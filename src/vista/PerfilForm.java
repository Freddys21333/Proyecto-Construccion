package vista;

import controlador.MensajeController;
import controlador.RespuestaController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.dto.MensajeDTO;
import modelo.dto.RespuestaDTO;
import util.SesionUsuario;
import util.RoundedButton;

/**
 *
 * @author Carlos.Rezabala
 */
public class PerfilForm extends javax.swing.JFrame {

    // Paleta de colores (minimalista, en linea con el resto de la app)
    private static final Color COLOR_PRIMARIO = new Color(0, 102, 102);
    private static final Color COLOR_PRIMARIO_SUAVE = new Color(224, 240, 240);
    private static final Color COLOR_FONDO = new Color(248, 249, 250);
    private static final Color COLOR_TARJETA = Color.WHITE;
    private static final Color COLOR_BORDE = new Color(228, 231, 233);
    private static final Color COLOR_TEXTO = new Color(51, 51, 51);
    private static final Color COLOR_TEXTO_SUAVE = new Color(130, 137, 140);
    private static final Color COLOR_FILA_ALTERNA = new Color(250, 251, 251);
    private static final Color COLOR_BADGE_VACIO = new Color(197, 202, 205);

    private final MensajeController mensajeController;
    private final RespuestaController respuestaController;
    private List<MensajeDTO> misMensajes;
    private final BadgeLabel badgeReutilizable = new BadgeLabel();

    /**
     * Creates new form PerfilForm
     */
    public PerfilForm() {
        initComponents();
        estilizarTablas();
        mensajeController = new MensajeController();
        respuestaController = new RespuestaController();
        cargarDatosUsuario();
        cargarMisPublicaciones();
    }

    private void cargarDatosUsuario() {
        if (SesionUsuario.usuarioActual != null) {
            lblBienvenida.setText("Publicaciones de " + SesionUsuario.usuarioActual.getNombre());
        }
    }

    private void cargarMisPublicaciones() {
        DefaultTableModel modelo = (DefaultTableModel) tblPublicaciones.getModel();
        modelo.setRowCount(0);

        if (SesionUsuario.usuarioActual == null) {
            misMensajes = new java.util.ArrayList<>();
            lblContador.setText("");
            return;
        }

        misMensajes = mensajeController.listarMensajesPorUsuario(SesionUsuario.usuarioActual.getIdUsuario());

        for (MensajeDTO mensaje : misMensajes) {
            int totalRespuestas = respuestaController.contarRespuestas(mensaje.getIdMensaje());

            modelo.addRow(new Object[]{
                mensaje.getTitulo(),
                mensaje.getNombreCategoria(),
                mensaje.getFechaPublicacion(),
                totalRespuestas
            });
        }

        lblContador.setText(misMensajes.size() == 1 ? "1 publicacion" : misMensajes.size() + " publicaciones");

        if (misMensajes.isEmpty()) {
            txtContenido.setText("Aun no tienes publicaciones. Anda al foro y comparte tu primer mensaje.");
        } else {
            txtContenido.setText("Selecciona una publicacion de la lista para ver su contenido y respuestas.");
        }

        limpiarRespuestas();
    }

    private MensajeDTO obtenerPublicacionSeleccionada() {
        int fila = tblPublicaciones.getSelectedRow();

        if (fila >= 0 && misMensajes != null && fila < misMensajes.size()) {
            return misMensajes.get(fila);
        }

        return null;
    }

    private void limpiarRespuestas() {
        DefaultTableModel modeloRespuestas = (DefaultTableModel) tblRespuestas.getModel();
        modeloRespuestas.setRowCount(0);
    }

    private void cargarRespuestas(int idMensaje) {
        DefaultTableModel modeloRespuestas = (DefaultTableModel) tblRespuestas.getModel();
        modeloRespuestas.setRowCount(0);

        List<RespuestaDTO> respuestas = respuestaController.listarRespuestas(idMensaje);

        for (RespuestaDTO respuesta : respuestas) {
            modeloRespuestas.addRow(new Object[]{
                respuesta.getNombreUsuario(),
                respuesta.getContenido(),
                respuesta.getFechaRespuesta()
            });
        }
    }

    // ---------------------------------------------------------------
    // Estilo: tablas limpias, filas alternadas, encabezado plano y
    // una "badge" redondeada para el numero de respuestas.
    // ---------------------------------------------------------------
    private void estilizarTablas() {
        estilizarTabla(tblPublicaciones);
        estilizarTabla(tblRespuestas);

        tblPublicaciones.getColumnModel().getColumn(0).setPreferredWidth(280);
        tblPublicaciones.getColumnModel().getColumn(1).setPreferredWidth(160);
        tblPublicaciones.getColumnModel().getColumn(2).setPreferredWidth(160);
        tblPublicaciones.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblPublicaciones.getColumnModel().getColumn(3).setCellRenderer(new BadgeRespuestasRenderer());

        tblRespuestas.getColumnModel().getColumn(0).setPreferredWidth(140);
        tblRespuestas.getColumnModel().getColumn(1).setPreferredWidth(420);
        tblRespuestas.getColumnModel().getColumn(2).setPreferredWidth(160);
    }

    private void estilizarTabla(JTable tabla) {
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.setForeground(COLOR_TEXTO);
        tabla.setRowHeight(34);
        tabla.setShowGrid(false);
        tabla.setIntercellSpacing(new Dimension(0, 0));
        tabla.setSelectionBackground(COLOR_PRIMARIO_SUAVE);
        tabla.setSelectionForeground(COLOR_TEXTO);
        tabla.setFillsViewportHeight(true);
        tabla.setFocusable(false);
        tabla.setRowSelectionAllowed(true);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(0, 36));
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setForeground(COLOR_TEXTO_SUAVE);
        header.setBackground(Color.WHITE);
        header.setReorderingAllowed(false);
        header.setDefaultRenderer(new EncabezadoRenderer());

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(new FilaRenderer());
        }
    }

    /**
     * Renderer plano para el encabezado: fondo blanco y una linea inferior
     * sutil, sin el relieve por defecto de Swing.
     */
    private class EncabezadoRenderer extends DefaultTableCellRenderer {
        EncabezadoRenderer() {
            setHorizontalAlignment(SwingConstants.LEFT);
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, false, false, row, column);
            setBackground(Color.WHITE);
            setForeground(COLOR_TEXTO_SUAVE);
            setFont(new Font("Segoe UI", Font.BOLD, 12));
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE),
                    BorderFactory.createEmptyBorder(0, 12, 0, 12)));
            return this;
        }
    }

    /**
     * Renderer de fila estandar: texto con padding y color alternado
     * para facilitar la lectura sin necesidad de lineas de grilla.
     */
    private class FilaRenderer extends DefaultTableCellRenderer {
        FilaRenderer() {
            setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, false, row, column);

            if (isSelected) {
                setBackground(COLOR_PRIMARIO_SUAVE);
            } else {
                setBackground(row % 2 == 0 ? COLOR_TARJETA : COLOR_FILA_ALTERNA);
            }
            setForeground(COLOR_TEXTO);
            setFont(new Font("Segoe UI", Font.PLAIN, 13));
            return this;
        }
    }

    /**
     * Renderer para la columna "Respuestas": dibuja una pildora
     * redondeada centrada, con color solido si hay respuestas o
     * en gris suave si la publicacion aun no tiene ninguna.
     */
    private class BadgeRespuestasRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            int total = 0;
            try {
                total = Integer.parseInt(String.valueOf(value));
            } catch (NumberFormatException ignored) {
            }

            badgeReutilizable.setText(String.valueOf(total));
            badgeReutilizable.setPildoraColor(total > 0 ? COLOR_PRIMARIO : COLOR_BADGE_VACIO);
            badgeReutilizable.setForeground(total > 0 ? Color.WHITE : Color.WHITE);
            badgeReutilizable.setFilaFondo(isSelected ? COLOR_PRIMARIO_SUAVE
                    : (row % 2 == 0 ? COLOR_TARJETA : COLOR_FILA_ALTERNA));

            return badgeReutilizable;
        }
    }

    /**
     * Etiqueta que se pinta a si misma como una pildora redondeada,
     * usada para mostrar el numero de respuestas de forma compacta.
     */
    private static class BadgeLabel extends JLabel {

        private Color pildoraColor = COLOR_PRIMARIO;
        private Color filaFondo = Color.WHITE;

        BadgeLabel() {
            setHorizontalAlignment(SwingConstants.CENTER);
            setFont(new Font("Segoe UI", Font.BOLD, 12));
            setOpaque(true);
        }

        void setPildoraColor(Color color) {
            this.pildoraColor = color;
        }

        void setFilaFondo(Color color) {
            this.filaFondo = color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(filaFondo);
            g2.fillRect(0, 0, getWidth(), getHeight());

            int alto = 22;
            int ancho = Math.max(30, getFontMetrics(getFont()).stringWidth(getText()) + 22);
            int x = (getWidth() - ancho) / 2;
            int y = (getHeight() - alto) / 2;

            g2.setColor(pildoraColor);
            g2.fillRoundRect(x, y, ancho, alto, alto, alto);
            g2.dispose();

            super.paintComponent(g);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnMenu = new RoundedButton();
        lblBienvenida = new javax.swing.JLabel();
        lblContador = new javax.swing.JLabel();
        lblSeccionPublicaciones = new javax.swing.JLabel();
        scrollPublicaciones = new javax.swing.JScrollPane();
        tblPublicaciones = new javax.swing.JTable();
        lblSeccionContenido = new javax.swing.JLabel();
        scrollContenido = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextArea();
        lblSeccionRespuestas = new javax.swing.JLabel();
        scrollRespuestas = new javax.swing.JScrollPane();
        tblRespuestas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mi perfil");
        setResizable(false);

        jPanel1.setBackground(COLOR_FONDO);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 680));
        jPanel1.setLayout(null);

        pnlHeader.setBackground(COLOR_PRIMARIO);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Mi perfil");

        btnMenu.setBackground(COLOR_PRIMARIO);
        btnMenu.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu principal");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(30, 30, 30))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTitulo)
                    .addComponent(btnMenu))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(pnlHeader);
        pnlHeader.setBounds(0, 0, 800, 64);

        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblBienvenida.setForeground(COLOR_TEXTO);
        lblBienvenida.setText("Mis publicaciones");

        jPanel1.add(lblBienvenida);
        lblBienvenida.setBounds(30, 88, 560, 26);

        lblContador.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblContador.setForeground(COLOR_TEXTO_SUAVE);
        lblContador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jPanel1.add(lblContador);
        lblContador.setBounds(590, 92, 180, 20);

        lblSeccionPublicaciones.setFont(new java.awt.Font("Segoe UI", 1, 11));
        lblSeccionPublicaciones.setForeground(COLOR_TEXTO_SUAVE);
        lblSeccionPublicaciones.setText("PUBLICACIONES");

        jPanel1.add(lblSeccionPublicaciones);
        lblSeccionPublicaciones.setBounds(30, 122, 300, 16);

        tblPublicaciones.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Titulo", "Categoria", "Fecha", "Respuestas"}
        ) {
            boolean[] canEdit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblPublicaciones.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tblPublicacionesValueChanged(evt);
            }
        });
        scrollPublicaciones.setViewportView(tblPublicaciones);
        scrollPublicaciones.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        scrollPublicaciones.getViewport().setBackground(Color.WHITE);

        jPanel1.add(scrollPublicaciones);
        scrollPublicaciones.setBounds(30, 142, 740, 186);

        lblSeccionContenido.setFont(new java.awt.Font("Segoe UI", 1, 11));
        lblSeccionContenido.setForeground(COLOR_TEXTO_SUAVE);
        lblSeccionContenido.setText("CONTENIDO");

        jPanel1.add(lblSeccionContenido);
        lblSeccionContenido.setBounds(30, 342, 300, 16);

        txtContenido.setEditable(false);
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);
        txtContenido.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtContenido.setForeground(COLOR_TEXTO);
        txtContenido.setBackground(Color.WHITE);
        txtContenido.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        scrollContenido.setViewportView(txtContenido);
        scrollContenido.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));

        jPanel1.add(scrollContenido);
        scrollContenido.setBounds(30, 362, 740, 88);

        lblSeccionRespuestas.setFont(new java.awt.Font("Segoe UI", 1, 11));
        lblSeccionRespuestas.setForeground(COLOR_TEXTO_SUAVE);
        lblSeccionRespuestas.setText("RESPUESTAS");

        jPanel1.add(lblSeccionRespuestas);
        lblSeccionRespuestas.setBounds(30, 464, 300, 16);

        tblRespuestas.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Autor", "Respuesta", "Fecha"}
        ) {
            boolean[] canEdit = new boolean [] {false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        scrollRespuestas.setViewportView(tblRespuestas);
        scrollRespuestas.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        scrollRespuestas.getViewport().setBackground(Color.WHITE);

        jPanel1.add(scrollRespuestas);
        scrollRespuestas.setBounds(30, 484, 740, 176);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuPrincipalForm menu = new MenuPrincipalForm();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void tblPublicacionesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tblPublicacionesValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }

        MensajeDTO seleccionado = obtenerPublicacionSeleccionada();

        if (seleccionado != null) {
            txtContenido.setText(seleccionado.getContenido());
            txtContenido.setCaretPosition(0);
            cargarRespuestas(seleccionado.getIdMensaje());
        } else {
            txtContenido.setText("");
            limpiarRespuestas();
        }
    }//GEN-LAST:event_tblPublicacionesValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblContador;
    private javax.swing.JLabel lblSeccionContenido;
    private javax.swing.JLabel lblSeccionPublicaciones;
    private javax.swing.JLabel lblSeccionRespuestas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JScrollPane scrollContenido;
    private javax.swing.JScrollPane scrollPublicaciones;
    private javax.swing.JScrollPane scrollRespuestas;
    private javax.swing.JTable tblPublicaciones;
    private javax.swing.JTable tblRespuestas;
    private javax.swing.JTextArea txtContenido;
    // End of variables declaration//GEN-END:variables
}

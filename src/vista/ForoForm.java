package vista;

import controlador.CategoriaController;
import controlador.MensajeController;
import controlador.RespuestaController;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import modelo.dto.CategoriaDTO;
import modelo.dto.MensajeDTO;
import modelo.dto.RespuestaDTO;
import util.SesionUsuario;
import util.UIStyle;
import util.RoundedButton;

public class ForoForm extends javax.swing.JFrame {

    private final CategoriaController categoriaController;
    private final MensajeController mensajeController;
    private final RespuestaController respuestaController;
    private List<MensajeDTO> mensajesActuales;

    public ForoForm() {
        initComponents();
        categoriaController = new CategoriaController();
        mensajeController = new MensajeController();
        respuestaController = new RespuestaController();
        cargarCategorias();
        cargarMensajes();
    }

    private void cargarCategorias() {
        cmbCategoria.removeAllItems();
        cmbCategoria.addItem(new CategoriaDTO(0, "Todas las categorias"));

        List<CategoriaDTO> categorias = categoriaController.obtenerCategorias();
        for (CategoriaDTO categoria : categorias) {
            cmbCategoria.addItem(categoria);
        }
    }

    private void cargarMensajes() {
        CategoriaDTO seleccionada = (CategoriaDTO) cmbCategoria.getSelectedItem();
        int idCategoria = (seleccionada == null) ? 0 : seleccionada.getIdCategoria();

        mensajesActuales = mensajeController.listarMensajesPorCategoria(idCategoria);

        DefaultTableModel modelo = (DefaultTableModel) tblMensajes.getModel();
        modelo.setRowCount(0);

        for (MensajeDTO mensaje : mensajesActuales) {
            modelo.addRow(new Object[]{
                mensaje.getTitulo(),
                mensaje.getNombreCategoria(),
                mensaje.getNombreUsuario(),
                mensaje.getFechaPublicacion()
            });
        }

        txtContenido.setText("");
        limpiarRespuestas();
    }

    private MensajeDTO obtenerMensajeSeleccionado() {
        int fila = tblMensajes.getSelectedRow();

        if (fila >= 0 && mensajesActuales != null && fila < mensajesActuales.size()) {
            return mensajesActuales.get(fila);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnMenu = new RoundedButton();
        pnlFiltro = new javax.swing.JPanel();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnFiltrar = new RoundedButton();
        btnPublicar = new RoundedButton();
        javax.swing.JLabel lblSeccionMensajes = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tblMensajes = new javax.swing.JTable();
        javax.swing.JLabel lblSeccionContenido = new javax.swing.JLabel();
        scrollContenido = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextArea();
        javax.swing.JLabel lblSeccionRespuestas = new javax.swing.JLabel();
        scrollRespuestas = new javax.swing.JScrollPane();
        tblRespuestas = new javax.swing.JTable();
        btnResponder = new RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Foro");
        setResizable(false);

        jPanel1.setBackground(UIStyle.FONDO);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 680));
        jPanel1.setLayout(null);

        pnlHeader.setBackground(UIStyle.PRIMARIO);
        pnlHeader.setLayout(null);

        lblTitulo.setFont(UIStyle.FUENTE_SUBTITULO_HEADER);
        lblTitulo.setForeground(java.awt.Color.WHITE);
        lblTitulo.setText("Foro de mensajes");
        pnlHeader.add(lblTitulo);
        lblTitulo.setBounds(30, 0, 400, 64);

        btnMenu.setText("Menu principal");
        UIStyle.botonHeader(btnMenu);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        pnlHeader.add(btnMenu);
        btnMenu.setBounds(650, 16, 120, 32);

        jPanel1.add(pnlHeader);
        pnlHeader.setBounds(0, 0, 800, 64);

        pnlFiltro.setBackground(UIStyle.TARJETA);
        pnlFiltro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, UIStyle.BORDE));
        pnlFiltro.setLayout(null);

        lblCategoria.setText("Categoria");
        UIStyle.etiquetaCampo(lblCategoria);
        pnlFiltro.add(lblCategoria);
        lblCategoria.setBounds(20, 20, 90, 18);

        UIStyle.estiloComboBox(cmbCategoria);
        pnlFiltro.add(cmbCategoria);
        cmbCategoria.setBounds(110, 15, 250, 32);

        btnFiltrar.setText("Filtrar");
        UIStyle.botonPrimario(btnFiltrar);
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        pnlFiltro.add(btnFiltrar);
        btnFiltrar.setBounds(372, 15, 100, 32);

        btnPublicar.setText("Publicar mensaje");
        UIStyle.botonAcento(btnPublicar);
        btnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarActionPerformed(evt);
            }
        });
        pnlFiltro.add(btnPublicar);
        btnPublicar.setBounds(610, 15, 170, 32);

        jPanel1.add(pnlFiltro);
        pnlFiltro.setBounds(0, 64, 800, 62);

        lblSeccionMensajes.setText("MENSAJES");
        UIStyle.etiquetaSeccion(lblSeccionMensajes);
        jPanel1.add(lblSeccionMensajes);
        lblSeccionMensajes.setBounds(20, 142, 300, 16);

        tblMensajes.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Titulo", "Categoria", "Autor", "Fecha"}
        ) {
            boolean[] canEdit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        UIStyle.estilizarTabla(tblMensajes);
        tblMensajes.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tblMensajesValueChanged(evt);
            }
        });
        scrollTabla.setViewportView(tblMensajes);
        scrollTabla.setBorder(javax.swing.BorderFactory.createLineBorder(UIStyle.BORDE, 1, true));
        scrollTabla.getViewport().setBackground(UIStyle.TARJETA);

        jPanel1.add(scrollTabla);
        scrollTabla.setBounds(20, 162, 760, 168);

        lblSeccionContenido.setText("CONTENIDO DEL MENSAJE");
        UIStyle.etiquetaSeccion(lblSeccionContenido);
        jPanel1.add(lblSeccionContenido);
        lblSeccionContenido.setBounds(20, 346, 300, 16);

        txtContenido.setEditable(false);
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);
        txtContenido.setFont(UIStyle.FUENTE_TEXTO);
        txtContenido.setForeground(UIStyle.TEXTO);
        txtContenido.setBackground(UIStyle.TARJETA);
        txtContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12));
        scrollContenido.setViewportView(txtContenido);
        scrollContenido.setBorder(javax.swing.BorderFactory.createLineBorder(UIStyle.BORDE, 1, true));

        jPanel1.add(scrollContenido);
        scrollContenido.setBounds(20, 366, 760, 88);

        lblSeccionRespuestas.setText("RESPUESTAS");
        UIStyle.etiquetaSeccion(lblSeccionRespuestas);
        jPanel1.add(lblSeccionRespuestas);
        lblSeccionRespuestas.setBounds(20, 470, 300, 16);

        tblRespuestas.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Autor", "Respuesta", "Fecha"}
        ) {
            boolean[] canEdit = new boolean [] {false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        UIStyle.estilizarTabla(tblRespuestas);
        scrollRespuestas.setViewportView(tblRespuestas);
        scrollRespuestas.setBorder(javax.swing.BorderFactory.createLineBorder(UIStyle.BORDE, 1, true));
        scrollRespuestas.getViewport().setBackground(UIStyle.TARJETA);

        jPanel1.add(scrollRespuestas);
        scrollRespuestas.setBounds(20, 490, 760, 132);

        btnResponder.setText("Responder mensaje");
        UIStyle.botonPrimario(btnResponder);
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        jPanel1.add(btnResponder);
        btnResponder.setBounds(20, 634, 210, 40);

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

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        cargarMensajes();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarActionPerformed
        if (SesionUsuario.usuarioActual == null) {
            JOptionPane.showMessageDialog(this, "Debe iniciar sesion para publicar un mensaje.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PublicarMensajeForm publicar = new PublicarMensajeForm();
        publicar.setVisible(true);
        publicar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnPublicarActionPerformed

    private void tblMensajesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tblMensajesValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }

        MensajeDTO seleccionado = obtenerMensajeSeleccionado();

        if (seleccionado != null) {
            txtContenido.setText(seleccionado.getContenido());
            txtContenido.setCaretPosition(0);
            cargarRespuestas(seleccionado.getIdMensaje());
        } else {
            txtContenido.setText("");
            limpiarRespuestas();
        }
    }//GEN-LAST:event_tblMensajesValueChanged

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        MensajeDTO seleccionado = obtenerMensajeSeleccionado();

        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un mensaje del listado para responder.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (SesionUsuario.usuarioActual == null) {
            JOptionPane.showMessageDialog(this, "Debe iniciar sesion para responder un mensaje.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JTextArea txtRespuesta = new JTextArea(5, 30);
        txtRespuesta.setLineWrap(true);
        txtRespuesta.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(txtRespuesta);

        javax.swing.JPanel panelDialogo = new javax.swing.JPanel(new BorderLayout(5, 5));
        panelDialogo.add(new javax.swing.JLabel("Respuesta a: " + seleccionado.getTitulo()), BorderLayout.NORTH);
        panelDialogo.add(scroll, BorderLayout.CENTER);

        int opcion = JOptionPane.showConfirmDialog(this, panelDialogo, "Responder mensaje",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            String resultado = respuestaController.responderMensaje(
                    seleccionado.getIdMensaje(),
                    txtRespuesta.getText()
            );

            if (resultado.equals("OK")) {
                cargarRespuestas(seleccionado.getIdMensaje());
            } else {
                JOptionPane.showMessageDialog(this, resultado, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnResponderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForoForm.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnResponder;
    private javax.swing.JComboBox<CategoriaDTO> cmbCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JScrollPane scrollContenido;
    private javax.swing.JScrollPane scrollRespuestas;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblMensajes;
    private javax.swing.JTable tblRespuestas;
    private javax.swing.JTextArea txtContenido;
    // End of variables declaration//GEN-END:variables
}

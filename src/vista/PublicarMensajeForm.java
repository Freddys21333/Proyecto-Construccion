package vista;

import controlador.CategoriaController;
import controlador.MensajeController;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.dto.CategoriaDTO;
import util.UIStyle;
import util.RoundedButton;

public class PublicarMensajeForm extends javax.swing.JFrame {

    private final CategoriaController categoriaController;
    private final MensajeController mensajeController;

    public PublicarMensajeForm() {
        initComponents();
        categoriaController = new CategoriaController();
        mensajeController = new MensajeController();
        cargarCategorias();
    }

    private void cargarCategorias() {
        cmbCategoria.removeAllItems();

        List<CategoriaDTO> categorias = categoriaController.obtenerCategorias();
        for (CategoriaDTO categoria : categorias) {
            cmbCategoria.addItem(categoria);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new RoundedButton();
        pnlBody = new javax.swing.JPanel();
        javax.swing.JPanel pnlCard = new javax.swing.JPanel();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblTituloMensaje = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblContenido = new javax.swing.JLabel();
        scrollContenido = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextArea();
        btnPublicar = new RoundedButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Publicar mensaje");
        setResizable(false);

        jPanel1.setBackground(UIStyle.FONDO);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        pnlHeader.setBackground(UIStyle.PRIMARIO);
        pnlHeader.setLayout(null);

        lblTitulo.setFont(UIStyle.FUENTE_SUBTITULO_HEADER);
        lblTitulo.setForeground(java.awt.Color.WHITE);
        lblTitulo.setText("Publicar mensaje");
        pnlHeader.add(lblTitulo);
        lblTitulo.setBounds(30, 0, 400, 64);

        btnVolver.setText("Volver al foro");
        UIStyle.botonHeader(btnVolver);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pnlHeader.add(btnVolver);
        btnVolver.setBounds(650, 16, 120, 32);

        jPanel1.add(pnlHeader);
        pnlHeader.setBounds(0, 0, 800, 64);

        pnlBody.setBackground(UIStyle.FONDO);
        pnlBody.setLayout(null);

        pnlCard.setBackground(UIStyle.TARJETA);
        pnlCard.setBorder(javax.swing.BorderFactory.createLineBorder(UIStyle.BORDE, 1, true));
        pnlCard.setLayout(null);

        lblCategoria.setText("Categoria");
        UIStyle.etiquetaCampo(lblCategoria);
        pnlCard.add(lblCategoria);
        lblCategoria.setBounds(36, 28, 300, 18);

        UIStyle.estiloComboBox(cmbCategoria);
        pnlCard.add(cmbCategoria);
        cmbCategoria.setBounds(36, 48, 300, 36);

        lblTituloMensaje.setText("Titulo");
        UIStyle.etiquetaCampo(lblTituloMensaje);
        pnlCard.add(lblTituloMensaje);
        lblTituloMensaje.setBounds(36, 100, 660, 18);

        UIStyle.estiloCampo(txtTitulo);
        pnlCard.add(txtTitulo);
        txtTitulo.setBounds(36, 120, 660, 40);

        lblContenido.setText("Contenido");
        UIStyle.etiquetaCampo(lblContenido);
        pnlCard.add(lblContenido);
        lblContenido.setBounds(36, 176, 660, 18);

        txtContenido.setFont(UIStyle.FUENTE_INPUT);
        txtContenido.setForeground(UIStyle.TEXTO);
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);
        txtContenido.setRows(8);
        txtContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12));
        scrollContenido.setViewportView(txtContenido);
        scrollContenido.setBorder(javax.swing.BorderFactory.createLineBorder(UIStyle.BORDE, 1, true));
        pnlCard.add(scrollContenido);
        scrollContenido.setBounds(36, 196, 660, 180);

        btnPublicar.setText("Publicar");
        UIStyle.botonPrimario(btnPublicar);
        btnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarActionPerformed(evt);
            }
        });
        pnlCard.add(btnPublicar);
        btnPublicar.setBounds(36, 396, 160, 44);

        UIStyle.botonTexto(btnCancelar, UIStyle.TEXTO_SUAVE);
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlCard.add(btnCancelar);
        btnCancelar.setBounds(206, 396, 120, 44);

        pnlBody.add(pnlCard);
        pnlCard.setBounds(68, 30, 664, 460);

        jPanel1.add(pnlBody);
        pnlBody.setBounds(0, 64, 800, 536);

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

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ForoForm foro = new ForoForm();
        foro.setVisible(true);
        foro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarActionPerformed
        CategoriaDTO categoria = (CategoriaDTO) cmbCategoria.getSelectedItem();
        int idCategoria = (categoria == null) ? 0 : categoria.getIdCategoria();

        String resultado = mensajeController.publicarMensaje(
                txtTitulo.getText(),
                txtContenido.getText(),
                idCategoria
        );

        if (resultado.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Mensaje publicado correctamente.");

            ForoForm foro = new ForoForm();
            foro.setVisible(true);
            foro.setLocationRelativeTo(null);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPublicarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ForoForm foro = new ForoForm();
        foro.setVisible(true);
        foro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(PublicarMensajeForm.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PublicarMensajeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<CategoriaDTO> cmbCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblContenido;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloMensaje;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JScrollPane scrollContenido;
    private javax.swing.JTextArea txtContenido;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}

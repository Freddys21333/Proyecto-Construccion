package vista;

import controlador.UsuarioController;
import util.SesionUsuario;
import util.UIStyle;
import util.RoundedButton;

public class MenuPrincipalForm extends javax.swing.JFrame {

    public MenuPrincipalForm() {
        initComponents();
        cargarDatosUsuario();
    }

    private void cargarDatosUsuario() {
        if (SesionUsuario.usuarioActual != null) {
            lblBienvenida.setText("Bienvenido, " + SesionUsuario.usuarioActual.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCerrarSesion = new RoundedButton();
        pnlBody = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        javax.swing.JLabel lblSubtitulo = new javax.swing.JLabel();
        btnVerForo = new RoundedButton();
        btnPublicarMensaje = new RoundedButton();
        btnMiPerfil = new RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");
        setResizable(false);

        jPanel1.setBackground(UIStyle.FONDO);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        pnlHeader.setBackground(UIStyle.PRIMARIO);
        pnlHeader.setLayout(null);

        lblTitulo.setFont(UIStyle.FUENTE_SUBTITULO_HEADER);
        lblTitulo.setForeground(java.awt.Color.WHITE);
        lblTitulo.setText("Foro de soporte tecnico estudiantil");
        pnlHeader.add(lblTitulo);
        lblTitulo.setBounds(30, 0, 460, 64);

        btnCerrarSesion.setText("Cerrar sesion");
        UIStyle.botonHeader(btnCerrarSesion);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        pnlHeader.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(650, 16, 120, 32);

        jPanel1.add(pnlHeader);
        pnlHeader.setBounds(0, 0, 800, 64);

        pnlBody.setBackground(UIStyle.FONDO);
        pnlBody.setLayout(null);

        lblBienvenida.setFont(UIStyle.FUENTE_TITULO);
        lblBienvenida.setForeground(UIStyle.TEXTO);
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setText("Bienvenido");
        pnlBody.add(lblBienvenida);
        lblBienvenida.setBounds(150, 56, 500, 40);

        lblSubtitulo.setFont(UIStyle.FUENTE_TEXTO);
        lblSubtitulo.setForeground(UIStyle.TEXTO_SUAVE);
        lblSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtitulo.setText("Elige una opcion para continuar");
        pnlBody.add(lblSubtitulo);
        lblSubtitulo.setBounds(150, 98, 500, 22);

        btnVerForo.setText("Ver Foro");
        UIStyle.botonPrimario(btnVerForo);
        btnVerForo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerForoActionPerformed(evt);
            }
        });
        pnlBody.add(btnVerForo);
        btnVerForo.setBounds(270, 170, 260, 52);

        btnPublicarMensaje.setText("Publicar Mensaje");
        UIStyle.botonPrimario(btnPublicarMensaje);
        btnPublicarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarMensajeActionPerformed(evt);
            }
        });
        pnlBody.add(btnPublicarMensaje);
        btnPublicarMensaje.setBounds(270, 236, 260, 52);

        btnMiPerfil.setText("Mi Perfil");
        UIStyle.botonPrimario(btnMiPerfil);
        btnMiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiPerfilActionPerformed(evt);
            }
        });
        pnlBody.add(btnMiPerfil);
        btnMiPerfil.setBounds(270, 302, 260, 52);

        jPanel1.add(pnlBody);
        pnlBody.setBounds(0, 64, 800, 436);

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

    private void btnVerForoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerForoActionPerformed
        ForoForm foro = new ForoForm();
        foro.setVisible(true);
        foro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVerForoActionPerformed

    private void btnPublicarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarMensajeActionPerformed
        PublicarMensajeForm publicar = new PublicarMensajeForm();
        publicar.setVisible(true);
        publicar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnPublicarMensajeActionPerformed

    private void btnMiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiPerfilActionPerformed
        PerfilForm perfil = new PerfilForm();
        perfil.setVisible(true);
        perfil.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnMiPerfilActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        UsuarioController controller = new UsuarioController();
        controller.cerrarSesion();

        LoginForm login = new LoginForm();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalForm.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnMiPerfil;
    private javax.swing.JButton btnPublicarMensaje;
    private javax.swing.JButton btnVerForo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables
}

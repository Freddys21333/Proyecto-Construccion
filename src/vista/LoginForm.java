package vista;

import controlador.UsuarioController;
import util.SesionUsuario;
import util.UIStyle;
import util.RoundedButton;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        lblLavanderia = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        javax.swing.JPanel pnlCard = new javax.swing.JPanel();
        lblInicioSesion = new javax.swing.JLabel();
        javax.swing.JLabel lblSubtitulo = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        LoginBtn = new RoundedButton();
        lblRegistrar = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesion");
        setResizable(false);

        jPanel1.setBackground(UIStyle.FONDO);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 540));
        jPanel1.setLayout(null);

        Right.setBackground(UIStyle.PRIMARIO);
        Right.setLayout(null);

        lblLavanderia.setFont(UIStyle.FUENTE_SUBTITULO_HEADER);
        lblLavanderia.setForeground(java.awt.Color.WHITE);
        lblLavanderia.setText("Foro de Soporte Tecnico Estudiantil");
        Right.add(lblLavanderia);
        lblLavanderia.setBounds(30, 0, 460, 64);

        jPanel1.add(Right);
        Right.setBounds(0, 0, 800, 64);

        Left.setBackground(UIStyle.FONDO);
        Left.setLayout(null);

        pnlCard.setBackground(UIStyle.TARJETA);
        pnlCard.setBorder(javax.swing.BorderFactory.createLineBorder(UIStyle.BORDE, 1, true));
        pnlCard.setLayout(null);

        lblInicioSesion.setFont(UIStyle.FUENTE_TITULO);
        lblInicioSesion.setForeground(UIStyle.TEXTO);
        lblInicioSesion.setText("Iniciar sesion");
        pnlCard.add(lblInicioSesion);
        lblInicioSesion.setBounds(40, 28, 340, 36);

        lblSubtitulo.setFont(UIStyle.FUENTE_TEXTO);
        lblSubtitulo.setForeground(UIStyle.TEXTO_SUAVE);
        lblSubtitulo.setText("Ingresa tus datos para continuar");
        pnlCard.add(lblSubtitulo);
        lblSubtitulo.setBounds(40, 64, 340, 20);

        lblEmail.setText("Email");
        UIStyle.etiquetaCampo(lblEmail);
        pnlCard.add(lblEmail);
        lblEmail.setBounds(40, 104, 340, 18);

        UIStyle.estiloCampo(txtEmail);
        pnlCard.add(txtEmail);
        txtEmail.setBounds(40, 124, 340, 40);

        lblContrasena.setText("Contrasena");
        UIStyle.etiquetaCampo(lblContrasena);
        pnlCard.add(lblContrasena);
        lblContrasena.setBounds(40, 180, 340, 18);

        txtContrasena.setEchoChar('•');
        UIStyle.estiloCampo(txtContrasena);
        pnlCard.add(txtContrasena);
        txtContrasena.setBounds(40, 200, 340, 40);

        LoginBtn.setText("Iniciar sesion");
        UIStyle.botonPrimario((RoundedButton) LoginBtn);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        pnlCard.add(LoginBtn);
        LoginBtn.setBounds(40, 260, 340, 44);

        lblRegistrar.setFont(UIStyle.FUENTE_TEXTO);
        lblRegistrar.setForeground(UIStyle.TEXTO_SUAVE);
        lblRegistrar.setText("No tienes cuenta?");
        lblRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlCard.add(lblRegistrar);
        lblRegistrar.setBounds(40, 322, 160, 24);

        UIStyle.botonTexto(btnRegistrar, UIStyle.PRIMARIO);
        btnRegistrar.setText("Registrarme");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlCard.add(btnRegistrar);
        btnRegistrar.setBounds(200, 322, 180, 24);

        Left.add(pnlCard);
        pnlCard.setBounds(190, 40, 420, 390);

        jPanel1.add(Left);
        Left.setBounds(0, 64, 800, 476);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        RegistroForm Registro = new RegistroForm();
        Registro.setVisible(true);
        Registro.pack();
        Registro.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
         UsuarioController controller = new UsuarioController();

        String resultado = controller.iniciarSesion(
            txtEmail.getText(),
            new String(txtContrasena.getPassword())
        );

        if (resultado.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + SesionUsuario.usuarioActual.getNombre());

            MenuPrincipalForm menu = new MenuPrincipalForm();
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPanel Right;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInicioSesion;
    private javax.swing.JLabel lblLavanderia;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}

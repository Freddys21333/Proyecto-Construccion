package vista;

import controlador.UsuarioController;
import util.SesionUsuario;
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
        lblInicioSesion = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        LoginBtn = new javax.swing.JButton();
        lblRegistrar = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIAR SESION");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        lblLavanderia.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblLavanderia.setForeground(new java.awt.Color(255, 255, 255));
        lblLavanderia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLavanderia.setText("Lavanderia virtual");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap(532, Short.MAX_VALUE)
                .addComponent(lblLavanderia)
                .addContainerGap())
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(lblLavanderia)
                .addContainerGap())
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 800, 60);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setMinimumSize(new java.awt.Dimension(400, 500));

        lblInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblInicioSesion.setForeground(new java.awt.Color(0, 102, 102));
        lblInicioSesion.setText("Iniciar sesion");

        lblEmail.setBackground(new java.awt.Color(102, 102, 102));
        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));

        lblContrasena.setBackground(new java.awt.Color(102, 102, 102));
        lblContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblContrasena.setText("Contraseña");

        LoginBtn.setBackground(new java.awt.Color(0, 102, 102));
        LoginBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Iniciar sesion");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        lblRegistrar.setText("¿No tienes cuenta?");

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 204, 204));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(lblInicioSesion))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail)
                            .addComponent(lblContrasena)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(lblRegistrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar)))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblInicioSesion)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistrar)
                    .addComponent(btnRegistrar))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 60, 800, 440);

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

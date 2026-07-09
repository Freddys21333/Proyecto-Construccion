package vista;

import java.awt.Color;
import javax.swing.JOptionPane;
import controlador.UsuarioController;
import util.UIStyle;
import util.RoundedButton;

public class RegistroForm extends javax.swing.JFrame {

    public RegistroForm() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLavanderia = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        javax.swing.JPanel pnlCard = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel lblSubtitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txtConfContra = new javax.swing.JTextField();
        SignUpBtn = new RoundedButton();
        jLabel8 = new javax.swing.JLabel();
        btnInicioSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");
        setResizable(false);

        jPanel1.setBackground(UIStyle.FONDO);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 620));
        jPanel1.setLayout(null);

        jPanel2.setBackground(UIStyle.PRIMARIO);
        jPanel2.setLayout(null);

        lblLavanderia.setFont(UIStyle.FUENTE_SUBTITULO_HEADER);
        lblLavanderia.setForeground(Color.WHITE);
        lblLavanderia.setText("Foro de Soporte Tecnico Estudiantil");
        jPanel2.add(lblLavanderia);
        lblLavanderia.setBounds(30, 0, 460, 64);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 800, 64);

        jPanel3.setBackground(UIStyle.FONDO);
        jPanel3.setLayout(null);

        pnlCard.setBackground(UIStyle.TARJETA);
        pnlCard.setBorder(javax.swing.BorderFactory.createLineBorder(UIStyle.BORDE, 1, true));
        pnlCard.setLayout(null);

        jLabel4.setFont(UIStyle.FUENTE_TITULO);
        jLabel4.setForeground(UIStyle.TEXTO);
        jLabel4.setText("Crear cuenta");
        pnlCard.add(jLabel4);
        jLabel4.setBounds(40, 28, 440, 36);

        lblSubtitulo.setFont(UIStyle.FUENTE_TEXTO);
        lblSubtitulo.setForeground(UIStyle.TEXTO_SUAVE);
        lblSubtitulo.setText("Completa tus datos para unirte al foro");
        pnlCard.add(lblSubtitulo);
        lblSubtitulo.setBounds(40, 64, 440, 20);

        jLabel5.setText("Nombre y Apellidos");
        UIStyle.etiquetaCampo(jLabel5);
        pnlCard.add(jLabel5);
        jLabel5.setBounds(40, 104, 440, 18);

        UIStyle.estiloCampo(txtNombreCliente);
        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });
        pnlCard.add(txtNombreCliente);
        txtNombreCliente.setBounds(40, 124, 440, 40);

        jLabel6.setText("Email");
        UIStyle.etiquetaCampo(jLabel6);
        pnlCard.add(jLabel6);
        jLabel6.setBounds(40, 180, 440, 18);

        UIStyle.estiloCampo(txtCorreo);
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        pnlCard.add(txtCorreo);
        txtCorreo.setBounds(40, 200, 440, 40);

        jLabel7.setText("Contrasena");
        UIStyle.etiquetaCampo(jLabel7);
        pnlCard.add(jLabel7);
        jLabel7.setBounds(40, 256, 210, 18);

        pass.setEchoChar('•');
        UIStyle.estiloCampo(pass);
        pnlCard.add(pass);
        pass.setBounds(40, 276, 210, 40);

        jLabel10.setText("Confirmar contrasena");
        UIStyle.etiquetaCampo(jLabel10);
        pnlCard.add(jLabel10);
        jLabel10.setBounds(270, 256, 210, 18);

        UIStyle.estiloCampo(txtConfContra);
        txtConfContra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfContraFocusLost(evt);
            }
        });
        pnlCard.add(txtConfContra);
        txtConfContra.setBounds(270, 276, 210, 40);

        SignUpBtn.setText("Registrar");
        UIStyle.botonPrimario((RoundedButton) SignUpBtn);
        SignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBtnActionPerformed(evt);
            }
        });
        pnlCard.add(SignUpBtn);
        SignUpBtn.setBounds(40, 336, 440, 44);

        jLabel8.setFont(UIStyle.FUENTE_TEXTO);
        jLabel8.setForeground(UIStyle.TEXTO_SUAVE);
        jLabel8.setText("Ya tienes cuenta?");
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlCard.add(jLabel8);
        jLabel8.setBounds(40, 398, 200, 24);

        UIStyle.botonTexto(btnInicioSesion, UIStyle.PRIMARIO);
        btnInicioSesion.setText("Iniciar sesion");
        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });
        pnlCard.add(btnInicioSesion);
        btnInicioSesion.setBounds(280, 398, 200, 24);

        jPanel3.add(pnlCard);
        pnlCard.setBounds(180, 40, 520, 460);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 64, 800, 556);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed
        // Abre la ventana de inicio de sesión
        LoginForm login = new LoginForm();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        // Cierra la ventana actual de registro.
        this.dispose();
    }//GEN-LAST:event_btnInicioSesionActionPerformed

    private void SignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBtnActionPerformed
        // Se crea el controlador encargado de procesar el registro del usuario.
        UsuarioController controller = new UsuarioController();
        // Se envían al controlador los datos ingresados en el formulario.
        String resultado = controller.registrarUsuario(
            txtNombreCliente.getText(),
            txtCorreo.getText(),
            new String(pass.getPassword()),
            txtConfContra.getText()
        );
        // Si el registro fue correcto, se muestra un mensaje y se vuelve al login.
        if (resultado.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");

            LoginForm login = new LoginForm();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            // Cierra la ventana de registro.
            this.dispose();

        } else {
            // Muestra el error devuelto por el controlador.
            JOptionPane.showMessageDialog(this, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_SignUpBtnActionPerformed

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        // Permite escribir solo letras y espacios en el campo de nombre.
        Character car = evt.getKeyChar();
        boolean valido = true;
        if (!Character.isLetter(car) && car != ' ') {
            valido = false;
        }
        // Limita la cantidad de caracteres del nombre.
        if (txtNombreCliente.getText().length() > 30) {
            valido = false;
        }
        // Si el carácter no es válido, se bloquea su ingreso.
        if (!valido) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        // Valida visualmente el formato del correo cuando el usuario sale del campo.
        String correo = txtCorreo.getText().trim();

        if (correo.isEmpty()) {
            // Si está vacío, se restaura el borde normal.
            txtCorreo.setBorder(UIStyle.bordeCampo());

        } else if (correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            // Si el formato es correcto, se aplica un borde de éxito.
            txtCorreo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createLineBorder(UIStyle.EXITO_BORDE, 1, true),
                    javax.swing.BorderFactory.createEmptyBorder(6, 10, 6, 10)));

        } else {
            // Si el formato no es válido, se aplica un borde de error.
            txtCorreo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createLineBorder(UIStyle.ERROR_BORDE, 1, true),
                    javax.swing.BorderFactory.createEmptyBorder(6, 10, 6, 10)));
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtConfContraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfContraFocusLost
        // Verifica visualmente si la confirmación coincide con la contraseña ingresada.
        String password = new String(pass.getPassword());
        String confirmPassword = txtConfContra.getText();

        if (confirmPassword.isEmpty()) {
            // Si está vacío, se restaura el borde normal.
            txtConfContra.setBorder(UIStyle.bordeCampo());

        } else if (confirmPassword.equals(password)) {
            // Si las contraseñas coinciden, se aplica un borde de éxito.
            txtConfContra.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createLineBorder(UIStyle.EXITO_BORDE, 1, true),
                    javax.swing.BorderFactory.createEmptyBorder(6, 10, 6, 10)));

        } else {
            // Si las contraseñas no coinciden, se aplica un borde de error.
            txtConfContra.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createLineBorder(UIStyle.ERROR_BORDE, 1, true),
                    javax.swing.BorderFactory.createEmptyBorder(6, 10, 6, 10)));
        }
    }//GEN-LAST:event_txtConfContraFocusLost

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblLavanderia;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField txtConfContra;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}

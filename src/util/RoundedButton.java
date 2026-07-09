package util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Boton plano con esquinas redondeadas, pensado para mantener un
 * lenguaje visual minimalista y consistente en toda la aplicacion.
 * Calcula automaticamente un tono ligeramente mas oscuro para el
 * estado "hover" a partir del color de fondo asignado con
 * setBackground(...).
 */
public class RoundedButton extends JButton {

    private int arco = 10;
    private boolean sobreBoton = false;

    public RoundedButton() {
        this("");
    }

    public RoundedButton(String texto) {
        super(texto);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sobreBoton = isEnabled();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sobreBoton = false;
                repaint();
            }
        });
    }

    public void setArco(int arco) {
        this.arco = arco;
    }

    private Color tonoHover(Color base) {
        int r = Math.max(0, base.getRed() - 18);
        int g = Math.max(0, base.getGreen() - 18);
        int b = Math.max(0, base.getBlue() - 18);
        return new Color(r, g, b);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color base = getBackground();

        if (!isEnabled()) {
            g2.setColor(new Color(200, 203, 205));
        } else if (sobreBoton) {
            g2.setColor(tonoHover(base));
        } else {
            g2.setColor(base);
        }

        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arco, arco);
        g2.dispose();

        super.paintComponent(g);
    }
}

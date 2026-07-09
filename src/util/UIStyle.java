package util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

/**
 * Paleta de colores, tipografias y helpers de estilo compartidos por
 * todas las pantallas de la aplicacion. Centralizar estos valores
 * asegura consistencia visual (mismo acento, mismos grises, mismos
 * tamaños de fuente) y facilita ajustar el diseño en un solo lugar.
 */
public final class UIStyle {

    private UIStyle() {
    }

    // ---- Paleta ----------------------------------------------------
    public static final Color PRIMARIO = new Color(0, 102, 102);
    public static final Color PRIMARIO_SUAVE = new Color(224, 240, 240);
    public static final Color ACENTO = new Color(0, 176, 176);
    public static final Color FONDO = new Color(248, 249, 250);
    public static final Color TARJETA = Color.WHITE;
    public static final Color BORDE = new Color(226, 229, 231);
    public static final Color BORDE_FOCO = PRIMARIO;
    public static final Color TEXTO = new Color(45, 51, 54);
    public static final Color TEXTO_SUAVE = new Color(130, 137, 140);
    public static final Color FILA_ALTERNA = new Color(250, 251, 251);
    public static final Color EXITO_FONDO = new Color(224, 247, 235);
    public static final Color EXITO_BORDE = new Color(97, 187, 141);
    public static final Color ERROR_FONDO = new Color(253, 228, 228);
    public static final Color ERROR_BORDE = new Color(214, 116, 116);

    // ---- Tipografia --------------------------------------------------
    public static final String FAMILIA = "Segoe UI";
    public static final Font FUENTE_TITULO = new Font(FAMILIA, Font.BOLD, 30);
    public static final Font FUENTE_SUBTITULO_HEADER = new Font(FAMILIA, Font.BOLD, 19);
    public static final Font FUENTE_LABEL = new Font(FAMILIA, Font.PLAIN, 13);
    public static final Font FUENTE_INPUT = new Font(FAMILIA, Font.PLAIN, 14);
    public static final Font FUENTE_BOTON = new Font(FAMILIA, Font.BOLD, 14);
    public static final Font FUENTE_BOTON_HEADER = new Font(FAMILIA, Font.PLAIN, 13);
    public static final Font FUENTE_TEXTO = new Font(FAMILIA, Font.PLAIN, 13);
    public static final Font FUENTE_SECCION = new Font(FAMILIA, Font.BOLD, 11);

    // ---- Botones -----------------------------------------------------

    /** Boton principal: relleno solido en el color de marca. */
    public static void botonPrimario(JButton boton) {
        boton.setBackground(PRIMARIO);
        boton.setForeground(Color.WHITE);
        boton.setFont(FUENTE_BOTON);
        if (boton instanceof RoundedButton) {
            ((RoundedButton) boton).setArco(10);
        }
    }

    /** Boton de acento, para acciones secundarias que igual destacan. */
    public static void botonAcento(JButton boton) {
        boton.setBackground(ACENTO);
        boton.setForeground(Color.WHITE);
        boton.setFont(FUENTE_BOTON);
        if (boton instanceof RoundedButton) {
            ((RoundedButton) boton).setArco(10);
        }
    }

    /** Boton plano para la barra de cabecera (mismo color que el fondo). */
    public static void botonHeader(JButton boton) {
        boton.setBackground(PRIMARIO);
        boton.setForeground(Color.WHITE);
        boton.setFont(FUENTE_BOTON_HEADER);
        if (boton instanceof RoundedButton) {
            ((RoundedButton) boton).setArco(8);
        }
    }

    /** Boton de texto, sin relleno, usado para acciones secundarias tipo enlace. */
    public static void botonTexto(JButton boton, Color colorTexto) {
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setOpaque(false);
        boton.setForeground(colorTexto);
        boton.setFont(FUENTE_BOTON);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // ---- Campos de texto ----------------------------------------------

    /** Borde plano con relleno interno, sin el relieve por defecto de Swing. */
    public static Border bordeCampo() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE, 1, true),
                BorderFactory.createEmptyBorder(6, 10, 6, 10));
    }

    private static Border bordeCampoFoco() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE_FOCO, 1, true),
                BorderFactory.createEmptyBorder(6, 10, 6, 10));
    }

    /**
     * Aplica tipografia, color de texto y un borde plano con padding a un
     * campo de texto (JTextField o JPasswordField), y resalta el borde
     * suavemente cuando el campo recibe el foco.
     */
    public static void estiloCampo(JTextComponent campo) {
        campo.setFont(FUENTE_INPUT);
        campo.setForeground(TEXTO);
        campo.setBackground(TARJETA);
        campo.setBorder(bordeCampo());
        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                campo.setBorder(bordeCampoFoco());
            }

            @Override
            public void focusLost(FocusEvent e) {
                campo.setBorder(bordeCampo());
            }
        });
    }

    public static void estiloComboBox(JComboBox<?> combo) {
        combo.setFont(FUENTE_INPUT);
        combo.setBackground(TARJETA);
        combo.setForeground(TEXTO);
        combo.setBorder(BorderFactory.createLineBorder(BORDE, 1, true));
    }

    // ---- Tablas --------------------------------------------------------

    /**
     * Estilo plano y consistente para JTable: sin lineas de grilla,
     * encabezado blanco con una linea inferior sutil, y color de
     * seleccion en el tono suave de la marca.
     */
    public static void estilizarTabla(javax.swing.JTable tabla) {
        tabla.setFont(FUENTE_TEXTO);
        tabla.setForeground(TEXTO);
        tabla.setRowHeight(32);
        tabla.setShowGrid(false);
        tabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabla.setSelectionBackground(PRIMARIO_SUAVE);
        tabla.setSelectionForeground(TEXTO);
        tabla.setFillsViewportHeight(true);
        tabla.setFocusable(false);
        tabla.setRowSelectionAllowed(true);

        javax.swing.table.JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new java.awt.Dimension(0, 34));
        header.setFont(new Font(FAMILIA, Font.BOLD, 12));
        header.setForeground(TEXTO_SUAVE);
        header.setBackground(TARJETA);
        header.setReorderingAllowed(false);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDE));
    }

    // ---- Etiquetas -----------------------------------------------------

    public static void etiquetaCampo(JLabel label) {
        label.setFont(FUENTE_LABEL);
        label.setForeground(TEXTO_SUAVE);
    }

    public static void etiquetaSeccion(JLabel label) {
        label.setFont(FUENTE_SECCION);
        label.setForeground(TEXTO_SUAVE);
    }
}

package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    // Genera un hash SHA-256 a partir de un texto recibido.
    // Se utiliza para guardar contraseñas de forma más segura.
    public static String sha256(String texto) {
        try {
            // Se obtiene una instancia del algoritmo SHA-256.
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Convierte el texto en bytes y genera el hash.
            byte[] hash = md.digest(texto.getBytes());

            StringBuilder sb = new StringBuilder();
            // Convierte cada byte del hash en formato hexadecimal.
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error al generar hash: " + e.getMessage());
            return null;
        }
    }
}
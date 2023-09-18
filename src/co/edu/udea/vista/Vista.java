package co.edu.udea.vista;
import javax.swing.JOptionPane;
public class Vista {
    public void mostrarMensaje(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String ingresoDatos(String message) {
        String input = new String();
        try {
            input = JOptionPane.showInputDialog(null, message);
        } catch (NullPointerException e) {
            JOptionPane.showInputDialog(null, "Por favor, no dejes campos vacios");
            ingresoDatos(message);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa solo números");
            ingresoDatos(message);
        }
        return input;
    }
}

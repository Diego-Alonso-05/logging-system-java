package M4;

import M0.Log;
import java.util.List;

/*
 * Component interface for the Composite pattern.
 * Allows treating individual logs and groups uniformly.
 */
public interface LogComponent {

    // Para mostrar el árbol con indentación
    void display(String indent);

    // Para aplanar los logs y guardarlos
    List<Log> getLogs();
}
package battleRoyale_v1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogPartida {
	
	private PrintWriter pw;
	
	//constructor
    public LogPartida(String fichero) throws IOException {
        pw = new PrintWriter(new FileWriter(fichero));
    }
	
    //ir poniendo mensajes en el fichero log
    public void log(String mensaje) {
        pw.println(mensaje);
        pw.flush();
    }
    
    //se cierra el fichero
    public void cerrar() {
        pw.close();
    }
}

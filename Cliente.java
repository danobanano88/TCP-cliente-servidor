import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;



public class Cliente {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 4020;

        DataInputStream  in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, PUERTO);
            System.out.println("Cliente conectado");
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Hola servidor");

            String mensaje = in.readUTF();
            System.out.println("Mensaje recibido: " + mensaje);
            sc.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
      
    }
    
}

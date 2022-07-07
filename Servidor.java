import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;


public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        final int PUERTO = 4020;
        DataInputStream in;
        DataOutputStream out;

        try {
        servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado en el puerto " + PUERTO);
        
        while(true){
            sc = servidor.accept();
            System.out.println("Cliente conectado");
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF();
            System.out.println("Mensaje recibido: " + mensaje);

            out.writeUTF("Mensaje recibido: " + mensaje);

            sc.close();
            System.out.println("Conexion cerrada");
        }

            
        } catch (Exception e) {
            Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }


}

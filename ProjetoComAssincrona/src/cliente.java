import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class cliente {
	public static void main(String[] args) {
        try {
            Socket fluxo = new Socket("127.0.0.1",12345);
            System.out.println("se conectou!");
            Thread entrada = new Thread();
            entrada.start();
            Thread saida = new Thread();
            saida.start();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

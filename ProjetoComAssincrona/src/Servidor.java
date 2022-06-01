import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class servidor {

	public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("se preparando...");
            Socket fluxo = server.accept();
            Thread entrada = new Thread();
            entrada.start();
            Thread saida = new Thread();
            saida.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
	


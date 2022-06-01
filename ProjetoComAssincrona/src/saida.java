import java.io.PrintStream;
import java.util.Scanner;

public class saida extends Thread {

	public void run(){
	System.out.println(fluxo.getInetAddress().getHostAddress()+" conectado!");
    Scanner leDoFluxo = new Scanner(fluxo.getInputStream());
    while(leDoFluxo.hasNextLine()) {
        System.out.println(leDoFluxo.nextLine());
        PrintStream escrevenofluxo = new PrintStream(fluxo.getOutputStream());
        Scanner teclado = new Scanner(System.in);
        if(teclado.hasNextLine()) {
            String x = teclado.nextLine();
            escrevenofluxo.println(x);                    
        }
        escrevenofluxo = null;
    }
    leDoFluxo.close();
    server.close();
	}
}

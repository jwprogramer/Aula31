import java.io.PrintStream;
import java.util.Scanner;

public class entrada extends Thread {
    public void run() {
    	
    PrintStream escrevenofluxo = new PrintStream(fluxo.getOutputStream());
    Scanner teclado = new Scanner(System.in);
    while(teclado.hasNextLine()) {
        String x = teclado.nextLine();
        escrevenofluxo.println(x);
        Scanner leDoFluxo = new Scanner(fluxo.getInputStream());
        if(leDoFluxo.hasNextLine()) {
            System.out.println(leDoFluxo.nextLine());
        }
        leDoFluxo = null;
    }
    teclado.close();
    escrevenofluxo.close();
    fluxo.close();
    }
}

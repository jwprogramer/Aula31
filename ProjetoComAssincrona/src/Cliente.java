import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Scanner leDoFluxo = new Scanner(fluxo.getInputStream());
			while (leDoFluxo.hasNextLine()) {
				System.out.println(leDoFluxo.nextLine());
				PrintStream escrevenofluxo = new PrintStream(fluxo.getOutputStream());
				Scanner teclado = new Scanner(System.in);
				InputStream is = System.in;
				if (teclado.hasNextLine()) {
					String x = teclado.nextLine();
					escrevenofluxo.println(x);
				}
				escrevenofluxo = null;
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				String digitado = br.readLine();
			}
			leDoFluxo.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	
	
	
	

    public static void main(String[] args) {
        try {
            Socket fluxo = new Socket("127.0.0.1",12345);
            System.out.println("se conectou!");
            PrintStream escrevenofluxo = new PrintStream(fluxo.getOutputStream());
            Scanner teclado = new Scanner(System.in);
            while(teclado.hasNextLine()) {
                String x = teclado.nextLine();
                escrevenofluxo.println(x);
                //aqui
                Scanner leDoFluxo = new Scanner(fluxo.getInputStream());
                if(leDoFluxo.hasNextLine()) {
                    System.out.println(leDoFluxo.nextLine());
                }
                leDoFluxo = null;
            }
            teclado.close();
            escrevenofluxo.close();
            fluxo.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

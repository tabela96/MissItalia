package gastaldo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(9999);
		ArrayList <String> lista=new ArrayList<String>();
		lista.add("Menegon");
		lista.add("Borto");
		lista.add("Nardi");
		lista.add("Gastaldo");
		int primo=0;
		int secondo=0;
		int terzo=0;
		int quarto=0;
		while(true){
			Socket s=ss.accept();
			PrintWriter out=new PrintWriter(s.getOutputStream(), true);
			for(int i=0;i<lista.size();i++){
				out.println(lista.get(i));
			}
			out.println("FINE");
			int votazione=s.getInputStream().read();
			switch (votazione) {
			case 0:
				primo++;
				break;
			case 1:
				secondo++;
				break;
			case 2:
				terzo++;
				break;
			case 3:
				quarto++;
				break;
			}
			System.out.println("VOTI:");
			System.out.println("Menegon: "+primo);
			System.out.println("Borto: "+secondo);
			System.out.println("Nardi: "+terzo);
			System.out.println("Gastaldo: "+quarto);
		}
	}
}

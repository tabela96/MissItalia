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
		while(true){
			Socket s=ss.accept();
			PrintWriter out=new PrintWriter(s.getOutputStream(), true);
			for(int i=0;i<lista.size();i++){
				out.println(lista.get(i));
			}
			out.println("FINE");
		}
	}
}

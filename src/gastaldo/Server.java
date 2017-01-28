package gastaldo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(9999);
		while(true){
			Socket s=ss.accept();
		}
	}
}

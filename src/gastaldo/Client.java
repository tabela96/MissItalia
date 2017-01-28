package gastaldo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class Client {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client window = new Client();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public void open() throws UnknownHostException, IOException {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		avvia();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 10, 162, 202);
		
		Button btnLista = new Button(shell, SWT.NONE);
		btnLista.setBounds(214, 10, 75, 25);
		btnLista.setText("Lista");

	}
	
	public void avvia() throws UnknownHostException, IOException{
		Socket s=new Socket("localhost", 9999);
	}
}

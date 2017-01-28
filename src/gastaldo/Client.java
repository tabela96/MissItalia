package gastaldo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell shell;
	private Socket s;

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
		btnLista.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					s=new Socket("localhost", 9999);
					InputStreamReader isr=new InputStreamReader(s.getInputStream());
					BufferedReader in=new BufferedReader(isr);
					String fine=in.readLine();
					while(!fine.equals("FINE")){
						list.add(fine);
						fine=in.readLine();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLista.setBounds(214, 10, 75, 25);
		btnLista.setText("Lista");

	}
	
}

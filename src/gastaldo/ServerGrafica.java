package gastaldo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class ServerGrafica {

	protected Shell shell;
	private ServerSocket ss;
	private Socket s;
	private int primo = 0;
	private int secondo = 0;
	private int terzo = 0;
	private int quarto = 0;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerGrafica window = new ServerGrafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * 
	 * @throws IOException
	 */
	public void open() throws IOException {
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
		shell.setSize(146, 235);
		shell.setText("SWT Application");

		Label lblMenegon = new Label(shell, SWT.NONE);
		lblMenegon.setBounds(10, 10, 55, 15);
		lblMenegon.setText("Menegon");

		Label lblGastaldo = new Label(shell, SWT.NONE);
		lblGastaldo.setBounds(10, 48, 55, 15);
		lblGastaldo.setText("Gastaldo");

		Label lblBorto = new Label(shell, SWT.NONE);
		lblBorto.setBounds(10, 92, 55, 15);
		lblBorto.setText("Borto");

		Label lblNardi = new Label(shell, SWT.NONE);
		lblNardi.setBounds(10, 140, 55, 15);
		lblNardi.setText("Nardi");

		Label votoMenegon = new Label(shell, SWT.NONE);
		votoMenegon.setBounds(107, 10, 55, 15);
		votoMenegon.setText("0");

		Label votoGastaldo = new Label(shell, SWT.NONE);
		votoGastaldo.setBounds(107, 48, 55, 15);
		votoGastaldo.setText("0");

		Label votoBorto = new Label(shell, SWT.NONE);
		votoBorto.setBounds(107, 92, 55, 15);
		votoBorto.setText("0");

		Label votoNardi = new Label(shell, SWT.NONE);
		votoNardi.setBounds(107, 140, 55, 15);
		votoNardi.setText("0");

		Button btnAvvia = new Button(shell, SWT.NONE);
		btnAvvia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					crea();
					votoMenegon.setText(String.valueOf(primo));
					votoBorto.setText(String.valueOf(secondo));
					votoNardi.setText(String.valueOf(terzo));
					votoGastaldo.setText(String.valueOf(quarto));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAvvia.setBounds(10, 172, 110, 25);
		btnAvvia.setText("Avvia Server");

	}

	public void crea() throws IOException {
		ss = new ServerSocket(9999);
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Menegon");
		lista.add("Borto");
		lista.add("Nardi");
		lista.add("Gastaldo");
		s = ss.accept();
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		for (int i = 0; i < lista.size(); i++) {
			out.println(lista.get(i));
		}
		out.println("FINE");
		int votazione = s.getInputStream().read();
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
		System.out.println("Menegon: " + primo);
		System.out.println("Borto: " + secondo);
		System.out.println("Nardi: " + terzo);
		System.out.println("Gastaldo: " + quarto);
	}
}

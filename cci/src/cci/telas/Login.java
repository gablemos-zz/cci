package cci.telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Login {
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlLogin = new Shell();
		shlLogin.setSize(194, 198);
		shlLogin.setText("Login");
		
		Label lblUsuario = new Label(shlLogin, SWT.NONE);
		lblUsuario.setBounds(10, 10, 55, 15);
		lblUsuario.setText("Usu\u00E1rio");
		
		text = new Text(shlLogin, SWT.BORDER);
		text.setBounds(71, 7, 97, 21);
		
		Label lblSenha = new Label(shlLogin, SWT.NONE);
		lblSenha.setBounds(10, 56, 55, 15);
		lblSenha.setText("Senha");
		
		text_1 = new Text(shlLogin, SWT.BORDER);
		text_1.setBounds(71, 53, 97, 21);
		
		Button btnLogar = new Button(shlLogin, SWT.NONE);
		btnLogar.setBounds(10, 104, 75, 25);
		btnLogar.setText("Logar");
		
		Button btnCancelar = new Button(shlLogin, SWT.NONE);
		btnCancelar.setBounds(93, 104, 75, 25);
		btnCancelar.setText("Cancelar");

		shlLogin.open();
		shlLogin.layout();
		while (!shlLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}

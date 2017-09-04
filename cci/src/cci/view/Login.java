package cci.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class Login {

	protected Shell shlLogin;
	private Text txtUsuario;
	private Text txtSenha;

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
		createContents();
		shlLogin.open();
		shlLogin.layout();
		while (!shlLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogin = new Shell();
		shlLogin.setImage(SWTResourceManager.getImage(Login.class, "/cci/imagem/Logo.jpg"));
		shlLogin.setBackgroundImage(SWTResourceManager.getImage(Login.class, "/cci/imagem/S.jpg"));
		shlLogin.setSize(945, 786);
		shlLogin.setText("Login");
		
		Label lblUsuario = new Label(shlLogin, SWT.NONE);
		lblUsuario.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblUsuario.setBounds(610, 337, 65, 21);
		lblUsuario.setText(" Usu\u00E1rio");
		
		txtUsuario = new Text(shlLogin, SWT.BORDER);
		txtUsuario.setBounds(523, 364, 238, 21);
		
		txtSenha = new Text(shlLogin, SWT.BORDER);
		txtSenha.setBounds(523, 447, 238, 21);
		
		Label lblSenha = new Label(shlLogin, SWT.NONE);
		lblSenha.setText("  Senha");
		lblSenha.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblSenha.setBounds(610, 420, 65, 21);
		
		Button btnLogar = new Button(shlLogin, SWT.NONE);
		btnLogar.setBounds(523, 517, 75, 25);
		btnLogar.setText("Logar");
		
		Button btnSair = new Button(shlLogin, SWT.NONE);
		btnSair.setBounds(686, 517, 75, 25);
		btnSair.setText("Sair");

	}
}

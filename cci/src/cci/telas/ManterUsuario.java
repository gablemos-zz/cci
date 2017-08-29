package cci.telas;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ManterUsuario {
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ManterUsuario window = new ManterUsuario();
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
		Shell shlManterUsurio = new Shell();
		shlManterUsurio.setSize(450, 168);
		shlManterUsurio.setText("Manter Usu\u00E1rio");
		
		Label lblUsuario = new Label(shlManterUsurio, SWT.NONE);
		lblUsuario.setBounds(10, 10, 55, 15);
		lblUsuario.setText("Usuario");
		
		text = new Text(shlManterUsurio, SWT.BORDER);
		text.setBounds(82, 7, 115, 21);
		
		text_1 = new Text(shlManterUsurio, SWT.BORDER);
		text_1.setText("*******");
		text_1.setBounds(81, 31, 116, 21);
		
		Label lblSenha = new Label(shlManterUsurio, SWT.NONE);
		lblSenha.setBounds(10, 37, 55, 15);
		lblSenha.setText("Senha");
		
		Combo combo = new Combo(shlManterUsurio, SWT.NONE);
		combo.setItems(new String[] {"ADM", "Funcion\u00E1rio"});
		combo.setBounds(82, 58, 115, 23);
		combo.select(0);
		
		Label lblPrermisso = new Label(shlManterUsurio, SWT.NONE);
		lblPrermisso.setBounds(10, 66, 64, 15);
		lblPrermisso.setText("Prermiss\u00E3o");
		
		Button btnInserir = new Button(shlManterUsurio, SWT.NONE);
		btnInserir.setBounds(10, 97, 75, 25);
		btnInserir.setText("Inserir");
		
		Button btnAnterar = new Button(shlManterUsurio, SWT.NONE);
		btnAnterar.setBounds(88, 97, 75, 25);
		btnAnterar.setText("Anterar");
		
		Button btnExcluir = new Button(shlManterUsurio, SWT.NONE);
		btnExcluir.setBounds(172, 97, 75, 25);
		btnExcluir.setText("Excluir");
		
		Button btnSair = new Button(shlManterUsurio, SWT.NONE);
		btnSair.setBounds(253, 97, 75, 25);
		btnSair.setText("Sair");

		shlManterUsurio.open();
		shlManterUsurio.layout();
		while (!shlManterUsurio.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

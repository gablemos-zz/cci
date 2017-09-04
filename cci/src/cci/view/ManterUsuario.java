package cci.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ManterUsuario {

	protected Shell shell;
	private Text txtUsuario;
	private Text txtSenha;
	private Table table;

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
		shell.setBackgroundImage(SWTResourceManager.getImage(ManterUsuario.class, "/cci/imagem/Usuario.jpg"));
		shell.setImage(SWTResourceManager.getImage(ManterUsuario.class, "/cci/imagem/Logo.jpg"));
		shell.setSize(945, 786);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblUsuario = new Label(shell, SWT.NONE);
		lblUsuario.setBounds(253, 225, 40, 15);
		lblUsuario.setText("Usu\u00E1rio");
		
		txtUsuario = new Text(shell, SWT.BORDER);
		txtUsuario.setBounds(86, 246, 373, 21);
		
		Label lblSenha = new Label(shell, SWT.NONE);
		lblSenha.setBounds(253, 312, 40, 15);
		lblSenha.setText(" Senha");
		
		txtSenha = new Text(shell, SWT.BORDER);
		txtSenha.setBounds(86, 333, 373, 21);
		
		Label lblAcesso = new Label(shell, SWT.NONE);
		lblAcesso.setBounds(253, 407, 40, 15);
		lblAcesso.setText("Acesso");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"Administrador", "Funcion\u00E1rio"});
		combo.setBounds(86, 428, 373, 23);
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.setBounds(86, 480, 75, 65);
		btnCadastrar.setText("Cadastrar");
		
		Button btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.setBounds(315, 586, 75, 65);
		btnCancelar.setText("Cancelar");
		
		Button btnEliminar = new Button(shell, SWT.NONE);
		btnEliminar.setBounds(159, 586, 75, 65);
		btnEliminar.setText("Eliminar");
		
		Button btnAtualizar = new Button(shell, SWT.NONE);
		btnAtualizar.setBounds(384, 480, 75, 65);
		btnAtualizar.setText("Atualizar");
		
		Button btnCarregar = new Button(shell, SWT.NONE);
		btnCarregar.setBounds(240, 480, 75, 65);
		btnCarregar.setText("Carregar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(492, 225, 373, 426);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnUsuario = new TableColumn(table, SWT.NONE);
		tblclmnUsuario.setWidth(200);
		tblclmnUsuario.setText("Usu\u00E1rio");
		
		TableColumn tblclmnSenha = new TableColumn(table, SWT.NONE);
		tblclmnSenha.setWidth(168);
		tblclmnSenha.setText("Senha");

	}
}

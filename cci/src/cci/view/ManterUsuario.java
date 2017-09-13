package cci.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class ManterUsuario {

	protected Shell shlManterUsuario;
	private Text txtUsuario;
	private Text txtSenha;
	private Table tbUsuarios;

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
		shlManterUsuario.open();
		shlManterUsuario.layout();
		while (!shlManterUsuario.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlManterUsuario = new Shell();
		shlManterUsuario.setBackgroundImage(SWTResourceManager.getImage(ManterUsuario.class, "/cci/imagem/Cliente.jpg"));
		shlManterUsuario.setImage(SWTResourceManager.getImage(ManterUsuario.class, "/cci/imagem/Logo.jpg"));
		shlManterUsuario.setSize(945, 786);
		shlManterUsuario.setText("Manter Usuario");
		shlManterUsuario.setLayout(null);
		
		Label lblUsuario = new Label(shlManterUsuario, SWT.NONE);
		lblUsuario.setBounds(253, 225, 40, 15);
		lblUsuario.setText("Usu\u00E1rio");
		
		txtUsuario = new Text(shlManterUsuario, SWT.BORDER);
		txtUsuario.setBounds(86, 246, 373, 21);
		
		Label lblSenha = new Label(shlManterUsuario, SWT.NONE);
		lblSenha.setBounds(253, 312, 40, 15);
		lblSenha.setText(" Senha");
		
		txtSenha = new Text(shlManterUsuario, SWT.BORDER);
		txtSenha.setBounds(86, 333, 373, 21);
		
		Label lblAcesso = new Label(shlManterUsuario, SWT.NONE);
		lblAcesso.setBounds(253, 407, 40, 15);
		lblAcesso.setText("Acesso");
		
		Combo cmbxAcesso = new Combo(shlManterUsuario, SWT.NONE);
		cmbxAcesso.setItems(new String[] {"Administrador", "Funcion\u00E1rio"});
		cmbxAcesso.setBounds(86, 428, 373, 23);
		
		Button btnCadastrar = new Button(shlManterUsuario, SWT.NONE);
		btnCadastrar.setBounds(86, 480, 75, 65);
		btnCadastrar.setText("Cadastrar");
		
		Button btnCancelar = new Button(shlManterUsuario, SWT.NONE);
		btnCancelar.setBounds(315, 586, 75, 65);
		btnCancelar.setText("Cancelar");
		
		Button btnEliminar = new Button(shlManterUsuario, SWT.NONE);
		btnEliminar.setBounds(159, 586, 75, 65);
		btnEliminar.setText("Eliminar");
		
		Button btnAtualizar = new Button(shlManterUsuario, SWT.NONE);
		btnAtualizar.setBounds(384, 480, 75, 65);
		btnAtualizar.setText("Atualizar");
		
		Button btnCarregar = new Button(shlManterUsuario, SWT.NONE);
		btnCarregar.setBounds(240, 480, 75, 65);
		btnCarregar.setText("Carregar");
		
		tbUsuarios = new Table(shlManterUsuario, SWT.BORDER | SWT.FULL_SELECTION);
		tbUsuarios.setBounds(492, 225, 373, 426);
		tbUsuarios.setHeaderVisible(true);
		tbUsuarios.setLinesVisible(true);
		
		TableColumn tblclmnUsuario = new TableColumn(tbUsuarios, SWT.NONE);
		tblclmnUsuario.setWidth(200);
		tblclmnUsuario.setText("Usu\u00E1rio");
		
		TableColumn tblclmnSenha = new TableColumn(tbUsuarios, SWT.NONE);
		tblclmnSenha.setWidth(168);
		tblclmnSenha.setText("Senha");
		
		Menu menu = new Menu(shlManterUsuario, SWT.BAR);
		shlManterUsuario.setMenuBar(menu);
		
		MenuItem mntmCadastros_1 = new MenuItem(menu, SWT.CASCADE);
		mntmCadastros_1.setText("Cadastros");
		
		Menu menu_1 = new Menu(mntmCadastros_1);
		mntmCadastros_1.setMenu(menu_1);
		
		MenuItem mntmCliente = new MenuItem(menu_1, SWT.NONE);
		mntmCliente.setText("Cliente");

	}
}

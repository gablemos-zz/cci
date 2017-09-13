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

public class ManterCliente {

	protected Shell shlManterCliente;
	private Text txtCpf;
	private Text txtNome;
	private Text txtRg;
	private Text txtTelefone;
	private Text txtCelular;
	private Text txtEmail;
	private Text txtCep;
	private Text txtLogradouro;
	private Text txtBairro;
	private Text txtNumero;
	private Text txtComplemento;
	private Text txtCidade;
	private Table tbClientes;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ManterCliente window = new ManterCliente();
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
		shlManterCliente.open();
		shlManterCliente.layout();
		while (!shlManterCliente.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlManterCliente = new Shell();
		shlManterCliente.setBackgroundImage(SWTResourceManager.getImage(ManterCliente.class, "/cci/imagem/Cliente.jpg"));
		shlManterCliente.setImage(SWTResourceManager.getImage(ManterCliente.class, "/cci/imagem/Logo.jpg"));
		shlManterCliente.setSize(945, 786);
		shlManterCliente.setText("Manter Cliente");
		
		Label lblCpf = new Label(shlManterCliente, SWT.NONE);
		lblCpf.setBounds(39, 196, 32, 15);
		lblCpf.setText(" CPF ");
		
		txtCpf = new Text(shlManterCliente, SWT.BORDER);
		txtCpf.setBounds(77, 193, 277, 21);
		
		Label lblNome = new Label(shlManterCliente, SWT.NONE);
		lblNome.setBounds(39, 223, 44, 15);
		lblNome.setText(" Nome ");
		
		txtNome = new Text(shlManterCliente, SWT.BORDER);
		txtNome.setBounds(87, 220, 267, 21);
		
		Label lblRg = new Label(shlManterCliente, SWT.NONE);
		lblRg.setBounds(39, 250, 26, 15);
		lblRg.setText(" RG ");
		
		txtRg = new Text(shlManterCliente, SWT.BORDER);
		txtRg.setBounds(71, 247, 283, 21);
		
		txtTelefone = new Text(shlManterCliente, SWT.BORDER);
		txtTelefone.setBounds(100, 274, 254, 21);
		
		Label lblTelefone = new Label(shlManterCliente, SWT.NONE);
		lblTelefone.setBounds(39, 277, 55, 15);
		lblTelefone.setText(" Telefone ");
		
		txtCelular = new Text(shlManterCliente, SWT.BORDER);
		txtCelular.setBounds(87, 301, 267, 21);
		
		Label lblCelular = new Label(shlManterCliente, SWT.NONE);
		lblCelular.setBounds(39, 304, 44, 15);
		lblCelular.setText(" Celular ");
		
		txtEmail = new Text(shlManterCliente, SWT.BORDER);
		txtEmail.setBounds(87, 328, 267, 21);
		
		Label lblEmail = new Label(shlManterCliente, SWT.NONE);
		lblEmail.setBounds(39, 331, 38, 15);
		lblEmail.setText(" Email");
		
		txtCep = new Text(shlManterCliente, SWT.BORDER);
		txtCep.setBounds(77, 355, 277, 21);
		
		Label lblCep = new Label(shlManterCliente, SWT.NONE);
		lblCep.setBounds(39, 358, 32, 15);
		lblCep.setText(" CEP ");
		
		txtLogradouro = new Text(shlManterCliente, SWT.BORDER);
		txtLogradouro.setBounds(118, 382, 236, 21);
		
		Label lblLogradouro = new Label(shlManterCliente, SWT.NONE);
		lblLogradouro.setBounds(39, 385, 73, 15);
		lblLogradouro.setText(" Logradouro ");
		
		txtBairro = new Text(shlManterCliente, SWT.BORDER);
		txtBairro.setBounds(87, 409, 267, 21);
		
		Label lblBairro = new Label(shlManterCliente, SWT.NONE);
		lblBairro.setBounds(39, 412, 38, 15);
		lblBairro.setText(" Bairro");
		
		txtNumero = new Text(shlManterCliente, SWT.BORDER);
		txtNumero.setBounds(97, 436, 257, 21);
		
		Label lblNumero = new Label(shlManterCliente, SWT.NONE);
		lblNumero.setBounds(39, 439, 55, 15);
		lblNumero.setText(" Numero ");
		
		txtComplemento = new Text(shlManterCliente, SWT.BORDER);
		txtComplemento.setBounds(125, 463, 229, 21);
		
		Label lblComplemento = new Label(shlManterCliente, SWT.NONE);
		lblComplemento.setBounds(39, 466, 80, 15);
		lblComplemento.setText("Complemento ");
		
		txtCidade = new Text(shlManterCliente, SWT.BORDER);
		txtCidade.setBounds(87, 490, 267, 21);
		
		Label lblCidade = new Label(shlManterCliente, SWT.NONE);
		lblCidade.setBounds(39, 493, 44, 15);
		lblCidade.setText("Cidade");
		
		Combo cmbxEstado = new Combo(shlManterCliente, SWT.NONE);
		cmbxEstado.setBounds(87, 517, 267, 23);
		
		Label lblEstado = new Label(shlManterCliente, SWT.NONE);
		lblEstado.setBounds(39, 520, 44, 15);
		lblEstado.setText("Estado");
		
		Button btnCadastrar = new Button(shlManterCliente, SWT.NONE);
		btnCadastrar.setBounds(39, 557, 75, 65);
		btnCadastrar.setText("Cadastrar");
		
		Button btnAtualizar = new Button(shlManterCliente, SWT.NONE);
		btnAtualizar.setText("Atualizar");
		btnAtualizar.setBounds(279, 557, 75, 65);
		
		Button btnCarregar = new Button(shlManterCliente, SWT.NONE);
		btnCarregar.setText("Carregar");
		btnCarregar.setBounds(162, 557, 75, 65);
		
		Button btnEliminar = new Button(shlManterCliente, SWT.NONE);
		btnEliminar.setText("Eliminar");
		btnEliminar.setBounds(100, 649, 75, 65);
		
		Button btnCancelar = new Button(shlManterCliente, SWT.NONE);
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(222, 649, 75, 65);
		
		tbClientes = new Table(shlManterCliente, SWT.BORDER | SWT.FULL_SELECTION);
		tbClientes.setBounds(385, 193, 511, 521);
		tbClientes.setHeaderVisible(true);
		tbClientes.setLinesVisible(true);
		
		TableColumn tblclmnCpf = new TableColumn(tbClientes, SWT.CENTER);
		tblclmnCpf.setWidth(121);
		tblclmnCpf.setText("CPF");
		
		TableColumn tblclmnNome = new TableColumn(tbClientes, SWT.CENTER);
		tblclmnNome.setWidth(141);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnTelefone = new TableColumn(tbClientes, SWT.CENTER);
		tblclmnTelefone.setWidth(121);
		tblclmnTelefone.setText("Telefone");
		
		TableColumn tblclmnCelular = new TableColumn(tbClientes, SWT.CENTER);
		tblclmnCelular.setWidth(121);
		tblclmnCelular.setText("Celular");

	}
}

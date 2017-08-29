package cci.telas;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class ManterClientes {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ManterClientes window = new ManterClientes();
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
		Shell shlManterClientes = new Shell();
		shlManterClientes.setSize(450, 561);
		shlManterClientes.setText("Manter Clientes");
		
		Label lblCpf = new Label(shlManterClientes, SWT.NONE);
		lblCpf.setBounds(10, 10, 55, 15);
		lblCpf.setText("CPF");
		
		Label lblNome = new Label(shlManterClientes, SWT.NONE);
		lblNome.setBounds(10, 37, 55, 15);
		lblNome.setText("Nome");
		
		Label lblRg = new Label(shlManterClientes, SWT.NONE);
		lblRg.setBounds(10, 64, 55, 15);
		lblRg.setText("RG");
		
		Label lblEndereco = new Label(shlManterClientes, SWT.NONE);
		lblEndereco.setBounds(10, 91, 55, 15);
		lblEndereco.setText("Endereco");
		
		Label lblNumero = new Label(shlManterClientes, SWT.NONE);
		lblNumero.setBounds(10, 118, 55, 15);
		lblNumero.setText("Numero");
		
		Label lblComplemento = new Label(shlManterClientes, SWT.NONE);
		lblComplemento.setBounds(10, 145, 84, 15);
		lblComplemento.setText("Complemento");
		
		Label lblBairro = new Label(shlManterClientes, SWT.NONE);
		lblBairro.setBounds(10, 172, 55, 15);
		lblBairro.setText("Bairro");
		
		Label lblCidade = new Label(shlManterClientes, SWT.NONE);
		lblCidade.setBounds(10, 199, 55, 15);
		lblCidade.setText("Cidade");
		
		Label lblTelefone = new Label(shlManterClientes, SWT.NONE);
		lblTelefone.setBounds(10, 226, 55, 15);
		lblTelefone.setText("Telefone");
		
		Label lblCelular = new Label(shlManterClientes, SWT.NONE);
		lblCelular.setBounds(10, 253, 55, 15);
		lblCelular.setText("Celular");
		
		Label lblEmail = new Label(shlManterClientes, SWT.NONE);
		lblEmail.setBounds(10, 280, 55, 15);
		lblEmail.setText("Email");
		
		text = new Text(shlManterClientes, SWT.BORDER);
		text.setBounds(100, 34, 309, 21);
		
		text_1 = new Text(shlManterClientes, SWT.BORDER);
		text_1.setBounds(100, 7, 309, 21);
		
		text_2 = new Text(shlManterClientes, SWT.BORDER);
		text_2.setBounds(100, 61, 309, 21);
		
		text_3 = new Text(shlManterClientes, SWT.BORDER);
		text_3.setBounds(100, 88, 309, 21);
		
		text_4 = new Text(shlManterClientes, SWT.BORDER);
		text_4.setBounds(100, 115, 309, 21);
		
		text_5 = new Text(shlManterClientes, SWT.BORDER);
		text_5.setBounds(100, 142, 309, 21);
		
		text_6 = new Text(shlManterClientes, SWT.BORDER);
		text_6.setBounds(100, 169, 309, 21);
		
		text_7 = new Text(shlManterClientes, SWT.BORDER);
		text_7.setBounds(100, 196, 309, 21);
		
		text_8 = new Text(shlManterClientes, SWT.BORDER);
		text_8.setBounds(100, 223, 309, 21);
		
		text_9 = new Text(shlManterClientes, SWT.BORDER);
		text_9.setBounds(100, 250, 309, 21);
		
		text_10 = new Text(shlManterClientes, SWT.BORDER);
		text_10.setBounds(100, 277, 309, 21);
		
		Button btnInserir = new Button(shlManterClientes, SWT.NONE);
		btnInserir.setBounds(10, 312, 75, 25);
		btnInserir.setText("Inserir");
		
		Button btnAlterar = new Button(shlManterClientes, SWT.NONE);
		btnAlterar.setBounds(91, 312, 75, 25);
		btnAlterar.setText("Alterar");
		
		Button btnEliminar = new Button(shlManterClientes, SWT.NONE);
		btnEliminar.setBounds(172, 312, 75, 25);
		btnEliminar.setText("Eliminar");
		
		Button btnAtualizar = new Button(shlManterClientes, SWT.NONE);
		btnAtualizar.setBounds(253, 312, 75, 25);
		btnAtualizar.setText("Atualizar");
		
		Button btnSair = new Button(shlManterClientes, SWT.NONE);
		btnSair.setBounds(334, 312, 75, 25);
		btnSair.setText("Sair");
		
		table = new Table(shlManterClientes, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 343, 399, 144);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCpf = new TableColumn(table, SWT.NONE);
		tblclmnCpf.setWidth(100);
		tblclmnCpf.setText("CPF");
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(295);
		tblclmnNome.setText("Nome");

		shlManterClientes.open();
		shlManterClientes.layout();
		while (!shlManterClientes.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

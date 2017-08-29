package cci.telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ManterFuncionario {
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
	private Text text_11;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ManterFuncionario window = new ManterFuncionario();
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
		Shell shlManterFuncionario = new Shell();
		shlManterFuncionario.setSize(450, 539);
		shlManterFuncionario.setText("Manter Funcionario");
		
		Label lblCpf = new Label(shlManterFuncionario, SWT.NONE);
		lblCpf.setBounds(10, 10, 55, 15);
		lblCpf.setText("CPF");
		
		text = new Text(shlManterFuncionario, SWT.BORDER);
		text.setBounds(71, 10, 288, 21);
		
		text_1 = new Text(shlManterFuncionario, SWT.BORDER);
		text_1.setBounds(71, 37, 288, 21);
		
		text_2 = new Text(shlManterFuncionario, SWT.BORDER);
		text_2.setBounds(71, 64, 288, 21);
		
		text_3 = new Text(shlManterFuncionario, SWT.BORDER);
		text_3.setBounds(71, 91, 288, 21);
		
		text_4 = new Text(shlManterFuncionario, SWT.BORDER);
		text_4.setBounds(71, 118, 288, 21);
		
		text_5 = new Text(shlManterFuncionario, SWT.BORDER);
		text_5.setBounds(95, 145, 264, 21);
		
		text_6 = new Text(shlManterFuncionario, SWT.BORDER);
		text_6.setBounds(71, 172, 288, 21);
		
		text_7 = new Text(shlManterFuncionario, SWT.BORDER);
		text_7.setBounds(71, 199, 288, 21);
		
		text_8 = new Text(shlManterFuncionario, SWT.BORDER);
		text_8.setBounds(71, 226, 288, 21);
		
		Label lblNome = new Label(shlManterFuncionario, SWT.NONE);
		lblNome.setBounds(10, 43, 55, 15);
		lblNome.setText("Nome");
		
		Label lblRg = new Label(shlManterFuncionario, SWT.NONE);
		lblRg.setBounds(10, 70, 55, 15);
		lblRg.setText("RG");
		
		Label lblEndereco = new Label(shlManterFuncionario, SWT.NONE);
		lblEndereco.setBounds(10, 97, 55, 15);
		lblEndereco.setText("Endereco");
		
		Label lblNumero = new Label(shlManterFuncionario, SWT.NONE);
		lblNumero.setBounds(10, 124, 55, 15);
		lblNumero.setText("Numero");
		
		Label lblComplemento = new Label(shlManterFuncionario, SWT.NONE);
		lblComplemento.setBounds(10, 151, 79, 15);
		lblComplemento.setText("Complemento");
		
		Label lblBairro = new Label(shlManterFuncionario, SWT.NONE);
		lblBairro.setBounds(10, 178, 55, 15);
		lblBairro.setText("Bairro");
		
		Label lblCidade = new Label(shlManterFuncionario, SWT.NONE);
		lblCidade.setBounds(10, 205, 55, 15);
		lblCidade.setText("Cidade");
		
		Label lblTelefone = new Label(shlManterFuncionario, SWT.NONE);
		lblTelefone.setBounds(10, 232, 55, 15);
		lblTelefone.setText("Telefone");
		
		text_9 = new Text(shlManterFuncionario, SWT.BORDER);
		text_9.setBounds(71, 253, 288, 21);
		
		text_10 = new Text(shlManterFuncionario, SWT.BORDER);
		text_10.setBounds(71, 280, 288, 21);
		
		Label lblTelefone_1 = new Label(shlManterFuncionario, SWT.NONE);
		lblTelefone_1.setBounds(10, 259, 55, 15);
		lblTelefone_1.setText("Telefone");
		
		Label lblEmail = new Label(shlManterFuncionario, SWT.NONE);
		lblEmail.setBounds(10, 286, 55, 15);
		lblEmail.setText("Email");
		
		Button btnInserir = new Button(shlManterFuncionario, SWT.NONE);
		btnInserir.setBounds(10, 342, 75, 25);
		btnInserir.setText("Inserir");
		
		Button btnAlterar = new Button(shlManterFuncionario, SWT.NONE);
		btnAlterar.setBounds(95, 342, 75, 25);
		btnAlterar.setText("Alterar");
		
		Button btnEliminar = new Button(shlManterFuncionario, SWT.NONE);
		btnEliminar.setBounds(176, 342, 75, 25);
		btnEliminar.setText("Eliminar");
		
		Button btnSair = new Button(shlManterFuncionario, SWT.NONE);
		btnSair.setBounds(338, 342, 75, 25);
		btnSair.setText("Sair");
		
		table = new Table(shlManterFuncionario, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 373, 403, 118);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCpf = new TableColumn(table, SWT.NONE);
		tblclmnCpf.setWidth(100);
		tblclmnCpf.setText("CPF");
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnCargo = new TableColumn(table, SWT.NONE);
		tblclmnCargo.setWidth(144);
		tblclmnCargo.setText("Cargo");
		
		text_11 = new Text(shlManterFuncionario, SWT.BORDER);
		text_11.setBounds(71, 307, 288, 21);
		
		Label lblCargo = new Label(shlManterFuncionario, SWT.NONE);
		lblCargo.setBounds(10, 307, 55, 15);
		lblCargo.setText("Cargo");
		
		Button btnAtualizar = new Button(shlManterFuncionario, SWT.NONE);
		btnAtualizar.setBounds(257, 342, 75, 25);
		btnAtualizar.setText("Atualizar");

		shlManterFuncionario.open();
		shlManterFuncionario.layout();
		while (!shlManterFuncionario.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}

package cci.telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ManterServico {

	protected Shell shlManterServicos;
	private Text text;
	private Text txtR;
	private Table table;
	private Text text_1;
	private Table table_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ManterServico window = new ManterServico();
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
		shlManterServicos.open();
		shlManterServicos.layout();
		while (!shlManterServicos.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlManterServicos = new Shell();
		shlManterServicos.setSize(450, 602);
		shlManterServicos.setText("Manter Servicos");
		
		text = new Text(shlManterServicos, SWT.BORDER);
		text.setBounds(83, 10, 269, 21);
		
		txtR = new Text(shlManterServicos, SWT.BORDER);
		txtR.setText("R$ ");
		txtR.setEnabled(false);
		txtR.setBounds(83, 64, 108, 21);
		
		Spinner spinner = new Spinner(shlManterServicos, SWT.BORDER);
		spinner.setBounds(132, 36, 47, 22);
		
		Label lblDias = new Label(shlManterServicos, SWT.NONE);
		lblDias.setBounds(185, 43, 55, 15);
		lblDias.setText("dias");
		
		Combo combo = new Combo(shlManterServicos, SWT.NONE);
		combo.setBounds(83, 91, 269, 23);
		
		Combo combo_1 = new Combo(shlManterServicos, SWT.NONE);
		combo_1.setBounds(83, 120, 269, 23);
		
		Label lblDescricao = new Label(shlManterServicos, SWT.NONE);
		lblDescricao.setBounds(10, 13, 55, 15);
		lblDescricao.setText("Descricao");
		
		Label lblTempoDeExecucao = new Label(shlManterServicos, SWT.NONE);
		lblTempoDeExecucao.setBounds(10, 44, 116, 15);
		lblTempoDeExecucao.setText("Tempo de Execucao");
		
		Label lblCusto = new Label(shlManterServicos, SWT.NONE);
		lblCusto.setBounds(10, 70, 55, 15);
		lblCusto.setText("Custo");
		
		Label lblProduto = new Label(shlManterServicos, SWT.NONE);
		lblProduto.setBounds(10, 99, 55, 15);
		lblProduto.setText("Produto");
		
		Button btnAdd = new Button(shlManterServicos, SWT.NONE);
		btnAdd.setBounds(359, 89, 50, 25);
		btnAdd.setText("Add");
		
		Label lblFuncionario = new Label(shlManterServicos, SWT.NONE);
		lblFuncionario.setBounds(10, 128, 67, 15);
		lblFuncionario.setText("Funcionario");
		
		table = new Table(shlManterServicos, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 179, 342, 106);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnPreasUsadasNeste = new TableColumn(table, SWT.NONE);
		tblclmnPreasUsadasNeste.setWidth(338);
		tblclmnPreasUsadasNeste.setText("Pre\u00E7as usadas neste Servi\u00E7o");
		
		Label lblNewLabel = new Label(shlManterServicos, SWT.NONE);
		lblNewLabel.setBounds(10, 158, 99, 15);
		lblNewLabel.setText("Ordem de Servi\u00E7o");
		
		text_1 = new Text(shlManterServicos, SWT.BORDER);
		text_1.setEnabled(false);
		text_1.setBounds(115, 152, 76, 21);
		
		Button btnInserir = new Button(shlManterServicos, SWT.NONE);
		btnInserir.setBounds(10, 310, 75, 25);
		btnInserir.setText("Inserir");
		
		Button btnAlterar = new Button(shlManterServicos, SWT.NONE);
		btnAlterar.setBounds(91, 310, 75, 25);
		btnAlterar.setText("Alterar");
		
		Button btnEliminar = new Button(shlManterServicos, SWT.NONE);
		btnEliminar.setBounds(172, 310, 75, 25);
		btnEliminar.setText("Eliminar");
		
		Button btnAtualizar = new Button(shlManterServicos, SWT.NONE);
		btnAtualizar.setBounds(253, 310, 75, 25);
		btnAtualizar.setText("Atualizar");
		
		Button btnCancelar = new Button(shlManterServicos, SWT.NONE);
		btnCancelar.setBounds(334, 310, 75, 25);
		btnCancelar.setText("Cancelar");
		
		table_1 = new Table(shlManterServicos, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(10, 360, 399, 194);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnOrdemDeServio = new TableColumn(table_1, SWT.NONE);
		tblclmnOrdemDeServio.setWidth(109);
		tblclmnOrdemDeServio.setText("Ordem de Servi\u00E7o");
		
		TableColumn tblclmnDescrio = new TableColumn(table_1, SWT.NONE);
		tblclmnDescrio.setWidth(286);
		tblclmnDescrio.setText("Descri\u00E7\u00E3o");

	}
}

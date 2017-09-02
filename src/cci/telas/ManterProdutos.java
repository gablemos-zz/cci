package cci.telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ManterProdutos {

	protected Shell shlManterProdutos;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ManterProdutos window = new ManterProdutos();
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
		shlManterProdutos.open();
		shlManterProdutos.layout();
		while (!shlManterProdutos.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlManterProdutos = new Shell();
		shlManterProdutos.setSize(450, 351);
		shlManterProdutos.setText("Manter Produtos");
		
		text = new Text(shlManterProdutos, SWT.BORDER);
		text.setBounds(93, 10, 152, 21);
		
		text_1 = new Text(shlManterProdutos, SWT.BORDER);
		text_1.setBounds(93, 37, 152, 21);
		
		text_2 = new Text(shlManterProdutos, SWT.BORDER);
		text_2.setBounds(93, 64, 152, 21);
		
		text_3 = new Text(shlManterProdutos, SWT.BORDER);
		text_3.setBounds(93, 91, 152, 21);
		
		Label lblPeso = new Label(shlManterProdutos, SWT.NONE);
		lblPeso.setBounds(10, 10, 55, 15);
		lblPeso.setText("Peso");
		
		Label lblUnidade = new Label(shlManterProdutos, SWT.NONE);
		lblUnidade.setBounds(10, 37, 55, 15);
		lblUnidade.setText("Unidade");
		
		Label lblEspecificao = new Label(shlManterProdutos, SWT.NONE);
		lblEspecificao.setBounds(10, 64, 77, 15);
		lblEspecificao.setText("Especifica\u00E7\u00E3o");
		
		Label lblPreo = new Label(shlManterProdutos, SWT.NONE);
		lblPreo.setBounds(10, 91, 55, 15);
		lblPreo.setText("Pre\u00E7o");
		
		Button btnInserir = new Button(shlManterProdutos, SWT.NONE);
		btnInserir.setBounds(10, 145, 75, 25);
		btnInserir.setText("Inserir");
		
		Button btnAlterar = new Button(shlManterProdutos, SWT.NONE);
		btnAlterar.setBounds(93, 145, 75, 25);
		btnAlterar.setText("Alterar");
		
		Button btnEliminar = new Button(shlManterProdutos, SWT.NONE);
		btnEliminar.setBounds(181, 145, 75, 25);
		btnEliminar.setText("Eliminar");
		
		Button btnAtualizar = new Button(shlManterProdutos, SWT.NONE);
		btnAtualizar.setBounds(262, 145, 75, 25);
		btnAtualizar.setText("Atualizar");
		
		Button btnSair = new Button(shlManterProdutos, SWT.NONE);
		btnSair.setBounds(343, 145, 75, 25);
		btnSair.setText("Sair");
		
		table = new Table(shlManterProdutos, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 178, 408, 125);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnEspecificao = new TableColumn(table, SWT.NONE);
		tblclmnEspecificao.setWidth(404);
		tblclmnEspecificao.setText("Especifica\u00E7\u00E3o");

	}

}

package prova_semestral_prog.prova;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JanelaLista extends JPanel {

	public JanelaLista() {
		setLayout(new BorderLayout());
		
		JPanel tabelaLayout = new JPanel(new GridLayout(1, 1));
		
		@SuppressWarnings("serial")
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		modelo.addColumn("ID");
		modelo.addColumn("Data Terra");
		modelo.addColumn("Numero de dias em Marte");
		modelo.addColumn("Longitude Solar");
		modelo.addColumn("Mes em Marte");
		modelo.addColumn("temperatura Minima");
		modelo.addColumn("Temperatura Maxima");
		modelo.addColumn("Pressao Atmosférica");

		MissaoDao dao = new MissaoDao();
		dao.getList().forEach(missao -> {
			modelo.addRow(new Object[] {
					missao.getId(),
					missao.getDataTerra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					missao.getNrDiasMarte(),
					missao.getLongSolar(),
					missao.getMesMarte(),
					missao.getMinTemp(),
					missao.getMaxTemp(),
					missao.getPressaoAtm()
			});
		});
		
		JTable tabela = new JTable(modelo);
		
		JScrollPane scroll = new JScrollPane(tabela);
		tabelaLayout.add(scroll);
		add(tabelaLayout,BorderLayout.CENTER);
		
		JPanel painel = new JPanel(new FlowLayout());
		JButton botaoDeletar = new JButton("deletar");
		botaoDeletar.addActionListener(acaodeletar -> {
			if (tabela.getSelectedRow() >= 0) {
				dao.remover(Integer.parseInt(String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0))));
				Main.tabs.setSelectedIndex(0);
				Main.tabs.setSelectedIndex(1);
			} else {
				System.out.println("selecione uma linha");
			}
		});

		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(acaoeditar -> {
			if (tabela.getSelectedRow() >= 0) {
				String id = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
				String dataTerra = tabela.getValueAt(tabela.getSelectedRow(), 1).toString();
				String nrDiasMarte = tabela.getValueAt(tabela.getSelectedRow(), 2).toString();
				String longSolar = tabela.getValueAt(tabela.getSelectedRow(), 3).toString();
				String mesMarte = tabela.getValueAt(tabela.getSelectedRow(), 4).toString();
				String minTemp = tabela.getValueAt(tabela.getSelectedRow(), 5).toString();
				String maxTemp = tabela.getValueAt(tabela.getSelectedRow(), 6).toString();
				String pressaoAtm = tabela.getValueAt(tabela.getSelectedRow(), 7).toString();

				Main.tabs.setSelectedIndex(0);
				JanelaCadastro janelaCadastro = (JanelaCadastro) Main.tabs.getComponent(0);

				JTextField campoId = janelaCadastro.getCampoId();
				campoId.setText(id);
				
				JTextField campoDataTerra = janelaCadastro.getCampoDataTerra();
				campoDataTerra.setText(dataTerra);
				
				JTextField campoNrDiasMarte = janelaCadastro.getCampoNrDiasMarte();
				campoNrDiasMarte.setText(nrDiasMarte);
				
				JTextField campoLongSolar = janelaCadastro.getCampolongSoalar();
				campoLongSolar.setText(longSolar);
				
				JTextField campoMesMarte = janelaCadastro.getCampoMesMarte();
				campoMesMarte.setText(mesMarte);
				
				JTextField campoMinTemp = janelaCadastro.getCampoMinTemp();
				campoMinTemp.setText(minTemp);
				
				JTextField campoMaxTemp = janelaCadastro.getCampoMaxTemp();
				campoMaxTemp.setText(maxTemp);
				
				JTextField campoPressaoAtm = janelaCadastro.getCampoPressaoAtm();
				campoPressaoAtm.setText(pressaoAtm);
				
			} else {
				System.out.println("selecione uma linha");
			}
		});
		painel.add(botaoDeletar);
		painel.add(botaoEditar);
		add(painel,BorderLayout.SOUTH);
	}

}

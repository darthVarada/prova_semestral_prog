package prova_semestral_prog.prova;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Main {
	
	public static JTabbedPane tabs;
	
	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Prova semestral Grupo LEAF");
		tabs = new JTabbedPane();
		tabs.add("Cadastro",new JanelaCadastro());
		tabs.add("Lista",new JanelaLista());
		tabs.addChangeListener(acaoMudar -> {
			tabs.setComponentAt(1, new JanelaLista());
		});

		janela.add(tabs);
		janela.setSize(800, 350);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

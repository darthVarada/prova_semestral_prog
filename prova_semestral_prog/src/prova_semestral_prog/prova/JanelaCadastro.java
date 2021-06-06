package prova_semestral_prog.prova;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastro extends JPanel {

	private JTextField campoId;
	private JTextField campoDataTerra;
	private JTextField campoNrDiasMarte;
	private JTextField campolongSoalar;
	private JTextField campoMesMarte;
	private JTextField campoMinTemp;
	private JTextField campoMaxTemp;
	private JTextField campoPressaoAtm;

	public JanelaCadastro() {

		setLayout(new BorderLayout());
		JPanel campos = new JPanel(new GridLayout(16, 1));
		campos.add(new JLabel("id"));
		campoId = new JTextField();
		campoId.setEditable(false);
		campos.add(campoId);

		campos.add(new JLabel("Data Terra"));
		campoDataTerra = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		campos.add(campoDataTerra);

		campos.add(new JLabel("Numero de dias em Marte"));
		campoNrDiasMarte = new JTextField();
		campos.add(campoNrDiasMarte);

		campos.add(new JLabel("Longitude Solar"));
		campolongSoalar = new JTextField();
		campos.add(campolongSoalar);

		campos.add(new JLabel("Mes em Marte"));
		campoMesMarte = new JTextField();
		campos.add(campoMesMarte);

		campos.add(new JLabel("temperatura Minima"));
		campoMinTemp = new JTextField();
		campos.add(campoMinTemp);

		campos.add(new JLabel("Temperatura Maxima"));
		campoMaxTemp = new JTextField();
		campos.add(campoMaxTemp);

		campos.add(new JLabel("Pressao Atmosférica"));
		campoPressaoAtm = new JTextField();
		campos.add(campoPressaoAtm);

		add(campos, BorderLayout.CENTER);

		JPanel botoes = new JPanel(new FlowLayout());
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(acao -> {
			Missao missao = new Missao();

			missao.setLongSolar(Double.parseDouble(campolongSoalar.getText()));
			missao.setMaxTemp(Double.parseDouble(campoMaxTemp.getText()));
			missao.setMesMarte(Integer.parseInt(campoMesMarte.getText()));
			missao.setMinTemp(Double.parseDouble(campoMinTemp.getText()));
			missao.setNrDiasMarte(Integer.parseInt(campoNrDiasMarte.getText()));
			missao.setPressaoAtm(Double.parseDouble(campoPressaoAtm.getText()));
			missao.setDataTerra(LocalDate.parse(campoDataTerra.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

			MissaoDao dao = new MissaoDao();
			
			if (campoId.getText() != null && !campoId.getText().trim().equals("")) {
				missao.setId(Integer.parseInt(campoId.getText()));
				dao.atualizar(missao);
			} else {
				dao.salvar(missao);
			}
			
		});
		botoes.add(salvar);
		JButton limpar = new JButton("limpar");
		limpar.addActionListener(acao -> {

			campoId.setText("");
			campoDataTerra.setText("");
			campoNrDiasMarte.setText("");
			campolongSoalar.setText("");
			campoMesMarte.setText("");
			campoMinTemp.setText("");
			campoMaxTemp.setText("");
			campoPressaoAtm.setText("");

		});
		botoes.add(limpar);
		add(botoes, BorderLayout.SOUTH);
	}

	public JTextField getCampoId() {
		return campoId;
	}

	public JTextField getCampoDataTerra() {
		return campoDataTerra;
	}

	public JTextField getCampoNrDiasMarte() {
		return campoNrDiasMarte;
	}

	public JTextField getCampolongSoalar() {
		return campolongSoalar;
	}

	public JTextField getCampoMesMarte() {
		return campoMesMarte;
	}

	public JTextField getCampoMinTemp() {
		return campoMinTemp;
	}

	public JTextField getCampoMaxTemp() {
		return campoMaxTemp;
	}

	public JTextField getCampoPressaoAtm() {
		return campoPressaoAtm;
	}

}

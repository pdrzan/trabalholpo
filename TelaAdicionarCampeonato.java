package a;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAdicionarCampeonato implements Tela {

	private JMenuItem botaoOrigem;
	ArrayList<Campeonato> campeonatos;
	private JPanel tela;
    private JPanel maxJogadores;
	private JTextField maxJogadoresText;
    private JPanel maxTimes;
	private JTextField maxTimesText;
	private JPanel maxPartidas;
	private JTextField maxPartidasText;
    private JPanel nomeCampeonato;
	private JTextField nomeCampeonatoText;
	private JButton salvar;
	 
	// int maxJogadores, int maxTimes, int maxPartidas, String nomeCampeonato
	public TelaAdicionarCampeonato(JMenuItem botaoOrigem, ArrayList<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
		this.botaoOrigem = botaoOrigem;
		
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		maxJogadoresText = new JTextField(40);
		maxJogadores = new JPanel();
		maxJogadores.setLayout(new FlowLayout());
		maxJogadores.add(new JLabel("Maximo de Jogadores: "));
		maxJogadores.add(maxJogadoresText);
		tela.add(maxJogadores);
		
		maxTimesText = new JTextField(40);
		maxTimes = new JPanel();
		maxTimes.setLayout(new FlowLayout());
		maxTimes.add(new JLabel("Maximo de Times: "));
		maxTimes.add(maxTimesText);
		tela.add(maxTimes);
		
		maxPartidasText = new JTextField(40);
		maxPartidas = new JPanel();
		maxPartidas.setLayout(new FlowLayout());
		maxPartidas.add(new JLabel("Maximo de Partidas: "));
		maxPartidas.add(maxPartidasText);
		tela.add(maxPartidas);
		
		nomeCampeonatoText = new JTextField(40);
		nomeCampeonato = new JPanel();
		nomeCampeonato.setLayout(new FlowLayout());
		nomeCampeonato.add(new JLabel("Nome do Campeonato: "));
		nomeCampeonato.add(nomeCampeonatoText);
		tela.add(nomeCampeonato);
	
		salvar = new JButton("Salvar");
		salvar.addActionListener((e) -> {
			try {
                campeonatos.add(new Campeonato(Integer.parseInt(maxJogadoresText.getText()), Integer.parseInt(maxTimesText.getText()), Integer.parseInt(maxPartidasText.getText()), nomeCampeonatoText.getText()));
				JOptionPane.showMessageDialog(null, "Campeonato salvo com sucesso");
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Campeonato!");
			}
		});
		tela.add(salvar);
	}
	
	@Override
	public JPanel getTela() {
		return tela;
	}
	

	@Override
	public JMenuItem getSource() {
		return botaoOrigem;
	}

	@Override
	public String getMensagemStatus() {
		return "Adicionando Campeonato...";
	}

}

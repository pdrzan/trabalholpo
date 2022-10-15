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

public class TelaRemoverTaca implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
    private JPanel nomeCampeonato;
	private JTextField nomeCampeonatoText;
    private JPanel nomeTime;
	private JTextField nomeTimeText;
	private JPanel ano;
	private JTextField anoText;
	private JButton remover;
	private ArrayList<Partida> partidas;
    private ArrayList<Campeonato> campeonatos;
    private ArrayList<Taca> tacas;
    private ArrayList<Time> times;
	
	public TelaRemoverTaca(JMenuItem botaoOrigem, ArrayList<Taca> tacas, ArrayList<Campeonato> campeonatos, ArrayList<Time> times) {
		this.campeonatos = campeonatos;
        this.botaoOrigem = botaoOrigem;
        this.tacas = tacas;
        this.times = times;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		nomeCampeonatoText = new JTextField(40);
		nomeCampeonato = new JPanel();
		nomeCampeonato.setLayout(new FlowLayout());
		nomeCampeonato.add(new JLabel("Nome do Campeonato: "));
		nomeCampeonato.add(nomeCampeonatoText);
		tela.add(nomeCampeonato);

		nomeTimeText = new JTextField(40);
		nomeTime = new JPanel();
		nomeTime.setLayout(new FlowLayout());
		nomeTime.add(new JLabel("Nome do time ganhador: "));
		nomeTime.add(nomeTimeText);
		tela.add(nomeTime);

		anoText = new JTextField(40);
		ano = new JPanel();
		ano.setLayout(new FlowLayout());
		ano.add(new JLabel("Ano correspondente: "));
		ano.add(anoText);
		tela.add(ano);
		
		remover = new JButton("Remover");
		remover.addActionListener((e) -> {
			boolean encontrado = false;
			try {
				for(int i = 0; i < tacas.size(); i++ ) {
					if(tacas.get(i).getGanhador().getNomeTime().equals(nomeTimeText.getText()) && tacas.get(i).getCampeonato().getNomeCampeonato().equals(nomeCampeonatoText.getText()) && tacas.get(i).getAno() == Integer.parseInt(anoText.getText())) {
						tacas.remove(i);
						encontrado = true;
						break;
					}
				}
				if(encontrado) {
					JOptionPane.showMessageDialog(null, "Taca removida com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Taca nao encontrada");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Campeonato/Jogador!");
			}
		});
	tela.add(remover);
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
		return "Removendo Taca...";
	}

}

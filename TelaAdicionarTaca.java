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

public class TelaAdicionarTaca implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
    private JPanel nomeCampeonato;
	private JTextField nomeCampeonatoText;
    private JPanel nomeTime;
	private JTextField nomeTimeText;
	private JPanel ano;
	private JTextField anoText;
	private JButton salvar;
	private ArrayList<Partida> partidas;
    private ArrayList<Campeonato> campeonatos;
    private ArrayList<Taca> tacas;
    private ArrayList<Time> times;
	
	public TelaAdicionarTaca(JMenuItem botaoOrigem, ArrayList<Taca> tacas, ArrayList<Campeonato> campeonatos, ArrayList<Time> times) {
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

		salvar = new JButton("Salvar");
		salvar.addActionListener((e) -> {
			boolean achou = false;
			try {
				for(int i = 0; i < campeonatos.size(); i++ ) {
					if(campeonatos.get(i).getNomeCampeonato().equals(nomeCampeonatoText.getText())) {
						for(int j = 0; j < times.size();j++ ) {
							if(times.get(j).getNomeTime().equals(nomeTimeText.getText())) {
								tacas.add(new Taca(campeonatos.get(i), Integer.parseInt(anoText.getText()), times.get(j)));
								achou = true;
								break;
							}
						}
						break;
					}
				}
				if(achou) {
					JOptionPane.showMessageDialog(null, "Taca adicionada com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Time/Campeonato nao encontrado");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para a Taca");
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
		return "Adiconando Taca...";
	}

}

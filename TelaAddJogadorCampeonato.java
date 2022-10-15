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

public class TelaAddJogadorCampeonato implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
    private JPanel nome;
	private JTextField nomeText;
	private JPanel posicao;
	private JTextField posicaoText;
    private JPanel nomeCampeonato;
	private JTextField nomeCampeonatoText;
	private JButton adicionar;
	private ArrayList<Jogador> jogadores;
    private ArrayList<Campeonato> campeonatos;
	
	public TelaAddJogadorCampeonato(JMenuItem botaoOrigem, ArrayList<Jogador> jogadores, ArrayList<Campeonato> campeonatos) {
		this.jogadores = jogadores;
		this.campeonatos = campeonatos;
        this.botaoOrigem = botaoOrigem;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));

		nomeText = new JTextField(40);
        nome = new JPanel();
        nome.setLayout(new FlowLayout());
        nome.add(new JLabel("Nome do Jogador: "));
        nome.add(nomeText);
		tela.add(nome);

		posicaoText = new JTextField(40);
		posicao = new JPanel();
		posicao.setLayout(new FlowLayout());
		posicao.add(new JLabel("Posicao: "));
		posicao.add(posicaoText);
		tela.add(posicao);

		nomeCampeonatoText = new JTextField(40);
		nomeCampeonato = new JPanel();
		nomeCampeonato.setLayout(new FlowLayout());
		nomeCampeonato.add(new JLabel("Nome do Campeonato: "));
		nomeCampeonato.add(nomeCampeonatoText);
		tela.add(nomeCampeonato);
		
		adicionar = new JButton("Adicionar");
		adicionar.addActionListener((e) -> {
			boolean achou = false;
			try {
				for(int i = 0; i < campeonatos.size(); i ++) {
					if(campeonatos.get(i).getNomeCampeonato().equals(nomeCampeonatoText.getText())) {
						for(int j = 0; j < jogadores.size(); j++) {
							if(jogadores.get(j).getNome().equals(nomeText.getText()) && jogadores.get(j).getPosicao().equals(posicaoText.getText())) {
								jogadores.get(j).adicionaCampeonatos(campeonatos.get(i));
								achou = true;
								break;
							}
						}
						break;
					}
				}
				if(achou) {
					JOptionPane.showMessageDialog(null, "Campeonato adicionado com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Campeonato/Jogador nao encontrado");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Jogador/Campeonato!");
			}
		});
		tela.add(adicionar);
		
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
		return "Adicionado Campeonato ao Jogador...";
	}

}

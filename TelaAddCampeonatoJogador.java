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

public class TelaAddCampeonatoJogador implements Tela {
	
	private JMenuItem botaoOrigem;
	private JPanel tela;
	private ArrayList<Campeonato> campeonatos;
    private JPanel nomeCampeonato;
	private JTextField nomeCampeonatoText;
	private JPanel nomeJogador;
	private JTextField nomeJogadorText;
	private JButton adicionar;
	private ArrayList<Jogador> jogadores;
	
	public TelaAddCampeonatoJogador(JMenuItem botaoOrigem, ArrayList<Campeonato> campeonatos, ArrayList<Jogador> jogadores) {
		this.botaoOrigem = botaoOrigem;
		this.campeonatos = campeonatos;
		this.jogadores = jogadores;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		nomeCampeonatoText = new JTextField(40);
		nomeCampeonato = new JPanel();
		nomeCampeonato.setLayout(new FlowLayout());
		nomeCampeonato.add(new JLabel("Nome do Campeonato: "));
		nomeCampeonato.add(nomeCampeonatoText);
		tela.add(nomeCampeonato);
		
		nomeJogadorText = new JTextField(40);
		nomeJogador = new JPanel();
		nomeJogador.setLayout(new FlowLayout());
		nomeJogador.add(new JLabel("Nome do Jogador: "));
		nomeJogador.add(nomeJogadorText);
		tela.add(nomeJogador);
		
		adicionar = new JButton("Atualizar");
		adicionar.addActionListener((e) -> {
			boolean achou = false;
			try {
				for(int i = 0; i < campeonatos.size(); i++ ) {
					if(campeonatos.get(i).getNomeCampeonato().equals(nomeCampeonatoText.getText())) {
						for(int j = 0; j < jogadores.size();j++ ) {
							if(jogadores.get(j).getNome().equals(nomeJogadorText.getText())) {
								campeonatos.get(i).adicionaJogador(jogadores.get(j));
								achou = true;
								break;
							}
						}
						break;
					}
				}
				if(achou) {
					JOptionPane.showMessageDialog(null, "Jogador adicionado com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Jogador/Campeonato nao encontrado");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Campeonato/Jogador!");
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
		return "Adicionando Jogador ao Campeonato...";
	}

}

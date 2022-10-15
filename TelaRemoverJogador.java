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

public class TelaRemoverJogador implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
    private JPanel nome;
	private JTextField nomeText;
	private JPanel posicao;
	private JTextField posicaoText;
    private JPanel nomeTime;
	private JTextField nomeTimeText;
	private JButton remover;
	private ArrayList<Jogador> jogadores;
    private ArrayList<Time> times;
	
	public TelaRemoverJogador(JMenuItem botaoOrigem, ArrayList<Jogador> jogadores, ArrayList<Time> times) {
		this.jogadores = jogadores;
		this.times = times;
        this.botaoOrigem = botaoOrigem;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));

		nomeText = new JTextField(40);
        nome = new JPanel();
        nome.setLayout(new FlowLayout());
        nome.add(new JLabel("Nome: "));
        nome.add(nomeText);
		tela.add(nome);

		posicaoText = new JTextField(40);
		posicao = new JPanel();
		posicao.setLayout(new FlowLayout());
		posicao.add(new JLabel("Posicao: "));
		posicao.add(posicaoText);
		tela.add(posicao);

		nomeTimeText = new JTextField(40);
        nomeTime = new JPanel();
        nomeTime.setLayout(new FlowLayout());
        nomeTime.add(new JLabel("Nome do Time: "));
        nomeTime.add(nomeTimeText);
		tela.add(nomeTime);

		//int idade, String nome, String posicao, Time time, int maxCampeonatos
		
		remover = new JButton("Remover");
		remover.addActionListener((e) -> {
			boolean encontrado = false;
			try {
                for(int i = 0; i < times.size(); i++) {
                	if(times.get(i).getNomeTime().equals(nomeTimeText.getText())) {
                		for(int j = 0; j < jogadores.size(); j++) {
                			if(jogadores.get(j).getTime().equals(times.get(i)) && jogadores.get(j).getPosicao().equals(posicaoText.getText()) && jogadores.get(j).getNome().equals(nomeText.getText())) {
                				jogadores.remove(j);
                				encontrado = true;
                				break;
                			}
                		}
                		break;
                	}
                }
                if(encontrado) {
					JOptionPane.showMessageDialog(null, "Jogador removido com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Jogador nao encontrado");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Jogador!");
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
		return "Removendo Jogador...";
	}

}

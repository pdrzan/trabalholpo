package a;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaListarJogador implements Tela {

	private JMenuItem botaoOrigem;
	ArrayList<Jogador> jogadorAtual;
	ArrayList<Jogador> ultimosJogadoresListadas;
	private JPanel tela;
	
	public TelaListarJogador(JMenuItem botaoOrigem, ArrayList<Jogador> jogadores) {
		this.jogadorAtual = jogadores;
		this.botaoOrigem = botaoOrigem;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JPanel getTela() {
		if(!jogadorAtual.equals(ultimosJogadoresListadas)) {
			ultimosJogadoresListadas = (ArrayList<Jogador>)jogadorAtual.clone();
			
			tela.removeAll();
			
			for(int i = 0 ; i < ultimosJogadoresListadas.size() ; i++) 
				tela.add(new JLabel(ultimosJogadoresListadas.get(i).toString()));
		}
		
		return tela;
	}

	@Override
	public JMenuItem getSource() {
		return botaoOrigem;
	}

	@Override
	public String getMensagemStatus() {
		return "Listar Taca...";
	}

}

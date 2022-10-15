package a;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaListarPartida implements Tela {

	private JMenuItem botaoOrigem;
	ArrayList<Partida> partidasAtual;
	ArrayList<Partida> ultimasPartidasListadas;
	private JPanel tela;
	
	public TelaListarPartida(JMenuItem botaoOrigem, ArrayList<Partida> partidas) {
		this.partidasAtual = partidas;
		this.botaoOrigem = botaoOrigem;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
	}
	@SuppressWarnings("unchecked")
	@Override
	public JPanel getTela() {
		if(!partidasAtual.equals(ultimasPartidasListadas)) {
			ultimasPartidasListadas = (ArrayList<Partida>)partidasAtual.clone();
			
			tela.removeAll();
			
			for(int i = 0 ; i < ultimasPartidasListadas.size() ; i++) 
				tela.add(new JLabel(ultimasPartidasListadas.get(i).toString()));
		}
		
		return tela;
	}

	@Override
	public JMenuItem getSource() {
		return botaoOrigem;
	}

	@Override
	public String getMensagemStatus() {
		return "Listando partidas...";
	}

}

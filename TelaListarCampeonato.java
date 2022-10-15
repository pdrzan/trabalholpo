package a;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaListarCampeonato implements Tela {
	
	private JMenuItem botaoOrigem;
	ArrayList<Campeonato> campeonatosAtual;
	ArrayList<Campeonato> ultimosCampeonatosListados;
	private JPanel tela;

	public TelaListarCampeonato(JMenuItem botaoOrigem, ArrayList<Campeonato> campeonatos) {
		this.campeonatosAtual = campeonatos;
		this.botaoOrigem = botaoOrigem;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
	}
	
	@Override
	public JPanel getTela() {
		if(!campeonatosAtual.equals(ultimosCampeonatosListados)) {
			ultimosCampeonatosListados = (ArrayList<Campeonato>)campeonatosAtual.clone();
			
			tela.removeAll();
			
			for(int i = 0 ; i < ultimosCampeonatosListados.size() ; i++) 
				tela.add(new JLabel(ultimosCampeonatosListados.get(i).toString()));
		}
		
		return tela;
	}

	@Override
	public JMenuItem getSource() {
		return botaoOrigem;
	}

	@Override
	public String getMensagemStatus() {
		return "Listando Campeonatos...";
	}

}

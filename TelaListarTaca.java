package a;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaListarTaca implements Tela {
	private JMenuItem botaoOrigem;
	ArrayList<Taca> tacasAtual;
	ArrayList<Taca> ultimasTacasListadas;
	private JPanel tela;
	
	public TelaListarTaca(JMenuItem botaoOrigem, ArrayList<Taca> tacas) {
		this.tacasAtual = tacas;
		this.botaoOrigem = botaoOrigem;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
	}
	@SuppressWarnings("unchecked")
	@Override
	public JPanel getTela() {
		if(!tacasAtual.equals(ultimasTacasListadas)) {
			ultimasTacasListadas = (ArrayList<Taca>)tacasAtual.clone();
			
			tela.removeAll();
			
			for(int i = 0 ; i < ultimasTacasListadas.size() ; i++) 
				tela.add(new JLabel(ultimasTacasListadas.get(i).toString()));
		}
		
		return tela;
	}

	@Override
	public JMenuItem getSource() {
		return botaoOrigem;
	}

	@Override
	public String getMensagemStatus() {
		return "Listando Tacas...";
	}

}

package a;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaListarTime implements Tela {

	private JMenuItem botaoOrigem;
	ArrayList<Time> timeAtual;
	ArrayList<Time> ultimasTimesListados;
	private JPanel tela;
	
	public TelaListarTime(JMenuItem botaoOrigem, ArrayList<Time> times) {
		this.timeAtual = times;
		this.botaoOrigem = botaoOrigem;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JPanel getTela() {
		if(!timeAtual.equals(ultimasTimesListados)) {
			ultimasTimesListados = (ArrayList<Time>)timeAtual.clone();
			
			tela.removeAll();
			
			for(int i = 0 ; i < ultimasTimesListados.size() ; i++) 
				tela.add(new JLabel(ultimasTimesListados.get(i).toString()));
		}
		
		return tela;
	}

	@Override
	public JMenuItem getSource() {
		return botaoOrigem;
	}

	@Override
	public String getMensagemStatus() {
		return "Listando Times...";
	}

}

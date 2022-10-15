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


public class TelaRemoverPartida implements Tela {

	private JMenuItem botaoOrigem;
	private JPanel tela;
	private ArrayList<Partida> partidas;
	private JPanel time1;
	private JPanel time2;
	private JPanel data;
	private JTextField nomeTime1;
	private JTextField nomeTime2;
	private JTextField dataPartida;
	private JButton remover;
	
	public TelaRemoverPartida(JMenuItem botaoOrigem, ArrayList<Partida> partidas) {
		this.botaoOrigem = botaoOrigem;
		this.partidas = partidas;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		nomeTime1 = new JTextField(40);
		time1 = new JPanel();
		time1.setLayout(new FlowLayout());
		time1.add(new JLabel("Nome do primeiro time: "));
		time1.add(nomeTime1);
		tela.add(time1);
		
		nomeTime2 = new JTextField(40);
		time2 = new JPanel();
		time2.setLayout(new FlowLayout());
		time2.add(new JLabel("Nome do segundo time: "));
		time2.add(nomeTime2);
		tela.add(time2);
		
		dataPartida = new JTextField(40);
		data = new JPanel();
		data.setLayout(new FlowLayout());
		data.add(new JLabel("Data da Partida(Formato = DD:MM:AA): "));
		data.add(dataPartida);
		tela.add(data);
		
		remover = new JButton("Remover");
		remover.addActionListener((e) -> {
			boolean encontrado = false;
			try {
				for(int i = 0; i < partidas.size(); i++ ) {
					if(nomeTime1.getText().equals(partidas.get(i).getTime1()) && nomeTime2.getText().equals(partidas.get(i).getTime2()) && dataPartida.getText().equals(partidas.get(i).getDataPartida())) {
						partidas.remove(i);
						encontrado = true;
						break;
					}
				}
				if(encontrado) {
					JOptionPane.showMessageDialog(null, "Partida removida com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Partida nao encontrada");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para a Partida!");
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
		return "Removendo Partida...";
	}

}

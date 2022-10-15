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

public class TelaAtualizarPartida implements Tela {
		
	private JMenuItem botaoOrigem;
	private JPanel tela;
	private ArrayList<Partida> partidas;
	private JPanel time1;
	private JPanel time2;
	private JPanel data;
	private JPanel time1Para;
	private JPanel time2Para;
	private JPanel dataPara;
	private JPanel resultado;
	private JTextField nomeTime1;
	private JTextField nomeTime2;
	private JTextField dataPartida;
	private JTextField nomeTime1Para;
	private JTextField nomeTime2Para;
	private JTextField dataPartidaPara;
	private JTextField textResultado;
	private JButton atualizar;

	public TelaAtualizarPartida(JMenuItem botaoOrigem, ArrayList<Partida> partidas) {
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
		
		nomeTime1Para = new JTextField(40);
		time1Para = new JPanel();
		time1Para.setLayout(new FlowLayout());
		time1Para.add(new JLabel("Mudar o nome do primeiro time para: "));
		time1Para.add(nomeTime1Para);
		tela.add(time1Para);
		
		nomeTime2Para = new JTextField(40);
		time2Para = new JPanel();
		time2Para.setLayout(new FlowLayout());
		time2Para.add(new JLabel("Mudar o nome do segundo time para: "));
		time2Para.add(nomeTime2Para);
		tela.add(time2Para);
		
		dataPartidaPara = new JTextField(40);
		dataPara = new JPanel();
		dataPara.setLayout(new FlowLayout());
		dataPara.add(new JLabel("Mudar data da Partida(Formato = DD:MM:AA) para: "));
		dataPara.add(dataPartidaPara);
		tela.add(dataPara);
		
		textResultado = new JTextField(40);
		resultado = new JPanel();
		resultado.setLayout(new FlowLayout());
		resultado.add(new JLabel("Mudar resultado para(Formato : Time 1: %Numero X Time 2: %Numero"));
		resultado.add(textResultado);
		tela.add(resultado);
		
		atualizar = new JButton("Atualizar");
		atualizar.addActionListener((e) -> {
			boolean achou = false;
			try {
				for(int i = 0; i < partidas.size(); i++ ) {
					if(nomeTime1.getText().equals(partidas.get(i).getTime1()) && nomeTime2.getText().equals(partidas.get(i).getTime2()) && dataPartida.getText().equals(partidas.get(i).getDataPartida())) {
						partidas.get(i).setDataPartida(dataPartidaPara.getText());
						partidas.get(i).setResultado(textResultado.getText());
						partidas.get(i).setTime1(nomeTime1Para.getText());
						partidas.get(i).setTime2(nomeTime2Para.getText());
						achou = true;
						break;
					}
				}
				if(achou) {
					JOptionPane.showMessageDialog(null, "Partida atualizada com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Partida nao encontrada");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para a Partida!");
			}
		});
		tela.add(atualizar);
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
		return "Atualizando Partida...";
	}

}

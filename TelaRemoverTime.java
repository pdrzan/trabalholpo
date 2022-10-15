package a;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaRemoverTime implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
	private ArrayList<Time> times;
    private JPanel anoDeCriacao;
	private JTextField anoDeCriacaoText;
	private JPanel nomeTime;
	private JTextField nomeTimeText;
	private JButton remover;
	
	//int maxJogadores,int anoDeCriacao, int maxTacas, String nomeTime
	public TelaRemoverTime(JMenuItem botaoOrigem, ArrayList<Time> times) {
		this.botaoOrigem = botaoOrigem;
		this.times = times;
		tela = new JPanel();
		
		anoDeCriacaoText = new JTextField(40);
		anoDeCriacao = new JPanel();
		anoDeCriacao.setLayout(new FlowLayout());
		anoDeCriacao.add(new JLabel("Ano de criacao: "));
		anoDeCriacao.add(anoDeCriacaoText);
		tela.add(anoDeCriacao);
		
		nomeTimeText = new JTextField(40);
		nomeTime = new JPanel();
		nomeTime.setLayout(new FlowLayout());
		nomeTime.add(new JLabel("Nome do Time: "));
		nomeTime.add(nomeTimeText);
		tela.add(nomeTime);
		
		//int maxJogadores,int anoDeCriacao, int maxTacas, String nomeTime
		remover = new JButton("Remover");
		remover.addActionListener((e) -> {
			boolean encontrado = false;
			try {
                for(int i = 0; i < times.size(); i++) {
                	if(times.get(i).getAnoDeCriacao() == (Integer.parseInt(anoDeCriacaoText.getText())) && times.get(i).getNomeTime().equals(nomeTimeText.getText())) {
                		times.remove(i);
                		encontrado = true;
                		break;
                	}
                }
                if(encontrado) {
					JOptionPane.showMessageDialog(null, "Time removido com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Time nao encontrado");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Time!");
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
		return "Removendo Time...";
	}

}

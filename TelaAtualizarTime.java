package a;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAtualizarTime implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
	private ArrayList<Time> times;
    private JPanel anoDeCriacao;
	private JTextField anoDeCriacaoText;
	private JPanel nomeTime;
	private JTextField nomeTimeText;

    private JPanel anoDeCriacaoPara;
	private JTextField anoDeCriacaoTextPara;
	private JPanel nomeTimePara;
	private JTextField nomeTimeTextPara;
	private JButton atualizar;
	
	//int maxJogadores,int anoDeCriacao, int maxTacas, String nomeTime
	public TelaAtualizarTime(JMenuItem botaoOrigem, ArrayList<Time> times) {
		this.botaoOrigem = botaoOrigem;
		this.times = times;
		tela = new JPanel();
		
		anoDeCriacaoText = new JTextField(40);
		anoDeCriacao = new JPanel();
		anoDeCriacao.setLayout(new FlowLayout());
		anoDeCriacao.add(new JLabel("Ano de criacao: "));
		anoDeCriacao.add(anoDeCriacaoText);
		tela.add(anoDeCriacao);
		
		anoDeCriacaoTextPara = new JTextField(40);
		anoDeCriacaoPara = new JPanel();
		anoDeCriacaoPara.setLayout(new FlowLayout());
		anoDeCriacaoPara.add(new JLabel("Ano de cracao para: "));
		anoDeCriacaoPara.add(anoDeCriacaoTextPara);
		tela.add(anoDeCriacaoPara);
		
		nomeTimeText = new JTextField(40);
		nomeTime = new JPanel();
		nomeTime.setLayout(new FlowLayout());
		nomeTime.add(new JLabel("Nome do Time: "));
		nomeTime.add(nomeTimeText);
		tela.add(nomeTime);
		
		nomeTimeTextPara = new JTextField(40);
		nomeTimePara = new JPanel();
		nomeTimePara.setLayout(new FlowLayout());
		nomeTimePara.add(new JLabel("Nome do Time para: "));
		nomeTimePara.add(nomeTimeTextPara);
		tela.add(nomeTimePara);
		
		//int maxJogadores,int anoDeCriacao, int maxTacas, String nomeTime
		atualizar = new JButton("Atualizar");
		atualizar.addActionListener((e) -> {
			boolean achou = false;
			try {
				for(int i = 0; i < times.size(); i++) {
                	if(times.get(i).getAnoDeCriacao() == (Integer.parseInt(anoDeCriacaoText.getText())) && times.get(i).getNomeTime().equals(nomeTimeText.getText())) {
                		times.get(i).setAnoDeCriacao(Integer.parseInt(anoDeCriacaoTextPara.getText()));
                		times.get(i).setNomeTime(nomeTimeTextPara.getText());
                		achou = true;
                		break;
                	}
                }
				if(achou) {
					JOptionPane.showMessageDialog(null, "Time atualizado com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Time nao encontrado");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Time!");
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
		return "Removendo Time...";
	}

}

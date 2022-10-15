package a;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAdicionarTime implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
	private ArrayList<Time> times;
	private JPanel maxJogadores;
	private JTextField maxJogadoresText;
    private JPanel anoDeCriacao;
	private JTextField anoDeCriacaoText;
	private JPanel maxTacas;
	private JTextField maxTacasText;
	private JPanel nomeTime;
	private JTextField nomeTimeText;
	private JButton salvar;
	
	//int maxJogadores,int anoDeCriacao, int maxTacas, String nomeTime
	public TelaAdicionarTime(JMenuItem botaoOrigem, ArrayList<Time> times) {
		this.botaoOrigem = botaoOrigem;
		this.times = times;
		tela = new JPanel();
		
		maxJogadoresText = new JTextField(40);
		maxJogadores = new JPanel();
		maxJogadores.setLayout(new FlowLayout());
		maxJogadores.add(new JLabel("Maximo de Jogadores: "));
		maxJogadores.add(maxJogadoresText);
		tela.add(maxJogadores);
		
		anoDeCriacaoText = new JTextField(40);
		anoDeCriacao = new JPanel();
		anoDeCriacao.setLayout(new FlowLayout());
		anoDeCriacao.add(new JLabel("Ano de criacao: "));
		anoDeCriacao.add(anoDeCriacaoText);
		tela.add(anoDeCriacao);
		
		maxTacasText = new JTextField(40);
		maxTacas = new JPanel();
		maxTacas.setLayout(new FlowLayout());
        maxTacas.add(new JLabel("Maximo de Tacas: "));
        maxTacas.add(maxTacasText);
		tela.add(maxTacas);
		
		nomeTimeText = new JTextField(40);
		nomeTime = new JPanel();
		nomeTime.setLayout(new FlowLayout());
		nomeTime.add(new JLabel("Nome do Time: "));
		nomeTime.add(nomeTimeText);
		tela.add(nomeTime);
		
		//int maxJogadores,int anoDeCriacao, int maxTacas, String nomeTime
		salvar = new JButton("Salvar");
		salvar.addActionListener((e) -> {
			try {
                times.add(new Time(Integer.parseInt(maxJogadoresText.getText()), Integer.parseInt(anoDeCriacaoText.getText()), Integer.parseInt(maxTacasText.getText()), nomeTimeText.getText()));
				JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso");
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Time!");
			}
		});
		tela.add(salvar);
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
		return "Adicionando Time...";
	}

}

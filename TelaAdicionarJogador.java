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

public class TelaAdicionarJogador implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
    private JPanel idade;
	private JTextField idadeText;
    private JPanel nome;
	private JTextField nomeText;
	private JPanel posicao;
	private JTextField posicaoText;
    private JPanel nomeTime;
	private JTextField nomeTimeText;
	private JPanel maxCampeonatos;
	private JTextField maxCampeonatosText;
	private JButton salvar;
	private ArrayList<Jogador> jogadores;
    private ArrayList<Time> times;
	//int idade, String nome, String posicao, Time time, int maxCampeonatos
	public TelaAdicionarJogador(JMenuItem botaoOrigem, ArrayList<Jogador> jogadores, ArrayList<Time> times) {
		this.jogadores = jogadores;
		this.times = times;
        this.botaoOrigem = botaoOrigem;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		idadeText = new JTextField(40);
		idade = new JPanel();
		idade.setLayout(new FlowLayout());
		idade.add(new JLabel("Idade: "));
		idade.add(idadeText);
		tela.add(idade);

		nomeText = new JTextField(40);
        nome = new JPanel();
        nome.setLayout(new FlowLayout());
        nome.add(new JLabel("Nome: "));
        nome.add(nomeText);
		tela.add(nome);

		posicaoText = new JTextField(40);
		posicao = new JPanel();
		posicao.setLayout(new FlowLayout());
		posicao.add(new JLabel("Posicao: "));
		posicao.add(posicaoText);
		tela.add(posicao);

		nomeTimeText = new JTextField(40);
        nomeTime = new JPanel();
        nomeTime.setLayout(new FlowLayout());
        nomeTime.add(new JLabel("Nome do Time: "));
        nomeTime.add(nomeTimeText);
		tela.add(nomeTime);
		
		maxCampeonatosText = new JTextField(40);
		maxCampeonatos = new JPanel();
		maxCampeonatos.setLayout(new FlowLayout());
		maxCampeonatos.add(new JLabel("Max de campeonatos: "));
		maxCampeonatos.add(maxCampeonatosText);
		tela.add(maxCampeonatos);

		//int idade, String nome, String posicao, Time time, int maxCampeonatos
		
		salvar = new JButton("Salvar");
		salvar.addActionListener((e) -> {
			boolean achou = false;
			try {
                for(int i = 0; i < times.size(); i++) {
                	if(times.get(i).getNomeTime().equals(nomeTimeText.getText())) {
                		jogadores.add(new Jogador(Integer.parseInt(idadeText.getText()), nomeText.getText(), posicaoText.getText(), times.get(i), Integer.parseInt(maxCampeonatosText.getText())));
                		achou = true;
                		break;
                	}
                }
                if(achou) {
                	JOptionPane.showMessageDialog(null, "Jogador salvo com sucesso");
                }
                else {
                	JOptionPane.showMessageDialog(null, "Time do jogador nao encontrado, digite novamente");
                }
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Jogador");
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
		return "Adcionando Jogador...";
	}

}

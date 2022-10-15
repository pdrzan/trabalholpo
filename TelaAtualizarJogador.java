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

public class TelaAtualizarJogador implements Tela {

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
	private JPanel idadePara;
	private JTextField idadeTextPara;
    private JPanel nomePara;
	private JTextField nomeTextPara;
	private JPanel posicaoPara;
	private JTextField posicaoTextPara;
    private JPanel nomeTimePara;
	private JTextField nomeTimeTextPara;
	private JButton salvar;
	private ArrayList<Jogador> jogadores;
    private ArrayList<Time> times;
	//int idade, String nome, String posicao, Time time, int maxCampeonatos
	public TelaAtualizarJogador(JMenuItem botaoOrigem, ArrayList<Jogador> jogadores, ArrayList<Time> times) {
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
		
		idadeTextPara = new JTextField(40);
		idadePara = new JPanel();
		idadePara.setLayout(new FlowLayout());
		idadePara.add(new JLabel("Idade para: "));
		idadePara.add(idadeTextPara);
		tela.add(idadePara);

		nomeTextPara = new JTextField(40);
        nomePara = new JPanel();
        nomePara.setLayout(new FlowLayout());
        nomePara.add(new JLabel("Nome para: "));
        nomePara.add(nomeTextPara);
		tela.add(nomePara);

		posicaoTextPara = new JTextField(40);
		posicaoPara = new JPanel();
		posicaoPara.setLayout(new FlowLayout());
		posicaoPara.add(new JLabel("Posicao para: "));
		posicaoPara.add(posicaoTextPara);
		tela.add(posicaoPara);

		nomeTimeTextPara = new JTextField(40);
        nomeTimePara = new JPanel();
        nomeTimePara.setLayout(new FlowLayout());
        nomeTimePara.add(new JLabel("Nome do Time para: "));
        nomeTimePara.add(nomeTimeTextPara);
		tela.add(nomeTimePara);
		//int idade, String nome, String posicao, Time time, int maxCampeonatos
		
		salvar = new JButton("Salvar");
		salvar.addActionListener((e) -> {
			try {
				boolean achou = false;
                for(int i = 0; i < times.size(); i++) {
                	if(times.get(i).getNomeTime().equals(nomeTimeText.getText())) {
                		for(int j = 0; j < jogadores.size(); j++) {
                			if(jogadores.get(j).getTime().equals(times.get(i)) && jogadores.get(j).getPosicao().equals(posicaoText.getText()) && jogadores.get(j).getNome().equals(nomeText.getText()) && jogadores.get(j).getIdade() == Integer.parseInt(idadeText.getText())) {
                				jogadores.get(j).setIdade(Integer.parseInt(idadeTextPara.getText()));
                				jogadores.get(j).setNome(nomeTextPara.getText());
                				jogadores.get(j).setTime(times.get(i));
                				jogadores.get(j).setPosicao(posicaoTextPara.getText());
                				achou = true;
                			}
                		}
                		break;
                	}
                }
                if(achou) {
                	JOptionPane.showMessageDialog(null, "Jogador atualizado com sucesso");
                }
                else {
                	JOptionPane.showMessageDialog(null, "Jogador nao encontrado");
                }
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Jogador!");
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
		return "Atualizando Jogador...";
	}

}

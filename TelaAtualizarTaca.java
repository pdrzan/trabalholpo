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

public class TelaAtualizarTaca implements Tela {

	private JPanel tela;
	private JMenuItem botaoOrigem;
    private JPanel nomeCampeonato;
	private JTextField nomeCampeonatoText;
	private JPanel nomeCampeonatoPara;
	private JTextField nomeCampeonatoTextPara;
    private JPanel nomeTime;
	private JTextField nomeTimeText;
	private JPanel ano;
	private JTextField anoText;
	private JPanel anoPara;
	private JTextField anoTextPara;
	private JButton atualizar;
	private ArrayList<Partida> partidas;
    private ArrayList<Campeonato> campeonatos;
    private ArrayList<Taca> tacas;
    private ArrayList<Time> times;
	
	public TelaAtualizarTaca(JMenuItem botaoOrigem, ArrayList<Taca> tacas, ArrayList<Campeonato> campeonatos, ArrayList<Time> times) {
		this.campeonatos = campeonatos;
        this.botaoOrigem = botaoOrigem;
        this.tacas = tacas;
        this.times = times;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		nomeCampeonatoText = new JTextField(40);
		nomeCampeonato = new JPanel();
		nomeCampeonato.setLayout(new FlowLayout());
		nomeCampeonato.add(new JLabel("Nome do Campeonato: "));
		nomeCampeonato.add(nomeCampeonatoText);
		tela.add(nomeCampeonato);

		anoText = new JTextField(40);
		ano = new JPanel();
		ano.setLayout(new FlowLayout());
		ano.add(new JLabel("Ano correspondente: "));
		ano.add(anoText);
		tela.add(ano);
		
		nomeTimeText = new JTextField(40);
		nomeTime = new JPanel();
		nomeTime.setLayout(new FlowLayout());
		nomeTime.add(new JLabel("Mudar o ganhador para: "));
		nomeTime.add(nomeTimeText);
		tela.add(nomeTime);
		
		nomeCampeonatoTextPara = new JTextField(40);
		nomeCampeonatoPara = new JPanel();
		nomeCampeonatoPara.setLayout(new FlowLayout());
		nomeCampeonatoPara.add(new JLabel("Nome do Campeonato para: "));
		nomeCampeonatoPara.add(nomeCampeonatoTextPara);
		tela.add(nomeCampeonatoPara);

		anoTextPara = new JTextField(40);
		anoPara = new JPanel();
		anoPara.setLayout(new FlowLayout());
		anoPara.add(new JLabel("Ano correspondente para: "));
		anoPara.add(anoTextPara);
		tela.add(anoPara);
		
		atualizar = new JButton("Atualizar");
		atualizar.addActionListener((e) -> {
			boolean achou = false;
			try {
				for(int i = 0; i < tacas.size(); i++ ) {
					if( tacas.get(i).getCampeonato().getNomeCampeonato().equals(nomeCampeonatoText.getText()) && tacas.get(i).getAno() == Integer.parseInt(anoText.getText())) {
						
						for(int j = 0; j < times.size(); j++) {
							if(times.get(j).getNomeTime().equals(nomeTimeText.getText())) {
								tacas.get(i).setTimeGanhador(times.get(j));
								achou = true;
								break;
							}
						}
						if(!achou) {
							break;
						}
						for(int j = 0; j < campeonatos.size() ; j++) {
							if(campeonatos.get(j).getNomeCampeonato().equals(nomeCampeonatoTextPara.getText())) {
								tacas.get(i).setCampeonato(campeonatos.get(j));
								achou = true;
								break;
							}
						}
						tacas.get(i).setAno(Integer.parseInt(anoTextPara.getText()));
						break;
					}
				}
				if(achou) {
					JOptionPane.showMessageDialog(null, "Taca atualizada com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Taca nao encontrada");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para a Taca!");
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
		return "Atualizando Taca...";
	}

}
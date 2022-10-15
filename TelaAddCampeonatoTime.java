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

public class TelaAddCampeonatoTime implements Tela {

	private JMenuItem botaoOrigem;
	private JPanel tela;
	private ArrayList<Campeonato> campeonatos;
    private JPanel nomeCampeonato;
	private JTextField nomeCampeonatoText;
	private JPanel nomeTime;
	private JTextField nomeTimeText;
	private JButton adicionar;
	private ArrayList<Time> times;
	
	public TelaAddCampeonatoTime(JMenuItem botaoOrigem, ArrayList<Campeonato> campeonatos, ArrayList<Time> times) {
		this.botaoOrigem = botaoOrigem;
		this.campeonatos = campeonatos;
		this.times = times;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		nomeCampeonatoText = new JTextField(40);
		nomeCampeonato = new JPanel();
		nomeCampeonato.setLayout(new FlowLayout());
		nomeCampeonato.add(new JLabel("Nome do Campeonato: "));
		nomeCampeonato.add(nomeCampeonatoText);
		tela.add(nomeCampeonato);
		
		nomeTimeText = new JTextField(40);
		nomeTime = new JPanel();
		nomeTime.setLayout(new FlowLayout());
		nomeTime.add(new JLabel("Nome do Time: "));
		nomeTime.add(nomeTimeText);
		tela.add(nomeTime);
		
		adicionar = new JButton("Atualizar");
		adicionar.addActionListener((e) -> {
			boolean achou = false;
			try {
				for(int i = 0; i < campeonatos.size(); i++ ) {
					if(campeonatos.get(i).getNomeCampeonato().equals(nomeCampeonatoText.getText())) {
						for(int j = 0; j < times.size();j++ ) {
							if(times.get(j).getNomeTime().equals(nomeTimeText.getText())) {
								campeonatos.get(i).adicionaTime(times.get(j));
								achou = true;
								break;
							}
						}
						break;
					}
				}
				if(achou) {
					JOptionPane.showMessageDialog(null, "Time adicionado com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Time/Campeonato nao encontrado");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Campeonato/Time!");
			}
		});
		
	tela.add(adicionar);
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
		return "Adicionando Time ao Campeonato...";
	}

}

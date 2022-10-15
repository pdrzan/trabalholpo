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

public class TelaRemoverCampeonato implements Tela {
	
	private JMenuItem botaoOrigem;
	ArrayList<Campeonato> campeonatos;
	private JPanel tela;
    private JPanel nomeCampeonato;
	private JTextField nomeCampeonatoText;
	private JButton remover;

	public TelaRemoverCampeonato(JMenuItem botaoOrigem, ArrayList<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
		this.botaoOrigem = botaoOrigem;
		
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		nomeCampeonatoText = new JTextField(40);
		nomeCampeonato = new JPanel();
		nomeCampeonato.setLayout(new FlowLayout());
		nomeCampeonato.add(new JLabel("Nome do Campeonato: "));
		nomeCampeonato.add(nomeCampeonatoText);
		tela.add(nomeCampeonato);
		
		remover = new JButton("Remover");
		remover.addActionListener((e) -> {
			boolean encontrado = false;
			try {
				for(int i = 0; i < campeonatos.size(); i++ ) {
					if(nomeCampeonatoText.getText().equals(campeonatos.get(i).getNomeCampeonato()) && campeonatos.get(i) != null) {
						campeonatos.remove(i);
						encontrado = true;
						break;
					}
				}
				if(encontrado) {
					JOptionPane.showMessageDialog(null, "Campeonato removido com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Campeonato nao encontrado");
				}
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para o Campeonato!");
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
		return "Removendo Campeonato...";
	}

}

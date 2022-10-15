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

public class TelaAdicionarPartida implements Tela{
    private JPanel tela;
	private JMenuItem botaoOrigem;
    private JPanel cadastrarCestasTime1;
	private JTextField cestasTime1;
    private JPanel cadastrarCestasTime2;
	private JTextField cestasTime2;
	private JPanel cadastrarTime1;
	private JTextField time1;
    private JPanel cadastrarTime2;
	private JTextField time2;
	private JPanel cadastrarDataPartida;
	private JTextField dataPartida;
	private JPanel cadastrarCampeonato;
	private JTextField campeonato;
	private JButton salvar;
	private ArrayList<Partida> partidas;
    private ArrayList<Campeonato> campeonatos;
	
	public TelaAdicionarPartida(JMenuItem botaoOrigem, ArrayList<Partida> partidas, ArrayList<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
        this.botaoOrigem = botaoOrigem;
		this.partidas = partidas;
		tela = new JPanel();
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		cestasTime1 = new JTextField(40);
		cadastrarCestasTime1 = new JPanel();
		cadastrarCestasTime1.setLayout(new FlowLayout());
		cadastrarCestasTime1.add(new JLabel("Cestas primeiro time: "));
		cadastrarCestasTime1.add(cestasTime1);
		tela.add(cadastrarCestasTime1);

        cestasTime2 = new JTextField(40);
		cadastrarCestasTime2 = new JPanel();
		cadastrarCestasTime2.setLayout(new FlowLayout());
		cadastrarCestasTime2.add(new JLabel("Cestas primeiro time: "));
		cadastrarCestasTime2.add(cestasTime2);
		tela.add(cadastrarCestasTime2);

		time1 = new JTextField(40);
		cadastrarTime1 = new JPanel();
		cadastrarTime1.setLayout(new FlowLayout());
		cadastrarTime1.add(new JLabel("Time 1: "));
		cadastrarTime1.add(time1);
		tela.add(cadastrarTime1);

        time2 = new JTextField(40);
		cadastrarTime2 = new JPanel();
		cadastrarTime2.setLayout(new FlowLayout());
		cadastrarTime2.add(new JLabel("Time 2: "));
		cadastrarTime2.add(time2);
		tela.add(cadastrarTime2);
		
		dataPartida = new JTextField(40);
		cadastrarDataPartida = new JPanel();
		cadastrarDataPartida.setLayout(new FlowLayout());
		cadastrarDataPartida.add(new JLabel("Data da Partida: "));
		cadastrarDataPartida.add(dataPartida);
		tela.add(cadastrarDataPartida);

        campeonato = new JTextField(40);
		cadastrarCampeonato = new JPanel();
		cadastrarCampeonato.setLayout(new FlowLayout());
		cadastrarCampeonato.add(new JLabel("Nome Campeonato: "));
		cadastrarCampeonato.add(campeonato);
		tela.add(cadastrarCampeonato);
		
		salvar = new JButton("Salvar");
		salvar.addActionListener((e) -> {
			boolean achou = false;
			try {
                Campeonato campeonato1 = null;
                for(int i = 0; i < campeonatos.size(); i++){
                    if(campeonatos.get(i).getNomeCampeonato().equals(campeonato.getText())){
                        campeonato1 = campeonatos.get(i);
                        achou = true;
                        partidas.add(new Partida(time1.getText(), time2.getText(), dataPartida.getText(), campeonato1 , "Time 1: " + cestasTime1.getText() + " X " + "Time 2: " + cestasTime2.getText()));
                        break;
                    }
                }
                if(achou) {
                	JOptionPane.showMessageDialog(null, "Partida salva com sucesso");
                }
                else {
                	JOptionPane.showMessageDialog(null, "Campeonato nao encontrado");
                }
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Parâmetros inválidos para a Partida!");
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
		return "Adicionando Partida...";
	}

}

package a;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;


public class Basquete extends JFrame{
    private JMenuBar barra = new JMenuBar();

    private JMenu partida = new JMenu("Partida");
    private JMenu campeonato = new JMenu("Campeonato");
    private JMenu taca = new JMenu("Taca");
    private JMenu time = new JMenu("Time");
    private JMenu jogador = new JMenu("Jogador");

    private JMenuItem partida1 = new JMenuItem("Adicionar Partida");
    private JMenuItem partida2 = new JMenuItem("Remover Partida");
    private JMenuItem partida3 = new JMenuItem("Atualizar Partida");
    private JMenuItem partida4 = new JMenuItem("Listar Partidas");

    private JMenuItem jogador1 = new JMenuItem("Adicionar Jogador");
    private JMenuItem jogador2 = new JMenuItem("Remover Jogador");
    private JMenuItem jogador3 = new JMenuItem("Atualizar Jogador");
    private JMenuItem jogador4 = new JMenuItem("Listar Jogadores");
    private JMenuItem jogador5 = new JMenuItem("Adicionar Campeonato ao Jogador");

    private JMenuItem taca1 = new JMenuItem("Adicionar Taca");
    private JMenuItem taca2 = new JMenuItem("Remover Taca");
    private JMenuItem taca3 = new JMenuItem("Atualizar Taca");
    private JMenuItem taca4 = new JMenuItem("Listar Tacas");
 
    private JMenuItem time1 = new JMenuItem("Adicionar Time");
    private JMenuItem time2 = new JMenuItem("Remover Time");
    private JMenuItem time3 = new JMenuItem("Atualizar Time");
    private JMenuItem time4 = new JMenuItem("Listar Times");

    private JMenuItem campeonato1 = new JMenuItem("Adicionar Campeonato");
    private JMenuItem campeonato2 = new JMenuItem("Remover Campeonato");
    private JMenuItem campeonato4 = new JMenuItem("Listar Campeonatos");
    private JMenuItem campeonato5 = new JMenuItem("Adicionar Jogador ao Campeonato");
    private JMenuItem campeonato6 = new JMenuItem("Adiciona Time ao Campeonato");

    private JTextField caixa = new JTextField(10);
    
    private ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
    private ArrayList<Time> times = new ArrayList<Time>();
    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    private ArrayList<Partida> partidas = new ArrayList<Partida>();
    private ArrayList<Taca> tacas = new ArrayList<Taca>();

    private ArrayList<Tela> telas = new ArrayList<Tela>();
	private Tela telaAtual;

    private JLabel status = new JLabel("Status");

    public Basquete(){
        setJMenuBar(barra);
        barra.add(partida);
        barra.add(campeonato);
        barra.add(taca);
        barra.add(time);
        barra.add(jogador);
        
        partida.add(partida1);
        partida.add(partida2);
        partida.add(partida3);
        partida.add(partida4);


        campeonato.add(campeonato1);
        campeonato.add(campeonato2);
        campeonato.add(campeonato4);
        campeonato.add(campeonato5);
        campeonato.add(campeonato6);

        taca.add(taca1);
        taca.add(taca2);
        taca.add(taca3);
        taca.add(taca4);

        time.add(time1);
        time.add(time2);
        time.add(time3);
        time.add(time4);

        jogador.add(jogador1);
        jogador.add(jogador2);
        jogador.add(jogador3);
        jogador.add(jogador4);
        jogador.add(jogador5);

		add(status, BorderLayout.SOUTH);

        telas.add(new TelaAdicionarPartida(partida1, partidas, campeonatos));
		telas.add(new TelaRemoverPartida(partida2, partidas));
        telas.add(new TelaAtualizarPartida(partida3, partidas));
        telas.add(new TelaListarPartida(partida4, partidas));

        telas.add(new TelaAdicionarCampeonato(campeonato1, campeonatos));
		telas.add(new TelaRemoverCampeonato(campeonato2, campeonatos));
        telas.add(new TelaListarCampeonato(campeonato4, campeonatos));
        telas.add(new TelaAddCampeonatoJogador(campeonato5, campeonatos, jogadores));
        telas.add(new TelaAddCampeonatoTime(campeonato6, campeonatos, times));

        telas.add(new TelaAdicionarTaca(taca1, tacas, campeonatos, times));
		telas.add(new TelaRemoverTaca(taca2, tacas, campeonatos, times));
        telas.add(new TelaAtualizarTaca(taca3, tacas, campeonatos, times));
        telas.add(new TelaListarTaca(taca4, tacas));

        telas.add(new TelaAdicionarJogador(jogador1, jogadores, times));
		telas.add(new TelaRemoverJogador(jogador2, jogadores, times));
        telas.add(new TelaAtualizarJogador(jogador3, jogadores, times));
        telas.add(new TelaListarJogador(jogador4, jogadores));
        telas.add(new TelaAddJogadorCampeonato(jogador5, jogadores, campeonatos));

        telas.add(new TelaAdicionarTime(time1, times));
		telas.add(new TelaRemoverTime(time2, times));
        telas.add(new TelaAtualizarTime(time3, times));
        telas.add(new TelaListarTime(time4, times));

        ActionListener listenerPadrao = ((e) -> {
			if(telaAtual != null)
				remove(telaAtual.getTela());
			
			for(int i = 0 ; i < telas.size() ; i++) {
				if(telas.get(i).getSource().equals(e.getSource())) {
					telaAtual = telas.get(i);
					break;
				}
			}
			add(telaAtual.getTela(), BorderLayout.CENTER);
			status.setText(telaAtual.getMensagemStatus());
			setVisible(true);
		});
        partida1.addActionListener(listenerPadrao);
		partida2.addActionListener(listenerPadrao);
        partida3.addActionListener(listenerPadrao);
		partida4.addActionListener(listenerPadrao);

        taca1.addActionListener(listenerPadrao);
		taca2.addActionListener(listenerPadrao);
        taca3.addActionListener(listenerPadrao);
		taca4.addActionListener(listenerPadrao);

        jogador1.addActionListener(listenerPadrao);
		jogador2.addActionListener(listenerPadrao);
        jogador3.addActionListener(listenerPadrao);
		jogador4.addActionListener(listenerPadrao);
		jogador5.addActionListener(listenerPadrao);

        campeonato1.addActionListener(listenerPadrao);
		campeonato2.addActionListener(listenerPadrao);
		campeonato4.addActionListener(listenerPadrao);
		campeonato5.addActionListener(listenerPadrao);
		campeonato6.addActionListener(listenerPadrao);

        time1.addActionListener(listenerPadrao);
		time2.addActionListener(listenerPadrao);
        time3.addActionListener(listenerPadrao);
		time4.addActionListener(listenerPadrao);

        setTitle("Menu");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

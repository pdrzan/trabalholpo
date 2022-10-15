package a;

public class Campeonato{
	  private Jogador[] jogadores;
	  private String nomeCampeonato;
	  private Time[] times;
	  private Taca taca;
	  private Partida[] partidas;
	  private int quantidadeTime = 0;
	  private int quantidadeJogador = 0;
	  private int quantidadePartida = 0;

	  public Campeonato(int maxJogadores, int maxTimes, int maxPartidas, String nomeCampeonato){
	    times = new Time[maxTimes];
	    jogadores = new Jogador[maxJogadores];
	    partidas = new Partida[maxPartidas];
	    setNomeCampeonato(nomeCampeonato);
	  }
	  
	  public void setTaca(Taca taca){
	    this.taca = taca;
	  }
	  
	  public Taca getTaca(){
	    return taca;
	  }

	  public void adicionaTime(Time time){
	    this.times[quantidadeTime] = time;
	    quantidadeTime++;
	    
	  }

	  public void adicionaPartida(Partida partida){
	    this.partidas[quantidadePartida] = partida;
	    quantidadePartida++;
	  }

	  public void setNomeCampeonato(String nomeCampeonato){
	    this.nomeCampeonato = nomeCampeonato;
	  }

	  public String getNomeCampeonato(){
	    return nomeCampeonato;
	  }

	  public void adicionaJogador(Jogador jogador){
	    jogadores[quantidadeJogador] = jogador;
	    quantidadeJogador++;
	    jogador.adicionaCampeonatos(this);
	  }

	  public int getQuantidadeJogador(){
	    return quantidadeJogador;
	  }

	  public int getQuantidadeTime(){
	    return quantidadeTime;
	  }
	  
	  @Override
	  public String toString() {
		return "Campeonato: " + nomeCampeonato;
	  }
	}
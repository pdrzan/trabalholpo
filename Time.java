package a;

public class Time{
    private Jogador[] jogadores;
    private Taca[] tacas;
    private String nomeTime;
    private int anoDeCriacao;
    private int quantidadeTaca = 0;
    private int quantidadeJogador = 0;

    public Time(int maxJogadores,int anoDeCriacao, int maxTacas, String nomeTime){
        jogadores = new Jogador[maxJogadores];
        setAnoDeCriacao(anoDeCriacao);
        tacas = new Taca[maxTacas];
        setNomeTime(nomeTime);
    }
    public void setNomeTime(String nomeTime) {
    	this.nomeTime = nomeTime;
    }
    
    public String getNomeTime() {
    	return nomeTime;
    }
    
    public void adicionaJogador(Jogador jogador){
      this.jogadores[quantidadeJogador] = jogador;
      quantidadeJogador++;
    }
    public void setAnoDeCriacao(int anoDeCriacao){
        this.anoDeCriacao = anoDeCriacao;
    }
  
    public void adicionaTaca(Taca taca){
      tacas[quantidadeTaca] = taca;
      quantidadeTaca++;
    }
    public int getAnoDeCriacao(){
      return anoDeCriacao;
    }
    
    @Override
	public String toString() {
		return "Time = Nome: " + nomeTime + "/ AnoCriacao: " + anoDeCriacao + "/ Quantidade de Tacas: " + quantidadeTaca + "/ Quantidade de Jogadores: " + quantidadeJogador;
	}
    
}
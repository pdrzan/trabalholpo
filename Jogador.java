package a;

public class Jogador {
    private int idade;
    private String nome;
    private String posicao;
    private Campeonato[] campeonatos;
    private int quantidadeCampeonato =0;
    private Time time;

    public Jogador(int idade, String nome, String posicao, Time time, int maxCampeonatos){
        setIdade(idade);
        setNome(nome);
        setPosicao(posicao);
        setTime(time);
        campeonatos = new Campeonato[maxCampeonatos];
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPosicao(String posicao){
        this.posicao = posicao;
    }

    public int getIdade(){
        return idade;
    }
    public String getNome(){
        return nome;
    }
    
    public String getPosicao(){
        return posicao;
    }
    public void adicionaCampeonatos(Campeonato campeonato){
    	boolean temJa = false;
    	for(int i = 0; i< quantidadeCampeonato; i++) {
    	  if(campeonatos[i].equals(campeonato)) {
    		  temJa = true;
    		  break;
    	  }
    	}
    	if(!temJa) {
    		campeonatos[quantidadeCampeonato] = campeonato;
    		quantidadeCampeonato++;
    	}
    }
    public void setTime(Time time){
      this.time = time;
      time.adicionaJogador(this);
    }

    public Time getTime(){
      return time;
    }
    
    @Override
	public String toString() {
		return "Jogador = Nome: " + nome + "/ Posicao: " + posicao + "/ Idade: " + idade + "/ Time: " + time.getNomeTime();
	}


}

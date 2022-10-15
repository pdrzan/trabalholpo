package a;

public class Taca{
    private Campeonato campeonato;
    private int ano;
    private Time timeGanhador;
    public Taca(Campeonato campeonato, int ano, Time timeGanhador){
        setCampeonato(campeonato);
        setAno(ano);
        setTimeGanhador(timeGanhador);
    }
    public void setCampeonato(Campeonato campeonato){
      this.campeonato = campeonato;
      campeonato.setTaca(this);
    }
    public void setAno(int ano){
        this.ano = ano;
    }
    public void setTimeGanhador(Time timeGanhador){
        this.timeGanhador = timeGanhador;
        timeGanhador.adicionaTaca(this);
    }

    public int getAno(){
        return ano;
    }

    public Time getGanhador(){
      return timeGanhador;
    }

    public Campeonato getCampeonato(){
      return campeonato;
    }
    
    @Override
	public String toString() {
		return "Taca = Ano: " + ano + "/ Campeonato: " + campeonato.getNomeCampeonato();
	}
}
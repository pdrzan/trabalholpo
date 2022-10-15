package a;

public class Partida{
    private String time1;
    private String time2;
    private String dataPartida;
    private Campeonato campeonato;
    private String resultado;
    
    public Partida(String time1, String time2, String  dataPartida, Campeonato campeonato, String resultado){
        setTime1(time1);
        setTime2(time2);
        setDataPartida(dataPartida);
        setCampeonato(campeonato);
        setResultado(resultado);
    }

    public void setResultado(String resultado){
      this.resultado = resultado;
    }

    public String getResultado(){
      return resultado;
    }
    
    public void setTime1( String time1) {
        this.time1= time1;
    }
    
    public void setTime2( String time2) {
        this.time2= time2;
    }
    
    public void setDataPartida( String dataPartida) {
        this.dataPartida= dataPartida;
    }
    
    public void setCampeonato(Campeonato campeonato) {
        this.campeonato= campeonato;
        campeonato.adicionaPartida(this);
    }
    public Campeonato getCampeonato() {
        return campeonato;
    }
    public String getTime1(){
        return time1;
    }
    public String getTime2(){
        return time2;
    }
    public String getDataPartida(){
        return dataPartida;
    }
    
    @Override
	public String toString() {
		return "Partida = Time 1: " + time1 + "/ Time 2: " + time2 + "/ Resultado: " + resultado + "/ Data da Partida: " + dataPartida + "/ Campeonato: " + campeonato.getNomeCampeonato();
	}
   
}
import java.util.ArrayList;
public class Castelo {
	public int id;
	public int soldados;
	public ArrayList<Integer> estradas;
	public boolean conquistado;
	public Castelo(int id,int soldados){
		this.id = id;
		this.soldados = soldados;
		conquistado=false;
		estradas = new ArrayList<Integer>();
	}
	@Override
	public String toString(){
		return "Castelo: "+id+"     Numero soldados: "+soldados + "     Estradas:  "+estradas;
	}
}
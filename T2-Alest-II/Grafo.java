import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Grafo{
	private Lista castelos = new Lista();	
	private int maxCastelos;
	int soldados;
	ArrayList<Integer> caminho = new ArrayList<Integer>();
	public Grafo(String a) throws FileNotFoundException{
		this.maxCastelos=0;
		File arq = new File(a);
		Scanner in = new Scanner(arq);
		Castelo principal = new Castelo(0,in.nextInt()-50);
		principal.conquistado=true;
		this.soldados = principal.soldados;
		castelos.add(principal);
		int Ncastelos = in.nextInt();
		int arestas = in.nextInt();
		while(Ncastelos+arestas > 0){
			if(Ncastelos>0){
                Castelo atual = new Castelo(in.nextInt(),in.nextInt());
                castelos.add(atual);
                Ncastelos--;
			}
                else if(arestas>0){
                    int de = in.nextInt();
                    int para = in.nextInt();
                    castelos.get(de).estradas.add(para);
                    castelos.get(para).estradas.add(de);
                    arestas--;
                    
                }
                        
		}
	}
	public void printAllNodes(){
		for(int i = 0;i<castelos.size();i++){
			System.out.println(castelos.get(i));
		}
	}
	public Lista getCastelos(){return castelos;}
	public int getMaxCastelos(){return maxCastelos;}
	public ArrayList<Integer> getCaminho(){return caminho;}
	public void calculaMaxCastelos(Castelo c,ArrayList<Integer> caminhoAtual){
		for(int i=0;i<c.estradas.size();i++){
			Castelo teste = castelos.get(c.estradas.get(i));
			if(!teste.conquistado){				
				int soldadosNecessarios = (teste.soldados*2)+50;
				if(soldados>=soldadosNecessarios){
					soldados-=soldadosNecessarios;
					castelos.get(c.estradas.get(i)).conquistado=true;
					caminhoAtual.add(castelos.get(c.estradas.get(i)).id);
					int conquistados = caminhoAtual.size()-1;
					if(conquistados>maxCastelos){
						maxCastelos=conquistados;
						acheiOCaminho(caminhoAtual);
					}
					//System.out.println(teste.id+"  "+soldados+"  "+conquistados);
					calculaMaxCastelos(castelos.get(c.estradas.get(i)),caminhoAtual);
				}
			}
		}
		c.conquistado=false;
		caminhoAtual.remove((Integer)c.id);
		soldados+=(c.soldados*2)+50;
	}
	public void acheiOCaminho(ArrayList<Integer> v){
		caminho.clear();
		for(Integer i:v)caminho.add(i);
	}
	public int qtdConquistados(){
		int res=0;
		for(int i = 1;i<castelos.size();i++)if(castelos.get(i).conquistado)res++;
		return res;
	}
}


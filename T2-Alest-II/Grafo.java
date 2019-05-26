import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Grafo{
	private Lista castelos = new Lista();	
	private int maxCastelos;
	private int jeitos;
	int soldados;
	public Grafo(String a) throws FileNotFoundException{
		this.maxCastelos=0;
		this.jeitos=1;
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
	public int getJeitos(){return jeitos;}
	public void calculaMaxCastelos(Castelo c){
		for(int i=0;i<c.estradas.size();i++){
			Castelo teste = castelos.get(c.estradas.get(i));
			if(!teste.conquistado){				
				int soldadosNecessarios = (teste.soldados*2)+50;
				if(soldados>=soldadosNecessarios){
					soldados-=soldadosNecessarios;
					castelos.get(c.estradas.get(i)).conquistado=true;
					int conquistados = qtdConquistados();
					if(conquistados>maxCastelos)maxCastelos=conquistados;
					else if(conquistados==maxCastelos)jeitos++;
					//System.out.println(teste.id+"  "+soldados+"  "+conquistados);
					calculaMaxCastelos(castelos.get(c.estradas.get(i)));
				}
			}
		}
		c.conquistado=false;
		soldados+=(c.soldados*2)+50;
	}
	public int qtdConquistados(){
		int res=0;
		for(int i = 1;i<castelos.size();i++)if(castelos.get(i).conquistado)res++;
		return res;
	}
}

/*
	djikstra(Grafo g, castelo c){
		para cada castelo v de g:
			hashmap D[v] = infinity;
			hashmap P[v] = null;
		D[c] = 0;
		lista Q = todos castelos de g;

		enquanto Q.size>0:
			c=retiramin(Q);

			para cada vizinho v de c:
				se D[c]+peso(c,v)<D[v]:
					D[v]=D[c]+peso(c,v);
					P[v]=c;
	}

	retiramin(lista Q, hashmap D){
		castelo min = Q[0];
		for(int i = 1;i<Q.size();i++){
			if(D[Q[i]] < D[min]) min = Q[i];
		}
		Q.remove(min);
		return min;
	}
*/


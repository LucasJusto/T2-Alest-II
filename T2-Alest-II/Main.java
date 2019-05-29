import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args)throws FileNotFoundException{
		Scanner usr = new Scanner(System.in);
		System.out.println("Digite o diretorio do arquivo: ");
		String arq = usr.next();
		Grafo grafo = new Grafo(arq);
		//grafo.printAllNodes();
		Lista todosCastelos = grafo.getCastelos();
		Castelo fragolleto = todosCastelos.get(0);
		long initialTime = System.currentTimeMillis(); //comeco do algoritmo
		ArrayList<Integer> caminhoAtual = new ArrayList<Integer>();
		caminhoAtual.add(0);
		grafo.calculaMaxCastelos(fragolleto,caminhoAtual);
		int maxCastelos = grafo.getMaxCastelos();
		long finalTime = System.currentTimeMillis();
		long duration = finalTime-initialTime;
		System.out.println("Caso: " +arq.substring(6,arq.length())+"   Resposta: "+maxCastelos+"   Caminho: "+grafo.getCaminho()+"   Tempo: "+duration+"ms");
	}
}

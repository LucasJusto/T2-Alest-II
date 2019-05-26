import java.util.Scanner;
import java.io.FileNotFoundException;
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
		grafo.calculaMaxCastelos(fragolleto);
		int maxCastelos = grafo.getMaxCastelos();
		int jeitos = grafo.getJeitos();
		long finalTime = System.currentTimeMillis();
		long duration = finalTime-initialTime;
		System.out.println("Caso: " +arq.substring(6,arq.length())+"   Resposta: "+maxCastelos+"   Tempo: "+duration+"ms");
	}
}
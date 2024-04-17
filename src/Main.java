import java.util.Scanner;

import model.ListaProcesso;
import model.Processo;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de processos:");
        int qtProcessos = scanner.nextInt();

        System.out.println("Digite o quantum:");
        int quantum = scanner.nextInt();

        ListaProcesso listaProcesso = new ListaProcesso(quantum);

        // Criando os processos e adicionando à lista
        for (int i = 1; i <= qtProcessos; i++) {
            System.out.println("Digite o burst time para o processo P" + i + ":");
            int bt = scanner.nextInt();
            listaProcesso.adicionarProcesso(new Processo("P" + i, 0, bt, 0));
        }

        System.out.println("\nExecutando Round Robin...\n");

        // Executando o algoritmo Round Robin
        listaProcesso.executarRoundRobin();

        // Imprimindo resultados
        System.out.println("Processos após o processamento:");
        listaProcesso.imprimirProcessos();
        System.out.println("\nTempo médio de espera: " + listaProcesso.calcularMediaEspera());

        scanner.close();
    }
}

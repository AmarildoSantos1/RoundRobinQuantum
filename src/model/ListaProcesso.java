package model;

import java.util.ArrayList;
import java.util.List;

public class ListaProcesso {
    private Integer quantum;
    private List<Processo> lista;

    public ListaProcesso(Integer quantum) {
        this.quantum = quantum;
        this.lista = new ArrayList<>();
    }

    public void adicionarProcesso(Processo processo) {
        lista.add(processo);
    }

    public void executarRoundRobin() {
        List<Processo> fila = new ArrayList<>(lista); // Cria uma cópia da lista de processos

        int clock = 0;
        while (!fila.isEmpty()) {
            Processo processoAtual = fila.remove(0); // Remove o primeiro processo da fila

            if (processoAtual.getBt() > 0) {
                // Executa o processo pelo quantum ou até o término do burst time
                int tempoExecutado = Math.min(quantum, processoAtual.getBt());
                processoAtual.setBt(processoAtual.getBt() - tempoExecutado);

                // Atualiza o tempo de espera dos processos na fila
                for (Processo processo : fila) {
                    processo.setTempoEspera(processo.getTempoEspera() + tempoExecutado);
                }

                clock += tempoExecutado;

                // Reinserção do processo na fila se ainda não terminou
                if (processoAtual.getBt() > 0) {
                    fila.add(processoAtual);
                }
            }
        }
    }

    public Double calcularMediaEspera() {
        double totalEspera = 0.0;
        for (Processo processo : lista) {
            totalEspera += processo.getTempoEspera();
        }
        return totalEspera / lista.size();
    }

    public void imprimirProcessos() {
        for (Processo processo : lista) {
            processo.imprimir();
        }
    }
}

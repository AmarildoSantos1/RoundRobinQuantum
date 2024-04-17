package model;

public class Processo implements Comparable<Processo> {
    private String nome;
    private Integer at;
    private Integer bt;
    private Integer tempoEspera;

    public Processo(String nome, Integer at, Integer bt, Integer tempoEspera) {
        this.nome = nome;
        this.at = at;
        this.bt = bt;
        this.tempoEspera = tempoEspera != null ? tempoEspera : 0;
    }

    public void imprimir() {
        System.out.println("*******************");
        System.out.println("NOME: " + nome);
        System.out.println("AT: " + at);
        System.out.println("BT: " + bt);
        System.out.println("TE: " + tempoEspera);
        System.out.println("*******************");
    }

    public String getNome() {
        return nome;
    }

    public Integer getAt() {
        return at;
    }

    public Integer getBt() {
        return bt;
    }

    public void setBt(Integer bt) {
        this.bt = bt;
    }

    public Integer getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(Integer tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    @Override
    public int compareTo(Processo processo) {
        return this.at.compareTo(processo.at);
    }
}

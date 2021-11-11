package Jogador;

import Clube.Clube;

import java.math.BigDecimal;

public class Jogador {
    protected String nome;
    protected int idade;
    protected Clube clubeAtual;
    protected int reputacaoHistorica;
    protected Object apetiteFinanceiro;
    protected BigDecimal preco;

    public Jogador(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, Object apetiteFinanceiro, BigDecimal preco){
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        if(reputacaoHistorica >= 1 && reputacaoHistorica <=10) {
            this.reputacaoHistorica = reputacaoHistorica;
        }
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public boolean existeInteresse(Clube x){
        return (x.reputacaoHistorica >= 1);
    }

    public void setClubeAtual(Clube clube){
        this.clubeAtual = clube;
    }


    public String getClube(){
        if(this.clubeAtual == null){
            return "_Sem_CLube";
        }
        else{
            return this.clubeAtual.nome;
        }
    }

    public Object getObjectClube(){
        if(this.clubeAtual == null){
            return null;
        }else{
            return this.clubeAtual;
        }
    }

    public int getReputacao(){
        return this.reputacaoHistorica;
    }




}

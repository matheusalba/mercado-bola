package Clube;

import java.math.BigDecimal;

public class Clube {
    public String nome;
    public int reputacaoHistorica;
    public BigDecimal saldoDisponivelEmCaixa;

    public Clube(String nome, int reputacaoHistorica, BigDecimal saldoDisponivelEmCaixa){
        this.nome=nome;
        this.reputacaoHistorica = reputacaoHistorica;
        this.saldoDisponivelEmCaixa = saldoDisponivelEmCaixa;
    }

    public int getReputacao(){
        return this.reputacaoHistorica;
    }

    public BigDecimal getSaldo(){return this.saldoDisponivelEmCaixa;}

    public String getNome(){
        return this.nome;
    }
}

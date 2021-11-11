package Jogador;

import ApetiteFinanceiro.Conservador;
import ApetiteFinanceiro.Mercenario;
import Clube.Clube;

import java.math.BigDecimal;

public class Zagueiro extends Jogador{
    public boolean idadeMaiorQueTrinta;

    public Zagueiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, Object apetiteFinanceiro, BigDecimal preco){
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
         if(idade>30){
             this.idadeMaiorQueTrinta = true;
         }else{
             this.idadeMaiorQueTrinta = false;
         }

    }
    public BigDecimal valorDeCompra(){
        BigDecimal percentualDoZagueiro = BigDecimal.valueOf(0);
        if(this.apetiteFinanceiro instanceof Conservador)
        {
            percentualDoZagueiro = BigDecimal.valueOf(0.4);
        }
        if(this.apetiteFinanceiro instanceof Mercenario){
            percentualDoZagueiro = BigDecimal.valueOf(0.8);
        }
        BigDecimal acrescimoDoApetite = (this.preco.multiply(percentualDoZagueiro).add(this.preco));
        if(this.idadeMaiorQueTrinta){
            return acrescimoDoApetite.subtract(BigDecimal.valueOf(0.2).multiply(acrescimoDoApetite));
        }else{
            return acrescimoDoApetite;
        }
    }

}

package Jogador;

import ApetiteFinanceiro.Conservador;
import ApetiteFinanceiro.Indiferente;
import ApetiteFinanceiro.Mercenario;
import Clube.Clube;


import java.math.BigDecimal;

public class Atacante extends Jogador {
    public int quantidadeGolsFeitos;

    public Atacante(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, Object apetiteFinanceiro, BigDecimal preco, int quantidadeGols) {
        super(nome, idade, clubeAtual, reputacaoHistorica,apetiteFinanceiro, preco);
        this.quantidadeGolsFeitos = quantidadeGols;
    }

    public int GetQuantidadeDeGols(){
        return this.quantidadeGolsFeitos;
    }

    public int getReputacao(){
        return this.reputacaoHistorica;
    }

    public BigDecimal valorDeCompra(){
        BigDecimal variavel = BigDecimal.valueOf(0);
        if(this.apetiteFinanceiro instanceof Conservador)
        {
            variavel = BigDecimal.valueOf(0.4);
        }
        if(this.apetiteFinanceiro instanceof Mercenario){
            variavel = BigDecimal.valueOf(0.8);
        }
        BigDecimal acrescimoDoApetite = (this.preco.multiply(variavel).add(this.preco));
        BigDecimal acrescimoDoAtacante = BigDecimal.valueOf(0.01).multiply(acrescimoDoApetite).multiply(BigDecimal.valueOf(this.quantidadeGolsFeitos));
        if(this.idade >= 30) {
            return acrescimoDoAtacante.add(acrescimoDoApetite).subtract((acrescimoDoAtacante.add(acrescimoDoApetite)).multiply(BigDecimal.valueOf(0.25)));
        }else{
            return acrescimoDoAtacante.add(acrescimoDoApetite);
        }
    }

}

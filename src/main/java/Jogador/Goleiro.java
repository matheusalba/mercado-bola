package Jogador;

import ApetiteFinanceiro.Conservador;
import ApetiteFinanceiro.Mercenario;
import Clube.Clube;
import ApetiteFinanceiro.Indiferente;
import java.math.BigDecimal;

public class Goleiro extends Jogador {
    public int quantidadeDePenaltisDefendidos;

    public Goleiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, Object apetiteFinanceiro, BigDecimal preco, int penaltisDefendidos) {
        super(nome, idade, clubeAtual, reputacaoHistorica,apetiteFinanceiro, preco);
        this.quantidadeDePenaltisDefendidos = penaltisDefendidos;
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
        BigDecimal acrescimoDoGoleiro = BigDecimal.valueOf(0.04).multiply(acrescimoDoApetite).multiply(BigDecimal.valueOf(this.quantidadeDePenaltisDefendidos));
        return acrescimoDoGoleiro.add(acrescimoDoApetite);
    }

    public int getPenaltis(){
        return this.quantidadeDePenaltisDefendidos;
    }
}

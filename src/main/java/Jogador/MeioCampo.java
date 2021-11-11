package Jogador;


import ApetiteFinanceiro.Conservador;
import ApetiteFinanceiro.Mercenario;
import Clube.Clube;

import java.math.BigDecimal;

public class MeioCampo extends Jogador{
    public MeioCampo(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, Object apetiteFinanceiro, BigDecimal preco){
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);


    }
    public BigDecimal valorDeCompra(){
        BigDecimal percentualDoMeioDeCampo = BigDecimal.valueOf(0);
        if(this.apetiteFinanceiro instanceof Conservador)
        {
            percentualDoMeioDeCampo = BigDecimal.valueOf(0.4);
        }
        if(this.apetiteFinanceiro instanceof Mercenario){
            percentualDoMeioDeCampo = BigDecimal.valueOf(0.8);
        }
        BigDecimal acrescimoDoApetite = (this.preco.multiply(percentualDoMeioDeCampo).add(this.preco));
        if(this.idade > 30){
            return acrescimoDoApetite.subtract(BigDecimal.valueOf(0.3).multiply(acrescimoDoApetite));
        }else{
            return acrescimoDoApetite;
        }
    }

    @Override
    public boolean existeInteresse(Clube x){
        if(this.reputacaoHistorica >= (x.getReputacao()+2)){
            return true;
        }else{
            return false;
        }
    }
}

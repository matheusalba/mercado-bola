package Jogador;

import ApetiteFinanceiro.Conservador;
import ApetiteFinanceiro.Mercenario;
import Clube.Clube;

import java.math.BigDecimal;

public class Lateral extends Jogador {

    public int cruzamentosAcertados;

    public Lateral(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, Object apetiteFinanceiro, BigDecimal preco, int cruzamentosCerteiros){
        super(nome,idade,clubeAtual,reputacaoHistorica,apetiteFinanceiro,preco);
        this.cruzamentosAcertados = cruzamentosCerteiros;
    }

    public BigDecimal valorDeCompra(){
        BigDecimal variavel = BigDecimal.valueOf(0);
        if (this.apetiteFinanceiro instanceof Conservador) {
            variavel = BigDecimal.valueOf(0.4);
        }
        if (this.apetiteFinanceiro instanceof Mercenario) {
            variavel = BigDecimal.valueOf(0.8);
        }
        BigDecimal acrescimoDoApetite = (this.preco.multiply(variavel).add(this.preco));
        BigDecimal acrescimoDosEscanteios = (acrescimoDoApetite.multiply(BigDecimal.valueOf(0.02)).multiply(BigDecimal.valueOf(this.cruzamentosAcertados)));

        if(this.idade > 28){
            BigDecimal valor = acrescimoDoApetite.add(acrescimoDosEscanteios);
            return valor.multiply(BigDecimal.valueOf(0.3)).add(valor);
        }

        return acrescimoDoApetite.add(acrescimoDosEscanteios);
    }

}

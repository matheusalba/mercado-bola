import ApetiteFinanceiro.Conservador;
import ApetiteFinanceiro.Indiferente;
import ApetiteFinanceiro.Mercenario;
import Clube.Clube;
import Jogador.*;
import Negociacao.Negociacao;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class Tests {
    @Test
    public void deveSerPossivelVerificarOValorDeUmZagueiroComMenosDeTrintaAnos(){
        Zagueiro Lucio = new Zagueiro("Lúcio",28,null,9,new Mercenario(),BigDecimal.valueOf(2000));
        BigDecimal valorEsperado = BigDecimal.valueOf(3600);
        Assert.assertTrue(Lucio.valorDeCompra().compareTo(valorEsperado)==0);
    }
    @Test
    public void naoDeveSerPossivelNegociarUmZagueiroPorFaltaDeCaixa(){
        Zagueiro Lucio = new Zagueiro("Lúcio",35,null,9,new Indiferente(),BigDecimal.valueOf(2000));
        Clube Palmeiras = new Clube("Palmeiras EC",5,BigDecimal.valueOf(8));
        Negociacao venda = new Negociacao();

        Assert.assertFalse(venda.negociar(Palmeiras,Lucio));
    }
    @Test
    public void deveSerPossivelNegociarUmZagueiro(){
        Zagueiro Lucio = new Zagueiro("Lúcio",35,null,9,new Indiferente(),BigDecimal.valueOf(2000));
        Clube Palmeiras = new Clube("Palmeiras EC",5,BigDecimal.valueOf(8000000));
        Negociacao venda = new Negociacao();

        Assert.assertTrue(venda.negociar(Palmeiras,Lucio));
        Assert.assertEquals(Palmeiras,Lucio.getObjectClube());
    }
    @Test
    public void deveSerPossivelNegociarUmLateralCorretamente(){
        Lateral Adriano = new Lateral("Adriano",27,null,9,new Indiferente(),BigDecimal.valueOf(1000),20);
        Clube Palmeiras = new Clube("Palmeiras EC",5,BigDecimal.valueOf(8000000));
        Negociacao venda = new Negociacao();
        Assert.assertTrue(venda.negociar(Palmeiras,Adriano));
        Assert.assertEquals(Palmeiras,Adriano.getObjectClube());
    }
    @Test
    public void deveSerPossivelVerificarAQuantidadeDePenaltisDefendidos(){
        Goleiro Ceni = new Goleiro("Rogério Ceni",26,null,10,new Conservador(),BigDecimal.valueOf(9000000),100);
        int valorEsperado = 100;
        Assert.assertEquals(Ceni.getPenaltis(),valorEsperado);
    }
    @Test
    public void deveSerPossivelVerificarCorretamenteOValorDeCompraDeUmGoleiro(){
        Goleiro Ceni = new Goleiro("Rogério Ceni",26,null,10,new Conservador(),BigDecimal.valueOf(900),100);
        BigDecimal valorEsperado = BigDecimal.valueOf(6300);
        Assert.assertTrue(Ceni.valorDeCompra().compareTo(valorEsperado)==0);
    }
    @Test
    public void deveSerPossivelVerificarOValorDeUmZagueiroIndiferenteComMaisDeTrintaAnos(){
        Zagueiro Manuel = new Zagueiro("Manuel",31,null,7,new Indiferente(),BigDecimal.valueOf(5000));
        BigDecimal valorEsperado = BigDecimal.valueOf(4000);
        Assert.assertTrue(Manuel.valorDeCompra().compareTo(valorEsperado)==0);
    }
    @Test
    public void deveSerPossivelVerificarOValorDeUmLateralIndiferente(){
        Lateral CraqueNeto = new Lateral("Neto",25,null,8,new Indiferente(),BigDecimal.valueOf(7000),12);

        BigDecimal valorEsperado = BigDecimal.valueOf(8680);
        Assert.assertTrue(CraqueNeto.valorDeCompra().compareTo(valorEsperado)==0);

    }
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {
        Negociacao venda = new Negociacao();
        Goleiro Fabio = new Goleiro("Fabio",31,null,8,new Conservador(),BigDecimal.valueOf(8),32);
        Clube Cruzeiro = new Clube("Cruzeiro Sociedade Anônima de Futebol",9,BigDecimal.valueOf(300000));

        boolean resposta = venda.negociar(Cruzeiro,Fabio);
        Assert.assertTrue(resposta);

    }
    @Test
    public void naoDeveSerPossivelNegociarUmGoleiroComUmClubeQueNaoTemSaldoEmCaixa(){
        Negociacao venda = new Negociacao();
        Goleiro Fabio = new Goleiro("Fabio",31,null,8,new Conservador(),BigDecimal.valueOf(800),32);
        Clube Cruzeiro = new Clube("Cruzeiro Sociedade Anônima de Futebol",9,BigDecimal.valueOf(30));

        boolean resposta = venda.negociar(Cruzeiro,Fabio);
        Assert.assertFalse(resposta);
    }
    @Test
    public void deveSerPossivelCalcularCorretamenteOValorDeCompraDeUmGoleiro(){
        Goleiro Fabio = new Goleiro("Fabio",31,null,8,new Conservador(),BigDecimal.valueOf(800),32);
        BigDecimal valorEsperado = BigDecimal.valueOf(2553.6);
        Assert.assertTrue(Fabio.valorDeCompra().compareTo(valorEsperado)==0);
    }
    @Test
    public void deveSerPossivelVerificarErroNoValorDoGoleiro(){
        Goleiro Fabio = new Goleiro("Fabio",31,null,8,new Conservador(),BigDecimal.valueOf(800),32);
        BigDecimal valorEsperado = BigDecimal.valueOf(2553.0);
        Assert.assertFalse(Fabio.valorDeCompra().compareTo(valorEsperado)==0);
    }
    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, new Conservador(), BigDecimal.valueOf(800500), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }
    @Test
    public void deveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMaiorQueASua(){
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 9, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 8, new Conservador(), BigDecimal.valueOf(800500), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertTrue(foiPossivelNegociar);
    }
    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel(){
        Negociacao venda = new Negociacao();
        Goleiro Fabio = new Goleiro("Fabio",31,null,8,new Conservador(),BigDecimal.valueOf(80000),32);
        Clube Cruzeiro = new Clube("Cruzeiro Sociedade Anônima de Futebol",9,BigDecimal.valueOf(30));

        boolean resposta = venda.negociar(Cruzeiro,Fabio);
        Assert.assertFalse(resposta);
    }
    @Test
    public void deveSerPossivelNegociarComCaixaDisponivel(){
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 9, BigDecimal.valueOf(1000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 8, new Conservador(), BigDecimal.valueOf(8005), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertTrue(foiPossivelNegociar);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos(){
        Negociacao venda = new Negociacao();
        MeioCampo Fabricio = new MeioCampo("Fabricio",29,null,7, new Mercenario(), BigDecimal.valueOf(8000));
        BigDecimal valorEsperado = BigDecimal.valueOf(14400);
        Assert.assertTrue(Fabricio.valorDeCompra().compareTo(valorEsperado)==0);



    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos(){
        Negociacao venda = new Negociacao();
        MeioCampo Fabricio = new MeioCampo("Fabricio",31,null,7, new Mercenario(), BigDecimal.valueOf(8000));
        BigDecimal valorEsperado = BigDecimal.valueOf(10080);
        Assert.assertTrue(Fabricio.valorDeCompra().compareTo(valorEsperado)==0);



    }
    @Test
    public void deveNegociarCorretamenteUmMeioDeCamposComMaisReputacaoQueOTime(){
        Negociacao venda = new Negociacao();
        MeioCampo Fabricio = new MeioCampo("Fabricio",31,null,7, new Mercenario(), BigDecimal.valueOf(3000));
        Clube RioBranco = new Clube("Rio Branco AC",5,BigDecimal.valueOf(8000));

        Assert.assertTrue(venda.negociar(RioBranco,Fabricio));

    }
    @Test
    public void naoDeveNegociarCorretamenteUmMeioDeCamposComMaisReputacaoQueOTime(){
        Negociacao venda = new Negociacao();
        MeioCampo Fabricio = new MeioCampo("Fabricio",31,null,7, new Mercenario(), BigDecimal.valueOf(3000));
        Clube RioBranco = new Clube("Rio Branco AC",7,BigDecimal.valueOf(8000));

        Assert.assertFalse(venda.negociar(RioBranco,Fabricio));

    }
    @Test
    public void deveNegociarCorretamenteMeioDeCamposConservador(){
        Negociacao venda = new Negociacao();
        MeioCampo Fabricio = new MeioCampo("Fabricio",31,null,7, new Conservador(), BigDecimal.valueOf(3000));
        Clube RioBranco = new Clube("Rio Branco AC",5,BigDecimal.valueOf(8000));
        System.out.println(Fabricio.valorDeCompra());
        Assert.assertTrue(venda.negociar(RioBranco,Fabricio));
    }
    @Test
    public void deveNegociarCorretamenteMeioDeCamposIndiferente(){
        Negociacao venda = new Negociacao();
        MeioCampo Fabricio = new MeioCampo("Fabricio",31,null,7, new Indiferente(), BigDecimal.valueOf(3000));
        Clube RioBranco = new Clube("Rio Branco AC",5,BigDecimal.valueOf(8000));
        System.out.println(Fabricio.valorDeCompra());
        Assert.assertTrue(venda.negociar(RioBranco,Fabricio));
    }
    @Test
    public void deveNegociarCorretamenteUmZagueiroConservador(){
        Negociacao venda = new Negociacao();
        Zagueiro Dede = new Zagueiro("Dedé",34,null,8,new Conservador(),BigDecimal.valueOf(2000));
        Clube RioBranco = new Clube("Rio Branco AC",5,BigDecimal.valueOf(8000));
        Assert.assertTrue(venda.negociar(RioBranco,Dede));
    }
}

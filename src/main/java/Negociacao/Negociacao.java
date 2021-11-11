package Negociacao;

import Clube.Clube;

import Jogador.*;

public class Negociacao {

    private void atualizaSaldoDoClube(Clube clubeComprante, Object jogadorASerVendido){
        if(jogadorASerVendido instanceof Goleiro){
            clubeComprante.saldoDisponivelEmCaixa = clubeComprante.saldoDisponivelEmCaixa.subtract(((Goleiro) jogadorASerVendido).valorDeCompra());
        }else if(jogadorASerVendido instanceof Atacante){
            clubeComprante.saldoDisponivelEmCaixa = clubeComprante.saldoDisponivelEmCaixa.subtract(((Atacante) jogadorASerVendido).valorDeCompra());
        }else if(jogadorASerVendido instanceof Zagueiro){
            clubeComprante.saldoDisponivelEmCaixa = clubeComprante.saldoDisponivelEmCaixa.subtract(((Zagueiro) jogadorASerVendido).valorDeCompra());
        }
    }



    public boolean negociar (Clube clubeComprante, Object jogadorASerVendido){


        if(jogadorASerVendido instanceof Goleiro){
            if(clubeComprante.getReputacao()>= 1){
                if(((Goleiro) jogadorASerVendido).existeInteresse(clubeComprante)){
                double ok = clubeComprante.saldoDisponivelEmCaixa.compareTo(((Goleiro) jogadorASerVendido).valorDeCompra());

                    if(ok>=0){
                        atualizaSaldoDoClube(clubeComprante,jogadorASerVendido);
                        ((Goleiro) jogadorASerVendido).setClubeAtual(clubeComprante);
                        return true;
                    }

                }
            }
        }
        if(jogadorASerVendido instanceof Atacante){
            if(clubeComprante.getReputacao()>= ((Atacante) jogadorASerVendido).getReputacao()){
                if(((Atacante) jogadorASerVendido).existeInteresse(clubeComprante)) {
                    double ok = clubeComprante.saldoDisponivelEmCaixa.compareTo(((Atacante) jogadorASerVendido).valorDeCompra());
                    if(ok>=0) {
                        atualizaSaldoDoClube(clubeComprante, jogadorASerVendido);
                        ((Atacante) jogadorASerVendido).setClubeAtual(clubeComprante);
                        return true;
                    }
                }
            }
        }
        if(jogadorASerVendido instanceof Zagueiro){
            if(clubeComprante.getReputacao()>= 1){
                if(((Zagueiro) jogadorASerVendido).existeInteresse(clubeComprante)){
                    double ok = clubeComprante.saldoDisponivelEmCaixa.compareTo(((Zagueiro) jogadorASerVendido).valorDeCompra());
                    if(ok>=0) {
                        atualizaSaldoDoClube(clubeComprante, jogadorASerVendido);
                        ((Zagueiro) jogadorASerVendido).setClubeAtual(clubeComprante);
                        return true;
                    }
                }
            }
        }
        if(jogadorASerVendido instanceof MeioCampo){
            if(((MeioCampo) jogadorASerVendido).existeInteresse(clubeComprante)){

                double ok = clubeComprante.saldoDisponivelEmCaixa.compareTo(((MeioCampo) jogadorASerVendido).valorDeCompra());
                if(ok>=0) {
                    atualizaSaldoDoClube(clubeComprante, jogadorASerVendido);
                    ((MeioCampo) jogadorASerVendido).setClubeAtual(clubeComprante);
                    return true;
                }

            }
        }
        if(jogadorASerVendido instanceof Lateral){
            if(((Lateral) jogadorASerVendido).existeInteresse(clubeComprante)){
                double ok = clubeComprante.saldoDisponivelEmCaixa.compareTo(((Lateral) jogadorASerVendido).valorDeCompra());
                if(ok>=0){
                    atualizaSaldoDoClube(clubeComprante,jogadorASerVendido);
                    ((Lateral) jogadorASerVendido).setClubeAtual(clubeComprante);
                    return true;
                }
            }
        }
        return false;
    }
}

public class ArCondicionado {
    /*ATRIBUTOS */
    public String marca;
    public String modelo;
    public int potencia;
    public int consumo;
    public int temperaturaControle;
    public boolean ligado;
    public boolean compressor;
    public boolean ventilacao;
    public int temperaturaAmbiente;
    public String local;
    public int consumoKW;
    public int interacoes;
    /*ATRIBUTOS */
    
    /*CONSTRUTOR */

    public ArCondicionado (String nMarca, String nModelo, int tPotencia, int kConsumo, String nLocal) {
        marca = nMarca;
        modelo = nModelo;
        potencia = tPotencia;
        consumo = kConsumo;
        local = nLocal;
        temperaturaControle = 23;
        ligado = false;
        compressor = false;
        ventilacao = false;
        temperaturaAmbiente = 0;
        consumoKW = 0;
        interacoes = 0;
    }

    /*CONSTRUTOR */

    /*MÉTODOS */

    public void ligaArCondicionado () {
        ligado = true;
    }

    public void desligaArCondicionado () {
        ligado = false;
        compressor = false;
        ventilacao = false;
    }

    public void ativaVentilacao () {
        compressor = false;
        ventilacao = true;
        
    }

    public void ativaCompressor () {
        compressor = true;
        ventilacao = false;
    }

    public void aumentaTemperaturaControle () {
        if (temperaturaControle > 17 && temperaturaControle < 40){ // limito o controle a ficar entre as temperatura de 17 ate 40 graus
            temperaturaControle++;
        }
    }

    public void diminuiTemperaturaControle () {
        if (temperaturaControle > 17 && temperaturaControle < 40) { // limito o controle a ficar entre as temperatura de 17 ate 40 graus
            temperaturaControle--;
        }
    }

    public void marcarConsumo () {
        consumoKW++;
    }

    public int somarConsumo () {
        int totalConsumo=0;
        totalConsumo = (consumoKW * consumo)/1000;
        return totalConsumo;
    }

    public void mostrarConsumo () {
        System.out.println("|------------------------------------------------|");
        System.out.println("\tAr-condicionado : " + local);
        System.out.println("\tVezes ativado : " + consumoKW);
        System.out.println("\tConsumo : " + consumo+" W");
        System.out.println("\tCONSUMO TOTAL = " + somarConsumo()+" KW");
        System.out.println("|------------------------------------------------|");
    }


    public void alterarTemperaturaControle (int tAlterar) { // metodo interno de teste.
        temperaturaControle = tAlterar;
    }


    public int aumentaTemperaturaAmbiente () {
        int temperaturaFinal; //crio a veriavel para retorno da temperatura ambiente
        ativaCompressor(); // ligo o compressor
        temperaturaAmbiente++; //compremento +1 na temperatura ambiente
        marcarConsumo();
        System.out.println("\tAQUECENDO");
        temperaturaFinal = temperaturaAmbiente; // atribuo a temperatura final aumentada ah variavel de retorno
        if ( temperaturaControle == temperaturaAmbiente ) {
            ativaVentilacao();
        }
        else {
            ativaCompressor() ; // tratamento para desligar o compressor no momento certo
        }
        return temperaturaFinal;
        
    }

    public int diminuiTemperaturaAmbiente () {
        int temperaturaFinal;
        ativaCompressor(); // ligo o compressor
        temperaturaAmbiente--; //compremento -1 na temperatura ambiente
        marcarConsumo();
        System.out.println("ESFRIANDO");
        temperaturaFinal = temperaturaAmbiente; // atribuo a temperatura final diminuida ah variavel de retorno
        if ( temperaturaControle == temperaturaAmbiente ) {
            ativaVentilacao() ;
        }
        else {
            ativaCompressor() ;
        }
        return temperaturaFinal;
    }


    public void modoAutomatico () {
        int tempAtual = temperaturaAmbiente;
        mostrarTemperaturaAmbiente();
        if (tempAtual < temperaturaControle){ // comparo a temperatura ambiente com a temperatura escolhida para o programa saber o que fazer
            aumentaTemperaturaAmbiente(); //compremento +1 na temperatura ambiente
        }else if (tempAtual > temperaturaControle) {
            diminuiTemperaturaAmbiente(); //compremento -1 na temperatura ambiente
        }else {
            ativaVentilacao(); // ativo a ventilacao
        }
    }

    public void modoVerao (){ // esse modo apenas aumenta a temperatura e/ou ventila o ambiente
        int tempAtual = temperaturaAmbiente;
        mostrarTemperaturaAmbiente();
        if (tempAtual < temperaturaControle){ // comparo a temperatura ambiente com a temperatura escolhida para o programa saber o que fazer
            aumentaTemperaturaAmbiente(); //compremento +1 na temperatura ambiente
        }else {
            ativaVentilacao(); // ativo a ventilacao
        }
        
    }

    public void modoInverno () {
        int tempAtual = temperaturaAmbiente;
        mostrarTemperaturaAmbiente();
        if (tempAtual > temperaturaControle) { // comparo a temperatura ambiente com a temperatura escolhida para o programa saber o que fazer
            diminuiTemperaturaAmbiente();
        }else { // senão
            ativaVentilacao(); //ativo a ventilaçao
        }
    }

    public void mudarTemperaturaAmbiente (int temperatura) {
        temperaturaAmbiente = temperatura;
    }

    public int mostrarTemperaturaControle (){
        int tempControle = temperaturaControle;
        return tempControle;
    }

    public void mostrarTemperaturaAmbiente () {
        System.out.println("\t" + local);
        System.out.println("TEMPERATURA AMBIENTE: " + temperaturaAmbiente);
        System.out.println("MODO ATIVO : "+ (compressor ? "COMPRESSOR" : "VENTILACAO"));
    }

    public void estadoCompressor () {
        System.out.println("\n COMPRESSOR :" + compressor);
    }

    /*METODO PARA CONFIRMAR O FUNCIONAMENTO DAS FUNCOES BASICAS - SEM FUNCIONAMENTO DIRETO NO CONTROLE */
    public void mostrarInformacoes () {
        System.out.println ( "");
        System.out.println (  "\n Status do arcondicionado : " + (ligado ? "LIGADO" : "DESLIGADO"));
        System.out.println (  "\n Compressor : " + (compressor ? "LIGADO" : "DESLIGADO")) ;
        System.out.println (  "\n Ventilação : " + (ventilacao ? "LIGADO" : "DESLIGADO"));
        System.out.println (  "\n -----------------------------------------");
        System.out.println (  "\n Temparatura no Controle : " + temperaturaControle);
        System.out.println (  "\n Temperatura Ambiente : " + temperaturaAmbiente);
        System.out.println (  "\n -----------------------------------------");
        
    }

    public void consumoEnergia () {

    }




    public String toString () { // retorno ao chamar apenas a classe sem chamar metodo
        String retorna = "";
        retorna += "\n -----------------------------------------";
        retorna += "\n \tAR-CONDICIONADO : " + local;
        retorna += "\n -----------------------------------------";
        retorna += "\n Marca : " + marca;
        retorna += "\n Modelo : " + modelo;
        retorna += "\n Potencia : " + potencia + "BTU";
        retorna += "\n Consumo : " + consumo + " W";
        retorna += "\n -----------------------------------------";
        retorna += "\n Status do arcondicionado : " + (ligado ? "LIGADO" : "DESLIGADO");
        retorna += "\n Compressor : " + (compressor ? "LIGADO" : "DESLIGADO") ;
        retorna += "\n Ventilacao : " + (ventilacao ? "LIGADO" : "DESLIGADO");
        retorna += "\n -----------------------------------------";
        retorna += "\n Temparatura no Controle : " + temperaturaControle;
        retorna += "\n Temperatura Ambiente : " + temperaturaAmbiente;
        retorna += "\n -----------------------------------------";


        return retorna;
    }

    /*MÉTODOS */

}
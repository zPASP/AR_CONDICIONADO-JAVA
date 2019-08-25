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
    /*ATRIBUTOS */
    
    /*CONSTRUTOR */

    public ArCondicionado () {
        marca = "";
        modelo = "";
        potencia = 0;
        consumo = 0;
        temperaturaControle = 17;
        ligado = false;
        compressor = false;
        ventilacao = false;
        temperaturaAmbiente = 16;
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

    public void aumentaTemperaturaControle () {
        if (temperaturaControle > 17 && temperaturaControle < 40){
            temperaturaControle++;
        }
    }

    public void diminuiTemperaturaControle () {
        if (temperaturaControle > 17 && temperaturaControle < 40) {
            temperaturaControle--;
        }
    }

    public int aumentaTemperaturaAmbiente () {
        int temperaturaFinal; //crio a veriavel para retorno da temperatura ambiente
        if (temperaturaAmbiente < temperaturaControle) { // comparo a temperatura ambiente com a temperatura escolhida para o programa saber o que fazer
            compressor = true; // ligo o compressor
            temperaturaAmbiente++; //compremento +1 na temperatura ambiente
            temperaturaFinal = temperaturaAmbiente; //a variavel de retorno recebe o valor da temperatura ambiente
        }else { // senão
            ativaVentilacao(); //ativo a ventilaçao
            temperaturaFinal = temperaturaAmbiente; //a variavel de retorno recebe o valor da temperatura ambiente
        }
        return temperaturaFinal;
    }

    public int diminuiTemperaturaAmbiente () {
        int temperaturaFinal;
        if (temperaturaAmbiente > temperaturaControle) { // comparo a temperatura ambiente com a temperatura escolhida para o programa saber o que fazer
            compressor = true; // ligo o compressor
            temperaturaAmbiente--; //compremento -1 na temperatura ambiente
            temperaturaFinal = temperaturaAmbiente; //a variavel de retorno recebe o valor da temperatura ambiente
        }else { // senão
            ativaVentilacao(); //ativo a ventilaçao
            temperaturaFinal = temperaturaAmbiente; //a variavel de retorno recebe o valor da temperatura ambiente
        }

        return temperaturaFinal;
    }

    public void mudarTemperaturaAmbiente (int temperatura) {
        temperaturaAmbiente = temperatura;
    }

    public String toString () { // retorno ao chamar apenas a classe sem chamar metodo
        String retorna = "";
        retorna += "\n Marca : " + marca;
        retorna += "\n Modelo : " + modelo;
        retorna += "\n Potencia : " + potencia;
        retorna += "\n Consumo : " + consumo;
        retorna += "\n Temparatura no Controle : " + temperaturaControle;
        retorna += "\n Status do arcondicionado : " + (ligado ? "LIGADO" : "DESLIGADO");
        retorna += "\n Compressor : " + (compressor ? "LIGADO" : "DESLIGADO") ;
        retorna += "\n Ventilação : " + (ventilacao ? "LIGADO" : "DESLIGADO");
        retorna += "\n Temperatura Ambiebnte : " + temperaturaAmbiente;

        return retorna;
    }

    /*MÉTODOS */

}
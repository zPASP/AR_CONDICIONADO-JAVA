import java.util.Scanner;

public class Controle {

    public static void telaBoasVindas(int repetindo) { //teça de abertura do sistema aparece somente na primeira repetição
        if (repetindo == 0){ //defino que se estiver repedindo ou o valor for diferente de 0 não ira ser executado
            System.out.println("+------ BEM VINDO A CASA AUTO-CRIMATIZADA -------+");
            System.out.println("|------------------------------------------------|");
            System.out.println("|------**LIGANDO TODOS OS AR-CONCIONADOS**-------|");
            System.out.println("|                                                |");
        }
    }
    
    public static int trocarModoArCondionado () { // opção para escolher o modo operante do ar-condicionado

        int retornaModo = 0;
        int modoOperacao = -2;


        System.out.println("|INFORME O MODO DE OPERACAO DO AR-CONDICIONADO:  |");
        System.out.println("|1 - AUTOMATICO                                  |");
        System.out.println("|2 - VERAO                                       |");
        System.out.println("|3 - INVERNO                                     |");

            while (modoOperacao < -1 || modoOperacao > 3) { //repetição para aceitar somente os valores validos
                System.out.print("\t\t");
                modoOperacao = Integer.parseInt(System.console().readLine());
            if (modoOperacao > 3 || modoOperacao < 1 )
                System.out.println("|   [ERROR] VALOR INVALIDO                       |");
                if (modoOperacao == 0) modoOperacao = -2; // caso seja informado um valor 0 nesse menu não é para ele ser valido, então eu altero o valor para a repetição se manter
            }
        retornaModo = modoOperacao;

        return retornaModo;
    }

    public static int escolherTrocarModoArCondionado(int repetindo,int modoEscolhido) { // saber se quer trocar o modo de opeção do ar
        int escolhaRetorno = 0;
        int escolhaRepeti = 3;
            if (modoEscolhido != -1) {
                if (repetindo != 0) { //não é valido para a primeira execução
                    System.out.println("|  TROCA O MODO DE OPERACAO DO AR-CONDICIONADO   |");
                    System.out.println("|1 - SIM                                         |");
                    System.out.println("|0 - NAO                                         |");
                        
                        while (escolhaRepeti < -1 || escolhaRepeti > 1) { //repetição para aceitar somente valores validos
                            System.out.print("\t\t");
                            escolhaRepeti = Integer.parseInt(System.console().readLine());
                            if (escolhaRepeti > 1 || escolhaRepeti < 0 )
                                System.out.println("|   [ERROR] VALOR INVALIDO                       |");
                        }

                        if (escolhaRepeti == 1){ //se valor 1
                                escolhaRetorno = trocarModoArCondionado(); //chamo a função para escolher o modo do ar novamente
                        }else if (escolhaRepeti == 0){ //se valor 0
                            System.out.println("|        MODO DO AR-CONDIONADO NAO ALTERADO      |"); //mantenho o modo que ja estava
                            escolhaRetorno = modoEscolhido;
                        }else if (escolhaRepeti == -1){ //se valor -1 não faço nada e encaminha para a temperatura do controle
                            escolhaRetorno = -1;
                        }

                }else { // senão
                    escolhaRetorno = trocarModoArCondionado(); //se for a primeira vez encaminho direto sem perguntar nada
                }
            return escolhaRetorno;
        }else {
            escolhaRetorno = modoEscolhido;
            return escolhaRetorno;
        }
    }
    

    public static int mudarTemperaturaControle(int tempControl) {
        int tempFinal = 0;
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|          TEMPERATURA ATUAL DO CONTROLE         |");
        System.out.println("|     " + tempControl + "                                         |");
        System.out.println("|          ESCOLHA A TEMPERATURA DO CONTROLE     |");

            while (tempFinal < 16 || tempFinal > 40 ) {//valor do controle entre 17 e 40 16 ficou para sair do programa
                System.out.print("\t\t");
                tempFinal = Integer.parseInt(System.console().readLine());
                if (tempFinal == 16) tempFinal = 10; // caso seja digitado 16 transformo em outro valor não valido diferente de -1
                if (tempFinal == -1) tempFinal = 16; //caso seja -1 transformo em 16 para poder sair da repetição feita

            if (tempFinal > 40 || tempFinal < 17  && tempFinal != -1)
                System.out.println("|   [ERROR] VALOR INVALIDO                       |");
            }
            if (tempFinal == 16) tempFinal = -1; // tratamento do valor 16 tranformando em -1 novamente para sair do programa

        System.out.println("|------------------------------------------------|");

        return tempFinal;
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        ArCondicionado sala,escritorio,quarto;
        /**
         * METODOS TESTADOS
         * temperatura ambiente não ultrapassa o valor da temperatura do controle
         * temperatura controle não ultrapassa os valores de 17 até 40
         * toString mostrando corretamente as insformações da classe
         * 
         */


        /* PROCESSAMENTO INTERNO SEM INTERRAÇÂO DO USER */
            /*ATRIBUIçÃO DAS CLASSES */
        escritorio = new ArCondicionado("Eletrolux", "ArtCool", 9000, 1038,"Escritorio");
        sala = new ArCondicionado("Philco", "EcoTurbo", 18000, 5200,"Sala");
        quarto = new ArCondicionado("Samsung", "TurboMaster", 1200, 3510,"Quarto");

        telaBoasVindas(0);
            /**LIGAR OS ARES */
        escritorio.ligaArCondicionado();
        sala.ligaArCondicionado();
        quarto.ligaArCondicionado();
            /*VALORES ALEATORIO PARA A TEMPERATURA AMBIENTE. DE 0 Até 40 */
        escritorio.mudarTemperaturaAmbiente((int) (Math.random()*40+1));
        sala.mudarTemperaturaAmbiente((int) (Math.random()*40+1));
        quarto.mudarTemperaturaAmbiente((int) (Math.random()*40+1));
            
        System.out.println(escritorio);
        System.out.println(sala);
        System.out.println(quarto);

        /** */

        boolean continuarPrograma = true;

        int interacao = 0;
        int contador = 0;

        int modoOperacao = 0;
        int valorTemperatura = sala.mostrarTemperaturaControle();
        int tempAnterior = 0;
        int diferecaTemp = 0;
        boolean aumentarTemp = true;


        while(continuarPrograma) {
            
                modoOperacao = escolherTrocarModoArCondionado(interacao, modoOperacao);

                tempAnterior = valorTemperatura;
                valorTemperatura = mudarTemperaturaControle(valorTemperatura);

                if (valorTemperatura != -1){
                    if (tempAnterior > valorTemperatura){
                        diferecaTemp = tempAnterior - valorTemperatura;
                        aumentarTemp = false;
                    }else if (tempAnterior < valorTemperatura) {
                        diferecaTemp = valorTemperatura - tempAnterior;
                        aumentarTemp = true;
                    }else {
                        diferecaTemp = 0;
                    }
                }

                if(valorTemperatura != -1){
                    if (diferecaTemp == 0) {
                        System.out.println("");
                        escritorio.alterarTemperaturaControle(valorTemperatura);
                        sala.alterarTemperaturaControle(valorTemperatura);
                        quarto.alterarTemperaturaControle(valorTemperatura);
                    } 
                    if(aumentarTemp) {
                        for (int i = 0; i < diferecaTemp; i++){
                            System.out.println("AUMENTANDO TEMPERATURA DO CONTROLE: "+ (escritorio.mostrarTemperaturaControle()+1));
                            escritorio.aumentaTemperaturaControle();
                            sala.aumentaTemperaturaControle();
                            quarto.aumentaTemperaturaControle();
                        }
                    }else if(!aumentarTemp) {
                        for (int i = 0; i < diferecaTemp; i++) {
                            System.out.println("DIMINUINDO TEMPERATURA DO CONTROLE: "+ (escritorio.mostrarTemperaturaControle()-1));
                            escritorio.diminuiTemperaturaControle();
                            sala.diminuiTemperaturaControle();
                            quarto.diminuiTemperaturaControle();
                        }
                    }
                }


                //System.out.println("TEMPERATURA CONTROLE: "+ valorTemperatura);
                //System.out.println("MODO DE ESCOLHA: "+modoOperacao);

                if (valorTemperatura == -1 || modoOperacao == -1){
                    System.out.println("|------------------------------------------------|");
                    System.out.println("|   FECHANDO O PROGRAMA CASA AUTO_CLIMATIZADA    |");
                    System.out.println("|-----**DESLIGANDO TODOS OS AR-CONCIONADOS**-----|");
                    System.out.println("|------------------------------------------------|");
                    continuarPrograma = false;
                    escritorio.desligaArCondicionado();
                    sala.desligaArCondicionado();
                    quarto.desligaArCondicionado();

                    escritorio.mostrarConsumo();
                    sala.mostrarConsumo();
                    quarto.mostrarConsumo();

                }
                
         //      escritorio.mostrarInformacoes();
         //       System.out.println("10x DEPOIS");

                while (contador < 10  && continuarPrograma) {
                    System.out.println("\n|------------------------------------------------|");
                   // System.out.println("INTERACAO "+contador+":");
                    if (modoOperacao == 1){ //automatico
                        escritorio.modoAutomatico();
                        sala.modoAutomatico();
                        quarto.modoAutomatico();
                        
                    }else if(modoOperacao == 2){ // verão
                        escritorio.modoVerao();
                        sala.modoVerao();
                        quarto.modoVerao();

                    }else { //inverno
                        escritorio.modoInverno();
                        sala.modoInverno();
                        sala.modoInverno();

                    }
                    contador++;
                    System.out.println("|------------------------------------------------|\n");
                }
        //        escritorio.mostrarInformacoes();
            contador=0;
            interacao++;
        }
    }
}
public class Controle {
    public static void main(String[] args) {
        ArCondicionado sala;

        sala = new ArCondicionado();

        sala.ligaArCondicionado();

        System.out.println(sala);

        sala.aumentaTemperaturaAmbiente();
        sala.aumentaTemperaturaAmbiente();
        sala.aumentaTemperaturaAmbiente();
        sala.aumentaTemperaturaAmbiente();
        sala.diminuiTemperaturaControle();

        System.out.println(sala);

        sala.mudarTemperaturaAmbiente(40);;
        sala.aumentaTemperaturaAmbiente();
        sala.aumentaTemperaturaAmbiente();
        sala.aumentaTemperaturaAmbiente();

        System.out.println(sala);

    }
}
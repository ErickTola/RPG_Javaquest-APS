package Sistema;

public class Alavancas {

    static boolean[] estado = {false,true,false,false,true};

    static public void puzzle(){
        int escolha = 0;

        System.out.println("false true false false true");

        while (!(estado[1] && estado[2] && estado[3] && estado[4] && estado[5])) {

            String textoEstado = "";


            escolha = Entrada.entradaInt() - 1;

            if (escolha == 0){
                estado[4] = !estado[4];
                estado[escolha] = !estado[escolha];
                estado[escolha+1] = !estado[escolha+1];
            }else if (escolha == 4){
                estado[0] = !estado[0];
                estado[escolha] = !estado[escolha];
                estado[escolha-1] = !estado[escolha-1];
            }
            else {
                estado[escolha-1] = !estado[escolha-1];
                estado[escolha] = !estado[escolha];
                estado[escolha+1] = !estado[escolha+1];
            }

            for (boolean b : estado) {
                textoEstado += b + " ";
            }

            System.out.println(textoEstado);
        }

    }
}

package Sistema;

import java.util.Arrays;

public class Inventario {

    public static String invConsumiveis[] = new String[15];


    public static void adcItem(String name){
        //Faz um loop pelo array de inventário verificando se há um espaço livre, para poder adicionar um valor ao endereço do inventário.
        for(int i = 0; i < invConsumiveis.length; i++){
            if(invConsumiveis[i] == null){
                invConsumiveis[i] = name;
                break;
            }
            if (i == invConsumiveis.length - 1 && invConsumiveis[i] != null){
            System.out.println("Não há espaço no inventário");
            }
        }

    }

    public static void rmvItemId(int x){ // Remove item do inventário pelo indice (Número da lista)
        //Após remover o item indicado, move o restante dos itens para o espaço acima do inventário
            invConsumiveis[x-1] = null;
            for(int i = x-1; i < invConsumiveis.length; i++){
                if (i != invConsumiveis.length - 1) {
                    invConsumiveis[i] = invConsumiveis[i + 1];
                    invConsumiveis[i + 1] = null;
                }
            }
    }

    public static void clearInv(){ // Limpa o inventário, preenchendo seus espaços com um valor Nulo
        Arrays.fill(invConsumiveis, null);
        }
//
    public static void rmvItemNome(String x){ // Remove o item do inventário pelo nome
        int indice = 0;

        //Faz um loop por cada item do inventário até achar o primeiro que bata com o valor dado, e então torna o valor nulo.
        for(int i = 0; i< invConsumiveis.length; i++){
            if (invConsumiveis[i] == x){
                invConsumiveis[i] = null;
                indice = i;
                break;
            }
        }
        //Após remover o item indicado, move o restante dos itens para o espaço acima do inventário
        for(int i = indice; i < invConsumiveis.length; i++){
            if (i != invConsumiveis.length - 1) {
                invConsumiveis[i] = invConsumiveis[i + 1];
                invConsumiveis[i + 1] = null;
            }
        }
    }

    //Chama o comando de utilizar item e remove o item utilizado do inventário
    public static void usaItemInv(int x){
        Items.usaItem(invConsumiveis[x-1]);
        rmvItemId(x);
    }

    //Faz um loop por todos os itens não nulos do inventário e os mostra na tela, além de retornar o total de itens encontrado no inventário.
    public static int printInv(){
        int totalDeItens = 0;
        for(int i = 0; i < invConsumiveis.length; i++){
            if (invConsumiveis[i] != null) {
                System.out.println( (i+1) + " - " + invConsumiveis[i] );
                totalDeItens += 1;
            }
        }
        return totalDeItens;
    }

    //Faz um loop por todos os itens do inventário e verifica se todos não são vazios.
    public static boolean invCheck(){
        for(String s: invConsumiveis){
            if(s != null){
                return true;
            }
        }
        return false;
    }


}

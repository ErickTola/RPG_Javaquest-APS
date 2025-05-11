public class Inventario {

    public static String invConsumiveis[] = new String[15];


    public static void adcItem(String name){

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
            invConsumiveis[x-1] = null;
            for(int i = x-1; i < invConsumiveis.length; i++){
                if (i != invConsumiveis.length - 1) {
                    invConsumiveis[i] = invConsumiveis[i + 1];
                    invConsumiveis[i + 1] = null;
                }
            }
    }

    public static void rmvItemNome(String x){ // Remove o item do inventário pelo nome
        int indice = 0;

        for(int i = 0; i< invConsumiveis.length; i++){
            if (invConsumiveis[i] == x){
                invConsumiveis[i] = null;
                indice = i;
                break;
            }
        }
        for(int i = indice; i < invConsumiveis.length; i++){
            if (i != invConsumiveis.length - 1) {
                invConsumiveis[i] = invConsumiveis[i + 1];
                invConsumiveis[i + 1] = null;
            }
        }
    }

    public static void usaItemInv(int x){
        Items.usaItem(invConsumiveis[x-1]);
        rmvItemId(x);
    }

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

    public static boolean invCheck(){
        for(String s: invConsumiveis){
            if(s != null){
                return true;
            }
        }
        return false;
    }

}

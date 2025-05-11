public class Inventario {

    public static String inv[] = new String[15];


    public static void adcItem(String name){

        for(int i = 0; i < inv.length; i++){
            if(inv[i] == null){
                inv[i] = name;
                break;
            }
            if (i == inv.length - 1 && inv[i] != null){
            System.out.println("Não há espaço no inventário");
            }
        }

    }

    public static void rmvItemId(int x){ // Remove item do inventário pelo indice (Número da lista)
            inv[x-1] = null;
            for(int i = x-1; i < inv.length; i++){
                if (i != inv.length - 1) {
                    inv[i] = inv[i + 1];
                    inv[i + 1] = null;
                }
            }
    }

    public static void rmvItemNome(String x){ // Remove o item do inventário pelo nome
        int indice = 0;

        for(int i=0;i<inv.length;i++){
            if (inv[i] == x){
                inv[i] = null;
                indice = i;
                break;
            }
        }
        for(int i = indice; i < inv.length; i++){
            if (i != inv.length - 1) {
                inv[i] = inv[i + 1];
                inv[i + 1] = null;
            }
        }
    }

    public static void usaItemInv(int x){
        Items.usaItem(inv[x-1]);
        rmvItemId(x);
    }

    public static void printInv(){
        for(String x: inv){
            if (x != null) {
                System.out.println(x);
            }
        }
    }

}

package Sistema;

public class Menus {
    static int escolhaMenu = 0;

    public static String separador(){
        String sep = "";
        for(int i = 0; i < 100 ; i++){
            sep = sep + "-";
        }
        return sep + "\n";
    }

    public static int menuCombate(){

        System.out.println(
                separador()+
                "O que deseja fazer?         HP: "+ Heroi.getHp() + "\n" +
                "\n"+
                "1 - Atacar\n"+
                "2 - Defender\n"+
                "3 - Inventário\n"
        );
        System.out.print("Digite sua escolha: ");
        //Recolhe o valor de entrada do jogador e faz com que seja impossivel de colocar um valor acima ou abaixo do listado
        escolhaMenu = Entrada.entradaInt();
        while (escolhaMenu <= 0 || escolhaMenu > 3) { // (Tratamento de excessões)

            System.out.println(
                    separador()+
                    "O que deseja fazer?         HP: "+ Heroi.getHp() + "\n" +
                    "\n"+
                    "1 - Atacar\n"+
                    "2 - Defender\n"+
                    "3 - Inventário\n"
            );
            System.out.print("Digite sua escolha: ");
            escolhaMenu = Entrada.entradaInt();
        }
        //Executa a ação selecionada pelo jogador
        switch (escolhaMenu) {
            case 1:
                escolhaMenu = -1;
                System.out.println(
                        separador() +
                        """
                                Como deseja atacar?
                                
                                1 - Ataque Certeiro (+1 de precisão)
                                2 - Ataque Potente (+1 de força)
                                0 - Sair
                                """);
                System.out.print("Digite sua escolha: ");
                escolhaMenu = Entrada.entradaInt();
                while (escolhaMenu < 0 || escolhaMenu > 2){
                    if (escolhaMenu != -1){
                    System.out.println("Entrada Invalida");
                    }
                    System.out.print("Digite sua escolha: ");
                    escolhaMenu = Entrada.entradaInt();
                }
                Combate.opcao = escolhaMenu;
                break;
            case 2:
                Combate.opcao = 3;
                break;
            case 3:
                escolhaMenu = -1;
                if(Inventario.invCheck()) {
                    int totalDeItens = Inventario.printInv();
                    System.out.println("0 - Sair");
                    System.out.print("Digite sua escolha: ");
                    escolhaMenu = Entrada.entradaInt();
                    while (escolhaMenu < 0 || escolhaMenu > totalDeItens) {
                        System.out.println("Sistema.Entrada Inválida!");
                        System.out.print("Digite sua escolha: ");
                        escolhaMenu = Entrada.entradaInt();
                    }
                    if (escolhaMenu == 0){
                        Combate.opcao = -1;
                        menuCombate();
                    }else{
                        Inventario.usaItemInv(escolhaMenu);
                        return 0;
                    }
                }else{
                    System.out.println("Inventário vazio!");
                    Combate.opcao = -1;
                    menuCombate();

                }
            default:
                menuCombate();
                break;
        }

        return 0;
    }

    public static void menuStats(){
        System.out.println(separador());
        System.out.println("Stats:\n");
        System.out.println("Vida: " + Heroi.getHp() +"\n");
        System.out.println("Atk: " + Heroi.getAtk());
        System.out.println("Dmg: " + Heroi.getDmg());
        System.out.println("Def: " + Heroi.getDef());
        System.out.println("Agl: " + Heroi.getAgl() +"\n");
        System.out.println("Equipamento:\n");
        System.out.println("Arma: " + Heroi.getArmaAtual() +" | "+ Items.descItem(Heroi.getArmaAtual()));
        System.out.println("Armadura: " + Heroi.getArmaduraAtual() +" | "+ Items.descItem(Heroi.getArmaduraAtual()));
        System.out.print("Anel: " + Heroi.getAnelAtual());
        if (Heroi.getAnelAtual() != "Nenhum"){
            System.out.println(" | "+ Items.descItem(Heroi.getAnelAtual()));
        }
    }



}

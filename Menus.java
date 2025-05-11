public class Menus {
    static int escolhaMenu = 0;
    public static int menuCombate(){

        System.out.println(
                "-------------------------------------\n"+
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
                    "-------------------------------------\n"+
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
                        """
                                -------------------------------------
                                Como deseja atacar?
                                
                                1 - Ataque Certeiro (+1 de precisão)
                                2 - Ataque Potente (+1 de força)
                                0 - Sair
                                """);
                System.out.print("Digite sua escolha: ");
                escolhaMenu = Entrada.entradaInt();
                while (escolhaMenu < 0 || escolhaMenu > 2){
                    System.out.println("Entrada Invalida");
                    System.out.print("Digite sua escolha: ");
                    escolhaMenu = Entrada.entradaInt();
                }
                return escolhaMenu;
            case 2:
                return 3;
            case 3:
                escolhaMenu = -1;
                if(Inventario.invCheck()) {
                    int totalDeItens = Inventario.printInv();
                    System.out.println("0 - Sair");
                    System.out.print("Digite sua escolha: ");
                    escolhaMenu = Entrada.entradaInt();
                    while (escolhaMenu < 0 || escolhaMenu > totalDeItens) {
                        System.out.println("Entrada Inválida!");
                        System.out.print("Digite sua escolha: ");
                        escolhaMenu = Entrada.entradaInt();
                    }
                    if (escolhaMenu == 0){
                        menuCombate();
                    }else{
                        Inventario.usaItemInv(escolhaMenu);
                        return 0;
                    }
                }else{
                    System.out.println("Inventário vazio!");
                    menuCombate();
                }
        }

        return 0;
    }
}

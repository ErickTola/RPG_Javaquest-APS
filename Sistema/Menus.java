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
                System.out.print(Menus.separador());
                while (escolhaMenu < 0 || escolhaMenu > 2){
                    if (escolhaMenu != -1){
                    System.out.println("Entrada Invalida");
                    }
                    System.out.print("Digite sua escolha: ");
                    escolhaMenu = Entrada.entradaInt();
                    System.out.print(Menus.separador());
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
                        Combate.opcao = 0;
                        menuCombate();
                    }else{
                        Inventario.usaItemInv(escolhaMenu);
                        Combate.opcao = -1;
                        return 0;
                    }
                }else{
                    System.out.println("Inventário vazio!");
                    Combate.opcao = 0;
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
    // Método utilizado para adicionar pausas
    public static void loading(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //    Método que apresenta a introdução da história
    public static void introducaoHistoria() {
        System.out.println(separador());
        System.out.println("Em uma pacata vila, Senhor Jones, um simples pescador, se entristece com tanta sujeira e poluição na praia.");
        loading(3000);
        System.out.println("Determinado a descobrir o grande causador dessa poluição em massa, Senhor Jones parte em uma grande jornada.");
        loading(3000);

        // Destaque para o capítulo
        System.out.println("\n\n===== CAPÍTULO 1 =====");
        System.out.println("      A Praia Poluída\n");
        loading(3000);

        // Chama o método para a interação na praia
        introducaoPraia();
    }

    // Método para introduzir a situação da praia poluída e a criança
    public static void introducaoPraia() {
        System.out.println(separador());
        System.out.println("Para início de sua jornada, Senhor Jones desce até a praia principal na costa de sua vila. O ar está denso e a água cheia de resíduos.");
        loading(3000);
        System.out.println("A tristeza toma conta do herói ao ver o estado da praia.");
        loading(3000);
        System.out.println("Senhor Jones: Mas que droga... preciso fazer algo");
        loading(3000);
        System.out.println("Enquanto anda pela praia, ele se depara com uma criança escondida atrás de uma pilha de lixo.");
        loading(3000);
        System.out.println("O herói, curioso, se aproxima e pergunta:");
        System.out.println("Senhor Jones: O que está acontecendo?");
        loading(3000);
        System.out.println("A criança responde: ");
        System.out.println("Criança assustada: Moço, eu vi um monstro tentando comer uma gaivota, estou com medo!");
        loading(1500);
        System.out.println("Criança assustada: E se ele acabar devorando pessoas, meus amigos...");
        loading(3000);
        System.out.println("Você tem duas opções:");
        System.out.println("1 - Ajudar a criança");
        System.out.println("2 - Ignorar e seguir em frente");

        int escolha = Entrada.entradaInt();
        while (escolha < 1 || escolha > 2) {
            System.out.println("Escolha inválida. Por favor, escolha 1 ou 2.");
            escolha = Entrada.entradaInt();
        }

        if (escolha == 1) {
            ajudarPIVETE();
        } else {
            ignorarPIVETE();
        }
    }

    // Método quando o jogador escolhe ajudar a criança
    public static void ajudarPIVETE() {
        System.out.println(separador());
        System.out.println("A criança, aliviada, diz:");
        System.out.println("Criança assustada: Aqui, moço, pegue isso!");
        loading(3000);
        System.out.println("A criança lhe entrega um pedaço de madeira, sua primeira arma.");
        loading(2500);
        Inventario.adcItem("Pedaço de Madeira");  // método para adicionar o item ao inventário
        System.out.println("Você agora está armado com o pedaço de madeira.");
        loading(3000);
        System.out.println("Com o item em mãos, você segue para investigar o monstro.");
        loading(3000);
        System.out.println("Senhor Jones, determinado em ajudar a criança, segue os rastros de resíduo verde até a ponta da praia.");
        loading(3000);
        System.out.println("Ele avista o seu primeiro inimigo: Slime de Chorume.");
        loading(1500);
        System.out.println("O Slime de Chorume parece determinado em comer gaivotas e espalhar seu resíduo tóxico pela praia...");
        loading(3000);
        System.out.println("Mas nosso herói, Senhor Jones, está a um passo de mudar essa história toda.");
        loading(3000);
        System.out.println("Senhor Jones: Ei, então você é a gosminha que está atacando as gaivotas, ein? Se prepare para lutar.");
        loading(2500);
        combateSlime(); // Inicia o combate com o Slime
        avancarCentroDaPraia(); // CONTINUA a história normal para ambos
    }

    // Método quando o jogador escolhe ignorar a criança
    public static void ignorarPIVETE() {
        System.out.println(separador());
        System.out.println("Senhor Jones: Desculpa guri, tenho outras coisas para fazer.");
        System.out.println("Você ignora a criança e segue adiante.");
        avancarCentroDaPraia(); // CONTINUA a história normal para ambos
    }

    // Método que inicia o combate com o Slime de Chorume
    public static void combateSlime() {
        System.out.println(separador());
        System.out.println("Com seu pedaço de madeira em mãos, Senhor Jones se prepara para iniciar o seu primeiro combate nessa grande jornada.");
        loading(2000);
        System.out.println("O Slime de Chorume começa a se mover em sua direção, pronto para atacar!");
        // Inicia o combate com o Slime de Chorume
        new Combate("Slime");  // Chama o método de combate
    }
    // Após o evento com a criança
    public static void avancarCentroDaPraia() {
        System.out.println(separador());
        System.out.println("Senhor Jones segue até o centro da praia. A visão é ainda pior: lixo por todos os lados e um cheiro insuportável no ar.");
        loading(3000);
        System.out.println("A tristeza se mistura à revolta. Ele fecha os punhos, determinado a encontrar o verdadeiro culpado.");
        loading(3000);

        // Começar escolha das próximas rotas
        explorarCentroPraia(false, false);
    }

    // Função com as escolhas/ramificações
    public static void explorarCentroPraia(boolean foiQuiosque, boolean foiOrla) {
        System.out.println(separador());
        System.out.println("Nosso herói avista 3 caminhos à frente. Qual ele deve seguir?");
        if (!foiQuiosque) System.out.println("1 - Ir ao quiosque abandonado");
        if (!foiOrla) System.out.println("2 - Seguir para a orla da praia");
        System.out.println("3 - Ir até o píer");

        int escolha = Entrada.entradaInt();

        switch (escolha) {
            case 1:
                if (!foiQuiosque) {
                    visitarQuiosque();
                    foiQuiosque = true;
                } else {
                    System.out.println("Você já explorou o quiosque.");
                }
                break;
            case 2:
                if (!foiOrla) {
                    visitarOrla();
                    foiOrla = true;
                } else {
                    System.out.println("Você já explorou a orla.");
                }
                break;
            case 3:
                if (foiQuiosque && foiOrla) {
                    acessarPier();
                    return; // fim das escolhas
                } else {
                    System.out.println("Senhor Jones: O píer está muito sujo... ainda não estou pronto para ir até lá.");
                    loading(2000);
                }
                break;
            default:
                System.out.println("Escolha inválida. Tente novamente.");
        }

        // Mostra novamente as opções depos de passar por uma
        if (!(foiQuiosque && foiOrla)) {
            explorarCentroPraia(foiQuiosque, foiOrla);
        }
    }

    // Quiosque
    public static void visitarQuiosque() {
        System.out.println(separador());
        System.out.println("O herói chega ao quiosque abandonado.");
        System.out.println("Senhor Jones: Lixo espalhado, cheiro de comida estragada...");
        System.out.println("1 - Vasculhar o quiosque");
        System.out.println("2 - Voltar ao centro da praia");

        int escolha = Entrada.entradaInt();
        while (escolha != 1 && escolha != 2) {
            System.out.println("Escolha inválida.");
            escolha = Entrada.entradaInt();
        }

        if (escolha == 1) {
            System.out.println("Entre sacolas e caixas velhas, você encontra uma poção de cura!");
            Inventario.adcItem("Cura Pequena");
            loading(2000);
        }
        System.out.println("Você retorna ao centro da praia.");
        loading(2000);
    }

    // Orla
    public static void visitarOrla() {
        System.out.println(separador());
        System.out.println("Senhor Jones vai até a orla da praia, em passos leves.");
        loading(3000);
        System.out.println("Ele avista um grupo de jovens preocupados. Um deles se aproxima:");
        loading(3000);
        System.out.println("Azevedo: Ei, senhor! Você viu nosso amigo? Ele saiu pra limpar a praia e não voltou.");
        loading(2000);

        boolean resolveuOrla = false;

        while (!resolveuOrla) {
            System.out.println("1 - Ajudar a encontrar o jovem");
            System.out.println("2 - Ignorar e seguir");
            System.out.println("3 - Perguntar mais sobre o desaparecido");

            int escolha = Entrada.entradaInt();

            switch (escolha) {
                case 1:
                    System.out.println("Você decide ajudar os jovens na busca por seu amigo.");
                    loading(2000);
                    grutaPoluida();
                    System.out.println("Senhor Jones retorna à orla e entrega o amigo resgatado aos jovens.");
                    loading(3000);
                    System.out.println("\"Muito obrigado, senhor!\" - diz um deles.");
                    loading(3000);
                    System.out.println("Você recebe: Mantos reforçados.");
                    Inventario.adcItem("Mantos reforçados");
                    resolveuOrla = true;
                    loading(2000);
                    break;
                case 2:
                    System.out.println("Senhor Jones: Sinto muito, mas tenho mais coisas a fazer.");
                    resolveuOrla = true;
                    loading(2000);
                    break;
                case 3:
                    System.out.println("Azevedo: O nome dele é Henry. Ele estava vestindo um casaco preto e um tênis amarelo da marca New Horizon.");
                    loading(2000);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        System.out.println("Você retorna ao centro da praia.");
        loading(2000);
    }

    // Gruta Poluída
    public static void grutaPoluida() {
        boolean encontrouAmigo = false;
        boolean foiDireita = false;
        boolean foiMeio = false;
        boolean foiEsquerda = false;

        while (!encontrouAmigo) {
            System.out.println(separador());
            System.out.println("Você está dentro da Gruta Poluída. Três caminhos diante de você:");
            System.out.println("1 - Caminho da direita");
            System.out.println("2 - Caminho do meio");
            System.out.println("3 - Caminho da esquerda");

            int escolha = Entrada.entradaInt();

            switch (escolha) {
                case 1:
                    if (foiDireita) {
                        System.out.println("Senhor Jones: Se não me engano, eu já fui por aí...");
                        loading(2000);
                    } else {
                        System.out.println("Você segue pela direita. O caminho é curto e termina numa parede de pedras.");
                        System.out.println("Mas encontra uma pequena Poção de Cura!");
                        Inventario.adcItem("Cura Média");
                        foiDireita = true;
                    }
                    break;
                case 2:
                    if (foiMeio) {
                        System.out.println("Senhor Jones: Se não me engano, eu já fui por aí...");
                        loading(2000);
                    } else {
                        System.out.println("Você vai pelo meio e um Slime de Chorume salta do chão!");
                        new Combate("Slime");
                        System.out.println("Você venceu e ele dropou Poção de Força!");
                        Inventario.adcItem("Poção de Força");
                        foiMeio = true;
                    }
                    break;
                case 3:
                    if (foiEsquerda) {
                        System.out.println("Senhor Jones: Se não me engano, eu já fui por aí...");
                        loading(2000);
                    } else {
                        System.out.println("Você encontra o jovem perdido! Ele parece assustado, mas está bem.");
                        loading(2000);
                        System.out.println("Senhor Jones: Você é o Henry, não é?");
                        loading(3000);
                        System.out.println("Henry: Sim senhor, eu me perdi nessa gruta tentando recolher o máximo de lixo possível");
                        loading(3000);
                        System.out.println("Senhor Jones: Agora está tudo bem. Vamos voltar.");
                        loading(2000);
                        System.out.println("Enquanto saem da gruta, um Mago de Sujeira aparece para impedi-los!");
                        new Combate("Mago");
                        loading(2000);
                        System.out.println("Você vence a batalha e adquire o item: Coletor de Lixo!");
                        Inventario.adcItem("Coletor de Lixo");
                        encontrouAmigo = true;
                        foiEsquerda = true;
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Pier (liberado apenas depois de visitar os dois anteriores)
    public static void acessarPier() {
        System.out.println(separador());
        System.out.println("Com coragem renovada, Senhor Jones finalmente se aproxima do píer...");
    }



}

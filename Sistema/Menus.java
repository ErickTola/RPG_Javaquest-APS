package Sistema;

public class Menus {
    static int escolhaMenu = 0; // Utilizado nas entradas do menu
    static boolean skip = false; // Função de depuração, utilizada para desabilitar o tempo de espera entre dialogos.
    static boolean fimJogo = false; // Utilizada para definir se o jogador chegou ao final do jogo e sair do programa.

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
        if (Heroi.getAnelAtual() != "Nenhum"){
            System.out.println("Anel: " + Heroi.getAnelAtual() + " | "+ Items.descItem(Heroi.getAnelAtual()) + "\n");
        }else{
            System.out.print("Anel: " + Heroi.getAnelAtual() + "\n\n");
        }
        System.out.print("Digite qualquer tecla para continuar: ");
        Entrada.entradaStr();
        }
    // Método utilizado para adicionar pausas
    public static void loading(int ms) {
        try {
            if(!skip) {
                Thread.sleep(ms);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    Método que apresenta a introdução da história
    public static int iniciodaJornada(){
        Heroi.gameInit();
        System.out.println(separador());
        System.out.println("Em uma pacata vila, Senhor Jones, um simples pescador, se entristece com tanta sujeira e poluição na praia.");
        loading(3000);
        System.out.println("Determinado a descobrir o grande causador dessa poluição em massa, Senhor Jones parte em uma grande jornada.");
        loading(3000);

        // Destaque para o capítulo
        System.out.println("\n\n===== CAPÍTULO 1 =====");
        System.out.println("      A Praia Poluída\n");
        loading(3000);
        // Chama o metodo para os caminhos do jogo
        introducaoPraia();
        terrenoFabrica();
        return 0;
    }
//
    // Método para introduzir a situação da praia poluída e a criança
    public static int introducaoPraia() {
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
        return 0;
    }

    // Método quando o jogador escolhe ajudar a criança
    public static int ajudarPIVETE() {
        System.out.println(separador());
        System.out.println("A criança, aliviada, diz:");
        System.out.println("Criança assustada: Aqui, moço, pegue isso!");
        loading(3000);
        System.out.println("A criança lhe entrega um pedaço de madeira, sua primeira arma.");
        loading(2500);
        Items.equipItem("Pedaço de Madeira");  // método para adicionar o item ao inventário
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
        if (!Heroi.getVivo()){return 0;}
        avancarCentroDaPraia(); // CONTINUA a história normal para ambos
        return 0;
    }

    // Método quando o jogador escolhe ignorar a criança
    public static int ignorarPIVETE() {
        System.out.println(separador());
        System.out.println("Senhor Jones: Desculpa guri, tenho outras coisas para fazer.");
        System.out.println("Você ignora a criança e segue adiante.");
        avancarCentroDaPraia(); // CONTINUA a história normal para ambos
        return 0;
    }

    // Método que inicia o combate com o Slime de Chorume
    public static int combateSlime() {
        System.out.println(separador());
        System.out.println("Com seu pedaço de madeira em mãos, Senhor Jones se prepara para iniciar o seu primeiro combate nessa grande jornada.");
        loading(2000);
        System.out.println("O Slime de Chorume começa a se mover em sua direção, pronto para atacar!");
        // Inicia o combate com o Slime de Chorume
        new Combate("Slime");  // Chama o método de combate
        if (!Heroi.getVivo()){return 0;}
        loading(2000);
        menuStats();
        return 0;
    }
    // Após o evento com a criança
    public static int avancarCentroDaPraia() {
        System.out.println(separador());
        System.out.println("Senhor Jones segue até o centro da praia. A visão é ainda pior: lixo por todos os lados e um cheiro insuportável no ar.");
        loading(3000);
        System.out.println("A tristeza se mistura à revolta. Ele fecha os punhos, determinado a encontrar o verdadeiro culpado.");
        loading(3000);

        // Começar escolha das próximas rotas
        explorarCentroPraia(false, false);
        return 0;
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
                    break; // fim das escolhas
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

    // Metodo de caminho pro Quiosque
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

    // Metodo de caminho pra Orla
    public static void visitarOrla() {
        System.out.println(separador());
        System.out.println("Senhor Jones vai até a orla da praia, em passos leves.");
        loading(3000);
        System.out.println("Ele avista um grupo de jovens preocupados. Um deles se aproxima:");
        loading(3000);
        System.out.println("Azevedo: Ei, senhor! Você viu nosso amigo? Ele saiu pra limpar a praia e não voltou.");
        loading(2000);

        boolean resolveuOrla = false;
        boolean jaPerguntouSobreDesaparecido = false;

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
                    System.out.println("Azevedo: Não sei como te agradecer, senhor. Tome, pegue isto para se proteger desse lixo todo.");
                    loading(2000);
                    System.out.println("Você recebe: Mantos reforçados.");
                    Items.equipItem("Mantos reforçados");
                    resolveuOrla = true;
                    loading(2000);
                    break;
                case 2:
                    System.out.println("Senhor Jones: Sinto muito, mas tenho mais coisas a fazer.");
                    resolveuOrla = true;
                    loading(2000);
                    break;
                case 3:
                    if (jaPerguntouSobreDesaparecido) {
                        System.out.println("Azevedo: Eu acabei de dizer sobre ele... você está bem?");
                        loading(2000);
                    } else {
                        System.out.println("Azevedo: O nome dele é Henry. Ele estava vestindo um casaco preto e um tênis amarelo da marca New Horizon.");
                        loading(2000);
                        System.out.println("Azevedo: A última vez que foi visto, foi perto da Gruta Poluída.");
                        loading(2000);
                        jaPerguntouSobreDesaparecido = true;
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        System.out.println("Você retorna ao centro da praia e parte a caminho do píer.");
        loading(2000);
        acessarPier();
    }

    // Missão: resgate do soldado Henry
    public static int grutaPoluida() {
        boolean encontrouAmigo = false;
        boolean foiDireita = false;
        boolean foiMeio = false;
        boolean foiEsquerda = false;

            System.out.println(separador());
            System.out.println("Senhor Jones parte até a gruta.");
            loading(3000);
            System.out.println("O caminho fedia e estava infestado de lixo. Mas Senhor Jones chega ao local.");
            loading(3000);
            while (!encontrouAmigo) {
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
                        loading(2000);
                        System.out.println("Mas encontra uma pequena Poção de Cura!");
                        loading(2000);
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
                        if (!Heroi.getVivo()){return 0;}
                        loading(2000);
                        menuStats();
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
                        if (!Heroi.getVivo()){return 0;}
                        loading(2000);
                        menuStats();
                        System.out.println("\nVocê vence a batalha e adquire o item: Coletor de Lixo!");
                        Items.equipItem("Coletor de Lixo");
                        encontrouAmigo = true;
                        foiEsquerda = true;
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        return 0;
    }

    // Pier (liberado apenas depois de visitar os dois anteriores)
    public static void acessarPier() {
        System.out.println(separador());
        System.out.println("Com coragem renovada, Senhor Jones finalmente se aproxima do píer...");
        loading(3000);
        System.out.println("A madeira do píer está coberta de sujeira e garrafas jogadas ao vento.");
        loading(2000);
        System.out.println("Mas com o Coletor de Lixo em mãos, ele poderá limpar o caminho.");
        loading(3000);
        System.out.println("Ao tentar entrar, um ser brilhante aparece diante dele...");
        loading(3000);
        System.out.println("??? : Você, nobre guerreiro, desejas eliminar todo mal e poluição deste lugar?");
        loading(3000);
        System.out.println("??? : Mas antes, terá que passar por um desafio.");
        loading(2000);
        System.out.println("Senhor Jones: E quem é você?");
        loading(2000);
        System.out.println("Mestre da Reciclagem: Sou o Mestre da Reciclagem, guardião do píer!");
        loading(3000);
        System.out.println("Senhor Jones: Espera aí!");
        loading(2000);
        System.out.println("Senhor Jones: ....");
        loading(3000);
        System.out.println("Senhor Jones: Você não é o seu Joaquim que trabalha no açougue?");
        loading(3000);
        System.out.println("Mestre da Reciclagem: Não.");
        loading(3000);
        System.out.println("Senhor Jones: Claro que é. Você tá fedendo com essas roupas.");
        loading(2000);
        System.out.println("Mestre da Reciclagem: CALADO! Apenas aceite o desafio para passar para o píer.");
        loading(3000);
        System.out.println("Senhor Jones: Tá, vamos nessa.");
        loading(2000);
        desafioReciclagem();
    }

    // Desafio de reciclagem com o Mestre da Reciclagem
    public static int lerEscolhaValida() {
        int escolha = 0;
        boolean valido = false;
        while (!valido) {
            try {
                escolha = Entrada.entradaInt();
                if (escolha >= 1 && escolha <= 5) {
                    valido = true;
                } else {
                    System.out.println("Opção inválida! Digite um número entre 1 e 5.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número entre 1 e 5.");
                // evitar errinhos bestas
            }
        }
        return escolha;
    }

    public static void desafioReciclagem() {
        System.out.println(separador());
        System.out.println("Mestre da Reciclagem: Antes de começarmos, escute com atenção, jovem guerreiro...");
        loading(2000);
        System.out.println("Essas são as cores das lixeiras e seus materiais:");
        System.out.println("1) Azul     - Papéis e papelão");
        System.out.println("2) Vermelho - Plásticos");
        System.out.println("3) Verde    - Vidros");
        System.out.println("4) Amarelo  - Metais");
        System.out.println("5) Marrom   - Lixo orgânico");
        loading(3500);
        System.out.println("Mestre da Reciclagem: Agora, mostre que você é digno de seguir adiante!");
        loading(1500);

        // PERGUNTA 1
        System.out.println(separador());
        System.out.println("Mestre da Reciclagem: Em qual lixeira devo jogar uma Garrafa PET?");
        System.out.println("1) Azul\n2) Vermelho\n3) Verde\n4) Amarelo\n5) Marrom");
        int escolha1 = 0;
        while (escolha1 != 2) {
            escolha1 = lerEscolhaValida();
            if (escolha1 == 2) {
                System.out.println("Mestre da Reciclagem: Muito bem! Garrafa PET vai na lixeira vermelha.");
            } else {
                System.out.println("Mestre da Reciclagem: Você errou! Tente novamente.");
            }
        }
        loading(1500);

        // PERGUNTA 2
        System.out.println(separador());
        System.out.println("Mestre da Reciclagem: E um jornal velho?");
        System.out.println("1) Azul\n2) Vermelho\n3) Verde\n4) Amarelo\n5) Marrom");
        int escolha2 = 0;
        while (escolha2 != 1) {
            escolha2 = lerEscolhaValida();
            if (escolha2 == 1) {
                System.out.println("Mestre da Reciclagem: Correto! Papel vai na lixeira azul.");
            } else {
                System.out.println("Mestre da Reciclagem: Tente novamente.");
            }
        }
        loading(1500);

        // PERGUNTA 3
        System.out.println(separador());
        System.out.println("Mestre da Reciclagem: Restos de comida?");
        System.out.println("1) Azul\n2) Vermelho\n3) Verde\n4) Amarelo\n5) Marrom");
        int escolha3 = 0;
        while (escolha3 != 5) {
            escolha3 = lerEscolhaValida();
            if (escolha3 == 5) {
                System.out.println("Mestre da Reciclagem: Exato! Lixo orgânico vai na marrom.");
            } else {
                System.out.println("Mestre da Reciclagem: Tente novamente.");
            }
        }
        loading(1500);

        // PERGUNTA 4
        System.out.println(separador());
        System.out.println("Mestre da Reciclagem: E um pote de vidro?");
        System.out.println("1) Azul\n2) Vermelho\n3) Verde\n4) Amarelo\n5) Marrom");
        int escolha4 = 0;
        while (escolha4 != 3) {
            escolha4 = lerEscolhaValida();
            if (escolha4 == 3) {
                System.out.println("Mestre da Reciclagem: Muito bem! Vidros vão na lixeira verde.");
            } else {
                System.out.println("Mestre da Reciclagem: Tente novamente.");
            }
        }
        loading(1500);

        // PERGUNTA 5
        System.out.println(separador());
        System.out.println("Mestre da Reciclagem: E uma latinha de refrigerante?");
        System.out.println("1) Azul\n2) Vermelho\n3) Verde\n4) Amarelo\n5) Marrom");
        int escolha5 = 0;
        while (escolha5 != 4) {
            escolha5 = lerEscolhaValida();
            if (escolha5 == 4) {
                System.out.println("Mestre da Reciclagem: Exatamente! Metais vão na amarela.");
            } else {
                System.out.println("Mestre da Reciclagem: Tente novamente.");
            }
        }

        System.out.println("Mestre da Reciclagem: Muito bem, guerreiro. A passagem está liberada.");
        loading(2000);
        System.out.println("Mestre da Reciclagem: Mas antes, pegue isto, você vai precisar....");
        loading(2000);
        Inventario.adcItem("Cura Grande");
        Inventario.adcItem("Poção de Precisão");
        System.out.println("Você recebeu uma poção de cura grande e uma poção de precisão!");
        loading(2000);
        System.out.println("Você descansa e se sente totalmente revigorado!");
        Heroi.adcVida(35);
        loading(2000);
        avancarPierFinal();
    }

    // Caminhada e batalha final do capítulo 1
    public static int avancarPierFinal() {
        System.out.println(separador());
        System.out.println("Senhor Jones atravessa os portões do píer.");
        loading(2000);
        System.out.println("Com sua grande determinação, ele começa a limpar o caminho, passo a passo...");
        loading(3000);
        System.out.println("Sacos plásticos voam, latas rolam por entre seus pés, mas ele não para.");
        loading(3000);
        System.out.println("Após uma longa caminhada, ele chega ao final do píer.");
        loading(2000);
        System.out.println("Diante dele, uma imensa MONTANHA de garrafas PET se move...");
        loading(3000);
        System.out.println("Delas, se ergue uma criatura grotesca, feita inteiramente de plástico sujo e deformado.");
        loading(1500);
        System.out.println("\n\n===== BOSS =====");
        System.out.println("     O GOLEM DE PLÁSTICO!\n");
        loading(2000);
        new Combate("Golem");
        if (!Heroi.getVivo()){return 0;}
        loading(2000);
        menuStats();
        System.out.println("\nApós uma batalha intensa, Senhor Jones destrói o Golem de Plástico!");
        loading(3000);
        System.out.println("A montanha de lixo desmorona. Um raio de sol rompe as nuvens pela primeira vez em dias.");
        loading(3000);
        System.out.println("Senhor Jones percebe que a água está com um resíduos pesados e com aspectos gordurosos.");
        loading(3000);
        System.out.println("Senhor Jones tenta avistar a origem desse problema e assustadoramente...");
        loading(3500);
        System.out.println("Senhor Jones: A fábrica do meu irmão...?");
        loading(3000);
        System.out.println(" ===== FIM DO CAPÍTULO 1. ===== ");
        return 0;
    }
    // Caminha até o terreno da fabrica + luta com braço, esfinge e boss final
    public static int terrenoFabrica(){
        System.out.println(separador());
        System.out.println(" ===== INÍCIO CAPÍTULO 2 ===== ");
        System.out.println("      Terreno Fabrica\n");
        System.out.println("Após querer ir à origem do problema, Senhor Jones caminha até a estrada de terra que leva ao terreno da fábrica.");
        loading(3000);
        System.out.println("O vento sopra forte, levantando poeira e folhas secas ao seu redor.");
        loading(3000);
        System.out.println("Ele respira fundo, encara o portão enferrujado e o empurra com força.");
        loading(3000);
        System.out.println("O portão range, abrindo passagem para um ambiente pesado.");
        loading(3000);
        System.out.println("Passo a passo, Senhor Jones avança entre estruturas corroídas e silhuetas metálicas.");
        loading(3000);
        System.out.println("Sons estranhos ecoam... estalos, chiados... como se a fábrica estivesse viva.");
        loading(3000);
        System.out.println("Ele avista uma parede com braços robóticos se movimentando estranhamente.");
        loading(3000);
        System.out.println("De repente, o chão treme sob seus pés. Os braços notaram ele.");
        loading(3000);
        System.out.println(separador());
        new Combate("Braço");
        if (!Heroi.getVivo()){return 0;}
        loading(3000);
        menuStats();
        System.out.println("\nCom coragem e engenhosidade, Senhor Jones derrota a criatura da fábrica.\n");
        loading(3000);
        System.out.println("Os sons da hidrelétrica chamam a atenção do Senhor Jones, que decide entrar no gerador para analisar a situação do local.\n");
        loading(3000);
        System.out.println("Ao entrar no gerador, avista um empregado cabisbaixo sentado ao lado do dínamo. Ele parece estar analisando a água poluída...\n");
        loading(3000);
        System.out.println("Senhor Jones: O que o senhor faz aqui? Era pra essa fábrica estar em evacuação devido ao estado do ambiente ao redor.");
        loading(3000);
        System.out.println("O empregado se levanta, vira pra ele e diz: Sabe, essas águas costumavam ser tão limpas, agora não servem nem pra irrigar uma planta.");
        loading(3000);
        System.out.println("Senhor Jones avista o nome dele no crachá: Senhor Erick, eletricista sênior.");
        loading(3000);
        System.out.println("Erick: Eu assinei os relatórios que ignoravam o estado da água. Eu ajudei a matar isso aqui.");
        loading(3000);
        System.out.println("Jones: Ainda temos chances de reverter a situação. Irei chegar ao final da fábrica e resolver tudo, pode confiar em mim!");
        loading(3000);
        System.out.println("Erick: Estou contando com isso! Pegue isso para você, talvez possa te ajudar.");
        Items.equipItem("Espada de Plástico");
        System.out.println("\nVocê ganhou um novo item: uma afiada espada feita de plástico reciclado. Corta precisamente os inimigos.\n");
        loading(3000);
        System.out.println("Senhor Jones, após receber o novo item, se sente confiante e avança para o final da fábrica.\n");
        loading(3000);
        System.out.println("Ele se depara com uma espécie de esfinge de lixo, formada por tubos de metais, restos de empilhadeiras e lixo do local.\n");
        loading(3000);
        System.out.println("Jones sabe que a Esfinge está protegendo o causador de tudo isso!\n");
        loading(3000);
        System.out.println("Ele avança para falar com ela\n");
        loading(3000);
        System.out.println("Esfinge de Lixo: Ser insignificante, você só passará caso acerte meu enigma e, caso erre... sofrerá as consequências.\n");
        loading(3000);

        // ENIGMA Esfinge
        System.out.println(separador());
        System.out.println(
                separador()+
                        "O que é, o que é?\n" +
                        "Sou invisível, mas me faço notar,\n" +
                        "empurro gigantes que dançam sem parar.\n" +
                        "Não broto da terra, nem brilho como o luar,\n" +
                        "mas giro com força, sem nunca me cansar.\n\n" +
                        "\n"+
                        "1) Energia solar\n" +
                        "2) Energia hidráulica\n" +
                        "3) Energia eólica\n" +
                        "4) Energia de biomassa\n" +
                        "5) Energia nuclear");
                        System.out.print("Digite sua escolha: ");
        // sistema de escolha do enigma
        int escolhaEnigma = 0;
                escolhaEnigma = lerEscolhaValida();
            if (escolhaEnigma == 3) {
                System.out.println("\nVejo que você é uma pessoa sábia, pode passar, e leve isso com você");
                loading(3000);
            } else {
                System.out.println("Errado! Francamente, e ainda se dizem a raça mais evoluída...");
                new Combate("Esfinge");
                if (!Heroi.getVivo()){return 0;}
                loading(2000);
                menuStats();

            }
        Inventario.adcItem("Cura Grande");
        Items.equipItem("Armadura Robótica");
        Items.equipItem("Anel de Hermes");
        System.out.println("Você recebeu uma poção de cura grande, uma Armadura Robótica e Anel de Hermes! (+4 de defesa , +20 de HP e +3 de agilidade!)\n");
        System.out.println("Você se sente totalmente revigorado!");
        Heroi.adcVida(100);
        System.out.println(separador());
        System.out.println("Após passar pela Esfinge, Jones atravessa a porta que ela estava protegendo e se depara com seu irmão, Jack, o dono da fábrica.\n");
        loading(3000);
        System.out.println("Jones sabia que teria que enfrentar Jack para, enfim, acabar com essa poluição em massa.\n");
        loading(3000);
        System.out.println("===== FIM DO CAPÍTULO 2.=====\n");
        loading(2000);
        System.out.println("===== A BATALHA FINAL =====\n");
        loading(3000);
        System.out.println("Jones: Irmão, você nunca se importou com os outros. Não me surpreende você não ligar para o nosso planeta.");
        loading(3000);
        System.out.println("Jack: HAHAHAHHHHHA! Imaginei que você viria para me derrotar. Você e esse seu altruísmo patético...");
        loading(3000);
        System.out.println("Minha conta bancária tá bem gorda graças a isso. (Ele abre os braços se referindo à fábrica)");
        loading(3000);
        System.out.println("Jack: Esse é só o começo. Você não conseguirá me impedir, igual fez com os incompetentes anteriores.");
        loading(3000);
        System.out.println("Jones: Não me faça fazer isso, irmão. Por favor, se entregue! Não quero derrotar você.");
        loading(3000);
        System.out.println("Jack: Como se você fosse capaz!");
        loading(3000);
        System.out.println("Jack entra em um corpo robótico para poder enfrentar Jones.");
        System.out.println("Jones: Veremos!");
        new Combate("Boss");
        if (!Heroi.getVivo()){return 0;}
        loading(2000);
        menuStats();
        System.out.println("Após uma luta árdua com seu irmão, Jones sai vitorioso, prende seu irmão e espera a chegada da polícia ambiental.\n");
        loading(3000);
        System.out.println("Antes da chegada da polícia, eles conseguem ter um breve diálogo.\n");
        loading(3000);
        System.out.println("Jones: Você me obrigou a fazer isso. Eu podia ter te ajudado! Precisamos cuidar do nosso planeta.");
        loading(3000);
        System.out.println("Jack: Você está certo, irmão. Eu pensei que não tinha volta, mas se todos nós fizermos nossa parte, já ajuda!");
        loading(3000);
        System.out.println("Jack: Quando eu ficar livre, irei me redimir e com certeza ajudarei o meio ambiente.\n");
        loading(3000);
        System.out.println("A polícia ambiental leva Jack em custódia, agradece Jones pelos serviços prestados em prol do meio ambiente, e diz que tomarão conta da fábrica.\n");
        loading(3000);
        System.out.println("Ao final dessa longa jornada, Jones retorna para sua vila e toma um belo banho (ele realmente estava precisando).\n");
        loading(3000);
        System.out.println("Ele caminha em direção à praia, repara que o ar já não está mais pesado, puxa o ar com vigor e se sente aliviado por ter conseguido ajudar a vila.\n");
        loading(3000);
        System.out.println("===== PARABÉNS, VOCÊ CONCLUIU O JOGO =====");
        fimJogo = true;
        return 0;
    }
}



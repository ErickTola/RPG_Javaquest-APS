package Sistema;
import Inimigos.*;

public class Combate {
    static int TurnoAtual = 1;
    public Inimigo InimigoAtual; // Declaração de váriavel com o tipo da classe
    int initHero;
    int initEnem;
    public static int opcao = 0;
    boolean ordem;
    boolean stun = false;

    Combate(String escolha){ // (Metodo construtor)


        //Seleciona o inimigo a partir do parâmetro dado na instanciação do objeto de combate.
        switch(escolha) {
            case "Golem":
                InimigoAtual = new GolemPrastico(); // (Polimorfismo de classe)
                System.out.println("\nUm Golem de plástico selvagem aparece!!");
                break;
            case "Slime":
                InimigoAtual = new Slime(); // (Polimorfismo de classe)
                System.out.println("\nVocê se depara com um Slime de Chorume!!");
                break;
            case "Mago":
                InimigoAtual = new Mago();
                System.out.println("\nUm Mago de sujeira surge duma pilha de lixo!");
                break;
            case "Braço":
                InimigoAtual = new BracosRobos();
                System.out.println("\nUma parede de braços te encara!");
                break;
            case "Trabalhador":
                InimigoAtual = new Trabalhador();
                System.out.println("\nUm trabalhador desesperado te enfrenta!");
                break;
            case "Carregador":
                InimigoAtual = new CarregadorRobo();
                System.out.println("\nUm Robô de carga bloqueia seu caminho!");
                break;
            case "Rato":
                InimigoAtual = new Rato();
                System.out.println("\nUm grande Rato mutante quer fazer você de janta!");
                break;
            case "Sentinela":
                InimigoAtual = new SentinelaRobo();
                System.out.println("\nUm Sentinela Robô da cidade te enfrenta!");
                break;
            case "Guarda":
                InimigoAtual = new GuardaRobo();
                System.out.println("\nUm Guarda robôtico empede sua passagem!");
                break;
            case "Ciborgue":
                InimigoAtual = new Ciborgue();
                System.out.println("\nO Ciêntista Ciborgue quer acabar com você!");
                break;
            case "Boss":
                InimigoAtual = new Gigaboss();
                System.out.println("\nO Grande Chefe te encara malignamente!");
                break;
            default:
                InimigoAtual = new Dummy();
                System.out.println("\nUm erro na instanciação de inimigos ocorreu!!");
                InimigoAtual.rmvVida(0);
                break;

        }

        // Calcula iniciativa

        initHero = Heroi.inciativa();
        initEnem = InimigoAtual.inciativa();

        ordem = initEnem <= initHero;

        // Inicia os turnos de combate
        while (InimigoAtual.vivo && Heroi.getVivo()){
            int tmpAtk = 0;
            int tmpDmg = 0;
            boolean atacou = false;

            if (!ordem) {
                //Turno do Inimigo

                if (InimigoAtual.ataque() >= Heroi.defesa()) {
                    int tmpDano = InimigoAtual.dano();
                    stun = InimigoAtual.perdeVez;
                    Heroi.rmvVida(tmpDano);
                    InimigoAtual.adcDebuff();
                    if(tmpDano != 0) {
                        System.out.println("\nVocê recebe " + tmpDano + " de Dano!");
                        System.out.println("\nSua vida: " + Heroi.getHp());
                    }
                } else {
                    System.out.println("\n" + InimigoAtual.getNome() + " errou o ataque!");
                    stun = false;
                }

                //Verifica se a vida do jogador está acima de 0
                if (!Heroi.getVivo()) {
                    System.out.println("FIM DE JOGO!");
                    Heroi.gameOver();
                    break;
                }
                ordem = true;
            }
            if (ordem) {
                // Turno do herói
                Heroi.InicioTurno();
                if(!stun){
                    while(opcao == 0){
                    Menus.menuCombate();
                        switch (opcao) {
                            case 1:
                                opcao = -1;
                                tmpAtk = Heroi.getAtk() + 1;
                                if (Heroi.getDmg() > 0) {
                                    tmpDmg = Heroi.getDmg();
                                }
                                if (Heroi.getDmg() <= 0) {
                                    tmpDmg = 1;
                                }
                                atacou = true;
                                break;
                            case 2:
                                opcao = -1;
                                if (Heroi.getAtk() > 0) {
                                    tmpAtk = Heroi.getAtk();
                                }
                                if (Heroi.getAtk() <= 0) {
                                    tmpAtk = 1;
                                }
                                tmpDmg = Heroi.getDmg() + 1;
                                atacou = true;
                                break;
                            case 3:
                                opcao = -1;
                                Heroi.riseDef();
                                break;
                        }
                    }
                    opcao = 0;
                    //Calcula ataque do jogador contra a defesa do inimigo
                    if (atacou) {
                        if (Heroi.ataque(tmpAtk) >= InimigoAtual.defesa()) {
                            int tmpDano = Heroi.dano(tmpDmg);
                            InimigoAtual.rmvVida(tmpDano);
                            System.out.println("\nO inimigo recebe " + tmpDano + " de Dano!");
                            System.out.println("\nVida do inimigo: " + InimigoAtual.getHp());
                        } else {
                            System.out.println("\nVocê errou o ataque!");
                        }
                        //Verifica se a vida do inimigo está acima de 0
                        if (!InimigoAtual.vivo) {
                            System.out.println("Você derrotou o " + InimigoAtual.getNome() + "!");
                            break;
                        }

                    }
                }else{
                    System.out.println("\nVocê não consegue se mover por um turno!");
                    System.out.print(Menus.separador());
                }
                ordem = false;
            }
            //Contabiliza o fim do turno.
                TurnoAtual += 1;
        }
    }

}

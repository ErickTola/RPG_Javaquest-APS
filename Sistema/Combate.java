package Sistema;
import Inimigos.*;

public class Combate {
    //Definição da variavel das classes
    static int TurnoAtual = 1;
    public Inimigo InimigoAtual; // Declaração de váriavel com o tipo da classe
    int initHero;
    int initEnem;
    public static int opcao = 0; // Declaração estática
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
                InimigoAtual = new Mago();// (Polimorfismo de classe)
                System.out.println("\nUm Mago de sujeira surge duma pilha de lixo!");
                break;
            case "Braço":
                InimigoAtual = new BracosRobos();// (Polimorfismo de classe)
                System.out.println("\nUma parede de braços se prepara pra te atacar!");
                break;
            case "Boss":
                InimigoAtual = new Gigaboss();// (Polimorfismo de classe)
                System.out.println("\nO Grande Chefe te encara malignamente!");
                break;
            case "Esfinge":
                InimigoAtual = new EsfingedeLixo();// (Polimorfismo de classe)
                System.out.println("\nA Esfinge de Lixo vai impedir você de passar");
                break;
            default:
                InimigoAtual = new Dummy();// (Polimorfismo de classe)
                System.out.println("\nUm erro na instanciação de inimigos ocorreu!!");
                InimigoAtual.rmvVida(0);
                break;

        }

        // Calcula iniciativa

        initHero = Heroi.inciativa();
        initEnem = InimigoAtual.inciativa();

        ordem = initEnem <= initHero; // verifica se você ou o inimigo começara

        // Inicia os turnos de combate
        while (InimigoAtual.vivo && Heroi.getVivo()){
            int tmpAtk = 0;
            int tmpDmg = 0;
            boolean atacou = false;

            if (!ordem) {
                //Turno do Inimigo
                //Calcula o ataque inimigo contra a defesa do herói
                if (InimigoAtual.ataque() >= Heroi.defesa()) {
                    int tmpDano = InimigoAtual.dano();
                    stun = InimigoAtual.perdeVez; // Recebe a booleana para pular o turno do heroi
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

                //Verifica se a vida do jogador está acima de 0 e chama a função de recomeçar o programa.
                if (!Heroi.getVivo()) {
                    System.out.println("FIM DE JOGO!");
                    Heroi.gameOver();
                    break;
                }
                ordem = true; //Passa a vez para o jogador
            }
            if (ordem) {
                // Turno do herói
                Heroi.InicioTurno();
                if(!stun){
                    while(opcao == 0){ // Garante que o jogador não selecione opções não existentes e consiga entrar e sair de menus.
                    Menus.menuCombate(); // Abre as opções de combate
                        switch (opcao) { // Seleciona o ataque escolhido pelo jogador.
                            case 1: // Ataque certeiro (+1 dado para acertar)
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
                            case 2: // Ataque poderoso (+1 de dano)
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
                            case 3: // Aumenta a defesa em +1
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
                        //Verifica se a vida do inimigo está acima de 0 e termina o combate
                        if (!InimigoAtual.vivo) {
                            System.out.println("Você derrotou o " + InimigoAtual.getNome() + "!");
                            Heroi.setDesv(false);
                            Heroi.setVantagem(false);
                            Heroi.setVeneno(false);
                            break;
                        }

                    }
                }else{
                    System.out.println("\nVocê não consegue se mover por um turno!"); // Case stun = true;
                    System.out.print(Menus.separador());
                }
                ordem = false; // Passa a vez para o inimigo.
            }
            //Contabiliza o fim do turno.
                TurnoAtual += 1;
        }
    }

}

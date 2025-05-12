package Sistema;

import Inimigos.GolemPrastico;
import Inimigos.Inimigo;
import Inimigos.Slime;

public class Combate {
    static int TurnoAtual = 1;
    Inimigo InimigoAtual; // Declaração de váriavel com o tipo da classe
    int initHero;
    int initEnem;
    boolean ordem;

    Combate(String escolha){ // (Metodo construtor)


        //Seleciona o inimigo a partir do parâmetro dado na instanciação do objeto de combate.
        switch(escolha) {
            case "Golem":
                InimigoAtual = new GolemPrastico(); // (Polimorfismo de classe)
                System.out.println("\nUm Golem selvagem aparece!!");
                break;
            case "Slime":
                InimigoAtual = new Slime(); // (Polimorfismo de classe)
                System.out.println("\nVocê se depara com um Slime!!");
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
                //Turno do Inimigos.Inimigo
                if (InimigoAtual.ataque() >= Heroi.defesa()) {
                    int tmpDano = InimigoAtual.dano();
                    Heroi.rmvVida(tmpDano);
                    InimigoAtual.adcDebuff();
                    System.out.println("\nVocê recebe " + tmpDano + " de Dano!");
                    System.out.println("\nSua vida: " + Heroi.getHp());
                } else {
                    System.out.println("\n" + InimigoAtual.getNome() + " errou o ataque!");
                }
                //Verifica se a vida do jogador está acima de 0
                if (!Heroi.getVivo()) {
                    System.out.println("FIM DE JOGO!");
                    break;
                }
                ordem = true;
            }
            if (ordem) {
                // Turno do herói
                Heroi.InicioTurno();
                int opcao = Menus.menuCombate();
                switch (opcao) {
                    case 1:
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
                        Heroi.riseDef();
                        break;
                    default:
                        break;
                }
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
                ordem = false;
            }
            //Contabiliza o fim do turno.
                TurnoAtual += 1;
        }
    }

}

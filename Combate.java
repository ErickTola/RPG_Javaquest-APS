public class Combate {
    static int TurnoAtual = 1;
    Inimigo InimigoAtual; // Declaração de váriavel com o tipo da classe
    int initHero;
    int initEnem;
    int escolhaatk;
    boolean ordem;

    Combate(String escolha){ // (Metodo construtor)


        //Seleciona o inimigo a partir do parâmetro dado na instanciação do objeto de combate.
        switch(escolha) {
            case "Golem":
                InimigoAtual = new GolemPrastico(); // (Polimorfismo de classe)
                System.out.println("\nUm Golem selvagem aparece!!");
                break;
            case "Slime":
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
            if (!ordem) {
                //Turno do Inimigo
                if (InimigoAtual.ataque() >= Heroi.defesa()) {
                    int tmpDano = InimigoAtual.dano();
                    Heroi.rmvVida(tmpDano);
                    InimigoAtual.adcDebuff();
                    System.out.println("\nVocê recebe " + tmpDano + " de Dano!");
                    System.out.println("\nSua vida: " + Heroi.getHp());
                } else {
                    System.out.println("\n" + InimigoAtual.nome + " errou o ataque!");
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
                System.out.println(
                        """
                                -------------------------------------
                                O que deseja fazer?
                                
                                1 - Ataque certeiro (+1 dado de acerto)
                                2 - Ataque poderoso (+1 dado de dano)
                                """);
                System.out.print("Digite sua escolha: ");
                //Recolhe o valor de entrada do jogador e faz com que seja impossivel de colocar um valor acima ou abaixo do listado
                escolhaatk = Entrada.entradaInt();
                while (escolhaatk <= 0 || escolhaatk > 2) { // (Tratamento de excessões)

                    System.out.println(
                            """
                                    -------------------------------------
                                    O que deseja fazer?
                                    
                                    1 - Ataque certeiro (+1 dado de acerto)
                                    2 - Ataque poderoso (+1 dado de dano)
                                    """);
                    System.out.print("Digite sua escolha: ");
                    escolhaatk = Entrada.entradaInt();
                }
                //Executa a ação selecionada pelo jogador
                switch (escolhaatk) {
                    case 1:
                        tmpAtk = Heroi.getAtk() + 1;
                        if (Heroi.getDmg() > 0) {
                            tmpDmg = Heroi.getDmg();
                        }
                        if (Heroi.getDmg() <= 0) {
                            tmpDmg = 1;
                        }
                        System.out.println(tmpAtk);
                        break;
                    case 2:
                        if (Heroi.getAtk() > 0) {
                            tmpAtk = Heroi.getAtk();
                        }
                        if (Heroi.getAtk() <= 0) {
                            tmpAtk = 1;
                        }
                        tmpDmg = Heroi.getDmg() + 1;
                        System.out.println(tmpAtk);
                        break;
                }
                //Calcula ataque do jogador contra a defesa do inimigo
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
                    System.out.println("Você derrotou o " + InimigoAtual.nome + "!");
                    break;
                }
                ordem = false;
            }
            //Contabiliza o fim do turno.
                TurnoAtual += 1;
        }
    }

}

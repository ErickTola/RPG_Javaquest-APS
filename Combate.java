public class Combate {
    static int TurnoAtual = 1;
    Inimigo InimigoAtual;
    int initHero;
    int initEnem;
    int escolhaatk;

    Combate(String escolha){



        switch(escolha) {
            case "Golem":
                InimigoAtual = new GolemPrastico();
                System.out.println("\nUm Golem selvagem aparece!!");
                break;
            case "Slime":
                break;
        }

        initHero = heroi.inciativa();
        initEnem = InimigoAtual.inciativa();

        while (InimigoAtual.vivo && heroi.vivo){
            int tmpAtk = 0;
            int tmpDmg = 0;
            if (initEnem > initHero) {

                //Turno do Inimigo
                if (InimigoAtual.ataque() >= heroi.defesa()) {
                    int tmpDano = InimigoAtual.dano();
                    heroi.rmvVida(tmpDano);
                    System.out.println("\nVocê recebe " + tmpDano + " de Dano!");
                    System.out.println("\nSua vida: " + heroi.hp);
                } else {
                    System.out.println("\n" + InimigoAtual.nome + " errou o ataque!");
                }
                if (!heroi.vivo) {
                    System.out.println("FIM DE JOGO!");
                    break;
                }
                // Turno do herói
                heroi.InicioTurno();
                System.out.println(
                        """
                        -------------------------------------
                        Como deseja atacar?
                        
                        1 - Ataque certeiro (+1 dado de acerto)
                        2 - Ataque poderoso (+1 dado de dano)
                        """);
                System.out.print("Digite sua escolha: ");
                escolhaatk = heroi.entradaInt();
                while (escolhaatk <= 0 || escolhaatk > 2){

                    System.out.println(
                            """
                            -------------------------------------
                            Como deseja atacar?
                            
                            1 - Ataque certeiro (+1 dado de acerto)
                            2 - Ataque poderoso (+1 dado de dano)
                            """);
                    System.out.print("Digite sua escolha: ");
                    escolhaatk = heroi.entradaInt();
                }
                switch(escolhaatk){
                    case 1:
                        tmpAtk = heroi.atk + 1;
                        if (heroi.dmg > 0) {
                            tmpDmg = heroi.dmg;
                        }
                        else if(heroi.dmg < 0){
                            tmpDmg = 1;
                        }
                        System.out.println(tmpAtk + "," + tmpDmg);
                        break;
                    case 2:
                        if (heroi.atk > 0) {
                            tmpAtk = heroi.atk;
                        }
                        else if(heroi.atk <= 0){
                            tmpAtk = 1;
                        }
                        tmpDmg = heroi.dmg + 1;
                        System.out.println(tmpAtk + "," + tmpDmg);
                        break;
                }
                if (heroi.ataque(tmpAtk) >= InimigoAtual.defesa()) {
                    int tmpDano = heroi.dano(tmpDmg);
                    InimigoAtual.rmvVida(tmpDano);
                    System.out.println("\nO inimigo recebe " + tmpDano + " de Dano!");
                    System.out.println("\nVida do inimigo: " + InimigoAtual.hp);
                } else {
                    System.out.println("\nVocê errou o ataque!");
                }
                if (!InimigoAtual.vivo) {
                    System.out.println("Você derrotou o " + InimigoAtual.nome + "!");
                    break;
                }

                TurnoAtual += 1;
            }
            // Turno do herói
            else{
                heroi.InicioTurno();
                System.out.println(
                        """
                        -------------------------------------
                        Como deseja atacar?
                        
                        1 - Ataque certeiro (+1 dado de acerto)
                        2 - Ataque poderoso (+1 dado de dano)
                        """);
                System.out.print("Digite sua escolha: ");
                escolhaatk = heroi.entradaInt();
                while (escolhaatk <= 0 || escolhaatk > 2){

                    System.out.println(
                            """
                            -------------------------------------
                            Como deseja atacar?
                            
                            1 - Ataque certeiro (+1 dado de acerto)
                            2 - Ataque poderoso (+1 dado de dano)
                            """);
                    System.out.print("Digite sua escolha: ");
                    escolhaatk = heroi.entradaInt();
                }
                switch(escolhaatk){
                    case 1:
                        tmpAtk = heroi.atk + 1;
                        if (heroi.dmg > 0) {
                            tmpDmg = heroi.dmg;
                        }
                        else if(heroi.dmg < 0){
                            tmpDmg = 1;
                        }
                        System.out.println(tmpAtk + "," + tmpDmg);
                        break;
                    case 2:
                        if (heroi.atk > 0) {
                            tmpAtk = heroi.atk;
                        }
                        else if(heroi.atk <= 0){
                            tmpAtk = 1;
                        }
                        tmpDmg = heroi.dmg + 1;
                        System.out.println(tmpAtk + "," + tmpDmg);
                        break;
                }
                if (heroi.ataque(tmpAtk) >= InimigoAtual.defesa()) {
                    int tmpDano = heroi.dano(tmpDmg);
                    InimigoAtual.rmvVida(tmpDano);
                    System.out.println("\nO inimigo recebe " + tmpDano + " de Dano!");
                    System.out.println("\nVida do inimigo: " + InimigoAtual.hp);
                } else {
                    System.out.println("\nVocê errou o ataque!");
                }
                if (!InimigoAtual.vivo) {
                    System.out.println("Você derrotou o " + InimigoAtual.nome + "!");
                    break;
                }
                //Turno do Inimigo
                if (InimigoAtual.ataque() >= heroi.defesa()) {
                    int tmpDano = InimigoAtual.dano();
                    heroi.rmvVida(tmpDano);
                    System.out.println("\nVocê recebe " + tmpDano + " de Dano!");
                    System.out.println("\nSua vida: " + heroi.hp);
                } else {
                    System.out.println("\n" + InimigoAtual.nome + " errou o ataque!");
                }
                if (!heroi.vivo) {
                    System.out.println("FIM DE JOGO!");
                    break;
                }
                TurnoAtual += 1;
            }
        }
    }

}

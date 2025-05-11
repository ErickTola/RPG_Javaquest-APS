public class GolemPrastico extends Inimigo{

    GolemPrastico() {
        hp = 35;
        atk = 1;
        def = 1;
        agl = 1;
        dmg = 0;
        nome = "Golem de Plástico";
    }
    public void efeitoEspec(int escolha){
        switch (escolha) {
            case 1:
                System.out.println("\nO Golem arremessa uma pedra!");
                dmg = 2;
                break;
            case 2:
                System.out.println("\nO Golem joga areia em seus olhos!");
                if (heroi.debuffInit <= 0) {
                    heroi.debuffInit += Combate.TurnoAtual;
                    heroi.debuffTempo = 2;
                    heroi.atk -= 1;
                    heroi.desvantagem = true;
                    System.out.println("\nVocê está com dificuldade de atacar agora!");
                }
                dmg = 1;
                break;
        }
    }
}



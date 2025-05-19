package Inimigos;

public class BracosRobos extends Inimigo{// (Herança)


    public BracosRobos(){ // (Construtor)
        //Construtor que substituí os valores da classe pai pelos valores do inimigo em questão.
        this.hp = 40;
        this.maxHp = hp;
        this.atk = 3;
        this.def = 2;
        this.agl = 1;
        this.dmg = 0;
        this.atkUsado = 0;
        this.perdeVez = false;
        this.nome = "Braços Robóticos";

    }

    //Substituí o metodo genérico da classe pai e define os efeitos dos ataques do inimigo atual.
    @Override
    public int ataque(){// (Sobrescrita de metodo)
        int dado = 0;
        for (int x = 0; x < this.atk; x++) {
            int dadoPro = EnemyRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        efeitoEspec(calculadorChance(20)); // Usa um metodo da classe pai que devolve uma escolha baseada em porcentagem de chance de ocorrer (Neste caso 20%)
        return dado;
    }

    // Sobrescreve o metodo abstrato da classe pai e aplica os efeitos do ataque escolhido pelo metodo acima
    @Override
    public void efeitoEspec(int escolha) {// (Sobrescrita de metodo)
        switch (escolha) {
            case 1:
                System.out.println("\nUm dos braços te da um soco!");
                this.dmg = 1;
                this.perdeVez = false;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\nOs braços tentam te agarrar!");
                this.atkUsado = 1;
                this.perdeVez = true;
                this.dmg = 0;
                break;
            default:
                System.out.println("Ocorreu um erro na escolha de ataque");
                this.perdeVez = false;
                break;
        }
    }

    // Sobrescreve o metodo abstrato da classe pai (Inutilizado para este inimigo.)
    @Override
    public void adcDebuff() {// (Sobrescrita de metodo)

    }

}

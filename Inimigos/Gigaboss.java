package Inimigos;

public class Gigaboss extends Inimigo{
    public Gigaboss(){
        this.hp = 35;
        this.maxHp = hp;
        this.atk = 1;
        this.def = 1;
        this.agl = 1;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "O Chefe da Coorporação";
    }

    @Override
    public int ataque(){
        int dado = 0;
        for (int x = 0; x < this.atk; x++) {
            int dadoPro = EnemyRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        efeitoEspec(calculadorChance(20));
        return dado;
    }

    @Override
    public void adcDebuff() {

    }

    @Override
    public void efeitoEspec(int escolha) {
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
}


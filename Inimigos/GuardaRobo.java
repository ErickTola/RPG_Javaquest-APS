package Inimigos;

public class GuardaRobo extends Inimigo{

    public GuardaRobo(){
        this.hp = 35;
        this.maxHp = hp;
        this.atk = 1;
        this.def = 1;
        this.agl = 1;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Guarda Robô";
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
                System.out.println("\nO Guarda atira contra você!");
                this.dmg = 3;
                this.perdeVez = false;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\nO Guarda tenta te segurar em um apertão!");
                this.atkUsado = 1;
                this.perdeVez = true;
                this.dmg = 1;
                break;
            default:
                System.out.println("Ocorreu um erro na escolha de ataque");
                this.perdeVez = false;
                break;
        }
    }
}

package Inimigos;

public class CarregadorRobo extends Inimigo{

    public CarregadorRobo(){
        this.hp = 35;
        this.maxHp = hp;
        this.atk = 1;
        this.def = 3;
        this.agl = 1;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Carregador Robô";
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
                System.out.println("\nO Robô arremesa uma caixa contra você");
                this.dmg = 3;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\nO Robô quebra um barril na própia cabeça!");
                this.atkUsado = 1;
                this.adcVida(EnemyRd.nextInt(1,10));
                this.dmg = 0;
                break;
            default:
                System.out.println("Ocorreu um erro na escolha de ataque");
                break;
        }
    }
}


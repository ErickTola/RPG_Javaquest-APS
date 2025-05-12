package Inimigos;

public class CarregadorRobo extends Inimigo{

    public CarregadorRobo(){
        this.hp = 35;
        this.maxHp = hp;
        this.atk = 1;
        this.def = 1;
        this.agl = 1;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Braços Robóticos";
    }


    @Override
    public void adcDebuff() {

    }

    @Override
    public void efeitoEspec(int escolha) {

    }
}

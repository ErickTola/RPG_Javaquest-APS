package Inimigos;

public class Mago extends Inimigo{

    public Mago(){
        this.hp = 20;
        this.maxHp = hp;
        this.atk = 2;
        this.def = 1;
        this.agl = 3;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Mago de Sujeira";
    }

    @Override
    public void adcDebuff() {

    }

    @Override
    public void efeitoEspec(int escolha) {

    }
}

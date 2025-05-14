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
        switch (this.atkUsado){
            case 1:
                //Verifica se o jogador já não está com alguma desvantagem
                //Salva o turno em que a desvantagem foi incialmente aplicada e determina a sua duração
                if (Sistema.Heroi.getDebuffInit() <= 0) {
                    Sistema.Heroi.aplDesv(3,2,"veneno");
                }
                this.atkUsado = 0;
                break;
            default:
                this.atkUsado = 0;
                break;
        }
    }

    @Override
    public void efeitoEspec(int escolha) {
        switch (escolha) {
            case 1:
                System.out.println("\nO mago lança um raio de lixo!");
                this.dmg = 1;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\nO mago joga uma bola de sujeira venenosa!");
                this.atkUsado = 1;
                this.dmg = 1;
                break;
            default:
                System.out.println("\nOcorreu um erro na escolha de ataque");
                break;
        }
    }
}

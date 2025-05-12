package Inimigos;

public class Slime extends Inimigo{

    public Slime(){
        this.hp = 10;
        this.maxHp = hp;
        this.atk = 1;
        this.def = 1;
        this.agl = 1;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Slime de Chorume";
    }

    @Override
    public void adcDebuff() {
        switch (this.atkUsado){
            case 1:
                //Verifica se o jogador já não está com alguma desvantagem
                //Salva o turno em que a desvantagem foi incialmente aplicada e determina a sua duração
                if (Sistema.Heroi.getDebuffInit() <= 0) {
                    Sistema.Heroi.aplDesv(2,1,"def");
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
                System.out.println("\nO slime ataca com um de seus tentaculos!");
                this.dmg = 1;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\nO slime cospe chorume em você!");
                this.atkUsado = 1;
                this.dmg = 1;
                break;
            default:
                System.out.println("Ocorreu um erro na escolha de ataque");
                break;
        }
    }
}

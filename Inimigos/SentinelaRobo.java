package Inimigos;

public class SentinelaRobo extends Inimigo{

    public SentinelaRobo(){
        this.hp = 35;
        this.maxHp = hp;
        this.atk = 2;
        this.def = 2;
        this.agl = 3;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Sentinela Robô";
    }

    @Override
    public void efeitoEspec(int escolha){ // (Sobrescrita de metodo)
        switch (escolha) {
            case 1:
                System.out.println("\nO Sentinela te dá uma bordoada!");
                this.dmg = 3;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\nO Sentinela joga uma bomba de fumaça de controle!");
                this.atkUsado = 1;
                this.dmg = 1;
                break;
            default:
                System.out.println("Ocorreu um erro na escolha de ataque do golem.");
                break;
        }
    }
    //Substituí o metodo genérico da classe pai e aplica a desvantagem no herói caso o ataque cause desvantagem.
    @Override
    public void adcDebuff(){ // (Sobrescrita de metodo)
        switch (this.atkUsado){
            case 1:
                //Verifica se o jogador já não está com alguma desvantagem
                //Salva o turno em que a desvantagem foi incialmente aplicada e determina a sua duração
                if (Sistema.Heroi.getDebuffInit() <= 0) {
                    Sistema.Heroi.aplDesv(3,2,"atk");
                }
                this.atkUsado = 0;
                break;
            default:
                this.atkUsado = 0;
                break;
        }
    }

}

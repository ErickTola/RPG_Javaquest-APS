package Inimigos;

public class GolemPrastico extends Inimigo{ // (Herança)

    public GolemPrastico() {// (Construtor)
        //Construtor que substituí os valores da classe pai pelos valores do inimigo em questão.
        this.hp = 35;
        this.maxHp = hp;
        this.atk = 1;
        this.def = 3;
        this.agl = 2;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Golem de Plástico";
    }
    //Substituí o metodo genérico da classe pai e define os efeitos dos ataques do inimigo atual.

    @Override
    public void efeitoEspec(int escolha){ // (Sobrescrita de metodo)
        switch (escolha) {
            case 1:
                System.out.println("\nO Golem arremessa uma pedra!");
                this.dmg = 2;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\nO Golem joga areia em seus olhos!");
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
                    Sistema.Heroi.aplDesv(2,1,"atk");
                }
                this.atkUsado = 0;
                break;
            default:
                this.atkUsado = 0;
                break;
        }
    }

}



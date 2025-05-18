package Inimigos;

public class EsfingedeLixo extends Inimigo{

    public EsfingedeLixo(){
        this.hp = 25;
        this.maxHp = hp;
        this.atk = 2;
        this.def = 3;
        this.agl = 1;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Esfinge de Lixo";
    }

    @Override
    public void efeitoEspec(int escolha){ // (Sobrescrita de metodo)
        switch (escolha) {
            case 1:
                System.out.println("\n A esfinge te acerta com uma patada");
                this.dmg = 2;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\n A esfinge pula e o impacto faz voce cair");
                this.atkUsado = 1;
                this.dmg = 2;
                break;
            default:
                System.out.println("Ocorreu um erro na escolha de ataque da esfinge.");
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
                    Sistema.Heroi.aplDesv(2,2,"def");
                }
                this.atkUsado = 0;
                break;
            default:
                this.atkUsado = 0;
                break;
        }
    }
}

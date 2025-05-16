package Inimigos;

public class Ciborgue extends Inimigo{

    public Ciborgue(){
        this.hp = 35;
        this.maxHp = hp;
        this.atk = 1;
        this.def = 1;
        this.agl = 1;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "Ciêntista Ciborgue";
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
        efeitoEspec(EnemyRd.nextInt(1,3));
        return dado;
    }

    @Override
    public void adcDebuff() {
        switch (this.atkUsado){
            case 1:
                //Verifica se o jogador já não está com alguma desvantagem
                //Salva o turno em que a desvantagem foi incialmente aplicada e determina a sua duração
                if (Sistema.Heroi.getDebuffInit() <= 0) {
                    Sistema.Heroi.aplDesv(2,2,"atk");
                }
                this.atkUsado = 0;
                break;
            case 2:
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

    @Override
    public void efeitoEspec(int escolha) {
        switch (escolha) {
            case 1:
                System.out.println("\nO Ciborgue tenta te golpear!");
                this.dmg = 2;
                this.atkUsado = 0;
                break;
            case 2:
                System.out.println("\nO Ciborgue lança uma granada de luz!");
                this.atkUsado = 1;
                this.dmg = 0;
                break;
            case 3:
                System.out.println("\nO Ciborgue joga cola em seus pés!");
                this.atkUsado = 2;
                this.dmg = 0;
                break;
            case 4:
                System.out.println("\nO Ciborgue atira contra você!");
                this.atkUsado = 3;
                this.dmg = 3;
                break;

            default:
                System.out.println("Ocorreu um erro na escolha de ataque");
                break;
        }
    }
}

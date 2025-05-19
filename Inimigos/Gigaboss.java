package Inimigos;

public class Gigaboss extends Inimigo{ // (Herança)
    public Gigaboss(){
        //Construtor que substituí os valores da classe pai pelos valores do inimigo em questão.
        this.hp = 35;
        this.maxHp = hp;
        this.atk = 5;
        this.def = 3;
        this.agl = 5;
        this.dmg = 0;
        this.atkUsado = 0;
        this.nome = "O Chefe da Coorporação";
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
    public void adcDebuff() {// (Sobrescrita de metodo)
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

    //Substituí o metodo genérico da classe pai e define os efeitos dos ataques do inimigo atual.
    @Override
    public void efeitoEspec(int escolha) {// (Sobrescrita de metodo)
        switch (escolha) {
            case 1:
                System.out.println("\n Jack dispara uma rajada de vapor toxico da armadura");
                this.dmg = 5;
                this.perdeVez = false;
                this.atkUsado = 1;
                break;
            case 2:
                System.out.println("\n Jack com sua armadura te prende utilizando uma especie de rede Plástica");
                this.atkUsado = 0;
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

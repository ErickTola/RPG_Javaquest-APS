import java.util.Random;


public class Inimigo {
    Random EnemyRd = new Random();
     int hp;
     int atk;
     int def;
     int agl;
     int dmg;
     String nome;

    public boolean vivo = true;

    protected int ataque(){
        int dado = 0;
        for (int x = 0; x < atk; x++) {
            int dadoPro = EnemyRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        efeitoEspec(EnemyRd.nextInt(1,3));
        return dado;
    }

    protected int defesa(){
        int dado = 0;
        for (int x = 0; x < def; x++) {
            int dadoPro = EnemyRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        return dado;
    }

    protected int inciativa(){
        int dado = 0;
        for (int x = 0; x < agl; x++) {
            int dadoPro = EnemyRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        return dado;
    }

    protected int dano(){
        int dado = 0;
        for (int x = 0; x < dmg; x++) {
            int dadoPro = EnemyRd.nextInt(0, 4) + 1;
            if (dado <= dadoPro) {
                dado += dadoPro;
            }
        }
        return dado;
    }

    protected void efeitoEspec(int escolha){
        switch (escolha) {
            case 1:
                break;
            case 2:
                break;
        }
    }

    protected void rmvVida(int Dano){
        hp -= Dano;

        if (hp <= 0) {
            hp = 0;
            System.out.println("O inimigo foi derrotado!");
            vivo = false;
        }
    }
}

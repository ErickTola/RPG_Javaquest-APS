import java.util.Random;
import java.util.Scanner;

public class heroi {
    static int maxHp = 35;
    static int maxAtk = 1;
    static int maxDef = 1;
    static int maxAgl = 1;
    static int maxDmg = 1;
    static int hp = 35;
    static int atk = 1;
    static int def = 1;
    static int agl = 1;
    static int dmg = 1;
    static int debuffInit = 0;
    static int debuffTempo = 0;
    static boolean desvantagem = false;
    static boolean vivo = true;
    static Random HeroRd = new Random();
    static Scanner scn = new Scanner(System.in);

    protected static int ataque(int atk){
        int dado = 0;
        for (int x = 0; x < atk; x++) {
            int dadoPro = HeroRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        System.out.println("\nVocê ataca!");
        return dado;
    }

    protected static int defesa(){
        int dado = 0;
        for (int x = 0; x < def; x++) {
            int dadoPro = HeroRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        return dado;
    }

    protected static int inciativa(){
        int dado = 0;
        for (int x = 0; x < agl; x++) {
            int dadoPro = HeroRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        return dado;
    }

    protected static int dano(int dmg){
        int dado = 0;
        for (int x = 0; x < dmg; x++) {
            int dadoPro = HeroRd.nextInt(0, 4) + 1;
            if (dado <= dadoPro) {
                dado += dadoPro;
            }
        }
        return dado;
    }

    protected static void rmvVida(int Dano){
        hp -= Dano;

        if (hp <= 0) {
            hp = 0;
            vivo = false;
        }
    }

    static int entradaInt(){
        int tmp = scn.nextInt();
        scn.nextLine();
        return tmp;
    }

    static String entradaStr(){
        return scn.next();
    }

    static void InicioTurno(){
        if (debuffInit + debuffTempo <= Combate.TurnoAtual && desvantagem){
            debuffInit = 0;
            debuffTempo = 0;
            atk = maxAtk;
            def = maxDef;
            agl = maxAgl;
            dmg = maxDmg;
            desvantagem = false;
            System.out.println("Sua desvantagem passou!");
        }
    }

}


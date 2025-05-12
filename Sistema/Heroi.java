package Sistema;

import java.util.Arrays;
import java.util.Random;

public class Heroi {

    // (Atributos Estáticos e Encapsulamento)
    static private int maxHp = 35;
    static private Integer debuffs[] = {0,0,0};
    static private Integer buffs[] = {0,0,0};
    static private String armaAtual = "Pedaço de Madeira";
    static private String armaduraAtual = "Roupas Comuns";
    static private String anelAtual = "Nenhum";
    static private int hp = 35;
    static private int atk = 1;
    static private int def = 1;
    static private int agl = 1;
    static private int dmg = 1;
    static private int debuffInit = 0;
    static private int debuffTempo = 0;
    static private boolean desvantagem = false;
    static private int buffInit = 0;
    static private int buffTempo = 0;
    static private boolean vantagem = false;
    static private boolean vivo = true;
    static private boolean defRose = false;

    static private final Random HeroRd = new Random(); //(Objeto final)

    //Cria um valor aleatório entre 1 e 20, usado para determinar se o ataque acerta o inimigo
    //O número de vezes que um valor é pego é determinado pelo atributo atk
    //Se atk é 2. então pegamos 2 números aleátorios entre 1 e 20 e ficamos com o maior.
    public static int ataque(int atk){
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

    //Funciona igualmente ao ataque, porém é usado para calcular se o ataque inimigo errara.
    public static int defesa(){
        int dado = 0;
        for (int x = 0; x < def; x++) {
            int dadoPro = HeroRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        return dado;
    }

    //Funciona igualmente aos atributos anteriores, o valor dado por essa função será comparado com o valor de iniciativa inimigo, e o com maior valor iniciará o combate.
    public static int inciativa(){
        int dado = 0;
        for (int x = 0; x < agl; x++) {
            int dadoPro = HeroRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        return dado;
    }
    //Cria um valor aleatório entre 1 e 4, usado para determinar o quanto de vida o ataque retira
    //O número de vezes que um valor é pego é determinado pelo atributo dmg, que por sua vez é influenciado pelo ataque escolhido e pelo equipamento do jogador
    //Se dmg é 2 então pegamos 2 números aleatórios entre 1 e 4 e o somamos, retornando o valor total no final da função.
    public static int dano(int dmg){
        int dado = 0;
        for (int x = 0; x < dmg; x++) {
            int dadoPro = HeroRd.nextInt(0, 4) + 1;
            dado += dadoPro;
        }
        return dado;
    }

    //Função para alterarmos o HP de maneira segura, assegurarmos que o HP nunca ficara abaixo de zero e acionar uma variável que determina o fim de jogo.
    public static void rmvVida(int Dano){
        hp -= Dano;

        if (hp <= 0) {
            hp = 0;
            vivo = false;
        }
    }

    public static void adcVida(int Cura){
        hp += Cura;
        System.out.println("Você recuperou "+ Cura +" de vida!");
        if (hp > maxHp){
            hp = maxHp;
        }
    }

    //Função executada sempre que o turno do jogador começa, é usada para calcular a duração das desvantagens, e caso elas tenham acabado removê-las.
    public static void InicioTurno(){
        if (debuffInit + debuffTempo <= Combate.TurnoAtual && desvantagem){
            debuffInit = 0;
            debuffTempo = 0;
            atk -= debuffs[0];
            def -= debuffs[1];
            dmg -= debuffs[2];
            Arrays.fill(debuffs, 0);
            desvantagem = false;
            System.out.println("Sua desvantagem passou!");
        }
        if (buffInit + buffTempo <= Combate.TurnoAtual && vantagem){
            buffInit = 0;
            buffTempo = 0;
            atk -= buffs[0];
            def -= buffs[1];
            dmg -= buffs[2];
            Arrays.fill(buffs, 0);
            vantagem = false;
            System.out.println("Sua vantagem passou!");
        }
        if(defRose){
            def -= 1;
            defRose = false;
        }
    }

    //Função utiliziada para aplicar alguma desvantagem no jogador
    public static void aplDesv(int dur,int valor, String atrb){
        Heroi.debuffInit = Combate.TurnoAtual;
        Heroi.debuffTempo = dur;
        Heroi.desvantagem = true;

        switch(atrb){
            case("atk"):
                atk -= valor;
                debuffs[0] = -valor;
                System.out.println("\nVocê está com dificuldade de atacar agora!");
                break;
            case("def"):
                def -= valor;
                debuffs[1] = -valor;
                if (def <= 0){
                    def = 1;
                }
                System.out.println("\nVocê está com dificuldade para se defender agora!");
                break;
            case("dmg"):
                dmg -= valor;
                debuffs[2] = -valor;
                System.out.println("\nVocê se sente fraco agora!");
                break;
        }

    }

    public static void aplVan(int dur,int valor, String atrb){
        Heroi.buffInit = Combate.TurnoAtual;
        Heroi.buffTempo = dur;
        Heroi.vantagem = true;

        switch(atrb){
            case("atk"):
                atk += valor;
                buffs[0] = valor;
                System.out.println("\nVocê se sente mais preciso!");
                break;
            case("def"):
                def += valor;
                buffs[1] = valor;
                System.out.println("\nVocê está com facilidade para se defender agora!");
                break;
            case("dmg"):
                buffs[2] = valor;
                dmg += valor;
                System.out.println("\nVocê se sente mais forte agora!");
                break;
        }

    }

    public static void riseDef(){
        defRose = true;
        def += 1;
    }

    // (Encapsulamento das variáveis.)
    public static String getHp(){
        return (hp + "/" + maxHp);
    }

    public static int getAtk(){
        return atk;
    }

    public static int getDef(){
        return def;
    }

    public static int getAgl(){
        return agl;
    }

    public static int getDmg(){
        return dmg;
    }

    public static int getDebuffInit(){
        return debuffInit;
    }

    public static boolean getVivo(){
        return vivo;
    }

    public static String getArmaAtual() {
        return armaAtual;
    }

    public static String getArmaduraAtual() {
        return armaduraAtual;
    }

    public static String getAnelAtual() {
        return anelAtual;
    }

    public static void setAtk(int x){
        atk = x;
    }

    public static void setDmg(int x){
        dmg = x;
    }

    public static void setDef(int x){
        def = x;
    }

    public static void setAgl(int x){
        agl = x;
    }

    public static void riseMaxHp(int x){
        maxHp += x;
    }

    public static void setArmaAtual(String armaAtual) {
        Heroi.armaAtual = armaAtual;
    }

    public static void setArmaduraAtual(String armaduraAtual) {
        Heroi.armaduraAtual = armaduraAtual;
    }

    public static void setAnelAtual(String anelAtual) {
        Heroi.anelAtual = anelAtual;
    }
}


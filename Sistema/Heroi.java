package Sistema;
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
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
    static private boolean veneno = false;
    static private int dmgVeneno = 0;

    //Inicia um objeto gerador de números aleatórios.
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
        if (debuffInit + debuffTempo <= Combate.TurnoAtual && (desvantagem || veneno)){
            debuffInit = 0;
            debuffTempo = 0;
            atk -= debuffs[0];
            def -= debuffs[1];
            dmg -= debuffs[2];
            Arrays.fill(debuffs, 0);
            if(desvantagem){
                System.out.println("Sua desvantagem passou!");
                desvantagem = false;
            }
            if(veneno){
                System.out.println("O veneno passou!");
                veneno = false;
            }

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
        if(veneno){
            rmvVida(dmgVeneno);
            System.out.print(Menus.separador());
            System.out.println("Você recebe " + dmgVeneno +" de dano do veneno!");
        }
    }

    //Função utiliziada para aplicar alguma desvantagem no jogador
    public static void aplDesv(int dur,int valor, String atrb){
        debuffInit = Combate.TurnoAtual;
        debuffTempo = dur;
        desvantagem = true;

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
            case("veneno"):
                veneno = true;
                dmgVeneno = valor;
                System.out.println("\nVocê está envenenado!");
                break;
        }

    }

    //Aplica Vantagens para o jogador.
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
    //Aumenta a defesa do jogador por um turno
    public static void riseDef(){
        defRose = true;
        def += 1;
        System.out.println("Você se prepara para se defender!");
    }
    //Metodo para resetar a condição de vivo do jogador após um "Game Over"
    public static void gameInit(){
        vivo = true;
    }

    //Metodo para refedifir todos os atributos do jogador após um "Game Over" e ativar a flag de morte.
    public static void gameOver(){
         maxHp = 35;
         Items.equipItem("Peçaço de Madeira");
         Items.equipItem("Roupas Comuns");
         Items.equipItem("Nenhum");
         hp = 35;
         atk = 1;
         def = 1;
         agl = 1;
         dmg = 1;
         debuffInit = 0;
         debuffTempo = 0;
         desvantagem = false;
         buffInit = 0;
         buffTempo = 0;
         vantagem = false;
         vivo = false;
         defRose = false;
         veneno = false;
         dmgVeneno = 0;
         Inventario.clearInv();
    }

    // (Encapsulamento das variáveis.)
    public static String getHp(){
        return (hp + "/" + maxHp);
    } //(Metodo "getter" / Encapsulamento)

    public static int getAtk(){
        return atk;
    }//(Metodo "getter" / Encapsulamento)

    public static int getDef(){
        return def;
    }//(Metodo "getter" / Encapsulamento)

    public static int getAgl(){
        return agl;
    }//(Metodo "getter" / Encapsulamento)

    public static int getDmg(){
        return dmg;
    }//(Metodo "getter" / Encapsulamento)

    public static int getDebuffInit(){
        return debuffInit;
    }//(Metodo "getter" / Encapsulamento)

    public static boolean getVivo(){
        return vivo;
    }//(Metodo "getter" / Encapsulamento)

    public static String getArmaAtual() {//(Metodo "getter" / Encapsulamento)
        return armaAtual;
    }

    public static String getArmaduraAtual() {//(Metodo "getter" / Encapsulamento)
        return armaduraAtual;
    }

    public static String getAnelAtual() {//(Metodo "getter" / Encapsulamento)
        return anelAtual;
    }

    public static void setAtk(int x){
        atk = x;
    }//(Metodo "setter" / Encapsulamento)

    public static void setDmg(int x){
        dmg = x;
    }//(Metodo "setter" / Encapsulamento)

    public static void setDef(int x){
        def = x;
    }//(Metodo "setter" / Encapsulamento)

    public static void setAgl(int x){
        agl = x;
    }//(Metodo "setter" / Encapsulamento)

    public static void riseMaxHp(int x){
        maxHp += x;
    }//Metodo utilizado para aumentar a vida maxima do jogador

    public static void setArmaAtual(String armaAtual) {//(Metodo "setter" / Encapsulamento)
        Heroi.armaAtual = armaAtual;
    }

    public static void setArmaduraAtual(String armaduraAtual) {//(Metodo "setter" / Encapsulamento)
        Heroi.armaduraAtual = armaduraAtual;
    }

    public static void setAnelAtual(String anelAtual) {//(Metodo "setter" / Encapsulamento)
        Heroi.anelAtual = anelAtual;
    }
}


package Inimigos;

import java.util.Random;


public abstract class Inimigo { // (Classe abstrata)
    // Essa é uma classe gererica de inimigo, onde nós temos todas as funções que um inimigo pode executar em combate, mas não temos as condições especificas de cada inimigo.
    Random EnemyRd = new Random(); // (Instanciação de objeto)
     int hp;
     int maxHp;
     int atk;
     int def;
     int agl;
     int dmg;
     int atkUsado;
     public boolean perdeVez = false;
     String nome;
     public boolean vivo = true;

    //Cria um valor aleatório entre 1 e 20, usado para determinar se o ataque acerta o herói
    //O número de vezes que um valor é pego é determinado pelo atributo atk
    //Se atk é 2 então pegamos 2 números aleatórios entre 1 e 20 e ficamos com o maior.
    //Após verificar se o ataque acerta, ele determina um ataque aleatório que o inimigo executará, causando diversos efeitos.
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
    //Funciona igualmente ao ataque sem a condição de efeitos especiais, porém é usado para calcular se o ataque do herói errara.
    public int defesa(){
        int dado = 0;
        for (int x = 0; x < this.def; x++) {
            int dadoPro = EnemyRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        return dado;
    }
    //Funciona igualmente aos atributos anteriores, o valor dado por essa função será comparado com o valor de iniciativa do herói, e o com maior valor iniciará o combate.
    public int inciativa(){
        int dado = 0;
        for (int x = 0; x < this.agl; x++) {
            int dadoPro = EnemyRd.nextInt(0, 20) + 1;
            if (dado <= dadoPro) {
                dado = dadoPro;
            }
        }
        return dado;
    }

    //Cria um valor aleatório entre 1 e 4, usado para determinar o quanto de vida o ataque retira
    //O número de vezes que um valor é pego é determinado pelo atributo dmg, que por sua vez é influenciado pelo ataque escolhido
    //Se dmg é 2 então pegamos 2 números aleatórios entre 1 e 4 e os somamos, retornando o valor total no final da função.
    public int dano(){
        int dado = 0;
        for (int x = 0; x < this.dmg; x++) {
            int dadoPro = EnemyRd.nextInt(0, 4) + 1;
            dado += dadoPro;
        }
        return dado;
    }

    //Função para alterarmos o HP de maneira segura, assegurarmos que o HP nunca ficara abaixo de zero e acionar uma variável que determina se o jogador venceu o inimigo
    public void rmvVida(int Dano){
        this.hp -= Dano;

        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println("O inimigo foi derrotado!");
            this.vivo = false;
        }
    }

    //Calcula a chance de um ataque acertar a partir de uma porcetagem especificada, dada de 10% em 10%
    public int calculadorChance(int porcentagem){
        int escolha = EnemyRd.nextInt(1,11);
        if (escolha <= (porcentagem/10)){
            return 2;
        }else{
            return 1;
        }
    }

    //Metodo abstrato que adiciona a desvantagem ao jogador caso o ataque inimigo acerte, será implementado nas classes filhas.
    public abstract void adcDebuff();// (Metodo abstráto)

    //Metodo abstrato que determina o efeito especial, será implementado nas classes filhas.
    public abstract void efeitoEspec(int escolha); // (Metodo abstráto)

    //Retorna o HP do inimigo em formato de string
    public String getHp(){ //(Metodo "getter" / Encapsulamento)
        return (this.hp + "/" + this.maxHp);
    }
    //Retorna o nome do inimigo.
    public String getNome(){//(Metodo "getter" / Encapsulamento)
        return nome;
    }

}

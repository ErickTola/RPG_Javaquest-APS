package Inimigos;

public class Dummy extends Inimigo{// (Herança)
    // Classe vazia para gerenciamento de erros caso o combate seja iniciado de maneira errada.
    // Ele cria um inimigo com 0 de hp, o que faz o combate ser encerrado imediatamente.

    public Dummy(){
        //Construtor que substituí os valores da classe pai pelos valores do inimigo em questão.
        this.hp = 0;
    }

    @Override
    public void adcDebuff() {// (Sobrescrita de metodo)

    }

    @Override
    public void efeitoEspec(int escolha) {// (Sobrescrita de metodo)

    }
}

package Sistema;

public abstract class  Items {


    public static void usaItem(String item){

        switch(item){

            case "Cura Pequena":
                Heroi.adcVida(10);
                break;
            case "Cura Média":
                Heroi.adcVida(15);
                break;
            case "Cura Grande":
                Heroi.adcVida(25);
                break;
            case "Poção de Precisão":
                Heroi.aplVan(5,1,"atk");
                break;
            case "Poção de Força":
                Heroi.aplVan(5,1,"dmg");
                break;
            case "Poção de Defesa":
                Heroi.aplVan(5,1,"def");
                break;



            default:
                System.out.println("Item inválido");
                break;
        }

    }

    public static void equipItem(String item){

        switch (item){
            case "Pedaço de Madeira":
                Heroi.setArmaAtual(item);
                Heroi.setAtk(1);
                break;
            case "Coletor de Lixo":
                Heroi.setArmaAtual(item);
                Heroi.setAtk(2);
                break;
            case "Espada de Plástico":
                Heroi.setArmaAtual(item);
                Heroi.setDmg(2);
                break;
            case "Lança de Circuítos":
                Heroi.setArmaAtual(item);
                Heroi.setDmg(3);
                break;
            case "Braço Robótico":
                Heroi.setArmaAtual(item);
                Heroi.setAtk(3);
                break;
            case "Mantos reforçados":
                Heroi.setArmaduraAtual(item);
                Heroi.setDef(2);
                Heroi.riseMaxHp(5);
                break;
            case "Armadura Plástica":
                Heroi.setArmaduraAtual(item);
                Heroi.setDef(3);
                Heroi.riseMaxHp(10);
                break;
            case "Armadura Robótica":
                Heroi.setArmaduraAtual(item);
                Heroi.setDef(4);
                Heroi.riseMaxHp(20);
                break;
            case "Nenhum":
                Heroi.setAnelAtual(item);
                Heroi.setAgl(1);
                break;
            case "Anel da Rapidez":
                Heroi.setAnelAtual(item);
                Heroi.setAgl(2);
                break;
            case "Anel da Velocidade":
                Heroi.setAnelAtual(item);
                Heroi.setAgl(3);
                break;
            case "Anel de Hermes":
                Heroi.setAnelAtual(item);
                Heroi.setAgl(4);
                break;

        }
    }

    public static String descItem(String item){
        String descricao = "";
        switch (item){
            case "Pedaço de Madeira":
                descricao = "Um pedaço de madeira que foi encontrado na praia, não é o melhor, mas dá pra se defender.";
                break;
            case "Coletor de Lixo":
                descricao = "Um braço coletor de lixo, bem util contra criaturas de lixo!";
                break;
            case "Espada de Plástico":
                descricao = "Uma afiada espada feita de plástico do golem, corta precisamente os inimigos.";
                break;
            case "Lança de Circuítos":
                descricao = "Circuitos eletrônicos podem ser mais afiados do que você imagina!";
                break;
            case "Braço Robótico":
                descricao = "Um braço tecnológico e destrutivo que foi tomado de um robô desavisado.";
                break;
            case "Roupas Comuns":
                descricao = "São suas roupas comuns que você sempre usou";
                break;
            case "Mantos reforçados":
                descricao = "Vestes de proteção robustas, usadas pelos coletores da praia.";
                break;
            case "Armadura Plástica":
                descricao = "Uma armadura reciclada da carcaça do golem plástico.";
                break;
            case "Armadura Robótica":
                descricao = "Uma armadura feita dos restos dos robos infrentados. No peitoral está escrito \"Propriedade de XXXX\"";
                break;
            case "Anel da Rapidez":
                descricao = "Um anel engravado com letras estranhas";
                break;
            case "Anel da Velocidade":
                descricao = "Um anel prateado e com um leve brilho. Usa-lo te faz te sentir mais leve";
                break;
            case "Anel de Hermes":
                descricao = "Um anel dourado com marcações em preto. \"Meu precioso!\" ";
                break;
        }
        return descricao;
    }
}


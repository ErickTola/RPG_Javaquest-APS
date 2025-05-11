

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

}


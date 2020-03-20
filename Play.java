import java.util.Random;
import java.util.Scanner;

class Play {


    public static void main(String[] args) {

        System.out.println("Bienvenue au blackjack de la WCS");
        
        int countJ1 = 0;
        int countDealer = 0;
        
        int card1 = takeCard();
        card1 = choice(card1);
        System.out.println("Le joueur a pioché la carte : " + card1);
        int card2 = takeCard();
        card2 = choice(card2);
        System.out.println("Le joueur a pioché la carte : " + card2);
        countJ1 = card1 + card2;
        System.out.println("Le joueur 1 a " + countJ1 + " points");
        int cardDealer1 = takeCard();
        if (cardDealer1 == 1){
            cardDealer1 = 11;
        }
        System.out.println("Le croupier a pioché la carte : " + cardDealer1);
        int cardDealer2 = takeCard();
        System.out.println("Le croupier a pioché une carte face cachée ");
        countDealer = cardDealer1 + cardDealer2;
        if ( cardDealer2==1 && countDealer< 17){
            cardDealer2=11;    
        }
        countDealer = cardDealer1 + cardDealer2;
        while (countJ1 < 21) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez vous piocher une nouvelle carte: oui ou non");
            String reponse = sc.nextLine();
            if (reponse.equals("oui")) { 
                System.out.println("le joueur a décidé de continuer");
                int card = takeCard();
                card =choice(card);
                System.out.println("Le joueur a pioché la carte : " + card);
                countJ1 = countJ1 + card;
                System.out.println("le score de joueur 1 est : " + countJ1);
            }
            else if (reponse.equals("non")) {
                System.out.println("le joueur a décidé d'arreter");
                break;
            }
            else {
                System.out.println("nous n'avons pas compris merci de recommencer");
            }
        }

        if (countJ1 <= 21) {
            System.out.println("le dealer révèle la deuxième carte :" + cardDealer2);
            while (countDealer <= 16) {
                int cardDealer = takeCard();
                if (cardDealer ==1) {
                    if ( countDealer + 11 >= 16 && countDealer + 11<21){
                        cardDealer = 11;
                    }else{
                        cardDealer = 1;
                    }
                }
                System.out.println("le dealer a pioché la carte :" + cardDealer);
                countDealer = countDealer + cardDealer; 
                System.out.println("le score du dealer est : " + countDealer);
            }
            
        
        }
        
        
        // TODO : vérifier qui a gagné
        if (countJ1 > 21) {
            System.out.println("le joueur 1 a perdu!");
        } else if (countDealer > 21){
            System.out.println("le croupier a perdu!");
        } else if (countJ1>countDealer) {
            System.out.println("le joueur 1 a gagné !");
        } else if (countJ1 == countDealer) {
            System.out.println("le joue est a égalité avec le croupier");
        } else {
            System.out.println("le joueur 1 a perdu! et le croupier a gagné !! ");
        }




    }

    // méthode random
    public static int takeCard() {
        Random rand = new Random();
        int card = 1 + rand.nextInt(10);
        return card;
    }

    public static int choice(int card){
        if (card == 1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez vous que l'As est une valeur de 1 ou 11 ?");
            int choice = sc.nextInt();
            if (choice == 1) { 
                System.out.println("le joueur a décidé que l'As vaut 1");
                card = 1;
            }
            else  {
                System.out.println("le joueur a décidé que l'As vaut 11");
                card = 11;
            }
            
        }
        return card;
    }

}


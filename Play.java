import java.util.Random;
import java.util.Scanner;

class Play {

    
    public static void main(String[] args) {

        System.out.println("Bienvenue au blackjack de la WCS");
        
        int countJ1 = 0;
        int countDealer = 0;
        
        int card1 = takeCard();
        System.out.println("Le joueur a pioché la carte : " + card1);
        int card2 = takeCard();
        System.out.println("Le joueur a pioché la carte : " + card2);
        countJ1 = card1 + card2;
        System.out.println("Le joueur 1 a " + countJ1 + " points");
        int cardDealer1 = takeCard();
        System.out.println("Le croupier a pioché la carte : " + cardDealer1);
        int cardDealer2 = takeCard();
        System.out.println("Le croupier a pioché une carte face cachée ");
        countDealer = cardDealer1 + cardDealer2;
        while (countJ1 < 21) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez vous piocher une nouvelle carte: oui ou non");
            String reponse = sc.nextLine();
            if (reponse.equals("oui")) { 
                System.out.println("le joueur a décidé de continuer");
                int card = takeCard();
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
                System.out.println("le dealer a pioché la carte :" + cardDealer);
                countDealer = countDealer + cardDealer;   
            }
            System.out.println("le score du dealer est : " + countDealer);
        }
        
        
        // TODO : vérifier qui a gagné
        if (countJ1 > 21) {
            System.out.println("le joueur 1 a perdu!");
        } else if (countJ1>countDealer) {
            System.out.println("le joueur 1 a gagné !");
        } else if (countJ1 == countDealer) {
            System.out.println("égalité");
        } else {
            System.out.println("le joueur 1 a perdu!");
        }




    }

    // méthode random
    public static int takeCard() {
        Random rand = new Random();
        int card = 1 + rand.nextInt(10);
        return card;
    }
}


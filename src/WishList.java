import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {

        ArrayList<String> wishList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String userChoice;

        do{
            System.out.print("inserisci il tuo regalo: ");
            String gift = scanner.nextLine();
            wishList.add(gift);
            System.out.println("Lista : " + wishList.size());

            System.out.print("Vuoi un'altro regalo? (si/no): ");
            userChoice = scanner.nextLine();
        } while (userChoice.equalsIgnoreCase("si"));

        Collections.sort(wishList);
        System.out.println("Lista dei regali completa: ");
        for (String gift : wishList) {
            System.out.println(gift);
        }

        scanner.close();


    }
}

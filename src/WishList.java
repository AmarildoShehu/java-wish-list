import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {

    private static final String FILE_NAME = "ListaDesideri.txt";

    public static void main(String[] args) {

        ArrayList<String> wishList = loadWishList();
        Scanner scanner = new Scanner(System.in);
        String userChoice;

        do {
            System.out.print("Inserisci il tuo regalo: ");
            String gift = scanner.nextLine();
            wishList.add(gift);
            System.out.println("Lista: " + wishList.size());

            System.out.print("Vuoi un altro regalo? (si/no): ");
            userChoice = scanner.nextLine();
        } while (userChoice.equalsIgnoreCase("si"));

        Collections.sort(wishList);
        System.out.println("Lista dei regali completa: ");
        for (String gift : wishList) {
            System.out.println(gift);
        }

        saveWishList(wishList);
        scanner.close();
    }

    private static ArrayList<String> loadWishList() {
        ArrayList<String> wishList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                wishList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Errore nel caricare la lista: " + e.getMessage());
        }
        return wishList;
    }

    private static void saveWishList(ArrayList<String> wishList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String gift : wishList) {
                bw.write(gift);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio della lista: " + e.getMessage());
        }
    }
}
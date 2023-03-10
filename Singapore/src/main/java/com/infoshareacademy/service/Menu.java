package com.infoshareacademy.service;
import java.util.InputMismatchException;
import java.util.Scanner;

//stworzyłem metody do obsługi menu w oparciu o kombinację pętli "do while" oraz instrukcji warunkowej "switch"

public class Menu {
      public static void OpenMenu() {
        Scanner sc = new Scanner(System.in);
        int option;
//        System.out.println("\nWitaj Włóczykiju! Zaplanuj swoją wycieczkę razem ze mną!");
        do {
            System.out.println("");
            System.out.println("     ****************************************");
            System.out.println("     *              MENU PLANER             *");
            System.out.println("     ****************************************");
            System.out.println("     1. Miasta");
            System.out.println("     2. Wyszukaj");
            System.out.println("     3. Wycieczka");
            System.out.println("     4. Wyjście");
            System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 4:");
            option = sc.nextInt();

            OpenSubMenu(sc, option);

        } while (option != 4);
    }

    private static void OpenSubMenu(Scanner sc, int option) {
        int subOption;
        int subSubOption;
        switch (option) {
            case 1: {
                openMenuMiasta(sc);
                break;
            }
            case 2: {
                openMenuWyszukiwarka(sc);
                break;
            }
            case 3: {
                openMenuWycieczka(sc);
                break;
            }
            case 4:
                System.out.println("Wybrałeś wyjście. Tylko nie zapomnij wrócić!");
                System.exit(0);
                break;
        }
    }

    private static void openMenuMiasta(Scanner sc) {
        int subOption;
        do {
            System.out.println("");
            System.out.println("     ****************************************");
            System.out.println("     *                MIASTA                *");
            System.out.println("     ****************************************");
            System.out.println("     1. Wyświetl");
            System.out.println("     2. Opinia");
            System.out.println("     3. Dodaj");
            System.out.println("     4. Powrót");
            System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 4:");
            subOption = sc.nextInt();

            switch (subOption) {
                case 1: {
                    System.out.println("Wyświetl");
                    System.out.println("Wybierz nr miasta:");
                    Scanner scannerMiast = new Scanner(System.in);
                    int nrMiasta = scannerMiast.nextInt();
                    System.out.println("     ****************************************");
                    System.out.println("     * MIEJSCA w: "+nrMiasta+"               ");
                    System.out.println("     ****************************************");

                    // nr miasta powinien zwracać nazwę wybranego miasta i w z wiązku z tym wyborem powinny być zwracane wartości miejsc dla wybranego miasta
                    openSubMenuMiejsca(sc);
                    break;
                }
                case 2: {
                    System.out.println("Opinia");
                    break;
                }
                case 3: {
                    System.out.println("Dodaj");
                    break;
                }
                case 4: {
                    System.out.println("Powrót do PLANERA");
                    break;
                }
            }
        } while (subOption != 4);
    }

    private static void openSubMenuMiejsca(Scanner sc) {
        int subSubOption;
        do {
            System.out.println("     1. Zabytki");
            System.out.println("     2. Natura");
            System.out.println("     3. Jedzenie");
            System.out.println("     4. Powrót");
            System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 4:");
            subSubOption = sc.nextInt();

            switch (subSubOption) {
                case 1: {
                    System.out.println("Zabytki");
                    System.out.println("Wybierz nr zabytku:");
                    Scanner scannerZabytków = new Scanner(System.in);
                    int nrZabytku = scannerZabytków.nextInt();
                    openSubSubMenu(sc);
                    break;
                }
                case 2: {
                    System.out.println("Natura");
                    System.out.println("Wybierz nr natura:");
                    Scanner scannerNatura = new Scanner(System.in);
                    int nrNatury = scannerNatura.nextInt();
                    openSubSubMenu(sc);
                    break;
                }
                case 3: {
                    System.out.println("Jedzenie");
                    System.out.println("Wybierz nr jedzenia:");
                    Scanner scannerJedzenie = new Scanner(System.in);
                    int nrJedzenia = scannerJedzenie.nextInt();
                    openSubSubMenu(sc);
                    break;
                }
                case 4: {
                    System.out.println("powrót do MIAST");
                    break;
                }
            }
        } while (subSubOption != 4);
    }

    private static void openSubSubMenu(Scanner sc) {
        int subSubSubOption;
        do {
            System.out.println("     1. Wyświetl");
            System.out.println("     2. Opinia");
            System.out.println("     3. Dodaj");
            System.out.println("     4. Powrót");
            System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 4:");
            subSubSubOption = sc.nextInt();

            switch (subSubSubOption) {
                case 1: {
                    System.out.println("Wyświetl");
                    break;
                }
                case 2: {
                    System.out.println("Opinia");
                    break;
                }
                case 3: {
                    System.out.println("Dodaj");
                    break;
                }
                case 4: {
                    System.out.println("powrót do miejsc");
                    break;
                }
            }
        } while (subSubSubOption != 4);
    }

    private static void openMenuWyszukiwarka(Scanner sc) {
        int subOption;
        do {
            System.out.println("");
            System.out.println("     ****************************************");
            System.out.println("     *               Wyszukaj               *");
            System.out.println("     ****************************************");
            System.out.println("     1. miasto");
            System.out.println("     2. zabytek");
            System.out.println("     3. natura i tereny rekreacyjne");
            System.out.println("     4. jedzenie");
            System.out.println("     5. użytkownika");
            System.out.println("     6. Powrót");
            System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
            subOption = sc.nextInt();

            switch (subOption) {
                case 1: {
                    System.out.println("Wyszukaj miasto");
                    break;
                }
                case 2: {
                    System.out.println("Wyszukaj zabytek");
                    break;
                }
                case 3: {
                    System.out.println("Wyszukaj natura i tereny rekreacyjne");
                    break;
                }
                case 4: {
                    System.out.println("Wyszukaj jedzenie");
                    break;
                }
                case 5: {
                    System.out.println("Wyszukaj użytkownika");
                    break;
                }
                case 6: {
                    System.out.println("powrót do PLANERA");
                    break;
                }
            }
        } while (subOption != 6);
    }

    private static void openMenuWycieczka(Scanner sc) {
        int subOption;
        do {
            System.out.println("");
            System.out.println("     ****************************************");
            System.out.println("     *               Wycieczka              *");
            System.out.println("     ****************************************");
            System.out.println("     1. Losuj");
            System.out.println("     2. Wyszukaj");
            System.out.println("     3. Dodaj");
            System.out.println("     4. Edytuj");
            System.out.println("     5. Usuń");
            System.out.println("     6. Powrót");
            System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
            subOption = sc.nextInt();

            switch (subOption) {
                case 1: {
                    System.out.println("Losuj");
                    break;
                }
                case 2: {
                    System.out.println("Wyszukaj");
                    break;
                }
                case 3: {
                    System.out.println("Dodaj");
                    break;
                }
                case 4: {
                    System.out.println("Edytuj");
                    break;
                }
                case 5: {
                    System.out.println("Usuń");
                    break;
                }
                case 6: {
                    System.out.println("powrót do PLANERA");
                    break;
                }
            }
        } while (subOption != 6);
    }

    //Obsłużyłem wyjątek InputMismatchException metody OpenMenuMethod

    public static void OpenMenuMethod() {
        repeat: while (true) {
            try {
                Menu.OpenMenu();
            } catch (InputMismatchException e) {
                System.out.println("Nie podałeś liczby z przedziału od 1 do 4, spróbuj ponownie!");
                continue repeat;
            }
        }
    }
}
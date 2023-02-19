package com.infoshareacademy.model;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//stworzyłem metody do obsługi menu w oparciu o kombinację pętli "do while" oraz instrukcji warunkowej "switch"

public class Menu {
      public static void OpenMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        int option;      //przerzuciłem zmienne subOption i subSubOption do metody prywatnej OpenSubOption
        System.out.println("\nWitaj Włóczykiju! Zaplanuj swoją wycieczkę razem ze mną!");
        do {
            System.out.println("");
            System.out.println("     ****************************************");
            System.out.println("     *              MENU PLANER             *");
            System.out.println("     ****************************************");
            System.out.println("     1. Miasta");
            System.out.println("     2. Miejsca");
            System.out.println("     3. Opinie");
            System.out.println("     4. Wycieczka");
            System.out.println("     5. Wyjście");
            System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 5:");
            option = sc.nextInt();

            OpenSubMenu(sc, option);   //*

        } while (option != 5);
    }

    //* Wyodrębniłem kod podMenu do prywatnej metody OpenSubMenu celem jego hermetyzacji

    private static void OpenSubMenu(Scanner sc, int option) throws IOException {
        int subOption;
        int subSubOption;
        switch (option) {
            case 1: {
                do {
                    System.out.println("");
                    System.out.println("     ****************************************");
                    System.out.println("     *                MIASTA                *");
                    System.out.println("     ****************************************");
                    System.out.println("     1. Wyświetl");
                    System.out.println("     2. Wybierz");
                    System.out.println("     3. Dodaj");
                    System.out.println("     4. Powrót");
                    System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 4:");
                    subOption = sc.nextInt();

                    switch (subOption) {
                        case 1: {
                            System.out.println("Wyświetl");
                            break;
                        }
                        case 2: {
                            System.out.println("Wybierz");
                            break;
                        }
                        case 3: {
                            System.out.println("Dodaj");
                            break;
                        }
                        case 4: {
                            System.out.println("powrót do PLANERA");
                            break;
                        }
                    }
                } while (subOption != 4);
                break;
            }
            case 2: {
                do {
                    System.out.println("");
                    System.out.println("     ****************************************");
                    System.out.println("     *                MIEJSCA               *");
                    System.out.println("     ****************************************");
                    System.out.println("     1. Wyświetl");
                    System.out.println("     2. Wybierz");
                    System.out.println("     3. Dodaj");
                    System.out.println("     4. Powrót");
                    System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
                    subOption = sc.nextInt();

                    switch (subOption) {
                        case 1: {
                            System.out.println("Wyświetl");
                            break;
                        }
                        case 2: {
                            do {
                                System.out.println("");
                                System.out.println("     ****************************************");
                                System.out.println("     *                TYP                   *");
                                System.out.println("     ****************************************");
                                System.out.println("     1. Zabytki");
                                System.out.println("     2. Natura");
                                System.out.println("     3. Jedzenie");
                                System.out.println("     4. Powrót");
                                System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
                                subSubOption = sc.nextInt();

                                switch (subSubOption) {
                                    case 1: {
                                        System.out.println("Zabytki");
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Natura");
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Jedzenie");
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("powrót do MIEJSC");
                                        break;
                                    }
                                }
                            } while (subSubOption != 4);
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
                break;
            }
            case 3: {
                do {
                    System.out.println("");
                    System.out.println("     ****************************************");
                    System.out.println("     *                OPINIE                *");
                    System.out.println("     ****************************************");
                    System.out.println("     1. Dodaj");
                    System.out.println("     2. Wyświetl");
                    System.out.println("     3. Wyszukaj");
                    System.out.println("     4. Powrót");
                    System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
                    subOption = sc.nextInt();

                    switch (subOption) {
                        case 1: {
                            System.out.println("Dodaj");
                            break;
                        }
                        case 2: {
                            System.out.println("Wyświetl");
                            break;
                        }
                        case 3: {
                            System.out.println("Wyszukaj");
                            break;
                        }
                        case 4: {
                            System.out.println("powrót do PLANERA");
                            break;
                        }
                    }
                } while (subOption != 4);
                break;
            }
            case 4: {
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
                    System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 5:");
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
                break;
            }
            case 5:
                System.out.println("Wybrałeś wyjście. Tylko nie zapomnij wrócić!");
                System.exit(0);
                break;
        }
    }

    //Obsłużyłem wyjątek InputMismatchException metody OpenMenuMethod

    public static void OpenMenuMethod() throws IOException {
        repeat: while (true) {
            try {
                Menu.OpenMenu();
            } catch (InputMismatchException e) {
                System.out.println("Podałeś literę zamiast liczby, spróbuj ponownie!");
                continue repeat;
            }
        }
    }
}
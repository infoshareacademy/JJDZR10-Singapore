package com.infoshareacademy.model;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void menu(){

        Scanner sc = new Scanner(System.in);
        int option, subOption, subSubOption;
        System.out.println("\nWitaj Włóczykiju! Zaplanuj swoją wycieczkę razem ze mną!");
        do {
            System.out.println("");
            System.out.println("     ****************************************");
            System.out.println("     *             MENU PLANERA             *");
            System.out.println("     ****************************************");
            System.out.println("     1. Użytkownik");
            System.out.println("     2. Miasta");
            System.out.println("     3. Miejsca");
            System.out.println("     4. Opinie");
            System.out.println("     5. Wycieczka");
            System.out.println("     6. Wyjście");
            System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
            option = sc.nextInt();

            switch (option) {
                case 1: {

                    do {
                        System.out.println("");
                        System.out.println("     ****************************************");
                        System.out.println("     *              UŻYTKOWNIK              *");
                        System.out.println("     ****************************************");
                        System.out.println("     1. Wyświetl");
                        System.out.println("     2. Dodaj");
                        System.out.println("     3. Edytuj");
                        System.out.println("     4. Zmień");
                        System.out.println("     5. Usuń");
                        System.out.println("     6. Powrót");
                        System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
                        subOption = sc.nextInt();

                        switch (subOption) {
                            case 1: {
                                System.out.println("Wyświetl");
                                break;
                            }
                            case 2: {
                                System.out.println("dodaj");
                                break;
                            }
                            case 3: {
                                System.out.println("edytuj");
                                break;
                            }
                            case 4: {
                                System.out.println("zmień");
                                break;
                            }
                            case 5: {
                                System.out.println("usuń");
                                break;
                            }
                            case 6: {
                                System.out.println("powrót do planera");
                                break;
                            }
                            //option = sc.nextInt();
                        }
                    } while (subOption != 6);
                    break;
                }

                case 2:

                {

                    do {
                        System.out.println("");
                        System.out.println("     ****************************************");
                        System.out.println("     *                MIASTA                *");
                        System.out.println("     ****************************************");
                        System.out.println("     1. Wyświetl");
                        System.out.println("     2. Wybierz");
                        System.out.println("     3. Dodaj");
                        System.out.println("     4. Edytuj");
                        System.out.println("     5. Usuń");
                        System.out.println("     6. Powrót");
                        System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
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
                                System.out.println("Edytuj");
                                break;
                            }
                            case 5: {
                                System.out.println("Usuń");
                                break;
                            }
                            case 6: {
                                System.out.println("powrót do planera");
                                break;
                            }
                            // option = sc.nextInt();
                        }
                    } while (subOption != 6);
                    break;
                }

                case 3:

                {

                    do {
                        System.out.println("");
                        System.out.println("     ****************************************");
                        System.out.println("     *                MIEJSCA               *");
                        System.out.println("     ****************************************");
                        System.out.println("     1. Wyświetl");
                        System.out.println("     2. Wybierz");
                        System.out.println("     3. Dodaj");
                        System.out.println("     4. Edytuj");
                        System.out.println("     5. Usuń");
                        System.out.println("     6. Powrót");
                        System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
                        subOption = sc.nextInt();

                        switch (subOption) {
                            case 1: {
                                System.out.println("Wyświetl");
                                break;
                            }
                            case 2:

                            {
                                do {
                                    System.out.println("");
                                    System.out.println("     ****************************************");
                                    System.out.println("     *                TYP                   *");
                                    System.out.println("     ****************************************");
                                    System.out.println("     1. Zabytki");
                                    System.out.println("     2. Natura");
                                    System.out.println("     3. Jedzenie");
                                    System.out.println("     4. Dzieci");
                                    System.out.println("     5. Imprezy");
                                    System.out.println("     6. Powrót");
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
                                            System.out.println("Dzieci");
                                            break;
                                        }
                                        case 5: {
                                            System.out.println("Imprezy");
                                            break;
                                        }
                                        case 6: {
                                            System.out.println("powrót do miejsc");
                                            break;
                                        }
                                        // option = sc.nextInt();
                                    }
                                } while (subSubOption != 6);
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
                                System.out.println("usuń");
                                break;
                            }
                            case 6: {
                                System.out.println("powrót do planera");
                                break;
                            }
                            // option = sc.nextInt();
                        }
                    } while (subOption != 6);
                    break;
                }

                case 4:

                {

                    do {
                        System.out.println("");
                        System.out.println("     ****************************************");
                        System.out.println("     *                OPINIE                *");
                        System.out.println("     ****************************************");
                        System.out.println("     1. Dodaj");
                        System.out.println("     2. Edytuj");
                        System.out.println("     3. Usuń");
                        System.out.println("     4. Wyświetl");
                        System.out.println("     5. Wyszukaj");
                        System.out.println("     6. Powrót");
                        System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 6:");
                        subOption = sc.nextInt();

                        switch (subOption) {
                            case 1: {
                                System.out.println("Dodaj");
                                break;
                            }
                            case 2: {
                                System.out.println("Edytuj");
                                break;
                            }
                            case 3: {
                                System.out.println("Usuń");
                                break;
                            }
                            case 4: {
                                System.out.println("Wyświetl");
                                break;
                            }
                            case 5: {
                                System.out.println("Wyszukaj");
                                break;
                            }
                            case 6: {
                                System.out.println("powrót do planera");
                                break;
                            }
                            // option = sc.nextInt();
                        }
                    } while (subOption != 6);
                    break;

                }

                case 5: {

                    do {
                        System.out.println("");
                        System.out.println("     ****************************************");
                        System.out.println("     *               Wycieczka              *");
                        System.out.println("     ****************************************");
                        System.out.println("     1. Wyszukaj");
                        System.out.println("     2. Dodaj");
                        System.out.println("     3. Edytuj");
                        System.out.println("     4. Usuń");
                        System.out.println("     5. Powrót");
                        System.out.println("\nWybierz opcję i wprowadź liczbę od 1 do 5:");
                        subOption = sc.nextInt();

                        switch (subOption) {
                            case 1: {
                                System.out.println("Wyszukaj");
                                break;
                            }
                            case 2: {
                                System.out.println("Dodaj");
                                break;
                            }
                            case 3: {
                                System.out.println("Edytuj");
                                break;
                            }
                            case 4: {
                                System.out.println("Usuń");
                                break;
                            }

                            case 5: {
                                System.out.println("powrót do planera");
                                break;
                            }

                            // option = sc.nextInt();
                        }
                    } while (subOption != 5);
                    break;

                }

                case 6:
                    System.out.println("Wybrałeś wyjście. Tylko nie zapomnij wrócić!");
                    System.exit(0);
                    break;
            }

        } while (option != 6);

    }
}
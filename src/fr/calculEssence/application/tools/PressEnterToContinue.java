package fr.calculEssence.application.tools;

import java.util.Scanner;

public class PressEnterToContinue {

    //méthode permettant de faire un "press enter to continue"
    public static void Press(Scanner scanner) {
        System.out.println("Press enter to continue");
        scanner.nextLine();
        scanner.nextLine();
    }
}

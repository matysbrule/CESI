import java.util.Scanner;
import java.util.Arrays;

public class PizzeriaAdminConsoleApp {

    private static void afficherPizzas(Pizza[] pizzas) {
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.getCode() + " - " + pizza.getNom() + " (" + pizza.getPrix() + " €)");
        }
    }

    public static void main(String[] args) {
        // Initialisation du tableau de pizzas
        Pizza[] pizzas = {
                new Pizza("PEP", "Pépéroni", 12.50),
                new Pizza("MAR", "Margherita", 14.00),
                new Pizza("REIN", "La Reine", 11.50),
                new Pizza("FRO", "La 4 fromages", 12.00),
                new Pizza("CAN", "La cannibale", 12.50),
                new Pizza("SAV", "La savoyarde", 13.00),
                new Pizza("ORI", "L’orientale", 13.50),
                new Pizza("IND", "L’indienne", 14.00)
        };
        while (true) {
            // Afficher les pizzas si l'option 1 est sélectionnée
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veuillez choisir une option :");
            System.out.println("1 - Afficher les pizzas");
            System.out.println("2 - Ajouter une pizza");
            System.out.println("3 - Modifier une pizza");
            System.out.println("4 - Supprimer une pizza");
            System.out.println("0 - Quitter");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    afficherPizzas(pizzas);
                    break;
                case 2:
                    // Ajouter une pizza
                    Scanner inputScanner = new Scanner(System.in);

                    System.out.println("Veuillez saisir le code :");
                    String code = inputScanner.next();

                    System.out.println("Veuillez saisir le nom (sans espace) :");
                    String nom = inputScanner.next();

                    System.out.println("Veuillez saisir le prix :");
                    double prix = inputScanner.nextDouble();
                    Pizza nouvellePizza = new Pizza(code, nom, prix);

                    // Augmenter la taille du tableau
                    pizzas = Arrays.copyOf(pizzas, pizzas.length + 1);

                    // Ajouter la nouvelle pizza à la fin du tableau
                    pizzas[pizzas.length - 1] = nouvellePizza;

                    System.out.println("La pizza a été ajoutée avec succès !");
                    break;
                case 3:
                    // Modifier une pizza
                    afficherPizzas(pizzas);
                    Scanner modifyScanner = new Scanner(System.in);
                    System.out.println("Veuillez choisir le code de la pizza à modifier :");
                    String codeAModifier = modifyScanner.next();

                    int indexAModifier = -1;
                    for (int i = 0; i < pizzas.length; i++) {
                        if (pizzas[i].getCode().equals(codeAModifier)) {
                            indexAModifier = i;
                            break;
                        }
                    }

                    if (indexAModifier != -1) {
                        System.out.println("Veuillez saisir le nouveau code :");
                        String nouveauCode = modifyScanner.next();

                        System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
                        String nouveauNom = modifyScanner.next();

                        System.out.println("Veuillez saisir le nouveau prix :");
                        double nouveauPrix = modifyScanner.nextDouble();

                        // Modifier la pizza avec les nouvelles informations
                        pizzas[indexAModifier].setCode(nouveauCode);
                        pizzas[indexAModifier].setNom(nouveauNom);
                        pizzas[indexAModifier].setPrix(nouveauPrix);

                        System.out.println("La pizza a été modifiée avec succès !");
                    } else {
                        System.out.println("Aucune pizza trouvée avec le code spécifié.");
                    }

                    break;
                case 4:
                    // Supprimer une pizza
                    afficherPizzas(pizzas);

                    Scanner deleteScanner = new Scanner(System.in);
                    System.out.println("Veuillez choisir le code de la pizza à supprimer :");
                    String codeASupprimer = deleteScanner.next();

                    int indexASupprimer = -1;
                    for (int i = 0; i < pizzas.length; i++) {
                        if (pizzas[i].getCode().equals(codeASupprimer)) {
                            indexASupprimer = i;
                            break;
                        }
                    }

                    // Vérifier si la pizza a été trouvée
                    if (indexASupprimer != -1) {
                        // Créer un nouveau tableau sans la pizza à supprimer
                        Pizza[] nouveauTableau = new Pizza[pizzas.length - 1];
                        System.arraycopy(pizzas, 0, nouveauTableau, 0, indexASupprimer);
                        System.arraycopy(pizzas, indexASupprimer + 1, nouveauTableau, indexASupprimer, pizzas.length - indexASupprimer - 1);

                        // Affecter le nouveau tableau41
                        pizzas = nouveauTableau;

                        System.out.println("La pizza a été supprimée avec succès !");
                    } else {
                        System.out.println("Aucune pizza trouvée avec le code spécifié.");
                    }

                    break;
                case 0:
                    System.out.println("Au revoir !");
                    System.exit(0); // Quitter l'application
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    continue;
            }
        }
    }
}

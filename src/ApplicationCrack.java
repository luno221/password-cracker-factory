package application;

import fabrique.FabriqueAttaque;
import strategie.Attaque;
import cible.Cible;

public class ApplicationCrack { 
    public static void main(String[] args) {
        // 1. Récupération des paramètres CLI
        String typeAttaque = args.length > 0 ? args[0] : "brute";
        String typeCible  = args.length > 1 ? args[1] : "locale";
        String login = args.length > 2 ? args[2] : "admin";
        String urlCible = args.length > 3 ? args[3] : "http://localhost/php-site/authenticate.php"; 

        // 2. Création de l’attaque et de la cible via la Fabrique (Factory Method)
        Attaque attaque = FabriqueAttaque.creerAttaque(typeAttaque);
        Cible   cible   = FabriqueAttaque.creerCible(typeCible, urlCible);

        // 3. Exécution de l’attaque
        System.out.println("Lancement de l'attaque '" + typeAttaque + "' sur la cible '" + typeCible + "' pour le login '" + login + "'...");
        long startTime = System.currentTimeMillis();
        String motDePasseTrouve = attaque.lancer(login, cible);
        long endTime = System.currentTimeMillis();

        System.out.println("Attaque terminée en " + (endTime - startTime) + " ms.");
        if (motDePasseTrouve != null) {
            System.out.println("Succès ! Mot de passe trouvé : " + motDePasseTrouve);
        } else {
            System.out.println("Échec. Le mot de passe n'a pas été trouvé avec cette stratégie.");
        }
    }
}

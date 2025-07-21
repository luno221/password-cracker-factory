package fabrique;

import strategie.Attaque;
import strategie.StrategieBruteForce;
import strategie.StrategieDictionnaire;
import cible.Cible;
import cible.CibleLocale;
import cible.CibleEnLigne;

/**
 * Pattern Factory Method :
 * Cette classe agit comme une "Simple Factory". Elle centralise la création
 * des objets (Attaques et Cibles) pour découpler le client (ApplicationCrack)
 * des implémentations concrètes.
 */
public class FabriqueAttaque {
    /**
     * Crée une instance de stratégie d'attaque en fonction du type demandé.
     * @param type Le type d'attaque ("dict", "brute").
     * @return Une instance de l'interface Attaque.
     * @throws IllegalArgumentException si le type est inconnu.
     */
    public static Attaque creerAttaque(String type) {
        switch (type.toLowerCase()) {
            case "dict":
                return new StrategieDictionnaire();
            case "brute":
                return new StrategieBruteForce();
            default:
                throw new IllegalArgumentException("Type d'attaque inconnu : " + type);
        }
    }

    /**
     * Crée une instance de cible d'authentification en fonction du type demandé.
     * @param type Le type de cible ("locale", "online").
     * @param params Paramètres supplémentaires pour la création de la cible (ex: URL pour CibleEnLigne).
     * @return Une instance de l'interface Cible.
     * @throws IllegalArgumentException si le type est inconnu.
     */
    public static Cible creerCible(String type, String... params) {
        switch (type.toLowerCase()) {
            case "online":
                if (params.length == 0 || params[0] == null || params[0].isEmpty()) {
                    throw new IllegalArgumentException("L'URL est requise pour le type de cible 'online'");
                }
                return new CibleEnLigne(params[0]);
            case "locale":
                return new CibleLocale();
            default:
                throw new IllegalArgumentException("Type de cible inconnu : " + type);
        }
    }
}
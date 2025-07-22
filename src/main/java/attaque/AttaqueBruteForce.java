package attaque;

import cible.Cible;

public class AttaqueBruteForce implements Attaque {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int MAX_LENGTH = 4;

    @Override
    public void attaquer(Cible cible) {
        System.out.println("Démarrage de l'attaque par force brute...");
        for (int length = 2; length <= MAX_LENGTH; length++) {
            if (genererEtTester(new StringBuilder(), length, cible)) {
                return; // Mot de passe trouvé, on arrête
            }
        }
        System.out.println("Echec de l'attaque. On a tout tenté mais cela nous a pas laissé faire ");
    }

    private boolean genererEtTester(StringBuilder current, int length, Cible cible) {

        if (current.length() == length) {
            String password = current.toString();
            System.out.println("Tentative de mot de passe: " + password);
            if (cible.tenterConnexion(password)) {
                System.out.println("Mot de passe trouvé: " + password);
                return true;
            }
            return false;
        }

        for (char c : ALPHABET.toCharArray()) {
            current.append(c);
            if (genererEtTester(current, length, cible)) {
                return true; // Si le mot de passe est trouvé dans un appel récursif, on remonte true
            }
            current.deleteCharAt(current.length() - 1); // Backtrack pour essayer le caractère suivant
        }
        return false; // Aucun mot de passe trouvé à partir de cette branche
    }
}

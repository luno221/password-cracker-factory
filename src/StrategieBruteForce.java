package com.cracker.strategie;

import com.cracker.cible.Cible;

public class StrategieBruteForce implements Attaque {
    private static final int longueurMax = 6;

    @Override
    public String lancer(String login, Cible cible) {
        char[] charset = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        return genererEtTester("", charset, login, cible, 1);
    }

    private String genererEtTester(String prefixe, char[] charset, String login, Cible cible, int profondeur) {
        if (profondeur > longueurMax) {
            return null;
        }

        for (char c : charset) {
            String motTest = prefixe + c;
            if (cible.verifier(login, motTest)) {
                return motTest; // Trouvé ! On retourne le mot de passe.
            }
            // On continue la recherche récursivement
            String resultat = genererEtTester(motTest, charset, login, cible, profondeur + 1);
            if (resultat != null) {
                return resultat; // On propage le résultat trouvé pour arrêter toutes les boucles.
            }
        }
        return null; // Non trouvé à ce niveau de récursion.
    }
}

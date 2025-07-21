package com.cracker.strategie;

import com.cracker.cible.Cible;
import com.cracker.utilitaire.LecteurDictionnaire;

public class StrategieDictionnaire implements Attaque {
    @Override
    public String lancer(String login, Cible cible) {
        for (String motDePasse : LecteurDictionnaire.lire("dict/dictionnaire.txt")) {
            if (cible.verifier(login, motDePasse)) {
                return motDePasse;
            }
        }
        return null;
    }
}

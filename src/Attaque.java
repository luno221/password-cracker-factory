package com.cracker.strategie;

/**
 * Interface pour toute stratégie d'attaque. 
 */
public interface Attaque {
    /**
     * Lance l'attaque sur une cible pour un login donné.
     * @return le mot de passe trouvé, ou null si l'attaque échoue.
     */
    String lancer(String login, com.cracker.cible.Cible cible);
}

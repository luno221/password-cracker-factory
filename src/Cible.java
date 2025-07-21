package com.cracker.cible;

/**
 * Interface pour toute cible d'authentification.
 * La méthode verifier doit retourner true si (login, motDePasse) est valide.
 */
public interface Cible {
    /**
     * Vérifie le couple login/motDePasse sur la cible.
     *
     * @param login        le nom d'utilisateur
     * @param motDePasse   le mot de passe à tester
     * @return true si l'authentification réussit
     */
    boolean verifier(String login, String motDePasse);
}

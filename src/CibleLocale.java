package com.cracker.cible;

public class CibleLocale implements Cible {
    private static final String ADMIN_LOGIN    = "admin";
    private static final String ADMIN_MOTDEPASSE = "azerty";

    @Override
    public boolean verifier(String login, String motDePasse) {
        return ADMIN_LOGIN.equals(login) && ADMIN_MOTDEPASSE.equals(motDePasse);
    }
}

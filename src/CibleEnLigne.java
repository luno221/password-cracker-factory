package com.cracker.cible;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CibleEnLigne implements Cible {
    private String urlAuthentification;

    public CibleEnLigne(String urlAuthentification) {
        this.urlAuthentification = urlAuthentification;
    }

    @Override
    public boolean verifier(String login, String motDePasse) {
        try {
            URL url = new URL(urlAuthentification);
            HttpURLConnection connexion = (HttpURLConnection) url.openConnection();
            connexion.setRequestMethod("POST");
            connexion.setDoOutput(true);
            String donnees = "login=" + login + "&motDePasse=" + motDePasse;
            OutputStream os = connexion.getOutputStream();
            os.write(donnees.getBytes());
            os.flush();
            return connexion.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
        }
    }
}

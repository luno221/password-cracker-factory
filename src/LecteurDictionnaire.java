package com.cracker.utilitaire;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LecteurDictionnaire {
    public static List<String> lire(String cheminFichier) {
        try {
            return Files.readAllLines(Paths.get(cheminFichier));
        } catch (Exception e) {
            throw new RuntimeException("Impossible de lire le dictionnaire", e);
        }
    }
}

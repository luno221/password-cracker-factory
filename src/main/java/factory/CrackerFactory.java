
public class CrackerFactory {

    // Crée l'attaque selon le type spécifié (BruteForce ou Dictionnaire)
    public Attack createAttack(String attackType) {
        if ("brute_force".equalsIgnoreCase(attackType)) {
            return new BruteForceAttack();
        } else if ("dictionnary".equalsIgnoreCase(attackType)) {
            return new DictionaryAttack();
        } else {
            throw new IllegalArgumentException("Attack type not supported");
        }
    }

    // Crée la cible selon le type spécifié (local ou online)
    public Target createTarget(String targetType, String login) {
        if ("local".equalsIgnoreCase(targetType)) {
            return new LocalAuthenticator(login);
        } else if ("online".equalsIgnoreCase(targetType)) {
            return new OnlineAuthenticator(login);
        } else {
            throw new IllegalArgumentException("Target type not supported");
        }
    }
}

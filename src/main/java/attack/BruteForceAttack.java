public class BruteForceAttack implements Attack {

    @Override
    public void execute(Target target) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
        String password = generatePassword(alphabet, 4);  // Limite de 4 caractères pour l'exemple
        System.out.println("Tentative de mot de passe: " + password);
        if (target.authenticate(password)) {
            System.out.println("Mot de passe trouvé: " + password);
        } else {
            System.out.println("Échec de la tentative.");
        }
    }

    private String generatePassword(String alphabet, int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * alphabet.length());
            password.append(alphabet.charAt(index));
        }
        return password.toString();
    }
}

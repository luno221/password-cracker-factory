public class AuthentificationLocale {
    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }
        String login = args[0];
        String motDePasse = args[1];

        // valeurs en dur
        String adminLogin       = "admin";
        String adminMotDePasse = "passer123";

        if (adminLogin.equals(login) && adminMotDePasse.equals(motDePasse)) {
            System.out.println("Connexion réussie");
        } else {
            System.out.println("Échec de la connexion");
        }
    }
}

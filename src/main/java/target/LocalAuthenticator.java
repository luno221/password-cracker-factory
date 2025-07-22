import target.Target;
public class LocalAuthenticator implements Target {

    private String login;

    public LocalAuthenticator(String login) {
        this.login = login;
    }

    @Override
    public boolean authenticate(String password) {
        // Le login et mot de passe sont définis en dur pour l'exemple
        return "admin".equals(login) && "passer1234".equals(password);
    }
}

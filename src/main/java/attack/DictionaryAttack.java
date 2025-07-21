import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryAttack implements Attack {

    @Override
    public void execute(Target target) {
        try (BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Tentative de mot de passe: " + line);
                if (target.authenticate(line)) {
                    System.out.println("Mot de passe trouvé: " + line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

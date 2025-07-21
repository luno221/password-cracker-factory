public class CrackerApp {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java CrackerApp --type <attack_type> --target <target_type> --login <login>");
            return;
        }

        String attackType = args[1];
        String targetType = args[3];
        String login = args[5];

        CrackerFactory factory = new CrackerFactory();
        Attack attack = factory.createAttack(attackType);
        Target target = factory.createTarget(targetType, login);

        attack.execute(target);
    }
}

package Commands;

public class ExitCommand extends Command {
    public void execute() {
        System.out.println("Closing Galaga...");
        System.exit(0);
    }
}

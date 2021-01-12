package picocli;

@CommandLine.Command(
        name = "Generator",
        subcommands = {
                RunCommand.class,
        }
)
public class MainCommand implements Runnable {

    @Override
    public void run() {
        new CommandLine(new MainCommand()).usage(System.out);
    }

}

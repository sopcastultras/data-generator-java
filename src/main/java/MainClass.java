import picocli.CommandLine;
import picocli.MainCommand;

public class MainClass {

    public static void main(String[] args) {
        final CommandLine cmd = new CommandLine(new MainCommand());
        final CommandLine.ParseResult parseResult;
        try {
            parseResult = cmd.parseArgs(args);
            if (!parseResult.errors().isEmpty()) {
                System.out.println(cmd.getUsageMessage());
            }
            int exitCode = cmd.execute(args);
            System.exit(exitCode);
        } catch (CommandLine.MissingParameterException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}

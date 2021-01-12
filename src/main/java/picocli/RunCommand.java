package picocli;

import generator.DataGenerator;

import java.io.IOException;

@CommandLine.Command(
        name = "RUN",
        mixinStandardHelpOptions = true,
        description = "For example 'RUN --filename file.xml --datatype xml --count 3'"
)
public class RunCommand implements Runnable {

    @CommandLine.Option(
            names = {"--count"},
            required = true,
            description = "Number of generated entities"
    )
    protected int count;

    @CommandLine.Option(
            names = {"--filename"},
            required = true,
            description = "The name of the file to create"

    )
    protected String fileName;

    @CommandLine.Option(
            names = {"--datatype"},
            required = true,
            description = "Supported file types: json, xml, csv"
    )
    protected String dataType;

    @Override
    public void run() {
        try {
            runUnsafe();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void runUnsafe() {
        final DataGenerator dataGenerator = new DataGenerator(fileName, dataType, count);
        try {
            dataGenerator.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

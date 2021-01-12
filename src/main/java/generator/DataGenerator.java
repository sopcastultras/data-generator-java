package generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import model.DataModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public int count;
    public String fileName;
    public String dataType;

    public DataGenerator(String fileName, String dataType, int count) {
        this.count = count;
        this.fileName = fileName;
        this.dataType = dataType;
    }

    private static List<DataModel> generateGroup(int count) {
        List<DataModel> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            groups.add(new DataModel().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i))
                    .withFooter(String.format("footer %s", i)));
        }
        return groups;
    }

    public void run() throws IOException {
        List<DataModel> groups = generateGroup(count);
        if ("csv".equals(dataType)) {
            saveAsCsv(groups, new File(fileName));
        } else if ("xml".equals(dataType)) {
            saveAsXml(groups, new File(fileName));
        } else if ("json".equals(dataType)) {
            saveAsJson(groups, new File(fileName));
        } else {
            System.out.printf("Unrecognized format: %s\n", dataType);
        }
    }

    private void saveAsJson(List<DataModel> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsCsv(List<DataModel> groups, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (DataModel group : groups) {
                writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
            }
        }
    }

    private void saveAsXml(List<DataModel> groups, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(DataModel.class);
        String xml = xStream.toXML(groups);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

}

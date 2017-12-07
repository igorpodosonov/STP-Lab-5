package serialization.serialize.types;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import serialization.ClassToSerialize;

import java.io.IOException;

public class GsonSerialize extends SuperSerialization {

    public void runSerialization(String filePath) throws IOException {
        measureStart();

        String json = getTextFromFile(filePath);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        ClassToSerialize serializedClass = gson.fromJson(json, ClassToSerialize.class);

        String deserialize = gson.toJson(serializedClass);
        overwriteFile(filePath, deserialize);

        measuresEnd();
        displayStats("Gson Serialize/Deserialize");
    }
}

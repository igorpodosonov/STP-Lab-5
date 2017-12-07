package serialization.serialize.types;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import serialization.ClassToSerialize;

import java.io.IOException;

public class GsonSerialize extends SuperSerialization {

    public void runSerialization(String filePath) throws IOException {
        measureStart();

        ClassToSerialize serializedClass = serialize(filePath);
        String deserialize = deserialize(serializedClass);

        overwriteFile(filePath, deserialize);

        measuresEnd();
        displayStats("Gson Serialize/Deserialize");
    }

    public String deserialize(ClassToSerialize serializedClass){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String deserialize = gson.toJson(serializedClass);

        return deserialize;
    }

    public ClassToSerialize serialize(String filePath) {
        String json = getTextFromFile(filePath);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        ClassToSerialize serializedClass = gson.fromJson(json, ClassToSerialize.class);

        return serializedClass;
    }
}

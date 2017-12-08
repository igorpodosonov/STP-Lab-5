package serialization.serialize.types;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import serialization.ClassToSerialize;

import java.io.IOException;

public class JacksonSerialize extends SuperSerialization {

    public void runSerialization(String filePath) throws IOException {
        measureStart();

        ClassToSerialize serializedClass = serialize(filePath);
        String deserialize = deserialize(serializedClass);

        overwriteFile(filePath, deserialize);

        measuresEnd();
        displayStats("Jackson Serialize/Deserialize");
    }

    public String deserialize(ClassToSerialize serializedClass) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);

        String deserialize = mapper.writeValueAsString(serializedClass);

        return deserialize;
    }

    public ClassToSerialize serialize(String filePath) throws IOException {
        String json = getTextFromFile(filePath);

        ObjectMapper mapper = new ObjectMapper();

        ClassToSerialize serializedClass = mapper.readValue(json, ClassToSerialize.class);
        return serializedClass;
    }
}

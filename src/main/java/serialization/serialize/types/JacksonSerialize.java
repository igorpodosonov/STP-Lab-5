package serialization.serialize.types;

import com.sun.xml.internal.ws.developer.SerializationFeature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import serialization.ClassToSerialize;

import java.io.IOException;

public class JacksonSerialize extends SuperSerialization {

    public void runSerialization(String filePath) throws IOException {
        measureStart();

        String json = getTextFromFile(filePath);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);

        ClassToSerialize serializedClass = mapper.readValue(json, ClassToSerialize.class);

        String deserialize = mapper.writeValueAsString(serializedClass);
        overwriteFile(filePath, deserialize);

        measuresEnd();
        displayStats("Jackson Serialize/Deserialize");
    }
}

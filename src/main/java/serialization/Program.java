package serialization;

import com.sun.org.apache.xpath.internal.SourceTree;
import serialization.serialize.types.GsonSerialize;
import serialization.serialize.types.JacksonSerialize;
import serialization.serialize.types.OrgJsonSerialize;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        String filePath = "D://serialize-gson.txt";

        GsonSerialize gson = new GsonSerialize();
        gson.runSerialization(filePath);

        OrgJsonSerialize orgJson = new OrgJsonSerialize();
        orgJson.runSerialization(filePath);

        JacksonSerialize jackson = new JacksonSerialize();
        jackson. runSerialization(filePath);
    }
}
package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import serialization.serialize.types.GsonSerialize;
import serialization.serialize.types.JacksonSerialize;
import serialization.serialize.types.OrgJsonSerialize;

import java.io.BufferedReader;
import java.io.FileReader;
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
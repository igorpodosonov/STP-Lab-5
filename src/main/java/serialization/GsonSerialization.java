package serialization;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.*;
import java.util.HashMap;

public class GsonSerialization extends ObjectToSerialize implements MySerializeInterface {

    public GsonSerialization(String filePath) throws IOException {
        measureStart();

        String json = getTextFromFile(filePath);
        serialize(json);

        measuresEnd();
        displayStats("Serialization");
    }

    public GsonSerialization(int fieldNumber, String fieldString, String objectString, int objectNum, String mapString, String mapStringVaue, String mapNum, int mapNumValue) {
        this.fieldNumber = fieldNumber;
        this.fieldString = fieldString;
        this.fieldObject = new CustomObject(objectString, objectNum);
        this.fieldMap = new LinkedTreeMap();
        this.fieldMap.put(mapString, mapStringVaue);
        this.fieldMap.put(mapNum, mapNumValue);
    }

    private void serialize(String jsonConfig) {
        final Gson gson = new Gson();
        GsonSerialization object = gson.fromJson(jsonConfig, GsonSerialization.class);
        this.fieldNumber = object.fieldNumber;
        this.fieldString = object.fieldString;
        this.fieldObject = object.fieldObject;
        this.fieldMap = object.fieldMap;

        //Solve double instead of int problem
        Double doubleNum = (Double) fieldMap.get("field_number");
        Integer intNum = doubleNum.intValue();
        fieldMap.put("field_number", intNum);
    }

    public void deserialization(String filePath) throws IOException {
        measureStart();

        final Gson gson = new Gson();
        String serialization = gson.toJson(this);
        overwriteFile(filePath, serialization);

        measuresEnd();
        displayStats("Deserialization");
    }
}
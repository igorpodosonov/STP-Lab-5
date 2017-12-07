package serialization.serialize.types;

import org.json.JSONObject;
import serialization.ClassToSerialize;
import serialization.CustomObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OrgJsonSerialize extends SuperSerialization {

    public void runSerialization(String filePath) throws IOException {
        measureStart();

        String json = getTextFromFile(filePath);

        ClassToSerialize serializedClass = serialization(json);

        String deserialize = deserialization(serializedClass);
        overwriteFile(filePath, deserialize);

        measuresEnd();
        displayStats("Org.Json Serialize/Deserialize");
    }

    private String deserialization(ClassToSerialize serializedClass) {
        JSONObject jsnDeserialized = new JSONObject();
        jsnDeserialized.put("movie_name", serializedClass.name);
        jsnDeserialized.put("year", serializedClass.year);

        JSONObject jsnDirInfo = new JSONObject();
        jsnDirInfo.put("name", serializedClass.directorInfo.name);
        jsnDirInfo.put("birth_place", serializedClass.directorInfo.placeOfBirth);
        jsnDirInfo.put("birth_year", serializedClass.directorInfo.yearOfBirth);

        jsnDeserialized.put("director_info", jsnDirInfo);
        jsnDeserialized.put("actor_role", serializedClass.actorsRoles);

        return jsnDeserialized.toString(4);
    }

    private ClassToSerialize serialization(String json) {
        JSONObject jsnObj = new JSONObject(json);
        ClassToSerialize serializedClass = new ClassToSerialize();

        serializedClass.name = jsnObj.getString("movie_name");
        serializedClass.year = jsnObj.getInt("year");

        JSONObject dirInfo = jsnObj.getJSONObject("director_info");
        String name = dirInfo.getString("name");
        String birthPlace = dirInfo.getString("birth_place");
        int birthYear = dirInfo.getInt("birth_year");
        CustomObject customObj = new CustomObject(name, birthPlace, birthYear);
        serializedClass.directorInfo = customObj;

        Map<String, String> map = new HashMap<String, String>();
        JSONObject mapObj = jsnObj.getJSONObject("actor_role");
        Iterator<?> keys = mapObj.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = mapObj.getString(key);
            map.put(key, value);
        }

        serializedClass.actorsRoles = map;

        return serializedClass;
    }
}

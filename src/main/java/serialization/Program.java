package serialization;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        String filePath = "D://serialize.txt";

        GsonSerialization deserialize = new GsonSerialization(
                1,
                "qwerty",
                "qwerty",
                1,
                "field_string",
                "qwerty",
                "field_number",
                1);

        deserialize.deserialization(filePath);

        GsonSerialization serialize = new GsonSerialization(filePath);
    }
}
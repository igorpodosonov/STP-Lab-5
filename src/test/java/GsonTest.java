import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serialization.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class GsonTest {
    private String filePath = "D://serialize.txt";
    private GsonSerialization expectedClass;
    private GsonSerialization actualClass;

    @Before
    public void setUp() {
        expectedClass = new GsonSerialization(
                1,
                "qwerty",
                "qwerty",
                1,
                "field_string",
                "qwerty",
                "field_number",
                1);
    }

    @Test
    public void testSerialize() throws Exception {
        actualClass = new GsonSerialization(filePath);

        assertEquals(expectedClass.fieldString, actualClass.fieldString);
        assertEquals(expectedClass.fieldNumber, actualClass.fieldNumber);
        assertEquals(expectedClass.fieldObject.fieldNumber, actualClass.fieldObject.fieldNumber);
        assertEquals(expectedClass.fieldObject.fieldString, actualClass.fieldObject.fieldString);
        assertEquals(expectedClass.fieldMap, actualClass.fieldMap);
    }

    @Test
    public void testDeserialize() throws Exception {
        //Serialize from original file
        expectedClass = new GsonSerialization(filePath);

        //Serialize from original file and deserialize to the same file
        actualClass = new GsonSerialization(filePath);
        actualClass.deserialization(filePath);
        //Serialize from the deserialized file
        actualClass = new GsonSerialization(filePath);
        
        assertEquals(expectedClass.fieldString, actualClass.fieldString);
        assertEquals(expectedClass.fieldNumber, actualClass.fieldNumber);
        assertEquals(expectedClass.fieldObject.fieldNumber, actualClass.fieldObject.fieldNumber);
        assertEquals(expectedClass.fieldObject.fieldString, actualClass.fieldObject.fieldString);
        assertEquals(expectedClass.fieldMap, actualClass.fieldMap);
    }
}

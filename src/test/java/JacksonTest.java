import org.junit.Before;
import org.junit.Test;
import serialization.ClassToSerialize;
import serialization.serialize.types.GsonSerialize;
import serialization.serialize.types.JacksonSerialize;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JacksonTest {
    private String filePath = "D://serialize-gson.txt";
    private ClassToSerialize expectedClass;
    private ClassToSerialize actual;

    @Before
    public void setUp() throws IOException {
        JacksonSerialize jackson = new JacksonSerialize();
        expectedClass = jackson.serialize(filePath);
    }

    @Test
    public void testSerialize() throws Exception {
        JacksonSerialize jackson = new JacksonSerialize();
        actual = jackson.serialize(filePath);

        assertEquals(expectedClass.name, actual.name);
        assertEquals(expectedClass.year, actual.year);

        assertEquals(expectedClass.directorInfo.name, actual.directorInfo.name);
        assertEquals(expectedClass.directorInfo.yearOfBirth, actual.directorInfo.yearOfBirth);
        assertEquals(expectedClass.directorInfo.placeOfBirth, actual.directorInfo.placeOfBirth);

        assertEquals(expectedClass.actorsRoles, actual.actorsRoles);
    }

    @Test
    public void testDeserialize() throws Exception {
        JacksonSerialize jackson = new JacksonSerialize();
        jackson.deserialize(expectedClass);

        actual = jackson.serialize(filePath);

        assertEquals(expectedClass.name, actual.name);
        assertEquals(expectedClass.year, actual.year);

        assertEquals(expectedClass.directorInfo.name, actual.directorInfo.name);
        assertEquals(expectedClass.directorInfo.yearOfBirth, actual.directorInfo.yearOfBirth);
        assertEquals(expectedClass.directorInfo.placeOfBirth, actual.directorInfo.placeOfBirth);

        assertEquals(expectedClass.actorsRoles, actual.actorsRoles);
    }
}

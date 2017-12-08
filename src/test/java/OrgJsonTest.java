import org.junit.Before;
import org.junit.Test;
import serialization.ClassToSerialize;
import serialization.serialize.types.JacksonSerialize;
import serialization.serialize.types.OrgJsonSerialize;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OrgJsonTest {
    private String filePath = "serialize.txt";
    private ClassToSerialize expectedClass;
    private ClassToSerialize actual;

    @Before
    public void setUp() throws IOException {
        OrgJsonSerialize orgJson = new OrgJsonSerialize();
        expectedClass = orgJson.serialization(filePath);
    }

    @Test
    public void testSerialize() throws Exception {
        OrgJsonSerialize orgJson = new OrgJsonSerialize();
        actual = orgJson.serialization(filePath);

        assertEquals(expectedClass.name, actual.name);
        assertEquals(expectedClass.year, actual.year);

        assertEquals(expectedClass.directorInfo.name, actual.directorInfo.name);
        assertEquals(expectedClass.directorInfo.yearOfBirth, actual.directorInfo.yearOfBirth);
        assertEquals(expectedClass.directorInfo.placeOfBirth, actual.directorInfo.placeOfBirth);

        assertEquals(expectedClass.actorsRoles, actual.actorsRoles);
    }

    @Test
    public void testDeserialize() throws Exception {
        OrgJsonSerialize orgJson = new OrgJsonSerialize();
        orgJson.deserialization(expectedClass);

        actual = orgJson.serialization(filePath);

        assertEquals(expectedClass.name, actual.name);
        assertEquals(expectedClass.year, actual.year);

        assertEquals(expectedClass.directorInfo.name, actual.directorInfo.name);
        assertEquals(expectedClass.directorInfo.yearOfBirth, actual.directorInfo.yearOfBirth);
        assertEquals(expectedClass.directorInfo.placeOfBirth, actual.directorInfo.placeOfBirth);

        assertEquals(expectedClass.actorsRoles, actual.actorsRoles);
    }
}

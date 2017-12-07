import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serialization.*;
import serialization.serialize.types.GsonSerialize;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class GsonTest {
    private String filePath = "serialize.txt";
    private ClassToSerialize expectedClass;
    private ClassToSerialize actual;

    @Before
    public void setUp(){
        GsonSerialize gson = new GsonSerialize();
        expectedClass = gson.serialize(filePath);
    }

    @Test
    public void testSerialize() throws Exception {
        GsonSerialize gson = new GsonSerialize();
        actual = gson.serialize(filePath);

        assertEquals(expectedClass.name, actual.name);
        assertEquals(expectedClass.year, actual.year);

        assertEquals(expectedClass.directorInfo.name, actual.directorInfo.name);
        assertEquals(expectedClass.directorInfo.yearOfBirth, actual.directorInfo.yearOfBirth);
        assertEquals(expectedClass.directorInfo.placeOfBirth, actual.directorInfo.placeOfBirth);

        assertEquals(expectedClass.actorsRoles, actual.actorsRoles);
    }

    @Test
    public void testDeserialize() throws Exception {
        GsonSerialize gson = new GsonSerialize();
        gson.deserialize(expectedClass);

        actual = gson.serialize(filePath);

        assertEquals(expectedClass.name, actual.name);
        assertEquals(expectedClass.year, actual.year);

        assertEquals(expectedClass.directorInfo.name, actual.directorInfo.name);
        assertEquals(expectedClass.directorInfo.yearOfBirth, actual.directorInfo.yearOfBirth);
        assertEquals(expectedClass.directorInfo.placeOfBirth, actual.directorInfo.placeOfBirth);

        assertEquals(expectedClass.actorsRoles, actual.actorsRoles);
    }
}

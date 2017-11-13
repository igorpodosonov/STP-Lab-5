package serialization;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface MySerializeInterface {
    void deserialization(String filePath) throws IOException;
}

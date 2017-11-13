package serialization;
import java.io.*;
import java.util.Map;

public class ObjectToSerialize {
    public int fieldNumber;
    public String fieldString;
    public CustomObject fieldObject;
    public Map fieldMap;

    public String getTextFromFile(String filePath){
        String textFromFile = "";

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                textFromFile += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return textFromFile;
    }

    public void overwriteFile(String filePath, String contents) throws IOException {
        File myFoo = new File(filePath);
        FileWriter fooWriter = new FileWriter(myFoo, false);
        fooWriter.write(contents);
        fooWriter.close();
    }

    long timeStart;
    long memoryStart;
    long timeEnd;
    long memoryEnd;

    void measureStart() {
        timeStart = System.nanoTime();
        memoryStart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    void measuresEnd() {
        timeEnd = System.nanoTime();
        memoryEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    long getTime() {
        return timeEnd - timeStart;
    }

    long getMemory() {
        return memoryEnd - memoryStart;
    }

    void displayStats(String processName) {
        System.out.println(processName + " run time: " + getTime() + " ns, memory usage: " + getMemory());
    }
}

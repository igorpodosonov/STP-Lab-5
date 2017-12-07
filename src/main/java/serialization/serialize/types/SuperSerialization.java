package serialization.serialize.types;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.*;

public class SuperSerialization {
    @JsonIgnore
    long timeStart;
    @JsonIgnore
    long memoryStart;
    @JsonIgnore
    long timeEnd;
    @JsonIgnore
    long memoryEnd;

    void measureStart() {
        timeStart = System.currentTimeMillis();
        memoryStart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    void measuresEnd() {
        timeEnd = System.currentTimeMillis();
        memoryEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    long getTime() {
        return timeEnd - timeStart;
    }

    long getMemory() {
        return memoryEnd - memoryStart;
    }

    void displayStats(String processName) {
        String divider = "====================================";

        System.out.println(divider);
        System.out.println(processName + " \n run time: " + getTime() + " milliseconds, \n memory usage: " + (float)getMemory()/1000000 + " megabytes");
        System.out.println(divider);
    }

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
}

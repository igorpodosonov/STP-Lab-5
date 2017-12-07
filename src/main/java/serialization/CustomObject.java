package serialization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonRawValue;

public class CustomObject {
    @Expose
    public String name;
    @Expose
    @SerializedName("birth_place")
    @JsonProperty("birth_place")
    public String placeOfBirth;
    @Expose
    @SerializedName("birth_year")
    @JsonProperty("birth_year")
    public int yearOfBirth;

    public CustomObject(String name, String placeOfBirth, int yearOfBirth) {
        this.name = name;
        this.placeOfBirth = placeOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public CustomObject(){
        //Empty constructor for Jackson Serializer
    }
}

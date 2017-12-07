package serialization;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonRawValue;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({"name", "year", "director_info", "actor_role"})
public class ClassToSerialize {
    @Expose
    @SerializedName("movie_name")
    @JsonProperty("movie_name")
    public String name;

    @Expose
    @JsonProperty("year")
    public int year;

    @Expose
    @SerializedName("director_info")
    @JsonProperty("director_info")
    public CustomObject directorInfo;

    @Expose
    @SerializedName("actor_role")
    @JsonProperty("actor_role")
    public Map<String, String> actorsRoles;
}

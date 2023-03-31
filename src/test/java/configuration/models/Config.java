package configuration.models;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import java.util.*;

@Data
public class Config {
    private String defaultEnvironment;
    Map<String, Environment> environments = new LinkedHashMap<>();
    private Browser browser;


    @JsonAnySetter
    public void setEnvironments(String key, Environment value) {
        environments.put(key, value);
    }

    @JsonAnyGetter
    public List<Environment> getEnvironments() {
        List<Environment> list = new ArrayList<>();
        for (Environment environment : environments.values()) {
            list.add(environment);
        }
        return list;
    }

}

package entity.slack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Purpose {
    private String value;
    private String creator;
    @JsonProperty("last_set")
    private Long lastSet;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getLastSet() {
        return lastSet;
    }

    public void setLastSet(Long lastSet) {
        this.lastSet = lastSet;
    }
}

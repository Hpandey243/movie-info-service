package com.sapients.movieinfoservice.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "director",
        "producer"
})
public class FilmDTO {

    @JsonProperty("title")
    private String title;
    @JsonProperty("director")
    private String director;
    @JsonProperty("producer")
    private String producer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("director")
    public void setDirector(String director) {
        this.director = director;
    }

    @JsonProperty("producer")
    public String getProducer() {
        return producer;
    }

    @JsonProperty("producer")
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
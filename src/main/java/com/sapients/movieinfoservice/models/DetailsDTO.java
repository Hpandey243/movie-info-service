package com.sapients.movieinfoservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "results"
})
public class DetailsDTO {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("results")
    private final List<ResultDTO> results = null;

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("results")
    public List<ResultDTO> getResults() {
        return results;
    }


}

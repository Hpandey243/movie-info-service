package com.sapients.movieinfoservice.models;


import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"films"})
public class ResultDTO {

    @JsonProperty("films")
    public List<String> films = null;

}
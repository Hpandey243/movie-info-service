package com.sapients.movieinfoservice.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapients.movieinfoservice.models.Details;
import com.sapients.movieinfoservice.movieinfoconstants.Constants;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfflineMovieInfoServiceImpl  implements  OfflineMovieInfoService{
    String path= Constants.PLANET_FILE_PATH;
    @Override
    public Details getDetails(String type, String name) throws IOException {
        return getDetailsFromStubs(path).stream()
                .filter(detail-> detail.getType().equals(type) && name.equals(detail.getName()))
                .collect(Collectors.toList()).get(0);

    }

    private static List<Details> getDetailsFromStubs(final String pathName) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return List.of(mapper.readValue(new File(pathName), Details[].class));
    }

}

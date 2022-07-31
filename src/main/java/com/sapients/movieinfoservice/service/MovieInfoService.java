package com.sapients.movieinfoservice.service;

import com.sapients.movieinfoservice.exceptionHandler.MicroserviceException;
import com.sapients.movieinfoservice.models.Details;

import java.io.IOException;


public interface MovieInfoService {
    Details fetchMovieInfo(String type, String name) throws MicroserviceException, IOException;


}

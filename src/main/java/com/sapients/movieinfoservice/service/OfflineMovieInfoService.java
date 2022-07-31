package com.sapients.movieinfoservice.service;

import com.sapients.movieinfoservice.models.Details;

import java.io.IOException;
import java.util.List;

public interface OfflineMovieInfoService {

    Details getDetails(String type, String name) throws IOException;
}

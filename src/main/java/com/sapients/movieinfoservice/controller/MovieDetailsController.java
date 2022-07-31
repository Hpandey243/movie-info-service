package com.sapients.movieinfoservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sapients.movieinfoservice.exceptionHandler.MicroserviceException;
import com.sapients.movieinfoservice.models.Details;
import com.sapients.movieinfoservice.models.DetailsDTO;
import com.sapients.movieinfoservice.service.MovieInfoServiceImpl;
import com.sapients.movieinfoservice.service.OfflineMovieInfoService;
import com.sapients.movieinfoservice.service.OfflineMovieInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/movieInfo")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class MovieDetailsController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieDetailsController.class);
    @Autowired
    MovieInfoServiceImpl movieInfoService;

    @Autowired
    OfflineMovieInfoServiceImpl offlineMovieInfoService;

    @HystrixCommand(fallbackMethod = "getFallbackMovieInfo")
    @GetMapping("/{type}")
    public ResponseEntity<Details> getMovieInfo(@PathVariable(required = true) String type,
                                                @RequestParam(required = true) String name,
                                                @RequestParam(required = false, defaultValue = "false") boolean offlineMode)
            throws MicroserviceException, IOException {

        if (offlineMode) {
            LOGGER.info("Fetching data in offline mode for type {}",type);
            return new ResponseEntity<Details>(offlineMovieInfoService.getDetails(type, name), HttpStatus.OK);

        }
        LOGGER.info("Fetching data  for type {}",type);
        return new ResponseEntity<Details>(movieInfoService.fetchMovieInfo(type, name), HttpStatus.OK);

    }

    public ResponseEntity<DetailsDTO> getFallbackMovieInfo(@PathVariable(required = true) String type,
                                                           @RequestParam(required = true) String name,
                                                           @RequestParam(required = false, defaultValue = "false") boolean offlineMode) {
        return new ResponseEntity<>(new DetailsDTO(), HttpStatus.REQUEST_TIMEOUT);
    }
}
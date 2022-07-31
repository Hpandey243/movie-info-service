package com.sapients.movieinfoservice.Utils;

import com.sapients.movieinfoservice.controller.MovieDetailsController;
import com.sapients.movieinfoservice.exceptionHandler.MicroserviceException;
import com.sapients.movieinfoservice.exceptionHandler.NotFoundException;
import com.sapients.movieinfoservice.models.DetailsDTO;
import com.sapients.movieinfoservice.models.FilmDTO;
import com.sapients.movieinfoservice.service.OfflineMovieInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Component
public class SWApiConnector {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieDetailsController.class);
    @Value("${swapi.base.url}")
    public String baseUrl;
    @Autowired
    OfflineMovieInfoServiceImpl offlineMovieInfoService;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public DetailsDTO fetchInfo(String type, String name) throws MicroserviceException, IOException {

        DetailsDTO response;
        String url = baseUrl + type + "?search=" + name;

        try {
            response = restTemplate().getForObject(url, DetailsDTO.class);
            if (response == null) {
                throw new NotFoundException("No data found for this type");
            }

            return response;
        } catch (Exception ex) {
            LOGGER.error("Exception  while calling swapi");
            throw new MicroserviceException(ex.getLocalizedMessage());
        }
    }

    public FilmDTO fetchFilmsDetail(String filmsUrl) {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(filmsUrl);

        return this.restTemplate().getForObject(builder.build().encode().toUri(), FilmDTO.class);

    }
}
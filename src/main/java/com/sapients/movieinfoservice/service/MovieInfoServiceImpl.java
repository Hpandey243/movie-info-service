package com.sapients.movieinfoservice.service;

import com.sapients.movieinfoservice.exceptionHandler.MicroserviceException;
import com.sapients.movieinfoservice.Utils.SWApiConnector;
import com.sapients.movieinfoservice.models.Film;
import com.sapients.movieinfoservice.models.Details;
import com.sapients.movieinfoservice.models.DetailsDTO;
import com.sapients.movieinfoservice.models.ResultDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Autowired
    SWApiConnector apiConnector;

    @Override
    public Details fetchMovieInfo(String type, String name) throws MicroserviceException, IOException {
        DetailsDTO detailsInfo = apiConnector.fetchInfo(type, name);
        Details details = new Details();
        details.setCount(detailsInfo.getCount());
        details.setName(name);
        details.setType(type);
        if(!type.equals("films")){
            details.setFilms(fetchFilmDetails(detailsInfo.getResults()));
        }
        return details;
    }

    private List<Film> fetchFilmDetails(List<ResultDTO> results) {

        List<Film> filmList = new ArrayList<>();
        List<String> filmsUrl = results.stream()
                .flatMap(result -> result.films.stream())
                .collect(Collectors.toList());

        filmsUrl.stream().forEach(uri -> {
            Film film = new Film();
            BeanUtils.copyProperties(apiConnector.fetchFilmsDetail(uri), film);
            filmList.add(film);

        });
        return filmList;
    }
}
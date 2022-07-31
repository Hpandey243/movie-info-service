package com.sapients.movieinfoservice;

import com.sapients.movieinfoservice.exceptionHandler.MicroserviceException;
import com.sapients.movieinfoservice.models.Details;
import com.sapients.movieinfoservice.movieinfoconstants.Constants;
import com.sapients.movieinfoservice.service.OfflineMovieInfoServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfflineMovieInfoServiceApplicationTests {

    @InjectMocks
    OfflineMovieInfoServiceImpl movieInfoServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(movieInfoServiceImpl, "path", Constants.PLANET_FILE_PATH);
    }

    @Test
    public void test() throws MicroserviceException, IOException {
        Details details = movieInfoServiceImpl.getDetails("planets", "Yavin IV");
        Assert.assertNotNull(details);
        Assert.assertEquals(details.getName(), "Yavin IV");
        Assert.assertNotNull(details.getFilms());
    }

}
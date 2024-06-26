package org.example.accuweather;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.example.accuweather.weather.Weather;


import java.util.List;

import static io.restassured.RestAssured.given;

public class GetWeatherOneDayTest extends AccuweatherAbstractTest {

    @Test
    void getWeatherOneDay_shouldReturn() {

        Weather response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/1day/294021")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .extract()
                .response()
                .body().as(Weather.class);

        Assertions.assertEquals(1,response.getDailyForecasts().size());
    }
}

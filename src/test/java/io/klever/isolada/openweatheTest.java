package io.klever.isolada;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;



public class openweatheTest {

//variaveis
    String key = "5a86ba97cee28667a2ec18e72559cfea";
    String url = "https://api.openweathermap.org/data/2.5/weather";


    @Test
    public void testObtençaodeTemperaturaporLongitudeelatitudeComsucesso() {
        //configuraçoes de parametros
        given().queryParam("lat", "57").queryParam("lon", "2.15").queryParam("appid", key)
                .when().get(url)
                .then().assertThat()
                .statusCode(200);


    }

    @Test
    public void testObtençaodeTemperaturaporLongitudeelatitudesemAppid() {
//configurações de parametros
        given().queryParam("lat", "57").queryParam("lon", "2.15")
                .when().get(url)
                .then().assertThat()
                .statusCode(401);
    }


    @Test
    public void testObtençaodetemperaturaPelonomeDacidade() {
        //configurações de parametros
        given().queryParam("q", "los angeles").queryParam("appid", key)
                .when().get(url)
                .then().log().body();


    }

    @Test
    public void Validarcidade() {
        //configurações de parametros
        String cidade = given().queryParam("q", "Los Angeles").queryParam("appid", key)

                .when().get(url)
                .then().extract().path("sys.country");
//validação de resposta
        System.out.println(cidade);
        Assert.assertTrue(cidade.equals("US"));


    }

}


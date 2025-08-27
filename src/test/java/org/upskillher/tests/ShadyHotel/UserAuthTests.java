package org.upskillher.tests.ShadyHotel;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.upskillher.bases.BaseTest;
import org.upskillher.models.Login;

public class UserAuthTests extends BaseTest { //extendemos la base para traer datos que se neceistan

@Test
    public void gettingTokenFromUserWithValidCredentials() {
    Login login = new Login("admin", "password");
    Response response = RestAssured  //para pedirle que nos de el bodyResponse
            .given()
            .body(login)
            .when()
            .post("/auth/login")
            .then()
            .log()
            .all()
            .statusCode(200)
            .extract() //extraer el response
            .response();
    JsonPath responseBody = new JsonPath(response.asString());
    String token = responseBody.getString("token");
    BaseTest.token = token;  //guardar el token en baseTest
    System.out.println("Token generado: " + token); //instruccion para ver el token en consola
}//gettingTokenFromUserWithValidCredentials

    @Test
    public void gettingTokenFromUserWithInvalidCredentials() {
        Login login = new Login("fake", "fake");
        Response response = RestAssured  //para pedirle que nos de el bodyResponse
                .given()
                .body(login)
                .when()
                .post("/auth/login")
                .then()
                .log()
                .all()
                .statusCode(401)
                .extract() //extraer el response
                .response();
        JsonPath responseBody = new JsonPath(response.asString());
        String token = responseBody.getString("token");
        BaseTest.token = token;  //guardar el token en baseTest
        System.out.println("Token generado: " + token); //instruccion para ver el token en consola
    }//gettingTokenFromUserWithInvalidCredentials

    @Test
    public void gettingTokenFromUserWithEmptyCredentials() {
        Login login = new Login("", "");
        Response response = RestAssured  //para pedirle que nos de el bodyResponse
                .given()
                .body(login)
                .when()
                .post("/auth/login")
                .then()
                .log()
                .all()
                .statusCode(401)
                .extract() //extraer el response
                .response();
        JsonPath responseBody = new JsonPath(response.asString());
        String token = responseBody.getString("token");
        BaseTest.token = token;  //guardar el token en baseTest
        System.out.println("Token generado: " + token); //instruccion para ver el token en consola
    }//gettingTokenFromUserWithEmptyCredentials



}//UserAuthTests

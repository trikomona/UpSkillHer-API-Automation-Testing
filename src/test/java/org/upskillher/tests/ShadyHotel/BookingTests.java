package org.upskillher.tests.ShadyHotel;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.upskillher.bases.BaseTest;
import org.upskillher.models.BookingData;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class BookingTests extends BaseTest { //Extendemos para que traiga elementos de la base

    @Test
    public void successfullyBookingWithValidKeys () {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .body(BookingData.getBookingMap())  //se manda a llamar el map de BookingData, primero se instancia
                .when()
                .post("/booking")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Respuesta completa: " + response.asString());
    }//SuccessfullyBookingWithValidKeys

    @Test
    public void unsuccessfullyBookingWithValidKeysAndPastDates () { //
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .body(BookingData.getBookingMapWrongDates())  //se manda a llamar el map de BookingData, primero se instancia
                .when()
                .post("/booking")
                .then()
                .log().all()
                .statusCode(400) //da como respuesta un 200
                .extract()
                .response();
        System.out.println("Respuesta completa: " + response.asString());
    }//SuccessfullyBookingWithValidKeysAndPastDates

    @Test
    public void unsuccessfullyBookingWithEmptyDetails () {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .body(BookingData.getBookingWithEmptyDetails())  //se manda a llamar el map de BookingData, primero se instancia
                .when()
                .post("/booking")
                .then()
                .log().all()
                .statusCode(400)
                .extract()
                .response();
        System.out.println("Respuesta completa: " + response.asString());
    }//unsuccessfullyBookingWithEmptyDetails

    @Test
    public void unsuccessfullyBookingWithoutBookingDates () {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .body(BookingData.getBookingWithoutBookingDates())  //se manda a llamar el map de BookingData, primero se instancia
                .when()
                .post("/booking")
                .then()
                .log().all()
                .statusCode(400)
                .extract()
                .response();
        System.out.println("Respuesta completa: " + response.asString());
    }//unsuccessfullyBookingWithEmptyDetails

    @Test
    public void getBookingIds() {  //**************pendiente a que Irvin nos de los passos a seguir
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .when()
                .get("/booking")
                .then()
                .log().all()
                .statusCode(400)
                .extract()
                .response();
        System.out.println("Respuesta completa: " + response.asString());
    }//getBookingIds




}//BookingTests

package org.upskillher.tests.ShadyHotel;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.upskillher.bases.BaseTest;
import org.upskillher.models.BookingData;

import java.util.HashMap;
import java.util.Map;

public class RoomsTests extends BaseTest {  //extendemos base para traernos instrucciones que estan en esa clase

    @Test
    public void getAllRoomsThatIsAvailable () {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .when()
                .get("/room")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Respuesta completa: " + response.asString());
    }//getAllRoomsThatIsAvailable

    @Test
    public void getAvailableRoomsWithSpecificParams() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .queryParam("roomid", "1")
                .queryParam("roomPrice", "100")
                .when()
                .get("/room")
                .then()
                .statusCode(200) //Se trae todos los rooms
                .extract()
                .response();

        System.out.println("Available rooms: " + response.asString());
    }//getAvailableRoomsWithSpecificParams


    @Test
    public void getAvailableRoomsWithSpecificDates() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .queryParam("checkin", "2025-10-20")
                .queryParam("checkout", "2025-10-30")
                .when()
                .get("/room")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Available rooms: " + response.asString());
    }//getAvailableRoomsWithSpecificDates


    @Test
    public void getAvailableRoomsWithPastSpecificDates() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .queryParam("checkin", "2025-01-20")
                .queryParam("checkout", "2025-01-30")
                .when()
                .get("/room")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Available rooms: " + response.asString());
    }//getAvailableRoomsWithPastSpecificDates

    @Test
    public void getAvailableRoomsWithEmptyPastSpecificDates() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .queryParam("checkin", "")
                .queryParam("checkout", "")
                .when()
                .get("/room")
                .then()
                .statusCode(200) //deberia dar 400
                .extract()
                .response();

        System.out.println("Available rooms: " + response.asString());
    }//getAvailableRoomsWithEmptyPastSpecificDates

    @Test
    public void getAvailableRoomsWithOnlyCheckOutDate() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .queryParam("checkout", "2025-01-30")
                .when()
                .get("/room")
                .then()
                .statusCode(200) //deberia dar 400
                .extract()
                .response();

        System.out.println("Available rooms: " + response.asString());
    }//getAvailableRoomsWithEmptyPastSpecificDates

    @Test
    public void updateRoomPrice() {
        Map<String, Object> bodyRequest = new HashMap<>(); //campo a actualizar
        bodyRequest.put("roomPrice", 300);//actualizar
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .body(bodyRequest)
                .when()
                .patch("/room/1")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Respuesta del PATCH: " + response.asString());
    }//updateRoomPrice

}//RoomsTests


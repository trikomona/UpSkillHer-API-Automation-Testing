package org.upskillher.tests.ShadyHotel;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.upskillher.bases.BaseTest;
import org.upskillher.models.MessageData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class MessagesTests extends BaseTest {

    @Test
    public void createNewMessage() {
        Map<String, Object> body = MessageData.createMessage(
                "Marinita",
                "marinitae@example.com",
                "345234234566",
                "Esto es una prueba",
                "I would like to inquire about room availability"
        );
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .body(body)
                .when()
                .post("/message")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Respuesta completa: " + response.asString());
    }//createNewMessage

    @Test
    public void createNewMessageWithEmptyData() {
        Map<String, Object> body = MessageData.createMessage(
                "",
                "",
                "",
                "",
                ""
        );
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseTest.token)
                .contentType("application/json")
                .body(body)
                .when()
                .post("/message") // Endpoint para enviar mensajes
                .then()
                .log().all()
                .statusCode(400) //
                .extract()
                .response();

        System.out.println("Respuesta completa: " + response.asString());
    }//createNewMessageWithEmptyData


    @Test
    public void getAllMessagesCreated() {
        Response response = RestAssured
                .given()
                .when()
                .get("/message")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asString());
        //response.then().body("name", equalTo("Marinita"));
    }//getAllMessagesCreated

    @Test
    public void getAMessageWithId() {
        Response response = RestAssured
                .given()
                .queryParam("id", 2)
                .when()
                .get("/message")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asString());
        //response.then().body("name", equalTo("Marinita"));
    }//getAMessageWithId

    @Test
    public void getAMessageWithName() {
        Response response = RestAssured
                .given()
                .queryParam("name", "Marinita")
                .when()
                .get("/message")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asString());
        //response.then().body("name", equalTo("Marinita"));
    }//getAMessageWithName

}//MessagesTests

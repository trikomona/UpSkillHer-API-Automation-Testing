package org.upskillher.bases;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    public static String token;
    public RequestSpecification requestSpecification; //este es un objeto
    //que va a traer informacion del givven, la cual se hereda a donde se solicite extends

    @BeforeTest
    public void settingUpConfig (){
        RestAssured.baseURI="https://automationintesting.online/api";
        //pagina de inicio ademas del RestAssured pues este se va a estar heredando
    }//settingUpConfig

    @BeforeMethod
    public void SetUpHeader(){
    }//SetUpHeader
}//BaseTest

package api.stepdefinitions;

import api.pojo.AdminUserPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utils.ConfigReader_UI_API;
import java.io.File;
import java.io.IOException;
public class RegisterAdminStepDef {
    Response response;
    @When("user has codefish endpoint")
    public void userHasCodefishEndpoint() {
        RestAssured.baseURI= ConfigReader_UI_API.readProperty("api_url");
        RestAssured.basePath ="/register";
    }
    @Then("user sends POST request to register admin user and status code is {int}")
    public void userSendsPOSTRequestToRegisterAdminUserAndStatusCodeIs(int statusCode) throws IOException {
        AdminUserPojo user = new AdminUserPojo();
        user.setUsername("Aigerim6");
        user.setPassword("1234");
        user.setRole("ROLE_ADMIN");

        File jsonFile = new File("src/test/resources/adminUser.json");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(jsonFile,user);

        response=RestAssured.given().contentType(ContentType.JSON)
                .body(jsonFile)
                .auth().basic("admin", "admin")
                .when().post()
                .then().statusCode(statusCode).log().body()
                .body("username", Matchers.equalTo("Aigerim6"))
                .and().body("role",Matchers.equalTo("ROLE_ADMIN"))
                .extract().response();
    }
}

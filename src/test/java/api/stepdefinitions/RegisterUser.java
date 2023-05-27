package api.stepdefinitions;

import api.pojo.RegisterUserPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utils.ConfigReader_UI_API;

import java.io.File;
import java.io.IOException;

public class RegisterUser {

    Response response;

    @Given("user has codefish endpoint")
    public void userHasCodefishEndpoint() {
        RestAssured.baseURI= ConfigReader_UI_API.readProperty("api_url");
        RestAssured.basePath="register";
    }
    @When("user sends POST request to register regular user {string}, validates username {string} and role, status code is {int}")
    public void userSendsPOSTRequestToRegisterRegularUserValidatesUsernameAndRoleStatusCodeIs(String role, String username, int statusCode) throws IOException {
        RegisterUserPojo user = new RegisterUserPojo();
        user.setUsername(ConfigReader_UI_API.readProperty("api_regular_username"));
        user.setPassword(ConfigReader_UI_API.readProperty("api_regular_password"));
        user.setRole(role);
        File jsonFile = new File("src/test/resources/registerUser.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(jsonFile,user);
        response=RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonFile)
                .auth().basic("admin", "admin").when().post().then().statusCode(statusCode)
                .body("username", Matchers.equalTo(username))
                .and().body("role",Matchers.equalTo(role)).extract().response();
    }

}

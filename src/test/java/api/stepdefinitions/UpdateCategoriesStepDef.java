package api.stepdefinitions;

import api.pojo.CategoryPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader_UI_API;

import java.util.Optional;

public class UpdateCategoriesStepDef {

    Response response;

    @Given("User checks the endpoint")
    public void user_checks_the_endpoint() {
        RestAssured.baseURI = ConfigReader_UI_API.readProperty("api_url");
        RestAssured.basePath = "api/ecommerce/categories/edit/";
    }
    @When("User sents PUT request to the server to update a category with {int} and {string}")
    public void userSentsPUTRequestToTheServerToUpdateACategoryWithAnd(int id, String name) {
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setId(id);
        categoryPojo.setName(name);
        response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(categoryPojo)
                .auth().basic("admin","admin")
                .when().put(String.valueOf(id));
    }
    @Then("User validates the status code {int}")
    public void user_validates_the_status_code(int statusCode) {
       response.then().statusCode(statusCode);
    }

    @Then("User should get the category with {int} and {string}")
    public void userShouldGetTheCategoryWithAnd(int id, String name) {
      CategoryPojo parsedResp = response.as(CategoryPojo.class);
      Assert.assertEquals(id,parsedResp.getId());
      Assert.assertEquals(name,parsedResp.getName());
    }

    @When("User sends a PUT request to the server to update a category with id {int} and an empty name {string}")
    public void user_sends_a_put_request_to_the_server_to_update_a_category_with_id_and_an_empty_name(int id, String name) {
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setId(id);
        categoryPojo.setName(name);
        response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(categoryPojo)
                .auth().basic("admin","admin")
                .when().put(String.valueOf(id));
    }
    @Then("User validates the status code is {int}")
    public void user_validates_the_status_code_is(int statusCode) {
        response.then().statusCode(statusCode);
    }



}

package api.stepdefinitions;

import api.pojo.CategoryPojo;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader_UI_API;

public class AddCategoriesStepDef {

    Response response;

    @Given("Categories are available on the server")
    public void categoriesAreAvailableOnTheServer() {
        RestAssured.baseURI= ConfigReader_UI_API.readProperty("api_url");
        RestAssured.basePath="api/ecommerce/categories";
    }


    @When("I sent post API request to server to add a category with {int} and {string}")
    public void iSentPostAPIRequestToServerToAddACategoryWithAnd(int id, String name) {
        CategoryPojo category=new CategoryPojo();
        category.setId(id);
        category.setName(name);
        response=RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(category)
                .auth().basic("admin", "admin")
                .when().post("add");
    }

    @Then("The status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("I should get the category with {int} and {string}")
    public void iShouldGetTheCategoryWithAnd(int id, String name) {
        Response getResponse=RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .auth().basic("admin", "admin")
                .when().get(String.valueOf(id))
                .then().statusCode(200).extract().response();

        CategoryPojo parsedResponse=response.as(CategoryPojo.class);
        Assert.assertEquals(id,parsedResponse.getId());
        Assert.assertEquals(name,parsedResponse.getName());
    }

}

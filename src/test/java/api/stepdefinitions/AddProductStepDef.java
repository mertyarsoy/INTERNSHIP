package api.stepdefinitions;

import api.pojo.ProductPojo;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.BrowserUtils;
import utils.ConfigReader_UI_API;

public class AddProductStepDef {

    Response response;
    @Given("User has valid API endpoint")
    public void userHasValidAPIEndpoint() {
        RestAssured.baseURI= ConfigReader_UI_API.readProperty("base_uri");
        RestAssured.basePath=ConfigReader_UI_API.readProperty("base_path");
    }
    @When("User sends POST request to add product with  {int}, {string} and {int}")
    public void userSendsPOSTRequestToAddProductWithAnd(int id, String name, int price) {
        ProductPojo product = new ProductPojo();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(product)
                .auth().basic("admin","admin")
                .when().post("add");
    }
    @Then("Status code is {int}")
    public void statusCodeIs(int expectedStatusCode) {
        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);

    }

    @Then("User should get a product {int}, {string} and {int}")
    public void userShouldGetAProductAnd(int  id, String name, int price) {

        Response response1 = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .auth().basic("admin","admin")
                .when().get(String.valueOf(id))
                .then().statusCode(200).extract().response();

        ProductPojo parsedResp = response.as(ProductPojo.class);

        Assert.assertEquals(id,parsedResp.getId());
        Assert.assertEquals(name,parsedResp.getName());
        Assert.assertEquals(price,parsedResp.getPrice());



    }


}

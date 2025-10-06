package com.nttdata.steps;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderCreateStep {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear orden en PetStore")
    public void orderCreate(int petId, int quantity, String shipDate, String status ){

        SerenityRest.given()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": "+ petId +",\n" +
                        "  \"quantity\": "+ quantity +",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
        ;
    }

    public void validateStatusCode(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validateBody() {
        restAssuredThat(response -> {
            response.contentType(ContentType.JSON);
            response.body("id", notNullValue());
        });
    }

}

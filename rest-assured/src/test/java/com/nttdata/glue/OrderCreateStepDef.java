package com.nttdata.glue;

import com.nttdata.steps.OrderCreateStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderCreateStepDef {

    @Steps
    OrderCreateStep orderCreateStep;

    @Given("url {string}")
    public void urlHttpsPetstoreSwaggerIoVStoreOrder(String arg0) {

    }

    @When("creo la orden con petId {int}, quantity {int}, shipDate {string}, status {string}")
    public void creoLaOrdenConPetIdQuantityShipDateStatus(int petId, int quantity, String shipDate, String status) {
        orderCreateStep.orderCreate(petId,quantity,shipDate,status);
    }

    @Then("codigo de respuesta es {int}")
    public void codigoDeRespuestaEs(int statusCode) {
        orderCreateStep.validateStatusCode(statusCode);
    }

    @And("valido el resultado")
    public void validoElResultado() {
        orderCreateStep.validateBody();
    }

}

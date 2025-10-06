package com.nttdata.glue;

import com.nttdata.steps.OrderQueryStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.thucydides.core.annotations.Steps;

public class OrderQueryStepDef {
    @Steps
    OrderQueryStep orderQueryStep;

    @When("consulto la orden con orderId {int}")
    public void consultoLaOrdenConOrderId(int orderId) {
        orderQueryStep.orderQuery(orderId);
    }

    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
    orderQueryStep.validateStatusCode(statusCode);
    }

}

package com.nttdata.steps;

import com.nttdata.model.Order;

import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.*;

public class OrderQueryStep {

    private static String URL_BASE = "https://petstore.swagger.io/v2/";

    public Order order;

    public void orderQuery(int orderId){
        Response response = given()
                .baseUri(URL_BASE)
                .log()
                .all()
                .when()
                .get("store/order/" + orderId);

        if (response.statusCode() == 200) {
            order = response.as(Order.class);
            orderList(order);
        } else if (response.statusCode() == 404) {
            String message = response.toString();
            System.out.println(message);
        }
    }
    public void orderList(Order order){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("orderId: " + order.getId());
        System.out.println("petId: " + order.getPetId());
        System.out.println("Cantidad: " + order.getQuantity());
        System.out.println("Fecha: " + order.getShipDate());
        System.out.println("Estado: " + order.getStatus());
        System.out.println("Completado: " + order.isComplete());
    }
    public void validateStatusCode(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
}

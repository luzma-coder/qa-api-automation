Feature: Crear y consultar ordenes para mascota usando karate

  Background:
    Given url "https://petstore.swagger.io/v2/"
@crear
  #https://petstore.swagger.io/v2/store/order
  Scenario Outline: Crear orden para mascota mediante POST
    Given path "store/order"
    And request
    """
    {
      "id": 0,
      "petId": <petIdValue>,
      "quantity": <quantityValue>,
      "shipDate": "2025-10-05T17:33:00.798Z",
      "status": "placed",
      "complete": true
    }
    """
    When method post
    Then status <codeResponse>
    And print response

    #And match $.id != ""
    Examples:
      | petIdValue | quantityValue | codeResponse |
      | 2          | 5             | 200          |
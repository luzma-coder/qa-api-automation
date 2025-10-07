Feature: Crear y consultar ordenes para mascota usando karate

  Background:
    Given url "https://petstore.swagger.io/v2/"
  @crear
  Scenario: Crear orden para mascota mediante POST
    Given path "store/order"
    And request
    """
    {
      "id": 0,
      "petId": 2,
      "quantity": 5,
      "shipDate": "2025-10-05T17:33:00.798Z",
      "status": "placed",
      "complete": true
    }
    """
    When method post
    Then status 200
    And print response
    * def storeId = response.id

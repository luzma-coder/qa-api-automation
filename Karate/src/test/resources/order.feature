Feature: Crear y consultar ordenes para mascota usando karate

  Background:
    Given url "https://petstore.swagger.io/v2/"

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
    And def orderId = response.id
    And print orderId

#  Scenario: Consultar orden numero storeId
#    Given path "store/order/"
#    And param orderId  = orderId
#    When method get
#    Then status 200
#    And print response

    Scenario: Consultar orden numero 2
      Given path "store/order/2"
      When method get
      Then status 200
      And print response

#  Scenario: Eliminar orden numero storeId
#    Given path "store/order/"
#    And param orderId  = orderId
#    When method get
#    Then status 200
#    And print response

  Scenario: Elminar orden numero 2
      Given path "store/order/2"
      When method delete
      Then status 200
      And print response

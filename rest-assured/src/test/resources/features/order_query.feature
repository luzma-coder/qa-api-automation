Feature: Consultar orden para PetStore

  @query
  Scenario: Consultar orden para PetStore
    Given url 'https://petstore.swagger.io/v2/store/order/orderId'
    When consulto la orden con orderId 2
    Then el codigo de respuesta es 200
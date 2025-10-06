Feature: Crear y consultar orden para PetStore

  @create
  Scenario: Crear orden para PetStore
    Given url 'https://petstore.swagger.io/v2/store/order'
    When creo la orden con petId 8, quantity 3, shipDate "025-10-05T16:48:48.522Z", status "placed"
    Then codigo de respuesta es 200
    And valido el resultado

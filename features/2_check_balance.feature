Feature: Revisar el balance de un usuario
   Como un cliente de API WEB (no humano)
   Requiero revisar el balance total de un usuario

   Scenario: Revision del balance de un usuario
    Given El siguiente dato NOMBRE "Pedro Gomez"
    When Preparo el JSON con los datos del usuario
    And Hago una request POST para obtener el balance del usuario
    Then Recibo una respuesta con http status 200
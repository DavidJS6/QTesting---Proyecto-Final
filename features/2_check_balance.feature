Feature: Revisar el balance de un cliente
   Como un cliente de API WEB (no humano)
   Requiero revisar el balance total de un cliente

   Scenario: Revision del balance de un cliente
    Given El siguiente dato NOMBRE "Pedro Gomez"
    When Preparo el JSON con los datos del cliente
    Then Hago una request POST para obtener el balance del cliente
    Then Recibo una respuesta con http status 200
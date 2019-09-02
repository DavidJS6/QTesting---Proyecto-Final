Feature: Registra un nuevo usuario
   Como un cliente de API WEB (no humano)
   Requiero registrar un nuevo usuario

  Scenario: Registro de un usuario
   Given Los siguientes datos ID 10 NOMBRE "Alfonso" CI 1234567
    When Preparo el JSON de los datos
    Then Hago un request POST hacia el url user con los datos
    Then Recibo una respuesta con http status 201
 
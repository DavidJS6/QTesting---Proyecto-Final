Feature: Registrar una transaccion con un usuario nuevo
   Como un cliente de API WEB (no humano)
   Requiero registrar un nuevo usuario y luego registrar una transaccion

  Scenario: Registro de una transaccion
    Given Los siguientes datos NOMBRE "Pedro Gomez" y MONTO 50
    When Preparo el JSON para registrar un nuevo usuario
    And Hago una request POST para registrar al usuario
    And Preparo el JSON para registrar la transaccion
    And Hago una request POST para registrar la transaccion
    Then Recibo una respuesta con http status 200 de la transaccion
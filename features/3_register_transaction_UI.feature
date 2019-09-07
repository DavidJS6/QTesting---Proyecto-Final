Feature: Mostrar balance de un usuario
 Como Usuario Final (humano)
 Quiero ver el balance y el detalle de transacciones de un usuario

  Scenario: Se tiene datos validos y se muestran correctamente
    Given Los siguientes datos de usuario NOMBRE "David Sandoval" y MONTO 100
    When Navego a la pagina principal del sistema
    And Introduzco el nombre del usuario
    And Presiono el boton Registrarse
    And Introduzco el monto para la transaccion
    And Presiono el boton Registrar ingreso
    Then Se debe mostrar el balance de "100"
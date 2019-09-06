Feature: Mostrar balance de un cliente
 Como Usuario Final (humano)
 Quiero ver el balance y el detalle de transacciones de un cliente

  Scenario: Se tiene datos validos y se muestran correctamente
    Given Los siguientes datos de cliente NOMBRE "David Sandoval" y MONTO 100
    When Navego a la pagina principal del sistema
    And Introduzco el nombre del cliente
    And Presiono el boton Registrarse
    And Introduzco el monto para la transaccion
    And Presiono el boton Registrar ingreso
    Then Se debe mostrar el balance de "100"
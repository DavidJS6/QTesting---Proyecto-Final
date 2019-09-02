Feature: Mostrar informacion del usuario
 Como Usuario Final (humano)
 Quiero ver los datos de un usuario del sistema

 Scenario: Se tiene datos validos y se muestran correctamente
  Given Dados datos de usuario nombre: "Jaime Z" y ci: 1234567
   When Navego a la pagina principal 
     And Llenar el campo de nombre
     And Llenar el campo de ci
     And Hacer click en el boton Show
     Then Se debe mostrar la cadena "Jaime Z - 1234567"
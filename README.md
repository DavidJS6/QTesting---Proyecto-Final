# QTesting - Proyecto final

Proyecto desarrollado para el modulo 3: "pruebas de software" de la Maestria de Direcciòn Estratégica
en Ingenieria de Software en el que se implementaron todos los niveles de pruebas en el diagrama
piramidal, la cual se compone de las siguientes pruebas:

- Pruebas unitarias
- Pruebas de integracion
- Pruebas de UI automatizadas

Este proyecto consta de dos partes:

- **Codigo NodeJS:** el cual se utiliza para realizar las pruebas de integración y de UI
automatizadas utilizando [CucumberJS](https://cucumber.io/docs/installation/javascript/), junto a 
su lenguaje Gherkin; y los servicios web proporcionados por un servidor.

- **Servidor Java:** el cual se encarga de levantar los servicios web que se utilizan en el
código NodeJS, además de dar acceso una interfaz gráfica para hacer uso de esos servicios. Fue
desarrollado utilizando [Spring Boot](https://spring.io/projects/spring-boot) y ofrece los
servicios web básicos de una billetera movil junto a las pruebas unitarias de dichos servicios. 
Entre los servicios web que ofrece se encuentran:

    - Registro de usuario
    - Registro de transacción de ingreso
    - Registro de transacción de retiro
    - Consulta del saldo total de un usuario
   
    
### Pasos para obtener y ejecutar el proyecto
    
* Debe asegurarse de tener NodeJS instalado en su sistema, en caso de no tenerlo puede 
descargarlo del siguiente enlace [NodeJS](https://nodejs.org/es/)

* Debe tener instalado el JDK de Java y en caso de ser necesario, declarar la variable de entorno
JAVA_HOME para que apunte al directorio donde tiene instalado el JDK.
 
* Clonar el proyecto en algun directorio en su sistema

* Utilizando una consola dirigirse al directorio donde tiene clonado el proyecto y ejecutar el
siguiente comando para instalar las dependencias de NodeJS:

        - npm install

* Para levantar el servidor se contara con dos formas, se podrá ejecutar el código mismo del
servidor, el cual se encuentra en la carpeta server/qtesting-server, o se podrá utilizar
el archivo jar ejecutable del servidor

    * Para ejecutar el código del servidor solo basta con abrir el directorio server/qtesting-server, 
    el cual se encuentra dentro del proyecto clonado; usando algún IDE y ejecutar el proyecto
    para que se instalen ciertas dependencias maven y se levante el servidor.
    
    * Para levantar el servidor utilizando el archivo jar se deberá dirigir al directorio server 
    utilizando una consola y ejecutar el siguiente comando
    
            > java -jar qtesting-server-1.0.0-SNAPSHOT.jar

De cualquiera de las dos formas mencionadas anteriormente se terminará teniendo un servidor
al cual se podrá acceder por medio del siguiente enlace [http://localhost:42624/home](http://localhost:42624/home)


### Pasos para ejecutar las pruebas unitarias

* Utilizando cualquier IDE de su preferencia se deberá abrir el directorio server/qtesting-server
y dirigirse a la sección de pruebas en src/test/java/com/example/qtestingserver en donde se podrá
tener acceso a la clase "UserTest" que es donde se encuentran las distintas pruebas unitarias,
las pruebas unitarias que se implementaron son:

    * **invalidClientNameTest:** prueba donde se valida cuando un usuario intenta registrar un
    nombre con caracteres especiales.
    * **clientSuccessfullyRegisteredTest:** prueba donde se valida cuando un usuario se regisra
    de forma correcta.
    * **transactionWithNoRegisteredClient:** prueba donde se valida cuando se intenta realizar
    una transaccion con un usuario que no se encuentra registrado.
    * **transactionWithAmountZeroTest:** prueba donde se valida cuando se intenta hacer una
    transaccion con un monto igual a zero (0).
    * **transactionWithInsufficientBalance:** prueba donde se valida cuando se intenta hacer
    una transaccion de retiro pero el saldo del usuario no es suficiente.
    * **incomeTransactionTest:** prueba donde se valida cuando una transaccion de ingreso
    se realiza de forma exitosa.
    * **withdrawalTransactionTest:** prueba donde se valida cuando una transaccion de retiro
    se realiza de forma exitosa.


### Pasos para ejecutar las pruebas de integridad y UI automatizadas

* Utilizando una consola o algun editor de texto que cuenta con una consola (por ejemplo 
[Visual Studio Code](https://code.visualstudio.com)), ingresar al directorio donde se clono
el proyecto y ejecutar el siguiente comando

        - ./node_modules/.bin/cucumber-js

* Las pruebas de integracion que se implementaron son:

    *  **register_transaction:** Prueba en donde se utilizan los servicios web del servidor Java
    para registrar un nuevo usuario y una transferencia de registro.
    * **check_balance:** Prueba en donde se utilizan los servicios web del servidor Java
    para obtener el saldo de un usuario que se encuentra registrado (se ocupa el mismo nombre
    de usuario que en la prueba "register_transaction" por lo que se obtiene el resultado de 
    dicha transaccion).

* La prueba de UI automatizada que se implemento es:

    * **register_transaction_UI:** Prueba que tiene el mismo comportamiento que la prueba
    "register_transaction" (se registra un usuario y una transaccion de ingreso) con la 
    diferencia de que esta prueba interactua con la vista HTML para hacer las validaciones.

        
**Nota:** Para que estas pruebas se puedan realizar de forma exitosa es necesario que el servidor
Java se encuentre previamente levantado antes de ejecutar el comando de cucumberJS
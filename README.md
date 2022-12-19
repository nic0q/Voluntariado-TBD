# Laboratorio N°3 - Laboratorio de Taller de Base de Datos
Este repositorio contiene todos los archivos relacionados con el Laboratorio N°3 del
Laboratorio de Taller de Base de Datos (Base de Datos Avanzadas 13317) desarrollado
por el equipo 5. 

## Integrantes del equipo 5
* [Vanina Correa](https://github.com/Vanina11)
* [Nícolas Farfán](https://github.com/nic0q)
* [Vicente Muñoz](https://github.com/LeVixo)
* [Xavier Muñoz](https://github.com/iChavy)
* [John Serrano](https://github.com/PodssilDev)
* [Nicolas Venegas](https://github.com/nicovenegas2)

## Descripción
El Laboratorio consiste en expandir lo realizado en el Laboratorio 1 y 2, ahora realizando consulta realizadas con Base de Datos No Relacionales (No SQL), utilizando MongoDB. Para ello, se realiza un Backend utilizando Java y un Frontend donde las vistas fueron creadas utilizando VUE.js + Nuxt para poder realizar ciertos requisitos del Laboratorio N°3 del curso. <br>

El repositorio incluye tres carpetas principales:  <br>
* [Carpeta Backend](https://github.com/nic0q/TBD-MongoDB/tree/main/Backend): Contiene todos los archivos del Backend del proyecto y las clases de las entidades del modelo. 
Se distribuyen las clases en los paquetes Services, Repositories y Models.
* [Carpeta Database](https://github.com/nic0q/TBD-MongoDB/tree/main/DataBase): Contiene los archivos .json para crear la Base de Datos, cargar los datos de prueba, cargar las emergencias, regiones, tareas y voluntarios en formato MongoDB.
* [Carpeta Frontend](https://github.com/nic0q/TBD-MongoDB/tree/main/Frontend): Contiene todos los archivos del Frontend y las vistas realizas utilizando Vue + Nuxt.JS. 
Principalmente, está la vista para poder ver las emergencias por cada región y la vista para ver una lista de emergencias con menos voluntarios.

## Modelo a seguir para el Laboratorio N°3 (Mismo del Laboratorio 1 y 2)

![image](https://user-images.githubusercontent.com/91446330/194765651-54627927-e275-40c0-9a8f-879d4f50b83a.png)


## Requisitos y herramientas de desarrollo
Para ejecutar correctamente todo el proyecto, además de los archivos del repositorio se requieren las siguientes tecnologías:

* [MongoDB Community Edition](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows/) versión 6.0.
* [MongoDB Compass](https://www.mongodb.com/try/download/compass) versión 1.34.2.
* [IntelliJ IDEA Ultimate](https://www.jetbrains.com/es-es/idea/download/#section=windows) versión 2022.2.1, aunque debería funcionar con cualquier versión.
* JDK Versión 17 (Se debe configurar tanto en el proyecto como en Gradle)
* [Nuxt + VUE](https://nuxtjs.org) versión 3.
* [Postman](https://www.postman.com/downloads/) versión 9.4

También, para el desarrollo del proyecto se utilizó:
* [Visual Studio Code](https://code.visualstudio.com) versión 1.74.1
* [GitKraken](https://www.gitkraken.com) versión 9.0.0

## Instrucciones de instalación
1. Clonar el repositorio: Esto proporcionará las tres carpetas principales para el proyecto de Laboratorio. Para clonarlo, se debe usar el siguiente comando en el directorio deseado:
```sh
git clone https://github.com/nic0q/TBD-MongoDB.git
```
2. Ir al siguiente [link](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows/) e instalar MongoDB Community Edition y seguir las instrucciones del instalador.
3. Ir al siguiente [link](https://www.mongodb.com/try/download/compass) e instalar MongoDB Compass y seguir las instrucciones del instalador.
4. Instalar IntelliJ IDEA Ultimate: Ingresar al sitio web oficial de IntelliJ IDEA y seleccionar el instalador dependiendo del Sistema Operativo en uso:
* Para Windows, utilizar el siguiente [link](https://www.jetbrains.com/idea/download/#section=windows).
* Para Linux, utilizar el siguiente [link](https://www.jetbrains.com/es-es/idea/download/#section=linux).
* Para MacOs, utilizar el siguiente [link](https://www.jetbrains.com/es-es/idea/download/#section=mac).
5. Al abrir IntelliJ IDEA Ultimate, abrir un nuevo proyecto y seleccionar la carpeta **Backend**. Debemos esperar a que el proyecto se configure y se instalen los plugins necesarios.
6. Dentro de la carpeta src -> main crear una carpeta llamada "resources". Luego, crear un archivo sin extensión llamado **application.properties**. Dentro del archivo, se debe incluir lo siguiente:
```sh
spring.data.mongodb.host = localhost
spring.data.mongodb.port = 27017
spring.data.mongodb.database = tbd3
```
7. Configurar el JDK: Al abrir una clase IntelliJ nos solicitará configurar un JDK. Debemos asegurarnos de seleccionar JDK versión 17. Si no tenemos JDK 17, IntelliJ nos proporciona una opción para instalarlo automáticamente. 
8. Ir al siguiente [link](https://nodejs.org/en/) e instalar la última versión de Node.js, siguiendo las instrucciones de instalación.
8. Abrir una consola / terminal dentro de la carpeta **Frontend** y aplicar el siguiente comando, el cual instalará todas las dependencias necesarias para el proyecto:
```sh
npm install
```
* Si por algún motivo lo anterior falla, se puede utilizar:
```sh
npm install --force
```
9. Ir al siguiente [link](https://www.postman.com/downloads/) e instalar la última versión de Postman.

Con esto ya estamos listos con todo lo que es la instalación del proyecto y se puede continuar a las instrucciones de uso.

## Instrucciones de uso
1. En MongoDB Compass crear una nueva Base de Datos llamada "tbd3"
2. Luego, crear una nueva colecciones de nombres: emergencies, tasks, regions, voluntaries. En cada uno, seleccionar la opción "Add data" y luego la opción JSON. Cargar el archivo JSON correspondiente en cada collección.
3. Utilizando IntelliJ IDEA Ultimate, asegurarse de que se detecte correctamente Spring Boot y Gradle. Ejecutar la aplicación haciendo click en la opción "Run" dentro de IntelliJ IDEA.
4. Dentro de la carpeta Frontend, abrir una consola / terminal. Ejecutar el siguiente comando:
```sh
npm run dev
```

Con esto ya tenemos levantado FrontEnd y Backend

5. Para probar el CRUD de una tabla, debemos colocar la ruta en Postman (Por ejemplo, **http://127.0.0.1:8080/emergencies**). Luego seleccionar uno de los métodos a aplicar, dependiendo de si quieres crear, mostrar, editar o eliminar un elemento.
6. Para ir a la vista del mapa de habilidades disponibles dentro de una región, ir a http://localhost:3000/habilidades-region

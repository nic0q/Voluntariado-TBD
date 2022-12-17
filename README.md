# Laboratorio N°2 - Laboratorio de Taller de Base de Datos
Este repositorio contiene todos los archivos relacionados con el Laboratorio N°2 del
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
El Laboratorio consiste en expandir lo realizado en el Laboratorio 1, ahora realizando consulta realizadas con Base de Datos Geoespaciales, utilizando la herramienta PostGis. Para ello, se realiza un Backend utilizando Java y el servicio REST API con Sql2 y un Frontend donde las vistas fueron creadas utilizando VUE.js + Nuxt para poder realizar ciertos requisitos del Laboratorio N°2 del curso. <br>

El repositorio incluye tres carpetas principales:  <br>
* [Carpeta Backend](https://github.com/nic0q/TBD-Lab2-Grupo-5/tree/master/Backend): Contiene todos los archivos del Backend del proyecto y las clases de las entidades del modelo. 
Se distribuyen las clases en los paquetes Services, Repositories y Models.
* [Carpeta Database](https://github.com/nic0q/TBD-Lab2-Grupo-5/tree/master/DataBase): Contiene los archivos dbCreate.sql, el cual contiene los scripts necesarios para crear
la Base de Datos y las tablas del modelo, el archivo loadData.sql, el cual contiene datos dummy para poblar las tablas y el archivo regiones.sql, el cual es el script que permite crear la tabla de las regiones de Chile como poli-polígono.
* [Carpeta Frontend](https://github.com/nic0q/TBD-Lab2-Grupo-5/tree/master/Frontend): Contiene todos los archivos del Frontend y las vistas realizas utilizando Vue + Nuxt.JS. 
Principalmente, está la vista para poder ver las emergencias por cada región y la vista para ver una lista de emergencias con menos voluntarios.

## Modelo a seguir para el Laboratorio N°2 (Mismo del Laboratorio 1)

![image](https://user-images.githubusercontent.com/91446330/194765651-54627927-e275-40c0-9a8f-879d4f50b83a.png)


## Requisitos y herramientas de desarrollo
Para ejecutar correctamente todo el proyecto, además de los archivos del repositorio se requieren las siguientes tecnologías:

* [PostgreSQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) versión 12 o superior. 
* [PgAdmin](https://www.pgadmin.org) versión 4.
* [IntelliJ IDEA Ultimate](https://www.jetbrains.com/es-es/idea/download/#section=windows) versión 2022.2.1, aunque debería funcionar con cualquier versión.
* JDK Versión 17 (Se debe configurar tanto en el proyecto como en Gradle)
* [Nuxt + VUE](https://nuxtjs.org) versión 3.
* [Postman](https://www.postman.com/downloads/) versión 9.4
* [PostGis](https://postgis.net) versión 3.2 o superior

También, para el desarrollo del proyecto se utilizó:
* [Visual Studio Code](https://code.visualstudio.com) versión 1.73
* [GitKraken](https://www.gitkraken.com) versión 8.10.3

## Instrucciones de instalación
1. Clonar el repositorio: Esto proporcionará las tres carpetas principales para el proyecto de Laboratorio. Para clonarlo, se debe usar el siguiente comando en el directorio deseado:
```sh
git clone https://github.com/nic0q/TBD-Lab2-Grupo-5.git
```
2. Instalar PostgreSQL 12 y PGAdmin 4: Para ello, se puede instalar un pack en conjunto desde el siguiente [link](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads). Se debe seleccionar la versión deseada para el Sistema Operativo deseado y seguir las instrucciones de instalación. Durante la instalación es necesario configurar un **username** y un **password** para utilizar con PostgreSQL. Estos serán luego necesarios para la creación de la Base de Datos junto con sus tablas.
4. Instalar IntelliJ IDEA Ultimate: Ingresar al sitio web oficial de IntelliJ IDEA y seleccionar el instalador dependiendo del Sistema Operativo en uso:
* Para Windows, utilizar el siguiente [link](https://www.jetbrains.com/idea/download/#section=windows).
* Para Linux, utilizar el siguiente [link](https://www.jetbrains.com/es-es/idea/download/#section=linux).
* Para MacOs, utilizar el siguiente [link](https://www.jetbrains.com/es-es/idea/download/#section=mac).
5. Al abrir IntelliJ IDEA Ultimate, abrir un nuevo proyecto y seleccionar la carpeta **Backend**. Debemos esperar a que el proyecto se configure y se instalen los plugins necesarios.
6. Dentro de la carpeta src -> main crear una carpeta llamada "resources". Luego, crear un archivo sin extensión llamado **application.properties**. Dentro del archivo, se debe incluir lo siguiente:
```sh
database.url=jdbc:postgresql://127.0.0.1:5432/VoluntariadoDB
database.user= [USER]
spring.devtools.restart.aditional-paths= src/main/java
database.password= [PASSWORD]
server.port=8000
```
Luego cambiar database.user y database.password al username y password configurados en el paso 2.

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
10. Abrir la aplicación "Application Stack Builder" (incluida con la instalación de PostgreSQL y PgAdmin). Seleccionas PostgreSQL, luego continuar. Ir a la opción "Spatial Extensions" y seleccionar **PostGIS 3.2 Bundle for PostgreSQL 14**. Continuar hasta que se completa la instalación.

Con esto ya estamos listos con todo lo que es la instalación del proyecto y se puede continuar a las instrucciones de uso.

## Instrucciones de uso
1. En PgAdmin, seleccionar la opción "Query tool" y copiar la primera parte del script dbCreate.sql para solo crear la Base de Datos. 
2. Abrir la opción Query tool nuevamente, pero dentro de VoluntariadoDB (La Base de Datos que se crea en el paso 1) y copiar el resto de dbCreate
3. Copiar todo el contenido de loadData.sql y ejecutarlo dentro de Query tool.

**Nota:** Si bien la siguiente instrucción se puede realizar en PgAdmin, debido al tiempo que toma cargar el archivo y la extensión de este, es muy recomendable hacer el siguiente paso tal cual como se indica.

4. Abrir una consola (CMD) dentro de la carpeta Database. Luego, escribir el siguiente comando:
```sh
psql -U [USUARIO] -d [BASEDEDATOS] -a -f regiones.sql
```
Donde [USUARIO] corresponde al nombre de usuario de PostgreSQL y [BASEDEDATOS] el nombre de la Base de Datos (VoluntariadoDB si se esta siguiendo los pasos al pie de la letra). Al ejecutar el comando anterior, se solicitará la contraseña para PostgreSQL. Luego de eso, se debe esperar a que se ejecute todo el script.

5. Utilizando IntelliJ IDEA Ultimate, asegurarse de que se detecte correctamente Spring Boot y Gradle. Ejecutar la aplicación haciendo click en la opción "Run" dentro de IntelliJ IDEA.
7. Dentro de la carpeta Frontend, abrir una consola / terminal. Ejecutar el siguiente comando:
```sh
npm run dev
```
8. Con esto ya tenemos levantado FrontEnd y Backend
9. Para probar el CRUD de una tabla, debemos colocar la ruta en Postman (Por ejemplo, **http://127.0.0.1:8000/institutions**). Luego seleccionar uno de los métodos a aplicar, dependiendo de si quieres crear, mostrar, editar o eliminar un elemento.
10. Para ir a la vista de emergencias con menos voluntarios ir a **http://localhost:3000/tareas-menos-voluntarios**
11. Para ir a la vista de emergencias por región ir a **http://localhost:3000/emergencias-region**

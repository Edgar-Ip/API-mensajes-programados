# Generador de Mensajes Automáticos para Discord


Este proyecto es una API REST desarrollada en Java con Spring Boot que permite programar mensajes automáticos y enviarlos a un canal de Discord en la fecha y hora establecida. Además, cuenta con un panel web para visualizar los mensajes programados.


## Tecnologías Utilizadas

  -Java 17
  
  -Spring Boot (Spring Web, Spring Data JPA, Spring Scheduler, Spring Security)
  
  -Base de Datos MySQL
  
  -Swagger/OpenAPI para documentación de la API
  
  -JDA (Java Discord API) para la integración con Discord
  
  -Thymeleaf y Bootstrap para el panel web

  

## Características Principales


✅ Almacena los mensajes programados en una base de datos MySQL.

✅ Programa la ejecución automática de los mensajes en la fecha indicada.

✅ Integración con un bot de Discord para el envío de mensajes automáticos.

✅ Documentación de la API con Swagger/OpenAPI.

✅ Panel web para visualizar los mensajes programados.





## Endpoints de la API


Método / Endpoint	/ Descripción


  -POST	/api/messages ->	Guarda un mensaje programado (texto + fecha).
  
  
  -GET	/api/messages ->	Obtiene la lista de mensajes programados.
  
  
  -DELETE	/api/messages/{id} -> Elimina un mensaje programado por ID.

  




## Requisitos Previos


-Tener instalado Java 17 o superior.


-Tener instalado MySQL y crear una base de datos llamada mensajes_db.


-Crear un bot en Discord desde el Discord Developer Portal y obtener su Bot Token.



## Configuración del Proyecto


1-Clonar este repositorio.


2-Configurar el archivo application.properties en src/main/resources/:


  spring.datasource.url=jdbc:mysql://localhost:3306/mensajes_db
  
  spring.datasource.username=tu_usuario
  
  spring.datasource.password=tu_contraseña
  

  discord.bot.token=TU_BOT_TOKEN

  

3-Instalar dependencias y compilar el proyecto




## Ejecución del Proyecto

Para iniciar el backend, ejecutar:


  mvn spring-boot:run
  

El backend correrá en: http://localhost:8080


Para visualizar la documentación con Swagger/OpenAPI:

http://localhost:8080/swagger-ui/index.html



## Panel Web


Para acceder al panel web y visualizar los mensajes programados, ir a:
http://localhost:8080/messages




### Recursos Adicionales



  -Integración con bot de Discord: Discord.dev
  
  
  -Documentación sobre integraciones de API de Discord: Pipedream
  





##### Desarrollado por Edgar Gutiérrez Mejía.

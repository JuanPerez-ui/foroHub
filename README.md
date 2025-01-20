Foro Hub - Challenge Back End

Descripción del proyecto

Foro Hub es un proyecto diseñado para replicar el funcionamiento interno de un foro. Este tipo de plataformas permite a los usuarios realizar preguntas y compartir conocimientos sobre temas específicos, promoviendo el aprendizaje y la colaboración entre participantes. Nuestro desafío consiste en desarrollar una API REST utilizando Spring Framework que gestione tópicos del foro y permita realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar).

Características principales

La API implementa las siguientes funcionalidades:

Crear un nuevo tópico: Permite registrar un nuevo tema de discusión en el foro.

Mostrar todos los tópicos creados: Recupera y muestra la lista completa de temas registrados.

Mostrar un tópico específico: Devuelve la información detallada de un tema particular.

Actualizar un tópico: Modifica los datos de un tópico existente.

Eliminar un tópico: Elimina un tema del foro.

Tecnologías utilizadas

Java: Lenguaje principal del desarrollo.

Spring Framework: Framework utilizado para la creación de la API REST.

Spring Data JPA: Gestión de la persistencia de datos.

PostgreSQL: Base de datos relacional utilizada para almacenar la información.

Spring Security: Implementación de autenticación y autorización para proteger los endpoints.

Funcionalidades adicionales

Modelo REST: Las rutas han sido diseñadas siguiendo las mejores prácticas de REST.

Validaciones de negocio: Se han incorporado validaciones para asegurar la integridad de los datos según las reglas de negocio.

Persistencia de datos: La información se almacena de forma persistente en una base de datos PostgreSQL.

Autenticación y autorización: Los endpoints están protegidos para garantizar que solo usuarios autorizados puedan acceder o modificar información.

Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalados:

Java 17 o superior.

Maven.

PostgreSQL.

Un entorno de desarrollo como IntelliJ IDEA o Eclipse.

Configuración e instalación

Clona este repositorio:

git clone https://github.com/tu-usuario/foro-hub.git

Configura la base de datos en el archivo application.properties o application.yml:

spring.datasource.url=jdbc:postgresql://${DB_HOST}/foroHub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

Ejecuta el proyecto:

mvn spring-boot:run

Endpoints disponibles

POST /topicos: Crear un nuevo tópico.

GET /topicos: Listar todos los tópicos.

GET /topicos/{id}: Obtener detalles de un tópico específico.

PUT /topicos/{id}: Actualizar un tópico existente.

DELETE /topicos/{id}: Eliminar un tópico.


¡Gracias por explorar Foro Hub! Si tienes preguntas o sugerencias, no dudes en abrir un issue.

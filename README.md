Implementado métodos api rest para Laptop:
- finAll -> devuelve todos los laptops
- finOneById -> devuelve una respuesta 200 con el laptop
- create -> devuelve una respuesta 200 con el laptop creado
- update -> devuelve una respuesta 200 con el laptop actualizado
- delete -> devuelve una respuesta de No contenido ya que el laptop ha sido borrado
- deleteAll -> devuelve una respues de No Contenido ya que todos los laptops han sido borrados

Swagger se ejecuta en:
http://localhost:8081/swagger-ui/index.html
en el application.properties:
he tendio que añadir esta opción:
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
para que swagger no diera problemas con spring boot al ejecutarse.


Se han realizado los test para el controller Hello y Laptop:



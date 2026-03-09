Este es el challenge de ALURA LATAM en el programa ONE de Oracle 
Esta es una API REST con Java 25, Spring Boot 3.5.11
Maven como gestor de depencias
Lombok 
Spring Data JPA conectado a MySQL
Spring Security + JWT Bearer
Flyway para crear tablas y datos iniciales
Se tiene las funcionalidad 
Primera funcionalidad permite ver un listado de los topicos con un metodo GET y endponin /topicos aqui guarda en la base de datos esos topicos 
Se puede agregar los campos id,titulo mensaje y fecha de creación mostrando una lista.
La segunda funcionalidad es en otro endpoint /auth se debe de ingresar un mail y contraseña para poder obtener un token tipo barrer el cual se usara en otras funcionalidades.
Para tercer funcionalidad se debe de poder registrar un tópico donde es un post /topicos y aqui se puede guardar un nuevo tópico pero se debe de autorizar con AUTH sino se autoriza marca el 403 
el cual se obtiene de la funcionalidad anterior si es correcto se debe de pasar 201 y insertar el registro en la BD, 
La cuarta funcionalidad es poder actualizar un tópico con PUT /topicos donde se puede actualizar ese tópico igual necesita autenticarse con la funcionalidad 2. 
La ultima funcionalidad es poder eliminar un tópico donde en la url se pasa topico/{id} siendo un parametro id que es el id a borrar y lo puede borrar de la bd para poder hacer este paso se 
debe de autenticar si fue correcta la autenticacion lanza un 200 y sino se autentica o es incorrecta 403. 
Se puede probar con insomnia o postman la API o con comandos
1.Listar Topicos
curl --request GET http://localhost:8080/topico

2.Autenticarse 
 curl --request POST http://localhost:8080/auth \
--header "Content-Type: application/json" \
--data '{
"email":"admin@correo.com",
"password":"123456"
}'

3.Crear topico
curl --request POST http://localhost:8080/topicos \
--header "Content-Type: application/json" \
--header "Authorization: Bearer TU_TOKEN" \
--data '{
"titulo":"Primer tópico",
"mensaje":"Mensaje del tópico"
}'

Actualizar topico
curl --request PUT http://localhost:8080/topicos \
--header "Content-Type: application/json" \
--header "Authorization: Bearer TU_TOKEN" \
--data '{
"id":1,
"titulo":"Título actualizado",
"mensaje":"Mensaje actualizado"
}'

BorrarTopico
curl --request DELETE http://localhost:8080/topicos/1 \
--header "Authorization: Bearer TU_TOKEN"



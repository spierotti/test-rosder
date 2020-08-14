// INSERTAR REGISTRO PERSONA
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"rutPersona\":1}" http://localhost:8080/api/personas/insertar
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"rutPersona\":2,\"nombre\":\"Santiago\",\"apellido\":\"Pierotti\",\"cc\":12345}" http://localhost:8080/api/fisicas/insertar
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"rutPersona\":3,\"razonSocial\":\"prueba empresa\",\"anioFundacion\":2012}" http://localhost:8080/api/juridicas/insertar

// VER REGISTRO PERSONA POR RUT
curl -X GET "http://localhost:8080/api/personas/ver?id=1"

// ACTUALIZAR PERSONA
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"rutPersona\":123455}" http://localhost:8080/api/personas/actualizar

// OBTIENE LISTADO DE TODAS LAS PERSONAS
curl -X GET "http://localhost:8080/api/personas/findAll"

// BORRAR PERSONA
curl -X DELETE "http://localhost:8080/api/personas/1"
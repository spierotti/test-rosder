//////// EJERCICIO Nº1 ////////

// INSERTAR REGISTRO PERSONA
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"rutPersona\":3}" http://localhost:8080/api/personas/insertar

// INSERTAR REGISTRO PERSONA FISICA
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"rutPersona\":4,\"nombre\":\"Santiago\",\"apellido\":\"Pierotti\",\"cc\":12345}" http://localhost:8080/api/fisicas/insertar

// INSERTAR REGISTRO PERSONA JURIDICA
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"rutPersona\":5,\"razonSocial\":\"prueba empresa\",\"anioFundacion\":2012}" http://localhost:8080/api/juridicas/insertar

// VER REGISTRO PERSONA FISICA POR RUT
curl -X GET "http://localhost:8080/api/fisicas/ver?id=1"

// VER REGISTRO PERSONA JURIDICA POR RUT
curl -X GET "http://localhost:8080/api/juridicas/ver?id=2"

// ACTUALIZAR PERSONA
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"rutPersona\":123455}" http://localhost:8080/api/personas/actualizar

// OBTIENE LISTADO PERSONAS
curl -X GET "http://localhost:8080/api/personas/findAll"

// BORRAR PERSONA
curl -X DELETE "http://localhost:8080/api/personas/1"

//////// EJERCICIO Nº2 ////////

// DAR DE ALTA UNA CUENTA
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"nroCuenta\":1,\"saldo\":0.00,\"moneda\":1,\"titular\":1}" http://localhost:8080/api/cuentas/insertar

// ELIMINAR CUENTA
curl -X DELETE "http://localhost:8080/api/cuentas/1"

// LISTADO DE CUENTAS
curl -X GET "http://localhost:8080/api/cuentas/findAll"

// DAR DE ALTA MOVIMIENTO
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"id\":1,\"descripcion\":\"credito\",\"fecha_movimiento\":\"12\\12\\2020\",\"tipo_movimiento\":\"CREDITO\",\"importe\":100.00,\"nroCuenta\":2}" http://localhost:8080/api/movimientos/insertar
curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{\"id\":2,\"descripcion\":\"debito\",\"fecha_movimiento\":\"12\\12\\2020\",\"tipo_movimiento\":\"DEBITO\",\"importe\":100.00,\"nroCuenta\":2}" http://localhost:8080/api/movimientos/insertar

// LISTAR MOVIMIENTO POR CUENTA
curl -X GET "http://localhost:8080/api/movimientos/findAll"

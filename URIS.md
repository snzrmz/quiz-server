# URIS

**/jugadores/{id}**
GET - JugadorDao.getOne
PUT - JugadorDao.update
POST - JugadorDao.create
**/jugadores/{id}/mazos**
GET - MazoDao.getAll
//DELETE - ¿Eliminar todos los mazos??
**/jugadores/{id}/mazos/{nombre}**
GET MazoDao.getOne
POST String MazoDao.create --> return mazo.getNombre()
PUT MazoDao.update
DELETE MazoDao.delete
**/jugadores/{id}/mazos/{nombre}/tarjetas** -> http://localhost:8080/quiz-server/api/jugadores/1/mazos/Geografía/tarjeta
GET TarjetaDao.getAllOfMazo
**/jugadores/{id}/mazos/{nombre}/tarjetas/{idTarjeta}**
GET TarjetaDao.getOne
POST TarjetaDao.create
PUT TarjetaDao.update
DELETE TarjetaDao.remove
**/jugadores/{id}/mazos/{nombre}/repasos/**
GET - RepasoDao.getAllFrom
POST RepasoDao.create
**/jugadores/{id}/mazos/{nombre}/repasos/{*numeroRepaso*}/**
GET RepasoDao.getOne

**al tener que devolver tarjetas he supuesto que lo mejor sería dividir dentro de un repasos
**las tarjetas que se han acertado y las que se han fallado.

**/jugadores/{id}/mazos/{nombre}/repasos/{*numeroRepaso*}/tarjetas/acertadas**
GET - TarjetaDao.getTarjetasAcertadas
**/jugadores/{id}/mazos/{nombre}/repasos/{*numeroRepaso*}/tarjetas/falladas**
GET - TarjetaDao.getTarjetasFalladas
/jugadores/{id}/mazos/{nombre}/tarjetas/{idTarjeta}/respuestas/
GET (obtener la/s respuesta/s de la tarjeta)

Falta:
1. Crear tarjetas [respuesta Unica y Multiple]. Ahora mismo solo se puede crear una entidad Tarjeta.
2. Obtener las respuestas de una tarjeta
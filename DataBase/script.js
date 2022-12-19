// Query 1: Hacer una consulta  en un servicio REST para mostrar las tareas de una emergencia usando aggregate, lookup y unwind
db.tasks.aggregate([
  {
    $match: {
      "id_emergency": 3 // id_emergency = 3
    }
  },
  {
    $lookup: {
      from: "tasks",
      localField: "id_task",
      foreignField: "id_emergency",
      as: "tasks"
    }
  }
])

// Mostrar en un mapa el resumen de habilidades disponibles dentro de una región usando operaciones de datos geoespaciales
db = connect( 'mongodb://localhost/tbd3'); // conección a la base de datos tbd3
db = db.getSiblingDB('tbd3'); // obtiene la base de datos tbd3
let region = db.regions.findOne( { name: "Región Metropolitana de Santiago"}); // obtiene la región metropolitana de santiago como ejemplo
// imprime los voluntarios que se encuentran dentro de la región metropolitana de santiago
printjson(db.voluntaries.find({ location: { $geoWithin: {$geometry: region.geometry} } }, {name: 1, abilities: 1, _id: 0}))
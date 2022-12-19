db = db.getSiblingDB('tbd3'); // se conecta o crea la base de datos tbd3

// Query 1: Hacer una consulta  en un servicio REST para mostrar las tareas de una emergencia usando aggregate, lookup y unwind
printjson(
db.tasks.aggregate([
  { $match: { id_emergency: 3 } },
  {
    $lookup: {
      from: "tasks",
      localField: "id_task",
      foreignField: "id_emergency",
      as: "tasks"
    }
  },
  { $unwind : "$tasks" },
  { $project: {
      _id: 0,
      id_emergency: 1,
      tasks: 1
    }
  }
]))

// Query 2: Obtener todas las skills de los voluntarios que se encuentran en determinada region
let region = db.regions.findOne( { name: "Región Metropolitana de Santiago"}); // obtiene la región metropolitana de santiago como ejemplo
printjson(db.voluntaries.find({location: {$geoWithin: {$geometry: region.geometry} } },{name: 1,skills: 1, _id: 0}))
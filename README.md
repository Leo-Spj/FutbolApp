## Pasos para iniciar el proyecto

1. Asegurese que el servidor de MySQL este corriendo en el puerto 3306
2. No cree ninguna base de datos, el proyecto se encargara de crearla
3. Ejecute el proyecto con el comando `mvn spring-boot:run`
4. Asegurese se esté ejecutando en el puerto 8080
5. Instala las dependencias de la carpeta `client` con el comando `npm install` (debe estár ubicado en la carpeta `client`por terminal)
6. Ejecute el cliente con el comando `npm run dev`


## Algunas peticiones por Postman

Cada tabla contiene su CRUD completo, tanto para la tabla de futbolistas como para la de posiciones.

#### Endpoints de la tabla de posiciones
1. /posiciones
2. /posiciones/{id}
3. /posiciones/{id} (PUT)
4. /posiciones/{id} (DELETE)

#### Endpoints de la tabla de futbolistas
1. /futbolistas
2. /futbolistas/{id}
3. /futbolistas/{id} (PUT)
4. /futbolistas/{id} (DELETE)


### Sí usará Postman, aquí tiene algunos ejemplos de los JSON que se pueden enviar

Posiciones:

```json
{
    "posicion": "Delantero"
}
```

Futbolistas:

```json
{
    "nombre": "Leo",
    "apellido": "Messi",
    "fechaNacimiento": "1987-06-24",
    "caracteristicas": "1.7m 72Kg",
    "posicion": {
        "id": 1
    }
}
```

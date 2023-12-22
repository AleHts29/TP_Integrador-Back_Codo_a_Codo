# Descripción de Clases y Controladores

En este proyecto, se han implementado tres controladores principales para gestionar entidades específicas: Usuarios, Oradores y Gestión de Tickets. A continuación, se presenta una breve descripción de cada clase y su funcionalidad.

## UserController

**Descripción:**
Este controlador gestiona las operaciones relacionadas con la entidad `User`. Proporciona endpoints para listar todos los usuarios, guardar un nuevo usuario, obtener un usuario por su ID y eliminar un usuario por su ID.

**Endpoints:**
- `GET /users/listall`: Obtiene la lista de todos los usuarios.
- `POST /users/save`: Guarda un nuevo usuario.
- `GET /users/id/{id}`: Obtiene un usuario por su ID.
- `DELETE /users/id/{id}`: Elimina un usuario por su ID.

## SpeakerController

**Descripción:**
Este controlador se encarga de las operaciones relacionadas con la entidad `Speaker`. Ofrece endpoints para listar todos los oradores, guardar un nuevo orador, obtener un orador por su ID y eliminar un orador por su ID.

**Endpoints:**
- `GET /speaker/listall`: Obtiene la lista de todos los oradores.
- `POST /speaker/save`: Guarda un nuevo orador.
- `GET /speaker/id/{id}`: Obtiene un orador por su ID.
- `DELETE /speaker/id/{id}`: Elimina un orador por su ID.

## TicketManagementController

**Descripción:**
Este controlador gestiona las operaciones relacionadas con la entidad `TicketsManagement`. Proporciona endpoints para listar todos los registros de gestión de tickets, guardar un nuevo registro, obtener un registro por su ID y eliminar un registro por su ID.

**Endpoints:**
- `GET /tickets/listall`: Obtiene la lista de todos los registros de gestión de tickets.
- `POST /tickets/save`: Guarda un nuevo registro de gestión de tickets.
- `GET /tickets/id/{id}`: Obtiene un registro de gestión de tickets por su ID.
- `DELETE /tickets/id/{id}`: Elimina un registro de gestión de tickets por su ID.

Estos controladores están diseñados para interactuar con los servicios respectivos (`UserService`, `SpeakerService`, `TicketsManagementService`), que manejan la lógica de negocio y la interacción con las capas de persistencia.
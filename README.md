# Proyecto de Gestión de Franquicias

Este proyecto es una API que permite gestionar franquicias y sus sucursales utilizando **MongoDB** como base de datos y **Spring Boot** como framework backend. Se incluyen operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para manejar franquicias y sucursales asociadas.

## Características

- Gestión de franquicias.
- Operaciones CRUD para sucursales asociadas a una franquicia.
- Persistencia de datos con MongoDB.
- Arquitectura RESTful para las operaciones.

## Requisitos previos

1. **Java**: JDK 11 o superior.
2. **Maven**: Gestor de dependencias.
3. **MongoDB**: Base de datos no relacional.
4. **REST Client o Postman** (opcional): Para probar los endpoints.

## Configuración

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/JesusOsorioJ/evalart.git
   cd evalart

2. Configurar la conexión a MongoDB en el archivo application.properties
    ```bash 
    spring.data.mongodb.uri=mongodb://localhost:27017/franquicias

3. Compilar y ejecutar el proyecto:
    ```bash 
    mvn clean install
    mvn spring-boot:run

## Pruebas de Endpoints

Para probar los endpoints, se ha proporcionado un folder de `REST Client` en el directorio raíz del proyecto.

### Cómo usar el archivo de `REST Client`:

1. **Instalar la extensión REST Client en Visual Studio Code:**

    Si aún no la tienes instalada, puedes encontrarla [aquí](https://marketplace.visualstudio.com/items?itemName=humao.rest-client).

2. **Abrir el archivo `.rest`:**

3. **Hacer requests:**

    Haz clic en el botón `Send Request` al lado de cada bloque de solicitud para probar los diferentes endpoints de la API.

## Próximas mejoras
- Validación más robusta de datos.
- Autenticación y autorización con JWT.
- Documentación Swagger para la API.
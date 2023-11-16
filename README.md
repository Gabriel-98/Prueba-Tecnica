# <center> Inventario de libreria </center>

## 1. Tecnologías usadas:

- API (Completa)
  - Lenguaje: Java
  - Framework: Spring Boot
  - Base de datos: NO (Sobre Memoria)

- Interfaz web (Permite listar los libros)
  - Lenguaje: Java
  - Framework: Spring Boot
  - Gestor de plantillas: Thymeleaf

- Prueba unitarias (Casi nada)

## 2. Instalación

## 3. Documentación de la API

**Puerto de la API:** 9001

**Puerto de la interfaz web:** 9002

### 3.0 Estructura del objeto Book.

| Nombre del campo | Formato      | Restricciones                                    | Descripción |
| ---------------- | ------------ | ------------------------------------------------ | ----------- |
| id               | Número       |                                                  | Identificador          |
| title            | Alfanumerico | * Longitud Mínima: 1 <br> * Longitud Máxima: 100 | El nombre del libro                  |
| author           | Alfanumerico | * Longitud Mínima: 1 <br> * Longitud Máxima: 100 | Nombres y apellidos del autor              |
| publicationYear  | Número       | * >= 0 <br> * <= año actual                      | Año de publicación del libro                  |
| genre            | Alfanumerico | * Longitud Mínima: 1 <br> * Longitud Máxima: 100 | Categoría o género del libro                  |

### 3.1 Obtener información sobre un libro

**Método de la petición:** GET

**URL de la petición:** .../bookstore-api/books/{id}

**Campos de la respuesta:**

| Nombre del campo |
| ---------------- |
| id               |
| title            |
| author           |
| publicationYear  |
| genre            |

**Ejemplo de petición:**

```
GET .../bookstore-api/books/1
```

**Ejemplo de respuesta:**

```json
{
    "id": 1,
    "title": "Crimen y castigo",
    "author": "Fiodor Dostoyevski",
    "publicationYear": 1866,
    "genre": "Novela policial"
}
```

### 3.2 Registrar un libro

**Método de la petición:** POST

**URL de la petición:** .../bookstore-api/books

**Campos de la petición:**

| Nombre del campo | Obligatorio |
| ---------------- | ----------- |
| title            | SI          |
| author           | SI          |
| publicationYear  | SI          |
| genre            | SI          |

**Campos de la respuesta:**

| Nombre del campo |
| ---------------- |
| id               |
| title            |
| author           |
| publicationYear  |
| genre            |

**Ejemplo de petición:**

```
POST .../bookstore-api/books
```

```json
{
    "title": "Crimen y castigo",
    "author": "Fiodor Dostoyevski",
    "publicationYear": 1866,
    "genre": "Novela policial"
}
```

**Ejemplo de respuesta:**

```json
{
    "id": 1,
    "title": "Crimen y castigo",
    "author": "Fiodor Dostoyevski",
    "publicationYear": 1866,
    "genre": "Novela policial"
}
```

### 3.3 Editar información sobre un libro

**Método de la petición:** PUT

**URL de la petición:** .../bookstore-api/books

**Campos de la petición:**

| Nombre del campo | Obligatorio |
| ---------------- | ----------- |
| id               | SI          |
| title            | SI          |
| author           | SI          |
| publicationYear  | SI          |
| genre            | SI          |

**Campos de la respuesta:**

| Nombre del campo |
| ---------------- |
| id               |
| title            |
| author           |
| publicationYear  |
| genre            |

**Ejemplo de petición:**

```
PUT .../bookstore-api/books
```

```json
{
    "id": 1,
    "title": "Crimen y castigo",
    "author": "Fiodor Dostoyevski",
    "publicationYear": 1866,
    "genre": "Ficcion filosofica"
}
```

**Ejemplo de respuesta:**

```json
{
    "id": 1,
    "title": "Crimen y castigo",
    "author": "Fiodor Dostoyevski",
    "publicationYear": 1866,
    "genre": "Ficcion filosofica"
}
```

### 3.4 Eliminar el registro de un libro

**Método de la petición:** DELETE

**URL de la petición:** .../bookstore-api/books/{id}

**Campos de la respuesta:**

| Nombre del campo |
| ---------------- |
| id               |
| title            |
| author           |
| publicationYear  |
| genre            |

**Ejemplo de petición:**

```
DELETE .../bookstore-api/books/1
```

**Ejemplo de respuesta:**

```json
{
    "id": 1,
    "title": "Crimen y castigo",
    "author": "Fiodor Dostoyevski",
    "publicationYear": 1866,
    "genre": "Ficcion filosofica"
}
```

### 3.5 Listar todos los libros

**Método de la petición:** GET

**URL de la petición:** .../bookstore-api/books

**Campos de la respuesta:**

Una lista de objetos Book, cada unos de esos conteniendo los siguientes campos:

| Nombre del campo |
| ---------------- |
| id               |
| title            |
| author           |
| publicationYear  |
| genre            |

**Ejemplo de petición:**

```
GET .../bookstore-api/books
```

**Ejemplo de respuesta:**

```json
[
    {
        "id": 1,
        "title": "Crimen y castigo",
        "author": "Fiodor Dostoyevski",
        "publicationYear": 1866,
        "genre": "Novela policial"
    },
    {
        "id": 2,
        "title": "Don Quijote de la Mancha",
        "author": "Miguel de Cervantes Saavedra",
        "publicationYear": 1605,
        "genre": "Parodia"
    },
    {
        "id": 3,
        "title": "El leon, la bruja y el armario",
        "author": "C. S. Lewis",
        "publicationYear": 2017,
        "genre": "Novela de fantasia y aventura"
    },
    ...
]
```
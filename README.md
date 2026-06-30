#  KAJA - Sistema de Gestión de Productos

##  Descripción

KAJA es una aplicación de consola desarrollada en Java que permite administrar productos mediante operaciones CRUD (Crear, Consultar, Actualizar y Eliminar), utilizando Programación Orientada a Objetos (POO), JDBC y una base de datos MySQL.

Este proyecto fue desarrollado como evidencia para el Servicio Nacional de Aprendizaje (SENA).

---

##  Objetivo

Desarrollar una aplicación Java que implemente un módulo CRUD para la gestión de productos, aplicando el patrón DAO y estableciendo conexión con una base de datos MySQL mediante JDBC.

---

##  Tecnologías utilizadas

- Java 21
- JDBC (Java Database Connectivity)
- MySQL
- XAMPP
- DBeaver
- Visual Studio Code
- Git
- GitHub

---

##  Estructura del proyecto

```
KAJA-JAVA
│
├── src
│   ├── conexion
│   │     Conexion.java
│   │
│   ├── dao
│   │     ProductoDAO.java
│   │
│   ├── modelo
│   │     Producto.java
│   │
│   └── principal
│         Main.java
│
├── lib
│     mysql-connector-j.jar
│
├── kaja.sql
│
└── README.md
```

---

##  Funcionalidades

-  Conexión a MySQL mediante JDBC.
-  Registrar productos.
-  Listar productos.
-  Buscar productos por ID.
-  Actualizar productos.
-  Eliminar productos.
-  Menú interactivo en consola.

---

##  Base de datos

Nombre de la base de datos:

```
kaja
```

Tabla utilizada:

```
productos
```

---

##  Cómo ejecutar el proyecto

1. Iniciar Apache y MySQL desde XAMPP.
2. Importar el archivo `kaja.sql` en MySQL.
3. Abrir el proyecto en Visual Studio Code.
4. Verificar que el archivo `mysql-connector-j.jar` esté agregado al proyecto.
5. Ejecutar la clase `Main.java`.

---

##  Evidencias

Durante la ejecución del proyecto se pueden realizar las siguientes operaciones:

- Registrar un producto.
- Consultar todos los productos.
- Buscar un producto por ID.
- Actualizar un producto.
- Eliminar un producto.

---

##  Autor

**Nicolás Villalba**

---

##  Evidencia SENA

**Programa:** Análisis y Desarrollo de Software (ADSO)

**Evidencia:** GA7-220501096-AA2-EV01

**Proyecto:** KAJA - Sistema de Gestión de Productos

---

##  Licencia

Proyecto desarrollado con fines académicos para el SENA.

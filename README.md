# 🧠 Examen Semana 9 - Desarrollo Orientado a Objetos I

---

## 👤 Autor del proyecto
- **Nombre completo:**  Catalina Zapata
- **Carrera:** Analista Programador
- **Nombre del Proyecto:** LLanquihueTour7
---
## 📘 Descripción general del proyecto
Este proyecto corresponde a la evaluación Sumativa de la semana 8 de la asignatura *Desarrollo Orientado a Objetos I*. Se trata de un sistema orientado a objetos desarrollado en Java, cuyo objetivo es modelar y gestionar la información de la empresa LLanquihue Tour, aplicando los principios de colecciones, métodos, herencia, polimorfismo, clases abtractas y archivo txt.

El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas reales y proponiendo una solución estructurada, modular y reutilizable.

---
## 🧱 Estructura general del proyecto

```plaintext
    📁 src/
├── 📁 data/                         # Paquete encargado de gestionar las entidades del sistema.
│   └── 📄 GestorEntidades           # Administra la colección ArrayList<Registrable>, registra entidades mediante métodos.
│   
├── 📁 model/                        # Paquete que contiene el modelo de datos de la aplicación.
│   │
│   ├── 📄 Registrable               # Interfaz que define el contrato común mostrarResumen().
│   ├── 📄 RecursoAgencia            # Superclase abstracta que contiene atributos y comportamientos comunes.
│   ├── 📄 GuiaTuristico             # Representa un guía turístico perteneciente a LlanquihueTour.
│   ├── 📄 ColaboradorExterno        # Representa un guía externo asociado a otra agencia.
│   └── 📄 Movilizacion              # Representa un conductor o servicio de transporte turístico.
│  
├── 📁 resources/                    # Paquete destinado al almacenamiento de información externa.
│   └── 📄 tours.txt                 # Archivo de texto que almacena las entidades registradas.
│ 
├── 📁 app/                           # Paquete encargado de la interacción con el usuario.
│   └── 📄 Main                      # Punto de entrada del programa, muestra menú y ejecuta acciones.
│ 
├── 📁 util/                         # Paquete con herramientas reutilizables del sistema.
│   └── 📄 Validadores               # Clase encargada de validar ingresos del usuario (texto, números y campos vacíos).
│ 
└── 📄 README.md                     # Documento con la descripción e instrucciones del proyecto.
```

---
## ⚙️ Instrucciones para compilar y ejecutar `Main`
1. Abrir el proyecto en IntelliJ IDEA.
2. Esperar a que IntelliJ cargue las dependencias del proyecto.
3. Navegar hasta la clase `Main` ubicada en el paquete `app`.
4. Ejecutar el método `main()` presionando el botón **Run** (▶).
5. Verificar los resultados en la consola de ejecución.

---

**Repositorio GitHub:** https://github.com/CatalinaZapata/LLanquihueTour7.git |
**Fecha de entrega:** 19/07/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Examen Semana 9
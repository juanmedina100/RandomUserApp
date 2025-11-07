# 📱 RandomUser App

![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin)
![License](https://img.shields.io/badge/License-MIT-green.svg)
![API](https://img.shields.io/badge/API-RandomUser.me-orange)
![Status](https://img.shields.io/badge/Build-Passing-brightgreen)
![Platform](https://img.shields.io/badge/Platform-Android-lightgrey)

---

**RandomUser Explorer** es una aplicación móvil moderna desarrollada para mostrar información de usuarios generada dinámicamente desde la API pública [randomuser.me](https://randomuser.me/).  
La app presenta un diseño minimalista y atractivo, centrado en la experiencia de usuario (UI/UX) con una interfaz limpia, intuitiva y adaptable a diferentes dispositivos.

---

## 🚀 Características principales

- 🔄 **Obtención dinámica de usuarios** desde la API de [randomuser.me](https://randomuser.me/).
- 🧑‍💼 **Visualización completa del perfil**: nombre, edad, dirección, contacto, nacionalidad, foto y más.
- 🎨 **Diseño moderno y adaptable** con modo claro/oscuro.
- 💫 **Animaciones suaves y navegación fluida**.
- 📤 **Opción para compartir perfiles**.

---

## 🧠 Estructura de la aplicación

### 🏠 Pantalla principal
Muestra una lista de usuarios aleatorios con:
- Foto de perfil
- Nombre completo
- País de origen

Incluye un botón flotante para agregar nuevos usuarios.

### 👤 Pantalla de detalles
Muestra la información completa del usuario:
- 📸 Imagen de perfil (grande)
- 👤 Nombre completo y género
- 🎂 Edad y fecha de nacimiento
- 📍 Dirección completa (calle, ciudad, estado, país)
- 🕒 Zona horaria
- 📧 Email
- ☎️ Teléfono
- 🌐 Nacionalidad

---

## 🧩 Ejemplo de datos de la API

```json
{
  "gender": "male",
  "name": {"title": "Mr", "first": "Thorvald", "last": "Heggelund"},
  "location": {
    "street": {"number": 8887, "name": "Munkerudstubben"},
    "city": "Hasvik",
    "state": "Vest-Agder",
    "country": "Norway",
    "postcode": "7405"
  },
  "email": "thorvald.heggelund@example.com",
  "login": {"username": "redgoose533"},
  "dob": {"date": "1950-11-18T05:07:00.847Z", "age": 74},
  "phone": "00000000",
  "picture": {"large": "https://randomuser.me/api/portraits/men/33.jpg"},
  "nat": "NO"
}
```

## ⚙️ Tecnologías utilizadas

- Kotlin / Jetpack Compose
- Ktor Client (para las peticiones HTTP)
- Material Design 3
- RandomUser API
- Coroutines / Flow
- Koin / Voyager / Navigation
- MVVM Architecture
- Room (persistencia de datos)
- Coil (carga de imágenes)

## 📦 Instalación y ejecución

1 - Clona el repositorio:
```bash
  git clone https://github.com/juanmedina100/RandomUserApp.git

```
2 - Abre el proyecto en Android Studio o IntelliJ IDEA.
3 - Sincroniza las dependencias con Gradle.
4 - Ejecuta el proyecto en un emulador o dispositivo físico.

## 🧭 Estructura del proyecto
```bash
RandomUserExplorer/
│
├── app/
│   ├── data/            # Lógica de red y modelos de datos
│   ├── ui/              # Pantallas y componentes de interfaz
│   ├── viewmodel/       # Lógica de presentación (MVVM)
│   └── utils/           # Funciones auxiliares y constantes
│
├── assets/              # Iconos y recursos gráficos
├── README.md            # Documentación del proyecto
└── build.gradle.kts     # Configuración de dependencias

```
## 🖼️ Capturas de pantalla (pendiente)


## 🧑‍💻 Autor

**Juan Medina**
📍 El Salvador
🌐 randomuser.me
📧 juanmedina100@gmail.com


## 🪪 Licencia

Este proyecto está licenciado bajo la MIT License.
Consulta el archivo LICENSE
para más detalles.
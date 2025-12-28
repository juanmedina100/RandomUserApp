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
- 🧑‍💼 **Visualización completa del perfil**: nombre, edad, dirección, contacto, foto y más.
- 🎨 **Diseño moderno y adaptable** con modo claro/oscuro.
- 💫 **Animaciones suaves y navegación fluida**.

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
- ☎️ Teléfono
- 📧 Email

---

## 🧩 Ejemplo de datos de la API

```json
{
  "results": [
    {
      "gender": "female",
      "name": {
        "title": "Miss",
        "first": "Jennie",
        "last": "Nichols"
      },
      "location": {
        "street": {
          "number": 8929,
          "name": "Valwood Pkwy",
        },
        "city": "Billings",
        "state": "Michigan",
        "country": "United States",
        "postcode": "63104",
        "coordinates": {
          "latitude": "-69.8246",
          "longitude": "134.8719"
        },
        "timezone": {
          "offset": "+9:30",
          "description": "Adelaide, Darwin"
        }
      },
      "email": "jennie.nichols@example.com",
      "login": {
        "uuid": "7a0eed16-9430-4d68-901f-c0d4c1c3bf00",
        "username": "yellowpeacock117",
        "password": "addison",
        "salt": "sld1yGtd",
        "md5": "ab54ac4c0be9480ae8fa5e9e2a5196a3",
        "sha1": "edcf2ce613cbdea349133c52dc2f3b83168dc51b",
        "sha256": "48df5229235ada28389b91e60a935e4f9b73eb4bdb855ef9258a1751f10bdc5d"
      },
      "dob": {
        "date": "1992-03-08T15:13:16.688Z",
        "age": 30
      },
      "registered": {
        "date": "2007-07-09T05:51:59.390Z",
        "age": 14
      },
      "phone": "(272) 790-0888",
      "cell": "(489) 330-2385",
      "id": {
        "name": "SSN",
        "value": "405-88-3636"
      },
      "picture": {
        "large": "https://randomuser.me/api/portraits/men/75.jpg",
        "medium": "https://randomuser.me/api/portraits/med/men/75.jpg",
        "thumbnail": "https://randomuser.me/api/portraits/thumb/men/75.jpg"
      },
      "nat": "US"
    }
  ],
  "info": {
    "seed": "56d27f4a53bd5441",
    "results": 1,
    "page": 1,
    "version": "1.4"
  }
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
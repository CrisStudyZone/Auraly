# Auraly 📆

AgendaPro es una aplicación móvil desarrollada en Android Studio para la gestión de turnos, cobros de mensualidades y comunicación automatizada vía WhatsApp entre profesionales y clientes.

## ✨ Funcionalidades principales

- Registro de profesionales y clientes.
- Agendamiento de turnos.
- Visualización de clientes con deuda activa.
- Envío de recordatorios personalizados vía WhatsApp.

## 📱 Tecnologías utilizadas

- Android Studio (Kotlin)
- Firebase Authentication (Login con Google)
- Firebase Realtime Database (Base de datos remota)
- Firebase Storage (Imágenes y documentos)
- Room (opcional, si guardamos algo local)
- MVVM Architecture
- Material Design 3
- WhatsApp Integration (Intent API)

## 🚀 Metodología de trabajo

El desarrollo se llevará a cabo utilizando una metodología ágil con sprints semanales, aplicando buenas prácticas de organización, testing básico y separación de responsabilidades.

| Sprint   | Tareas principales                                 | Horas estimadas | Detalles                                                             |
| :------- | :------------------------------------------------- | :-------------- | :------------------------------------------------------------------- |
| Sprint 1 | Setup proyecto + Firebase Auth + Navegación básica | **10 a 12 hs**  | (Firebase puede llevar 2-3 hs; Login otra 3-4 hs; navegación 3-4 hs) |
| Sprint 2 | CRUD Clientes y Turnos en Firebase                 | **15 a 18 hs**  | (Modelado, lectura/escritura en DB, pantallas de ABM)                |
| Sprint 3 | WhatsApp Integration + Storage                     | **12 a 14 hs**  | (Mensajes personalizados + carga de imágenes/documentos)             |
| Sprint 4 | Pulido UI/UX + README completo + Testing final     | **10 a 12 hs**  | (Diseño visual, validaciones, creación del README bien explicado)    |

🔥 Estructura General de Proyecto

- app/
  - data/
    - remote/ (Firebase API calls)
    - repository/
    - model/ (Cliente.kt, Turno.kt, Profesional.kt)
  - domain/
    - usecase/ (business logic)
  - ui/
    - screens/ (Splash, Login, Home, Clientes, Turnos)
    - components/ (cards, forms, etc.)
  - utils/
    - FirebaseUtils.kt
    - Constants.kt
- README.md
- build.gradle

![Diagrama de clases Auraly drawio](https://github.com/user-attachments/assets/5a0b1ce1-370d-41f6-bedb-44fcde7aa1b9)

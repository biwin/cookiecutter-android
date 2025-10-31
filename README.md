# 🧱 cookiecutter: Android Clean Architecture 
### *Built with Hilt • Room • Retrofit • Coroutines • Material 3*

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9%2B-blue?logo=kotlin)](https://kotlinlang.org/) [![Android Studio](https://img.shields.io/badge/Android%20Studio-Giraffe%2B-brightgreen?logo=android)](https://developer.android.com/studio) [![License](https://img.shields.io/badge/License-MIT-lightgrey.svg)](LICENSE) [![Contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg)](#-contributing)

## 🧐 But why..?
Android’s default project creation isn’t customizable — every new app starts with the same tedious setup:

- Renaming packages
- Rebuilding navigation and fragments
- Re-creating layouts
- Adding and configuring dependencies
- Setting up Dependency Injection, network, and databases
- Re-structuring the entire project

All these repetitive tasks slow development and clutter creativity.
So I built this template — a ready-to-use, scalable foundation that automates the grind and lets you start building right away. 🚀

## 🚀 Overview

**Cookiecutter Android** is a **production-grade starter** for Android apps built with **Kotlin**, **Hilt**, and **Jetpack Room**.

It enforces **Clean Architecture** and **Material You (Material 3)** design principles to provide a scalable, testable, and maintainable foundation.



## 🌟 Key Features

✅ **Clean Architecture (MVVM + Use Cases)**
- Enforces strict separation of **Presentation**, **Domain**, and **Data** layers.

✅ **Dependency Injection with Hilt**
- Compile-time safe DI built on top of Dagger.

✅ Dual Gradle DSL Support
- Fully compatible with both Groovy DSL (build.gradle) and Kotlin DSL (build.gradle.kts).

✅ **Local Persistence via Room**
- Coroutine-friendly, Flow-based database access.

✅ Customizable Bottom Navigation
- Built with `BottomNavigationView`.
- Each navigation fragment can be customized on start.

✅ **Material You Design**
- Preconfigured **Material 3** theming with dynamic colors and typography.

✅ **Network + Caching Layer**
- Includes `NetworkBoundResource` and `Resource` abstractions for synchronized local + remote data.
- Handles common network states (Loading, Success, Error) gracefully.

✅ **Startup Configuration**
- Uses `androidx.startup.Initializer` for clean startup logic.

✅ **Reusable UI Logic**
- Base implementations for **RecyclerView adapters**, **DiffUtil**, and **state management**.




## 🧩 Architecture Overview

| **Layer** | **Responsibility** | **Key Components** | **Depends On** |
|------------|--------------------|--------------------|----------------|
| **Presentation** | UI & State Management | Activities, Fragments, ViewModels | Domain |
| **Domain** | Business Logic & Rules | Use Cases, Repository Interfaces, Domain Models | None (Pure Kotlin) |
| **Data** | Data Sources (Local/Remote) | DAOs, DTOs, Entities, Mappers, NetworkBoundResource | Domain |


## 🛠️ Tech Stack

| Category | Tool / Framework |
|-----------|------------------|
| **Language** | Kotlin |
| **Build System** | Gradle (Groovy & Kotlin DSL supported) |
| **Dependency Injection** | Hilt |
| **Database** | Room *(optional)* |
| **Concurrency** | Coroutines, Flow |
| **UI / Design** | Material Components (Material 3) |
| **Navigation** | BottomNavigationView with customizable fragments |
| **Architecture** | Clean Architecture + MVVM |
| **Networking** | Retrofit *(placeholder, optional)* |


## ⚙️ Getting Started

### 1️⃣ Install cookiecutter
```bash
pipx install cookiecutter
```

### 2️⃣ Generate a New Project via Cookiecutter
```bash
cookiecutter gh:biwin/cookiecutter-android
```

### 3️⃣ Open in Android Studio
Open the generated project, perform a **Gradle Sync**, and start coding! 🎉



## 📜 License

Licensed under the **[MIT License](LICENSE)** — feel free to use, modify, and distribute.

📣 Follow updates → watch this repository

🌟 If you find this useful, **give it a star on GitHub!**

💡 Have ideas or fixes? Pull requests are always open!

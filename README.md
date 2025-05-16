👽 Rick and Morty App – Android Kotlin + Jetpack Compose + Clean Architecture

Description:

The Rick and Morty App is a feature-rich Android application developed using Kotlin and Jetpack Compose, built upon the principles of Clean Architecture and modular design. It connects to the Rick and Morty API to present character details, using a layered architecture for scalability and maintainability.
🧱 Architecture Breakdown:

The application follows Clean Architecture with clear separation between:

    Data Layer (data)

        Contains data sources, mappers, and repository implementations.

        RickAndMortyRepositoryImpl is responsible for handling data interactions.

    Domain Layer (domain)

        Hosts business logic, data models, and use cases like RickAndMortyUseCase.

        Designed to be independent of UI and data source implementations.

    Presentation Layer (presentation)

        Built using Jetpack Compose for a modern, reactive UI.

        Structured into feature modules:

            main (main list screen + widgets)

            detail (character detail screen)

        Contains ViewModel and ViewState classes for state management.

🧩 Project Features:

    di: Dependency Injection configuration (likely Hilt or Koin).

    navigation: Centralized Compose Navigation between screens.

    widgets: Reusable UI components like LoadingDialog and DataItem.

    utils: Utility classes and constants.

    MyApplication.kt: Application entry point with initialization logic.

⚙️ Tech Stack:

    🛠️ Kotlin

    🎨 Jetpack Compose

    🧱 Clean Architecture

    ⚙️ Dependency Injection (e.g., Hilt)

    🌐 Rick and Morty REST API

    🔄 MVVM Pattern

    🧪 Unit & UI Testing

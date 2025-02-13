## Architecture Overview
This project follows the MVI (Model-View-Intent) design pattern combined with Clean Architecture principles to ensure a scalable, maintainable, and testable structure.

![app_architecture_image](https://github.com/OneDroid/GreedyCoder/blob/main/readme/app_architecture/GreedyCoderArchitecture.png)

* The Presentation Layer is responsible for rendering the UI and managing user interactions via a unidirectional flow of Intent, State, and ViewModel.
  
* The Domain Layer encapsulates business logic in UseCases, This layer is completely independent of other layers, ensuring that it can be reused and tested in isolation.
  
* The Data Layer abstracts data sources (API, Database) through a Repository pattern.

## Analytics
![Analytics](https://repobeats.axiom.co/api/embed/0f839f0e025bce09c72f6e444bb71a56ce47a8ab.svg "Repobeats analytics image")

## Contributors
<a href="https://github.com/OneDroid/GreedyCoder/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=OneDroid/GreedyCoder&max=100&columns=20" />
</a>

## Author
**Tawhid Monowar** - *Open Source Software Engineer* <br>
[LinkedIn](https://www.linkedin.com/in/tawhidmonowar) | [Portfolio](https://tawhidmonowar.github.io/profile)  | [GitHub](https://github.com/tawhidmonowar)

# clean-architecture-with-mvvm
## This project is an answer to the interview question 
## Explain how you would implement a Clean Architecture with MVVM in an Android application. What are the key components, and how do they interact?

### Clean architecture 
Clean architecture helps create systems that are framework-independent, in which the code is maintainable, testable, and applies separation of concerns 
Clean architecture achieves this through layers where the innermost layers are more abstract and deal with business logic,while the outermost layers are more concrete and deal with the platform and external interactions.

### key layers and components 
#### 1. Domain Layer
        * Entites     pure Java/Kotlin
        * Use cases business logic operations (GetUserProfileUseCase)
        * Repository Interfaces contracts for data access

#### 2. Data Layer
        * Repository Implementations
        * Data sources: Remote API | Local Database
        * Mappers converting between entities and data models

#### 3. Presentation Layer (MVVM)
        * View observes the viewmodel state
        * ViewModel holds UI state, processes user actions, and invokes use case
        * UI models data structures optimized for UI consumption

### Interaction Flow

#### 1. View interaction: user interacts with the UI (clicks a button to view order details).
#### 2. View to ViewModel: View informs the view model of the action (calls a function in the OrderViewModel like loadOrderDetails(orderID)).
#### 3. ViewModel to UseCase: the view model invokes a use case (GetOrderDetailsUseCase.execute (orderID))
#### 4. UseCase to Entities and Repository Interfaces: The use case handles business logic, it might interact with entities and use the repository interfaces to fetch data 
#### 5. Repository Implementation interacts with Data sources, network API via retrofit, or local database via Room
#### 6. Data flows back through layers in reverse: from data sources to repository implementation to use cases to view model to view
#### 7. The view model updates its state via Live data or flow
#### 8. View observes the view model's state and updates the UI to reflect the new data

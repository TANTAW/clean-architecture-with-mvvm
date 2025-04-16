# clean-architecture-with-mvvm
## This project is an answer to the interview question 
## Explain how you would implement a Clean Architecture with MVVM in an Android application. What are the key components and how do they interact?

### Clean architecture 
clean archeticture helps create systems that are Framework independant in which the code is maintainable, testable and applying seprations of concerns 
clean archeticture acheives this through layers where the innermost layers are more anstract and deal with buisness logic while the outermost layers are more conceate and deal with the platform and external interactions.

### key layers and components 
#### 1. Domain Layer
        * Entites     pure Java/Kotlin
        * Usecases    buisness logic operations (GetUserProfileUseCase)
        * Repository Interfaces contracts for data access

#### 2. Data Layer
        * Repository Implementations
        * Data sources Remote API | Local Database
        * Mappers converting between entities and data models

#### 3. Presentation Layer (MVVM)
        * View opserves viewmodel state
        * ViewModel holds UI state, Process User actions, invoke usecase
        * UI models data structures optimized for UI consumption

### Interaction Flow

#### 1. View interaction: user interacts with the UI (clicks a button to view order details).
#### 2. View to ViewModel: view informs the viewmodel of the action (calls a function in the OrderViewModel like loadOrderDetails(orderID)).
#### 3. ViewModel to Usecase: the view model invokes a usecase (GetOrderDetailsUseCase.excute(orderID))
#### 4. UseCase to Entities and Repository Interfaces: The use case handles business logic it might interat with entites and use Repositories interfaces to fetch data 
#### 5. Repository Implementation interact with Data sources network API via retrofit or local database via room
#### 6. Data flows back through layers in reverse: from datasources to repository implementation to usecases to viewmodel to view
#### 7. The view model updates it's state via Live data or flow
#### 8. View observes the view model's state and update the UI to reflect the new data

# GADS-2020-Leaderboard
## Brief overview
An Android mobile app that showcases the top 20 learners in both the *Learning Leaders* and *Skill IQ* categories for the Google Africa Developer Scholarship 2020 Leaderboard.
It fetches data from a remote GADS API using Retrofit2 and offers offline cache using okhttp3.

## Dependencies
1. Android Navigation Architecture with a single activity design pattern.
2. Dagger2 for dependency injection.
3. Retrofit2 and okhttp3 for communicating with the web service API and okhttp for caching
4. Data Binding framework.
5. Android Material Design.

## App Architecture and design
1. CLEAN Architecture with a mix of MVVM for the app's Presentation Layer.
2. SOLID Principles.

### Packages
1. *App:* contains all UI data including dependency injection, utilities etc
2. *Presentation:* contains ViewModels
3. *Domain:* contains the App's usecases and entities. Defines contract for the other layers
4. *Data:* contains references and defines the contract for the data sources (Remote and Local)
5. *Remote:* contains retrofit API service, and repository implementations
6. *Local:* no implementations. Just for backup if the need arise to use local persistence like ROOM DB

## Screenshots
1. Splash screen

![splash_screen](https://user-images.githubusercontent.com/65837990/92314843-4c930f00-efd5-11ea-81f5-cef8d2bb8610.png)

2. Main App Screen showing the Skill IQ Leaders

![skills](https://user-images.githubusercontent.com/65837990/92314846-4e5cd280-efd5-11ea-8db3-3c1700fdbaf9.png)

3. Main App Screen showing the Learning Leaders

![learning](https://user-images.githubusercontent.com/65837990/92314845-4dc43c00-efd5-11ea-906b-e0675b0f8973.png)

4. Project Submission Screen

![submission](https://user-images.githubusercontent.com/65837990/92314848-4ef56900-efd5-11ea-93c5-7db87c9ec058.png)

5. Project Submission Screen with a confirmation dialog

![dialog_submission](https://user-images.githubusercontent.com/65837990/92314850-4f8dff80-efd5-11ea-9b97-9ff38e4ee789.png)

6. Project Submission Screen with error input fields

![error_submission](https://user-images.githubusercontent.com/65837990/92314849-4ef56900-efd5-11ea-8010-f90d316c505d.png)

7. Project Submission Screen with success dialog

![succes_submission](https://user-images.githubusercontent.com/65837990/92314852-50bf2c80-efd5-11ea-962b-fed1ac13ac9f.png)

8. Project Submission Screen with failure dialog

![failed_submission](https://user-images.githubusercontent.com/65837990/92314851-50269600-efd5-11ea-8b4e-fcb99fe7fae8.png)



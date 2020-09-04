# GADS-2020-Leaderboard
## Brief overview
An Android mobile app that showcases the top 20 learners in both the *Learning Leaders* and *Skill IQ* categories for the Google Africa Developer Scholarship 2020 Leaderboard
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
1. *App* contains all UI data including dependency injection, utilities etc
2. *Presentation* contains ViewModels
3. *Domain* contains the App's usecases and entities. Defines contract for the other layers
4. *Data* contains references and defines the contract for the data sources (Remote and Local)
5. *Remote* contains retrofit API service, and repository implementations
6. *Local* no implementations. Just for backup if the need arise to use local persistence like ROOM DB

## Screenshots
1. Splash screen
![screenshot-1599181206786](https://user-images.githubusercontent.com/65837990/92188133-a8358f00-ee53-11ea-9505-0a253b21304f.jpg)

2. Main App Screen showing the Learning Leaders
![screenshot-1599181121077](https://user-images.githubusercontent.com/65837990/92188156-b8e60500-ee53-11ea-84d2-b6fe2cb5ecc2.jpg)

3. Main App Screen showing the Skill IQ Leaders
![screenshot-1599181069882](https://user-images.githubusercontent.com/65837990/92188166-bd122280-ee53-11ea-8799-339fcc9fac95.jpg)

4. Project Submission Screen
![screenshot-1599181181108](https://user-images.githubusercontent.com/65837990/92188140-abc91600-ee53-11ea-9dbb-a154dc84edf2.jpg)

5. Project Submission Screen with a confirmation dialog
![screenshot-1599181131757](https://user-images.githubusercontent.com/65837990/92188152-b4b9e780-ee53-11ea-9620-8f383ee08c8e.jpg)


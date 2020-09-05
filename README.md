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
![screenshot-1599181206786](https://user-images.githubusercontent.com/65837990/92188133-a8358f00-ee53-11ea-9505-0a253b21304f.jpg)

2. Main App Screen showing the Skill IQ Leaders
![skill](https://user-images.githubusercontent.com/65837990/92296662-f370a000-ef2e-11ea-9a5b-0b578f951396.png)

3. Main App Screen showing the Learning Leaders
![learning](https://user-images.githubusercontent.com/65837990/92296661-f10e4600-ef2e-11ea-8496-3b1bbef8e8dc.png)

4. Project Submission Screen
![submission](https://user-images.githubusercontent.com/65837990/92296663-f4093680-ef2e-11ea-84ae-f27ab7592a10.png)

5. Project Submission Screen with a confirmation dialog
![confirm_submission](https://user-images.githubusercontent.com/65837990/92296667-f66b9080-ef2e-11ea-8e37-201226db06f2.png)

6. Project Submission Screen with error input fields
![error_submission](https://user-images.githubusercontent.com/65837990/92296664-f4a1cd00-ef2e-11ea-96e7-12058913a75b.png)

7. Project Submission Screen with success dialog
![success_submission](https://user-images.githubusercontent.com/65837990/92296666-f5d2fa00-ef2e-11ea-889b-f3147a1ecdce.png)

8. Project Submission Screen with failure dialog
![failed_submission](https://user-images.githubusercontent.com/65837990/92296665-f53a6380-ef2e-11ea-9df1-efa0a29c9c37.png)



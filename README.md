# kotlin-mvvm
Languages: [English](README.md)

[![Kotlin](https://img.shields.io/badge/kotlin-1.4.30-blue.svg)](http://kotlinlang.org) [![Gradle](https://img.shields.io/badge/gradle-4.0.0-%2366DCB8.svg)](https://developer.android.com/studio/releases/gradle-plugin) [![Mockito](https://img.shields.io/badge/mockito-2.27.0-orange.svg)](https://site.mockito.org/)

MVVM(Model View ViewModel) sample in Kotlin using the components ViewModel, LiveData, the libraries Retrofit, Glide and Mockito for testing.

### MVVM Pattern (Model View ViewModel)
 <img src="assets/AndroidMVVM.png">

### App
<img src="assets/app_image.webp" height="480">

### Architecture
<img src="assets/mvvm_architecture.png" height="540">

### Screenshots

<img src="assets/homepage.png.png" height="480">

<img src="assets/searchpage.png.png" height="196"> 

#### Note: To run the app you have to add [NewsAPI.org](https://newsapi.org/register) key. I have taken this step to due to limited access to daily request for News. Getting a key would take just few seconds :)

#### Setup API Key
1. Visit [NewsAPI.org](https://newsapi.org/register) to get your API Key
2. Copy your API Key from accounts section
3. Open `gradle.properties` *(Create the file if not exists)*
    - For Linux/Mac: `/home/.gradle/gradle.properties`
    - For Windows: `C:\Users\<UserName>\.gradle\gradle.properties`
    - Add the following line:
    ```
    NewsApi_ApiKey="YOUR_API_KEY"
    ``` 


### Slides

Android MVVM https://docs.google.com/presentation/d/1nTwtU8OWYs_8Q3i_3hOPAWodDpDKzO--uA-4b6LUr8g/edit?usp=sharing

Android MVVM Clean https://docs.google.com/presentation/d/1luTzvqGaMjVycEx109-AjYIj3FIpXYAt3Mnu-gjqxtc/edit?usp=sharing

### Updates [July 2022]

- Added state flow. [branch State Flow](https://github.com/emedinaa/kotlin-mvvm/tree/state-flow)

- Added jetpack compose. [branch compose](https://github.com/emedinaa/kotlin-mvvm/tree/compose)

- Added rxjava library. [branch rx-kotlin](https://github.com/emedinaa/kotlin-mvvm/tree/rxkotlin)

- Add navigation component library. [branch navigation-component](https://github.com/emedinaa/kotlin-mvvm/tree/navigation-component)

- Added viewbinding support and  kotlin extensions were removed. [branch viewbinding](https://github.com/emedinaa/kotlin-mvvm/tree/viewbinding)

- Added dependency injection with Hilt, included android tests [branch hilt](https://github.com/emedinaa/kotlin-mvvm/tree/hilt)

- Added unit tests with Flow [branch flow](https://github.com/emedinaa/kotlin-mvvm/tree/flow)

- Added kotlin Flow and fragment ktx [branch flow](https://github.com/emedinaa/kotlin-mvvm/tree/flow)

- Room [branch room](https://github.com/emedinaa/kotlin-mvvm/tree/room)

- Added View Binding [branch viewbinding](https://github.com/emedinaa/kotlin-mvvm/tree/viewbinding)

- Dependencies versions were updated and ViewModelProviders class was removed (deprecated). [all branches](https://github.com/emedinaa/kotlin-mvvm/)

- Added Coroutines with retrofit and sealed classes to replace callbacks. Included testing with Coroutines. [branch coroutines](https://github.com/emedinaa/kotlin-mvvm/tree/coroutines)

- Added Koin, dependency injection framework written in Kotlin. Included integration with Mockito for testing (11th Oct) [branch koin](https://github.com/emedinaa/kotlin-mvvm/tree/koin)

- Added Unit Testing with Mockito (27th May) [Link](https://github.com/emedinaa/kotlin-mvvm/commit/92d9e5a659c21178364d0b51e904fd126b0b6204)

- Fix load images android P by Carlos Ugaz [carlosgub](https://github.com/carlosgub) [Link](https://github.com/emedinaa/kotlin-mvvm/pull/1)


### Dependencies

- Retrofit 2 [version: '2.3.0'](https://square.github.io/retrofit/)
- OkHttp 3 [version: '3.4.1'](https://square.github.io/okhttp/)
- Glide [version: '4.9.0'](https://github.com/bumptech/glide)
- AndroidX [version: '1.2.0'](https://mvnrepository.com/artifact/androidx)
- Arch Lifecycle [version: '2.4.0'](https://developer.android.com/jetpack/androidx/releases/lifecycle)
- Mockito [version: '2.27.0'](https://site.mockito.org/)
- Arch Testing [version: '2.4.0'](https://mvnrepository.com/artifact/android.arch.core/core-testing?repo=google)

### References

- State Flow https://developer.android.com/kotlin/flow/stateflow-and-sharedflow
- ViewModel https://developer.android.com/topic/libraries/architecture/viewmodel
- LiveData https://developer.android.com/topic/libraries/architecture/livedata
- Android Architecture Blueprints https://github.com/googlesamples/android-architecture
- Android Jetpack: ViewModel https://www.youtube.com/watch?v=5qlIPTDE274
- Mockito : https://site.mockito.org/
- Unit Testing + Mockito + Kotlin + Architecture components https://medium.com/@marco_cattaneo/unit-testing-with-mockito-on-kotlin-android-project-with-architecture-components-2059eb637912
- Junit + LiveData https://jeroenmols.com/blog/2019/01/17/livedatajunit5/

### Contributing and reporting issues

If you want to contribute in this repository, please send me a pull request or if you want to report some issues please send at https://github.com/ten/kotlin-mvvm/issues

I appreciate any question or comment. Also, if you consider it useful, you can give me a star ⭐ ⭐ ⭐.

package navigation

enum class screenTypes {
    HomeScreen,
    WelcomeScreen;
    companion object {
        fun fromRoute(route: String?): screenTypes
                = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            WelcomeScreen.name -> WelcomeScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}
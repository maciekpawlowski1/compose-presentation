# **Jetpack Compose**
## Maciej Pawłowski i Krzysztof Czechowicz

---
# Jetpack Compose – Wprowadzenie
- Nowoczesny toolkit do tworzenia UI w Androidzie
- Deklaratywny sposób budowania interfejsów
- Mniej boilerplate, szybszy development
- Integruje się z istniejącymi aplikacjami

---

# Dlaczego Jetpack Compose?
- deklaratywny model UI
- pełna kompatybilność z Kotlinem
- mniej kodu niż w XML
- szybkie podglądy (`@Preview`)
- łatwa obsługa stanów

---
# Compose zamiast XML

> Teams report saving up to 45% of lines of code when migrating screens from XML to Compose, and building features about 30% faster with Compose compared to Views.

---

# Architektura Deklaratywna

**Imperatywne UI (XML + View):**
- modyfikacja drzewa UI
- ręczne zarządzanie stanem

**Deklaratywne UI (Compose):**
- UI = funkcja stanu
- brak ręcznej ingerencji w widoki

---

<style scoped>
  {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-template-rows: min-content;
    grid-column-gap: 16px;
  }
</style>

<div style="grid-column: span 2;">

# Pierwszy Komponent Compose

</div>

<div>

```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```

</div>

<div>

```kotlin
@Preview(showBackground = true)  
@Composable  
fun GreetingPreview() {  
    Greeting(name = "World")  
}
```

</div>

---
# Przykład 1

---

# Integracja z Anroid Activity
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme {
                Greeting(
                    name = "Android",
                )
            }
        }
    }
}
```

---

# Przykład 2

---

# Composable
![height:480px](https://cdn.markslides.ai/users/3643/images/6TWWwj0KbUS6r5d26ORYV)

---

# Stan w Jetpack Compose

- użycie remember
- wartości re-renderują UI po zmianie

```kotlin
var text by remember { mutableStateOf("") }  
TextField(  
    value = text,  
    onValueChange = { text = it }  
)
```

---

# Odczytywanie stanu - sposób 2

```kotlin
val text = remember { mutableStateOf("") }  
TextField(  
    value = text.value,  
    onValueChange = { text.value = it }  
)
```

# Odczytywanie stanu - sposób 3

```kotlin
val (text, setText) = remember { mutableStateOf("") }
TextField(
    value = text,
    onValueChange = { setText(it) }
)
```

---

# State Hoisting – oddzielanie logiki od UI

```kotlin
@Composable  
fun Counter(count: Int, onIncrement: () -> Unit) {  
    Button(onClick = onIncrement) {  
        Text("Count: $count")  
    }  
}
```

---

# View Model w Compose
```kotlin
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
```

---

# Przykład 3

---

# Przykład 4

---

# Layouty w Compose

- Column, Row, Box
- elastyczne i proste układanie elementów

```kotlin
Column {  
    Text("Hello")  
    Text("World")  
}
```

---

# Przykład 5

---

# Fazy Compose: 1 - Composition
![height:480px](https://cdn.markslides.ai/users/3643/images/X5btB4CI9qAleOWhRB8pv)

---
# Fazy Compose: 2 - Layout
https://developer.android.com/static/develop/ui/compose/images/layout.mp4

---

# Fazy Compose: 3 - Draw
https://developer.android.com/static/develop/ui/compose/images/drawing.mp4

---

# CompositionLocal

- mechanizm dzielenia się danymi w drzewie UI bez przekazywania parametrów
- alternatywa dla dependency injection w widoku
- używane dla: themingu, lokalizacji, konfiguracji

Tworzenie wartości:
```kotlin
val LocalSpacing = compositionLocalOf { 8.dp }


CompositionLocalProvider(LocalSpacing provides 16.dp) {  
    Text("Spacing = ${LocalSpacing.current}")  
}
```

---

# Przykład 6

---

# Material Design 3

```kotlin
MaterialTheme {  
    Surface {  
        Text("MD3 Example")  
    }  
}
```

---

# Modifiers – podstawy

- służą do modyfikowania wyglądu i zachowania komponentów
- kolejność modifierów MA znaczenie
- modyfikują: rozmiar, padding, kliknięcia, tło, animacje i wiele innych

```kotlin
Modifier
    .padding(16.dp)
    .background(Color.Blue)
    .clickable { /* ... */ }
    .fillMaxWidth()
```

---

# Przykład 7

---

# remember i rememberSaveable

**remember**
- przechowuje stan podczas recomposition
- nie przetrwa rotacji / procesu zabicia aplikacji

**rememberSaveable**
- zapisuje stan w Bundle
- przetrwa zmiany konfiguracji (np. rotację) i śmierć procesu

```kotlin
var name by remember { mutableStateOf("") }  
var counter by rememberSaveable { mutableStateOf(0) }
```

---

# LaunchedEffect – uruchamianie kodu w Compose

- uruchamia coroutine powiązane z cyklem życia Composable
- używane do: fetch API, timerów, animacji, efektów ubocznych
- klucz kontroluje ponowne uruchomienie

```kotlin
LaunchedEffect(key1 = userId) {  
    loadUserData(userId)  
}
```

---

# LazyColumn / LazyRow

- działają jak RecyclerView, ale prościej
- renderują tylko widoczne elementy
- idealne listy z tysiącami elementów

```kotlin
LazyColumn {  
    items(1000) { index ->  
        Text("Item $index")  
    }  
}
LazyRow {  
    items(list) { item ->  
        ItemCard(item)  
    }  
}
```

---

# Canvas w Compose

- niskopoziomowe API do rysowania
- pozwala tworzyć wykresy, gry, własne elementy UI

```kotlin
Canvas(modifier = Modifier.size(200.dp)) {  
    drawCircle(Color.Red, radius = 80f)  
    drawLine(Color.Black, Offset(0f,0f), Offset(size.width, size.height))  
}
```

---

# Animacje

```kotlin
val alpha by animateFloatAsState(  
    targetValue = if (visible) 1f else 0f  
)  
Box(modifier = Modifier.alpha(alpha))
```

---

# Przykład 8

---

# Przykład 9

---

# Przykład 10

---

# Integracja z XML / Views

```kotlin
AndroidView(  
    factory = { context ->  
        TextView(context).apply { text = "Legacy View" }  
    }  
)
```

---

# Nawigacja w Compose

```kotlin
NavHost(navController, startDestination = "home") {  
    composable("home") { HomeScreen() }  
    composable("details") { DetailScreen() }  
}
```



---



# Performance – recompositions

- Compose optymalizuje sam rekompozycje
- Unika zbędnego renderowania
- Najważniejsze zasady:
    - stabilne typy (stable)
    - unikanie mutowalnych obiektów
    - przenoszenie stanu wyżej, jeśli trzeba

---

# Testowanie w Jetpack Compose

```kotlin
@get:Rule  
val composeTestRule = createComposeRule()  

@Test  
fun testGreeting() {  
    composeTestRule.setContent { Greeting("Maciek") }  
    composeTestRule.onNodeWithText("Hello Maciek!").assertExists()  
}
```

---

# 🕒 Zadanie: Zegar odliczający od 10 do 0
Stwórz ekran, który:
- po wyświetleniu automatycznie rozpoczyna odliczanie od **10 do 0**
- posiada przycisk **"Restart"**, który uruchamia odliczanie od nowa
- użyj `remember { mutableStateOf(10) }` do przechowywania licznika
- w `LaunchedEffect` umieść pętlę odliczającą z `delay(1000)`
- zadbaj, aby UI nie blokowało się podczas odliczania



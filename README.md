# YAAR AI — Android starter

A simple Hinglish-friendly Android chat UI built with Kotlin and Jetpack Compose.

## What this starter includes
- Chat screen with message bubbles
- Text input and send button
- Local in-memory chat history while the app is open
- A simple welcome message

## Important
This is a **starter project**, not a finished AI-powered app or APK. The send button currently adds a local demo reply. To connect a real AI model, add a small HTTPS backend that calls the model provider. Do **not** put an API key inside the Android app.

## Open in Android Studio
1. Install Android Studio.
2. Choose **Open** and select this `YAAR_AI_Android_Starter` folder.
3. Let Gradle sync.
4. Run on an Android emulator or device.

## Next step for real AI
Create a backend endpoint such as `POST /chat` that accepts the conversation and returns an assistant reply. Then replace `demoReply()` in `MainActivity.kt` with a Retrofit/OkHttp request to your backend. Keep credentials on the backend.

## App identity
- App name: YAAR AI
- Package: `com.y arai.app` (the actual package in source is `com.yaarai.app`)

## Build APK without owning a laptop
This project does not include the Gradle wrapper files, so the GitHub Actions workflow needs those added before it can build. The simplest route is to open the project in an Android cloud IDE or use a computer with Android Studio once to generate the Gradle wrapper (`gradle wrapper`). This starter is not yet a finished AI product.

# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

This is an Android project using Gradle with Kotlin DSL. The main project is located in the `Lab01/` directory.

```bash
# Navigate to the Lab01 directory for all Android commands
cd Lab01

# Build the project
./gradlew build

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install debug APK to connected device/emulator
./gradlew installDebug

# Run unit tests
./gradlew test

# Run instrumented tests (requires connected device/emulator)
./gradlew connectedAndroidTest

# Clean build artifacts
./gradlew clean

# Check dependencies for updates
./gradlew dependencyUpdates
```

## Project Architecture

### Structure
- **Lab01/**: Main Android project directory
- **Requirements/**: Lab documentation and requirements (Word docs, PDFs)

### Android Project Details
- **Package**: `com.example.lab01`
- **Target SDK**: 35 (Android 15)
- **Minimum SDK**: 27 (Android 8.1)
- **Build System**: Gradle with Kotlin DSL and Version Catalog
- **Language**: Kotlin
- **Architecture**: Single Activity with ConstraintLayout

### Key Configuration
- Uses **Gradle Version Catalog** (`gradle/libs.versions.toml`) for dependency management
- **AndroidX** libraries with Material Design Components
- **Edge-to-edge** UI implementation
- **ProGuard** configured for release builds

### Dependencies Management
- All versions are centralized in `gradle/libs.versions.toml`
- Uses `libs.` references in build scripts
- Current major dependencies: AndroidX Core KTX, AppCompat, Material Design, ConstraintLayout

### Testing Setup
- **Unit tests**: JUnit 4.13.2 in `src/test/`
- **Instrumented tests**: AndroidX Test + Espresso in `src/androidTest/`
- Test runner: AndroidJUnitRunner

## Development Notes

- This appears to be a lab exercise project (PRM392 course)
- Multiple lab requirements are documented in the `Requirements/` directory
- The project follows standard Android development practices with modern tooling
- When working with layouts, the main activity uses ConstraintLayout for responsive design
- **IMPORTANT**: Do not automatically build the project after making changes. Only build when explicitly requested by the user.
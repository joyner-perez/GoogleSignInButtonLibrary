# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Development Commands

```bash
# Build
./gradlew build
./gradlew assembleDebug
./gradlew assembleRelease
./gradlew clean

# Tests
./gradlew test                          # Unit tests
./gradlew connectedAndroidTest          # Instrumented tests (requires device/emulator)

# Code quality (run before committing)
./gradlew ktlintCheck                   # Check formatting
./gradlew ktlintFormat                  # Auto-fix formatting
./gradlew detekt                        # Static analysis (max-issues: 0, must pass)

# Documentation
./gradlew GoogleSignInComposeLibrary:dokkaGenerateHtml
```

A pre-commit hook (`.scripts/pre-commit`) is auto-installed via `settings.gradle` and enforces quality checks on commit.

## Architecture

This is a Jetpack Compose Android library (`GoogleSignInComposeLibrary` module) published via JitPack. The `app` module is an example/demo only.

**Two public composables:**
- `GoogleSignInButton` — UI-only button, calls `onClick: () -> Unit`
- `GoogleSignInFullButton` — Handles Google authentication via Android Credential Manager, calls `onClick: (Result<String>) -> Unit` with the ID token

**Standalone auth function:**
- `makeLogin(context, tokenClientId): Result<String>` — suspend function for manual auth invocation outside the button

**Type-safe button system** (sealed class hierarchy in `ui/type/` and `ui/properties/`):
- `CommonButtonType`: `Elevated`, `Filled`, `FilledTonal`, `Outlined`, `Text`
- `FabButtonType`: `Fab`, `SmallFab`, `LargeFab`, `FabExtended`
- `IconButtonType`: `IconFilled`, `IconFilledTonal`, `IconOutlined`, `IconStandard`

Each type has a corresponding `*Properties` sealed subclass (in `ui/properties/`) for customization (colors, sizes, text, etc.).

**Internal routing pattern:** The public composables delegate to `MainCommonGoogleSignButton`, `MainFabGoogleSignButton`, or `MainIconGoogleSignButton` routers, which then render the appropriate individual button composable. Individual button implementations live in `ui/buttons/common/`, `ui/buttons/fab/`, and `ui/buttons/icon/`.

**Authentication flow** (`makeLogin`): Creates a `GetCredentialRequest` with Google ID option + SHA-256 nonce, calls Android Credential Manager, extracts ID token from `GoogleIdTokenCredential`.

## Code Style

- KtLint 1.8.0 with Android Studio code style (`.editorconfig`)
- Detekt 1.23.8 with Compose rules; strict (max 0 issues)
- Composable functions use PascalCase naming (enforced via `.editorconfig` override)
- Dependency versions managed in `gradle/libs.versions.toml`
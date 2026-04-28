import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.nio.file.attribute.PosixFilePermissions

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

val hooksDir = rootDir.toPath().resolve(".git/hooks")
val targetHook = hooksDir.resolve("pre-commit")
val sourceHook = rootDir.toPath().resolve(".scripts/pre-commit")

if (Files.notExists(sourceHook)) {
    throw GradleException("❌ No existe el hook fuente: $sourceHook. ¿Está en .scripts/pre-commit?")
}

Files.createDirectories(hooksDir)

println("🔧 Installing Git hook pre-commit…")
Files.copy(sourceHook, targetHook, StandardCopyOption.REPLACE_EXISTING)

try {
    Files.setPosixFilePermissions(
        targetHook,
        PosixFilePermissions.fromString("rwxr-xr-x")
    )
} catch (_: Throwable) {}

println("✅ Hook installed at $targetHook")

rootProject.name = "GoogleSignInButtonLibrary"
include(":app")
include(":GoogleSignInComposeLibrary")

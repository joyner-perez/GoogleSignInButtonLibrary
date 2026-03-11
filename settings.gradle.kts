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

// 1) Asegura que el origen exista
if (Files.notExists(sourceHook)) {
    throw GradleException("❌ No existe el hook fuente: $sourceHook. ¿Está en .scripts/pre-commit?")
}

// 2) Asegura que exista .git/hooks
Files.createDirectories(hooksDir)

// 3) Copia SIEMPRE (o cuando cambie)
println("🔧 Installing Git hook pre-commit…")
Files.copy(sourceHook, targetHook, StandardCopyOption.REPLACE_EXISTING)

// 4) Permisos (en Windows esto puede no aplicar y no pasa nada)
try {
    Files.setPosixFilePermissions(
        targetHook,
        PosixFilePermissions.fromString("rwxr-xr-x")
    )
} catch (_: Throwable) {
    // Windows / FS sin POSIX
}

println("✅ Hook installed at $targetHook")

rootProject.name = "GoogleSignInButtonLibrary"
include(":app")
include(":GoogleSignInComposeLibrary")

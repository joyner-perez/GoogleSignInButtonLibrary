import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.caupain)
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.gradle.build.health)
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.sort.dependencies) apply false
}

val ktLintVersion: String = libs.versions.ktlintVersion.get()

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    configure<KtlintExtension> {
        version.set(ktLintVersion)
        debug.set(true)
        verbose.set(true)
        android.set(true)
        outputToConsole.set(true)
        outputColorName.set("RED")
        filter {
            exclude("**/com/example/googlesignincompose/app/**")
        }
    }
}

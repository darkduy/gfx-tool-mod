pluginManagement {
    repositories {
        // Gradle plugin portal first
        gradlePluginPortal()
        // Maven Central
        mavenCentral()
        // Fabric's own maven for fabric-loom plugin/artifacts
        maven("https://maven.fabricmc.net/")
    }

    // Optional: help Gradle resolve the plugin id to the module on Fabric maven
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "fabric-loom") {
                // map plugin id to the actual module coordinates used by Fabric
                useModule("fabric-loom:fabric-loom.gradle.plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "gfx-tool-mod"
plugins {
    id("fabric-loom") version "1.2.9" // hoặc version bạn muốn
    java
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.20.4")
    mappings("net.fabricmc:yarn:1.20.4+build.11:v2")
    modImplementation("net.fabricmc:fabric-loader:0.14.22")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.79.0+1.20.4")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

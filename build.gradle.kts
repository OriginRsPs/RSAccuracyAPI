import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.origin"
version = "1.0.1"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java {
            srcDir("src")
        }
    }
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.32")
}

tasks.named<ShadowJar>("shadowJar") {
    archiveFileName.set("RSAccuracyAPI-1.0.1.jar")
}

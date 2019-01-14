import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.10"
    id("com.github.johnrengelman.shadow") version "4.0.3"
}

group = "no.kartveit"
version = "1.0-SNAPSHOT"


task("fatJar", type = Jar::class) {
    manifest {
        attributes["Main-Class"] = "no.kartveit.BootstrapKt"
    }
}

tasks.withType<Jar>{
    manifest {
        attributes(mapOf(
            "Main-Class" to "no.kartveit.BootstrapKt"
        ))
    }
}

tasks.withType<ShadowJar> {
    manifest {
        attributes(mapOf(
            "Main-Class" to "no.kartveit.BootstrapKt"
        ))
    }
    mergeServiceFiles()
}


repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.ian"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly(files("libs/spigot-1.20.4-R0.1-SNAPSHOT.jar"))
    implementation("com.github.SevJSix:SimpleMixins:1.1")
    implementation("net.bytebuddy:byte-buddy:1.12.17")
    implementation("net.bytebuddy:byte-buddy-agent:1.12.17")
    implementation("io.netty:netty-all:5.0.0.Alpha2")
}

tasks {
    shadowJar {
        archiveFileName.set("TestPlugin-${project.version}.jar")
    }
}

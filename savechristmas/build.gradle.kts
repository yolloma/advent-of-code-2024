plugins {
    kotlin("jvm") version "2.0.10"
}

group = "org.yolloma"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

sourceSets {
    test {
        resources.srcDirs.plus("src/test/resources")
    }

    main {
        resources.srcDirs.plus("src/main/resources")
    }

}

kotlin {
    jvmToolchain(21)
}
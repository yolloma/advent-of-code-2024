plugins {
    kotlin("jvm") version "2.0.10"
}

group = "org.yolloma"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
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
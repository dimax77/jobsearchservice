plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "1.8.20"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()

}
dependencies {
    implementation(project(":data"))
    implementation(project(":model"))
}

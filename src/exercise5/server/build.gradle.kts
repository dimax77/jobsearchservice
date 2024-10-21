plugins {
    id("org.jetbrains.kotlin.jvm")
    application
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()

}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.20")
    implementation("io.ktor:ktor-server-core:2.1.0")
    implementation("io.ktor:ktor-server-netty:2.1.0")
    implementation("io.ktor:ktor-server-content-negotiation:2.1.0")
//    implementation("io.ktor:ktor-jackson:2.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
//    implementation("androidx.room:room-runtime:2.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation(project(":data"))
    implementation(project(":testdatasource"))
    implementation(project(":service"))
    implementation(project(":model"))
//    implementation(project(":CompanyDataService"))
    implementation("io.ktor:ktor-server-content-negotiation:2.1.0") // Для ContentNegotiation
    implementation("io.ktor:ktor-serialization-gson:2.3.4") // Для работы с JSON через Gson
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.0")
    implementation("com.fatboyindustrial.gson-javatime-serialisers:gson-javatime-serialisers:1.1.1")



}

application {
    mainClass.set("com.mockingb.server.ServerKt")
}

tasks.register("downloadDependencies") {
    doLast {
        println("Downloading dependencies...")
        exec {
            commandLine("gradle", "dependencies")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

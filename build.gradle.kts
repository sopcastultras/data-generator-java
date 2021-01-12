plugins {
    java
    id("com.palantir.graal") version "0.7.2"
}

group = "org.generator.data"
version = "1.0-SNAPSHOT"

tasks.withType(Wrapper::class) {
    gradleVersion = "6.1.1"
}

graal {
    mainClass("MainClass")
    outputName("main")
}

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("info.picocli:picocli-codegen:4.6.1")
    implementation("info.picocli:picocli:4.6.1")

    implementation("com.thoughtworks.xstream:xstream:1.4.15")
    implementation("com.google.code.gson:gson:2.8.6")
}

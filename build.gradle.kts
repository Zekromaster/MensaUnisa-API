plugins {
    id("java")
    id("io.freefair.lombok") version "8.3"
}

group = "net.zekromaster.mensaunisa.api"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.1")

    testImplementation(platform("org.spockframework:spock-bom:2.3-groovy-4.0"))
    testImplementation("org.spockframework:spock-core")
    testImplementation("org.hamcrest:hamcrest-core:2.2")

    implementation("io.vavr:vavr:0.10.4")
    implementation("com.dieselpoint:norm:1.0.5")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.javalin:javalin:5.6.2")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("io.vavr:vavr-gson:0.10.2")
    implementation("org.apache.commons:commons-lang3:3.13.0")
}

tasks.test {
    useJUnitPlatform()
}
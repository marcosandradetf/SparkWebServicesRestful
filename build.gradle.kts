plugins {
    java
    application
}

application {
    // Define a classe principal do aplicativo Spark Java
        mainClass.set("sparkwebservicesrestful.App")
}

group = "SparkWebServicesRestful"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.sparkjava:spark-core:2.9.4")
    implementation("org.slf4j:slf4j-api:2.0.12")
    testImplementation("ch.qos.logback:logback-classic:1.4.14")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.4")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<JavaExec>("run") {
    // Configuração dos argumentos para a tarefa run
    if (project.hasProperty("args")) {
        args(*(project.property("args") as String).split(" ").toTypedArray())
    }
}


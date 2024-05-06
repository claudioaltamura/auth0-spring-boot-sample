plugins {
	checkstyle
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.5"
	id("com.github.ben-manes.versions") version "0.51.0"
	id("se.solrike.sonarlint") version "2.0.0"
}

group = "de.claudioaltamura"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

dependencyLocking {
	lockAllConfigurations()
}

checkstyle {
	toolVersion = "10.3"
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	sonarlintPlugins("org.sonarsource.java:sonar-java-plugin:7.34.0.35958")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("io.github.cdimascio:dotenv-java:3.0.0")
	implementation("me.paulschwarz:spring-dotenv:4.0.0")
	implementation("com.okta.spring:okta-spring-boot-starter:3.0.6")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

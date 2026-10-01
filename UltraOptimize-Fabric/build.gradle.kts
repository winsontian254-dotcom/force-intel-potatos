plugins {
	id("fabric-loom") version "1.4.11"
	id("maven-publish")
}

version = project.property("mod_version").toString()
group = project.property("maven_group").toString()

repositories {
	mavenCentral()
	maven("https://maven.fabricmc.net/") {
		name = "Fabric"
	}
	maven("https://maven.architectury.dev/") {
		name = "Architectury"
	}
	maven("https://maven.modmuss50.me") {
		name = "modmuss50"
	}
}

dependencies {
	minecraft("com.mojang:minecraft:${property("minecraft_version")}")
	mappings(loom.officialMojangMappings())
	modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")
	modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_version")}")

	// Mixin Extras for enhanced mixin support
	val mixinExtrasVersion = property("mixinextras_version").toString()
	modImplementation("io.github.llamalad7:mixinextras-fabric:${mixinExtrasVersion}")
	include("io.github.llamalad7:mixinextras-fabric:${mixinExtrasVersion}")
}

loom {
	accessWidenerPath.set(file("src/main/resources/ultraoptimize.accesswidener"))
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17

	withSourcesJar()
}

tasks.withType<JavaCompile>().configureEach {
	options.release.set(17)
}

tasks.jar {
	from("LICENSE") {
		rename { "${it}_${project.property("archives_base_name")}" }
	}
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
		}
	}

	repositories {
		// Add your maven repository here if you want to publish
	}
}

group = "space.iseki"
version = "1.0-SNAPSHOT"
plugins{
    kotlin("jvm") version "1.3.70"
	kotlin("plugin.serialization") version "1.3.70"
	//application
}

//application{
//   mainClassName="MainKt"
//}

dependencies {
    implementation("org.jsoup:jsoup:1.13.1")
	implementation(kotlin("stdlib", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
	
    val jacksonVersion = "2.10.2"
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation(vertx("core"))
    implementation(vertx("lang-kotlin"))
    implementation(vertx("lang-kotlin-coroutines"))
    implementation(coroutine("core"))
}

repositories {
    //maven { setUrl("https://maven.aliyun.com/repository/public/") }
    mavenCentral()
    jcenter()
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs = listOf("-XXLanguage:+NewInference")
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs = listOf("-XXLanguage:+NewInference")
    }
}

fun DependencyHandler.vertx(module: String, version: String = "4.0.0-milestone4") =
    "io.vertx:vertx-$module:$version"
fun DependencyHandler.coroutine(module: String, version: String = "1.3.3") =
    "org.jetbrains.kotlinx:kotlinx-coroutines-$module:$version"
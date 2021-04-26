plugins {
    kotlin("jvm") version "1.4.32"
    kotlin("kapt") version "1.4.32"
    id("me.champeau.gradle.jmh") version "0.5.2"
    id("io.morethan.jmhreport") version "0.9.0"
    application
}

group = "br.com.alice.benchmarks"
version "0.0.1"


repositories {
    mavenCentral()
}

sourceSets.main {
    java.srcDirs("src")
}
sourceSets.test {
    java.srcDirs("test")
}

dependencies {
    kapt("org.openjdk.jmh:jmh-generator-annprocess:1.25")

    implementation("org.openjdk.jmh:jmh-core:1.25")
    implementation("org.openjdk.jmh:jmh-generator-annprocess:1.25")

    api("ch.qos.logback:logback-classic:1.2.3")
    implementation("net.logstash.logback:logstash-logback-encoder:6.4")

    annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.25")

    testImplementation(kotlin("test-junit"))
}

jmhReport {
    jmhResultPath = project.file("build/result.json").absolutePath
    jmhReportOutput = project.file("build/reports/jmh").absolutePath
}

task("benchmarks", type = JavaExec::class) {
    main = "br.com.alice.benchmarks.BenchmarksRunnerKt"
}

tasks.test {
    useJUnit()
}

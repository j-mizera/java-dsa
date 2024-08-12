plugins {
    id("java")
    id("checkstyle")
    id("pmd")
}

group = "eu.witherxse.dsa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("codeQuality") {
    dependsOn("checkstyleMain", "checkstyleTest", "pmdMain", "pmdTest")
}

checkstyle {
    toolVersion = "10.17.0"
    configFile = file("${rootDir}/config/checkstyle/checkstyle.xml")
    isShowViolations = true
    isIgnoreFailures = false
}
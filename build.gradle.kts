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
}

tasks.withType<Checkstyle> {
    /*doLast {
        reports.forEach { report ->
            val outputFile = report.outputLocation.asFile.orNull
            val outputFileExists = outputFile?.exists() ?: false
            val errorExists = outputFileExists && outputFile?.readText()?.contains("<error ") == true
            if (errorExists) {
                throw GradleException("There were checkstyle warnings! For more info check $outputFile")
            }
        }
    }*/
}
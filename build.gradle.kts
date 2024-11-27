plugins {
    id("org.openrewrite.build.recipe-library") version "latest.release"
}

group = "org.openrewrite.recipe"
description = "A rewrite module hosting recommended collections of recipes"

repositories {
    val maven = maven {
        url = uri("https://repo.gradle.org/gradle/libs-releases/")
        content {
            excludeVersionByRegex(".+", ".+", ".+-rc-?[0-9]*")
        }
    }
    // Needed to pick up snapshot versions of rewrite
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

val rewriteVersion = rewriteRecipe.rewriteVersion.get()
dependencies {
    implementation(platform("org.openrewrite:rewrite-bom:$rewriteVersion"))

    implementation("org.openrewrite:rewrite-yaml")
    implementation("org.openrewrite:rewrite-java")
    implementation("org.openrewrite:rewrite-xml")
    implementation("org.openrewrite:rewrite-hcl")
    implementation("org.openrewrite:rewrite-maven")
    implementation("org.openrewrite.recipe:rewrite-migrate-java:$rewriteVersion")
    implementation("org.openrewrite.recipe:rewrite-static-analysis:$rewriteVersion")
    implementation("org.openrewrite.recipe:rewrite-terraform:$rewriteVersion")
    implementation("org.openrewrite.recipe:rewrite-testing-frameworks:$rewriteVersion")

    testImplementation("org.openrewrite:rewrite-test")
}

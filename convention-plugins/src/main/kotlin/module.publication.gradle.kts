//import org.gradle.api.publish.maven.MavenPublication
//import org.gradle.api.tasks.bundling.Jar
//import org.gradle.kotlin.dsl.`maven-publish`

plugins {
//    `maven-publish`
//    signing
    id("io.deepmedia.tools.deployer")
}

//publishing {
//    // Configure all publications
//    publications.withType<MavenPublication> {
//        // Stub javadoc.jar artifact
//        artifact(tasks.register("${name}JavadocJar", Jar::class) {
//            archiveClassifier.set("javadoc")
//            archiveAppendix.set(this@withType.name)
//        })
//
//        // Provide artifacts information required by Maven Central
//        pom {
//            name.set("Kotlin Multiplatform fibonacci library")
//            description.set("Dummy library to test deployment to Maven Central")
//            url.set("https://github.com/dambatenne/fibonacci-generator")
//
//            licenses {
//                license {
//                    name.set("MIT")
//                    url.set("https://opensource.org/licenses/MIT")
//                }
//            }
//            developers {
//                developer {
//                    id.set("Ambatenne")
//                    name.set("Denis Ambatenne")
//                    organization.set("none")
//                    organizationUrl.set("https://github.com/dambatenne")
//                }
//            }
//            scm {
//                url.set("https://github.com/dambatenne/fibonacci-generator")
//            }
//        }
//    }
//}
//
//signing {
//    if (project.hasProperty("signing.gnupg.keyName")) {
//        useGpgCmd()
//        sign(publishing.publications)
//    }
//}

deployer {

    content.kotlinComponents()

    projectInfo {
        // Project name. Defaults to rootProject.name
        name.set("Kotlin Multiplatform fibonacci library")
        // Project description. Defaults to rootProject.name
        description.set("Dummy library to test deployment to Maven Central")
        // Project url
        url.set("https://github.com/dambatenne/fibonacci-generator")
        // Package group id. Defaults to project's group
        groupId.set("io.github.dambatenne")
        // Package artifact. Defaults to project's archivesName or project.name
        artifactId.set("fibonacci-generator")
        // Project SCM information. Defaults to project.url
        scm {
            url.set("https://github.com/dambatenne/fibonacci-generator")
        }
        // Licenses. Apache 2.0 and MIT are built-in
        license(apache2)
        license(MIT)
        // Developers
        developer("dambatenne", "dambatenne@gmail.com")
    }

    release {
        // Release version. Defaults to project.version, or AGP configured version for Android projects
        release.version.set("0.0.1")
        // Release description. Defaults to "${project.name} {release.tag}"
        release.description.set("Initial release")
    }

    centralPortalSpec {
        // Take these credentials from the Generate User Token page at https://central.sonatype.com/account
        auth.user.set(secret("OSSRH_USERNAME"))
        auth.password.set(secret("OSSRH_PASSWORD"))
        allowMavenCentralSync = false

        signing.key.set(secret("OSSRH_GPG_SECRET_KEY"))
        signing.password.set(secret("OSSRH_GPG_SECRET_KEY_PASSWORD"))
    }


}
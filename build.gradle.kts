import java.lang.Integer.min

tasks.register("createDirs"){
    doLast{
        (1..1000).forEach {
            File("project$it").mkdirs()
            File("project$it/build.gradle.kts").writeText("plugins{ java }\n dependencies{ implementation(\"org.wildfly.core:wildfly-server:29.0.1.Final\")}\n")
            var upper= min(it,100)
            (1..upper).forEach {
                se->
                File("project$it/build.gradle.kts").appendText("dependencies{ implementation(project(\":project$se\"))}\n")
            }
        }

    }
}

val foo by tasks.registering {
    doLast {
        repeat(Int.MAX_VALUE) {
            println()
            repeat(128) {
                print("$it aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            }
        }


    }
}
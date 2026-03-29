# Tincore
Tincore is a library for the tin minecraft mod ecosystem. It will be required by every mod developed for the tin mod ecosystem.

## for developers
A example mod template is out now!

It is using architectury.

this is how you add this mod to your mod on fabric and neoforge.

Add this block to your build.gradle
````groovy
repositories {
        maven {
            url = uri("https://maven.pkg.github.com/randomusert-s-mods/tincore")
            credentials {
                username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
            }
        }
    }
````

to add the dependency to your mod do this:
````groovy
//fabric
implementation "io.github.randomusert.mods:tincore-fabric:0.1" // Please use the latest version

//neoforge
implementation "io.github.randomusert.mods:tincore-neoforge:0.1" // Please use the latest version
````

## issues
This mod's source can be on 2 places: GitHub and Gitlab

## Tin mod ecosystem
Welcome to tin mod ecosystem. This ecosystem of mods are developed by randomusert on GitHub.

The ecosystem is built with 1 goal in mind: create a unified mod env. take Tincraft and tin utils for example, they will have Compat with each other.

I hope you enjoy the mods put from the tin mods ecosystem.
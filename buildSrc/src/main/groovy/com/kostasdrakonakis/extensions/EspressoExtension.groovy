package com.kostasdrakonakis.extensions


import org.gradle.api.Project

class EspressoExtension {
    private String greeter = "Kostas"
    private String message = "Test Gradle Plugin"

    private Project project

    EspressoExtension(Project project) {
        this.project = project
    }

    String getGreeter() {
        return greeter
    }

    String getMessage() {
        return message
    }

    void setGreeter(String greeter) {
        this.greeter = greeter
    }

    void setMessage(String message) {
        this.message = message
    }
}

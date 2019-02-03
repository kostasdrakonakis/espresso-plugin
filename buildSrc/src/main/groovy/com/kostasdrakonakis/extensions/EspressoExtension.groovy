package com.kostasdrakonakis.extensions;

class EspressoExtension {
    private String greeter = "Kostas"
    private String message = "Test Gradle Plugin"

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

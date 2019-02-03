package com.kostasdrakonakis.tasks

import com.kostasdrakonakis.extensions.EspressoExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jsoup.Jsoup

class PrintEspressoResultsTask extends DefaultTask {

    private EspressoExtension extension

    @TaskAction
    void printEspressoResults() throws Exception {
        println "Hello, ${extension.getGreeter()}"
        println "I have a message for You: ${extension.getMessage()}"
        def doc = Jsoup.parse("index.html")
    }

    void setExtension(EspressoExtension extension) {
        this.extension = extension
    }
}

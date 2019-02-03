package com.kostasdrakonakis.plugins;

import com.kostasdrakonakis.extensions.EspressoExtension
import com.kostasdrakonakis.tasks.PrintEspressoResultsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class EspressoPlugin implements Plugin<Project> {

    public static final String PLUGIN_EXTENSION = "espressoResults"
    public static final String PLUGIN_TASK = "printEspressoResults"

    @Override
    void apply(Project project) {
        EspressoExtension extension =
                project.getExtensions().create(PLUGIN_EXTENSION, EspressoExtension.class)
        PrintEspressoResultsTask task =
                project.getTasks().create(PLUGIN_TASK, PrintEspressoResultsTask.class)
        task.setExtension(extension)
    }
}

package com.kostasdrakonakis.plugins

import com.kostasdrakonakis.extensions.EspressoExtension
import com.kostasdrakonakis.repositories.KostasRepoAction
import com.kostasdrakonakis.tasks.PrintEspressoResultsTask
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler

class EspressoPlugin implements Plugin<Project> {

    public static final String PLUGIN_EXTENSION = "espressoResults"
    public static final String PLUGIN_TASK = "printEspressoResults"
    private static final String ERROR_PLUGIN_REQUIRED = "'com.android.application' or 'com.android.library' plugin required"

    @Override
    void apply(Project project) {
        requireAndroidPlugins(project)
        EspressoExtension extension =
                project.getExtensions().create(PLUGIN_EXTENSION, EspressoExtension.class, project)
        project.getTasks().create(PLUGIN_TASK, PrintEspressoResultsTask.class, extension)
        requireRepo(project)
    }

    static void requireRepo(Project project) {
        project.getRepositories().getMetaClass().kostas = {
            project.getRepositories().maven(new KostasRepoAction())
        }
        print(project)
    }

    private void print(Project project) {
        RepositoryHandler handler = project.getRepositories()
        RepositoryHandler buildScriptHandler = project.getBuildscript().getRepositories()
        println "Repositories size: " + handler.size()
        println "BuildScript Repositories size: " + buildScriptHandler.size()
        handler.forEach({
            println "Repository: " + it.name
        })
        buildScriptHandler.forEach({
            println "BuildScript Repository: " + it.name
        })
    }

    static void requireAndroidPlugins(Project project) {
        Plugin androidApp = project.getPlugins().findPlugin('com.android.application')
        Plugin androidLibrary = project.getPlugins().findPlugin('com.android.library')
        boolean missingAndroid = androidApp == null
        boolean missingLibrary = androidLibrary == null

        if (!missingAndroid && !missingLibrary) {
            throw new GradleException(ERROR_PLUGIN_REQUIRED)
        }
    }
}

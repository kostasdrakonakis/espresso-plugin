package com.kostasdrakonakis.plugins

import com.kostasdrakonakis.repositories.KostasRepository
import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.MavenArtifactRepository

class KostasRepoDetails {
    private Project project

    KostasRepoDetails() {
        
    }

    KostasRepoDetails(Project project) {
        this.project = project
    }

    MavenArtifactRepository kostas() {
        KostasRepository.getInstance(project)
    }
}

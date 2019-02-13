package com.kostasdrakonakis.repositories

import org.gradle.api.Action
import org.gradle.api.artifacts.repositories.MavenArtifactRepository

class KostasRepoAction implements Action<MavenArtifactRepository> {
    @Override
    void execute(MavenArtifactRepository mavenArtifactRepository) {
        mavenArtifactRepository.setUrl(URI.create("http://repo.joblessdomination.com/repository/android-releases/"))
        mavenArtifactRepository.setName("kostas")
    }
}

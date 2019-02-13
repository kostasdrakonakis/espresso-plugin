package com.kostasdrakonakis.repositories

import org.gradle.api.Action
import org.gradle.api.ActionConfiguration
import org.gradle.api.Project
import org.gradle.api.artifacts.ComponentMetadataSupplier
import org.gradle.api.artifacts.ComponentMetadataVersionLister
import org.gradle.api.artifacts.repositories.AuthenticationContainer
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.artifacts.repositories.PasswordCredentials
import org.gradle.api.credentials.Credentials
import org.gradle.api.internal.artifacts.dsl.DefaultRepositoryHandler

class KostasRepository implements MavenArtifactRepository {

    private static MavenArtifactRepository repo
    private URI url
    private String name

    private KostasRepository() {}

    static MavenArtifactRepository getInstance(Project project) {
        if (repo == null) {
            DefaultRepositoryHandler drh = (DefaultRepositoryHandler) project.getRepositories()
            repo = drh.maven(new KostasRepoAction())
        }
        return repo
    }

    @Override
    String getName() {
        return name
    }

    @Override
    void setName(String name) {
        this.name = name
    }

    @Override
    URI getUrl() {
        return url
    }

    @Override
    void setUrl(URI url) {
        this.url = url
    }

    @Override
    void setUrl(Object url) {
        this.url = url as URI
    }

    @Override
    Set<URI> getArtifactUrls() {
        return new HashSet<URI>()
    }

    @Override
    void artifactUrls(Object... urls) {

    }

    @Override
    void setArtifactUrls(Set<URI> urls) {

    }

    @Override
    void setArtifactUrls(Iterable<?> urls) {

    }

    @Override
    void metadataSources(Action<? super MetadataSources> configureAction) {

    }

    @Override
    PasswordCredentials getCredentials() {
        return null
    }

    @Override
    <T extends Credentials> T getCredentials(Class<T> credentialsType) {
        return null
    }

    @Override
    void credentials(Action<? super PasswordCredentials> action) {

    }

    @Override
    <T extends Credentials> void credentials(Class<T> credentialsType, Action<? super T> action) {

    }

    @Override
    void authentication(Action<? super AuthenticationContainer> action) {

    }

    @Override
    AuthenticationContainer getAuthentication() {
        return null
    }

    @Override
    void setMetadataSupplier(Class<? extends ComponentMetadataSupplier> rule) {

    }

    @Override
    void setMetadataSupplier(Class<? extends ComponentMetadataSupplier> rule, Action<? super ActionConfiguration> configureAction) {

    }

    @Override
    void setComponentVersionsLister(Class<? extends ComponentMetadataVersionLister> lister) {

    }

    @Override
    void setComponentVersionsLister(Class<? extends ComponentMetadataVersionLister> lister, Action<? super ActionConfiguration> configureAction) {

    }
}

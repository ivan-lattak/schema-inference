package cz.cuni.mff.dsi.nosql.s13e

import org.gradle.api.Plugin
import org.gradle.api.Project

class UtilsPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        UtilsExtension extension = project.extensions.create('utils', UtilsExtension)
        extension.project = project
    }

}

class UtilsExtension {

    Project project

    Map<String, ?> getPropertiesForProject() {
        String prefix = project.path.substring(1).replace ':', '.'
        Map<String, ?> propsForProject = [:]
        project.properties.each {
            if (it.key.startsWith(prefix)) {
                propsForProject << it
            }
        }
        return propsForProject
    }

}

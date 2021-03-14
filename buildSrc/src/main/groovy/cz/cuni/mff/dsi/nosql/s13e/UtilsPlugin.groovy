package cz.cuni.mff.dsi.nosql.s13e

import org.gradle.api.Plugin
import org.gradle.api.Project

@SuppressWarnings('unused')
class UtilsPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('utils', UtilsExtension, project)
    }

}

class UtilsExtension {

    private final Project project

    UtilsExtension(Project project) {
        this.project = project
    }

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

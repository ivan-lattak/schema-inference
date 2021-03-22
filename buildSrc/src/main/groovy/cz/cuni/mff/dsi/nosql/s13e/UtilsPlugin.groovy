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

    Map<String, ?> getPropertiesForApproach() {
        Map<String, ?> propsForApproach = [:]
        String approachPrefix = project.path.substring(':'.length()) + '.'
        fillFromAll(propsForApproach, approachPrefix)
        fillFromCurrent(propsForApproach, approachPrefix)

        return propsForApproach
    }

    private void fillFromAll(Map<String, Object> properties, String approachPrefix) {
        project.properties.each {
            if (it.key.startsWith('allApproaches.')) {
                def newKey = approachPrefix + it.key.substring('allApproaches.'.length())
                properties[newKey] = it.value
            }
        }
    }

    private void fillFromCurrent(Map<String, Object> properties, String approachPrefix) {
        project.properties.each {
            if (it.key.startsWith(approachPrefix)) {
                properties << it
            }
        }
    }

}

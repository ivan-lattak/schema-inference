package cz.cuni.mff.ksi.nosql.s13e

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

    Map<String, Object> getPropertiesWithPrefix(String prefix) {
        Map<String, Object> propsForApproach = [:]
        String prefixWithDot = prefix.endsWith('.') ? prefix : prefix + '.'

        fillFromAll(propsForApproach, prefixWithDot)
        fillFromCurrent(propsForApproach, prefixWithDot)

        return propsForApproach
    }

    private void fillFromAll(Map<String, Object> properties, String prefix) {
        project.properties.each {
            if (it.key.startsWith('allApproaches.')) {
                def newKey = prefix + it.key.substring('allApproaches.'.length())
                properties[newKey] = it.value
            }
        }
    }

    private void fillFromCurrent(Map<String, Object> properties, String prefix) {
        project.properties.each {
            if (it.key.startsWith(prefix)) {
                properties << it
            }
        }
    }

}

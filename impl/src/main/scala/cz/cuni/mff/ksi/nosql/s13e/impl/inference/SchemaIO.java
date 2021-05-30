package cz.cuni.mff.ksi.nosql.s13e.impl.inference;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class SchemaIO {

    private static final Map<String, Object> options = createOptions();

    public static NoSQLSchema save(NoSQLSchema schema, Path filePath) throws IOException {
        ResourceSet resourceSet = createResourceSet();
        Resource resource = resourceSet.createResource(URI.createFileURI(filePath.toAbsolutePath().toString()));
        resource.getContents().add(schema);
        try (OutputStream outputStream = Files.newOutputStream(filePath)) {
            resource.save(outputStream, options);
        }
        return schema;
    }

    private static ResourceSet createResourceSet() {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(NoSQLSchemaPackage.eNS_URI, NoSQLSchemaPackage.eINSTANCE);
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        return resourceSet;
    }

    private static Map<String, Object> createOptions() {
        Map<String, Object> options = new HashMap<>();
        options.put(XMIResource.OPTION_ENCODING, "UTF-8");
        return Collections.unmodifiableMap(options);
    }

    public static NoSQLSchema save(NoSQLSchema schema, Writer writer) {
        throw new UnsupportedOperationException();
    }

}

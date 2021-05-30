package cz.cuni.mff.ksi.nosql.s13e.impl.inference;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class SchemaIO {

    private static final Map<String, Object> options = createOptions();

    private static Map<String, Object> createOptions() {
        Map<String, Object> options = new HashMap<>();
        options.put(XMIResource.OPTION_ENCODING, "UTF-8");
        return Collections.unmodifiableMap(options);
    }

    public static NoSQLSchema save(NoSQLSchema schema, Path filePath) throws IOException {
        Resource resource = new XMIResourceImpl();
        resource.getContents().add(schema);
        try (OutputStream outputStream = Files.newOutputStream(filePath)) {
            resource.save(outputStream, options);
        }
        return schema;
    }

    public static NoSQLSchema save(NoSQLSchema schema, OutputStream outputStream) throws IOException {
        Resource resource = new XMIResourceImpl();
        resource.getContents().add(schema);
        resource.save(outputStream, options);
        return schema;
    }

    public static NoSQLSchema load(Path filePath) throws IOException {
        Resource resource = new XMIResourceImpl();
        try (InputStream inputStream = Files.newInputStream(filePath)) {
            resource.load(inputStream, options);
        }
        return (NoSQLSchema) resource.getContents().get(0);
    }

    public static NoSQLSchema load(InputStream inputStream) throws IOException {
        Resource resource = new XMIResourceImpl();
        resource.load(inputStream, options);
        return (NoSQLSchema) resource.getContents().get(0);
    }

}

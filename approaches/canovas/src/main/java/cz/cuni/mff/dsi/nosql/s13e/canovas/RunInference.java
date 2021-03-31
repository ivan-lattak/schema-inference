package cz.cuni.mff.dsi.nosql.s13e.canovas;

import jsondiscoverer.JsonSimpleDiscoverer;
import jsondiscoverer.JsonSource;
import jsondiscoverer.util.ModelHelper;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RunInference {

    public static final String PROPERTY_MONGO_HOST = "canovas.mongoHost";
    public static final String PROPERTY_DB_NAME = "canovas.dbName";
    public static final String PROPERTY_COLLECTION_NAME = "canovas.collectionName";
    public static final String PROPERTY_JSON_DIR = "canovas.jsonDir";
    public static final String PROPERTY_OUTPUT_FILE = "canovas.outputFile";

    private static final String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static final String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static final String collectionName = System.getProperty(PROPERTY_COLLECTION_NAME, "articles");
    private static final String jsonDir = System.getProperty(PROPERTY_JSON_DIR, "json");
    private static final String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "schema.xml");

    public static void main(String[] args) throws IOException {
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

        new MongoImporter(mongoHost, dbName, collectionName, jsonDir).importToFile();
        JsonSource source = new JsonSource(collectionName);
        source.addJsonData(null, Files.newBufferedReader(Paths.get(jsonDir).resolve(collectionName + ".json")));

        JsonSimpleDiscoverer discoverer = new JsonSimpleDiscoverer();
        EPackage ePackage = discoverer.discover(source);

        ModelHelper.saveEPackage(ePackage, new File(outputFile));
    }

}

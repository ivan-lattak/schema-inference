package cz.cuni.mff.dsi.nosql.s13e.canovas;

import cz.cuni.mff.dsi.nosql.s13e.canovas.util.MongoImporter;
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

public class Main {

    public static final String PROPERTY_MONGO_HOST = "canovas.mongoHost";
    public static final String PROPERTY_DB_NAME = "canovas.dbName";
    public static final String PROPERTY_COLLECTION_NAME = "canovas.collectionName";
    public static final String PROPERTY_JSON_DIR = "canovas.jsonDir";
    public static final String PROPERTY_OUTPUT_FILE = "canovas.outputFile";

    private static String mongoHost = System.getProperty(PROPERTY_MONGO_HOST, "localhost");
    private static String dbName = System.getProperty(PROPERTY_DB_NAME, "inference");
    private static String collectionName = System.getProperty(PROPERTY_COLLECTION_NAME, "articles");
    private static String jsonDir = System.getProperty(PROPERTY_JSON_DIR, "json");
    private static String outputFile = System.getProperty(PROPERTY_OUTPUT_FILE, "schema.xml");

    public static void main(String[] args) throws IOException {
        parseArgs(args);
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

        new MongoImporter(mongoHost, dbName, collectionName, jsonDir).importToFile();
        JsonSource source = new JsonSource(collectionName);
        source.addJsonData(null, Files.newBufferedReader(Paths.get(jsonDir).resolve(collectionName + ".json")));

        JsonSimpleDiscoverer discoverer = new JsonSimpleDiscoverer();
        EPackage ePackage = discoverer.discover(source);

        ModelHelper.saveEPackage(ePackage, new File(outputFile));
    }

    private static void parseArgs(String[] args) {
        if (args.length == 0) {
            return;
        }
        if (args.length != 5) {
            throw new IllegalArgumentException("Usage: cz.cuni.mff.dsi.nosql.s13e.canovas.Main <mongoHost> <dbName> <collectionName> <jsonDir> <outputFile>");
        }

        mongoHost = args[0];
        dbName = args[1];
        collectionName = args[2];
        jsonDir = args[3];
        outputFile = args[4];
    }

}

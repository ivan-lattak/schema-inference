package cz.cuni.mff.dsi.nosql.s13e.frozza.model;

public class InputParams {

    public final String address;
    public final String port;
    public final String databaseName;
    public final String collectionName;
    @SuppressWarnings("unused")
    public final String userId = "admin";

    public InputParams(String address, String port, String databaseName, String collectionName) {
        this.address = address;
        this.port = port;
        this.databaseName = databaseName;
        this.collectionName = collectionName;
    }
}

/**
 *
 */
package es.um.nosql.s13e.json2dbschema.main.util;


import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * @author dsevilla
 *
 */
public class JSON2RawSchema {
    private static ObjectMapper m = new ObjectMapper();

    public static JsonNode fromJSON(String json) throws JsonProcessingException, IOException {
        return m.readTree(json);
    }
}

/**
 *
 */
package es.um.nosql.s13e.json2dbschema.util.abstractjson.impl.jackson;

import es.um.nosql.s13e.json2dbschema.util.abstractjson.IAJArray;
import org.codehaus.jackson.JsonNode;

/**
 * @author dsevilla
 */
public class JacksonArray extends JacksonElement implements IAJArray {
    public JacksonArray(JsonNode val) {
        super(val);
    }
}

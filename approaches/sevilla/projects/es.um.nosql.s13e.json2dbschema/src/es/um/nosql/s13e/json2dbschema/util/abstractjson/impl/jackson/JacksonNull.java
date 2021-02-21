/**
 *
 */
package es.um.nosql.s13e.json2dbschema.util.abstractjson.impl.jackson;

import es.um.nosql.s13e.json2dbschema.util.abstractjson.IAJNull;
import org.codehaus.jackson.JsonNode;

/**
 * @author dsevilla
 */
public class JacksonNull extends JacksonElement implements IAJNull {
    public JacksonNull(JsonNode val) {
        super(val);
    }
}

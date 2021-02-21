/**
 *
 */
package es.um.nosql.s13e.json2dbschema.util.abstractjson.impl.jackson;

import es.um.nosql.s13e.json2dbschema.util.abstractjson.IAJTextual;
import org.codehaus.jackson.JsonNode;

/**
 * @author dsevilla
 */
public class JacksonTextual extends JacksonElement implements IAJTextual {
    public JacksonTextual(JsonNode val) {
        super(val);
    }
}

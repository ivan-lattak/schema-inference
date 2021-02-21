/**
 *
 */
package es.um.nosql.s13e.json2dbschema.util.abstractjson.impl.jackson;

import es.um.nosql.s13e.json2dbschema.util.abstractjson.IAJBoolean;
import org.codehaus.jackson.JsonNode;

/**
 * @author dsevilla
 */
public class JacksonBoolean extends JacksonElement implements IAJBoolean {
    public JacksonBoolean(JsonNode val) {
        super(val);
    }
}

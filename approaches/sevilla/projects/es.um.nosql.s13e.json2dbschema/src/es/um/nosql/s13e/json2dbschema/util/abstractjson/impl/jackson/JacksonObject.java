/**
 *
 */
package es.um.nosql.s13e.json2dbschema.util.abstractjson.impl.jackson;

import es.um.nosql.s13e.json2dbschema.util.abstractjson.IAJObject;
import org.codehaus.jackson.JsonNode;

/**
 * @author dsevilla
 */
public class JacksonObject extends JacksonElement implements IAJObject {
    public JacksonObject(JsonNode val) {
        super(val);
    }
}

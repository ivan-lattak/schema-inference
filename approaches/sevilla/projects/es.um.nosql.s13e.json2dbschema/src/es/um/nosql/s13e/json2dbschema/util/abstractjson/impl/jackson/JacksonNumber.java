/**
 *
 */
package es.um.nosql.s13e.json2dbschema.util.abstractjson.impl.jackson;

import es.um.nosql.s13e.json2dbschema.util.abstractjson.IAJNumber;
import org.codehaus.jackson.JsonNode;

/**
 * @author dsevilla
 */
public class JacksonNumber extends JacksonElement implements IAJNumber {
    public JacksonNumber(JsonNode val) {
        super(val);
    }
}

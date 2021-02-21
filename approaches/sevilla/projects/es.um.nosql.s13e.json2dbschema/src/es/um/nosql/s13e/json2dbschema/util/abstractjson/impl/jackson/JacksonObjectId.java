/**
 *
 */
package es.um.nosql.s13e.json2dbschema.util.abstractjson.impl.jackson;

import es.um.nosql.s13e.json2dbschema.util.abstractjson.IAJObjectId;
import org.codehaus.jackson.JsonNode;

public class JacksonObjectId extends JacksonElement implements IAJObjectId {
    public JacksonObjectId(JsonNode val) {
        super(val);
    }
}

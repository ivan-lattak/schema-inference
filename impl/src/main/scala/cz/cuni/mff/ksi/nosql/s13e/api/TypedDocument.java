package cz.cuni.mff.ksi.nosql.s13e.api;

import play.api.libs.json.JsValue;

public interface TypedDocument {

    String getTypeName();

    JsValue getDocument();

}

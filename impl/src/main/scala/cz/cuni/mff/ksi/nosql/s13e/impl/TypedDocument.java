package cz.cuni.mff.ksi.nosql.s13e.impl;

import play.api.libs.json.JsObject;

import java.io.Serializable;

/**
 * A simple interface representing a JSON document with its type name, usually inferred from the name of the enclosing
 * collection.
 */
public interface TypedDocument extends Serializable {

    String getTypeName();

    JsObject getDocument();

}

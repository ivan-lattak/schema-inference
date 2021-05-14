package cz.cuni.mff.ksi.nosql.s13e.impl;

import play.api.libs.json.JsObject;

import java.io.Serializable;

public interface TypedDocument extends Serializable {

    String getTypeName();

    JsObject getDocument();

}

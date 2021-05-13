package cz.cuni.mff.ksi.nosql.s13e.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface TypedDocument {

    String getTypeName();

    ObjectNode getDocument();

}

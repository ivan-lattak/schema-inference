/**
 * This package contains the entry point of the API of the schema inference approach implementation. There are three
 * classes/interfaces:
 *
 * <ul>
 *     <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.SchemaInference} - represents the main entry point of the API</li>
 *     <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.DataLoader} - provided for easy extension of approach to handle other
 *     database systems</li>
 *     <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.TypedDocument} - represents a JSON document with its type name</li>
 * </ul>
 */
@ParametersAreNonnullByDefault
@ReturnValuesAreNonnullByDefault
@FieldsAreNonnullByDefault
package cz.cuni.mff.ksi.nosql.s13e.impl;

import cz.cuni.mff.ksi.nosql.s13e.utils.annotation.FieldsAreNonnullByDefault;
import cz.cuni.mff.ksi.nosql.s13e.utils.annotation.ReturnValuesAreNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Union Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnionType#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getUnionType()
 * @model
 * @generated
 */
public interface UnionType extends Type {
    /**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.SingleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @model containment="true" lower="2"
	 * @generated
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getUnionType_Types()
	 */
    EList<SingleType> getTypes();

} // UnionType

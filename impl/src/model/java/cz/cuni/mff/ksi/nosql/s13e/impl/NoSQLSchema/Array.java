/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array#getElementType <em>Element Type</em>}</li>
 * </ul>
 *
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getArray()
 * @model
 * @generated
 */
public interface Array extends ComplexType {
    /**
	 * Returns the value of the '<em><b>Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Element Type</em>' containment reference.
	 * @model containment="true" required="true"
	 * @generated
	 * @see #setElementType(Type)
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getArray_ElementType()
	 */
	Type getElementType();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array#getElementType <em>Element Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Element Type</em>' containment reference.
	 * @generated
	 * @see #getElementType()
	 */
	void setElementType(Type value);

} // Array

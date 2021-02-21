/**
 *
 */
package es.um.nosql.s13e.NoSQLSchema;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.Attribute#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Property {
    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Type</em>' containment reference.
     * @model containment="true" required="true"
     * @generated
     * @see #setType(DataType)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getAttribute_Type()
     */
    DataType getType();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.Attribute#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @generated
     * @see #getType()
     */
    void setType(DataType value);

} // Attribute

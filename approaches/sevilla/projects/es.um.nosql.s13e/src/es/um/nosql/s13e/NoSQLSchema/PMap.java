/**
 *
 */
package es.um.nosql.s13e.NoSQLSchema;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PMap</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.PMap#getKeyType <em>Key Type</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.PMap#getValueType <em>Value Type</em>}</li>
 * </ul>
 *
 * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getPMap()
 * @model
 * @generated
 */
public interface PMap extends DataType {
    /**
     * Returns the value of the '<em><b>Key Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Key Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Key Type</em>' containment reference.
     * @model containment="true"
     * @generated
     * @see #setKeyType(PrimitiveType)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getPMap_KeyType()
     */
    PrimitiveType getKeyType();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.PMap#getKeyType <em>Key Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Key Type</em>' containment reference.
     * @generated
     * @see #getKeyType()
     */
    void setKeyType(PrimitiveType value);

    /**
     * Returns the value of the '<em><b>Value Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Value Type</em>' containment reference.
     * @model containment="true"
     * @generated
     * @see #setValueType(DataType)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getPMap_ValueType()
     */
    DataType getValueType();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.PMap#getValueType <em>Value Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Value Type</em>' containment reference.
     * @generated
     * @see #getValueType()
     */
    void setValueType(DataType value);

} // PMap

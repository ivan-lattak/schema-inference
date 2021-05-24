/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference#getTarget <em>Target</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference#getOriginalType <em>Original Type</em>}</li>
 * </ul>
 *
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntityReference()
 * @model
 * @generated
 */
public interface EntityReference extends SingleType {
    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Target</em>' reference.
     * @model required="true"
     * @generated
     * @see #setTarget(Entity)
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntityReference_Target()
     */
    Entity getTarget();

    /**
     * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Target</em>' reference.
     * @generated
     * @see #getTarget()
     */
    void setTarget(Entity value);

    /**
     * Returns the value of the '<em><b>Original Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Original Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Original Type</em>' containment reference.
     * @model containment="true"
     * @generated
     * @see #setOriginalType(PrimitiveType)
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntityReference_OriginalType()
     */
    PrimitiveType getOriginalType();

    /**
     * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference#getOriginalType <em>Original Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Original Type</em>' containment reference.
     * @generated
     * @see #getOriginalType()
     */
    void setOriginalType(PrimitiveType value);

} // EntityReference

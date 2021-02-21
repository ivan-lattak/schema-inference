/**
 *
 */
package es.um.nosql.s13e.NoSQLSchema;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.Reference#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.Reference#getRefsTo <em>Refs To</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.Reference#getOriginalType <em>Original Type</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.Reference#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends Association {
    /**
     * Returns the value of the '<em><b>Opposite</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Opposite</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Opposite</em>' reference.
     * @model
     * @generated
     * @see #setOpposite(Reference)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getReference_Opposite()
     */
    Reference getOpposite();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.Reference#getOpposite <em>Opposite</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Opposite</em>' reference.
     * @generated
     * @see #getOpposite()
     */
    void setOpposite(Reference value);

    /**
     * Returns the value of the '<em><b>Refs To</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Refs To</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Refs To</em>' reference.
     * @model required="true"
     * @generated
     * @see #setRefsTo(EntityType)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getReference_RefsTo()
     */
    EntityType getRefsTo();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.Reference#getRefsTo <em>Refs To</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Refs To</em>' reference.
     * @generated
     * @see #getRefsTo()
     */
    void setRefsTo(EntityType value);

    /**
     * Returns the value of the '<em><b>Original Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Original Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Original Type</em>' attribute.
     * @model
     * @generated
     * @see #setOriginalType(String)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getReference_OriginalType()
     */
    String getOriginalType();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.Reference#getOriginalType <em>Original Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Original Type</em>' attribute.
     * @generated
     * @see #getOriginalType()
     */
    void setOriginalType(String value);

    /**
     * Returns the value of the '<em><b>Features</b></em>' reference list.
     * The list contents are of type {@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Features</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Features</em>' reference list.
     * @model
     * @generated
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getReference_Features()
     */
    EList<StructuralVariation> getFeatures();

} // Reference

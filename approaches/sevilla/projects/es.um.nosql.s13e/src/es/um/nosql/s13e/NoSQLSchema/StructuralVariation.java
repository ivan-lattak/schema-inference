/**
 *
 */
package es.um.nosql.s13e.NoSQLSchema;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Variation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getVariationId <em>Variation Id</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getProperties <em>Properties</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getCount <em>Count</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getFirstTimestamp <em>First Timestamp</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getLastTimestamp <em>Last Timestamp</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getContainer <em>Container</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getKey <em>Key</em>}</li>
 * </ul>
 *
 * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getStructuralVariation()
 * @model
 * @generated
 */
public interface StructuralVariation extends EObject {
    /**
     * Returns the value of the '<em><b>Variation Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Variation Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Variation Id</em>' attribute.
     * @model required="true"
     * @generated
     * @see #setVariationId(int)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getStructuralVariation_VariationId()
     */
    int getVariationId();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getVariationId <em>Variation Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Variation Id</em>' attribute.
     * @generated
     * @see #getVariationId()
     */
    void setVariationId(int value);

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link es.um.nosql.s13e.NoSQLSchema.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @model containment="true" required="true"
     * @generated
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getStructuralVariation_Properties()
     */
    EList<Property> getProperties();

    /**
     * Returns the value of the '<em><b>Count</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Count</em>' attribute.
     * @model default="0"
     * @generated
     * @see #setCount(long)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getStructuralVariation_Count()
     */
    long getCount();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getCount <em>Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Count</em>' attribute.
     * @generated
     * @see #getCount()
     */
    void setCount(long value);

    /**
     * Returns the value of the '<em><b>First Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Timestamp</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>First Timestamp</em>' attribute.
     * @model
     * @generated
     * @see #setFirstTimestamp(long)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getStructuralVariation_FirstTimestamp()
     */
    long getFirstTimestamp();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getFirstTimestamp <em>First Timestamp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>First Timestamp</em>' attribute.
     * @generated
     * @see #getFirstTimestamp()
     */
    void setFirstTimestamp(long value);

    /**
     * Returns the value of the '<em><b>Last Timestamp</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Timestamp</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Last Timestamp</em>' attribute.
     * @model
     * @generated
     * @see #setLastTimestamp(long)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getStructuralVariation_LastTimestamp()
     */
    long getLastTimestamp();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getLastTimestamp <em>Last Timestamp</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Last Timestamp</em>' attribute.
     * @generated
     * @see #getLastTimestamp()
     */
    void setLastTimestamp(long value);

    /**
     * Returns the value of the '<em><b>Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link es.um.nosql.s13e.NoSQLSchema.SchemaType#getVariations <em>Variations</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Container</em>' container reference.
     * @model opposite="variations" required="true" transient="false"
     * @generated
     * @see #setContainer(SchemaType)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getStructuralVariation_Container()
     * @see es.um.nosql.s13e.NoSQLSchema.SchemaType#getVariations
     */
    SchemaType getContainer();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.StructuralVariation#getContainer <em>Container</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Container</em>' container reference.
     * @generated
     * @see #getContainer()
     */
    void setContainer(SchemaType value);

    /**
     * Returns the value of the '<em><b>Key</b></em>' reference list.
     * The list contents are of type {@link es.um.nosql.s13e.NoSQLSchema.Property}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Key</em>' reference list.
     * @model
     * @generated
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getStructuralVariation_Key()
     */
    EList<Property> getKey();

} // StructuralVariation

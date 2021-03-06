/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#isRoot <em>Root</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getAdditionalCount <em>Additional Count</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getProperties <em>Properties</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getAggregates <em>Aggregates</em>}</li>
 * </ul>
 *
 * @model
 * @generated
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntityVersion()
 */
public interface EntityVersion extends EObject {
    /**
     * Returns the value of the '<em><b>Root</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Root</em>' attribute.
     * @model default="false"
     * @generated
     * @see #setRoot(boolean)
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntityVersion_Root()
     */
    boolean isRoot();

    /**
     * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#isRoot <em>Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Root</em>' attribute.
     * @generated
     * @see #isRoot()
     */
    void setRoot(boolean value);

    /**
     * Returns the value of the '<em><b>Additional Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Additional Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Additional Count</em>' attribute.
     * @see #setAdditionalCount(int)
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntityVersion_AdditionalCount()
     * @model required="true"
     * @generated
     */
    int getAdditionalCount();

    /**
     * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getAdditionalCount <em>Additional Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Additional Count</em>' attribute.
     * @generated
     * @see #getAdditionalCount()
     */
    void setAdditionalCount(int value);

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntityVersion_Properties()
     * @model containment="true"
     * @generated
	 */
    EList<Property> getProperties();

    /**
     * Returns the value of the '<em><b>Aggregates</b></em>' reference list.
     * The list contents are of type {@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate}.
     * It is bidirectional and its opposite is '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aggregates</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aggregates</em>' reference list.
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntityVersion_Aggregates()
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate#getTarget
     * @model opposite="target" ordered="false"
     * @generated
	 */
    EList<Aggregate> getAggregates();

} // EntityVersion

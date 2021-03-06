/**
 *
 */
package es.um.nosql.s13e.NoSQLSchema;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>No SQL Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.NoSQLSchema#getName <em>Name</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.NoSQLSchema#getEntities <em>Entities</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.NoSQLSchema#getRelationships <em>Relationships</em>}</li>
 * </ul>
 *
 * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getNoSQLSchema()
 * @model
 * @generated
 */
public interface NoSQLSchema extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @model required="true"
     * @generated
     * @see #setName(String)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getNoSQLSchema_Name()
     */
    String getName();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.NoSQLSchema#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Name</em>' attribute.
     * @generated
     * @see #getName()
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
     * The list contents are of type {@link es.um.nosql.s13e.NoSQLSchema.EntityType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Entities</em>' containment reference list.
     * @model containment="true"
     * @generated
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getNoSQLSchema_Entities()
     */
    EList<EntityType> getEntities();

    /**
     * Returns the value of the '<em><b>Relationships</b></em>' containment reference list.
     * The list contents are of type {@link es.um.nosql.s13e.NoSQLSchema.RelationshipType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Relationships</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Relationships</em>' containment reference list.
     * @model containment="true"
     * @generated
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getNoSQLSchema_Relationships()
     */
    EList<RelationshipType> getRelationships();

} // NoSQLSchema

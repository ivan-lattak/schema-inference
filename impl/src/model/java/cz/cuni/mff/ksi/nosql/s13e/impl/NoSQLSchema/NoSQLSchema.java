/**
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import java.lang.String;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>No SQL Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema#getName <em>Name</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema#getEntities <em>Entities</em>}</li>
 * </ul>
 *
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getNoSQLSchema()
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
	 * @model id="true" required="true"
	 * @generated
	 * @see #setName(String)
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getNoSQLSchema_Name()
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getNoSQLSchema_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getEntities();

} // NoSQLSchema

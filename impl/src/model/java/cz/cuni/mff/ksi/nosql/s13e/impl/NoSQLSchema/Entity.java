/**
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import java.lang.String;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#getName <em>Name</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#isRoot <em>Root</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#getVersions <em>Versions</em>}</li>
 * </ul>
 *
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntity_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' attribute.
	 * @see #setRoot(boolean)
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntity_Root()
	 * @model default="false"
	 * @generated
	 */
	boolean isRoot();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#isRoot <em>Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' attribute.
	 * @see #isRoot()
	 * @generated
	 */
	void setRoot(boolean value);

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Versions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @model containment="true" required="true"
	 * @generated
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getEntity_Versions()
	 */
	EList<EntityVersion> getVersions();

} // Entity

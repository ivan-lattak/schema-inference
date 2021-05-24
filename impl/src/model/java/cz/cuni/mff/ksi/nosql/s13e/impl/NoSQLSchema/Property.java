/**
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema;

import org.eclipse.emf.ecore.EObject;

import java.lang.String;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#getName <em>Name</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#isOptional <em>Optional</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends EObject {
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
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getProperty_Name()
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getProperty_Optional()
	 * @model default="false"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(Type)
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#getProperty_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // Property

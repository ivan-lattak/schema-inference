/**
 *
 */
package es.um.nosql.s13e.NoSQLSchema;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.Property#getName <em>Name</em>}</li>
 *   <li>{@link es.um.nosql.s13e.NoSQLSchema.Property#isOptional <em>Optional</em>}</li>
 * </ul>
 *
 * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getProperty()
 * @model abstract="true"
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
     * @model required="true"
     * @generated
     * @see #setName(String)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getProperty_Name()
     */
    String getName();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.Property#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Name</em>' attribute.
     * @generated
     * @see #getName()
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
     *
     * @return the value of the '<em>Optional</em>' attribute.
     * @model default="false"
     * @generated
     * @see #setOptional(boolean)
     * @see es.um.nosql.s13e.NoSQLSchema.NoSQLSchemaPackage#getProperty_Optional()
     */
    boolean isOptional();

    /**
     * Sets the value of the '{@link es.um.nosql.s13e.NoSQLSchema.Property#isOptional <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Optional</em>' attribute.
     * @generated
     * @see #isOptional()
     */
    void setOptional(boolean value);

} // Property

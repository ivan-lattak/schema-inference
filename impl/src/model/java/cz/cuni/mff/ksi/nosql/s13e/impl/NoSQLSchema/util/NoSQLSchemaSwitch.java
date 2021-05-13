/**
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.util;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage
 * @generated
 */
public class NoSQLSchemaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NoSQLSchemaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoSQLSchemaSwitch() {
		if (modelPackage == null) {
			modelPackage = NoSQLSchemaPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case NoSQLSchemaPackage.NO_SQL_SCHEMA: {
				NoSQLSchema noSQLSchema = (NoSQLSchema) theEObject;
				T result = caseNoSQLSchema(noSQLSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.ENTITY: {
				Entity entity = (Entity) theEObject;
				T result = caseEntity(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.ENTITY_VERSION: {
				EntityVersion entityVersion = (EntityVersion) theEObject;
				T result = caseEntityVersion(entityVersion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.PROPERTY: {
				Property property = (Property) theEObject;
				T result = caseProperty(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.TYPE: {
				Type type = (Type) theEObject;
				T result = caseType(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.UNION_TYPE: {
				UnionType unionType = (UnionType) theEObject;
				T result = caseUnionType(unionType);
				if (result == null) result = caseType(unionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.SINGLE_TYPE: {
				SingleType singleType = (SingleType) theEObject;
				T result = caseSingleType(singleType);
				if (result == null) result = caseType(singleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.ENTITY_REFERENCE: {
				EntityReference entityReference = (EntityReference) theEObject;
				T result = caseEntityReference(entityReference);
				if (result == null) result = caseSingleType(entityReference);
				if (result == null) result = caseType(entityReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.UNKNOWN_TYPE: {
				UnknownType unknownType = (UnknownType) theEObject;
				T result = caseUnknownType(unknownType);
				if (result == null) result = caseSingleType(unknownType);
				if (result == null) result = caseType(unknownType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.COMPLEX_TYPE: {
				ComplexType complexType = (ComplexType) theEObject;
				T result = caseComplexType(complexType);
				if (result == null) result = caseSingleType(complexType);
				if (result == null) result = caseType(complexType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.ARRAY: {
				Array array = (Array) theEObject;
				T result = caseArray(array);
				if (result == null) result = caseComplexType(array);
				if (result == null) result = caseSingleType(array);
				if (result == null) result = caseType(array);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.AGGREGATE: {
				Aggregate aggregate = (Aggregate) theEObject;
				T result = caseAggregate(aggregate);
				if (result == null) result = caseComplexType(aggregate);
				if (result == null) result = caseSingleType(aggregate);
				if (result == null) result = caseType(aggregate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType) theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseSingleType(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.BOOLEAN: {
				cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean boolean_ = (cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean) theEObject;
				T result = caseBoolean(boolean_);
				if (result == null) result = casePrimitiveType(boolean_);
				if (result == null) result = caseSingleType(boolean_);
				if (result == null) result = caseType(boolean_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.NUMBER: {
				cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number number = (cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number) theEObject;
				T result = caseNumber(number);
				if (result == null) result = casePrimitiveType(number);
				if (result == null) result = caseSingleType(number);
				if (result == null) result = caseType(number);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NoSQLSchemaPackage.STRING: {
				cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String string = (cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String) theEObject;
				T result = caseString(string);
				if (result == null) result = casePrimitiveType(string);
				if (result == null) result = caseSingleType(string);
				if (result == null) result = caseType(string);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No SQL Schema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No SQL Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoSQLSchema(NoSQLSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityVersion(EntityVersion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Union Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Union Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnionType(UnionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleType(SingleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityReference(EntityReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownType(UnknownType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexType(ComplexType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArray(Array object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregate(Aggregate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolean(cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumber(cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseString(cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //NoSQLSchemaSwitch

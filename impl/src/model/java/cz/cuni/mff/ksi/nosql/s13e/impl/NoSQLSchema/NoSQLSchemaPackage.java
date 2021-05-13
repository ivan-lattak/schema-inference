/**
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import java.lang.String;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaFactory
 * @model kind="package"
 * @generated
 */
public interface NoSQLSchemaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "NoSQLSchema";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ksi.mff.cuni.cz/NoSQLSchema";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "NoSQLSchema";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NoSQLSchemaPackage eINSTANCE = cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl.init();

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaImpl <em>No SQL Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getNoSQLSchema()
	 * @generated
	 */
	int NO_SQL_SCHEMA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_SQL_SCHEMA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_SQL_SCHEMA__ENTITIES = 1;

	/**
	 * The number of structural features of the '<em>No SQL Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_SQL_SCHEMA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>No SQL Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_SQL_SCHEMA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ROOT = 1;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__VERSIONS = 2;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl <em>Entity Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getEntityVersion()
	 * @generated
	 */
	int ENTITY_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_VERSION__ID = 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_VERSION__COUNT = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_VERSION__PROPERTIES = 2;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_VERSION__ENTITY = 3;

	/**
	 * The number of structural features of the '<em>Entity Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_VERSION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Entity Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_VERSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.PropertyImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OPTIONAL = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.TypeImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 4;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnionTypeImpl <em>Union Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnionTypeImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getUnionType()
	 * @generated
	 */
	int UNION_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__TYPES = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Union Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Union Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.SingleTypeImpl <em>Single Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.SingleTypeImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getSingleType()
	 * @generated
	 */
	int SINGLE_TYPE = 6;

	/**
	 * The number of structural features of the '<em>Single Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Single Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityReferenceImpl <em>Entity Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityReferenceImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getEntityReference()
	 * @generated
	 */
	int ENTITY_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REFERENCE__TARGET = SINGLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REFERENCE__ORIGINAL_TYPE = SINGLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entity Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REFERENCE_FEATURE_COUNT = SINGLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Entity Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_REFERENCE_OPERATION_COUNT = SINGLE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnknownTypeImpl <em>Unknown Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnknownTypeImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getUnknownType()
	 * @generated
	 */
	int UNKNOWN_TYPE = 8;

	/**
	 * The number of structural features of the '<em>Unknown Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_FEATURE_COUNT = SINGLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unknown Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_TYPE_OPERATION_COUNT = SINGLE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ComplexTypeImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getComplexType()
	 * @generated
	 */
	int COMPLEX_TYPE = 9;

	/**
	 * The number of structural features of the '<em>Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_FEATURE_COUNT = SINGLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_OPERATION_COUNT = SINGLE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ArrayImpl <em>Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ArrayImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getArray()
	 * @generated
	 */
	int ARRAY = 10;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY__ELEMENT_TYPE = COMPLEX_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_FEATURE_COUNT = COMPLEX_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_OPERATION_COUNT = COMPLEX_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.AggregateImpl <em>Aggregate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.AggregateImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getAggregate()
	 * @generated
	 */
	int AGGREGATE = 11;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE__TARGET = COMPLEX_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aggregate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_FEATURE_COUNT = COMPLEX_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Aggregate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_OPERATION_COUNT = COMPLEX_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.PrimitiveTypeImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 12;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = SINGLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = SINGLE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.BooleanImpl <em>Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.BooleanImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 13;

	/**
	 * The number of structural features of the '<em>Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NumberImpl <em>Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NumberImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getNumber()
	 * @generated
	 */
	int NUMBER = 14;

	/**
	 * The number of structural features of the '<em>Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.StringImpl <em>String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.StringImpl
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getString()
	 * @generated
	 */
	int STRING = 15;

	/**
	 * The number of structural features of the '<em>String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema <em>No SQL Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No SQL Schema</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema
	 * @generated
	 */
	EClass getNoSQLSchema();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema#getName()
	 * @see #getNoSQLSchema()
	 * @generated
	 */
	EAttribute getNoSQLSchema_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema#getEntities()
	 * @see #getNoSQLSchema()
	 * @generated
	 */
	EReference getNoSQLSchema_Entities();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#getName()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Name();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#isRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#isRoot()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Root();

	/**
	 * Returns the meta object for the containment reference list '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity#getVersions()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Versions();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion <em>Entity Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Version</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion
	 * @generated
	 */
	EClass getEntityVersion();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getId()
	 * @see #getEntityVersion()
	 * @generated
	 */
	EAttribute getEntityVersion_Id();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getCount()
	 * @see #getEntityVersion()
	 * @generated
	 */
	EAttribute getEntityVersion_Count();

	/**
	 * Returns the meta object for the containment reference list '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getProperties()
	 * @see #getEntityVersion()
	 * @generated
	 */
	EReference getEntityVersion_Properties();

	/**
	 * Returns the meta object for the container reference '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entity</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion#getEntity()
	 * @see #getEntityVersion()
	 * @generated
	 */
	EReference getEntityVersion_Entity();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#isOptional()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Optional();

	/**
	 * Returns the meta object for the containment reference '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Type();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnionType <em>Union Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnionType
	 * @generated
	 */
	EClass getUnionType();

	/**
	 * Returns the meta object for the containment reference list '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnionType#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnionType#getTypes()
	 * @see #getUnionType()
	 * @generated
	 */
	EReference getUnionType_Types();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.SingleType <em>Single Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.SingleType
	 * @generated
	 */
	EClass getSingleType();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference <em>Entity Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Reference</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference
	 * @generated
	 */
	EClass getEntityReference();

	/**
	 * Returns the meta object for the reference '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference#getTarget()
	 * @see #getEntityReference()
	 * @generated
	 */
	EReference getEntityReference_Target();

	/**
	 * Returns the meta object for the reference '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference#getOriginalType <em>Original Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference#getOriginalType()
	 * @see #getEntityReference()
	 * @generated
	 */
	EReference getEntityReference_OriginalType();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnknownType <em>Unknown Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnknownType
	 * @generated
	 */
	EClass getUnknownType();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.ComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.ComplexType
	 * @generated
	 */
	EClass getComplexType();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array
	 * @generated
	 */
	EClass getArray();

	/**
	 * Returns the meta object for the containment reference '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array#getElementType()
	 * @see #getArray()
	 * @generated
	 */
	EReference getArray_ElementType();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate <em>Aggregate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregate</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate
	 * @generated
	 */
	EClass getAggregate();

	/**
	 * Returns the meta object for the reference '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate#getTarget()
	 * @see #getAggregate()
	 * @generated
	 */
	EReference getAggregate_Target();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean
	 * @generated
	 */
	EClass getBoolean();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number
	 * @generated
	 */
	EClass getNumber();

	/**
	 * Returns the meta object for class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String</em>'.
	 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String
	 * @generated
	 */
	EClass getString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NoSQLSchemaFactory getNoSQLSchemaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaImpl <em>No SQL Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getNoSQLSchema()
		 * @generated
		 */
		EClass NO_SQL_SCHEMA = eINSTANCE.getNoSQLSchema();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NO_SQL_SCHEMA__NAME = eINSTANCE.getNoSQLSchema_Name();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NO_SQL_SCHEMA__ENTITIES = eINSTANCE.getNoSQLSchema_Entities();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__ROOT = eINSTANCE.getEntity_Root();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__VERSIONS = eINSTANCE.getEntity_Versions();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl <em>Entity Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getEntityVersion()
		 * @generated
		 */
		EClass ENTITY_VERSION = eINSTANCE.getEntityVersion();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_VERSION__ID = eINSTANCE.getEntityVersion_Id();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_VERSION__COUNT = eINSTANCE.getEntityVersion_Count();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_VERSION__PROPERTIES = eINSTANCE.getEntityVersion_Properties();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_VERSION__ENTITY = eINSTANCE.getEntityVersion_Entity();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.PropertyImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__OPTIONAL = eINSTANCE.getProperty_Optional();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.TypeImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnionTypeImpl <em>Union Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnionTypeImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getUnionType()
		 * @generated
		 */
		EClass UNION_TYPE = eINSTANCE.getUnionType();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNION_TYPE__TYPES = eINSTANCE.getUnionType_Types();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.SingleTypeImpl <em>Single Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.SingleTypeImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getSingleType()
		 * @generated
		 */
		EClass SINGLE_TYPE = eINSTANCE.getSingleType();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityReferenceImpl <em>Entity Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityReferenceImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getEntityReference()
		 * @generated
		 */
		EClass ENTITY_REFERENCE = eINSTANCE.getEntityReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_REFERENCE__TARGET = eINSTANCE.getEntityReference_Target();

		/**
		 * The meta object literal for the '<em><b>Original Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_REFERENCE__ORIGINAL_TYPE = eINSTANCE.getEntityReference_OriginalType();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnknownTypeImpl <em>Unknown Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnknownTypeImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getUnknownType()
		 * @generated
		 */
		EClass UNKNOWN_TYPE = eINSTANCE.getUnknownType();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ComplexTypeImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getComplexType()
		 * @generated
		 */
		EClass COMPLEX_TYPE = eINSTANCE.getComplexType();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ArrayImpl <em>Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ArrayImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getArray()
		 * @generated
		 */
		EClass ARRAY = eINSTANCE.getArray();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY__ELEMENT_TYPE = eINSTANCE.getArray_ElementType();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.AggregateImpl <em>Aggregate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.AggregateImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getAggregate()
		 * @generated
		 */
		EClass AGGREGATE = eINSTANCE.getAggregate();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATE__TARGET = eINSTANCE.getAggregate_Target();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.PrimitiveTypeImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.BooleanImpl <em>Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.BooleanImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getBoolean()
		 * @generated
		 */
		EClass BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NumberImpl <em>Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NumberImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getNumber()
		 * @generated
		 */
		EClass NUMBER = eINSTANCE.getNumber();

		/**
		 * The meta object literal for the '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.StringImpl <em>String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.StringImpl
		 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.NoSQLSchemaPackageImpl#getString()
		 * @generated
		 */
		EClass STRING = eINSTANCE.getString();

	}

} //NoSQLSchemaPackage

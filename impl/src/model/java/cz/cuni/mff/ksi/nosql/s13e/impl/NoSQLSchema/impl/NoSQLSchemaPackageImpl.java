/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.*;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NoSQLSchemaPackageImpl extends EPackageImpl implements NoSQLSchemaPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass noSQLSchemaEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass entityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass entityVersionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass propertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass singleTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass entityReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unknownTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass complexTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass arrayEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass aggregateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass booleanEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass numberEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private NoSQLSchemaPackageImpl() {
        super(eNS_URI, NoSQLSchemaFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>This method is used to initialize {@link NoSQLSchemaPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static NoSQLSchemaPackage init() {
        if (isInited) return (NoSQLSchemaPackage) EPackage.Registry.INSTANCE.getEPackage(NoSQLSchemaPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredNoSQLSchemaPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        NoSQLSchemaPackageImpl theNoSQLSchemaPackage = registeredNoSQLSchemaPackage instanceof NoSQLSchemaPackageImpl ? (NoSQLSchemaPackageImpl) registeredNoSQLSchemaPackage : new NoSQLSchemaPackageImpl();

        isInited = true;

        // Create package meta-data objects
        theNoSQLSchemaPackage.createPackageContents();

        // Initialize created meta-data
        theNoSQLSchemaPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theNoSQLSchemaPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(NoSQLSchemaPackage.eNS_URI, theNoSQLSchemaPackage);
        return theNoSQLSchemaPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNoSQLSchema() {
        return noSQLSchemaEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNoSQLSchema_Name() {
        return (EAttribute) noSQLSchemaEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNoSQLSchema_Entities() {
        return (EReference) noSQLSchemaEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEntity() {
        return entityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEntity_Name() {
        return (EAttribute) entityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEntity_Root() {
        return (EAttribute) entityEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEntity_Flattened() {
        return (EAttribute) entityEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntity_Versions() {
        return (EReference) entityEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEntityVersion() {
        return entityVersionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEntityVersion_AdditionalCount() {
        return (EAttribute) entityVersionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntityVersion_Properties() {
        return (EReference) entityVersionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntityVersion_Aggregates() {
        return (EReference) entityVersionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProperty() {
        return propertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProperty_Name() {
        return (EAttribute) propertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProperty_Optional() {
        return (EAttribute) propertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProperty_Type() {
        return (EReference) propertyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getType() {
        return typeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUnionType() {
        return unionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUnionType_Types() {
        return (EReference) unionTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSingleType() {
        return singleTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEntityReference() {
        return entityReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntityReference_Target() {
        return (EReference) entityReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEntityReference_OriginalType() {
        return (EReference) entityReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUnknownType() {
        return unknownTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComplexType() {
        return complexTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getArray() {
        return arrayEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getArray_ElementType() {
        return (EReference) arrayEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAggregate() {
        return aggregateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAggregate_Target() {
        return (EReference) aggregateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPrimitiveType() {
        return primitiveTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBoolean() {
        return booleanEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNumber() {
        return numberEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getString() {
        return stringEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NoSQLSchemaFactory getNoSQLSchemaFactory() {
        return (NoSQLSchemaFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        noSQLSchemaEClass = createEClass(NO_SQL_SCHEMA);
        createEAttribute(noSQLSchemaEClass, NO_SQL_SCHEMA__NAME);
        createEReference(noSQLSchemaEClass, NO_SQL_SCHEMA__ENTITIES);

        entityEClass = createEClass(ENTITY);
        createEAttribute(entityEClass, ENTITY__NAME);
        createEAttribute(entityEClass, ENTITY__ROOT);
        createEAttribute(entityEClass, ENTITY__FLATTENED);
        createEReference(entityEClass, ENTITY__VERSIONS);

        entityVersionEClass = createEClass(ENTITY_VERSION);
        createEAttribute(entityVersionEClass, ENTITY_VERSION__ADDITIONAL_COUNT);
        createEReference(entityVersionEClass, ENTITY_VERSION__PROPERTIES);
        createEReference(entityVersionEClass, ENTITY_VERSION__AGGREGATES);

        propertyEClass = createEClass(PROPERTY);
        createEAttribute(propertyEClass, PROPERTY__NAME);
        createEAttribute(propertyEClass, PROPERTY__OPTIONAL);
        createEReference(propertyEClass, PROPERTY__TYPE);

        typeEClass = createEClass(TYPE);

        unionTypeEClass = createEClass(UNION_TYPE);
        createEReference(unionTypeEClass, UNION_TYPE__TYPES);

        singleTypeEClass = createEClass(SINGLE_TYPE);

        entityReferenceEClass = createEClass(ENTITY_REFERENCE);
        createEReference(entityReferenceEClass, ENTITY_REFERENCE__TARGET);
        createEReference(entityReferenceEClass, ENTITY_REFERENCE__ORIGINAL_TYPE);

        unknownTypeEClass = createEClass(UNKNOWN_TYPE);

        complexTypeEClass = createEClass(COMPLEX_TYPE);

        arrayEClass = createEClass(ARRAY);
        createEReference(arrayEClass, ARRAY__ELEMENT_TYPE);

        aggregateEClass = createEClass(AGGREGATE);
        createEReference(aggregateEClass, AGGREGATE__TARGET);

        primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

        booleanEClass = createEClass(BOOLEAN);

        numberEClass = createEClass(NUMBER);

        stringEClass = createEClass(STRING);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        unionTypeEClass.getESuperTypes().add(this.getType());
        singleTypeEClass.getESuperTypes().add(this.getType());
        entityReferenceEClass.getESuperTypes().add(this.getSingleType());
        unknownTypeEClass.getESuperTypes().add(this.getType());
        complexTypeEClass.getESuperTypes().add(this.getSingleType());
        arrayEClass.getESuperTypes().add(this.getComplexType());
        aggregateEClass.getESuperTypes().add(this.getComplexType());
        primitiveTypeEClass.getESuperTypes().add(this.getSingleType());
        booleanEClass.getESuperTypes().add(this.getPrimitiveType());
        numberEClass.getESuperTypes().add(this.getPrimitiveType());
        stringEClass.getESuperTypes().add(this.getPrimitiveType());

        // Initialize classes, features, and operations; add parameters
        initEClass(noSQLSchemaEClass, NoSQLSchema.class, "NoSQLSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNoSQLSchema_Name(), ecorePackage.getEString(), "name", null, 1, 1, NoSQLSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNoSQLSchema_Entities(), this.getEntity(), null, "entities", null, 0, -1, NoSQLSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEntity_Name(), ecorePackage.getEString(), "name", null, 1, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEntity_Root(), ecorePackage.getEBoolean(), "root", "false", 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEntity_Flattened(), ecorePackage.getEBoolean(), "flattened", "false", 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEntity_Versions(), this.getEntityVersion(), null, "versions", null, 1, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(entityVersionEClass, EntityVersion.class, "EntityVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEntityVersion_AdditionalCount(), ecorePackage.getEInt(), "additionalCount", null, 1, 1, EntityVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEntityVersion_Properties(), this.getProperty(), null, "properties", null, 0, -1, EntityVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEntityVersion_Aggregates(), this.getAggregate(), this.getAggregate_Target(), "aggregates", null, 0, -1, EntityVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProperty_Optional(), ecorePackage.getEBoolean(), "optional", "false", 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProperty_Type(), this.getType(), null, "type", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(unionTypeEClass, UnionType.class, "UnionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUnionType_Types(), this.getSingleType(), null, "types", null, 2, -1, UnionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(singleTypeEClass, SingleType.class, "SingleType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(entityReferenceEClass, EntityReference.class, "EntityReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEntityReference_Target(), this.getEntity(), null, "target", null, 1, 1, EntityReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEntityReference_OriginalType(), this.getPrimitiveType(), null, "originalType", null, 0, 1, EntityReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(unknownTypeEClass, UnknownType.class, "UnknownType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(complexTypeEClass, ComplexType.class, "ComplexType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(arrayEClass, Array.class, "Array", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getArray_ElementType(), this.getType(), null, "elementType", null, 1, 1, Array.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(aggregateEClass, Aggregate.class, "Aggregate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAggregate_Target(), this.getEntityVersion(), this.getEntityVersion_Aggregates(), "target", null, 1, 1, Aggregate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(booleanEClass, cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean.class, "Boolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(numberEClass, cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number.class, "Number", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(stringEClass, cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String.class, "String", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //NoSQLSchemaPackageImpl

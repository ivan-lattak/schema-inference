/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NoSQLSchemaFactoryImpl extends EFactoryImpl implements NoSQLSchemaFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public static NoSQLSchemaFactory init() {
        try {
            NoSQLSchemaFactory theNoSQLSchemaFactory = (NoSQLSchemaFactory) EPackage.Registry.INSTANCE.getEFactory(NoSQLSchemaPackage.eNS_URI);
            if (theNoSQLSchemaFactory != null) {
                return theNoSQLSchemaFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new NoSQLSchemaFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NoSQLSchemaFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case NoSQLSchemaPackage.NO_SQL_SCHEMA:
                return createNoSQLSchema();
            case NoSQLSchemaPackage.ENTITY:
                return createEntity();
            case NoSQLSchemaPackage.ENTITY_VERSION:
                return createEntityVersion();
            case NoSQLSchemaPackage.PROPERTY:
                return createProperty();
            case NoSQLSchemaPackage.UNION_TYPE:
                return createUnionType();
            case NoSQLSchemaPackage.ENTITY_REFERENCE:
                return createEntityReference();
            case NoSQLSchemaPackage.UNKNOWN_TYPE:
                return createUnknownType();
            case NoSQLSchemaPackage.ARRAY:
                return createArray();
            case NoSQLSchemaPackage.AGGREGATE:
                return createAggregate();
            case NoSQLSchemaPackage.BOOLEAN:
                return createBoolean();
            case NoSQLSchemaPackage.NUMBER:
                return createNumber();
            case NoSQLSchemaPackage.STRING:
                return createString();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NoSQLSchema createNoSQLSchema() {
        NoSQLSchemaImpl noSQLSchema = new NoSQLSchemaImpl();
        return noSQLSchema;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Entity createEntity() {
        EntityImpl entity = new EntityImpl();
        return entity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public EntityVersion createEntityVersion() {
        EntityVersionImpl entityVersion = new EntityVersionImpl();
        return entityVersion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Property createProperty() {
        PropertyImpl property = new PropertyImpl();
        return property;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public UnionType createUnionType() {
        UnionTypeImpl unionType = new UnionTypeImpl();
        return unionType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public EntityReference createEntityReference() {
        EntityReferenceImpl entityReference = new EntityReferenceImpl();
        return entityReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public UnknownType createUnknownType() {
        UnknownTypeImpl unknownType = new UnknownTypeImpl();
        return unknownType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Array createArray() {
        ArrayImpl array = new ArrayImpl();
        return array;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Aggregate createAggregate() {
        AggregateImpl aggregate = new AggregateImpl();
        return aggregate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean createBoolean() {
        BooleanImpl boolean_ = new BooleanImpl();
        return boolean_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number createNumber() {
        NumberImpl number = new NumberImpl();
        return number;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String createString() {
        StringImpl string = new StringImpl();
        return string;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NoSQLSchemaPackage getNoSQLSchemaPackage() {
        return (NoSQLSchemaPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @deprecated
     */
    @Deprecated
    public static NoSQLSchemaPackage getPackage() {
        return NoSQLSchemaPackage.eINSTANCE;
    }

} //NoSQLSchemaFactoryImpl

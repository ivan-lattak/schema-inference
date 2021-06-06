/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.util;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @generated
 * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage
 */
public class NoSQLSchemaAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected static NoSQLSchemaPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NoSQLSchemaAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = NoSQLSchemaPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected NoSQLSchemaSwitch<Adapter> modelSwitch =
            new NoSQLSchemaSwitch<Adapter>() {
                @Override
                public Adapter caseNoSQLSchema(NoSQLSchema object) {
                    return createNoSQLSchemaAdapter();
                }

                @Override
                public Adapter caseEntity(Entity object) {
                    return createEntityAdapter();
                }

                @Override
                public Adapter caseEntityVersion(EntityVersion object) {
                    return createEntityVersionAdapter();
                }

                @Override
                public Adapter caseProperty(Property object) {
                    return createPropertyAdapter();
                }

                @Override
                public Adapter caseType(Type object) {
                    return createTypeAdapter();
                }

                @Override
                public Adapter caseUnionType(UnionType object) {
                    return createUnionTypeAdapter();
                }

                @Override
                public Adapter caseSingleType(SingleType object) {
                    return createSingleTypeAdapter();
                }

                @Override
                public Adapter caseEntityReference(EntityReference object) {
                    return createEntityReferenceAdapter();
                }

                @Override
                public Adapter caseUnknownType(UnknownType object) {
                    return createUnknownTypeAdapter();
                }

                @Override
                public Adapter caseComplexType(ComplexType object) {
                    return createComplexTypeAdapter();
                }

                @Override
                public Adapter caseArray(Array object) {
                    return createArrayAdapter();
                }

                @Override
                public Adapter caseAggregate(Aggregate object) {
                    return createAggregateAdapter();
                }

                @Override
                public Adapter casePrimitiveType(PrimitiveType object) {
                    return createPrimitiveTypeAdapter();
                }

                @Override
                public Adapter caseBoolean(cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean object) {
                    return createBooleanAdapter();
                }

                @Override
                public Adapter caseNumber(cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number object) {
                    return createNumberAdapter();
                }

                @Override
                public Adapter caseString(cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String object) {
                    return createStringAdapter();
                }

                @Override
                public Adapter defaultCase(EObject object) {
                    return createEObjectAdapter();
                }
            };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }


    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema <em>No SQL Schema</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchema
     */
    public Adapter createNoSQLSchemaAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity <em>Entity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion <em>Entity Version</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion
     */
    public Adapter createEntityVersionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property <em>Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property
     */
    public Adapter createPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Type
     */
    public Adapter createTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnionType <em>Union Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnionType
     */
    public Adapter createUnionTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.SingleType <em>Single Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.SingleType
     */
    public Adapter createSingleTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference <em>Entity Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference
     */
    public Adapter createEntityReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnknownType <em>Unknown Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnknownType
     */
    public Adapter createUnknownTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.ComplexType <em>Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.ComplexType
     */
    public Adapter createComplexTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array <em>Array</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array
     */
    public Adapter createArrayAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate <em>Aggregate</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate
     */
    public Adapter createAggregateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.PrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.PrimitiveType
     */
    public Adapter createPrimitiveTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean <em>Boolean</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Boolean
     */
    public Adapter createBooleanAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number <em>Number</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Number
     */
    public Adapter createNumberAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String <em>String</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     * @see cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.String
     */
    public Adapter createStringAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //NoSQLSchemaAdapterFactory

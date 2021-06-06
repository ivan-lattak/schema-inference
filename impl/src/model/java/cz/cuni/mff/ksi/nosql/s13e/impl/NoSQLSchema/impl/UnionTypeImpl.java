/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.SingleType;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.UnionType;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Union Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.UnionTypeImpl#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnionTypeImpl extends TypeImpl implements UnionType {
    /**
     * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getTypes()
     */
    protected EList<SingleType> types;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected UnionTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return NoSQLSchemaPackage.Literals.UNION_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public EList<SingleType> getTypes() {
        if (types == null) {
            types = new EObjectContainmentEList<SingleType>(SingleType.class, this, NoSQLSchemaPackage.UNION_TYPE__TYPES);
        }
        return types;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case NoSQLSchemaPackage.UNION_TYPE__TYPES:
                return ((InternalEList<?>) getTypes()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case NoSQLSchemaPackage.UNION_TYPE__TYPES:
                return getTypes();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case NoSQLSchemaPackage.UNION_TYPE__TYPES:
                getTypes().clear();
                getTypes().addAll((Collection<? extends SingleType>) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case NoSQLSchemaPackage.UNION_TYPE__TYPES:
                getTypes().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case NoSQLSchemaPackage.UNION_TYPE__TYPES:
                return types != null && !types.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //UnionTypeImpl

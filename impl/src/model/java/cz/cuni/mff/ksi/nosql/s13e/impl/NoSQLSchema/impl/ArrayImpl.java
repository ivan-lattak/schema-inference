/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Array;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.ArrayImpl#getElementType <em>Element Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayImpl extends ComplexTypeImpl implements Array {
    /**
     * The cached value of the '{@link #getElementType() <em>Element Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getElementType()
     */
    protected Type elementType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected ArrayImpl() {
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
        return NoSQLSchemaPackage.Literals.ARRAY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Type getElementType() {
        return elementType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetElementType(Type newElementType, NotificationChain msgs) {
        Type oldElementType = elementType;
        elementType = newElementType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE, oldElementType, newElementType);
            if (msgs == null) msgs = notification;
            else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setElementType(Type newElementType) {
        if (newElementType != elementType) {
            NotificationChain msgs = null;
            if (elementType != null)
                msgs = ((InternalEObject) elementType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE, null, msgs);
            if (newElementType != null)
                msgs = ((InternalEObject) newElementType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE, null, msgs);
            msgs = basicSetElementType(newElementType, msgs);
            if (msgs != null) msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE, newElementType, newElementType));
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
            case NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE:
                return basicSetElementType(null, msgs);
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
            case NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE:
                return getElementType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE:
                setElementType((Type) newValue);
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
            case NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE:
                setElementType((Type) null);
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
            case NoSQLSchemaPackage.ARRAY__ELEMENT_TYPE:
                return elementType != null;
        }
        return super.eIsSet(featureID);
    }

} //ArrayImpl

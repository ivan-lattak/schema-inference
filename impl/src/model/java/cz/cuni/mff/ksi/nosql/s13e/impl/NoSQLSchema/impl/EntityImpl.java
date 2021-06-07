/**
 *
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityImpl#getName <em>Name</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityImpl#isFlattened <em>Flattened</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityImpl#getVersions <em>Versions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityImpl extends MinimalEObjectImpl.Container implements Entity {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getName()
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getName()
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #isFlattened() <em>Flattened</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #isFlattened()
     */
    protected static final boolean FLATTENED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isFlattened() <em>Flattened</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFlattened()
     * @generated
     * @ordered
	 */
    protected boolean flattened = FLATTENED_EDEFAULT;

    /**
     * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersions()
     * @generated
     * @ordered
	 */
    protected EList<EntityVersion> versions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
	 */
    protected EntityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
	 */
    @Override
    protected EClass eStaticClass() {
        return NoSQLSchemaPackage.Literals.ENTITY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isFlattened() {
        return flattened;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
	 */
    public void setFlattened(boolean newFlattened) {
        boolean oldFlattened = flattened;
        flattened = newFlattened;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY__FLATTENED, oldFlattened, flattened));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EntityVersion> getVersions() {
        if (versions == null) {
            versions = new EObjectContainmentEList<EntityVersion>(EntityVersion.class, this, NoSQLSchemaPackage.ENTITY__VERSIONS);
        }
        return versions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case NoSQLSchemaPackage.ENTITY__VERSIONS:
                return ((InternalEList<?>) getVersions()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case NoSQLSchemaPackage.ENTITY__NAME:
                return getName();
            case NoSQLSchemaPackage.ENTITY__FLATTENED:
                return isFlattened();
            case NoSQLSchemaPackage.ENTITY__VERSIONS:
                return getVersions();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case NoSQLSchemaPackage.ENTITY__NAME:
                setName((String) newValue);
                return;
            case NoSQLSchemaPackage.ENTITY__FLATTENED:
                setFlattened((Boolean) newValue);
                return;
            case NoSQLSchemaPackage.ENTITY__VERSIONS:
                getVersions().clear();
                getVersions().addAll((Collection<? extends EntityVersion>) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
	 */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case NoSQLSchemaPackage.ENTITY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case NoSQLSchemaPackage.ENTITY__FLATTENED:
                setFlattened(FLATTENED_EDEFAULT);
                return;
            case NoSQLSchemaPackage.ENTITY__VERSIONS:
                getVersions().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case NoSQLSchemaPackage.ENTITY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case NoSQLSchemaPackage.ENTITY__FLATTENED:
                return flattened != FLATTENED_EDEFAULT;
            case NoSQLSchemaPackage.ENTITY__VERSIONS:
                return versions != null && !versions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", flattened: ");
        result.append(flattened);
        result.append(')');
        return result.toString();
	}

} //EntityImpl

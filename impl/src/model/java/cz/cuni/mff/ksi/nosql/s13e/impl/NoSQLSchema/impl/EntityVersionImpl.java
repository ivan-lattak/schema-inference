/**
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Aggregate;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityVersion;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Property;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl#getId <em>Id</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl#getAdditionalCount <em>Additional Count</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl#getAggregates <em>Aggregates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityVersionImpl extends MinimalEObjectImpl.Container implements EntityVersion {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getId()
     */
    protected int id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getAdditionalCount() <em>Additional Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getAdditionalCount()
     */
    protected static final int ADDITIONAL_COUNT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getAdditionalCount() <em>Additional Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getAdditionalCount()
     */
    protected int additionalCount = ADDITIONAL_COUNT_EDEFAULT;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getProperties()
     */
    protected EList<Property> properties;

    /**
     * The cached value of the '{@link #getAggregates() <em>Aggregates</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getAggregates()
     */
    protected EList<Aggregate> aggregates;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected EntityVersionImpl() {
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
        return NoSQLSchemaPackage.Literals.ENTITY_VERSION;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setId(int newId) {
        int oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY_VERSION__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public int getAdditionalCount() {
        return additionalCount;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setAdditionalCount(int newAdditionalCount) {
        int oldAdditionalCount = additionalCount;
        additionalCount = newAdditionalCount;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY_VERSION__ADDITIONAL_COUNT, oldAdditionalCount, additionalCount));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public EList<Property> getProperties() {
        if (properties == null) {
            properties = new EObjectContainmentEList<Property>(Property.class, this, NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES);
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public EList<Aggregate> getAggregates() {
        if (aggregates == null) {
            aggregates = new EObjectWithInverseResolvingEList<Aggregate>(Aggregate.class, this, NoSQLSchemaPackage.ENTITY_VERSION__AGGREGATES, NoSQLSchemaPackage.AGGREGATE__TARGET);
        }
        return aggregates;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case NoSQLSchemaPackage.ENTITY_VERSION__AGGREGATES:
                return ((InternalEList<InternalEObject>) (InternalEList<?>) getAggregates()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
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
            case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
                return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
            case NoSQLSchemaPackage.ENTITY_VERSION__AGGREGATES:
                return ((InternalEList<?>) getAggregates()).basicRemove(otherEnd, msgs);
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
            case NoSQLSchemaPackage.ENTITY_VERSION__ID:
                return getId();
            case NoSQLSchemaPackage.ENTITY_VERSION__ADDITIONAL_COUNT:
                return getAdditionalCount();
            case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
                return getProperties();
            case NoSQLSchemaPackage.ENTITY_VERSION__AGGREGATES:
                return getAggregates();
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
            case NoSQLSchemaPackage.ENTITY_VERSION__ID:
                setId((Integer) newValue);
                return;
            case NoSQLSchemaPackage.ENTITY_VERSION__ADDITIONAL_COUNT:
                setAdditionalCount((Integer) newValue);
                return;
            case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends Property>) newValue);
                return;
            case NoSQLSchemaPackage.ENTITY_VERSION__AGGREGATES:
                getAggregates().clear();
                getAggregates().addAll((Collection<? extends Aggregate>) newValue);
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
            case NoSQLSchemaPackage.ENTITY_VERSION__ID:
                setId(ID_EDEFAULT);
                return;
            case NoSQLSchemaPackage.ENTITY_VERSION__ADDITIONAL_COUNT:
                setAdditionalCount(ADDITIONAL_COUNT_EDEFAULT);
                return;
            case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
                getProperties().clear();
                return;
            case NoSQLSchemaPackage.ENTITY_VERSION__AGGREGATES:
                getAggregates().clear();
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
            case NoSQLSchemaPackage.ENTITY_VERSION__ID:
                return id != ID_EDEFAULT;
            case NoSQLSchemaPackage.ENTITY_VERSION__ADDITIONAL_COUNT:
                return additionalCount != ADDITIONAL_COUNT_EDEFAULT;
            case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
                return properties != null && !properties.isEmpty();
            case NoSQLSchemaPackage.ENTITY_VERSION__AGGREGATES:
                return aggregates != null && !aggregates.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (id: ");
        result.append(id);
        result.append(", additionalCount: ");
        result.append(additionalCount);
        result.append(')');
		return result.toString();
	}

} //EntityVersionImpl

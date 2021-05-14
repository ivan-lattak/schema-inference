/**
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
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
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl#getCount <em>Count</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityVersionImpl#getEntity <em>Entity</em>}</li>
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
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getCount()
	 */
	protected static final long COUNT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getCount()
	 */
	protected long count = COUNT_EDEFAULT;

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
	public long getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setCount(long newCount) {
		long oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY_VERSION__COUNT, oldCount, count));
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
	public Entity getEntity() {
		if (eContainerFeatureID() != NoSQLSchemaPackage.ENTITY_VERSION__ENTITY) return null;
		return (Entity) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetEntity(Entity newEntity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newEntity, NoSQLSchemaPackage.ENTITY_VERSION__ENTITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEntity(Entity newEntity) {
		if (newEntity != eInternalContainer() || (eContainerFeatureID() != NoSQLSchemaPackage.ENTITY_VERSION__ENTITY && newEntity != null)) {
			if (EcoreUtil.isAncestor(this, newEntity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEntity != null)
				msgs = ((InternalEObject) newEntity).eInverseAdd(this, NoSQLSchemaPackage.ENTITY__VERSIONS, Entity.class, msgs);
			msgs = basicSetEntity(newEntity, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY_VERSION__ENTITY, newEntity, newEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NoSQLSchemaPackage.ENTITY_VERSION__ENTITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEntity((Entity) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
				return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
			case NoSQLSchemaPackage.ENTITY_VERSION__ENTITY:
				return basicSetEntity(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case NoSQLSchemaPackage.ENTITY_VERSION__ENTITY:
				return eInternalContainer().eInverseRemove(this, NoSQLSchemaPackage.ENTITY__VERSIONS, Entity.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NoSQLSchemaPackage.ENTITY_VERSION__ID:
				return getId();
			case NoSQLSchemaPackage.ENTITY_VERSION__COUNT:
				return getCount();
			case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
				return getProperties();
			case NoSQLSchemaPackage.ENTITY_VERSION__ENTITY:
				return getEntity();
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
			case NoSQLSchemaPackage.ENTITY_VERSION__COUNT:
				setCount((Long) newValue);
				return;
			case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>) newValue);
				return;
			case NoSQLSchemaPackage.ENTITY_VERSION__ENTITY:
				setEntity((Entity) newValue);
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
			case NoSQLSchemaPackage.ENTITY_VERSION__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
				getProperties().clear();
				return;
			case NoSQLSchemaPackage.ENTITY_VERSION__ENTITY:
				setEntity((Entity) null);
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
			case NoSQLSchemaPackage.ENTITY_VERSION__ID:
				return id != ID_EDEFAULT;
			case NoSQLSchemaPackage.ENTITY_VERSION__COUNT:
				return count != COUNT_EDEFAULT;
			case NoSQLSchemaPackage.ENTITY_VERSION__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case NoSQLSchemaPackage.ENTITY_VERSION__ENTITY:
				return getEntity() != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", count: ");
		result.append(count);
		result.append(')');
		return result.toString();
	}

} //EntityVersionImpl

/**
 */
package cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl;

import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.Entity;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.EntityReference;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.NoSQLSchemaPackage;
import cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.PrimitiveType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityReferenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link cz.cuni.mff.ksi.nosql.s13e.impl.NoSQLSchema.impl.EntityReferenceImpl#getOriginalType <em>Original Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityReferenceImpl extends SingleTypeImpl implements EntityReference {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getTarget()
	 */
	protected Entity target;

	/**
	 * The cached value of the '{@link #getOriginalType() <em>Original Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 * @see #getOriginalType()
	 */
	protected PrimitiveType originalType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EntityReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NoSQLSchemaPackage.Literals.ENTITY_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (Entity) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NoSQLSchemaPackage.ENTITY_REFERENCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Entity newTarget) {
		Entity oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY_REFERENCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PrimitiveType getOriginalType() {
		return originalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetOriginalType(PrimitiveType newOriginalType, NotificationChain msgs) {
		PrimitiveType oldOriginalType = originalType;
		originalType = newOriginalType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE, oldOriginalType, newOriginalType);
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
	public void setOriginalType(PrimitiveType newOriginalType) {
		if (newOriginalType != originalType) {
			NotificationChain msgs = null;
			if (originalType != null)
				msgs = ((InternalEObject) originalType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE, null, msgs);
			if (newOriginalType != null)
				msgs = ((InternalEObject) newOriginalType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE, null, msgs);
			msgs = basicSetOriginalType(newOriginalType, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE, newOriginalType, newOriginalType));
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
			case NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE:
				return basicSetOriginalType(null, msgs);
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
			case NoSQLSchemaPackage.ENTITY_REFERENCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE:
				return getOriginalType();
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
			case NoSQLSchemaPackage.ENTITY_REFERENCE__TARGET:
				setTarget((Entity) newValue);
				return;
			case NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE:
				setOriginalType((PrimitiveType) newValue);
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
			case NoSQLSchemaPackage.ENTITY_REFERENCE__TARGET:
				setTarget((Entity) null);
				return;
			case NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE:
				setOriginalType((PrimitiveType)null);
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
			case NoSQLSchemaPackage.ENTITY_REFERENCE__TARGET:
				return target != null;
			case NoSQLSchemaPackage.ENTITY_REFERENCE__ORIGINAL_TYPE:
				return originalType != null;
		}
		return super.eIsSet(featureID);
	}

} //EntityReferenceImpl

/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.impl;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.NumericalValue;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relatif To PC Indirect Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.RelatifToPCIndirectModeImpl#getDeplacement <em>Deplacement</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.RelatifToPCIndirectModeImpl#getRegister <em>Register</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelatifToPCIndirectModeImpl extends MinimalEObjectImpl.Container implements RelatifToPCIndirectMode
{
  /**
   * The cached value of the '{@link #getDeplacement() <em>Deplacement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeplacement()
   * @generated
   * @ordered
   */
  protected NumericalValue deplacement;

  /**
   * The default value of the '{@link #getRegister() <em>Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegister()
   * @generated
   * @ordered
   */
  protected static final String REGISTER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRegister() <em>Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegister()
   * @generated
   * @ordered
   */
  protected String register = REGISTER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelatifToPCIndirectModeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AssemblerPackage.Literals.RELATIF_TO_PC_INDIRECT_MODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NumericalValue getDeplacement()
  {
    return deplacement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeplacement(NumericalValue newDeplacement, NotificationChain msgs)
  {
    NumericalValue oldDeplacement = deplacement;
    deplacement = newDeplacement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT, oldDeplacement, newDeplacement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDeplacement(NumericalValue newDeplacement)
  {
    if (newDeplacement != deplacement)
    {
      NotificationChain msgs = null;
      if (deplacement != null)
        msgs = ((InternalEObject)deplacement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT, null, msgs);
      if (newDeplacement != null)
        msgs = ((InternalEObject)newDeplacement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT, null, msgs);
      msgs = basicSetDeplacement(newDeplacement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT, newDeplacement, newDeplacement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getRegister()
  {
    return register;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRegister(String newRegister)
  {
    String oldRegister = register;
    register = newRegister;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__REGISTER, oldRegister, register));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT:
        return basicSetDeplacement(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT:
        return getDeplacement();
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__REGISTER:
        return getRegister();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT:
        setDeplacement((NumericalValue)newValue);
        return;
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__REGISTER:
        setRegister((String)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT:
        setDeplacement((NumericalValue)null);
        return;
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__REGISTER:
        setRegister(REGISTER_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__DEPLACEMENT:
        return deplacement != null;
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE__REGISTER:
        return REGISTER_EDEFAULT == null ? register != null : !REGISTER_EDEFAULT.equals(register);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (register: ");
    result.append(register);
    result.append(')');
    return result.toString();
  }

} //RelatifToPCIndirectModeImpl

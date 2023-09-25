/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.impl;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BinaryeValue;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binarye Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.BinaryeValueImpl#isIsNegative <em>Is Negative</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.BinaryeValueImpl#getBinaryValue <em>Binary Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryeValueImpl extends MinimalEObjectImpl.Container implements BinaryeValue
{
  /**
   * The default value of the '{@link #isIsNegative() <em>Is Negative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNegative()
   * @generated
   * @ordered
   */
  protected static final boolean IS_NEGATIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsNegative() <em>Is Negative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNegative()
   * @generated
   * @ordered
   */
  protected boolean isNegative = IS_NEGATIVE_EDEFAULT;

  /**
   * The default value of the '{@link #getBinaryValue() <em>Binary Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinaryValue()
   * @generated
   * @ordered
   */
  protected static final String BINARY_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBinaryValue() <em>Binary Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinaryValue()
   * @generated
   * @ordered
   */
  protected String binaryValue = BINARY_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BinaryeValueImpl()
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
    return AssemblerPackage.Literals.BINARYE_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isIsNegative()
  {
    return isNegative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIsNegative(boolean newIsNegative)
  {
    boolean oldIsNegative = isNegative;
    isNegative = newIsNegative;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.BINARYE_VALUE__IS_NEGATIVE, oldIsNegative, isNegative));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getBinaryValue()
  {
    return binaryValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBinaryValue(String newBinaryValue)
  {
    String oldBinaryValue = binaryValue;
    binaryValue = newBinaryValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.BINARYE_VALUE__BINARY_VALUE, oldBinaryValue, binaryValue));
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
      case AssemblerPackage.BINARYE_VALUE__IS_NEGATIVE:
        return isIsNegative();
      case AssemblerPackage.BINARYE_VALUE__BINARY_VALUE:
        return getBinaryValue();
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
      case AssemblerPackage.BINARYE_VALUE__IS_NEGATIVE:
        setIsNegative((Boolean)newValue);
        return;
      case AssemblerPackage.BINARYE_VALUE__BINARY_VALUE:
        setBinaryValue((String)newValue);
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
      case AssemblerPackage.BINARYE_VALUE__IS_NEGATIVE:
        setIsNegative(IS_NEGATIVE_EDEFAULT);
        return;
      case AssemblerPackage.BINARYE_VALUE__BINARY_VALUE:
        setBinaryValue(BINARY_VALUE_EDEFAULT);
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
      case AssemblerPackage.BINARYE_VALUE__IS_NEGATIVE:
        return isNegative != IS_NEGATIVE_EDEFAULT;
      case AssemblerPackage.BINARYE_VALUE__BINARY_VALUE:
        return BINARY_VALUE_EDEFAULT == null ? binaryValue != null : !BINARY_VALUE_EDEFAULT.equals(binaryValue);
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
    result.append(" (isNegative: ");
    result.append(isNegative);
    result.append(", binaryValue: ");
    result.append(binaryValue);
    result.append(')');
    return result.toString();
  }

} //BinaryeValueImpl

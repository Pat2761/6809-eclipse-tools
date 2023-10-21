/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.impl;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fcc Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.FccDirectiveImpl#getDirective <em>Directive</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.FccDirectiveImpl#getString <em>String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FccDirectiveImpl extends MinimalEObjectImpl.Container implements FccDirective
{
  /**
   * The default value of the '{@link #getDirective() <em>Directive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirective()
   * @generated
   * @ordered
   */
  protected static final String DIRECTIVE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDirective() <em>Directive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirective()
   * @generated
   * @ordered
   */
  protected String directive = DIRECTIVE_EDEFAULT;

  /**
   * The default value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected static final String STRING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected String string = STRING_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FccDirectiveImpl()
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
    return AssemblerPackage.Literals.FCC_DIRECTIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDirective()
  {
    return directive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDirective(String newDirective)
  {
    String oldDirective = directive;
    directive = newDirective;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.FCC_DIRECTIVE__DIRECTIVE, oldDirective, directive));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getString()
  {
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setString(String newString)
  {
    String oldString = string;
    string = newString;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.FCC_DIRECTIVE__STRING, oldString, string));
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
      case AssemblerPackage.FCC_DIRECTIVE__DIRECTIVE:
        return getDirective();
      case AssemblerPackage.FCC_DIRECTIVE__STRING:
        return getString();
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
      case AssemblerPackage.FCC_DIRECTIVE__DIRECTIVE:
        setDirective((String)newValue);
        return;
      case AssemblerPackage.FCC_DIRECTIVE__STRING:
        setString((String)newValue);
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
      case AssemblerPackage.FCC_DIRECTIVE__DIRECTIVE:
        setDirective(DIRECTIVE_EDEFAULT);
        return;
      case AssemblerPackage.FCC_DIRECTIVE__STRING:
        setString(STRING_EDEFAULT);
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
      case AssemblerPackage.FCC_DIRECTIVE__DIRECTIVE:
        return DIRECTIVE_EDEFAULT == null ? directive != null : !DIRECTIVE_EDEFAULT.equals(directive);
      case AssemblerPackage.FCC_DIRECTIVE__STRING:
        return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals(string);
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
    result.append(" (directive: ");
    result.append(directive);
    result.append(", string: ");
    result.append(string);
    result.append(')');
    return result.toString();
  }

} //FccDirectiveImpl

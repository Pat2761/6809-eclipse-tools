/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.impl;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.MulInstruction;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mul Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.MulInstructionImpl#getInstruction <em>Instruction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MulInstructionImpl extends MinimalEObjectImpl.Container implements MulInstruction
{
  /**
   * The default value of the '{@link #getInstruction() <em>Instruction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstruction()
   * @generated
   * @ordered
   */
  protected static final String INSTRUCTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInstruction() <em>Instruction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstruction()
   * @generated
   * @ordered
   */
  protected String instruction = INSTRUCTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MulInstructionImpl()
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
    return AssemblerPackage.Literals.MUL_INSTRUCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getInstruction()
  {
    return instruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInstruction(String newInstruction)
  {
    String oldInstruction = instruction;
    instruction = newInstruction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.MUL_INSTRUCTION__INSTRUCTION, oldInstruction, instruction));
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
      case AssemblerPackage.MUL_INSTRUCTION__INSTRUCTION:
        return getInstruction();
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
      case AssemblerPackage.MUL_INSTRUCTION__INSTRUCTION:
        setInstruction((String)newValue);
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
      case AssemblerPackage.MUL_INSTRUCTION__INSTRUCTION:
        setInstruction(INSTRUCTION_EDEFAULT);
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
      case AssemblerPackage.MUL_INSTRUCTION__INSTRUCTION:
        return INSTRUCTION_EDEFAULT == null ? instruction != null : !INSTRUCTION_EDEFAULT.equals(instruction);
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
    result.append(" (instruction: ");
    result.append(instruction);
    result.append(')');
    return result.toString();
  }

} //MulInstructionImpl

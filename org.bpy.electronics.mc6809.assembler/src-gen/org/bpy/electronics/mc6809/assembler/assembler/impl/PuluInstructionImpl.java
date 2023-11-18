/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.impl;

import java.util.Collection;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.PuluInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Register;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pulu Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.PuluInstructionImpl#getInstruction <em>Instruction</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.PuluInstructionImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.PuluInstructionImpl#getRegisters <em>Registers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PuluInstructionImpl extends MinimalEObjectImpl.Container implements PuluInstruction
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
   * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand()
   * @generated
   * @ordered
   */
  protected ImmediatOperand operand;

  /**
   * The cached value of the '{@link #getRegisters() <em>Registers</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegisters()
   * @generated
   * @ordered
   */
  protected EList<Register> registers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PuluInstructionImpl()
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
    return AssemblerPackage.Literals.PULU_INSTRUCTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.PULU_INSTRUCTION__INSTRUCTION, oldInstruction, instruction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImmediatOperand getOperand()
  {
    return operand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand(ImmediatOperand newOperand, NotificationChain msgs)
  {
    ImmediatOperand oldOperand = operand;
    operand = newOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssemblerPackage.PULU_INSTRUCTION__OPERAND, oldOperand, newOperand);
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
  public void setOperand(ImmediatOperand newOperand)
  {
    if (newOperand != operand)
    {
      NotificationChain msgs = null;
      if (operand != null)
        msgs = ((InternalEObject)operand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssemblerPackage.PULU_INSTRUCTION__OPERAND, null, msgs);
      if (newOperand != null)
        msgs = ((InternalEObject)newOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssemblerPackage.PULU_INSTRUCTION__OPERAND, null, msgs);
      msgs = basicSetOperand(newOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.PULU_INSTRUCTION__OPERAND, newOperand, newOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Register> getRegisters()
  {
    if (registers == null)
    {
      registers = new EDataTypeEList<Register>(Register.class, this, AssemblerPackage.PULU_INSTRUCTION__REGISTERS);
    }
    return registers;
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
      case AssemblerPackage.PULU_INSTRUCTION__OPERAND:
        return basicSetOperand(null, msgs);
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
      case AssemblerPackage.PULU_INSTRUCTION__INSTRUCTION:
        return getInstruction();
      case AssemblerPackage.PULU_INSTRUCTION__OPERAND:
        return getOperand();
      case AssemblerPackage.PULU_INSTRUCTION__REGISTERS:
        return getRegisters();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AssemblerPackage.PULU_INSTRUCTION__INSTRUCTION:
        setInstruction((String)newValue);
        return;
      case AssemblerPackage.PULU_INSTRUCTION__OPERAND:
        setOperand((ImmediatOperand)newValue);
        return;
      case AssemblerPackage.PULU_INSTRUCTION__REGISTERS:
        getRegisters().clear();
        getRegisters().addAll((Collection<? extends Register>)newValue);
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
      case AssemblerPackage.PULU_INSTRUCTION__INSTRUCTION:
        setInstruction(INSTRUCTION_EDEFAULT);
        return;
      case AssemblerPackage.PULU_INSTRUCTION__OPERAND:
        setOperand((ImmediatOperand)null);
        return;
      case AssemblerPackage.PULU_INSTRUCTION__REGISTERS:
        getRegisters().clear();
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
      case AssemblerPackage.PULU_INSTRUCTION__INSTRUCTION:
        return INSTRUCTION_EDEFAULT == null ? instruction != null : !INSTRUCTION_EDEFAULT.equals(instruction);
      case AssemblerPackage.PULU_INSTRUCTION__OPERAND:
        return operand != null;
      case AssemblerPackage.PULU_INSTRUCTION__REGISTERS:
        return registers != null && !registers.isEmpty();
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
    result.append(", registers: ");
    result.append(registers);
    result.append(')');
    return result.toString();
  }

} //PuluInstructionImpl

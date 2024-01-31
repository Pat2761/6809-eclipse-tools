/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.impl;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Register;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exg Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.ExgInstructionImpl#getInstruction <em>Instruction</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.ExgInstructionImpl#getWsOperand <em>Ws Operand</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.ExgInstructionImpl#getReg1 <em>Reg1</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.ExgInstructionImpl#getReg2 <em>Reg2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExgInstructionImpl extends MinimalEObjectImpl.Container implements ExgInstruction
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
   * The default value of the '{@link #getWsOperand() <em>Ws Operand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWsOperand()
   * @generated
   * @ordered
   */
  protected static final String WS_OPERAND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getWsOperand() <em>Ws Operand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWsOperand()
   * @generated
   * @ordered
   */
  protected String wsOperand = WS_OPERAND_EDEFAULT;

  /**
   * The default value of the '{@link #getReg1() <em>Reg1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReg1()
   * @generated
   * @ordered
   */
  protected static final Register REG1_EDEFAULT = Register.A;

  /**
   * The cached value of the '{@link #getReg1() <em>Reg1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReg1()
   * @generated
   * @ordered
   */
  protected Register reg1 = REG1_EDEFAULT;

  /**
   * The default value of the '{@link #getReg2() <em>Reg2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReg2()
   * @generated
   * @ordered
   */
  protected static final Register REG2_EDEFAULT = Register.A;

  /**
   * The cached value of the '{@link #getReg2() <em>Reg2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReg2()
   * @generated
   * @ordered
   */
  protected Register reg2 = REG2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExgInstructionImpl()
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
    return AssemblerPackage.Literals.EXG_INSTRUCTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.EXG_INSTRUCTION__INSTRUCTION, oldInstruction, instruction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getWsOperand()
  {
    return wsOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWsOperand(String newWsOperand)
  {
    String oldWsOperand = wsOperand;
    wsOperand = newWsOperand;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.EXG_INSTRUCTION__WS_OPERAND, oldWsOperand, wsOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Register getReg1()
  {
    return reg1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReg1(Register newReg1)
  {
    Register oldReg1 = reg1;
    reg1 = newReg1 == null ? REG1_EDEFAULT : newReg1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.EXG_INSTRUCTION__REG1, oldReg1, reg1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Register getReg2()
  {
    return reg2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReg2(Register newReg2)
  {
    Register oldReg2 = reg2;
    reg2 = newReg2 == null ? REG2_EDEFAULT : newReg2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.EXG_INSTRUCTION__REG2, oldReg2, reg2));
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
      case AssemblerPackage.EXG_INSTRUCTION__INSTRUCTION:
        return getInstruction();
      case AssemblerPackage.EXG_INSTRUCTION__WS_OPERAND:
        return getWsOperand();
      case AssemblerPackage.EXG_INSTRUCTION__REG1:
        return getReg1();
      case AssemblerPackage.EXG_INSTRUCTION__REG2:
        return getReg2();
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
      case AssemblerPackage.EXG_INSTRUCTION__INSTRUCTION:
        setInstruction((String)newValue);
        return;
      case AssemblerPackage.EXG_INSTRUCTION__WS_OPERAND:
        setWsOperand((String)newValue);
        return;
      case AssemblerPackage.EXG_INSTRUCTION__REG1:
        setReg1((Register)newValue);
        return;
      case AssemblerPackage.EXG_INSTRUCTION__REG2:
        setReg2((Register)newValue);
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
      case AssemblerPackage.EXG_INSTRUCTION__INSTRUCTION:
        setInstruction(INSTRUCTION_EDEFAULT);
        return;
      case AssemblerPackage.EXG_INSTRUCTION__WS_OPERAND:
        setWsOperand(WS_OPERAND_EDEFAULT);
        return;
      case AssemblerPackage.EXG_INSTRUCTION__REG1:
        setReg1(REG1_EDEFAULT);
        return;
      case AssemblerPackage.EXG_INSTRUCTION__REG2:
        setReg2(REG2_EDEFAULT);
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
      case AssemblerPackage.EXG_INSTRUCTION__INSTRUCTION:
        return INSTRUCTION_EDEFAULT == null ? instruction != null : !INSTRUCTION_EDEFAULT.equals(instruction);
      case AssemblerPackage.EXG_INSTRUCTION__WS_OPERAND:
        return WS_OPERAND_EDEFAULT == null ? wsOperand != null : !WS_OPERAND_EDEFAULT.equals(wsOperand);
      case AssemblerPackage.EXG_INSTRUCTION__REG1:
        return reg1 != REG1_EDEFAULT;
      case AssemblerPackage.EXG_INSTRUCTION__REG2:
        return reg2 != REG2_EDEFAULT;
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
    result.append(", wsOperand: ");
    result.append(wsOperand);
    result.append(", reg1: ");
    result.append(reg1);
    result.append(", reg2: ");
    result.append(reg2);
    result.append(')');
    return result.toString();
  }

} //ExgInstructionImpl

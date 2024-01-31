/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.impl;

import org.bpy.electronics.mc6809.assembler.assembler.AddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.AddInstructionImpl#getInstruction <em>Instruction</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.AddInstructionImpl#getWsOperand <em>Ws Operand</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.impl.AddInstructionImpl#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddInstructionImpl extends MinimalEObjectImpl.Container implements AddInstruction
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
   * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand()
   * @generated
   * @ordered
   */
  protected EObject operand;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AddInstructionImpl()
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
    return AssemblerPackage.Literals.ADD_INSTRUCTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.ADD_INSTRUCTION__INSTRUCTION, oldInstruction, instruction));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.ADD_INSTRUCTION__WS_OPERAND, oldWsOperand, wsOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getOperand()
  {
    return operand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand(EObject newOperand, NotificationChain msgs)
  {
    EObject oldOperand = operand;
    operand = newOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssemblerPackage.ADD_INSTRUCTION__OPERAND, oldOperand, newOperand);
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
  public void setOperand(EObject newOperand)
  {
    if (newOperand != operand)
    {
      NotificationChain msgs = null;
      if (operand != null)
        msgs = ((InternalEObject)operand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssemblerPackage.ADD_INSTRUCTION__OPERAND, null, msgs);
      if (newOperand != null)
        msgs = ((InternalEObject)newOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssemblerPackage.ADD_INSTRUCTION__OPERAND, null, msgs);
      msgs = basicSetOperand(newOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssemblerPackage.ADD_INSTRUCTION__OPERAND, newOperand, newOperand));
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
      case AssemblerPackage.ADD_INSTRUCTION__OPERAND:
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
      case AssemblerPackage.ADD_INSTRUCTION__INSTRUCTION:
        return getInstruction();
      case AssemblerPackage.ADD_INSTRUCTION__WS_OPERAND:
        return getWsOperand();
      case AssemblerPackage.ADD_INSTRUCTION__OPERAND:
        return getOperand();
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
      case AssemblerPackage.ADD_INSTRUCTION__INSTRUCTION:
        setInstruction((String)newValue);
        return;
      case AssemblerPackage.ADD_INSTRUCTION__WS_OPERAND:
        setWsOperand((String)newValue);
        return;
      case AssemblerPackage.ADD_INSTRUCTION__OPERAND:
        setOperand((EObject)newValue);
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
      case AssemblerPackage.ADD_INSTRUCTION__INSTRUCTION:
        setInstruction(INSTRUCTION_EDEFAULT);
        return;
      case AssemblerPackage.ADD_INSTRUCTION__WS_OPERAND:
        setWsOperand(WS_OPERAND_EDEFAULT);
        return;
      case AssemblerPackage.ADD_INSTRUCTION__OPERAND:
        setOperand((EObject)null);
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
      case AssemblerPackage.ADD_INSTRUCTION__INSTRUCTION:
        return INSTRUCTION_EDEFAULT == null ? instruction != null : !INSTRUCTION_EDEFAULT.equals(instruction);
      case AssemblerPackage.ADD_INSTRUCTION__WS_OPERAND:
        return WS_OPERAND_EDEFAULT == null ? wsOperand != null : !WS_OPERAND_EDEFAULT.equals(wsOperand);
      case AssemblerPackage.ADD_INSTRUCTION__OPERAND:
        return operand != null;
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
    result.append(')');
    return result.toString();
  }

} //AddInstructionImpl

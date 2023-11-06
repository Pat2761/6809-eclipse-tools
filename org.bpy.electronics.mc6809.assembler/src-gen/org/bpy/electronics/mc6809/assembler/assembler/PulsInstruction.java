/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Puls Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction#getInstruction <em>Instruction</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction#getRegisters <em>Registers</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getPulsInstruction()
 * @model
 * @generated
 */
public interface PulsInstruction extends EObject
{
  /**
   * Returns the value of the '<em><b>Instruction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instruction</em>' attribute.
   * @see #setInstruction(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getPulsInstruction_Instruction()
   * @model
   * @generated
   */
  String getInstruction();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction#getInstruction <em>Instruction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instruction</em>' attribute.
   * @see #getInstruction()
   * @generated
   */
  void setInstruction(String value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(ImmediatOperand)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getPulsInstruction_Operand()
   * @model containment="true"
   * @generated
   */
  ImmediatOperand getOperand();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(ImmediatOperand value);

  /**
   * Returns the value of the '<em><b>Registers</b></em>' attribute list.
   * The list contents are of type {@link org.bpy.electronics.mc6809.assembler.assembler.Register}.
   * The literals are from the enumeration {@link org.bpy.electronics.mc6809.assembler.assembler.Register}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Registers</em>' attribute list.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Register
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getPulsInstruction_Registers()
   * @model unique="false"
   * @generated
   */
  EList<Register> getRegisters();

} // PulsInstruction

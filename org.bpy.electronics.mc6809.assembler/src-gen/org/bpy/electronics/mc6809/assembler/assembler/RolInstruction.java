/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rol Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RolInstruction#getInstruction <em>Instruction</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RolInstruction#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRolInstruction()
 * @model
 * @generated
 */
public interface RolInstruction extends EObject
{
  /**
   * Returns the value of the '<em><b>Instruction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instruction</em>' attribute.
   * @see #setInstruction(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRolInstruction_Instruction()
   * @model
   * @generated
   */
  String getInstruction();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RolInstruction#getInstruction <em>Instruction</em>}' attribute.
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
   * @see #setOperand(EObject)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRolInstruction_Operand()
   * @model containment="true"
   * @generated
   */
  EObject getOperand();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RolInstruction#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(EObject value);

} // RolInstruction

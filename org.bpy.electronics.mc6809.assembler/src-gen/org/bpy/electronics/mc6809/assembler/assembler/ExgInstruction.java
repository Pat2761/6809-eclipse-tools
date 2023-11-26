/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exg Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction#getInstruction <em>Instruction</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction#getReg1 <em>Reg1</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction#getReg2 <em>Reg2</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getExgInstruction()
 * @model
 * @generated
 */
public interface ExgInstruction extends EObject
{
  /**
   * Returns the value of the '<em><b>Instruction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instruction</em>' attribute.
   * @see #setInstruction(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getExgInstruction_Instruction()
   * @model
   * @generated
   */
  String getInstruction();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction#getInstruction <em>Instruction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instruction</em>' attribute.
   * @see #getInstruction()
   * @generated
   */
  void setInstruction(String value);

  /**
   * Returns the value of the '<em><b>Reg1</b></em>' attribute.
   * The literals are from the enumeration {@link org.bpy.electronics.mc6809.assembler.assembler.Register}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reg1</em>' attribute.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Register
   * @see #setReg1(Register)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getExgInstruction_Reg1()
   * @model
   * @generated
   */
  Register getReg1();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction#getReg1 <em>Reg1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reg1</em>' attribute.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Register
   * @see #getReg1()
   * @generated
   */
  void setReg1(Register value);

  /**
   * Returns the value of the '<em><b>Reg2</b></em>' attribute.
   * The literals are from the enumeration {@link org.bpy.electronics.mc6809.assembler.assembler.Register}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reg2</em>' attribute.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Register
   * @see #setReg2(Register)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getExgInstruction_Reg2()
   * @model
   * @generated
   */
  Register getReg2();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction#getReg2 <em>Reg2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reg2</em>' attribute.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Register
   * @see #getReg2()
   * @generated
   */
  void setReg2(Register value);

} // ExgInstruction

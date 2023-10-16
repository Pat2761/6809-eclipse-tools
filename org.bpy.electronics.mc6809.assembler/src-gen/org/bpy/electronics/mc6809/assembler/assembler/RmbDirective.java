/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rmb Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RmbDirective#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RmbDirective#getDirective <em>Directive</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RmbDirective#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RmbDirective#getComment <em>Comment</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRmbDirective()
 * @model
 * @generated
 */
public interface RmbDirective extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(IdentifierValue)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRmbDirective_Name()
   * @model containment="true"
   * @generated
   */
  IdentifierValue getName();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RmbDirective#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(IdentifierValue value);

  /**
   * Returns the value of the '<em><b>Directive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directive</em>' attribute.
   * @see #setDirective(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRmbDirective_Directive()
   * @model
   * @generated
   */
  String getDirective();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RmbDirective#getDirective <em>Directive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Directive</em>' attribute.
   * @see #getDirective()
   * @generated
   */
  void setDirective(String value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(Expression)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRmbDirective_Operand()
   * @model containment="true"
   * @generated
   */
  Expression getOperand();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RmbDirective#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(Expression value);

  /**
   * Returns the value of the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' attribute.
   * @see #setComment(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRmbDirective_Comment()
   * @model
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RmbDirective#getComment <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' attribute.
   * @see #getComment()
   * @generated
   */
  void setComment(String value);

} // RmbDirective

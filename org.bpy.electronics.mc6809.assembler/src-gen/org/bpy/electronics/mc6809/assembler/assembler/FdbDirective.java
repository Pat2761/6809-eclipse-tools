/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fdb Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.FdbDirective#getDirective <em>Directive</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.FdbDirective#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getFdbDirective()
 * @model
 * @generated
 */
public interface FdbDirective extends EObject
{
  /**
   * Returns the value of the '<em><b>Directive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directive</em>' attribute.
   * @see #setDirective(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getFdbDirective_Directive()
   * @model
   * @generated
   */
  String getDirective();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.FdbDirective#getDirective <em>Directive</em>}' attribute.
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
   * @see #setOperand(ListOfExpression)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getFdbDirective_Operand()
   * @model containment="true"
   * @generated
   */
  ListOfExpression getOperand();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.FdbDirective#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(ListOfExpression value);

} // FdbDirective

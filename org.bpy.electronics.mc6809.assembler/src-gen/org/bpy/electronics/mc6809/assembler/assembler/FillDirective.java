/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fill Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.FillDirective#getDirective <em>Directive</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.FillDirective#getValue <em>Value</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.FillDirective#getNumber <em>Number</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getFillDirective()
 * @model
 * @generated
 */
public interface FillDirective extends EObject
{
  /**
   * Returns the value of the '<em><b>Directive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directive</em>' attribute.
   * @see #setDirective(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getFillDirective_Directive()
   * @model
   * @generated
   */
  String getDirective();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.FillDirective#getDirective <em>Directive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Directive</em>' attribute.
   * @see #getDirective()
   * @generated
   */
  void setDirective(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expression)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getFillDirective_Value()
   * @model containment="true"
   * @generated
   */
  Expression getValue();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.FillDirective#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expression value);

  /**
   * Returns the value of the '<em><b>Number</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' containment reference.
   * @see #setNumber(Expression)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getFillDirective_Number()
   * @model containment="true"
   * @generated
   */
  Expression getNumber();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.FillDirective#getNumber <em>Number</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' containment reference.
   * @see #getNumber()
   * @generated
   */
  void setNumber(Expression value);

} // FillDirective

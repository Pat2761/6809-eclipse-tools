/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relative Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RelativeMode#isIsPcRelative <em>Is Pc Relative</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RelativeMode#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRelativeMode()
 * @model
 * @generated
 */
public interface RelativeMode extends EObject
{
  /**
   * Returns the value of the '<em><b>Is Pc Relative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Pc Relative</em>' attribute.
   * @see #setIsPcRelative(boolean)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRelativeMode_IsPcRelative()
   * @model
   * @generated
   */
  boolean isIsPcRelative();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RelativeMode#isIsPcRelative <em>Is Pc Relative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Pc Relative</em>' attribute.
   * @see #isIsPcRelative()
   * @generated
   */
  void setIsPcRelative(boolean value);

  /**
   * Returns the value of the '<em><b>Offset</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Offset</em>' containment reference.
   * @see #setOffset(Expression)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRelativeMode_Offset()
   * @model containment="true"
   * @generated
   */
  Expression getOffset();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RelativeMode#getOffset <em>Offset</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Offset</em>' containment reference.
   * @see #getOffset()
   * @generated
   */
  void setOffset(Expression value);

} // RelativeMode

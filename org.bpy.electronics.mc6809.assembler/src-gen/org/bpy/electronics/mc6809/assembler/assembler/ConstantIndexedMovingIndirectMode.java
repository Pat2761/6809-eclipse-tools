/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Indexed Moving Indirect Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode#getDeplacement <em>Deplacement</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode#getRegister <em>Register</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getConstantIndexedMovingIndirectMode()
 * @model
 * @generated
 */
public interface ConstantIndexedMovingIndirectMode extends EObject
{
  /**
   * Returns the value of the '<em><b>Deplacement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deplacement</em>' containment reference.
   * @see #setDeplacement(NumericalValue)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getConstantIndexedMovingIndirectMode_Deplacement()
   * @model containment="true"
   * @generated
   */
  NumericalValue getDeplacement();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode#getDeplacement <em>Deplacement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deplacement</em>' containment reference.
   * @see #getDeplacement()
   * @generated
   */
  void setDeplacement(NumericalValue value);

  /**
   * Returns the value of the '<em><b>Register</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Register</em>' attribute.
   * @see #setRegister(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getConstantIndexedMovingIndirectMode_Register()
   * @model
   * @generated
   */
  String getRegister();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode#getRegister <em>Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Register</em>' attribute.
   * @see #getRegister()
   * @generated
   */
  void setRegister(String value);

} // ConstantIndexedMovingIndirectMode

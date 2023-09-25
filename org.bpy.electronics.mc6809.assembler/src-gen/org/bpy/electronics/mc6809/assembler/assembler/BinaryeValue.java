/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binarye Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.BinaryeValue#isIsNegative <em>Is Negative</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.BinaryeValue#getBinaryValue <em>Binary Value</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getBinaryeValue()
 * @model
 * @generated
 */
public interface BinaryeValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Is Negative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Negative</em>' attribute.
   * @see #setIsNegative(boolean)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getBinaryeValue_IsNegative()
   * @model
   * @generated
   */
  boolean isIsNegative();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.BinaryeValue#isIsNegative <em>Is Negative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Negative</em>' attribute.
   * @see #isIsNegative()
   * @generated
   */
  void setIsNegative(boolean value);

  /**
   * Returns the value of the '<em><b>Binary Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binary Value</em>' attribute.
   * @see #setBinaryValue(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getBinaryeValue_BinaryValue()
   * @model
   * @generated
   */
  String getBinaryValue();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.BinaryeValue#getBinaryValue <em>Binary Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Binary Value</em>' attribute.
   * @see #getBinaryValue()
   * @generated
   */
  void setBinaryValue(String value);

} // BinaryeValue

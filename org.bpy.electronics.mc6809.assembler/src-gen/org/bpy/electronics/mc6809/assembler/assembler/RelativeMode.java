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
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.RelativeMode#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRelativeMode()
 * @model
 * @generated
 */
public interface RelativeMode extends EObject
{
  /**
   * Returns the value of the '<em><b>Location</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location</em>' containment reference.
   * @see #setLocation(IdentifierValue)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getRelativeMode_Location()
   * @model containment="true"
   * @generated
   */
  IdentifierValue getLocation();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.RelativeMode#getLocation <em>Location</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location</em>' containment reference.
   * @see #getLocation()
   * @generated
   */
  void setLocation(IdentifierValue value);

} // RelativeMode

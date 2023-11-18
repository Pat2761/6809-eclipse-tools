/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.Model#getSourceLines <em>Source Lines</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Source Lines</b></em>' containment reference list.
   * The list contents are of type {@link org.bpy.electronics.mc6809.assembler.assembler.SourceLine}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Lines</em>' containment reference list.
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getModel_SourceLines()
   * @model containment="true"
   * @generated
   */
  EList<SourceLine> getSourceLines();

} // Model

/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opt Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.OptDirective#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.OptDirective#getDirective <em>Directive</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.OptDirective#getOptions <em>Options</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.OptDirective#getComment <em>Comment</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getOptDirective()
 * @model
 * @generated
 */
public interface OptDirective extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(IdentifierValue)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getOptDirective_Name()
   * @model containment="true"
   * @generated
   */
  IdentifierValue getName();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.OptDirective#getName <em>Name</em>}' containment reference.
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
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getOptDirective_Directive()
   * @model
   * @generated
   */
  String getDirective();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.OptDirective#getDirective <em>Directive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Directive</em>' attribute.
   * @see #getDirective()
   * @generated
   */
  void setDirective(String value);

  /**
   * Returns the value of the '<em><b>Options</b></em>' attribute list.
   * The list contents are of type {@link org.bpy.electronics.mc6809.assembler.assembler.AssemblyOption}.
   * The literals are from the enumeration {@link org.bpy.electronics.mc6809.assembler.assembler.AssemblyOption}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Options</em>' attribute list.
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblyOption
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getOptDirective_Options()
   * @model unique="false"
   * @generated
   */
  EList<AssemblyOption> getOptions();

  /**
   * Returns the value of the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' attribute.
   * @see #setComment(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getOptDirective_Comment()
   * @model
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.OptDirective#getComment <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' attribute.
   * @see #getComment()
   * @generated
   */
  void setComment(String value);

} // OptDirective

/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Of Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.ListOfExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.ListOfExpression#getCommaExpressions <em>Comma Expressions</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getListOfExpression()
 * @model
 * @generated
 */
public interface ListOfExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getListOfExpression_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.ListOfExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Comma Expressions</b></em>' containment reference list.
   * The list contents are of type {@link org.bpy.electronics.mc6809.assembler.assembler.CommaExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comma Expressions</em>' containment reference list.
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getListOfExpression_CommaExpressions()
   * @model containment="true"
   * @generated
   */
  EList<CommaExpression> getCommaExpressions();

} // ListOfExpression

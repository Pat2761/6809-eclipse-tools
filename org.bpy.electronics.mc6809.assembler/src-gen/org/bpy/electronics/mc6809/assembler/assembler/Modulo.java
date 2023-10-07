/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modulo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.Modulo#getOpretation <em>Opretation</em>}</li>
 *   <li>{@link org.bpy.electronics.mc6809.assembler.assembler.Modulo#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getModulo()
 * @model
 * @generated
 */
public interface Modulo extends Expression
{
  /**
   * Returns the value of the '<em><b>Opretation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opretation</em>' attribute.
   * @see #setOpretation(String)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getModulo_Opretation()
   * @model
   * @generated
   */
  String getOpretation();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.Modulo#getOpretation <em>Opretation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opretation</em>' attribute.
   * @see #getOpretation()
   * @generated
   */
  void setOpretation(String value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getModulo_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link org.bpy.electronics.mc6809.assembler.assembler.Modulo#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // Modulo

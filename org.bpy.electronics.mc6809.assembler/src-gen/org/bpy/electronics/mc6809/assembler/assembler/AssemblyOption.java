/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Assembly Option</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage#getAssemblyOption()
 * @model
 * @generated
 */
public enum AssemblyOption implements Enumerator
{
  /**
   * The '<em><b>PAG</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PAG_VALUE
   * @generated
   * @ordered
   */
  PAG(0, "PAG", "PAG"),

  /**
   * The '<em><b>NOP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOP_VALUE
   * @generated
   * @ordered
   */
  NOP(1, "NOP", "NOP"),

  /**
   * The '<em><b>CON</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CON_VALUE
   * @generated
   * @ordered
   */
  CON(2, "CON", "CON"),

  /**
   * The '<em><b>NOC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOC_VALUE
   * @generated
   * @ordered
   */
  NOC(3, "NOC", "NOC"),

  /**
   * The '<em><b>MAC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MAC_VALUE
   * @generated
   * @ordered
   */
  MAC(4, "MAC", "MAC"),

  /**
   * The '<em><b>NOM</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOM_VALUE
   * @generated
   * @ordered
   */
  NOM(5, "NOM", "NOM"),

  /**
   * The '<em><b>EXP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXP_VALUE
   * @generated
   * @ordered
   */
  EXP(6, "EXP", "EXP"),

  /**
   * The '<em><b>NOE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOE_VALUE
   * @generated
   * @ordered
   */
  NOE(7, "NOE", "NOE");

  /**
   * The '<em><b>PAG</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PAG
   * @model
   * @generated
   * @ordered
   */
  public static final int PAG_VALUE = 0;

  /**
   * The '<em><b>NOP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOP
   * @model
   * @generated
   * @ordered
   */
  public static final int NOP_VALUE = 1;

  /**
   * The '<em><b>CON</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CON
   * @model
   * @generated
   * @ordered
   */
  public static final int CON_VALUE = 2;

  /**
   * The '<em><b>NOC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOC
   * @model
   * @generated
   * @ordered
   */
  public static final int NOC_VALUE = 3;

  /**
   * The '<em><b>MAC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MAC
   * @model
   * @generated
   * @ordered
   */
  public static final int MAC_VALUE = 4;

  /**
   * The '<em><b>NOM</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOM
   * @model
   * @generated
   * @ordered
   */
  public static final int NOM_VALUE = 5;

  /**
   * The '<em><b>EXP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXP
   * @model
   * @generated
   * @ordered
   */
  public static final int EXP_VALUE = 6;

  /**
   * The '<em><b>NOE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOE
   * @model
   * @generated
   * @ordered
   */
  public static final int NOE_VALUE = 7;

  /**
   * An array of all the '<em><b>Assembly Option</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AssemblyOption[] VALUES_ARRAY =
    new AssemblyOption[]
    {
      PAG,
      NOP,
      CON,
      NOC,
      MAC,
      NOM,
      EXP,
      NOE,
    };

  /**
   * A public read-only list of all the '<em><b>Assembly Option</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AssemblyOption> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Assembly Option</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AssemblyOption get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssemblyOption result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assembly Option</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AssemblyOption getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssemblyOption result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assembly Option</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AssemblyOption get(int value)
  {
    switch (value)
    {
      case PAG_VALUE: return PAG;
      case NOP_VALUE: return NOP;
      case CON_VALUE: return CON;
      case NOC_VALUE: return NOC;
      case MAC_VALUE: return MAC;
      case NOM_VALUE: return NOM;
      case EXP_VALUE: return EXP;
      case NOE_VALUE: return NOE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private AssemblyOption(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //AssemblyOption

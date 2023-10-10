/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.util;

import org.bpy.electronics.mc6809.assembler.assembler.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
 * @generated
 */
public class AssemblerAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AssemblerPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssemblerAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AssemblerPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssemblerSwitch<Adapter> modelSwitch =
    new AssemblerSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseSourceLine(SourceLine object)
      {
        return createSourceLineAdapter();
      }
      @Override
      public Adapter caseBlankLine(BlankLine object)
      {
        return createBlankLineAdapter();
      }
      @Override
      public Adapter caseCommentLine(CommentLine object)
      {
        return createCommentLineAdapter();
      }
      @Override
      public Adapter caseDirectiveLine(DirectiveLine object)
      {
        return createDirectiveLineAdapter();
      }
      @Override
      public Adapter caseEquDirective(EquDirective object)
      {
        return createEquDirectiveAdapter();
      }
      @Override
      public Adapter caseOperand(Operand object)
      {
        return createOperandAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseIdentifierValue(IdentifierValue object)
      {
        return createIdentifierValueAdapter();
      }
      @Override
      public Adapter caseStringValue(StringValue object)
      {
        return createStringValueAdapter();
      }
      @Override
      public Adapter caseDecimalValue(DecimalValue object)
      {
        return createDecimalValueAdapter();
      }
      @Override
      public Adapter caseHexaDecimalValue(HexaDecimalValue object)
      {
        return createHexaDecimalValueAdapter();
      }
      @Override
      public Adapter caseOctalValue(OctalValue object)
      {
        return createOctalValueAdapter();
      }
      @Override
      public Adapter caseBinaryValue(BinaryValue object)
      {
        return createBinaryValueAdapter();
      }
      @Override
      public Adapter caseCharacterValue(CharacterValue object)
      {
        return createCharacterValueAdapter();
      }
      @Override
      public Adapter caseMultiplication(Multiplication object)
      {
        return createMultiplicationAdapter();
      }
      @Override
      public Adapter caseDivision(Division object)
      {
        return createDivisionAdapter();
      }
      @Override
      public Adapter caseModulo(Modulo object)
      {
        return createModuloAdapter();
      }
      @Override
      public Adapter caseAddition(Addition object)
      {
        return createAdditionAdapter();
      }
      @Override
      public Adapter caseSubstraction(Substraction object)
      {
        return createSubstractionAdapter();
      }
      @Override
      public Adapter caseLeftShift(LeftShift object)
      {
        return createLeftShiftAdapter();
      }
      @Override
      public Adapter caseRigthShift(RigthShift object)
      {
        return createRigthShiftAdapter();
      }
      @Override
      public Adapter caseNegate(Negate object)
      {
        return createNegateAdapter();
      }
      @Override
      public Adapter caseAnd(And object)
      {
        return createAndAdapter();
      }
      @Override
      public Adapter caseOr(Or object)
      {
        return createOrAdapter();
      }
      @Override
      public Adapter caseXor(Xor object)
      {
        return createXorAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.SourceLine <em>Source Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.SourceLine
   * @generated
   */
  public Adapter createSourceLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.BlankLine <em>Blank Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.BlankLine
   * @generated
   */
  public Adapter createBlankLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.CommentLine <em>Comment Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.CommentLine
   * @generated
   */
  public Adapter createCommentLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine <em>Directive Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine
   * @generated
   */
  public Adapter createDirectiveLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.EquDirective <em>Equ Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.EquDirective
   * @generated
   */
  public Adapter createEquDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Operand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Operand
   * @generated
   */
  public Adapter createOperandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.IdentifierValue <em>Identifier Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.IdentifierValue
   * @generated
   */
  public Adapter createIdentifierValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.StringValue
   * @generated
   */
  public Adapter createStringValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.DecimalValue <em>Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.DecimalValue
   * @generated
   */
  public Adapter createDecimalValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.HexaDecimalValue <em>Hexa Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.HexaDecimalValue
   * @generated
   */
  public Adapter createHexaDecimalValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.OctalValue <em>Octal Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.OctalValue
   * @generated
   */
  public Adapter createOctalValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.BinaryValue <em>Binary Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.BinaryValue
   * @generated
   */
  public Adapter createBinaryValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.CharacterValue <em>Character Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.CharacterValue
   * @generated
   */
  public Adapter createCharacterValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Multiplication <em>Multiplication</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Multiplication
   * @generated
   */
  public Adapter createMultiplicationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Division <em>Division</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Division
   * @generated
   */
  public Adapter createDivisionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Modulo <em>Modulo</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Modulo
   * @generated
   */
  public Adapter createModuloAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Addition <em>Addition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Addition
   * @generated
   */
  public Adapter createAdditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Substraction <em>Substraction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Substraction
   * @generated
   */
  public Adapter createSubstractionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.LeftShift <em>Left Shift</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.LeftShift
   * @generated
   */
  public Adapter createLeftShiftAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.RigthShift <em>Rigth Shift</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.RigthShift
   * @generated
   */
  public Adapter createRigthShiftAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Negate <em>Negate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Negate
   * @generated
   */
  public Adapter createNegateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.And <em>And</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.And
   * @generated
   */
  public Adapter createAndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Or <em>Or</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Or
   * @generated
   */
  public Adapter createOrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.bpy.electronics.mc6809.assembler.assembler.Xor <em>Xor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.bpy.electronics.mc6809.assembler.assembler.Xor
   * @generated
   */
  public Adapter createXorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AssemblerAdapterFactory

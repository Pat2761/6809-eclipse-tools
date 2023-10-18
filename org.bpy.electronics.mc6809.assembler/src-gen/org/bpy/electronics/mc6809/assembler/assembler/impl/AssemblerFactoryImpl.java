/**
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.assembler.impl;

import org.bpy.electronics.mc6809.assembler.assembler.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssemblerFactoryImpl extends EFactoryImpl implements AssemblerFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssemblerFactory init()
  {
    try
    {
      AssemblerFactory theAssemblerFactory = (AssemblerFactory)EPackage.Registry.INSTANCE.getEFactory(AssemblerPackage.eNS_URI);
      if (theAssemblerFactory != null)
      {
        return theAssemblerFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AssemblerFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssemblerFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AssemblerPackage.MODEL: return createModel();
      case AssemblerPackage.SOURCE_LINE: return createSourceLine();
      case AssemblerPackage.BLANK_LINE: return createBlankLine();
      case AssemblerPackage.COMMENT_LINE: return createCommentLine();
      case AssemblerPackage.DIRECTIVE_LINE: return createDirectiveLine();
      case AssemblerPackage.NAM_DIRECTIVE: return createNamDirective();
      case AssemblerPackage.PAG_DIRECTIVE: return createPagDirective();
      case AssemblerPackage.OPT_DIRECTIVE: return createOptDirective();
      case AssemblerPackage.FAIL_DIRECTIVE: return createFailDirective();
      case AssemblerPackage.SET_DIRECTIVE: return createSetDirective();
      case AssemblerPackage.FILL_DIRECTIVE: return createFillDirective();
      case AssemblerPackage.BSZ_DIRECTIVE: return createBszDirective();
      case AssemblerPackage.FDB_DIRECTIVE: return createFdbDirective();
      case AssemblerPackage.FCB_DIRECTIVE: return createFcbDirective();
      case AssemblerPackage.RMB_DIRECTIVE: return createRmbDirective();
      case AssemblerPackage.END_DIRECTIVE: return createEndDirective();
      case AssemblerPackage.ORG_DIRECTIVE: return createOrgDirective();
      case AssemblerPackage.EQU_DIRECTIVE: return createEquDirective();
      case AssemblerPackage.LIST_OF_EXPRESSION: return createListOfExpression();
      case AssemblerPackage.EXPRESSION: return createExpression();
      case AssemblerPackage.IDENTIFIER_VALUE: return createIdentifierValue();
      case AssemblerPackage.STRING_VALUE: return createStringValue();
      case AssemblerPackage.DECIMAL_VALUE: return createDecimalValue();
      case AssemblerPackage.HEXA_DECIMAL_VALUE: return createHexaDecimalValue();
      case AssemblerPackage.OCTAL_VALUE: return createOctalValue();
      case AssemblerPackage.BINARY_VALUE: return createBinaryValue();
      case AssemblerPackage.CHARACTER_VALUE: return createCharacterValue();
      case AssemblerPackage.MULTIPLICATION: return createMultiplication();
      case AssemblerPackage.DIVISION: return createDivision();
      case AssemblerPackage.MODULO: return createModulo();
      case AssemblerPackage.ADDITION: return createAddition();
      case AssemblerPackage.SUBSTRACTION: return createSubstraction();
      case AssemblerPackage.LEFT_SHIFT: return createLeftShift();
      case AssemblerPackage.RIGHT_SHIFT: return createRightShift();
      case AssemblerPackage.AND: return createAnd();
      case AssemblerPackage.OR: return createOr();
      case AssemblerPackage.XOR: return createXor();
      case AssemblerPackage.NOT: return createNot();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AssemblerPackage.ASSEMBLY_OPTION:
        return createAssemblyOptionFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AssemblerPackage.ASSEMBLY_OPTION:
        return convertAssemblyOptionToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SourceLine createSourceLine()
  {
    SourceLineImpl sourceLine = new SourceLineImpl();
    return sourceLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BlankLine createBlankLine()
  {
    BlankLineImpl blankLine = new BlankLineImpl();
    return blankLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CommentLine createCommentLine()
  {
    CommentLineImpl commentLine = new CommentLineImpl();
    return commentLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DirectiveLine createDirectiveLine()
  {
    DirectiveLineImpl directiveLine = new DirectiveLineImpl();
    return directiveLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamDirective createNamDirective()
  {
    NamDirectiveImpl namDirective = new NamDirectiveImpl();
    return namDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PagDirective createPagDirective()
  {
    PagDirectiveImpl pagDirective = new PagDirectiveImpl();
    return pagDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OptDirective createOptDirective()
  {
    OptDirectiveImpl optDirective = new OptDirectiveImpl();
    return optDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FailDirective createFailDirective()
  {
    FailDirectiveImpl failDirective = new FailDirectiveImpl();
    return failDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SetDirective createSetDirective()
  {
    SetDirectiveImpl setDirective = new SetDirectiveImpl();
    return setDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FillDirective createFillDirective()
  {
    FillDirectiveImpl fillDirective = new FillDirectiveImpl();
    return fillDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BszDirective createBszDirective()
  {
    BszDirectiveImpl bszDirective = new BszDirectiveImpl();
    return bszDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FdbDirective createFdbDirective()
  {
    FdbDirectiveImpl fdbDirective = new FdbDirectiveImpl();
    return fdbDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FcbDirective createFcbDirective()
  {
    FcbDirectiveImpl fcbDirective = new FcbDirectiveImpl();
    return fcbDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RmbDirective createRmbDirective()
  {
    RmbDirectiveImpl rmbDirective = new RmbDirectiveImpl();
    return rmbDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EndDirective createEndDirective()
  {
    EndDirectiveImpl endDirective = new EndDirectiveImpl();
    return endDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OrgDirective createOrgDirective()
  {
    OrgDirectiveImpl orgDirective = new OrgDirectiveImpl();
    return orgDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EquDirective createEquDirective()
  {
    EquDirectiveImpl equDirective = new EquDirectiveImpl();
    return equDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ListOfExpression createListOfExpression()
  {
    ListOfExpressionImpl listOfExpression = new ListOfExpressionImpl();
    return listOfExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IdentifierValue createIdentifierValue()
  {
    IdentifierValueImpl identifierValue = new IdentifierValueImpl();
    return identifierValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StringValue createStringValue()
  {
    StringValueImpl stringValue = new StringValueImpl();
    return stringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DecimalValue createDecimalValue()
  {
    DecimalValueImpl decimalValue = new DecimalValueImpl();
    return decimalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HexaDecimalValue createHexaDecimalValue()
  {
    HexaDecimalValueImpl hexaDecimalValue = new HexaDecimalValueImpl();
    return hexaDecimalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OctalValue createOctalValue()
  {
    OctalValueImpl octalValue = new OctalValueImpl();
    return octalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BinaryValue createBinaryValue()
  {
    BinaryValueImpl binaryValue = new BinaryValueImpl();
    return binaryValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CharacterValue createCharacterValue()
  {
    CharacterValueImpl characterValue = new CharacterValueImpl();
    return characterValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Multiplication createMultiplication()
  {
    MultiplicationImpl multiplication = new MultiplicationImpl();
    return multiplication;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Division createDivision()
  {
    DivisionImpl division = new DivisionImpl();
    return division;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Modulo createModulo()
  {
    ModuloImpl modulo = new ModuloImpl();
    return modulo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Addition createAddition()
  {
    AdditionImpl addition = new AdditionImpl();
    return addition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Substraction createSubstraction()
  {
    SubstractionImpl substraction = new SubstractionImpl();
    return substraction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LeftShift createLeftShift()
  {
    LeftShiftImpl leftShift = new LeftShiftImpl();
    return leftShift;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RightShift createRightShift()
  {
    RightShiftImpl rightShift = new RightShiftImpl();
    return rightShift;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public And createAnd()
  {
    AndImpl and = new AndImpl();
    return and;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Or createOr()
  {
    OrImpl or = new OrImpl();
    return or;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Xor createXor()
  {
    XorImpl xor = new XorImpl();
    return xor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Not createNot()
  {
    NotImpl not = new NotImpl();
    return not;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssemblyOption createAssemblyOptionFromString(EDataType eDataType, String initialValue)
  {
    AssemblyOption result = AssemblyOption.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssemblyOptionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssemblerPackage getAssemblerPackage()
  {
    return (AssemblerPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AssemblerPackage getPackage()
  {
    return AssemblerPackage.eINSTANCE;
  }

} //AssemblerFactoryImpl

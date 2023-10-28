/**
 * generated by Xtext 2.28.0
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
      case AssemblerPackage.INSTRUCTION_LINE: return createInstructionLine();
      case AssemblerPackage.EXG_INSTRUCTION: return createExgInstruction();
      case AssemblerPackage.EOR_INSTRUCTION: return createEorInstruction();
      case AssemblerPackage.DEC_INSTRUCTION: return createDecInstruction();
      case AssemblerPackage.DAA_INSTRUCTION: return createDaaInstruction();
      case AssemblerPackage.CWAI_INSTRUCTION: return createCwaiInstruction();
      case AssemblerPackage.COM_INSTRUCTION: return createComInstruction();
      case AssemblerPackage.CMP_INSTRUCTION: return createCmpInstruction();
      case AssemblerPackage.CLR_INSTRUCTION: return createClrInstruction();
      case AssemblerPackage.BVS_INSTRUCTION: return createBvsInstruction();
      case AssemblerPackage.BVC_INSTRUCTION: return createBvcInstruction();
      case AssemblerPackage.BSR_INSTRUCTION: return createBsrInstruction();
      case AssemblerPackage.BRN_INSTRUCTION: return createBrnInstruction();
      case AssemblerPackage.BRA_INSTRUCTION: return createBraInstruction();
      case AssemblerPackage.BPL_INSTRUCTION: return createBplInstruction();
      case AssemblerPackage.BNE_INSTRUCTION: return createBneInstruction();
      case AssemblerPackage.BMI_INSTRUCTION: return createBmiInstruction();
      case AssemblerPackage.BLT_INSTRUCTION: return createBltInstruction();
      case AssemblerPackage.BLS_INSTRUCTION: return createBlsInstruction();
      case AssemblerPackage.BLO_INSTRUCTION: return createBloInstruction();
      case AssemblerPackage.BLE_INSTRUCTION: return createBleInstruction();
      case AssemblerPackage.BIT_INSTRUCTION: return createBitInstruction();
      case AssemblerPackage.BHS_INSTRUCTION: return createBhsInstruction();
      case AssemblerPackage.BHI_INSTRUCTION: return createBhiInstruction();
      case AssemblerPackage.BGT_INSTRUCTION: return createBgtInstruction();
      case AssemblerPackage.BGE_INSTRUCTION: return createBgeInstruction();
      case AssemblerPackage.BEQ_INSTRUCTION: return createBeqInstruction();
      case AssemblerPackage.BCS_INSTRUCTION: return createBcsInstruction();
      case AssemblerPackage.BCC_INSTRUCTION: return createBccInstruction();
      case AssemblerPackage.ASR_INSTRUCTION: return createAsrInstruction();
      case AssemblerPackage.ASL_INSTRUCTION: return createAslInstruction();
      case AssemblerPackage.AND_CC_INSTRUCTION: return createAndCCInstruction();
      case AssemblerPackage.AND_INSTRUCTION: return createAndInstruction();
      case AssemblerPackage.ADDD_INSTRUCTION: return createAdddInstruction();
      case AssemblerPackage.ADD_INSTRUCTION: return createAddInstruction();
      case AssemblerPackage.ADC_INSTRUCTION: return createAdcInstruction();
      case AssemblerPackage.ABX_INSTRUCTION: return createAbxInstruction();
      case AssemblerPackage.EXTENDED_INDIRECT_OPERAND: return createExtendedIndirectOperand();
      case AssemblerPackage.EXTENDED_OPERAND: return createExtendedOperand();
      case AssemblerPackage.DIRECT_OPERAND: return createDirectOperand();
      case AssemblerPackage.IMMEDIAT_OPERAND: return createImmediatOperand();
      case AssemblerPackage.INDEXED_OPERAND: return createIndexedOperand();
      case AssemblerPackage.CONSTANT_INDEXED_MODE: return createConstantIndexedMode();
      case AssemblerPackage.CONSTANT_INDEXED_MOVING_INDIRECT_MODE: return createConstantIndexedMovingIndirectMode();
      case AssemblerPackage.ACCUMULATOR_MOVING_MODE: return createAccumulatorMovingMode();
      case AssemblerPackage.ACCUMULATOR_MOVING_INDIRECT_MODE: return createAccumulatorMovingIndirectMode();
      case AssemblerPackage.AUTO_INC_DEC_MODE: return createAutoIncDecMode();
      case AssemblerPackage.AUTO_INC_DEC_INDIRECT_MODE: return createAutoIncDecIndirectMode();
      case AssemblerPackage.RELATIF_TO_PC_MODE: return createRelatifToPCMode();
      case AssemblerPackage.RELATIF_TO_PC_INDIRECT_MODE: return createRelatifToPCIndirectMode();
      case AssemblerPackage.RELATIVE_MODE: return createRelativeMode();
      case AssemblerPackage.DIRECTIVE_LINE: return createDirectiveLine();
      case AssemblerPackage.FCC_DIRECTIVE: return createFccDirective();
      case AssemblerPackage.REG_DIRECTIVE: return createRegDirective();
      case AssemblerPackage.SPC_DIRECTIVE: return createSpcDirective();
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
      case AssemblerPackage.NUMERICAL_VALUE: return createNumericalValue();
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
      case AssemblerPackage.REGISTER:
        return createRegisterFromString(eDataType, initialValue);
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
      case AssemblerPackage.REGISTER:
        return convertRegisterToString(eDataType, instanceValue);
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
  public InstructionLine createInstructionLine()
  {
    InstructionLineImpl instructionLine = new InstructionLineImpl();
    return instructionLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExgInstruction createExgInstruction()
  {
    ExgInstructionImpl exgInstruction = new ExgInstructionImpl();
    return exgInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EorInstruction createEorInstruction()
  {
    EorInstructionImpl eorInstruction = new EorInstructionImpl();
    return eorInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DecInstruction createDecInstruction()
  {
    DecInstructionImpl decInstruction = new DecInstructionImpl();
    return decInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DaaInstruction createDaaInstruction()
  {
    DaaInstructionImpl daaInstruction = new DaaInstructionImpl();
    return daaInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CwaiInstruction createCwaiInstruction()
  {
    CwaiInstructionImpl cwaiInstruction = new CwaiInstructionImpl();
    return cwaiInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ComInstruction createComInstruction()
  {
    ComInstructionImpl comInstruction = new ComInstructionImpl();
    return comInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CmpInstruction createCmpInstruction()
  {
    CmpInstructionImpl cmpInstruction = new CmpInstructionImpl();
    return cmpInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClrInstruction createClrInstruction()
  {
    ClrInstructionImpl clrInstruction = new ClrInstructionImpl();
    return clrInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BvsInstruction createBvsInstruction()
  {
    BvsInstructionImpl bvsInstruction = new BvsInstructionImpl();
    return bvsInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BvcInstruction createBvcInstruction()
  {
    BvcInstructionImpl bvcInstruction = new BvcInstructionImpl();
    return bvcInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BsrInstruction createBsrInstruction()
  {
    BsrInstructionImpl bsrInstruction = new BsrInstructionImpl();
    return bsrInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BrnInstruction createBrnInstruction()
  {
    BrnInstructionImpl brnInstruction = new BrnInstructionImpl();
    return brnInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BraInstruction createBraInstruction()
  {
    BraInstructionImpl braInstruction = new BraInstructionImpl();
    return braInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BplInstruction createBplInstruction()
  {
    BplInstructionImpl bplInstruction = new BplInstructionImpl();
    return bplInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BneInstruction createBneInstruction()
  {
    BneInstructionImpl bneInstruction = new BneInstructionImpl();
    return bneInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BmiInstruction createBmiInstruction()
  {
    BmiInstructionImpl bmiInstruction = new BmiInstructionImpl();
    return bmiInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BltInstruction createBltInstruction()
  {
    BltInstructionImpl bltInstruction = new BltInstructionImpl();
    return bltInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BlsInstruction createBlsInstruction()
  {
    BlsInstructionImpl blsInstruction = new BlsInstructionImpl();
    return blsInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BloInstruction createBloInstruction()
  {
    BloInstructionImpl bloInstruction = new BloInstructionImpl();
    return bloInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BleInstruction createBleInstruction()
  {
    BleInstructionImpl bleInstruction = new BleInstructionImpl();
    return bleInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BitInstruction createBitInstruction()
  {
    BitInstructionImpl bitInstruction = new BitInstructionImpl();
    return bitInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BhsInstruction createBhsInstruction()
  {
    BhsInstructionImpl bhsInstruction = new BhsInstructionImpl();
    return bhsInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BhiInstruction createBhiInstruction()
  {
    BhiInstructionImpl bhiInstruction = new BhiInstructionImpl();
    return bhiInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BgtInstruction createBgtInstruction()
  {
    BgtInstructionImpl bgtInstruction = new BgtInstructionImpl();
    return bgtInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BgeInstruction createBgeInstruction()
  {
    BgeInstructionImpl bgeInstruction = new BgeInstructionImpl();
    return bgeInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BeqInstruction createBeqInstruction()
  {
    BeqInstructionImpl beqInstruction = new BeqInstructionImpl();
    return beqInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BcsInstruction createBcsInstruction()
  {
    BcsInstructionImpl bcsInstruction = new BcsInstructionImpl();
    return bcsInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BccInstruction createBccInstruction()
  {
    BccInstructionImpl bccInstruction = new BccInstructionImpl();
    return bccInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AsrInstruction createAsrInstruction()
  {
    AsrInstructionImpl asrInstruction = new AsrInstructionImpl();
    return asrInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AslInstruction createAslInstruction()
  {
    AslInstructionImpl aslInstruction = new AslInstructionImpl();
    return aslInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndCCInstruction createAndCCInstruction()
  {
    AndCCInstructionImpl andCCInstruction = new AndCCInstructionImpl();
    return andCCInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndInstruction createAndInstruction()
  {
    AndInstructionImpl andInstruction = new AndInstructionImpl();
    return andInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AdddInstruction createAdddInstruction()
  {
    AdddInstructionImpl adddInstruction = new AdddInstructionImpl();
    return adddInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AddInstruction createAddInstruction()
  {
    AddInstructionImpl addInstruction = new AddInstructionImpl();
    return addInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AdcInstruction createAdcInstruction()
  {
    AdcInstructionImpl adcInstruction = new AdcInstructionImpl();
    return adcInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbxInstruction createAbxInstruction()
  {
    AbxInstructionImpl abxInstruction = new AbxInstructionImpl();
    return abxInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExtendedIndirectOperand createExtendedIndirectOperand()
  {
    ExtendedIndirectOperandImpl extendedIndirectOperand = new ExtendedIndirectOperandImpl();
    return extendedIndirectOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExtendedOperand createExtendedOperand()
  {
    ExtendedOperandImpl extendedOperand = new ExtendedOperandImpl();
    return extendedOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DirectOperand createDirectOperand()
  {
    DirectOperandImpl directOperand = new DirectOperandImpl();
    return directOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImmediatOperand createImmediatOperand()
  {
    ImmediatOperandImpl immediatOperand = new ImmediatOperandImpl();
    return immediatOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IndexedOperand createIndexedOperand()
  {
    IndexedOperandImpl indexedOperand = new IndexedOperandImpl();
    return indexedOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConstantIndexedMode createConstantIndexedMode()
  {
    ConstantIndexedModeImpl constantIndexedMode = new ConstantIndexedModeImpl();
    return constantIndexedMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConstantIndexedMovingIndirectMode createConstantIndexedMovingIndirectMode()
  {
    ConstantIndexedMovingIndirectModeImpl constantIndexedMovingIndirectMode = new ConstantIndexedMovingIndirectModeImpl();
    return constantIndexedMovingIndirectMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AccumulatorMovingMode createAccumulatorMovingMode()
  {
    AccumulatorMovingModeImpl accumulatorMovingMode = new AccumulatorMovingModeImpl();
    return accumulatorMovingMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AccumulatorMovingIndirectMode createAccumulatorMovingIndirectMode()
  {
    AccumulatorMovingIndirectModeImpl accumulatorMovingIndirectMode = new AccumulatorMovingIndirectModeImpl();
    return accumulatorMovingIndirectMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AutoIncDecMode createAutoIncDecMode()
  {
    AutoIncDecModeImpl autoIncDecMode = new AutoIncDecModeImpl();
    return autoIncDecMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AutoIncDecIndirectMode createAutoIncDecIndirectMode()
  {
    AutoIncDecIndirectModeImpl autoIncDecIndirectMode = new AutoIncDecIndirectModeImpl();
    return autoIncDecIndirectMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RelatifToPCMode createRelatifToPCMode()
  {
    RelatifToPCModeImpl relatifToPCMode = new RelatifToPCModeImpl();
    return relatifToPCMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RelatifToPCIndirectMode createRelatifToPCIndirectMode()
  {
    RelatifToPCIndirectModeImpl relatifToPCIndirectMode = new RelatifToPCIndirectModeImpl();
    return relatifToPCIndirectMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RelativeMode createRelativeMode()
  {
    RelativeModeImpl relativeMode = new RelativeModeImpl();
    return relativeMode;
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
  public FccDirective createFccDirective()
  {
    FccDirectiveImpl fccDirective = new FccDirectiveImpl();
    return fccDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RegDirective createRegDirective()
  {
    RegDirectiveImpl regDirective = new RegDirectiveImpl();
    return regDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SpcDirective createSpcDirective()
  {
    SpcDirectiveImpl spcDirective = new SpcDirectiveImpl();
    return spcDirective;
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
  public NumericalValue createNumericalValue()
  {
    NumericalValueImpl numericalValue = new NumericalValueImpl();
    return numericalValue;
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
  public Register createRegisterFromString(EDataType eDataType, String initialValue)
  {
    Register result = Register.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRegisterToString(EDataType eDataType, Object instanceValue)
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

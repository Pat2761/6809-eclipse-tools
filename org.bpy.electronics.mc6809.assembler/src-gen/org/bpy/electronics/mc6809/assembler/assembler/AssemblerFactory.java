/**
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.assembler;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
 * @generated
 */
public interface AssemblerFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AssemblerFactory eINSTANCE = org.bpy.electronics.mc6809.assembler.assembler.impl.AssemblerFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Source Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Source Line</em>'.
   * @generated
   */
  SourceLine createSourceLine();

  /**
   * Returns a new object of class '<em>Blank Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Blank Line</em>'.
   * @generated
   */
  BlankLine createBlankLine();

  /**
   * Returns a new object of class '<em>Comment Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comment Line</em>'.
   * @generated
   */
  CommentLine createCommentLine();

  /**
   * Returns a new object of class '<em>Instruction Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instruction Line</em>'.
   * @generated
   */
  InstructionLine createInstructionLine();

  /**
   * Returns a new object of class '<em>Tst Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tst Instruction</em>'.
   * @generated
   */
  TstInstruction createTstInstruction();

  /**
   * Returns a new object of class '<em>Tfr Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tfr Instruction</em>'.
   * @generated
   */
  TfrInstruction createTfrInstruction();

  /**
   * Returns a new object of class '<em>Sync Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sync Instruction</em>'.
   * @generated
   */
  SyncInstruction createSyncInstruction();

  /**
   * Returns a new object of class '<em>Swi3 Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Swi3 Instruction</em>'.
   * @generated
   */
  Swi3Instruction createSwi3Instruction();

  /**
   * Returns a new object of class '<em>Swi2 Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Swi2 Instruction</em>'.
   * @generated
   */
  Swi2Instruction createSwi2Instruction();

  /**
   * Returns a new object of class '<em>Swi Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Swi Instruction</em>'.
   * @generated
   */
  SwiInstruction createSwiInstruction();

  /**
   * Returns a new object of class '<em>Subd Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subd Instruction</em>'.
   * @generated
   */
  SubdInstruction createSubdInstruction();

  /**
   * Returns a new object of class '<em>Sub Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Instruction</em>'.
   * @generated
   */
  SubInstruction createSubInstruction();

  /**
   * Returns a new object of class '<em>St Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>St Instruction</em>'.
   * @generated
   */
  StInstruction createStInstruction();

  /**
   * Returns a new object of class '<em>Sex Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sex Instruction</em>'.
   * @generated
   */
  SexInstruction createSexInstruction();

  /**
   * Returns a new object of class '<em>Sbc Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sbc Instruction</em>'.
   * @generated
   */
  SbcInstruction createSbcInstruction();

  /**
   * Returns a new object of class '<em>Rts Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rts Instruction</em>'.
   * @generated
   */
  RtsInstruction createRtsInstruction();

  /**
   * Returns a new object of class '<em>Rti Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rti Instruction</em>'.
   * @generated
   */
  RtiInstruction createRtiInstruction();

  /**
   * Returns a new object of class '<em>Ror Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ror Instruction</em>'.
   * @generated
   */
  RorInstruction createRorInstruction();

  /**
   * Returns a new object of class '<em>Rol Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rol Instruction</em>'.
   * @generated
   */
  RolInstruction createRolInstruction();

  /**
   * Returns a new object of class '<em>Pulu Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pulu Instruction</em>'.
   * @generated
   */
  PuluInstruction createPuluInstruction();

  /**
   * Returns a new object of class '<em>Puls Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Puls Instruction</em>'.
   * @generated
   */
  PulsInstruction createPulsInstruction();

  /**
   * Returns a new object of class '<em>Pshu Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pshu Instruction</em>'.
   * @generated
   */
  PshuInstruction createPshuInstruction();

  /**
   * Returns a new object of class '<em>Pshs Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pshs Instruction</em>'.
   * @generated
   */
  PshsInstruction createPshsInstruction();

  /**
   * Returns a new object of class '<em>Or CC Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or CC Instruction</em>'.
   * @generated
   */
  OrCCInstruction createOrCCInstruction();

  /**
   * Returns a new object of class '<em>Or Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Instruction</em>'.
   * @generated
   */
  OrInstruction createOrInstruction();

  /**
   * Returns a new object of class '<em>Nop Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nop Instruction</em>'.
   * @generated
   */
  NopInstruction createNopInstruction();

  /**
   * Returns a new object of class '<em>Neg Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Neg Instruction</em>'.
   * @generated
   */
  NegInstruction createNegInstruction();

  /**
   * Returns a new object of class '<em>Mul Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mul Instruction</em>'.
   * @generated
   */
  MulInstruction createMulInstruction();

  /**
   * Returns a new object of class '<em>Lsr Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lsr Instruction</em>'.
   * @generated
   */
  LsrInstruction createLsrInstruction();

  /**
   * Returns a new object of class '<em>Lsl Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lsl Instruction</em>'.
   * @generated
   */
  LslInstruction createLslInstruction();

  /**
   * Returns a new object of class '<em>Lea Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lea Instruction</em>'.
   * @generated
   */
  LeaInstruction createLeaInstruction();

  /**
   * Returns a new object of class '<em>Ld Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ld Instruction</em>'.
   * @generated
   */
  LdInstruction createLdInstruction();

  /**
   * Returns a new object of class '<em>Jsr Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Jsr Instruction</em>'.
   * @generated
   */
  JsrInstruction createJsrInstruction();

  /**
   * Returns a new object of class '<em>Jmp Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Jmp Instruction</em>'.
   * @generated
   */
  JmpInstruction createJmpInstruction();

  /**
   * Returns a new object of class '<em>Inc Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inc Instruction</em>'.
   * @generated
   */
  IncInstruction createIncInstruction();

  /**
   * Returns a new object of class '<em>Exg Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exg Instruction</em>'.
   * @generated
   */
  ExgInstruction createExgInstruction();

  /**
   * Returns a new object of class '<em>Eor Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Eor Instruction</em>'.
   * @generated
   */
  EorInstruction createEorInstruction();

  /**
   * Returns a new object of class '<em>Dec Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dec Instruction</em>'.
   * @generated
   */
  DecInstruction createDecInstruction();

  /**
   * Returns a new object of class '<em>Daa Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Daa Instruction</em>'.
   * @generated
   */
  DaaInstruction createDaaInstruction();

  /**
   * Returns a new object of class '<em>Cwai Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cwai Instruction</em>'.
   * @generated
   */
  CwaiInstruction createCwaiInstruction();

  /**
   * Returns a new object of class '<em>Com Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Com Instruction</em>'.
   * @generated
   */
  ComInstruction createComInstruction();

  /**
   * Returns a new object of class '<em>Cmp Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cmp Instruction</em>'.
   * @generated
   */
  CmpInstruction createCmpInstruction();

  /**
   * Returns a new object of class '<em>Clr Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Clr Instruction</em>'.
   * @generated
   */
  ClrInstruction createClrInstruction();

  /**
   * Returns a new object of class '<em>Bvs Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bvs Instruction</em>'.
   * @generated
   */
  BvsInstruction createBvsInstruction();

  /**
   * Returns a new object of class '<em>Bvc Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bvc Instruction</em>'.
   * @generated
   */
  BvcInstruction createBvcInstruction();

  /**
   * Returns a new object of class '<em>Bsr Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bsr Instruction</em>'.
   * @generated
   */
  BsrInstruction createBsrInstruction();

  /**
   * Returns a new object of class '<em>Brn Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Brn Instruction</em>'.
   * @generated
   */
  BrnInstruction createBrnInstruction();

  /**
   * Returns a new object of class '<em>Bra Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bra Instruction</em>'.
   * @generated
   */
  BraInstruction createBraInstruction();

  /**
   * Returns a new object of class '<em>Bpl Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bpl Instruction</em>'.
   * @generated
   */
  BplInstruction createBplInstruction();

  /**
   * Returns a new object of class '<em>Bne Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bne Instruction</em>'.
   * @generated
   */
  BneInstruction createBneInstruction();

  /**
   * Returns a new object of class '<em>Bmi Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bmi Instruction</em>'.
   * @generated
   */
  BmiInstruction createBmiInstruction();

  /**
   * Returns a new object of class '<em>Blt Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Blt Instruction</em>'.
   * @generated
   */
  BltInstruction createBltInstruction();

  /**
   * Returns a new object of class '<em>Bls Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bls Instruction</em>'.
   * @generated
   */
  BlsInstruction createBlsInstruction();

  /**
   * Returns a new object of class '<em>Blo Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Blo Instruction</em>'.
   * @generated
   */
  BloInstruction createBloInstruction();

  /**
   * Returns a new object of class '<em>Ble Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ble Instruction</em>'.
   * @generated
   */
  BleInstruction createBleInstruction();

  /**
   * Returns a new object of class '<em>Bit Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bit Instruction</em>'.
   * @generated
   */
  BitInstruction createBitInstruction();

  /**
   * Returns a new object of class '<em>Bhs Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bhs Instruction</em>'.
   * @generated
   */
  BhsInstruction createBhsInstruction();

  /**
   * Returns a new object of class '<em>Bhi Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bhi Instruction</em>'.
   * @generated
   */
  BhiInstruction createBhiInstruction();

  /**
   * Returns a new object of class '<em>Bgt Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bgt Instruction</em>'.
   * @generated
   */
  BgtInstruction createBgtInstruction();

  /**
   * Returns a new object of class '<em>Bge Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bge Instruction</em>'.
   * @generated
   */
  BgeInstruction createBgeInstruction();

  /**
   * Returns a new object of class '<em>Beq Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Beq Instruction</em>'.
   * @generated
   */
  BeqInstruction createBeqInstruction();

  /**
   * Returns a new object of class '<em>Bcs Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bcs Instruction</em>'.
   * @generated
   */
  BcsInstruction createBcsInstruction();

  /**
   * Returns a new object of class '<em>Bcc Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bcc Instruction</em>'.
   * @generated
   */
  BccInstruction createBccInstruction();

  /**
   * Returns a new object of class '<em>Asr Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asr Instruction</em>'.
   * @generated
   */
  AsrInstruction createAsrInstruction();

  /**
   * Returns a new object of class '<em>Asl Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asl Instruction</em>'.
   * @generated
   */
  AslInstruction createAslInstruction();

  /**
   * Returns a new object of class '<em>And CC Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And CC Instruction</em>'.
   * @generated
   */
  AndCCInstruction createAndCCInstruction();

  /**
   * Returns a new object of class '<em>And Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Instruction</em>'.
   * @generated
   */
  AndInstruction createAndInstruction();

  /**
   * Returns a new object of class '<em>Addd Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Addd Instruction</em>'.
   * @generated
   */
  AdddInstruction createAdddInstruction();

  /**
   * Returns a new object of class '<em>Add Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Add Instruction</em>'.
   * @generated
   */
  AddInstruction createAddInstruction();

  /**
   * Returns a new object of class '<em>Adc Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Adc Instruction</em>'.
   * @generated
   */
  AdcInstruction createAdcInstruction();

  /**
   * Returns a new object of class '<em>Abx Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abx Instruction</em>'.
   * @generated
   */
  AbxInstruction createAbxInstruction();

  /**
   * Returns a new object of class '<em>Extended Indirect Operand</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extended Indirect Operand</em>'.
   * @generated
   */
  ExtendedIndirectOperand createExtendedIndirectOperand();

  /**
   * Returns a new object of class '<em>Extended Operand</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extended Operand</em>'.
   * @generated
   */
  ExtendedOperand createExtendedOperand();

  /**
   * Returns a new object of class '<em>Direct Operand</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Direct Operand</em>'.
   * @generated
   */
  DirectOperand createDirectOperand();

  /**
   * Returns a new object of class '<em>Immediat Operand</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Immediat Operand</em>'.
   * @generated
   */
  ImmediatOperand createImmediatOperand();

  /**
   * Returns a new object of class '<em>Indexed Operand</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Indexed Operand</em>'.
   * @generated
   */
  IndexedOperand createIndexedOperand();

  /**
   * Returns a new object of class '<em>Constant Indexed Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Indexed Mode</em>'.
   * @generated
   */
  ConstantIndexedMode createConstantIndexedMode();

  /**
   * Returns a new object of class '<em>Constant Indexed Moving Indirect Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Indexed Moving Indirect Mode</em>'.
   * @generated
   */
  ConstantIndexedMovingIndirectMode createConstantIndexedMovingIndirectMode();

  /**
   * Returns a new object of class '<em>Accumulator Moving Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accumulator Moving Mode</em>'.
   * @generated
   */
  AccumulatorMovingMode createAccumulatorMovingMode();

  /**
   * Returns a new object of class '<em>Accumulator Moving Indirect Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accumulator Moving Indirect Mode</em>'.
   * @generated
   */
  AccumulatorMovingIndirectMode createAccumulatorMovingIndirectMode();

  /**
   * Returns a new object of class '<em>Auto Inc Dec Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Auto Inc Dec Mode</em>'.
   * @generated
   */
  AutoIncDecMode createAutoIncDecMode();

  /**
   * Returns a new object of class '<em>Auto Inc Dec Indirect Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Auto Inc Dec Indirect Mode</em>'.
   * @generated
   */
  AutoIncDecIndirectMode createAutoIncDecIndirectMode();

  /**
   * Returns a new object of class '<em>Relatif To PC Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relatif To PC Mode</em>'.
   * @generated
   */
  RelatifToPCMode createRelatifToPCMode();

  /**
   * Returns a new object of class '<em>Relatif To PC Indirect Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relatif To PC Indirect Mode</em>'.
   * @generated
   */
  RelatifToPCIndirectMode createRelatifToPCIndirectMode();

  /**
   * Returns a new object of class '<em>Relative Mode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relative Mode</em>'.
   * @generated
   */
  RelativeMode createRelativeMode();

  /**
   * Returns a new object of class '<em>Directive Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Directive Line</em>'.
   * @generated
   */
  DirectiveLine createDirectiveLine();

  /**
   * Returns a new object of class '<em>Set DP Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Set DP Directive</em>'.
   * @generated
   */
  SetDPDirective createSetDPDirective();

  /**
   * Returns a new object of class '<em>Fcc Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fcc Directive</em>'.
   * @generated
   */
  FccDirective createFccDirective();

  /**
   * Returns a new object of class '<em>Reg Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reg Directive</em>'.
   * @generated
   */
  RegDirective createRegDirective();

  /**
   * Returns a new object of class '<em>Spc Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Spc Directive</em>'.
   * @generated
   */
  SpcDirective createSpcDirective();

  /**
   * Returns a new object of class '<em>Nam Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nam Directive</em>'.
   * @generated
   */
  NamDirective createNamDirective();

  /**
   * Returns a new object of class '<em>Pag Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pag Directive</em>'.
   * @generated
   */
  PagDirective createPagDirective();

  /**
   * Returns a new object of class '<em>Opt Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Opt Directive</em>'.
   * @generated
   */
  OptDirective createOptDirective();

  /**
   * Returns a new object of class '<em>Fail Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fail Directive</em>'.
   * @generated
   */
  FailDirective createFailDirective();

  /**
   * Returns a new object of class '<em>Set Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Set Directive</em>'.
   * @generated
   */
  SetDirective createSetDirective();

  /**
   * Returns a new object of class '<em>Fill Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fill Directive</em>'.
   * @generated
   */
  FillDirective createFillDirective();

  /**
   * Returns a new object of class '<em>Bsz Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bsz Directive</em>'.
   * @generated
   */
  BszDirective createBszDirective();

  /**
   * Returns a new object of class '<em>Fdb Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fdb Directive</em>'.
   * @generated
   */
  FdbDirective createFdbDirective();

  /**
   * Returns a new object of class '<em>Fcb Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fcb Directive</em>'.
   * @generated
   */
  FcbDirective createFcbDirective();

  /**
   * Returns a new object of class '<em>Rmb Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rmb Directive</em>'.
   * @generated
   */
  RmbDirective createRmbDirective();

  /**
   * Returns a new object of class '<em>End Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>End Directive</em>'.
   * @generated
   */
  EndDirective createEndDirective();

  /**
   * Returns a new object of class '<em>Org Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Org Directive</em>'.
   * @generated
   */
  OrgDirective createOrgDirective();

  /**
   * Returns a new object of class '<em>Equ Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equ Directive</em>'.
   * @generated
   */
  EquDirective createEquDirective();

  /**
   * Returns a new object of class '<em>List Of Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Of Expression</em>'.
   * @generated
   */
  ListOfExpression createListOfExpression();

  /**
   * Returns a new object of class '<em>Comma Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comma Expression</em>'.
   * @generated
   */
  CommaExpression createCommaExpression();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Numerical Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Value</em>'.
   * @generated
   */
  NumericalValue createNumericalValue();

  /**
   * Returns a new object of class '<em>Identifier Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Identifier Value</em>'.
   * @generated
   */
  IdentifierValue createIdentifierValue();

  /**
   * Returns a new object of class '<em>String Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Value</em>'.
   * @generated
   */
  StringValue createStringValue();

  /**
   * Returns a new object of class '<em>Decimal Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decimal Value</em>'.
   * @generated
   */
  DecimalValue createDecimalValue();

  /**
   * Returns a new object of class '<em>Hexa Decimal Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hexa Decimal Value</em>'.
   * @generated
   */
  HexaDecimalValue createHexaDecimalValue();

  /**
   * Returns a new object of class '<em>Octal Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Octal Value</em>'.
   * @generated
   */
  OctalValue createOctalValue();

  /**
   * Returns a new object of class '<em>Binary Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Value</em>'.
   * @generated
   */
  BinaryValue createBinaryValue();

  /**
   * Returns a new object of class '<em>Character Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Character Value</em>'.
   * @generated
   */
  CharacterValue createCharacterValue();

  /**
   * Returns a new object of class '<em>Multiplication</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplication</em>'.
   * @generated
   */
  Multiplication createMultiplication();

  /**
   * Returns a new object of class '<em>Division</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Division</em>'.
   * @generated
   */
  Division createDivision();

  /**
   * Returns a new object of class '<em>Modulo</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Modulo</em>'.
   * @generated
   */
  Modulo createModulo();

  /**
   * Returns a new object of class '<em>Addition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Addition</em>'.
   * @generated
   */
  Addition createAddition();

  /**
   * Returns a new object of class '<em>Substraction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Substraction</em>'.
   * @generated
   */
  Substraction createSubstraction();

  /**
   * Returns a new object of class '<em>Left Shift</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Left Shift</em>'.
   * @generated
   */
  LeftShift createLeftShift();

  /**
   * Returns a new object of class '<em>Right Shift</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Right Shift</em>'.
   * @generated
   */
  RightShift createRightShift();

  /**
   * Returns a new object of class '<em>And</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And</em>'.
   * @generated
   */
  And createAnd();

  /**
   * Returns a new object of class '<em>Or</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or</em>'.
   * @generated
   */
  Or createOr();

  /**
   * Returns a new object of class '<em>Xor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xor</em>'.
   * @generated
   */
  Xor createXor();

  /**
   * Returns a new object of class '<em>Not</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not</em>'.
   * @generated
   */
  Not createNot();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AssemblerPackage getAssemblerPackage();

} //AssemblerFactory

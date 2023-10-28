package org.bpy.electronics.mc6809.assembler.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.bpy.electronics.mc6809.assembler.services.AssemblerGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalAssemblerParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "'INCA'", "'INCB'", "'INC'", "'EXG'", "','", "'EORA'", "'EORB'", "'DECA'", "'DECB'", "'DEC'", "'DAA'", "'CWAI'", "'COMA'", "'COMB'", "'COM'", "'CMPA'", "'CMPB'", "'CLRA'", "'CLRB'", "'CLR'", "'BVS'", "'LBVS'", "'BVC'", "'LBVC'", "'BSR'", "'LBSR'", "'BRN'", "'LBRN'", "'BRA'", "'LBRA'", "'BPL'", "'LBPL'", "'BNE'", "'LBNE'", "'BMI'", "'LBMI'", "'BLT'", "'LBLT'", "'BLS'", "'LBLS'", "'BLO'", "'LBLO'", "'BLE'", "'LBLE'", "'BIT'", "'BHS'", "'LBHS'", "'BHI'", "'LBHI'", "'BGT'", "'LBGT'", "'BGE'", "'LBGE'", "'BEQ'", "'LBEQ'", "'BCS'", "'LBCS'", "'BCC'", "'LBCC'", "'ASRA'", "'ASRB'", "'ASR'", "'ASLA'", "'ASLB'", "'ASL'", "'ANDCC'", "'ANDA'", "'ANDB'", "'ADDD'", "'ADDA'", "'ADDB'", "'ADCA'", "'ADCB'", "'ABX'", "'['", "']'", "'>'", "'<'", "'#'", "'S'", "'U'", "'X'", "'Y'", "'A'", "'B'", "'D'", "'-'", "'--'", "'+'", "'++'", "'PCR'", "'FCC'", "'REG'", "'SPC'", "'NAM'", "'TTL'", "'PAG'", "'OPT'", "'FAIL'", "'SET'", "'*'", "'FILL'", "'BSZ'", "'ZMB'", "'FDB'", "'FCB'", "'RMB'", "'END'", "'ORG'", "'EQU'", "'/'", "'%'", "'<<'", "'>>'", "'&&'", "'||'", "'^'", "'!'", "'('", "')'", "'NOP'", "'CON'", "'NOC'", "'MAC'", "'NOM'", "'EXP'", "'NOE'", "'DP'", "'CC'", "'PC'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__50=50;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int RULE_CHARACTER=12;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=7;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_HEXA=9;
    public static final int RULE_INT=8;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int RULE_BINARY=11;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int RULE_ANY_EXCEPT_COMMENT_END_OF_LINE=5;
    public static final int T__90=90;
    public static final int RULE_CR=13;
    public static final int T__19=19;
    public static final int RULE_OCTAL=10;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=6;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int RULE_END_OF_FILE=14;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=4;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalAssemblerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAssemblerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAssemblerParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAssembler.g"; }



     	private AssemblerGrammarAccess grammarAccess;

        public InternalAssemblerParser(TokenStream input, AssemblerGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected AssemblerGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalAssembler.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAssembler.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalAssembler.g:66:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalAssembler.g:72:1: ruleModel returns [EObject current=null] : ( (lv_sourceLines_0_0= ruleSourceLine ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_sourceLines_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:78:2: ( ( (lv_sourceLines_0_0= ruleSourceLine ) )* )
            // InternalAssembler.g:79:2: ( (lv_sourceLines_0_0= ruleSourceLine ) )*
            {
            // InternalAssembler.g:79:2: ( (lv_sourceLines_0_0= ruleSourceLine ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_WS && LA1_0<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||LA1_0==RULE_ID||(LA1_0>=RULE_CR && LA1_0<=RULE_END_OF_FILE)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAssembler.g:80:3: (lv_sourceLines_0_0= ruleSourceLine )
            	    {
            	    // InternalAssembler.g:80:3: (lv_sourceLines_0_0= ruleSourceLine )
            	    // InternalAssembler.g:81:4: lv_sourceLines_0_0= ruleSourceLine
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getModelAccess().getSourceLinesSourceLineParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_sourceLines_0_0=ruleSourceLine();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getModelRule());
            	      				}
            	      				add(
            	      					current,
            	      					"sourceLines",
            	      					lv_sourceLines_0_0,
            	      					"org.bpy.electronics.mc6809.assembler.Assembler.SourceLine");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSourceLine"
    // InternalAssembler.g:101:1: entryRuleSourceLine returns [EObject current=null] : iv_ruleSourceLine= ruleSourceLine EOF ;
    public final EObject entryRuleSourceLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceLine = null;


        try {
            // InternalAssembler.g:101:51: (iv_ruleSourceLine= ruleSourceLine EOF )
            // InternalAssembler.g:102:2: iv_ruleSourceLine= ruleSourceLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSourceLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSourceLine=ruleSourceLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSourceLine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSourceLine"


    // $ANTLR start "ruleSourceLine"
    // InternalAssembler.g:108:1: ruleSourceLine returns [EObject current=null] : ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) | ( (lv_lineContent_3_0= ruleInstructionLine ) ) ) ;
    public final EObject ruleSourceLine() throws RecognitionException {
        EObject current = null;

        EObject lv_lineContent_0_0 = null;

        EObject lv_lineContent_1_0 = null;

        EObject lv_lineContent_2_0 = null;

        EObject lv_lineContent_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:114:2: ( ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) | ( (lv_lineContent_3_0= ruleInstructionLine ) ) ) )
            // InternalAssembler.g:115:2: ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) | ( (lv_lineContent_3_0= ruleInstructionLine ) ) )
            {
            // InternalAssembler.g:115:2: ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) | ( (lv_lineContent_3_0= ruleInstructionLine ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_WS:
                {
                switch ( input.LA(2) ) {
                case RULE_CR:
                case RULE_END_OF_FILE:
                    {
                    alt2=1;
                    }
                    break;
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                    {
                    alt2=3;
                    }
                    break;
                case 15:
                case 16:
                case 17:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                    {
                    alt2=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_CR:
            case RULE_END_OF_FILE:
                {
                alt2=1;
                }
                break;
            case RULE_ANY_EXCEPT_COMMENT_END_OF_LINE:
                {
                alt2=2;
                }
                break;
            case RULE_ID:
                {
                int LA2_4 = input.LA(2);

                if ( (LA2_4==RULE_WS) ) {
                    int LA2_7 = input.LA(3);

                    if ( ((LA2_7>=106 && LA2_7<=114)||(LA2_7>=116 && LA2_7<=124)) ) {
                        alt2=3;
                    }
                    else if ( ((LA2_7>=15 && LA2_7<=18)||(LA2_7>=20 && LA2_7<=88)) ) {
                        alt2=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 4, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalAssembler.g:116:3: ( (lv_lineContent_0_0= ruleBlankLine ) )
                    {
                    // InternalAssembler.g:116:3: ( (lv_lineContent_0_0= ruleBlankLine ) )
                    // InternalAssembler.g:117:4: (lv_lineContent_0_0= ruleBlankLine )
                    {
                    // InternalAssembler.g:117:4: (lv_lineContent_0_0= ruleBlankLine )
                    // InternalAssembler.g:118:5: lv_lineContent_0_0= ruleBlankLine
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSourceLineAccess().getLineContentBlankLineParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_lineContent_0_0=ruleBlankLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                      					}
                      					set(
                      						current,
                      						"lineContent",
                      						lv_lineContent_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.BlankLine");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:136:3: ( (lv_lineContent_1_0= ruleCommentLine ) )
                    {
                    // InternalAssembler.g:136:3: ( (lv_lineContent_1_0= ruleCommentLine ) )
                    // InternalAssembler.g:137:4: (lv_lineContent_1_0= ruleCommentLine )
                    {
                    // InternalAssembler.g:137:4: (lv_lineContent_1_0= ruleCommentLine )
                    // InternalAssembler.g:138:5: lv_lineContent_1_0= ruleCommentLine
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSourceLineAccess().getLineContentCommentLineParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_lineContent_1_0=ruleCommentLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                      					}
                      					set(
                      						current,
                      						"lineContent",
                      						lv_lineContent_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.CommentLine");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:156:3: ( (lv_lineContent_2_0= ruleDirectiveLine ) )
                    {
                    // InternalAssembler.g:156:3: ( (lv_lineContent_2_0= ruleDirectiveLine ) )
                    // InternalAssembler.g:157:4: (lv_lineContent_2_0= ruleDirectiveLine )
                    {
                    // InternalAssembler.g:157:4: (lv_lineContent_2_0= ruleDirectiveLine )
                    // InternalAssembler.g:158:5: lv_lineContent_2_0= ruleDirectiveLine
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSourceLineAccess().getLineContentDirectiveLineParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_lineContent_2_0=ruleDirectiveLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                      					}
                      					set(
                      						current,
                      						"lineContent",
                      						lv_lineContent_2_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.DirectiveLine");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:176:3: ( (lv_lineContent_3_0= ruleInstructionLine ) )
                    {
                    // InternalAssembler.g:176:3: ( (lv_lineContent_3_0= ruleInstructionLine ) )
                    // InternalAssembler.g:177:4: (lv_lineContent_3_0= ruleInstructionLine )
                    {
                    // InternalAssembler.g:177:4: (lv_lineContent_3_0= ruleInstructionLine )
                    // InternalAssembler.g:178:5: lv_lineContent_3_0= ruleInstructionLine
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSourceLineAccess().getLineContentInstructionLineParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_lineContent_3_0=ruleInstructionLine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                      					}
                      					set(
                      						current,
                      						"lineContent",
                      						lv_lineContent_3_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.InstructionLine");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSourceLine"


    // $ANTLR start "entryRuleBlankLine"
    // InternalAssembler.g:199:1: entryRuleBlankLine returns [EObject current=null] : iv_ruleBlankLine= ruleBlankLine EOF ;
    public final EObject entryRuleBlankLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlankLine = null;


        try {
            // InternalAssembler.g:199:50: (iv_ruleBlankLine= ruleBlankLine EOF )
            // InternalAssembler.g:200:2: iv_ruleBlankLine= ruleBlankLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlankLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlankLine=ruleBlankLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlankLine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlankLine"


    // $ANTLR start "ruleBlankLine"
    // InternalAssembler.g:206:1: ruleBlankLine returns [EObject current=null] : ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine ) ;
    public final EObject ruleBlankLine() throws RecognitionException {
        EObject current = null;

        Token lv_blankLine_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:212:2: ( ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine ) )
            // InternalAssembler.g:213:2: ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:213:2: ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine )
            // InternalAssembler.g:214:3: () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine
            {
            // InternalAssembler.g:214:3: ()
            // InternalAssembler.g:215:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlankLineAccess().getBlankLineAction_0(),
              					current);
              			
            }

            }

            // InternalAssembler.g:221:3: ( (lv_blankLine_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssembler.g:222:4: (lv_blankLine_1_0= RULE_WS )
                    {
                    // InternalAssembler.g:222:4: (lv_blankLine_1_0= RULE_WS )
                    // InternalAssembler.g:223:5: lv_blankLine_1_0= RULE_WS
                    {
                    lv_blankLine_1_0=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_blankLine_1_0, grammarAccess.getBlankLineAccess().getBlankLineWSTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBlankLineRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"blankLine",
                      						lv_blankLine_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.WS");
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBlankLineAccess().getEndOfLineParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlankLine"


    // $ANTLR start "entryRuleCommentLine"
    // InternalAssembler.g:250:1: entryRuleCommentLine returns [EObject current=null] : iv_ruleCommentLine= ruleCommentLine EOF ;
    public final EObject entryRuleCommentLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentLine = null;


        try {
            // InternalAssembler.g:250:52: (iv_ruleCommentLine= ruleCommentLine EOF )
            // InternalAssembler.g:251:2: iv_ruleCommentLine= ruleCommentLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCommentLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCommentLine=ruleCommentLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCommentLine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommentLine"


    // $ANTLR start "ruleCommentLine"
    // InternalAssembler.g:257:1: ruleCommentLine returns [EObject current=null] : ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine ) ;
    public final EObject ruleCommentLine() throws RecognitionException {
        EObject current = null;

        Token lv_comment_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:263:2: ( ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine ) )
            // InternalAssembler.g:264:2: ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine )
            {
            // InternalAssembler.g:264:2: ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine )
            // InternalAssembler.g:265:3: ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine
            {
            // InternalAssembler.g:265:3: ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
            // InternalAssembler.g:266:4: (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            {
            // InternalAssembler.g:266:4: (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            // InternalAssembler.g:267:5: lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
            {
            lv_comment_0_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_comment_0_0, grammarAccess.getCommentLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCommentLineRule());
              					}
              					setWithLastConsumed(
              						current,
              						"comment",
              						lv_comment_0_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCommentLineAccess().getEndOfLineParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommentLine"


    // $ANTLR start "entryRuleInstructionLine"
    // InternalAssembler.g:294:1: entryRuleInstructionLine returns [EObject current=null] : iv_ruleInstructionLine= ruleInstructionLine EOF ;
    public final EObject entryRuleInstructionLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstructionLine = null;


        try {
            // InternalAssembler.g:294:56: (iv_ruleInstructionLine= ruleInstructionLine EOF )
            // InternalAssembler.g:295:2: iv_ruleInstructionLine= ruleInstructionLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstructionLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstructionLine=ruleInstructionLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstructionLine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstructionLine"


    // $ANTLR start "ruleInstructionLine"
    // InternalAssembler.g:301:1: ruleInstructionLine returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) | ( (lv_instruction_30_0= ruleClrInstruction ) ) | ( (lv_instruction_31_0= ruleCmpInstruction ) ) | ( (lv_instruction_32_0= ruleComInstruction ) ) | ( (lv_instruction_33_0= ruleCwaiInstruction ) ) | ( (lv_instruction_34_0= ruleDaaInstruction ) ) | ( (lv_instruction_35_0= ruleDecInstruction ) ) | ( (lv_instruction_36_0= ruleEorInstruction ) ) | ( (lv_instruction_37_0= ruleExgInstruction ) ) | ( (lv_instruction_38_0= ruleIncInstruction ) ) ) (this_WS_39= RULE_WS ( (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_41= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleInstructionLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_WS_39=null;
        Token lv_comment_40_0=null;
        Token this_WS_41=null;
        EObject lv_name_0_0 = null;

        EObject lv_instruction_2_0 = null;

        EObject lv_instruction_3_0 = null;

        EObject lv_instruction_4_0 = null;

        EObject lv_instruction_5_0 = null;

        EObject lv_instruction_6_0 = null;

        EObject lv_instruction_7_0 = null;

        EObject lv_instruction_8_0 = null;

        EObject lv_instruction_9_0 = null;

        EObject lv_instruction_10_0 = null;

        EObject lv_instruction_11_0 = null;

        EObject lv_instruction_12_0 = null;

        EObject lv_instruction_13_0 = null;

        EObject lv_instruction_14_0 = null;

        EObject lv_instruction_15_0 = null;

        EObject lv_instruction_16_0 = null;

        EObject lv_instruction_17_0 = null;

        EObject lv_instruction_18_0 = null;

        EObject lv_instruction_19_0 = null;

        EObject lv_instruction_20_0 = null;

        EObject lv_instruction_21_0 = null;

        EObject lv_instruction_22_0 = null;

        EObject lv_instruction_23_0 = null;

        EObject lv_instruction_24_0 = null;

        EObject lv_instruction_25_0 = null;

        EObject lv_instruction_26_0 = null;

        EObject lv_instruction_27_0 = null;

        EObject lv_instruction_28_0 = null;

        EObject lv_instruction_29_0 = null;

        EObject lv_instruction_30_0 = null;

        EObject lv_instruction_31_0 = null;

        EObject lv_instruction_32_0 = null;

        EObject lv_instruction_33_0 = null;

        EObject lv_instruction_34_0 = null;

        EObject lv_instruction_35_0 = null;

        EObject lv_instruction_36_0 = null;

        EObject lv_instruction_37_0 = null;

        EObject lv_instruction_38_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:307:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) | ( (lv_instruction_30_0= ruleClrInstruction ) ) | ( (lv_instruction_31_0= ruleCmpInstruction ) ) | ( (lv_instruction_32_0= ruleComInstruction ) ) | ( (lv_instruction_33_0= ruleCwaiInstruction ) ) | ( (lv_instruction_34_0= ruleDaaInstruction ) ) | ( (lv_instruction_35_0= ruleDecInstruction ) ) | ( (lv_instruction_36_0= ruleEorInstruction ) ) | ( (lv_instruction_37_0= ruleExgInstruction ) ) | ( (lv_instruction_38_0= ruleIncInstruction ) ) ) (this_WS_39= RULE_WS ( (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_41= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) | ( (lv_instruction_30_0= ruleClrInstruction ) ) | ( (lv_instruction_31_0= ruleCmpInstruction ) ) | ( (lv_instruction_32_0= ruleComInstruction ) ) | ( (lv_instruction_33_0= ruleCwaiInstruction ) ) | ( (lv_instruction_34_0= ruleDaaInstruction ) ) | ( (lv_instruction_35_0= ruleDecInstruction ) ) | ( (lv_instruction_36_0= ruleEorInstruction ) ) | ( (lv_instruction_37_0= ruleExgInstruction ) ) | ( (lv_instruction_38_0= ruleIncInstruction ) ) ) (this_WS_39= RULE_WS ( (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_41= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) | ( (lv_instruction_30_0= ruleClrInstruction ) ) | ( (lv_instruction_31_0= ruleCmpInstruction ) ) | ( (lv_instruction_32_0= ruleComInstruction ) ) | ( (lv_instruction_33_0= ruleCwaiInstruction ) ) | ( (lv_instruction_34_0= ruleDaaInstruction ) ) | ( (lv_instruction_35_0= ruleDecInstruction ) ) | ( (lv_instruction_36_0= ruleEorInstruction ) ) | ( (lv_instruction_37_0= ruleExgInstruction ) ) | ( (lv_instruction_38_0= ruleIncInstruction ) ) ) (this_WS_39= RULE_WS ( (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_41= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:309:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) | ( (lv_instruction_30_0= ruleClrInstruction ) ) | ( (lv_instruction_31_0= ruleCmpInstruction ) ) | ( (lv_instruction_32_0= ruleComInstruction ) ) | ( (lv_instruction_33_0= ruleCwaiInstruction ) ) | ( (lv_instruction_34_0= ruleDaaInstruction ) ) | ( (lv_instruction_35_0= ruleDecInstruction ) ) | ( (lv_instruction_36_0= ruleEorInstruction ) ) | ( (lv_instruction_37_0= ruleExgInstruction ) ) | ( (lv_instruction_38_0= ruleIncInstruction ) ) ) (this_WS_39= RULE_WS ( (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_41= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:309:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:310:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:310:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:311:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.IdentifierValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:332:3: ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) | ( (lv_instruction_30_0= ruleClrInstruction ) ) | ( (lv_instruction_31_0= ruleCmpInstruction ) ) | ( (lv_instruction_32_0= ruleComInstruction ) ) | ( (lv_instruction_33_0= ruleCwaiInstruction ) ) | ( (lv_instruction_34_0= ruleDaaInstruction ) ) | ( (lv_instruction_35_0= ruleDecInstruction ) ) | ( (lv_instruction_36_0= ruleEorInstruction ) ) | ( (lv_instruction_37_0= ruleExgInstruction ) ) | ( (lv_instruction_38_0= ruleIncInstruction ) ) )
            int alt5=37;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt5=1;
                }
                break;
            case 86:
            case 87:
                {
                alt5=2;
                }
                break;
            case 84:
            case 85:
                {
                alt5=3;
                }
                break;
            case 83:
                {
                alt5=4;
                }
                break;
            case 81:
            case 82:
                {
                alt5=5;
                }
                break;
            case 80:
                {
                alt5=6;
                }
                break;
            case 77:
            case 78:
            case 79:
                {
                alt5=7;
                }
                break;
            case 74:
            case 75:
            case 76:
                {
                alt5=8;
                }
                break;
            case 72:
            case 73:
                {
                alt5=9;
                }
                break;
            case 70:
            case 71:
                {
                alt5=10;
                }
                break;
            case 68:
            case 69:
                {
                alt5=11;
                }
                break;
            case 66:
            case 67:
                {
                alt5=12;
                }
                break;
            case 64:
            case 65:
                {
                alt5=13;
                }
                break;
            case 62:
            case 63:
                {
                alt5=14;
                }
                break;
            case 60:
            case 61:
                {
                alt5=15;
                }
                break;
            case 59:
                {
                alt5=16;
                }
                break;
            case 57:
            case 58:
                {
                alt5=17;
                }
                break;
            case 55:
            case 56:
                {
                alt5=18;
                }
                break;
            case 53:
            case 54:
                {
                alt5=19;
                }
                break;
            case 51:
            case 52:
                {
                alt5=20;
                }
                break;
            case 49:
            case 50:
                {
                alt5=21;
                }
                break;
            case 47:
            case 48:
                {
                alt5=22;
                }
                break;
            case 45:
            case 46:
                {
                alt5=23;
                }
                break;
            case 43:
            case 44:
                {
                alt5=24;
                }
                break;
            case 41:
            case 42:
                {
                alt5=25;
                }
                break;
            case 39:
            case 40:
                {
                alt5=26;
                }
                break;
            case 37:
            case 38:
                {
                alt5=27;
                }
                break;
            case 35:
            case 36:
                {
                alt5=28;
                }
                break;
            case 32:
            case 33:
            case 34:
                {
                alt5=29;
                }
                break;
            case 30:
            case 31:
                {
                alt5=30;
                }
                break;
            case 27:
            case 28:
            case 29:
                {
                alt5=31;
                }
                break;
            case 26:
                {
                alt5=32;
                }
                break;
            case 25:
                {
                alt5=33;
                }
                break;
            case 22:
            case 23:
            case 24:
                {
                alt5=34;
                }
                break;
            case 20:
            case 21:
                {
                alt5=35;
                }
                break;
            case 18:
                {
                alt5=36;
                }
                break;
            case 15:
            case 16:
            case 17:
                {
                alt5=37;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:333:4: ( (lv_instruction_2_0= ruleAbxInstruction ) )
                    {
                    // InternalAssembler.g:333:4: ( (lv_instruction_2_0= ruleAbxInstruction ) )
                    // InternalAssembler.g:334:5: (lv_instruction_2_0= ruleAbxInstruction )
                    {
                    // InternalAssembler.g:334:5: (lv_instruction_2_0= ruleAbxInstruction )
                    // InternalAssembler.g:335:6: lv_instruction_2_0= ruleAbxInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAbxInstructionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_2_0=ruleAbxInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_2_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AbxInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:353:4: ( (lv_instruction_3_0= ruleAdcInstruction ) )
                    {
                    // InternalAssembler.g:353:4: ( (lv_instruction_3_0= ruleAdcInstruction ) )
                    // InternalAssembler.g:354:5: (lv_instruction_3_0= ruleAdcInstruction )
                    {
                    // InternalAssembler.g:354:5: (lv_instruction_3_0= ruleAdcInstruction )
                    // InternalAssembler.g:355:6: lv_instruction_3_0= ruleAdcInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAdcInstructionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_3_0=ruleAdcInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_3_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AdcInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:373:4: ( (lv_instruction_4_0= ruleAddInstruction ) )
                    {
                    // InternalAssembler.g:373:4: ( (lv_instruction_4_0= ruleAddInstruction ) )
                    // InternalAssembler.g:374:5: (lv_instruction_4_0= ruleAddInstruction )
                    {
                    // InternalAssembler.g:374:5: (lv_instruction_4_0= ruleAddInstruction )
                    // InternalAssembler.g:375:6: lv_instruction_4_0= ruleAddInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAddInstructionParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_4_0=ruleAddInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_4_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AddInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:393:4: ( (lv_instruction_5_0= ruleAdddInstruction ) )
                    {
                    // InternalAssembler.g:393:4: ( (lv_instruction_5_0= ruleAdddInstruction ) )
                    // InternalAssembler.g:394:5: (lv_instruction_5_0= ruleAdddInstruction )
                    {
                    // InternalAssembler.g:394:5: (lv_instruction_5_0= ruleAdddInstruction )
                    // InternalAssembler.g:395:6: lv_instruction_5_0= ruleAdddInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAdddInstructionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_5_0=ruleAdddInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_5_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AdddInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:413:4: ( (lv_instruction_6_0= ruleAndInstruction ) )
                    {
                    // InternalAssembler.g:413:4: ( (lv_instruction_6_0= ruleAndInstruction ) )
                    // InternalAssembler.g:414:5: (lv_instruction_6_0= ruleAndInstruction )
                    {
                    // InternalAssembler.g:414:5: (lv_instruction_6_0= ruleAndInstruction )
                    // InternalAssembler.g:415:6: lv_instruction_6_0= ruleAndInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAndInstructionParserRuleCall_2_4_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_6_0=ruleAndInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_6_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AndInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:433:4: ( (lv_instruction_7_0= ruleAndCCInstruction ) )
                    {
                    // InternalAssembler.g:433:4: ( (lv_instruction_7_0= ruleAndCCInstruction ) )
                    // InternalAssembler.g:434:5: (lv_instruction_7_0= ruleAndCCInstruction )
                    {
                    // InternalAssembler.g:434:5: (lv_instruction_7_0= ruleAndCCInstruction )
                    // InternalAssembler.g:435:6: lv_instruction_7_0= ruleAndCCInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAndCCInstructionParserRuleCall_2_5_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_7_0=ruleAndCCInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_7_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AndCCInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:453:4: ( (lv_instruction_8_0= ruleAslInstruction ) )
                    {
                    // InternalAssembler.g:453:4: ( (lv_instruction_8_0= ruleAslInstruction ) )
                    // InternalAssembler.g:454:5: (lv_instruction_8_0= ruleAslInstruction )
                    {
                    // InternalAssembler.g:454:5: (lv_instruction_8_0= ruleAslInstruction )
                    // InternalAssembler.g:455:6: lv_instruction_8_0= ruleAslInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAslInstructionParserRuleCall_2_6_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_8_0=ruleAslInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_8_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AslInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:473:4: ( (lv_instruction_9_0= ruleAsrInstruction ) )
                    {
                    // InternalAssembler.g:473:4: ( (lv_instruction_9_0= ruleAsrInstruction ) )
                    // InternalAssembler.g:474:5: (lv_instruction_9_0= ruleAsrInstruction )
                    {
                    // InternalAssembler.g:474:5: (lv_instruction_9_0= ruleAsrInstruction )
                    // InternalAssembler.g:475:6: lv_instruction_9_0= ruleAsrInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAsrInstructionParserRuleCall_2_7_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_9_0=ruleAsrInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_9_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AsrInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:493:4: ( (lv_instruction_10_0= ruleBccInstruction ) )
                    {
                    // InternalAssembler.g:493:4: ( (lv_instruction_10_0= ruleBccInstruction ) )
                    // InternalAssembler.g:494:5: (lv_instruction_10_0= ruleBccInstruction )
                    {
                    // InternalAssembler.g:494:5: (lv_instruction_10_0= ruleBccInstruction )
                    // InternalAssembler.g:495:6: lv_instruction_10_0= ruleBccInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBccInstructionParserRuleCall_2_8_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_10_0=ruleBccInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_10_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BccInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalAssembler.g:513:4: ( (lv_instruction_11_0= ruleBcsInstruction ) )
                    {
                    // InternalAssembler.g:513:4: ( (lv_instruction_11_0= ruleBcsInstruction ) )
                    // InternalAssembler.g:514:5: (lv_instruction_11_0= ruleBcsInstruction )
                    {
                    // InternalAssembler.g:514:5: (lv_instruction_11_0= ruleBcsInstruction )
                    // InternalAssembler.g:515:6: lv_instruction_11_0= ruleBcsInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBcsInstructionParserRuleCall_2_9_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_11_0=ruleBcsInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_11_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BcsInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalAssembler.g:533:4: ( (lv_instruction_12_0= ruleBeqInstruction ) )
                    {
                    // InternalAssembler.g:533:4: ( (lv_instruction_12_0= ruleBeqInstruction ) )
                    // InternalAssembler.g:534:5: (lv_instruction_12_0= ruleBeqInstruction )
                    {
                    // InternalAssembler.g:534:5: (lv_instruction_12_0= ruleBeqInstruction )
                    // InternalAssembler.g:535:6: lv_instruction_12_0= ruleBeqInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBeqInstructionParserRuleCall_2_10_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_12_0=ruleBeqInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_12_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BeqInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalAssembler.g:553:4: ( (lv_instruction_13_0= ruleBgeInstruction ) )
                    {
                    // InternalAssembler.g:553:4: ( (lv_instruction_13_0= ruleBgeInstruction ) )
                    // InternalAssembler.g:554:5: (lv_instruction_13_0= ruleBgeInstruction )
                    {
                    // InternalAssembler.g:554:5: (lv_instruction_13_0= ruleBgeInstruction )
                    // InternalAssembler.g:555:6: lv_instruction_13_0= ruleBgeInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBgeInstructionParserRuleCall_2_11_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_13_0=ruleBgeInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_13_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BgeInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalAssembler.g:573:4: ( (lv_instruction_14_0= ruleBgtInstruction ) )
                    {
                    // InternalAssembler.g:573:4: ( (lv_instruction_14_0= ruleBgtInstruction ) )
                    // InternalAssembler.g:574:5: (lv_instruction_14_0= ruleBgtInstruction )
                    {
                    // InternalAssembler.g:574:5: (lv_instruction_14_0= ruleBgtInstruction )
                    // InternalAssembler.g:575:6: lv_instruction_14_0= ruleBgtInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBgtInstructionParserRuleCall_2_12_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_14_0=ruleBgtInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_14_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BgtInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalAssembler.g:593:4: ( (lv_instruction_15_0= ruleBhiInstruction ) )
                    {
                    // InternalAssembler.g:593:4: ( (lv_instruction_15_0= ruleBhiInstruction ) )
                    // InternalAssembler.g:594:5: (lv_instruction_15_0= ruleBhiInstruction )
                    {
                    // InternalAssembler.g:594:5: (lv_instruction_15_0= ruleBhiInstruction )
                    // InternalAssembler.g:595:6: lv_instruction_15_0= ruleBhiInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBhiInstructionParserRuleCall_2_13_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_15_0=ruleBhiInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_15_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BhiInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalAssembler.g:613:4: ( (lv_instruction_16_0= ruleBhsInstruction ) )
                    {
                    // InternalAssembler.g:613:4: ( (lv_instruction_16_0= ruleBhsInstruction ) )
                    // InternalAssembler.g:614:5: (lv_instruction_16_0= ruleBhsInstruction )
                    {
                    // InternalAssembler.g:614:5: (lv_instruction_16_0= ruleBhsInstruction )
                    // InternalAssembler.g:615:6: lv_instruction_16_0= ruleBhsInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBhsInstructionParserRuleCall_2_14_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_16_0=ruleBhsInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_16_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BhsInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 16 :
                    // InternalAssembler.g:633:4: ( (lv_instruction_17_0= ruleBitInstruction ) )
                    {
                    // InternalAssembler.g:633:4: ( (lv_instruction_17_0= ruleBitInstruction ) )
                    // InternalAssembler.g:634:5: (lv_instruction_17_0= ruleBitInstruction )
                    {
                    // InternalAssembler.g:634:5: (lv_instruction_17_0= ruleBitInstruction )
                    // InternalAssembler.g:635:6: lv_instruction_17_0= ruleBitInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBitInstructionParserRuleCall_2_15_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_17_0=ruleBitInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_17_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BitInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 17 :
                    // InternalAssembler.g:653:4: ( (lv_instruction_18_0= ruleBleInstruction ) )
                    {
                    // InternalAssembler.g:653:4: ( (lv_instruction_18_0= ruleBleInstruction ) )
                    // InternalAssembler.g:654:5: (lv_instruction_18_0= ruleBleInstruction )
                    {
                    // InternalAssembler.g:654:5: (lv_instruction_18_0= ruleBleInstruction )
                    // InternalAssembler.g:655:6: lv_instruction_18_0= ruleBleInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBleInstructionParserRuleCall_2_16_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_18_0=ruleBleInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_18_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BleInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 18 :
                    // InternalAssembler.g:673:4: ( (lv_instruction_19_0= ruleBloInstruction ) )
                    {
                    // InternalAssembler.g:673:4: ( (lv_instruction_19_0= ruleBloInstruction ) )
                    // InternalAssembler.g:674:5: (lv_instruction_19_0= ruleBloInstruction )
                    {
                    // InternalAssembler.g:674:5: (lv_instruction_19_0= ruleBloInstruction )
                    // InternalAssembler.g:675:6: lv_instruction_19_0= ruleBloInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBloInstructionParserRuleCall_2_17_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_19_0=ruleBloInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_19_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BloInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 19 :
                    // InternalAssembler.g:693:4: ( (lv_instruction_20_0= ruleBlsInstruction ) )
                    {
                    // InternalAssembler.g:693:4: ( (lv_instruction_20_0= ruleBlsInstruction ) )
                    // InternalAssembler.g:694:5: (lv_instruction_20_0= ruleBlsInstruction )
                    {
                    // InternalAssembler.g:694:5: (lv_instruction_20_0= ruleBlsInstruction )
                    // InternalAssembler.g:695:6: lv_instruction_20_0= ruleBlsInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBlsInstructionParserRuleCall_2_18_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_20_0=ruleBlsInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_20_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BlsInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 20 :
                    // InternalAssembler.g:713:4: ( (lv_instruction_21_0= ruleBltInstruction ) )
                    {
                    // InternalAssembler.g:713:4: ( (lv_instruction_21_0= ruleBltInstruction ) )
                    // InternalAssembler.g:714:5: (lv_instruction_21_0= ruleBltInstruction )
                    {
                    // InternalAssembler.g:714:5: (lv_instruction_21_0= ruleBltInstruction )
                    // InternalAssembler.g:715:6: lv_instruction_21_0= ruleBltInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBltInstructionParserRuleCall_2_19_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_21_0=ruleBltInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_21_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BltInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 21 :
                    // InternalAssembler.g:733:4: ( (lv_instruction_22_0= ruleBmiInstruction ) )
                    {
                    // InternalAssembler.g:733:4: ( (lv_instruction_22_0= ruleBmiInstruction ) )
                    // InternalAssembler.g:734:5: (lv_instruction_22_0= ruleBmiInstruction )
                    {
                    // InternalAssembler.g:734:5: (lv_instruction_22_0= ruleBmiInstruction )
                    // InternalAssembler.g:735:6: lv_instruction_22_0= ruleBmiInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBmiInstructionParserRuleCall_2_20_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_22_0=ruleBmiInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_22_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BmiInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 22 :
                    // InternalAssembler.g:753:4: ( (lv_instruction_23_0= ruleBneInstruction ) )
                    {
                    // InternalAssembler.g:753:4: ( (lv_instruction_23_0= ruleBneInstruction ) )
                    // InternalAssembler.g:754:5: (lv_instruction_23_0= ruleBneInstruction )
                    {
                    // InternalAssembler.g:754:5: (lv_instruction_23_0= ruleBneInstruction )
                    // InternalAssembler.g:755:6: lv_instruction_23_0= ruleBneInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBneInstructionParserRuleCall_2_21_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_23_0=ruleBneInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_23_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BneInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 23 :
                    // InternalAssembler.g:773:4: ( (lv_instruction_24_0= ruleBplInstruction ) )
                    {
                    // InternalAssembler.g:773:4: ( (lv_instruction_24_0= ruleBplInstruction ) )
                    // InternalAssembler.g:774:5: (lv_instruction_24_0= ruleBplInstruction )
                    {
                    // InternalAssembler.g:774:5: (lv_instruction_24_0= ruleBplInstruction )
                    // InternalAssembler.g:775:6: lv_instruction_24_0= ruleBplInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBplInstructionParserRuleCall_2_22_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_24_0=ruleBplInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_24_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BplInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 24 :
                    // InternalAssembler.g:793:4: ( (lv_instruction_25_0= ruleBraInstruction ) )
                    {
                    // InternalAssembler.g:793:4: ( (lv_instruction_25_0= ruleBraInstruction ) )
                    // InternalAssembler.g:794:5: (lv_instruction_25_0= ruleBraInstruction )
                    {
                    // InternalAssembler.g:794:5: (lv_instruction_25_0= ruleBraInstruction )
                    // InternalAssembler.g:795:6: lv_instruction_25_0= ruleBraInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBraInstructionParserRuleCall_2_23_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_25_0=ruleBraInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_25_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BraInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 25 :
                    // InternalAssembler.g:813:4: ( (lv_instruction_26_0= ruleBrnInstruction ) )
                    {
                    // InternalAssembler.g:813:4: ( (lv_instruction_26_0= ruleBrnInstruction ) )
                    // InternalAssembler.g:814:5: (lv_instruction_26_0= ruleBrnInstruction )
                    {
                    // InternalAssembler.g:814:5: (lv_instruction_26_0= ruleBrnInstruction )
                    // InternalAssembler.g:815:6: lv_instruction_26_0= ruleBrnInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBrnInstructionParserRuleCall_2_24_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_26_0=ruleBrnInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_26_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BrnInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 26 :
                    // InternalAssembler.g:833:4: ( (lv_instruction_27_0= ruleBsrInstruction ) )
                    {
                    // InternalAssembler.g:833:4: ( (lv_instruction_27_0= ruleBsrInstruction ) )
                    // InternalAssembler.g:834:5: (lv_instruction_27_0= ruleBsrInstruction )
                    {
                    // InternalAssembler.g:834:5: (lv_instruction_27_0= ruleBsrInstruction )
                    // InternalAssembler.g:835:6: lv_instruction_27_0= ruleBsrInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBsrInstructionParserRuleCall_2_25_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_27_0=ruleBsrInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_27_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BsrInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 27 :
                    // InternalAssembler.g:853:4: ( (lv_instruction_28_0= ruleBvcInstruction ) )
                    {
                    // InternalAssembler.g:853:4: ( (lv_instruction_28_0= ruleBvcInstruction ) )
                    // InternalAssembler.g:854:5: (lv_instruction_28_0= ruleBvcInstruction )
                    {
                    // InternalAssembler.g:854:5: (lv_instruction_28_0= ruleBvcInstruction )
                    // InternalAssembler.g:855:6: lv_instruction_28_0= ruleBvcInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBvcInstructionParserRuleCall_2_26_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_28_0=ruleBvcInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_28_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BvcInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 28 :
                    // InternalAssembler.g:873:4: ( (lv_instruction_29_0= ruleBvsInstruction ) )
                    {
                    // InternalAssembler.g:873:4: ( (lv_instruction_29_0= ruleBvsInstruction ) )
                    // InternalAssembler.g:874:5: (lv_instruction_29_0= ruleBvsInstruction )
                    {
                    // InternalAssembler.g:874:5: (lv_instruction_29_0= ruleBvsInstruction )
                    // InternalAssembler.g:875:6: lv_instruction_29_0= ruleBvsInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionBvsInstructionParserRuleCall_2_27_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_29_0=ruleBvsInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_29_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BvsInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 29 :
                    // InternalAssembler.g:893:4: ( (lv_instruction_30_0= ruleClrInstruction ) )
                    {
                    // InternalAssembler.g:893:4: ( (lv_instruction_30_0= ruleClrInstruction ) )
                    // InternalAssembler.g:894:5: (lv_instruction_30_0= ruleClrInstruction )
                    {
                    // InternalAssembler.g:894:5: (lv_instruction_30_0= ruleClrInstruction )
                    // InternalAssembler.g:895:6: lv_instruction_30_0= ruleClrInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionClrInstructionParserRuleCall_2_28_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_30_0=ruleClrInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_30_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ClrInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 30 :
                    // InternalAssembler.g:913:4: ( (lv_instruction_31_0= ruleCmpInstruction ) )
                    {
                    // InternalAssembler.g:913:4: ( (lv_instruction_31_0= ruleCmpInstruction ) )
                    // InternalAssembler.g:914:5: (lv_instruction_31_0= ruleCmpInstruction )
                    {
                    // InternalAssembler.g:914:5: (lv_instruction_31_0= ruleCmpInstruction )
                    // InternalAssembler.g:915:6: lv_instruction_31_0= ruleCmpInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionCmpInstructionParserRuleCall_2_29_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_31_0=ruleCmpInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_31_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.CmpInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 31 :
                    // InternalAssembler.g:933:4: ( (lv_instruction_32_0= ruleComInstruction ) )
                    {
                    // InternalAssembler.g:933:4: ( (lv_instruction_32_0= ruleComInstruction ) )
                    // InternalAssembler.g:934:5: (lv_instruction_32_0= ruleComInstruction )
                    {
                    // InternalAssembler.g:934:5: (lv_instruction_32_0= ruleComInstruction )
                    // InternalAssembler.g:935:6: lv_instruction_32_0= ruleComInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionComInstructionParserRuleCall_2_30_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_32_0=ruleComInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_32_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ComInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 32 :
                    // InternalAssembler.g:953:4: ( (lv_instruction_33_0= ruleCwaiInstruction ) )
                    {
                    // InternalAssembler.g:953:4: ( (lv_instruction_33_0= ruleCwaiInstruction ) )
                    // InternalAssembler.g:954:5: (lv_instruction_33_0= ruleCwaiInstruction )
                    {
                    // InternalAssembler.g:954:5: (lv_instruction_33_0= ruleCwaiInstruction )
                    // InternalAssembler.g:955:6: lv_instruction_33_0= ruleCwaiInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionCwaiInstructionParserRuleCall_2_31_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_33_0=ruleCwaiInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_33_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.CwaiInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 33 :
                    // InternalAssembler.g:973:4: ( (lv_instruction_34_0= ruleDaaInstruction ) )
                    {
                    // InternalAssembler.g:973:4: ( (lv_instruction_34_0= ruleDaaInstruction ) )
                    // InternalAssembler.g:974:5: (lv_instruction_34_0= ruleDaaInstruction )
                    {
                    // InternalAssembler.g:974:5: (lv_instruction_34_0= ruleDaaInstruction )
                    // InternalAssembler.g:975:6: lv_instruction_34_0= ruleDaaInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionDaaInstructionParserRuleCall_2_32_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_34_0=ruleDaaInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_34_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DaaInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 34 :
                    // InternalAssembler.g:993:4: ( (lv_instruction_35_0= ruleDecInstruction ) )
                    {
                    // InternalAssembler.g:993:4: ( (lv_instruction_35_0= ruleDecInstruction ) )
                    // InternalAssembler.g:994:5: (lv_instruction_35_0= ruleDecInstruction )
                    {
                    // InternalAssembler.g:994:5: (lv_instruction_35_0= ruleDecInstruction )
                    // InternalAssembler.g:995:6: lv_instruction_35_0= ruleDecInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionDecInstructionParserRuleCall_2_33_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_35_0=ruleDecInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_35_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DecInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 35 :
                    // InternalAssembler.g:1013:4: ( (lv_instruction_36_0= ruleEorInstruction ) )
                    {
                    // InternalAssembler.g:1013:4: ( (lv_instruction_36_0= ruleEorInstruction ) )
                    // InternalAssembler.g:1014:5: (lv_instruction_36_0= ruleEorInstruction )
                    {
                    // InternalAssembler.g:1014:5: (lv_instruction_36_0= ruleEorInstruction )
                    // InternalAssembler.g:1015:6: lv_instruction_36_0= ruleEorInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionEorInstructionParserRuleCall_2_34_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_36_0=ruleEorInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_36_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.EorInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 36 :
                    // InternalAssembler.g:1033:4: ( (lv_instruction_37_0= ruleExgInstruction ) )
                    {
                    // InternalAssembler.g:1033:4: ( (lv_instruction_37_0= ruleExgInstruction ) )
                    // InternalAssembler.g:1034:5: (lv_instruction_37_0= ruleExgInstruction )
                    {
                    // InternalAssembler.g:1034:5: (lv_instruction_37_0= ruleExgInstruction )
                    // InternalAssembler.g:1035:6: lv_instruction_37_0= ruleExgInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionExgInstructionParserRuleCall_2_35_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_37_0=ruleExgInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_37_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExgInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 37 :
                    // InternalAssembler.g:1053:4: ( (lv_instruction_38_0= ruleIncInstruction ) )
                    {
                    // InternalAssembler.g:1053:4: ( (lv_instruction_38_0= ruleIncInstruction ) )
                    // InternalAssembler.g:1054:5: (lv_instruction_38_0= ruleIncInstruction )
                    {
                    // InternalAssembler.g:1054:5: (lv_instruction_38_0= ruleIncInstruction )
                    // InternalAssembler.g:1055:6: lv_instruction_38_0= ruleIncInstruction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionIncInstructionParserRuleCall_2_36_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_instruction_38_0=ruleIncInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      						}
                      						set(
                      							current,
                      							"instruction",
                      							lv_instruction_38_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IncInstruction");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:1073:3: (this_WS_39= RULE_WS ( (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_WS) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:1074:4: this_WS_39= RULE_WS ( (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_39=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_39, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1078:4: ( (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1079:5: (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1079:5: (lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1080:6: lv_comment_40_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_40_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_40_0, grammarAccess.getInstructionLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getInstructionLineRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_40_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:1097:3: (this_WS_41= RULE_WS )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:1098:4: this_WS_41= RULE_WS
                    {
                    this_WS_41=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_41, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getInstructionLineAccess().getEndOfLineParserRuleCall_5());
              		
            }
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstructionLine"


    // $ANTLR start "entryRuleIncInstruction"
    // InternalAssembler.g:1114:1: entryRuleIncInstruction returns [EObject current=null] : iv_ruleIncInstruction= ruleIncInstruction EOF ;
    public final EObject entryRuleIncInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncInstruction = null;


        try {
            // InternalAssembler.g:1114:55: (iv_ruleIncInstruction= ruleIncInstruction EOF )
            // InternalAssembler.g:1115:2: iv_ruleIncInstruction= ruleIncInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIncInstruction=ruleIncInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIncInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIncInstruction"


    // $ANTLR start "ruleIncInstruction"
    // InternalAssembler.g:1121:1: ruleIncInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' ) ) ) | ( ( (lv_instruction_1_0= 'INC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
    public final EObject ruleIncInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token lv_instruction_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_1 = null;

        EObject lv_operand_3_2 = null;

        EObject lv_operand_3_3 = null;

        EObject lv_operand_3_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1127:2: ( ( ( ( (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' ) ) ) | ( ( (lv_instruction_1_0= 'INC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:1128:2: ( ( ( (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' ) ) ) | ( ( (lv_instruction_1_0= 'INC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:1128:2: ( ( ( (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' ) ) ) | ( ( (lv_instruction_1_0= 'INC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=15 && LA10_0<=16)) ) {
                alt10=1;
            }
            else if ( (LA10_0==17) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:1129:3: ( ( (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' ) ) )
                    {
                    // InternalAssembler.g:1129:3: ( ( (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' ) ) )
                    // InternalAssembler.g:1130:4: ( (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' ) )
                    {
                    // InternalAssembler.g:1130:4: ( (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' ) )
                    // InternalAssembler.g:1131:5: (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' )
                    {
                    // InternalAssembler.g:1131:5: (lv_instruction_0_1= 'INCA' | lv_instruction_0_2= 'INCB' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==15) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==16) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalAssembler.g:1132:6: lv_instruction_0_1= 'INCA'
                            {
                            lv_instruction_0_1=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_1, grammarAccess.getIncInstructionAccess().getInstructionINCAKeyword_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIncInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:1143:6: lv_instruction_0_2= 'INCB'
                            {
                            lv_instruction_0_2=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_2, grammarAccess.getIncInstructionAccess().getInstructionINCBKeyword_0_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIncInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1157:3: ( ( (lv_instruction_1_0= 'INC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:1157:3: ( ( (lv_instruction_1_0= 'INC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:1158:4: ( (lv_instruction_1_0= 'INC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:1158:4: ( (lv_instruction_1_0= 'INC' ) )
                    // InternalAssembler.g:1159:5: (lv_instruction_1_0= 'INC' )
                    {
                    // InternalAssembler.g:1159:5: (lv_instruction_1_0= 'INC' )
                    // InternalAssembler.g:1160:6: lv_instruction_1_0= 'INC'
                    {
                    lv_instruction_1_0=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_1_0, grammarAccess.getIncInstructionAccess().getInstructionINCKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIncInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_1_0, "INC");
                      					
                    }

                    }


                    }

                    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_2, grammarAccess.getIncInstructionAccess().getWSTerminalRuleCall_1_1());
                      			
                    }
                    // InternalAssembler.g:1176:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:1177:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:1177:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:1178:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:1178:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt9=4;
                    alt9 = dfa9.predict(input);
                    switch (alt9) {
                        case 1 :
                            // InternalAssembler.g:1179:7: lv_operand_3_1= ruleDirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getIncInstructionAccess().getOperandDirectOperandParserRuleCall_1_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_1=ruleDirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getIncInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_1,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:1195:7: lv_operand_3_2= ruleIndexedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getIncInstructionAccess().getOperandIndexedOperandParserRuleCall_1_2_0_1());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_2=ruleIndexedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getIncInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_2,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:1211:7: lv_operand_3_3= ruleExtendedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getIncInstructionAccess().getOperandExtendedOperandParserRuleCall_1_2_0_2());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_3=ruleExtendedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getIncInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_3,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:1227:7: lv_operand_3_4= ruleExtendedIndirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getIncInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_1_2_0_3());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_4=ruleExtendedIndirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getIncInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_4,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncInstruction"


    // $ANTLR start "entryRuleExgInstruction"
    // InternalAssembler.g:1250:1: entryRuleExgInstruction returns [EObject current=null] : iv_ruleExgInstruction= ruleExgInstruction EOF ;
    public final EObject entryRuleExgInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExgInstruction = null;


        try {
            // InternalAssembler.g:1250:55: (iv_ruleExgInstruction= ruleExgInstruction EOF )
            // InternalAssembler.g:1251:2: iv_ruleExgInstruction= ruleExgInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExgInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExgInstruction=ruleExgInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExgInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExgInstruction"


    // $ANTLR start "ruleExgInstruction"
    // InternalAssembler.g:1257:1: ruleExgInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'EXG' ) ) this_WS_1= RULE_WS ( (lv_reg1_2_0= ruleRegister ) ) otherlv_3= ',' ( (lv_reg2_4_0= ruleRegister ) ) ) ;
    public final EObject ruleExgInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_reg1_2_0 = null;

        Enumerator lv_reg2_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1263:2: ( ( ( (lv_instruction_0_0= 'EXG' ) ) this_WS_1= RULE_WS ( (lv_reg1_2_0= ruleRegister ) ) otherlv_3= ',' ( (lv_reg2_4_0= ruleRegister ) ) ) )
            // InternalAssembler.g:1264:2: ( ( (lv_instruction_0_0= 'EXG' ) ) this_WS_1= RULE_WS ( (lv_reg1_2_0= ruleRegister ) ) otherlv_3= ',' ( (lv_reg2_4_0= ruleRegister ) ) )
            {
            // InternalAssembler.g:1264:2: ( ( (lv_instruction_0_0= 'EXG' ) ) this_WS_1= RULE_WS ( (lv_reg1_2_0= ruleRegister ) ) otherlv_3= ',' ( (lv_reg2_4_0= ruleRegister ) ) )
            // InternalAssembler.g:1265:3: ( (lv_instruction_0_0= 'EXG' ) ) this_WS_1= RULE_WS ( (lv_reg1_2_0= ruleRegister ) ) otherlv_3= ',' ( (lv_reg2_4_0= ruleRegister ) )
            {
            // InternalAssembler.g:1265:3: ( (lv_instruction_0_0= 'EXG' ) )
            // InternalAssembler.g:1266:4: (lv_instruction_0_0= 'EXG' )
            {
            // InternalAssembler.g:1266:4: (lv_instruction_0_0= 'EXG' )
            // InternalAssembler.g:1267:5: lv_instruction_0_0= 'EXG'
            {
            lv_instruction_0_0=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_instruction_0_0, grammarAccess.getExgInstructionAccess().getInstructionEXGKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getExgInstructionRule());
              					}
              					setWithLastConsumed(current, "instruction", lv_instruction_0_0, "EXG");
              				
            }

            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getExgInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1283:3: ( (lv_reg1_2_0= ruleRegister ) )
            // InternalAssembler.g:1284:4: (lv_reg1_2_0= ruleRegister )
            {
            // InternalAssembler.g:1284:4: (lv_reg1_2_0= ruleRegister )
            // InternalAssembler.g:1285:5: lv_reg1_2_0= ruleRegister
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExgInstructionAccess().getReg1RegisterEnumRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_reg1_2_0=ruleRegister();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExgInstructionRule());
              					}
              					set(
              						current,
              						"reg1",
              						lv_reg1_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.Register");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getExgInstructionAccess().getCommaKeyword_3());
              		
            }
            // InternalAssembler.g:1306:3: ( (lv_reg2_4_0= ruleRegister ) )
            // InternalAssembler.g:1307:4: (lv_reg2_4_0= ruleRegister )
            {
            // InternalAssembler.g:1307:4: (lv_reg2_4_0= ruleRegister )
            // InternalAssembler.g:1308:5: lv_reg2_4_0= ruleRegister
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExgInstructionAccess().getReg2RegisterEnumRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_reg2_4_0=ruleRegister();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExgInstructionRule());
              					}
              					set(
              						current,
              						"reg2",
              						lv_reg2_4_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.Register");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExgInstruction"


    // $ANTLR start "entryRuleEorInstruction"
    // InternalAssembler.g:1329:1: entryRuleEorInstruction returns [EObject current=null] : iv_ruleEorInstruction= ruleEorInstruction EOF ;
    public final EObject entryRuleEorInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEorInstruction = null;


        try {
            // InternalAssembler.g:1329:55: (iv_ruleEorInstruction= ruleEorInstruction EOF )
            // InternalAssembler.g:1330:2: iv_ruleEorInstruction= ruleEorInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEorInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEorInstruction=ruleEorInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEorInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEorInstruction"


    // $ANTLR start "ruleEorInstruction"
    // InternalAssembler.g:1336:1: ruleEorInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
    public final EObject ruleEorInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_1 = null;

        EObject lv_operand_2_2 = null;

        EObject lv_operand_2_3 = null;

        EObject lv_operand_2_4 = null;

        EObject lv_operand_2_5 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1342:2: ( ( ( ( (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1343:2: ( ( ( (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1343:2: ( ( ( (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1344:3: ( ( (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1344:3: ( ( (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' ) ) )
            // InternalAssembler.g:1345:4: ( (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' ) )
            {
            // InternalAssembler.g:1345:4: ( (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' ) )
            // InternalAssembler.g:1346:5: (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' )
            {
            // InternalAssembler.g:1346:5: (lv_instruction_0_1= 'EORA' | lv_instruction_0_2= 'EORB' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            else if ( (LA11_0==21) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalAssembler.g:1347:6: lv_instruction_0_1= 'EORA'
                    {
                    lv_instruction_0_1=(Token)match(input,20,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getEorInstructionAccess().getInstructionEORAKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEorInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1358:6: lv_instruction_0_2= 'EORB'
                    {
                    lv_instruction_0_2=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getEorInstructionAccess().getInstructionEORBKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEorInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEorInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1375:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1376:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1376:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1377:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1377:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt12=5;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalAssembler.g:1378:6: lv_operand_2_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEorInstructionAccess().getOperandImmediatOperandParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEorInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_1,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1394:6: lv_operand_2_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEorInstructionAccess().getOperandDirectOperandParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEorInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_2,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:1410:6: lv_operand_2_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEorInstructionAccess().getOperandIndexedOperandParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEorInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_3,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:1426:6: lv_operand_2_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEorInstructionAccess().getOperandExtendedOperandParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEorInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_4,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalAssembler.g:1442:6: lv_operand_2_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEorInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_0_4());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEorInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_5,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEorInstruction"


    // $ANTLR start "entryRuleDecInstruction"
    // InternalAssembler.g:1464:1: entryRuleDecInstruction returns [EObject current=null] : iv_ruleDecInstruction= ruleDecInstruction EOF ;
    public final EObject entryRuleDecInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecInstruction = null;


        try {
            // InternalAssembler.g:1464:55: (iv_ruleDecInstruction= ruleDecInstruction EOF )
            // InternalAssembler.g:1465:2: iv_ruleDecInstruction= ruleDecInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDecInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDecInstruction=ruleDecInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecInstruction"


    // $ANTLR start "ruleDecInstruction"
    // InternalAssembler.g:1471:1: ruleDecInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' ) ) ) | ( ( (lv_instruction_1_0= 'DEC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
    public final EObject ruleDecInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token lv_instruction_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_1 = null;

        EObject lv_operand_3_2 = null;

        EObject lv_operand_3_3 = null;

        EObject lv_operand_3_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1477:2: ( ( ( ( (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' ) ) ) | ( ( (lv_instruction_1_0= 'DEC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:1478:2: ( ( ( (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' ) ) ) | ( ( (lv_instruction_1_0= 'DEC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:1478:2: ( ( ( (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' ) ) ) | ( ( (lv_instruction_1_0= 'DEC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=22 && LA15_0<=23)) ) {
                alt15=1;
            }
            else if ( (LA15_0==24) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalAssembler.g:1479:3: ( ( (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' ) ) )
                    {
                    // InternalAssembler.g:1479:3: ( ( (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' ) ) )
                    // InternalAssembler.g:1480:4: ( (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' ) )
                    {
                    // InternalAssembler.g:1480:4: ( (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' ) )
                    // InternalAssembler.g:1481:5: (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' )
                    {
                    // InternalAssembler.g:1481:5: (lv_instruction_0_1= 'DECA' | lv_instruction_0_2= 'DECB' )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==22) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==23) ) {
                        alt13=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalAssembler.g:1482:6: lv_instruction_0_1= 'DECA'
                            {
                            lv_instruction_0_1=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_1, grammarAccess.getDecInstructionAccess().getInstructionDECAKeyword_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getDecInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:1493:6: lv_instruction_0_2= 'DECB'
                            {
                            lv_instruction_0_2=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_2, grammarAccess.getDecInstructionAccess().getInstructionDECBKeyword_0_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getDecInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1507:3: ( ( (lv_instruction_1_0= 'DEC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:1507:3: ( ( (lv_instruction_1_0= 'DEC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:1508:4: ( (lv_instruction_1_0= 'DEC' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:1508:4: ( (lv_instruction_1_0= 'DEC' ) )
                    // InternalAssembler.g:1509:5: (lv_instruction_1_0= 'DEC' )
                    {
                    // InternalAssembler.g:1509:5: (lv_instruction_1_0= 'DEC' )
                    // InternalAssembler.g:1510:6: lv_instruction_1_0= 'DEC'
                    {
                    lv_instruction_1_0=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_1_0, grammarAccess.getDecInstructionAccess().getInstructionDECKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDecInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_1_0, "DEC");
                      					
                    }

                    }


                    }

                    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_2, grammarAccess.getDecInstructionAccess().getWSTerminalRuleCall_1_1());
                      			
                    }
                    // InternalAssembler.g:1526:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:1527:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:1527:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:1528:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:1528:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt14=4;
                    alt14 = dfa14.predict(input);
                    switch (alt14) {
                        case 1 :
                            // InternalAssembler.g:1529:7: lv_operand_3_1= ruleDirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getDecInstructionAccess().getOperandDirectOperandParserRuleCall_1_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_1=ruleDirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getDecInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_1,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:1545:7: lv_operand_3_2= ruleIndexedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getDecInstructionAccess().getOperandIndexedOperandParserRuleCall_1_2_0_1());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_2=ruleIndexedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getDecInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_2,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:1561:7: lv_operand_3_3= ruleExtendedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getDecInstructionAccess().getOperandExtendedOperandParserRuleCall_1_2_0_2());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_3=ruleExtendedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getDecInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_3,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:1577:7: lv_operand_3_4= ruleExtendedIndirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getDecInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_1_2_0_3());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_4=ruleExtendedIndirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getDecInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_4,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecInstruction"


    // $ANTLR start "entryRuleDaaInstruction"
    // InternalAssembler.g:1600:1: entryRuleDaaInstruction returns [EObject current=null] : iv_ruleDaaInstruction= ruleDaaInstruction EOF ;
    public final EObject entryRuleDaaInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDaaInstruction = null;


        try {
            // InternalAssembler.g:1600:55: (iv_ruleDaaInstruction= ruleDaaInstruction EOF )
            // InternalAssembler.g:1601:2: iv_ruleDaaInstruction= ruleDaaInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDaaInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDaaInstruction=ruleDaaInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDaaInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDaaInstruction"


    // $ANTLR start "ruleDaaInstruction"
    // InternalAssembler.g:1607:1: ruleDaaInstruction returns [EObject current=null] : ( (lv_instruction_0_0= 'DAA' ) ) ;
    public final EObject ruleDaaInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1613:2: ( ( (lv_instruction_0_0= 'DAA' ) ) )
            // InternalAssembler.g:1614:2: ( (lv_instruction_0_0= 'DAA' ) )
            {
            // InternalAssembler.g:1614:2: ( (lv_instruction_0_0= 'DAA' ) )
            // InternalAssembler.g:1615:3: (lv_instruction_0_0= 'DAA' )
            {
            // InternalAssembler.g:1615:3: (lv_instruction_0_0= 'DAA' )
            // InternalAssembler.g:1616:4: lv_instruction_0_0= 'DAA'
            {
            lv_instruction_0_0=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_instruction_0_0, grammarAccess.getDaaInstructionAccess().getInstructionDAAKeyword_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getDaaInstructionRule());
              				}
              				setWithLastConsumed(current, "instruction", lv_instruction_0_0, "DAA");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDaaInstruction"


    // $ANTLR start "entryRuleCwaiInstruction"
    // InternalAssembler.g:1631:1: entryRuleCwaiInstruction returns [EObject current=null] : iv_ruleCwaiInstruction= ruleCwaiInstruction EOF ;
    public final EObject entryRuleCwaiInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCwaiInstruction = null;


        try {
            // InternalAssembler.g:1631:56: (iv_ruleCwaiInstruction= ruleCwaiInstruction EOF )
            // InternalAssembler.g:1632:2: iv_ruleCwaiInstruction= ruleCwaiInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCwaiInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCwaiInstruction=ruleCwaiInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCwaiInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCwaiInstruction"


    // $ANTLR start "ruleCwaiInstruction"
    // InternalAssembler.g:1638:1: ruleCwaiInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'CWAI' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) ;
    public final EObject ruleCwaiInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1644:2: ( ( ( (lv_instruction_0_0= 'CWAI' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) )
            // InternalAssembler.g:1645:2: ( ( (lv_instruction_0_0= 'CWAI' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            {
            // InternalAssembler.g:1645:2: ( ( (lv_instruction_0_0= 'CWAI' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            // InternalAssembler.g:1646:3: ( (lv_instruction_0_0= 'CWAI' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) )
            {
            // InternalAssembler.g:1646:3: ( (lv_instruction_0_0= 'CWAI' ) )
            // InternalAssembler.g:1647:4: (lv_instruction_0_0= 'CWAI' )
            {
            // InternalAssembler.g:1647:4: (lv_instruction_0_0= 'CWAI' )
            // InternalAssembler.g:1648:5: lv_instruction_0_0= 'CWAI'
            {
            lv_instruction_0_0=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_instruction_0_0, grammarAccess.getCwaiInstructionAccess().getInstructionCWAIKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCwaiInstructionRule());
              					}
              					setWithLastConsumed(current, "instruction", lv_instruction_0_0, "CWAI");
              				
            }

            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getCwaiInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1664:3: ( (lv_operand_2_0= ruleImmediatOperand ) )
            // InternalAssembler.g:1665:4: (lv_operand_2_0= ruleImmediatOperand )
            {
            // InternalAssembler.g:1665:4: (lv_operand_2_0= ruleImmediatOperand )
            // InternalAssembler.g:1666:5: lv_operand_2_0= ruleImmediatOperand
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCwaiInstructionAccess().getOperandImmediatOperandParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleImmediatOperand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCwaiInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCwaiInstruction"


    // $ANTLR start "entryRuleComInstruction"
    // InternalAssembler.g:1687:1: entryRuleComInstruction returns [EObject current=null] : iv_ruleComInstruction= ruleComInstruction EOF ;
    public final EObject entryRuleComInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComInstruction = null;


        try {
            // InternalAssembler.g:1687:55: (iv_ruleComInstruction= ruleComInstruction EOF )
            // InternalAssembler.g:1688:2: iv_ruleComInstruction= ruleComInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComInstruction=ruleComInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComInstruction"


    // $ANTLR start "ruleComInstruction"
    // InternalAssembler.g:1694:1: ruleComInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' ) ) ) | ( ( (lv_instruction_1_0= 'COM' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
    public final EObject ruleComInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token lv_instruction_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_1 = null;

        EObject lv_operand_3_2 = null;

        EObject lv_operand_3_3 = null;

        EObject lv_operand_3_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1700:2: ( ( ( ( (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' ) ) ) | ( ( (lv_instruction_1_0= 'COM' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:1701:2: ( ( ( (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' ) ) ) | ( ( (lv_instruction_1_0= 'COM' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:1701:2: ( ( ( (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' ) ) ) | ( ( (lv_instruction_1_0= 'COM' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=27 && LA18_0<=28)) ) {
                alt18=1;
            }
            else if ( (LA18_0==29) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalAssembler.g:1702:3: ( ( (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' ) ) )
                    {
                    // InternalAssembler.g:1702:3: ( ( (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' ) ) )
                    // InternalAssembler.g:1703:4: ( (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' ) )
                    {
                    // InternalAssembler.g:1703:4: ( (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' ) )
                    // InternalAssembler.g:1704:5: (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' )
                    {
                    // InternalAssembler.g:1704:5: (lv_instruction_0_1= 'COMA' | lv_instruction_0_2= 'COMB' )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==27) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==28) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalAssembler.g:1705:6: lv_instruction_0_1= 'COMA'
                            {
                            lv_instruction_0_1=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_1, grammarAccess.getComInstructionAccess().getInstructionCOMAKeyword_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getComInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:1716:6: lv_instruction_0_2= 'COMB'
                            {
                            lv_instruction_0_2=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_2, grammarAccess.getComInstructionAccess().getInstructionCOMBKeyword_0_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getComInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1730:3: ( ( (lv_instruction_1_0= 'COM' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:1730:3: ( ( (lv_instruction_1_0= 'COM' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:1731:4: ( (lv_instruction_1_0= 'COM' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:1731:4: ( (lv_instruction_1_0= 'COM' ) )
                    // InternalAssembler.g:1732:5: (lv_instruction_1_0= 'COM' )
                    {
                    // InternalAssembler.g:1732:5: (lv_instruction_1_0= 'COM' )
                    // InternalAssembler.g:1733:6: lv_instruction_1_0= 'COM'
                    {
                    lv_instruction_1_0=(Token)match(input,29,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_1_0, grammarAccess.getComInstructionAccess().getInstructionCOMKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getComInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_1_0, "COM");
                      					
                    }

                    }


                    }

                    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_2, grammarAccess.getComInstructionAccess().getWSTerminalRuleCall_1_1());
                      			
                    }
                    // InternalAssembler.g:1749:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:1750:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:1750:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:1751:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:1751:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt17=4;
                    alt17 = dfa17.predict(input);
                    switch (alt17) {
                        case 1 :
                            // InternalAssembler.g:1752:7: lv_operand_3_1= ruleDirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getComInstructionAccess().getOperandDirectOperandParserRuleCall_1_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_1=ruleDirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getComInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_1,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:1768:7: lv_operand_3_2= ruleIndexedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getComInstructionAccess().getOperandIndexedOperandParserRuleCall_1_2_0_1());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_2=ruleIndexedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getComInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_2,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:1784:7: lv_operand_3_3= ruleExtendedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getComInstructionAccess().getOperandExtendedOperandParserRuleCall_1_2_0_2());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_3=ruleExtendedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getComInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_3,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:1800:7: lv_operand_3_4= ruleExtendedIndirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getComInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_1_2_0_3());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_4=ruleExtendedIndirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getComInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_4,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComInstruction"


    // $ANTLR start "entryRuleCmpInstruction"
    // InternalAssembler.g:1823:1: entryRuleCmpInstruction returns [EObject current=null] : iv_ruleCmpInstruction= ruleCmpInstruction EOF ;
    public final EObject entryRuleCmpInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmpInstruction = null;


        try {
            // InternalAssembler.g:1823:55: (iv_ruleCmpInstruction= ruleCmpInstruction EOF )
            // InternalAssembler.g:1824:2: iv_ruleCmpInstruction= ruleCmpInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCmpInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCmpInstruction=ruleCmpInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCmpInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCmpInstruction"


    // $ANTLR start "ruleCmpInstruction"
    // InternalAssembler.g:1830:1: ruleCmpInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
    public final EObject ruleCmpInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_1 = null;

        EObject lv_operand_2_2 = null;

        EObject lv_operand_2_3 = null;

        EObject lv_operand_2_4 = null;

        EObject lv_operand_2_5 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1836:2: ( ( ( ( (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1837:2: ( ( ( (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1837:2: ( ( ( (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1838:3: ( ( (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1838:3: ( ( (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' ) ) )
            // InternalAssembler.g:1839:4: ( (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' ) )
            {
            // InternalAssembler.g:1839:4: ( (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' ) )
            // InternalAssembler.g:1840:5: (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' )
            {
            // InternalAssembler.g:1840:5: (lv_instruction_0_1= 'CMPA' | lv_instruction_0_2= 'CMPB' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            else if ( (LA19_0==31) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalAssembler.g:1841:6: lv_instruction_0_1= 'CMPA'
                    {
                    lv_instruction_0_1=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getCmpInstructionAccess().getInstructionCMPAKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCmpInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1852:6: lv_instruction_0_2= 'CMPB'
                    {
                    lv_instruction_0_2=(Token)match(input,31,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getCmpInstructionAccess().getInstructionCMPBKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCmpInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getCmpInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1869:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1870:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1870:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1871:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1871:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt20=5;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1872:6: lv_operand_2_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCmpInstructionAccess().getOperandImmediatOperandParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCmpInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_1,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1888:6: lv_operand_2_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCmpInstructionAccess().getOperandDirectOperandParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCmpInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_2,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:1904:6: lv_operand_2_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCmpInstructionAccess().getOperandIndexedOperandParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCmpInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_3,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:1920:6: lv_operand_2_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCmpInstructionAccess().getOperandExtendedOperandParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCmpInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_4,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalAssembler.g:1936:6: lv_operand_2_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCmpInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_0_4());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCmpInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_5,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCmpInstruction"


    // $ANTLR start "entryRuleClrInstruction"
    // InternalAssembler.g:1958:1: entryRuleClrInstruction returns [EObject current=null] : iv_ruleClrInstruction= ruleClrInstruction EOF ;
    public final EObject entryRuleClrInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClrInstruction = null;


        try {
            // InternalAssembler.g:1958:55: (iv_ruleClrInstruction= ruleClrInstruction EOF )
            // InternalAssembler.g:1959:2: iv_ruleClrInstruction= ruleClrInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClrInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClrInstruction=ruleClrInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClrInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClrInstruction"


    // $ANTLR start "ruleClrInstruction"
    // InternalAssembler.g:1965:1: ruleClrInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' ) ) ) | ( ( (lv_instruction_1_0= 'CLR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
    public final EObject ruleClrInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token lv_instruction_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_1 = null;

        EObject lv_operand_3_2 = null;

        EObject lv_operand_3_3 = null;

        EObject lv_operand_3_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1971:2: ( ( ( ( (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' ) ) ) | ( ( (lv_instruction_1_0= 'CLR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:1972:2: ( ( ( (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' ) ) ) | ( ( (lv_instruction_1_0= 'CLR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:1972:2: ( ( ( (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' ) ) ) | ( ( (lv_instruction_1_0= 'CLR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=32 && LA23_0<=33)) ) {
                alt23=1;
            }
            else if ( (LA23_0==34) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalAssembler.g:1973:3: ( ( (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' ) ) )
                    {
                    // InternalAssembler.g:1973:3: ( ( (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' ) ) )
                    // InternalAssembler.g:1974:4: ( (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' ) )
                    {
                    // InternalAssembler.g:1974:4: ( (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' ) )
                    // InternalAssembler.g:1975:5: (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' )
                    {
                    // InternalAssembler.g:1975:5: (lv_instruction_0_1= 'CLRA' | lv_instruction_0_2= 'CLRB' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==32) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==33) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalAssembler.g:1976:6: lv_instruction_0_1= 'CLRA'
                            {
                            lv_instruction_0_1=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_1, grammarAccess.getClrInstructionAccess().getInstructionCLRAKeyword_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getClrInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:1987:6: lv_instruction_0_2= 'CLRB'
                            {
                            lv_instruction_0_2=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_2, grammarAccess.getClrInstructionAccess().getInstructionCLRBKeyword_0_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getClrInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2001:3: ( ( (lv_instruction_1_0= 'CLR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:2001:3: ( ( (lv_instruction_1_0= 'CLR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:2002:4: ( (lv_instruction_1_0= 'CLR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:2002:4: ( (lv_instruction_1_0= 'CLR' ) )
                    // InternalAssembler.g:2003:5: (lv_instruction_1_0= 'CLR' )
                    {
                    // InternalAssembler.g:2003:5: (lv_instruction_1_0= 'CLR' )
                    // InternalAssembler.g:2004:6: lv_instruction_1_0= 'CLR'
                    {
                    lv_instruction_1_0=(Token)match(input,34,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_1_0, grammarAccess.getClrInstructionAccess().getInstructionCLRKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClrInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_1_0, "CLR");
                      					
                    }

                    }


                    }

                    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_2, grammarAccess.getClrInstructionAccess().getWSTerminalRuleCall_1_1());
                      			
                    }
                    // InternalAssembler.g:2020:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:2021:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:2021:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:2022:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:2022:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt22=4;
                    alt22 = dfa22.predict(input);
                    switch (alt22) {
                        case 1 :
                            // InternalAssembler.g:2023:7: lv_operand_3_1= ruleDirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getClrInstructionAccess().getOperandDirectOperandParserRuleCall_1_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_1=ruleDirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getClrInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_1,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:2039:7: lv_operand_3_2= ruleIndexedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getClrInstructionAccess().getOperandIndexedOperandParserRuleCall_1_2_0_1());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_2=ruleIndexedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getClrInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_2,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:2055:7: lv_operand_3_3= ruleExtendedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getClrInstructionAccess().getOperandExtendedOperandParserRuleCall_1_2_0_2());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_3=ruleExtendedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getClrInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_3,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:2071:7: lv_operand_3_4= ruleExtendedIndirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getClrInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_1_2_0_3());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_4=ruleExtendedIndirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getClrInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_4,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClrInstruction"


    // $ANTLR start "entryRuleBvsInstruction"
    // InternalAssembler.g:2094:1: entryRuleBvsInstruction returns [EObject current=null] : iv_ruleBvsInstruction= ruleBvsInstruction EOF ;
    public final EObject entryRuleBvsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBvsInstruction = null;


        try {
            // InternalAssembler.g:2094:55: (iv_ruleBvsInstruction= ruleBvsInstruction EOF )
            // InternalAssembler.g:2095:2: iv_ruleBvsInstruction= ruleBvsInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBvsInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBvsInstruction=ruleBvsInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBvsInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBvsInstruction"


    // $ANTLR start "ruleBvsInstruction"
    // InternalAssembler.g:2101:1: ruleBvsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBvsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2107:2: ( ( ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2108:2: ( ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2108:2: ( ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2109:3: ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2109:3: ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) )
            // InternalAssembler.g:2110:4: ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) )
            {
            // InternalAssembler.g:2110:4: ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) )
            // InternalAssembler.g:2111:5: (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' )
            {
            // InternalAssembler.g:2111:5: (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            else if ( (LA24_0==36) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalAssembler.g:2112:6: lv_instruction_0_1= 'BVS'
                    {
                    lv_instruction_0_1=(Token)match(input,35,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBvsInstructionAccess().getInstructionBVSKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBvsInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2123:6: lv_instruction_0_2= 'LBVS'
                    {
                    lv_instruction_0_2=(Token)match(input,36,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBvsInstructionAccess().getInstructionLBVSKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBvsInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBvsInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2140:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2141:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2141:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2142:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBvsInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBvsInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBvsInstruction"


    // $ANTLR start "entryRuleBvcInstruction"
    // InternalAssembler.g:2163:1: entryRuleBvcInstruction returns [EObject current=null] : iv_ruleBvcInstruction= ruleBvcInstruction EOF ;
    public final EObject entryRuleBvcInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBvcInstruction = null;


        try {
            // InternalAssembler.g:2163:55: (iv_ruleBvcInstruction= ruleBvcInstruction EOF )
            // InternalAssembler.g:2164:2: iv_ruleBvcInstruction= ruleBvcInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBvcInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBvcInstruction=ruleBvcInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBvcInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBvcInstruction"


    // $ANTLR start "ruleBvcInstruction"
    // InternalAssembler.g:2170:1: ruleBvcInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBvcInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2176:2: ( ( ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2177:2: ( ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2177:2: ( ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2178:3: ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2178:3: ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) )
            // InternalAssembler.g:2179:4: ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) )
            {
            // InternalAssembler.g:2179:4: ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) )
            // InternalAssembler.g:2180:5: (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' )
            {
            // InternalAssembler.g:2180:5: (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalAssembler.g:2181:6: lv_instruction_0_1= 'BVC'
                    {
                    lv_instruction_0_1=(Token)match(input,37,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBvcInstructionAccess().getInstructionBVCKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBvcInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2192:6: lv_instruction_0_2= 'LBVC'
                    {
                    lv_instruction_0_2=(Token)match(input,38,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBvcInstructionAccess().getInstructionLBVCKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBvcInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBvcInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2209:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2210:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2210:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2211:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBvcInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBvcInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBvcInstruction"


    // $ANTLR start "entryRuleBsrInstruction"
    // InternalAssembler.g:2232:1: entryRuleBsrInstruction returns [EObject current=null] : iv_ruleBsrInstruction= ruleBsrInstruction EOF ;
    public final EObject entryRuleBsrInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBsrInstruction = null;


        try {
            // InternalAssembler.g:2232:55: (iv_ruleBsrInstruction= ruleBsrInstruction EOF )
            // InternalAssembler.g:2233:2: iv_ruleBsrInstruction= ruleBsrInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBsrInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBsrInstruction=ruleBsrInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBsrInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBsrInstruction"


    // $ANTLR start "ruleBsrInstruction"
    // InternalAssembler.g:2239:1: ruleBsrInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBsrInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2245:2: ( ( ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2246:2: ( ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2246:2: ( ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2247:3: ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2247:3: ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) )
            // InternalAssembler.g:2248:4: ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) )
            {
            // InternalAssembler.g:2248:4: ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) )
            // InternalAssembler.g:2249:5: (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' )
            {
            // InternalAssembler.g:2249:5: (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==39) ) {
                alt26=1;
            }
            else if ( (LA26_0==40) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalAssembler.g:2250:6: lv_instruction_0_1= 'BSR'
                    {
                    lv_instruction_0_1=(Token)match(input,39,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBsrInstructionAccess().getInstructionBSRKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBsrInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2261:6: lv_instruction_0_2= 'LBSR'
                    {
                    lv_instruction_0_2=(Token)match(input,40,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBsrInstructionAccess().getInstructionLBSRKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBsrInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBsrInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2278:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2279:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2279:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2280:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBsrInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBsrInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBsrInstruction"


    // $ANTLR start "entryRuleBrnInstruction"
    // InternalAssembler.g:2301:1: entryRuleBrnInstruction returns [EObject current=null] : iv_ruleBrnInstruction= ruleBrnInstruction EOF ;
    public final EObject entryRuleBrnInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBrnInstruction = null;


        try {
            // InternalAssembler.g:2301:55: (iv_ruleBrnInstruction= ruleBrnInstruction EOF )
            // InternalAssembler.g:2302:2: iv_ruleBrnInstruction= ruleBrnInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBrnInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBrnInstruction=ruleBrnInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBrnInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBrnInstruction"


    // $ANTLR start "ruleBrnInstruction"
    // InternalAssembler.g:2308:1: ruleBrnInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBrnInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2314:2: ( ( ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2315:2: ( ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2315:2: ( ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2316:3: ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2316:3: ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) )
            // InternalAssembler.g:2317:4: ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) )
            {
            // InternalAssembler.g:2317:4: ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) )
            // InternalAssembler.g:2318:5: (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' )
            {
            // InternalAssembler.g:2318:5: (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==41) ) {
                alt27=1;
            }
            else if ( (LA27_0==42) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalAssembler.g:2319:6: lv_instruction_0_1= 'BRN'
                    {
                    lv_instruction_0_1=(Token)match(input,41,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBrnInstructionAccess().getInstructionBRNKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBrnInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2330:6: lv_instruction_0_2= 'LBRN'
                    {
                    lv_instruction_0_2=(Token)match(input,42,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBrnInstructionAccess().getInstructionLBRNKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBrnInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBrnInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2347:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2348:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2348:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2349:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBrnInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBrnInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBrnInstruction"


    // $ANTLR start "entryRuleBraInstruction"
    // InternalAssembler.g:2370:1: entryRuleBraInstruction returns [EObject current=null] : iv_ruleBraInstruction= ruleBraInstruction EOF ;
    public final EObject entryRuleBraInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBraInstruction = null;


        try {
            // InternalAssembler.g:2370:55: (iv_ruleBraInstruction= ruleBraInstruction EOF )
            // InternalAssembler.g:2371:2: iv_ruleBraInstruction= ruleBraInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBraInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBraInstruction=ruleBraInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBraInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBraInstruction"


    // $ANTLR start "ruleBraInstruction"
    // InternalAssembler.g:2377:1: ruleBraInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBraInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2383:2: ( ( ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2384:2: ( ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2384:2: ( ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2385:3: ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2385:3: ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) )
            // InternalAssembler.g:2386:4: ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) )
            {
            // InternalAssembler.g:2386:4: ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) )
            // InternalAssembler.g:2387:5: (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' )
            {
            // InternalAssembler.g:2387:5: (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==43) ) {
                alt28=1;
            }
            else if ( (LA28_0==44) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalAssembler.g:2388:6: lv_instruction_0_1= 'BRA'
                    {
                    lv_instruction_0_1=(Token)match(input,43,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBraInstructionAccess().getInstructionBRAKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBraInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2399:6: lv_instruction_0_2= 'LBRA'
                    {
                    lv_instruction_0_2=(Token)match(input,44,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBraInstructionAccess().getInstructionLBRAKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBraInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBraInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2416:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2417:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2417:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2418:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBraInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBraInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBraInstruction"


    // $ANTLR start "entryRuleBplInstruction"
    // InternalAssembler.g:2439:1: entryRuleBplInstruction returns [EObject current=null] : iv_ruleBplInstruction= ruleBplInstruction EOF ;
    public final EObject entryRuleBplInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBplInstruction = null;


        try {
            // InternalAssembler.g:2439:55: (iv_ruleBplInstruction= ruleBplInstruction EOF )
            // InternalAssembler.g:2440:2: iv_ruleBplInstruction= ruleBplInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBplInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBplInstruction=ruleBplInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBplInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBplInstruction"


    // $ANTLR start "ruleBplInstruction"
    // InternalAssembler.g:2446:1: ruleBplInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBplInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2452:2: ( ( ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2453:2: ( ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2453:2: ( ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2454:3: ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2454:3: ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) )
            // InternalAssembler.g:2455:4: ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) )
            {
            // InternalAssembler.g:2455:4: ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) )
            // InternalAssembler.g:2456:5: (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' )
            {
            // InternalAssembler.g:2456:5: (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==45) ) {
                alt29=1;
            }
            else if ( (LA29_0==46) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalAssembler.g:2457:6: lv_instruction_0_1= 'BPL'
                    {
                    lv_instruction_0_1=(Token)match(input,45,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBplInstructionAccess().getInstructionBPLKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBplInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2468:6: lv_instruction_0_2= 'LBPL'
                    {
                    lv_instruction_0_2=(Token)match(input,46,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBplInstructionAccess().getInstructionLBPLKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBplInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBplInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2485:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2486:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2486:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2487:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBplInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBplInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBplInstruction"


    // $ANTLR start "entryRuleBneInstruction"
    // InternalAssembler.g:2508:1: entryRuleBneInstruction returns [EObject current=null] : iv_ruleBneInstruction= ruleBneInstruction EOF ;
    public final EObject entryRuleBneInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBneInstruction = null;


        try {
            // InternalAssembler.g:2508:55: (iv_ruleBneInstruction= ruleBneInstruction EOF )
            // InternalAssembler.g:2509:2: iv_ruleBneInstruction= ruleBneInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBneInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBneInstruction=ruleBneInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBneInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBneInstruction"


    // $ANTLR start "ruleBneInstruction"
    // InternalAssembler.g:2515:1: ruleBneInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBneInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2521:2: ( ( ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2522:2: ( ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2522:2: ( ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2523:3: ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2523:3: ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) )
            // InternalAssembler.g:2524:4: ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) )
            {
            // InternalAssembler.g:2524:4: ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) )
            // InternalAssembler.g:2525:5: (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' )
            {
            // InternalAssembler.g:2525:5: (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==47) ) {
                alt30=1;
            }
            else if ( (LA30_0==48) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalAssembler.g:2526:6: lv_instruction_0_1= 'BNE'
                    {
                    lv_instruction_0_1=(Token)match(input,47,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBneInstructionAccess().getInstructionBNEKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBneInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2537:6: lv_instruction_0_2= 'LBNE'
                    {
                    lv_instruction_0_2=(Token)match(input,48,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBneInstructionAccess().getInstructionLBNEKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBneInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBneInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2554:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2555:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2555:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2556:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBneInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBneInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBneInstruction"


    // $ANTLR start "entryRuleBmiInstruction"
    // InternalAssembler.g:2577:1: entryRuleBmiInstruction returns [EObject current=null] : iv_ruleBmiInstruction= ruleBmiInstruction EOF ;
    public final EObject entryRuleBmiInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBmiInstruction = null;


        try {
            // InternalAssembler.g:2577:55: (iv_ruleBmiInstruction= ruleBmiInstruction EOF )
            // InternalAssembler.g:2578:2: iv_ruleBmiInstruction= ruleBmiInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBmiInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBmiInstruction=ruleBmiInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBmiInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBmiInstruction"


    // $ANTLR start "ruleBmiInstruction"
    // InternalAssembler.g:2584:1: ruleBmiInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBmiInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2590:2: ( ( ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2591:2: ( ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2591:2: ( ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2592:3: ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2592:3: ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) )
            // InternalAssembler.g:2593:4: ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) )
            {
            // InternalAssembler.g:2593:4: ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) )
            // InternalAssembler.g:2594:5: (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' )
            {
            // InternalAssembler.g:2594:5: (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==49) ) {
                alt31=1;
            }
            else if ( (LA31_0==50) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalAssembler.g:2595:6: lv_instruction_0_1= 'BMI'
                    {
                    lv_instruction_0_1=(Token)match(input,49,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBmiInstructionAccess().getInstructionBMIKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBmiInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2606:6: lv_instruction_0_2= 'LBMI'
                    {
                    lv_instruction_0_2=(Token)match(input,50,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBmiInstructionAccess().getInstructionLBMIKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBmiInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBmiInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2623:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2624:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2624:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2625:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBmiInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBmiInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBmiInstruction"


    // $ANTLR start "entryRuleBltInstruction"
    // InternalAssembler.g:2646:1: entryRuleBltInstruction returns [EObject current=null] : iv_ruleBltInstruction= ruleBltInstruction EOF ;
    public final EObject entryRuleBltInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBltInstruction = null;


        try {
            // InternalAssembler.g:2646:55: (iv_ruleBltInstruction= ruleBltInstruction EOF )
            // InternalAssembler.g:2647:2: iv_ruleBltInstruction= ruleBltInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBltInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBltInstruction=ruleBltInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBltInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBltInstruction"


    // $ANTLR start "ruleBltInstruction"
    // InternalAssembler.g:2653:1: ruleBltInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBltInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2659:2: ( ( ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2660:2: ( ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2660:2: ( ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2661:3: ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2661:3: ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) )
            // InternalAssembler.g:2662:4: ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) )
            {
            // InternalAssembler.g:2662:4: ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) )
            // InternalAssembler.g:2663:5: (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' )
            {
            // InternalAssembler.g:2663:5: (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==51) ) {
                alt32=1;
            }
            else if ( (LA32_0==52) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalAssembler.g:2664:6: lv_instruction_0_1= 'BLT'
                    {
                    lv_instruction_0_1=(Token)match(input,51,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBltInstructionAccess().getInstructionBLTKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBltInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2675:6: lv_instruction_0_2= 'LBLT'
                    {
                    lv_instruction_0_2=(Token)match(input,52,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBltInstructionAccess().getInstructionLBLTKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBltInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBltInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2692:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2693:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2693:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2694:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBltInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBltInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBltInstruction"


    // $ANTLR start "entryRuleBlsInstruction"
    // InternalAssembler.g:2715:1: entryRuleBlsInstruction returns [EObject current=null] : iv_ruleBlsInstruction= ruleBlsInstruction EOF ;
    public final EObject entryRuleBlsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlsInstruction = null;


        try {
            // InternalAssembler.g:2715:55: (iv_ruleBlsInstruction= ruleBlsInstruction EOF )
            // InternalAssembler.g:2716:2: iv_ruleBlsInstruction= ruleBlsInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlsInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlsInstruction=ruleBlsInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlsInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlsInstruction"


    // $ANTLR start "ruleBlsInstruction"
    // InternalAssembler.g:2722:1: ruleBlsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBlsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2728:2: ( ( ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2729:2: ( ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2729:2: ( ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2730:3: ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2730:3: ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) )
            // InternalAssembler.g:2731:4: ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) )
            {
            // InternalAssembler.g:2731:4: ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) )
            // InternalAssembler.g:2732:5: (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' )
            {
            // InternalAssembler.g:2732:5: (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==53) ) {
                alt33=1;
            }
            else if ( (LA33_0==54) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalAssembler.g:2733:6: lv_instruction_0_1= 'BLS'
                    {
                    lv_instruction_0_1=(Token)match(input,53,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBlsInstructionAccess().getInstructionBLSKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBlsInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2744:6: lv_instruction_0_2= 'LBLS'
                    {
                    lv_instruction_0_2=(Token)match(input,54,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBlsInstructionAccess().getInstructionLBLSKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBlsInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBlsInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2761:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2762:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2762:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2763:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBlsInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBlsInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlsInstruction"


    // $ANTLR start "entryRuleBloInstruction"
    // InternalAssembler.g:2784:1: entryRuleBloInstruction returns [EObject current=null] : iv_ruleBloInstruction= ruleBloInstruction EOF ;
    public final EObject entryRuleBloInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBloInstruction = null;


        try {
            // InternalAssembler.g:2784:55: (iv_ruleBloInstruction= ruleBloInstruction EOF )
            // InternalAssembler.g:2785:2: iv_ruleBloInstruction= ruleBloInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBloInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBloInstruction=ruleBloInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBloInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBloInstruction"


    // $ANTLR start "ruleBloInstruction"
    // InternalAssembler.g:2791:1: ruleBloInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBloInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2797:2: ( ( ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2798:2: ( ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2798:2: ( ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2799:3: ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2799:3: ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) )
            // InternalAssembler.g:2800:4: ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) )
            {
            // InternalAssembler.g:2800:4: ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) )
            // InternalAssembler.g:2801:5: (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' )
            {
            // InternalAssembler.g:2801:5: (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==55) ) {
                alt34=1;
            }
            else if ( (LA34_0==56) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalAssembler.g:2802:6: lv_instruction_0_1= 'BLO'
                    {
                    lv_instruction_0_1=(Token)match(input,55,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBloInstructionAccess().getInstructionBLOKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBloInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2813:6: lv_instruction_0_2= 'LBLO'
                    {
                    lv_instruction_0_2=(Token)match(input,56,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBloInstructionAccess().getInstructionLBLOKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBloInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBloInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2830:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2831:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2831:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2832:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBloInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBloInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBloInstruction"


    // $ANTLR start "entryRuleBleInstruction"
    // InternalAssembler.g:2853:1: entryRuleBleInstruction returns [EObject current=null] : iv_ruleBleInstruction= ruleBleInstruction EOF ;
    public final EObject entryRuleBleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBleInstruction = null;


        try {
            // InternalAssembler.g:2853:55: (iv_ruleBleInstruction= ruleBleInstruction EOF )
            // InternalAssembler.g:2854:2: iv_ruleBleInstruction= ruleBleInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBleInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBleInstruction=ruleBleInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBleInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBleInstruction"


    // $ANTLR start "ruleBleInstruction"
    // InternalAssembler.g:2860:1: ruleBleInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2866:2: ( ( ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2867:2: ( ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2867:2: ( ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2868:3: ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2868:3: ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) )
            // InternalAssembler.g:2869:4: ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) )
            {
            // InternalAssembler.g:2869:4: ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) )
            // InternalAssembler.g:2870:5: (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' )
            {
            // InternalAssembler.g:2870:5: (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==57) ) {
                alt35=1;
            }
            else if ( (LA35_0==58) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalAssembler.g:2871:6: lv_instruction_0_1= 'BLE'
                    {
                    lv_instruction_0_1=(Token)match(input,57,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBleInstructionAccess().getInstructionBLEKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBleInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2882:6: lv_instruction_0_2= 'LBLE'
                    {
                    lv_instruction_0_2=(Token)match(input,58,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBleInstructionAccess().getInstructionLBLEKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBleInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBleInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2899:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2900:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2900:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2901:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBleInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBleInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBleInstruction"


    // $ANTLR start "entryRuleBitInstruction"
    // InternalAssembler.g:2922:1: entryRuleBitInstruction returns [EObject current=null] : iv_ruleBitInstruction= ruleBitInstruction EOF ;
    public final EObject entryRuleBitInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitInstruction = null;


        try {
            // InternalAssembler.g:2922:55: (iv_ruleBitInstruction= ruleBitInstruction EOF )
            // InternalAssembler.g:2923:2: iv_ruleBitInstruction= ruleBitInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitInstruction=ruleBitInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitInstruction"


    // $ANTLR start "ruleBitInstruction"
    // InternalAssembler.g:2929:1: ruleBitInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) ) ) ;
    public final EObject ruleBitInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_1 = null;

        EObject lv_operand_2_2 = null;

        EObject lv_operand_2_3 = null;

        EObject lv_operand_2_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2935:2: ( ( ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:2936:2: ( ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:2936:2: ( ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:2937:3: ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:2937:3: ( (lv_instruction_0_0= 'BIT' ) )
            // InternalAssembler.g:2938:4: (lv_instruction_0_0= 'BIT' )
            {
            // InternalAssembler.g:2938:4: (lv_instruction_0_0= 'BIT' )
            // InternalAssembler.g:2939:5: lv_instruction_0_0= 'BIT'
            {
            lv_instruction_0_0=(Token)match(input,59,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_instruction_0_0, grammarAccess.getBitInstructionAccess().getInstructionBITKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBitInstructionRule());
              					}
              					setWithLastConsumed(current, "instruction", lv_instruction_0_0, "BIT");
              				
            }

            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBitInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2955:3: ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:2956:4: ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:2956:4: ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:2957:5: (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:2957:5: (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand )
            int alt36=4;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalAssembler.g:2958:6: lv_operand_2_1= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitInstructionAccess().getOperandDirectOperandParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_1=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBitInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_1,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2974:6: lv_operand_2_2= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitInstructionAccess().getOperandIndexedOperandParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_2=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBitInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_2,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:2990:6: lv_operand_2_3= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitInstructionAccess().getOperandExtendedOperandParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_3=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBitInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_3,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:3006:6: lv_operand_2_4= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBitInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_4=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBitInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_4,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitInstruction"


    // $ANTLR start "entryRuleBhsInstruction"
    // InternalAssembler.g:3028:1: entryRuleBhsInstruction returns [EObject current=null] : iv_ruleBhsInstruction= ruleBhsInstruction EOF ;
    public final EObject entryRuleBhsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBhsInstruction = null;


        try {
            // InternalAssembler.g:3028:55: (iv_ruleBhsInstruction= ruleBhsInstruction EOF )
            // InternalAssembler.g:3029:2: iv_ruleBhsInstruction= ruleBhsInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBhsInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBhsInstruction=ruleBhsInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBhsInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBhsInstruction"


    // $ANTLR start "ruleBhsInstruction"
    // InternalAssembler.g:3035:1: ruleBhsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBhsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3041:2: ( ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:3042:2: ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:3042:2: ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:3043:3: ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:3043:3: ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) )
            // InternalAssembler.g:3044:4: ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) )
            {
            // InternalAssembler.g:3044:4: ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) )
            // InternalAssembler.g:3045:5: (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' )
            {
            // InternalAssembler.g:3045:5: (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==60) ) {
                alt37=1;
            }
            else if ( (LA37_0==61) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalAssembler.g:3046:6: lv_instruction_0_1= 'BHS'
                    {
                    lv_instruction_0_1=(Token)match(input,60,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBhsInstructionAccess().getInstructionBHSKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBhsInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3057:6: lv_instruction_0_2= 'LBHS'
                    {
                    lv_instruction_0_2=(Token)match(input,61,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBhsInstructionAccess().getInstructionLBHSKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBhsInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBhsInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3074:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:3075:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:3075:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:3076:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBhsInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBhsInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBhsInstruction"


    // $ANTLR start "entryRuleBhiInstruction"
    // InternalAssembler.g:3097:1: entryRuleBhiInstruction returns [EObject current=null] : iv_ruleBhiInstruction= ruleBhiInstruction EOF ;
    public final EObject entryRuleBhiInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBhiInstruction = null;


        try {
            // InternalAssembler.g:3097:55: (iv_ruleBhiInstruction= ruleBhiInstruction EOF )
            // InternalAssembler.g:3098:2: iv_ruleBhiInstruction= ruleBhiInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBhiInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBhiInstruction=ruleBhiInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBhiInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBhiInstruction"


    // $ANTLR start "ruleBhiInstruction"
    // InternalAssembler.g:3104:1: ruleBhiInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBhiInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3110:2: ( ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:3111:2: ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:3111:2: ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:3112:3: ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:3112:3: ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) )
            // InternalAssembler.g:3113:4: ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) )
            {
            // InternalAssembler.g:3113:4: ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) )
            // InternalAssembler.g:3114:5: (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' )
            {
            // InternalAssembler.g:3114:5: (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==62) ) {
                alt38=1;
            }
            else if ( (LA38_0==63) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalAssembler.g:3115:6: lv_instruction_0_1= 'BHI'
                    {
                    lv_instruction_0_1=(Token)match(input,62,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBhiInstructionAccess().getInstructionBHIKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBhiInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3126:6: lv_instruction_0_2= 'LBHI'
                    {
                    lv_instruction_0_2=(Token)match(input,63,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBhiInstructionAccess().getInstructionLBHIKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBhiInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBhiInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3143:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:3144:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:3144:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:3145:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBhiInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBhiInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBhiInstruction"


    // $ANTLR start "entryRuleBgtInstruction"
    // InternalAssembler.g:3166:1: entryRuleBgtInstruction returns [EObject current=null] : iv_ruleBgtInstruction= ruleBgtInstruction EOF ;
    public final EObject entryRuleBgtInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBgtInstruction = null;


        try {
            // InternalAssembler.g:3166:55: (iv_ruleBgtInstruction= ruleBgtInstruction EOF )
            // InternalAssembler.g:3167:2: iv_ruleBgtInstruction= ruleBgtInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBgtInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBgtInstruction=ruleBgtInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBgtInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBgtInstruction"


    // $ANTLR start "ruleBgtInstruction"
    // InternalAssembler.g:3173:1: ruleBgtInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBgtInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3179:2: ( ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:3180:2: ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:3180:2: ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:3181:3: ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:3181:3: ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) )
            // InternalAssembler.g:3182:4: ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) )
            {
            // InternalAssembler.g:3182:4: ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) )
            // InternalAssembler.g:3183:5: (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' )
            {
            // InternalAssembler.g:3183:5: (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==64) ) {
                alt39=1;
            }
            else if ( (LA39_0==65) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalAssembler.g:3184:6: lv_instruction_0_1= 'BGT'
                    {
                    lv_instruction_0_1=(Token)match(input,64,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBgtInstructionAccess().getInstructionBGTKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBgtInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3195:6: lv_instruction_0_2= 'LBGT'
                    {
                    lv_instruction_0_2=(Token)match(input,65,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBgtInstructionAccess().getInstructionLBGTKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBgtInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBgtInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3212:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:3213:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:3213:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:3214:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBgtInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBgtInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBgtInstruction"


    // $ANTLR start "entryRuleBgeInstruction"
    // InternalAssembler.g:3235:1: entryRuleBgeInstruction returns [EObject current=null] : iv_ruleBgeInstruction= ruleBgeInstruction EOF ;
    public final EObject entryRuleBgeInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBgeInstruction = null;


        try {
            // InternalAssembler.g:3235:55: (iv_ruleBgeInstruction= ruleBgeInstruction EOF )
            // InternalAssembler.g:3236:2: iv_ruleBgeInstruction= ruleBgeInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBgeInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBgeInstruction=ruleBgeInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBgeInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBgeInstruction"


    // $ANTLR start "ruleBgeInstruction"
    // InternalAssembler.g:3242:1: ruleBgeInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBgeInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3248:2: ( ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:3249:2: ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:3249:2: ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:3250:3: ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:3250:3: ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) )
            // InternalAssembler.g:3251:4: ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) )
            {
            // InternalAssembler.g:3251:4: ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) )
            // InternalAssembler.g:3252:5: (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' )
            {
            // InternalAssembler.g:3252:5: (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==66) ) {
                alt40=1;
            }
            else if ( (LA40_0==67) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalAssembler.g:3253:6: lv_instruction_0_1= 'BGE'
                    {
                    lv_instruction_0_1=(Token)match(input,66,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBgeInstructionAccess().getInstructionBGEKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBgeInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3264:6: lv_instruction_0_2= 'LBGE'
                    {
                    lv_instruction_0_2=(Token)match(input,67,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBgeInstructionAccess().getInstructionLBGEKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBgeInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBgeInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3281:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:3282:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:3282:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:3283:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBgeInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBgeInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBgeInstruction"


    // $ANTLR start "entryRuleBeqInstruction"
    // InternalAssembler.g:3304:1: entryRuleBeqInstruction returns [EObject current=null] : iv_ruleBeqInstruction= ruleBeqInstruction EOF ;
    public final EObject entryRuleBeqInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeqInstruction = null;


        try {
            // InternalAssembler.g:3304:55: (iv_ruleBeqInstruction= ruleBeqInstruction EOF )
            // InternalAssembler.g:3305:2: iv_ruleBeqInstruction= ruleBeqInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBeqInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBeqInstruction=ruleBeqInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBeqInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBeqInstruction"


    // $ANTLR start "ruleBeqInstruction"
    // InternalAssembler.g:3311:1: ruleBeqInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBeqInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3317:2: ( ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:3318:2: ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:3318:2: ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:3319:3: ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:3319:3: ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) )
            // InternalAssembler.g:3320:4: ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) )
            {
            // InternalAssembler.g:3320:4: ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) )
            // InternalAssembler.g:3321:5: (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' )
            {
            // InternalAssembler.g:3321:5: (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==68) ) {
                alt41=1;
            }
            else if ( (LA41_0==69) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalAssembler.g:3322:6: lv_instruction_0_1= 'BEQ'
                    {
                    lv_instruction_0_1=(Token)match(input,68,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBeqInstructionAccess().getInstructionBEQKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBeqInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3333:6: lv_instruction_0_2= 'LBEQ'
                    {
                    lv_instruction_0_2=(Token)match(input,69,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBeqInstructionAccess().getInstructionLBEQKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBeqInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBeqInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3350:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:3351:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:3351:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:3352:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBeqInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBeqInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBeqInstruction"


    // $ANTLR start "entryRuleBcsInstruction"
    // InternalAssembler.g:3373:1: entryRuleBcsInstruction returns [EObject current=null] : iv_ruleBcsInstruction= ruleBcsInstruction EOF ;
    public final EObject entryRuleBcsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBcsInstruction = null;


        try {
            // InternalAssembler.g:3373:55: (iv_ruleBcsInstruction= ruleBcsInstruction EOF )
            // InternalAssembler.g:3374:2: iv_ruleBcsInstruction= ruleBcsInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBcsInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBcsInstruction=ruleBcsInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBcsInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBcsInstruction"


    // $ANTLR start "ruleBcsInstruction"
    // InternalAssembler.g:3380:1: ruleBcsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBcsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3386:2: ( ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:3387:2: ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:3387:2: ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:3388:3: ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:3388:3: ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) )
            // InternalAssembler.g:3389:4: ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) )
            {
            // InternalAssembler.g:3389:4: ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) )
            // InternalAssembler.g:3390:5: (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' )
            {
            // InternalAssembler.g:3390:5: (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==70) ) {
                alt42=1;
            }
            else if ( (LA42_0==71) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalAssembler.g:3391:6: lv_instruction_0_1= 'BCS'
                    {
                    lv_instruction_0_1=(Token)match(input,70,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBcsInstructionAccess().getInstructionBCSKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBcsInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3402:6: lv_instruction_0_2= 'LBCS'
                    {
                    lv_instruction_0_2=(Token)match(input,71,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBcsInstructionAccess().getInstructionLBCSKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBcsInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBcsInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3419:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:3420:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:3420:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:3421:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBcsInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBcsInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBcsInstruction"


    // $ANTLR start "entryRuleBccInstruction"
    // InternalAssembler.g:3442:1: entryRuleBccInstruction returns [EObject current=null] : iv_ruleBccInstruction= ruleBccInstruction EOF ;
    public final EObject entryRuleBccInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBccInstruction = null;


        try {
            // InternalAssembler.g:3442:55: (iv_ruleBccInstruction= ruleBccInstruction EOF )
            // InternalAssembler.g:3443:2: iv_ruleBccInstruction= ruleBccInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBccInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBccInstruction=ruleBccInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBccInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBccInstruction"


    // $ANTLR start "ruleBccInstruction"
    // InternalAssembler.g:3449:1: ruleBccInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBccInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3455:2: ( ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:3456:2: ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:3456:2: ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:3457:3: ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:3457:3: ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) )
            // InternalAssembler.g:3458:4: ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) )
            {
            // InternalAssembler.g:3458:4: ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) )
            // InternalAssembler.g:3459:5: (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' )
            {
            // InternalAssembler.g:3459:5: (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==72) ) {
                alt43=1;
            }
            else if ( (LA43_0==73) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalAssembler.g:3460:6: lv_instruction_0_1= 'BCC'
                    {
                    lv_instruction_0_1=(Token)match(input,72,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getBccInstructionAccess().getInstructionBCCKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBccInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3471:6: lv_instruction_0_2= 'LBCC'
                    {
                    lv_instruction_0_2=(Token)match(input,73,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getBccInstructionAccess().getInstructionLBCCKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBccInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBccInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3488:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:3489:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:3489:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:3490:5: lv_operand_2_0= ruleRelativeMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBccInstructionAccess().getOperandRelativeModeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBccInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.RelativeMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBccInstruction"


    // $ANTLR start "entryRuleAsrInstruction"
    // InternalAssembler.g:3511:1: entryRuleAsrInstruction returns [EObject current=null] : iv_ruleAsrInstruction= ruleAsrInstruction EOF ;
    public final EObject entryRuleAsrInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsrInstruction = null;


        try {
            // InternalAssembler.g:3511:55: (iv_ruleAsrInstruction= ruleAsrInstruction EOF )
            // InternalAssembler.g:3512:2: iv_ruleAsrInstruction= ruleAsrInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAsrInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAsrInstruction=ruleAsrInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAsrInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAsrInstruction"


    // $ANTLR start "ruleAsrInstruction"
    // InternalAssembler.g:3518:1: ruleAsrInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
    public final EObject ruleAsrInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token lv_instruction_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_1 = null;

        EObject lv_operand_3_2 = null;

        EObject lv_operand_3_3 = null;

        EObject lv_operand_3_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3524:2: ( ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:3525:2: ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:3525:2: ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=74 && LA46_0<=75)) ) {
                alt46=1;
            }
            else if ( (LA46_0==76) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalAssembler.g:3526:3: ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) )
                    {
                    // InternalAssembler.g:3526:3: ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) )
                    // InternalAssembler.g:3527:4: ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) )
                    {
                    // InternalAssembler.g:3527:4: ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) )
                    // InternalAssembler.g:3528:5: (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' )
                    {
                    // InternalAssembler.g:3528:5: (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==74) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==75) ) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalAssembler.g:3529:6: lv_instruction_0_1= 'ASRA'
                            {
                            lv_instruction_0_1=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_1, grammarAccess.getAsrInstructionAccess().getInstructionASRAKeyword_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getAsrInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:3540:6: lv_instruction_0_2= 'ASRB'
                            {
                            lv_instruction_0_2=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_2, grammarAccess.getAsrInstructionAccess().getInstructionASRBKeyword_0_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getAsrInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3554:3: ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:3554:3: ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:3555:4: ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:3555:4: ( (lv_instruction_1_0= 'ASR' ) )
                    // InternalAssembler.g:3556:5: (lv_instruction_1_0= 'ASR' )
                    {
                    // InternalAssembler.g:3556:5: (lv_instruction_1_0= 'ASR' )
                    // InternalAssembler.g:3557:6: lv_instruction_1_0= 'ASR'
                    {
                    lv_instruction_1_0=(Token)match(input,76,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_1_0, grammarAccess.getAsrInstructionAccess().getInstructionASRKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAsrInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_1_0, "ASR");
                      					
                    }

                    }


                    }

                    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_2, grammarAccess.getAsrInstructionAccess().getWSTerminalRuleCall_1_1());
                      			
                    }
                    // InternalAssembler.g:3573:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:3574:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:3574:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:3575:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:3575:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt45=4;
                    alt45 = dfa45.predict(input);
                    switch (alt45) {
                        case 1 :
                            // InternalAssembler.g:3576:7: lv_operand_3_1= ruleDirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAsrInstructionAccess().getOperandDirectOperandParserRuleCall_1_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_1=ruleDirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_1,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:3592:7: lv_operand_3_2= ruleIndexedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAsrInstructionAccess().getOperandIndexedOperandParserRuleCall_1_2_0_1());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_2=ruleIndexedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_2,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:3608:7: lv_operand_3_3= ruleExtendedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAsrInstructionAccess().getOperandExtendedOperandParserRuleCall_1_2_0_2());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_3=ruleExtendedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_3,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:3624:7: lv_operand_3_4= ruleExtendedIndirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAsrInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_1_2_0_3());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_4=ruleExtendedIndirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_4,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAsrInstruction"


    // $ANTLR start "entryRuleAslInstruction"
    // InternalAssembler.g:3647:1: entryRuleAslInstruction returns [EObject current=null] : iv_ruleAslInstruction= ruleAslInstruction EOF ;
    public final EObject entryRuleAslInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAslInstruction = null;


        try {
            // InternalAssembler.g:3647:55: (iv_ruleAslInstruction= ruleAslInstruction EOF )
            // InternalAssembler.g:3648:2: iv_ruleAslInstruction= ruleAslInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAslInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAslInstruction=ruleAslInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAslInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAslInstruction"


    // $ANTLR start "ruleAslInstruction"
    // InternalAssembler.g:3654:1: ruleAslInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
    public final EObject ruleAslInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token lv_instruction_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_1 = null;

        EObject lv_operand_3_2 = null;

        EObject lv_operand_3_3 = null;

        EObject lv_operand_3_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3660:2: ( ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:3661:2: ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:3661:2: ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=77 && LA49_0<=78)) ) {
                alt49=1;
            }
            else if ( (LA49_0==79) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalAssembler.g:3662:3: ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) )
                    {
                    // InternalAssembler.g:3662:3: ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) )
                    // InternalAssembler.g:3663:4: ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) )
                    {
                    // InternalAssembler.g:3663:4: ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) )
                    // InternalAssembler.g:3664:5: (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' )
                    {
                    // InternalAssembler.g:3664:5: (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==77) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==78) ) {
                        alt47=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalAssembler.g:3665:6: lv_instruction_0_1= 'ASLA'
                            {
                            lv_instruction_0_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_1, grammarAccess.getAslInstructionAccess().getInstructionASLAKeyword_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getAslInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:3676:6: lv_instruction_0_2= 'ASLB'
                            {
                            lv_instruction_0_2=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_instruction_0_2, grammarAccess.getAslInstructionAccess().getInstructionASLBKeyword_0_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getAslInstructionRule());
                              						}
                              						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3690:3: ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:3690:3: ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:3691:4: ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:3691:4: ( (lv_instruction_1_0= 'ASL' ) )
                    // InternalAssembler.g:3692:5: (lv_instruction_1_0= 'ASL' )
                    {
                    // InternalAssembler.g:3692:5: (lv_instruction_1_0= 'ASL' )
                    // InternalAssembler.g:3693:6: lv_instruction_1_0= 'ASL'
                    {
                    lv_instruction_1_0=(Token)match(input,79,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_1_0, grammarAccess.getAslInstructionAccess().getInstructionASLKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAslInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_1_0, "ASL");
                      					
                    }

                    }


                    }

                    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_2, grammarAccess.getAslInstructionAccess().getWSTerminalRuleCall_1_1());
                      			
                    }
                    // InternalAssembler.g:3709:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:3710:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:3710:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:3711:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:3711:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt48=4;
                    alt48 = dfa48.predict(input);
                    switch (alt48) {
                        case 1 :
                            // InternalAssembler.g:3712:7: lv_operand_3_1= ruleDirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAslInstructionAccess().getOperandDirectOperandParserRuleCall_1_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_1=ruleDirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAslInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_1,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:3728:7: lv_operand_3_2= ruleIndexedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAslInstructionAccess().getOperandIndexedOperandParserRuleCall_1_2_0_1());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_2=ruleIndexedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAslInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_2,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:3744:7: lv_operand_3_3= ruleExtendedOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAslInstructionAccess().getOperandExtendedOperandParserRuleCall_1_2_0_2());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_3=ruleExtendedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAslInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_3,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:3760:7: lv_operand_3_4= ruleExtendedIndirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAslInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_1_2_0_3());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_4=ruleExtendedIndirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAslInstructionRule());
                              							}
                              							set(
                              								current,
                              								"operand",
                              								lv_operand_3_4,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAslInstruction"


    // $ANTLR start "entryRuleAndCCInstruction"
    // InternalAssembler.g:3783:1: entryRuleAndCCInstruction returns [EObject current=null] : iv_ruleAndCCInstruction= ruleAndCCInstruction EOF ;
    public final EObject entryRuleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndCCInstruction = null;


        try {
            // InternalAssembler.g:3783:57: (iv_ruleAndCCInstruction= ruleAndCCInstruction EOF )
            // InternalAssembler.g:3784:2: iv_ruleAndCCInstruction= ruleAndCCInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndCCInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndCCInstruction=ruleAndCCInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndCCInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndCCInstruction"


    // $ANTLR start "ruleAndCCInstruction"
    // InternalAssembler.g:3790:1: ruleAndCCInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) ;
    public final EObject ruleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3796:2: ( ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) )
            // InternalAssembler.g:3797:2: ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            {
            // InternalAssembler.g:3797:2: ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            // InternalAssembler.g:3798:3: ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) )
            {
            // InternalAssembler.g:3798:3: ( (lv_instruction_0_0= 'ANDCC' ) )
            // InternalAssembler.g:3799:4: (lv_instruction_0_0= 'ANDCC' )
            {
            // InternalAssembler.g:3799:4: (lv_instruction_0_0= 'ANDCC' )
            // InternalAssembler.g:3800:5: lv_instruction_0_0= 'ANDCC'
            {
            lv_instruction_0_0=(Token)match(input,80,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_instruction_0_0, grammarAccess.getAndCCInstructionAccess().getInstructionANDCCKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAndCCInstructionRule());
              					}
              					setWithLastConsumed(current, "instruction", lv_instruction_0_0, "ANDCC");
              				
            }

            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAndCCInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3816:3: ( (lv_operand_2_0= ruleImmediatOperand ) )
            // InternalAssembler.g:3817:4: (lv_operand_2_0= ruleImmediatOperand )
            {
            // InternalAssembler.g:3817:4: (lv_operand_2_0= ruleImmediatOperand )
            // InternalAssembler.g:3818:5: lv_operand_2_0= ruleImmediatOperand
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndCCInstructionAccess().getOperandImmediatOperandParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleImmediatOperand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAndCCInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndCCInstruction"


    // $ANTLR start "entryRuleAndInstruction"
    // InternalAssembler.g:3839:1: entryRuleAndInstruction returns [EObject current=null] : iv_ruleAndInstruction= ruleAndInstruction EOF ;
    public final EObject entryRuleAndInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndInstruction = null;


        try {
            // InternalAssembler.g:3839:55: (iv_ruleAndInstruction= ruleAndInstruction EOF )
            // InternalAssembler.g:3840:2: iv_ruleAndInstruction= ruleAndInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndInstruction=ruleAndInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndInstruction"


    // $ANTLR start "ruleAndInstruction"
    // InternalAssembler.g:3846:1: ruleAndInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
    public final EObject ruleAndInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_1 = null;

        EObject lv_operand_2_2 = null;

        EObject lv_operand_2_3 = null;

        EObject lv_operand_2_4 = null;

        EObject lv_operand_2_5 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3852:2: ( ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:3853:2: ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:3853:2: ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:3854:3: ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:3854:3: ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) )
            // InternalAssembler.g:3855:4: ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) )
            {
            // InternalAssembler.g:3855:4: ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) )
            // InternalAssembler.g:3856:5: (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' )
            {
            // InternalAssembler.g:3856:5: (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==81) ) {
                alt50=1;
            }
            else if ( (LA50_0==82) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalAssembler.g:3857:6: lv_instruction_0_1= 'ANDA'
                    {
                    lv_instruction_0_1=(Token)match(input,81,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getAndInstructionAccess().getInstructionANDAKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAndInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3868:6: lv_instruction_0_2= 'ANDB'
                    {
                    lv_instruction_0_2=(Token)match(input,82,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getAndInstructionAccess().getInstructionANDBKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAndInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAndInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3885:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:3886:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:3886:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:3887:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:3887:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt51=5;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalAssembler.g:3888:6: lv_operand_2_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandImmediatOperandParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_1,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3904:6: lv_operand_2_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandDirectOperandParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_2,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:3920:6: lv_operand_2_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandIndexedOperandParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_3,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:3936:6: lv_operand_2_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandExtendedOperandParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_4,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalAssembler.g:3952:6: lv_operand_2_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_0_4());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_5,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndInstruction"


    // $ANTLR start "entryRuleAdddInstruction"
    // InternalAssembler.g:3974:1: entryRuleAdddInstruction returns [EObject current=null] : iv_ruleAdddInstruction= ruleAdddInstruction EOF ;
    public final EObject entryRuleAdddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdddInstruction = null;


        try {
            // InternalAssembler.g:3974:56: (iv_ruleAdddInstruction= ruleAdddInstruction EOF )
            // InternalAssembler.g:3975:2: iv_ruleAdddInstruction= ruleAdddInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdddInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdddInstruction=ruleAdddInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdddInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdddInstruction"


    // $ANTLR start "ruleAdddInstruction"
    // InternalAssembler.g:3981:1: ruleAdddInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
    public final EObject ruleAdddInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_1 = null;

        EObject lv_operand_2_2 = null;

        EObject lv_operand_2_3 = null;

        EObject lv_operand_2_4 = null;

        EObject lv_operand_2_5 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3987:2: ( ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:3988:2: ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:3988:2: ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:3989:3: ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:3989:3: ( (lv_instruction_0_0= 'ADDD' ) )
            // InternalAssembler.g:3990:4: (lv_instruction_0_0= 'ADDD' )
            {
            // InternalAssembler.g:3990:4: (lv_instruction_0_0= 'ADDD' )
            // InternalAssembler.g:3991:5: lv_instruction_0_0= 'ADDD'
            {
            lv_instruction_0_0=(Token)match(input,83,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_instruction_0_0, grammarAccess.getAdddInstructionAccess().getInstructionADDDKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAdddInstructionRule());
              					}
              					setWithLastConsumed(current, "instruction", lv_instruction_0_0, "ADDD");
              				
            }

            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAdddInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4007:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:4008:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:4008:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:4009:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:4009:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt52=5;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalAssembler.g:4010:6: lv_operand_2_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandImmediatOperandParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_1,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4026:6: lv_operand_2_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandDirectOperandParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_2,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:4042:6: lv_operand_2_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandIndexedOperandParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_3,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:4058:6: lv_operand_2_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandExtendedOperandParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_4,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalAssembler.g:4074:6: lv_operand_2_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_0_4());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_5,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdddInstruction"


    // $ANTLR start "entryRuleAddInstruction"
    // InternalAssembler.g:4096:1: entryRuleAddInstruction returns [EObject current=null] : iv_ruleAddInstruction= ruleAddInstruction EOF ;
    public final EObject entryRuleAddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddInstruction = null;


        try {
            // InternalAssembler.g:4096:55: (iv_ruleAddInstruction= ruleAddInstruction EOF )
            // InternalAssembler.g:4097:2: iv_ruleAddInstruction= ruleAddInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddInstruction=ruleAddInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddInstruction"


    // $ANTLR start "ruleAddInstruction"
    // InternalAssembler.g:4103:1: ruleAddInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
    public final EObject ruleAddInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_1 = null;

        EObject lv_operand_2_2 = null;

        EObject lv_operand_2_3 = null;

        EObject lv_operand_2_4 = null;

        EObject lv_operand_2_5 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4109:2: ( ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:4110:2: ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:4110:2: ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:4111:3: ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:4111:3: ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) )
            // InternalAssembler.g:4112:4: ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) )
            {
            // InternalAssembler.g:4112:4: ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) )
            // InternalAssembler.g:4113:5: (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' )
            {
            // InternalAssembler.g:4113:5: (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==84) ) {
                alt53=1;
            }
            else if ( (LA53_0==85) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalAssembler.g:4114:6: lv_instruction_0_1= 'ADDA'
                    {
                    lv_instruction_0_1=(Token)match(input,84,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getAddInstructionAccess().getInstructionADDAKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4125:6: lv_instruction_0_2= 'ADDB'
                    {
                    lv_instruction_0_2=(Token)match(input,85,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getAddInstructionAccess().getInstructionADDBKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAddInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4142:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:4143:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:4143:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:4144:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:4144:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt54=5;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // InternalAssembler.g:4145:6: lv_operand_2_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandImmediatOperandParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_1,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4161:6: lv_operand_2_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandDirectOperandParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_2,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:4177:6: lv_operand_2_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandIndexedOperandParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_3,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:4193:6: lv_operand_2_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandExtendedOperandParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_4,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalAssembler.g:4209:6: lv_operand_2_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_0_4());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_5,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddInstruction"


    // $ANTLR start "entryRuleAdcInstruction"
    // InternalAssembler.g:4231:1: entryRuleAdcInstruction returns [EObject current=null] : iv_ruleAdcInstruction= ruleAdcInstruction EOF ;
    public final EObject entryRuleAdcInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdcInstruction = null;


        try {
            // InternalAssembler.g:4231:55: (iv_ruleAdcInstruction= ruleAdcInstruction EOF )
            // InternalAssembler.g:4232:2: iv_ruleAdcInstruction= ruleAdcInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdcInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdcInstruction=ruleAdcInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdcInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdcInstruction"


    // $ANTLR start "ruleAdcInstruction"
    // InternalAssembler.g:4238:1: ruleAdcInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
    public final EObject ruleAdcInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_1 = null;

        EObject lv_operand_2_2 = null;

        EObject lv_operand_2_3 = null;

        EObject lv_operand_2_4 = null;

        EObject lv_operand_2_5 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4244:2: ( ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:4245:2: ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:4245:2: ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:4246:3: ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:4246:3: ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) )
            // InternalAssembler.g:4247:4: ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) )
            {
            // InternalAssembler.g:4247:4: ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) )
            // InternalAssembler.g:4248:5: (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' )
            {
            // InternalAssembler.g:4248:5: (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==86) ) {
                alt55=1;
            }
            else if ( (LA55_0==87) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalAssembler.g:4249:6: lv_instruction_0_1= 'ADCA'
                    {
                    lv_instruction_0_1=(Token)match(input,86,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_1, grammarAccess.getAdcInstructionAccess().getInstructionADCAKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAdcInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4260:6: lv_instruction_0_2= 'ADCB'
                    {
                    lv_instruction_0_2=(Token)match(input,87,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_0_2, grammarAccess.getAdcInstructionAccess().getInstructionADCBKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAdcInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4277:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:4278:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:4278:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:4279:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:4279:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt56=5;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // InternalAssembler.g:4280:6: lv_operand_2_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandImmediatOperandParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_1,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4296:6: lv_operand_2_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandDirectOperandParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_2,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:4312:6: lv_operand_2_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandIndexedOperandParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_3,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:4328:6: lv_operand_2_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandExtendedOperandParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_4,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalAssembler.g:4344:6: lv_operand_2_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_0_4());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_5,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdcInstruction"


    // $ANTLR start "entryRuleAbxInstruction"
    // InternalAssembler.g:4366:1: entryRuleAbxInstruction returns [EObject current=null] : iv_ruleAbxInstruction= ruleAbxInstruction EOF ;
    public final EObject entryRuleAbxInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbxInstruction = null;


        try {
            // InternalAssembler.g:4366:55: (iv_ruleAbxInstruction= ruleAbxInstruction EOF )
            // InternalAssembler.g:4367:2: iv_ruleAbxInstruction= ruleAbxInstruction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbxInstructionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAbxInstruction=ruleAbxInstruction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbxInstruction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbxInstruction"


    // $ANTLR start "ruleAbxInstruction"
    // InternalAssembler.g:4373:1: ruleAbxInstruction returns [EObject current=null] : ( (lv_instruction_0_0= 'ABX' ) ) ;
    public final EObject ruleAbxInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:4379:2: ( ( (lv_instruction_0_0= 'ABX' ) ) )
            // InternalAssembler.g:4380:2: ( (lv_instruction_0_0= 'ABX' ) )
            {
            // InternalAssembler.g:4380:2: ( (lv_instruction_0_0= 'ABX' ) )
            // InternalAssembler.g:4381:3: (lv_instruction_0_0= 'ABX' )
            {
            // InternalAssembler.g:4381:3: (lv_instruction_0_0= 'ABX' )
            // InternalAssembler.g:4382:4: lv_instruction_0_0= 'ABX'
            {
            lv_instruction_0_0=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_instruction_0_0, grammarAccess.getAbxInstructionAccess().getInstructionABXKeyword_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getAbxInstructionRule());
              				}
              				setWithLastConsumed(current, "instruction", lv_instruction_0_0, "ABX");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbxInstruction"


    // $ANTLR start "entryRuleExtendedIndirectOperand"
    // InternalAssembler.g:4397:1: entryRuleExtendedIndirectOperand returns [EObject current=null] : iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF ;
    public final EObject entryRuleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedIndirectOperand = null;


        try {
            // InternalAssembler.g:4397:64: (iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF )
            // InternalAssembler.g:4398:2: iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtendedIndirectOperandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtendedIndirectOperand=ruleExtendedIndirectOperand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtendedIndirectOperand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtendedIndirectOperand"


    // $ANTLR start "ruleExtendedIndirectOperand"
    // InternalAssembler.g:4404:1: ruleExtendedIndirectOperand returns [EObject current=null] : (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4410:2: ( (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalAssembler.g:4411:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalAssembler.g:4411:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalAssembler.g:4412:3: otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtendedIndirectOperandAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:4416:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:4417:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:4417:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:4418:5: lv_operand_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtendedIndirectOperandAccess().getOperandExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_operand_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtendedIndirectOperandRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_1_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getExtendedIndirectOperandAccess().getRightSquareBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtendedIndirectOperand"


    // $ANTLR start "entryRuleExtendedOperand"
    // InternalAssembler.g:4443:1: entryRuleExtendedOperand returns [EObject current=null] : iv_ruleExtendedOperand= ruleExtendedOperand EOF ;
    public final EObject entryRuleExtendedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedOperand = null;


        try {
            // InternalAssembler.g:4443:56: (iv_ruleExtendedOperand= ruleExtendedOperand EOF )
            // InternalAssembler.g:4444:2: iv_ruleExtendedOperand= ruleExtendedOperand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtendedOperandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtendedOperand=ruleExtendedOperand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtendedOperand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtendedOperand"


    // $ANTLR start "ruleExtendedOperand"
    // InternalAssembler.g:4450:1: ruleExtendedOperand returns [EObject current=null] : ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExtendedOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4456:2: ( ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:4457:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:4457:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:4458:3: (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) )
            {
            // InternalAssembler.g:4458:3: (otherlv_0= '>' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==91) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAssembler.g:4459:4: otherlv_0= '>'
                    {
                    otherlv_0=(Token)match(input,91,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getExtendedOperandAccess().getGreaterThanSignKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:4464:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:4465:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:4465:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:4466:5: lv_operand_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtendedOperandAccess().getOperandExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtendedOperandRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_1_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtendedOperand"


    // $ANTLR start "entryRuleDirectOperand"
    // InternalAssembler.g:4487:1: entryRuleDirectOperand returns [EObject current=null] : iv_ruleDirectOperand= ruleDirectOperand EOF ;
    public final EObject entryRuleDirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectOperand = null;


        try {
            // InternalAssembler.g:4487:54: (iv_ruleDirectOperand= ruleDirectOperand EOF )
            // InternalAssembler.g:4488:2: iv_ruleDirectOperand= ruleDirectOperand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectOperandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDirectOperand=ruleDirectOperand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectOperand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDirectOperand"


    // $ANTLR start "ruleDirectOperand"
    // InternalAssembler.g:4494:1: ruleDirectOperand returns [EObject current=null] : (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleDirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4500:2: ( (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:4501:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:4501:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:4502:3: otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectOperandAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalAssembler.g:4506:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:4507:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:4507:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:4508:5: lv_operand_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDirectOperandAccess().getOperandExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDirectOperandRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_1_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirectOperand"


    // $ANTLR start "entryRuleImmediatOperand"
    // InternalAssembler.g:4529:1: entryRuleImmediatOperand returns [EObject current=null] : iv_ruleImmediatOperand= ruleImmediatOperand EOF ;
    public final EObject entryRuleImmediatOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImmediatOperand = null;


        try {
            // InternalAssembler.g:4529:56: (iv_ruleImmediatOperand= ruleImmediatOperand EOF )
            // InternalAssembler.g:4530:2: iv_ruleImmediatOperand= ruleImmediatOperand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImmediatOperandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImmediatOperand=ruleImmediatOperand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImmediatOperand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImmediatOperand"


    // $ANTLR start "ruleImmediatOperand"
    // InternalAssembler.g:4536:1: ruleImmediatOperand returns [EObject current=null] : (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleImmediatOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4542:2: ( (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:4543:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:4543:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:4544:3: otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,93,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImmediatOperandAccess().getNumberSignKeyword_0());
              		
            }
            // InternalAssembler.g:4548:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:4549:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:4549:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:4550:5: lv_operand_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImmediatOperandAccess().getOperandExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getImmediatOperandRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_1_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImmediatOperand"


    // $ANTLR start "entryRuleIndexedOperand"
    // InternalAssembler.g:4571:1: entryRuleIndexedOperand returns [EObject current=null] : iv_ruleIndexedOperand= ruleIndexedOperand EOF ;
    public final EObject entryRuleIndexedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedOperand = null;


        try {
            // InternalAssembler.g:4571:55: (iv_ruleIndexedOperand= ruleIndexedOperand EOF )
            // InternalAssembler.g:4572:2: iv_ruleIndexedOperand= ruleIndexedOperand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexedOperandRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIndexedOperand=ruleIndexedOperand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndexedOperand; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexedOperand"


    // $ANTLR start "ruleIndexedOperand"
    // InternalAssembler.g:4578:1: ruleIndexedOperand returns [EObject current=null] : ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) ;
    public final EObject ruleIndexedOperand() throws RecognitionException {
        EObject current = null;

        EObject lv_mode_0_0 = null;

        EObject lv_mode_1_0 = null;

        EObject lv_mode_2_0 = null;

        EObject lv_mode_3_0 = null;

        EObject lv_mode_4_0 = null;

        EObject lv_mode_5_0 = null;

        EObject lv_mode_6_0 = null;

        EObject lv_mode_7_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4584:2: ( ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) )
            // InternalAssembler.g:4585:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            {
            // InternalAssembler.g:4585:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            int alt58=8;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // InternalAssembler.g:4586:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    {
                    // InternalAssembler.g:4586:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    // InternalAssembler.g:4587:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    {
                    // InternalAssembler.g:4587:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    // InternalAssembler.g:4588:5: lv_mode_0_0= ruleAutoIncDecMode
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIndexedOperandAccess().getModeAutoIncDecModeParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_mode_0_0=ruleAutoIncDecMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIndexedOperandRule());
                      					}
                      					set(
                      						current,
                      						"mode",
                      						lv_mode_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AutoIncDecMode");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4606:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    {
                    // InternalAssembler.g:4606:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    // InternalAssembler.g:4607:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    {
                    // InternalAssembler.g:4607:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    // InternalAssembler.g:4608:5: lv_mode_1_0= ruleConstantIndexedMode
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIndexedOperandAccess().getModeConstantIndexedModeParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_mode_1_0=ruleConstantIndexedMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIndexedOperandRule());
                      					}
                      					set(
                      						current,
                      						"mode",
                      						lv_mode_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.ConstantIndexedMode");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:4626:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    {
                    // InternalAssembler.g:4626:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    // InternalAssembler.g:4627:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    {
                    // InternalAssembler.g:4627:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    // InternalAssembler.g:4628:5: lv_mode_2_0= ruleAccumulatorMovingMode
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIndexedOperandAccess().getModeAccumulatorMovingModeParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_mode_2_0=ruleAccumulatorMovingMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIndexedOperandRule());
                      					}
                      					set(
                      						current,
                      						"mode",
                      						lv_mode_2_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AccumulatorMovingMode");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:4646:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    {
                    // InternalAssembler.g:4646:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    // InternalAssembler.g:4647:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    {
                    // InternalAssembler.g:4647:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    // InternalAssembler.g:4648:5: lv_mode_3_0= ruleRelatifToPCMode
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIndexedOperandAccess().getModeRelatifToPCModeParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_mode_3_0=ruleRelatifToPCMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIndexedOperandRule());
                      					}
                      					set(
                      						current,
                      						"mode",
                      						lv_mode_3_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.RelatifToPCMode");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:4666:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:4666:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    // InternalAssembler.g:4667:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    {
                    // InternalAssembler.g:4667:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    // InternalAssembler.g:4668:5: lv_mode_4_0= ruleConstantIndexedMovingIndirectMode
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIndexedOperandAccess().getModeConstantIndexedMovingIndirectModeParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_mode_4_0=ruleConstantIndexedMovingIndirectMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIndexedOperandRule());
                      					}
                      					set(
                      						current,
                      						"mode",
                      						lv_mode_4_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.ConstantIndexedMovingIndirectMode");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:4686:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    {
                    // InternalAssembler.g:4686:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    // InternalAssembler.g:4687:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    {
                    // InternalAssembler.g:4687:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    // InternalAssembler.g:4688:5: lv_mode_5_0= ruleAutoIncDecIndirectMode
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIndexedOperandAccess().getModeAutoIncDecIndirectModeParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_mode_5_0=ruleAutoIncDecIndirectMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIndexedOperandRule());
                      					}
                      					set(
                      						current,
                      						"mode",
                      						lv_mode_5_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AutoIncDecIndirectMode");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:4706:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:4706:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    // InternalAssembler.g:4707:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    {
                    // InternalAssembler.g:4707:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    // InternalAssembler.g:4708:5: lv_mode_6_0= ruleAccumulatorMovingIndirectMode
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIndexedOperandAccess().getModeAccumulatorMovingIndirectModeParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_mode_6_0=ruleAccumulatorMovingIndirectMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIndexedOperandRule());
                      					}
                      					set(
                      						current,
                      						"mode",
                      						lv_mode_6_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AccumulatorMovingIndirectMode");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:4726:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    {
                    // InternalAssembler.g:4726:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    // InternalAssembler.g:4727:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    {
                    // InternalAssembler.g:4727:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    // InternalAssembler.g:4728:5: lv_mode_7_0= ruleRelatifToPCIndirectMode
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIndexedOperandAccess().getModeRelatifToPCIndirectModeParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_mode_7_0=ruleRelatifToPCIndirectMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIndexedOperandRule());
                      					}
                      					set(
                      						current,
                      						"mode",
                      						lv_mode_7_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.RelatifToPCIndirectMode");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndexedOperand"


    // $ANTLR start "entryRuleConstantIndexedMode"
    // InternalAssembler.g:4749:1: entryRuleConstantIndexedMode returns [EObject current=null] : iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF ;
    public final EObject entryRuleConstantIndexedMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMode = null;


        try {
            // InternalAssembler.g:4749:60: (iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF )
            // InternalAssembler.g:4750:2: iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantIndexedModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantIndexedMode=ruleConstantIndexedMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantIndexedMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantIndexedMode"


    // $ANTLR start "ruleConstantIndexedMode"
    // InternalAssembler.g:4756:1: ruleConstantIndexedMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
    public final EObject ruleConstantIndexedMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_register_2_1=null;
        Token lv_register_2_2=null;
        Token lv_register_2_3=null;
        Token lv_register_2_4=null;
        EObject lv_deplacement_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4762:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:4763:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:4763:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:4764:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:4764:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_ID && LA59_0<=RULE_CHARACTER)||LA59_0==101||LA59_0==103) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAssembler.g:4765:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:4765:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:4766:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_deplacement_0_0=ruleNumericalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getConstantIndexedModeRule());
                      					}
                      					set(
                      						current,
                      						"deplacement",
                      						lv_deplacement_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.NumericalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstantIndexedModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:4787:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:4788:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:4788:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:4789:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:4789:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt60=4;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt60=1;
                }
                break;
            case 95:
                {
                alt60=2;
                }
                break;
            case 96:
                {
                alt60=3;
                }
                break;
            case 97:
                {
                alt60=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalAssembler.g:4790:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_2_1, grammarAccess.getConstantIndexedModeAccess().getRegisterSKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstantIndexedModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4801:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_2_2, grammarAccess.getConstantIndexedModeAccess().getRegisterUKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstantIndexedModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_2_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:4812:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_2_3, grammarAccess.getConstantIndexedModeAccess().getRegisterXKeyword_2_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstantIndexedModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_2_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:4823:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_2_4, grammarAccess.getConstantIndexedModeAccess().getRegisterYKeyword_2_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstantIndexedModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_2_4, null);
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantIndexedMode"


    // $ANTLR start "entryRuleConstantIndexedMovingIndirectMode"
    // InternalAssembler.g:4840:1: entryRuleConstantIndexedMovingIndirectMode returns [EObject current=null] : iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF ;
    public final EObject entryRuleConstantIndexedMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMovingIndirectMode = null;


        try {
            // InternalAssembler.g:4840:74: (iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF )
            // InternalAssembler.g:4841:2: iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantIndexedMovingIndirectModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantIndexedMovingIndirectMode=ruleConstantIndexedMovingIndirectMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantIndexedMovingIndirectMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantIndexedMovingIndirectMode"


    // $ANTLR start "ruleConstantIndexedMovingIndirectMode"
    // InternalAssembler.g:4847:1: ruleConstantIndexedMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
    public final EObject ruleConstantIndexedMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_register_3_1=null;
        Token lv_register_3_2=null;
        Token lv_register_3_3=null;
        Token lv_register_3_4=null;
        Token otherlv_4=null;
        EObject lv_deplacement_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4853:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:4854:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:4854:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:4855:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:4859:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=RULE_ID && LA61_0<=RULE_CHARACTER)||LA61_0==101||LA61_0==103) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalAssembler.g:4860:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:4860:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:4861:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedMovingIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_deplacement_1_0=ruleNumericalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getConstantIndexedMovingIndirectModeRule());
                      					}
                      					set(
                      						current,
                      						"deplacement",
                      						lv_deplacement_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.NumericalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:4882:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:4883:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:4883:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:4884:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:4884:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt62=4;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt62=1;
                }
                break;
            case 95:
                {
                alt62=2;
                }
                break;
            case 96:
                {
                alt62=3;
                }
                break;
            case 97:
                {
                alt62=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalAssembler.g:4885:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,94,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_3_1, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getRegisterSKeyword_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstantIndexedMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_3_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4896:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,95,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_3_2, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getRegisterUKeyword_3_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstantIndexedMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_3_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:4907:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,96,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_3_3, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getRegisterXKeyword_3_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstantIndexedMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_3_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:4918:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,97,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_3_4, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getRegisterYKeyword_3_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstantIndexedMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_3_4, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            otherlv_4=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantIndexedMovingIndirectMode"


    // $ANTLR start "entryRuleAccumulatorMovingMode"
    // InternalAssembler.g:4939:1: entryRuleAccumulatorMovingMode returns [EObject current=null] : iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF ;
    public final EObject entryRuleAccumulatorMovingMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingMode = null;


        try {
            // InternalAssembler.g:4939:62: (iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF )
            // InternalAssembler.g:4940:2: iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccumulatorMovingModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAccumulatorMovingMode=ruleAccumulatorMovingMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccumulatorMovingMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccumulatorMovingMode"


    // $ANTLR start "ruleAccumulatorMovingMode"
    // InternalAssembler.g:4946:1: ruleAccumulatorMovingMode returns [EObject current=null] : ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
    public final EObject ruleAccumulatorMovingMode() throws RecognitionException {
        EObject current = null;

        Token lv_deplacement_0_1=null;
        Token lv_deplacement_0_2=null;
        Token lv_deplacement_0_3=null;
        Token otherlv_1=null;
        Token lv_register_2_1=null;
        Token lv_register_2_2=null;
        Token lv_register_2_3=null;
        Token lv_register_2_4=null;


        	enterRule();

        try {
            // InternalAssembler.g:4952:2: ( ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:4953:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:4953:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:4954:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:4954:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) )
            // InternalAssembler.g:4955:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            {
            // InternalAssembler.g:4955:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            // InternalAssembler.g:4956:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            {
            // InternalAssembler.g:4956:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            int alt63=3;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt63=1;
                }
                break;
            case 99:
                {
                alt63=2;
                }
                break;
            case 100:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalAssembler.g:4957:6: lv_deplacement_0_1= 'A'
                    {
                    lv_deplacement_0_1=(Token)match(input,98,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_deplacement_0_1, grammarAccess.getAccumulatorMovingModeAccess().getDeplacementAKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingModeRule());
                      						}
                      						setWithLastConsumed(current, "deplacement", lv_deplacement_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4968:6: lv_deplacement_0_2= 'B'
                    {
                    lv_deplacement_0_2=(Token)match(input,99,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_deplacement_0_2, grammarAccess.getAccumulatorMovingModeAccess().getDeplacementBKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingModeRule());
                      						}
                      						setWithLastConsumed(current, "deplacement", lv_deplacement_0_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:4979:6: lv_deplacement_0_3= 'D'
                    {
                    lv_deplacement_0_3=(Token)match(input,100,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_deplacement_0_3, grammarAccess.getAccumulatorMovingModeAccess().getDeplacementDKeyword_0_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingModeRule());
                      						}
                      						setWithLastConsumed(current, "deplacement", lv_deplacement_0_3, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAccumulatorMovingModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:4996:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:4997:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:4997:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:4998:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:4998:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt64=4;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt64=1;
                }
                break;
            case 95:
                {
                alt64=2;
                }
                break;
            case 96:
                {
                alt64=3;
                }
                break;
            case 97:
                {
                alt64=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalAssembler.g:4999:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_2_1, grammarAccess.getAccumulatorMovingModeAccess().getRegisterSKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:5010:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_2_2, grammarAccess.getAccumulatorMovingModeAccess().getRegisterUKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_2_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:5021:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_2_3, grammarAccess.getAccumulatorMovingModeAccess().getRegisterXKeyword_2_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_2_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:5032:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_2_4, grammarAccess.getAccumulatorMovingModeAccess().getRegisterYKeyword_2_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_2_4, null);
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccumulatorMovingMode"


    // $ANTLR start "entryRuleAccumulatorMovingIndirectMode"
    // InternalAssembler.g:5049:1: entryRuleAccumulatorMovingIndirectMode returns [EObject current=null] : iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF ;
    public final EObject entryRuleAccumulatorMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingIndirectMode = null;


        try {
            // InternalAssembler.g:5049:70: (iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF )
            // InternalAssembler.g:5050:2: iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccumulatorMovingIndirectModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAccumulatorMovingIndirectMode=ruleAccumulatorMovingIndirectMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccumulatorMovingIndirectMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccumulatorMovingIndirectMode"


    // $ANTLR start "ruleAccumulatorMovingIndirectMode"
    // InternalAssembler.g:5056:1: ruleAccumulatorMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
    public final EObject ruleAccumulatorMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_deplacement_1_1=null;
        Token lv_deplacement_1_2=null;
        Token lv_deplacement_1_3=null;
        Token otherlv_2=null;
        Token lv_register_3_1=null;
        Token lv_register_3_2=null;
        Token lv_register_3_3=null;
        Token lv_register_3_4=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAssembler.g:5062:2: ( (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:5063:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:5063:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:5064:3: otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAccumulatorMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:5068:3: ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) )
            // InternalAssembler.g:5069:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            {
            // InternalAssembler.g:5069:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            // InternalAssembler.g:5070:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            {
            // InternalAssembler.g:5070:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            int alt65=3;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt65=1;
                }
                break;
            case 99:
                {
                alt65=2;
                }
                break;
            case 100:
                {
                alt65=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalAssembler.g:5071:6: lv_deplacement_1_1= 'A'
                    {
                    lv_deplacement_1_1=(Token)match(input,98,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_deplacement_1_1, grammarAccess.getAccumulatorMovingIndirectModeAccess().getDeplacementAKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "deplacement", lv_deplacement_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:5082:6: lv_deplacement_1_2= 'B'
                    {
                    lv_deplacement_1_2=(Token)match(input,99,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_deplacement_1_2, grammarAccess.getAccumulatorMovingIndirectModeAccess().getDeplacementBKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "deplacement", lv_deplacement_1_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:5093:6: lv_deplacement_1_3= 'D'
                    {
                    lv_deplacement_1_3=(Token)match(input,100,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_deplacement_1_3, grammarAccess.getAccumulatorMovingIndirectModeAccess().getDeplacementDKeyword_1_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "deplacement", lv_deplacement_1_3, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAccumulatorMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:5110:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:5111:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:5111:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:5112:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:5112:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt66=4;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt66=1;
                }
                break;
            case 95:
                {
                alt66=2;
                }
                break;
            case 96:
                {
                alt66=3;
                }
                break;
            case 97:
                {
                alt66=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalAssembler.g:5113:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,94,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_3_1, grammarAccess.getAccumulatorMovingIndirectModeAccess().getRegisterSKeyword_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_3_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:5124:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,95,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_3_2, grammarAccess.getAccumulatorMovingIndirectModeAccess().getRegisterUKeyword_3_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_3_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:5135:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,96,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_3_3, grammarAccess.getAccumulatorMovingIndirectModeAccess().getRegisterXKeyword_3_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_3_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:5146:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,97,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_register_3_4, grammarAccess.getAccumulatorMovingIndirectModeAccess().getRegisterYKeyword_3_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAccumulatorMovingIndirectModeRule());
                      						}
                      						setWithLastConsumed(current, "register", lv_register_3_4, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            otherlv_4=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getAccumulatorMovingIndirectModeAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccumulatorMovingIndirectMode"


    // $ANTLR start "entryRuleAutoIncDecMode"
    // InternalAssembler.g:5167:1: entryRuleAutoIncDecMode returns [EObject current=null] : iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF ;
    public final EObject entryRuleAutoIncDecMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecMode = null;


        try {
            // InternalAssembler.g:5167:55: (iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF )
            // InternalAssembler.g:5168:2: iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAutoIncDecModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAutoIncDecMode=ruleAutoIncDecMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAutoIncDecMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAutoIncDecMode"


    // $ANTLR start "ruleAutoIncDecMode"
    // InternalAssembler.g:5174:1: ruleAutoIncDecMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) ;
    public final EObject ruleAutoIncDecMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_decrement_2_0=null;
        Token lv_decrement_3_0=null;
        Token lv_register_4_1=null;
        Token lv_register_4_2=null;
        Token lv_register_4_3=null;
        Token lv_register_4_4=null;
        Token lv_register_5_1=null;
        Token lv_register_5_2=null;
        Token lv_register_5_3=null;
        Token lv_register_5_4=null;
        Token lv_increment_6_0=null;
        Token lv_increment_7_0=null;
        EObject lv_deplacement_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5180:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) )
            // InternalAssembler.g:5181:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            {
            // InternalAssembler.g:5181:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            // InternalAssembler.g:5182:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            {
            // InternalAssembler.g:5182:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=RULE_ID && LA67_0<=RULE_CHARACTER)||LA67_0==101||LA67_0==103) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAssembler.g:5183:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:5183:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:5184:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_deplacement_0_0=ruleNumericalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAutoIncDecModeRule());
                      					}
                      					set(
                      						current,
                      						"deplacement",
                      						lv_deplacement_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.NumericalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAutoIncDecModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:5205:3: ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=101 && LA72_0<=102)) ) {
                alt72=1;
            }
            else if ( ((LA72_0>=94 && LA72_0<=97)) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalAssembler.g:5206:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:5206:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    // InternalAssembler.g:5207:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:5207:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==101) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==102) ) {
                        alt68=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 0, input);

                        throw nvae;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalAssembler.g:5208:6: ( (lv_decrement_2_0= '-' ) )
                            {
                            // InternalAssembler.g:5208:6: ( (lv_decrement_2_0= '-' ) )
                            // InternalAssembler.g:5209:7: (lv_decrement_2_0= '-' )
                            {
                            // InternalAssembler.g:5209:7: (lv_decrement_2_0= '-' )
                            // InternalAssembler.g:5210:8: lv_decrement_2_0= '-'
                            {
                            lv_decrement_2_0=(Token)match(input,101,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_decrement_2_0, grammarAccess.getAutoIncDecModeAccess().getDecrementHyphenMinusKeyword_2_0_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "decrement", lv_decrement_2_0, "-");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:5223:6: ( (lv_decrement_3_0= '--' ) )
                            {
                            // InternalAssembler.g:5223:6: ( (lv_decrement_3_0= '--' ) )
                            // InternalAssembler.g:5224:7: (lv_decrement_3_0= '--' )
                            {
                            // InternalAssembler.g:5224:7: (lv_decrement_3_0= '--' )
                            // InternalAssembler.g:5225:8: lv_decrement_3_0= '--'
                            {
                            lv_decrement_3_0=(Token)match(input,102,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_decrement_3_0, grammarAccess.getAutoIncDecModeAccess().getDecrementHyphenMinusHyphenMinusKeyword_2_0_0_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "decrement", lv_decrement_3_0, "--");
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalAssembler.g:5238:5: ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    // InternalAssembler.g:5239:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    {
                    // InternalAssembler.g:5239:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    // InternalAssembler.g:5240:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    {
                    // InternalAssembler.g:5240:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    int alt69=4;
                    switch ( input.LA(1) ) {
                    case 94:
                        {
                        alt69=1;
                        }
                        break;
                    case 95:
                        {
                        alt69=2;
                        }
                        break;
                    case 96:
                        {
                        alt69=3;
                        }
                        break;
                    case 97:
                        {
                        alt69=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 0, input);

                        throw nvae;
                    }

                    switch (alt69) {
                        case 1 :
                            // InternalAssembler.g:5241:8: lv_register_4_1= 'S'
                            {
                            lv_register_4_1=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_4_1, grammarAccess.getAutoIncDecModeAccess().getRegisterSKeyword_2_0_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_4_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:5252:8: lv_register_4_2= 'U'
                            {
                            lv_register_4_2=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_4_2, grammarAccess.getAutoIncDecModeAccess().getRegisterUKeyword_2_0_1_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_4_2, null);
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:5263:8: lv_register_4_3= 'X'
                            {
                            lv_register_4_3=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_4_3, grammarAccess.getAutoIncDecModeAccess().getRegisterXKeyword_2_0_1_0_2());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_4_3, null);
                              							
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:5274:8: lv_register_4_4= 'Y'
                            {
                            lv_register_4_4=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_4_4, grammarAccess.getAutoIncDecModeAccess().getRegisterYKeyword_2_0_1_0_3());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_4_4, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:5289:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:5289:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    // InternalAssembler.g:5290:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    {
                    // InternalAssembler.g:5290:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:5291:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:5291:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:5292:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:5292:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt70=4;
                    switch ( input.LA(1) ) {
                    case 94:
                        {
                        alt70=1;
                        }
                        break;
                    case 95:
                        {
                        alt70=2;
                        }
                        break;
                    case 96:
                        {
                        alt70=3;
                        }
                        break;
                    case 97:
                        {
                        alt70=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }

                    switch (alt70) {
                        case 1 :
                            // InternalAssembler.g:5293:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,94,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_5_1, grammarAccess.getAutoIncDecModeAccess().getRegisterSKeyword_2_1_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_5_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:5304:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,95,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_5_2, grammarAccess.getAutoIncDecModeAccess().getRegisterUKeyword_2_1_0_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_5_2, null);
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:5315:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,96,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_5_3, grammarAccess.getAutoIncDecModeAccess().getRegisterXKeyword_2_1_0_0_2());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_5_3, null);
                              							
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:5326:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,97,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_5_4, grammarAccess.getAutoIncDecModeAccess().getRegisterYKeyword_2_1_0_0_3());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_5_4, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalAssembler.g:5339:5: ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==103) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==104) ) {
                        alt71=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalAssembler.g:5340:6: ( (lv_increment_6_0= '+' ) )
                            {
                            // InternalAssembler.g:5340:6: ( (lv_increment_6_0= '+' ) )
                            // InternalAssembler.g:5341:7: (lv_increment_6_0= '+' )
                            {
                            // InternalAssembler.g:5341:7: (lv_increment_6_0= '+' )
                            // InternalAssembler.g:5342:8: lv_increment_6_0= '+'
                            {
                            lv_increment_6_0=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_increment_6_0, grammarAccess.getAutoIncDecModeAccess().getIncrementPlusSignKeyword_2_1_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "increment", lv_increment_6_0, "+");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:5355:6: ( (lv_increment_7_0= '++' ) )
                            {
                            // InternalAssembler.g:5355:6: ( (lv_increment_7_0= '++' ) )
                            // InternalAssembler.g:5356:7: (lv_increment_7_0= '++' )
                            {
                            // InternalAssembler.g:5356:7: (lv_increment_7_0= '++' )
                            // InternalAssembler.g:5357:8: lv_increment_7_0= '++'
                            {
                            lv_increment_7_0=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_increment_7_0, grammarAccess.getAutoIncDecModeAccess().getIncrementPlusSignPlusSignKeyword_2_1_1_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecModeRule());
                              								}
                              								setWithLastConsumed(current, "increment", lv_increment_7_0, "++");
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAutoIncDecMode"


    // $ANTLR start "entryRuleAutoIncDecIndirectMode"
    // InternalAssembler.g:5376:1: entryRuleAutoIncDecIndirectMode returns [EObject current=null] : iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF ;
    public final EObject entryRuleAutoIncDecIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecIndirectMode = null;


        try {
            // InternalAssembler.g:5376:63: (iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF )
            // InternalAssembler.g:5377:2: iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAutoIncDecIndirectModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAutoIncDecIndirectMode=ruleAutoIncDecIndirectMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAutoIncDecIndirectMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAutoIncDecIndirectMode"


    // $ANTLR start "ruleAutoIncDecIndirectMode"
    // InternalAssembler.g:5383:1: ruleAutoIncDecIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) ;
    public final EObject ruleAutoIncDecIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_decrement_3_0=null;
        Token lv_decrement_4_0=null;
        Token lv_register_5_1=null;
        Token lv_register_5_2=null;
        Token lv_register_5_3=null;
        Token lv_register_5_4=null;
        Token lv_register_6_1=null;
        Token lv_register_6_2=null;
        Token lv_register_6_3=null;
        Token lv_register_6_4=null;
        Token lv_increment_7_0=null;
        Token lv_increment_8_0=null;
        Token otherlv_9=null;
        EObject lv_deplacement_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5389:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) )
            // InternalAssembler.g:5390:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            {
            // InternalAssembler.g:5390:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            // InternalAssembler.g:5391:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAutoIncDecIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:5395:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=RULE_ID && LA73_0<=RULE_CHARACTER)||LA73_0==101||LA73_0==103) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalAssembler.g:5396:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:5396:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:5397:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_deplacement_1_0=ruleNumericalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAutoIncDecIndirectModeRule());
                      					}
                      					set(
                      						current,
                      						"deplacement",
                      						lv_deplacement_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.NumericalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAutoIncDecIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:5418:3: ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=101 && LA78_0<=102)) ) {
                alt78=1;
            }
            else if ( ((LA78_0>=94 && LA78_0<=97)) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalAssembler.g:5419:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:5419:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    // InternalAssembler.g:5420:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:5420:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==101) ) {
                        alt74=1;
                    }
                    else if ( (LA74_0==102) ) {
                        alt74=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 74, 0, input);

                        throw nvae;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalAssembler.g:5421:6: ( (lv_decrement_3_0= '-' ) )
                            {
                            // InternalAssembler.g:5421:6: ( (lv_decrement_3_0= '-' ) )
                            // InternalAssembler.g:5422:7: (lv_decrement_3_0= '-' )
                            {
                            // InternalAssembler.g:5422:7: (lv_decrement_3_0= '-' )
                            // InternalAssembler.g:5423:8: lv_decrement_3_0= '-'
                            {
                            lv_decrement_3_0=(Token)match(input,101,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_decrement_3_0, grammarAccess.getAutoIncDecIndirectModeAccess().getDecrementHyphenMinusKeyword_3_0_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "decrement", lv_decrement_3_0, "-");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:5436:6: ( (lv_decrement_4_0= '--' ) )
                            {
                            // InternalAssembler.g:5436:6: ( (lv_decrement_4_0= '--' ) )
                            // InternalAssembler.g:5437:7: (lv_decrement_4_0= '--' )
                            {
                            // InternalAssembler.g:5437:7: (lv_decrement_4_0= '--' )
                            // InternalAssembler.g:5438:8: lv_decrement_4_0= '--'
                            {
                            lv_decrement_4_0=(Token)match(input,102,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_decrement_4_0, grammarAccess.getAutoIncDecIndirectModeAccess().getDecrementHyphenMinusHyphenMinusKeyword_3_0_0_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "decrement", lv_decrement_4_0, "--");
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalAssembler.g:5451:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:5452:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:5452:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:5453:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:5453:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt75=4;
                    switch ( input.LA(1) ) {
                    case 94:
                        {
                        alt75=1;
                        }
                        break;
                    case 95:
                        {
                        alt75=2;
                        }
                        break;
                    case 96:
                        {
                        alt75=3;
                        }
                        break;
                    case 97:
                        {
                        alt75=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }

                    switch (alt75) {
                        case 1 :
                            // InternalAssembler.g:5454:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,94,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_5_1, grammarAccess.getAutoIncDecIndirectModeAccess().getRegisterSKeyword_3_0_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_5_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:5465:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,95,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_5_2, grammarAccess.getAutoIncDecIndirectModeAccess().getRegisterUKeyword_3_0_1_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_5_2, null);
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:5476:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,96,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_5_3, grammarAccess.getAutoIncDecIndirectModeAccess().getRegisterXKeyword_3_0_1_0_2());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_5_3, null);
                              							
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:5487:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,97,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_5_4, grammarAccess.getAutoIncDecIndirectModeAccess().getRegisterYKeyword_3_0_1_0_3());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_5_4, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:5502:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:5502:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    // InternalAssembler.g:5503:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    {
                    // InternalAssembler.g:5503:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) )
                    // InternalAssembler.g:5504:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    {
                    // InternalAssembler.g:5504:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    // InternalAssembler.g:5505:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    {
                    // InternalAssembler.g:5505:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    int alt76=4;
                    switch ( input.LA(1) ) {
                    case 94:
                        {
                        alt76=1;
                        }
                        break;
                    case 95:
                        {
                        alt76=2;
                        }
                        break;
                    case 96:
                        {
                        alt76=3;
                        }
                        break;
                    case 97:
                        {
                        alt76=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 0, input);

                        throw nvae;
                    }

                    switch (alt76) {
                        case 1 :
                            // InternalAssembler.g:5506:8: lv_register_6_1= 'S'
                            {
                            lv_register_6_1=(Token)match(input,94,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_6_1, grammarAccess.getAutoIncDecIndirectModeAccess().getRegisterSKeyword_3_1_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_6_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:5517:8: lv_register_6_2= 'U'
                            {
                            lv_register_6_2=(Token)match(input,95,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_6_2, grammarAccess.getAutoIncDecIndirectModeAccess().getRegisterUKeyword_3_1_0_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_6_2, null);
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:5528:8: lv_register_6_3= 'X'
                            {
                            lv_register_6_3=(Token)match(input,96,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_6_3, grammarAccess.getAutoIncDecIndirectModeAccess().getRegisterXKeyword_3_1_0_0_2());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_6_3, null);
                              							
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:5539:8: lv_register_6_4= 'Y'
                            {
                            lv_register_6_4=(Token)match(input,97,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_register_6_4, grammarAccess.getAutoIncDecIndirectModeAccess().getRegisterYKeyword_3_1_0_0_3());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "register", lv_register_6_4, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalAssembler.g:5552:5: ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==103) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==104) ) {
                        alt77=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalAssembler.g:5553:6: ( (lv_increment_7_0= '+' ) )
                            {
                            // InternalAssembler.g:5553:6: ( (lv_increment_7_0= '+' ) )
                            // InternalAssembler.g:5554:7: (lv_increment_7_0= '+' )
                            {
                            // InternalAssembler.g:5554:7: (lv_increment_7_0= '+' )
                            // InternalAssembler.g:5555:8: lv_increment_7_0= '+'
                            {
                            lv_increment_7_0=(Token)match(input,103,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_increment_7_0, grammarAccess.getAutoIncDecIndirectModeAccess().getIncrementPlusSignKeyword_3_1_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "increment", lv_increment_7_0, "+");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:5568:6: ( (lv_increment_8_0= '++' ) )
                            {
                            // InternalAssembler.g:5568:6: ( (lv_increment_8_0= '++' ) )
                            // InternalAssembler.g:5569:7: (lv_increment_8_0= '++' )
                            {
                            // InternalAssembler.g:5569:7: (lv_increment_8_0= '++' )
                            // InternalAssembler.g:5570:8: lv_increment_8_0= '++'
                            {
                            lv_increment_8_0=(Token)match(input,104,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_increment_8_0, grammarAccess.getAutoIncDecIndirectModeAccess().getIncrementPlusSignPlusSignKeyword_3_1_1_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getAutoIncDecIndirectModeRule());
                              								}
                              								setWithLastConsumed(current, "increment", lv_increment_8_0, "++");
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getAutoIncDecIndirectModeAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAutoIncDecIndirectMode"


    // $ANTLR start "entryRuleRelatifToPCMode"
    // InternalAssembler.g:5593:1: entryRuleRelatifToPCMode returns [EObject current=null] : iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF ;
    public final EObject entryRuleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCMode = null;


        try {
            // InternalAssembler.g:5593:56: (iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF )
            // InternalAssembler.g:5594:2: iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelatifToPCModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelatifToPCMode=ruleRelatifToPCMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelatifToPCMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelatifToPCMode"


    // $ANTLR start "ruleRelatifToPCMode"
    // InternalAssembler.g:5600:1: ruleRelatifToPCMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) ;
    public final EObject ruleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_register_2_0=null;
        EObject lv_deplacement_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5606:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) )
            // InternalAssembler.g:5607:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            {
            // InternalAssembler.g:5607:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            // InternalAssembler.g:5608:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) )
            {
            // InternalAssembler.g:5608:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=RULE_ID && LA79_0<=RULE_CHARACTER)||LA79_0==101||LA79_0==103) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAssembler.g:5609:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:5609:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:5610:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_deplacement_0_0=ruleNumericalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRelatifToPCModeRule());
                      					}
                      					set(
                      						current,
                      						"deplacement",
                      						lv_deplacement_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.NumericalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,19,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelatifToPCModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:5631:3: ( (lv_register_2_0= 'PCR' ) )
            // InternalAssembler.g:5632:4: (lv_register_2_0= 'PCR' )
            {
            // InternalAssembler.g:5632:4: (lv_register_2_0= 'PCR' )
            // InternalAssembler.g:5633:5: lv_register_2_0= 'PCR'
            {
            lv_register_2_0=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_register_2_0, grammarAccess.getRelatifToPCModeAccess().getRegisterPCRKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRelatifToPCModeRule());
              					}
              					setWithLastConsumed(current, "register", lv_register_2_0, "PCR");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelatifToPCMode"


    // $ANTLR start "entryRuleRelatifToPCIndirectMode"
    // InternalAssembler.g:5649:1: entryRuleRelatifToPCIndirectMode returns [EObject current=null] : iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF ;
    public final EObject entryRuleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCIndirectMode = null;


        try {
            // InternalAssembler.g:5649:64: (iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF )
            // InternalAssembler.g:5650:2: iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelatifToPCIndirectModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelatifToPCIndirectMode=ruleRelatifToPCIndirectMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelatifToPCIndirectMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelatifToPCIndirectMode"


    // $ANTLR start "ruleRelatifToPCIndirectMode"
    // InternalAssembler.g:5656:1: ruleRelatifToPCIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) ;
    public final EObject ruleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_register_3_0=null;
        Token otherlv_4=null;
        EObject lv_deplacement_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5662:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:5663:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:5663:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            // InternalAssembler.g:5664:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRelatifToPCIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:5668:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=RULE_ID && LA80_0<=RULE_CHARACTER)||LA80_0==101||LA80_0==103) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAssembler.g:5669:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:5669:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:5670:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_deplacement_1_0=ruleNumericalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRelatifToPCIndirectModeRule());
                      					}
                      					set(
                      						current,
                      						"deplacement",
                      						lv_deplacement_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.NumericalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,19,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRelatifToPCIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:5691:3: ( (lv_register_3_0= 'PCR' ) )
            // InternalAssembler.g:5692:4: (lv_register_3_0= 'PCR' )
            {
            // InternalAssembler.g:5692:4: (lv_register_3_0= 'PCR' )
            // InternalAssembler.g:5693:5: lv_register_3_0= 'PCR'
            {
            lv_register_3_0=(Token)match(input,105,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_register_3_0, grammarAccess.getRelatifToPCIndirectModeAccess().getRegisterPCRKeyword_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRelatifToPCIndirectModeRule());
              					}
              					setWithLastConsumed(current, "register", lv_register_3_0, "PCR");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRelatifToPCIndirectModeAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelatifToPCIndirectMode"


    // $ANTLR start "entryRuleRelativeMode"
    // InternalAssembler.g:5713:1: entryRuleRelativeMode returns [EObject current=null] : iv_ruleRelativeMode= ruleRelativeMode EOF ;
    public final EObject entryRuleRelativeMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeMode = null;


        try {
            // InternalAssembler.g:5713:53: (iv_ruleRelativeMode= ruleRelativeMode EOF )
            // InternalAssembler.g:5714:2: iv_ruleRelativeMode= ruleRelativeMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelativeModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelativeMode=ruleRelativeMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelativeMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelativeMode"


    // $ANTLR start "ruleRelativeMode"
    // InternalAssembler.g:5720:1: ruleRelativeMode returns [EObject current=null] : ( (lv_location_0_0= ruleIdentifierValue ) ) ;
    public final EObject ruleRelativeMode() throws RecognitionException {
        EObject current = null;

        EObject lv_location_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5726:2: ( ( (lv_location_0_0= ruleIdentifierValue ) ) )
            // InternalAssembler.g:5727:2: ( (lv_location_0_0= ruleIdentifierValue ) )
            {
            // InternalAssembler.g:5727:2: ( (lv_location_0_0= ruleIdentifierValue ) )
            // InternalAssembler.g:5728:3: (lv_location_0_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:5728:3: (lv_location_0_0= ruleIdentifierValue )
            // InternalAssembler.g:5729:4: lv_location_0_0= ruleIdentifierValue
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getRelativeModeAccess().getLocationIdentifierValueParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_location_0_0=ruleIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getRelativeModeRule());
              				}
              				set(
              					current,
              					"location",
              					lv_location_0_0,
              					"org.bpy.electronics.mc6809.assembler.Assembler.IdentifierValue");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelativeMode"


    // $ANTLR start "entryRuleDirectiveLine"
    // InternalAssembler.g:5749:1: entryRuleDirectiveLine returns [EObject current=null] : iv_ruleDirectiveLine= ruleDirectiveLine EOF ;
    public final EObject entryRuleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectiveLine = null;


        try {
            // InternalAssembler.g:5749:54: (iv_ruleDirectiveLine= ruleDirectiveLine EOF )
            // InternalAssembler.g:5750:2: iv_ruleDirectiveLine= ruleDirectiveLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectiveLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDirectiveLine=ruleDirectiveLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectiveLine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDirectiveLine"


    // $ANTLR start "ruleDirectiveLine"
    // InternalAssembler.g:5756:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleDirectiveLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_WS_18=null;
        Token lv_comment_19_0=null;
        Token this_WS_20=null;
        EObject lv_name_0_0 = null;

        EObject lv_directive_2_0 = null;

        EObject lv_directive_3_0 = null;

        EObject lv_directive_4_0 = null;

        EObject lv_directive_5_0 = null;

        EObject lv_directive_6_0 = null;

        EObject lv_directive_7_0 = null;

        EObject lv_directive_8_0 = null;

        EObject lv_directive_9_0 = null;

        EObject lv_directive_10_0 = null;

        EObject lv_directive_11_0 = null;

        EObject lv_directive_12_0 = null;

        EObject lv_directive_13_0 = null;

        EObject lv_directive_14_0 = null;

        EObject lv_directive_15_0 = null;

        EObject lv_directive_16_0 = null;

        EObject lv_directive_17_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5762:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:5763:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:5763:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:5764:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:5764:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_ID) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalAssembler.g:5765:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5765:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:5766:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.IdentifierValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:5787:3: ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) )
            int alt82=16;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt82=1;
                }
                break;
            case 123:
                {
                alt82=2;
                }
                break;
            case 117:
            case 118:
                {
                alt82=3;
                }
                break;
            case 122:
                {
                alt82=4;
                }
                break;
            case 113:
                {
                alt82=5;
                }
                break;
            case 116:
                {
                alt82=6;
                }
                break;
            case 112:
                {
                alt82=7;
                }
                break;
            case 111:
                {
                alt82=8;
                }
                break;
            case 109:
            case 110:
                {
                alt82=9;
                }
                break;
            case 114:
                {
                alt82=10;
                }
                break;
            case 108:
                {
                alt82=11;
                }
                break;
            case 107:
                {
                alt82=12;
                }
                break;
            case 120:
                {
                alt82=13;
                }
                break;
            case 119:
                {
                alt82=14;
                }
                break;
            case 106:
                {
                alt82=15;
                }
                break;
            case 121:
                {
                alt82=16;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalAssembler.g:5788:4: ( (lv_directive_2_0= ruleEquDirective ) )
                    {
                    // InternalAssembler.g:5788:4: ( (lv_directive_2_0= ruleEquDirective ) )
                    // InternalAssembler.g:5789:5: (lv_directive_2_0= ruleEquDirective )
                    {
                    // InternalAssembler.g:5789:5: (lv_directive_2_0= ruleEquDirective )
                    // InternalAssembler.g:5790:6: lv_directive_2_0= ruleEquDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveEquDirectiveParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_2_0=ruleEquDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_2_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.EquDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:5808:4: ( (lv_directive_3_0= ruleOrgDirective ) )
                    {
                    // InternalAssembler.g:5808:4: ( (lv_directive_3_0= ruleOrgDirective ) )
                    // InternalAssembler.g:5809:5: (lv_directive_3_0= ruleOrgDirective )
                    {
                    // InternalAssembler.g:5809:5: (lv_directive_3_0= ruleOrgDirective )
                    // InternalAssembler.g:5810:6: lv_directive_3_0= ruleOrgDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveOrgDirectiveParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_3_0=ruleOrgDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_3_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.OrgDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:5828:4: ( (lv_directive_4_0= ruleBszDirective ) )
                    {
                    // InternalAssembler.g:5828:4: ( (lv_directive_4_0= ruleBszDirective ) )
                    // InternalAssembler.g:5829:5: (lv_directive_4_0= ruleBszDirective )
                    {
                    // InternalAssembler.g:5829:5: (lv_directive_4_0= ruleBszDirective )
                    // InternalAssembler.g:5830:6: lv_directive_4_0= ruleBszDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveBszDirectiveParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_4_0=ruleBszDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_4_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.BszDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:5848:4: ( (lv_directive_5_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:5848:4: ( (lv_directive_5_0= ruleEndDirective ) )
                    // InternalAssembler.g:5849:5: (lv_directive_5_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:5849:5: (lv_directive_5_0= ruleEndDirective )
                    // InternalAssembler.g:5850:6: lv_directive_5_0= ruleEndDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveEndDirectiveParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_5_0=ruleEndDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_5_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.EndDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:5868:4: ( (lv_directive_6_0= ruleFailDirective ) )
                    {
                    // InternalAssembler.g:5868:4: ( (lv_directive_6_0= ruleFailDirective ) )
                    // InternalAssembler.g:5869:5: (lv_directive_6_0= ruleFailDirective )
                    {
                    // InternalAssembler.g:5869:5: (lv_directive_6_0= ruleFailDirective )
                    // InternalAssembler.g:5870:6: lv_directive_6_0= ruleFailDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFailDirectiveParserRuleCall_2_4_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_6_0=ruleFailDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_6_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.FailDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:5888:4: ( (lv_directive_7_0= ruleFillDirective ) )
                    {
                    // InternalAssembler.g:5888:4: ( (lv_directive_7_0= ruleFillDirective ) )
                    // InternalAssembler.g:5889:5: (lv_directive_7_0= ruleFillDirective )
                    {
                    // InternalAssembler.g:5889:5: (lv_directive_7_0= ruleFillDirective )
                    // InternalAssembler.g:5890:6: lv_directive_7_0= ruleFillDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFillDirectiveParserRuleCall_2_5_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_7_0=ruleFillDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_7_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.FillDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:5908:4: ( (lv_directive_8_0= ruleOptDirective ) )
                    {
                    // InternalAssembler.g:5908:4: ( (lv_directive_8_0= ruleOptDirective ) )
                    // InternalAssembler.g:5909:5: (lv_directive_8_0= ruleOptDirective )
                    {
                    // InternalAssembler.g:5909:5: (lv_directive_8_0= ruleOptDirective )
                    // InternalAssembler.g:5910:6: lv_directive_8_0= ruleOptDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveOptDirectiveParserRuleCall_2_6_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_8_0=ruleOptDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_8_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.OptDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:5928:4: ( (lv_directive_9_0= rulePagDirective ) )
                    {
                    // InternalAssembler.g:5928:4: ( (lv_directive_9_0= rulePagDirective ) )
                    // InternalAssembler.g:5929:5: (lv_directive_9_0= rulePagDirective )
                    {
                    // InternalAssembler.g:5929:5: (lv_directive_9_0= rulePagDirective )
                    // InternalAssembler.g:5930:6: lv_directive_9_0= rulePagDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectivePagDirectiveParserRuleCall_2_7_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_9_0=rulePagDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_9_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.PagDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:5948:4: ( (lv_directive_10_0= ruleNamDirective ) )
                    {
                    // InternalAssembler.g:5948:4: ( (lv_directive_10_0= ruleNamDirective ) )
                    // InternalAssembler.g:5949:5: (lv_directive_10_0= ruleNamDirective )
                    {
                    // InternalAssembler.g:5949:5: (lv_directive_10_0= ruleNamDirective )
                    // InternalAssembler.g:5950:6: lv_directive_10_0= ruleNamDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveNamDirectiveParserRuleCall_2_8_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_10_0=ruleNamDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_10_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.NamDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalAssembler.g:5968:4: ( (lv_directive_11_0= ruleSetDirective ) )
                    {
                    // InternalAssembler.g:5968:4: ( (lv_directive_11_0= ruleSetDirective ) )
                    // InternalAssembler.g:5969:5: (lv_directive_11_0= ruleSetDirective )
                    {
                    // InternalAssembler.g:5969:5: (lv_directive_11_0= ruleSetDirective )
                    // InternalAssembler.g:5970:6: lv_directive_11_0= ruleSetDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveSetDirectiveParserRuleCall_2_9_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_11_0=ruleSetDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_11_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.SetDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalAssembler.g:5988:4: ( (lv_directive_12_0= ruleSpcDirective ) )
                    {
                    // InternalAssembler.g:5988:4: ( (lv_directive_12_0= ruleSpcDirective ) )
                    // InternalAssembler.g:5989:5: (lv_directive_12_0= ruleSpcDirective )
                    {
                    // InternalAssembler.g:5989:5: (lv_directive_12_0= ruleSpcDirective )
                    // InternalAssembler.g:5990:6: lv_directive_12_0= ruleSpcDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveSpcDirectiveParserRuleCall_2_10_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_12_0=ruleSpcDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_12_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.SpcDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalAssembler.g:6008:4: ( (lv_directive_13_0= ruleRegDirective ) )
                    {
                    // InternalAssembler.g:6008:4: ( (lv_directive_13_0= ruleRegDirective ) )
                    // InternalAssembler.g:6009:5: (lv_directive_13_0= ruleRegDirective )
                    {
                    // InternalAssembler.g:6009:5: (lv_directive_13_0= ruleRegDirective )
                    // InternalAssembler.g:6010:6: lv_directive_13_0= ruleRegDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveRegDirectiveParserRuleCall_2_11_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_13_0=ruleRegDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_13_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.RegDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalAssembler.g:6028:4: ( (lv_directive_14_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:6028:4: ( (lv_directive_14_0= ruleFcbDirective ) )
                    // InternalAssembler.g:6029:5: (lv_directive_14_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:6029:5: (lv_directive_14_0= ruleFcbDirective )
                    // InternalAssembler.g:6030:6: lv_directive_14_0= ruleFcbDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFcbDirectiveParserRuleCall_2_12_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_14_0=ruleFcbDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_14_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.FcbDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalAssembler.g:6048:4: ( (lv_directive_15_0= ruleFdbDirective ) )
                    {
                    // InternalAssembler.g:6048:4: ( (lv_directive_15_0= ruleFdbDirective ) )
                    // InternalAssembler.g:6049:5: (lv_directive_15_0= ruleFdbDirective )
                    {
                    // InternalAssembler.g:6049:5: (lv_directive_15_0= ruleFdbDirective )
                    // InternalAssembler.g:6050:6: lv_directive_15_0= ruleFdbDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFdbDirectiveParserRuleCall_2_13_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_15_0=ruleFdbDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_15_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.FdbDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalAssembler.g:6068:4: ( (lv_directive_16_0= ruleFccDirective ) )
                    {
                    // InternalAssembler.g:6068:4: ( (lv_directive_16_0= ruleFccDirective ) )
                    // InternalAssembler.g:6069:5: (lv_directive_16_0= ruleFccDirective )
                    {
                    // InternalAssembler.g:6069:5: (lv_directive_16_0= ruleFccDirective )
                    // InternalAssembler.g:6070:6: lv_directive_16_0= ruleFccDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFccDirectiveParserRuleCall_2_14_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_16_0=ruleFccDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_16_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.FccDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 16 :
                    // InternalAssembler.g:6088:4: ( (lv_directive_17_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:6088:4: ( (lv_directive_17_0= ruleRmbDirective ) )
                    // InternalAssembler.g:6089:5: (lv_directive_17_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:6089:5: (lv_directive_17_0= ruleRmbDirective )
                    // InternalAssembler.g:6090:6: lv_directive_17_0= ruleRmbDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveRmbDirectiveParserRuleCall_2_15_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_17_0=ruleRmbDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_17_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.RmbDirective");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:6108:3: (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_WS) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt83=1;
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalAssembler.g:6109:4: this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_18, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:6113:4: ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:6114:5: (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:6114:5: (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:6115:6: lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_19_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_19_0, grammarAccess.getDirectiveLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectiveLineRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_19_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:6132:3: (this_WS_20= RULE_WS )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_WS) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalAssembler.g:6133:4: this_WS_20= RULE_WS
                    {
                    this_WS_20=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_20, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDirectiveLineAccess().getEndOfLineParserRuleCall_5());
              		
            }
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirectiveLine"


    // $ANTLR start "entryRuleFccDirective"
    // InternalAssembler.g:6149:1: entryRuleFccDirective returns [EObject current=null] : iv_ruleFccDirective= ruleFccDirective EOF ;
    public final EObject entryRuleFccDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFccDirective = null;


        try {
            // InternalAssembler.g:6149:53: (iv_ruleFccDirective= ruleFccDirective EOF )
            // InternalAssembler.g:6150:2: iv_ruleFccDirective= ruleFccDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFccDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFccDirective=ruleFccDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFccDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFccDirective"


    // $ANTLR start "ruleFccDirective"
    // InternalAssembler.g:6156:1: ruleFccDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleFccDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_string_2_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6162:2: ( ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) ) )
            // InternalAssembler.g:6163:2: ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) )
            {
            // InternalAssembler.g:6163:2: ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) )
            // InternalAssembler.g:6164:3: ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) )
            {
            // InternalAssembler.g:6164:3: ( (lv_directive_0_0= 'FCC' ) )
            // InternalAssembler.g:6165:4: (lv_directive_0_0= 'FCC' )
            {
            // InternalAssembler.g:6165:4: (lv_directive_0_0= 'FCC' )
            // InternalAssembler.g:6166:5: lv_directive_0_0= 'FCC'
            {
            lv_directive_0_0=(Token)match(input,106,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getFccDirectiveAccess().getDirectiveFCCKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFccDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "FCC");
              				
            }

            }


            }

            // InternalAssembler.g:6178:3: (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) )
            // InternalAssembler.g:6179:4: this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:6183:4: ( (lv_string_2_0= RULE_STRING ) )
            // InternalAssembler.g:6184:5: (lv_string_2_0= RULE_STRING )
            {
            // InternalAssembler.g:6184:5: (lv_string_2_0= RULE_STRING )
            // InternalAssembler.g:6185:6: lv_string_2_0= RULE_STRING
            {
            lv_string_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(lv_string_2_0, grammarAccess.getFccDirectiveAccess().getStringSTRINGTerminalRuleCall_1_1_0());
              					
            }
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getFccDirectiveRule());
              						}
              						setWithLastConsumed(
              							current,
              							"string",
              							lv_string_2_0,
              							"org.bpy.electronics.mc6809.assembler.Assembler.STRING");
              					
            }

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFccDirective"


    // $ANTLR start "entryRuleRegDirective"
    // InternalAssembler.g:6206:1: entryRuleRegDirective returns [EObject current=null] : iv_ruleRegDirective= ruleRegDirective EOF ;
    public final EObject entryRuleRegDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegDirective = null;


        try {
            // InternalAssembler.g:6206:53: (iv_ruleRegDirective= ruleRegDirective EOF )
            // InternalAssembler.g:6207:2: iv_ruleRegDirective= ruleRegDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegDirective=ruleRegDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegDirective"


    // $ANTLR start "ruleRegDirective"
    // InternalAssembler.g:6213:1: ruleRegDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? ) ;
    public final EObject ruleRegDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_options_2_0 = null;

        Enumerator lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6219:2: ( ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? ) )
            // InternalAssembler.g:6220:2: ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? )
            {
            // InternalAssembler.g:6220:2: ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? )
            // InternalAssembler.g:6221:3: ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )?
            {
            // InternalAssembler.g:6221:3: ( (lv_directive_0_0= 'REG' ) )
            // InternalAssembler.g:6222:4: (lv_directive_0_0= 'REG' )
            {
            // InternalAssembler.g:6222:4: (lv_directive_0_0= 'REG' )
            // InternalAssembler.g:6223:5: lv_directive_0_0= 'REG'
            {
            lv_directive_0_0=(Token)match(input,107,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getRegDirectiveAccess().getDirectiveREGKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "REG");
              				
            }

            }


            }

            // InternalAssembler.g:6235:3: (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_WS) ) {
                int LA86_1 = input.LA(2);

                if ( ((LA86_1>=94 && LA86_1<=100)||(LA86_1>=142 && LA86_1<=144)) ) {
                    alt86=1;
                }
            }
            switch (alt86) {
                case 1 :
                    // InternalAssembler.g:6236:4: this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )*
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:6240:4: ( (lv_options_2_0= ruleRegister ) )
                    // InternalAssembler.g:6241:5: (lv_options_2_0= ruleRegister )
                    {
                    // InternalAssembler.g:6241:5: (lv_options_2_0= ruleRegister )
                    // InternalAssembler.g:6242:6: lv_options_2_0= ruleRegister
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRegDirectiveAccess().getOptionsRegisterEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
                    lv_options_2_0=ruleRegister();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRegDirectiveRule());
                      						}
                      						add(
                      							current,
                      							"options",
                      							lv_options_2_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.Register");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalAssembler.g:6259:4: (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==19) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // InternalAssembler.g:6260:5: otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getRegDirectiveAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:6264:5: ( (lv_options_4_0= ruleRegister ) )
                    	    // InternalAssembler.g:6265:6: (lv_options_4_0= ruleRegister )
                    	    {
                    	    // InternalAssembler.g:6265:6: (lv_options_4_0= ruleRegister )
                    	    // InternalAssembler.g:6266:7: lv_options_4_0= ruleRegister
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRegDirectiveAccess().getOptionsRegisterEnumRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_25);
                    	    lv_options_4_0=ruleRegister();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRegDirectiveRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"options",
                    	      								lv_options_4_0,
                    	      								"org.bpy.electronics.mc6809.assembler.Assembler.Register");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop85;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegDirective"


    // $ANTLR start "entryRuleSpcDirective"
    // InternalAssembler.g:6289:1: entryRuleSpcDirective returns [EObject current=null] : iv_ruleSpcDirective= ruleSpcDirective EOF ;
    public final EObject entryRuleSpcDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpcDirective = null;


        try {
            // InternalAssembler.g:6289:53: (iv_ruleSpcDirective= ruleSpcDirective EOF )
            // InternalAssembler.g:6290:2: iv_ruleSpcDirective= ruleSpcDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpcDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpcDirective=ruleSpcDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpcDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpcDirective"


    // $ANTLR start "ruleSpcDirective"
    // InternalAssembler.g:6296:1: ruleSpcDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? ) ;
    public final EObject ruleSpcDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        EObject lv_spaceCount_2_0 = null;

        EObject lv_keepCount_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6302:2: ( ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? ) )
            // InternalAssembler.g:6303:2: ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? )
            {
            // InternalAssembler.g:6303:2: ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? )
            // InternalAssembler.g:6304:3: ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )?
            {
            // InternalAssembler.g:6304:3: ( (lv_directive_0_0= 'SPC' ) )
            // InternalAssembler.g:6305:4: (lv_directive_0_0= 'SPC' )
            {
            // InternalAssembler.g:6305:4: (lv_directive_0_0= 'SPC' )
            // InternalAssembler.g:6306:5: lv_directive_0_0= 'SPC'
            {
            lv_directive_0_0=(Token)match(input,108,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getSpcDirectiveAccess().getDirectiveSPCKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSpcDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "SPC");
              				
            }

            }


            }

            // InternalAssembler.g:6318:3: (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_WS) ) {
                int LA88_1 = input.LA(2);

                if ( ((LA88_1>=RULE_ID && LA88_1<=RULE_CHARACTER)||LA88_1==101||LA88_1==103||(LA88_1>=132 && LA88_1<=133)) ) {
                    alt88=1;
                }
            }
            switch (alt88) {
                case 1 :
                    // InternalAssembler.g:6319:4: this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )?
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:6323:4: ( (lv_spaceCount_2_0= ruleExpression ) )
                    // InternalAssembler.g:6324:5: (lv_spaceCount_2_0= ruleExpression )
                    {
                    // InternalAssembler.g:6324:5: (lv_spaceCount_2_0= ruleExpression )
                    // InternalAssembler.g:6325:6: lv_spaceCount_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSpcDirectiveAccess().getSpaceCountExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
                    lv_spaceCount_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSpcDirectiveRule());
                      						}
                      						set(
                      							current,
                      							"spaceCount",
                      							lv_spaceCount_2_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalAssembler.g:6342:4: (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==19) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalAssembler.g:6343:5: otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) )
                            {
                            otherlv_3=(Token)match(input,19,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getSpcDirectiveAccess().getCommaKeyword_1_2_0());
                              				
                            }
                            // InternalAssembler.g:6347:5: ( (lv_keepCount_4_0= ruleExpression ) )
                            // InternalAssembler.g:6348:6: (lv_keepCount_4_0= ruleExpression )
                            {
                            // InternalAssembler.g:6348:6: (lv_keepCount_4_0= ruleExpression )
                            // InternalAssembler.g:6349:7: lv_keepCount_4_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getSpcDirectiveAccess().getKeepCountExpressionParserRuleCall_1_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_keepCount_4_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getSpcDirectiveRule());
                              							}
                              							set(
                              								current,
                              								"keepCount",
                              								lv_keepCount_4_0,
                              								"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpcDirective"


    // $ANTLR start "entryRuleNamDirective"
    // InternalAssembler.g:6372:1: entryRuleNamDirective returns [EObject current=null] : iv_ruleNamDirective= ruleNamDirective EOF ;
    public final EObject entryRuleNamDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamDirective = null;


        try {
            // InternalAssembler.g:6372:53: (iv_ruleNamDirective= ruleNamDirective EOF )
            // InternalAssembler.g:6373:2: iv_ruleNamDirective= ruleNamDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamDirective=ruleNamDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamDirective"


    // $ANTLR start "ruleNamDirective"
    // InternalAssembler.g:6379:1: ruleNamDirective returns [EObject current=null] : ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) ) ;
    public final EObject ruleNamDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token lv_directive_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6385:2: ( ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:6386:2: ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:6386:2: ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) )
            // InternalAssembler.g:6387:3: ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) )
            {
            // InternalAssembler.g:6387:3: ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==109) ) {
                alt89=1;
            }
            else if ( (LA89_0==110) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalAssembler.g:6388:4: ( (lv_directive_0_0= 'NAM' ) )
                    {
                    // InternalAssembler.g:6388:4: ( (lv_directive_0_0= 'NAM' ) )
                    // InternalAssembler.g:6389:5: (lv_directive_0_0= 'NAM' )
                    {
                    // InternalAssembler.g:6389:5: (lv_directive_0_0= 'NAM' )
                    // InternalAssembler.g:6390:6: lv_directive_0_0= 'NAM'
                    {
                    lv_directive_0_0=(Token)match(input,109,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_directive_0_0, grammarAccess.getNamDirectiveAccess().getDirectiveNAMKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getNamDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "directive", lv_directive_0_0, "NAM");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:6403:4: ( (lv_directive_1_0= 'TTL' ) )
                    {
                    // InternalAssembler.g:6403:4: ( (lv_directive_1_0= 'TTL' ) )
                    // InternalAssembler.g:6404:5: (lv_directive_1_0= 'TTL' )
                    {
                    // InternalAssembler.g:6404:5: (lv_directive_1_0= 'TTL' )
                    // InternalAssembler.g:6405:6: lv_directive_1_0= 'TTL'
                    {
                    lv_directive_1_0=(Token)match(input,110,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_directive_1_0, grammarAccess.getNamDirectiveAccess().getDirectiveTTLKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getNamDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "directive", lv_directive_1_0, "TTL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_WS_2=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_2, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:6422:3: ( (lv_operand_3_0= ruleIdentifierValue ) )
            // InternalAssembler.g:6423:4: (lv_operand_3_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:6423:4: (lv_operand_3_0= ruleIdentifierValue )
            // InternalAssembler.g:6424:5: lv_operand_3_0= ruleIdentifierValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNamDirectiveAccess().getOperandIdentifierValueParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_3_0=ruleIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNamDirectiveRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_3_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.IdentifierValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamDirective"


    // $ANTLR start "entryRulePagDirective"
    // InternalAssembler.g:6445:1: entryRulePagDirective returns [EObject current=null] : iv_rulePagDirective= rulePagDirective EOF ;
    public final EObject entryRulePagDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePagDirective = null;


        try {
            // InternalAssembler.g:6445:53: (iv_rulePagDirective= rulePagDirective EOF )
            // InternalAssembler.g:6446:2: iv_rulePagDirective= rulePagDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPagDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePagDirective=rulePagDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePagDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePagDirective"


    // $ANTLR start "rulePagDirective"
    // InternalAssembler.g:6452:1: rulePagDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? ) ;
    public final EObject rulePagDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6458:2: ( ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? ) )
            // InternalAssembler.g:6459:2: ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? )
            {
            // InternalAssembler.g:6459:2: ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? )
            // InternalAssembler.g:6460:3: ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )?
            {
            // InternalAssembler.g:6460:3: ( (lv_directive_0_0= 'PAG' ) )
            // InternalAssembler.g:6461:4: (lv_directive_0_0= 'PAG' )
            {
            // InternalAssembler.g:6461:4: (lv_directive_0_0= 'PAG' )
            // InternalAssembler.g:6462:5: lv_directive_0_0= 'PAG'
            {
            lv_directive_0_0=(Token)match(input,111,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getPagDirectiveAccess().getDirectivePAGKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPagDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "PAG");
              				
            }

            }


            }

            // InternalAssembler.g:6474:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_WS) ) {
                int LA90_1 = input.LA(2);

                if ( ((LA90_1>=RULE_ID && LA90_1<=RULE_CHARACTER)||LA90_1==101||LA90_1==103||(LA90_1>=132 && LA90_1<=133)) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // InternalAssembler.g:6475:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:6479:4: ( (lv_operand_2_0= ruleExpression ) )
                    // InternalAssembler.g:6480:5: (lv_operand_2_0= ruleExpression )
                    {
                    // InternalAssembler.g:6480:5: (lv_operand_2_0= ruleExpression )
                    // InternalAssembler.g:6481:6: lv_operand_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPagDirectiveAccess().getOperandExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPagDirectiveRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePagDirective"


    // $ANTLR start "entryRuleOptDirective"
    // InternalAssembler.g:6503:1: entryRuleOptDirective returns [EObject current=null] : iv_ruleOptDirective= ruleOptDirective EOF ;
    public final EObject entryRuleOptDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptDirective = null;


        try {
            // InternalAssembler.g:6503:53: (iv_ruleOptDirective= ruleOptDirective EOF )
            // InternalAssembler.g:6504:2: iv_ruleOptDirective= ruleOptDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOptDirective=ruleOptDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptDirective"


    // $ANTLR start "ruleOptDirective"
    // InternalAssembler.g:6510:1: ruleOptDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? ) ;
    public final EObject ruleOptDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_options_2_0 = null;

        Enumerator lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6516:2: ( ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? ) )
            // InternalAssembler.g:6517:2: ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? )
            {
            // InternalAssembler.g:6517:2: ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? )
            // InternalAssembler.g:6518:3: ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )?
            {
            // InternalAssembler.g:6518:3: ( (lv_directive_0_0= 'OPT' ) )
            // InternalAssembler.g:6519:4: (lv_directive_0_0= 'OPT' )
            {
            // InternalAssembler.g:6519:4: (lv_directive_0_0= 'OPT' )
            // InternalAssembler.g:6520:5: lv_directive_0_0= 'OPT'
            {
            lv_directive_0_0=(Token)match(input,112,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getOptDirectiveAccess().getDirectiveOPTKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOptDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "OPT");
              				
            }

            }


            }

            // InternalAssembler.g:6532:3: (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_WS) ) {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==111||(LA92_1>=135 && LA92_1<=141)) ) {
                    alt92=1;
                }
            }
            switch (alt92) {
                case 1 :
                    // InternalAssembler.g:6533:4: this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )*
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:6537:4: ( (lv_options_2_0= ruleAssemblyOption ) )
                    // InternalAssembler.g:6538:5: (lv_options_2_0= ruleAssemblyOption )
                    {
                    // InternalAssembler.g:6538:5: (lv_options_2_0= ruleAssemblyOption )
                    // InternalAssembler.g:6539:6: lv_options_2_0= ruleAssemblyOption
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
                    lv_options_2_0=ruleAssemblyOption();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOptDirectiveRule());
                      						}
                      						add(
                      							current,
                      							"options",
                      							lv_options_2_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.AssemblyOption");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalAssembler.g:6556:4: (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==19) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // InternalAssembler.g:6557:5: otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getOptDirectiveAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:6561:5: ( (lv_options_4_0= ruleAssemblyOption ) )
                    	    // InternalAssembler.g:6562:6: (lv_options_4_0= ruleAssemblyOption )
                    	    {
                    	    // InternalAssembler.g:6562:6: (lv_options_4_0= ruleAssemblyOption )
                    	    // InternalAssembler.g:6563:7: lv_options_4_0= ruleAssemblyOption
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_25);
                    	    lv_options_4_0=ruleAssemblyOption();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getOptDirectiveRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"options",
                    	      								lv_options_4_0,
                    	      								"org.bpy.electronics.mc6809.assembler.Assembler.AssemblyOption");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop91;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptDirective"


    // $ANTLR start "entryRuleFailDirective"
    // InternalAssembler.g:6586:1: entryRuleFailDirective returns [EObject current=null] : iv_ruleFailDirective= ruleFailDirective EOF ;
    public final EObject entryRuleFailDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailDirective = null;


        try {
            // InternalAssembler.g:6586:54: (iv_ruleFailDirective= ruleFailDirective EOF )
            // InternalAssembler.g:6587:2: iv_ruleFailDirective= ruleFailDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFailDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFailDirective=ruleFailDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFailDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailDirective"


    // $ANTLR start "ruleFailDirective"
    // InternalAssembler.g:6593:1: ruleFailDirective returns [EObject current=null] : ( (lv_directive_0_0= 'FAIL' ) ) ;
    public final EObject ruleFailDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6599:2: ( ( (lv_directive_0_0= 'FAIL' ) ) )
            // InternalAssembler.g:6600:2: ( (lv_directive_0_0= 'FAIL' ) )
            {
            // InternalAssembler.g:6600:2: ( (lv_directive_0_0= 'FAIL' ) )
            // InternalAssembler.g:6601:3: (lv_directive_0_0= 'FAIL' )
            {
            // InternalAssembler.g:6601:3: (lv_directive_0_0= 'FAIL' )
            // InternalAssembler.g:6602:4: lv_directive_0_0= 'FAIL'
            {
            lv_directive_0_0=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_directive_0_0, grammarAccess.getFailDirectiveAccess().getDirectiveFAILKeyword_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getFailDirectiveRule());
              				}
              				setWithLastConsumed(current, "directive", lv_directive_0_0, "FAIL");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailDirective"


    // $ANTLR start "entryRuleSetDirective"
    // InternalAssembler.g:6617:1: entryRuleSetDirective returns [EObject current=null] : iv_ruleSetDirective= ruleSetDirective EOF ;
    public final EObject entryRuleSetDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDirective = null;


        try {
            // InternalAssembler.g:6617:53: (iv_ruleSetDirective= ruleSetDirective EOF )
            // InternalAssembler.g:6618:2: iv_ruleSetDirective= ruleSetDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetDirective=ruleSetDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetDirective"


    // $ANTLR start "ruleSetDirective"
    // InternalAssembler.g:6624:1: ruleSetDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) ;
    public final EObject ruleSetDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6630:2: ( ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) )
            // InternalAssembler.g:6631:2: ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            {
            // InternalAssembler.g:6631:2: ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            // InternalAssembler.g:6632:3: ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            {
            // InternalAssembler.g:6632:3: ( (lv_directive_0_0= 'SET' ) )
            // InternalAssembler.g:6633:4: (lv_directive_0_0= 'SET' )
            {
            // InternalAssembler.g:6633:4: (lv_directive_0_0= 'SET' )
            // InternalAssembler.g:6634:5: lv_directive_0_0= 'SET'
            {
            lv_directive_0_0=(Token)match(input,114,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getSetDirectiveAccess().getDirectiveSETKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSetDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "SET");
              				
            }

            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:6650:3: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==115) ) {
                int LA94_1 = input.LA(2);

                if ( ((LA94_1>=RULE_ID && LA94_1<=RULE_CHARACTER)||LA94_1==101||LA94_1==103||(LA94_1>=132 && LA94_1<=133)) ) {
                    alt94=1;
                }
                else if ( (LA94_1==EOF||LA94_1==RULE_WS||(LA94_1>=RULE_CR && LA94_1<=RULE_END_OF_FILE)) ) {
                    alt94=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 94, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA94_0>=RULE_ID && LA94_0<=RULE_CHARACTER)||LA94_0==101||LA94_0==103||(LA94_0>=132 && LA94_0<=133)) ) {
                alt94=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalAssembler.g:6651:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:6651:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:6652:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:6652:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==115) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalAssembler.g:6653:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:6653:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:6654:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,115,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_2_0, grammarAccess.getSetDirectiveAccess().getIsRelativeToPCAsteriskKeyword_2_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getSetDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_2_0 != null, "*");
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalAssembler.g:6666:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:6667:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:6667:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:6668:7: lv_operand_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetDirectiveAccess().getOperandExpressionParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getSetDirectiveRule());
                      							}
                      							set(
                      								current,
                      								"operand",
                      								lv_operand_3_0,
                      								"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:6687:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    {
                    // InternalAssembler.g:6687:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    // InternalAssembler.g:6688:5: (lv_isRelativeToPC_4_0= '*' )
                    {
                    // InternalAssembler.g:6688:5: (lv_isRelativeToPC_4_0= '*' )
                    // InternalAssembler.g:6689:6: lv_isRelativeToPC_4_0= '*'
                    {
                    lv_isRelativeToPC_4_0=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getSetDirectiveAccess().getIsRelativeToPCAsteriskKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSetDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetDirective"


    // $ANTLR start "entryRuleFillDirective"
    // InternalAssembler.g:6706:1: entryRuleFillDirective returns [EObject current=null] : iv_ruleFillDirective= ruleFillDirective EOF ;
    public final EObject entryRuleFillDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFillDirective = null;


        try {
            // InternalAssembler.g:6706:54: (iv_ruleFillDirective= ruleFillDirective EOF )
            // InternalAssembler.g:6707:2: iv_ruleFillDirective= ruleFillDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFillDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFillDirective=ruleFillDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFillDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFillDirective"


    // $ANTLR start "ruleFillDirective"
    // InternalAssembler.g:6713:1: ruleFillDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) ) ;
    public final EObject ruleFillDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;

        EObject lv_number_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6719:2: ( ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) ) )
            // InternalAssembler.g:6720:2: ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) )
            {
            // InternalAssembler.g:6720:2: ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) )
            // InternalAssembler.g:6721:3: ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:6721:3: ( (lv_directive_0_0= 'FILL' ) )
            // InternalAssembler.g:6722:4: (lv_directive_0_0= 'FILL' )
            {
            // InternalAssembler.g:6722:4: (lv_directive_0_0= 'FILL' )
            // InternalAssembler.g:6723:5: lv_directive_0_0= 'FILL'
            {
            lv_directive_0_0=(Token)match(input,116,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getFillDirectiveAccess().getDirectiveFILLKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFillDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "FILL");
              				
            }

            }


            }

            // InternalAssembler.g:6735:3: (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) )
            // InternalAssembler.g:6736:4: this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:6740:4: ( (lv_value_2_0= ruleExpression ) )
            // InternalAssembler.g:6741:5: (lv_value_2_0= ruleExpression )
            {
            // InternalAssembler.g:6741:5: (lv_value_2_0= ruleExpression )
            // InternalAssembler.g:6742:6: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getFillDirectiveAccess().getValueExpressionParserRuleCall_1_1_0());
              					
            }
            pushFollow(FOLLOW_10);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getFillDirectiveRule());
              						}
              						set(
              							current,
              							"value",
              							lv_value_2_0,
              							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_3, grammarAccess.getFillDirectiveAccess().getCommaKeyword_1_2());
              			
            }
            // InternalAssembler.g:6763:4: ( (lv_number_4_0= ruleExpression ) )
            // InternalAssembler.g:6764:5: (lv_number_4_0= ruleExpression )
            {
            // InternalAssembler.g:6764:5: (lv_number_4_0= ruleExpression )
            // InternalAssembler.g:6765:6: lv_number_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getFillDirectiveAccess().getNumberExpressionParserRuleCall_1_3_0());
              					
            }
            pushFollow(FOLLOW_2);
            lv_number_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getFillDirectiveRule());
              						}
              						set(
              							current,
              							"number",
              							lv_number_4_0,
              							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFillDirective"


    // $ANTLR start "entryRuleBszDirective"
    // InternalAssembler.g:6787:1: entryRuleBszDirective returns [EObject current=null] : iv_ruleBszDirective= ruleBszDirective EOF ;
    public final EObject entryRuleBszDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBszDirective = null;


        try {
            // InternalAssembler.g:6787:53: (iv_ruleBszDirective= ruleBszDirective EOF )
            // InternalAssembler.g:6788:2: iv_ruleBszDirective= ruleBszDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBszDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBszDirective=ruleBszDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBszDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBszDirective"


    // $ANTLR start "ruleBszDirective"
    // InternalAssembler.g:6794:1: ruleBszDirective returns [EObject current=null] : ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) ) ;
    public final EObject ruleBszDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_1=null;
        Token lv_directive_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6800:2: ( ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) ) )
            // InternalAssembler.g:6801:2: ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) )
            {
            // InternalAssembler.g:6801:2: ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) )
            // InternalAssembler.g:6802:3: ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:6802:3: ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) )
            // InternalAssembler.g:6803:4: ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) )
            {
            // InternalAssembler.g:6803:4: ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) )
            // InternalAssembler.g:6804:5: (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' )
            {
            // InternalAssembler.g:6804:5: (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==117) ) {
                alt95=1;
            }
            else if ( (LA95_0==118) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalAssembler.g:6805:6: lv_directive_0_1= 'BSZ'
                    {
                    lv_directive_0_1=(Token)match(input,117,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_directive_0_1, grammarAccess.getBszDirectiveAccess().getDirectiveBSZKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBszDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "directive", lv_directive_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:6816:6: lv_directive_0_2= 'ZMB'
                    {
                    lv_directive_0_2=(Token)match(input,118,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_directive_0_2, grammarAccess.getBszDirectiveAccess().getDirectiveZMBKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBszDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "directive", lv_directive_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalAssembler.g:6829:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )
            // InternalAssembler.g:6830:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:6834:4: ( (lv_operand_2_0= ruleExpression ) )
            // InternalAssembler.g:6835:5: (lv_operand_2_0= ruleExpression )
            {
            // InternalAssembler.g:6835:5: (lv_operand_2_0= ruleExpression )
            // InternalAssembler.g:6836:6: lv_operand_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getBszDirectiveAccess().getOperandExpressionParserRuleCall_1_1_0());
              					
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getBszDirectiveRule());
              						}
              						set(
              							current,
              							"operand",
              							lv_operand_2_0,
              							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBszDirective"


    // $ANTLR start "entryRuleFdbDirective"
    // InternalAssembler.g:6858:1: entryRuleFdbDirective returns [EObject current=null] : iv_ruleFdbDirective= ruleFdbDirective EOF ;
    public final EObject entryRuleFdbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFdbDirective = null;


        try {
            // InternalAssembler.g:6858:53: (iv_ruleFdbDirective= ruleFdbDirective EOF )
            // InternalAssembler.g:6859:2: iv_ruleFdbDirective= ruleFdbDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFdbDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFdbDirective=ruleFdbDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFdbDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFdbDirective"


    // $ANTLR start "ruleFdbDirective"
    // InternalAssembler.g:6865:1: ruleFdbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) ;
    public final EObject ruleFdbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6871:2: ( ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) )
            // InternalAssembler.g:6872:2: ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            {
            // InternalAssembler.g:6872:2: ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            // InternalAssembler.g:6873:3: ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            {
            // InternalAssembler.g:6873:3: ( (lv_directive_0_0= 'FDB' ) )
            // InternalAssembler.g:6874:4: (lv_directive_0_0= 'FDB' )
            {
            // InternalAssembler.g:6874:4: (lv_directive_0_0= 'FDB' )
            // InternalAssembler.g:6875:5: lv_directive_0_0= 'FDB'
            {
            lv_directive_0_0=(Token)match(input,119,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getFdbDirectiveAccess().getDirectiveFDBKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFdbDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "FDB");
              				
            }

            }


            }

            // InternalAssembler.g:6887:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_WS) ) {
                int LA96_1 = input.LA(2);

                if ( ((LA96_1>=RULE_ID && LA96_1<=RULE_CHARACTER)||LA96_1==101||LA96_1==103||(LA96_1>=132 && LA96_1<=133)) ) {
                    alt96=1;
                }
            }
            switch (alt96) {
                case 1 :
                    // InternalAssembler.g:6888:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:6892:4: ( (lv_operand_2_0= ruleListOfExpression ) )
                    // InternalAssembler.g:6893:5: (lv_operand_2_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:6893:5: (lv_operand_2_0= ruleListOfExpression )
                    // InternalAssembler.g:6894:6: lv_operand_2_0= ruleListOfExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFdbDirectiveAccess().getOperandListOfExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleListOfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFdbDirectiveRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ListOfExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFdbDirective"


    // $ANTLR start "entryRuleFcbDirective"
    // InternalAssembler.g:6916:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:6916:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:6917:2: iv_ruleFcbDirective= ruleFcbDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFcbDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFcbDirective=ruleFcbDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFcbDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFcbDirective"


    // $ANTLR start "ruleFcbDirective"
    // InternalAssembler.g:6923:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) ;
    public final EObject ruleFcbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6929:2: ( ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) )
            // InternalAssembler.g:6930:2: ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            {
            // InternalAssembler.g:6930:2: ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            // InternalAssembler.g:6931:3: ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            {
            // InternalAssembler.g:6931:3: ( (lv_directive_0_0= 'FCB' ) )
            // InternalAssembler.g:6932:4: (lv_directive_0_0= 'FCB' )
            {
            // InternalAssembler.g:6932:4: (lv_directive_0_0= 'FCB' )
            // InternalAssembler.g:6933:5: lv_directive_0_0= 'FCB'
            {
            lv_directive_0_0=(Token)match(input,120,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getFcbDirectiveAccess().getDirectiveFCBKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFcbDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "FCB");
              				
            }

            }


            }

            // InternalAssembler.g:6945:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_WS) ) {
                int LA97_1 = input.LA(2);

                if ( ((LA97_1>=RULE_ID && LA97_1<=RULE_CHARACTER)||LA97_1==101||LA97_1==103||(LA97_1>=132 && LA97_1<=133)) ) {
                    alt97=1;
                }
            }
            switch (alt97) {
                case 1 :
                    // InternalAssembler.g:6946:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:6950:4: ( (lv_operand_2_0= ruleListOfExpression ) )
                    // InternalAssembler.g:6951:5: (lv_operand_2_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:6951:5: (lv_operand_2_0= ruleListOfExpression )
                    // InternalAssembler.g:6952:6: lv_operand_2_0= ruleListOfExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFcbDirectiveAccess().getOperandListOfExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleListOfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFcbDirectiveRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ListOfExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFcbDirective"


    // $ANTLR start "entryRuleRmbDirective"
    // InternalAssembler.g:6974:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:6974:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:6975:2: iv_ruleRmbDirective= ruleRmbDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRmbDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRmbDirective=ruleRmbDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRmbDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRmbDirective"


    // $ANTLR start "ruleRmbDirective"
    // InternalAssembler.g:6981:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? ) ;
    public final EObject ruleRmbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6987:2: ( ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? ) )
            // InternalAssembler.g:6988:2: ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? )
            {
            // InternalAssembler.g:6988:2: ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? )
            // InternalAssembler.g:6989:3: ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )?
            {
            // InternalAssembler.g:6989:3: ( (lv_directive_0_0= 'RMB' ) )
            // InternalAssembler.g:6990:4: (lv_directive_0_0= 'RMB' )
            {
            // InternalAssembler.g:6990:4: (lv_directive_0_0= 'RMB' )
            // InternalAssembler.g:6991:5: lv_directive_0_0= 'RMB'
            {
            lv_directive_0_0=(Token)match(input,121,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getRmbDirectiveAccess().getDirectiveRMBKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRmbDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "RMB");
              				
            }

            }


            }

            // InternalAssembler.g:7003:3: (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==RULE_WS) ) {
                int LA99_1 = input.LA(2);

                if ( ((LA99_1>=RULE_ID && LA99_1<=RULE_CHARACTER)||LA99_1==101||LA99_1==103||LA99_1==115||(LA99_1>=132 && LA99_1<=133)) ) {
                    alt99=1;
                }
            }
            switch (alt99) {
                case 1 :
                    // InternalAssembler.g:7004:4: this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:7008:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:7009:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:7009:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==115) ) {
                        alt98=1;
                    }
                    switch (alt98) {
                        case 1 :
                            // InternalAssembler.g:7010:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:7010:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:7011:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,115,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_2_0, grammarAccess.getRmbDirectiveAccess().getIsRelativeToPCAsteriskKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRmbDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_2_0 != null, "*");
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalAssembler.g:7023:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:7024:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:7024:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:7025:7: lv_operand_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getRmbDirectiveAccess().getOperandExpressionParserRuleCall_1_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getRmbDirectiveRule());
                      							}
                      							set(
                      								current,
                      								"operand",
                      								lv_operand_3_0,
                      								"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRmbDirective"


    // $ANTLR start "entryRuleEndDirective"
    // InternalAssembler.g:7048:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:7048:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:7049:2: iv_ruleEndDirective= ruleEndDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEndDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEndDirective=ruleEndDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEndDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndDirective"


    // $ANTLR start "ruleEndDirective"
    // InternalAssembler.g:7055:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) ;
    public final EObject ruleEndDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7061:2: ( ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) )
            // InternalAssembler.g:7062:2: ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            {
            // InternalAssembler.g:7062:2: ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            // InternalAssembler.g:7063:3: ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            {
            // InternalAssembler.g:7063:3: ( (lv_directive_0_0= 'END' ) )
            // InternalAssembler.g:7064:4: (lv_directive_0_0= 'END' )
            {
            // InternalAssembler.g:7064:4: (lv_directive_0_0= 'END' )
            // InternalAssembler.g:7065:5: lv_directive_0_0= 'END'
            {
            lv_directive_0_0=(Token)match(input,122,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getEndDirectiveAccess().getDirectiveENDKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEndDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "END");
              				
            }

            }


            }

            // InternalAssembler.g:7077:3: (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==RULE_WS) ) {
                int LA102_1 = input.LA(2);

                if ( ((LA102_1>=RULE_ID && LA102_1<=RULE_CHARACTER)||LA102_1==101||LA102_1==103||LA102_1==115||(LA102_1>=132 && LA102_1<=133)) ) {
                    alt102=1;
                }
            }
            switch (alt102) {
                case 1 :
                    // InternalAssembler.g:7078:4: this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:7082:4: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==115) ) {
                        int LA101_1 = input.LA(2);

                        if ( (LA101_1==EOF||LA101_1==RULE_WS||(LA101_1>=RULE_CR && LA101_1<=RULE_END_OF_FILE)) ) {
                            alt101=2;
                        }
                        else if ( ((LA101_1>=RULE_ID && LA101_1<=RULE_CHARACTER)||LA101_1==101||LA101_1==103||(LA101_1>=132 && LA101_1<=133)) ) {
                            alt101=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 101, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA101_0>=RULE_ID && LA101_0<=RULE_CHARACTER)||LA101_0==101||LA101_0==103||(LA101_0>=132 && LA101_0<=133)) ) {
                        alt101=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 101, 0, input);

                        throw nvae;
                    }
                    switch (alt101) {
                        case 1 :
                            // InternalAssembler.g:7083:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:7083:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            // InternalAssembler.g:7084:6: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:7084:6: ( (lv_isRelativeToPC_2_0= '*' ) )?
                            int alt100=2;
                            int LA100_0 = input.LA(1);

                            if ( (LA100_0==115) ) {
                                alt100=1;
                            }
                            switch (alt100) {
                                case 1 :
                                    // InternalAssembler.g:7085:7: (lv_isRelativeToPC_2_0= '*' )
                                    {
                                    // InternalAssembler.g:7085:7: (lv_isRelativeToPC_2_0= '*' )
                                    // InternalAssembler.g:7086:8: lv_isRelativeToPC_2_0= '*'
                                    {
                                    lv_isRelativeToPC_2_0=(Token)match(input,115,FOLLOW_14); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(lv_isRelativeToPC_2_0, grammarAccess.getEndDirectiveAccess().getIsRelativeToPCAsteriskKeyword_1_1_0_0_0());
                                      							
                                    }
                                    if ( state.backtracking==0 ) {

                                      								if (current==null) {
                                      									current = createModelElement(grammarAccess.getEndDirectiveRule());
                                      								}
                                      								setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_2_0 != null, "*");
                                      							
                                    }

                                    }


                                    }
                                    break;

                            }

                            // InternalAssembler.g:7098:6: ( (lv_operand_3_0= ruleExpression ) )
                            // InternalAssembler.g:7099:7: (lv_operand_3_0= ruleExpression )
                            {
                            // InternalAssembler.g:7099:7: (lv_operand_3_0= ruleExpression )
                            // InternalAssembler.g:7100:8: lv_operand_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getEndDirectiveAccess().getOperandExpressionParserRuleCall_1_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getEndDirectiveRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_3_0,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:7119:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            {
                            // InternalAssembler.g:7119:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            // InternalAssembler.g:7120:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:7120:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:7121:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getEndDirectiveAccess().getIsRelativeToPCAsteriskKeyword_1_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEndDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndDirective"


    // $ANTLR start "entryRuleOrgDirective"
    // InternalAssembler.g:7139:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:7139:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:7140:2: iv_ruleOrgDirective= ruleOrgDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrgDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrgDirective=ruleOrgDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrgDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrgDirective"


    // $ANTLR start "ruleOrgDirective"
    // InternalAssembler.g:7146:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) ;
    public final EObject ruleOrgDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7152:2: ( ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) )
            // InternalAssembler.g:7153:2: ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            {
            // InternalAssembler.g:7153:2: ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            // InternalAssembler.g:7154:3: ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            {
            // InternalAssembler.g:7154:3: ( (lv_directive_0_0= 'ORG' ) )
            // InternalAssembler.g:7155:4: (lv_directive_0_0= 'ORG' )
            {
            // InternalAssembler.g:7155:4: (lv_directive_0_0= 'ORG' )
            // InternalAssembler.g:7156:5: lv_directive_0_0= 'ORG'
            {
            lv_directive_0_0=(Token)match(input,123,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getOrgDirectiveAccess().getDirectiveORGKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOrgDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "ORG");
              				
            }

            }


            }

            // InternalAssembler.g:7168:3: (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_WS) ) {
                int LA105_1 = input.LA(2);

                if ( ((LA105_1>=RULE_ID && LA105_1<=RULE_CHARACTER)||LA105_1==101||LA105_1==103||LA105_1==115||(LA105_1>=132 && LA105_1<=133)) ) {
                    alt105=1;
                }
            }
            switch (alt105) {
                case 1 :
                    // InternalAssembler.g:7169:4: this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:7173:4: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==115) ) {
                        int LA104_1 = input.LA(2);

                        if ( ((LA104_1>=RULE_ID && LA104_1<=RULE_CHARACTER)||LA104_1==101||LA104_1==103||(LA104_1>=132 && LA104_1<=133)) ) {
                            alt104=1;
                        }
                        else if ( (LA104_1==EOF||LA104_1==RULE_WS||(LA104_1>=RULE_CR && LA104_1<=RULE_END_OF_FILE)) ) {
                            alt104=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 104, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA104_0>=RULE_ID && LA104_0<=RULE_CHARACTER)||LA104_0==101||LA104_0==103||(LA104_0>=132 && LA104_0<=133)) ) {
                        alt104=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 104, 0, input);

                        throw nvae;
                    }
                    switch (alt104) {
                        case 1 :
                            // InternalAssembler.g:7174:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:7174:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            // InternalAssembler.g:7175:6: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:7175:6: ( (lv_isRelativeToPC_2_0= '*' ) )?
                            int alt103=2;
                            int LA103_0 = input.LA(1);

                            if ( (LA103_0==115) ) {
                                alt103=1;
                            }
                            switch (alt103) {
                                case 1 :
                                    // InternalAssembler.g:7176:7: (lv_isRelativeToPC_2_0= '*' )
                                    {
                                    // InternalAssembler.g:7176:7: (lv_isRelativeToPC_2_0= '*' )
                                    // InternalAssembler.g:7177:8: lv_isRelativeToPC_2_0= '*'
                                    {
                                    lv_isRelativeToPC_2_0=(Token)match(input,115,FOLLOW_14); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(lv_isRelativeToPC_2_0, grammarAccess.getOrgDirectiveAccess().getIsRelativeToPCAsteriskKeyword_1_1_0_0_0());
                                      							
                                    }
                                    if ( state.backtracking==0 ) {

                                      								if (current==null) {
                                      									current = createModelElement(grammarAccess.getOrgDirectiveRule());
                                      								}
                                      								setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_2_0 != null, "*");
                                      							
                                    }

                                    }


                                    }
                                    break;

                            }

                            // InternalAssembler.g:7189:6: ( (lv_operand_3_0= ruleExpression ) )
                            // InternalAssembler.g:7190:7: (lv_operand_3_0= ruleExpression )
                            {
                            // InternalAssembler.g:7190:7: (lv_operand_3_0= ruleExpression )
                            // InternalAssembler.g:7191:8: lv_operand_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getOrgDirectiveAccess().getOperandExpressionParserRuleCall_1_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_operand_3_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getOrgDirectiveRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_3_0,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:7210:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            {
                            // InternalAssembler.g:7210:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            // InternalAssembler.g:7211:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:7211:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:7212:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getOrgDirectiveAccess().getIsRelativeToPCAsteriskKeyword_1_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getOrgDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrgDirective"


    // $ANTLR start "entryRuleEquDirective"
    // InternalAssembler.g:7230:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:7230:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:7231:2: iv_ruleEquDirective= ruleEquDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEquDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquDirective=ruleEquDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquDirective"


    // $ANTLR start "ruleEquDirective"
    // InternalAssembler.g:7237:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) ;
    public final EObject ruleEquDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7243:2: ( ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) )
            // InternalAssembler.g:7244:2: ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            {
            // InternalAssembler.g:7244:2: ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            // InternalAssembler.g:7245:3: ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            {
            // InternalAssembler.g:7245:3: ( (lv_directive_0_0= 'EQU' ) )
            // InternalAssembler.g:7246:4: (lv_directive_0_0= 'EQU' )
            {
            // InternalAssembler.g:7246:4: (lv_directive_0_0= 'EQU' )
            // InternalAssembler.g:7247:5: lv_directive_0_0= 'EQU'
            {
            lv_directive_0_0=(Token)match(input,124,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_0_0, grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEquDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_0_0, "EQU");
              				
            }

            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:7263:3: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==115) ) {
                int LA107_1 = input.LA(2);

                if ( ((LA107_1>=RULE_ID && LA107_1<=RULE_CHARACTER)||LA107_1==101||LA107_1==103||(LA107_1>=132 && LA107_1<=133)) ) {
                    alt107=1;
                }
                else if ( (LA107_1==EOF||LA107_1==RULE_WS||(LA107_1>=RULE_CR && LA107_1<=RULE_END_OF_FILE)) ) {
                    alt107=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 107, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA107_0>=RULE_ID && LA107_0<=RULE_CHARACTER)||LA107_0==101||LA107_0==103||(LA107_0>=132 && LA107_0<=133)) ) {
                alt107=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // InternalAssembler.g:7264:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:7264:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:7265:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:7265:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==115) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // InternalAssembler.g:7266:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:7266:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:7267:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,115,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_2_0, grammarAccess.getEquDirectiveAccess().getIsRelativeToPCAsteriskKeyword_2_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEquDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_2_0 != null, "*");
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalAssembler.g:7279:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:7280:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:7280:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:7281:7: lv_operand_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getEquDirectiveAccess().getOperandExpressionParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getEquDirectiveRule());
                      							}
                      							set(
                      								current,
                      								"operand",
                      								lv_operand_3_0,
                      								"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:7300:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    {
                    // InternalAssembler.g:7300:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    // InternalAssembler.g:7301:5: (lv_isRelativeToPC_4_0= '*' )
                    {
                    // InternalAssembler.g:7301:5: (lv_isRelativeToPC_4_0= '*' )
                    // InternalAssembler.g:7302:6: lv_isRelativeToPC_4_0= '*'
                    {
                    lv_isRelativeToPC_4_0=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getEquDirectiveAccess().getIsRelativeToPCAsteriskKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEquDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquDirective"


    // $ANTLR start "entryRuleListOfExpression"
    // InternalAssembler.g:7319:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:7319:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:7320:2: iv_ruleListOfExpression= ruleListOfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListOfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListOfExpression=ruleListOfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListOfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListOfExpression"


    // $ANTLR start "ruleListOfExpression"
    // InternalAssembler.g:7326:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7332:2: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalAssembler.g:7333:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalAssembler.g:7333:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalAssembler.g:7334:3: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalAssembler.g:7334:3: ( (lv_expressions_0_0= ruleExpression ) )
            // InternalAssembler.g:7335:4: (lv_expressions_0_0= ruleExpression )
            {
            // InternalAssembler.g:7335:4: (lv_expressions_0_0= ruleExpression )
            // InternalAssembler.g:7336:5: lv_expressions_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_expressions_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getListOfExpressionRule());
              					}
              					add(
              						current,
              						"expressions",
              						lv_expressions_0_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAssembler.g:7353:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==19) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalAssembler.g:7354:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:7358:4: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalAssembler.g:7359:5: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalAssembler.g:7359:5: (lv_expressions_2_0= ruleExpression )
            	    // InternalAssembler.g:7360:6: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_expressions_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getListOfExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_2_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListOfExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalAssembler.g:7382:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:7382:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:7383:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalAssembler.g:7389:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7395:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:7396:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:7396:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:7397:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:7397:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:7398:4: lv_operand_0_0= ruleMultiplication
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getExpressionAccess().getOperandMultiplicationParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_operand_0_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getExpressionRule());
              				}
              				set(
              					current,
              					"operand",
              					lv_operand_0_0,
              					"org.bpy.electronics.mc6809.assembler.Assembler.Multiplication");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleMultiplication"
    // InternalAssembler.g:7418:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:7418:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:7419:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalAssembler.g:7425:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7431:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:7432:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:7432:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:7433:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_Division_0=ruleDivision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Division_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7441:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==115) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalAssembler.g:7442:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:7442:4: ()
            	    // InternalAssembler.g:7443:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:7449:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:7450:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:7450:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:7451:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,115,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_operation_2_0, grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getMultiplicationRule());
            	      						}
            	      						setWithLastConsumed(current, "operation", lv_operation_2_0, "*");
            	      					
            	    }

            	    }


            	    }

            	    // InternalAssembler.g:7463:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:7464:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:7464:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:7465:6: lv_right_3_0= ruleDivision
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_right_3_0=ruleDivision();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.Division");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop109;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleDivision"
    // InternalAssembler.g:7487:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:7487:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:7488:2: iv_ruleDivision= ruleDivision EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDivisionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDivision=ruleDivision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDivision; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDivision"


    // $ANTLR start "ruleDivision"
    // InternalAssembler.g:7494:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7500:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:7501:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:7501:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:7502:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_Modulo_0=ruleModulo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Modulo_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7510:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==125) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalAssembler.g:7511:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:7511:4: ()
            	    // InternalAssembler.g:7512:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:7518:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:7519:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:7519:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:7520:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,125,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_opretation_2_0, grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getDivisionRule());
            	      						}
            	      						setWithLastConsumed(current, "opretation", lv_opretation_2_0, "/");
            	      					
            	    }

            	    }


            	    }

            	    // InternalAssembler.g:7532:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:7533:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:7533:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:7534:6: lv_right_3_0= ruleModulo
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_right_3_0=ruleModulo();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDivisionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.Modulo");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop110;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDivision"


    // $ANTLR start "entryRuleModulo"
    // InternalAssembler.g:7556:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:7556:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:7557:2: iv_ruleModulo= ruleModulo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuloRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModulo=ruleModulo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModulo; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModulo"


    // $ANTLR start "ruleModulo"
    // InternalAssembler.g:7563:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7569:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:7570:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:7570:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:7571:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_30);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7579:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==126) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // InternalAssembler.g:7580:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:7580:4: ()
            	    // InternalAssembler.g:7581:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:7587:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:7588:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:7588:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:7589:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,126,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_opretation_2_0, grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getModuloRule());
            	      						}
            	      						setWithLastConsumed(current, "opretation", lv_opretation_2_0, "%");
            	      					
            	    }

            	    }


            	    }

            	    // InternalAssembler.g:7601:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:7602:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:7602:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:7603:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_right_3_0=ruleAddition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getModuloRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.Addition");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop111;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModulo"


    // $ANTLR start "entryRuleAddition"
    // InternalAssembler.g:7625:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:7625:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:7626:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalAssembler.g:7632:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7638:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:7639:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:7639:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:7640:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_Substraction_0=ruleSubstraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Substraction_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7648:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==103) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // InternalAssembler.g:7649:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:7649:4: ()
            	    // InternalAssembler.g:7650:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,103,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:7660:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:7661:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:7661:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:7662:6: lv_right_3_0= ruleSubstraction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_right_3_0=ruleSubstraction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.Substraction");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop112;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleSubstraction"
    // InternalAssembler.g:7684:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:7684:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:7685:2: iv_ruleSubstraction= ruleSubstraction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubstractionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSubstraction=ruleSubstraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubstraction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubstraction"


    // $ANTLR start "ruleSubstraction"
    // InternalAssembler.g:7691:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7697:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:7698:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:7698:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:7699:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_32);
            this_LeftShift_0=ruleLeftShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LeftShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7707:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==101) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalAssembler.g:7708:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:7708:4: ()
            	    // InternalAssembler.g:7709:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:7715:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:7716:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,101,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:7722:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:7723:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:7723:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:7724:6: lv_right_3_0= ruleLeftShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_right_3_0=ruleLeftShift();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSubstractionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.LeftShift");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop113;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubstraction"


    // $ANTLR start "entryRuleLeftShift"
    // InternalAssembler.g:7746:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:7746:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:7747:2: iv_ruleLeftShift= ruleLeftShift EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLeftShiftRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLeftShift=ruleLeftShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLeftShift; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLeftShift"


    // $ANTLR start "ruleLeftShift"
    // InternalAssembler.g:7753:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7759:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:7760:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:7760:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:7761:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLeftShiftAccess().getRightShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_33);
            this_RightShift_0=ruleRightShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RightShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7769:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==127) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalAssembler.g:7770:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:7770:4: ()
            	    // InternalAssembler.g:7771:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,127,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:7781:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:7782:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:7782:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:7783:6: lv_right_3_0= ruleRightShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLeftShiftAccess().getRightRightShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_right_3_0=ruleRightShift();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLeftShiftRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.RightShift");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop114;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLeftShift"


    // $ANTLR start "entryRuleRightShift"
    // InternalAssembler.g:7805:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:7805:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:7806:2: iv_ruleRightShift= ruleRightShift EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRightShiftRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRightShift=ruleRightShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRightShift; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRightShift"


    // $ANTLR start "ruleRightShift"
    // InternalAssembler.g:7812:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7818:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:7819:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:7819:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:7820:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRightShiftAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_34);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7828:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==128) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // InternalAssembler.g:7829:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:7829:4: ()
            	    // InternalAssembler.g:7830:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,128,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:7840:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:7841:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:7841:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:7842:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRightShiftAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRightShiftRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.And");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop115;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRightShift"


    // $ANTLR start "entryRuleAnd"
    // InternalAssembler.g:7864:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:7864:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:7865:2: iv_ruleAnd= ruleAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalAssembler.g:7871:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7877:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:7878:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:7878:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:7879:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getOrParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Or_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7887:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==129) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // InternalAssembler.g:7888:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:7888:4: ()
            	    // InternalAssembler.g:7889:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,129,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:7899:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:7900:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:7900:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:7901:6: lv_right_3_0= ruleOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_right_3_0=ruleOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.Or");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop116;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleOr"
    // InternalAssembler.g:7923:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:7923:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:7924:2: iv_ruleOr= ruleOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalAssembler.g:7930:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7936:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:7937:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:7937:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:7938:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getXorParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_36);
            this_Xor_0=ruleXor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Xor_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:7946:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==130) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // InternalAssembler.g:7947:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:7947:4: ()
            	    // InternalAssembler.g:7948:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,130,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:7958:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:7959:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:7959:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:7960:6: lv_right_3_0= ruleXor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_right_3_0=ruleXor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.Xor");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop117;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleXor"
    // InternalAssembler.g:7982:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:7982:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:7983:2: iv_ruleXor= ruleXor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXor=ruleXor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXor; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXor"


    // $ANTLR start "ruleXor"
    // InternalAssembler.g:7989:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:7995:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:7996:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:7996:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:7997:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_37);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:8005:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==131) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // InternalAssembler.g:8006:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:8006:4: ()
            	    // InternalAssembler.g:8007:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,131,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:8017:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:8018:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:8018:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:8019:6: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXorRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.Primary");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRulePrimary"
    // InternalAssembler.g:8041:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:8041:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:8042:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalAssembler.g:8048:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_value_0_0 = null;

        EObject lv_value_1_0 = null;

        EObject lv_value_2_0 = null;

        EObject lv_value_3_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_value_5_0 = null;

        EObject lv_value_8_0 = null;

        EObject this_Multiplication_10 = null;



        	enterRule();

        try {
            // InternalAssembler.g:8054:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:8055:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:8055:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt119=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 101:
            case 103:
                {
                alt119=1;
                }
                break;
            case RULE_HEXA:
                {
                alt119=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt119=3;
                }
                break;
            case RULE_BINARY:
                {
                alt119=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt119=5;
                }
                break;
            case RULE_ID:
                {
                alt119=6;
                }
                break;
            case 132:
                {
                alt119=7;
                }
                break;
            case 133:
                {
                alt119=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // InternalAssembler.g:8056:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:8056:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:8057:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:8057:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:8058:5: lv_value_0_0= ruleDecimalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryAccess().getValueDecimalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=ruleDecimalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.DecimalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:8076:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:8076:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:8077:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:8077:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:8078:5: lv_value_1_0= ruleHexaDecimalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryAccess().getValueHexaDecimalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleHexaDecimalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.HexaDecimalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:8096:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:8096:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:8097:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:8097:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:8098:5: lv_value_2_0= ruleOctalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryAccess().getValueOctalValueParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleOctalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_2_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.OctalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:8116:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:8116:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:8117:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:8117:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:8118:5: lv_value_3_0= ruleBinaryValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryAccess().getValueBinaryValueParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleBinaryValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_3_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.BinaryValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:8136:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:8136:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:8137:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:8137:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:8138:5: lv_value_4_0= ruleCharacterValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryAccess().getValueCharacterValueParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleCharacterValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_4_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.CharacterValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:8156:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:8156:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:8157:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:8157:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:8158:5: lv_value_5_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryAccess().getValueIdentifierValueParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_5_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.IdentifierValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:8176:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:8176:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:8177:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:8177:4: ()
                    // InternalAssembler.g:8178:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,132,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:8188:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:8189:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:8189:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:8190:6: lv_value_8_0= rulePrimary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryAccess().getValuePrimaryParserRuleCall_6_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_8_0=rulePrimary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_8_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.Primary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:8209:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:8209:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:8210:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,133,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_38);
                    this_Multiplication_10=ruleMultiplication();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Multiplication_10;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_11=(Token)match(input,134,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_7_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleNumericalValue"
    // InternalAssembler.g:8231:1: entryRuleNumericalValue returns [EObject current=null] : iv_ruleNumericalValue= ruleNumericalValue EOF ;
    public final EObject entryRuleNumericalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalValue = null;


        try {
            // InternalAssembler.g:8231:55: (iv_ruleNumericalValue= ruleNumericalValue EOF )
            // InternalAssembler.g:8232:2: iv_ruleNumericalValue= ruleNumericalValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumericalValue=ruleNumericalValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalValue"


    // $ANTLR start "ruleNumericalValue"
    // InternalAssembler.g:8238:1: ruleNumericalValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) ;
    public final EObject ruleNumericalValue() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;

        EObject lv_value_1_0 = null;

        EObject lv_value_2_0 = null;

        EObject lv_value_3_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:8244:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:8245:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:8245:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            int alt120=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 101:
            case 103:
                {
                alt120=1;
                }
                break;
            case RULE_HEXA:
                {
                alt120=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt120=3;
                }
                break;
            case RULE_BINARY:
                {
                alt120=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt120=5;
                }
                break;
            case RULE_ID:
                {
                alt120=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }

            switch (alt120) {
                case 1 :
                    // InternalAssembler.g:8246:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:8246:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:8247:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:8247:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:8248:5: lv_value_0_0= ruleDecimalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNumericalValueAccess().getValueDecimalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=ruleDecimalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNumericalValueRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.DecimalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:8266:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:8266:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:8267:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:8267:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:8268:5: lv_value_1_0= ruleHexaDecimalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNumericalValueAccess().getValueHexaDecimalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleHexaDecimalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNumericalValueRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.HexaDecimalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:8286:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:8286:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:8287:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:8287:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:8288:5: lv_value_2_0= ruleOctalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNumericalValueAccess().getValueOctalValueParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleOctalValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNumericalValueRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_2_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.OctalValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:8306:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:8306:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:8307:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:8307:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:8308:5: lv_value_3_0= ruleBinaryValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNumericalValueAccess().getValueBinaryValueParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleBinaryValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNumericalValueRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_3_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.BinaryValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:8326:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:8326:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:8327:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:8327:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:8328:5: lv_value_4_0= ruleCharacterValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNumericalValueAccess().getValueCharacterValueParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleCharacterValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNumericalValueRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_4_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.CharacterValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:8346:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:8346:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:8347:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:8347:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:8348:5: lv_value_5_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNumericalValueAccess().getValueIdentifierValueParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNumericalValueRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_5_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.IdentifierValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalValue"


    // $ANTLR start "entryRuleIdentifierValue"
    // InternalAssembler.g:8369:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:8369:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:8370:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdentifierValue=ruleIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifierValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentifierValue"


    // $ANTLR start "ruleIdentifierValue"
    // InternalAssembler.g:8376:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:8382:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:8383:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:8383:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:8384:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:8384:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:8385:4: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getIdentifierValueAccess().getValueIDTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getIdentifierValueRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.bpy.electronics.mc6809.assembler.Assembler.ID");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentifierValue"


    // $ANTLR start "entryRuleDecimalValue"
    // InternalAssembler.g:8404:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:8404:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:8405:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDecimalValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecimalValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecimalValue"


    // $ANTLR start "ruleDecimalValue"
    // InternalAssembler.g:8411:1: ruleDecimalValue returns [EObject current=null] : ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_sign_0_1=null;
        Token lv_sign_0_2=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:8417:2: ( ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:8418:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:8418:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:8419:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:8419:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==101||LA122_0==103) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalAssembler.g:8420:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    {
                    // InternalAssembler.g:8420:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    // InternalAssembler.g:8421:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    {
                    // InternalAssembler.g:8421:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    int alt121=2;
                    int LA121_0 = input.LA(1);

                    if ( (LA121_0==101) ) {
                        alt121=1;
                    }
                    else if ( (LA121_0==103) ) {
                        alt121=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 121, 0, input);

                        throw nvae;
                    }
                    switch (alt121) {
                        case 1 :
                            // InternalAssembler.g:8422:6: lv_sign_0_1= '-'
                            {
                            lv_sign_0_1=(Token)match(input,101,FOLLOW_39); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_sign_0_1, grammarAccess.getDecimalValueAccess().getSignHyphenMinusKeyword_0_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getDecimalValueRule());
                              						}
                              						setWithLastConsumed(current, "sign", lv_sign_0_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:8433:6: lv_sign_0_2= '+'
                            {
                            lv_sign_0_2=(Token)match(input,103,FOLLOW_39); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_sign_0_2, grammarAccess.getDecimalValueAccess().getSignPlusSignKeyword_0_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getDecimalValueRule());
                              						}
                              						setWithLastConsumed(current, "sign", lv_sign_0_2, null);
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:8446:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:8447:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:8447:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:8448:5: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getDecimalValueAccess().getValueINTTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDecimalValueRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.INT");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecimalValue"


    // $ANTLR start "entryRuleHexaDecimalValue"
    // InternalAssembler.g:8468:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:8468:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:8469:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHexaDecimalValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHexaDecimalValue=ruleHexaDecimalValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHexaDecimalValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHexaDecimalValue"


    // $ANTLR start "ruleHexaDecimalValue"
    // InternalAssembler.g:8475:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:8481:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:8482:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:8482:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:8483:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:8483:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:8484:4: lv_value_0_0= RULE_HEXA
            {
            lv_value_0_0=(Token)match(input,RULE_HEXA,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getHexaDecimalValueAccess().getValueHEXATerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getHexaDecimalValueRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.bpy.electronics.mc6809.assembler.Assembler.HEXA");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHexaDecimalValue"


    // $ANTLR start "entryRuleOctalValue"
    // InternalAssembler.g:8503:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:8503:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:8504:2: iv_ruleOctalValue= ruleOctalValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOctalValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOctalValue=ruleOctalValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOctalValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOctalValue"


    // $ANTLR start "ruleOctalValue"
    // InternalAssembler.g:8510:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:8516:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:8517:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:8517:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:8518:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:8518:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:8519:4: lv_value_0_0= RULE_OCTAL
            {
            lv_value_0_0=(Token)match(input,RULE_OCTAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getOctalValueAccess().getValueOCTALTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getOctalValueRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.bpy.electronics.mc6809.assembler.Assembler.OCTAL");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOctalValue"


    // $ANTLR start "entryRuleBinaryValue"
    // InternalAssembler.g:8538:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:8538:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:8539:2: iv_ruleBinaryValue= ruleBinaryValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBinaryValue=ruleBinaryValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryValue"


    // $ANTLR start "ruleBinaryValue"
    // InternalAssembler.g:8545:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:8551:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:8552:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:8552:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:8553:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:8553:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:8554:4: lv_value_0_0= RULE_BINARY
            {
            lv_value_0_0=(Token)match(input,RULE_BINARY,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getBinaryValueAccess().getValueBINARYTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBinaryValueRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.bpy.electronics.mc6809.assembler.Assembler.BINARY");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryValue"


    // $ANTLR start "entryRuleCharacterValue"
    // InternalAssembler.g:8573:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:8573:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:8574:2: iv_ruleCharacterValue= ruleCharacterValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCharacterValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCharacterValue=ruleCharacterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCharacterValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCharacterValue"


    // $ANTLR start "ruleCharacterValue"
    // InternalAssembler.g:8580:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:8586:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:8587:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:8587:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:8588:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:8588:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:8589:4: lv_value_0_0= RULE_CHARACTER
            {
            lv_value_0_0=(Token)match(input,RULE_CHARACTER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getCharacterValueAccess().getValueCHARACTERTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getCharacterValueRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.bpy.electronics.mc6809.assembler.Assembler.CHARACTER");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCharacterValue"


    // $ANTLR start "entryRuleEndOfLine"
    // InternalAssembler.g:8608:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:8608:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:8609:2: iv_ruleEndOfLine= ruleEndOfLine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEndOfLineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEndOfLine=ruleEndOfLine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEndOfLine.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndOfLine"


    // $ANTLR start "ruleEndOfLine"
    // InternalAssembler.g:8615:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:8621:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:8622:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:8622:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==RULE_CR) ) {
                alt123=1;
            }
            else if ( (LA123_0==RULE_END_OF_FILE) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalAssembler.g:8623:3: this_CR_0= RULE_CR
                    {
                    this_CR_0=(Token)match(input,RULE_CR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_CR_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_CR_0, grammarAccess.getEndOfLineAccess().getCRTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:8631:3: this_END_OF_FILE_1= RULE_END_OF_FILE
                    {
                    this_END_OF_FILE_1=(Token)match(input,RULE_END_OF_FILE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_END_OF_FILE_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_END_OF_FILE_1, grammarAccess.getEndOfLineAccess().getEND_OF_FILETerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndOfLine"


    // $ANTLR start "ruleAssemblyOption"
    // InternalAssembler.g:8642:1: ruleAssemblyOption returns [Enumerator current=null] : ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) ;
    public final Enumerator ruleAssemblyOption() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalAssembler.g:8648:2: ( ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) )
            // InternalAssembler.g:8649:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            {
            // InternalAssembler.g:8649:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            int alt124=8;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt124=1;
                }
                break;
            case 135:
                {
                alt124=2;
                }
                break;
            case 136:
                {
                alt124=3;
                }
                break;
            case 137:
                {
                alt124=4;
                }
                break;
            case 138:
                {
                alt124=5;
                }
                break;
            case 139:
                {
                alt124=6;
                }
                break;
            case 140:
                {
                alt124=7;
                }
                break;
            case 141:
                {
                alt124=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }

            switch (alt124) {
                case 1 :
                    // InternalAssembler.g:8650:3: (enumLiteral_0= 'PAG' )
                    {
                    // InternalAssembler.g:8650:3: (enumLiteral_0= 'PAG' )
                    // InternalAssembler.g:8651:4: enumLiteral_0= 'PAG'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:8658:3: (enumLiteral_1= 'NOP' )
                    {
                    // InternalAssembler.g:8658:3: (enumLiteral_1= 'NOP' )
                    // InternalAssembler.g:8659:4: enumLiteral_1= 'NOP'
                    {
                    enumLiteral_1=(Token)match(input,135,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:8666:3: (enumLiteral_2= 'CON' )
                    {
                    // InternalAssembler.g:8666:3: (enumLiteral_2= 'CON' )
                    // InternalAssembler.g:8667:4: enumLiteral_2= 'CON'
                    {
                    enumLiteral_2=(Token)match(input,136,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:8674:3: (enumLiteral_3= 'NOC' )
                    {
                    // InternalAssembler.g:8674:3: (enumLiteral_3= 'NOC' )
                    // InternalAssembler.g:8675:4: enumLiteral_3= 'NOC'
                    {
                    enumLiteral_3=(Token)match(input,137,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:8682:3: (enumLiteral_4= 'MAC' )
                    {
                    // InternalAssembler.g:8682:3: (enumLiteral_4= 'MAC' )
                    // InternalAssembler.g:8683:4: enumLiteral_4= 'MAC'
                    {
                    enumLiteral_4=(Token)match(input,138,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:8690:3: (enumLiteral_5= 'NOM' )
                    {
                    // InternalAssembler.g:8690:3: (enumLiteral_5= 'NOM' )
                    // InternalAssembler.g:8691:4: enumLiteral_5= 'NOM'
                    {
                    enumLiteral_5=(Token)match(input,139,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:8698:3: (enumLiteral_6= 'EXP' )
                    {
                    // InternalAssembler.g:8698:3: (enumLiteral_6= 'EXP' )
                    // InternalAssembler.g:8699:4: enumLiteral_6= 'EXP'
                    {
                    enumLiteral_6=(Token)match(input,140,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:8706:3: (enumLiteral_7= 'NOE' )
                    {
                    // InternalAssembler.g:8706:3: (enumLiteral_7= 'NOE' )
                    // InternalAssembler.g:8707:4: enumLiteral_7= 'NOE'
                    {
                    enumLiteral_7=(Token)match(input,141,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssemblyOptionAccess().getNOEEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssemblyOption"


    // $ANTLR start "ruleRegister"
    // InternalAssembler.g:8717:1: ruleRegister returns [Enumerator current=null] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) ;
    public final Enumerator ruleRegister() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;


        	enterRule();

        try {
            // InternalAssembler.g:8723:2: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) )
            // InternalAssembler.g:8724:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            {
            // InternalAssembler.g:8724:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            int alt125=10;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt125=1;
                }
                break;
            case 99:
                {
                alt125=2;
                }
                break;
            case 100:
                {
                alt125=3;
                }
                break;
            case 96:
                {
                alt125=4;
                }
                break;
            case 97:
                {
                alt125=5;
                }
                break;
            case 95:
                {
                alt125=6;
                }
                break;
            case 94:
                {
                alt125=7;
                }
                break;
            case 142:
                {
                alt125=8;
                }
                break;
            case 143:
                {
                alt125=9;
                }
                break;
            case 144:
                {
                alt125=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // InternalAssembler.g:8725:3: (enumLiteral_0= 'A' )
                    {
                    // InternalAssembler.g:8725:3: (enumLiteral_0= 'A' )
                    // InternalAssembler.g:8726:4: enumLiteral_0= 'A'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:8733:3: (enumLiteral_1= 'B' )
                    {
                    // InternalAssembler.g:8733:3: (enumLiteral_1= 'B' )
                    // InternalAssembler.g:8734:4: enumLiteral_1= 'B'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:8741:3: (enumLiteral_2= 'D' )
                    {
                    // InternalAssembler.g:8741:3: (enumLiteral_2= 'D' )
                    // InternalAssembler.g:8742:4: enumLiteral_2= 'D'
                    {
                    enumLiteral_2=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:8749:3: (enumLiteral_3= 'X' )
                    {
                    // InternalAssembler.g:8749:3: (enumLiteral_3= 'X' )
                    // InternalAssembler.g:8750:4: enumLiteral_3= 'X'
                    {
                    enumLiteral_3=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:8757:3: (enumLiteral_4= 'Y' )
                    {
                    // InternalAssembler.g:8757:3: (enumLiteral_4= 'Y' )
                    // InternalAssembler.g:8758:4: enumLiteral_4= 'Y'
                    {
                    enumLiteral_4=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:8765:3: (enumLiteral_5= 'U' )
                    {
                    // InternalAssembler.g:8765:3: (enumLiteral_5= 'U' )
                    // InternalAssembler.g:8766:4: enumLiteral_5= 'U'
                    {
                    enumLiteral_5=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:8773:3: (enumLiteral_6= 'S' )
                    {
                    // InternalAssembler.g:8773:3: (enumLiteral_6= 'S' )
                    // InternalAssembler.g:8774:4: enumLiteral_6= 'S'
                    {
                    enumLiteral_6=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:8781:3: (enumLiteral_7= 'DP' )
                    {
                    // InternalAssembler.g:8781:3: (enumLiteral_7= 'DP' )
                    // InternalAssembler.g:8782:4: enumLiteral_7= 'DP'
                    {
                    enumLiteral_7=(Token)match(input,142,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:8789:3: (enumLiteral_8= 'CC' )
                    {
                    // InternalAssembler.g:8789:3: (enumLiteral_8= 'CC' )
                    // InternalAssembler.g:8790:4: enumLiteral_8= 'CC'
                    {
                    enumLiteral_8=(Token)match(input,143,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAssembler.g:8797:3: (enumLiteral_9= 'PC' )
                    {
                    // InternalAssembler.g:8797:3: (enumLiteral_9= 'PC' )
                    // InternalAssembler.g:8798:4: enumLiteral_9= 'PC'
                    {
                    enumLiteral_9=(Token)match(input,144,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getPCEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getRegisterAccess().getPCEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegister"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA58 dfa58 = new DFA58(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\4\uffff\6\14\14\uffff";
    static final String dfa_3s = "\1\7\1\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\23\1\uffff";
    static final String dfa_4s = "\1\u0085\1\uffff\2\10\6\u0083\1\uffff\1\u0085\1\uffff\2\10\6\u0083\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\10\uffff\1\2\1\uffff\1\3\10\uffff\1\4";
    static final String dfa_6s = "\26\uffff}>";
    static final String[] dfa_7s = {
            "\1\11\1\4\1\5\1\6\1\7\1\10\6\uffff\1\12\105\uffff\1\13\1\uffff\1\14\1\1\5\uffff\3\12\1\2\1\uffff\1\3\34\uffff\2\14",
            "",
            "\1\4",
            "\1\4",
            "\1\14\10\uffff\2\14\4\uffff\1\12\121\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\4\uffff\1\12\121\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\4\uffff\1\12\121\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\4\uffff\1\12\121\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\4\uffff\1\12\121\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\4\uffff\1\12\121\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "",
            "\1\24\1\17\1\20\1\21\1\22\1\23\6\uffff\1\12\116\uffff\3\12\1\15\1\uffff\1\16\34\uffff\2\25",
            "",
            "\1\17",
            "\1\17",
            "\1\12\106\uffff\1\25\12\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\12\106\uffff\1\25\12\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\12\106\uffff\1\25\12\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\12\106\uffff\1\25\12\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\12\106\uffff\1\25\12\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\12\106\uffff\1\25\12\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1178:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_8s = "\27\uffff";
    static final String dfa_9s = "\5\uffff\6\15\14\uffff";
    static final String dfa_10s = "\1\7\2\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\23\1\uffff";
    static final String dfa_11s = "\1\u0085\2\uffff\2\10\6\u0083\1\uffff\1\u0085\1\uffff\2\10\6\u0083\1\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\10\uffff\1\3\1\uffff\1\4\10\uffff\1\5";
    static final String dfa_13s = "\27\uffff}>";
    static final String[] dfa_14s = {
            "\1\12\1\5\1\6\1\7\1\10\1\11\6\uffff\1\13\105\uffff\1\14\1\uffff\1\15\1\2\1\1\4\uffff\3\13\1\3\1\uffff\1\4\34\uffff\2\15",
            "",
            "",
            "\1\5",
            "\1\5",
            "\1\15\10\uffff\2\15\4\uffff\1\13\121\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\4\uffff\1\13\121\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\4\uffff\1\13\121\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\4\uffff\1\13\121\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\4\uffff\1\13\121\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\4\uffff\1\13\121\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "",
            "\1\25\1\20\1\21\1\22\1\23\1\24\6\uffff\1\13\116\uffff\3\13\1\16\1\uffff\1\17\34\uffff\2\26",
            "",
            "\1\20",
            "\1\20",
            "\1\13\106\uffff\1\26\12\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\13\106\uffff\1\26\12\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\13\106\uffff\1\26\12\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\13\106\uffff\1\26\12\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\13\106\uffff\1\26\12\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\13\106\uffff\1\26\12\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1377:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1528:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1751:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1871:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2022:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2957:5: (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3575:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3711:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3887:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4009:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4144:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4279:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_15s = "\44\uffff";
    static final String dfa_16s = "\15\uffff\4\34\23\uffff";
    static final String dfa_17s = "\1\7\2\10\6\23\1\136\1\uffff\1\7\1\uffff\4\4\1\uffff\2\10\6\23\1\136\2\uffff\4\132\3\uffff";
    static final String dfa_18s = "\1\147\2\10\6\23\1\151\1\uffff\1\147\1\uffff\4\150\1\uffff\2\10\6\23\1\151\2\uffff\4\150\3\uffff";
    static final String dfa_19s = "\12\uffff\1\3\1\uffff\1\1\4\uffff\1\4\11\uffff\1\7\1\2\4\uffff\1\6\1\10\1\5";
    static final String dfa_20s = "\44\uffff}>";
    static final String[] dfa_21s = {
            "\1\10\1\3\1\4\1\5\1\6\1\7\6\uffff\1\11\105\uffff\1\13\10\uffff\3\12\1\1\1\uffff\1\2",
            "\1\3",
            "\1\3",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\15\1\16\1\17\1\20\3\uffff\2\14\2\uffff\1\21",
            "",
            "\1\31\1\24\1\25\1\26\1\27\1\30\6\uffff\1\32\116\uffff\3\33\1\22\1\uffff\1\23",
            "",
            "\1\34\10\uffff\2\34\130\uffff\2\14",
            "\1\34\10\uffff\2\34\130\uffff\2\14",
            "\1\34\10\uffff\2\34\130\uffff\2\14",
            "\1\34\10\uffff\2\34\130\uffff\2\14",
            "",
            "\1\24",
            "\1\24",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\35\1\36\1\37\1\40\3\uffff\2\41\2\uffff\1\42",
            "",
            "",
            "\1\43\14\uffff\2\41",
            "\1\43\14\uffff\2\41",
            "\1\43\14\uffff\2\41",
            "\1\43\14\uffff\2\41",
            "",
            "",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "4585:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000060B2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xFFFFFFFFFFF78000L,0x0000000001FFFFFFL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000081F80L,0x000000BC1A000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000001FC0000000L,0x000000000001C000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000081F80L,0x000000BC3A000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000001F80L,0x000000A008000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x00000003C0000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000081F80L,0x000000A000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000001C00000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x00000063C0000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x1FF7FC0000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L,0x0000000000003F80L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000001F80L,0x000800A008000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x2000000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000100L});

}
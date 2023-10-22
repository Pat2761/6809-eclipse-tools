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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "'BVS'", "'LBVS'", "'BVC'", "'LBVC'", "'BSR'", "'LBSR'", "'BRN'", "'LBRN'", "'BRA'", "'LBRA'", "'BPL'", "'LBPL'", "'BNE'", "'LBNE'", "'BMI'", "'LBMI'", "'BLT'", "'LBLT'", "'BLS'", "'LBLS'", "'BLO'", "'LBLO'", "'BLE'", "'LBLE'", "'BIT'", "'BHS'", "'LBHS'", "'BHI'", "'LBHI'", "'BGT'", "'LBGT'", "'BGE'", "'LBGE'", "'BEQ'", "'LBEQ'", "'BCS'", "'LBCS'", "'BCC'", "'LBCC'", "'ASRA'", "'ASRB'", "'ASR'", "'ASLA'", "'ASLB'", "'ASL'", "'ANDCC'", "'ANDA'", "'ANDB'", "'ADDD'", "'ADDA'", "'ADDB'", "'ADCA'", "'ADCB'", "'ABX'", "'['", "']'", "'>'", "'<'", "'#'", "','", "'S'", "'U'", "'X'", "'Y'", "'A'", "'B'", "'D'", "'-'", "'--'", "'+'", "'++'", "'PCR'", "'FCC'", "'REG'", "'SPC'", "'NAM'", "'TTL'", "'PAG'", "'OPT'", "'FAIL'", "'SET'", "'*'", "'FILL'", "'BSZ'", "'ZMB'", "'FDB'", "'FCB'", "'RMB'", "'END'", "'ORG'", "'EQU'", "'/'", "'%'", "'<<'", "'>>'", "'&&'", "'||'", "'^'", "'!'", "'('", "')'", "'NOP'", "'CON'", "'NOC'", "'MAC'", "'NOM'", "'EXP'", "'NOE'", "'DP'", "'CC'", "'PC'"
    };
    public static final int T__50=50;
    public static final int RULE_CHARACTER=12;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=7;
    public static final int RULE_HEXA=9;
    public static final int RULE_INT=8;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__65=65;
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
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
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
                    {
                    alt2=4;
                    }
                    break;
                case RULE_CR:
                case RULE_END_OF_FILE:
                    {
                    alt2=1;
                    }
                    break;
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    {
                    alt2=3;
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

                    if ( ((LA2_7>=15 && LA2_7<=68)) ) {
                        alt2=4;
                    }
                    else if ( ((LA2_7>=87 && LA2_7<=95)||(LA2_7>=97 && LA2_7<=105)) ) {
                        alt2=3;
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
    // InternalAssembler.g:301:1: ruleInstructionLine returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) ) (this_WS_30= RULE_WS ( (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_32= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleInstructionLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_WS_30=null;
        Token lv_comment_31_0=null;
        Token this_WS_32=null;
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



        	enterRule();

        try {
            // InternalAssembler.g:307:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) ) (this_WS_30= RULE_WS ( (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_32= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) ) (this_WS_30= RULE_WS ( (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_32= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) ) (this_WS_30= RULE_WS ( (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_32= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:309:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) ) (this_WS_30= RULE_WS ( (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_32= RULE_WS )? ruleEndOfLine
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
            // InternalAssembler.g:332:3: ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) | ( (lv_instruction_17_0= ruleBitInstruction ) ) | ( (lv_instruction_18_0= ruleBleInstruction ) ) | ( (lv_instruction_19_0= ruleBloInstruction ) ) | ( (lv_instruction_20_0= ruleBlsInstruction ) ) | ( (lv_instruction_21_0= ruleBltInstruction ) ) | ( (lv_instruction_22_0= ruleBmiInstruction ) ) | ( (lv_instruction_23_0= ruleBneInstruction ) ) | ( (lv_instruction_24_0= ruleBplInstruction ) ) | ( (lv_instruction_25_0= ruleBraInstruction ) ) | ( (lv_instruction_26_0= ruleBrnInstruction ) ) | ( (lv_instruction_27_0= ruleBsrInstruction ) ) | ( (lv_instruction_28_0= ruleBvcInstruction ) ) | ( (lv_instruction_29_0= ruleBvsInstruction ) ) )
            int alt5=28;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt5=1;
                }
                break;
            case 66:
            case 67:
                {
                alt5=2;
                }
                break;
            case 64:
            case 65:
                {
                alt5=3;
                }
                break;
            case 63:
                {
                alt5=4;
                }
                break;
            case 61:
            case 62:
                {
                alt5=5;
                }
                break;
            case 60:
                {
                alt5=6;
                }
                break;
            case 57:
            case 58:
            case 59:
                {
                alt5=7;
                }
                break;
            case 54:
            case 55:
            case 56:
                {
                alt5=8;
                }
                break;
            case 52:
            case 53:
                {
                alt5=9;
                }
                break;
            case 50:
            case 51:
                {
                alt5=10;
                }
                break;
            case 48:
            case 49:
                {
                alt5=11;
                }
                break;
            case 46:
            case 47:
                {
                alt5=12;
                }
                break;
            case 44:
            case 45:
                {
                alt5=13;
                }
                break;
            case 42:
            case 43:
                {
                alt5=14;
                }
                break;
            case 40:
            case 41:
                {
                alt5=15;
                }
                break;
            case 39:
                {
                alt5=16;
                }
                break;
            case 37:
            case 38:
                {
                alt5=17;
                }
                break;
            case 35:
            case 36:
                {
                alt5=18;
                }
                break;
            case 33:
            case 34:
                {
                alt5=19;
                }
                break;
            case 31:
            case 32:
                {
                alt5=20;
                }
                break;
            case 29:
            case 30:
                {
                alt5=21;
                }
                break;
            case 27:
            case 28:
                {
                alt5=22;
                }
                break;
            case 25:
            case 26:
                {
                alt5=23;
                }
                break;
            case 23:
            case 24:
                {
                alt5=24;
                }
                break;
            case 21:
            case 22:
                {
                alt5=25;
                }
                break;
            case 19:
            case 20:
                {
                alt5=26;
                }
                break;
            case 17:
            case 18:
                {
                alt5=27;
                }
                break;
            case 15:
            case 16:
                {
                alt5=28;
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

            }

            // InternalAssembler.g:893:3: (this_WS_30= RULE_WS ( (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:894:4: this_WS_30= RULE_WS ( (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_30=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_30, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:898:4: ( (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:899:5: (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:899:5: (lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:900:6: lv_comment_31_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_31_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_31_0, grammarAccess.getInstructionLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getInstructionLineRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_31_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:917:3: (this_WS_32= RULE_WS )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:918:4: this_WS_32= RULE_WS
                    {
                    this_WS_32=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_32, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_4());
                      			
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


    // $ANTLR start "entryRuleBvsInstruction"
    // InternalAssembler.g:934:1: entryRuleBvsInstruction returns [EObject current=null] : iv_ruleBvsInstruction= ruleBvsInstruction EOF ;
    public final EObject entryRuleBvsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBvsInstruction = null;


        try {
            // InternalAssembler.g:934:55: (iv_ruleBvsInstruction= ruleBvsInstruction EOF )
            // InternalAssembler.g:935:2: iv_ruleBvsInstruction= ruleBvsInstruction EOF
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
    // InternalAssembler.g:941:1: ruleBvsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBvsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:947:2: ( ( ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:948:2: ( ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:948:2: ( ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:949:3: ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:949:3: ( ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) ) )
            // InternalAssembler.g:950:4: ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) )
            {
            // InternalAssembler.g:950:4: ( (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' ) )
            // InternalAssembler.g:951:5: (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' )
            {
            // InternalAssembler.g:951:5: (lv_instruction_0_1= 'BVS' | lv_instruction_0_2= 'LBVS' )
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
                    // InternalAssembler.g:952:6: lv_instruction_0_1= 'BVS'
                    {
                    lv_instruction_0_1=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:963:6: lv_instruction_0_2= 'LBVS'
                    {
                    lv_instruction_0_2=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBvsInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:980:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:981:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:981:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:982:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1003:1: entryRuleBvcInstruction returns [EObject current=null] : iv_ruleBvcInstruction= ruleBvcInstruction EOF ;
    public final EObject entryRuleBvcInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBvcInstruction = null;


        try {
            // InternalAssembler.g:1003:55: (iv_ruleBvcInstruction= ruleBvcInstruction EOF )
            // InternalAssembler.g:1004:2: iv_ruleBvcInstruction= ruleBvcInstruction EOF
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
    // InternalAssembler.g:1010:1: ruleBvcInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBvcInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1016:2: ( ( ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1017:2: ( ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1017:2: ( ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1018:3: ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1018:3: ( ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) ) )
            // InternalAssembler.g:1019:4: ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) )
            {
            // InternalAssembler.g:1019:4: ( (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' ) )
            // InternalAssembler.g:1020:5: (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' )
            {
            // InternalAssembler.g:1020:5: (lv_instruction_0_1= 'BVC' | lv_instruction_0_2= 'LBVC' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            else if ( (LA9_0==18) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:1021:6: lv_instruction_0_1= 'BVC'
                    {
                    lv_instruction_0_1=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1032:6: lv_instruction_0_2= 'LBVC'
                    {
                    lv_instruction_0_2=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBvcInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1049:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1050:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1050:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1051:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1072:1: entryRuleBsrInstruction returns [EObject current=null] : iv_ruleBsrInstruction= ruleBsrInstruction EOF ;
    public final EObject entryRuleBsrInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBsrInstruction = null;


        try {
            // InternalAssembler.g:1072:55: (iv_ruleBsrInstruction= ruleBsrInstruction EOF )
            // InternalAssembler.g:1073:2: iv_ruleBsrInstruction= ruleBsrInstruction EOF
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
    // InternalAssembler.g:1079:1: ruleBsrInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBsrInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1085:2: ( ( ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1086:2: ( ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1086:2: ( ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1087:3: ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1087:3: ( ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) ) )
            // InternalAssembler.g:1088:4: ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) )
            {
            // InternalAssembler.g:1088:4: ( (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' ) )
            // InternalAssembler.g:1089:5: (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' )
            {
            // InternalAssembler.g:1089:5: (lv_instruction_0_1= 'BSR' | lv_instruction_0_2= 'LBSR' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
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
                    // InternalAssembler.g:1090:6: lv_instruction_0_1= 'BSR'
                    {
                    lv_instruction_0_1=(Token)match(input,19,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1101:6: lv_instruction_0_2= 'LBSR'
                    {
                    lv_instruction_0_2=(Token)match(input,20,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBsrInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1118:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1119:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1119:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1120:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1141:1: entryRuleBrnInstruction returns [EObject current=null] : iv_ruleBrnInstruction= ruleBrnInstruction EOF ;
    public final EObject entryRuleBrnInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBrnInstruction = null;


        try {
            // InternalAssembler.g:1141:55: (iv_ruleBrnInstruction= ruleBrnInstruction EOF )
            // InternalAssembler.g:1142:2: iv_ruleBrnInstruction= ruleBrnInstruction EOF
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
    // InternalAssembler.g:1148:1: ruleBrnInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBrnInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1154:2: ( ( ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1155:2: ( ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1155:2: ( ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1156:3: ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1156:3: ( ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) ) )
            // InternalAssembler.g:1157:4: ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) )
            {
            // InternalAssembler.g:1157:4: ( (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' ) )
            // InternalAssembler.g:1158:5: (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' )
            {
            // InternalAssembler.g:1158:5: (lv_instruction_0_1= 'BRN' | lv_instruction_0_2= 'LBRN' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            else if ( (LA11_0==22) ) {
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
                    // InternalAssembler.g:1159:6: lv_instruction_0_1= 'BRN'
                    {
                    lv_instruction_0_1=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1170:6: lv_instruction_0_2= 'LBRN'
                    {
                    lv_instruction_0_2=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBrnInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1187:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1188:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1188:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1189:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1210:1: entryRuleBraInstruction returns [EObject current=null] : iv_ruleBraInstruction= ruleBraInstruction EOF ;
    public final EObject entryRuleBraInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBraInstruction = null;


        try {
            // InternalAssembler.g:1210:55: (iv_ruleBraInstruction= ruleBraInstruction EOF )
            // InternalAssembler.g:1211:2: iv_ruleBraInstruction= ruleBraInstruction EOF
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
    // InternalAssembler.g:1217:1: ruleBraInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBraInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1223:2: ( ( ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1224:2: ( ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1224:2: ( ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1225:3: ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1225:3: ( ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) ) )
            // InternalAssembler.g:1226:4: ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) )
            {
            // InternalAssembler.g:1226:4: ( (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' ) )
            // InternalAssembler.g:1227:5: (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' )
            {
            // InternalAssembler.g:1227:5: (lv_instruction_0_1= 'BRA' | lv_instruction_0_2= 'LBRA' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            else if ( (LA12_0==24) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalAssembler.g:1228:6: lv_instruction_0_1= 'BRA'
                    {
                    lv_instruction_0_1=(Token)match(input,23,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1239:6: lv_instruction_0_2= 'LBRA'
                    {
                    lv_instruction_0_2=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBraInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1256:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1257:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1257:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1258:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1279:1: entryRuleBplInstruction returns [EObject current=null] : iv_ruleBplInstruction= ruleBplInstruction EOF ;
    public final EObject entryRuleBplInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBplInstruction = null;


        try {
            // InternalAssembler.g:1279:55: (iv_ruleBplInstruction= ruleBplInstruction EOF )
            // InternalAssembler.g:1280:2: iv_ruleBplInstruction= ruleBplInstruction EOF
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
    // InternalAssembler.g:1286:1: ruleBplInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBplInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1292:2: ( ( ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1293:2: ( ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1293:2: ( ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1294:3: ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1294:3: ( ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) ) )
            // InternalAssembler.g:1295:4: ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) )
            {
            // InternalAssembler.g:1295:4: ( (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' ) )
            // InternalAssembler.g:1296:5: (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' )
            {
            // InternalAssembler.g:1296:5: (lv_instruction_0_1= 'BPL' | lv_instruction_0_2= 'LBPL' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            else if ( (LA13_0==26) ) {
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
                    // InternalAssembler.g:1297:6: lv_instruction_0_1= 'BPL'
                    {
                    lv_instruction_0_1=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1308:6: lv_instruction_0_2= 'LBPL'
                    {
                    lv_instruction_0_2=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBplInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1325:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1326:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1326:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1327:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1348:1: entryRuleBneInstruction returns [EObject current=null] : iv_ruleBneInstruction= ruleBneInstruction EOF ;
    public final EObject entryRuleBneInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBneInstruction = null;


        try {
            // InternalAssembler.g:1348:55: (iv_ruleBneInstruction= ruleBneInstruction EOF )
            // InternalAssembler.g:1349:2: iv_ruleBneInstruction= ruleBneInstruction EOF
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
    // InternalAssembler.g:1355:1: ruleBneInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBneInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1361:2: ( ( ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1362:2: ( ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1362:2: ( ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1363:3: ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1363:3: ( ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) ) )
            // InternalAssembler.g:1364:4: ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) )
            {
            // InternalAssembler.g:1364:4: ( (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' ) )
            // InternalAssembler.g:1365:5: (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' )
            {
            // InternalAssembler.g:1365:5: (lv_instruction_0_1= 'BNE' | lv_instruction_0_2= 'LBNE' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            else if ( (LA14_0==28) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalAssembler.g:1366:6: lv_instruction_0_1= 'BNE'
                    {
                    lv_instruction_0_1=(Token)match(input,27,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1377:6: lv_instruction_0_2= 'LBNE'
                    {
                    lv_instruction_0_2=(Token)match(input,28,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBneInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1394:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1395:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1395:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1396:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1417:1: entryRuleBmiInstruction returns [EObject current=null] : iv_ruleBmiInstruction= ruleBmiInstruction EOF ;
    public final EObject entryRuleBmiInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBmiInstruction = null;


        try {
            // InternalAssembler.g:1417:55: (iv_ruleBmiInstruction= ruleBmiInstruction EOF )
            // InternalAssembler.g:1418:2: iv_ruleBmiInstruction= ruleBmiInstruction EOF
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
    // InternalAssembler.g:1424:1: ruleBmiInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBmiInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1430:2: ( ( ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1431:2: ( ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1431:2: ( ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1432:3: ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1432:3: ( ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) ) )
            // InternalAssembler.g:1433:4: ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) )
            {
            // InternalAssembler.g:1433:4: ( (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' ) )
            // InternalAssembler.g:1434:5: (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' )
            {
            // InternalAssembler.g:1434:5: (lv_instruction_0_1= 'BMI' | lv_instruction_0_2= 'LBMI' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==29) ) {
                alt15=1;
            }
            else if ( (LA15_0==30) ) {
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
                    // InternalAssembler.g:1435:6: lv_instruction_0_1= 'BMI'
                    {
                    lv_instruction_0_1=(Token)match(input,29,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1446:6: lv_instruction_0_2= 'LBMI'
                    {
                    lv_instruction_0_2=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBmiInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1463:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1464:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1464:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1465:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1486:1: entryRuleBltInstruction returns [EObject current=null] : iv_ruleBltInstruction= ruleBltInstruction EOF ;
    public final EObject entryRuleBltInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBltInstruction = null;


        try {
            // InternalAssembler.g:1486:55: (iv_ruleBltInstruction= ruleBltInstruction EOF )
            // InternalAssembler.g:1487:2: iv_ruleBltInstruction= ruleBltInstruction EOF
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
    // InternalAssembler.g:1493:1: ruleBltInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBltInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1499:2: ( ( ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1500:2: ( ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1500:2: ( ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1501:3: ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1501:3: ( ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) ) )
            // InternalAssembler.g:1502:4: ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) )
            {
            // InternalAssembler.g:1502:4: ( (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' ) )
            // InternalAssembler.g:1503:5: (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' )
            {
            // InternalAssembler.g:1503:5: (lv_instruction_0_1= 'BLT' | lv_instruction_0_2= 'LBLT' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==31) ) {
                alt16=1;
            }
            else if ( (LA16_0==32) ) {
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
                    // InternalAssembler.g:1504:6: lv_instruction_0_1= 'BLT'
                    {
                    lv_instruction_0_1=(Token)match(input,31,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1515:6: lv_instruction_0_2= 'LBLT'
                    {
                    lv_instruction_0_2=(Token)match(input,32,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBltInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1532:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1533:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1533:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1534:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1555:1: entryRuleBlsInstruction returns [EObject current=null] : iv_ruleBlsInstruction= ruleBlsInstruction EOF ;
    public final EObject entryRuleBlsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlsInstruction = null;


        try {
            // InternalAssembler.g:1555:55: (iv_ruleBlsInstruction= ruleBlsInstruction EOF )
            // InternalAssembler.g:1556:2: iv_ruleBlsInstruction= ruleBlsInstruction EOF
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
    // InternalAssembler.g:1562:1: ruleBlsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBlsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1568:2: ( ( ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1569:2: ( ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1569:2: ( ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1570:3: ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1570:3: ( ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) ) )
            // InternalAssembler.g:1571:4: ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) )
            {
            // InternalAssembler.g:1571:4: ( (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' ) )
            // InternalAssembler.g:1572:5: (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' )
            {
            // InternalAssembler.g:1572:5: (lv_instruction_0_1= 'BLS' | lv_instruction_0_2= 'LBLS' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            else if ( (LA17_0==34) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalAssembler.g:1573:6: lv_instruction_0_1= 'BLS'
                    {
                    lv_instruction_0_1=(Token)match(input,33,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1584:6: lv_instruction_0_2= 'LBLS'
                    {
                    lv_instruction_0_2=(Token)match(input,34,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBlsInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1601:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1602:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1602:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1603:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1624:1: entryRuleBloInstruction returns [EObject current=null] : iv_ruleBloInstruction= ruleBloInstruction EOF ;
    public final EObject entryRuleBloInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBloInstruction = null;


        try {
            // InternalAssembler.g:1624:55: (iv_ruleBloInstruction= ruleBloInstruction EOF )
            // InternalAssembler.g:1625:2: iv_ruleBloInstruction= ruleBloInstruction EOF
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
    // InternalAssembler.g:1631:1: ruleBloInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBloInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1637:2: ( ( ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1638:2: ( ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1638:2: ( ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1639:3: ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1639:3: ( ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) ) )
            // InternalAssembler.g:1640:4: ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) )
            {
            // InternalAssembler.g:1640:4: ( (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' ) )
            // InternalAssembler.g:1641:5: (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' )
            {
            // InternalAssembler.g:1641:5: (lv_instruction_0_1= 'BLO' | lv_instruction_0_2= 'LBLO' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==35) ) {
                alt18=1;
            }
            else if ( (LA18_0==36) ) {
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
                    // InternalAssembler.g:1642:6: lv_instruction_0_1= 'BLO'
                    {
                    lv_instruction_0_1=(Token)match(input,35,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1653:6: lv_instruction_0_2= 'LBLO'
                    {
                    lv_instruction_0_2=(Token)match(input,36,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBloInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1670:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1671:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1671:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1672:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1693:1: entryRuleBleInstruction returns [EObject current=null] : iv_ruleBleInstruction= ruleBleInstruction EOF ;
    public final EObject entryRuleBleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBleInstruction = null;


        try {
            // InternalAssembler.g:1693:55: (iv_ruleBleInstruction= ruleBleInstruction EOF )
            // InternalAssembler.g:1694:2: iv_ruleBleInstruction= ruleBleInstruction EOF
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
    // InternalAssembler.g:1700:1: ruleBleInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1706:2: ( ( ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1707:2: ( ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1707:2: ( ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1708:3: ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1708:3: ( ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) ) )
            // InternalAssembler.g:1709:4: ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) )
            {
            // InternalAssembler.g:1709:4: ( (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' ) )
            // InternalAssembler.g:1710:5: (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' )
            {
            // InternalAssembler.g:1710:5: (lv_instruction_0_1= 'BLE' | lv_instruction_0_2= 'LBLE' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            else if ( (LA19_0==38) ) {
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
                    // InternalAssembler.g:1711:6: lv_instruction_0_1= 'BLE'
                    {
                    lv_instruction_0_1=(Token)match(input,37,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1722:6: lv_instruction_0_2= 'LBLE'
                    {
                    lv_instruction_0_2=(Token)match(input,38,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBleInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1739:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1740:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1740:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1741:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1762:1: entryRuleBitInstruction returns [EObject current=null] : iv_ruleBitInstruction= ruleBitInstruction EOF ;
    public final EObject entryRuleBitInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitInstruction = null;


        try {
            // InternalAssembler.g:1762:55: (iv_ruleBitInstruction= ruleBitInstruction EOF )
            // InternalAssembler.g:1763:2: iv_ruleBitInstruction= ruleBitInstruction EOF
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
    // InternalAssembler.g:1769:1: ruleBitInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:1775:2: ( ( ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1776:2: ( ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1776:2: ( ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1777:3: ( (lv_instruction_0_0= 'BIT' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1777:3: ( (lv_instruction_0_0= 'BIT' ) )
            // InternalAssembler.g:1778:4: (lv_instruction_0_0= 'BIT' )
            {
            // InternalAssembler.g:1778:4: (lv_instruction_0_0= 'BIT' )
            // InternalAssembler.g:1779:5: lv_instruction_0_0= 'BIT'
            {
            lv_instruction_0_0=(Token)match(input,39,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBitInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1795:3: ( ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1796:4: ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1796:4: ( (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1797:5: (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1797:5: (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand )
            int alt20=4;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1798:6: lv_operand_2_1= ruleDirectOperand
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
                    // InternalAssembler.g:1814:6: lv_operand_2_2= ruleIndexedOperand
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
                    // InternalAssembler.g:1830:6: lv_operand_2_3= ruleExtendedOperand
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
                    // InternalAssembler.g:1846:6: lv_operand_2_4= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1868:1: entryRuleBhsInstruction returns [EObject current=null] : iv_ruleBhsInstruction= ruleBhsInstruction EOF ;
    public final EObject entryRuleBhsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBhsInstruction = null;


        try {
            // InternalAssembler.g:1868:55: (iv_ruleBhsInstruction= ruleBhsInstruction EOF )
            // InternalAssembler.g:1869:2: iv_ruleBhsInstruction= ruleBhsInstruction EOF
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
    // InternalAssembler.g:1875:1: ruleBhsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBhsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1881:2: ( ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1882:2: ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1882:2: ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1883:3: ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1883:3: ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) )
            // InternalAssembler.g:1884:4: ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) )
            {
            // InternalAssembler.g:1884:4: ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) )
            // InternalAssembler.g:1885:5: (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' )
            {
            // InternalAssembler.g:1885:5: (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==40) ) {
                alt21=1;
            }
            else if ( (LA21_0==41) ) {
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
                    // InternalAssembler.g:1886:6: lv_instruction_0_1= 'BHS'
                    {
                    lv_instruction_0_1=(Token)match(input,40,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1897:6: lv_instruction_0_2= 'LBHS'
                    {
                    lv_instruction_0_2=(Token)match(input,41,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBhsInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1914:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1915:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1915:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1916:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1937:1: entryRuleBhiInstruction returns [EObject current=null] : iv_ruleBhiInstruction= ruleBhiInstruction EOF ;
    public final EObject entryRuleBhiInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBhiInstruction = null;


        try {
            // InternalAssembler.g:1937:55: (iv_ruleBhiInstruction= ruleBhiInstruction EOF )
            // InternalAssembler.g:1938:2: iv_ruleBhiInstruction= ruleBhiInstruction EOF
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
    // InternalAssembler.g:1944:1: ruleBhiInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBhiInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1950:2: ( ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1951:2: ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1951:2: ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1952:3: ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1952:3: ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) )
            // InternalAssembler.g:1953:4: ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) )
            {
            // InternalAssembler.g:1953:4: ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) )
            // InternalAssembler.g:1954:5: (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' )
            {
            // InternalAssembler.g:1954:5: (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==42) ) {
                alt22=1;
            }
            else if ( (LA22_0==43) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:1955:6: lv_instruction_0_1= 'BHI'
                    {
                    lv_instruction_0_1=(Token)match(input,42,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1966:6: lv_instruction_0_2= 'LBHI'
                    {
                    lv_instruction_0_2=(Token)match(input,43,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBhiInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1983:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1984:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1984:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1985:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:2006:1: entryRuleBgtInstruction returns [EObject current=null] : iv_ruleBgtInstruction= ruleBgtInstruction EOF ;
    public final EObject entryRuleBgtInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBgtInstruction = null;


        try {
            // InternalAssembler.g:2006:55: (iv_ruleBgtInstruction= ruleBgtInstruction EOF )
            // InternalAssembler.g:2007:2: iv_ruleBgtInstruction= ruleBgtInstruction EOF
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
    // InternalAssembler.g:2013:1: ruleBgtInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBgtInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2019:2: ( ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2020:2: ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2020:2: ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2021:3: ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2021:3: ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) )
            // InternalAssembler.g:2022:4: ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) )
            {
            // InternalAssembler.g:2022:4: ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) )
            // InternalAssembler.g:2023:5: (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' )
            {
            // InternalAssembler.g:2023:5: (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==44) ) {
                alt23=1;
            }
            else if ( (LA23_0==45) ) {
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
                    // InternalAssembler.g:2024:6: lv_instruction_0_1= 'BGT'
                    {
                    lv_instruction_0_1=(Token)match(input,44,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:2035:6: lv_instruction_0_2= 'LBGT'
                    {
                    lv_instruction_0_2=(Token)match(input,45,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBgtInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2052:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2053:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2053:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2054:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:2075:1: entryRuleBgeInstruction returns [EObject current=null] : iv_ruleBgeInstruction= ruleBgeInstruction EOF ;
    public final EObject entryRuleBgeInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBgeInstruction = null;


        try {
            // InternalAssembler.g:2075:55: (iv_ruleBgeInstruction= ruleBgeInstruction EOF )
            // InternalAssembler.g:2076:2: iv_ruleBgeInstruction= ruleBgeInstruction EOF
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
    // InternalAssembler.g:2082:1: ruleBgeInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBgeInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2088:2: ( ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2089:2: ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2089:2: ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2090:3: ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2090:3: ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) )
            // InternalAssembler.g:2091:4: ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) )
            {
            // InternalAssembler.g:2091:4: ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) )
            // InternalAssembler.g:2092:5: (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' )
            {
            // InternalAssembler.g:2092:5: (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==46) ) {
                alt24=1;
            }
            else if ( (LA24_0==47) ) {
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
                    // InternalAssembler.g:2093:6: lv_instruction_0_1= 'BGE'
                    {
                    lv_instruction_0_1=(Token)match(input,46,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:2104:6: lv_instruction_0_2= 'LBGE'
                    {
                    lv_instruction_0_2=(Token)match(input,47,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBgeInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2121:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2122:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2122:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2123:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:2144:1: entryRuleBeqInstruction returns [EObject current=null] : iv_ruleBeqInstruction= ruleBeqInstruction EOF ;
    public final EObject entryRuleBeqInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeqInstruction = null;


        try {
            // InternalAssembler.g:2144:55: (iv_ruleBeqInstruction= ruleBeqInstruction EOF )
            // InternalAssembler.g:2145:2: iv_ruleBeqInstruction= ruleBeqInstruction EOF
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
    // InternalAssembler.g:2151:1: ruleBeqInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBeqInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2157:2: ( ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2158:2: ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2158:2: ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2159:3: ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2159:3: ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) )
            // InternalAssembler.g:2160:4: ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) )
            {
            // InternalAssembler.g:2160:4: ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) )
            // InternalAssembler.g:2161:5: (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' )
            {
            // InternalAssembler.g:2161:5: (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==48) ) {
                alt25=1;
            }
            else if ( (LA25_0==49) ) {
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
                    // InternalAssembler.g:2162:6: lv_instruction_0_1= 'BEQ'
                    {
                    lv_instruction_0_1=(Token)match(input,48,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:2173:6: lv_instruction_0_2= 'LBEQ'
                    {
                    lv_instruction_0_2=(Token)match(input,49,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBeqInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2190:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2191:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2191:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2192:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:2213:1: entryRuleBcsInstruction returns [EObject current=null] : iv_ruleBcsInstruction= ruleBcsInstruction EOF ;
    public final EObject entryRuleBcsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBcsInstruction = null;


        try {
            // InternalAssembler.g:2213:55: (iv_ruleBcsInstruction= ruleBcsInstruction EOF )
            // InternalAssembler.g:2214:2: iv_ruleBcsInstruction= ruleBcsInstruction EOF
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
    // InternalAssembler.g:2220:1: ruleBcsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBcsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2226:2: ( ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2227:2: ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2227:2: ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2228:3: ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2228:3: ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) )
            // InternalAssembler.g:2229:4: ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) )
            {
            // InternalAssembler.g:2229:4: ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) )
            // InternalAssembler.g:2230:5: (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' )
            {
            // InternalAssembler.g:2230:5: (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==50) ) {
                alt26=1;
            }
            else if ( (LA26_0==51) ) {
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
                    // InternalAssembler.g:2231:6: lv_instruction_0_1= 'BCS'
                    {
                    lv_instruction_0_1=(Token)match(input,50,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:2242:6: lv_instruction_0_2= 'LBCS'
                    {
                    lv_instruction_0_2=(Token)match(input,51,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBcsInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2259:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2260:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2260:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2261:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:2282:1: entryRuleBccInstruction returns [EObject current=null] : iv_ruleBccInstruction= ruleBccInstruction EOF ;
    public final EObject entryRuleBccInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBccInstruction = null;


        try {
            // InternalAssembler.g:2282:55: (iv_ruleBccInstruction= ruleBccInstruction EOF )
            // InternalAssembler.g:2283:2: iv_ruleBccInstruction= ruleBccInstruction EOF
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
    // InternalAssembler.g:2289:1: ruleBccInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBccInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2295:2: ( ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:2296:2: ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:2296:2: ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:2297:3: ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:2297:3: ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) )
            // InternalAssembler.g:2298:4: ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) )
            {
            // InternalAssembler.g:2298:4: ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) )
            // InternalAssembler.g:2299:5: (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' )
            {
            // InternalAssembler.g:2299:5: (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==52) ) {
                alt27=1;
            }
            else if ( (LA27_0==53) ) {
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
                    // InternalAssembler.g:2300:6: lv_instruction_0_1= 'BCC'
                    {
                    lv_instruction_0_1=(Token)match(input,52,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:2311:6: lv_instruction_0_2= 'LBCC'
                    {
                    lv_instruction_0_2=(Token)match(input,53,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBccInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2328:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:2329:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:2329:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:2330:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:2351:1: entryRuleAsrInstruction returns [EObject current=null] : iv_ruleAsrInstruction= ruleAsrInstruction EOF ;
    public final EObject entryRuleAsrInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsrInstruction = null;


        try {
            // InternalAssembler.g:2351:55: (iv_ruleAsrInstruction= ruleAsrInstruction EOF )
            // InternalAssembler.g:2352:2: iv_ruleAsrInstruction= ruleAsrInstruction EOF
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
    // InternalAssembler.g:2358:1: ruleAsrInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
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
            // InternalAssembler.g:2364:2: ( ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:2365:2: ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:2365:2: ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=54 && LA30_0<=55)) ) {
                alt30=1;
            }
            else if ( (LA30_0==56) ) {
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
                    // InternalAssembler.g:2366:3: ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) )
                    {
                    // InternalAssembler.g:2366:3: ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) )
                    // InternalAssembler.g:2367:4: ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) )
                    {
                    // InternalAssembler.g:2367:4: ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) )
                    // InternalAssembler.g:2368:5: (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' )
                    {
                    // InternalAssembler.g:2368:5: (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==54) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==55) ) {
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
                            // InternalAssembler.g:2369:6: lv_instruction_0_1= 'ASRA'
                            {
                            lv_instruction_0_1=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2380:6: lv_instruction_0_2= 'ASRB'
                            {
                            lv_instruction_0_2=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2394:3: ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:2394:3: ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:2395:4: ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:2395:4: ( (lv_instruction_1_0= 'ASR' ) )
                    // InternalAssembler.g:2396:5: (lv_instruction_1_0= 'ASR' )
                    {
                    // InternalAssembler.g:2396:5: (lv_instruction_1_0= 'ASR' )
                    // InternalAssembler.g:2397:6: lv_instruction_1_0= 'ASR'
                    {
                    lv_instruction_1_0=(Token)match(input,56,FOLLOW_5); if (state.failed) return current;
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

                    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_2, grammarAccess.getAsrInstructionAccess().getWSTerminalRuleCall_1_1());
                      			
                    }
                    // InternalAssembler.g:2413:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:2414:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:2414:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:2415:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:2415:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt29=4;
                    alt29 = dfa29.predict(input);
                    switch (alt29) {
                        case 1 :
                            // InternalAssembler.g:2416:7: lv_operand_3_1= ruleDirectOperand
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
                            // InternalAssembler.g:2432:7: lv_operand_3_2= ruleIndexedOperand
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
                            // InternalAssembler.g:2448:7: lv_operand_3_3= ruleExtendedOperand
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
                            // InternalAssembler.g:2464:7: lv_operand_3_4= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:2487:1: entryRuleAslInstruction returns [EObject current=null] : iv_ruleAslInstruction= ruleAslInstruction EOF ;
    public final EObject entryRuleAslInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAslInstruction = null;


        try {
            // InternalAssembler.g:2487:55: (iv_ruleAslInstruction= ruleAslInstruction EOF )
            // InternalAssembler.g:2488:2: iv_ruleAslInstruction= ruleAslInstruction EOF
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
    // InternalAssembler.g:2494:1: ruleAslInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
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
            // InternalAssembler.g:2500:2: ( ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:2501:2: ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:2501:2: ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=57 && LA33_0<=58)) ) {
                alt33=1;
            }
            else if ( (LA33_0==59) ) {
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
                    // InternalAssembler.g:2502:3: ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) )
                    {
                    // InternalAssembler.g:2502:3: ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) )
                    // InternalAssembler.g:2503:4: ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) )
                    {
                    // InternalAssembler.g:2503:4: ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) )
                    // InternalAssembler.g:2504:5: (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' )
                    {
                    // InternalAssembler.g:2504:5: (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==57) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==58) ) {
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
                            // InternalAssembler.g:2505:6: lv_instruction_0_1= 'ASLA'
                            {
                            lv_instruction_0_1=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2516:6: lv_instruction_0_2= 'ASLB'
                            {
                            lv_instruction_0_2=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2530:3: ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:2530:3: ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:2531:4: ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:2531:4: ( (lv_instruction_1_0= 'ASL' ) )
                    // InternalAssembler.g:2532:5: (lv_instruction_1_0= 'ASL' )
                    {
                    // InternalAssembler.g:2532:5: (lv_instruction_1_0= 'ASL' )
                    // InternalAssembler.g:2533:6: lv_instruction_1_0= 'ASL'
                    {
                    lv_instruction_1_0=(Token)match(input,59,FOLLOW_5); if (state.failed) return current;
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

                    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_2, grammarAccess.getAslInstructionAccess().getWSTerminalRuleCall_1_1());
                      			
                    }
                    // InternalAssembler.g:2549:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:2550:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:2550:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:2551:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:2551:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt32=4;
                    alt32 = dfa32.predict(input);
                    switch (alt32) {
                        case 1 :
                            // InternalAssembler.g:2552:7: lv_operand_3_1= ruleDirectOperand
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
                            // InternalAssembler.g:2568:7: lv_operand_3_2= ruleIndexedOperand
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
                            // InternalAssembler.g:2584:7: lv_operand_3_3= ruleExtendedOperand
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
                            // InternalAssembler.g:2600:7: lv_operand_3_4= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:2623:1: entryRuleAndCCInstruction returns [EObject current=null] : iv_ruleAndCCInstruction= ruleAndCCInstruction EOF ;
    public final EObject entryRuleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndCCInstruction = null;


        try {
            // InternalAssembler.g:2623:57: (iv_ruleAndCCInstruction= ruleAndCCInstruction EOF )
            // InternalAssembler.g:2624:2: iv_ruleAndCCInstruction= ruleAndCCInstruction EOF
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
    // InternalAssembler.g:2630:1: ruleAndCCInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) ;
    public final EObject ruleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2636:2: ( ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) )
            // InternalAssembler.g:2637:2: ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            {
            // InternalAssembler.g:2637:2: ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            // InternalAssembler.g:2638:3: ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) )
            {
            // InternalAssembler.g:2638:3: ( (lv_instruction_0_0= 'ANDCC' ) )
            // InternalAssembler.g:2639:4: (lv_instruction_0_0= 'ANDCC' )
            {
            // InternalAssembler.g:2639:4: (lv_instruction_0_0= 'ANDCC' )
            // InternalAssembler.g:2640:5: lv_instruction_0_0= 'ANDCC'
            {
            lv_instruction_0_0=(Token)match(input,60,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAndCCInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2656:3: ( (lv_operand_2_0= ruleImmediatOperand ) )
            // InternalAssembler.g:2657:4: (lv_operand_2_0= ruleImmediatOperand )
            {
            // InternalAssembler.g:2657:4: (lv_operand_2_0= ruleImmediatOperand )
            // InternalAssembler.g:2658:5: lv_operand_2_0= ruleImmediatOperand
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
    // InternalAssembler.g:2679:1: entryRuleAndInstruction returns [EObject current=null] : iv_ruleAndInstruction= ruleAndInstruction EOF ;
    public final EObject entryRuleAndInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndInstruction = null;


        try {
            // InternalAssembler.g:2679:55: (iv_ruleAndInstruction= ruleAndInstruction EOF )
            // InternalAssembler.g:2680:2: iv_ruleAndInstruction= ruleAndInstruction EOF
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
    // InternalAssembler.g:2686:1: ruleAndInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:2692:2: ( ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:2693:2: ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:2693:2: ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:2694:3: ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:2694:3: ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) )
            // InternalAssembler.g:2695:4: ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) )
            {
            // InternalAssembler.g:2695:4: ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) )
            // InternalAssembler.g:2696:5: (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' )
            {
            // InternalAssembler.g:2696:5: (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==61) ) {
                alt34=1;
            }
            else if ( (LA34_0==62) ) {
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
                    // InternalAssembler.g:2697:6: lv_instruction_0_1= 'ANDA'
                    {
                    lv_instruction_0_1=(Token)match(input,61,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:2708:6: lv_instruction_0_2= 'ANDB'
                    {
                    lv_instruction_0_2=(Token)match(input,62,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:2725:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:2726:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:2726:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:2727:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:2727:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt35=5;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalAssembler.g:2728:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:2744:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:2760:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:2776:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:2792:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:2814:1: entryRuleAdddInstruction returns [EObject current=null] : iv_ruleAdddInstruction= ruleAdddInstruction EOF ;
    public final EObject entryRuleAdddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdddInstruction = null;


        try {
            // InternalAssembler.g:2814:56: (iv_ruleAdddInstruction= ruleAdddInstruction EOF )
            // InternalAssembler.g:2815:2: iv_ruleAdddInstruction= ruleAdddInstruction EOF
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
    // InternalAssembler.g:2821:1: ruleAdddInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:2827:2: ( ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:2828:2: ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:2828:2: ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:2829:3: ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:2829:3: ( (lv_instruction_0_0= 'ADDD' ) )
            // InternalAssembler.g:2830:4: (lv_instruction_0_0= 'ADDD' )
            {
            // InternalAssembler.g:2830:4: (lv_instruction_0_0= 'ADDD' )
            // InternalAssembler.g:2831:5: lv_instruction_0_0= 'ADDD'
            {
            lv_instruction_0_0=(Token)match(input,63,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:2847:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:2848:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:2848:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:2849:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:2849:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt36=5;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalAssembler.g:2850:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:2866:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:2882:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:2898:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:2914:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:2936:1: entryRuleAddInstruction returns [EObject current=null] : iv_ruleAddInstruction= ruleAddInstruction EOF ;
    public final EObject entryRuleAddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddInstruction = null;


        try {
            // InternalAssembler.g:2936:55: (iv_ruleAddInstruction= ruleAddInstruction EOF )
            // InternalAssembler.g:2937:2: iv_ruleAddInstruction= ruleAddInstruction EOF
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
    // InternalAssembler.g:2943:1: ruleAddInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:2949:2: ( ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:2950:2: ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:2950:2: ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:2951:3: ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:2951:3: ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) )
            // InternalAssembler.g:2952:4: ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) )
            {
            // InternalAssembler.g:2952:4: ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) )
            // InternalAssembler.g:2953:5: (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' )
            {
            // InternalAssembler.g:2953:5: (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==64) ) {
                alt37=1;
            }
            else if ( (LA37_0==65) ) {
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
                    // InternalAssembler.g:2954:6: lv_instruction_0_1= 'ADDA'
                    {
                    lv_instruction_0_1=(Token)match(input,64,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:2965:6: lv_instruction_0_2= 'ADDB'
                    {
                    lv_instruction_0_2=(Token)match(input,65,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:2982:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:2983:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:2983:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:2984:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:2984:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt38=5;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // InternalAssembler.g:2985:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:3001:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:3017:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:3033:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:3049:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:3071:1: entryRuleAdcInstruction returns [EObject current=null] : iv_ruleAdcInstruction= ruleAdcInstruction EOF ;
    public final EObject entryRuleAdcInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdcInstruction = null;


        try {
            // InternalAssembler.g:3071:55: (iv_ruleAdcInstruction= ruleAdcInstruction EOF )
            // InternalAssembler.g:3072:2: iv_ruleAdcInstruction= ruleAdcInstruction EOF
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
    // InternalAssembler.g:3078:1: ruleAdcInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:3084:2: ( ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:3085:2: ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:3085:2: ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:3086:3: ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:3086:3: ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) )
            // InternalAssembler.g:3087:4: ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) )
            {
            // InternalAssembler.g:3087:4: ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) )
            // InternalAssembler.g:3088:5: (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' )
            {
            // InternalAssembler.g:3088:5: (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==66) ) {
                alt39=1;
            }
            else if ( (LA39_0==67) ) {
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
                    // InternalAssembler.g:3089:6: lv_instruction_0_1= 'ADCA'
                    {
                    lv_instruction_0_1=(Token)match(input,66,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:3100:6: lv_instruction_0_2= 'ADCB'
                    {
                    lv_instruction_0_2=(Token)match(input,67,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:3117:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:3118:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:3118:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:3119:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:3119:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt40=5;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // InternalAssembler.g:3120:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:3136:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:3152:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:3168:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:3184:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:3206:1: entryRuleAbxInstruction returns [EObject current=null] : iv_ruleAbxInstruction= ruleAbxInstruction EOF ;
    public final EObject entryRuleAbxInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbxInstruction = null;


        try {
            // InternalAssembler.g:3206:55: (iv_ruleAbxInstruction= ruleAbxInstruction EOF )
            // InternalAssembler.g:3207:2: iv_ruleAbxInstruction= ruleAbxInstruction EOF
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
    // InternalAssembler.g:3213:1: ruleAbxInstruction returns [EObject current=null] : ( (lv_instruction_0_0= 'ABX' ) ) ;
    public final EObject ruleAbxInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3219:2: ( ( (lv_instruction_0_0= 'ABX' ) ) )
            // InternalAssembler.g:3220:2: ( (lv_instruction_0_0= 'ABX' ) )
            {
            // InternalAssembler.g:3220:2: ( (lv_instruction_0_0= 'ABX' ) )
            // InternalAssembler.g:3221:3: (lv_instruction_0_0= 'ABX' )
            {
            // InternalAssembler.g:3221:3: (lv_instruction_0_0= 'ABX' )
            // InternalAssembler.g:3222:4: lv_instruction_0_0= 'ABX'
            {
            lv_instruction_0_0=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3237:1: entryRuleExtendedIndirectOperand returns [EObject current=null] : iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF ;
    public final EObject entryRuleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedIndirectOperand = null;


        try {
            // InternalAssembler.g:3237:64: (iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF )
            // InternalAssembler.g:3238:2: iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF
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
    // InternalAssembler.g:3244:1: ruleExtendedIndirectOperand returns [EObject current=null] : (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3250:2: ( (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalAssembler.g:3251:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalAssembler.g:3251:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalAssembler.g:3252:3: otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtendedIndirectOperandAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:3256:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:3257:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:3257:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:3258:5: lv_operand_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtendedIndirectOperandAccess().getOperandExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
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

            otherlv_2=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3283:1: entryRuleExtendedOperand returns [EObject current=null] : iv_ruleExtendedOperand= ruleExtendedOperand EOF ;
    public final EObject entryRuleExtendedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedOperand = null;


        try {
            // InternalAssembler.g:3283:56: (iv_ruleExtendedOperand= ruleExtendedOperand EOF )
            // InternalAssembler.g:3284:2: iv_ruleExtendedOperand= ruleExtendedOperand EOF
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
    // InternalAssembler.g:3290:1: ruleExtendedOperand returns [EObject current=null] : ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExtendedOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3296:2: ( ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:3297:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:3297:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:3298:3: (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) )
            {
            // InternalAssembler.g:3298:3: (otherlv_0= '>' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==71) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAssembler.g:3299:4: otherlv_0= '>'
                    {
                    otherlv_0=(Token)match(input,71,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getExtendedOperandAccess().getGreaterThanSignKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:3304:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:3305:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:3305:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:3306:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:3327:1: entryRuleDirectOperand returns [EObject current=null] : iv_ruleDirectOperand= ruleDirectOperand EOF ;
    public final EObject entryRuleDirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectOperand = null;


        try {
            // InternalAssembler.g:3327:54: (iv_ruleDirectOperand= ruleDirectOperand EOF )
            // InternalAssembler.g:3328:2: iv_ruleDirectOperand= ruleDirectOperand EOF
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
    // InternalAssembler.g:3334:1: ruleDirectOperand returns [EObject current=null] : (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleDirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3340:2: ( (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:3341:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:3341:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:3342:3: otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectOperandAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalAssembler.g:3346:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:3347:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:3347:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:3348:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:3369:1: entryRuleImmediatOperand returns [EObject current=null] : iv_ruleImmediatOperand= ruleImmediatOperand EOF ;
    public final EObject entryRuleImmediatOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImmediatOperand = null;


        try {
            // InternalAssembler.g:3369:56: (iv_ruleImmediatOperand= ruleImmediatOperand EOF )
            // InternalAssembler.g:3370:2: iv_ruleImmediatOperand= ruleImmediatOperand EOF
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
    // InternalAssembler.g:3376:1: ruleImmediatOperand returns [EObject current=null] : (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleImmediatOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3382:2: ( (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:3383:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:3383:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:3384:3: otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImmediatOperandAccess().getNumberSignKeyword_0());
              		
            }
            // InternalAssembler.g:3388:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:3389:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:3389:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:3390:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:3411:1: entryRuleIndexedOperand returns [EObject current=null] : iv_ruleIndexedOperand= ruleIndexedOperand EOF ;
    public final EObject entryRuleIndexedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedOperand = null;


        try {
            // InternalAssembler.g:3411:55: (iv_ruleIndexedOperand= ruleIndexedOperand EOF )
            // InternalAssembler.g:3412:2: iv_ruleIndexedOperand= ruleIndexedOperand EOF
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
    // InternalAssembler.g:3418:1: ruleIndexedOperand returns [EObject current=null] : ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) ;
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
            // InternalAssembler.g:3424:2: ( ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) )
            // InternalAssembler.g:3425:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            {
            // InternalAssembler.g:3425:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            int alt42=8;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // InternalAssembler.g:3426:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    {
                    // InternalAssembler.g:3426:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    // InternalAssembler.g:3427:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    {
                    // InternalAssembler.g:3427:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    // InternalAssembler.g:3428:5: lv_mode_0_0= ruleAutoIncDecMode
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
                    // InternalAssembler.g:3446:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    {
                    // InternalAssembler.g:3446:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    // InternalAssembler.g:3447:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    {
                    // InternalAssembler.g:3447:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    // InternalAssembler.g:3448:5: lv_mode_1_0= ruleConstantIndexedMode
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
                    // InternalAssembler.g:3466:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    {
                    // InternalAssembler.g:3466:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    // InternalAssembler.g:3467:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    {
                    // InternalAssembler.g:3467:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    // InternalAssembler.g:3468:5: lv_mode_2_0= ruleAccumulatorMovingMode
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
                    // InternalAssembler.g:3486:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    {
                    // InternalAssembler.g:3486:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    // InternalAssembler.g:3487:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    {
                    // InternalAssembler.g:3487:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    // InternalAssembler.g:3488:5: lv_mode_3_0= ruleRelatifToPCMode
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
                    // InternalAssembler.g:3506:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:3506:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    // InternalAssembler.g:3507:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    {
                    // InternalAssembler.g:3507:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    // InternalAssembler.g:3508:5: lv_mode_4_0= ruleConstantIndexedMovingIndirectMode
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
                    // InternalAssembler.g:3526:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    {
                    // InternalAssembler.g:3526:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    // InternalAssembler.g:3527:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    {
                    // InternalAssembler.g:3527:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    // InternalAssembler.g:3528:5: lv_mode_5_0= ruleAutoIncDecIndirectMode
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
                    // InternalAssembler.g:3546:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:3546:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    // InternalAssembler.g:3547:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    {
                    // InternalAssembler.g:3547:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    // InternalAssembler.g:3548:5: lv_mode_6_0= ruleAccumulatorMovingIndirectMode
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
                    // InternalAssembler.g:3566:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    {
                    // InternalAssembler.g:3566:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    // InternalAssembler.g:3567:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    {
                    // InternalAssembler.g:3567:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    // InternalAssembler.g:3568:5: lv_mode_7_0= ruleRelatifToPCIndirectMode
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
    // InternalAssembler.g:3589:1: entryRuleConstantIndexedMode returns [EObject current=null] : iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF ;
    public final EObject entryRuleConstantIndexedMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMode = null;


        try {
            // InternalAssembler.g:3589:60: (iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF )
            // InternalAssembler.g:3590:2: iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF
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
    // InternalAssembler.g:3596:1: ruleConstantIndexedMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:3602:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:3603:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:3603:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:3604:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:3604:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_CHARACTER)||LA43_0==82||LA43_0==84) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAssembler.g:3605:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:3605:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:3606:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_14);
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

            otherlv_1=(Token)match(input,74,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstantIndexedModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:3627:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:3628:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:3628:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:3629:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:3629:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt44=1;
                }
                break;
            case 76:
                {
                alt44=2;
                }
                break;
            case 77:
                {
                alt44=3;
                }
                break;
            case 78:
                {
                alt44=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalAssembler.g:3630:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:3641:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:3652:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:3663:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3680:1: entryRuleConstantIndexedMovingIndirectMode returns [EObject current=null] : iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF ;
    public final EObject entryRuleConstantIndexedMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMovingIndirectMode = null;


        try {
            // InternalAssembler.g:3680:74: (iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF )
            // InternalAssembler.g:3681:2: iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF
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
    // InternalAssembler.g:3687:1: ruleConstantIndexedMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:3693:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:3694:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:3694:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:3695:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:3699:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_CHARACTER)||LA45_0==82||LA45_0==84) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAssembler.g:3700:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:3700:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:3701:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedMovingIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_14);
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

            otherlv_2=(Token)match(input,74,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:3722:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:3723:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:3723:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:3724:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:3724:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt46=4;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt46=1;
                }
                break;
            case 76:
                {
                alt46=2;
                }
                break;
            case 77:
                {
                alt46=3;
                }
                break;
            case 78:
                {
                alt46=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalAssembler.g:3725:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,75,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:3736:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,76,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:3747:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,77,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:3758:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,78,FOLLOW_13); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3779:1: entryRuleAccumulatorMovingMode returns [EObject current=null] : iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF ;
    public final EObject entryRuleAccumulatorMovingMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingMode = null;


        try {
            // InternalAssembler.g:3779:62: (iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF )
            // InternalAssembler.g:3780:2: iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF
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
    // InternalAssembler.g:3786:1: ruleAccumulatorMovingMode returns [EObject current=null] : ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:3792:2: ( ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:3793:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:3793:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:3794:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:3794:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) )
            // InternalAssembler.g:3795:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            {
            // InternalAssembler.g:3795:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            // InternalAssembler.g:3796:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            {
            // InternalAssembler.g:3796:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt47=1;
                }
                break;
            case 80:
                {
                alt47=2;
                }
                break;
            case 81:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalAssembler.g:3797:6: lv_deplacement_0_1= 'A'
                    {
                    lv_deplacement_0_1=(Token)match(input,79,FOLLOW_14); if (state.failed) return current;
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
                    // InternalAssembler.g:3808:6: lv_deplacement_0_2= 'B'
                    {
                    lv_deplacement_0_2=(Token)match(input,80,FOLLOW_14); if (state.failed) return current;
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
                    // InternalAssembler.g:3819:6: lv_deplacement_0_3= 'D'
                    {
                    lv_deplacement_0_3=(Token)match(input,81,FOLLOW_14); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,74,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAccumulatorMovingModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:3836:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:3837:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:3837:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:3838:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:3838:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt48=4;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt48=1;
                }
                break;
            case 76:
                {
                alt48=2;
                }
                break;
            case 77:
                {
                alt48=3;
                }
                break;
            case 78:
                {
                alt48=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalAssembler.g:3839:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:3850:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:3861:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:3872:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3889:1: entryRuleAccumulatorMovingIndirectMode returns [EObject current=null] : iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF ;
    public final EObject entryRuleAccumulatorMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingIndirectMode = null;


        try {
            // InternalAssembler.g:3889:70: (iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF )
            // InternalAssembler.g:3890:2: iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF
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
    // InternalAssembler.g:3896:1: ruleAccumulatorMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:3902:2: ( (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:3903:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:3903:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:3904:3: otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAccumulatorMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:3908:3: ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) )
            // InternalAssembler.g:3909:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            {
            // InternalAssembler.g:3909:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            // InternalAssembler.g:3910:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            {
            // InternalAssembler.g:3910:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            int alt49=3;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt49=1;
                }
                break;
            case 80:
                {
                alt49=2;
                }
                break;
            case 81:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalAssembler.g:3911:6: lv_deplacement_1_1= 'A'
                    {
                    lv_deplacement_1_1=(Token)match(input,79,FOLLOW_14); if (state.failed) return current;
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
                    // InternalAssembler.g:3922:6: lv_deplacement_1_2= 'B'
                    {
                    lv_deplacement_1_2=(Token)match(input,80,FOLLOW_14); if (state.failed) return current;
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
                    // InternalAssembler.g:3933:6: lv_deplacement_1_3= 'D'
                    {
                    lv_deplacement_1_3=(Token)match(input,81,FOLLOW_14); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,74,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAccumulatorMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:3950:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:3951:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:3951:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:3952:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:3952:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt50=4;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt50=1;
                }
                break;
            case 76:
                {
                alt50=2;
                }
                break;
            case 77:
                {
                alt50=3;
                }
                break;
            case 78:
                {
                alt50=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalAssembler.g:3953:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,75,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:3964:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,76,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:3975:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,77,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:3986:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,78,FOLLOW_13); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4007:1: entryRuleAutoIncDecMode returns [EObject current=null] : iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF ;
    public final EObject entryRuleAutoIncDecMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecMode = null;


        try {
            // InternalAssembler.g:4007:55: (iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF )
            // InternalAssembler.g:4008:2: iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF
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
    // InternalAssembler.g:4014:1: ruleAutoIncDecMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) ;
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
            // InternalAssembler.g:4020:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) )
            // InternalAssembler.g:4021:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            {
            // InternalAssembler.g:4021:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            // InternalAssembler.g:4022:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            {
            // InternalAssembler.g:4022:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_CHARACTER)||LA51_0==82||LA51_0==84) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalAssembler.g:4023:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:4023:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:4024:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_14);
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

            otherlv_1=(Token)match(input,74,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAutoIncDecModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:4045:3: ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=82 && LA56_0<=83)) ) {
                alt56=1;
            }
            else if ( ((LA56_0>=75 && LA56_0<=78)) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalAssembler.g:4046:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:4046:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    // InternalAssembler.g:4047:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:4047:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==82) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==83) ) {
                        alt52=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }
                    switch (alt52) {
                        case 1 :
                            // InternalAssembler.g:4048:6: ( (lv_decrement_2_0= '-' ) )
                            {
                            // InternalAssembler.g:4048:6: ( (lv_decrement_2_0= '-' ) )
                            // InternalAssembler.g:4049:7: (lv_decrement_2_0= '-' )
                            {
                            // InternalAssembler.g:4049:7: (lv_decrement_2_0= '-' )
                            // InternalAssembler.g:4050:8: lv_decrement_2_0= '-'
                            {
                            lv_decrement_2_0=(Token)match(input,82,FOLLOW_15); if (state.failed) return current;
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
                            // InternalAssembler.g:4063:6: ( (lv_decrement_3_0= '--' ) )
                            {
                            // InternalAssembler.g:4063:6: ( (lv_decrement_3_0= '--' ) )
                            // InternalAssembler.g:4064:7: (lv_decrement_3_0= '--' )
                            {
                            // InternalAssembler.g:4064:7: (lv_decrement_3_0= '--' )
                            // InternalAssembler.g:4065:8: lv_decrement_3_0= '--'
                            {
                            lv_decrement_3_0=(Token)match(input,83,FOLLOW_15); if (state.failed) return current;
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

                    // InternalAssembler.g:4078:5: ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    // InternalAssembler.g:4079:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    {
                    // InternalAssembler.g:4079:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    // InternalAssembler.g:4080:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    {
                    // InternalAssembler.g:4080:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    int alt53=4;
                    switch ( input.LA(1) ) {
                    case 75:
                        {
                        alt53=1;
                        }
                        break;
                    case 76:
                        {
                        alt53=2;
                        }
                        break;
                    case 77:
                        {
                        alt53=3;
                        }
                        break;
                    case 78:
                        {
                        alt53=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;
                    }

                    switch (alt53) {
                        case 1 :
                            // InternalAssembler.g:4081:8: lv_register_4_1= 'S'
                            {
                            lv_register_4_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:4092:8: lv_register_4_2= 'U'
                            {
                            lv_register_4_2=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:4103:8: lv_register_4_3= 'X'
                            {
                            lv_register_4_3=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:4114:8: lv_register_4_4= 'Y'
                            {
                            lv_register_4_4=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:4129:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:4129:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    // InternalAssembler.g:4130:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    {
                    // InternalAssembler.g:4130:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:4131:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:4131:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:4132:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:4132:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt54=4;
                    switch ( input.LA(1) ) {
                    case 75:
                        {
                        alt54=1;
                        }
                        break;
                    case 76:
                        {
                        alt54=2;
                        }
                        break;
                    case 77:
                        {
                        alt54=3;
                        }
                        break;
                    case 78:
                        {
                        alt54=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;
                    }

                    switch (alt54) {
                        case 1 :
                            // InternalAssembler.g:4133:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,75,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:4144:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,76,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:4155:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,77,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:4166:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,78,FOLLOW_19); if (state.failed) return current;
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

                    // InternalAssembler.g:4179:5: ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==84) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==85) ) {
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
                            // InternalAssembler.g:4180:6: ( (lv_increment_6_0= '+' ) )
                            {
                            // InternalAssembler.g:4180:6: ( (lv_increment_6_0= '+' ) )
                            // InternalAssembler.g:4181:7: (lv_increment_6_0= '+' )
                            {
                            // InternalAssembler.g:4181:7: (lv_increment_6_0= '+' )
                            // InternalAssembler.g:4182:8: lv_increment_6_0= '+'
                            {
                            lv_increment_6_0=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:4195:6: ( (lv_increment_7_0= '++' ) )
                            {
                            // InternalAssembler.g:4195:6: ( (lv_increment_7_0= '++' ) )
                            // InternalAssembler.g:4196:7: (lv_increment_7_0= '++' )
                            {
                            // InternalAssembler.g:4196:7: (lv_increment_7_0= '++' )
                            // InternalAssembler.g:4197:8: lv_increment_7_0= '++'
                            {
                            lv_increment_7_0=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4216:1: entryRuleAutoIncDecIndirectMode returns [EObject current=null] : iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF ;
    public final EObject entryRuleAutoIncDecIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecIndirectMode = null;


        try {
            // InternalAssembler.g:4216:63: (iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF )
            // InternalAssembler.g:4217:2: iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF
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
    // InternalAssembler.g:4223:1: ruleAutoIncDecIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) ;
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
            // InternalAssembler.g:4229:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) )
            // InternalAssembler.g:4230:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            {
            // InternalAssembler.g:4230:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            // InternalAssembler.g:4231:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAutoIncDecIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:4235:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=RULE_ID && LA57_0<=RULE_CHARACTER)||LA57_0==82||LA57_0==84) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAssembler.g:4236:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:4236:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:4237:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_14);
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

            otherlv_2=(Token)match(input,74,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAutoIncDecIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:4258:3: ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=82 && LA62_0<=83)) ) {
                alt62=1;
            }
            else if ( ((LA62_0>=75 && LA62_0<=78)) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalAssembler.g:4259:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:4259:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    // InternalAssembler.g:4260:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:4260:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==82) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==83) ) {
                        alt58=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalAssembler.g:4261:6: ( (lv_decrement_3_0= '-' ) )
                            {
                            // InternalAssembler.g:4261:6: ( (lv_decrement_3_0= '-' ) )
                            // InternalAssembler.g:4262:7: (lv_decrement_3_0= '-' )
                            {
                            // InternalAssembler.g:4262:7: (lv_decrement_3_0= '-' )
                            // InternalAssembler.g:4263:8: lv_decrement_3_0= '-'
                            {
                            lv_decrement_3_0=(Token)match(input,82,FOLLOW_15); if (state.failed) return current;
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
                            // InternalAssembler.g:4276:6: ( (lv_decrement_4_0= '--' ) )
                            {
                            // InternalAssembler.g:4276:6: ( (lv_decrement_4_0= '--' ) )
                            // InternalAssembler.g:4277:7: (lv_decrement_4_0= '--' )
                            {
                            // InternalAssembler.g:4277:7: (lv_decrement_4_0= '--' )
                            // InternalAssembler.g:4278:8: lv_decrement_4_0= '--'
                            {
                            lv_decrement_4_0=(Token)match(input,83,FOLLOW_15); if (state.failed) return current;
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

                    // InternalAssembler.g:4291:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:4292:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:4292:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:4293:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:4293:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt59=4;
                    switch ( input.LA(1) ) {
                    case 75:
                        {
                        alt59=1;
                        }
                        break;
                    case 76:
                        {
                        alt59=2;
                        }
                        break;
                    case 77:
                        {
                        alt59=3;
                        }
                        break;
                    case 78:
                        {
                        alt59=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }

                    switch (alt59) {
                        case 1 :
                            // InternalAssembler.g:4294:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,75,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:4305:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,76,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:4316:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,77,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:4327:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,78,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:4342:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:4342:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    // InternalAssembler.g:4343:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    {
                    // InternalAssembler.g:4343:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) )
                    // InternalAssembler.g:4344:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    {
                    // InternalAssembler.g:4344:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    // InternalAssembler.g:4345:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    {
                    // InternalAssembler.g:4345:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    int alt60=4;
                    switch ( input.LA(1) ) {
                    case 75:
                        {
                        alt60=1;
                        }
                        break;
                    case 76:
                        {
                        alt60=2;
                        }
                        break;
                    case 77:
                        {
                        alt60=3;
                        }
                        break;
                    case 78:
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
                            // InternalAssembler.g:4346:8: lv_register_6_1= 'S'
                            {
                            lv_register_6_1=(Token)match(input,75,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:4357:8: lv_register_6_2= 'U'
                            {
                            lv_register_6_2=(Token)match(input,76,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:4368:8: lv_register_6_3= 'X'
                            {
                            lv_register_6_3=(Token)match(input,77,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:4379:8: lv_register_6_4= 'Y'
                            {
                            lv_register_6_4=(Token)match(input,78,FOLLOW_19); if (state.failed) return current;
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

                    // InternalAssembler.g:4392:5: ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==84) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==85) ) {
                        alt61=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalAssembler.g:4393:6: ( (lv_increment_7_0= '+' ) )
                            {
                            // InternalAssembler.g:4393:6: ( (lv_increment_7_0= '+' ) )
                            // InternalAssembler.g:4394:7: (lv_increment_7_0= '+' )
                            {
                            // InternalAssembler.g:4394:7: (lv_increment_7_0= '+' )
                            // InternalAssembler.g:4395:8: lv_increment_7_0= '+'
                            {
                            lv_increment_7_0=(Token)match(input,84,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:4408:6: ( (lv_increment_8_0= '++' ) )
                            {
                            // InternalAssembler.g:4408:6: ( (lv_increment_8_0= '++' ) )
                            // InternalAssembler.g:4409:7: (lv_increment_8_0= '++' )
                            {
                            // InternalAssembler.g:4409:7: (lv_increment_8_0= '++' )
                            // InternalAssembler.g:4410:8: lv_increment_8_0= '++'
                            {
                            lv_increment_8_0=(Token)match(input,85,FOLLOW_13); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4433:1: entryRuleRelatifToPCMode returns [EObject current=null] : iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF ;
    public final EObject entryRuleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCMode = null;


        try {
            // InternalAssembler.g:4433:56: (iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF )
            // InternalAssembler.g:4434:2: iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF
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
    // InternalAssembler.g:4440:1: ruleRelatifToPCMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) ;
    public final EObject ruleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_register_2_0=null;
        EObject lv_deplacement_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4446:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) )
            // InternalAssembler.g:4447:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            {
            // InternalAssembler.g:4447:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            // InternalAssembler.g:4448:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) )
            {
            // InternalAssembler.g:4448:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_ID && LA63_0<=RULE_CHARACTER)||LA63_0==82||LA63_0==84) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalAssembler.g:4449:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:4449:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:4450:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_14);
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

            otherlv_1=(Token)match(input,74,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelatifToPCModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:4471:3: ( (lv_register_2_0= 'PCR' ) )
            // InternalAssembler.g:4472:4: (lv_register_2_0= 'PCR' )
            {
            // InternalAssembler.g:4472:4: (lv_register_2_0= 'PCR' )
            // InternalAssembler.g:4473:5: lv_register_2_0= 'PCR'
            {
            lv_register_2_0=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4489:1: entryRuleRelatifToPCIndirectMode returns [EObject current=null] : iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF ;
    public final EObject entryRuleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCIndirectMode = null;


        try {
            // InternalAssembler.g:4489:64: (iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF )
            // InternalAssembler.g:4490:2: iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF
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
    // InternalAssembler.g:4496:1: ruleRelatifToPCIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) ;
    public final EObject ruleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_register_3_0=null;
        Token otherlv_4=null;
        EObject lv_deplacement_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4502:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:4503:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:4503:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            // InternalAssembler.g:4504:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRelatifToPCIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:4508:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=RULE_ID && LA64_0<=RULE_CHARACTER)||LA64_0==82||LA64_0==84) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalAssembler.g:4509:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:4509:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:4510:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_14);
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

            otherlv_2=(Token)match(input,74,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRelatifToPCIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:4531:3: ( (lv_register_3_0= 'PCR' ) )
            // InternalAssembler.g:4532:4: (lv_register_3_0= 'PCR' )
            {
            // InternalAssembler.g:4532:4: (lv_register_3_0= 'PCR' )
            // InternalAssembler.g:4533:5: lv_register_3_0= 'PCR'
            {
            lv_register_3_0=(Token)match(input,86,FOLLOW_13); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4553:1: entryRuleRelativeMode returns [EObject current=null] : iv_ruleRelativeMode= ruleRelativeMode EOF ;
    public final EObject entryRuleRelativeMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeMode = null;


        try {
            // InternalAssembler.g:4553:53: (iv_ruleRelativeMode= ruleRelativeMode EOF )
            // InternalAssembler.g:4554:2: iv_ruleRelativeMode= ruleRelativeMode EOF
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
    // InternalAssembler.g:4560:1: ruleRelativeMode returns [EObject current=null] : ( (lv_location_0_0= ruleIdentifierValue ) ) ;
    public final EObject ruleRelativeMode() throws RecognitionException {
        EObject current = null;

        EObject lv_location_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4566:2: ( ( (lv_location_0_0= ruleIdentifierValue ) ) )
            // InternalAssembler.g:4567:2: ( (lv_location_0_0= ruleIdentifierValue ) )
            {
            // InternalAssembler.g:4567:2: ( (lv_location_0_0= ruleIdentifierValue ) )
            // InternalAssembler.g:4568:3: (lv_location_0_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:4568:3: (lv_location_0_0= ruleIdentifierValue )
            // InternalAssembler.g:4569:4: lv_location_0_0= ruleIdentifierValue
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
    // InternalAssembler.g:4589:1: entryRuleDirectiveLine returns [EObject current=null] : iv_ruleDirectiveLine= ruleDirectiveLine EOF ;
    public final EObject entryRuleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectiveLine = null;


        try {
            // InternalAssembler.g:4589:54: (iv_ruleDirectiveLine= ruleDirectiveLine EOF )
            // InternalAssembler.g:4590:2: iv_ruleDirectiveLine= ruleDirectiveLine EOF
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
    // InternalAssembler.g:4596:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:4602:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:4603:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:4603:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:4604:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:4604:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAssembler.g:4605:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4605:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4606:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4627:3: ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) )
            int alt66=16;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt66=1;
                }
                break;
            case 104:
                {
                alt66=2;
                }
                break;
            case 98:
            case 99:
                {
                alt66=3;
                }
                break;
            case 103:
                {
                alt66=4;
                }
                break;
            case 94:
                {
                alt66=5;
                }
                break;
            case 97:
                {
                alt66=6;
                }
                break;
            case 93:
                {
                alt66=7;
                }
                break;
            case 92:
                {
                alt66=8;
                }
                break;
            case 90:
            case 91:
                {
                alt66=9;
                }
                break;
            case 95:
                {
                alt66=10;
                }
                break;
            case 89:
                {
                alt66=11;
                }
                break;
            case 88:
                {
                alt66=12;
                }
                break;
            case 101:
                {
                alt66=13;
                }
                break;
            case 100:
                {
                alt66=14;
                }
                break;
            case 87:
                {
                alt66=15;
                }
                break;
            case 102:
                {
                alt66=16;
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
                    // InternalAssembler.g:4628:4: ( (lv_directive_2_0= ruleEquDirective ) )
                    {
                    // InternalAssembler.g:4628:4: ( (lv_directive_2_0= ruleEquDirective ) )
                    // InternalAssembler.g:4629:5: (lv_directive_2_0= ruleEquDirective )
                    {
                    // InternalAssembler.g:4629:5: (lv_directive_2_0= ruleEquDirective )
                    // InternalAssembler.g:4630:6: lv_directive_2_0= ruleEquDirective
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
                    // InternalAssembler.g:4648:4: ( (lv_directive_3_0= ruleOrgDirective ) )
                    {
                    // InternalAssembler.g:4648:4: ( (lv_directive_3_0= ruleOrgDirective ) )
                    // InternalAssembler.g:4649:5: (lv_directive_3_0= ruleOrgDirective )
                    {
                    // InternalAssembler.g:4649:5: (lv_directive_3_0= ruleOrgDirective )
                    // InternalAssembler.g:4650:6: lv_directive_3_0= ruleOrgDirective
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
                    // InternalAssembler.g:4668:4: ( (lv_directive_4_0= ruleBszDirective ) )
                    {
                    // InternalAssembler.g:4668:4: ( (lv_directive_4_0= ruleBszDirective ) )
                    // InternalAssembler.g:4669:5: (lv_directive_4_0= ruleBszDirective )
                    {
                    // InternalAssembler.g:4669:5: (lv_directive_4_0= ruleBszDirective )
                    // InternalAssembler.g:4670:6: lv_directive_4_0= ruleBszDirective
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
                    // InternalAssembler.g:4688:4: ( (lv_directive_5_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:4688:4: ( (lv_directive_5_0= ruleEndDirective ) )
                    // InternalAssembler.g:4689:5: (lv_directive_5_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:4689:5: (lv_directive_5_0= ruleEndDirective )
                    // InternalAssembler.g:4690:6: lv_directive_5_0= ruleEndDirective
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
                    // InternalAssembler.g:4708:4: ( (lv_directive_6_0= ruleFailDirective ) )
                    {
                    // InternalAssembler.g:4708:4: ( (lv_directive_6_0= ruleFailDirective ) )
                    // InternalAssembler.g:4709:5: (lv_directive_6_0= ruleFailDirective )
                    {
                    // InternalAssembler.g:4709:5: (lv_directive_6_0= ruleFailDirective )
                    // InternalAssembler.g:4710:6: lv_directive_6_0= ruleFailDirective
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
                    // InternalAssembler.g:4728:4: ( (lv_directive_7_0= ruleFillDirective ) )
                    {
                    // InternalAssembler.g:4728:4: ( (lv_directive_7_0= ruleFillDirective ) )
                    // InternalAssembler.g:4729:5: (lv_directive_7_0= ruleFillDirective )
                    {
                    // InternalAssembler.g:4729:5: (lv_directive_7_0= ruleFillDirective )
                    // InternalAssembler.g:4730:6: lv_directive_7_0= ruleFillDirective
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
                    // InternalAssembler.g:4748:4: ( (lv_directive_8_0= ruleOptDirective ) )
                    {
                    // InternalAssembler.g:4748:4: ( (lv_directive_8_0= ruleOptDirective ) )
                    // InternalAssembler.g:4749:5: (lv_directive_8_0= ruleOptDirective )
                    {
                    // InternalAssembler.g:4749:5: (lv_directive_8_0= ruleOptDirective )
                    // InternalAssembler.g:4750:6: lv_directive_8_0= ruleOptDirective
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
                    // InternalAssembler.g:4768:4: ( (lv_directive_9_0= rulePagDirective ) )
                    {
                    // InternalAssembler.g:4768:4: ( (lv_directive_9_0= rulePagDirective ) )
                    // InternalAssembler.g:4769:5: (lv_directive_9_0= rulePagDirective )
                    {
                    // InternalAssembler.g:4769:5: (lv_directive_9_0= rulePagDirective )
                    // InternalAssembler.g:4770:6: lv_directive_9_0= rulePagDirective
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
                    // InternalAssembler.g:4788:4: ( (lv_directive_10_0= ruleNamDirective ) )
                    {
                    // InternalAssembler.g:4788:4: ( (lv_directive_10_0= ruleNamDirective ) )
                    // InternalAssembler.g:4789:5: (lv_directive_10_0= ruleNamDirective )
                    {
                    // InternalAssembler.g:4789:5: (lv_directive_10_0= ruleNamDirective )
                    // InternalAssembler.g:4790:6: lv_directive_10_0= ruleNamDirective
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
                    // InternalAssembler.g:4808:4: ( (lv_directive_11_0= ruleSetDirective ) )
                    {
                    // InternalAssembler.g:4808:4: ( (lv_directive_11_0= ruleSetDirective ) )
                    // InternalAssembler.g:4809:5: (lv_directive_11_0= ruleSetDirective )
                    {
                    // InternalAssembler.g:4809:5: (lv_directive_11_0= ruleSetDirective )
                    // InternalAssembler.g:4810:6: lv_directive_11_0= ruleSetDirective
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
                    // InternalAssembler.g:4828:4: ( (lv_directive_12_0= ruleSpcDirective ) )
                    {
                    // InternalAssembler.g:4828:4: ( (lv_directive_12_0= ruleSpcDirective ) )
                    // InternalAssembler.g:4829:5: (lv_directive_12_0= ruleSpcDirective )
                    {
                    // InternalAssembler.g:4829:5: (lv_directive_12_0= ruleSpcDirective )
                    // InternalAssembler.g:4830:6: lv_directive_12_0= ruleSpcDirective
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
                    // InternalAssembler.g:4848:4: ( (lv_directive_13_0= ruleRegDirective ) )
                    {
                    // InternalAssembler.g:4848:4: ( (lv_directive_13_0= ruleRegDirective ) )
                    // InternalAssembler.g:4849:5: (lv_directive_13_0= ruleRegDirective )
                    {
                    // InternalAssembler.g:4849:5: (lv_directive_13_0= ruleRegDirective )
                    // InternalAssembler.g:4850:6: lv_directive_13_0= ruleRegDirective
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
                    // InternalAssembler.g:4868:4: ( (lv_directive_14_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:4868:4: ( (lv_directive_14_0= ruleFcbDirective ) )
                    // InternalAssembler.g:4869:5: (lv_directive_14_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:4869:5: (lv_directive_14_0= ruleFcbDirective )
                    // InternalAssembler.g:4870:6: lv_directive_14_0= ruleFcbDirective
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
                    // InternalAssembler.g:4888:4: ( (lv_directive_15_0= ruleFdbDirective ) )
                    {
                    // InternalAssembler.g:4888:4: ( (lv_directive_15_0= ruleFdbDirective ) )
                    // InternalAssembler.g:4889:5: (lv_directive_15_0= ruleFdbDirective )
                    {
                    // InternalAssembler.g:4889:5: (lv_directive_15_0= ruleFdbDirective )
                    // InternalAssembler.g:4890:6: lv_directive_15_0= ruleFdbDirective
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
                    // InternalAssembler.g:4908:4: ( (lv_directive_16_0= ruleFccDirective ) )
                    {
                    // InternalAssembler.g:4908:4: ( (lv_directive_16_0= ruleFccDirective ) )
                    // InternalAssembler.g:4909:5: (lv_directive_16_0= ruleFccDirective )
                    {
                    // InternalAssembler.g:4909:5: (lv_directive_16_0= ruleFccDirective )
                    // InternalAssembler.g:4910:6: lv_directive_16_0= ruleFccDirective
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
                    // InternalAssembler.g:4928:4: ( (lv_directive_17_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:4928:4: ( (lv_directive_17_0= ruleRmbDirective ) )
                    // InternalAssembler.g:4929:5: (lv_directive_17_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:4929:5: (lv_directive_17_0= ruleRmbDirective )
                    // InternalAssembler.g:4930:6: lv_directive_17_0= ruleRmbDirective
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

            // InternalAssembler.g:4948:3: (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_WS) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt67=1;
                }
            }
            switch (alt67) {
                case 1 :
                    // InternalAssembler.g:4949:4: this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_18, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:4953:4: ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:4954:5: (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4954:5: (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4955:6: lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:4972:3: (this_WS_20= RULE_WS )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_WS) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalAssembler.g:4973:4: this_WS_20= RULE_WS
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
    // InternalAssembler.g:4989:1: entryRuleFccDirective returns [EObject current=null] : iv_ruleFccDirective= ruleFccDirective EOF ;
    public final EObject entryRuleFccDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFccDirective = null;


        try {
            // InternalAssembler.g:4989:53: (iv_ruleFccDirective= ruleFccDirective EOF )
            // InternalAssembler.g:4990:2: iv_ruleFccDirective= ruleFccDirective EOF
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
    // InternalAssembler.g:4996:1: ruleFccDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleFccDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_string_2_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5002:2: ( ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) ) )
            // InternalAssembler.g:5003:2: ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) )
            {
            // InternalAssembler.g:5003:2: ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) )
            // InternalAssembler.g:5004:3: ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) )
            {
            // InternalAssembler.g:5004:3: ( (lv_directive_0_0= 'FCC' ) )
            // InternalAssembler.g:5005:4: (lv_directive_0_0= 'FCC' )
            {
            // InternalAssembler.g:5005:4: (lv_directive_0_0= 'FCC' )
            // InternalAssembler.g:5006:5: lv_directive_0_0= 'FCC'
            {
            lv_directive_0_0=(Token)match(input,87,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:5018:3: (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) )
            // InternalAssembler.g:5019:4: this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:5023:4: ( (lv_string_2_0= RULE_STRING ) )
            // InternalAssembler.g:5024:5: (lv_string_2_0= RULE_STRING )
            {
            // InternalAssembler.g:5024:5: (lv_string_2_0= RULE_STRING )
            // InternalAssembler.g:5025:6: lv_string_2_0= RULE_STRING
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
    // InternalAssembler.g:5046:1: entryRuleRegDirective returns [EObject current=null] : iv_ruleRegDirective= ruleRegDirective EOF ;
    public final EObject entryRuleRegDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegDirective = null;


        try {
            // InternalAssembler.g:5046:53: (iv_ruleRegDirective= ruleRegDirective EOF )
            // InternalAssembler.g:5047:2: iv_ruleRegDirective= ruleRegDirective EOF
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
    // InternalAssembler.g:5053:1: ruleRegDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? ) ;
    public final EObject ruleRegDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_options_2_0 = null;

        Enumerator lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5059:2: ( ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? ) )
            // InternalAssembler.g:5060:2: ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? )
            {
            // InternalAssembler.g:5060:2: ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? )
            // InternalAssembler.g:5061:3: ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )?
            {
            // InternalAssembler.g:5061:3: ( (lv_directive_0_0= 'REG' ) )
            // InternalAssembler.g:5062:4: (lv_directive_0_0= 'REG' )
            {
            // InternalAssembler.g:5062:4: (lv_directive_0_0= 'REG' )
            // InternalAssembler.g:5063:5: lv_directive_0_0= 'REG'
            {
            lv_directive_0_0=(Token)match(input,88,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:5075:3: (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_WS) ) {
                int LA70_1 = input.LA(2);

                if ( ((LA70_1>=75 && LA70_1<=81)||(LA70_1>=123 && LA70_1<=125)) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalAssembler.g:5076:4: this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )*
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:5080:4: ( (lv_options_2_0= ruleRegister ) )
                    // InternalAssembler.g:5081:5: (lv_options_2_0= ruleRegister )
                    {
                    // InternalAssembler.g:5081:5: (lv_options_2_0= ruleRegister )
                    // InternalAssembler.g:5082:6: lv_options_2_0= ruleRegister
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

                    // InternalAssembler.g:5099:4: (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==74) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalAssembler.g:5100:5: otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) )
                    	    {
                    	    otherlv_3=(Token)match(input,74,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getRegDirectiveAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:5104:5: ( (lv_options_4_0= ruleRegister ) )
                    	    // InternalAssembler.g:5105:6: (lv_options_4_0= ruleRegister )
                    	    {
                    	    // InternalAssembler.g:5105:6: (lv_options_4_0= ruleRegister )
                    	    // InternalAssembler.g:5106:7: lv_options_4_0= ruleRegister
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
                    	    break loop69;
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
    // InternalAssembler.g:5129:1: entryRuleSpcDirective returns [EObject current=null] : iv_ruleSpcDirective= ruleSpcDirective EOF ;
    public final EObject entryRuleSpcDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpcDirective = null;


        try {
            // InternalAssembler.g:5129:53: (iv_ruleSpcDirective= ruleSpcDirective EOF )
            // InternalAssembler.g:5130:2: iv_ruleSpcDirective= ruleSpcDirective EOF
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
    // InternalAssembler.g:5136:1: ruleSpcDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? ) ;
    public final EObject ruleSpcDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        EObject lv_spaceCount_2_0 = null;

        EObject lv_keepCount_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5142:2: ( ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? ) )
            // InternalAssembler.g:5143:2: ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? )
            {
            // InternalAssembler.g:5143:2: ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? )
            // InternalAssembler.g:5144:3: ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )?
            {
            // InternalAssembler.g:5144:3: ( (lv_directive_0_0= 'SPC' ) )
            // InternalAssembler.g:5145:4: (lv_directive_0_0= 'SPC' )
            {
            // InternalAssembler.g:5145:4: (lv_directive_0_0= 'SPC' )
            // InternalAssembler.g:5146:5: lv_directive_0_0= 'SPC'
            {
            lv_directive_0_0=(Token)match(input,89,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:5158:3: (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_WS) ) {
                int LA72_1 = input.LA(2);

                if ( ((LA72_1>=RULE_ID && LA72_1<=RULE_CHARACTER)||LA72_1==82||LA72_1==84||(LA72_1>=113 && LA72_1<=114)) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalAssembler.g:5159:4: this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )?
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:5163:4: ( (lv_spaceCount_2_0= ruleExpression ) )
                    // InternalAssembler.g:5164:5: (lv_spaceCount_2_0= ruleExpression )
                    {
                    // InternalAssembler.g:5164:5: (lv_spaceCount_2_0= ruleExpression )
                    // InternalAssembler.g:5165:6: lv_spaceCount_2_0= ruleExpression
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

                    // InternalAssembler.g:5182:4: (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==74) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalAssembler.g:5183:5: otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) )
                            {
                            otherlv_3=(Token)match(input,74,FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getSpcDirectiveAccess().getCommaKeyword_1_2_0());
                              				
                            }
                            // InternalAssembler.g:5187:5: ( (lv_keepCount_4_0= ruleExpression ) )
                            // InternalAssembler.g:5188:6: (lv_keepCount_4_0= ruleExpression )
                            {
                            // InternalAssembler.g:5188:6: (lv_keepCount_4_0= ruleExpression )
                            // InternalAssembler.g:5189:7: lv_keepCount_4_0= ruleExpression
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
    // InternalAssembler.g:5212:1: entryRuleNamDirective returns [EObject current=null] : iv_ruleNamDirective= ruleNamDirective EOF ;
    public final EObject entryRuleNamDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamDirective = null;


        try {
            // InternalAssembler.g:5212:53: (iv_ruleNamDirective= ruleNamDirective EOF )
            // InternalAssembler.g:5213:2: iv_ruleNamDirective= ruleNamDirective EOF
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
    // InternalAssembler.g:5219:1: ruleNamDirective returns [EObject current=null] : ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) ) ;
    public final EObject ruleNamDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token lv_directive_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5225:2: ( ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:5226:2: ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:5226:2: ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) )
            // InternalAssembler.g:5227:3: ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) )
            {
            // InternalAssembler.g:5227:3: ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==90) ) {
                alt73=1;
            }
            else if ( (LA73_0==91) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalAssembler.g:5228:4: ( (lv_directive_0_0= 'NAM' ) )
                    {
                    // InternalAssembler.g:5228:4: ( (lv_directive_0_0= 'NAM' ) )
                    // InternalAssembler.g:5229:5: (lv_directive_0_0= 'NAM' )
                    {
                    // InternalAssembler.g:5229:5: (lv_directive_0_0= 'NAM' )
                    // InternalAssembler.g:5230:6: lv_directive_0_0= 'NAM'
                    {
                    lv_directive_0_0=(Token)match(input,90,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:5243:4: ( (lv_directive_1_0= 'TTL' ) )
                    {
                    // InternalAssembler.g:5243:4: ( (lv_directive_1_0= 'TTL' ) )
                    // InternalAssembler.g:5244:5: (lv_directive_1_0= 'TTL' )
                    {
                    // InternalAssembler.g:5244:5: (lv_directive_1_0= 'TTL' )
                    // InternalAssembler.g:5245:6: lv_directive_1_0= 'TTL'
                    {
                    lv_directive_1_0=(Token)match(input,91,FOLLOW_5); if (state.failed) return current;
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

            this_WS_2=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_2, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:5262:3: ( (lv_operand_3_0= ruleIdentifierValue ) )
            // InternalAssembler.g:5263:4: (lv_operand_3_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:5263:4: (lv_operand_3_0= ruleIdentifierValue )
            // InternalAssembler.g:5264:5: lv_operand_3_0= ruleIdentifierValue
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
    // InternalAssembler.g:5285:1: entryRulePagDirective returns [EObject current=null] : iv_rulePagDirective= rulePagDirective EOF ;
    public final EObject entryRulePagDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePagDirective = null;


        try {
            // InternalAssembler.g:5285:53: (iv_rulePagDirective= rulePagDirective EOF )
            // InternalAssembler.g:5286:2: iv_rulePagDirective= rulePagDirective EOF
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
    // InternalAssembler.g:5292:1: rulePagDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? ) ;
    public final EObject rulePagDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5298:2: ( ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? ) )
            // InternalAssembler.g:5299:2: ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? )
            {
            // InternalAssembler.g:5299:2: ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? )
            // InternalAssembler.g:5300:3: ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )?
            {
            // InternalAssembler.g:5300:3: ( (lv_directive_0_0= 'PAG' ) )
            // InternalAssembler.g:5301:4: (lv_directive_0_0= 'PAG' )
            {
            // InternalAssembler.g:5301:4: (lv_directive_0_0= 'PAG' )
            // InternalAssembler.g:5302:5: lv_directive_0_0= 'PAG'
            {
            lv_directive_0_0=(Token)match(input,92,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:5314:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_WS) ) {
                int LA74_1 = input.LA(2);

                if ( ((LA74_1>=RULE_ID && LA74_1<=RULE_CHARACTER)||LA74_1==82||LA74_1==84||(LA74_1>=113 && LA74_1<=114)) ) {
                    alt74=1;
                }
            }
            switch (alt74) {
                case 1 :
                    // InternalAssembler.g:5315:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:5319:4: ( (lv_operand_2_0= ruleExpression ) )
                    // InternalAssembler.g:5320:5: (lv_operand_2_0= ruleExpression )
                    {
                    // InternalAssembler.g:5320:5: (lv_operand_2_0= ruleExpression )
                    // InternalAssembler.g:5321:6: lv_operand_2_0= ruleExpression
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
    // InternalAssembler.g:5343:1: entryRuleOptDirective returns [EObject current=null] : iv_ruleOptDirective= ruleOptDirective EOF ;
    public final EObject entryRuleOptDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptDirective = null;


        try {
            // InternalAssembler.g:5343:53: (iv_ruleOptDirective= ruleOptDirective EOF )
            // InternalAssembler.g:5344:2: iv_ruleOptDirective= ruleOptDirective EOF
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
    // InternalAssembler.g:5350:1: ruleOptDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? ) ;
    public final EObject ruleOptDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_options_2_0 = null;

        Enumerator lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5356:2: ( ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? ) )
            // InternalAssembler.g:5357:2: ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? )
            {
            // InternalAssembler.g:5357:2: ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? )
            // InternalAssembler.g:5358:3: ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )?
            {
            // InternalAssembler.g:5358:3: ( (lv_directive_0_0= 'OPT' ) )
            // InternalAssembler.g:5359:4: (lv_directive_0_0= 'OPT' )
            {
            // InternalAssembler.g:5359:4: (lv_directive_0_0= 'OPT' )
            // InternalAssembler.g:5360:5: lv_directive_0_0= 'OPT'
            {
            lv_directive_0_0=(Token)match(input,93,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:5372:3: (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_WS) ) {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==92||(LA76_1>=116 && LA76_1<=122)) ) {
                    alt76=1;
                }
            }
            switch (alt76) {
                case 1 :
                    // InternalAssembler.g:5373:4: this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )*
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:5377:4: ( (lv_options_2_0= ruleAssemblyOption ) )
                    // InternalAssembler.g:5378:5: (lv_options_2_0= ruleAssemblyOption )
                    {
                    // InternalAssembler.g:5378:5: (lv_options_2_0= ruleAssemblyOption )
                    // InternalAssembler.g:5379:6: lv_options_2_0= ruleAssemblyOption
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

                    // InternalAssembler.g:5396:4: (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==74) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // InternalAssembler.g:5397:5: otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) )
                    	    {
                    	    otherlv_3=(Token)match(input,74,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getOptDirectiveAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:5401:5: ( (lv_options_4_0= ruleAssemblyOption ) )
                    	    // InternalAssembler.g:5402:6: (lv_options_4_0= ruleAssemblyOption )
                    	    {
                    	    // InternalAssembler.g:5402:6: (lv_options_4_0= ruleAssemblyOption )
                    	    // InternalAssembler.g:5403:7: lv_options_4_0= ruleAssemblyOption
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
                    	    break loop75;
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
    // InternalAssembler.g:5426:1: entryRuleFailDirective returns [EObject current=null] : iv_ruleFailDirective= ruleFailDirective EOF ;
    public final EObject entryRuleFailDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailDirective = null;


        try {
            // InternalAssembler.g:5426:54: (iv_ruleFailDirective= ruleFailDirective EOF )
            // InternalAssembler.g:5427:2: iv_ruleFailDirective= ruleFailDirective EOF
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
    // InternalAssembler.g:5433:1: ruleFailDirective returns [EObject current=null] : ( (lv_directive_0_0= 'FAIL' ) ) ;
    public final EObject ruleFailDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5439:2: ( ( (lv_directive_0_0= 'FAIL' ) ) )
            // InternalAssembler.g:5440:2: ( (lv_directive_0_0= 'FAIL' ) )
            {
            // InternalAssembler.g:5440:2: ( (lv_directive_0_0= 'FAIL' ) )
            // InternalAssembler.g:5441:3: (lv_directive_0_0= 'FAIL' )
            {
            // InternalAssembler.g:5441:3: (lv_directive_0_0= 'FAIL' )
            // InternalAssembler.g:5442:4: lv_directive_0_0= 'FAIL'
            {
            lv_directive_0_0=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:5457:1: entryRuleSetDirective returns [EObject current=null] : iv_ruleSetDirective= ruleSetDirective EOF ;
    public final EObject entryRuleSetDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDirective = null;


        try {
            // InternalAssembler.g:5457:53: (iv_ruleSetDirective= ruleSetDirective EOF )
            // InternalAssembler.g:5458:2: iv_ruleSetDirective= ruleSetDirective EOF
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
    // InternalAssembler.g:5464:1: ruleSetDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) ;
    public final EObject ruleSetDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5470:2: ( ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) )
            // InternalAssembler.g:5471:2: ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            {
            // InternalAssembler.g:5471:2: ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            // InternalAssembler.g:5472:3: ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            {
            // InternalAssembler.g:5472:3: ( (lv_directive_0_0= 'SET' ) )
            // InternalAssembler.g:5473:4: (lv_directive_0_0= 'SET' )
            {
            // InternalAssembler.g:5473:4: (lv_directive_0_0= 'SET' )
            // InternalAssembler.g:5474:5: lv_directive_0_0= 'SET'
            {
            lv_directive_0_0=(Token)match(input,95,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:5490:3: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==96) ) {
                int LA78_1 = input.LA(2);

                if ( (LA78_1==EOF||LA78_1==RULE_WS||(LA78_1>=RULE_CR && LA78_1<=RULE_END_OF_FILE)) ) {
                    alt78=2;
                }
                else if ( ((LA78_1>=RULE_ID && LA78_1<=RULE_CHARACTER)||LA78_1==82||LA78_1==84||(LA78_1>=113 && LA78_1<=114)) ) {
                    alt78=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA78_0>=RULE_ID && LA78_0<=RULE_CHARACTER)||LA78_0==82||LA78_0==84||(LA78_0>=113 && LA78_0<=114)) ) {
                alt78=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalAssembler.g:5491:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:5491:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:5492:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:5492:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==96) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalAssembler.g:5493:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:5493:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:5494:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,96,FOLLOW_12); if (state.failed) return current;
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

                    // InternalAssembler.g:5506:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:5507:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:5507:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:5508:7: lv_operand_3_0= ruleExpression
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
                    // InternalAssembler.g:5527:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    {
                    // InternalAssembler.g:5527:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    // InternalAssembler.g:5528:5: (lv_isRelativeToPC_4_0= '*' )
                    {
                    // InternalAssembler.g:5528:5: (lv_isRelativeToPC_4_0= '*' )
                    // InternalAssembler.g:5529:6: lv_isRelativeToPC_4_0= '*'
                    {
                    lv_isRelativeToPC_4_0=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:5546:1: entryRuleFillDirective returns [EObject current=null] : iv_ruleFillDirective= ruleFillDirective EOF ;
    public final EObject entryRuleFillDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFillDirective = null;


        try {
            // InternalAssembler.g:5546:54: (iv_ruleFillDirective= ruleFillDirective EOF )
            // InternalAssembler.g:5547:2: iv_ruleFillDirective= ruleFillDirective EOF
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
    // InternalAssembler.g:5553:1: ruleFillDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) ) ;
    public final EObject ruleFillDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;

        EObject lv_number_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5559:2: ( ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) ) )
            // InternalAssembler.g:5560:2: ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) )
            {
            // InternalAssembler.g:5560:2: ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) )
            // InternalAssembler.g:5561:3: ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:5561:3: ( (lv_directive_0_0= 'FILL' ) )
            // InternalAssembler.g:5562:4: (lv_directive_0_0= 'FILL' )
            {
            // InternalAssembler.g:5562:4: (lv_directive_0_0= 'FILL' )
            // InternalAssembler.g:5563:5: lv_directive_0_0= 'FILL'
            {
            lv_directive_0_0=(Token)match(input,97,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:5575:3: (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) )
            // InternalAssembler.g:5576:4: this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:5580:4: ( (lv_value_2_0= ruleExpression ) )
            // InternalAssembler.g:5581:5: (lv_value_2_0= ruleExpression )
            {
            // InternalAssembler.g:5581:5: (lv_value_2_0= ruleExpression )
            // InternalAssembler.g:5582:6: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getFillDirectiveAccess().getValueExpressionParserRuleCall_1_1_0());
              					
            }
            pushFollow(FOLLOW_14);
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

            otherlv_3=(Token)match(input,74,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_3, grammarAccess.getFillDirectiveAccess().getCommaKeyword_1_2());
              			
            }
            // InternalAssembler.g:5603:4: ( (lv_number_4_0= ruleExpression ) )
            // InternalAssembler.g:5604:5: (lv_number_4_0= ruleExpression )
            {
            // InternalAssembler.g:5604:5: (lv_number_4_0= ruleExpression )
            // InternalAssembler.g:5605:6: lv_number_4_0= ruleExpression
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
    // InternalAssembler.g:5627:1: entryRuleBszDirective returns [EObject current=null] : iv_ruleBszDirective= ruleBszDirective EOF ;
    public final EObject entryRuleBszDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBszDirective = null;


        try {
            // InternalAssembler.g:5627:53: (iv_ruleBszDirective= ruleBszDirective EOF )
            // InternalAssembler.g:5628:2: iv_ruleBszDirective= ruleBszDirective EOF
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
    // InternalAssembler.g:5634:1: ruleBszDirective returns [EObject current=null] : ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) ) ;
    public final EObject ruleBszDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_1=null;
        Token lv_directive_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5640:2: ( ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) ) )
            // InternalAssembler.g:5641:2: ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) )
            {
            // InternalAssembler.g:5641:2: ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) )
            // InternalAssembler.g:5642:3: ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:5642:3: ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) )
            // InternalAssembler.g:5643:4: ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) )
            {
            // InternalAssembler.g:5643:4: ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) )
            // InternalAssembler.g:5644:5: (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' )
            {
            // InternalAssembler.g:5644:5: (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==98) ) {
                alt79=1;
            }
            else if ( (LA79_0==99) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalAssembler.g:5645:6: lv_directive_0_1= 'BSZ'
                    {
                    lv_directive_0_1=(Token)match(input,98,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:5656:6: lv_directive_0_2= 'ZMB'
                    {
                    lv_directive_0_2=(Token)match(input,99,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:5669:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )
            // InternalAssembler.g:5670:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:5674:4: ( (lv_operand_2_0= ruleExpression ) )
            // InternalAssembler.g:5675:5: (lv_operand_2_0= ruleExpression )
            {
            // InternalAssembler.g:5675:5: (lv_operand_2_0= ruleExpression )
            // InternalAssembler.g:5676:6: lv_operand_2_0= ruleExpression
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
    // InternalAssembler.g:5698:1: entryRuleFdbDirective returns [EObject current=null] : iv_ruleFdbDirective= ruleFdbDirective EOF ;
    public final EObject entryRuleFdbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFdbDirective = null;


        try {
            // InternalAssembler.g:5698:53: (iv_ruleFdbDirective= ruleFdbDirective EOF )
            // InternalAssembler.g:5699:2: iv_ruleFdbDirective= ruleFdbDirective EOF
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
    // InternalAssembler.g:5705:1: ruleFdbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) ;
    public final EObject ruleFdbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5711:2: ( ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) )
            // InternalAssembler.g:5712:2: ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            {
            // InternalAssembler.g:5712:2: ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            // InternalAssembler.g:5713:3: ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            {
            // InternalAssembler.g:5713:3: ( (lv_directive_0_0= 'FDB' ) )
            // InternalAssembler.g:5714:4: (lv_directive_0_0= 'FDB' )
            {
            // InternalAssembler.g:5714:4: (lv_directive_0_0= 'FDB' )
            // InternalAssembler.g:5715:5: lv_directive_0_0= 'FDB'
            {
            lv_directive_0_0=(Token)match(input,100,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:5727:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_WS) ) {
                int LA80_1 = input.LA(2);

                if ( ((LA80_1>=RULE_ID && LA80_1<=RULE_CHARACTER)||LA80_1==82||LA80_1==84||(LA80_1>=113 && LA80_1<=114)) ) {
                    alt80=1;
                }
            }
            switch (alt80) {
                case 1 :
                    // InternalAssembler.g:5728:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:5732:4: ( (lv_operand_2_0= ruleListOfExpression ) )
                    // InternalAssembler.g:5733:5: (lv_operand_2_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:5733:5: (lv_operand_2_0= ruleListOfExpression )
                    // InternalAssembler.g:5734:6: lv_operand_2_0= ruleListOfExpression
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
    // InternalAssembler.g:5756:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:5756:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:5757:2: iv_ruleFcbDirective= ruleFcbDirective EOF
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
    // InternalAssembler.g:5763:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) ;
    public final EObject ruleFcbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5769:2: ( ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) )
            // InternalAssembler.g:5770:2: ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            {
            // InternalAssembler.g:5770:2: ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            // InternalAssembler.g:5771:3: ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            {
            // InternalAssembler.g:5771:3: ( (lv_directive_0_0= 'FCB' ) )
            // InternalAssembler.g:5772:4: (lv_directive_0_0= 'FCB' )
            {
            // InternalAssembler.g:5772:4: (lv_directive_0_0= 'FCB' )
            // InternalAssembler.g:5773:5: lv_directive_0_0= 'FCB'
            {
            lv_directive_0_0=(Token)match(input,101,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:5785:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_WS) ) {
                int LA81_1 = input.LA(2);

                if ( ((LA81_1>=RULE_ID && LA81_1<=RULE_CHARACTER)||LA81_1==82||LA81_1==84||(LA81_1>=113 && LA81_1<=114)) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // InternalAssembler.g:5786:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:5790:4: ( (lv_operand_2_0= ruleListOfExpression ) )
                    // InternalAssembler.g:5791:5: (lv_operand_2_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:5791:5: (lv_operand_2_0= ruleListOfExpression )
                    // InternalAssembler.g:5792:6: lv_operand_2_0= ruleListOfExpression
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
    // InternalAssembler.g:5814:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:5814:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:5815:2: iv_ruleRmbDirective= ruleRmbDirective EOF
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
    // InternalAssembler.g:5821:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? ) ;
    public final EObject ruleRmbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5827:2: ( ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? ) )
            // InternalAssembler.g:5828:2: ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? )
            {
            // InternalAssembler.g:5828:2: ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? )
            // InternalAssembler.g:5829:3: ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )?
            {
            // InternalAssembler.g:5829:3: ( (lv_directive_0_0= 'RMB' ) )
            // InternalAssembler.g:5830:4: (lv_directive_0_0= 'RMB' )
            {
            // InternalAssembler.g:5830:4: (lv_directive_0_0= 'RMB' )
            // InternalAssembler.g:5831:5: lv_directive_0_0= 'RMB'
            {
            lv_directive_0_0=(Token)match(input,102,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:5843:3: (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_WS) ) {
                int LA83_1 = input.LA(2);

                if ( ((LA83_1>=RULE_ID && LA83_1<=RULE_CHARACTER)||LA83_1==82||LA83_1==84||LA83_1==96||(LA83_1>=113 && LA83_1<=114)) ) {
                    alt83=1;
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalAssembler.g:5844:4: this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:5848:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:5849:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:5849:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==96) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // InternalAssembler.g:5850:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:5850:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:5851:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,96,FOLLOW_12); if (state.failed) return current;
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

                    // InternalAssembler.g:5863:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:5864:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:5864:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:5865:7: lv_operand_3_0= ruleExpression
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
    // InternalAssembler.g:5888:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:5888:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:5889:2: iv_ruleEndDirective= ruleEndDirective EOF
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
    // InternalAssembler.g:5895:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) ;
    public final EObject ruleEndDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5901:2: ( ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) )
            // InternalAssembler.g:5902:2: ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            {
            // InternalAssembler.g:5902:2: ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            // InternalAssembler.g:5903:3: ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            {
            // InternalAssembler.g:5903:3: ( (lv_directive_0_0= 'END' ) )
            // InternalAssembler.g:5904:4: (lv_directive_0_0= 'END' )
            {
            // InternalAssembler.g:5904:4: (lv_directive_0_0= 'END' )
            // InternalAssembler.g:5905:5: lv_directive_0_0= 'END'
            {
            lv_directive_0_0=(Token)match(input,103,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:5917:3: (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_WS) ) {
                int LA86_1 = input.LA(2);

                if ( ((LA86_1>=RULE_ID && LA86_1<=RULE_CHARACTER)||LA86_1==82||LA86_1==84||LA86_1==96||(LA86_1>=113 && LA86_1<=114)) ) {
                    alt86=1;
                }
            }
            switch (alt86) {
                case 1 :
                    // InternalAssembler.g:5918:4: this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:5922:4: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==96) ) {
                        int LA85_1 = input.LA(2);

                        if ( ((LA85_1>=RULE_ID && LA85_1<=RULE_CHARACTER)||LA85_1==82||LA85_1==84||(LA85_1>=113 && LA85_1<=114)) ) {
                            alt85=1;
                        }
                        else if ( (LA85_1==EOF||LA85_1==RULE_WS||(LA85_1>=RULE_CR && LA85_1<=RULE_END_OF_FILE)) ) {
                            alt85=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 85, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA85_0>=RULE_ID && LA85_0<=RULE_CHARACTER)||LA85_0==82||LA85_0==84||(LA85_0>=113 && LA85_0<=114)) ) {
                        alt85=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;
                    }
                    switch (alt85) {
                        case 1 :
                            // InternalAssembler.g:5923:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:5923:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            // InternalAssembler.g:5924:6: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:5924:6: ( (lv_isRelativeToPC_2_0= '*' ) )?
                            int alt84=2;
                            int LA84_0 = input.LA(1);

                            if ( (LA84_0==96) ) {
                                alt84=1;
                            }
                            switch (alt84) {
                                case 1 :
                                    // InternalAssembler.g:5925:7: (lv_isRelativeToPC_2_0= '*' )
                                    {
                                    // InternalAssembler.g:5925:7: (lv_isRelativeToPC_2_0= '*' )
                                    // InternalAssembler.g:5926:8: lv_isRelativeToPC_2_0= '*'
                                    {
                                    lv_isRelativeToPC_2_0=(Token)match(input,96,FOLLOW_12); if (state.failed) return current;
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

                            // InternalAssembler.g:5938:6: ( (lv_operand_3_0= ruleExpression ) )
                            // InternalAssembler.g:5939:7: (lv_operand_3_0= ruleExpression )
                            {
                            // InternalAssembler.g:5939:7: (lv_operand_3_0= ruleExpression )
                            // InternalAssembler.g:5940:8: lv_operand_3_0= ruleExpression
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
                            // InternalAssembler.g:5959:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            {
                            // InternalAssembler.g:5959:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            // InternalAssembler.g:5960:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:5960:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:5961:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:5979:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:5979:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:5980:2: iv_ruleOrgDirective= ruleOrgDirective EOF
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
    // InternalAssembler.g:5986:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) ;
    public final EObject ruleOrgDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5992:2: ( ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) )
            // InternalAssembler.g:5993:2: ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            {
            // InternalAssembler.g:5993:2: ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            // InternalAssembler.g:5994:3: ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            {
            // InternalAssembler.g:5994:3: ( (lv_directive_0_0= 'ORG' ) )
            // InternalAssembler.g:5995:4: (lv_directive_0_0= 'ORG' )
            {
            // InternalAssembler.g:5995:4: (lv_directive_0_0= 'ORG' )
            // InternalAssembler.g:5996:5: lv_directive_0_0= 'ORG'
            {
            lv_directive_0_0=(Token)match(input,104,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:6008:3: (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_WS) ) {
                int LA89_1 = input.LA(2);

                if ( ((LA89_1>=RULE_ID && LA89_1<=RULE_CHARACTER)||LA89_1==82||LA89_1==84||LA89_1==96||(LA89_1>=113 && LA89_1<=114)) ) {
                    alt89=1;
                }
            }
            switch (alt89) {
                case 1 :
                    // InternalAssembler.g:6009:4: this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:6013:4: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==96) ) {
                        int LA88_1 = input.LA(2);

                        if ( (LA88_1==EOF||LA88_1==RULE_WS||(LA88_1>=RULE_CR && LA88_1<=RULE_END_OF_FILE)) ) {
                            alt88=2;
                        }
                        else if ( ((LA88_1>=RULE_ID && LA88_1<=RULE_CHARACTER)||LA88_1==82||LA88_1==84||(LA88_1>=113 && LA88_1<=114)) ) {
                            alt88=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 88, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA88_0>=RULE_ID && LA88_0<=RULE_CHARACTER)||LA88_0==82||LA88_0==84||(LA88_0>=113 && LA88_0<=114)) ) {
                        alt88=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 88, 0, input);

                        throw nvae;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalAssembler.g:6014:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:6014:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            // InternalAssembler.g:6015:6: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:6015:6: ( (lv_isRelativeToPC_2_0= '*' ) )?
                            int alt87=2;
                            int LA87_0 = input.LA(1);

                            if ( (LA87_0==96) ) {
                                alt87=1;
                            }
                            switch (alt87) {
                                case 1 :
                                    // InternalAssembler.g:6016:7: (lv_isRelativeToPC_2_0= '*' )
                                    {
                                    // InternalAssembler.g:6016:7: (lv_isRelativeToPC_2_0= '*' )
                                    // InternalAssembler.g:6017:8: lv_isRelativeToPC_2_0= '*'
                                    {
                                    lv_isRelativeToPC_2_0=(Token)match(input,96,FOLLOW_12); if (state.failed) return current;
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

                            // InternalAssembler.g:6029:6: ( (lv_operand_3_0= ruleExpression ) )
                            // InternalAssembler.g:6030:7: (lv_operand_3_0= ruleExpression )
                            {
                            // InternalAssembler.g:6030:7: (lv_operand_3_0= ruleExpression )
                            // InternalAssembler.g:6031:8: lv_operand_3_0= ruleExpression
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
                            // InternalAssembler.g:6050:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            {
                            // InternalAssembler.g:6050:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            // InternalAssembler.g:6051:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:6051:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:6052:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:6070:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:6070:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:6071:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:6077:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) ;
    public final EObject ruleEquDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6083:2: ( ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) )
            // InternalAssembler.g:6084:2: ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            {
            // InternalAssembler.g:6084:2: ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            // InternalAssembler.g:6085:3: ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            {
            // InternalAssembler.g:6085:3: ( (lv_directive_0_0= 'EQU' ) )
            // InternalAssembler.g:6086:4: (lv_directive_0_0= 'EQU' )
            {
            // InternalAssembler.g:6086:4: (lv_directive_0_0= 'EQU' )
            // InternalAssembler.g:6087:5: lv_directive_0_0= 'EQU'
            {
            lv_directive_0_0=(Token)match(input,105,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:6103:3: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==96) ) {
                int LA91_1 = input.LA(2);

                if ( ((LA91_1>=RULE_ID && LA91_1<=RULE_CHARACTER)||LA91_1==82||LA91_1==84||(LA91_1>=113 && LA91_1<=114)) ) {
                    alt91=1;
                }
                else if ( (LA91_1==EOF||LA91_1==RULE_WS||(LA91_1>=RULE_CR && LA91_1<=RULE_END_OF_FILE)) ) {
                    alt91=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA91_0>=RULE_ID && LA91_0<=RULE_CHARACTER)||LA91_0==82||LA91_0==84||(LA91_0>=113 && LA91_0<=114)) ) {
                alt91=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalAssembler.g:6104:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:6104:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:6105:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:6105:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==96) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // InternalAssembler.g:6106:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:6106:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:6107:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,96,FOLLOW_12); if (state.failed) return current;
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

                    // InternalAssembler.g:6119:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:6120:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:6120:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:6121:7: lv_operand_3_0= ruleExpression
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
                    // InternalAssembler.g:6140:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    {
                    // InternalAssembler.g:6140:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    // InternalAssembler.g:6141:5: (lv_isRelativeToPC_4_0= '*' )
                    {
                    // InternalAssembler.g:6141:5: (lv_isRelativeToPC_4_0= '*' )
                    // InternalAssembler.g:6142:6: lv_isRelativeToPC_4_0= '*'
                    {
                    lv_isRelativeToPC_4_0=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:6159:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:6159:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:6160:2: iv_ruleListOfExpression= ruleListOfExpression EOF
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
    // InternalAssembler.g:6166:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6172:2: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalAssembler.g:6173:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalAssembler.g:6173:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalAssembler.g:6174:3: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalAssembler.g:6174:3: ( (lv_expressions_0_0= ruleExpression ) )
            // InternalAssembler.g:6175:4: (lv_expressions_0_0= ruleExpression )
            {
            // InternalAssembler.g:6175:4: (lv_expressions_0_0= ruleExpression )
            // InternalAssembler.g:6176:5: lv_expressions_0_0= ruleExpression
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

            // InternalAssembler.g:6193:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==74) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalAssembler.g:6194:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,74,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:6198:4: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalAssembler.g:6199:5: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalAssembler.g:6199:5: (lv_expressions_2_0= ruleExpression )
            	    // InternalAssembler.g:6200:6: lv_expressions_2_0= ruleExpression
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
            	    break loop92;
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
    // InternalAssembler.g:6222:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:6222:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:6223:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalAssembler.g:6229:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6235:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:6236:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:6236:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:6237:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:6237:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:6238:4: lv_operand_0_0= ruleMultiplication
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
    // InternalAssembler.g:6258:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:6258:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:6259:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:6265:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6271:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:6272:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:6272:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:6273:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
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
            // InternalAssembler.g:6281:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==96) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalAssembler.g:6282:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:6282:4: ()
            	    // InternalAssembler.g:6283:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:6289:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:6290:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:6290:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:6291:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,96,FOLLOW_12); if (state.failed) return current;
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

            	    // InternalAssembler.g:6303:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:6304:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:6304:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:6305:6: lv_right_3_0= ruleDivision
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
            	    break loop93;
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
    // InternalAssembler.g:6327:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:6327:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:6328:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:6334:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6340:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:6341:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:6341:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:6342:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
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
            // InternalAssembler.g:6350:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==106) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalAssembler.g:6351:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:6351:4: ()
            	    // InternalAssembler.g:6352:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:6358:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:6359:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:6359:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:6360:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,106,FOLLOW_12); if (state.failed) return current;
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

            	    // InternalAssembler.g:6372:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:6373:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:6373:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:6374:6: lv_right_3_0= ruleModulo
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
            	    break loop94;
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
    // InternalAssembler.g:6396:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:6396:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:6397:2: iv_ruleModulo= ruleModulo EOF
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
    // InternalAssembler.g:6403:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6409:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:6410:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:6410:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:6411:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
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
            // InternalAssembler.g:6419:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==107) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalAssembler.g:6420:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:6420:4: ()
            	    // InternalAssembler.g:6421:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:6427:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:6428:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:6428:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:6429:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,107,FOLLOW_12); if (state.failed) return current;
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

            	    // InternalAssembler.g:6441:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:6442:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:6442:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:6443:6: lv_right_3_0= ruleAddition
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
            	    break loop95;
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
    // InternalAssembler.g:6465:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:6465:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:6466:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:6472:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6478:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:6479:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:6479:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:6480:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
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
            // InternalAssembler.g:6488:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==84) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalAssembler.g:6489:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:6489:4: ()
            	    // InternalAssembler.g:6490:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,84,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6500:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:6501:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:6501:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:6502:6: lv_right_3_0= ruleSubstraction
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
            	    break loop96;
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
    // InternalAssembler.g:6524:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:6524:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:6525:2: iv_ruleSubstraction= ruleSubstraction EOF
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
    // InternalAssembler.g:6531:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6537:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:6538:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:6538:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:6539:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
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
            // InternalAssembler.g:6547:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==82) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalAssembler.g:6548:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:6548:4: ()
            	    // InternalAssembler.g:6549:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:6555:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:6556:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,82,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:6562:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:6563:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:6563:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:6564:6: lv_right_3_0= ruleLeftShift
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
            	    break loop97;
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
    // InternalAssembler.g:6586:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:6586:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:6587:2: iv_ruleLeftShift= ruleLeftShift EOF
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
    // InternalAssembler.g:6593:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6599:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:6600:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:6600:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:6601:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
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
            // InternalAssembler.g:6609:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==108) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalAssembler.g:6610:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:6610:4: ()
            	    // InternalAssembler.g:6611:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,108,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6621:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:6622:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:6622:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:6623:6: lv_right_3_0= ruleRightShift
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
            	    break loop98;
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
    // InternalAssembler.g:6645:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:6645:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:6646:2: iv_ruleRightShift= ruleRightShift EOF
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
    // InternalAssembler.g:6652:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6658:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:6659:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:6659:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:6660:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
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
            // InternalAssembler.g:6668:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==109) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalAssembler.g:6669:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:6669:4: ()
            	    // InternalAssembler.g:6670:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,109,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6680:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:6681:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:6681:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:6682:6: lv_right_3_0= ruleAnd
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
            	    break loop99;
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
    // InternalAssembler.g:6704:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:6704:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:6705:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalAssembler.g:6711:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6717:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:6718:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:6718:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:6719:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
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
            // InternalAssembler.g:6727:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==110) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalAssembler.g:6728:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:6728:4: ()
            	    // InternalAssembler.g:6729:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,110,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6739:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:6740:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:6740:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:6741:6: lv_right_3_0= ruleOr
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
            	    break loop100;
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
    // InternalAssembler.g:6763:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:6763:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:6764:2: iv_ruleOr= ruleOr EOF
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
    // InternalAssembler.g:6770:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6776:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:6777:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:6777:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:6778:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
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
            // InternalAssembler.g:6786:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==111) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalAssembler.g:6787:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:6787:4: ()
            	    // InternalAssembler.g:6788:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,111,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6798:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:6799:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:6799:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:6800:6: lv_right_3_0= ruleXor
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
            	    break loop101;
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
    // InternalAssembler.g:6822:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:6822:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:6823:2: iv_ruleXor= ruleXor EOF
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
    // InternalAssembler.g:6829:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6835:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:6836:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:6836:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:6837:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
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
            // InternalAssembler.g:6845:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==112) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalAssembler.g:6846:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:6846:4: ()
            	    // InternalAssembler.g:6847:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,112,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6857:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:6858:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:6858:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:6859:6: lv_right_3_0= rulePrimary
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
            	    break loop102;
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
    // InternalAssembler.g:6881:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:6881:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:6882:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:6888:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
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
            // InternalAssembler.g:6894:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:6895:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:6895:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt103=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 82:
            case 84:
                {
                alt103=1;
                }
                break;
            case RULE_HEXA:
                {
                alt103=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt103=3;
                }
                break;
            case RULE_BINARY:
                {
                alt103=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt103=5;
                }
                break;
            case RULE_ID:
                {
                alt103=6;
                }
                break;
            case 113:
                {
                alt103=7;
                }
                break;
            case 114:
                {
                alt103=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // InternalAssembler.g:6896:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:6896:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:6897:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:6897:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:6898:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:6916:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:6916:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:6917:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:6917:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:6918:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:6936:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:6936:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:6937:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:6937:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:6938:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:6956:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:6956:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:6957:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:6957:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:6958:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:6976:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:6976:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:6977:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:6977:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:6978:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:6996:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:6996:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:6997:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:6997:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:6998:5: lv_value_5_0= ruleIdentifierValue
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
                    // InternalAssembler.g:7016:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:7016:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:7017:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:7017:4: ()
                    // InternalAssembler.g:7018:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,113,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:7028:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:7029:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:7029:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:7030:6: lv_value_8_0= rulePrimary
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
                    // InternalAssembler.g:7049:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:7049:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:7050:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,114,FOLLOW_12); if (state.failed) return current;
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
                    otherlv_11=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:7071:1: entryRuleNumericalValue returns [EObject current=null] : iv_ruleNumericalValue= ruleNumericalValue EOF ;
    public final EObject entryRuleNumericalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalValue = null;


        try {
            // InternalAssembler.g:7071:55: (iv_ruleNumericalValue= ruleNumericalValue EOF )
            // InternalAssembler.g:7072:2: iv_ruleNumericalValue= ruleNumericalValue EOF
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
    // InternalAssembler.g:7078:1: ruleNumericalValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) ;
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
            // InternalAssembler.g:7084:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:7085:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:7085:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            int alt104=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 82:
            case 84:
                {
                alt104=1;
                }
                break;
            case RULE_HEXA:
                {
                alt104=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt104=3;
                }
                break;
            case RULE_BINARY:
                {
                alt104=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt104=5;
                }
                break;
            case RULE_ID:
                {
                alt104=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // InternalAssembler.g:7086:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:7086:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:7087:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:7087:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:7088:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:7106:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:7106:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:7107:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:7107:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:7108:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:7126:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:7126:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:7127:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:7127:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:7128:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:7146:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:7146:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:7147:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:7147:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:7148:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:7166:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:7166:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:7167:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:7167:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:7168:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:7186:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:7186:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:7187:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:7187:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:7188:5: lv_value_5_0= ruleIdentifierValue
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
    // InternalAssembler.g:7209:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:7209:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:7210:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
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
    // InternalAssembler.g:7216:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:7222:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:7223:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:7223:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:7224:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:7224:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:7225:4: lv_value_0_0= RULE_ID
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
    // InternalAssembler.g:7244:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:7244:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:7245:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalAssembler.g:7251:1: ruleDecimalValue returns [EObject current=null] : ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_sign_0_1=null;
        Token lv_sign_0_2=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:7257:2: ( ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:7258:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:7258:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:7259:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:7259:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==82||LA106_0==84) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalAssembler.g:7260:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    {
                    // InternalAssembler.g:7260:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    // InternalAssembler.g:7261:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    {
                    // InternalAssembler.g:7261:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==82) ) {
                        alt105=1;
                    }
                    else if ( (LA105_0==84) ) {
                        alt105=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 105, 0, input);

                        throw nvae;
                    }
                    switch (alt105) {
                        case 1 :
                            // InternalAssembler.g:7262:6: lv_sign_0_1= '-'
                            {
                            lv_sign_0_1=(Token)match(input,82,FOLLOW_39); if (state.failed) return current;
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
                            // InternalAssembler.g:7273:6: lv_sign_0_2= '+'
                            {
                            lv_sign_0_2=(Token)match(input,84,FOLLOW_39); if (state.failed) return current;
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

            // InternalAssembler.g:7286:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:7287:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:7287:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:7288:5: lv_value_1_0= RULE_INT
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
    // InternalAssembler.g:7308:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:7308:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:7309:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
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
    // InternalAssembler.g:7315:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:7321:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:7322:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:7322:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:7323:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:7323:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:7324:4: lv_value_0_0= RULE_HEXA
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
    // InternalAssembler.g:7343:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:7343:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:7344:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:7350:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:7356:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:7357:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:7357:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:7358:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:7358:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:7359:4: lv_value_0_0= RULE_OCTAL
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
    // InternalAssembler.g:7378:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:7378:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:7379:2: iv_ruleBinaryValue= ruleBinaryValue EOF
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
    // InternalAssembler.g:7385:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:7391:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:7392:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:7392:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:7393:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:7393:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:7394:4: lv_value_0_0= RULE_BINARY
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
    // InternalAssembler.g:7413:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:7413:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:7414:2: iv_ruleCharacterValue= ruleCharacterValue EOF
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
    // InternalAssembler.g:7420:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:7426:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:7427:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:7427:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:7428:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:7428:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:7429:4: lv_value_0_0= RULE_CHARACTER
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
    // InternalAssembler.g:7448:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:7448:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:7449:2: iv_ruleEndOfLine= ruleEndOfLine EOF
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
    // InternalAssembler.g:7455:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:7461:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:7462:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:7462:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==RULE_CR) ) {
                alt107=1;
            }
            else if ( (LA107_0==RULE_END_OF_FILE) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // InternalAssembler.g:7463:3: this_CR_0= RULE_CR
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
                    // InternalAssembler.g:7471:3: this_END_OF_FILE_1= RULE_END_OF_FILE
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
    // InternalAssembler.g:7482:1: ruleAssemblyOption returns [Enumerator current=null] : ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) ;
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
            // InternalAssembler.g:7488:2: ( ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) )
            // InternalAssembler.g:7489:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            {
            // InternalAssembler.g:7489:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            int alt108=8;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt108=1;
                }
                break;
            case 116:
                {
                alt108=2;
                }
                break;
            case 117:
                {
                alt108=3;
                }
                break;
            case 118:
                {
                alt108=4;
                }
                break;
            case 119:
                {
                alt108=5;
                }
                break;
            case 120:
                {
                alt108=6;
                }
                break;
            case 121:
                {
                alt108=7;
                }
                break;
            case 122:
                {
                alt108=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalAssembler.g:7490:3: (enumLiteral_0= 'PAG' )
                    {
                    // InternalAssembler.g:7490:3: (enumLiteral_0= 'PAG' )
                    // InternalAssembler.g:7491:4: enumLiteral_0= 'PAG'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:7498:3: (enumLiteral_1= 'NOP' )
                    {
                    // InternalAssembler.g:7498:3: (enumLiteral_1= 'NOP' )
                    // InternalAssembler.g:7499:4: enumLiteral_1= 'NOP'
                    {
                    enumLiteral_1=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:7506:3: (enumLiteral_2= 'CON' )
                    {
                    // InternalAssembler.g:7506:3: (enumLiteral_2= 'CON' )
                    // InternalAssembler.g:7507:4: enumLiteral_2= 'CON'
                    {
                    enumLiteral_2=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:7514:3: (enumLiteral_3= 'NOC' )
                    {
                    // InternalAssembler.g:7514:3: (enumLiteral_3= 'NOC' )
                    // InternalAssembler.g:7515:4: enumLiteral_3= 'NOC'
                    {
                    enumLiteral_3=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:7522:3: (enumLiteral_4= 'MAC' )
                    {
                    // InternalAssembler.g:7522:3: (enumLiteral_4= 'MAC' )
                    // InternalAssembler.g:7523:4: enumLiteral_4= 'MAC'
                    {
                    enumLiteral_4=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:7530:3: (enumLiteral_5= 'NOM' )
                    {
                    // InternalAssembler.g:7530:3: (enumLiteral_5= 'NOM' )
                    // InternalAssembler.g:7531:4: enumLiteral_5= 'NOM'
                    {
                    enumLiteral_5=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:7538:3: (enumLiteral_6= 'EXP' )
                    {
                    // InternalAssembler.g:7538:3: (enumLiteral_6= 'EXP' )
                    // InternalAssembler.g:7539:4: enumLiteral_6= 'EXP'
                    {
                    enumLiteral_6=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:7546:3: (enumLiteral_7= 'NOE' )
                    {
                    // InternalAssembler.g:7546:3: (enumLiteral_7= 'NOE' )
                    // InternalAssembler.g:7547:4: enumLiteral_7= 'NOE'
                    {
                    enumLiteral_7=(Token)match(input,122,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:7557:1: ruleRegister returns [Enumerator current=null] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) ;
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
            // InternalAssembler.g:7563:2: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) )
            // InternalAssembler.g:7564:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            {
            // InternalAssembler.g:7564:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            int alt109=10;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt109=1;
                }
                break;
            case 80:
                {
                alt109=2;
                }
                break;
            case 81:
                {
                alt109=3;
                }
                break;
            case 77:
                {
                alt109=4;
                }
                break;
            case 78:
                {
                alt109=5;
                }
                break;
            case 76:
                {
                alt109=6;
                }
                break;
            case 75:
                {
                alt109=7;
                }
                break;
            case 123:
                {
                alt109=8;
                }
                break;
            case 124:
                {
                alt109=9;
                }
                break;
            case 125:
                {
                alt109=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // InternalAssembler.g:7565:3: (enumLiteral_0= 'A' )
                    {
                    // InternalAssembler.g:7565:3: (enumLiteral_0= 'A' )
                    // InternalAssembler.g:7566:4: enumLiteral_0= 'A'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:7573:3: (enumLiteral_1= 'B' )
                    {
                    // InternalAssembler.g:7573:3: (enumLiteral_1= 'B' )
                    // InternalAssembler.g:7574:4: enumLiteral_1= 'B'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:7581:3: (enumLiteral_2= 'D' )
                    {
                    // InternalAssembler.g:7581:3: (enumLiteral_2= 'D' )
                    // InternalAssembler.g:7582:4: enumLiteral_2= 'D'
                    {
                    enumLiteral_2=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:7589:3: (enumLiteral_3= 'X' )
                    {
                    // InternalAssembler.g:7589:3: (enumLiteral_3= 'X' )
                    // InternalAssembler.g:7590:4: enumLiteral_3= 'X'
                    {
                    enumLiteral_3=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:7597:3: (enumLiteral_4= 'Y' )
                    {
                    // InternalAssembler.g:7597:3: (enumLiteral_4= 'Y' )
                    // InternalAssembler.g:7598:4: enumLiteral_4= 'Y'
                    {
                    enumLiteral_4=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:7605:3: (enumLiteral_5= 'U' )
                    {
                    // InternalAssembler.g:7605:3: (enumLiteral_5= 'U' )
                    // InternalAssembler.g:7606:4: enumLiteral_5= 'U'
                    {
                    enumLiteral_5=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:7613:3: (enumLiteral_6= 'S' )
                    {
                    // InternalAssembler.g:7613:3: (enumLiteral_6= 'S' )
                    // InternalAssembler.g:7614:4: enumLiteral_6= 'S'
                    {
                    enumLiteral_6=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:7621:3: (enumLiteral_7= 'DP' )
                    {
                    // InternalAssembler.g:7621:3: (enumLiteral_7= 'DP' )
                    // InternalAssembler.g:7622:4: enumLiteral_7= 'DP'
                    {
                    enumLiteral_7=(Token)match(input,123,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:7629:3: (enumLiteral_8= 'CC' )
                    {
                    // InternalAssembler.g:7629:3: (enumLiteral_8= 'CC' )
                    // InternalAssembler.g:7630:4: enumLiteral_8= 'CC'
                    {
                    enumLiteral_8=(Token)match(input,124,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAssembler.g:7637:3: (enumLiteral_9= 'PC' )
                    {
                    // InternalAssembler.g:7637:3: (enumLiteral_9= 'PC' )
                    // InternalAssembler.g:7638:4: enumLiteral_9= 'PC'
                    {
                    enumLiteral_9=(Token)match(input,125,FOLLOW_2); if (state.failed) return current;
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


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\4\uffff\6\14\14\uffff";
    static final String dfa_3s = "\1\7\1\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\106\1\uffff";
    static final String dfa_4s = "\1\162\1\uffff\2\10\6\160\1\uffff\1\162\1\uffff\2\10\6\160\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\10\uffff\1\2\1\uffff\1\3\10\uffff\1\4";
    static final String dfa_6s = "\26\uffff}>";
    static final String[] dfa_7s = {
            "\1\11\1\4\1\5\1\6\1\7\1\10\70\uffff\1\13\1\uffff\1\14\1\1\1\uffff\1\12\4\uffff\3\12\1\2\1\uffff\1\3\34\uffff\2\14",
            "",
            "\1\4",
            "\1\4",
            "\1\14\10\uffff\2\14\73\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\73\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\73\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\73\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\73\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\73\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "",
            "\1\24\1\17\1\20\1\21\1\22\1\23\75\uffff\1\12\4\uffff\3\12\1\15\1\uffff\1\16\34\uffff\2\25",
            "",
            "\1\17",
            "\1\17",
            "\1\25\3\uffff\1\12\7\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\25\3\uffff\1\12\7\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\25\3\uffff\1\12\7\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\25\3\uffff\1\12\7\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\25\3\uffff\1\12\7\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            "\1\25\3\uffff\1\12\7\uffff\1\25\1\uffff\1\25\13\uffff\1\25\11\uffff\7\25",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1797:5: (lv_operand_2_1= ruleDirectOperand | lv_operand_2_2= ruleIndexedOperand | lv_operand_2_3= ruleExtendedOperand | lv_operand_2_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2415:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2551:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_8s = "\27\uffff";
    static final String dfa_9s = "\5\uffff\6\15\14\uffff";
    static final String dfa_10s = "\1\7\2\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\106\1\uffff";
    static final String dfa_11s = "\1\162\2\uffff\2\10\6\160\1\uffff\1\162\1\uffff\2\10\6\160\1\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\10\uffff\1\3\1\uffff\1\4\10\uffff\1\5";
    static final String dfa_13s = "\27\uffff}>";
    static final String[] dfa_14s = {
            "\1\12\1\5\1\6\1\7\1\10\1\11\70\uffff\1\14\1\uffff\1\15\1\2\1\1\1\13\4\uffff\3\13\1\3\1\uffff\1\4\34\uffff\2\15",
            "",
            "",
            "\1\5",
            "\1\5",
            "\1\15\10\uffff\2\15\73\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\73\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\73\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\73\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\73\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\73\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "",
            "\1\25\1\20\1\21\1\22\1\23\1\24\75\uffff\1\13\4\uffff\3\13\1\16\1\uffff\1\17\34\uffff\2\26",
            "",
            "\1\20",
            "\1\20",
            "\1\26\3\uffff\1\13\7\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\26\3\uffff\1\13\7\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\26\3\uffff\1\13\7\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\26\3\uffff\1\13\7\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\26\3\uffff\1\13\7\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            "\1\26\3\uffff\1\13\7\uffff\1\26\1\uffff\1\26\13\uffff\1\26\11\uffff\7\26",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2727:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2849:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2984:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3119:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_15s = "\44\uffff";
    static final String dfa_16s = "\14\uffff\4\34\24\uffff";
    static final String dfa_17s = "\1\7\2\10\6\112\1\113\1\uffff\1\7\4\4\2\uffff\2\10\6\112\1\113\3\uffff\4\106\2\uffff";
    static final String dfa_18s = "\1\124\2\10\6\112\1\126\1\uffff\1\124\4\125\2\uffff\2\10\6\112\1\126\3\uffff\4\125\2\uffff";
    static final String dfa_19s = "\12\uffff\1\3\5\uffff\1\4\1\1\11\uffff\1\7\1\2\1\6\4\uffff\1\10\1\5";
    static final String dfa_20s = "\44\uffff}>";
    static final String[] dfa_21s = {
            "\1\10\1\3\1\4\1\5\1\6\1\7\70\uffff\1\13\4\uffff\1\11\4\uffff\3\12\1\1\1\uffff\1\2",
            "\1\3",
            "\1\3",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\14\1\15\1\16\1\17\3\uffff\2\21\2\uffff\1\20",
            "",
            "\1\31\1\24\1\25\1\26\1\27\1\30\75\uffff\1\32\4\uffff\3\33\1\22\1\uffff\1\23",
            "\1\34\10\uffff\2\34\105\uffff\2\21",
            "\1\34\10\uffff\2\34\105\uffff\2\21",
            "\1\34\10\uffff\2\34\105\uffff\2\21",
            "\1\34\10\uffff\2\34\105\uffff\2\21",
            "",
            "",
            "\1\24",
            "\1\24",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\32",
            "\1\36\1\37\1\40\1\41\3\uffff\2\35\2\uffff\1\42",
            "",
            "",
            "",
            "\1\43\15\uffff\2\35",
            "\1\43\15\uffff\2\35",
            "\1\43\15\uffff\2\35",
            "\1\43\15\uffff\2\35",
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

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "3425:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000060B2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xFFFFFFFFFFFF8000L,0x000000000000001FL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001F80L,0x00060000001785A0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000001F80L,0x00060000001787A0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001F80L,0x0006000000140080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000001F80L,0x0000000000140400L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000038000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x00000000000C7800L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000300000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x000003FEFF800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x380000000003F800L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x07F0000010000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000001F80L,0x0006000100140080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000400000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0001000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000100L});

}
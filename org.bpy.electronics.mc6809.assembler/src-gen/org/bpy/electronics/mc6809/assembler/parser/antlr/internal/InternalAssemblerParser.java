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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "'BHS'", "'LBHS'", "'BHI'", "'LBHI'", "'BGT'", "'LBGT'", "'BGE'", "'LBGE'", "'BEQ'", "'LBEQ'", "'BCS'", "'LBCS'", "'BCC'", "'LBCC'", "'ASRA'", "'ASRB'", "'ASR'", "'ASLA'", "'ASLB'", "'ASL'", "'ANDCC'", "'ANDA'", "'ANDB'", "'ADDD'", "'ADDA'", "'ADDB'", "'ADCA'", "'ADCB'", "'ABX'", "'['", "']'", "'>'", "'<'", "'#'", "','", "'S'", "'U'", "'X'", "'Y'", "'A'", "'B'", "'D'", "'-'", "'--'", "'+'", "'++'", "'PCR'", "'FCC'", "'REG'", "'SPC'", "'NAM'", "'TTL'", "'PAG'", "'OPT'", "'FAIL'", "'SET'", "'*'", "'FILL'", "'BSZ'", "'ZMB'", "'FDB'", "'FCB'", "'RMB'", "'END'", "'ORG'", "'EQU'", "'/'", "'%'", "'<<'", "'>>'", "'&&'", "'||'", "'^'", "'!'", "'('", "')'", "'NOP'", "'CON'", "'NOC'", "'MAC'", "'NOM'", "'EXP'", "'NOE'", "'DP'", "'CC'", "'PC'"
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
    public static final int T__94=94;
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
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int T__77=77;
    public static final int RULE_END_OF_FILE=14;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=4;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

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
                    {
                    alt2=4;
                    }
                    break;
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
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

                    if ( ((LA2_7>=15 && LA2_7<=43)) ) {
                        alt2=4;
                    }
                    else if ( ((LA2_7>=62 && LA2_7<=70)||(LA2_7>=72 && LA2_7<=80)) ) {
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
    // InternalAssembler.g:301:1: ruleInstructionLine returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) ) (this_WS_17= RULE_WS ( (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_19= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleInstructionLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_WS_17=null;
        Token lv_comment_18_0=null;
        Token this_WS_19=null;
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



        	enterRule();

        try {
            // InternalAssembler.g:307:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) ) (this_WS_17= RULE_WS ( (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_19= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) ) (this_WS_17= RULE_WS ( (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_19= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) ) (this_WS_17= RULE_WS ( (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_19= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:309:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) ) (this_WS_17= RULE_WS ( (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_19= RULE_WS )? ruleEndOfLine
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
            // InternalAssembler.g:332:3: ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) | ( (lv_instruction_10_0= ruleBccInstruction ) ) | ( (lv_instruction_11_0= ruleBcsInstruction ) ) | ( (lv_instruction_12_0= ruleBeqInstruction ) ) | ( (lv_instruction_13_0= ruleBgeInstruction ) ) | ( (lv_instruction_14_0= ruleBgtInstruction ) ) | ( (lv_instruction_15_0= ruleBhiInstruction ) ) | ( (lv_instruction_16_0= ruleBhsInstruction ) ) )
            int alt5=15;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt5=1;
                }
                break;
            case 41:
            case 42:
                {
                alt5=2;
                }
                break;
            case 39:
            case 40:
                {
                alt5=3;
                }
                break;
            case 38:
                {
                alt5=4;
                }
                break;
            case 36:
            case 37:
                {
                alt5=5;
                }
                break;
            case 35:
                {
                alt5=6;
                }
                break;
            case 32:
            case 33:
            case 34:
                {
                alt5=7;
                }
                break;
            case 29:
            case 30:
            case 31:
                {
                alt5=8;
                }
                break;
            case 27:
            case 28:
                {
                alt5=9;
                }
                break;
            case 25:
            case 26:
                {
                alt5=10;
                }
                break;
            case 23:
            case 24:
                {
                alt5=11;
                }
                break;
            case 21:
            case 22:
                {
                alt5=12;
                }
                break;
            case 19:
            case 20:
                {
                alt5=13;
                }
                break;
            case 17:
            case 18:
                {
                alt5=14;
                }
                break;
            case 15:
            case 16:
                {
                alt5=15;
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

            }

            // InternalAssembler.g:633:3: (this_WS_17= RULE_WS ( (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:634:4: this_WS_17= RULE_WS ( (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_17=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_17, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:638:4: ( (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:639:5: (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:639:5: (lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:640:6: lv_comment_18_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_18_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_18_0, grammarAccess.getInstructionLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getInstructionLineRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_18_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:657:3: (this_WS_19= RULE_WS )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:658:4: this_WS_19= RULE_WS
                    {
                    this_WS_19=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_19, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_4());
                      			
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


    // $ANTLR start "entryRuleBhsInstruction"
    // InternalAssembler.g:674:1: entryRuleBhsInstruction returns [EObject current=null] : iv_ruleBhsInstruction= ruleBhsInstruction EOF ;
    public final EObject entryRuleBhsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBhsInstruction = null;


        try {
            // InternalAssembler.g:674:55: (iv_ruleBhsInstruction= ruleBhsInstruction EOF )
            // InternalAssembler.g:675:2: iv_ruleBhsInstruction= ruleBhsInstruction EOF
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
    // InternalAssembler.g:681:1: ruleBhsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBhsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:687:2: ( ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:688:2: ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:688:2: ( ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:689:3: ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:689:3: ( ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) ) )
            // InternalAssembler.g:690:4: ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) )
            {
            // InternalAssembler.g:690:4: ( (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' ) )
            // InternalAssembler.g:691:5: (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' )
            {
            // InternalAssembler.g:691:5: (lv_instruction_0_1= 'BHS' | lv_instruction_0_2= 'LBHS' )
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
                    // InternalAssembler.g:692:6: lv_instruction_0_1= 'BHS'
                    {
                    lv_instruction_0_1=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:703:6: lv_instruction_0_2= 'LBHS'
                    {
                    lv_instruction_0_2=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:720:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:721:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:721:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:722:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:743:1: entryRuleBhiInstruction returns [EObject current=null] : iv_ruleBhiInstruction= ruleBhiInstruction EOF ;
    public final EObject entryRuleBhiInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBhiInstruction = null;


        try {
            // InternalAssembler.g:743:55: (iv_ruleBhiInstruction= ruleBhiInstruction EOF )
            // InternalAssembler.g:744:2: iv_ruleBhiInstruction= ruleBhiInstruction EOF
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
    // InternalAssembler.g:750:1: ruleBhiInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBhiInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:756:2: ( ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:757:2: ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:757:2: ( ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:758:3: ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:758:3: ( ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) ) )
            // InternalAssembler.g:759:4: ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) )
            {
            // InternalAssembler.g:759:4: ( (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' ) )
            // InternalAssembler.g:760:5: (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' )
            {
            // InternalAssembler.g:760:5: (lv_instruction_0_1= 'BHI' | lv_instruction_0_2= 'LBHI' )
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
                    // InternalAssembler.g:761:6: lv_instruction_0_1= 'BHI'
                    {
                    lv_instruction_0_1=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:772:6: lv_instruction_0_2= 'LBHI'
                    {
                    lv_instruction_0_2=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:789:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:790:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:790:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:791:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:812:1: entryRuleBgtInstruction returns [EObject current=null] : iv_ruleBgtInstruction= ruleBgtInstruction EOF ;
    public final EObject entryRuleBgtInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBgtInstruction = null;


        try {
            // InternalAssembler.g:812:55: (iv_ruleBgtInstruction= ruleBgtInstruction EOF )
            // InternalAssembler.g:813:2: iv_ruleBgtInstruction= ruleBgtInstruction EOF
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
    // InternalAssembler.g:819:1: ruleBgtInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBgtInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:825:2: ( ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:826:2: ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:826:2: ( ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:827:3: ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:827:3: ( ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) ) )
            // InternalAssembler.g:828:4: ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) )
            {
            // InternalAssembler.g:828:4: ( (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' ) )
            // InternalAssembler.g:829:5: (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' )
            {
            // InternalAssembler.g:829:5: (lv_instruction_0_1= 'BGT' | lv_instruction_0_2= 'LBGT' )
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
                    // InternalAssembler.g:830:6: lv_instruction_0_1= 'BGT'
                    {
                    lv_instruction_0_1=(Token)match(input,19,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:841:6: lv_instruction_0_2= 'LBGT'
                    {
                    lv_instruction_0_2=(Token)match(input,20,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:858:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:859:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:859:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:860:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:881:1: entryRuleBgeInstruction returns [EObject current=null] : iv_ruleBgeInstruction= ruleBgeInstruction EOF ;
    public final EObject entryRuleBgeInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBgeInstruction = null;


        try {
            // InternalAssembler.g:881:55: (iv_ruleBgeInstruction= ruleBgeInstruction EOF )
            // InternalAssembler.g:882:2: iv_ruleBgeInstruction= ruleBgeInstruction EOF
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
    // InternalAssembler.g:888:1: ruleBgeInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBgeInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:894:2: ( ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:895:2: ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:895:2: ( ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:896:3: ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:896:3: ( ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) ) )
            // InternalAssembler.g:897:4: ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) )
            {
            // InternalAssembler.g:897:4: ( (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' ) )
            // InternalAssembler.g:898:5: (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' )
            {
            // InternalAssembler.g:898:5: (lv_instruction_0_1= 'BGE' | lv_instruction_0_2= 'LBGE' )
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
                    // InternalAssembler.g:899:6: lv_instruction_0_1= 'BGE'
                    {
                    lv_instruction_0_1=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:910:6: lv_instruction_0_2= 'LBGE'
                    {
                    lv_instruction_0_2=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:927:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:928:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:928:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:929:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:950:1: entryRuleBeqInstruction returns [EObject current=null] : iv_ruleBeqInstruction= ruleBeqInstruction EOF ;
    public final EObject entryRuleBeqInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeqInstruction = null;


        try {
            // InternalAssembler.g:950:55: (iv_ruleBeqInstruction= ruleBeqInstruction EOF )
            // InternalAssembler.g:951:2: iv_ruleBeqInstruction= ruleBeqInstruction EOF
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
    // InternalAssembler.g:957:1: ruleBeqInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBeqInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:963:2: ( ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:964:2: ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:964:2: ( ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:965:3: ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:965:3: ( ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) ) )
            // InternalAssembler.g:966:4: ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) )
            {
            // InternalAssembler.g:966:4: ( (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' ) )
            // InternalAssembler.g:967:5: (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' )
            {
            // InternalAssembler.g:967:5: (lv_instruction_0_1= 'BEQ' | lv_instruction_0_2= 'LBEQ' )
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
                    // InternalAssembler.g:968:6: lv_instruction_0_1= 'BEQ'
                    {
                    lv_instruction_0_1=(Token)match(input,23,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:979:6: lv_instruction_0_2= 'LBEQ'
                    {
                    lv_instruction_0_2=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:996:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:997:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:997:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:998:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1019:1: entryRuleBcsInstruction returns [EObject current=null] : iv_ruleBcsInstruction= ruleBcsInstruction EOF ;
    public final EObject entryRuleBcsInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBcsInstruction = null;


        try {
            // InternalAssembler.g:1019:55: (iv_ruleBcsInstruction= ruleBcsInstruction EOF )
            // InternalAssembler.g:1020:2: iv_ruleBcsInstruction= ruleBcsInstruction EOF
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
    // InternalAssembler.g:1026:1: ruleBcsInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBcsInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1032:2: ( ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1033:2: ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1033:2: ( ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1034:3: ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1034:3: ( ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) ) )
            // InternalAssembler.g:1035:4: ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) )
            {
            // InternalAssembler.g:1035:4: ( (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' ) )
            // InternalAssembler.g:1036:5: (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' )
            {
            // InternalAssembler.g:1036:5: (lv_instruction_0_1= 'BCS' | lv_instruction_0_2= 'LBCS' )
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
                    // InternalAssembler.g:1037:6: lv_instruction_0_1= 'BCS'
                    {
                    lv_instruction_0_1=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1048:6: lv_instruction_0_2= 'LBCS'
                    {
                    lv_instruction_0_2=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:1065:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1066:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1066:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1067:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1088:1: entryRuleBccInstruction returns [EObject current=null] : iv_ruleBccInstruction= ruleBccInstruction EOF ;
    public final EObject entryRuleBccInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBccInstruction = null;


        try {
            // InternalAssembler.g:1088:55: (iv_ruleBccInstruction= ruleBccInstruction EOF )
            // InternalAssembler.g:1089:2: iv_ruleBccInstruction= ruleBccInstruction EOF
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
    // InternalAssembler.g:1095:1: ruleBccInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) ;
    public final EObject ruleBccInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_1=null;
        Token lv_instruction_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1101:2: ( ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) ) )
            // InternalAssembler.g:1102:2: ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            {
            // InternalAssembler.g:1102:2: ( ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) ) )
            // InternalAssembler.g:1103:3: ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleRelativeMode ) )
            {
            // InternalAssembler.g:1103:3: ( ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) ) )
            // InternalAssembler.g:1104:4: ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) )
            {
            // InternalAssembler.g:1104:4: ( (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' ) )
            // InternalAssembler.g:1105:5: (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' )
            {
            // InternalAssembler.g:1105:5: (lv_instruction_0_1= 'BCC' | lv_instruction_0_2= 'LBCC' )
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
                    // InternalAssembler.g:1106:6: lv_instruction_0_1= 'BCC'
                    {
                    lv_instruction_0_1=(Token)match(input,27,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1117:6: lv_instruction_0_2= 'LBCC'
                    {
                    lv_instruction_0_2=(Token)match(input,28,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:1134:3: ( (lv_operand_2_0= ruleRelativeMode ) )
            // InternalAssembler.g:1135:4: (lv_operand_2_0= ruleRelativeMode )
            {
            // InternalAssembler.g:1135:4: (lv_operand_2_0= ruleRelativeMode )
            // InternalAssembler.g:1136:5: lv_operand_2_0= ruleRelativeMode
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
    // InternalAssembler.g:1157:1: entryRuleAsrInstruction returns [EObject current=null] : iv_ruleAsrInstruction= ruleAsrInstruction EOF ;
    public final EObject entryRuleAsrInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsrInstruction = null;


        try {
            // InternalAssembler.g:1157:55: (iv_ruleAsrInstruction= ruleAsrInstruction EOF )
            // InternalAssembler.g:1158:2: iv_ruleAsrInstruction= ruleAsrInstruction EOF
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
    // InternalAssembler.g:1164:1: ruleAsrInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
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
            // InternalAssembler.g:1170:2: ( ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:1171:2: ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:1171:2: ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=29 && LA17_0<=30)) ) {
                alt17=1;
            }
            else if ( (LA17_0==31) ) {
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
                    // InternalAssembler.g:1172:3: ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) )
                    {
                    // InternalAssembler.g:1172:3: ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) )
                    // InternalAssembler.g:1173:4: ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) )
                    {
                    // InternalAssembler.g:1173:4: ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) )
                    // InternalAssembler.g:1174:5: (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' )
                    {
                    // InternalAssembler.g:1174:5: (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' )
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
                            // InternalAssembler.g:1175:6: lv_instruction_0_1= 'ASRA'
                            {
                            lv_instruction_0_1=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:1186:6: lv_instruction_0_2= 'ASRB'
                            {
                            lv_instruction_0_2=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1200:3: ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:1200:3: ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:1201:4: ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:1201:4: ( (lv_instruction_1_0= 'ASR' ) )
                    // InternalAssembler.g:1202:5: (lv_instruction_1_0= 'ASR' )
                    {
                    // InternalAssembler.g:1202:5: (lv_instruction_1_0= 'ASR' )
                    // InternalAssembler.g:1203:6: lv_instruction_1_0= 'ASR'
                    {
                    lv_instruction_1_0=(Token)match(input,31,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1219:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:1220:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:1220:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:1221:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:1221:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt16=4;
                    alt16 = dfa16.predict(input);
                    switch (alt16) {
                        case 1 :
                            // InternalAssembler.g:1222:7: lv_operand_3_1= ruleDirectOperand
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
                            // InternalAssembler.g:1238:7: lv_operand_3_2= ruleIndexedOperand
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
                            // InternalAssembler.g:1254:7: lv_operand_3_3= ruleExtendedOperand
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
                            // InternalAssembler.g:1270:7: lv_operand_3_4= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1293:1: entryRuleAslInstruction returns [EObject current=null] : iv_ruleAslInstruction= ruleAslInstruction EOF ;
    public final EObject entryRuleAslInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAslInstruction = null;


        try {
            // InternalAssembler.g:1293:55: (iv_ruleAslInstruction= ruleAslInstruction EOF )
            // InternalAssembler.g:1294:2: iv_ruleAslInstruction= ruleAslInstruction EOF
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
    // InternalAssembler.g:1300:1: ruleAslInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
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
            // InternalAssembler.g:1306:2: ( ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:1307:2: ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:1307:2: ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=32 && LA20_0<=33)) ) {
                alt20=1;
            }
            else if ( (LA20_0==34) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1308:3: ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) )
                    {
                    // InternalAssembler.g:1308:3: ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) )
                    // InternalAssembler.g:1309:4: ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) )
                    {
                    // InternalAssembler.g:1309:4: ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) )
                    // InternalAssembler.g:1310:5: (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' )
                    {
                    // InternalAssembler.g:1310:5: (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==32) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==33) ) {
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
                            // InternalAssembler.g:1311:6: lv_instruction_0_1= 'ASLA'
                            {
                            lv_instruction_0_1=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:1322:6: lv_instruction_0_2= 'ASLB'
                            {
                            lv_instruction_0_2=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1336:3: ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:1336:3: ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:1337:4: ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:1337:4: ( (lv_instruction_1_0= 'ASL' ) )
                    // InternalAssembler.g:1338:5: (lv_instruction_1_0= 'ASL' )
                    {
                    // InternalAssembler.g:1338:5: (lv_instruction_1_0= 'ASL' )
                    // InternalAssembler.g:1339:6: lv_instruction_1_0= 'ASL'
                    {
                    lv_instruction_1_0=(Token)match(input,34,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1355:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:1356:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:1356:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:1357:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:1357:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt19=4;
                    alt19 = dfa19.predict(input);
                    switch (alt19) {
                        case 1 :
                            // InternalAssembler.g:1358:7: lv_operand_3_1= ruleDirectOperand
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
                            // InternalAssembler.g:1374:7: lv_operand_3_2= ruleIndexedOperand
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
                            // InternalAssembler.g:1390:7: lv_operand_3_3= ruleExtendedOperand
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
                            // InternalAssembler.g:1406:7: lv_operand_3_4= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1429:1: entryRuleAndCCInstruction returns [EObject current=null] : iv_ruleAndCCInstruction= ruleAndCCInstruction EOF ;
    public final EObject entryRuleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndCCInstruction = null;


        try {
            // InternalAssembler.g:1429:57: (iv_ruleAndCCInstruction= ruleAndCCInstruction EOF )
            // InternalAssembler.g:1430:2: iv_ruleAndCCInstruction= ruleAndCCInstruction EOF
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
    // InternalAssembler.g:1436:1: ruleAndCCInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) ;
    public final EObject ruleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1442:2: ( ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) )
            // InternalAssembler.g:1443:2: ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            {
            // InternalAssembler.g:1443:2: ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            // InternalAssembler.g:1444:3: ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) )
            {
            // InternalAssembler.g:1444:3: ( (lv_instruction_0_0= 'ANDCC' ) )
            // InternalAssembler.g:1445:4: (lv_instruction_0_0= 'ANDCC' )
            {
            // InternalAssembler.g:1445:4: (lv_instruction_0_0= 'ANDCC' )
            // InternalAssembler.g:1446:5: lv_instruction_0_0= 'ANDCC'
            {
            lv_instruction_0_0=(Token)match(input,35,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:1462:3: ( (lv_operand_2_0= ruleImmediatOperand ) )
            // InternalAssembler.g:1463:4: (lv_operand_2_0= ruleImmediatOperand )
            {
            // InternalAssembler.g:1463:4: (lv_operand_2_0= ruleImmediatOperand )
            // InternalAssembler.g:1464:5: lv_operand_2_0= ruleImmediatOperand
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
    // InternalAssembler.g:1485:1: entryRuleAndInstruction returns [EObject current=null] : iv_ruleAndInstruction= ruleAndInstruction EOF ;
    public final EObject entryRuleAndInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndInstruction = null;


        try {
            // InternalAssembler.g:1485:55: (iv_ruleAndInstruction= ruleAndInstruction EOF )
            // InternalAssembler.g:1486:2: iv_ruleAndInstruction= ruleAndInstruction EOF
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
    // InternalAssembler.g:1492:1: ruleAndInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:1498:2: ( ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1499:2: ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1499:2: ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1500:3: ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1500:3: ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) )
            // InternalAssembler.g:1501:4: ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) )
            {
            // InternalAssembler.g:1501:4: ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) )
            // InternalAssembler.g:1502:5: (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' )
            {
            // InternalAssembler.g:1502:5: (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==36) ) {
                alt21=1;
            }
            else if ( (LA21_0==37) ) {
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
                    // InternalAssembler.g:1503:6: lv_instruction_0_1= 'ANDA'
                    {
                    lv_instruction_0_1=(Token)match(input,36,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1514:6: lv_instruction_0_2= 'ANDB'
                    {
                    lv_instruction_0_2=(Token)match(input,37,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:1531:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1532:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1532:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1533:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1533:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt22=5;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:1534:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:1550:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:1566:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:1582:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:1598:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1620:1: entryRuleAdddInstruction returns [EObject current=null] : iv_ruleAdddInstruction= ruleAdddInstruction EOF ;
    public final EObject entryRuleAdddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdddInstruction = null;


        try {
            // InternalAssembler.g:1620:56: (iv_ruleAdddInstruction= ruleAdddInstruction EOF )
            // InternalAssembler.g:1621:2: iv_ruleAdddInstruction= ruleAdddInstruction EOF
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
    // InternalAssembler.g:1627:1: ruleAdddInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:1633:2: ( ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1634:2: ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1634:2: ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1635:3: ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1635:3: ( (lv_instruction_0_0= 'ADDD' ) )
            // InternalAssembler.g:1636:4: (lv_instruction_0_0= 'ADDD' )
            {
            // InternalAssembler.g:1636:4: (lv_instruction_0_0= 'ADDD' )
            // InternalAssembler.g:1637:5: lv_instruction_0_0= 'ADDD'
            {
            lv_instruction_0_0=(Token)match(input,38,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:1653:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1654:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1654:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1655:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1655:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt23=5;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalAssembler.g:1656:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:1672:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:1688:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:1704:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:1720:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1742:1: entryRuleAddInstruction returns [EObject current=null] : iv_ruleAddInstruction= ruleAddInstruction EOF ;
    public final EObject entryRuleAddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddInstruction = null;


        try {
            // InternalAssembler.g:1742:55: (iv_ruleAddInstruction= ruleAddInstruction EOF )
            // InternalAssembler.g:1743:2: iv_ruleAddInstruction= ruleAddInstruction EOF
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
    // InternalAssembler.g:1749:1: ruleAddInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:1755:2: ( ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1756:2: ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1756:2: ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1757:3: ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1757:3: ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) )
            // InternalAssembler.g:1758:4: ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) )
            {
            // InternalAssembler.g:1758:4: ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) )
            // InternalAssembler.g:1759:5: (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' )
            {
            // InternalAssembler.g:1759:5: (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                alt24=1;
            }
            else if ( (LA24_0==40) ) {
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
                    // InternalAssembler.g:1760:6: lv_instruction_0_1= 'ADDA'
                    {
                    lv_instruction_0_1=(Token)match(input,39,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1771:6: lv_instruction_0_2= 'ADDB'
                    {
                    lv_instruction_0_2=(Token)match(input,40,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:1788:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1789:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1789:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1790:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1790:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt25=5;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalAssembler.g:1791:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:1807:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:1823:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:1839:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:1855:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1877:1: entryRuleAdcInstruction returns [EObject current=null] : iv_ruleAdcInstruction= ruleAdcInstruction EOF ;
    public final EObject entryRuleAdcInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdcInstruction = null;


        try {
            // InternalAssembler.g:1877:55: (iv_ruleAdcInstruction= ruleAdcInstruction EOF )
            // InternalAssembler.g:1878:2: iv_ruleAdcInstruction= ruleAdcInstruction EOF
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
    // InternalAssembler.g:1884:1: ruleAdcInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:1890:2: ( ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1891:2: ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1891:2: ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1892:3: ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1892:3: ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) )
            // InternalAssembler.g:1893:4: ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) )
            {
            // InternalAssembler.g:1893:4: ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) )
            // InternalAssembler.g:1894:5: (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' )
            {
            // InternalAssembler.g:1894:5: (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==41) ) {
                alt26=1;
            }
            else if ( (LA26_0==42) ) {
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
                    // InternalAssembler.g:1895:6: lv_instruction_0_1= 'ADCA'
                    {
                    lv_instruction_0_1=(Token)match(input,41,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1906:6: lv_instruction_0_2= 'ADCB'
                    {
                    lv_instruction_0_2=(Token)match(input,42,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:1923:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1924:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1924:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1925:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1925:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt27=5;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalAssembler.g:1926:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:1942:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:1958:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:1974:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:1990:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:2012:1: entryRuleAbxInstruction returns [EObject current=null] : iv_ruleAbxInstruction= ruleAbxInstruction EOF ;
    public final EObject entryRuleAbxInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbxInstruction = null;


        try {
            // InternalAssembler.g:2012:55: (iv_ruleAbxInstruction= ruleAbxInstruction EOF )
            // InternalAssembler.g:2013:2: iv_ruleAbxInstruction= ruleAbxInstruction EOF
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
    // InternalAssembler.g:2019:1: ruleAbxInstruction returns [EObject current=null] : ( (lv_instruction_0_0= 'ABX' ) ) ;
    public final EObject ruleAbxInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2025:2: ( ( (lv_instruction_0_0= 'ABX' ) ) )
            // InternalAssembler.g:2026:2: ( (lv_instruction_0_0= 'ABX' ) )
            {
            // InternalAssembler.g:2026:2: ( (lv_instruction_0_0= 'ABX' ) )
            // InternalAssembler.g:2027:3: (lv_instruction_0_0= 'ABX' )
            {
            // InternalAssembler.g:2027:3: (lv_instruction_0_0= 'ABX' )
            // InternalAssembler.g:2028:4: lv_instruction_0_0= 'ABX'
            {
            lv_instruction_0_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2043:1: entryRuleExtendedIndirectOperand returns [EObject current=null] : iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF ;
    public final EObject entryRuleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedIndirectOperand = null;


        try {
            // InternalAssembler.g:2043:64: (iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF )
            // InternalAssembler.g:2044:2: iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF
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
    // InternalAssembler.g:2050:1: ruleExtendedIndirectOperand returns [EObject current=null] : (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2056:2: ( (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalAssembler.g:2057:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalAssembler.g:2057:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalAssembler.g:2058:3: otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtendedIndirectOperandAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2062:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:2063:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:2063:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:2064:5: lv_operand_1_0= ruleExpression
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

            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2089:1: entryRuleExtendedOperand returns [EObject current=null] : iv_ruleExtendedOperand= ruleExtendedOperand EOF ;
    public final EObject entryRuleExtendedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedOperand = null;


        try {
            // InternalAssembler.g:2089:56: (iv_ruleExtendedOperand= ruleExtendedOperand EOF )
            // InternalAssembler.g:2090:2: iv_ruleExtendedOperand= ruleExtendedOperand EOF
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
    // InternalAssembler.g:2096:1: ruleExtendedOperand returns [EObject current=null] : ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExtendedOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2102:2: ( ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:2103:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:2103:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:2104:3: (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) )
            {
            // InternalAssembler.g:2104:3: (otherlv_0= '>' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==46) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAssembler.g:2105:4: otherlv_0= '>'
                    {
                    otherlv_0=(Token)match(input,46,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getExtendedOperandAccess().getGreaterThanSignKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:2110:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:2111:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:2111:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:2112:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:2133:1: entryRuleDirectOperand returns [EObject current=null] : iv_ruleDirectOperand= ruleDirectOperand EOF ;
    public final EObject entryRuleDirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectOperand = null;


        try {
            // InternalAssembler.g:2133:54: (iv_ruleDirectOperand= ruleDirectOperand EOF )
            // InternalAssembler.g:2134:2: iv_ruleDirectOperand= ruleDirectOperand EOF
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
    // InternalAssembler.g:2140:1: ruleDirectOperand returns [EObject current=null] : (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleDirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2146:2: ( (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:2147:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:2147:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:2148:3: otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectOperandAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalAssembler.g:2152:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:2153:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:2153:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:2154:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:2175:1: entryRuleImmediatOperand returns [EObject current=null] : iv_ruleImmediatOperand= ruleImmediatOperand EOF ;
    public final EObject entryRuleImmediatOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImmediatOperand = null;


        try {
            // InternalAssembler.g:2175:56: (iv_ruleImmediatOperand= ruleImmediatOperand EOF )
            // InternalAssembler.g:2176:2: iv_ruleImmediatOperand= ruleImmediatOperand EOF
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
    // InternalAssembler.g:2182:1: ruleImmediatOperand returns [EObject current=null] : (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleImmediatOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2188:2: ( (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:2189:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:2189:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:2190:3: otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,48,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImmediatOperandAccess().getNumberSignKeyword_0());
              		
            }
            // InternalAssembler.g:2194:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:2195:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:2195:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:2196:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:2217:1: entryRuleIndexedOperand returns [EObject current=null] : iv_ruleIndexedOperand= ruleIndexedOperand EOF ;
    public final EObject entryRuleIndexedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedOperand = null;


        try {
            // InternalAssembler.g:2217:55: (iv_ruleIndexedOperand= ruleIndexedOperand EOF )
            // InternalAssembler.g:2218:2: iv_ruleIndexedOperand= ruleIndexedOperand EOF
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
    // InternalAssembler.g:2224:1: ruleIndexedOperand returns [EObject current=null] : ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) ;
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
            // InternalAssembler.g:2230:2: ( ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) )
            // InternalAssembler.g:2231:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            {
            // InternalAssembler.g:2231:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            int alt29=8;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalAssembler.g:2232:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    {
                    // InternalAssembler.g:2232:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    // InternalAssembler.g:2233:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    {
                    // InternalAssembler.g:2233:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    // InternalAssembler.g:2234:5: lv_mode_0_0= ruleAutoIncDecMode
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
                    // InternalAssembler.g:2252:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    {
                    // InternalAssembler.g:2252:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    // InternalAssembler.g:2253:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    {
                    // InternalAssembler.g:2253:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    // InternalAssembler.g:2254:5: lv_mode_1_0= ruleConstantIndexedMode
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
                    // InternalAssembler.g:2272:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    {
                    // InternalAssembler.g:2272:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    // InternalAssembler.g:2273:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    {
                    // InternalAssembler.g:2273:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    // InternalAssembler.g:2274:5: lv_mode_2_0= ruleAccumulatorMovingMode
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
                    // InternalAssembler.g:2292:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    {
                    // InternalAssembler.g:2292:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    // InternalAssembler.g:2293:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    {
                    // InternalAssembler.g:2293:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    // InternalAssembler.g:2294:5: lv_mode_3_0= ruleRelatifToPCMode
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
                    // InternalAssembler.g:2312:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:2312:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    // InternalAssembler.g:2313:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    {
                    // InternalAssembler.g:2313:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    // InternalAssembler.g:2314:5: lv_mode_4_0= ruleConstantIndexedMovingIndirectMode
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
                    // InternalAssembler.g:2332:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    {
                    // InternalAssembler.g:2332:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    // InternalAssembler.g:2333:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    {
                    // InternalAssembler.g:2333:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    // InternalAssembler.g:2334:5: lv_mode_5_0= ruleAutoIncDecIndirectMode
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
                    // InternalAssembler.g:2352:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:2352:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    // InternalAssembler.g:2353:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    {
                    // InternalAssembler.g:2353:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    // InternalAssembler.g:2354:5: lv_mode_6_0= ruleAccumulatorMovingIndirectMode
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
                    // InternalAssembler.g:2372:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    {
                    // InternalAssembler.g:2372:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    // InternalAssembler.g:2373:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    {
                    // InternalAssembler.g:2373:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    // InternalAssembler.g:2374:5: lv_mode_7_0= ruleRelatifToPCIndirectMode
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
    // InternalAssembler.g:2395:1: entryRuleConstantIndexedMode returns [EObject current=null] : iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF ;
    public final EObject entryRuleConstantIndexedMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMode = null;


        try {
            // InternalAssembler.g:2395:60: (iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF )
            // InternalAssembler.g:2396:2: iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF
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
    // InternalAssembler.g:2402:1: ruleConstantIndexedMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:2408:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:2409:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:2409:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:2410:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:2410:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_CHARACTER)||LA30_0==57||LA30_0==59) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAssembler.g:2411:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2411:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:2412:5: lv_deplacement_0_0= ruleNumericalValue
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

            otherlv_1=(Token)match(input,49,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstantIndexedModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2433:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:2434:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:2434:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:2435:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:2435:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt31=1;
                }
                break;
            case 51:
                {
                alt31=2;
                }
                break;
            case 52:
                {
                alt31=3;
                }
                break;
            case 53:
                {
                alt31=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalAssembler.g:2436:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2447:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2458:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2469:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2486:1: entryRuleConstantIndexedMovingIndirectMode returns [EObject current=null] : iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF ;
    public final EObject entryRuleConstantIndexedMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMovingIndirectMode = null;


        try {
            // InternalAssembler.g:2486:74: (iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF )
            // InternalAssembler.g:2487:2: iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF
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
    // InternalAssembler.g:2493:1: ruleConstantIndexedMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:2499:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:2500:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:2500:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:2501:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2505:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_CHARACTER)||LA32_0==57||LA32_0==59) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAssembler.g:2506:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2506:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:2507:5: lv_deplacement_1_0= ruleNumericalValue
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

            otherlv_2=(Token)match(input,49,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:2528:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:2529:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:2529:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:2530:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:2530:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt33=1;
                }
                break;
            case 51:
                {
                alt33=2;
                }
                break;
            case 52:
                {
                alt33=3;
                }
                break;
            case 53:
                {
                alt33=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalAssembler.g:2531:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,50,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2542:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,51,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2553:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,52,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2564:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,53,FOLLOW_13); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2585:1: entryRuleAccumulatorMovingMode returns [EObject current=null] : iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF ;
    public final EObject entryRuleAccumulatorMovingMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingMode = null;


        try {
            // InternalAssembler.g:2585:62: (iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF )
            // InternalAssembler.g:2586:2: iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF
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
    // InternalAssembler.g:2592:1: ruleAccumulatorMovingMode returns [EObject current=null] : ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:2598:2: ( ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:2599:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:2599:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:2600:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:2600:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) )
            // InternalAssembler.g:2601:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            {
            // InternalAssembler.g:2601:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            // InternalAssembler.g:2602:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            {
            // InternalAssembler.g:2602:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            int alt34=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt34=1;
                }
                break;
            case 55:
                {
                alt34=2;
                }
                break;
            case 56:
                {
                alt34=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalAssembler.g:2603:6: lv_deplacement_0_1= 'A'
                    {
                    lv_deplacement_0_1=(Token)match(input,54,FOLLOW_14); if (state.failed) return current;
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
                    // InternalAssembler.g:2614:6: lv_deplacement_0_2= 'B'
                    {
                    lv_deplacement_0_2=(Token)match(input,55,FOLLOW_14); if (state.failed) return current;
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
                    // InternalAssembler.g:2625:6: lv_deplacement_0_3= 'D'
                    {
                    lv_deplacement_0_3=(Token)match(input,56,FOLLOW_14); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,49,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAccumulatorMovingModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2642:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:2643:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:2643:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:2644:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:2644:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt35=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt35=1;
                }
                break;
            case 51:
                {
                alt35=2;
                }
                break;
            case 52:
                {
                alt35=3;
                }
                break;
            case 53:
                {
                alt35=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalAssembler.g:2645:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2656:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2667:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2678:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2695:1: entryRuleAccumulatorMovingIndirectMode returns [EObject current=null] : iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF ;
    public final EObject entryRuleAccumulatorMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingIndirectMode = null;


        try {
            // InternalAssembler.g:2695:70: (iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF )
            // InternalAssembler.g:2696:2: iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF
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
    // InternalAssembler.g:2702:1: ruleAccumulatorMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:2708:2: ( (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:2709:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:2709:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:2710:3: otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAccumulatorMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2714:3: ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) )
            // InternalAssembler.g:2715:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            {
            // InternalAssembler.g:2715:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            // InternalAssembler.g:2716:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            {
            // InternalAssembler.g:2716:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt36=1;
                }
                break;
            case 55:
                {
                alt36=2;
                }
                break;
            case 56:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalAssembler.g:2717:6: lv_deplacement_1_1= 'A'
                    {
                    lv_deplacement_1_1=(Token)match(input,54,FOLLOW_14); if (state.failed) return current;
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
                    // InternalAssembler.g:2728:6: lv_deplacement_1_2= 'B'
                    {
                    lv_deplacement_1_2=(Token)match(input,55,FOLLOW_14); if (state.failed) return current;
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
                    // InternalAssembler.g:2739:6: lv_deplacement_1_3= 'D'
                    {
                    lv_deplacement_1_3=(Token)match(input,56,FOLLOW_14); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,49,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAccumulatorMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:2756:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:2757:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:2757:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:2758:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:2758:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt37=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt37=1;
                }
                break;
            case 51:
                {
                alt37=2;
                }
                break;
            case 52:
                {
                alt37=3;
                }
                break;
            case 53:
                {
                alt37=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalAssembler.g:2759:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,50,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2770:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,51,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2781:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,52,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2792:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,53,FOLLOW_13); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2813:1: entryRuleAutoIncDecMode returns [EObject current=null] : iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF ;
    public final EObject entryRuleAutoIncDecMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecMode = null;


        try {
            // InternalAssembler.g:2813:55: (iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF )
            // InternalAssembler.g:2814:2: iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF
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
    // InternalAssembler.g:2820:1: ruleAutoIncDecMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) ;
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
            // InternalAssembler.g:2826:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) )
            // InternalAssembler.g:2827:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            {
            // InternalAssembler.g:2827:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            // InternalAssembler.g:2828:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            {
            // InternalAssembler.g:2828:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_CHARACTER)||LA38_0==57||LA38_0==59) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAssembler.g:2829:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2829:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:2830:5: lv_deplacement_0_0= ruleNumericalValue
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

            otherlv_1=(Token)match(input,49,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAutoIncDecModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2851:3: ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=57 && LA43_0<=58)) ) {
                alt43=1;
            }
            else if ( ((LA43_0>=50 && LA43_0<=53)) ) {
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
                    // InternalAssembler.g:2852:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:2852:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    // InternalAssembler.g:2853:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:2853:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==57) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==58) ) {
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
                            // InternalAssembler.g:2854:6: ( (lv_decrement_2_0= '-' ) )
                            {
                            // InternalAssembler.g:2854:6: ( (lv_decrement_2_0= '-' ) )
                            // InternalAssembler.g:2855:7: (lv_decrement_2_0= '-' )
                            {
                            // InternalAssembler.g:2855:7: (lv_decrement_2_0= '-' )
                            // InternalAssembler.g:2856:8: lv_decrement_2_0= '-'
                            {
                            lv_decrement_2_0=(Token)match(input,57,FOLLOW_15); if (state.failed) return current;
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
                            // InternalAssembler.g:2869:6: ( (lv_decrement_3_0= '--' ) )
                            {
                            // InternalAssembler.g:2869:6: ( (lv_decrement_3_0= '--' ) )
                            // InternalAssembler.g:2870:7: (lv_decrement_3_0= '--' )
                            {
                            // InternalAssembler.g:2870:7: (lv_decrement_3_0= '--' )
                            // InternalAssembler.g:2871:8: lv_decrement_3_0= '--'
                            {
                            lv_decrement_3_0=(Token)match(input,58,FOLLOW_15); if (state.failed) return current;
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

                    // InternalAssembler.g:2884:5: ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    // InternalAssembler.g:2885:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2885:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    // InternalAssembler.g:2886:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    {
                    // InternalAssembler.g:2886:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    int alt40=4;
                    switch ( input.LA(1) ) {
                    case 50:
                        {
                        alt40=1;
                        }
                        break;
                    case 51:
                        {
                        alt40=2;
                        }
                        break;
                    case 52:
                        {
                        alt40=3;
                        }
                        break;
                    case 53:
                        {
                        alt40=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }

                    switch (alt40) {
                        case 1 :
                            // InternalAssembler.g:2887:8: lv_register_4_1= 'S'
                            {
                            lv_register_4_1=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2898:8: lv_register_4_2= 'U'
                            {
                            lv_register_4_2=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2909:8: lv_register_4_3= 'X'
                            {
                            lv_register_4_3=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2920:8: lv_register_4_4= 'Y'
                            {
                            lv_register_4_4=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2935:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:2935:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    // InternalAssembler.g:2936:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    {
                    // InternalAssembler.g:2936:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:2937:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2937:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:2938:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:2938:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt41=4;
                    switch ( input.LA(1) ) {
                    case 50:
                        {
                        alt41=1;
                        }
                        break;
                    case 51:
                        {
                        alt41=2;
                        }
                        break;
                    case 52:
                        {
                        alt41=3;
                        }
                        break;
                    case 53:
                        {
                        alt41=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 0, input);

                        throw nvae;
                    }

                    switch (alt41) {
                        case 1 :
                            // InternalAssembler.g:2939:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,50,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:2950:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,51,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:2961:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,52,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:2972:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,53,FOLLOW_19); if (state.failed) return current;
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

                    // InternalAssembler.g:2985:5: ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==59) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==60) ) {
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
                            // InternalAssembler.g:2986:6: ( (lv_increment_6_0= '+' ) )
                            {
                            // InternalAssembler.g:2986:6: ( (lv_increment_6_0= '+' ) )
                            // InternalAssembler.g:2987:7: (lv_increment_6_0= '+' )
                            {
                            // InternalAssembler.g:2987:7: (lv_increment_6_0= '+' )
                            // InternalAssembler.g:2988:8: lv_increment_6_0= '+'
                            {
                            lv_increment_6_0=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:3001:6: ( (lv_increment_7_0= '++' ) )
                            {
                            // InternalAssembler.g:3001:6: ( (lv_increment_7_0= '++' ) )
                            // InternalAssembler.g:3002:7: (lv_increment_7_0= '++' )
                            {
                            // InternalAssembler.g:3002:7: (lv_increment_7_0= '++' )
                            // InternalAssembler.g:3003:8: lv_increment_7_0= '++'
                            {
                            lv_increment_7_0=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3022:1: entryRuleAutoIncDecIndirectMode returns [EObject current=null] : iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF ;
    public final EObject entryRuleAutoIncDecIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecIndirectMode = null;


        try {
            // InternalAssembler.g:3022:63: (iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF )
            // InternalAssembler.g:3023:2: iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF
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
    // InternalAssembler.g:3029:1: ruleAutoIncDecIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) ;
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
            // InternalAssembler.g:3035:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) )
            // InternalAssembler.g:3036:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            {
            // InternalAssembler.g:3036:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            // InternalAssembler.g:3037:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAutoIncDecIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:3041:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_CHARACTER)||LA44_0==57||LA44_0==59) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAssembler.g:3042:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:3042:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:3043:5: lv_deplacement_1_0= ruleNumericalValue
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

            otherlv_2=(Token)match(input,49,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAutoIncDecIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:3064:3: ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=57 && LA49_0<=58)) ) {
                alt49=1;
            }
            else if ( ((LA49_0>=50 && LA49_0<=53)) ) {
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
                    // InternalAssembler.g:3065:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:3065:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    // InternalAssembler.g:3066:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:3066:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==57) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==58) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalAssembler.g:3067:6: ( (lv_decrement_3_0= '-' ) )
                            {
                            // InternalAssembler.g:3067:6: ( (lv_decrement_3_0= '-' ) )
                            // InternalAssembler.g:3068:7: (lv_decrement_3_0= '-' )
                            {
                            // InternalAssembler.g:3068:7: (lv_decrement_3_0= '-' )
                            // InternalAssembler.g:3069:8: lv_decrement_3_0= '-'
                            {
                            lv_decrement_3_0=(Token)match(input,57,FOLLOW_15); if (state.failed) return current;
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
                            // InternalAssembler.g:3082:6: ( (lv_decrement_4_0= '--' ) )
                            {
                            // InternalAssembler.g:3082:6: ( (lv_decrement_4_0= '--' ) )
                            // InternalAssembler.g:3083:7: (lv_decrement_4_0= '--' )
                            {
                            // InternalAssembler.g:3083:7: (lv_decrement_4_0= '--' )
                            // InternalAssembler.g:3084:8: lv_decrement_4_0= '--'
                            {
                            lv_decrement_4_0=(Token)match(input,58,FOLLOW_15); if (state.failed) return current;
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

                    // InternalAssembler.g:3097:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:3098:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:3098:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:3099:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:3099:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt46=4;
                    switch ( input.LA(1) ) {
                    case 50:
                        {
                        alt46=1;
                        }
                        break;
                    case 51:
                        {
                        alt46=2;
                        }
                        break;
                    case 52:
                        {
                        alt46=3;
                        }
                        break;
                    case 53:
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
                            // InternalAssembler.g:3100:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,50,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:3111:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,51,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:3122:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,52,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:3133:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,53,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:3148:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:3148:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    // InternalAssembler.g:3149:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    {
                    // InternalAssembler.g:3149:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) )
                    // InternalAssembler.g:3150:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    {
                    // InternalAssembler.g:3150:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    // InternalAssembler.g:3151:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    {
                    // InternalAssembler.g:3151:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    int alt47=4;
                    switch ( input.LA(1) ) {
                    case 50:
                        {
                        alt47=1;
                        }
                        break;
                    case 51:
                        {
                        alt47=2;
                        }
                        break;
                    case 52:
                        {
                        alt47=3;
                        }
                        break;
                    case 53:
                        {
                        alt47=4;
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
                            // InternalAssembler.g:3152:8: lv_register_6_1= 'S'
                            {
                            lv_register_6_1=(Token)match(input,50,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:3163:8: lv_register_6_2= 'U'
                            {
                            lv_register_6_2=(Token)match(input,51,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:3174:8: lv_register_6_3= 'X'
                            {
                            lv_register_6_3=(Token)match(input,52,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:3185:8: lv_register_6_4= 'Y'
                            {
                            lv_register_6_4=(Token)match(input,53,FOLLOW_19); if (state.failed) return current;
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

                    // InternalAssembler.g:3198:5: ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==59) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==60) ) {
                        alt48=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalAssembler.g:3199:6: ( (lv_increment_7_0= '+' ) )
                            {
                            // InternalAssembler.g:3199:6: ( (lv_increment_7_0= '+' ) )
                            // InternalAssembler.g:3200:7: (lv_increment_7_0= '+' )
                            {
                            // InternalAssembler.g:3200:7: (lv_increment_7_0= '+' )
                            // InternalAssembler.g:3201:8: lv_increment_7_0= '+'
                            {
                            lv_increment_7_0=(Token)match(input,59,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:3214:6: ( (lv_increment_8_0= '++' ) )
                            {
                            // InternalAssembler.g:3214:6: ( (lv_increment_8_0= '++' ) )
                            // InternalAssembler.g:3215:7: (lv_increment_8_0= '++' )
                            {
                            // InternalAssembler.g:3215:7: (lv_increment_8_0= '++' )
                            // InternalAssembler.g:3216:8: lv_increment_8_0= '++'
                            {
                            lv_increment_8_0=(Token)match(input,60,FOLLOW_13); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3239:1: entryRuleRelatifToPCMode returns [EObject current=null] : iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF ;
    public final EObject entryRuleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCMode = null;


        try {
            // InternalAssembler.g:3239:56: (iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF )
            // InternalAssembler.g:3240:2: iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF
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
    // InternalAssembler.g:3246:1: ruleRelatifToPCMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) ;
    public final EObject ruleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_register_2_0=null;
        EObject lv_deplacement_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3252:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) )
            // InternalAssembler.g:3253:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            {
            // InternalAssembler.g:3253:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            // InternalAssembler.g:3254:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) )
            {
            // InternalAssembler.g:3254:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_CHARACTER)||LA50_0==57||LA50_0==59) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalAssembler.g:3255:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:3255:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:3256:5: lv_deplacement_0_0= ruleNumericalValue
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

            otherlv_1=(Token)match(input,49,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelatifToPCModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:3277:3: ( (lv_register_2_0= 'PCR' ) )
            // InternalAssembler.g:3278:4: (lv_register_2_0= 'PCR' )
            {
            // InternalAssembler.g:3278:4: (lv_register_2_0= 'PCR' )
            // InternalAssembler.g:3279:5: lv_register_2_0= 'PCR'
            {
            lv_register_2_0=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3295:1: entryRuleRelatifToPCIndirectMode returns [EObject current=null] : iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF ;
    public final EObject entryRuleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCIndirectMode = null;


        try {
            // InternalAssembler.g:3295:64: (iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF )
            // InternalAssembler.g:3296:2: iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF
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
    // InternalAssembler.g:3302:1: ruleRelatifToPCIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) ;
    public final EObject ruleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_register_3_0=null;
        Token otherlv_4=null;
        EObject lv_deplacement_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3308:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:3309:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:3309:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            // InternalAssembler.g:3310:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRelatifToPCIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:3314:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_CHARACTER)||LA51_0==57||LA51_0==59) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalAssembler.g:3315:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:3315:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:3316:5: lv_deplacement_1_0= ruleNumericalValue
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

            otherlv_2=(Token)match(input,49,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRelatifToPCIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:3337:3: ( (lv_register_3_0= 'PCR' ) )
            // InternalAssembler.g:3338:4: (lv_register_3_0= 'PCR' )
            {
            // InternalAssembler.g:3338:4: (lv_register_3_0= 'PCR' )
            // InternalAssembler.g:3339:5: lv_register_3_0= 'PCR'
            {
            lv_register_3_0=(Token)match(input,61,FOLLOW_13); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3359:1: entryRuleRelativeMode returns [EObject current=null] : iv_ruleRelativeMode= ruleRelativeMode EOF ;
    public final EObject entryRuleRelativeMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeMode = null;


        try {
            // InternalAssembler.g:3359:53: (iv_ruleRelativeMode= ruleRelativeMode EOF )
            // InternalAssembler.g:3360:2: iv_ruleRelativeMode= ruleRelativeMode EOF
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
    // InternalAssembler.g:3366:1: ruleRelativeMode returns [EObject current=null] : ( (lv_location_0_0= ruleIdentifierValue ) ) ;
    public final EObject ruleRelativeMode() throws RecognitionException {
        EObject current = null;

        EObject lv_location_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3372:2: ( ( (lv_location_0_0= ruleIdentifierValue ) ) )
            // InternalAssembler.g:3373:2: ( (lv_location_0_0= ruleIdentifierValue ) )
            {
            // InternalAssembler.g:3373:2: ( (lv_location_0_0= ruleIdentifierValue ) )
            // InternalAssembler.g:3374:3: (lv_location_0_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:3374:3: (lv_location_0_0= ruleIdentifierValue )
            // InternalAssembler.g:3375:4: lv_location_0_0= ruleIdentifierValue
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
    // InternalAssembler.g:3395:1: entryRuleDirectiveLine returns [EObject current=null] : iv_ruleDirectiveLine= ruleDirectiveLine EOF ;
    public final EObject entryRuleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectiveLine = null;


        try {
            // InternalAssembler.g:3395:54: (iv_ruleDirectiveLine= ruleDirectiveLine EOF )
            // InternalAssembler.g:3396:2: iv_ruleDirectiveLine= ruleDirectiveLine EOF
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
    // InternalAssembler.g:3402:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:3408:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3409:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3409:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3410:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3410:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalAssembler.g:3411:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3411:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3412:5: lv_name_0_0= ruleIdentifierValue
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
            // InternalAssembler.g:3433:3: ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) )
            int alt53=16;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt53=1;
                }
                break;
            case 79:
                {
                alt53=2;
                }
                break;
            case 73:
            case 74:
                {
                alt53=3;
                }
                break;
            case 78:
                {
                alt53=4;
                }
                break;
            case 69:
                {
                alt53=5;
                }
                break;
            case 72:
                {
                alt53=6;
                }
                break;
            case 68:
                {
                alt53=7;
                }
                break;
            case 67:
                {
                alt53=8;
                }
                break;
            case 65:
            case 66:
                {
                alt53=9;
                }
                break;
            case 70:
                {
                alt53=10;
                }
                break;
            case 64:
                {
                alt53=11;
                }
                break;
            case 63:
                {
                alt53=12;
                }
                break;
            case 76:
                {
                alt53=13;
                }
                break;
            case 75:
                {
                alt53=14;
                }
                break;
            case 62:
                {
                alt53=15;
                }
                break;
            case 77:
                {
                alt53=16;
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
                    // InternalAssembler.g:3434:4: ( (lv_directive_2_0= ruleEquDirective ) )
                    {
                    // InternalAssembler.g:3434:4: ( (lv_directive_2_0= ruleEquDirective ) )
                    // InternalAssembler.g:3435:5: (lv_directive_2_0= ruleEquDirective )
                    {
                    // InternalAssembler.g:3435:5: (lv_directive_2_0= ruleEquDirective )
                    // InternalAssembler.g:3436:6: lv_directive_2_0= ruleEquDirective
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
                    // InternalAssembler.g:3454:4: ( (lv_directive_3_0= ruleOrgDirective ) )
                    {
                    // InternalAssembler.g:3454:4: ( (lv_directive_3_0= ruleOrgDirective ) )
                    // InternalAssembler.g:3455:5: (lv_directive_3_0= ruleOrgDirective )
                    {
                    // InternalAssembler.g:3455:5: (lv_directive_3_0= ruleOrgDirective )
                    // InternalAssembler.g:3456:6: lv_directive_3_0= ruleOrgDirective
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
                    // InternalAssembler.g:3474:4: ( (lv_directive_4_0= ruleBszDirective ) )
                    {
                    // InternalAssembler.g:3474:4: ( (lv_directive_4_0= ruleBszDirective ) )
                    // InternalAssembler.g:3475:5: (lv_directive_4_0= ruleBszDirective )
                    {
                    // InternalAssembler.g:3475:5: (lv_directive_4_0= ruleBszDirective )
                    // InternalAssembler.g:3476:6: lv_directive_4_0= ruleBszDirective
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
                    // InternalAssembler.g:3494:4: ( (lv_directive_5_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:3494:4: ( (lv_directive_5_0= ruleEndDirective ) )
                    // InternalAssembler.g:3495:5: (lv_directive_5_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:3495:5: (lv_directive_5_0= ruleEndDirective )
                    // InternalAssembler.g:3496:6: lv_directive_5_0= ruleEndDirective
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
                    // InternalAssembler.g:3514:4: ( (lv_directive_6_0= ruleFailDirective ) )
                    {
                    // InternalAssembler.g:3514:4: ( (lv_directive_6_0= ruleFailDirective ) )
                    // InternalAssembler.g:3515:5: (lv_directive_6_0= ruleFailDirective )
                    {
                    // InternalAssembler.g:3515:5: (lv_directive_6_0= ruleFailDirective )
                    // InternalAssembler.g:3516:6: lv_directive_6_0= ruleFailDirective
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
                    // InternalAssembler.g:3534:4: ( (lv_directive_7_0= ruleFillDirective ) )
                    {
                    // InternalAssembler.g:3534:4: ( (lv_directive_7_0= ruleFillDirective ) )
                    // InternalAssembler.g:3535:5: (lv_directive_7_0= ruleFillDirective )
                    {
                    // InternalAssembler.g:3535:5: (lv_directive_7_0= ruleFillDirective )
                    // InternalAssembler.g:3536:6: lv_directive_7_0= ruleFillDirective
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
                    // InternalAssembler.g:3554:4: ( (lv_directive_8_0= ruleOptDirective ) )
                    {
                    // InternalAssembler.g:3554:4: ( (lv_directive_8_0= ruleOptDirective ) )
                    // InternalAssembler.g:3555:5: (lv_directive_8_0= ruleOptDirective )
                    {
                    // InternalAssembler.g:3555:5: (lv_directive_8_0= ruleOptDirective )
                    // InternalAssembler.g:3556:6: lv_directive_8_0= ruleOptDirective
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
                    // InternalAssembler.g:3574:4: ( (lv_directive_9_0= rulePagDirective ) )
                    {
                    // InternalAssembler.g:3574:4: ( (lv_directive_9_0= rulePagDirective ) )
                    // InternalAssembler.g:3575:5: (lv_directive_9_0= rulePagDirective )
                    {
                    // InternalAssembler.g:3575:5: (lv_directive_9_0= rulePagDirective )
                    // InternalAssembler.g:3576:6: lv_directive_9_0= rulePagDirective
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
                    // InternalAssembler.g:3594:4: ( (lv_directive_10_0= ruleNamDirective ) )
                    {
                    // InternalAssembler.g:3594:4: ( (lv_directive_10_0= ruleNamDirective ) )
                    // InternalAssembler.g:3595:5: (lv_directive_10_0= ruleNamDirective )
                    {
                    // InternalAssembler.g:3595:5: (lv_directive_10_0= ruleNamDirective )
                    // InternalAssembler.g:3596:6: lv_directive_10_0= ruleNamDirective
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
                    // InternalAssembler.g:3614:4: ( (lv_directive_11_0= ruleSetDirective ) )
                    {
                    // InternalAssembler.g:3614:4: ( (lv_directive_11_0= ruleSetDirective ) )
                    // InternalAssembler.g:3615:5: (lv_directive_11_0= ruleSetDirective )
                    {
                    // InternalAssembler.g:3615:5: (lv_directive_11_0= ruleSetDirective )
                    // InternalAssembler.g:3616:6: lv_directive_11_0= ruleSetDirective
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
                    // InternalAssembler.g:3634:4: ( (lv_directive_12_0= ruleSpcDirective ) )
                    {
                    // InternalAssembler.g:3634:4: ( (lv_directive_12_0= ruleSpcDirective ) )
                    // InternalAssembler.g:3635:5: (lv_directive_12_0= ruleSpcDirective )
                    {
                    // InternalAssembler.g:3635:5: (lv_directive_12_0= ruleSpcDirective )
                    // InternalAssembler.g:3636:6: lv_directive_12_0= ruleSpcDirective
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
                    // InternalAssembler.g:3654:4: ( (lv_directive_13_0= ruleRegDirective ) )
                    {
                    // InternalAssembler.g:3654:4: ( (lv_directive_13_0= ruleRegDirective ) )
                    // InternalAssembler.g:3655:5: (lv_directive_13_0= ruleRegDirective )
                    {
                    // InternalAssembler.g:3655:5: (lv_directive_13_0= ruleRegDirective )
                    // InternalAssembler.g:3656:6: lv_directive_13_0= ruleRegDirective
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
                    // InternalAssembler.g:3674:4: ( (lv_directive_14_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:3674:4: ( (lv_directive_14_0= ruleFcbDirective ) )
                    // InternalAssembler.g:3675:5: (lv_directive_14_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:3675:5: (lv_directive_14_0= ruleFcbDirective )
                    // InternalAssembler.g:3676:6: lv_directive_14_0= ruleFcbDirective
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
                    // InternalAssembler.g:3694:4: ( (lv_directive_15_0= ruleFdbDirective ) )
                    {
                    // InternalAssembler.g:3694:4: ( (lv_directive_15_0= ruleFdbDirective ) )
                    // InternalAssembler.g:3695:5: (lv_directive_15_0= ruleFdbDirective )
                    {
                    // InternalAssembler.g:3695:5: (lv_directive_15_0= ruleFdbDirective )
                    // InternalAssembler.g:3696:6: lv_directive_15_0= ruleFdbDirective
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
                    // InternalAssembler.g:3714:4: ( (lv_directive_16_0= ruleFccDirective ) )
                    {
                    // InternalAssembler.g:3714:4: ( (lv_directive_16_0= ruleFccDirective ) )
                    // InternalAssembler.g:3715:5: (lv_directive_16_0= ruleFccDirective )
                    {
                    // InternalAssembler.g:3715:5: (lv_directive_16_0= ruleFccDirective )
                    // InternalAssembler.g:3716:6: lv_directive_16_0= ruleFccDirective
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
                    // InternalAssembler.g:3734:4: ( (lv_directive_17_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:3734:4: ( (lv_directive_17_0= ruleRmbDirective ) )
                    // InternalAssembler.g:3735:5: (lv_directive_17_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:3735:5: (lv_directive_17_0= ruleRmbDirective )
                    // InternalAssembler.g:3736:6: lv_directive_17_0= ruleRmbDirective
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

            // InternalAssembler.g:3754:3: (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_WS) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalAssembler.g:3755:4: this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_18, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3759:4: ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3760:5: (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3760:5: (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3761:6: lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:3778:3: (this_WS_20= RULE_WS )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_WS) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalAssembler.g:3779:4: this_WS_20= RULE_WS
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
    // InternalAssembler.g:3795:1: entryRuleFccDirective returns [EObject current=null] : iv_ruleFccDirective= ruleFccDirective EOF ;
    public final EObject entryRuleFccDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFccDirective = null;


        try {
            // InternalAssembler.g:3795:53: (iv_ruleFccDirective= ruleFccDirective EOF )
            // InternalAssembler.g:3796:2: iv_ruleFccDirective= ruleFccDirective EOF
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
    // InternalAssembler.g:3802:1: ruleFccDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleFccDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_string_2_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3808:2: ( ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) ) )
            // InternalAssembler.g:3809:2: ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) )
            {
            // InternalAssembler.g:3809:2: ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) )
            // InternalAssembler.g:3810:3: ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) )
            {
            // InternalAssembler.g:3810:3: ( (lv_directive_0_0= 'FCC' ) )
            // InternalAssembler.g:3811:4: (lv_directive_0_0= 'FCC' )
            {
            // InternalAssembler.g:3811:4: (lv_directive_0_0= 'FCC' )
            // InternalAssembler.g:3812:5: lv_directive_0_0= 'FCC'
            {
            lv_directive_0_0=(Token)match(input,62,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:3824:3: (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) )
            // InternalAssembler.g:3825:4: this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:3829:4: ( (lv_string_2_0= RULE_STRING ) )
            // InternalAssembler.g:3830:5: (lv_string_2_0= RULE_STRING )
            {
            // InternalAssembler.g:3830:5: (lv_string_2_0= RULE_STRING )
            // InternalAssembler.g:3831:6: lv_string_2_0= RULE_STRING
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
    // InternalAssembler.g:3852:1: entryRuleRegDirective returns [EObject current=null] : iv_ruleRegDirective= ruleRegDirective EOF ;
    public final EObject entryRuleRegDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegDirective = null;


        try {
            // InternalAssembler.g:3852:53: (iv_ruleRegDirective= ruleRegDirective EOF )
            // InternalAssembler.g:3853:2: iv_ruleRegDirective= ruleRegDirective EOF
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
    // InternalAssembler.g:3859:1: ruleRegDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? ) ;
    public final EObject ruleRegDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_options_2_0 = null;

        Enumerator lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3865:2: ( ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? ) )
            // InternalAssembler.g:3866:2: ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? )
            {
            // InternalAssembler.g:3866:2: ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? )
            // InternalAssembler.g:3867:3: ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )?
            {
            // InternalAssembler.g:3867:3: ( (lv_directive_0_0= 'REG' ) )
            // InternalAssembler.g:3868:4: (lv_directive_0_0= 'REG' )
            {
            // InternalAssembler.g:3868:4: (lv_directive_0_0= 'REG' )
            // InternalAssembler.g:3869:5: lv_directive_0_0= 'REG'
            {
            lv_directive_0_0=(Token)match(input,63,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:3881:3: (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_WS) ) {
                int LA57_1 = input.LA(2);

                if ( ((LA57_1>=50 && LA57_1<=56)||(LA57_1>=98 && LA57_1<=100)) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalAssembler.g:3882:4: this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )*
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3886:4: ( (lv_options_2_0= ruleRegister ) )
                    // InternalAssembler.g:3887:5: (lv_options_2_0= ruleRegister )
                    {
                    // InternalAssembler.g:3887:5: (lv_options_2_0= ruleRegister )
                    // InternalAssembler.g:3888:6: lv_options_2_0= ruleRegister
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

                    // InternalAssembler.g:3905:4: (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==49) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalAssembler.g:3906:5: otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) )
                    	    {
                    	    otherlv_3=(Token)match(input,49,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getRegDirectiveAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:3910:5: ( (lv_options_4_0= ruleRegister ) )
                    	    // InternalAssembler.g:3911:6: (lv_options_4_0= ruleRegister )
                    	    {
                    	    // InternalAssembler.g:3911:6: (lv_options_4_0= ruleRegister )
                    	    // InternalAssembler.g:3912:7: lv_options_4_0= ruleRegister
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
                    	    break loop56;
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
    // InternalAssembler.g:3935:1: entryRuleSpcDirective returns [EObject current=null] : iv_ruleSpcDirective= ruleSpcDirective EOF ;
    public final EObject entryRuleSpcDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpcDirective = null;


        try {
            // InternalAssembler.g:3935:53: (iv_ruleSpcDirective= ruleSpcDirective EOF )
            // InternalAssembler.g:3936:2: iv_ruleSpcDirective= ruleSpcDirective EOF
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
    // InternalAssembler.g:3942:1: ruleSpcDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? ) ;
    public final EObject ruleSpcDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        EObject lv_spaceCount_2_0 = null;

        EObject lv_keepCount_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3948:2: ( ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? ) )
            // InternalAssembler.g:3949:2: ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? )
            {
            // InternalAssembler.g:3949:2: ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? )
            // InternalAssembler.g:3950:3: ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )?
            {
            // InternalAssembler.g:3950:3: ( (lv_directive_0_0= 'SPC' ) )
            // InternalAssembler.g:3951:4: (lv_directive_0_0= 'SPC' )
            {
            // InternalAssembler.g:3951:4: (lv_directive_0_0= 'SPC' )
            // InternalAssembler.g:3952:5: lv_directive_0_0= 'SPC'
            {
            lv_directive_0_0=(Token)match(input,64,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:3964:3: (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_WS) ) {
                int LA59_1 = input.LA(2);

                if ( ((LA59_1>=RULE_ID && LA59_1<=RULE_CHARACTER)||LA59_1==57||LA59_1==59||(LA59_1>=88 && LA59_1<=89)) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalAssembler.g:3965:4: this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )?
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3969:4: ( (lv_spaceCount_2_0= ruleExpression ) )
                    // InternalAssembler.g:3970:5: (lv_spaceCount_2_0= ruleExpression )
                    {
                    // InternalAssembler.g:3970:5: (lv_spaceCount_2_0= ruleExpression )
                    // InternalAssembler.g:3971:6: lv_spaceCount_2_0= ruleExpression
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

                    // InternalAssembler.g:3988:4: (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==49) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalAssembler.g:3989:5: otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) )
                            {
                            otherlv_3=(Token)match(input,49,FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getSpcDirectiveAccess().getCommaKeyword_1_2_0());
                              				
                            }
                            // InternalAssembler.g:3993:5: ( (lv_keepCount_4_0= ruleExpression ) )
                            // InternalAssembler.g:3994:6: (lv_keepCount_4_0= ruleExpression )
                            {
                            // InternalAssembler.g:3994:6: (lv_keepCount_4_0= ruleExpression )
                            // InternalAssembler.g:3995:7: lv_keepCount_4_0= ruleExpression
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
    // InternalAssembler.g:4018:1: entryRuleNamDirective returns [EObject current=null] : iv_ruleNamDirective= ruleNamDirective EOF ;
    public final EObject entryRuleNamDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamDirective = null;


        try {
            // InternalAssembler.g:4018:53: (iv_ruleNamDirective= ruleNamDirective EOF )
            // InternalAssembler.g:4019:2: iv_ruleNamDirective= ruleNamDirective EOF
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
    // InternalAssembler.g:4025:1: ruleNamDirective returns [EObject current=null] : ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) ) ;
    public final EObject ruleNamDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token lv_directive_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4031:2: ( ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:4032:2: ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:4032:2: ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) )
            // InternalAssembler.g:4033:3: ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) )
            {
            // InternalAssembler.g:4033:3: ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==65) ) {
                alt60=1;
            }
            else if ( (LA60_0==66) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalAssembler.g:4034:4: ( (lv_directive_0_0= 'NAM' ) )
                    {
                    // InternalAssembler.g:4034:4: ( (lv_directive_0_0= 'NAM' ) )
                    // InternalAssembler.g:4035:5: (lv_directive_0_0= 'NAM' )
                    {
                    // InternalAssembler.g:4035:5: (lv_directive_0_0= 'NAM' )
                    // InternalAssembler.g:4036:6: lv_directive_0_0= 'NAM'
                    {
                    lv_directive_0_0=(Token)match(input,65,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:4049:4: ( (lv_directive_1_0= 'TTL' ) )
                    {
                    // InternalAssembler.g:4049:4: ( (lv_directive_1_0= 'TTL' ) )
                    // InternalAssembler.g:4050:5: (lv_directive_1_0= 'TTL' )
                    {
                    // InternalAssembler.g:4050:5: (lv_directive_1_0= 'TTL' )
                    // InternalAssembler.g:4051:6: lv_directive_1_0= 'TTL'
                    {
                    lv_directive_1_0=(Token)match(input,66,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:4068:3: ( (lv_operand_3_0= ruleIdentifierValue ) )
            // InternalAssembler.g:4069:4: (lv_operand_3_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:4069:4: (lv_operand_3_0= ruleIdentifierValue )
            // InternalAssembler.g:4070:5: lv_operand_3_0= ruleIdentifierValue
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
    // InternalAssembler.g:4091:1: entryRulePagDirective returns [EObject current=null] : iv_rulePagDirective= rulePagDirective EOF ;
    public final EObject entryRulePagDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePagDirective = null;


        try {
            // InternalAssembler.g:4091:53: (iv_rulePagDirective= rulePagDirective EOF )
            // InternalAssembler.g:4092:2: iv_rulePagDirective= rulePagDirective EOF
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
    // InternalAssembler.g:4098:1: rulePagDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? ) ;
    public final EObject rulePagDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4104:2: ( ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? ) )
            // InternalAssembler.g:4105:2: ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? )
            {
            // InternalAssembler.g:4105:2: ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? )
            // InternalAssembler.g:4106:3: ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )?
            {
            // InternalAssembler.g:4106:3: ( (lv_directive_0_0= 'PAG' ) )
            // InternalAssembler.g:4107:4: (lv_directive_0_0= 'PAG' )
            {
            // InternalAssembler.g:4107:4: (lv_directive_0_0= 'PAG' )
            // InternalAssembler.g:4108:5: lv_directive_0_0= 'PAG'
            {
            lv_directive_0_0=(Token)match(input,67,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:4120:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_WS) ) {
                int LA61_1 = input.LA(2);

                if ( ((LA61_1>=RULE_ID && LA61_1<=RULE_CHARACTER)||LA61_1==57||LA61_1==59||(LA61_1>=88 && LA61_1<=89)) ) {
                    alt61=1;
                }
            }
            switch (alt61) {
                case 1 :
                    // InternalAssembler.g:4121:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4125:4: ( (lv_operand_2_0= ruleExpression ) )
                    // InternalAssembler.g:4126:5: (lv_operand_2_0= ruleExpression )
                    {
                    // InternalAssembler.g:4126:5: (lv_operand_2_0= ruleExpression )
                    // InternalAssembler.g:4127:6: lv_operand_2_0= ruleExpression
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
    // InternalAssembler.g:4149:1: entryRuleOptDirective returns [EObject current=null] : iv_ruleOptDirective= ruleOptDirective EOF ;
    public final EObject entryRuleOptDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptDirective = null;


        try {
            // InternalAssembler.g:4149:53: (iv_ruleOptDirective= ruleOptDirective EOF )
            // InternalAssembler.g:4150:2: iv_ruleOptDirective= ruleOptDirective EOF
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
    // InternalAssembler.g:4156:1: ruleOptDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? ) ;
    public final EObject ruleOptDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_options_2_0 = null;

        Enumerator lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4162:2: ( ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? ) )
            // InternalAssembler.g:4163:2: ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? )
            {
            // InternalAssembler.g:4163:2: ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? )
            // InternalAssembler.g:4164:3: ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )?
            {
            // InternalAssembler.g:4164:3: ( (lv_directive_0_0= 'OPT' ) )
            // InternalAssembler.g:4165:4: (lv_directive_0_0= 'OPT' )
            {
            // InternalAssembler.g:4165:4: (lv_directive_0_0= 'OPT' )
            // InternalAssembler.g:4166:5: lv_directive_0_0= 'OPT'
            {
            lv_directive_0_0=(Token)match(input,68,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:4178:3: (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_WS) ) {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==67||(LA63_1>=91 && LA63_1<=97)) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // InternalAssembler.g:4179:4: this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )*
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4183:4: ( (lv_options_2_0= ruleAssemblyOption ) )
                    // InternalAssembler.g:4184:5: (lv_options_2_0= ruleAssemblyOption )
                    {
                    // InternalAssembler.g:4184:5: (lv_options_2_0= ruleAssemblyOption )
                    // InternalAssembler.g:4185:6: lv_options_2_0= ruleAssemblyOption
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

                    // InternalAssembler.g:4202:4: (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==49) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalAssembler.g:4203:5: otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) )
                    	    {
                    	    otherlv_3=(Token)match(input,49,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getOptDirectiveAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:4207:5: ( (lv_options_4_0= ruleAssemblyOption ) )
                    	    // InternalAssembler.g:4208:6: (lv_options_4_0= ruleAssemblyOption )
                    	    {
                    	    // InternalAssembler.g:4208:6: (lv_options_4_0= ruleAssemblyOption )
                    	    // InternalAssembler.g:4209:7: lv_options_4_0= ruleAssemblyOption
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
                    	    break loop62;
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
    // InternalAssembler.g:4232:1: entryRuleFailDirective returns [EObject current=null] : iv_ruleFailDirective= ruleFailDirective EOF ;
    public final EObject entryRuleFailDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailDirective = null;


        try {
            // InternalAssembler.g:4232:54: (iv_ruleFailDirective= ruleFailDirective EOF )
            // InternalAssembler.g:4233:2: iv_ruleFailDirective= ruleFailDirective EOF
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
    // InternalAssembler.g:4239:1: ruleFailDirective returns [EObject current=null] : ( (lv_directive_0_0= 'FAIL' ) ) ;
    public final EObject ruleFailDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:4245:2: ( ( (lv_directive_0_0= 'FAIL' ) ) )
            // InternalAssembler.g:4246:2: ( (lv_directive_0_0= 'FAIL' ) )
            {
            // InternalAssembler.g:4246:2: ( (lv_directive_0_0= 'FAIL' ) )
            // InternalAssembler.g:4247:3: (lv_directive_0_0= 'FAIL' )
            {
            // InternalAssembler.g:4247:3: (lv_directive_0_0= 'FAIL' )
            // InternalAssembler.g:4248:4: lv_directive_0_0= 'FAIL'
            {
            lv_directive_0_0=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4263:1: entryRuleSetDirective returns [EObject current=null] : iv_ruleSetDirective= ruleSetDirective EOF ;
    public final EObject entryRuleSetDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDirective = null;


        try {
            // InternalAssembler.g:4263:53: (iv_ruleSetDirective= ruleSetDirective EOF )
            // InternalAssembler.g:4264:2: iv_ruleSetDirective= ruleSetDirective EOF
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
    // InternalAssembler.g:4270:1: ruleSetDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) ;
    public final EObject ruleSetDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4276:2: ( ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) )
            // InternalAssembler.g:4277:2: ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            {
            // InternalAssembler.g:4277:2: ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            // InternalAssembler.g:4278:3: ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            {
            // InternalAssembler.g:4278:3: ( (lv_directive_0_0= 'SET' ) )
            // InternalAssembler.g:4279:4: (lv_directive_0_0= 'SET' )
            {
            // InternalAssembler.g:4279:4: (lv_directive_0_0= 'SET' )
            // InternalAssembler.g:4280:5: lv_directive_0_0= 'SET'
            {
            lv_directive_0_0=(Token)match(input,70,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:4296:3: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==71) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==EOF||LA65_1==RULE_WS||(LA65_1>=RULE_CR && LA65_1<=RULE_END_OF_FILE)) ) {
                    alt65=2;
                }
                else if ( ((LA65_1>=RULE_ID && LA65_1<=RULE_CHARACTER)||LA65_1==57||LA65_1==59||(LA65_1>=88 && LA65_1<=89)) ) {
                    alt65=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA65_0>=RULE_ID && LA65_0<=RULE_CHARACTER)||LA65_0==57||LA65_0==59||(LA65_0>=88 && LA65_0<=89)) ) {
                alt65=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalAssembler.g:4297:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:4297:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:4298:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:4298:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==71) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalAssembler.g:4299:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:4299:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:4300:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,71,FOLLOW_12); if (state.failed) return current;
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

                    // InternalAssembler.g:4312:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:4313:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:4313:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:4314:7: lv_operand_3_0= ruleExpression
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
                    // InternalAssembler.g:4333:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    {
                    // InternalAssembler.g:4333:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    // InternalAssembler.g:4334:5: (lv_isRelativeToPC_4_0= '*' )
                    {
                    // InternalAssembler.g:4334:5: (lv_isRelativeToPC_4_0= '*' )
                    // InternalAssembler.g:4335:6: lv_isRelativeToPC_4_0= '*'
                    {
                    lv_isRelativeToPC_4_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4352:1: entryRuleFillDirective returns [EObject current=null] : iv_ruleFillDirective= ruleFillDirective EOF ;
    public final EObject entryRuleFillDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFillDirective = null;


        try {
            // InternalAssembler.g:4352:54: (iv_ruleFillDirective= ruleFillDirective EOF )
            // InternalAssembler.g:4353:2: iv_ruleFillDirective= ruleFillDirective EOF
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
    // InternalAssembler.g:4359:1: ruleFillDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) ) ;
    public final EObject ruleFillDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;

        EObject lv_number_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4365:2: ( ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) ) )
            // InternalAssembler.g:4366:2: ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) )
            {
            // InternalAssembler.g:4366:2: ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) )
            // InternalAssembler.g:4367:3: ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:4367:3: ( (lv_directive_0_0= 'FILL' ) )
            // InternalAssembler.g:4368:4: (lv_directive_0_0= 'FILL' )
            {
            // InternalAssembler.g:4368:4: (lv_directive_0_0= 'FILL' )
            // InternalAssembler.g:4369:5: lv_directive_0_0= 'FILL'
            {
            lv_directive_0_0=(Token)match(input,72,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:4381:3: (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) )
            // InternalAssembler.g:4382:4: this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:4386:4: ( (lv_value_2_0= ruleExpression ) )
            // InternalAssembler.g:4387:5: (lv_value_2_0= ruleExpression )
            {
            // InternalAssembler.g:4387:5: (lv_value_2_0= ruleExpression )
            // InternalAssembler.g:4388:6: lv_value_2_0= ruleExpression
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

            otherlv_3=(Token)match(input,49,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_3, grammarAccess.getFillDirectiveAccess().getCommaKeyword_1_2());
              			
            }
            // InternalAssembler.g:4409:4: ( (lv_number_4_0= ruleExpression ) )
            // InternalAssembler.g:4410:5: (lv_number_4_0= ruleExpression )
            {
            // InternalAssembler.g:4410:5: (lv_number_4_0= ruleExpression )
            // InternalAssembler.g:4411:6: lv_number_4_0= ruleExpression
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
    // InternalAssembler.g:4433:1: entryRuleBszDirective returns [EObject current=null] : iv_ruleBszDirective= ruleBszDirective EOF ;
    public final EObject entryRuleBszDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBszDirective = null;


        try {
            // InternalAssembler.g:4433:53: (iv_ruleBszDirective= ruleBszDirective EOF )
            // InternalAssembler.g:4434:2: iv_ruleBszDirective= ruleBszDirective EOF
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
    // InternalAssembler.g:4440:1: ruleBszDirective returns [EObject current=null] : ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) ) ;
    public final EObject ruleBszDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_1=null;
        Token lv_directive_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4446:2: ( ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) ) )
            // InternalAssembler.g:4447:2: ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) )
            {
            // InternalAssembler.g:4447:2: ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) )
            // InternalAssembler.g:4448:3: ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:4448:3: ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) )
            // InternalAssembler.g:4449:4: ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) )
            {
            // InternalAssembler.g:4449:4: ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) )
            // InternalAssembler.g:4450:5: (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' )
            {
            // InternalAssembler.g:4450:5: (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==73) ) {
                alt66=1;
            }
            else if ( (LA66_0==74) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalAssembler.g:4451:6: lv_directive_0_1= 'BSZ'
                    {
                    lv_directive_0_1=(Token)match(input,73,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:4462:6: lv_directive_0_2= 'ZMB'
                    {
                    lv_directive_0_2=(Token)match(input,74,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:4475:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )
            // InternalAssembler.g:4476:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:4480:4: ( (lv_operand_2_0= ruleExpression ) )
            // InternalAssembler.g:4481:5: (lv_operand_2_0= ruleExpression )
            {
            // InternalAssembler.g:4481:5: (lv_operand_2_0= ruleExpression )
            // InternalAssembler.g:4482:6: lv_operand_2_0= ruleExpression
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
    // InternalAssembler.g:4504:1: entryRuleFdbDirective returns [EObject current=null] : iv_ruleFdbDirective= ruleFdbDirective EOF ;
    public final EObject entryRuleFdbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFdbDirective = null;


        try {
            // InternalAssembler.g:4504:53: (iv_ruleFdbDirective= ruleFdbDirective EOF )
            // InternalAssembler.g:4505:2: iv_ruleFdbDirective= ruleFdbDirective EOF
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
    // InternalAssembler.g:4511:1: ruleFdbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) ;
    public final EObject ruleFdbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4517:2: ( ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) )
            // InternalAssembler.g:4518:2: ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            {
            // InternalAssembler.g:4518:2: ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            // InternalAssembler.g:4519:3: ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            {
            // InternalAssembler.g:4519:3: ( (lv_directive_0_0= 'FDB' ) )
            // InternalAssembler.g:4520:4: (lv_directive_0_0= 'FDB' )
            {
            // InternalAssembler.g:4520:4: (lv_directive_0_0= 'FDB' )
            // InternalAssembler.g:4521:5: lv_directive_0_0= 'FDB'
            {
            lv_directive_0_0=(Token)match(input,75,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:4533:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_WS) ) {
                int LA67_1 = input.LA(2);

                if ( ((LA67_1>=RULE_ID && LA67_1<=RULE_CHARACTER)||LA67_1==57||LA67_1==59||(LA67_1>=88 && LA67_1<=89)) ) {
                    alt67=1;
                }
            }
            switch (alt67) {
                case 1 :
                    // InternalAssembler.g:4534:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4538:4: ( (lv_operand_2_0= ruleListOfExpression ) )
                    // InternalAssembler.g:4539:5: (lv_operand_2_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:4539:5: (lv_operand_2_0= ruleListOfExpression )
                    // InternalAssembler.g:4540:6: lv_operand_2_0= ruleListOfExpression
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
    // InternalAssembler.g:4562:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:4562:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:4563:2: iv_ruleFcbDirective= ruleFcbDirective EOF
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
    // InternalAssembler.g:4569:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) ;
    public final EObject ruleFcbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4575:2: ( ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) )
            // InternalAssembler.g:4576:2: ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            {
            // InternalAssembler.g:4576:2: ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            // InternalAssembler.g:4577:3: ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            {
            // InternalAssembler.g:4577:3: ( (lv_directive_0_0= 'FCB' ) )
            // InternalAssembler.g:4578:4: (lv_directive_0_0= 'FCB' )
            {
            // InternalAssembler.g:4578:4: (lv_directive_0_0= 'FCB' )
            // InternalAssembler.g:4579:5: lv_directive_0_0= 'FCB'
            {
            lv_directive_0_0=(Token)match(input,76,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:4591:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_WS) ) {
                int LA68_1 = input.LA(2);

                if ( ((LA68_1>=RULE_ID && LA68_1<=RULE_CHARACTER)||LA68_1==57||LA68_1==59||(LA68_1>=88 && LA68_1<=89)) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalAssembler.g:4592:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4596:4: ( (lv_operand_2_0= ruleListOfExpression ) )
                    // InternalAssembler.g:4597:5: (lv_operand_2_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:4597:5: (lv_operand_2_0= ruleListOfExpression )
                    // InternalAssembler.g:4598:6: lv_operand_2_0= ruleListOfExpression
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
    // InternalAssembler.g:4620:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:4620:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:4621:2: iv_ruleRmbDirective= ruleRmbDirective EOF
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
    // InternalAssembler.g:4627:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? ) ;
    public final EObject ruleRmbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4633:2: ( ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? ) )
            // InternalAssembler.g:4634:2: ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? )
            {
            // InternalAssembler.g:4634:2: ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? )
            // InternalAssembler.g:4635:3: ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )?
            {
            // InternalAssembler.g:4635:3: ( (lv_directive_0_0= 'RMB' ) )
            // InternalAssembler.g:4636:4: (lv_directive_0_0= 'RMB' )
            {
            // InternalAssembler.g:4636:4: (lv_directive_0_0= 'RMB' )
            // InternalAssembler.g:4637:5: lv_directive_0_0= 'RMB'
            {
            lv_directive_0_0=(Token)match(input,77,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:4649:3: (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_WS) ) {
                int LA70_1 = input.LA(2);

                if ( ((LA70_1>=RULE_ID && LA70_1<=RULE_CHARACTER)||LA70_1==57||LA70_1==59||LA70_1==71||(LA70_1>=88 && LA70_1<=89)) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalAssembler.g:4650:4: this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4654:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:4655:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:4655:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==71) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalAssembler.g:4656:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:4656:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:4657:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,71,FOLLOW_12); if (state.failed) return current;
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

                    // InternalAssembler.g:4669:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:4670:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:4670:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:4671:7: lv_operand_3_0= ruleExpression
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
    // InternalAssembler.g:4694:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:4694:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:4695:2: iv_ruleEndDirective= ruleEndDirective EOF
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
    // InternalAssembler.g:4701:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) ;
    public final EObject ruleEndDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4707:2: ( ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) )
            // InternalAssembler.g:4708:2: ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            {
            // InternalAssembler.g:4708:2: ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            // InternalAssembler.g:4709:3: ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            {
            // InternalAssembler.g:4709:3: ( (lv_directive_0_0= 'END' ) )
            // InternalAssembler.g:4710:4: (lv_directive_0_0= 'END' )
            {
            // InternalAssembler.g:4710:4: (lv_directive_0_0= 'END' )
            // InternalAssembler.g:4711:5: lv_directive_0_0= 'END'
            {
            lv_directive_0_0=(Token)match(input,78,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:4723:3: (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_WS) ) {
                int LA73_1 = input.LA(2);

                if ( ((LA73_1>=RULE_ID && LA73_1<=RULE_CHARACTER)||LA73_1==57||LA73_1==59||LA73_1==71||(LA73_1>=88 && LA73_1<=89)) ) {
                    alt73=1;
                }
            }
            switch (alt73) {
                case 1 :
                    // InternalAssembler.g:4724:4: this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4728:4: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==71) ) {
                        int LA72_1 = input.LA(2);

                        if ( ((LA72_1>=RULE_ID && LA72_1<=RULE_CHARACTER)||LA72_1==57||LA72_1==59||(LA72_1>=88 && LA72_1<=89)) ) {
                            alt72=1;
                        }
                        else if ( (LA72_1==EOF||LA72_1==RULE_WS||(LA72_1>=RULE_CR && LA72_1<=RULE_END_OF_FILE)) ) {
                            alt72=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 72, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA72_0>=RULE_ID && LA72_0<=RULE_CHARACTER)||LA72_0==57||LA72_0==59||(LA72_0>=88 && LA72_0<=89)) ) {
                        alt72=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 72, 0, input);

                        throw nvae;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalAssembler.g:4729:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:4729:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            // InternalAssembler.g:4730:6: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:4730:6: ( (lv_isRelativeToPC_2_0= '*' ) )?
                            int alt71=2;
                            int LA71_0 = input.LA(1);

                            if ( (LA71_0==71) ) {
                                alt71=1;
                            }
                            switch (alt71) {
                                case 1 :
                                    // InternalAssembler.g:4731:7: (lv_isRelativeToPC_2_0= '*' )
                                    {
                                    // InternalAssembler.g:4731:7: (lv_isRelativeToPC_2_0= '*' )
                                    // InternalAssembler.g:4732:8: lv_isRelativeToPC_2_0= '*'
                                    {
                                    lv_isRelativeToPC_2_0=(Token)match(input,71,FOLLOW_12); if (state.failed) return current;
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

                            // InternalAssembler.g:4744:6: ( (lv_operand_3_0= ruleExpression ) )
                            // InternalAssembler.g:4745:7: (lv_operand_3_0= ruleExpression )
                            {
                            // InternalAssembler.g:4745:7: (lv_operand_3_0= ruleExpression )
                            // InternalAssembler.g:4746:8: lv_operand_3_0= ruleExpression
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
                            // InternalAssembler.g:4765:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            {
                            // InternalAssembler.g:4765:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            // InternalAssembler.g:4766:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:4766:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:4767:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4785:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:4785:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:4786:2: iv_ruleOrgDirective= ruleOrgDirective EOF
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
    // InternalAssembler.g:4792:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) ;
    public final EObject ruleOrgDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4798:2: ( ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) )
            // InternalAssembler.g:4799:2: ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            {
            // InternalAssembler.g:4799:2: ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            // InternalAssembler.g:4800:3: ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            {
            // InternalAssembler.g:4800:3: ( (lv_directive_0_0= 'ORG' ) )
            // InternalAssembler.g:4801:4: (lv_directive_0_0= 'ORG' )
            {
            // InternalAssembler.g:4801:4: (lv_directive_0_0= 'ORG' )
            // InternalAssembler.g:4802:5: lv_directive_0_0= 'ORG'
            {
            lv_directive_0_0=(Token)match(input,79,FOLLOW_23); if (state.failed) return current;
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

            // InternalAssembler.g:4814:3: (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_WS) ) {
                int LA76_1 = input.LA(2);

                if ( ((LA76_1>=RULE_ID && LA76_1<=RULE_CHARACTER)||LA76_1==57||LA76_1==59||LA76_1==71||(LA76_1>=88 && LA76_1<=89)) ) {
                    alt76=1;
                }
            }
            switch (alt76) {
                case 1 :
                    // InternalAssembler.g:4815:4: this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4819:4: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==71) ) {
                        int LA75_1 = input.LA(2);

                        if ( ((LA75_1>=RULE_ID && LA75_1<=RULE_CHARACTER)||LA75_1==57||LA75_1==59||(LA75_1>=88 && LA75_1<=89)) ) {
                            alt75=1;
                        }
                        else if ( (LA75_1==EOF||LA75_1==RULE_WS||(LA75_1>=RULE_CR && LA75_1<=RULE_END_OF_FILE)) ) {
                            alt75=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 75, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA75_0>=RULE_ID && LA75_0<=RULE_CHARACTER)||LA75_0==57||LA75_0==59||(LA75_0>=88 && LA75_0<=89)) ) {
                        alt75=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalAssembler.g:4820:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:4820:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            // InternalAssembler.g:4821:6: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:4821:6: ( (lv_isRelativeToPC_2_0= '*' ) )?
                            int alt74=2;
                            int LA74_0 = input.LA(1);

                            if ( (LA74_0==71) ) {
                                alt74=1;
                            }
                            switch (alt74) {
                                case 1 :
                                    // InternalAssembler.g:4822:7: (lv_isRelativeToPC_2_0= '*' )
                                    {
                                    // InternalAssembler.g:4822:7: (lv_isRelativeToPC_2_0= '*' )
                                    // InternalAssembler.g:4823:8: lv_isRelativeToPC_2_0= '*'
                                    {
                                    lv_isRelativeToPC_2_0=(Token)match(input,71,FOLLOW_12); if (state.failed) return current;
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

                            // InternalAssembler.g:4835:6: ( (lv_operand_3_0= ruleExpression ) )
                            // InternalAssembler.g:4836:7: (lv_operand_3_0= ruleExpression )
                            {
                            // InternalAssembler.g:4836:7: (lv_operand_3_0= ruleExpression )
                            // InternalAssembler.g:4837:8: lv_operand_3_0= ruleExpression
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
                            // InternalAssembler.g:4856:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            {
                            // InternalAssembler.g:4856:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            // InternalAssembler.g:4857:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:4857:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:4858:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4876:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:4876:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:4877:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:4883:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) ;
    public final EObject ruleEquDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4889:2: ( ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) )
            // InternalAssembler.g:4890:2: ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            {
            // InternalAssembler.g:4890:2: ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            // InternalAssembler.g:4891:3: ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            {
            // InternalAssembler.g:4891:3: ( (lv_directive_0_0= 'EQU' ) )
            // InternalAssembler.g:4892:4: (lv_directive_0_0= 'EQU' )
            {
            // InternalAssembler.g:4892:4: (lv_directive_0_0= 'EQU' )
            // InternalAssembler.g:4893:5: lv_directive_0_0= 'EQU'
            {
            lv_directive_0_0=(Token)match(input,80,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:4909:3: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==71) ) {
                int LA78_1 = input.LA(2);

                if ( ((LA78_1>=RULE_ID && LA78_1<=RULE_CHARACTER)||LA78_1==57||LA78_1==59||(LA78_1>=88 && LA78_1<=89)) ) {
                    alt78=1;
                }
                else if ( (LA78_1==EOF||LA78_1==RULE_WS||(LA78_1>=RULE_CR && LA78_1<=RULE_END_OF_FILE)) ) {
                    alt78=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA78_0>=RULE_ID && LA78_0<=RULE_CHARACTER)||LA78_0==57||LA78_0==59||(LA78_0>=88 && LA78_0<=89)) ) {
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
                    // InternalAssembler.g:4910:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:4910:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:4911:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:4911:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==71) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalAssembler.g:4912:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:4912:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:4913:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,71,FOLLOW_12); if (state.failed) return current;
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

                    // InternalAssembler.g:4925:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:4926:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:4926:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:4927:7: lv_operand_3_0= ruleExpression
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
                    // InternalAssembler.g:4946:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    {
                    // InternalAssembler.g:4946:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    // InternalAssembler.g:4947:5: (lv_isRelativeToPC_4_0= '*' )
                    {
                    // InternalAssembler.g:4947:5: (lv_isRelativeToPC_4_0= '*' )
                    // InternalAssembler.g:4948:6: lv_isRelativeToPC_4_0= '*'
                    {
                    lv_isRelativeToPC_4_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4965:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:4965:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:4966:2: iv_ruleListOfExpression= ruleListOfExpression EOF
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
    // InternalAssembler.g:4972:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4978:2: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalAssembler.g:4979:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalAssembler.g:4979:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalAssembler.g:4980:3: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalAssembler.g:4980:3: ( (lv_expressions_0_0= ruleExpression ) )
            // InternalAssembler.g:4981:4: (lv_expressions_0_0= ruleExpression )
            {
            // InternalAssembler.g:4981:4: (lv_expressions_0_0= ruleExpression )
            // InternalAssembler.g:4982:5: lv_expressions_0_0= ruleExpression
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

            // InternalAssembler.g:4999:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==49) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalAssembler.g:5000:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,49,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:5004:4: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalAssembler.g:5005:5: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalAssembler.g:5005:5: (lv_expressions_2_0= ruleExpression )
            	    // InternalAssembler.g:5006:6: lv_expressions_2_0= ruleExpression
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
            	    break loop79;
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
    // InternalAssembler.g:5028:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:5028:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:5029:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalAssembler.g:5035:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5041:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:5042:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:5042:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:5043:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:5043:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:5044:4: lv_operand_0_0= ruleMultiplication
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
    // InternalAssembler.g:5064:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:5064:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:5065:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:5071:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5077:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:5078:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:5078:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:5079:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
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
            // InternalAssembler.g:5087:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==71) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalAssembler.g:5088:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:5088:4: ()
            	    // InternalAssembler.g:5089:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5095:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:5096:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:5096:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:5097:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,71,FOLLOW_12); if (state.failed) return current;
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

            	    // InternalAssembler.g:5109:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:5110:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:5110:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:5111:6: lv_right_3_0= ruleDivision
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
            	    break loop80;
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
    // InternalAssembler.g:5133:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:5133:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:5134:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:5140:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5146:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:5147:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:5147:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:5148:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
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
            // InternalAssembler.g:5156:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==81) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalAssembler.g:5157:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:5157:4: ()
            	    // InternalAssembler.g:5158:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5164:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:5165:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:5165:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:5166:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,81,FOLLOW_12); if (state.failed) return current;
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

            	    // InternalAssembler.g:5178:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:5179:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:5179:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:5180:6: lv_right_3_0= ruleModulo
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
            	    break loop81;
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
    // InternalAssembler.g:5202:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:5202:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:5203:2: iv_ruleModulo= ruleModulo EOF
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
    // InternalAssembler.g:5209:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5215:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:5216:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:5216:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:5217:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
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
            // InternalAssembler.g:5225:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==82) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalAssembler.g:5226:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:5226:4: ()
            	    // InternalAssembler.g:5227:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5233:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:5234:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:5234:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:5235:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,82,FOLLOW_12); if (state.failed) return current;
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

            	    // InternalAssembler.g:5247:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:5248:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:5248:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:5249:6: lv_right_3_0= ruleAddition
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
            	    break loop82;
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
    // InternalAssembler.g:5271:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:5271:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:5272:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:5278:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5284:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:5285:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:5285:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:5286:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
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
            // InternalAssembler.g:5294:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==59) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalAssembler.g:5295:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:5295:4: ()
            	    // InternalAssembler.g:5296:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,59,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5306:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:5307:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:5307:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:5308:6: lv_right_3_0= ruleSubstraction
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
            	    break loop83;
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
    // InternalAssembler.g:5330:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:5330:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:5331:2: iv_ruleSubstraction= ruleSubstraction EOF
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
    // InternalAssembler.g:5337:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5343:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:5344:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:5344:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:5345:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
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
            // InternalAssembler.g:5353:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==57) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalAssembler.g:5354:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:5354:4: ()
            	    // InternalAssembler.g:5355:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5361:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:5362:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,57,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5368:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:5369:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:5369:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:5370:6: lv_right_3_0= ruleLeftShift
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
            	    break loop84;
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
    // InternalAssembler.g:5392:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:5392:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:5393:2: iv_ruleLeftShift= ruleLeftShift EOF
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
    // InternalAssembler.g:5399:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5405:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:5406:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:5406:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:5407:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
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
            // InternalAssembler.g:5415:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==83) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalAssembler.g:5416:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:5416:4: ()
            	    // InternalAssembler.g:5417:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,83,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5427:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:5428:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:5428:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:5429:6: lv_right_3_0= ruleRightShift
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
            	    break loop85;
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
    // InternalAssembler.g:5451:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:5451:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:5452:2: iv_ruleRightShift= ruleRightShift EOF
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
    // InternalAssembler.g:5458:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5464:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:5465:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:5465:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:5466:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
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
            // InternalAssembler.g:5474:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==84) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalAssembler.g:5475:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:5475:4: ()
            	    // InternalAssembler.g:5476:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,84,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5486:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:5487:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:5487:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:5488:6: lv_right_3_0= ruleAnd
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
            	    break loop86;
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
    // InternalAssembler.g:5510:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:5510:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:5511:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalAssembler.g:5517:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5523:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:5524:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:5524:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:5525:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
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
            // InternalAssembler.g:5533:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==85) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalAssembler.g:5534:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:5534:4: ()
            	    // InternalAssembler.g:5535:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,85,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5545:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:5546:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:5546:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:5547:6: lv_right_3_0= ruleOr
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
            	    break loop87;
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
    // InternalAssembler.g:5569:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:5569:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:5570:2: iv_ruleOr= ruleOr EOF
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
    // InternalAssembler.g:5576:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5582:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:5583:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:5583:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:5584:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
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
            // InternalAssembler.g:5592:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==86) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalAssembler.g:5593:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:5593:4: ()
            	    // InternalAssembler.g:5594:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,86,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5604:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:5605:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:5605:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:5606:6: lv_right_3_0= ruleXor
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
            	    break loop88;
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
    // InternalAssembler.g:5628:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:5628:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:5629:2: iv_ruleXor= ruleXor EOF
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
    // InternalAssembler.g:5635:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5641:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:5642:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:5642:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:5643:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
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
            // InternalAssembler.g:5651:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==87) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalAssembler.g:5652:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:5652:4: ()
            	    // InternalAssembler.g:5653:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,87,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5663:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:5664:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:5664:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:5665:6: lv_right_3_0= rulePrimary
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
            	    break loop89;
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
    // InternalAssembler.g:5687:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:5687:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:5688:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:5694:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
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
            // InternalAssembler.g:5700:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:5701:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:5701:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt90=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 57:
            case 59:
                {
                alt90=1;
                }
                break;
            case RULE_HEXA:
                {
                alt90=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt90=3;
                }
                break;
            case RULE_BINARY:
                {
                alt90=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt90=5;
                }
                break;
            case RULE_ID:
                {
                alt90=6;
                }
                break;
            case 88:
                {
                alt90=7;
                }
                break;
            case 89:
                {
                alt90=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalAssembler.g:5702:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:5702:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:5703:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:5703:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:5704:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:5722:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:5722:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:5723:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:5723:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:5724:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:5742:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:5742:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:5743:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:5743:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:5744:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:5762:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:5762:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:5763:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:5763:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:5764:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:5782:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:5782:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:5783:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:5783:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:5784:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:5802:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:5802:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:5803:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5803:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:5804:5: lv_value_5_0= ruleIdentifierValue
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
                    // InternalAssembler.g:5822:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:5822:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:5823:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:5823:4: ()
                    // InternalAssembler.g:5824:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,88,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:5834:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:5835:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:5835:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:5836:6: lv_value_8_0= rulePrimary
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
                    // InternalAssembler.g:5855:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:5855:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:5856:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,89,FOLLOW_12); if (state.failed) return current;
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
                    otherlv_11=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:5877:1: entryRuleNumericalValue returns [EObject current=null] : iv_ruleNumericalValue= ruleNumericalValue EOF ;
    public final EObject entryRuleNumericalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalValue = null;


        try {
            // InternalAssembler.g:5877:55: (iv_ruleNumericalValue= ruleNumericalValue EOF )
            // InternalAssembler.g:5878:2: iv_ruleNumericalValue= ruleNumericalValue EOF
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
    // InternalAssembler.g:5884:1: ruleNumericalValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) ;
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
            // InternalAssembler.g:5890:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:5891:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:5891:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            int alt91=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 57:
            case 59:
                {
                alt91=1;
                }
                break;
            case RULE_HEXA:
                {
                alt91=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt91=3;
                }
                break;
            case RULE_BINARY:
                {
                alt91=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt91=5;
                }
                break;
            case RULE_ID:
                {
                alt91=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // InternalAssembler.g:5892:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:5892:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:5893:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:5893:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:5894:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:5912:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:5912:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:5913:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:5913:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:5914:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:5932:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:5932:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:5933:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:5933:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:5934:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:5952:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:5952:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:5953:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:5953:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:5954:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:5972:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:5972:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:5973:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:5973:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:5974:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:5992:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:5992:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:5993:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5993:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:5994:5: lv_value_5_0= ruleIdentifierValue
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
    // InternalAssembler.g:6015:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:6015:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:6016:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
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
    // InternalAssembler.g:6022:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6028:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:6029:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:6029:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:6030:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:6030:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:6031:4: lv_value_0_0= RULE_ID
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
    // InternalAssembler.g:6050:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:6050:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:6051:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalAssembler.g:6057:1: ruleDecimalValue returns [EObject current=null] : ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_sign_0_1=null;
        Token lv_sign_0_2=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6063:2: ( ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:6064:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:6064:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:6065:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:6065:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==57||LA93_0==59) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalAssembler.g:6066:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    {
                    // InternalAssembler.g:6066:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    // InternalAssembler.g:6067:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    {
                    // InternalAssembler.g:6067:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==57) ) {
                        alt92=1;
                    }
                    else if ( (LA92_0==59) ) {
                        alt92=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 92, 0, input);

                        throw nvae;
                    }
                    switch (alt92) {
                        case 1 :
                            // InternalAssembler.g:6068:6: lv_sign_0_1= '-'
                            {
                            lv_sign_0_1=(Token)match(input,57,FOLLOW_39); if (state.failed) return current;
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
                            // InternalAssembler.g:6079:6: lv_sign_0_2= '+'
                            {
                            lv_sign_0_2=(Token)match(input,59,FOLLOW_39); if (state.failed) return current;
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

            // InternalAssembler.g:6092:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:6093:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:6093:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:6094:5: lv_value_1_0= RULE_INT
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
    // InternalAssembler.g:6114:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:6114:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:6115:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
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
    // InternalAssembler.g:6121:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6127:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:6128:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:6128:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:6129:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:6129:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:6130:4: lv_value_0_0= RULE_HEXA
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
    // InternalAssembler.g:6149:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:6149:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:6150:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:6156:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6162:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:6163:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:6163:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:6164:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:6164:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:6165:4: lv_value_0_0= RULE_OCTAL
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
    // InternalAssembler.g:6184:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:6184:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:6185:2: iv_ruleBinaryValue= ruleBinaryValue EOF
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
    // InternalAssembler.g:6191:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6197:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:6198:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:6198:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:6199:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:6199:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:6200:4: lv_value_0_0= RULE_BINARY
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
    // InternalAssembler.g:6219:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:6219:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:6220:2: iv_ruleCharacterValue= ruleCharacterValue EOF
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
    // InternalAssembler.g:6226:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6232:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:6233:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:6233:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:6234:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:6234:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:6235:4: lv_value_0_0= RULE_CHARACTER
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
    // InternalAssembler.g:6254:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:6254:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:6255:2: iv_ruleEndOfLine= ruleEndOfLine EOF
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
    // InternalAssembler.g:6261:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:6267:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:6268:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:6268:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_CR) ) {
                alt94=1;
            }
            else if ( (LA94_0==RULE_END_OF_FILE) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalAssembler.g:6269:3: this_CR_0= RULE_CR
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
                    // InternalAssembler.g:6277:3: this_END_OF_FILE_1= RULE_END_OF_FILE
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
    // InternalAssembler.g:6288:1: ruleAssemblyOption returns [Enumerator current=null] : ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) ;
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
            // InternalAssembler.g:6294:2: ( ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) )
            // InternalAssembler.g:6295:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            {
            // InternalAssembler.g:6295:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            int alt95=8;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt95=1;
                }
                break;
            case 91:
                {
                alt95=2;
                }
                break;
            case 92:
                {
                alt95=3;
                }
                break;
            case 93:
                {
                alt95=4;
                }
                break;
            case 94:
                {
                alt95=5;
                }
                break;
            case 95:
                {
                alt95=6;
                }
                break;
            case 96:
                {
                alt95=7;
                }
                break;
            case 97:
                {
                alt95=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // InternalAssembler.g:6296:3: (enumLiteral_0= 'PAG' )
                    {
                    // InternalAssembler.g:6296:3: (enumLiteral_0= 'PAG' )
                    // InternalAssembler.g:6297:4: enumLiteral_0= 'PAG'
                    {
                    enumLiteral_0=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:6304:3: (enumLiteral_1= 'NOP' )
                    {
                    // InternalAssembler.g:6304:3: (enumLiteral_1= 'NOP' )
                    // InternalAssembler.g:6305:4: enumLiteral_1= 'NOP'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:6312:3: (enumLiteral_2= 'CON' )
                    {
                    // InternalAssembler.g:6312:3: (enumLiteral_2= 'CON' )
                    // InternalAssembler.g:6313:4: enumLiteral_2= 'CON'
                    {
                    enumLiteral_2=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:6320:3: (enumLiteral_3= 'NOC' )
                    {
                    // InternalAssembler.g:6320:3: (enumLiteral_3= 'NOC' )
                    // InternalAssembler.g:6321:4: enumLiteral_3= 'NOC'
                    {
                    enumLiteral_3=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:6328:3: (enumLiteral_4= 'MAC' )
                    {
                    // InternalAssembler.g:6328:3: (enumLiteral_4= 'MAC' )
                    // InternalAssembler.g:6329:4: enumLiteral_4= 'MAC'
                    {
                    enumLiteral_4=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:6336:3: (enumLiteral_5= 'NOM' )
                    {
                    // InternalAssembler.g:6336:3: (enumLiteral_5= 'NOM' )
                    // InternalAssembler.g:6337:4: enumLiteral_5= 'NOM'
                    {
                    enumLiteral_5=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:6344:3: (enumLiteral_6= 'EXP' )
                    {
                    // InternalAssembler.g:6344:3: (enumLiteral_6= 'EXP' )
                    // InternalAssembler.g:6345:4: enumLiteral_6= 'EXP'
                    {
                    enumLiteral_6=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:6352:3: (enumLiteral_7= 'NOE' )
                    {
                    // InternalAssembler.g:6352:3: (enumLiteral_7= 'NOE' )
                    // InternalAssembler.g:6353:4: enumLiteral_7= 'NOE'
                    {
                    enumLiteral_7=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:6363:1: ruleRegister returns [Enumerator current=null] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) ;
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
            // InternalAssembler.g:6369:2: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) )
            // InternalAssembler.g:6370:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            {
            // InternalAssembler.g:6370:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            int alt96=10;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt96=1;
                }
                break;
            case 55:
                {
                alt96=2;
                }
                break;
            case 56:
                {
                alt96=3;
                }
                break;
            case 52:
                {
                alt96=4;
                }
                break;
            case 53:
                {
                alt96=5;
                }
                break;
            case 51:
                {
                alt96=6;
                }
                break;
            case 50:
                {
                alt96=7;
                }
                break;
            case 98:
                {
                alt96=8;
                }
                break;
            case 99:
                {
                alt96=9;
                }
                break;
            case 100:
                {
                alt96=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // InternalAssembler.g:6371:3: (enumLiteral_0= 'A' )
                    {
                    // InternalAssembler.g:6371:3: (enumLiteral_0= 'A' )
                    // InternalAssembler.g:6372:4: enumLiteral_0= 'A'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:6379:3: (enumLiteral_1= 'B' )
                    {
                    // InternalAssembler.g:6379:3: (enumLiteral_1= 'B' )
                    // InternalAssembler.g:6380:4: enumLiteral_1= 'B'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:6387:3: (enumLiteral_2= 'D' )
                    {
                    // InternalAssembler.g:6387:3: (enumLiteral_2= 'D' )
                    // InternalAssembler.g:6388:4: enumLiteral_2= 'D'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:6395:3: (enumLiteral_3= 'X' )
                    {
                    // InternalAssembler.g:6395:3: (enumLiteral_3= 'X' )
                    // InternalAssembler.g:6396:4: enumLiteral_3= 'X'
                    {
                    enumLiteral_3=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:6403:3: (enumLiteral_4= 'Y' )
                    {
                    // InternalAssembler.g:6403:3: (enumLiteral_4= 'Y' )
                    // InternalAssembler.g:6404:4: enumLiteral_4= 'Y'
                    {
                    enumLiteral_4=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:6411:3: (enumLiteral_5= 'U' )
                    {
                    // InternalAssembler.g:6411:3: (enumLiteral_5= 'U' )
                    // InternalAssembler.g:6412:4: enumLiteral_5= 'U'
                    {
                    enumLiteral_5=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:6419:3: (enumLiteral_6= 'S' )
                    {
                    // InternalAssembler.g:6419:3: (enumLiteral_6= 'S' )
                    // InternalAssembler.g:6420:4: enumLiteral_6= 'S'
                    {
                    enumLiteral_6=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:6427:3: (enumLiteral_7= 'DP' )
                    {
                    // InternalAssembler.g:6427:3: (enumLiteral_7= 'DP' )
                    // InternalAssembler.g:6428:4: enumLiteral_7= 'DP'
                    {
                    enumLiteral_7=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:6435:3: (enumLiteral_8= 'CC' )
                    {
                    // InternalAssembler.g:6435:3: (enumLiteral_8= 'CC' )
                    // InternalAssembler.g:6436:4: enumLiteral_8= 'CC'
                    {
                    enumLiteral_8=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAssembler.g:6443:3: (enumLiteral_9= 'PC' )
                    {
                    // InternalAssembler.g:6443:3: (enumLiteral_9= 'PC' )
                    // InternalAssembler.g:6444:4: enumLiteral_9= 'PC'
                    {
                    enumLiteral_9=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
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


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA29 dfa29 = new DFA29(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\4\uffff\6\14\14\uffff";
    static final String dfa_3s = "\1\7\1\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\55\1\uffff";
    static final String dfa_4s = "\1\131\1\uffff\2\10\6\127\1\uffff\1\131\1\uffff\2\10\6\127\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\10\uffff\1\2\1\uffff\1\3\10\uffff\1\4";
    static final String dfa_6s = "\26\uffff}>";
    static final String[] dfa_7s = {
            "\1\11\1\4\1\5\1\6\1\7\1\10\37\uffff\1\13\1\uffff\1\14\1\1\1\uffff\1\12\4\uffff\3\12\1\2\1\uffff\1\3\34\uffff\2\14",
            "",
            "\1\4",
            "\1\4",
            "\1\14\10\uffff\2\14\42\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\42\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\42\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\42\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\42\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\42\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "",
            "\1\24\1\17\1\20\1\21\1\22\1\23\44\uffff\1\12\4\uffff\3\12\1\15\1\uffff\1\16\34\uffff\2\25",
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

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1221:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1357:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_8s = "\27\uffff";
    static final String dfa_9s = "\5\uffff\6\15\14\uffff";
    static final String dfa_10s = "\1\7\2\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\55\1\uffff";
    static final String dfa_11s = "\1\131\2\uffff\2\10\6\127\1\uffff\1\131\1\uffff\2\10\6\127\1\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\10\uffff\1\3\1\uffff\1\4\10\uffff\1\5";
    static final String dfa_13s = "\27\uffff}>";
    static final String[] dfa_14s = {
            "\1\12\1\5\1\6\1\7\1\10\1\11\37\uffff\1\14\1\uffff\1\15\1\2\1\1\1\13\4\uffff\3\13\1\3\1\uffff\1\4\34\uffff\2\15",
            "",
            "",
            "\1\5",
            "\1\5",
            "\1\15\10\uffff\2\15\42\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\42\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\42\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\42\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\42\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\42\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "",
            "\1\25\1\20\1\21\1\22\1\23\1\24\44\uffff\1\13\4\uffff\3\13\1\16\1\uffff\1\17\34\uffff\2\26",
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

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1533:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1655:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1790:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1925:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_15s = "\44\uffff";
    static final String dfa_16s = "\16\uffff\4\34\22\uffff";
    static final String dfa_17s = "\1\7\2\10\6\61\1\62\1\uffff\1\7\2\uffff\4\4\1\uffff\2\10\6\61\1\62\1\uffff\4\55\3\uffff";
    static final String dfa_18s = "\1\73\2\10\6\61\1\75\1\uffff\1\73\2\uffff\4\74\1\uffff\2\10\6\61\1\75\1\uffff\4\74\3\uffff";
    static final String dfa_19s = "\12\uffff\1\3\1\uffff\1\4\1\1\4\uffff\1\7\11\uffff\1\2\4\uffff\1\6\1\10\1\5";
    static final String dfa_20s = "\44\uffff}>";
    static final String[] dfa_21s = {
            "\1\10\1\3\1\4\1\5\1\6\1\7\37\uffff\1\13\4\uffff\1\11\4\uffff\3\12\1\1\1\uffff\1\2",
            "\1\3",
            "\1\3",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\16\1\17\1\20\1\21\3\uffff\2\15\2\uffff\1\14",
            "",
            "\1\32\1\25\1\26\1\27\1\30\1\31\44\uffff\1\33\4\uffff\3\22\1\23\1\uffff\1\24",
            "",
            "",
            "\1\34\10\uffff\2\34\54\uffff\2\15",
            "\1\34\10\uffff\2\34\54\uffff\2\15",
            "\1\34\10\uffff\2\34\54\uffff\2\15",
            "\1\34\10\uffff\2\34\54\uffff\2\15",
            "",
            "\1\25",
            "\1\25",
            "\1\33",
            "\1\33",
            "\1\33",
            "\1\33",
            "\1\33",
            "\1\33",
            "\1\35\1\36\1\37\1\40\3\uffff\2\41\2\uffff\1\42",
            "",
            "\1\43\15\uffff\2\41",
            "\1\43\15\uffff\2\41",
            "\1\43\15\uffff\2\41",
            "\1\43\15\uffff\2\41",
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

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "2231:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000060B2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000FFFFFFF8000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0BC2D00000001F80L,0x0000000003000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0BC3D00000001F80L,0x0000000003000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0A00400000001F80L,0x0000000003000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x003C000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0A02000000001F80L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x01C0000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x063C000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x1800000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xC000000000000000L,0x000000000001FF7FL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x01FC000000000000L,0x0000001C00000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x00000003F8000008L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0A00400000001F80L,0x0000000003000080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000100L});

}
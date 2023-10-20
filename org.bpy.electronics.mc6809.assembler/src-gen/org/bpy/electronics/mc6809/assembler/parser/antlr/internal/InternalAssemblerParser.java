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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "'ADCA'", "'ADCB'", "'ABX'", "'['", "']'", "'>'", "'<'", "'#'", "','", "'S'", "'U'", "'X'", "'Y'", "'A'", "'B'", "'D'", "'-'", "'--'", "'+'", "'++'", "'PCR'", "'FCC'", "'REG'", "'SPC'", "'NAM'", "'TTL'", "'PAG'", "'OPT'", "'FAIL'", "'SET'", "'*'", "'FILL'", "'BSZ'", "'ZMB'", "'FDB'", "'FCB'", "'RMB'", "'END'", "'ORG'", "'EQU'", "'/'", "'%'", "'<<'", "'>>'", "'&&'", "'||'", "'^'", "'!'", "'('", "')'", "'NOP'", "'CON'", "'NOC'", "'MAC'", "'NOM'", "'EXP'", "'NOE'", "'DP'", "'CC'", "'PC'"
    };
    public static final int T__50=50;
    public static final int RULE_ANY_EXCEPT_COMMENT_END_OF_LINE=5;
    public static final int RULE_CHARACTER=12;
    public static final int RULE_CR=13;
    public static final int T__19=19;
    public static final int RULE_OCTAL=10;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
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
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int RULE_END_OF_FILE=14;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=4;
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
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                    {
                    alt2=3;
                    }
                    break;
                case 15:
                case 16:
                case 17:
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

                    if ( ((LA2_7>=36 && LA2_7<=44)||(LA2_7>=46 && LA2_7<=54)) ) {
                        alt2=3;
                    }
                    else if ( ((LA2_7>=15 && LA2_7<=17)) ) {
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
    // InternalAssembler.g:301:1: ruleInstructionLine returns [EObject current=null] : ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) ) ;
    public final EObject ruleInstructionLine() throws RecognitionException {
        EObject current = null;

        EObject lv_instruction_0_0 = null;

        EObject lv_instruction_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:307:2: ( ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) ) )
            // InternalAssembler.g:308:2: ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) )
            {
            // InternalAssembler.g:308:2: ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==RULE_WS) ) {
                    int LA4_2 = input.LA(3);

                    if ( ((LA4_2>=15 && LA4_2<=16)) ) {
                        alt4=2;
                    }
                    else if ( (LA4_2==17) ) {
                        alt4=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==RULE_WS) ) {
                int LA4_2 = input.LA(2);

                if ( ((LA4_2>=15 && LA4_2<=16)) ) {
                    alt4=2;
                }
                else if ( (LA4_2==17) ) {
                    alt4=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:309:3: ( (lv_instruction_0_0= ruleAbxInstruction ) )
                    {
                    // InternalAssembler.g:309:3: ( (lv_instruction_0_0= ruleAbxInstruction ) )
                    // InternalAssembler.g:310:4: (lv_instruction_0_0= ruleAbxInstruction )
                    {
                    // InternalAssembler.g:310:4: (lv_instruction_0_0= ruleAbxInstruction )
                    // InternalAssembler.g:311:5: lv_instruction_0_0= ruleAbxInstruction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAbxInstructionParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instruction_0_0=ruleAbxInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      					}
                      					set(
                      						current,
                      						"instruction",
                      						lv_instruction_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AbxInstruction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:329:3: ( (lv_instruction_1_0= ruleAdcInstruction ) )
                    {
                    // InternalAssembler.g:329:3: ( (lv_instruction_1_0= ruleAdcInstruction ) )
                    // InternalAssembler.g:330:4: (lv_instruction_1_0= ruleAdcInstruction )
                    {
                    // InternalAssembler.g:330:4: (lv_instruction_1_0= ruleAdcInstruction )
                    // InternalAssembler.g:331:5: lv_instruction_1_0= ruleAdcInstruction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAdcInstructionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instruction_1_0=ruleAdcInstruction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getInstructionLineRule());
                      					}
                      					set(
                      						current,
                      						"instruction",
                      						lv_instruction_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AdcInstruction");
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
    // $ANTLR end "ruleInstructionLine"


    // $ANTLR start "entryRuleAdcInstruction"
    // InternalAssembler.g:352:1: entryRuleAdcInstruction returns [EObject current=null] : iv_ruleAdcInstruction= ruleAdcInstruction EOF ;
    public final EObject entryRuleAdcInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdcInstruction = null;


        try {
            // InternalAssembler.g:352:55: (iv_ruleAdcInstruction= ruleAdcInstruction EOF )
            // InternalAssembler.g:353:2: iv_ruleAdcInstruction= ruleAdcInstruction EOF
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
    // InternalAssembler.g:359:1: ruleAdcInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleAdcInstruction() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_instruction_2_1=null;
        Token lv_instruction_2_2=null;
        Token this_WS_3=null;
        Token this_WS_5=null;
        Token lv_comment_6_0=null;
        Token this_WS_7=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_4_1 = null;

        EObject lv_operand_4_2 = null;

        EObject lv_operand_4_3 = null;

        EObject lv_operand_4_4 = null;

        EObject lv_operand_4_5 = null;



        	enterRule();

        try {
            // InternalAssembler.g:365:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:366:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:366:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:367:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:367:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:368:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:368:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:369:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAdcInstructionAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
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

              			newLeafNode(this_WS_1, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:390:3: ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) )
            // InternalAssembler.g:391:4: ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) )
            {
            // InternalAssembler.g:391:4: ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) )
            // InternalAssembler.g:392:5: (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' )
            {
            // InternalAssembler.g:392:5: (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==16) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:393:6: lv_instruction_2_1= 'ADCA'
                    {
                    lv_instruction_2_1=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_2_1, grammarAccess.getAdcInstructionAccess().getInstructionADCAKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAdcInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:404:6: lv_instruction_2_2= 'ADCB'
                    {
                    lv_instruction_2_2=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_2_2, grammarAccess.getAdcInstructionAccess().getInstructionADCBKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAdcInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_2_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:421:3: ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:422:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:422:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:423:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:423:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            int alt7=5;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:424:6: lv_operand_4_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandImmediatOperandParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_4_1,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:440:6: lv_operand_4_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandDirectOperandParserRuleCall_4_0_1());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_4_2,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:456:6: lv_operand_4_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandIndexedOperandParserRuleCall_4_0_2());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_4_3,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalAssembler.g:472:6: lv_operand_4_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandExtendedOperandParserRuleCall_4_0_3());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_4_4,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalAssembler.g:488:6: lv_operand_4_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdcInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_4_0_4());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdcInstructionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_4_5,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedIndirectOperand");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalAssembler.g:506:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_WS) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:507:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:511:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:512:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:512:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:513:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getAdcInstructionAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAdcInstructionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_6_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:530:3: (this_WS_7= RULE_WS )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_WS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:531:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_6());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdcInstructionAccess().getEndOfLineParserRuleCall_7());
              		
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
    // $ANTLR end "ruleAdcInstruction"


    // $ANTLR start "entryRuleAbxInstruction"
    // InternalAssembler.g:547:1: entryRuleAbxInstruction returns [EObject current=null] : iv_ruleAbxInstruction= ruleAbxInstruction EOF ;
    public final EObject entryRuleAbxInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbxInstruction = null;


        try {
            // InternalAssembler.g:547:55: (iv_ruleAbxInstruction= ruleAbxInstruction EOF )
            // InternalAssembler.g:548:2: iv_ruleAbxInstruction= ruleAbxInstruction EOF
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
    // InternalAssembler.g:554:1: ruleAbxInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleAbxInstruction() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_instruction_2_0=null;
        Token this_WS_3=null;
        Token lv_comment_4_0=null;
        Token this_WS_5=null;
        EObject lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:560:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:561:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:561:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:562:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:562:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:563:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:563:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:564:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAbxInstructionAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAbxInstructionRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAbxInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:585:3: ( (lv_instruction_2_0= 'ABX' ) )
            // InternalAssembler.g:586:4: (lv_instruction_2_0= 'ABX' )
            {
            // InternalAssembler.g:586:4: (lv_instruction_2_0= 'ABX' )
            // InternalAssembler.g:587:5: lv_instruction_2_0= 'ABX'
            {
            lv_instruction_2_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_instruction_2_0, grammarAccess.getAbxInstructionAccess().getInstructionABXKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAbxInstructionRule());
              					}
              					setWithLastConsumed(current, "instruction", lv_instruction_2_0, "ABX");
              				
            }

            }


            }

            // InternalAssembler.g:599:3: (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_WS) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // InternalAssembler.g:600:4: this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getAbxInstructionAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:604:4: ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:605:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:605:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:606:6: lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_4_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_4_0, grammarAccess.getAbxInstructionAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAbxInstructionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_4_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:623:3: (this_WS_5= RULE_WS )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_WS) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAssembler.g:624:4: this_WS_5= RULE_WS
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getAbxInstructionAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAbxInstructionAccess().getEndOfLineParserRuleCall_5());
              		
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
    // $ANTLR end "ruleAbxInstruction"


    // $ANTLR start "entryRuleExtendedIndirectOperand"
    // InternalAssembler.g:640:1: entryRuleExtendedIndirectOperand returns [EObject current=null] : iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF ;
    public final EObject entryRuleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedIndirectOperand = null;


        try {
            // InternalAssembler.g:640:64: (iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF )
            // InternalAssembler.g:641:2: iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF
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
    // InternalAssembler.g:647:1: ruleExtendedIndirectOperand returns [EObject current=null] : (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:653:2: ( (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalAssembler.g:654:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalAssembler.g:654:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalAssembler.g:655:3: otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtendedIndirectOperandAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:659:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:660:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:660:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:661:5: lv_operand_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtendedIndirectOperandAccess().getOperandExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_11);
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

            otherlv_2=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:686:1: entryRuleExtendedOperand returns [EObject current=null] : iv_ruleExtendedOperand= ruleExtendedOperand EOF ;
    public final EObject entryRuleExtendedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedOperand = null;


        try {
            // InternalAssembler.g:686:56: (iv_ruleExtendedOperand= ruleExtendedOperand EOF )
            // InternalAssembler.g:687:2: iv_ruleExtendedOperand= ruleExtendedOperand EOF
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
    // InternalAssembler.g:693:1: ruleExtendedOperand returns [EObject current=null] : ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExtendedOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:699:2: ( ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:700:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:700:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:701:3: (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) )
            {
            // InternalAssembler.g:701:3: (otherlv_0= '>' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAssembler.g:702:4: otherlv_0= '>'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getExtendedOperandAccess().getGreaterThanSignKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:707:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:708:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:708:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:709:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:730:1: entryRuleDirectOperand returns [EObject current=null] : iv_ruleDirectOperand= ruleDirectOperand EOF ;
    public final EObject entryRuleDirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectOperand = null;


        try {
            // InternalAssembler.g:730:54: (iv_ruleDirectOperand= ruleDirectOperand EOF )
            // InternalAssembler.g:731:2: iv_ruleDirectOperand= ruleDirectOperand EOF
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
    // InternalAssembler.g:737:1: ruleDirectOperand returns [EObject current=null] : (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleDirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:743:2: ( (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:744:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:744:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:745:3: otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectOperandAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalAssembler.g:749:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:750:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:750:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:751:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:772:1: entryRuleImmediatOperand returns [EObject current=null] : iv_ruleImmediatOperand= ruleImmediatOperand EOF ;
    public final EObject entryRuleImmediatOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImmediatOperand = null;


        try {
            // InternalAssembler.g:772:56: (iv_ruleImmediatOperand= ruleImmediatOperand EOF )
            // InternalAssembler.g:773:2: iv_ruleImmediatOperand= ruleImmediatOperand EOF
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
    // InternalAssembler.g:779:1: ruleImmediatOperand returns [EObject current=null] : (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleImmediatOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:785:2: ( (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:786:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:786:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:787:3: otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImmediatOperandAccess().getNumberSignKeyword_0());
              		
            }
            // InternalAssembler.g:791:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:792:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:792:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:793:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:814:1: entryRuleIndexedOperand returns [EObject current=null] : iv_ruleIndexedOperand= ruleIndexedOperand EOF ;
    public final EObject entryRuleIndexedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedOperand = null;


        try {
            // InternalAssembler.g:814:55: (iv_ruleIndexedOperand= ruleIndexedOperand EOF )
            // InternalAssembler.g:815:2: iv_ruleIndexedOperand= ruleIndexedOperand EOF
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
    // InternalAssembler.g:821:1: ruleIndexedOperand returns [EObject current=null] : ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) ;
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
            // InternalAssembler.g:827:2: ( ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) )
            // InternalAssembler.g:828:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            {
            // InternalAssembler.g:828:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            int alt14=8;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalAssembler.g:829:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    {
                    // InternalAssembler.g:829:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    // InternalAssembler.g:830:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    {
                    // InternalAssembler.g:830:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    // InternalAssembler.g:831:5: lv_mode_0_0= ruleAutoIncDecMode
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
                    // InternalAssembler.g:849:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    {
                    // InternalAssembler.g:849:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    // InternalAssembler.g:850:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    {
                    // InternalAssembler.g:850:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    // InternalAssembler.g:851:5: lv_mode_1_0= ruleConstantIndexedMode
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
                    // InternalAssembler.g:869:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    {
                    // InternalAssembler.g:869:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    // InternalAssembler.g:870:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    {
                    // InternalAssembler.g:870:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    // InternalAssembler.g:871:5: lv_mode_2_0= ruleAccumulatorMovingMode
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
                    // InternalAssembler.g:889:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    {
                    // InternalAssembler.g:889:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    // InternalAssembler.g:890:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    {
                    // InternalAssembler.g:890:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    // InternalAssembler.g:891:5: lv_mode_3_0= ruleRelatifToPCMode
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
                    // InternalAssembler.g:909:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:909:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    // InternalAssembler.g:910:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    {
                    // InternalAssembler.g:910:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    // InternalAssembler.g:911:5: lv_mode_4_0= ruleConstantIndexedMovingIndirectMode
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
                    // InternalAssembler.g:929:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    {
                    // InternalAssembler.g:929:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    // InternalAssembler.g:930:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    {
                    // InternalAssembler.g:930:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    // InternalAssembler.g:931:5: lv_mode_5_0= ruleAutoIncDecIndirectMode
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
                    // InternalAssembler.g:949:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:949:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    // InternalAssembler.g:950:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    {
                    // InternalAssembler.g:950:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    // InternalAssembler.g:951:5: lv_mode_6_0= ruleAccumulatorMovingIndirectMode
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
                    // InternalAssembler.g:969:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    {
                    // InternalAssembler.g:969:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    // InternalAssembler.g:970:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    {
                    // InternalAssembler.g:970:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    // InternalAssembler.g:971:5: lv_mode_7_0= ruleRelatifToPCIndirectMode
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
    // InternalAssembler.g:992:1: entryRuleConstantIndexedMode returns [EObject current=null] : iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF ;
    public final EObject entryRuleConstantIndexedMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMode = null;


        try {
            // InternalAssembler.g:992:60: (iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF )
            // InternalAssembler.g:993:2: iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF
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
    // InternalAssembler.g:999:1: ruleConstantIndexedMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:1005:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:1006:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:1006:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:1007:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:1007:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_CHARACTER)||LA15_0==31||LA15_0==33) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAssembler.g:1008:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:1008:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:1009:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_12);
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

            otherlv_1=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstantIndexedModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:1030:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:1031:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:1031:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:1032:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:1032:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt16=1;
                }
                break;
            case 25:
                {
                alt16=2;
                }
                break;
            case 26:
                {
                alt16=3;
                }
                break;
            case 27:
                {
                alt16=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalAssembler.g:1033:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1044:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1055:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1066:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1083:1: entryRuleConstantIndexedMovingIndirectMode returns [EObject current=null] : iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF ;
    public final EObject entryRuleConstantIndexedMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMovingIndirectMode = null;


        try {
            // InternalAssembler.g:1083:74: (iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF )
            // InternalAssembler.g:1084:2: iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF
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
    // InternalAssembler.g:1090:1: ruleConstantIndexedMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:1096:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:1097:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:1097:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:1098:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:1102:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_CHARACTER)||LA17_0==31||LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAssembler.g:1103:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:1103:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:1104:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedMovingIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_12);
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

            otherlv_2=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:1125:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:1126:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:1126:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:1127:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:1127:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt18=1;
                }
                break;
            case 25:
                {
                alt18=2;
                }
                break;
            case 26:
                {
                alt18=3;
                }
                break;
            case 27:
                {
                alt18=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalAssembler.g:1128:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,24,FOLLOW_11); if (state.failed) return current;
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
                    // InternalAssembler.g:1139:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,25,FOLLOW_11); if (state.failed) return current;
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
                    // InternalAssembler.g:1150:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,26,FOLLOW_11); if (state.failed) return current;
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
                    // InternalAssembler.g:1161:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,27,FOLLOW_11); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1182:1: entryRuleAccumulatorMovingMode returns [EObject current=null] : iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF ;
    public final EObject entryRuleAccumulatorMovingMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingMode = null;


        try {
            // InternalAssembler.g:1182:62: (iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF )
            // InternalAssembler.g:1183:2: iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF
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
    // InternalAssembler.g:1189:1: ruleAccumulatorMovingMode returns [EObject current=null] : ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:1195:2: ( ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:1196:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:1196:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:1197:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:1197:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) )
            // InternalAssembler.g:1198:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            {
            // InternalAssembler.g:1198:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            // InternalAssembler.g:1199:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            {
            // InternalAssembler.g:1199:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt19=1;
                }
                break;
            case 29:
                {
                alt19=2;
                }
                break;
            case 30:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalAssembler.g:1200:6: lv_deplacement_0_1= 'A'
                    {
                    lv_deplacement_0_1=(Token)match(input,28,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:1211:6: lv_deplacement_0_2= 'B'
                    {
                    lv_deplacement_0_2=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:1222:6: lv_deplacement_0_3= 'D'
                    {
                    lv_deplacement_0_3=(Token)match(input,30,FOLLOW_12); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAccumulatorMovingModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:1239:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:1240:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:1240:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:1241:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:1241:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt20=1;
                }
                break;
            case 25:
                {
                alt20=2;
                }
                break;
            case 26:
                {
                alt20=3;
                }
                break;
            case 27:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1242:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1253:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1264:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1275:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1292:1: entryRuleAccumulatorMovingIndirectMode returns [EObject current=null] : iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF ;
    public final EObject entryRuleAccumulatorMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingIndirectMode = null;


        try {
            // InternalAssembler.g:1292:70: (iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF )
            // InternalAssembler.g:1293:2: iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF
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
    // InternalAssembler.g:1299:1: ruleAccumulatorMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:1305:2: ( (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:1306:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:1306:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:1307:3: otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAccumulatorMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:1311:3: ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) )
            // InternalAssembler.g:1312:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            {
            // InternalAssembler.g:1312:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            // InternalAssembler.g:1313:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            {
            // InternalAssembler.g:1313:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt21=1;
                }
                break;
            case 29:
                {
                alt21=2;
                }
                break;
            case 30:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalAssembler.g:1314:6: lv_deplacement_1_1= 'A'
                    {
                    lv_deplacement_1_1=(Token)match(input,28,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:1325:6: lv_deplacement_1_2= 'B'
                    {
                    lv_deplacement_1_2=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:1336:6: lv_deplacement_1_3= 'D'
                    {
                    lv_deplacement_1_3=(Token)match(input,30,FOLLOW_12); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAccumulatorMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:1353:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:1354:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:1354:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:1355:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:1355:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt22=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt22=1;
                }
                break;
            case 25:
                {
                alt22=2;
                }
                break;
            case 26:
                {
                alt22=3;
                }
                break;
            case 27:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:1356:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,24,FOLLOW_11); if (state.failed) return current;
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
                    // InternalAssembler.g:1367:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,25,FOLLOW_11); if (state.failed) return current;
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
                    // InternalAssembler.g:1378:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,26,FOLLOW_11); if (state.failed) return current;
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
                    // InternalAssembler.g:1389:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,27,FOLLOW_11); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1410:1: entryRuleAutoIncDecMode returns [EObject current=null] : iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF ;
    public final EObject entryRuleAutoIncDecMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecMode = null;


        try {
            // InternalAssembler.g:1410:55: (iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF )
            // InternalAssembler.g:1411:2: iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF
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
    // InternalAssembler.g:1417:1: ruleAutoIncDecMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) ;
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
            // InternalAssembler.g:1423:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) )
            // InternalAssembler.g:1424:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            {
            // InternalAssembler.g:1424:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            // InternalAssembler.g:1425:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            {
            // InternalAssembler.g:1425:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_CHARACTER)||LA23_0==31||LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAssembler.g:1426:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:1426:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:1427:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_12);
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

            otherlv_1=(Token)match(input,23,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAutoIncDecModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:1448:3: ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=31 && LA28_0<=32)) ) {
                alt28=1;
            }
            else if ( ((LA28_0>=24 && LA28_0<=27)) ) {
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
                    // InternalAssembler.g:1449:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:1449:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    // InternalAssembler.g:1450:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:1450:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==31) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==32) ) {
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
                            // InternalAssembler.g:1451:6: ( (lv_decrement_2_0= '-' ) )
                            {
                            // InternalAssembler.g:1451:6: ( (lv_decrement_2_0= '-' ) )
                            // InternalAssembler.g:1452:7: (lv_decrement_2_0= '-' )
                            {
                            // InternalAssembler.g:1452:7: (lv_decrement_2_0= '-' )
                            // InternalAssembler.g:1453:8: lv_decrement_2_0= '-'
                            {
                            lv_decrement_2_0=(Token)match(input,31,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:1466:6: ( (lv_decrement_3_0= '--' ) )
                            {
                            // InternalAssembler.g:1466:6: ( (lv_decrement_3_0= '--' ) )
                            // InternalAssembler.g:1467:7: (lv_decrement_3_0= '--' )
                            {
                            // InternalAssembler.g:1467:7: (lv_decrement_3_0= '--' )
                            // InternalAssembler.g:1468:8: lv_decrement_3_0= '--'
                            {
                            lv_decrement_3_0=(Token)match(input,32,FOLLOW_13); if (state.failed) return current;
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

                    // InternalAssembler.g:1481:5: ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    // InternalAssembler.g:1482:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    {
                    // InternalAssembler.g:1482:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    // InternalAssembler.g:1483:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    {
                    // InternalAssembler.g:1483:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    int alt25=4;
                    switch ( input.LA(1) ) {
                    case 24:
                        {
                        alt25=1;
                        }
                        break;
                    case 25:
                        {
                        alt25=2;
                        }
                        break;
                    case 26:
                        {
                        alt25=3;
                        }
                        break;
                    case 27:
                        {
                        alt25=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }

                    switch (alt25) {
                        case 1 :
                            // InternalAssembler.g:1484:8: lv_register_4_1= 'S'
                            {
                            lv_register_4_1=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:1495:8: lv_register_4_2= 'U'
                            {
                            lv_register_4_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:1506:8: lv_register_4_3= 'X'
                            {
                            lv_register_4_3=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:1517:8: lv_register_4_4= 'Y'
                            {
                            lv_register_4_4=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:1532:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:1532:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    // InternalAssembler.g:1533:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    {
                    // InternalAssembler.g:1533:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:1534:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:1534:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:1535:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:1535:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt26=4;
                    switch ( input.LA(1) ) {
                    case 24:
                        {
                        alt26=1;
                        }
                        break;
                    case 25:
                        {
                        alt26=2;
                        }
                        break;
                    case 26:
                        {
                        alt26=3;
                        }
                        break;
                    case 27:
                        {
                        alt26=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }

                    switch (alt26) {
                        case 1 :
                            // InternalAssembler.g:1536:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,24,FOLLOW_17); if (state.failed) return current;
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
                            // InternalAssembler.g:1547:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,25,FOLLOW_17); if (state.failed) return current;
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
                            // InternalAssembler.g:1558:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
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
                            // InternalAssembler.g:1569:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,27,FOLLOW_17); if (state.failed) return current;
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

                    // InternalAssembler.g:1582:5: ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==33) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==34) ) {
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
                            // InternalAssembler.g:1583:6: ( (lv_increment_6_0= '+' ) )
                            {
                            // InternalAssembler.g:1583:6: ( (lv_increment_6_0= '+' ) )
                            // InternalAssembler.g:1584:7: (lv_increment_6_0= '+' )
                            {
                            // InternalAssembler.g:1584:7: (lv_increment_6_0= '+' )
                            // InternalAssembler.g:1585:8: lv_increment_6_0= '+'
                            {
                            lv_increment_6_0=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:1598:6: ( (lv_increment_7_0= '++' ) )
                            {
                            // InternalAssembler.g:1598:6: ( (lv_increment_7_0= '++' ) )
                            // InternalAssembler.g:1599:7: (lv_increment_7_0= '++' )
                            {
                            // InternalAssembler.g:1599:7: (lv_increment_7_0= '++' )
                            // InternalAssembler.g:1600:8: lv_increment_7_0= '++'
                            {
                            lv_increment_7_0=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1619:1: entryRuleAutoIncDecIndirectMode returns [EObject current=null] : iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF ;
    public final EObject entryRuleAutoIncDecIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecIndirectMode = null;


        try {
            // InternalAssembler.g:1619:63: (iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF )
            // InternalAssembler.g:1620:2: iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF
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
    // InternalAssembler.g:1626:1: ruleAutoIncDecIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) ;
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
            // InternalAssembler.g:1632:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) )
            // InternalAssembler.g:1633:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            {
            // InternalAssembler.g:1633:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            // InternalAssembler.g:1634:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAutoIncDecIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:1638:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_CHARACTER)||LA29_0==31||LA29_0==33) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAssembler.g:1639:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:1639:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:1640:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_12);
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

            otherlv_2=(Token)match(input,23,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAutoIncDecIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:1661:3: ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=31 && LA34_0<=32)) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=24 && LA34_0<=27)) ) {
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
                    // InternalAssembler.g:1662:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:1662:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    // InternalAssembler.g:1663:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:1663:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==31) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==32) ) {
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
                            // InternalAssembler.g:1664:6: ( (lv_decrement_3_0= '-' ) )
                            {
                            // InternalAssembler.g:1664:6: ( (lv_decrement_3_0= '-' ) )
                            // InternalAssembler.g:1665:7: (lv_decrement_3_0= '-' )
                            {
                            // InternalAssembler.g:1665:7: (lv_decrement_3_0= '-' )
                            // InternalAssembler.g:1666:8: lv_decrement_3_0= '-'
                            {
                            lv_decrement_3_0=(Token)match(input,31,FOLLOW_13); if (state.failed) return current;
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
                            // InternalAssembler.g:1679:6: ( (lv_decrement_4_0= '--' ) )
                            {
                            // InternalAssembler.g:1679:6: ( (lv_decrement_4_0= '--' ) )
                            // InternalAssembler.g:1680:7: (lv_decrement_4_0= '--' )
                            {
                            // InternalAssembler.g:1680:7: (lv_decrement_4_0= '--' )
                            // InternalAssembler.g:1681:8: lv_decrement_4_0= '--'
                            {
                            lv_decrement_4_0=(Token)match(input,32,FOLLOW_13); if (state.failed) return current;
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

                    // InternalAssembler.g:1694:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:1695:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:1695:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:1696:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:1696:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt31=4;
                    switch ( input.LA(1) ) {
                    case 24:
                        {
                        alt31=1;
                        }
                        break;
                    case 25:
                        {
                        alt31=2;
                        }
                        break;
                    case 26:
                        {
                        alt31=3;
                        }
                        break;
                    case 27:
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
                            // InternalAssembler.g:1697:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,24,FOLLOW_11); if (state.failed) return current;
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
                            // InternalAssembler.g:1708:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,25,FOLLOW_11); if (state.failed) return current;
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
                            // InternalAssembler.g:1719:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,26,FOLLOW_11); if (state.failed) return current;
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
                            // InternalAssembler.g:1730:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,27,FOLLOW_11); if (state.failed) return current;
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
                    // InternalAssembler.g:1745:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:1745:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    // InternalAssembler.g:1746:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    {
                    // InternalAssembler.g:1746:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) )
                    // InternalAssembler.g:1747:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    {
                    // InternalAssembler.g:1747:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    // InternalAssembler.g:1748:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    {
                    // InternalAssembler.g:1748:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    int alt32=4;
                    switch ( input.LA(1) ) {
                    case 24:
                        {
                        alt32=1;
                        }
                        break;
                    case 25:
                        {
                        alt32=2;
                        }
                        break;
                    case 26:
                        {
                        alt32=3;
                        }
                        break;
                    case 27:
                        {
                        alt32=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }

                    switch (alt32) {
                        case 1 :
                            // InternalAssembler.g:1749:8: lv_register_6_1= 'S'
                            {
                            lv_register_6_1=(Token)match(input,24,FOLLOW_17); if (state.failed) return current;
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
                            // InternalAssembler.g:1760:8: lv_register_6_2= 'U'
                            {
                            lv_register_6_2=(Token)match(input,25,FOLLOW_17); if (state.failed) return current;
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
                            // InternalAssembler.g:1771:8: lv_register_6_3= 'X'
                            {
                            lv_register_6_3=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
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
                            // InternalAssembler.g:1782:8: lv_register_6_4= 'Y'
                            {
                            lv_register_6_4=(Token)match(input,27,FOLLOW_17); if (state.failed) return current;
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

                    // InternalAssembler.g:1795:5: ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==33) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==34) ) {
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
                            // InternalAssembler.g:1796:6: ( (lv_increment_7_0= '+' ) )
                            {
                            // InternalAssembler.g:1796:6: ( (lv_increment_7_0= '+' ) )
                            // InternalAssembler.g:1797:7: (lv_increment_7_0= '+' )
                            {
                            // InternalAssembler.g:1797:7: (lv_increment_7_0= '+' )
                            // InternalAssembler.g:1798:8: lv_increment_7_0= '+'
                            {
                            lv_increment_7_0=(Token)match(input,33,FOLLOW_11); if (state.failed) return current;
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
                            // InternalAssembler.g:1811:6: ( (lv_increment_8_0= '++' ) )
                            {
                            // InternalAssembler.g:1811:6: ( (lv_increment_8_0= '++' ) )
                            // InternalAssembler.g:1812:7: (lv_increment_8_0= '++' )
                            {
                            // InternalAssembler.g:1812:7: (lv_increment_8_0= '++' )
                            // InternalAssembler.g:1813:8: lv_increment_8_0= '++'
                            {
                            lv_increment_8_0=(Token)match(input,34,FOLLOW_11); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1836:1: entryRuleRelatifToPCMode returns [EObject current=null] : iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF ;
    public final EObject entryRuleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCMode = null;


        try {
            // InternalAssembler.g:1836:56: (iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF )
            // InternalAssembler.g:1837:2: iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF
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
    // InternalAssembler.g:1843:1: ruleRelatifToPCMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) ;
    public final EObject ruleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_register_2_0=null;
        EObject lv_deplacement_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1849:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) )
            // InternalAssembler.g:1850:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            {
            // InternalAssembler.g:1850:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            // InternalAssembler.g:1851:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) )
            {
            // InternalAssembler.g:1851:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_CHARACTER)||LA35_0==31||LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAssembler.g:1852:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:1852:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:1853:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_12);
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

            otherlv_1=(Token)match(input,23,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelatifToPCModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:1874:3: ( (lv_register_2_0= 'PCR' ) )
            // InternalAssembler.g:1875:4: (lv_register_2_0= 'PCR' )
            {
            // InternalAssembler.g:1875:4: (lv_register_2_0= 'PCR' )
            // InternalAssembler.g:1876:5: lv_register_2_0= 'PCR'
            {
            lv_register_2_0=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1892:1: entryRuleRelatifToPCIndirectMode returns [EObject current=null] : iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF ;
    public final EObject entryRuleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCIndirectMode = null;


        try {
            // InternalAssembler.g:1892:64: (iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF )
            // InternalAssembler.g:1893:2: iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF
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
    // InternalAssembler.g:1899:1: ruleRelatifToPCIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) ;
    public final EObject ruleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_register_3_0=null;
        Token otherlv_4=null;
        EObject lv_deplacement_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1905:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:1906:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:1906:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            // InternalAssembler.g:1907:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRelatifToPCIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:1911:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_ID && LA36_0<=RULE_CHARACTER)||LA36_0==31||LA36_0==33) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAssembler.g:1912:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:1912:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:1913:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_12);
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

            otherlv_2=(Token)match(input,23,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRelatifToPCIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:1934:3: ( (lv_register_3_0= 'PCR' ) )
            // InternalAssembler.g:1935:4: (lv_register_3_0= 'PCR' )
            {
            // InternalAssembler.g:1935:4: (lv_register_3_0= 'PCR' )
            // InternalAssembler.g:1936:5: lv_register_3_0= 'PCR'
            {
            lv_register_3_0=(Token)match(input,35,FOLLOW_11); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDirectiveLine"
    // InternalAssembler.g:1956:1: entryRuleDirectiveLine returns [EObject current=null] : iv_ruleDirectiveLine= ruleDirectiveLine EOF ;
    public final EObject entryRuleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectiveLine = null;


        try {
            // InternalAssembler.g:1956:54: (iv_ruleDirectiveLine= ruleDirectiveLine EOF )
            // InternalAssembler.g:1957:2: iv_ruleDirectiveLine= ruleDirectiveLine EOF
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
    // InternalAssembler.g:1963:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) ) ;
    public final EObject ruleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject lv_directive_0_0 = null;

        EObject lv_directive_1_0 = null;

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



        	enterRule();

        try {
            // InternalAssembler.g:1969:2: ( ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) ) )
            // InternalAssembler.g:1970:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) )
            {
            // InternalAssembler.g:1970:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) )
            int alt37=16;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // InternalAssembler.g:1971:3: ( (lv_directive_0_0= ruleEquDirective ) )
                    {
                    // InternalAssembler.g:1971:3: ( (lv_directive_0_0= ruleEquDirective ) )
                    // InternalAssembler.g:1972:4: (lv_directive_0_0= ruleEquDirective )
                    {
                    // InternalAssembler.g:1972:4: (lv_directive_0_0= ruleEquDirective )
                    // InternalAssembler.g:1973:5: lv_directive_0_0= ruleEquDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveEquDirectiveParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_0_0=ruleEquDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      					}
                      					set(
                      						current,
                      						"directive",
                      						lv_directive_0_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.EquDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1991:3: ( (lv_directive_1_0= ruleOrgDirective ) )
                    {
                    // InternalAssembler.g:1991:3: ( (lv_directive_1_0= ruleOrgDirective ) )
                    // InternalAssembler.g:1992:4: (lv_directive_1_0= ruleOrgDirective )
                    {
                    // InternalAssembler.g:1992:4: (lv_directive_1_0= ruleOrgDirective )
                    // InternalAssembler.g:1993:5: lv_directive_1_0= ruleOrgDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveOrgDirectiveParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_1_0=ruleOrgDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDirectiveLineRule());
                      					}
                      					set(
                      						current,
                      						"directive",
                      						lv_directive_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.OrgDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:2011:3: ( (lv_directive_2_0= ruleBszDirective ) )
                    {
                    // InternalAssembler.g:2011:3: ( (lv_directive_2_0= ruleBszDirective ) )
                    // InternalAssembler.g:2012:4: (lv_directive_2_0= ruleBszDirective )
                    {
                    // InternalAssembler.g:2012:4: (lv_directive_2_0= ruleBszDirective )
                    // InternalAssembler.g:2013:5: lv_directive_2_0= ruleBszDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveBszDirectiveParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_2_0=ruleBszDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.BszDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:2031:3: ( (lv_directive_3_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:2031:3: ( (lv_directive_3_0= ruleEndDirective ) )
                    // InternalAssembler.g:2032:4: (lv_directive_3_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:2032:4: (lv_directive_3_0= ruleEndDirective )
                    // InternalAssembler.g:2033:5: lv_directive_3_0= ruleEndDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveEndDirectiveParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_3_0=ruleEndDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.EndDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:2051:3: ( (lv_directive_4_0= ruleFailDirective ) )
                    {
                    // InternalAssembler.g:2051:3: ( (lv_directive_4_0= ruleFailDirective ) )
                    // InternalAssembler.g:2052:4: (lv_directive_4_0= ruleFailDirective )
                    {
                    // InternalAssembler.g:2052:4: (lv_directive_4_0= ruleFailDirective )
                    // InternalAssembler.g:2053:5: lv_directive_4_0= ruleFailDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFailDirectiveParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_4_0=ruleFailDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FailDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:2071:3: ( (lv_directive_5_0= ruleFillDirective ) )
                    {
                    // InternalAssembler.g:2071:3: ( (lv_directive_5_0= ruleFillDirective ) )
                    // InternalAssembler.g:2072:4: (lv_directive_5_0= ruleFillDirective )
                    {
                    // InternalAssembler.g:2072:4: (lv_directive_5_0= ruleFillDirective )
                    // InternalAssembler.g:2073:5: lv_directive_5_0= ruleFillDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFillDirectiveParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_5_0=ruleFillDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FillDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:2091:3: ( (lv_directive_6_0= ruleOptDirective ) )
                    {
                    // InternalAssembler.g:2091:3: ( (lv_directive_6_0= ruleOptDirective ) )
                    // InternalAssembler.g:2092:4: (lv_directive_6_0= ruleOptDirective )
                    {
                    // InternalAssembler.g:2092:4: (lv_directive_6_0= ruleOptDirective )
                    // InternalAssembler.g:2093:5: lv_directive_6_0= ruleOptDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveOptDirectiveParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_6_0=ruleOptDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.OptDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:2111:3: ( (lv_directive_7_0= rulePagDirective ) )
                    {
                    // InternalAssembler.g:2111:3: ( (lv_directive_7_0= rulePagDirective ) )
                    // InternalAssembler.g:2112:4: (lv_directive_7_0= rulePagDirective )
                    {
                    // InternalAssembler.g:2112:4: (lv_directive_7_0= rulePagDirective )
                    // InternalAssembler.g:2113:5: lv_directive_7_0= rulePagDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectivePagDirectiveParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_7_0=rulePagDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.PagDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:2131:3: ( (lv_directive_8_0= ruleNamDirective ) )
                    {
                    // InternalAssembler.g:2131:3: ( (lv_directive_8_0= ruleNamDirective ) )
                    // InternalAssembler.g:2132:4: (lv_directive_8_0= ruleNamDirective )
                    {
                    // InternalAssembler.g:2132:4: (lv_directive_8_0= ruleNamDirective )
                    // InternalAssembler.g:2133:5: lv_directive_8_0= ruleNamDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveNamDirectiveParserRuleCall_8_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_8_0=ruleNamDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.NamDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalAssembler.g:2151:3: ( (lv_directive_9_0= ruleSetDirective ) )
                    {
                    // InternalAssembler.g:2151:3: ( (lv_directive_9_0= ruleSetDirective ) )
                    // InternalAssembler.g:2152:4: (lv_directive_9_0= ruleSetDirective )
                    {
                    // InternalAssembler.g:2152:4: (lv_directive_9_0= ruleSetDirective )
                    // InternalAssembler.g:2153:5: lv_directive_9_0= ruleSetDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveSetDirectiveParserRuleCall_9_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_9_0=ruleSetDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.SetDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalAssembler.g:2171:3: ( (lv_directive_10_0= ruleSpcDirective ) )
                    {
                    // InternalAssembler.g:2171:3: ( (lv_directive_10_0= ruleSpcDirective ) )
                    // InternalAssembler.g:2172:4: (lv_directive_10_0= ruleSpcDirective )
                    {
                    // InternalAssembler.g:2172:4: (lv_directive_10_0= ruleSpcDirective )
                    // InternalAssembler.g:2173:5: lv_directive_10_0= ruleSpcDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveSpcDirectiveParserRuleCall_10_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_10_0=ruleSpcDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.SpcDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalAssembler.g:2191:3: ( (lv_directive_11_0= ruleRegDirective ) )
                    {
                    // InternalAssembler.g:2191:3: ( (lv_directive_11_0= ruleRegDirective ) )
                    // InternalAssembler.g:2192:4: (lv_directive_11_0= ruleRegDirective )
                    {
                    // InternalAssembler.g:2192:4: (lv_directive_11_0= ruleRegDirective )
                    // InternalAssembler.g:2193:5: lv_directive_11_0= ruleRegDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveRegDirectiveParserRuleCall_11_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_11_0=ruleRegDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.RegDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalAssembler.g:2211:3: ( (lv_directive_12_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:2211:3: ( (lv_directive_12_0= ruleFcbDirective ) )
                    // InternalAssembler.g:2212:4: (lv_directive_12_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:2212:4: (lv_directive_12_0= ruleFcbDirective )
                    // InternalAssembler.g:2213:5: lv_directive_12_0= ruleFcbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFcbDirectiveParserRuleCall_12_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_12_0=ruleFcbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FcbDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalAssembler.g:2231:3: ( (lv_directive_13_0= ruleFdbDirective ) )
                    {
                    // InternalAssembler.g:2231:3: ( (lv_directive_13_0= ruleFdbDirective ) )
                    // InternalAssembler.g:2232:4: (lv_directive_13_0= ruleFdbDirective )
                    {
                    // InternalAssembler.g:2232:4: (lv_directive_13_0= ruleFdbDirective )
                    // InternalAssembler.g:2233:5: lv_directive_13_0= ruleFdbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFdbDirectiveParserRuleCall_13_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_13_0=ruleFdbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FdbDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalAssembler.g:2251:3: ( (lv_directive_14_0= ruleFccDirective ) )
                    {
                    // InternalAssembler.g:2251:3: ( (lv_directive_14_0= ruleFccDirective ) )
                    // InternalAssembler.g:2252:4: (lv_directive_14_0= ruleFccDirective )
                    {
                    // InternalAssembler.g:2252:4: (lv_directive_14_0= ruleFccDirective )
                    // InternalAssembler.g:2253:5: lv_directive_14_0= ruleFccDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFccDirectiveParserRuleCall_14_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_14_0=ruleFccDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FccDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 16 :
                    // InternalAssembler.g:2271:3: ( (lv_directive_15_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:2271:3: ( (lv_directive_15_0= ruleRmbDirective ) )
                    // InternalAssembler.g:2272:4: (lv_directive_15_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:2272:4: (lv_directive_15_0= ruleRmbDirective )
                    // InternalAssembler.g:2273:5: lv_directive_15_0= ruleRmbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveRmbDirectiveParserRuleCall_15_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_15_0=ruleRmbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.RmbDirective");
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
    // $ANTLR end "ruleDirectiveLine"


    // $ANTLR start "entryRuleFccDirective"
    // InternalAssembler.g:2294:1: entryRuleFccDirective returns [EObject current=null] : iv_ruleFccDirective= ruleFccDirective EOF ;
    public final EObject entryRuleFccDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFccDirective = null;


        try {
            // InternalAssembler.g:2294:53: (iv_ruleFccDirective= ruleFccDirective EOF )
            // InternalAssembler.g:2295:2: iv_ruleFccDirective= ruleFccDirective EOF
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
    // InternalAssembler.g:2301:1: ruleFccDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleFccDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_string_4_0=null;
        Token this_WS_5=null;
        Token lv_comment_6_0=null;
        Token this_WS_7=null;
        EObject lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2307:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:2308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:2308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:2309:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:2309:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAssembler.g:2310:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2310:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:2311:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFccDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFccDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2332:3: ( (lv_directive_2_0= 'FCC' ) )
            // InternalAssembler.g:2333:4: (lv_directive_2_0= 'FCC' )
            {
            // InternalAssembler.g:2333:4: (lv_directive_2_0= 'FCC' )
            // InternalAssembler.g:2334:5: lv_directive_2_0= 'FCC'
            {
            lv_directive_2_0=(Token)match(input,36,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getFccDirectiveAccess().getDirectiveFCCKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFccDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "FCC");
              				
            }

            }


            }

            // InternalAssembler.g:2346:3: (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) )
            // InternalAssembler.g:2347:4: this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_3_0());
              			
            }
            // InternalAssembler.g:2351:4: ( (lv_string_4_0= RULE_STRING ) )
            // InternalAssembler.g:2352:5: (lv_string_4_0= RULE_STRING )
            {
            // InternalAssembler.g:2352:5: (lv_string_4_0= RULE_STRING )
            // InternalAssembler.g:2353:6: lv_string_4_0= RULE_STRING
            {
            lv_string_4_0=(Token)match(input,RULE_STRING,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(lv_string_4_0, grammarAccess.getFccDirectiveAccess().getStringSTRINGTerminalRuleCall_3_1_0());
              					
            }
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getFccDirectiveRule());
              						}
              						setWithLastConsumed(
              							current,
              							"string",
              							lv_string_4_0,
              							"org.bpy.electronics.mc6809.assembler.Assembler.STRING");
              					
            }

            }


            }


            }

            // InternalAssembler.g:2370:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_WS) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalAssembler.g:2371:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:2375:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:2376:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:2376:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:2377:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getFccDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFccDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_6_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:2394:3: (this_WS_7= RULE_WS )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_WS) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalAssembler.g:2395:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getFccDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleFccDirective"


    // $ANTLR start "entryRuleRegDirective"
    // InternalAssembler.g:2411:1: entryRuleRegDirective returns [EObject current=null] : iv_ruleRegDirective= ruleRegDirective EOF ;
    public final EObject entryRuleRegDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegDirective = null;


        try {
            // InternalAssembler.g:2411:53: (iv_ruleRegDirective= ruleRegDirective EOF )
            // InternalAssembler.g:2412:2: iv_ruleRegDirective= ruleRegDirective EOF
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
    // InternalAssembler.g:2418:1: ruleRegDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) ;
    public final EObject ruleRegDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token otherlv_5=null;
        Token this_WS_7=null;
        Token lv_comment_8_0=null;
        EObject lv_name_0_0 = null;

        Enumerator lv_options_4_0 = null;

        Enumerator lv_options_6_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2424:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) )
            // InternalAssembler.g:2425:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            {
            // InternalAssembler.g:2425:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            // InternalAssembler.g:2426:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine
            {
            // InternalAssembler.g:2426:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAssembler.g:2427:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2427:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:2428:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRegDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRegDirectiveRule());
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

              			newLeafNode(this_WS_1, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2449:3: ( (lv_directive_2_0= 'REG' ) )
            // InternalAssembler.g:2450:4: (lv_directive_2_0= 'REG' )
            {
            // InternalAssembler.g:2450:4: (lv_directive_2_0= 'REG' )
            // InternalAssembler.g:2451:5: lv_directive_2_0= 'REG'
            {
            lv_directive_2_0=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getRegDirectiveAccess().getDirectiveREGKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "REG");
              				
            }

            }


            }

            // InternalAssembler.g:2463:3: (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_WS) ) {
                int LA43_1 = input.LA(2);

                if ( ((LA43_1>=24 && LA43_1<=30)||(LA43_1>=72 && LA43_1<=74)) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalAssembler.g:2464:4: this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )*
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:2468:4: ( (lv_options_4_0= ruleRegister ) )
                    // InternalAssembler.g:2469:5: (lv_options_4_0= ruleRegister )
                    {
                    // InternalAssembler.g:2469:5: (lv_options_4_0= ruleRegister )
                    // InternalAssembler.g:2470:6: lv_options_4_0= ruleRegister
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRegDirectiveAccess().getOptionsRegisterEnumRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_23);
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

                    // InternalAssembler.g:2487:4: (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==23) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalAssembler.g:2488:5: otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getRegDirectiveAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:2492:5: ( (lv_options_6_0= ruleRegister ) )
                    	    // InternalAssembler.g:2493:6: (lv_options_6_0= ruleRegister )
                    	    {
                    	    // InternalAssembler.g:2493:6: (lv_options_6_0= ruleRegister )
                    	    // InternalAssembler.g:2494:7: lv_options_6_0= ruleRegister
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRegDirectiveAccess().getOptionsRegisterEnumRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_23);
                    	    lv_options_6_0=ruleRegister();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRegDirectiveRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"options",
                    	      								lv_options_6_0,
                    	      								"org.bpy.electronics.mc6809.assembler.Assembler.Register");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAssembler.g:2513:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_WS) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAssembler.g:2514:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:2518:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalAssembler.g:2519:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            {
                            // InternalAssembler.g:2519:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            // InternalAssembler.g:2520:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                            {
                            lv_comment_8_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_comment_8_0, grammarAccess.getRegDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getRegDirectiveRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"comment",
                              							lv_comment_8_0,
                              							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                              					
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRegDirectiveAccess().getEndOfLineParserRuleCall_5());
              		
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
    // $ANTLR end "ruleRegDirective"


    // $ANTLR start "entryRuleSpcDirective"
    // InternalAssembler.g:2548:1: entryRuleSpcDirective returns [EObject current=null] : iv_ruleSpcDirective= ruleSpcDirective EOF ;
    public final EObject entryRuleSpcDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpcDirective = null;


        try {
            // InternalAssembler.g:2548:53: (iv_ruleSpcDirective= ruleSpcDirective EOF )
            // InternalAssembler.g:2549:2: iv_ruleSpcDirective= ruleSpcDirective EOF
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
    // InternalAssembler.g:2555:1: ruleSpcDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleSpcDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token otherlv_5=null;
        Token this_WS_7=null;
        Token lv_comment_8_0=null;
        Token this_WS_9=null;
        EObject lv_name_0_0 = null;

        EObject lv_spaceCount_4_0 = null;

        EObject lv_keepCount_6_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2561:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:2562:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:2562:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:2563:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:2563:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalAssembler.g:2564:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2564:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:2565:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSpcDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSpcDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2586:3: ( (lv_directive_2_0= 'SPC' ) )
            // InternalAssembler.g:2587:4: (lv_directive_2_0= 'SPC' )
            {
            // InternalAssembler.g:2587:4: (lv_directive_2_0= 'SPC' )
            // InternalAssembler.g:2588:5: lv_directive_2_0= 'SPC'
            {
            lv_directive_2_0=(Token)match(input,38,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getSpcDirectiveAccess().getDirectiveSPCKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSpcDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "SPC");
              				
            }

            }


            }

            // InternalAssembler.g:2600:3: (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_WS) ) {
                int LA48_1 = input.LA(2);

                if ( ((LA48_1>=RULE_ID && LA48_1<=RULE_CHARACTER)||LA48_1==31||LA48_1==33||(LA48_1>=62 && LA48_1<=63)) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // InternalAssembler.g:2601:4: this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )?
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:2605:4: ( (lv_spaceCount_4_0= ruleExpression ) )
                    // InternalAssembler.g:2606:5: (lv_spaceCount_4_0= ruleExpression )
                    {
                    // InternalAssembler.g:2606:5: (lv_spaceCount_4_0= ruleExpression )
                    // InternalAssembler.g:2607:6: lv_spaceCount_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSpcDirectiveAccess().getSpaceCountExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_23);
                    lv_spaceCount_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSpcDirectiveRule());
                      						}
                      						set(
                      							current,
                      							"spaceCount",
                      							lv_spaceCount_4_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalAssembler.g:2624:4: (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==23) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalAssembler.g:2625:5: otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) )
                            {
                            otherlv_5=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getSpcDirectiveAccess().getCommaKeyword_3_2_0());
                              				
                            }
                            // InternalAssembler.g:2629:5: ( (lv_keepCount_6_0= ruleExpression ) )
                            // InternalAssembler.g:2630:6: (lv_keepCount_6_0= ruleExpression )
                            {
                            // InternalAssembler.g:2630:6: (lv_keepCount_6_0= ruleExpression )
                            // InternalAssembler.g:2631:7: lv_keepCount_6_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getSpcDirectiveAccess().getKeepCountExpressionParserRuleCall_3_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_4);
                            lv_keepCount_6_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getSpcDirectiveRule());
                              							}
                              							set(
                              								current,
                              								"keepCount",
                              								lv_keepCount_6_0,
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

            // InternalAssembler.g:2650:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_WS) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt49=1;
                }
            }
            switch (alt49) {
                case 1 :
                    // InternalAssembler.g:2651:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:2655:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:2656:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:2656:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:2657:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_8_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_8_0, grammarAccess.getSpcDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSpcDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_8_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:2674:3: (this_WS_9= RULE_WS )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_WS) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalAssembler.g:2675:4: this_WS_9= RULE_WS
                    {
                    this_WS_9=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_9, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSpcDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleSpcDirective"


    // $ANTLR start "entryRuleNamDirective"
    // InternalAssembler.g:2691:1: entryRuleNamDirective returns [EObject current=null] : iv_ruleNamDirective= ruleNamDirective EOF ;
    public final EObject entryRuleNamDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamDirective = null;


        try {
            // InternalAssembler.g:2691:53: (iv_ruleNamDirective= ruleNamDirective EOF )
            // InternalAssembler.g:2692:2: iv_ruleNamDirective= ruleNamDirective EOF
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
    // InternalAssembler.g:2698:1: ruleNamDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) ;
    public final EObject ruleNamDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token lv_directive_3_0=null;
        Token this_WS_4=null;
        Token this_WS_6=null;
        Token lv_comment_7_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2704:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) )
            // InternalAssembler.g:2705:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:2705:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            // InternalAssembler.g:2706:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine
            {
            // InternalAssembler.g:2706:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalAssembler.g:2707:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2707:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:2708:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNamDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNamDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2729:3: ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==39) ) {
                alt52=1;
            }
            else if ( (LA52_0==40) ) {
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
                    // InternalAssembler.g:2730:4: ( (lv_directive_2_0= 'NAM' ) )
                    {
                    // InternalAssembler.g:2730:4: ( (lv_directive_2_0= 'NAM' ) )
                    // InternalAssembler.g:2731:5: (lv_directive_2_0= 'NAM' )
                    {
                    // InternalAssembler.g:2731:5: (lv_directive_2_0= 'NAM' )
                    // InternalAssembler.g:2732:6: lv_directive_2_0= 'NAM'
                    {
                    lv_directive_2_0=(Token)match(input,39,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_directive_2_0, grammarAccess.getNamDirectiveAccess().getDirectiveNAMKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getNamDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "directive", lv_directive_2_0, "NAM");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2745:4: ( (lv_directive_3_0= 'TTL' ) )
                    {
                    // InternalAssembler.g:2745:4: ( (lv_directive_3_0= 'TTL' ) )
                    // InternalAssembler.g:2746:5: (lv_directive_3_0= 'TTL' )
                    {
                    // InternalAssembler.g:2746:5: (lv_directive_3_0= 'TTL' )
                    // InternalAssembler.g:2747:6: lv_directive_3_0= 'TTL'
                    {
                    lv_directive_3_0=(Token)match(input,40,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_directive_3_0, grammarAccess.getNamDirectiveAccess().getDirectiveTTLKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getNamDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "directive", lv_directive_3_0, "TTL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_WS_4=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_4, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:2764:3: ( (lv_operand_5_0= ruleIdentifierValue ) )
            // InternalAssembler.g:2765:4: (lv_operand_5_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:2765:4: (lv_operand_5_0= ruleIdentifierValue )
            // InternalAssembler.g:2766:5: lv_operand_5_0= ruleIdentifierValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNamDirectiveAccess().getOperandIdentifierValueParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_operand_5_0=ruleIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNamDirectiveRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_5_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.IdentifierValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAssembler.g:2783:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_WS) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalAssembler.g:2784:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:2788:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:2789:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:2789:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:2790:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_7_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_7_0, grammarAccess.getNamDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getNamDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_7_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getNamDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleNamDirective"


    // $ANTLR start "entryRulePagDirective"
    // InternalAssembler.g:2818:1: entryRulePagDirective returns [EObject current=null] : iv_rulePagDirective= rulePagDirective EOF ;
    public final EObject entryRulePagDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePagDirective = null;


        try {
            // InternalAssembler.g:2818:53: (iv_rulePagDirective= rulePagDirective EOF )
            // InternalAssembler.g:2819:2: iv_rulePagDirective= rulePagDirective EOF
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
    // InternalAssembler.g:2825:1: rulePagDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) ;
    public final EObject rulePagDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token this_WS_5=null;
        Token lv_comment_6_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2831:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) )
            // InternalAssembler.g:2832:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:2832:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            // InternalAssembler.g:2833:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine
            {
            // InternalAssembler.g:2833:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAssembler.g:2834:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2834:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:2835:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPagDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPagDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2856:3: ( (lv_directive_2_0= 'PAG' ) )
            // InternalAssembler.g:2857:4: (lv_directive_2_0= 'PAG' )
            {
            // InternalAssembler.g:2857:4: (lv_directive_2_0= 'PAG' )
            // InternalAssembler.g:2858:5: lv_directive_2_0= 'PAG'
            {
            lv_directive_2_0=(Token)match(input,41,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getPagDirectiveAccess().getDirectivePAGKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPagDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "PAG");
              				
            }

            }


            }

            // InternalAssembler.g:2870:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_WS) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==RULE_WS||(LA56_1>=RULE_ID && LA56_1<=RULE_END_OF_FILE)||LA56_1==31||LA56_1==33||(LA56_1>=62 && LA56_1<=63)) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // InternalAssembler.g:2871:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )?
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:2875:4: ( (lv_operand_4_0= ruleExpression ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_CHARACTER)||LA55_0==31||LA55_0==33||(LA55_0>=62 && LA55_0<=63)) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // InternalAssembler.g:2876:5: (lv_operand_4_0= ruleExpression )
                            {
                            // InternalAssembler.g:2876:5: (lv_operand_4_0= ruleExpression )
                            // InternalAssembler.g:2877:6: lv_operand_4_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getPagDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0());
                              					
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_4_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getPagDirectiveRule());
                              						}
                              						set(
                              							current,
                              							"operand",
                              							lv_operand_4_0,
                              							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalAssembler.g:2895:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_WS) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAssembler.g:2896:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:2900:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:2901:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:2901:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:2902:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getPagDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPagDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_6_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPagDirectiveAccess().getEndOfLineParserRuleCall_5());
              		
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
    // $ANTLR end "rulePagDirective"


    // $ANTLR start "entryRuleOptDirective"
    // InternalAssembler.g:2930:1: entryRuleOptDirective returns [EObject current=null] : iv_ruleOptDirective= ruleOptDirective EOF ;
    public final EObject entryRuleOptDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptDirective = null;


        try {
            // InternalAssembler.g:2930:53: (iv_ruleOptDirective= ruleOptDirective EOF )
            // InternalAssembler.g:2931:2: iv_ruleOptDirective= ruleOptDirective EOF
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
    // InternalAssembler.g:2937:1: ruleOptDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) ;
    public final EObject ruleOptDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token otherlv_5=null;
        Token this_WS_7=null;
        Token lv_comment_8_0=null;
        EObject lv_name_0_0 = null;

        Enumerator lv_options_4_0 = null;

        Enumerator lv_options_6_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2943:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) )
            // InternalAssembler.g:2944:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            {
            // InternalAssembler.g:2944:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            // InternalAssembler.g:2945:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine
            {
            // InternalAssembler.g:2945:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAssembler.g:2946:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2946:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:2947:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getOptDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getOptDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2968:3: ( (lv_directive_2_0= 'OPT' ) )
            // InternalAssembler.g:2969:4: (lv_directive_2_0= 'OPT' )
            {
            // InternalAssembler.g:2969:4: (lv_directive_2_0= 'OPT' )
            // InternalAssembler.g:2970:5: lv_directive_2_0= 'OPT'
            {
            lv_directive_2_0=(Token)match(input,42,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getOptDirectiveAccess().getDirectiveOPTKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOptDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "OPT");
              				
            }

            }


            }

            // InternalAssembler.g:2982:3: (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_WS) ) {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==41||(LA60_1>=65 && LA60_1<=71)) ) {
                    alt60=1;
                }
            }
            switch (alt60) {
                case 1 :
                    // InternalAssembler.g:2983:4: this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )*
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:2987:4: ( (lv_options_4_0= ruleAssemblyOption ) )
                    // InternalAssembler.g:2988:5: (lv_options_4_0= ruleAssemblyOption )
                    {
                    // InternalAssembler.g:2988:5: (lv_options_4_0= ruleAssemblyOption )
                    // InternalAssembler.g:2989:6: lv_options_4_0= ruleAssemblyOption
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_23);
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

                    // InternalAssembler.g:3006:4: (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==23) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // InternalAssembler.g:3007:5: otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getOptDirectiveAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:3011:5: ( (lv_options_6_0= ruleAssemblyOption ) )
                    	    // InternalAssembler.g:3012:6: (lv_options_6_0= ruleAssemblyOption )
                    	    {
                    	    // InternalAssembler.g:3012:6: (lv_options_6_0= ruleAssemblyOption )
                    	    // InternalAssembler.g:3013:7: lv_options_6_0= ruleAssemblyOption
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_23);
                    	    lv_options_6_0=ruleAssemblyOption();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getOptDirectiveRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"options",
                    	      								lv_options_6_0,
                    	      								"org.bpy.electronics.mc6809.assembler.Assembler.AssemblyOption");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAssembler.g:3032:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_WS) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalAssembler.g:3033:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:3037:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalAssembler.g:3038:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            {
                            // InternalAssembler.g:3038:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            // InternalAssembler.g:3039:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                            {
                            lv_comment_8_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_comment_8_0, grammarAccess.getOptDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getOptDirectiveRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"comment",
                              							lv_comment_8_0,
                              							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                              					
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOptDirectiveAccess().getEndOfLineParserRuleCall_5());
              		
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
    // $ANTLR end "ruleOptDirective"


    // $ANTLR start "entryRuleFailDirective"
    // InternalAssembler.g:3067:1: entryRuleFailDirective returns [EObject current=null] : iv_ruleFailDirective= ruleFailDirective EOF ;
    public final EObject entryRuleFailDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailDirective = null;


        try {
            // InternalAssembler.g:3067:54: (iv_ruleFailDirective= ruleFailDirective EOF )
            // InternalAssembler.g:3068:2: iv_ruleFailDirective= ruleFailDirective EOF
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
    // InternalAssembler.g:3074:1: ruleFailDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) ;
    public final EObject ruleFailDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_comment_4_0=null;
        EObject lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3080:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) )
            // InternalAssembler.g:3081:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            {
            // InternalAssembler.g:3081:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            // InternalAssembler.g:3082:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine
            {
            // InternalAssembler.g:3082:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalAssembler.g:3083:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3083:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3084:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFailDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFailDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFailDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3105:3: ( (lv_directive_2_0= 'FAIL' ) )
            // InternalAssembler.g:3106:4: (lv_directive_2_0= 'FAIL' )
            {
            // InternalAssembler.g:3106:4: (lv_directive_2_0= 'FAIL' )
            // InternalAssembler.g:3107:5: lv_directive_2_0= 'FAIL'
            {
            lv_directive_2_0=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getFailDirectiveAccess().getDirectiveFAILKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFailDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "FAIL");
              				
            }

            }


            }

            // InternalAssembler.g:3119:3: (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_WS) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAssembler.g:3120:4: this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFailDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3124:4: ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalAssembler.g:3125:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            {
                            // InternalAssembler.g:3125:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            // InternalAssembler.g:3126:6: lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                            {
                            lv_comment_4_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_comment_4_0, grammarAccess.getFailDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getFailDirectiveRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"comment",
                              							lv_comment_4_0,
                              							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                              					
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getFailDirectiveAccess().getEndOfLineParserRuleCall_4());
              		
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
    // $ANTLR end "ruleFailDirective"


    // $ANTLR start "entryRuleSetDirective"
    // InternalAssembler.g:3154:1: entryRuleSetDirective returns [EObject current=null] : iv_ruleSetDirective= ruleSetDirective EOF ;
    public final EObject entryRuleSetDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDirective = null;


        try {
            // InternalAssembler.g:3154:53: (iv_ruleSetDirective= ruleSetDirective EOF )
            // InternalAssembler.g:3155:2: iv_ruleSetDirective= ruleSetDirective EOF
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
    // InternalAssembler.g:3161:1: ruleSetDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
    public final EObject ruleSetDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_isRelativeToPC_4_0=null;
        Token lv_isRelativeToPC_6_0=null;
        Token this_WS_7=null;
        Token lv_comment_8_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3167:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:3168:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:3168:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:3169:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:3169:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalAssembler.g:3170:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3170:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3171:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSetDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSetDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3192:3: ( (lv_directive_2_0= 'SET' ) )
            // InternalAssembler.g:3193:4: (lv_directive_2_0= 'SET' )
            {
            // InternalAssembler.g:3193:4: (lv_directive_2_0= 'SET' )
            // InternalAssembler.g:3194:5: lv_directive_2_0= 'SET'
            {
            lv_directive_2_0=(Token)match(input,44,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getSetDirectiveAccess().getDirectiveSETKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSetDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "SET");
              				
            }

            }


            }

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:3210:3: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==45) ) {
                int LA68_1 = input.LA(2);

                if ( ((LA68_1>=RULE_ID && LA68_1<=RULE_CHARACTER)||LA68_1==31||LA68_1==33||(LA68_1>=62 && LA68_1<=63)) ) {
                    alt68=1;
                }
                else if ( ((LA68_1>=RULE_WS && LA68_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA68_1>=RULE_CR && LA68_1<=RULE_END_OF_FILE)) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA68_0>=RULE_ID && LA68_0<=RULE_CHARACTER)||LA68_0==31||LA68_0==33||(LA68_0>=62 && LA68_0<=63)) ) {
                alt68=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalAssembler.g:3211:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:3211:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:3212:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:3212:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==45) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalAssembler.g:3213:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:3213:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:3214:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,45,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getSetDirectiveAccess().getIsRelativeToPCAsteriskKeyword_4_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getSetDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalAssembler.g:3226:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:3227:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:3227:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:3228:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetDirectiveAccess().getOperandExpressionParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_24);
                    lv_operand_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getSetDirectiveRule());
                      							}
                      							set(
                      								current,
                      								"operand",
                      								lv_operand_5_0,
                      								"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3247:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    {
                    // InternalAssembler.g:3247:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    // InternalAssembler.g:3248:5: (lv_isRelativeToPC_6_0= '*' )
                    {
                    // InternalAssembler.g:3248:5: (lv_isRelativeToPC_6_0= '*' )
                    // InternalAssembler.g:3249:6: lv_isRelativeToPC_6_0= '*'
                    {
                    lv_isRelativeToPC_6_0=(Token)match(input,45,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isRelativeToPC_6_0, grammarAccess.getSetDirectiveAccess().getIsRelativeToPCAsteriskKeyword_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSetDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_6_0 != null, "*");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3262:3: (this_WS_7= RULE_WS )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_WS) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAssembler.g:3263:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:3268:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAssembler.g:3269:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3269:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3270:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_8_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_comment_8_0, grammarAccess.getSetDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_6_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getSetDirectiveRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"comment",
                      						lv_comment_8_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSetDirectiveAccess().getEndOfLineParserRuleCall_7());
              		
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
    // $ANTLR end "ruleSetDirective"


    // $ANTLR start "entryRuleFillDirective"
    // InternalAssembler.g:3297:1: entryRuleFillDirective returns [EObject current=null] : iv_ruleFillDirective= ruleFillDirective EOF ;
    public final EObject entryRuleFillDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFillDirective = null;


        try {
            // InternalAssembler.g:3297:54: (iv_ruleFillDirective= ruleFillDirective EOF )
            // InternalAssembler.g:3298:2: iv_ruleFillDirective= ruleFillDirective EOF
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
    // InternalAssembler.g:3304:1: ruleFillDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleFillDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token otherlv_5=null;
        Token this_WS_7=null;
        Token lv_comment_8_0=null;
        Token this_WS_9=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_number_6_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3310:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3311:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3311:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3312:3: ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3312:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAssembler.g:3313:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3313:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3314:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFillDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFillDirectiveRule());
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

            // InternalAssembler.g:3331:3: (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) )
            // InternalAssembler.g:3332:4: this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:3336:4: ( (lv_directive_2_0= 'FILL' ) )
            // InternalAssembler.g:3337:5: (lv_directive_2_0= 'FILL' )
            {
            // InternalAssembler.g:3337:5: (lv_directive_2_0= 'FILL' )
            // InternalAssembler.g:3338:6: lv_directive_2_0= 'FILL'
            {
            lv_directive_2_0=(Token)match(input,46,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(lv_directive_2_0, grammarAccess.getFillDirectiveAccess().getDirectiveFILLKeyword_1_1_0());
              					
            }
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getFillDirectiveRule());
              						}
              						setWithLastConsumed(current, "directive", lv_directive_2_0, "FILL");
              					
            }

            }


            }


            }

            // InternalAssembler.g:3351:3: (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) )
            // InternalAssembler.g:3352:4: this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_2_0());
              			
            }
            // InternalAssembler.g:3356:4: ( (lv_value_4_0= ruleExpression ) )
            // InternalAssembler.g:3357:5: (lv_value_4_0= ruleExpression )
            {
            // InternalAssembler.g:3357:5: (lv_value_4_0= ruleExpression )
            // InternalAssembler.g:3358:6: lv_value_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getFillDirectiveAccess().getValueExpressionParserRuleCall_2_1_0());
              					
            }
            pushFollow(FOLLOW_12);
            lv_value_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getFillDirectiveRule());
              						}
              						set(
              							current,
              							"value",
              							lv_value_4_0,
              							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getFillDirectiveAccess().getCommaKeyword_2_2());
              			
            }
            // InternalAssembler.g:3379:4: ( (lv_number_6_0= ruleExpression ) )
            // InternalAssembler.g:3380:5: (lv_number_6_0= ruleExpression )
            {
            // InternalAssembler.g:3380:5: (lv_number_6_0= ruleExpression )
            // InternalAssembler.g:3381:6: lv_number_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getFillDirectiveAccess().getNumberExpressionParserRuleCall_2_3_0());
              					
            }
            pushFollow(FOLLOW_4);
            lv_number_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getFillDirectiveRule());
              						}
              						set(
              							current,
              							"number",
              							lv_number_6_0,
              							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }

            // InternalAssembler.g:3399:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_WS) ) {
                int LA72_1 = input.LA(2);

                if ( (LA72_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalAssembler.g:3400:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3404:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3405:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3405:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3406:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_8_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_8_0, grammarAccess.getFillDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFillDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_8_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3423:3: (this_WS_9= RULE_WS )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_WS) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalAssembler.g:3424:4: this_WS_9= RULE_WS
                    {
                    this_WS_9=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_9, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getFillDirectiveAccess().getEndOfLineParserRuleCall_5());
              		
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
    // $ANTLR end "ruleFillDirective"


    // $ANTLR start "entryRuleBszDirective"
    // InternalAssembler.g:3440:1: entryRuleBszDirective returns [EObject current=null] : iv_ruleBszDirective= ruleBszDirective EOF ;
    public final EObject entryRuleBszDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBszDirective = null;


        try {
            // InternalAssembler.g:3440:53: (iv_ruleBszDirective= ruleBszDirective EOF )
            // InternalAssembler.g:3441:2: iv_ruleBszDirective= ruleBszDirective EOF
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
    // InternalAssembler.g:3447:1: ruleBszDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleBszDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_1=null;
        Token lv_directive_2_2=null;
        Token this_WS_3=null;
        Token this_WS_5=null;
        Token lv_comment_6_0=null;
        Token this_WS_7=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3453:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3454:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3454:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3455:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3455:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalAssembler.g:3456:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3456:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3457:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBszDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBszDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3478:3: ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) )
            // InternalAssembler.g:3479:4: ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) )
            {
            // InternalAssembler.g:3479:4: ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) )
            // InternalAssembler.g:3480:5: (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' )
            {
            // InternalAssembler.g:3480:5: (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==47) ) {
                alt75=1;
            }
            else if ( (LA75_0==48) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalAssembler.g:3481:6: lv_directive_2_1= 'BSZ'
                    {
                    lv_directive_2_1=(Token)match(input,47,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_directive_2_1, grammarAccess.getBszDirectiveAccess().getDirectiveBSZKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBszDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "directive", lv_directive_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3492:6: lv_directive_2_2= 'ZMB'
                    {
                    lv_directive_2_2=(Token)match(input,48,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_directive_2_2, grammarAccess.getBszDirectiveAccess().getDirectiveZMBKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBszDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "directive", lv_directive_2_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalAssembler.g:3505:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )
            // InternalAssembler.g:3506:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_3_0());
              			
            }
            // InternalAssembler.g:3510:4: ( (lv_operand_4_0= ruleExpression ) )
            // InternalAssembler.g:3511:5: (lv_operand_4_0= ruleExpression )
            {
            // InternalAssembler.g:3511:5: (lv_operand_4_0= ruleExpression )
            // InternalAssembler.g:3512:6: lv_operand_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getBszDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0());
              					
            }
            pushFollow(FOLLOW_4);
            lv_operand_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getBszDirectiveRule());
              						}
              						set(
              							current,
              							"operand",
              							lv_operand_4_0,
              							"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }

            // InternalAssembler.g:3530:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_WS) ) {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt76=1;
                }
            }
            switch (alt76) {
                case 1 :
                    // InternalAssembler.g:3531:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:3535:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3536:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3536:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3537:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getBszDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBszDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_6_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3554:3: (this_WS_7= RULE_WS )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_WS) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalAssembler.g:3555:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBszDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleBszDirective"


    // $ANTLR start "entryRuleFdbDirective"
    // InternalAssembler.g:3571:1: entryRuleFdbDirective returns [EObject current=null] : iv_ruleFdbDirective= ruleFdbDirective EOF ;
    public final EObject entryRuleFdbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFdbDirective = null;


        try {
            // InternalAssembler.g:3571:53: (iv_ruleFdbDirective= ruleFdbDirective EOF )
            // InternalAssembler.g:3572:2: iv_ruleFdbDirective= ruleFdbDirective EOF
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
    // InternalAssembler.g:3578:1: ruleFdbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleFdbDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token this_WS_5=null;
        Token lv_comment_6_0=null;
        Token this_WS_7=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3584:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3585:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3585:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3586:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3586:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalAssembler.g:3587:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3587:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3588:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFdbDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFdbDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3609:3: ( (lv_directive_2_0= 'FDB' ) )
            // InternalAssembler.g:3610:4: (lv_directive_2_0= 'FDB' )
            {
            // InternalAssembler.g:3610:4: (lv_directive_2_0= 'FDB' )
            // InternalAssembler.g:3611:5: lv_directive_2_0= 'FDB'
            {
            lv_directive_2_0=(Token)match(input,49,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getFdbDirectiveAccess().getDirectiveFDBKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFdbDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "FDB");
              				
            }

            }


            }

            // InternalAssembler.g:3623:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_WS) ) {
                int LA79_1 = input.LA(2);

                if ( ((LA79_1>=RULE_ID && LA79_1<=RULE_CHARACTER)||LA79_1==31||LA79_1==33||(LA79_1>=62 && LA79_1<=63)) ) {
                    alt79=1;
                }
            }
            switch (alt79) {
                case 1 :
                    // InternalAssembler.g:3624:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3628:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:3629:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:3629:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:3630:6: lv_operand_4_0= ruleListOfExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFdbDirectiveAccess().getOperandListOfExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_0=ruleListOfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFdbDirectiveRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_4_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ListOfExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3648:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_WS) ) {
                int LA80_1 = input.LA(2);

                if ( (LA80_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt80=1;
                }
            }
            switch (alt80) {
                case 1 :
                    // InternalAssembler.g:3649:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:3653:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3654:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3654:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3655:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getFdbDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFdbDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_6_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3672:3: (this_WS_7= RULE_WS )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_WS) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalAssembler.g:3673:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getFdbDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleFdbDirective"


    // $ANTLR start "entryRuleFcbDirective"
    // InternalAssembler.g:3689:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:3689:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:3690:2: iv_ruleFcbDirective= ruleFcbDirective EOF
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
    // InternalAssembler.g:3696:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleFcbDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token this_WS_5=null;
        Token lv_comment_6_0=null;
        Token this_WS_7=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3702:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3703:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3703:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3704:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3704:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalAssembler.g:3705:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3705:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3706:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFcbDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFcbDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3727:3: ( (lv_directive_2_0= 'FCB' ) )
            // InternalAssembler.g:3728:4: (lv_directive_2_0= 'FCB' )
            {
            // InternalAssembler.g:3728:4: (lv_directive_2_0= 'FCB' )
            // InternalAssembler.g:3729:5: lv_directive_2_0= 'FCB'
            {
            lv_directive_2_0=(Token)match(input,50,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getFcbDirectiveAccess().getDirectiveFCBKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFcbDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "FCB");
              				
            }

            }


            }

            // InternalAssembler.g:3741:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_WS) ) {
                int LA83_1 = input.LA(2);

                if ( ((LA83_1>=RULE_ID && LA83_1<=RULE_CHARACTER)||LA83_1==31||LA83_1==33||(LA83_1>=62 && LA83_1<=63)) ) {
                    alt83=1;
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalAssembler.g:3742:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3746:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:3747:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:3747:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:3748:6: lv_operand_4_0= ruleListOfExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFcbDirectiveAccess().getOperandListOfExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_0=ruleListOfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFcbDirectiveRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_4_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ListOfExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3766:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_WS) ) {
                int LA84_1 = input.LA(2);

                if ( (LA84_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt84=1;
                }
            }
            switch (alt84) {
                case 1 :
                    // InternalAssembler.g:3767:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:3771:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3772:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3772:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3773:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getFcbDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFcbDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_6_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3790:3: (this_WS_7= RULE_WS )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_WS) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalAssembler.g:3791:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getFcbDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleFcbDirective"


    // $ANTLR start "entryRuleRmbDirective"
    // InternalAssembler.g:3807:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:3807:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:3808:2: iv_ruleRmbDirective= ruleRmbDirective EOF
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
    // InternalAssembler.g:3814:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleRmbDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_isRelativeToPC_4_0=null;
        Token this_WS_6=null;
        Token lv_comment_7_0=null;
        Token this_WS_8=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3820:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3821:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3821:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3822:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3822:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_ID) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalAssembler.g:3823:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3823:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3824:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRmbDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRmbDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3845:3: ( (lv_directive_2_0= 'RMB' ) )
            // InternalAssembler.g:3846:4: (lv_directive_2_0= 'RMB' )
            {
            // InternalAssembler.g:3846:4: (lv_directive_2_0= 'RMB' )
            // InternalAssembler.g:3847:5: lv_directive_2_0= 'RMB'
            {
            lv_directive_2_0=(Token)match(input,51,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getRmbDirectiveAccess().getDirectiveRMBKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRmbDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "RMB");
              				
            }

            }


            }

            // InternalAssembler.g:3859:3: (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_WS) ) {
                int LA88_1 = input.LA(2);

                if ( ((LA88_1>=RULE_ID && LA88_1<=RULE_CHARACTER)||LA88_1==31||LA88_1==33||LA88_1==45||(LA88_1>=62 && LA88_1<=63)) ) {
                    alt88=1;
                }
            }
            switch (alt88) {
                case 1 :
                    // InternalAssembler.g:3860:4: this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3864:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:3865:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:3865:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==45) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalAssembler.g:3866:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:3866:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:3867:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,45,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getRmbDirectiveAccess().getIsRelativeToPCAsteriskKeyword_3_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getRmbDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalAssembler.g:3879:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:3880:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:3880:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:3881:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getRmbDirectiveAccess().getOperandExpressionParserRuleCall_3_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getRmbDirectiveRule());
                      							}
                      							set(
                      								current,
                      								"operand",
                      								lv_operand_5_0,
                      								"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3900:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_WS) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt89=1;
                }
            }
            switch (alt89) {
                case 1 :
                    // InternalAssembler.g:3901:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:3905:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3906:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3906:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3907:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_7_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_7_0, grammarAccess.getRmbDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRmbDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_7_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:3924:3: (this_WS_8= RULE_WS )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_WS) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalAssembler.g:3925:4: this_WS_8= RULE_WS
                    {
                    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_8, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRmbDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleRmbDirective"


    // $ANTLR start "entryRuleEndDirective"
    // InternalAssembler.g:3941:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:3941:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:3942:2: iv_ruleEndDirective= ruleEndDirective EOF
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
    // InternalAssembler.g:3948:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleEndDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_isRelativeToPC_4_0=null;
        Token lv_isRelativeToPC_6_0=null;
        Token this_WS_7=null;
        Token lv_comment_8_0=null;
        Token this_WS_9=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3954:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3955:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3955:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3956:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3956:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ID) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalAssembler.g:3957:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3957:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3958:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getEndDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getEndDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3979:3: ( (lv_directive_2_0= 'END' ) )
            // InternalAssembler.g:3980:4: (lv_directive_2_0= 'END' )
            {
            // InternalAssembler.g:3980:4: (lv_directive_2_0= 'END' )
            // InternalAssembler.g:3981:5: lv_directive_2_0= 'END'
            {
            lv_directive_2_0=(Token)match(input,52,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getEndDirectiveAccess().getDirectiveENDKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEndDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "END");
              				
            }

            }


            }

            // InternalAssembler.g:3993:3: (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_WS) ) {
                int LA94_1 = input.LA(2);

                if ( ((LA94_1>=RULE_ID && LA94_1<=RULE_CHARACTER)||LA94_1==31||LA94_1==33||LA94_1==45||(LA94_1>=62 && LA94_1<=63)) ) {
                    alt94=1;
                }
            }
            switch (alt94) {
                case 1 :
                    // InternalAssembler.g:3994:4: this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3998:4: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==45) ) {
                        int LA93_1 = input.LA(2);

                        if ( ((LA93_1>=RULE_ID && LA93_1<=RULE_CHARACTER)||LA93_1==31||LA93_1==33||(LA93_1>=62 && LA93_1<=63)) ) {
                            alt93=1;
                        }
                        else if ( (LA93_1==RULE_WS||(LA93_1>=RULE_CR && LA93_1<=RULE_END_OF_FILE)) ) {
                            alt93=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 93, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA93_0>=RULE_ID && LA93_0<=RULE_CHARACTER)||LA93_0==31||LA93_0==33||(LA93_0>=62 && LA93_0<=63)) ) {
                        alt93=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 0, input);

                        throw nvae;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalAssembler.g:3999:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:3999:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            // InternalAssembler.g:4000:6: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:4000:6: ( (lv_isRelativeToPC_4_0= '*' ) )?
                            int alt92=2;
                            int LA92_0 = input.LA(1);

                            if ( (LA92_0==45) ) {
                                alt92=1;
                            }
                            switch (alt92) {
                                case 1 :
                                    // InternalAssembler.g:4001:7: (lv_isRelativeToPC_4_0= '*' )
                                    {
                                    // InternalAssembler.g:4001:7: (lv_isRelativeToPC_4_0= '*' )
                                    // InternalAssembler.g:4002:8: lv_isRelativeToPC_4_0= '*'
                                    {
                                    lv_isRelativeToPC_4_0=(Token)match(input,45,FOLLOW_10); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getEndDirectiveAccess().getIsRelativeToPCAsteriskKeyword_3_1_0_0_0());
                                      							
                                    }
                                    if ( state.backtracking==0 ) {

                                      								if (current==null) {
                                      									current = createModelElement(grammarAccess.getEndDirectiveRule());
                                      								}
                                      								setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                                      							
                                    }

                                    }


                                    }
                                    break;

                            }

                            // InternalAssembler.g:4014:6: ( (lv_operand_5_0= ruleExpression ) )
                            // InternalAssembler.g:4015:7: (lv_operand_5_0= ruleExpression )
                            {
                            // InternalAssembler.g:4015:7: (lv_operand_5_0= ruleExpression )
                            // InternalAssembler.g:4016:8: lv_operand_5_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getEndDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getEndDirectiveRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_0,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:4035:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            {
                            // InternalAssembler.g:4035:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            // InternalAssembler.g:4036:6: (lv_isRelativeToPC_6_0= '*' )
                            {
                            // InternalAssembler.g:4036:6: (lv_isRelativeToPC_6_0= '*' )
                            // InternalAssembler.g:4037:7: lv_isRelativeToPC_6_0= '*'
                            {
                            lv_isRelativeToPC_6_0=(Token)match(input,45,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_6_0, grammarAccess.getEndDirectiveAccess().getIsRelativeToPCAsteriskKeyword_3_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEndDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_6_0 != null, "*");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalAssembler.g:4051:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_WS) ) {
                int LA95_1 = input.LA(2);

                if ( (LA95_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt95=1;
                }
            }
            switch (alt95) {
                case 1 :
                    // InternalAssembler.g:4052:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:4056:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:4057:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4057:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4058:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_8_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_8_0, grammarAccess.getEndDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEndDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_8_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:4075:3: (this_WS_9= RULE_WS )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_WS) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalAssembler.g:4076:4: this_WS_9= RULE_WS
                    {
                    this_WS_9=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_9, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEndDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleEndDirective"


    // $ANTLR start "entryRuleOrgDirective"
    // InternalAssembler.g:4092:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:4092:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:4093:2: iv_ruleOrgDirective= ruleOrgDirective EOF
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
    // InternalAssembler.g:4099:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
    public final EObject ruleOrgDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_isRelativeToPC_4_0=null;
        Token lv_isRelativeToPC_6_0=null;
        Token this_WS_7=null;
        Token lv_comment_8_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4105:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:4106:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:4106:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:4107:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:4107:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_ID) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalAssembler.g:4108:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4108:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4109:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getOrgDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getOrgDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4130:3: ( (lv_directive_2_0= 'ORG' ) )
            // InternalAssembler.g:4131:4: (lv_directive_2_0= 'ORG' )
            {
            // InternalAssembler.g:4131:4: (lv_directive_2_0= 'ORG' )
            // InternalAssembler.g:4132:5: lv_directive_2_0= 'ORG'
            {
            lv_directive_2_0=(Token)match(input,53,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getOrgDirectiveAccess().getDirectiveORGKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOrgDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "ORG");
              				
            }

            }


            }

            // InternalAssembler.g:4144:3: (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==RULE_WS) ) {
                int LA100_1 = input.LA(2);

                if ( ((LA100_1>=RULE_ID && LA100_1<=RULE_CHARACTER)||LA100_1==31||LA100_1==33||LA100_1==45||(LA100_1>=62 && LA100_1<=63)) ) {
                    alt100=1;
                }
            }
            switch (alt100) {
                case 1 :
                    // InternalAssembler.g:4145:4: this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:4149:4: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==45) ) {
                        int LA99_1 = input.LA(2);

                        if ( ((LA99_1>=RULE_ID && LA99_1<=RULE_CHARACTER)||LA99_1==31||LA99_1==33||(LA99_1>=62 && LA99_1<=63)) ) {
                            alt99=1;
                        }
                        else if ( ((LA99_1>=RULE_WS && LA99_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA99_1>=RULE_CR && LA99_1<=RULE_END_OF_FILE)) ) {
                            alt99=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 99, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA99_0>=RULE_ID && LA99_0<=RULE_CHARACTER)||LA99_0==31||LA99_0==33||(LA99_0>=62 && LA99_0<=63)) ) {
                        alt99=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 99, 0, input);

                        throw nvae;
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalAssembler.g:4150:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:4150:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            // InternalAssembler.g:4151:6: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:4151:6: ( (lv_isRelativeToPC_4_0= '*' ) )?
                            int alt98=2;
                            int LA98_0 = input.LA(1);

                            if ( (LA98_0==45) ) {
                                alt98=1;
                            }
                            switch (alt98) {
                                case 1 :
                                    // InternalAssembler.g:4152:7: (lv_isRelativeToPC_4_0= '*' )
                                    {
                                    // InternalAssembler.g:4152:7: (lv_isRelativeToPC_4_0= '*' )
                                    // InternalAssembler.g:4153:8: lv_isRelativeToPC_4_0= '*'
                                    {
                                    lv_isRelativeToPC_4_0=(Token)match(input,45,FOLLOW_10); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getOrgDirectiveAccess().getIsRelativeToPCAsteriskKeyword_3_1_0_0_0());
                                      							
                                    }
                                    if ( state.backtracking==0 ) {

                                      								if (current==null) {
                                      									current = createModelElement(grammarAccess.getOrgDirectiveRule());
                                      								}
                                      								setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                                      							
                                    }

                                    }


                                    }
                                    break;

                            }

                            // InternalAssembler.g:4165:6: ( (lv_operand_5_0= ruleExpression ) )
                            // InternalAssembler.g:4166:7: (lv_operand_5_0= ruleExpression )
                            {
                            // InternalAssembler.g:4166:7: (lv_operand_5_0= ruleExpression )
                            // InternalAssembler.g:4167:8: lv_operand_5_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getOrgDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_24);
                            lv_operand_5_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getOrgDirectiveRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_0,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:4186:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            {
                            // InternalAssembler.g:4186:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            // InternalAssembler.g:4187:6: (lv_isRelativeToPC_6_0= '*' )
                            {
                            // InternalAssembler.g:4187:6: (lv_isRelativeToPC_6_0= '*' )
                            // InternalAssembler.g:4188:7: lv_isRelativeToPC_6_0= '*'
                            {
                            lv_isRelativeToPC_6_0=(Token)match(input,45,FOLLOW_24); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_6_0, grammarAccess.getOrgDirectiveAccess().getIsRelativeToPCAsteriskKeyword_3_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getOrgDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_6_0 != null, "*");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalAssembler.g:4202:3: (this_WS_7= RULE_WS )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==RULE_WS) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalAssembler.g:4203:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:4208:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalAssembler.g:4209:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4209:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4210:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_8_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_comment_8_0, grammarAccess.getOrgDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getOrgDirectiveRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"comment",
                      						lv_comment_8_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrgDirectiveAccess().getEndOfLineParserRuleCall_6());
              		
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
    // $ANTLR end "ruleOrgDirective"


    // $ANTLR start "entryRuleEquDirective"
    // InternalAssembler.g:4237:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:4237:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:4238:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:4244:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
    public final EObject ruleEquDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_isRelativeToPC_4_0=null;
        Token lv_isRelativeToPC_6_0=null;
        Token this_WS_7=null;
        Token lv_comment_8_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4250:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:4251:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:4251:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:4252:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:4252:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_ID) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalAssembler.g:4253:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4253:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4254:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getEquDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getEquDirectiveRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4275:3: ( (lv_directive_2_0= 'EQU' ) )
            // InternalAssembler.g:4276:4: (lv_directive_2_0= 'EQU' )
            {
            // InternalAssembler.g:4276:4: (lv_directive_2_0= 'EQU' )
            // InternalAssembler.g:4277:5: lv_directive_2_0= 'EQU'
            {
            lv_directive_2_0=(Token)match(input,54,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEquDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "EQU");
              				
            }

            }


            }

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:4293:3: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==45) ) {
                int LA105_1 = input.LA(2);

                if ( ((LA105_1>=RULE_ID && LA105_1<=RULE_CHARACTER)||LA105_1==31||LA105_1==33||(LA105_1>=62 && LA105_1<=63)) ) {
                    alt105=1;
                }
                else if ( ((LA105_1>=RULE_WS && LA105_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA105_1>=RULE_CR && LA105_1<=RULE_END_OF_FILE)) ) {
                    alt105=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 105, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA105_0>=RULE_ID && LA105_0<=RULE_CHARACTER)||LA105_0==31||LA105_0==33||(LA105_0>=62 && LA105_0<=63)) ) {
                alt105=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalAssembler.g:4294:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:4294:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:4295:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:4295:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==45) ) {
                        alt104=1;
                    }
                    switch (alt104) {
                        case 1 :
                            // InternalAssembler.g:4296:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:4296:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:4297:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,45,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isRelativeToPC_4_0, grammarAccess.getEquDirectiveAccess().getIsRelativeToPCAsteriskKeyword_4_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEquDirectiveRule());
                              							}
                              							setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_4_0 != null, "*");
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalAssembler.g:4309:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:4310:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:4310:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:4311:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getEquDirectiveAccess().getOperandExpressionParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_24);
                    lv_operand_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getEquDirectiveRule());
                      							}
                      							set(
                      								current,
                      								"operand",
                      								lv_operand_5_0,
                      								"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:4330:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    {
                    // InternalAssembler.g:4330:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    // InternalAssembler.g:4331:5: (lv_isRelativeToPC_6_0= '*' )
                    {
                    // InternalAssembler.g:4331:5: (lv_isRelativeToPC_6_0= '*' )
                    // InternalAssembler.g:4332:6: lv_isRelativeToPC_6_0= '*'
                    {
                    lv_isRelativeToPC_6_0=(Token)match(input,45,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isRelativeToPC_6_0, grammarAccess.getEquDirectiveAccess().getIsRelativeToPCAsteriskKeyword_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEquDirectiveRule());
                      						}
                      						setWithLastConsumed(current, "isRelativeToPC", lv_isRelativeToPC_6_0 != null, "*");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:4345:3: (this_WS_7= RULE_WS )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_WS) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalAssembler.g:4346:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:4351:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalAssembler.g:4352:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4352:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4353:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_8_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_comment_8_0, grammarAccess.getEquDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_6_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEquDirectiveRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"comment",
                      						lv_comment_8_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEquDirectiveAccess().getEndOfLineParserRuleCall_7());
              		
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
    // $ANTLR end "ruleEquDirective"


    // $ANTLR start "entryRuleListOfExpression"
    // InternalAssembler.g:4380:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:4380:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:4381:2: iv_ruleListOfExpression= ruleListOfExpression EOF
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
    // InternalAssembler.g:4387:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4393:2: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalAssembler.g:4394:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalAssembler.g:4394:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalAssembler.g:4395:3: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalAssembler.g:4395:3: ( (lv_expressions_0_0= ruleExpression ) )
            // InternalAssembler.g:4396:4: (lv_expressions_0_0= ruleExpression )
            {
            // InternalAssembler.g:4396:4: (lv_expressions_0_0= ruleExpression )
            // InternalAssembler.g:4397:5: lv_expressions_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_43);
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

            // InternalAssembler.g:4414:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==23) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalAssembler.g:4415:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:4419:4: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalAssembler.g:4420:5: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalAssembler.g:4420:5: (lv_expressions_2_0= ruleExpression )
            	    // InternalAssembler.g:4421:6: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_43);
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
    // InternalAssembler.g:4443:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:4443:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:4444:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalAssembler.g:4450:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4456:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:4457:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:4457:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:4458:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:4458:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:4459:4: lv_operand_0_0= ruleMultiplication
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
    // InternalAssembler.g:4479:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:4479:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:4480:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:4486:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4492:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:4493:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:4493:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:4494:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_44);
            this_Division_0=ruleDivision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Division_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:4502:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==45) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalAssembler.g:4503:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:4503:4: ()
            	    // InternalAssembler.g:4504:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4510:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:4511:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:4511:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:4512:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,45,FOLLOW_10); if (state.failed) return current;
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

            	    // InternalAssembler.g:4524:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:4525:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:4525:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:4526:6: lv_right_3_0= ruleDivision
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_44);
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
    // InternalAssembler.g:4548:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:4548:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:4549:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:4555:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4561:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:4562:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:4562:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:4563:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_45);
            this_Modulo_0=ruleModulo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Modulo_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:4571:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==55) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalAssembler.g:4572:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:4572:4: ()
            	    // InternalAssembler.g:4573:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4579:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:4580:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:4580:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:4581:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,55,FOLLOW_10); if (state.failed) return current;
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

            	    // InternalAssembler.g:4593:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:4594:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:4594:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:4595:6: lv_right_3_0= ruleModulo
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_45);
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
    // InternalAssembler.g:4617:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:4617:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:4618:2: iv_ruleModulo= ruleModulo EOF
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
    // InternalAssembler.g:4624:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4630:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:4631:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:4631:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:4632:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_46);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:4640:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==56) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // InternalAssembler.g:4641:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:4641:4: ()
            	    // InternalAssembler.g:4642:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4648:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:4649:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:4649:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:4650:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,56,FOLLOW_10); if (state.failed) return current;
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

            	    // InternalAssembler.g:4662:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:4663:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:4663:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:4664:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_46);
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
    // InternalAssembler.g:4686:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:4686:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:4687:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:4693:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4699:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:4700:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:4700:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:4701:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_47);
            this_Substraction_0=ruleSubstraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Substraction_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:4709:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==33) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // InternalAssembler.g:4710:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:4710:4: ()
            	    // InternalAssembler.g:4711:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,33,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4721:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:4722:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:4722:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:4723:6: lv_right_3_0= ruleSubstraction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
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
    // InternalAssembler.g:4745:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:4745:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:4746:2: iv_ruleSubstraction= ruleSubstraction EOF
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
    // InternalAssembler.g:4752:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4758:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:4759:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:4759:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:4760:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_48);
            this_LeftShift_0=ruleLeftShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LeftShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:4768:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==31) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalAssembler.g:4769:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:4769:4: ()
            	    // InternalAssembler.g:4770:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4776:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:4777:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4783:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:4784:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:4784:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:4785:6: lv_right_3_0= ruleLeftShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
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
    // InternalAssembler.g:4807:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:4807:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:4808:2: iv_ruleLeftShift= ruleLeftShift EOF
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
    // InternalAssembler.g:4814:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4820:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:4821:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:4821:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:4822:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLeftShiftAccess().getRightShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_49);
            this_RightShift_0=ruleRightShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RightShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:4830:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==57) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalAssembler.g:4831:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:4831:4: ()
            	    // InternalAssembler.g:4832:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,57,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4842:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:4843:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:4843:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:4844:6: lv_right_3_0= ruleRightShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLeftShiftAccess().getRightRightShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_49);
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
    // InternalAssembler.g:4866:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:4866:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:4867:2: iv_ruleRightShift= ruleRightShift EOF
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
    // InternalAssembler.g:4873:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4879:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:4880:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:4880:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:4881:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRightShiftAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_50);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:4889:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==58) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // InternalAssembler.g:4890:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:4890:4: ()
            	    // InternalAssembler.g:4891:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,58,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4901:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:4902:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:4902:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:4903:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRightShiftAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_50);
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
    // InternalAssembler.g:4925:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:4925:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:4926:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalAssembler.g:4932:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4938:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:4939:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:4939:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:4940:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getOrParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_51);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Or_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:4948:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==59) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // InternalAssembler.g:4949:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:4949:4: ()
            	    // InternalAssembler.g:4950:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,59,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4960:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:4961:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:4961:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:4962:6: lv_right_3_0= ruleOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_51);
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
    // InternalAssembler.g:4984:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:4984:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:4985:2: iv_ruleOr= ruleOr EOF
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
    // InternalAssembler.g:4991:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4997:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:4998:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:4998:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:4999:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getXorParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_Xor_0=ruleXor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Xor_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:5007:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==60) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // InternalAssembler.g:5008:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:5008:4: ()
            	    // InternalAssembler.g:5009:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,60,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5019:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:5020:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:5020:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:5021:6: lv_right_3_0= ruleXor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_52);
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
    // InternalAssembler.g:5043:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:5043:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:5044:2: iv_ruleXor= ruleXor EOF
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
    // InternalAssembler.g:5050:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5056:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:5057:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:5057:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:5058:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_53);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:5066:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==61) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // InternalAssembler.g:5067:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:5067:4: ()
            	    // InternalAssembler.g:5068:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,61,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5078:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:5079:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:5079:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:5080:6: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_53);
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
    // InternalAssembler.g:5102:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:5102:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:5103:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:5109:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
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
            // InternalAssembler.g:5115:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:5116:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:5116:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt119=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 31:
            case 33:
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
            case 62:
                {
                alt119=7;
                }
                break;
            case 63:
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
                    // InternalAssembler.g:5117:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:5117:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:5118:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:5118:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:5119:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:5137:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:5137:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:5138:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:5138:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:5139:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:5157:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:5157:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:5158:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:5158:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:5159:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:5177:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:5177:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:5178:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:5178:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:5179:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:5197:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:5197:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:5198:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:5198:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:5199:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:5217:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:5217:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:5218:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5218:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:5219:5: lv_value_5_0= ruleIdentifierValue
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
                    // InternalAssembler.g:5237:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:5237:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:5238:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:5238:4: ()
                    // InternalAssembler.g:5239:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,62,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:5249:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:5250:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:5250:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:5251:6: lv_value_8_0= rulePrimary
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
                    // InternalAssembler.g:5270:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:5270:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:5271:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,63,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_54);
                    this_Multiplication_10=ruleMultiplication();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Multiplication_10;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_11=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:5292:1: entryRuleNumericalValue returns [EObject current=null] : iv_ruleNumericalValue= ruleNumericalValue EOF ;
    public final EObject entryRuleNumericalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalValue = null;


        try {
            // InternalAssembler.g:5292:55: (iv_ruleNumericalValue= ruleNumericalValue EOF )
            // InternalAssembler.g:5293:2: iv_ruleNumericalValue= ruleNumericalValue EOF
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
    // InternalAssembler.g:5299:1: ruleNumericalValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) ;
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
            // InternalAssembler.g:5305:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:5306:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:5306:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            int alt120=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 31:
            case 33:
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
                    // InternalAssembler.g:5307:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:5307:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:5308:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:5308:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:5309:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:5327:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:5327:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:5328:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:5328:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:5329:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:5347:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:5347:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:5348:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:5348:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:5349:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:5367:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:5367:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:5368:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:5368:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:5369:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:5387:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:5387:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:5388:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:5388:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:5389:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:5407:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:5407:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:5408:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5408:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:5409:5: lv_value_5_0= ruleIdentifierValue
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
    // InternalAssembler.g:5430:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:5430:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:5431:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
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
    // InternalAssembler.g:5437:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5443:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:5444:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:5444:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:5445:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:5445:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:5446:4: lv_value_0_0= RULE_ID
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
    // InternalAssembler.g:5465:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:5465:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:5466:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalAssembler.g:5472:1: ruleDecimalValue returns [EObject current=null] : ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_sign_0_1=null;
        Token lv_sign_0_2=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5478:2: ( ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:5479:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:5479:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:5480:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:5480:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==31||LA122_0==33) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalAssembler.g:5481:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    {
                    // InternalAssembler.g:5481:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    // InternalAssembler.g:5482:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    {
                    // InternalAssembler.g:5482:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    int alt121=2;
                    int LA121_0 = input.LA(1);

                    if ( (LA121_0==31) ) {
                        alt121=1;
                    }
                    else if ( (LA121_0==33) ) {
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
                            // InternalAssembler.g:5483:6: lv_sign_0_1= '-'
                            {
                            lv_sign_0_1=(Token)match(input,31,FOLLOW_55); if (state.failed) return current;
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
                            // InternalAssembler.g:5494:6: lv_sign_0_2= '+'
                            {
                            lv_sign_0_2=(Token)match(input,33,FOLLOW_55); if (state.failed) return current;
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

            // InternalAssembler.g:5507:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:5508:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:5508:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:5509:5: lv_value_1_0= RULE_INT
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
    // InternalAssembler.g:5529:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:5529:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:5530:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
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
    // InternalAssembler.g:5536:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5542:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:5543:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:5543:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:5544:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:5544:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:5545:4: lv_value_0_0= RULE_HEXA
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
    // InternalAssembler.g:5564:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:5564:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:5565:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:5571:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5577:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:5578:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:5578:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:5579:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:5579:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:5580:4: lv_value_0_0= RULE_OCTAL
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
    // InternalAssembler.g:5599:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:5599:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:5600:2: iv_ruleBinaryValue= ruleBinaryValue EOF
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
    // InternalAssembler.g:5606:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5612:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:5613:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:5613:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:5614:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:5614:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:5615:4: lv_value_0_0= RULE_BINARY
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
    // InternalAssembler.g:5634:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:5634:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:5635:2: iv_ruleCharacterValue= ruleCharacterValue EOF
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
    // InternalAssembler.g:5641:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5647:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:5648:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:5648:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:5649:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:5649:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:5650:4: lv_value_0_0= RULE_CHARACTER
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
    // InternalAssembler.g:5669:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:5669:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:5670:2: iv_ruleEndOfLine= ruleEndOfLine EOF
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
    // InternalAssembler.g:5676:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:5682:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:5683:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:5683:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
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
                    // InternalAssembler.g:5684:3: this_CR_0= RULE_CR
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
                    // InternalAssembler.g:5692:3: this_END_OF_FILE_1= RULE_END_OF_FILE
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
    // InternalAssembler.g:5703:1: ruleAssemblyOption returns [Enumerator current=null] : ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) ;
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
            // InternalAssembler.g:5709:2: ( ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) )
            // InternalAssembler.g:5710:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            {
            // InternalAssembler.g:5710:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            int alt124=8;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt124=1;
                }
                break;
            case 65:
                {
                alt124=2;
                }
                break;
            case 66:
                {
                alt124=3;
                }
                break;
            case 67:
                {
                alt124=4;
                }
                break;
            case 68:
                {
                alt124=5;
                }
                break;
            case 69:
                {
                alt124=6;
                }
                break;
            case 70:
                {
                alt124=7;
                }
                break;
            case 71:
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
                    // InternalAssembler.g:5711:3: (enumLiteral_0= 'PAG' )
                    {
                    // InternalAssembler.g:5711:3: (enumLiteral_0= 'PAG' )
                    // InternalAssembler.g:5712:4: enumLiteral_0= 'PAG'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:5719:3: (enumLiteral_1= 'NOP' )
                    {
                    // InternalAssembler.g:5719:3: (enumLiteral_1= 'NOP' )
                    // InternalAssembler.g:5720:4: enumLiteral_1= 'NOP'
                    {
                    enumLiteral_1=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:5727:3: (enumLiteral_2= 'CON' )
                    {
                    // InternalAssembler.g:5727:3: (enumLiteral_2= 'CON' )
                    // InternalAssembler.g:5728:4: enumLiteral_2= 'CON'
                    {
                    enumLiteral_2=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:5735:3: (enumLiteral_3= 'NOC' )
                    {
                    // InternalAssembler.g:5735:3: (enumLiteral_3= 'NOC' )
                    // InternalAssembler.g:5736:4: enumLiteral_3= 'NOC'
                    {
                    enumLiteral_3=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:5743:3: (enumLiteral_4= 'MAC' )
                    {
                    // InternalAssembler.g:5743:3: (enumLiteral_4= 'MAC' )
                    // InternalAssembler.g:5744:4: enumLiteral_4= 'MAC'
                    {
                    enumLiteral_4=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:5751:3: (enumLiteral_5= 'NOM' )
                    {
                    // InternalAssembler.g:5751:3: (enumLiteral_5= 'NOM' )
                    // InternalAssembler.g:5752:4: enumLiteral_5= 'NOM'
                    {
                    enumLiteral_5=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:5759:3: (enumLiteral_6= 'EXP' )
                    {
                    // InternalAssembler.g:5759:3: (enumLiteral_6= 'EXP' )
                    // InternalAssembler.g:5760:4: enumLiteral_6= 'EXP'
                    {
                    enumLiteral_6=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:5767:3: (enumLiteral_7= 'NOE' )
                    {
                    // InternalAssembler.g:5767:3: (enumLiteral_7= 'NOE' )
                    // InternalAssembler.g:5768:4: enumLiteral_7= 'NOE'
                    {
                    enumLiteral_7=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:5778:1: ruleRegister returns [Enumerator current=null] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) ;
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
            // InternalAssembler.g:5784:2: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) )
            // InternalAssembler.g:5785:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            {
            // InternalAssembler.g:5785:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            int alt125=10;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt125=1;
                }
                break;
            case 29:
                {
                alt125=2;
                }
                break;
            case 30:
                {
                alt125=3;
                }
                break;
            case 26:
                {
                alt125=4;
                }
                break;
            case 27:
                {
                alt125=5;
                }
                break;
            case 25:
                {
                alt125=6;
                }
                break;
            case 24:
                {
                alt125=7;
                }
                break;
            case 72:
                {
                alt125=8;
                }
                break;
            case 73:
                {
                alt125=9;
                }
                break;
            case 74:
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
                    // InternalAssembler.g:5786:3: (enumLiteral_0= 'A' )
                    {
                    // InternalAssembler.g:5786:3: (enumLiteral_0= 'A' )
                    // InternalAssembler.g:5787:4: enumLiteral_0= 'A'
                    {
                    enumLiteral_0=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:5794:3: (enumLiteral_1= 'B' )
                    {
                    // InternalAssembler.g:5794:3: (enumLiteral_1= 'B' )
                    // InternalAssembler.g:5795:4: enumLiteral_1= 'B'
                    {
                    enumLiteral_1=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:5802:3: (enumLiteral_2= 'D' )
                    {
                    // InternalAssembler.g:5802:3: (enumLiteral_2= 'D' )
                    // InternalAssembler.g:5803:4: enumLiteral_2= 'D'
                    {
                    enumLiteral_2=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:5810:3: (enumLiteral_3= 'X' )
                    {
                    // InternalAssembler.g:5810:3: (enumLiteral_3= 'X' )
                    // InternalAssembler.g:5811:4: enumLiteral_3= 'X'
                    {
                    enumLiteral_3=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:5818:3: (enumLiteral_4= 'Y' )
                    {
                    // InternalAssembler.g:5818:3: (enumLiteral_4= 'Y' )
                    // InternalAssembler.g:5819:4: enumLiteral_4= 'Y'
                    {
                    enumLiteral_4=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:5826:3: (enumLiteral_5= 'U' )
                    {
                    // InternalAssembler.g:5826:3: (enumLiteral_5= 'U' )
                    // InternalAssembler.g:5827:4: enumLiteral_5= 'U'
                    {
                    enumLiteral_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:5834:3: (enumLiteral_6= 'S' )
                    {
                    // InternalAssembler.g:5834:3: (enumLiteral_6= 'S' )
                    // InternalAssembler.g:5835:4: enumLiteral_6= 'S'
                    {
                    enumLiteral_6=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:5842:3: (enumLiteral_7= 'DP' )
                    {
                    // InternalAssembler.g:5842:3: (enumLiteral_7= 'DP' )
                    // InternalAssembler.g:5843:4: enumLiteral_7= 'DP'
                    {
                    enumLiteral_7=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:5850:3: (enumLiteral_8= 'CC' )
                    {
                    // InternalAssembler.g:5850:3: (enumLiteral_8= 'CC' )
                    // InternalAssembler.g:5851:4: enumLiteral_8= 'CC'
                    {
                    enumLiteral_8=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAssembler.g:5858:3: (enumLiteral_9= 'PC' )
                    {
                    // InternalAssembler.g:5858:3: (enumLiteral_9= 'PC' )
                    // InternalAssembler.g:5859:4: enumLiteral_9= 'PC'
                    {
                    enumLiteral_9=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
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


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String dfa_1s = "\27\uffff";
    static final String dfa_2s = "\1\7\2\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\23\1\uffff";
    static final String dfa_3s = "\1\77\2\uffff\2\10\6\75\1\uffff\1\77\1\uffff\2\10\6\75\1\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\2\10\uffff\1\3\1\uffff\1\4\10\uffff\1\5";
    static final String dfa_5s = "\27\uffff}>";
    static final String[] dfa_6s = {
            "\1\12\1\5\1\6\1\7\1\10\1\11\5\uffff\1\14\1\uffff\1\15\1\2\1\1\1\13\4\uffff\3\13\1\3\1\uffff\1\4\34\uffff\2\15",
            "",
            "",
            "\1\5",
            "\1\5",
            "\1\15\10\uffff\2\15\10\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\10\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\10\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\10\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\10\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\10\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "",
            "\1\25\1\20\1\21\1\22\1\23\1\24\12\uffff\1\13\4\uffff\3\13\1\16\1\uffff\1\17\34\uffff\2\26",
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

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "423:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_7s = "\44\uffff";
    static final String dfa_8s = "\16\uffff\4\34\22\uffff";
    static final String dfa_9s = "\1\7\2\10\6\27\1\30\1\uffff\1\7\2\uffff\4\4\1\uffff\2\10\6\27\1\30\1\uffff\4\23\3\uffff";
    static final String dfa_10s = "\1\41\2\10\6\27\1\43\1\uffff\1\41\2\uffff\4\42\1\uffff\2\10\6\27\1\43\1\uffff\4\42\3\uffff";
    static final String dfa_11s = "\12\uffff\1\3\1\uffff\1\4\1\1\4\uffff\1\7\11\uffff\1\2\4\uffff\1\6\1\10\1\5";
    static final String dfa_12s = "\44\uffff}>";
    static final String[] dfa_13s = {
            "\1\10\1\3\1\4\1\5\1\6\1\7\5\uffff\1\13\4\uffff\1\11\4\uffff\3\12\1\1\1\uffff\1\2",
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
            "\1\32\1\25\1\26\1\27\1\30\1\31\12\uffff\1\33\4\uffff\3\22\1\23\1\uffff\1\24",
            "",
            "",
            "\1\34\10\uffff\2\34\22\uffff\2\15",
            "\1\34\10\uffff\2\34\22\uffff\2\15",
            "\1\34\10\uffff\2\34\22\uffff\2\15",
            "\1\34\10\uffff\2\34\22\uffff\2\15",
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

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "828:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )";
        }
    }
    static final String dfa_14s = "\23\uffff";
    static final String dfa_15s = "\2\4\1\44\20\uffff";
    static final String dfa_16s = "\1\7\1\4\1\66\20\uffff";
    static final String dfa_17s = "\3\uffff\1\11\1\14\1\20\1\2\1\10\1\7\1\17\1\4\1\16\1\13\1\5\1\6\1\3\1\15\1\12\1\1";
    static final String dfa_18s = "\23\uffff}>";
    static final String[] dfa_19s = {
            "\1\2\2\uffff\1\1",
            "\1\2",
            "\1\11\1\4\1\14\2\3\1\7\1\10\1\15\1\21\1\uffff\1\16\2\17\1\13\1\20\1\5\1\12\1\6\1\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1970:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000060B2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xC0000002F0F41F80L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0xC000000280101F80L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000F000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000280801F80L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000018F000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000007F000000L,0x0000000000000700L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000806010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000006030L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xC000000280107F90L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000020000000000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0xC000200280101F80L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000100L});

}
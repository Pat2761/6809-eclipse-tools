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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "'ASRA'", "'ASRB'", "'ASR'", "'ASLA'", "'ASLB'", "'ASL'", "'ANDCC'", "'ANDA'", "'ANDB'", "'ADDD'", "'ADDA'", "'ADDB'", "'ADCA'", "'ADCB'", "'ABX'", "'['", "']'", "'>'", "'<'", "'#'", "','", "'S'", "'U'", "'X'", "'Y'", "'A'", "'B'", "'D'", "'-'", "'--'", "'+'", "'++'", "'PCR'", "'FCC'", "'REG'", "'SPC'", "'NAM'", "'TTL'", "'PAG'", "'OPT'", "'FAIL'", "'SET'", "'*'", "'FILL'", "'BSZ'", "'ZMB'", "'FDB'", "'FCB'", "'RMB'", "'END'", "'ORG'", "'EQU'", "'/'", "'%'", "'<<'", "'>>'", "'&&'", "'||'", "'^'", "'!'", "'('", "')'", "'NOP'", "'CON'", "'NOC'", "'MAC'", "'NOM'", "'EXP'", "'NOE'", "'DP'", "'CC'", "'PC'"
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
    public static final int T__77=77;
    public static final int RULE_END_OF_FILE=14;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=4;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int RULE_BINARY=11;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
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
                case RULE_CR:
                case RULE_END_OF_FILE:
                    {
                    alt2=1;
                    }
                    break;
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                    {
                    alt2=3;
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

                    if ( ((LA2_7>=15 && LA2_7<=29)) ) {
                        alt2=4;
                    }
                    else if ( ((LA2_7>=48 && LA2_7<=56)||(LA2_7>=58 && LA2_7<=66)) ) {
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
    // InternalAssembler.g:301:1: ruleInstructionLine returns [EObject current=null] : ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) | ( (lv_instruction_2_0= ruleAddInstruction ) ) | ( (lv_instruction_3_0= ruleAdddInstruction ) ) | ( (lv_instruction_4_0= ruleAndInstruction ) ) | ( (lv_instruction_5_0= ruleAndCCInstruction ) ) | ( (lv_instruction_6_0= ruleAslInstruction ) ) | ( (lv_instruction_7_0= ruleAsrInstruction ) ) ) ;
    public final EObject ruleInstructionLine() throws RecognitionException {
        EObject current = null;

        EObject lv_instruction_0_0 = null;

        EObject lv_instruction_1_0 = null;

        EObject lv_instruction_2_0 = null;

        EObject lv_instruction_3_0 = null;

        EObject lv_instruction_4_0 = null;

        EObject lv_instruction_5_0 = null;

        EObject lv_instruction_6_0 = null;

        EObject lv_instruction_7_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:307:2: ( ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) | ( (lv_instruction_2_0= ruleAddInstruction ) ) | ( (lv_instruction_3_0= ruleAdddInstruction ) ) | ( (lv_instruction_4_0= ruleAndInstruction ) ) | ( (lv_instruction_5_0= ruleAndCCInstruction ) ) | ( (lv_instruction_6_0= ruleAslInstruction ) ) | ( (lv_instruction_7_0= ruleAsrInstruction ) ) ) )
            // InternalAssembler.g:308:2: ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) | ( (lv_instruction_2_0= ruleAddInstruction ) ) | ( (lv_instruction_3_0= ruleAdddInstruction ) ) | ( (lv_instruction_4_0= ruleAndInstruction ) ) | ( (lv_instruction_5_0= ruleAndCCInstruction ) ) | ( (lv_instruction_6_0= ruleAslInstruction ) ) | ( (lv_instruction_7_0= ruleAsrInstruction ) ) )
            {
            // InternalAssembler.g:308:2: ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) | ( (lv_instruction_2_0= ruleAddInstruction ) ) | ( (lv_instruction_3_0= ruleAdddInstruction ) ) | ( (lv_instruction_4_0= ruleAndInstruction ) ) | ( (lv_instruction_5_0= ruleAndCCInstruction ) ) | ( (lv_instruction_6_0= ruleAslInstruction ) ) | ( (lv_instruction_7_0= ruleAsrInstruction ) ) )
            int alt4=8;
            alt4 = dfa4.predict(input);
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
                case 3 :
                    // InternalAssembler.g:349:3: ( (lv_instruction_2_0= ruleAddInstruction ) )
                    {
                    // InternalAssembler.g:349:3: ( (lv_instruction_2_0= ruleAddInstruction ) )
                    // InternalAssembler.g:350:4: (lv_instruction_2_0= ruleAddInstruction )
                    {
                    // InternalAssembler.g:350:4: (lv_instruction_2_0= ruleAddInstruction )
                    // InternalAssembler.g:351:5: lv_instruction_2_0= ruleAddInstruction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAddInstructionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instruction_2_0=ruleAddInstruction();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AddInstruction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:369:3: ( (lv_instruction_3_0= ruleAdddInstruction ) )
                    {
                    // InternalAssembler.g:369:3: ( (lv_instruction_3_0= ruleAdddInstruction ) )
                    // InternalAssembler.g:370:4: (lv_instruction_3_0= ruleAdddInstruction )
                    {
                    // InternalAssembler.g:370:4: (lv_instruction_3_0= ruleAdddInstruction )
                    // InternalAssembler.g:371:5: lv_instruction_3_0= ruleAdddInstruction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAdddInstructionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instruction_3_0=ruleAdddInstruction();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AdddInstruction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:389:3: ( (lv_instruction_4_0= ruleAndInstruction ) )
                    {
                    // InternalAssembler.g:389:3: ( (lv_instruction_4_0= ruleAndInstruction ) )
                    // InternalAssembler.g:390:4: (lv_instruction_4_0= ruleAndInstruction )
                    {
                    // InternalAssembler.g:390:4: (lv_instruction_4_0= ruleAndInstruction )
                    // InternalAssembler.g:391:5: lv_instruction_4_0= ruleAndInstruction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAndInstructionParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instruction_4_0=ruleAndInstruction();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AndInstruction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:409:3: ( (lv_instruction_5_0= ruleAndCCInstruction ) )
                    {
                    // InternalAssembler.g:409:3: ( (lv_instruction_5_0= ruleAndCCInstruction ) )
                    // InternalAssembler.g:410:4: (lv_instruction_5_0= ruleAndCCInstruction )
                    {
                    // InternalAssembler.g:410:4: (lv_instruction_5_0= ruleAndCCInstruction )
                    // InternalAssembler.g:411:5: lv_instruction_5_0= ruleAndCCInstruction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAndCCInstructionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instruction_5_0=ruleAndCCInstruction();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AndCCInstruction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:429:3: ( (lv_instruction_6_0= ruleAslInstruction ) )
                    {
                    // InternalAssembler.g:429:3: ( (lv_instruction_6_0= ruleAslInstruction ) )
                    // InternalAssembler.g:430:4: (lv_instruction_6_0= ruleAslInstruction )
                    {
                    // InternalAssembler.g:430:4: (lv_instruction_6_0= ruleAslInstruction )
                    // InternalAssembler.g:431:5: lv_instruction_6_0= ruleAslInstruction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAslInstructionParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instruction_6_0=ruleAslInstruction();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AslInstruction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:449:3: ( (lv_instruction_7_0= ruleAsrInstruction ) )
                    {
                    // InternalAssembler.g:449:3: ( (lv_instruction_7_0= ruleAsrInstruction ) )
                    // InternalAssembler.g:450:4: (lv_instruction_7_0= ruleAsrInstruction )
                    {
                    // InternalAssembler.g:450:4: (lv_instruction_7_0= ruleAsrInstruction )
                    // InternalAssembler.g:451:5: lv_instruction_7_0= ruleAsrInstruction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstructionLineAccess().getInstructionAsrInstructionParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instruction_7_0=ruleAsrInstruction();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.AsrInstruction");
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


    // $ANTLR start "entryRuleAsrInstruction"
    // InternalAssembler.g:472:1: entryRuleAsrInstruction returns [EObject current=null] : iv_ruleAsrInstruction= ruleAsrInstruction EOF ;
    public final EObject entryRuleAsrInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsrInstruction = null;


        try {
            // InternalAssembler.g:472:55: (iv_ruleAsrInstruction= ruleAsrInstruction EOF )
            // InternalAssembler.g:473:2: iv_ruleAsrInstruction= ruleAsrInstruction EOF
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
    // InternalAssembler.g:479:1: ruleAsrInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) ) ) | ( ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleAsrInstruction() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_instruction_2_1=null;
        Token lv_instruction_2_2=null;
        Token lv_instruction_3_0=null;
        Token this_WS_4=null;
        Token this_WS_6=null;
        Token lv_comment_7_0=null;
        Token this_WS_8=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_5_1 = null;

        EObject lv_operand_5_2 = null;

        EObject lv_operand_5_3 = null;

        EObject lv_operand_5_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:485:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) ) ) | ( ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:486:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) ) ) | ( ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:486:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) ) ) | ( ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:487:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) ) ) | ( ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:487:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:488:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:488:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:489:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAsrInstructionAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
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

              			newLeafNode(this_WS_1, grammarAccess.getAsrInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:510:3: ( ( ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) ) ) | ( ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=15 && LA8_0<=16)) ) {
                alt8=1;
            }
            else if ( (LA8_0==17) ) {
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
                    // InternalAssembler.g:511:4: ( ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) ) )
                    {
                    // InternalAssembler.g:511:4: ( ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) ) )
                    // InternalAssembler.g:512:5: ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) )
                    {
                    // InternalAssembler.g:512:5: ( (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' ) )
                    // InternalAssembler.g:513:6: (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' )
                    {
                    // InternalAssembler.g:513:6: (lv_instruction_2_1= 'ASRA' | lv_instruction_2_2= 'ASRB' )
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
                            // InternalAssembler.g:514:7: lv_instruction_2_1= 'ASRA'
                            {
                            lv_instruction_2_1=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_instruction_2_1, grammarAccess.getAsrInstructionAccess().getInstructionASRAKeyword_2_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAsrInstructionRule());
                              							}
                              							setWithLastConsumed(current, "instruction", lv_instruction_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:525:7: lv_instruction_2_2= 'ASRB'
                            {
                            lv_instruction_2_2=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_instruction_2_2, grammarAccess.getAsrInstructionAccess().getInstructionASRBKeyword_2_0_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAsrInstructionRule());
                              							}
                              							setWithLastConsumed(current, "instruction", lv_instruction_2_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:539:4: ( ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:539:4: ( ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:540:5: ( (lv_instruction_3_0= 'ASR' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:540:5: ( (lv_instruction_3_0= 'ASR' ) )
                    // InternalAssembler.g:541:6: (lv_instruction_3_0= 'ASR' )
                    {
                    // InternalAssembler.g:541:6: (lv_instruction_3_0= 'ASR' )
                    // InternalAssembler.g:542:7: lv_instruction_3_0= 'ASR'
                    {
                    lv_instruction_3_0=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_instruction_3_0, grammarAccess.getAsrInstructionAccess().getInstructionASRKeyword_2_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getAsrInstructionRule());
                      							}
                      							setWithLastConsumed(current, "instruction", lv_instruction_3_0, "ASR");
                      						
                    }

                    }


                    }

                    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_WS_4, grammarAccess.getAsrInstructionAccess().getWSTerminalRuleCall_2_1_1());
                      				
                    }
                    // InternalAssembler.g:558:5: ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:559:6: ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:559:6: ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:560:7: (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:560:7: (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand )
                    int alt7=4;
                    alt7 = dfa7.predict(input);
                    switch (alt7) {
                        case 1 :
                            // InternalAssembler.g:561:8: lv_operand_5_1= ruleDirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAsrInstructionAccess().getOperandDirectOperandParserRuleCall_2_1_2_0_0());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_1=ruleDirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_1,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:577:8: lv_operand_5_2= ruleIndexedOperand
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAsrInstructionAccess().getOperandIndexedOperandParserRuleCall_2_1_2_0_1());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_2=ruleIndexedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_2,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:593:8: lv_operand_5_3= ruleExtendedOperand
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAsrInstructionAccess().getOperandExtendedOperandParserRuleCall_2_1_2_0_2());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_3=ruleExtendedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_3,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:609:8: lv_operand_5_4= ruleExtendedIndirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAsrInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_1_2_0_3());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_4=ruleExtendedIndirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAsrInstructionRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_4,
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

            // InternalAssembler.g:629:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_WS) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:630:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getAsrInstructionAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:634:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:635:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:635:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:636:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_7_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_7_0, grammarAccess.getAsrInstructionAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAsrInstructionRule());
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

            // InternalAssembler.g:653:3: (this_WS_8= RULE_WS )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_WS) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:654:4: this_WS_8= RULE_WS
                    {
                    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_8, grammarAccess.getAsrInstructionAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAsrInstructionAccess().getEndOfLineParserRuleCall_5());
              		
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
    // $ANTLR end "ruleAsrInstruction"


    // $ANTLR start "entryRuleAslInstruction"
    // InternalAssembler.g:670:1: entryRuleAslInstruction returns [EObject current=null] : iv_ruleAslInstruction= ruleAslInstruction EOF ;
    public final EObject entryRuleAslInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAslInstruction = null;


        try {
            // InternalAssembler.g:670:55: (iv_ruleAslInstruction= ruleAslInstruction EOF )
            // InternalAssembler.g:671:2: iv_ruleAslInstruction= ruleAslInstruction EOF
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
    // InternalAssembler.g:677:1: ruleAslInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) ) ) | ( ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleAslInstruction() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_instruction_2_1=null;
        Token lv_instruction_2_2=null;
        Token lv_instruction_3_0=null;
        Token this_WS_4=null;
        Token this_WS_6=null;
        Token lv_comment_7_0=null;
        Token this_WS_8=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_5_1 = null;

        EObject lv_operand_5_2 = null;

        EObject lv_operand_5_3 = null;

        EObject lv_operand_5_4 = null;



        	enterRule();

        try {
            // InternalAssembler.g:683:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) ) ) | ( ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:684:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) ) ) | ( ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:684:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) ) ) | ( ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:685:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) ) ) | ( ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:685:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAssembler.g:686:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:686:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:687:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAslInstructionAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAslInstructionRule());
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

              			newLeafNode(this_WS_1, grammarAccess.getAslInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:708:3: ( ( ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) ) ) | ( ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=18 && LA14_0<=19)) ) {
                alt14=1;
            }
            else if ( (LA14_0==20) ) {
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
                    // InternalAssembler.g:709:4: ( ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) ) )
                    {
                    // InternalAssembler.g:709:4: ( ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) ) )
                    // InternalAssembler.g:710:5: ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) )
                    {
                    // InternalAssembler.g:710:5: ( (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' ) )
                    // InternalAssembler.g:711:6: (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' )
                    {
                    // InternalAssembler.g:711:6: (lv_instruction_2_1= 'ASLA' | lv_instruction_2_2= 'ASLB' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==18) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==19) ) {
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
                            // InternalAssembler.g:712:7: lv_instruction_2_1= 'ASLA'
                            {
                            lv_instruction_2_1=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_instruction_2_1, grammarAccess.getAslInstructionAccess().getInstructionASLAKeyword_2_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAslInstructionRule());
                              							}
                              							setWithLastConsumed(current, "instruction", lv_instruction_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:723:7: lv_instruction_2_2= 'ASLB'
                            {
                            lv_instruction_2_2=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_instruction_2_2, grammarAccess.getAslInstructionAccess().getInstructionASLBKeyword_2_0_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAslInstructionRule());
                              							}
                              							setWithLastConsumed(current, "instruction", lv_instruction_2_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:737:4: ( ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:737:4: ( ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:738:5: ( (lv_instruction_3_0= 'ASL' ) ) this_WS_4= RULE_WS ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:738:5: ( (lv_instruction_3_0= 'ASL' ) )
                    // InternalAssembler.g:739:6: (lv_instruction_3_0= 'ASL' )
                    {
                    // InternalAssembler.g:739:6: (lv_instruction_3_0= 'ASL' )
                    // InternalAssembler.g:740:7: lv_instruction_3_0= 'ASL'
                    {
                    lv_instruction_3_0=(Token)match(input,20,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_instruction_3_0, grammarAccess.getAslInstructionAccess().getInstructionASLKeyword_2_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getAslInstructionRule());
                      							}
                      							setWithLastConsumed(current, "instruction", lv_instruction_3_0, "ASL");
                      						
                    }

                    }


                    }

                    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_WS_4, grammarAccess.getAslInstructionAccess().getWSTerminalRuleCall_2_1_1());
                      				
                    }
                    // InternalAssembler.g:756:5: ( ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:757:6: ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:757:6: ( (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:758:7: (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:758:7: (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand )
                    int alt13=4;
                    alt13 = dfa13.predict(input);
                    switch (alt13) {
                        case 1 :
                            // InternalAssembler.g:759:8: lv_operand_5_1= ruleDirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAslInstructionAccess().getOperandDirectOperandParserRuleCall_2_1_2_0_0());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_1=ruleDirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAslInstructionRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_1,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.DirectOperand");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalAssembler.g:775:8: lv_operand_5_2= ruleIndexedOperand
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAslInstructionAccess().getOperandIndexedOperandParserRuleCall_2_1_2_0_1());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_2=ruleIndexedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAslInstructionRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_2,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.IndexedOperand");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalAssembler.g:791:8: lv_operand_5_3= ruleExtendedOperand
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAslInstructionAccess().getOperandExtendedOperandParserRuleCall_2_1_2_0_2());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_3=ruleExtendedOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAslInstructionRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_3,
                              									"org.bpy.electronics.mc6809.assembler.Assembler.ExtendedOperand");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }
                            break;
                        case 4 :
                            // InternalAssembler.g:807:8: lv_operand_5_4= ruleExtendedIndirectOperand
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAslInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_2_1_2_0_3());
                              							
                            }
                            pushFollow(FOLLOW_4);
                            lv_operand_5_4=ruleExtendedIndirectOperand();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAslInstructionRule());
                              								}
                              								set(
                              									current,
                              									"operand",
                              									lv_operand_5_4,
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

            // InternalAssembler.g:827:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_WS) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalAssembler.g:828:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getAslInstructionAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:832:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:833:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:833:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:834:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_7_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_7_0, grammarAccess.getAslInstructionAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAslInstructionRule());
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

            // InternalAssembler.g:851:3: (this_WS_8= RULE_WS )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_WS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAssembler.g:852:4: this_WS_8= RULE_WS
                    {
                    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_8, grammarAccess.getAslInstructionAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAslInstructionAccess().getEndOfLineParserRuleCall_5());
              		
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
    // $ANTLR end "ruleAslInstruction"


    // $ANTLR start "entryRuleAndCCInstruction"
    // InternalAssembler.g:868:1: entryRuleAndCCInstruction returns [EObject current=null] : iv_ruleAndCCInstruction= ruleAndCCInstruction EOF ;
    public final EObject entryRuleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndCCInstruction = null;


        try {
            // InternalAssembler.g:868:57: (iv_ruleAndCCInstruction= ruleAndCCInstruction EOF )
            // InternalAssembler.g:869:2: iv_ruleAndCCInstruction= ruleAndCCInstruction EOF
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
    // InternalAssembler.g:875:1: ruleAndCCInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ANDCC' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleImmediatOperand ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_instruction_2_0=null;
        Token this_WS_3=null;
        Token this_WS_5=null;
        Token lv_comment_6_0=null;
        Token this_WS_7=null;
        EObject lv_name_0_0 = null;

        EObject lv_operand_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:881:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ANDCC' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleImmediatOperand ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:882:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ANDCC' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleImmediatOperand ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:882:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ANDCC' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleImmediatOperand ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:883:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ANDCC' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleImmediatOperand ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:883:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAssembler.g:884:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:884:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:885:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAndCCInstructionAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAndCCInstructionRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAndCCInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:906:3: ( (lv_instruction_2_0= 'ANDCC' ) )
            // InternalAssembler.g:907:4: (lv_instruction_2_0= 'ANDCC' )
            {
            // InternalAssembler.g:907:4: (lv_instruction_2_0= 'ANDCC' )
            // InternalAssembler.g:908:5: lv_instruction_2_0= 'ANDCC'
            {
            lv_instruction_2_0=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_instruction_2_0, grammarAccess.getAndCCInstructionAccess().getInstructionANDCCKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAndCCInstructionRule());
              					}
              					setWithLastConsumed(current, "instruction", lv_instruction_2_0, "ANDCC");
              				
            }

            }


            }

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getAndCCInstructionAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:924:3: ( (lv_operand_4_0= ruleImmediatOperand ) )
            // InternalAssembler.g:925:4: (lv_operand_4_0= ruleImmediatOperand )
            {
            // InternalAssembler.g:925:4: (lv_operand_4_0= ruleImmediatOperand )
            // InternalAssembler.g:926:5: lv_operand_4_0= ruleImmediatOperand
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndCCInstructionAccess().getOperandImmediatOperandParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_operand_4_0=ruleImmediatOperand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAndCCInstructionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_4_0,
              						"org.bpy.electronics.mc6809.assembler.Assembler.ImmediatOperand");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAssembler.g:943:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_WS) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // InternalAssembler.g:944:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getAndCCInstructionAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:948:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:949:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:949:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:950:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getAndCCInstructionAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAndCCInstructionRule());
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

            // InternalAssembler.g:967:3: (this_WS_7= RULE_WS )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_WS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAssembler.g:968:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getAndCCInstructionAccess().getWSTerminalRuleCall_6());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndCCInstructionAccess().getEndOfLineParserRuleCall_7());
              		
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
    // $ANTLR end "ruleAndCCInstruction"


    // $ANTLR start "entryRuleAndInstruction"
    // InternalAssembler.g:984:1: entryRuleAndInstruction returns [EObject current=null] : iv_ruleAndInstruction= ruleAndInstruction EOF ;
    public final EObject entryRuleAndInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndInstruction = null;


        try {
            // InternalAssembler.g:984:55: (iv_ruleAndInstruction= ruleAndInstruction EOF )
            // InternalAssembler.g:985:2: iv_ruleAndInstruction= ruleAndInstruction EOF
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
    // InternalAssembler.g:991:1: ruleAndInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleAndInstruction() throws RecognitionException {
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
            // InternalAssembler.g:997:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:998:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:998:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:999:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:999:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1000:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1000:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1001:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAndInstructionAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAndInstructionRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAndInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1022:3: ( ( (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' ) ) )
            // InternalAssembler.g:1023:4: ( (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' ) )
            {
            // InternalAssembler.g:1023:4: ( (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' ) )
            // InternalAssembler.g:1024:5: (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' )
            {
            // InternalAssembler.g:1024:5: (lv_instruction_2_1= 'ANDA' | lv_instruction_2_2= 'ANDB' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==22) ) {
                alt21=1;
            }
            else if ( (LA21_0==23) ) {
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
                    // InternalAssembler.g:1025:6: lv_instruction_2_1= 'ANDA'
                    {
                    lv_instruction_2_1=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_2_1, grammarAccess.getAndInstructionAccess().getInstructionANDAKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAndInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1036:6: lv_instruction_2_2= 'ANDB'
                    {
                    lv_instruction_2_2=(Token)match(input,23,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_2_2, grammarAccess.getAndInstructionAccess().getInstructionANDBKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAndInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_2_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getAndInstructionAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:1053:3: ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1054:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1054:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1055:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1055:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            int alt22=5;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:1056:6: lv_operand_4_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandImmediatOperandParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
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
                    // InternalAssembler.g:1072:6: lv_operand_4_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandDirectOperandParserRuleCall_4_0_1());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
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
                    // InternalAssembler.g:1088:6: lv_operand_4_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandIndexedOperandParserRuleCall_4_0_2());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
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
                    // InternalAssembler.g:1104:6: lv_operand_4_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandExtendedOperandParserRuleCall_4_0_3());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
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
                    // InternalAssembler.g:1120:6: lv_operand_4_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAndInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_4_0_4());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAndInstructionRule());
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

            // InternalAssembler.g:1138:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_WS) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // InternalAssembler.g:1139:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getAndInstructionAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:1143:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1144:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1144:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1145:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getAndInstructionAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAndInstructionRule());
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

            // InternalAssembler.g:1162:3: (this_WS_7= RULE_WS )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_WS) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAssembler.g:1163:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getAndInstructionAccess().getWSTerminalRuleCall_6());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndInstructionAccess().getEndOfLineParserRuleCall_7());
              		
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
    // $ANTLR end "ruleAndInstruction"


    // $ANTLR start "entryRuleAdddInstruction"
    // InternalAssembler.g:1179:1: entryRuleAdddInstruction returns [EObject current=null] : iv_ruleAdddInstruction= ruleAdddInstruction EOF ;
    public final EObject entryRuleAdddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdddInstruction = null;


        try {
            // InternalAssembler.g:1179:56: (iv_ruleAdddInstruction= ruleAdddInstruction EOF )
            // InternalAssembler.g:1180:2: iv_ruleAdddInstruction= ruleAdddInstruction EOF
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
    // InternalAssembler.g:1186:1: ruleAdddInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ADDD' ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleAdddInstruction() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_instruction_2_0=null;
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
            // InternalAssembler.g:1192:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ADDD' ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1193:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ADDD' ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1193:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ADDD' ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1194:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ADDD' ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1194:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAssembler.g:1195:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1195:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1196:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAdddInstructionAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAdddInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1217:3: ( (lv_instruction_2_0= 'ADDD' ) )
            // InternalAssembler.g:1218:4: (lv_instruction_2_0= 'ADDD' )
            {
            // InternalAssembler.g:1218:4: (lv_instruction_2_0= 'ADDD' )
            // InternalAssembler.g:1219:5: lv_instruction_2_0= 'ADDD'
            {
            lv_instruction_2_0=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_instruction_2_0, grammarAccess.getAdddInstructionAccess().getInstructionADDDKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAdddInstructionRule());
              					}
              					setWithLastConsumed(current, "instruction", lv_instruction_2_0, "ADDD");
              				
            }

            }


            }

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getAdddInstructionAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:1235:3: ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1236:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1236:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1237:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1237:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            int alt26=5;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalAssembler.g:1238:6: lv_operand_4_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandImmediatOperandParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
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
                    // InternalAssembler.g:1254:6: lv_operand_4_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandDirectOperandParserRuleCall_4_0_1());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
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
                    // InternalAssembler.g:1270:6: lv_operand_4_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandIndexedOperandParserRuleCall_4_0_2());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
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
                    // InternalAssembler.g:1286:6: lv_operand_4_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandExtendedOperandParserRuleCall_4_0_3());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
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
                    // InternalAssembler.g:1302:6: lv_operand_4_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAdddInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_4_0_4());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAdddInstructionRule());
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

            // InternalAssembler.g:1320:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_WS) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // InternalAssembler.g:1321:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getAdddInstructionAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:1325:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1326:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1326:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1327:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getAdddInstructionAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAdddInstructionRule());
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

            // InternalAssembler.g:1344:3: (this_WS_7= RULE_WS )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_WS) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAssembler.g:1345:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getAdddInstructionAccess().getWSTerminalRuleCall_6());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdddInstructionAccess().getEndOfLineParserRuleCall_7());
              		
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
    // $ANTLR end "ruleAdddInstruction"


    // $ANTLR start "entryRuleAddInstruction"
    // InternalAssembler.g:1361:1: entryRuleAddInstruction returns [EObject current=null] : iv_ruleAddInstruction= ruleAddInstruction EOF ;
    public final EObject entryRuleAddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddInstruction = null;


        try {
            // InternalAssembler.g:1361:55: (iv_ruleAddInstruction= ruleAddInstruction EOF )
            // InternalAssembler.g:1362:2: iv_ruleAddInstruction= ruleAddInstruction EOF
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
    // InternalAssembler.g:1368:1: ruleAddInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleAddInstruction() throws RecognitionException {
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
            // InternalAssembler.g:1374:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1375:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1375:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1376:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1376:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAssembler.g:1377:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1377:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1378:5: lv_name_0_0= ruleIdentifierValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAddInstructionAccess().getNameIdentifierValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAddInstructionRule());
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAddInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1399:3: ( ( (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' ) ) )
            // InternalAssembler.g:1400:4: ( (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' ) )
            {
            // InternalAssembler.g:1400:4: ( (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' ) )
            // InternalAssembler.g:1401:5: (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' )
            {
            // InternalAssembler.g:1401:5: (lv_instruction_2_1= 'ADDA' | lv_instruction_2_2= 'ADDB' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==25) ) {
                alt30=1;
            }
            else if ( (LA30_0==26) ) {
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
                    // InternalAssembler.g:1402:6: lv_instruction_2_1= 'ADDA'
                    {
                    lv_instruction_2_1=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_2_1, grammarAccess.getAddInstructionAccess().getInstructionADDAKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1413:6: lv_instruction_2_2= 'ADDB'
                    {
                    lv_instruction_2_2=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_2_2, grammarAccess.getAddInstructionAccess().getInstructionADDBKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddInstructionRule());
                      						}
                      						setWithLastConsumed(current, "instruction", lv_instruction_2_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getAddInstructionAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:1430:3: ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1431:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1431:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1432:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1432:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            int alt31=5;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // InternalAssembler.g:1433:6: lv_operand_4_1= ruleImmediatOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandImmediatOperandParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_1=ruleImmediatOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
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
                    // InternalAssembler.g:1449:6: lv_operand_4_2= ruleDirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandDirectOperandParserRuleCall_4_0_1());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_2=ruleDirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
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
                    // InternalAssembler.g:1465:6: lv_operand_4_3= ruleIndexedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandIndexedOperandParserRuleCall_4_0_2());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_3=ruleIndexedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
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
                    // InternalAssembler.g:1481:6: lv_operand_4_4= ruleExtendedOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandExtendedOperandParserRuleCall_4_0_3());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_4=ruleExtendedOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
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
                    // InternalAssembler.g:1497:6: lv_operand_4_5= ruleExtendedIndirectOperand
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAddInstructionAccess().getOperandExtendedIndirectOperandParserRuleCall_4_0_4());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_5=ruleExtendedIndirectOperand();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAddInstructionRule());
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

            // InternalAssembler.g:1515:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_WS) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalAssembler.g:1516:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getAddInstructionAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:1520:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1521:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1521:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1522:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getAddInstructionAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddInstructionRule());
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

            // InternalAssembler.g:1539:3: (this_WS_7= RULE_WS )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_WS) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAssembler.g:1540:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getAddInstructionAccess().getWSTerminalRuleCall_6());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAddInstructionAccess().getEndOfLineParserRuleCall_7());
              		
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
    // $ANTLR end "ruleAddInstruction"


    // $ANTLR start "entryRuleAdcInstruction"
    // InternalAssembler.g:1556:1: entryRuleAdcInstruction returns [EObject current=null] : iv_ruleAdcInstruction= ruleAdcInstruction EOF ;
    public final EObject entryRuleAdcInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdcInstruction = null;


        try {
            // InternalAssembler.g:1556:55: (iv_ruleAdcInstruction= ruleAdcInstruction EOF )
            // InternalAssembler.g:1557:2: iv_ruleAdcInstruction= ruleAdcInstruction EOF
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
    // InternalAssembler.g:1563:1: ruleAdcInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1569:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1570:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1570:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1571:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) ) this_WS_3= RULE_WS ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1571:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAssembler.g:1572:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1572:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1573:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1594:3: ( ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) ) )
            // InternalAssembler.g:1595:4: ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) )
            {
            // InternalAssembler.g:1595:4: ( (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' ) )
            // InternalAssembler.g:1596:5: (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' )
            {
            // InternalAssembler.g:1596:5: (lv_instruction_2_1= 'ADCA' | lv_instruction_2_2= 'ADCB' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==27) ) {
                alt35=1;
            }
            else if ( (LA35_0==28) ) {
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
                    // InternalAssembler.g:1597:6: lv_instruction_2_1= 'ADCA'
                    {
                    lv_instruction_2_1=(Token)match(input,27,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1608:6: lv_instruction_2_2= 'ADCB'
                    {
                    lv_instruction_2_2=(Token)match(input,28,FOLLOW_5); if (state.failed) return current;
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

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:1625:3: ( ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1626:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1626:4: ( (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1627:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1627:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )
            int alt36=5;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalAssembler.g:1628:6: lv_operand_4_1= ruleImmediatOperand
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
                    // InternalAssembler.g:1644:6: lv_operand_4_2= ruleDirectOperand
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
                    // InternalAssembler.g:1660:6: lv_operand_4_3= ruleIndexedOperand
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
                    // InternalAssembler.g:1676:6: lv_operand_4_4= ruleExtendedOperand
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
                    // InternalAssembler.g:1692:6: lv_operand_4_5= ruleExtendedIndirectOperand
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

            // InternalAssembler.g:1710:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_WS) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // InternalAssembler.g:1711:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:1715:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1716:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1716:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1717:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1734:3: (this_WS_7= RULE_WS )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_WS) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAssembler.g:1735:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:1751:1: entryRuleAbxInstruction returns [EObject current=null] : iv_ruleAbxInstruction= ruleAbxInstruction EOF ;
    public final EObject entryRuleAbxInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbxInstruction = null;


        try {
            // InternalAssembler.g:1751:55: (iv_ruleAbxInstruction= ruleAbxInstruction EOF )
            // InternalAssembler.g:1752:2: iv_ruleAbxInstruction= ruleAbxInstruction EOF
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
    // InternalAssembler.g:1758:1: ruleAbxInstruction returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1764:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1765:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1765:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1766:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_instruction_2_0= 'ABX' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_5= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1766:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAssembler.g:1767:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1767:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1768:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAbxInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1789:3: ( (lv_instruction_2_0= 'ABX' ) )
            // InternalAssembler.g:1790:4: (lv_instruction_2_0= 'ABX' )
            {
            // InternalAssembler.g:1790:4: (lv_instruction_2_0= 'ABX' )
            // InternalAssembler.g:1791:5: lv_instruction_2_0= 'ABX'
            {
            lv_instruction_2_0=(Token)match(input,29,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1803:3: (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_WS) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // InternalAssembler.g:1804:4: this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getAbxInstructionAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1808:4: ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1809:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1809:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1810:6: lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1827:3: (this_WS_5= RULE_WS )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_WS) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAssembler.g:1828:4: this_WS_5= RULE_WS
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
    // InternalAssembler.g:1844:1: entryRuleExtendedIndirectOperand returns [EObject current=null] : iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF ;
    public final EObject entryRuleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedIndirectOperand = null;


        try {
            // InternalAssembler.g:1844:64: (iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF )
            // InternalAssembler.g:1845:2: iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF
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
    // InternalAssembler.g:1851:1: ruleExtendedIndirectOperand returns [EObject current=null] : (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1857:2: ( (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalAssembler.g:1858:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalAssembler.g:1858:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalAssembler.g:1859:3: otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtendedIndirectOperandAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:1863:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:1864:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:1864:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:1865:5: lv_operand_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtendedIndirectOperandAccess().getOperandExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
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

            otherlv_2=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1890:1: entryRuleExtendedOperand returns [EObject current=null] : iv_ruleExtendedOperand= ruleExtendedOperand EOF ;
    public final EObject entryRuleExtendedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedOperand = null;


        try {
            // InternalAssembler.g:1890:56: (iv_ruleExtendedOperand= ruleExtendedOperand EOF )
            // InternalAssembler.g:1891:2: iv_ruleExtendedOperand= ruleExtendedOperand EOF
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
    // InternalAssembler.g:1897:1: ruleExtendedOperand returns [EObject current=null] : ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExtendedOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1903:2: ( ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:1904:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:1904:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:1905:3: (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) )
            {
            // InternalAssembler.g:1905:3: (otherlv_0= '>' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==32) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalAssembler.g:1906:4: otherlv_0= '>'
                    {
                    otherlv_0=(Token)match(input,32,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getExtendedOperandAccess().getGreaterThanSignKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:1911:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:1912:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:1912:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:1913:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:1934:1: entryRuleDirectOperand returns [EObject current=null] : iv_ruleDirectOperand= ruleDirectOperand EOF ;
    public final EObject entryRuleDirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectOperand = null;


        try {
            // InternalAssembler.g:1934:54: (iv_ruleDirectOperand= ruleDirectOperand EOF )
            // InternalAssembler.g:1935:2: iv_ruleDirectOperand= ruleDirectOperand EOF
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
    // InternalAssembler.g:1941:1: ruleDirectOperand returns [EObject current=null] : (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleDirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1947:2: ( (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:1948:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:1948:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:1949:3: otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectOperandAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalAssembler.g:1953:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:1954:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:1954:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:1955:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:1976:1: entryRuleImmediatOperand returns [EObject current=null] : iv_ruleImmediatOperand= ruleImmediatOperand EOF ;
    public final EObject entryRuleImmediatOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImmediatOperand = null;


        try {
            // InternalAssembler.g:1976:56: (iv_ruleImmediatOperand= ruleImmediatOperand EOF )
            // InternalAssembler.g:1977:2: iv_ruleImmediatOperand= ruleImmediatOperand EOF
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
    // InternalAssembler.g:1983:1: ruleImmediatOperand returns [EObject current=null] : (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleImmediatOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1989:2: ( (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:1990:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:1990:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:1991:3: otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImmediatOperandAccess().getNumberSignKeyword_0());
              		
            }
            // InternalAssembler.g:1995:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:1996:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:1996:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:1997:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:2018:1: entryRuleIndexedOperand returns [EObject current=null] : iv_ruleIndexedOperand= ruleIndexedOperand EOF ;
    public final EObject entryRuleIndexedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedOperand = null;


        try {
            // InternalAssembler.g:2018:55: (iv_ruleIndexedOperand= ruleIndexedOperand EOF )
            // InternalAssembler.g:2019:2: iv_ruleIndexedOperand= ruleIndexedOperand EOF
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
    // InternalAssembler.g:2025:1: ruleIndexedOperand returns [EObject current=null] : ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) ;
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
            // InternalAssembler.g:2031:2: ( ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) )
            // InternalAssembler.g:2032:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            {
            // InternalAssembler.g:2032:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            int alt43=8;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // InternalAssembler.g:2033:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    {
                    // InternalAssembler.g:2033:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    // InternalAssembler.g:2034:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    {
                    // InternalAssembler.g:2034:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    // InternalAssembler.g:2035:5: lv_mode_0_0= ruleAutoIncDecMode
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
                    // InternalAssembler.g:2053:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    {
                    // InternalAssembler.g:2053:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    // InternalAssembler.g:2054:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    {
                    // InternalAssembler.g:2054:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    // InternalAssembler.g:2055:5: lv_mode_1_0= ruleConstantIndexedMode
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
                    // InternalAssembler.g:2073:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    {
                    // InternalAssembler.g:2073:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    // InternalAssembler.g:2074:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    {
                    // InternalAssembler.g:2074:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    // InternalAssembler.g:2075:5: lv_mode_2_0= ruleAccumulatorMovingMode
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
                    // InternalAssembler.g:2093:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    {
                    // InternalAssembler.g:2093:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    // InternalAssembler.g:2094:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    {
                    // InternalAssembler.g:2094:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    // InternalAssembler.g:2095:5: lv_mode_3_0= ruleRelatifToPCMode
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
                    // InternalAssembler.g:2113:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:2113:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    // InternalAssembler.g:2114:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    {
                    // InternalAssembler.g:2114:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    // InternalAssembler.g:2115:5: lv_mode_4_0= ruleConstantIndexedMovingIndirectMode
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
                    // InternalAssembler.g:2133:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    {
                    // InternalAssembler.g:2133:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    // InternalAssembler.g:2134:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    {
                    // InternalAssembler.g:2134:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    // InternalAssembler.g:2135:5: lv_mode_5_0= ruleAutoIncDecIndirectMode
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
                    // InternalAssembler.g:2153:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:2153:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    // InternalAssembler.g:2154:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    {
                    // InternalAssembler.g:2154:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    // InternalAssembler.g:2155:5: lv_mode_6_0= ruleAccumulatorMovingIndirectMode
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
                    // InternalAssembler.g:2173:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    {
                    // InternalAssembler.g:2173:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    // InternalAssembler.g:2174:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    {
                    // InternalAssembler.g:2174:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    // InternalAssembler.g:2175:5: lv_mode_7_0= ruleRelatifToPCIndirectMode
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
    // InternalAssembler.g:2196:1: entryRuleConstantIndexedMode returns [EObject current=null] : iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF ;
    public final EObject entryRuleConstantIndexedMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMode = null;


        try {
            // InternalAssembler.g:2196:60: (iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF )
            // InternalAssembler.g:2197:2: iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF
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
    // InternalAssembler.g:2203:1: ruleConstantIndexedMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:2209:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:2210:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:2210:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:2211:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:2211:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_CHARACTER)||LA44_0==43||LA44_0==45) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAssembler.g:2212:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2212:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:2213:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
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

            otherlv_1=(Token)match(input,35,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstantIndexedModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2234:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:2235:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:2235:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:2236:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:2236:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt45=1;
                }
                break;
            case 37:
                {
                alt45=2;
                }
                break;
            case 38:
                {
                alt45=3;
                }
                break;
            case 39:
                {
                alt45=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalAssembler.g:2237:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2248:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2259:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2270:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2287:1: entryRuleConstantIndexedMovingIndirectMode returns [EObject current=null] : iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF ;
    public final EObject entryRuleConstantIndexedMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMovingIndirectMode = null;


        try {
            // InternalAssembler.g:2287:74: (iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF )
            // InternalAssembler.g:2288:2: iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF
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
    // InternalAssembler.g:2294:1: ruleConstantIndexedMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:2300:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:2301:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:2301:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:2302:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2306:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_CHARACTER)||LA46_0==43||LA46_0==45) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalAssembler.g:2307:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2307:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:2308:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedMovingIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
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

            otherlv_2=(Token)match(input,35,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:2329:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:2330:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:2330:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:2331:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:2331:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt47=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt47=1;
                }
                break;
            case 37:
                {
                alt47=2;
                }
                break;
            case 38:
                {
                alt47=3;
                }
                break;
            case 39:
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
                    // InternalAssembler.g:2332:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
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
                    // InternalAssembler.g:2343:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,37,FOLLOW_19); if (state.failed) return current;
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
                    // InternalAssembler.g:2354:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,38,FOLLOW_19); if (state.failed) return current;
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
                    // InternalAssembler.g:2365:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,39,FOLLOW_19); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2386:1: entryRuleAccumulatorMovingMode returns [EObject current=null] : iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF ;
    public final EObject entryRuleAccumulatorMovingMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingMode = null;


        try {
            // InternalAssembler.g:2386:62: (iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF )
            // InternalAssembler.g:2387:2: iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF
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
    // InternalAssembler.g:2393:1: ruleAccumulatorMovingMode returns [EObject current=null] : ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:2399:2: ( ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:2400:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:2400:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:2401:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:2401:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) )
            // InternalAssembler.g:2402:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            {
            // InternalAssembler.g:2402:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            // InternalAssembler.g:2403:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            {
            // InternalAssembler.g:2403:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt48=1;
                }
                break;
            case 41:
                {
                alt48=2;
                }
                break;
            case 42:
                {
                alt48=3;
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
                    // InternalAssembler.g:2404:6: lv_deplacement_0_1= 'A'
                    {
                    lv_deplacement_0_1=(Token)match(input,40,FOLLOW_20); if (state.failed) return current;
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
                    // InternalAssembler.g:2415:6: lv_deplacement_0_2= 'B'
                    {
                    lv_deplacement_0_2=(Token)match(input,41,FOLLOW_20); if (state.failed) return current;
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
                    // InternalAssembler.g:2426:6: lv_deplacement_0_3= 'D'
                    {
                    lv_deplacement_0_3=(Token)match(input,42,FOLLOW_20); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,35,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAccumulatorMovingModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2443:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:2444:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:2444:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:2445:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:2445:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt49=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt49=1;
                }
                break;
            case 37:
                {
                alt49=2;
                }
                break;
            case 38:
                {
                alt49=3;
                }
                break;
            case 39:
                {
                alt49=4;
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
                    // InternalAssembler.g:2446:6: lv_register_2_1= 'S'
                    {
                    lv_register_2_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2457:6: lv_register_2_2= 'U'
                    {
                    lv_register_2_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2468:6: lv_register_2_3= 'X'
                    {
                    lv_register_2_3=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2479:6: lv_register_2_4= 'Y'
                    {
                    lv_register_2_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2496:1: entryRuleAccumulatorMovingIndirectMode returns [EObject current=null] : iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF ;
    public final EObject entryRuleAccumulatorMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingIndirectMode = null;


        try {
            // InternalAssembler.g:2496:70: (iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF )
            // InternalAssembler.g:2497:2: iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF
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
    // InternalAssembler.g:2503:1: ruleAccumulatorMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:2509:2: ( (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:2510:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:2510:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:2511:3: otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAccumulatorMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2515:3: ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) )
            // InternalAssembler.g:2516:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            {
            // InternalAssembler.g:2516:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            // InternalAssembler.g:2517:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            {
            // InternalAssembler.g:2517:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            int alt50=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt50=1;
                }
                break;
            case 41:
                {
                alt50=2;
                }
                break;
            case 42:
                {
                alt50=3;
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
                    // InternalAssembler.g:2518:6: lv_deplacement_1_1= 'A'
                    {
                    lv_deplacement_1_1=(Token)match(input,40,FOLLOW_20); if (state.failed) return current;
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
                    // InternalAssembler.g:2529:6: lv_deplacement_1_2= 'B'
                    {
                    lv_deplacement_1_2=(Token)match(input,41,FOLLOW_20); if (state.failed) return current;
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
                    // InternalAssembler.g:2540:6: lv_deplacement_1_3= 'D'
                    {
                    lv_deplacement_1_3=(Token)match(input,42,FOLLOW_20); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,35,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAccumulatorMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:2557:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:2558:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:2558:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:2559:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:2559:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt51=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt51=1;
                }
                break;
            case 37:
                {
                alt51=2;
                }
                break;
            case 38:
                {
                alt51=3;
                }
                break;
            case 39:
                {
                alt51=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalAssembler.g:2560:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
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
                    // InternalAssembler.g:2571:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,37,FOLLOW_19); if (state.failed) return current;
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
                    // InternalAssembler.g:2582:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,38,FOLLOW_19); if (state.failed) return current;
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
                    // InternalAssembler.g:2593:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,39,FOLLOW_19); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2614:1: entryRuleAutoIncDecMode returns [EObject current=null] : iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF ;
    public final EObject entryRuleAutoIncDecMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecMode = null;


        try {
            // InternalAssembler.g:2614:55: (iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF )
            // InternalAssembler.g:2615:2: iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF
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
    // InternalAssembler.g:2621:1: ruleAutoIncDecMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) ;
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
            // InternalAssembler.g:2627:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) )
            // InternalAssembler.g:2628:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            {
            // InternalAssembler.g:2628:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            // InternalAssembler.g:2629:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            {
            // InternalAssembler.g:2629:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=RULE_ID && LA52_0<=RULE_CHARACTER)||LA52_0==43||LA52_0==45) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalAssembler.g:2630:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2630:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:2631:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
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

            otherlv_1=(Token)match(input,35,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAutoIncDecModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2652:3: ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=43 && LA57_0<=44)) ) {
                alt57=1;
            }
            else if ( ((LA57_0>=36 && LA57_0<=39)) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalAssembler.g:2653:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:2653:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    // InternalAssembler.g:2654:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:2654:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==43) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==44) ) {
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
                            // InternalAssembler.g:2655:6: ( (lv_decrement_2_0= '-' ) )
                            {
                            // InternalAssembler.g:2655:6: ( (lv_decrement_2_0= '-' ) )
                            // InternalAssembler.g:2656:7: (lv_decrement_2_0= '-' )
                            {
                            // InternalAssembler.g:2656:7: (lv_decrement_2_0= '-' )
                            // InternalAssembler.g:2657:8: lv_decrement_2_0= '-'
                            {
                            lv_decrement_2_0=(Token)match(input,43,FOLLOW_21); if (state.failed) return current;
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
                            // InternalAssembler.g:2670:6: ( (lv_decrement_3_0= '--' ) )
                            {
                            // InternalAssembler.g:2670:6: ( (lv_decrement_3_0= '--' ) )
                            // InternalAssembler.g:2671:7: (lv_decrement_3_0= '--' )
                            {
                            // InternalAssembler.g:2671:7: (lv_decrement_3_0= '--' )
                            // InternalAssembler.g:2672:8: lv_decrement_3_0= '--'
                            {
                            lv_decrement_3_0=(Token)match(input,44,FOLLOW_21); if (state.failed) return current;
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

                    // InternalAssembler.g:2685:5: ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    // InternalAssembler.g:2686:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2686:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    // InternalAssembler.g:2687:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    {
                    // InternalAssembler.g:2687:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    int alt54=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt54=1;
                        }
                        break;
                    case 37:
                        {
                        alt54=2;
                        }
                        break;
                    case 38:
                        {
                        alt54=3;
                        }
                        break;
                    case 39:
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
                            // InternalAssembler.g:2688:8: lv_register_4_1= 'S'
                            {
                            lv_register_4_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2699:8: lv_register_4_2= 'U'
                            {
                            lv_register_4_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2710:8: lv_register_4_3= 'X'
                            {
                            lv_register_4_3=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2721:8: lv_register_4_4= 'Y'
                            {
                            lv_register_4_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:2736:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:2736:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    // InternalAssembler.g:2737:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    {
                    // InternalAssembler.g:2737:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:2738:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2738:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:2739:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:2739:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt55=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt55=1;
                        }
                        break;
                    case 37:
                        {
                        alt55=2;
                        }
                        break;
                    case 38:
                        {
                        alt55=3;
                        }
                        break;
                    case 39:
                        {
                        alt55=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 55, 0, input);

                        throw nvae;
                    }

                    switch (alt55) {
                        case 1 :
                            // InternalAssembler.g:2740:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,36,FOLLOW_25); if (state.failed) return current;
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
                            // InternalAssembler.g:2751:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,37,FOLLOW_25); if (state.failed) return current;
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
                            // InternalAssembler.g:2762:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,38,FOLLOW_25); if (state.failed) return current;
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
                            // InternalAssembler.g:2773:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,39,FOLLOW_25); if (state.failed) return current;
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

                    // InternalAssembler.g:2786:5: ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==45) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==46) ) {
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
                            // InternalAssembler.g:2787:6: ( (lv_increment_6_0= '+' ) )
                            {
                            // InternalAssembler.g:2787:6: ( (lv_increment_6_0= '+' ) )
                            // InternalAssembler.g:2788:7: (lv_increment_6_0= '+' )
                            {
                            // InternalAssembler.g:2788:7: (lv_increment_6_0= '+' )
                            // InternalAssembler.g:2789:8: lv_increment_6_0= '+'
                            {
                            lv_increment_6_0=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:2802:6: ( (lv_increment_7_0= '++' ) )
                            {
                            // InternalAssembler.g:2802:6: ( (lv_increment_7_0= '++' ) )
                            // InternalAssembler.g:2803:7: (lv_increment_7_0= '++' )
                            {
                            // InternalAssembler.g:2803:7: (lv_increment_7_0= '++' )
                            // InternalAssembler.g:2804:8: lv_increment_7_0= '++'
                            {
                            lv_increment_7_0=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2823:1: entryRuleAutoIncDecIndirectMode returns [EObject current=null] : iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF ;
    public final EObject entryRuleAutoIncDecIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecIndirectMode = null;


        try {
            // InternalAssembler.g:2823:63: (iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF )
            // InternalAssembler.g:2824:2: iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF
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
    // InternalAssembler.g:2830:1: ruleAutoIncDecIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) ;
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
            // InternalAssembler.g:2836:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) )
            // InternalAssembler.g:2837:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            {
            // InternalAssembler.g:2837:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            // InternalAssembler.g:2838:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAutoIncDecIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2842:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_ID && LA58_0<=RULE_CHARACTER)||LA58_0==43||LA58_0==45) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAssembler.g:2843:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2843:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:2844:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
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

            otherlv_2=(Token)match(input,35,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAutoIncDecIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:2865:3: ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=43 && LA63_0<=44)) ) {
                alt63=1;
            }
            else if ( ((LA63_0>=36 && LA63_0<=39)) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalAssembler.g:2866:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:2866:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    // InternalAssembler.g:2867:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:2867:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==43) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==44) ) {
                        alt59=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalAssembler.g:2868:6: ( (lv_decrement_3_0= '-' ) )
                            {
                            // InternalAssembler.g:2868:6: ( (lv_decrement_3_0= '-' ) )
                            // InternalAssembler.g:2869:7: (lv_decrement_3_0= '-' )
                            {
                            // InternalAssembler.g:2869:7: (lv_decrement_3_0= '-' )
                            // InternalAssembler.g:2870:8: lv_decrement_3_0= '-'
                            {
                            lv_decrement_3_0=(Token)match(input,43,FOLLOW_21); if (state.failed) return current;
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
                            // InternalAssembler.g:2883:6: ( (lv_decrement_4_0= '--' ) )
                            {
                            // InternalAssembler.g:2883:6: ( (lv_decrement_4_0= '--' ) )
                            // InternalAssembler.g:2884:7: (lv_decrement_4_0= '--' )
                            {
                            // InternalAssembler.g:2884:7: (lv_decrement_4_0= '--' )
                            // InternalAssembler.g:2885:8: lv_decrement_4_0= '--'
                            {
                            lv_decrement_4_0=(Token)match(input,44,FOLLOW_21); if (state.failed) return current;
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

                    // InternalAssembler.g:2898:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:2899:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2899:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:2900:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:2900:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt60=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt60=1;
                        }
                        break;
                    case 37:
                        {
                        alt60=2;
                        }
                        break;
                    case 38:
                        {
                        alt60=3;
                        }
                        break;
                    case 39:
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
                            // InternalAssembler.g:2901:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:2912:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,37,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:2923:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,38,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:2934:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,39,FOLLOW_19); if (state.failed) return current;
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
                    // InternalAssembler.g:2949:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:2949:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    // InternalAssembler.g:2950:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    {
                    // InternalAssembler.g:2950:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) )
                    // InternalAssembler.g:2951:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2951:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    // InternalAssembler.g:2952:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    {
                    // InternalAssembler.g:2952:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    int alt61=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt61=1;
                        }
                        break;
                    case 37:
                        {
                        alt61=2;
                        }
                        break;
                    case 38:
                        {
                        alt61=3;
                        }
                        break;
                    case 39:
                        {
                        alt61=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }

                    switch (alt61) {
                        case 1 :
                            // InternalAssembler.g:2953:8: lv_register_6_1= 'S'
                            {
                            lv_register_6_1=(Token)match(input,36,FOLLOW_25); if (state.failed) return current;
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
                            // InternalAssembler.g:2964:8: lv_register_6_2= 'U'
                            {
                            lv_register_6_2=(Token)match(input,37,FOLLOW_25); if (state.failed) return current;
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
                            // InternalAssembler.g:2975:8: lv_register_6_3= 'X'
                            {
                            lv_register_6_3=(Token)match(input,38,FOLLOW_25); if (state.failed) return current;
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
                            // InternalAssembler.g:2986:8: lv_register_6_4= 'Y'
                            {
                            lv_register_6_4=(Token)match(input,39,FOLLOW_25); if (state.failed) return current;
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

                    // InternalAssembler.g:2999:5: ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==45) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==46) ) {
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
                            // InternalAssembler.g:3000:6: ( (lv_increment_7_0= '+' ) )
                            {
                            // InternalAssembler.g:3000:6: ( (lv_increment_7_0= '+' ) )
                            // InternalAssembler.g:3001:7: (lv_increment_7_0= '+' )
                            {
                            // InternalAssembler.g:3001:7: (lv_increment_7_0= '+' )
                            // InternalAssembler.g:3002:8: lv_increment_7_0= '+'
                            {
                            lv_increment_7_0=(Token)match(input,45,FOLLOW_19); if (state.failed) return current;
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
                            // InternalAssembler.g:3015:6: ( (lv_increment_8_0= '++' ) )
                            {
                            // InternalAssembler.g:3015:6: ( (lv_increment_8_0= '++' ) )
                            // InternalAssembler.g:3016:7: (lv_increment_8_0= '++' )
                            {
                            // InternalAssembler.g:3016:7: (lv_increment_8_0= '++' )
                            // InternalAssembler.g:3017:8: lv_increment_8_0= '++'
                            {
                            lv_increment_8_0=(Token)match(input,46,FOLLOW_19); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3040:1: entryRuleRelatifToPCMode returns [EObject current=null] : iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF ;
    public final EObject entryRuleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCMode = null;


        try {
            // InternalAssembler.g:3040:56: (iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF )
            // InternalAssembler.g:3041:2: iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF
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
    // InternalAssembler.g:3047:1: ruleRelatifToPCMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) ;
    public final EObject ruleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_register_2_0=null;
        EObject lv_deplacement_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3053:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) )
            // InternalAssembler.g:3054:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            {
            // InternalAssembler.g:3054:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            // InternalAssembler.g:3055:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) )
            {
            // InternalAssembler.g:3055:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=RULE_ID && LA64_0<=RULE_CHARACTER)||LA64_0==43||LA64_0==45) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalAssembler.g:3056:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:3056:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:3057:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
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

            otherlv_1=(Token)match(input,35,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelatifToPCModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:3078:3: ( (lv_register_2_0= 'PCR' ) )
            // InternalAssembler.g:3079:4: (lv_register_2_0= 'PCR' )
            {
            // InternalAssembler.g:3079:4: (lv_register_2_0= 'PCR' )
            // InternalAssembler.g:3080:5: lv_register_2_0= 'PCR'
            {
            lv_register_2_0=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3096:1: entryRuleRelatifToPCIndirectMode returns [EObject current=null] : iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF ;
    public final EObject entryRuleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCIndirectMode = null;


        try {
            // InternalAssembler.g:3096:64: (iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF )
            // InternalAssembler.g:3097:2: iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF
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
    // InternalAssembler.g:3103:1: ruleRelatifToPCIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) ;
    public final EObject ruleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_register_3_0=null;
        Token otherlv_4=null;
        EObject lv_deplacement_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3109:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:3110:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:3110:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            // InternalAssembler.g:3111:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRelatifToPCIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:3115:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=RULE_ID && LA65_0<=RULE_CHARACTER)||LA65_0==43||LA65_0==45) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAssembler.g:3116:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:3116:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:3117:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
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

            otherlv_2=(Token)match(input,35,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRelatifToPCIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:3138:3: ( (lv_register_3_0= 'PCR' ) )
            // InternalAssembler.g:3139:4: (lv_register_3_0= 'PCR' )
            {
            // InternalAssembler.g:3139:4: (lv_register_3_0= 'PCR' )
            // InternalAssembler.g:3140:5: lv_register_3_0= 'PCR'
            {
            lv_register_3_0=(Token)match(input,47,FOLLOW_19); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3160:1: entryRuleDirectiveLine returns [EObject current=null] : iv_ruleDirectiveLine= ruleDirectiveLine EOF ;
    public final EObject entryRuleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectiveLine = null;


        try {
            // InternalAssembler.g:3160:54: (iv_ruleDirectiveLine= ruleDirectiveLine EOF )
            // InternalAssembler.g:3161:2: iv_ruleDirectiveLine= ruleDirectiveLine EOF
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
    // InternalAssembler.g:3167:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) ) ;
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
            // InternalAssembler.g:3173:2: ( ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) ) )
            // InternalAssembler.g:3174:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) )
            {
            // InternalAssembler.g:3174:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) )
            int alt66=16;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // InternalAssembler.g:3175:3: ( (lv_directive_0_0= ruleEquDirective ) )
                    {
                    // InternalAssembler.g:3175:3: ( (lv_directive_0_0= ruleEquDirective ) )
                    // InternalAssembler.g:3176:4: (lv_directive_0_0= ruleEquDirective )
                    {
                    // InternalAssembler.g:3176:4: (lv_directive_0_0= ruleEquDirective )
                    // InternalAssembler.g:3177:5: lv_directive_0_0= ruleEquDirective
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
                    // InternalAssembler.g:3195:3: ( (lv_directive_1_0= ruleOrgDirective ) )
                    {
                    // InternalAssembler.g:3195:3: ( (lv_directive_1_0= ruleOrgDirective ) )
                    // InternalAssembler.g:3196:4: (lv_directive_1_0= ruleOrgDirective )
                    {
                    // InternalAssembler.g:3196:4: (lv_directive_1_0= ruleOrgDirective )
                    // InternalAssembler.g:3197:5: lv_directive_1_0= ruleOrgDirective
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
                    // InternalAssembler.g:3215:3: ( (lv_directive_2_0= ruleBszDirective ) )
                    {
                    // InternalAssembler.g:3215:3: ( (lv_directive_2_0= ruleBszDirective ) )
                    // InternalAssembler.g:3216:4: (lv_directive_2_0= ruleBszDirective )
                    {
                    // InternalAssembler.g:3216:4: (lv_directive_2_0= ruleBszDirective )
                    // InternalAssembler.g:3217:5: lv_directive_2_0= ruleBszDirective
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
                    // InternalAssembler.g:3235:3: ( (lv_directive_3_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:3235:3: ( (lv_directive_3_0= ruleEndDirective ) )
                    // InternalAssembler.g:3236:4: (lv_directive_3_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:3236:4: (lv_directive_3_0= ruleEndDirective )
                    // InternalAssembler.g:3237:5: lv_directive_3_0= ruleEndDirective
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
                    // InternalAssembler.g:3255:3: ( (lv_directive_4_0= ruleFailDirective ) )
                    {
                    // InternalAssembler.g:3255:3: ( (lv_directive_4_0= ruleFailDirective ) )
                    // InternalAssembler.g:3256:4: (lv_directive_4_0= ruleFailDirective )
                    {
                    // InternalAssembler.g:3256:4: (lv_directive_4_0= ruleFailDirective )
                    // InternalAssembler.g:3257:5: lv_directive_4_0= ruleFailDirective
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
                    // InternalAssembler.g:3275:3: ( (lv_directive_5_0= ruleFillDirective ) )
                    {
                    // InternalAssembler.g:3275:3: ( (lv_directive_5_0= ruleFillDirective ) )
                    // InternalAssembler.g:3276:4: (lv_directive_5_0= ruleFillDirective )
                    {
                    // InternalAssembler.g:3276:4: (lv_directive_5_0= ruleFillDirective )
                    // InternalAssembler.g:3277:5: lv_directive_5_0= ruleFillDirective
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
                    // InternalAssembler.g:3295:3: ( (lv_directive_6_0= ruleOptDirective ) )
                    {
                    // InternalAssembler.g:3295:3: ( (lv_directive_6_0= ruleOptDirective ) )
                    // InternalAssembler.g:3296:4: (lv_directive_6_0= ruleOptDirective )
                    {
                    // InternalAssembler.g:3296:4: (lv_directive_6_0= ruleOptDirective )
                    // InternalAssembler.g:3297:5: lv_directive_6_0= ruleOptDirective
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
                    // InternalAssembler.g:3315:3: ( (lv_directive_7_0= rulePagDirective ) )
                    {
                    // InternalAssembler.g:3315:3: ( (lv_directive_7_0= rulePagDirective ) )
                    // InternalAssembler.g:3316:4: (lv_directive_7_0= rulePagDirective )
                    {
                    // InternalAssembler.g:3316:4: (lv_directive_7_0= rulePagDirective )
                    // InternalAssembler.g:3317:5: lv_directive_7_0= rulePagDirective
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
                    // InternalAssembler.g:3335:3: ( (lv_directive_8_0= ruleNamDirective ) )
                    {
                    // InternalAssembler.g:3335:3: ( (lv_directive_8_0= ruleNamDirective ) )
                    // InternalAssembler.g:3336:4: (lv_directive_8_0= ruleNamDirective )
                    {
                    // InternalAssembler.g:3336:4: (lv_directive_8_0= ruleNamDirective )
                    // InternalAssembler.g:3337:5: lv_directive_8_0= ruleNamDirective
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
                    // InternalAssembler.g:3355:3: ( (lv_directive_9_0= ruleSetDirective ) )
                    {
                    // InternalAssembler.g:3355:3: ( (lv_directive_9_0= ruleSetDirective ) )
                    // InternalAssembler.g:3356:4: (lv_directive_9_0= ruleSetDirective )
                    {
                    // InternalAssembler.g:3356:4: (lv_directive_9_0= ruleSetDirective )
                    // InternalAssembler.g:3357:5: lv_directive_9_0= ruleSetDirective
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
                    // InternalAssembler.g:3375:3: ( (lv_directive_10_0= ruleSpcDirective ) )
                    {
                    // InternalAssembler.g:3375:3: ( (lv_directive_10_0= ruleSpcDirective ) )
                    // InternalAssembler.g:3376:4: (lv_directive_10_0= ruleSpcDirective )
                    {
                    // InternalAssembler.g:3376:4: (lv_directive_10_0= ruleSpcDirective )
                    // InternalAssembler.g:3377:5: lv_directive_10_0= ruleSpcDirective
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
                    // InternalAssembler.g:3395:3: ( (lv_directive_11_0= ruleRegDirective ) )
                    {
                    // InternalAssembler.g:3395:3: ( (lv_directive_11_0= ruleRegDirective ) )
                    // InternalAssembler.g:3396:4: (lv_directive_11_0= ruleRegDirective )
                    {
                    // InternalAssembler.g:3396:4: (lv_directive_11_0= ruleRegDirective )
                    // InternalAssembler.g:3397:5: lv_directive_11_0= ruleRegDirective
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
                    // InternalAssembler.g:3415:3: ( (lv_directive_12_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:3415:3: ( (lv_directive_12_0= ruleFcbDirective ) )
                    // InternalAssembler.g:3416:4: (lv_directive_12_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:3416:4: (lv_directive_12_0= ruleFcbDirective )
                    // InternalAssembler.g:3417:5: lv_directive_12_0= ruleFcbDirective
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
                    // InternalAssembler.g:3435:3: ( (lv_directive_13_0= ruleFdbDirective ) )
                    {
                    // InternalAssembler.g:3435:3: ( (lv_directive_13_0= ruleFdbDirective ) )
                    // InternalAssembler.g:3436:4: (lv_directive_13_0= ruleFdbDirective )
                    {
                    // InternalAssembler.g:3436:4: (lv_directive_13_0= ruleFdbDirective )
                    // InternalAssembler.g:3437:5: lv_directive_13_0= ruleFdbDirective
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
                    // InternalAssembler.g:3455:3: ( (lv_directive_14_0= ruleFccDirective ) )
                    {
                    // InternalAssembler.g:3455:3: ( (lv_directive_14_0= ruleFccDirective ) )
                    // InternalAssembler.g:3456:4: (lv_directive_14_0= ruleFccDirective )
                    {
                    // InternalAssembler.g:3456:4: (lv_directive_14_0= ruleFccDirective )
                    // InternalAssembler.g:3457:5: lv_directive_14_0= ruleFccDirective
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
                    // InternalAssembler.g:3475:3: ( (lv_directive_15_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:3475:3: ( (lv_directive_15_0= ruleRmbDirective ) )
                    // InternalAssembler.g:3476:4: (lv_directive_15_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:3476:4: (lv_directive_15_0= ruleRmbDirective )
                    // InternalAssembler.g:3477:5: lv_directive_15_0= ruleRmbDirective
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
    // InternalAssembler.g:3498:1: entryRuleFccDirective returns [EObject current=null] : iv_ruleFccDirective= ruleFccDirective EOF ;
    public final EObject entryRuleFccDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFccDirective = null;


        try {
            // InternalAssembler.g:3498:53: (iv_ruleFccDirective= ruleFccDirective EOF )
            // InternalAssembler.g:3499:2: iv_ruleFccDirective= ruleFccDirective EOF
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
    // InternalAssembler.g:3505:1: ruleFccDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:3511:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3512:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3512:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3513:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCC' ) ) (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3513:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAssembler.g:3514:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3514:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3515:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3536:3: ( (lv_directive_2_0= 'FCC' ) )
            // InternalAssembler.g:3537:4: (lv_directive_2_0= 'FCC' )
            {
            // InternalAssembler.g:3537:4: (lv_directive_2_0= 'FCC' )
            // InternalAssembler.g:3538:5: lv_directive_2_0= 'FCC'
            {
            lv_directive_2_0=(Token)match(input,48,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:3550:3: (this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) ) )
            // InternalAssembler.g:3551:4: this_WS_3= RULE_WS ( (lv_string_4_0= RULE_STRING ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_3_0());
              			
            }
            // InternalAssembler.g:3555:4: ( (lv_string_4_0= RULE_STRING ) )
            // InternalAssembler.g:3556:5: (lv_string_4_0= RULE_STRING )
            {
            // InternalAssembler.g:3556:5: (lv_string_4_0= RULE_STRING )
            // InternalAssembler.g:3557:6: lv_string_4_0= RULE_STRING
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

            // InternalAssembler.g:3574:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_WS) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalAssembler.g:3575:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:3579:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3580:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3580:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3581:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:3598:3: (this_WS_7= RULE_WS )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_WS) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAssembler.g:3599:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:3615:1: entryRuleRegDirective returns [EObject current=null] : iv_ruleRegDirective= ruleRegDirective EOF ;
    public final EObject entryRuleRegDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegDirective = null;


        try {
            // InternalAssembler.g:3615:53: (iv_ruleRegDirective= ruleRegDirective EOF )
            // InternalAssembler.g:3616:2: iv_ruleRegDirective= ruleRegDirective EOF
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
    // InternalAssembler.g:3622:1: ruleRegDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:3628:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) )
            // InternalAssembler.g:3629:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            {
            // InternalAssembler.g:3629:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            // InternalAssembler.g:3630:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'REG' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine
            {
            // InternalAssembler.g:3630:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAssembler.g:3631:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3631:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3632:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3653:3: ( (lv_directive_2_0= 'REG' ) )
            // InternalAssembler.g:3654:4: (lv_directive_2_0= 'REG' )
            {
            // InternalAssembler.g:3654:4: (lv_directive_2_0= 'REG' )
            // InternalAssembler.g:3655:5: lv_directive_2_0= 'REG'
            {
            lv_directive_2_0=(Token)match(input,49,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:3667:3: (this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )* )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_WS) ) {
                int LA72_1 = input.LA(2);

                if ( ((LA72_1>=36 && LA72_1<=42)||(LA72_1>=84 && LA72_1<=86)) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalAssembler.g:3668:4: this_WS_3= RULE_WS ( (lv_options_4_0= ruleRegister ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )*
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3672:4: ( (lv_options_4_0= ruleRegister ) )
                    // InternalAssembler.g:3673:5: (lv_options_4_0= ruleRegister )
                    {
                    // InternalAssembler.g:3673:5: (lv_options_4_0= ruleRegister )
                    // InternalAssembler.g:3674:6: lv_options_4_0= ruleRegister
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRegDirectiveAccess().getOptionsRegisterEnumRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
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

                    // InternalAssembler.g:3691:4: (otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==35) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalAssembler.g:3692:5: otherlv_5= ',' ( (lv_options_6_0= ruleRegister ) )
                    	    {
                    	    otherlv_5=(Token)match(input,35,FOLLOW_30); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getRegDirectiveAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:3696:5: ( (lv_options_6_0= ruleRegister ) )
                    	    // InternalAssembler.g:3697:6: (lv_options_6_0= ruleRegister )
                    	    {
                    	    // InternalAssembler.g:3697:6: (lv_options_6_0= ruleRegister )
                    	    // InternalAssembler.g:3698:7: lv_options_6_0= ruleRegister
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRegDirectiveAccess().getOptionsRegisterEnumRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_31);
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
                    	    break loop71;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAssembler.g:3717:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_WS) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalAssembler.g:3718:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:3722:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalAssembler.g:3723:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            {
                            // InternalAssembler.g:3723:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            // InternalAssembler.g:3724:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:3752:1: entryRuleSpcDirective returns [EObject current=null] : iv_ruleSpcDirective= ruleSpcDirective EOF ;
    public final EObject entryRuleSpcDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpcDirective = null;


        try {
            // InternalAssembler.g:3752:53: (iv_ruleSpcDirective= ruleSpcDirective EOF )
            // InternalAssembler.g:3753:2: iv_ruleSpcDirective= ruleSpcDirective EOF
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
    // InternalAssembler.g:3759:1: ruleSpcDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:3765:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:3766:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:3766:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:3767:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SPC' ) ) (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:3767:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalAssembler.g:3768:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3768:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3769:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3790:3: ( (lv_directive_2_0= 'SPC' ) )
            // InternalAssembler.g:3791:4: (lv_directive_2_0= 'SPC' )
            {
            // InternalAssembler.g:3791:4: (lv_directive_2_0= 'SPC' )
            // InternalAssembler.g:3792:5: lv_directive_2_0= 'SPC'
            {
            lv_directive_2_0=(Token)match(input,50,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:3804:3: (this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )? )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_WS) ) {
                int LA77_1 = input.LA(2);

                if ( ((LA77_1>=RULE_ID && LA77_1<=RULE_CHARACTER)||LA77_1==43||LA77_1==45||(LA77_1>=74 && LA77_1<=75)) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // InternalAssembler.g:3805:4: this_WS_3= RULE_WS ( (lv_spaceCount_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )?
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3809:4: ( (lv_spaceCount_4_0= ruleExpression ) )
                    // InternalAssembler.g:3810:5: (lv_spaceCount_4_0= ruleExpression )
                    {
                    // InternalAssembler.g:3810:5: (lv_spaceCount_4_0= ruleExpression )
                    // InternalAssembler.g:3811:6: lv_spaceCount_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSpcDirectiveAccess().getSpaceCountExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
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

                    // InternalAssembler.g:3828:4: (otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==35) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalAssembler.g:3829:5: otherlv_5= ',' ( (lv_keepCount_6_0= ruleExpression ) )
                            {
                            otherlv_5=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getSpcDirectiveAccess().getCommaKeyword_3_2_0());
                              				
                            }
                            // InternalAssembler.g:3833:5: ( (lv_keepCount_6_0= ruleExpression ) )
                            // InternalAssembler.g:3834:6: (lv_keepCount_6_0= ruleExpression )
                            {
                            // InternalAssembler.g:3834:6: (lv_keepCount_6_0= ruleExpression )
                            // InternalAssembler.g:3835:7: lv_keepCount_6_0= ruleExpression
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

            // InternalAssembler.g:3854:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_WS) ) {
                int LA78_1 = input.LA(2);

                if ( (LA78_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // InternalAssembler.g:3855:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:3859:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3860:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3860:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3861:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:3878:3: (this_WS_9= RULE_WS )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_WS) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAssembler.g:3879:4: this_WS_9= RULE_WS
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
    // InternalAssembler.g:3895:1: entryRuleNamDirective returns [EObject current=null] : iv_ruleNamDirective= ruleNamDirective EOF ;
    public final EObject entryRuleNamDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamDirective = null;


        try {
            // InternalAssembler.g:3895:53: (iv_ruleNamDirective= ruleNamDirective EOF )
            // InternalAssembler.g:3896:2: iv_ruleNamDirective= ruleNamDirective EOF
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
    // InternalAssembler.g:3902:1: ruleNamDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:3908:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) )
            // InternalAssembler.g:3909:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:3909:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            // InternalAssembler.g:3910:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine
            {
            // InternalAssembler.g:3910:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAssembler.g:3911:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3911:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:3912:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3933:3: ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==51) ) {
                alt81=1;
            }
            else if ( (LA81_0==52) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalAssembler.g:3934:4: ( (lv_directive_2_0= 'NAM' ) )
                    {
                    // InternalAssembler.g:3934:4: ( (lv_directive_2_0= 'NAM' ) )
                    // InternalAssembler.g:3935:5: (lv_directive_2_0= 'NAM' )
                    {
                    // InternalAssembler.g:3935:5: (lv_directive_2_0= 'NAM' )
                    // InternalAssembler.g:3936:6: lv_directive_2_0= 'NAM'
                    {
                    lv_directive_2_0=(Token)match(input,51,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:3949:4: ( (lv_directive_3_0= 'TTL' ) )
                    {
                    // InternalAssembler.g:3949:4: ( (lv_directive_3_0= 'TTL' ) )
                    // InternalAssembler.g:3950:5: (lv_directive_3_0= 'TTL' )
                    {
                    // InternalAssembler.g:3950:5: (lv_directive_3_0= 'TTL' )
                    // InternalAssembler.g:3951:6: lv_directive_3_0= 'TTL'
                    {
                    lv_directive_3_0=(Token)match(input,52,FOLLOW_5); if (state.failed) return current;
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

            this_WS_4=(Token)match(input,RULE_WS,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_4, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:3968:3: ( (lv_operand_5_0= ruleIdentifierValue ) )
            // InternalAssembler.g:3969:4: (lv_operand_5_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:3969:4: (lv_operand_5_0= ruleIdentifierValue )
            // InternalAssembler.g:3970:5: lv_operand_5_0= ruleIdentifierValue
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

            // InternalAssembler.g:3987:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_WS) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalAssembler.g:3988:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:3992:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3993:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3993:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3994:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:4022:1: entryRulePagDirective returns [EObject current=null] : iv_rulePagDirective= rulePagDirective EOF ;
    public final EObject entryRulePagDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePagDirective = null;


        try {
            // InternalAssembler.g:4022:53: (iv_rulePagDirective= rulePagDirective EOF )
            // InternalAssembler.g:4023:2: iv_rulePagDirective= rulePagDirective EOF
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
    // InternalAssembler.g:4029:1: rulePagDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:4035:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) )
            // InternalAssembler.g:4036:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:4036:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            // InternalAssembler.g:4037:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine
            {
            // InternalAssembler.g:4037:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_ID) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalAssembler.g:4038:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4038:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4039:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4060:3: ( (lv_directive_2_0= 'PAG' ) )
            // InternalAssembler.g:4061:4: (lv_directive_2_0= 'PAG' )
            {
            // InternalAssembler.g:4061:4: (lv_directive_2_0= 'PAG' )
            // InternalAssembler.g:4062:5: lv_directive_2_0= 'PAG'
            {
            lv_directive_2_0=(Token)match(input,53,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:4074:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_WS) ) {
                int LA85_1 = input.LA(2);

                if ( (LA85_1==RULE_WS||(LA85_1>=RULE_ID && LA85_1<=RULE_END_OF_FILE)||LA85_1==43||LA85_1==45||(LA85_1>=74 && LA85_1<=75)) ) {
                    alt85=1;
                }
            }
            switch (alt85) {
                case 1 :
                    // InternalAssembler.g:4075:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )?
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:4079:4: ( (lv_operand_4_0= ruleExpression ) )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( ((LA84_0>=RULE_ID && LA84_0<=RULE_CHARACTER)||LA84_0==43||LA84_0==45||(LA84_0>=74 && LA84_0<=75)) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalAssembler.g:4080:5: (lv_operand_4_0= ruleExpression )
                            {
                            // InternalAssembler.g:4080:5: (lv_operand_4_0= ruleExpression )
                            // InternalAssembler.g:4081:6: lv_operand_4_0= ruleExpression
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

            // InternalAssembler.g:4099:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_WS) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalAssembler.g:4100:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:4104:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:4105:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4105:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4106:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:4134:1: entryRuleOptDirective returns [EObject current=null] : iv_ruleOptDirective= ruleOptDirective EOF ;
    public final EObject entryRuleOptDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptDirective = null;


        try {
            // InternalAssembler.g:4134:53: (iv_ruleOptDirective= ruleOptDirective EOF )
            // InternalAssembler.g:4135:2: iv_ruleOptDirective= ruleOptDirective EOF
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
    // InternalAssembler.g:4141:1: ruleOptDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:4147:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) )
            // InternalAssembler.g:4148:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            {
            // InternalAssembler.g:4148:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            // InternalAssembler.g:4149:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine
            {
            // InternalAssembler.g:4149:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_ID) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalAssembler.g:4150:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4150:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4151:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4172:3: ( (lv_directive_2_0= 'OPT' ) )
            // InternalAssembler.g:4173:4: (lv_directive_2_0= 'OPT' )
            {
            // InternalAssembler.g:4173:4: (lv_directive_2_0= 'OPT' )
            // InternalAssembler.g:4174:5: lv_directive_2_0= 'OPT'
            {
            lv_directive_2_0=(Token)match(input,54,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:4186:3: (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_WS) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==53||(LA89_1>=77 && LA89_1<=83)) ) {
                    alt89=1;
                }
            }
            switch (alt89) {
                case 1 :
                    // InternalAssembler.g:4187:4: this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )*
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:4191:4: ( (lv_options_4_0= ruleAssemblyOption ) )
                    // InternalAssembler.g:4192:5: (lv_options_4_0= ruleAssemblyOption )
                    {
                    // InternalAssembler.g:4192:5: (lv_options_4_0= ruleAssemblyOption )
                    // InternalAssembler.g:4193:6: lv_options_4_0= ruleAssemblyOption
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
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

                    // InternalAssembler.g:4210:4: (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==35) ) {
                            alt88=1;
                        }


                        switch (alt88) {
                    	case 1 :
                    	    // InternalAssembler.g:4211:5: otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) )
                    	    {
                    	    otherlv_5=(Token)match(input,35,FOLLOW_39); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getOptDirectiveAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:4215:5: ( (lv_options_6_0= ruleAssemblyOption ) )
                    	    // InternalAssembler.g:4216:6: (lv_options_6_0= ruleAssemblyOption )
                    	    {
                    	    // InternalAssembler.g:4216:6: (lv_options_6_0= ruleAssemblyOption )
                    	    // InternalAssembler.g:4217:7: lv_options_6_0= ruleAssemblyOption
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_31);
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
                    	    break loop88;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAssembler.g:4236:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_WS) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalAssembler.g:4237:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:4241:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // InternalAssembler.g:4242:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            {
                            // InternalAssembler.g:4242:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            // InternalAssembler.g:4243:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:4271:1: entryRuleFailDirective returns [EObject current=null] : iv_ruleFailDirective= ruleFailDirective EOF ;
    public final EObject entryRuleFailDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailDirective = null;


        try {
            // InternalAssembler.g:4271:54: (iv_ruleFailDirective= ruleFailDirective EOF )
            // InternalAssembler.g:4272:2: iv_ruleFailDirective= ruleFailDirective EOF
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
    // InternalAssembler.g:4278:1: ruleFailDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) ;
    public final EObject ruleFailDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_comment_4_0=null;
        EObject lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4284:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) )
            // InternalAssembler.g:4285:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            {
            // InternalAssembler.g:4285:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            // InternalAssembler.g:4286:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine
            {
            // InternalAssembler.g:4286:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_ID) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalAssembler.g:4287:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4287:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4288:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFailDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4309:3: ( (lv_directive_2_0= 'FAIL' ) )
            // InternalAssembler.g:4310:4: (lv_directive_2_0= 'FAIL' )
            {
            // InternalAssembler.g:4310:4: (lv_directive_2_0= 'FAIL' )
            // InternalAssembler.g:4311:5: lv_directive_2_0= 'FAIL'
            {
            lv_directive_2_0=(Token)match(input,55,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:4323:3: (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_WS) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalAssembler.g:4324:4: this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFailDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:4328:4: ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalAssembler.g:4329:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            {
                            // InternalAssembler.g:4329:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            // InternalAssembler.g:4330:6: lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:4358:1: entryRuleSetDirective returns [EObject current=null] : iv_ruleSetDirective= ruleSetDirective EOF ;
    public final EObject entryRuleSetDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDirective = null;


        try {
            // InternalAssembler.g:4358:53: (iv_ruleSetDirective= ruleSetDirective EOF )
            // InternalAssembler.g:4359:2: iv_ruleSetDirective= ruleSetDirective EOF
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
    // InternalAssembler.g:4365:1: ruleSetDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:4371:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:4372:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:4372:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:4373:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:4373:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_ID) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalAssembler.g:4374:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4374:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4375:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4396:3: ( (lv_directive_2_0= 'SET' ) )
            // InternalAssembler.g:4397:4: (lv_directive_2_0= 'SET' )
            {
            // InternalAssembler.g:4397:4: (lv_directive_2_0= 'SET' )
            // InternalAssembler.g:4398:5: lv_directive_2_0= 'SET'
            {
            lv_directive_2_0=(Token)match(input,56,FOLLOW_5); if (state.failed) return current;
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

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:4414:3: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==57) ) {
                int LA97_1 = input.LA(2);

                if ( ((LA97_1>=RULE_ID && LA97_1<=RULE_CHARACTER)||LA97_1==43||LA97_1==45||(LA97_1>=74 && LA97_1<=75)) ) {
                    alt97=1;
                }
                else if ( ((LA97_1>=RULE_WS && LA97_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA97_1>=RULE_CR && LA97_1<=RULE_END_OF_FILE)) ) {
                    alt97=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA97_0>=RULE_ID && LA97_0<=RULE_CHARACTER)||LA97_0==43||LA97_0==45||(LA97_0>=74 && LA97_0<=75)) ) {
                alt97=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // InternalAssembler.g:4415:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:4415:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:4416:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:4416:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==57) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // InternalAssembler.g:4417:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:4417:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:4418:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_18); if (state.failed) return current;
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

                    // InternalAssembler.g:4430:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:4431:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:4431:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:4432:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetDirectiveAccess().getOperandExpressionParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_32);
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
                    // InternalAssembler.g:4451:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    {
                    // InternalAssembler.g:4451:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    // InternalAssembler.g:4452:5: (lv_isRelativeToPC_6_0= '*' )
                    {
                    // InternalAssembler.g:4452:5: (lv_isRelativeToPC_6_0= '*' )
                    // InternalAssembler.g:4453:6: lv_isRelativeToPC_6_0= '*'
                    {
                    lv_isRelativeToPC_6_0=(Token)match(input,57,FOLLOW_32); if (state.failed) return current;
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

            // InternalAssembler.g:4466:3: (this_WS_7= RULE_WS )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==RULE_WS) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalAssembler.g:4467:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:4472:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalAssembler.g:4473:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4473:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4474:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:4501:1: entryRuleFillDirective returns [EObject current=null] : iv_ruleFillDirective= ruleFillDirective EOF ;
    public final EObject entryRuleFillDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFillDirective = null;


        try {
            // InternalAssembler.g:4501:54: (iv_ruleFillDirective= ruleFillDirective EOF )
            // InternalAssembler.g:4502:2: iv_ruleFillDirective= ruleFillDirective EOF
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
    // InternalAssembler.g:4508:1: ruleFillDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:4514:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:4515:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:4515:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:4516:3: ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:4516:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==RULE_ID) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalAssembler.g:4517:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4517:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4518:5: lv_name_0_0= ruleIdentifierValue
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

            // InternalAssembler.g:4535:3: (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) )
            // InternalAssembler.g:4536:4: this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:4540:4: ( (lv_directive_2_0= 'FILL' ) )
            // InternalAssembler.g:4541:5: (lv_directive_2_0= 'FILL' )
            {
            // InternalAssembler.g:4541:5: (lv_directive_2_0= 'FILL' )
            // InternalAssembler.g:4542:6: lv_directive_2_0= 'FILL'
            {
            lv_directive_2_0=(Token)match(input,58,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:4555:3: (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) )
            // InternalAssembler.g:4556:4: this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_2_0());
              			
            }
            // InternalAssembler.g:4560:4: ( (lv_value_4_0= ruleExpression ) )
            // InternalAssembler.g:4561:5: (lv_value_4_0= ruleExpression )
            {
            // InternalAssembler.g:4561:5: (lv_value_4_0= ruleExpression )
            // InternalAssembler.g:4562:6: lv_value_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getFillDirectiveAccess().getValueExpressionParserRuleCall_2_1_0());
              					
            }
            pushFollow(FOLLOW_20);
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

            otherlv_5=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getFillDirectiveAccess().getCommaKeyword_2_2());
              			
            }
            // InternalAssembler.g:4583:4: ( (lv_number_6_0= ruleExpression ) )
            // InternalAssembler.g:4584:5: (lv_number_6_0= ruleExpression )
            {
            // InternalAssembler.g:4584:5: (lv_number_6_0= ruleExpression )
            // InternalAssembler.g:4585:6: lv_number_6_0= ruleExpression
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

            // InternalAssembler.g:4603:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==RULE_WS) ) {
                int LA101_1 = input.LA(2);

                if ( (LA101_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt101=1;
                }
            }
            switch (alt101) {
                case 1 :
                    // InternalAssembler.g:4604:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:4608:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:4609:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4609:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4610:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:4627:3: (this_WS_9= RULE_WS )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==RULE_WS) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalAssembler.g:4628:4: this_WS_9= RULE_WS
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
    // InternalAssembler.g:4644:1: entryRuleBszDirective returns [EObject current=null] : iv_ruleBszDirective= ruleBszDirective EOF ;
    public final EObject entryRuleBszDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBszDirective = null;


        try {
            // InternalAssembler.g:4644:53: (iv_ruleBszDirective= ruleBszDirective EOF )
            // InternalAssembler.g:4645:2: iv_ruleBszDirective= ruleBszDirective EOF
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
    // InternalAssembler.g:4651:1: ruleBszDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:4657:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:4658:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:4658:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:4659:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:4659:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_ID) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalAssembler.g:4660:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4660:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4661:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4682:3: ( ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) ) )
            // InternalAssembler.g:4683:4: ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) )
            {
            // InternalAssembler.g:4683:4: ( (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' ) )
            // InternalAssembler.g:4684:5: (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' )
            {
            // InternalAssembler.g:4684:5: (lv_directive_2_1= 'BSZ' | lv_directive_2_2= 'ZMB' )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==59) ) {
                alt104=1;
            }
            else if ( (LA104_0==60) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // InternalAssembler.g:4685:6: lv_directive_2_1= 'BSZ'
                    {
                    lv_directive_2_1=(Token)match(input,59,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:4696:6: lv_directive_2_2= 'ZMB'
                    {
                    lv_directive_2_2=(Token)match(input,60,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:4709:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )
            // InternalAssembler.g:4710:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_3_0());
              			
            }
            // InternalAssembler.g:4714:4: ( (lv_operand_4_0= ruleExpression ) )
            // InternalAssembler.g:4715:5: (lv_operand_4_0= ruleExpression )
            {
            // InternalAssembler.g:4715:5: (lv_operand_4_0= ruleExpression )
            // InternalAssembler.g:4716:6: lv_operand_4_0= ruleExpression
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

            // InternalAssembler.g:4734:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_WS) ) {
                int LA105_1 = input.LA(2);

                if ( (LA105_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt105=1;
                }
            }
            switch (alt105) {
                case 1 :
                    // InternalAssembler.g:4735:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:4739:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:4740:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4740:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4741:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:4758:3: (this_WS_7= RULE_WS )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_WS) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalAssembler.g:4759:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:4775:1: entryRuleFdbDirective returns [EObject current=null] : iv_ruleFdbDirective= ruleFdbDirective EOF ;
    public final EObject entryRuleFdbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFdbDirective = null;


        try {
            // InternalAssembler.g:4775:53: (iv_ruleFdbDirective= ruleFdbDirective EOF )
            // InternalAssembler.g:4776:2: iv_ruleFdbDirective= ruleFdbDirective EOF
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
    // InternalAssembler.g:4782:1: ruleFdbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:4788:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:4789:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:4789:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:4790:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:4790:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==RULE_ID) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalAssembler.g:4791:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4791:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4792:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4813:3: ( (lv_directive_2_0= 'FDB' ) )
            // InternalAssembler.g:4814:4: (lv_directive_2_0= 'FDB' )
            {
            // InternalAssembler.g:4814:4: (lv_directive_2_0= 'FDB' )
            // InternalAssembler.g:4815:5: lv_directive_2_0= 'FDB'
            {
            lv_directive_2_0=(Token)match(input,61,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:4827:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==RULE_WS) ) {
                int LA108_1 = input.LA(2);

                if ( ((LA108_1>=RULE_ID && LA108_1<=RULE_CHARACTER)||LA108_1==43||LA108_1==45||(LA108_1>=74 && LA108_1<=75)) ) {
                    alt108=1;
                }
            }
            switch (alt108) {
                case 1 :
                    // InternalAssembler.g:4828:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:4832:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:4833:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:4833:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:4834:6: lv_operand_4_0= ruleListOfExpression
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

            // InternalAssembler.g:4852:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==RULE_WS) ) {
                int LA109_1 = input.LA(2);

                if ( (LA109_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt109=1;
                }
            }
            switch (alt109) {
                case 1 :
                    // InternalAssembler.g:4853:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:4857:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:4858:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4858:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4859:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:4876:3: (this_WS_7= RULE_WS )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==RULE_WS) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalAssembler.g:4877:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:4893:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:4893:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:4894:2: iv_ruleFcbDirective= ruleFcbDirective EOF
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
    // InternalAssembler.g:4900:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:4906:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:4907:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:4907:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:4908:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:4908:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==RULE_ID) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalAssembler.g:4909:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:4909:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:4910:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:4931:3: ( (lv_directive_2_0= 'FCB' ) )
            // InternalAssembler.g:4932:4: (lv_directive_2_0= 'FCB' )
            {
            // InternalAssembler.g:4932:4: (lv_directive_2_0= 'FCB' )
            // InternalAssembler.g:4933:5: lv_directive_2_0= 'FCB'
            {
            lv_directive_2_0=(Token)match(input,62,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:4945:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==RULE_WS) ) {
                int LA112_1 = input.LA(2);

                if ( ((LA112_1>=RULE_ID && LA112_1<=RULE_CHARACTER)||LA112_1==43||LA112_1==45||(LA112_1>=74 && LA112_1<=75)) ) {
                    alt112=1;
                }
            }
            switch (alt112) {
                case 1 :
                    // InternalAssembler.g:4946:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:4950:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:4951:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:4951:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:4952:6: lv_operand_4_0= ruleListOfExpression
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

            // InternalAssembler.g:4970:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==RULE_WS) ) {
                int LA113_1 = input.LA(2);

                if ( (LA113_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt113=1;
                }
            }
            switch (alt113) {
                case 1 :
                    // InternalAssembler.g:4971:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:4975:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:4976:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:4976:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:4977:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:4994:3: (this_WS_7= RULE_WS )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==RULE_WS) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalAssembler.g:4995:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:5011:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:5011:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:5012:2: iv_ruleRmbDirective= ruleRmbDirective EOF
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
    // InternalAssembler.g:5018:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:5024:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:5025:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:5025:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:5026:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:5026:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==RULE_ID) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalAssembler.g:5027:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5027:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:5028:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:5049:3: ( (lv_directive_2_0= 'RMB' ) )
            // InternalAssembler.g:5050:4: (lv_directive_2_0= 'RMB' )
            {
            // InternalAssembler.g:5050:4: (lv_directive_2_0= 'RMB' )
            // InternalAssembler.g:5051:5: lv_directive_2_0= 'RMB'
            {
            lv_directive_2_0=(Token)match(input,63,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:5063:3: (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==RULE_WS) ) {
                int LA117_1 = input.LA(2);

                if ( ((LA117_1>=RULE_ID && LA117_1<=RULE_CHARACTER)||LA117_1==43||LA117_1==45||LA117_1==57||(LA117_1>=74 && LA117_1<=75)) ) {
                    alt117=1;
                }
            }
            switch (alt117) {
                case 1 :
                    // InternalAssembler.g:5064:4: this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:5068:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:5069:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:5069:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==57) ) {
                        alt116=1;
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalAssembler.g:5070:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:5070:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:5071:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_18); if (state.failed) return current;
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

                    // InternalAssembler.g:5083:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:5084:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:5084:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:5085:7: lv_operand_5_0= ruleExpression
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

            // InternalAssembler.g:5104:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==RULE_WS) ) {
                int LA118_1 = input.LA(2);

                if ( (LA118_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt118=1;
                }
            }
            switch (alt118) {
                case 1 :
                    // InternalAssembler.g:5105:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:5109:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:5110:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:5110:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:5111:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:5128:3: (this_WS_8= RULE_WS )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==RULE_WS) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalAssembler.g:5129:4: this_WS_8= RULE_WS
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
    // InternalAssembler.g:5145:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:5145:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:5146:2: iv_ruleEndDirective= ruleEndDirective EOF
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
    // InternalAssembler.g:5152:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:5158:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:5159:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:5159:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:5160:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:5160:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==RULE_ID) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalAssembler.g:5161:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5161:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:5162:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:5183:3: ( (lv_directive_2_0= 'END' ) )
            // InternalAssembler.g:5184:4: (lv_directive_2_0= 'END' )
            {
            // InternalAssembler.g:5184:4: (lv_directive_2_0= 'END' )
            // InternalAssembler.g:5185:5: lv_directive_2_0= 'END'
            {
            lv_directive_2_0=(Token)match(input,64,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:5197:3: (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==RULE_WS) ) {
                int LA123_1 = input.LA(2);

                if ( ((LA123_1>=RULE_ID && LA123_1<=RULE_CHARACTER)||LA123_1==43||LA123_1==45||LA123_1==57||(LA123_1>=74 && LA123_1<=75)) ) {
                    alt123=1;
                }
            }
            switch (alt123) {
                case 1 :
                    // InternalAssembler.g:5198:4: this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:5202:4: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==57) ) {
                        int LA122_1 = input.LA(2);

                        if ( ((LA122_1>=RULE_ID && LA122_1<=RULE_CHARACTER)||LA122_1==43||LA122_1==45||(LA122_1>=74 && LA122_1<=75)) ) {
                            alt122=1;
                        }
                        else if ( (LA122_1==RULE_WS||(LA122_1>=RULE_CR && LA122_1<=RULE_END_OF_FILE)) ) {
                            alt122=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 122, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA122_0>=RULE_ID && LA122_0<=RULE_CHARACTER)||LA122_0==43||LA122_0==45||(LA122_0>=74 && LA122_0<=75)) ) {
                        alt122=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 122, 0, input);

                        throw nvae;
                    }
                    switch (alt122) {
                        case 1 :
                            // InternalAssembler.g:5203:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:5203:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            // InternalAssembler.g:5204:6: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:5204:6: ( (lv_isRelativeToPC_4_0= '*' ) )?
                            int alt121=2;
                            int LA121_0 = input.LA(1);

                            if ( (LA121_0==57) ) {
                                alt121=1;
                            }
                            switch (alt121) {
                                case 1 :
                                    // InternalAssembler.g:5205:7: (lv_isRelativeToPC_4_0= '*' )
                                    {
                                    // InternalAssembler.g:5205:7: (lv_isRelativeToPC_4_0= '*' )
                                    // InternalAssembler.g:5206:8: lv_isRelativeToPC_4_0= '*'
                                    {
                                    lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_18); if (state.failed) return current;
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

                            // InternalAssembler.g:5218:6: ( (lv_operand_5_0= ruleExpression ) )
                            // InternalAssembler.g:5219:7: (lv_operand_5_0= ruleExpression )
                            {
                            // InternalAssembler.g:5219:7: (lv_operand_5_0= ruleExpression )
                            // InternalAssembler.g:5220:8: lv_operand_5_0= ruleExpression
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
                            // InternalAssembler.g:5239:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            {
                            // InternalAssembler.g:5239:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            // InternalAssembler.g:5240:6: (lv_isRelativeToPC_6_0= '*' )
                            {
                            // InternalAssembler.g:5240:6: (lv_isRelativeToPC_6_0= '*' )
                            // InternalAssembler.g:5241:7: lv_isRelativeToPC_6_0= '*'
                            {
                            lv_isRelativeToPC_6_0=(Token)match(input,57,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:5255:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==RULE_WS) ) {
                int LA124_1 = input.LA(2);

                if ( (LA124_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt124=1;
                }
            }
            switch (alt124) {
                case 1 :
                    // InternalAssembler.g:5256:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:5260:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:5261:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:5261:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:5262:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:5279:3: (this_WS_9= RULE_WS )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==RULE_WS) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalAssembler.g:5280:4: this_WS_9= RULE_WS
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
    // InternalAssembler.g:5296:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:5296:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:5297:2: iv_ruleOrgDirective= ruleOrgDirective EOF
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
    // InternalAssembler.g:5303:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:5309:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:5310:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:5310:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:5311:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:5311:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==RULE_ID) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalAssembler.g:5312:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5312:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:5313:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:5334:3: ( (lv_directive_2_0= 'ORG' ) )
            // InternalAssembler.g:5335:4: (lv_directive_2_0= 'ORG' )
            {
            // InternalAssembler.g:5335:4: (lv_directive_2_0= 'ORG' )
            // InternalAssembler.g:5336:5: lv_directive_2_0= 'ORG'
            {
            lv_directive_2_0=(Token)match(input,65,FOLLOW_32); if (state.failed) return current;
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

            // InternalAssembler.g:5348:3: (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==RULE_WS) ) {
                int LA129_1 = input.LA(2);

                if ( ((LA129_1>=RULE_ID && LA129_1<=RULE_CHARACTER)||LA129_1==43||LA129_1==45||LA129_1==57||(LA129_1>=74 && LA129_1<=75)) ) {
                    alt129=1;
                }
            }
            switch (alt129) {
                case 1 :
                    // InternalAssembler.g:5349:4: this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:5353:4: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    int alt128=2;
                    int LA128_0 = input.LA(1);

                    if ( (LA128_0==57) ) {
                        int LA128_1 = input.LA(2);

                        if ( ((LA128_1>=RULE_ID && LA128_1<=RULE_CHARACTER)||LA128_1==43||LA128_1==45||(LA128_1>=74 && LA128_1<=75)) ) {
                            alt128=1;
                        }
                        else if ( ((LA128_1>=RULE_WS && LA128_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA128_1>=RULE_CR && LA128_1<=RULE_END_OF_FILE)) ) {
                            alt128=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 128, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA128_0>=RULE_ID && LA128_0<=RULE_CHARACTER)||LA128_0==43||LA128_0==45||(LA128_0>=74 && LA128_0<=75)) ) {
                        alt128=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 128, 0, input);

                        throw nvae;
                    }
                    switch (alt128) {
                        case 1 :
                            // InternalAssembler.g:5354:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:5354:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            // InternalAssembler.g:5355:6: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:5355:6: ( (lv_isRelativeToPC_4_0= '*' ) )?
                            int alt127=2;
                            int LA127_0 = input.LA(1);

                            if ( (LA127_0==57) ) {
                                alt127=1;
                            }
                            switch (alt127) {
                                case 1 :
                                    // InternalAssembler.g:5356:7: (lv_isRelativeToPC_4_0= '*' )
                                    {
                                    // InternalAssembler.g:5356:7: (lv_isRelativeToPC_4_0= '*' )
                                    // InternalAssembler.g:5357:8: lv_isRelativeToPC_4_0= '*'
                                    {
                                    lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_18); if (state.failed) return current;
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

                            // InternalAssembler.g:5369:6: ( (lv_operand_5_0= ruleExpression ) )
                            // InternalAssembler.g:5370:7: (lv_operand_5_0= ruleExpression )
                            {
                            // InternalAssembler.g:5370:7: (lv_operand_5_0= ruleExpression )
                            // InternalAssembler.g:5371:8: lv_operand_5_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getOrgDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_32);
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
                            // InternalAssembler.g:5390:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            {
                            // InternalAssembler.g:5390:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            // InternalAssembler.g:5391:6: (lv_isRelativeToPC_6_0= '*' )
                            {
                            // InternalAssembler.g:5391:6: (lv_isRelativeToPC_6_0= '*' )
                            // InternalAssembler.g:5392:7: lv_isRelativeToPC_6_0= '*'
                            {
                            lv_isRelativeToPC_6_0=(Token)match(input,57,FOLLOW_32); if (state.failed) return current;
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

            // InternalAssembler.g:5406:3: (this_WS_7= RULE_WS )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==RULE_WS) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalAssembler.g:5407:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:5412:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalAssembler.g:5413:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:5413:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:5414:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:5441:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:5441:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:5442:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:5448:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:5454:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:5455:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:5455:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:5456:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:5456:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==RULE_ID) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // InternalAssembler.g:5457:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5457:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:5458:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:5479:3: ( (lv_directive_2_0= 'EQU' ) )
            // InternalAssembler.g:5480:4: (lv_directive_2_0= 'EQU' )
            {
            // InternalAssembler.g:5480:4: (lv_directive_2_0= 'EQU' )
            // InternalAssembler.g:5481:5: lv_directive_2_0= 'EQU'
            {
            lv_directive_2_0=(Token)match(input,66,FOLLOW_5); if (state.failed) return current;
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

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:5497:3: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==57) ) {
                int LA134_1 = input.LA(2);

                if ( ((LA134_1>=RULE_WS && LA134_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA134_1>=RULE_CR && LA134_1<=RULE_END_OF_FILE)) ) {
                    alt134=2;
                }
                else if ( ((LA134_1>=RULE_ID && LA134_1<=RULE_CHARACTER)||LA134_1==43||LA134_1==45||(LA134_1>=74 && LA134_1<=75)) ) {
                    alt134=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 134, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA134_0>=RULE_ID && LA134_0<=RULE_CHARACTER)||LA134_0==43||LA134_0==45||(LA134_0>=74 && LA134_0<=75)) ) {
                alt134=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }
            switch (alt134) {
                case 1 :
                    // InternalAssembler.g:5498:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:5498:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:5499:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:5499:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt133=2;
                    int LA133_0 = input.LA(1);

                    if ( (LA133_0==57) ) {
                        alt133=1;
                    }
                    switch (alt133) {
                        case 1 :
                            // InternalAssembler.g:5500:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:5500:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:5501:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_18); if (state.failed) return current;
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

                    // InternalAssembler.g:5513:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:5514:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:5514:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:5515:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getEquDirectiveAccess().getOperandExpressionParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_32);
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
                    // InternalAssembler.g:5534:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    {
                    // InternalAssembler.g:5534:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    // InternalAssembler.g:5535:5: (lv_isRelativeToPC_6_0= '*' )
                    {
                    // InternalAssembler.g:5535:5: (lv_isRelativeToPC_6_0= '*' )
                    // InternalAssembler.g:5536:6: lv_isRelativeToPC_6_0= '*'
                    {
                    lv_isRelativeToPC_6_0=(Token)match(input,57,FOLLOW_32); if (state.failed) return current;
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

            // InternalAssembler.g:5549:3: (this_WS_7= RULE_WS )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==RULE_WS) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalAssembler.g:5550:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:5555:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt136=1;
            }
            switch (alt136) {
                case 1 :
                    // InternalAssembler.g:5556:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:5556:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:5557:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:5584:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:5584:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:5585:2: iv_ruleListOfExpression= ruleListOfExpression EOF
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
    // InternalAssembler.g:5591:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5597:2: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalAssembler.g:5598:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalAssembler.g:5598:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalAssembler.g:5599:3: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalAssembler.g:5599:3: ( (lv_expressions_0_0= ruleExpression ) )
            // InternalAssembler.g:5600:4: (lv_expressions_0_0= ruleExpression )
            {
            // InternalAssembler.g:5600:4: (lv_expressions_0_0= ruleExpression )
            // InternalAssembler.g:5601:5: lv_expressions_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_51);
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

            // InternalAssembler.g:5618:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop137:
            do {
                int alt137=2;
                int LA137_0 = input.LA(1);

                if ( (LA137_0==35) ) {
                    alt137=1;
                }


                switch (alt137) {
            	case 1 :
            	    // InternalAssembler.g:5619:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:5623:4: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalAssembler.g:5624:5: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalAssembler.g:5624:5: (lv_expressions_2_0= ruleExpression )
            	    // InternalAssembler.g:5625:6: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_51);
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
            	    break loop137;
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
    // InternalAssembler.g:5647:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:5647:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:5648:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalAssembler.g:5654:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5660:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:5661:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:5661:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:5662:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:5662:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:5663:4: lv_operand_0_0= ruleMultiplication
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
    // InternalAssembler.g:5683:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:5683:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:5684:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:5690:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5696:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:5697:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:5697:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:5698:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_Division_0=ruleDivision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Division_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:5706:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop138:
            do {
                int alt138=2;
                int LA138_0 = input.LA(1);

                if ( (LA138_0==57) ) {
                    alt138=1;
                }


                switch (alt138) {
            	case 1 :
            	    // InternalAssembler.g:5707:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:5707:4: ()
            	    // InternalAssembler.g:5708:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5714:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:5715:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:5715:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:5716:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,57,FOLLOW_18); if (state.failed) return current;
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

            	    // InternalAssembler.g:5728:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:5729:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:5729:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:5730:6: lv_right_3_0= ruleDivision
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_52);
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
            	    break loop138;
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
    // InternalAssembler.g:5752:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:5752:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:5753:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:5759:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5765:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:5766:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:5766:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:5767:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_53);
            this_Modulo_0=ruleModulo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Modulo_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:5775:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop139:
            do {
                int alt139=2;
                int LA139_0 = input.LA(1);

                if ( (LA139_0==67) ) {
                    alt139=1;
                }


                switch (alt139) {
            	case 1 :
            	    // InternalAssembler.g:5776:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:5776:4: ()
            	    // InternalAssembler.g:5777:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5783:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:5784:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:5784:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:5785:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,67,FOLLOW_18); if (state.failed) return current;
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

            	    // InternalAssembler.g:5797:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:5798:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:5798:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:5799:6: lv_right_3_0= ruleModulo
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_53);
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
            	    break loop139;
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
    // InternalAssembler.g:5821:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:5821:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:5822:2: iv_ruleModulo= ruleModulo EOF
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
    // InternalAssembler.g:5828:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5834:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:5835:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:5835:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:5836:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_54);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:5844:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop140:
            do {
                int alt140=2;
                int LA140_0 = input.LA(1);

                if ( (LA140_0==68) ) {
                    alt140=1;
                }


                switch (alt140) {
            	case 1 :
            	    // InternalAssembler.g:5845:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:5845:4: ()
            	    // InternalAssembler.g:5846:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5852:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:5853:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:5853:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:5854:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,68,FOLLOW_18); if (state.failed) return current;
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

            	    // InternalAssembler.g:5866:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:5867:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:5867:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:5868:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
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
            	    break loop140;
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
    // InternalAssembler.g:5890:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:5890:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:5891:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:5897:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5903:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:5904:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:5904:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:5905:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_55);
            this_Substraction_0=ruleSubstraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Substraction_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:5913:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop141:
            do {
                int alt141=2;
                int LA141_0 = input.LA(1);

                if ( (LA141_0==45) ) {
                    alt141=1;
                }


                switch (alt141) {
            	case 1 :
            	    // InternalAssembler.g:5914:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:5914:4: ()
            	    // InternalAssembler.g:5915:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,45,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5925:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:5926:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:5926:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:5927:6: lv_right_3_0= ruleSubstraction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_55);
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
            	    break loop141;
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
    // InternalAssembler.g:5949:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:5949:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:5950:2: iv_ruleSubstraction= ruleSubstraction EOF
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
    // InternalAssembler.g:5956:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:5962:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:5963:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:5963:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:5964:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_56);
            this_LeftShift_0=ruleLeftShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LeftShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:5972:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop142:
            do {
                int alt142=2;
                int LA142_0 = input.LA(1);

                if ( (LA142_0==43) ) {
                    alt142=1;
                }


                switch (alt142) {
            	case 1 :
            	    // InternalAssembler.g:5973:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:5973:4: ()
            	    // InternalAssembler.g:5974:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5980:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:5981:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:5987:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:5988:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:5988:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:5989:6: lv_right_3_0= ruleLeftShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
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
            	    break loop142;
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
    // InternalAssembler.g:6011:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:6011:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:6012:2: iv_ruleLeftShift= ruleLeftShift EOF
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
    // InternalAssembler.g:6018:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6024:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:6025:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:6025:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:6026:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLeftShiftAccess().getRightShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_57);
            this_RightShift_0=ruleRightShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RightShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:6034:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop143:
            do {
                int alt143=2;
                int LA143_0 = input.LA(1);

                if ( (LA143_0==69) ) {
                    alt143=1;
                }


                switch (alt143) {
            	case 1 :
            	    // InternalAssembler.g:6035:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:6035:4: ()
            	    // InternalAssembler.g:6036:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,69,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6046:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:6047:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:6047:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:6048:6: lv_right_3_0= ruleRightShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLeftShiftAccess().getRightRightShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
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
            	    break loop143;
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
    // InternalAssembler.g:6070:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:6070:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:6071:2: iv_ruleRightShift= ruleRightShift EOF
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
    // InternalAssembler.g:6077:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6083:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:6084:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:6084:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:6085:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRightShiftAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_58);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:6093:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop144:
            do {
                int alt144=2;
                int LA144_0 = input.LA(1);

                if ( (LA144_0==70) ) {
                    alt144=1;
                }


                switch (alt144) {
            	case 1 :
            	    // InternalAssembler.g:6094:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:6094:4: ()
            	    // InternalAssembler.g:6095:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,70,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6105:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:6106:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:6106:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:6107:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRightShiftAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_58);
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
            	    break loop144;
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
    // InternalAssembler.g:6129:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:6129:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:6130:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalAssembler.g:6136:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6142:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:6143:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:6143:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:6144:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getOrParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_59);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Or_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:6152:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop145:
            do {
                int alt145=2;
                int LA145_0 = input.LA(1);

                if ( (LA145_0==71) ) {
                    alt145=1;
                }


                switch (alt145) {
            	case 1 :
            	    // InternalAssembler.g:6153:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:6153:4: ()
            	    // InternalAssembler.g:6154:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,71,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6164:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:6165:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:6165:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:6166:6: lv_right_3_0= ruleOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
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
            	    break loop145;
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
    // InternalAssembler.g:6188:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:6188:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:6189:2: iv_ruleOr= ruleOr EOF
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
    // InternalAssembler.g:6195:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6201:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:6202:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:6202:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:6203:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getXorParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_60);
            this_Xor_0=ruleXor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Xor_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:6211:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop146:
            do {
                int alt146=2;
                int LA146_0 = input.LA(1);

                if ( (LA146_0==72) ) {
                    alt146=1;
                }


                switch (alt146) {
            	case 1 :
            	    // InternalAssembler.g:6212:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:6212:4: ()
            	    // InternalAssembler.g:6213:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,72,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6223:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:6224:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:6224:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:6225:6: lv_right_3_0= ruleXor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_60);
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
            	    break loop146;
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
    // InternalAssembler.g:6247:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:6247:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:6248:2: iv_ruleXor= ruleXor EOF
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
    // InternalAssembler.g:6254:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:6260:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:6261:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:6261:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:6262:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_61);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:6270:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop147:
            do {
                int alt147=2;
                int LA147_0 = input.LA(1);

                if ( (LA147_0==73) ) {
                    alt147=1;
                }


                switch (alt147) {
            	case 1 :
            	    // InternalAssembler.g:6271:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:6271:4: ()
            	    // InternalAssembler.g:6272:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,73,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:6282:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:6283:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:6283:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:6284:6: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_61);
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
            	    break loop147;
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
    // InternalAssembler.g:6306:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:6306:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:6307:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:6313:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
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
            // InternalAssembler.g:6319:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:6320:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:6320:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt148=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 43:
            case 45:
                {
                alt148=1;
                }
                break;
            case RULE_HEXA:
                {
                alt148=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt148=3;
                }
                break;
            case RULE_BINARY:
                {
                alt148=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt148=5;
                }
                break;
            case RULE_ID:
                {
                alt148=6;
                }
                break;
            case 74:
                {
                alt148=7;
                }
                break;
            case 75:
                {
                alt148=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }

            switch (alt148) {
                case 1 :
                    // InternalAssembler.g:6321:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:6321:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:6322:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:6322:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:6323:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:6341:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:6341:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:6342:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:6342:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:6343:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:6361:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:6361:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:6362:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:6362:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:6363:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:6381:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:6381:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:6382:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:6382:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:6383:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:6401:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:6401:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:6402:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:6402:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:6403:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:6421:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:6421:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:6422:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:6422:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:6423:5: lv_value_5_0= ruleIdentifierValue
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
                    // InternalAssembler.g:6441:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:6441:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:6442:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:6442:4: ()
                    // InternalAssembler.g:6443:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,74,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:6453:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:6454:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:6454:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:6455:6: lv_value_8_0= rulePrimary
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
                    // InternalAssembler.g:6474:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:6474:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:6475:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,75,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_62);
                    this_Multiplication_10=ruleMultiplication();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Multiplication_10;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_11=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:6496:1: entryRuleNumericalValue returns [EObject current=null] : iv_ruleNumericalValue= ruleNumericalValue EOF ;
    public final EObject entryRuleNumericalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalValue = null;


        try {
            // InternalAssembler.g:6496:55: (iv_ruleNumericalValue= ruleNumericalValue EOF )
            // InternalAssembler.g:6497:2: iv_ruleNumericalValue= ruleNumericalValue EOF
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
    // InternalAssembler.g:6503:1: ruleNumericalValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) ;
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
            // InternalAssembler.g:6509:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:6510:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:6510:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            int alt149=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 43:
            case 45:
                {
                alt149=1;
                }
                break;
            case RULE_HEXA:
                {
                alt149=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt149=3;
                }
                break;
            case RULE_BINARY:
                {
                alt149=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt149=5;
                }
                break;
            case RULE_ID:
                {
                alt149=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;
            }

            switch (alt149) {
                case 1 :
                    // InternalAssembler.g:6511:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:6511:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:6512:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:6512:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:6513:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:6531:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:6531:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:6532:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:6532:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:6533:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:6551:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:6551:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:6552:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:6552:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:6553:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:6571:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:6571:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:6572:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:6572:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:6573:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:6591:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:6591:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:6592:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:6592:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:6593:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:6611:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:6611:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:6612:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:6612:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:6613:5: lv_value_5_0= ruleIdentifierValue
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
    // InternalAssembler.g:6634:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:6634:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:6635:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
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
    // InternalAssembler.g:6641:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6647:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:6648:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:6648:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:6649:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:6649:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:6650:4: lv_value_0_0= RULE_ID
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
    // InternalAssembler.g:6669:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:6669:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:6670:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalAssembler.g:6676:1: ruleDecimalValue returns [EObject current=null] : ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_sign_0_1=null;
        Token lv_sign_0_2=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6682:2: ( ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:6683:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:6683:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:6684:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:6684:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==43||LA151_0==45) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalAssembler.g:6685:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    {
                    // InternalAssembler.g:6685:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    // InternalAssembler.g:6686:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    {
                    // InternalAssembler.g:6686:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    int alt150=2;
                    int LA150_0 = input.LA(1);

                    if ( (LA150_0==43) ) {
                        alt150=1;
                    }
                    else if ( (LA150_0==45) ) {
                        alt150=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 150, 0, input);

                        throw nvae;
                    }
                    switch (alt150) {
                        case 1 :
                            // InternalAssembler.g:6687:6: lv_sign_0_1= '-'
                            {
                            lv_sign_0_1=(Token)match(input,43,FOLLOW_63); if (state.failed) return current;
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
                            // InternalAssembler.g:6698:6: lv_sign_0_2= '+'
                            {
                            lv_sign_0_2=(Token)match(input,45,FOLLOW_63); if (state.failed) return current;
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

            // InternalAssembler.g:6711:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:6712:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:6712:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:6713:5: lv_value_1_0= RULE_INT
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
    // InternalAssembler.g:6733:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:6733:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:6734:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
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
    // InternalAssembler.g:6740:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6746:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:6747:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:6747:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:6748:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:6748:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:6749:4: lv_value_0_0= RULE_HEXA
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
    // InternalAssembler.g:6768:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:6768:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:6769:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:6775:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6781:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:6782:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:6782:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:6783:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:6783:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:6784:4: lv_value_0_0= RULE_OCTAL
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
    // InternalAssembler.g:6803:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:6803:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:6804:2: iv_ruleBinaryValue= ruleBinaryValue EOF
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
    // InternalAssembler.g:6810:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6816:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:6817:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:6817:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:6818:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:6818:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:6819:4: lv_value_0_0= RULE_BINARY
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
    // InternalAssembler.g:6838:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:6838:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:6839:2: iv_ruleCharacterValue= ruleCharacterValue EOF
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
    // InternalAssembler.g:6845:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:6851:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:6852:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:6852:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:6853:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:6853:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:6854:4: lv_value_0_0= RULE_CHARACTER
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
    // InternalAssembler.g:6873:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:6873:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:6874:2: iv_ruleEndOfLine= ruleEndOfLine EOF
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
    // InternalAssembler.g:6880:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:6886:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:6887:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:6887:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==RULE_CR) ) {
                alt152=1;
            }
            else if ( (LA152_0==RULE_END_OF_FILE) ) {
                alt152=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }
            switch (alt152) {
                case 1 :
                    // InternalAssembler.g:6888:3: this_CR_0= RULE_CR
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
                    // InternalAssembler.g:6896:3: this_END_OF_FILE_1= RULE_END_OF_FILE
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
    // InternalAssembler.g:6907:1: ruleAssemblyOption returns [Enumerator current=null] : ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) ;
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
            // InternalAssembler.g:6913:2: ( ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) )
            // InternalAssembler.g:6914:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            {
            // InternalAssembler.g:6914:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            int alt153=8;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt153=1;
                }
                break;
            case 77:
                {
                alt153=2;
                }
                break;
            case 78:
                {
                alt153=3;
                }
                break;
            case 79:
                {
                alt153=4;
                }
                break;
            case 80:
                {
                alt153=5;
                }
                break;
            case 81:
                {
                alt153=6;
                }
                break;
            case 82:
                {
                alt153=7;
                }
                break;
            case 83:
                {
                alt153=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }

            switch (alt153) {
                case 1 :
                    // InternalAssembler.g:6915:3: (enumLiteral_0= 'PAG' )
                    {
                    // InternalAssembler.g:6915:3: (enumLiteral_0= 'PAG' )
                    // InternalAssembler.g:6916:4: enumLiteral_0= 'PAG'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:6923:3: (enumLiteral_1= 'NOP' )
                    {
                    // InternalAssembler.g:6923:3: (enumLiteral_1= 'NOP' )
                    // InternalAssembler.g:6924:4: enumLiteral_1= 'NOP'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:6931:3: (enumLiteral_2= 'CON' )
                    {
                    // InternalAssembler.g:6931:3: (enumLiteral_2= 'CON' )
                    // InternalAssembler.g:6932:4: enumLiteral_2= 'CON'
                    {
                    enumLiteral_2=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:6939:3: (enumLiteral_3= 'NOC' )
                    {
                    // InternalAssembler.g:6939:3: (enumLiteral_3= 'NOC' )
                    // InternalAssembler.g:6940:4: enumLiteral_3= 'NOC'
                    {
                    enumLiteral_3=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:6947:3: (enumLiteral_4= 'MAC' )
                    {
                    // InternalAssembler.g:6947:3: (enumLiteral_4= 'MAC' )
                    // InternalAssembler.g:6948:4: enumLiteral_4= 'MAC'
                    {
                    enumLiteral_4=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:6955:3: (enumLiteral_5= 'NOM' )
                    {
                    // InternalAssembler.g:6955:3: (enumLiteral_5= 'NOM' )
                    // InternalAssembler.g:6956:4: enumLiteral_5= 'NOM'
                    {
                    enumLiteral_5=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:6963:3: (enumLiteral_6= 'EXP' )
                    {
                    // InternalAssembler.g:6963:3: (enumLiteral_6= 'EXP' )
                    // InternalAssembler.g:6964:4: enumLiteral_6= 'EXP'
                    {
                    enumLiteral_6=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:6971:3: (enumLiteral_7= 'NOE' )
                    {
                    // InternalAssembler.g:6971:3: (enumLiteral_7= 'NOE' )
                    // InternalAssembler.g:6972:4: enumLiteral_7= 'NOE'
                    {
                    enumLiteral_7=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:6982:1: ruleRegister returns [Enumerator current=null] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) ;
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
            // InternalAssembler.g:6988:2: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) )
            // InternalAssembler.g:6989:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            {
            // InternalAssembler.g:6989:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            int alt154=10;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt154=1;
                }
                break;
            case 41:
                {
                alt154=2;
                }
                break;
            case 42:
                {
                alt154=3;
                }
                break;
            case 38:
                {
                alt154=4;
                }
                break;
            case 39:
                {
                alt154=5;
                }
                break;
            case 37:
                {
                alt154=6;
                }
                break;
            case 36:
                {
                alt154=7;
                }
                break;
            case 84:
                {
                alt154=8;
                }
                break;
            case 85:
                {
                alt154=9;
                }
                break;
            case 86:
                {
                alt154=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 154, 0, input);

                throw nvae;
            }

            switch (alt154) {
                case 1 :
                    // InternalAssembler.g:6990:3: (enumLiteral_0= 'A' )
                    {
                    // InternalAssembler.g:6990:3: (enumLiteral_0= 'A' )
                    // InternalAssembler.g:6991:4: enumLiteral_0= 'A'
                    {
                    enumLiteral_0=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterAccess().getAEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:6998:3: (enumLiteral_1= 'B' )
                    {
                    // InternalAssembler.g:6998:3: (enumLiteral_1= 'B' )
                    // InternalAssembler.g:6999:4: enumLiteral_1= 'B'
                    {
                    enumLiteral_1=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterAccess().getBEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:7006:3: (enumLiteral_2= 'D' )
                    {
                    // InternalAssembler.g:7006:3: (enumLiteral_2= 'D' )
                    // InternalAssembler.g:7007:4: enumLiteral_2= 'D'
                    {
                    enumLiteral_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRegisterAccess().getDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:7014:3: (enumLiteral_3= 'X' )
                    {
                    // InternalAssembler.g:7014:3: (enumLiteral_3= 'X' )
                    // InternalAssembler.g:7015:4: enumLiteral_3= 'X'
                    {
                    enumLiteral_3=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRegisterAccess().getXEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:7022:3: (enumLiteral_4= 'Y' )
                    {
                    // InternalAssembler.g:7022:3: (enumLiteral_4= 'Y' )
                    // InternalAssembler.g:7023:4: enumLiteral_4= 'Y'
                    {
                    enumLiteral_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRegisterAccess().getYEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:7030:3: (enumLiteral_5= 'U' )
                    {
                    // InternalAssembler.g:7030:3: (enumLiteral_5= 'U' )
                    // InternalAssembler.g:7031:4: enumLiteral_5= 'U'
                    {
                    enumLiteral_5=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRegisterAccess().getUEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:7038:3: (enumLiteral_6= 'S' )
                    {
                    // InternalAssembler.g:7038:3: (enumLiteral_6= 'S' )
                    // InternalAssembler.g:7039:4: enumLiteral_6= 'S'
                    {
                    enumLiteral_6=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getRegisterAccess().getSEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:7046:3: (enumLiteral_7= 'DP' )
                    {
                    // InternalAssembler.g:7046:3: (enumLiteral_7= 'DP' )
                    // InternalAssembler.g:7047:4: enumLiteral_7= 'DP'
                    {
                    enumLiteral_7=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getRegisterAccess().getDPEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:7054:3: (enumLiteral_8= 'CC' )
                    {
                    // InternalAssembler.g:7054:3: (enumLiteral_8= 'CC' )
                    // InternalAssembler.g:7055:4: enumLiteral_8= 'CC'
                    {
                    enumLiteral_8=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getRegisterAccess().getCCEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAssembler.g:7062:3: (enumLiteral_9= 'PC' )
                    {
                    // InternalAssembler.g:7062:3: (enumLiteral_9= 'PC' )
                    // InternalAssembler.g:7063:4: enumLiteral_9= 'PC'
                    {
                    enumLiteral_9=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
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


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA66 dfa66 = new DFA66(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\2\4\1\17\10\uffff";
    static final String dfa_3s = "\1\7\1\4\1\35\10\uffff";
    static final String dfa_4s = "\3\uffff\1\6\1\4\1\5\1\1\1\2\1\3\1\7\1\10";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\2\uffff\1\1",
            "\1\2",
            "\3\12\3\11\1\3\2\5\1\4\2\10\2\7\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "308:2: ( ( (lv_instruction_0_0= ruleAbxInstruction ) ) | ( (lv_instruction_1_0= ruleAdcInstruction ) ) | ( (lv_instruction_2_0= ruleAddInstruction ) ) | ( (lv_instruction_3_0= ruleAdddInstruction ) ) | ( (lv_instruction_4_0= ruleAndInstruction ) ) | ( (lv_instruction_5_0= ruleAndCCInstruction ) ) | ( (lv_instruction_6_0= ruleAslInstruction ) ) | ( (lv_instruction_7_0= ruleAsrInstruction ) ) )";
        }
    }
    static final String dfa_7s = "\26\uffff";
    static final String dfa_8s = "\1\7\1\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\37\1\uffff";
    static final String dfa_9s = "\1\113\1\uffff\2\10\6\111\1\uffff\1\113\1\uffff\2\10\6\111\1\uffff";
    static final String dfa_10s = "\1\uffff\1\1\10\uffff\1\2\1\uffff\1\3\10\uffff\1\4";
    static final String dfa_11s = "\26\uffff}>";
    static final String[] dfa_12s = {
            "\1\11\1\4\1\5\1\6\1\7\1\10\21\uffff\1\13\1\uffff\1\14\1\1\1\uffff\1\12\4\uffff\3\12\1\2\1\uffff\1\3\34\uffff\2\14",
            "",
            "\1\4",
            "\1\4",
            "\1\14\10\uffff\2\14\24\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\24\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\24\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\24\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\24\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "\1\14\10\uffff\2\14\24\uffff\1\12\7\uffff\1\14\1\uffff\1\14\13\uffff\1\14\11\uffff\7\14",
            "",
            "\1\24\1\17\1\20\1\21\1\22\1\23\26\uffff\1\12\4\uffff\3\12\1\15\1\uffff\1\16\34\uffff\2\25",
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

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "560:7: (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "758:7: (lv_operand_5_1= ruleDirectOperand | lv_operand_5_2= ruleIndexedOperand | lv_operand_5_3= ruleExtendedOperand | lv_operand_5_4= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_13s = "\27\uffff";
    static final String dfa_14s = "\1\7\2\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\37\1\uffff";
    static final String dfa_15s = "\1\113\2\uffff\2\10\6\111\1\uffff\1\113\1\uffff\2\10\6\111\1\uffff";
    static final String dfa_16s = "\1\uffff\1\1\1\2\10\uffff\1\3\1\uffff\1\4\10\uffff\1\5";
    static final String dfa_17s = "\27\uffff}>";
    static final String[] dfa_18s = {
            "\1\12\1\5\1\6\1\7\1\10\1\11\21\uffff\1\14\1\uffff\1\15\1\2\1\1\1\13\4\uffff\3\13\1\3\1\uffff\1\4\34\uffff\2\15",
            "",
            "",
            "\1\5",
            "\1\5",
            "\1\15\10\uffff\2\15\24\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\24\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\24\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\24\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\24\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "\1\15\10\uffff\2\15\24\uffff\1\13\7\uffff\1\15\1\uffff\1\15\13\uffff\1\15\11\uffff\7\15",
            "",
            "\1\25\1\20\1\21\1\22\1\23\1\24\26\uffff\1\13\4\uffff\3\13\1\16\1\uffff\1\17\34\uffff\2\26",
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

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "1055:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "1237:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "1432:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "1627:5: (lv_operand_4_1= ruleImmediatOperand | lv_operand_4_2= ruleDirectOperand | lv_operand_4_3= ruleIndexedOperand | lv_operand_4_4= ruleExtendedOperand | lv_operand_4_5= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_19s = "\44\uffff";
    static final String dfa_20s = "\14\uffff\4\34\24\uffff";
    static final String dfa_21s = "\1\7\2\10\6\43\1\44\1\uffff\1\7\4\4\2\uffff\2\10\6\43\1\44\2\uffff\4\37\3\uffff";
    static final String dfa_22s = "\1\55\2\10\6\43\1\57\1\uffff\1\55\4\56\2\uffff\2\10\6\43\1\57\2\uffff\4\56\3\uffff";
    static final String dfa_23s = "\12\uffff\1\3\5\uffff\1\4\1\1\11\uffff\1\7\1\2\4\uffff\1\6\1\10\1\5";
    static final String dfa_24s = "\44\uffff}>";
    static final String[] dfa_25s = {
            "\1\10\1\3\1\4\1\5\1\6\1\7\21\uffff\1\13\4\uffff\1\11\4\uffff\3\12\1\1\1\uffff\1\2",
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
            "\1\31\1\24\1\25\1\26\1\27\1\30\26\uffff\1\32\4\uffff\3\33\1\22\1\uffff\1\23",
            "\1\34\10\uffff\2\34\36\uffff\2\21",
            "\1\34\10\uffff\2\34\36\uffff\2\21",
            "\1\34\10\uffff\2\34\36\uffff\2\21",
            "\1\34\10\uffff\2\34\36\uffff\2\21",
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
            "\1\35\1\36\1\37\1\40\3\uffff\2\41\2\uffff\1\42",
            "",
            "",
            "\1\43\15\uffff\2\41",
            "\1\43\15\uffff\2\41",
            "\1\43\15\uffff\2\41",
            "\1\43\15\uffff\2\41",
            "",
            "",
            ""
    };

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = dfa_19;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "2032:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )";
        }
    }
    static final String dfa_26s = "\23\uffff";
    static final String dfa_27s = "\2\4\1\60\20\uffff";
    static final String dfa_28s = "\1\7\1\4\1\102\20\uffff";
    static final String dfa_29s = "\3\uffff\1\12\1\1\1\11\1\14\1\20\1\2\1\10\1\7\1\17\1\4\1\16\1\13\1\5\1\6\1\3\1\15";
    static final String dfa_30s = "\23\uffff}>";
    static final String[] dfa_31s = {
            "\1\2\2\uffff\1\1",
            "\1\2",
            "\1\13\1\6\1\16\2\5\1\11\1\12\1\17\1\3\1\uffff\1\20\2\21\1\15\1\22\1\7\1\14\1\10\1\4",
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

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "3174:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleSpcDirective ) ) | ( (lv_directive_11_0= ruleRegDirective ) ) | ( (lv_directive_12_0= ruleFcbDirective ) ) | ( (lv_directive_13_0= ruleFdbDirective ) ) | ( (lv_directive_14_0= ruleFccDirective ) ) | ( (lv_directive_15_0= ruleRmbDirective ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000060B2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00002F0B40001F80L,0x0000000000000C00L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00002F0F40001F80L,0x0000000000000C00L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000280100001F80L,0x0000000000000C00L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000F000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000280800001F80L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000070000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000018F000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000007F000000000L,0x0000000000700000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800006010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000006030L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000280100007F90L,0x0000000000000C00L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0020000000000000L,0x00000000000FE000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0200280100001F80L,0x0000000000000C00L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x1800000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000100L});

}
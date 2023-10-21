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

                    if ( ((LA2_7>=48 && LA2_7<=56)||(LA2_7>=58 && LA2_7<=66)) ) {
                        alt2=3;
                    }
                    else if ( ((LA2_7>=15 && LA2_7<=29)) ) {
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
    // InternalAssembler.g:301:1: ruleInstructionLine returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) ) (this_WS_10= RULE_WS ( (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_12= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleInstructionLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_WS_10=null;
        Token lv_comment_11_0=null;
        Token this_WS_12=null;
        EObject lv_name_0_0 = null;

        EObject lv_instruction_2_0 = null;

        EObject lv_instruction_3_0 = null;

        EObject lv_instruction_4_0 = null;

        EObject lv_instruction_5_0 = null;

        EObject lv_instruction_6_0 = null;

        EObject lv_instruction_7_0 = null;

        EObject lv_instruction_8_0 = null;

        EObject lv_instruction_9_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:307:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) ) (this_WS_10= RULE_WS ( (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_12= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) ) (this_WS_10= RULE_WS ( (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_12= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:308:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) ) (this_WS_10= RULE_WS ( (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_12= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:309:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) ) (this_WS_10= RULE_WS ( (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_12= RULE_WS )? ruleEndOfLine
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
            // InternalAssembler.g:332:3: ( ( (lv_instruction_2_0= ruleAbxInstruction ) ) | ( (lv_instruction_3_0= ruleAdcInstruction ) ) | ( (lv_instruction_4_0= ruleAddInstruction ) ) | ( (lv_instruction_5_0= ruleAdddInstruction ) ) | ( (lv_instruction_6_0= ruleAndInstruction ) ) | ( (lv_instruction_7_0= ruleAndCCInstruction ) ) | ( (lv_instruction_8_0= ruleAslInstruction ) ) | ( (lv_instruction_9_0= ruleAsrInstruction ) ) )
            int alt5=8;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt5=1;
                }
                break;
            case 27:
            case 28:
                {
                alt5=2;
                }
                break;
            case 25:
            case 26:
                {
                alt5=3;
                }
                break;
            case 24:
                {
                alt5=4;
                }
                break;
            case 22:
            case 23:
                {
                alt5=5;
                }
                break;
            case 21:
                {
                alt5=6;
                }
                break;
            case 18:
            case 19:
            case 20:
                {
                alt5=7;
                }
                break;
            case 15:
            case 16:
            case 17:
                {
                alt5=8;
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

            }

            // InternalAssembler.g:493:3: (this_WS_10= RULE_WS ( (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:494:4: this_WS_10= RULE_WS ( (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_10=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_10, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:498:4: ( (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:499:5: (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:499:5: (lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:500:6: lv_comment_11_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_11_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_11_0, grammarAccess.getInstructionLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getInstructionLineRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"comment",
                      							lv_comment_11_0,
                      							"org.bpy.electronics.mc6809.assembler.Assembler.ANY_EXCEPT_COMMENT_END_OF_LINE");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAssembler.g:517:3: (this_WS_12= RULE_WS )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:518:4: this_WS_12= RULE_WS
                    {
                    this_WS_12=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_12, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_4());
                      			
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


    // $ANTLR start "entryRuleAsrInstruction"
    // InternalAssembler.g:534:1: entryRuleAsrInstruction returns [EObject current=null] : iv_ruleAsrInstruction= ruleAsrInstruction EOF ;
    public final EObject entryRuleAsrInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsrInstruction = null;


        try {
            // InternalAssembler.g:534:55: (iv_ruleAsrInstruction= ruleAsrInstruction EOF )
            // InternalAssembler.g:535:2: iv_ruleAsrInstruction= ruleAsrInstruction EOF
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
    // InternalAssembler.g:541:1: ruleAsrInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
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
            // InternalAssembler.g:547:2: ( ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:548:2: ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:548:2: ( ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) ) | ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
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
                    // InternalAssembler.g:549:3: ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) )
                    {
                    // InternalAssembler.g:549:3: ( ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) ) )
                    // InternalAssembler.g:550:4: ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) )
                    {
                    // InternalAssembler.g:550:4: ( (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' ) )
                    // InternalAssembler.g:551:5: (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' )
                    {
                    // InternalAssembler.g:551:5: (lv_instruction_0_1= 'ASRA' | lv_instruction_0_2= 'ASRB' )
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
                            // InternalAssembler.g:552:6: lv_instruction_0_1= 'ASRA'
                            {
                            lv_instruction_0_1=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:563:6: lv_instruction_0_2= 'ASRB'
                            {
                            lv_instruction_0_2=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:577:3: ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:577:3: ( ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:578:4: ( (lv_instruction_1_0= 'ASR' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:578:4: ( (lv_instruction_1_0= 'ASR' ) )
                    // InternalAssembler.g:579:5: (lv_instruction_1_0= 'ASR' )
                    {
                    // InternalAssembler.g:579:5: (lv_instruction_1_0= 'ASR' )
                    // InternalAssembler.g:580:6: lv_instruction_1_0= 'ASR'
                    {
                    lv_instruction_1_0=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:596:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:597:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:597:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:598:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:598:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt9=4;
                    alt9 = dfa9.predict(input);
                    switch (alt9) {
                        case 1 :
                            // InternalAssembler.g:599:7: lv_operand_3_1= ruleDirectOperand
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
                            // InternalAssembler.g:615:7: lv_operand_3_2= ruleIndexedOperand
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
                            // InternalAssembler.g:631:7: lv_operand_3_3= ruleExtendedOperand
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
                            // InternalAssembler.g:647:7: lv_operand_3_4= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:677:1: ruleAslInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) ;
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
            // InternalAssembler.g:683:2: ( ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) ) )
            // InternalAssembler.g:684:2: ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            {
            // InternalAssembler.g:684:2: ( ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) ) | ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=18 && LA13_0<=19)) ) {
                alt13=1;
            }
            else if ( (LA13_0==20) ) {
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
                    // InternalAssembler.g:685:3: ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) )
                    {
                    // InternalAssembler.g:685:3: ( ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) ) )
                    // InternalAssembler.g:686:4: ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) )
                    {
                    // InternalAssembler.g:686:4: ( (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' ) )
                    // InternalAssembler.g:687:5: (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' )
                    {
                    // InternalAssembler.g:687:5: (lv_instruction_0_1= 'ASLA' | lv_instruction_0_2= 'ASLB' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==18) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==19) ) {
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
                            // InternalAssembler.g:688:6: lv_instruction_0_1= 'ASLA'
                            {
                            lv_instruction_0_1=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
                            // InternalAssembler.g:699:6: lv_instruction_0_2= 'ASLB'
                            {
                            lv_instruction_0_2=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
                    // InternalAssembler.g:713:3: ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    {
                    // InternalAssembler.g:713:3: ( ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) ) )
                    // InternalAssembler.g:714:4: ( (lv_instruction_1_0= 'ASL' ) ) this_WS_2= RULE_WS ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    {
                    // InternalAssembler.g:714:4: ( (lv_instruction_1_0= 'ASL' ) )
                    // InternalAssembler.g:715:5: (lv_instruction_1_0= 'ASL' )
                    {
                    // InternalAssembler.g:715:5: (lv_instruction_1_0= 'ASL' )
                    // InternalAssembler.g:716:6: lv_instruction_1_0= 'ASL'
                    {
                    lv_instruction_1_0=(Token)match(input,20,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:732:4: ( ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) ) )
                    // InternalAssembler.g:733:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    {
                    // InternalAssembler.g:733:5: ( (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand ) )
                    // InternalAssembler.g:734:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    {
                    // InternalAssembler.g:734:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )
                    int alt12=4;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // InternalAssembler.g:735:7: lv_operand_3_1= ruleDirectOperand
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
                            // InternalAssembler.g:751:7: lv_operand_3_2= ruleIndexedOperand
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
                            // InternalAssembler.g:767:7: lv_operand_3_3= ruleExtendedOperand
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
                            // InternalAssembler.g:783:7: lv_operand_3_4= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:806:1: entryRuleAndCCInstruction returns [EObject current=null] : iv_ruleAndCCInstruction= ruleAndCCInstruction EOF ;
    public final EObject entryRuleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndCCInstruction = null;


        try {
            // InternalAssembler.g:806:57: (iv_ruleAndCCInstruction= ruleAndCCInstruction EOF )
            // InternalAssembler.g:807:2: iv_ruleAndCCInstruction= ruleAndCCInstruction EOF
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
    // InternalAssembler.g:813:1: ruleAndCCInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) ;
    public final EObject ruleAndCCInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:819:2: ( ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) ) )
            // InternalAssembler.g:820:2: ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            {
            // InternalAssembler.g:820:2: ( ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) ) )
            // InternalAssembler.g:821:3: ( (lv_instruction_0_0= 'ANDCC' ) ) this_WS_1= RULE_WS ( (lv_operand_2_0= ruleImmediatOperand ) )
            {
            // InternalAssembler.g:821:3: ( (lv_instruction_0_0= 'ANDCC' ) )
            // InternalAssembler.g:822:4: (lv_instruction_0_0= 'ANDCC' )
            {
            // InternalAssembler.g:822:4: (lv_instruction_0_0= 'ANDCC' )
            // InternalAssembler.g:823:5: lv_instruction_0_0= 'ANDCC'
            {
            lv_instruction_0_0=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAndCCInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:839:3: ( (lv_operand_2_0= ruleImmediatOperand ) )
            // InternalAssembler.g:840:4: (lv_operand_2_0= ruleImmediatOperand )
            {
            // InternalAssembler.g:840:4: (lv_operand_2_0= ruleImmediatOperand )
            // InternalAssembler.g:841:5: lv_operand_2_0= ruleImmediatOperand
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
    // InternalAssembler.g:862:1: entryRuleAndInstruction returns [EObject current=null] : iv_ruleAndInstruction= ruleAndInstruction EOF ;
    public final EObject entryRuleAndInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndInstruction = null;


        try {
            // InternalAssembler.g:862:55: (iv_ruleAndInstruction= ruleAndInstruction EOF )
            // InternalAssembler.g:863:2: iv_ruleAndInstruction= ruleAndInstruction EOF
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
    // InternalAssembler.g:869:1: ruleAndInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:875:2: ( ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:876:2: ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:876:2: ( ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:877:3: ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:877:3: ( ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) ) )
            // InternalAssembler.g:878:4: ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) )
            {
            // InternalAssembler.g:878:4: ( (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' ) )
            // InternalAssembler.g:879:5: (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' )
            {
            // InternalAssembler.g:879:5: (lv_instruction_0_1= 'ANDA' | lv_instruction_0_2= 'ANDB' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            else if ( (LA14_0==23) ) {
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
                    // InternalAssembler.g:880:6: lv_instruction_0_1= 'ANDA'
                    {
                    lv_instruction_0_1=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:891:6: lv_instruction_0_2= 'ANDB'
                    {
                    lv_instruction_0_2=(Token)match(input,23,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAndInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:908:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:909:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:909:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:910:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:910:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt15=5;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalAssembler.g:911:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:927:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:943:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:959:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:975:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:997:1: entryRuleAdddInstruction returns [EObject current=null] : iv_ruleAdddInstruction= ruleAdddInstruction EOF ;
    public final EObject entryRuleAdddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdddInstruction = null;


        try {
            // InternalAssembler.g:997:56: (iv_ruleAdddInstruction= ruleAdddInstruction EOF )
            // InternalAssembler.g:998:2: iv_ruleAdddInstruction= ruleAdddInstruction EOF
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
    // InternalAssembler.g:1004:1: ruleAdddInstruction returns [EObject current=null] : ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:1010:2: ( ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1011:2: ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1011:2: ( ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1012:3: ( (lv_instruction_0_0= 'ADDD' ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1012:3: ( (lv_instruction_0_0= 'ADDD' ) )
            // InternalAssembler.g:1013:4: (lv_instruction_0_0= 'ADDD' )
            {
            // InternalAssembler.g:1013:4: (lv_instruction_0_0= 'ADDD' )
            // InternalAssembler.g:1014:5: lv_instruction_0_0= 'ADDD'
            {
            lv_instruction_0_0=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAdddInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1030:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1031:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1031:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1032:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1032:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt16=5;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalAssembler.g:1033:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:1049:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:1065:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:1081:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:1097:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1119:1: entryRuleAddInstruction returns [EObject current=null] : iv_ruleAddInstruction= ruleAddInstruction EOF ;
    public final EObject entryRuleAddInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddInstruction = null;


        try {
            // InternalAssembler.g:1119:55: (iv_ruleAddInstruction= ruleAddInstruction EOF )
            // InternalAssembler.g:1120:2: iv_ruleAddInstruction= ruleAddInstruction EOF
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
    // InternalAssembler.g:1126:1: ruleAddInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:1132:2: ( ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1133:2: ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1133:2: ( ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1134:3: ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1134:3: ( ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) ) )
            // InternalAssembler.g:1135:4: ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) )
            {
            // InternalAssembler.g:1135:4: ( (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' ) )
            // InternalAssembler.g:1136:5: (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' )
            {
            // InternalAssembler.g:1136:5: (lv_instruction_0_1= 'ADDA' | lv_instruction_0_2= 'ADDB' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            else if ( (LA17_0==26) ) {
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
                    // InternalAssembler.g:1137:6: lv_instruction_0_1= 'ADDA'
                    {
                    lv_instruction_0_1=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1148:6: lv_instruction_0_2= 'ADDB'
                    {
                    lv_instruction_0_2=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAddInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1165:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1166:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1166:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1167:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1167:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt18=5;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalAssembler.g:1168:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:1184:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:1200:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:1216:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:1232:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1254:1: entryRuleAdcInstruction returns [EObject current=null] : iv_ruleAdcInstruction= ruleAdcInstruction EOF ;
    public final EObject entryRuleAdcInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdcInstruction = null;


        try {
            // InternalAssembler.g:1254:55: (iv_ruleAdcInstruction= ruleAdcInstruction EOF )
            // InternalAssembler.g:1255:2: iv_ruleAdcInstruction= ruleAdcInstruction EOF
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
    // InternalAssembler.g:1261:1: ruleAdcInstruction returns [EObject current=null] : ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) ;
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
            // InternalAssembler.g:1267:2: ( ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) ) )
            // InternalAssembler.g:1268:2: ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            {
            // InternalAssembler.g:1268:2: ( ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) ) )
            // InternalAssembler.g:1269:3: ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) ) this_WS_1= RULE_WS ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            {
            // InternalAssembler.g:1269:3: ( ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) ) )
            // InternalAssembler.g:1270:4: ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) )
            {
            // InternalAssembler.g:1270:4: ( (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' ) )
            // InternalAssembler.g:1271:5: (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' )
            {
            // InternalAssembler.g:1271:5: (lv_instruction_0_1= 'ADCA' | lv_instruction_0_2= 'ADCB' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            else if ( (LA19_0==28) ) {
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
                    // InternalAssembler.g:1272:6: lv_instruction_0_1= 'ADCA'
                    {
                    lv_instruction_0_1=(Token)match(input,27,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:1283:6: lv_instruction_0_2= 'ADCB'
                    {
                    lv_instruction_0_2=(Token)match(input,28,FOLLOW_5); if (state.failed) return current;
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getAdcInstructionAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1300:3: ( ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) ) )
            // InternalAssembler.g:1301:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            {
            // InternalAssembler.g:1301:4: ( (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand ) )
            // InternalAssembler.g:1302:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            {
            // InternalAssembler.g:1302:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )
            int alt20=5;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1303:6: lv_operand_2_1= ruleImmediatOperand
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
                    // InternalAssembler.g:1319:6: lv_operand_2_2= ruleDirectOperand
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
                    // InternalAssembler.g:1335:6: lv_operand_2_3= ruleIndexedOperand
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
                    // InternalAssembler.g:1351:6: lv_operand_2_4= ruleExtendedOperand
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
                    // InternalAssembler.g:1367:6: lv_operand_2_5= ruleExtendedIndirectOperand
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
    // InternalAssembler.g:1389:1: entryRuleAbxInstruction returns [EObject current=null] : iv_ruleAbxInstruction= ruleAbxInstruction EOF ;
    public final EObject entryRuleAbxInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbxInstruction = null;


        try {
            // InternalAssembler.g:1389:55: (iv_ruleAbxInstruction= ruleAbxInstruction EOF )
            // InternalAssembler.g:1390:2: iv_ruleAbxInstruction= ruleAbxInstruction EOF
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
    // InternalAssembler.g:1396:1: ruleAbxInstruction returns [EObject current=null] : ( (lv_instruction_0_0= 'ABX' ) ) ;
    public final EObject ruleAbxInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_instruction_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1402:2: ( ( (lv_instruction_0_0= 'ABX' ) ) )
            // InternalAssembler.g:1403:2: ( (lv_instruction_0_0= 'ABX' ) )
            {
            // InternalAssembler.g:1403:2: ( (lv_instruction_0_0= 'ABX' ) )
            // InternalAssembler.g:1404:3: (lv_instruction_0_0= 'ABX' )
            {
            // InternalAssembler.g:1404:3: (lv_instruction_0_0= 'ABX' )
            // InternalAssembler.g:1405:4: lv_instruction_0_0= 'ABX'
            {
            lv_instruction_0_0=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1420:1: entryRuleExtendedIndirectOperand returns [EObject current=null] : iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF ;
    public final EObject entryRuleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedIndirectOperand = null;


        try {
            // InternalAssembler.g:1420:64: (iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF )
            // InternalAssembler.g:1421:2: iv_ruleExtendedIndirectOperand= ruleExtendedIndirectOperand EOF
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
    // InternalAssembler.g:1427:1: ruleExtendedIndirectOperand returns [EObject current=null] : (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleExtendedIndirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1433:2: ( (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalAssembler.g:1434:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalAssembler.g:1434:2: (otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalAssembler.g:1435:3: otherlv_0= '[' ( (lv_operand_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtendedIndirectOperandAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:1439:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:1440:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:1440:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:1441:5: lv_operand_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtendedIndirectOperandAccess().getOperandExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_12);
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
    // InternalAssembler.g:1466:1: entryRuleExtendedOperand returns [EObject current=null] : iv_ruleExtendedOperand= ruleExtendedOperand EOF ;
    public final EObject entryRuleExtendedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedOperand = null;


        try {
            // InternalAssembler.g:1466:56: (iv_ruleExtendedOperand= ruleExtendedOperand EOF )
            // InternalAssembler.g:1467:2: iv_ruleExtendedOperand= ruleExtendedOperand EOF
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
    // InternalAssembler.g:1473:1: ruleExtendedOperand returns [EObject current=null] : ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExtendedOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1479:2: ( ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:1480:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:1480:2: ( (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:1481:3: (otherlv_0= '>' )? ( (lv_operand_1_0= ruleExpression ) )
            {
            // InternalAssembler.g:1481:3: (otherlv_0= '>' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalAssembler.g:1482:4: otherlv_0= '>'
                    {
                    otherlv_0=(Token)match(input,32,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getExtendedOperandAccess().getGreaterThanSignKeyword_0());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:1487:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:1488:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:1488:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:1489:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:1510:1: entryRuleDirectOperand returns [EObject current=null] : iv_ruleDirectOperand= ruleDirectOperand EOF ;
    public final EObject entryRuleDirectOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectOperand = null;


        try {
            // InternalAssembler.g:1510:54: (iv_ruleDirectOperand= ruleDirectOperand EOF )
            // InternalAssembler.g:1511:2: iv_ruleDirectOperand= ruleDirectOperand EOF
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
    // InternalAssembler.g:1517:1: ruleDirectOperand returns [EObject current=null] : (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleDirectOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1523:2: ( (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:1524:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:1524:2: (otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:1525:3: otherlv_0= '<' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectOperandAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalAssembler.g:1529:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:1530:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:1530:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:1531:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:1552:1: entryRuleImmediatOperand returns [EObject current=null] : iv_ruleImmediatOperand= ruleImmediatOperand EOF ;
    public final EObject entryRuleImmediatOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImmediatOperand = null;


        try {
            // InternalAssembler.g:1552:56: (iv_ruleImmediatOperand= ruleImmediatOperand EOF )
            // InternalAssembler.g:1553:2: iv_ruleImmediatOperand= ruleImmediatOperand EOF
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
    // InternalAssembler.g:1559:1: ruleImmediatOperand returns [EObject current=null] : (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) ;
    public final EObject ruleImmediatOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1565:2: ( (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) ) )
            // InternalAssembler.g:1566:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:1566:2: (otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) ) )
            // InternalAssembler.g:1567:3: otherlv_0= '#' ( (lv_operand_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImmediatOperandAccess().getNumberSignKeyword_0());
              		
            }
            // InternalAssembler.g:1571:3: ( (lv_operand_1_0= ruleExpression ) )
            // InternalAssembler.g:1572:4: (lv_operand_1_0= ruleExpression )
            {
            // InternalAssembler.g:1572:4: (lv_operand_1_0= ruleExpression )
            // InternalAssembler.g:1573:5: lv_operand_1_0= ruleExpression
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
    // InternalAssembler.g:1594:1: entryRuleIndexedOperand returns [EObject current=null] : iv_ruleIndexedOperand= ruleIndexedOperand EOF ;
    public final EObject entryRuleIndexedOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedOperand = null;


        try {
            // InternalAssembler.g:1594:55: (iv_ruleIndexedOperand= ruleIndexedOperand EOF )
            // InternalAssembler.g:1595:2: iv_ruleIndexedOperand= ruleIndexedOperand EOF
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
    // InternalAssembler.g:1601:1: ruleIndexedOperand returns [EObject current=null] : ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) ;
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
            // InternalAssembler.g:1607:2: ( ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) ) )
            // InternalAssembler.g:1608:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            {
            // InternalAssembler.g:1608:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )
            int alt22=8;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:1609:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    {
                    // InternalAssembler.g:1609:3: ( (lv_mode_0_0= ruleAutoIncDecMode ) )
                    // InternalAssembler.g:1610:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    {
                    // InternalAssembler.g:1610:4: (lv_mode_0_0= ruleAutoIncDecMode )
                    // InternalAssembler.g:1611:5: lv_mode_0_0= ruleAutoIncDecMode
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
                    // InternalAssembler.g:1629:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    {
                    // InternalAssembler.g:1629:3: ( (lv_mode_1_0= ruleConstantIndexedMode ) )
                    // InternalAssembler.g:1630:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    {
                    // InternalAssembler.g:1630:4: (lv_mode_1_0= ruleConstantIndexedMode )
                    // InternalAssembler.g:1631:5: lv_mode_1_0= ruleConstantIndexedMode
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
                    // InternalAssembler.g:1649:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    {
                    // InternalAssembler.g:1649:3: ( (lv_mode_2_0= ruleAccumulatorMovingMode ) )
                    // InternalAssembler.g:1650:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    {
                    // InternalAssembler.g:1650:4: (lv_mode_2_0= ruleAccumulatorMovingMode )
                    // InternalAssembler.g:1651:5: lv_mode_2_0= ruleAccumulatorMovingMode
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
                    // InternalAssembler.g:1669:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    {
                    // InternalAssembler.g:1669:3: ( (lv_mode_3_0= ruleRelatifToPCMode ) )
                    // InternalAssembler.g:1670:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    {
                    // InternalAssembler.g:1670:4: (lv_mode_3_0= ruleRelatifToPCMode )
                    // InternalAssembler.g:1671:5: lv_mode_3_0= ruleRelatifToPCMode
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
                    // InternalAssembler.g:1689:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:1689:3: ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) )
                    // InternalAssembler.g:1690:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    {
                    // InternalAssembler.g:1690:4: (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode )
                    // InternalAssembler.g:1691:5: lv_mode_4_0= ruleConstantIndexedMovingIndirectMode
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
                    // InternalAssembler.g:1709:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    {
                    // InternalAssembler.g:1709:3: ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) )
                    // InternalAssembler.g:1710:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    {
                    // InternalAssembler.g:1710:4: (lv_mode_5_0= ruleAutoIncDecIndirectMode )
                    // InternalAssembler.g:1711:5: lv_mode_5_0= ruleAutoIncDecIndirectMode
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
                    // InternalAssembler.g:1729:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    {
                    // InternalAssembler.g:1729:3: ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) )
                    // InternalAssembler.g:1730:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    {
                    // InternalAssembler.g:1730:4: (lv_mode_6_0= ruleAccumulatorMovingIndirectMode )
                    // InternalAssembler.g:1731:5: lv_mode_6_0= ruleAccumulatorMovingIndirectMode
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
                    // InternalAssembler.g:1749:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    {
                    // InternalAssembler.g:1749:3: ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) )
                    // InternalAssembler.g:1750:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    {
                    // InternalAssembler.g:1750:4: (lv_mode_7_0= ruleRelatifToPCIndirectMode )
                    // InternalAssembler.g:1751:5: lv_mode_7_0= ruleRelatifToPCIndirectMode
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
    // InternalAssembler.g:1772:1: entryRuleConstantIndexedMode returns [EObject current=null] : iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF ;
    public final EObject entryRuleConstantIndexedMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMode = null;


        try {
            // InternalAssembler.g:1772:60: (iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF )
            // InternalAssembler.g:1773:2: iv_ruleConstantIndexedMode= ruleConstantIndexedMode EOF
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
    // InternalAssembler.g:1779:1: ruleConstantIndexedMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:1785:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:1786:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:1786:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:1787:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:1787:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_CHARACTER)||LA23_0==43||LA23_0==45) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAssembler.g:1788:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:1788:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:1789:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_13);
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

            otherlv_1=(Token)match(input,35,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstantIndexedModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:1810:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:1811:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:1811:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:1812:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:1812:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt24=1;
                }
                break;
            case 37:
                {
                alt24=2;
                }
                break;
            case 38:
                {
                alt24=3;
                }
                break;
            case 39:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalAssembler.g:1813:6: lv_register_2_1= 'S'
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
                    // InternalAssembler.g:1824:6: lv_register_2_2= 'U'
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
                    // InternalAssembler.g:1835:6: lv_register_2_3= 'X'
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
                    // InternalAssembler.g:1846:6: lv_register_2_4= 'Y'
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
    // InternalAssembler.g:1863:1: entryRuleConstantIndexedMovingIndirectMode returns [EObject current=null] : iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF ;
    public final EObject entryRuleConstantIndexedMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantIndexedMovingIndirectMode = null;


        try {
            // InternalAssembler.g:1863:74: (iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF )
            // InternalAssembler.g:1864:2: iv_ruleConstantIndexedMovingIndirectMode= ruleConstantIndexedMovingIndirectMode EOF
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
    // InternalAssembler.g:1870:1: ruleConstantIndexedMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:1876:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:1877:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:1877:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:1878:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:1882:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_CHARACTER)||LA25_0==43||LA25_0==45) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAssembler.g:1883:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:1883:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:1884:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstantIndexedMovingIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_13);
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

            otherlv_2=(Token)match(input,35,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstantIndexedMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:1905:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:1906:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:1906:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:1907:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:1907:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt26=1;
                }
                break;
            case 37:
                {
                alt26=2;
                }
                break;
            case 38:
                {
                alt26=3;
                }
                break;
            case 39:
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
                    // InternalAssembler.g:1908:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,36,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:1919:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,37,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:1930:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,38,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:1941:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,39,FOLLOW_12); if (state.failed) return current;
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
    // InternalAssembler.g:1962:1: entryRuleAccumulatorMovingMode returns [EObject current=null] : iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF ;
    public final EObject entryRuleAccumulatorMovingMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingMode = null;


        try {
            // InternalAssembler.g:1962:62: (iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF )
            // InternalAssembler.g:1963:2: iv_ruleAccumulatorMovingMode= ruleAccumulatorMovingMode EOF
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
    // InternalAssembler.g:1969:1: ruleAccumulatorMovingMode returns [EObject current=null] : ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) ;
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
            // InternalAssembler.g:1975:2: ( ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) ) )
            // InternalAssembler.g:1976:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            {
            // InternalAssembler.g:1976:2: ( ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) ) )
            // InternalAssembler.g:1977:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) ) otherlv_1= ',' ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            {
            // InternalAssembler.g:1977:3: ( ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) ) )
            // InternalAssembler.g:1978:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            {
            // InternalAssembler.g:1978:4: ( (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' ) )
            // InternalAssembler.g:1979:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            {
            // InternalAssembler.g:1979:5: (lv_deplacement_0_1= 'A' | lv_deplacement_0_2= 'B' | lv_deplacement_0_3= 'D' )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt27=1;
                }
                break;
            case 41:
                {
                alt27=2;
                }
                break;
            case 42:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalAssembler.g:1980:6: lv_deplacement_0_1= 'A'
                    {
                    lv_deplacement_0_1=(Token)match(input,40,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:1991:6: lv_deplacement_0_2= 'B'
                    {
                    lv_deplacement_0_2=(Token)match(input,41,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2002:6: lv_deplacement_0_3= 'D'
                    {
                    lv_deplacement_0_3=(Token)match(input,42,FOLLOW_13); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,35,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAccumulatorMovingModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2019:3: ( ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) ) )
            // InternalAssembler.g:2020:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            {
            // InternalAssembler.g:2020:4: ( (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' ) )
            // InternalAssembler.g:2021:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            {
            // InternalAssembler.g:2021:5: (lv_register_2_1= 'S' | lv_register_2_2= 'U' | lv_register_2_3= 'X' | lv_register_2_4= 'Y' )
            int alt28=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt28=1;
                }
                break;
            case 37:
                {
                alt28=2;
                }
                break;
            case 38:
                {
                alt28=3;
                }
                break;
            case 39:
                {
                alt28=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalAssembler.g:2022:6: lv_register_2_1= 'S'
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
                    // InternalAssembler.g:2033:6: lv_register_2_2= 'U'
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
                    // InternalAssembler.g:2044:6: lv_register_2_3= 'X'
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
                    // InternalAssembler.g:2055:6: lv_register_2_4= 'Y'
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
    // InternalAssembler.g:2072:1: entryRuleAccumulatorMovingIndirectMode returns [EObject current=null] : iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF ;
    public final EObject entryRuleAccumulatorMovingIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccumulatorMovingIndirectMode = null;


        try {
            // InternalAssembler.g:2072:70: (iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF )
            // InternalAssembler.g:2073:2: iv_ruleAccumulatorMovingIndirectMode= ruleAccumulatorMovingIndirectMode EOF
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
    // InternalAssembler.g:2079:1: ruleAccumulatorMovingIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) ;
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
            // InternalAssembler.g:2085:2: ( (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:2086:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:2086:2: (otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']' )
            // InternalAssembler.g:2087:3: otherlv_0= '[' ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) ) otherlv_2= ',' ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAccumulatorMovingIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2091:3: ( ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) ) )
            // InternalAssembler.g:2092:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            {
            // InternalAssembler.g:2092:4: ( (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' ) )
            // InternalAssembler.g:2093:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            {
            // InternalAssembler.g:2093:5: (lv_deplacement_1_1= 'A' | lv_deplacement_1_2= 'B' | lv_deplacement_1_3= 'D' )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt29=1;
                }
                break;
            case 41:
                {
                alt29=2;
                }
                break;
            case 42:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalAssembler.g:2094:6: lv_deplacement_1_1= 'A'
                    {
                    lv_deplacement_1_1=(Token)match(input,40,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2105:6: lv_deplacement_1_2= 'B'
                    {
                    lv_deplacement_1_2=(Token)match(input,41,FOLLOW_13); if (state.failed) return current;
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
                    // InternalAssembler.g:2116:6: lv_deplacement_1_3= 'D'
                    {
                    lv_deplacement_1_3=(Token)match(input,42,FOLLOW_13); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,35,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAccumulatorMovingIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:2133:3: ( ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) ) )
            // InternalAssembler.g:2134:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            {
            // InternalAssembler.g:2134:4: ( (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' ) )
            // InternalAssembler.g:2135:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            {
            // InternalAssembler.g:2135:5: (lv_register_3_1= 'S' | lv_register_3_2= 'U' | lv_register_3_3= 'X' | lv_register_3_4= 'Y' )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt30=1;
                }
                break;
            case 37:
                {
                alt30=2;
                }
                break;
            case 38:
                {
                alt30=3;
                }
                break;
            case 39:
                {
                alt30=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalAssembler.g:2136:6: lv_register_3_1= 'S'
                    {
                    lv_register_3_1=(Token)match(input,36,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:2147:6: lv_register_3_2= 'U'
                    {
                    lv_register_3_2=(Token)match(input,37,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:2158:6: lv_register_3_3= 'X'
                    {
                    lv_register_3_3=(Token)match(input,38,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:2169:6: lv_register_3_4= 'Y'
                    {
                    lv_register_3_4=(Token)match(input,39,FOLLOW_12); if (state.failed) return current;
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
    // InternalAssembler.g:2190:1: entryRuleAutoIncDecMode returns [EObject current=null] : iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF ;
    public final EObject entryRuleAutoIncDecMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecMode = null;


        try {
            // InternalAssembler.g:2190:55: (iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF )
            // InternalAssembler.g:2191:2: iv_ruleAutoIncDecMode= ruleAutoIncDecMode EOF
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
    // InternalAssembler.g:2197:1: ruleAutoIncDecMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) ;
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
            // InternalAssembler.g:2203:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) ) )
            // InternalAssembler.g:2204:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            {
            // InternalAssembler.g:2204:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) ) )
            // InternalAssembler.g:2205:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            {
            // InternalAssembler.g:2205:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_CHARACTER)||LA31_0==43||LA31_0==45) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAssembler.g:2206:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2206:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:2207:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_13);
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

            otherlv_1=(Token)match(input,35,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAutoIncDecModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2228:3: ( ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) ) | ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=43 && LA36_0<=44)) ) {
                alt36=1;
            }
            else if ( ((LA36_0>=36 && LA36_0<=39)) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalAssembler.g:2229:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:2229:4: ( ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) ) )
                    // InternalAssembler.g:2230:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) ) ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:2230:5: ( ( (lv_decrement_2_0= '-' ) ) | ( (lv_decrement_3_0= '--' ) ) )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==43) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==44) ) {
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
                            // InternalAssembler.g:2231:6: ( (lv_decrement_2_0= '-' ) )
                            {
                            // InternalAssembler.g:2231:6: ( (lv_decrement_2_0= '-' ) )
                            // InternalAssembler.g:2232:7: (lv_decrement_2_0= '-' )
                            {
                            // InternalAssembler.g:2232:7: (lv_decrement_2_0= '-' )
                            // InternalAssembler.g:2233:8: lv_decrement_2_0= '-'
                            {
                            lv_decrement_2_0=(Token)match(input,43,FOLLOW_14); if (state.failed) return current;
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
                            // InternalAssembler.g:2246:6: ( (lv_decrement_3_0= '--' ) )
                            {
                            // InternalAssembler.g:2246:6: ( (lv_decrement_3_0= '--' ) )
                            // InternalAssembler.g:2247:7: (lv_decrement_3_0= '--' )
                            {
                            // InternalAssembler.g:2247:7: (lv_decrement_3_0= '--' )
                            // InternalAssembler.g:2248:8: lv_decrement_3_0= '--'
                            {
                            lv_decrement_3_0=(Token)match(input,44,FOLLOW_14); if (state.failed) return current;
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

                    // InternalAssembler.g:2261:5: ( ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) ) )
                    // InternalAssembler.g:2262:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2262:6: ( (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' ) )
                    // InternalAssembler.g:2263:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    {
                    // InternalAssembler.g:2263:7: (lv_register_4_1= 'S' | lv_register_4_2= 'U' | lv_register_4_3= 'X' | lv_register_4_4= 'Y' )
                    int alt33=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt33=1;
                        }
                        break;
                    case 37:
                        {
                        alt33=2;
                        }
                        break;
                    case 38:
                        {
                        alt33=3;
                        }
                        break;
                    case 39:
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
                            // InternalAssembler.g:2264:8: lv_register_4_1= 'S'
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
                            // InternalAssembler.g:2275:8: lv_register_4_2= 'U'
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
                            // InternalAssembler.g:2286:8: lv_register_4_3= 'X'
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
                            // InternalAssembler.g:2297:8: lv_register_4_4= 'Y'
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
                    // InternalAssembler.g:2312:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:2312:4: ( ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) ) )
                    // InternalAssembler.g:2313:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    {
                    // InternalAssembler.g:2313:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:2314:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2314:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:2315:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:2315:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt34=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt34=1;
                        }
                        break;
                    case 37:
                        {
                        alt34=2;
                        }
                        break;
                    case 38:
                        {
                        alt34=3;
                        }
                        break;
                    case 39:
                        {
                        alt34=4;
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
                            // InternalAssembler.g:2316:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,36,FOLLOW_18); if (state.failed) return current;
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
                            // InternalAssembler.g:2327:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,37,FOLLOW_18); if (state.failed) return current;
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
                            // InternalAssembler.g:2338:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,38,FOLLOW_18); if (state.failed) return current;
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
                            // InternalAssembler.g:2349:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,39,FOLLOW_18); if (state.failed) return current;
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

                    // InternalAssembler.g:2362:5: ( ( (lv_increment_6_0= '+' ) ) | ( (lv_increment_7_0= '++' ) ) )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==45) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==46) ) {
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
                            // InternalAssembler.g:2363:6: ( (lv_increment_6_0= '+' ) )
                            {
                            // InternalAssembler.g:2363:6: ( (lv_increment_6_0= '+' ) )
                            // InternalAssembler.g:2364:7: (lv_increment_6_0= '+' )
                            {
                            // InternalAssembler.g:2364:7: (lv_increment_6_0= '+' )
                            // InternalAssembler.g:2365:8: lv_increment_6_0= '+'
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
                            // InternalAssembler.g:2378:6: ( (lv_increment_7_0= '++' ) )
                            {
                            // InternalAssembler.g:2378:6: ( (lv_increment_7_0= '++' ) )
                            // InternalAssembler.g:2379:7: (lv_increment_7_0= '++' )
                            {
                            // InternalAssembler.g:2379:7: (lv_increment_7_0= '++' )
                            // InternalAssembler.g:2380:8: lv_increment_7_0= '++'
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
    // InternalAssembler.g:2399:1: entryRuleAutoIncDecIndirectMode returns [EObject current=null] : iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF ;
    public final EObject entryRuleAutoIncDecIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAutoIncDecIndirectMode = null;


        try {
            // InternalAssembler.g:2399:63: (iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF )
            // InternalAssembler.g:2400:2: iv_ruleAutoIncDecIndirectMode= ruleAutoIncDecIndirectMode EOF
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
    // InternalAssembler.g:2406:1: ruleAutoIncDecIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) ;
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
            // InternalAssembler.g:2412:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' ) )
            // InternalAssembler.g:2413:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            {
            // InternalAssembler.g:2413:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']' )
            // InternalAssembler.g:2414:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) ) otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAutoIncDecIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2418:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_ID && LA37_0<=RULE_CHARACTER)||LA37_0==43||LA37_0==45) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalAssembler.g:2419:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2419:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:2420:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAutoIncDecIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_13);
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

            otherlv_2=(Token)match(input,35,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAutoIncDecIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:2441:3: ( ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) ) | ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=43 && LA42_0<=44)) ) {
                alt42=1;
            }
            else if ( ((LA42_0>=36 && LA42_0<=39)) ) {
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
                    // InternalAssembler.g:2442:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    {
                    // InternalAssembler.g:2442:4: ( ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) ) )
                    // InternalAssembler.g:2443:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) ) ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    {
                    // InternalAssembler.g:2443:5: ( ( (lv_decrement_3_0= '-' ) ) | ( (lv_decrement_4_0= '--' ) ) )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==43) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==44) ) {
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
                            // InternalAssembler.g:2444:6: ( (lv_decrement_3_0= '-' ) )
                            {
                            // InternalAssembler.g:2444:6: ( (lv_decrement_3_0= '-' ) )
                            // InternalAssembler.g:2445:7: (lv_decrement_3_0= '-' )
                            {
                            // InternalAssembler.g:2445:7: (lv_decrement_3_0= '-' )
                            // InternalAssembler.g:2446:8: lv_decrement_3_0= '-'
                            {
                            lv_decrement_3_0=(Token)match(input,43,FOLLOW_14); if (state.failed) return current;
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
                            // InternalAssembler.g:2459:6: ( (lv_decrement_4_0= '--' ) )
                            {
                            // InternalAssembler.g:2459:6: ( (lv_decrement_4_0= '--' ) )
                            // InternalAssembler.g:2460:7: (lv_decrement_4_0= '--' )
                            {
                            // InternalAssembler.g:2460:7: (lv_decrement_4_0= '--' )
                            // InternalAssembler.g:2461:8: lv_decrement_4_0= '--'
                            {
                            lv_decrement_4_0=(Token)match(input,44,FOLLOW_14); if (state.failed) return current;
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

                    // InternalAssembler.g:2474:5: ( ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) ) )
                    // InternalAssembler.g:2475:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2475:6: ( (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' ) )
                    // InternalAssembler.g:2476:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    {
                    // InternalAssembler.g:2476:7: (lv_register_5_1= 'S' | lv_register_5_2= 'U' | lv_register_5_3= 'X' | lv_register_5_4= 'Y' )
                    int alt39=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt39=1;
                        }
                        break;
                    case 37:
                        {
                        alt39=2;
                        }
                        break;
                    case 38:
                        {
                        alt39=3;
                        }
                        break;
                    case 39:
                        {
                        alt39=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }

                    switch (alt39) {
                        case 1 :
                            // InternalAssembler.g:2477:8: lv_register_5_1= 'S'
                            {
                            lv_register_5_1=(Token)match(input,36,FOLLOW_12); if (state.failed) return current;
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
                            // InternalAssembler.g:2488:8: lv_register_5_2= 'U'
                            {
                            lv_register_5_2=(Token)match(input,37,FOLLOW_12); if (state.failed) return current;
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
                            // InternalAssembler.g:2499:8: lv_register_5_3= 'X'
                            {
                            lv_register_5_3=(Token)match(input,38,FOLLOW_12); if (state.failed) return current;
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
                            // InternalAssembler.g:2510:8: lv_register_5_4= 'Y'
                            {
                            lv_register_5_4=(Token)match(input,39,FOLLOW_12); if (state.failed) return current;
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
                    // InternalAssembler.g:2525:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    {
                    // InternalAssembler.g:2525:4: ( ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) ) )
                    // InternalAssembler.g:2526:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) ) ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    {
                    // InternalAssembler.g:2526:5: ( ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) ) )
                    // InternalAssembler.g:2527:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    {
                    // InternalAssembler.g:2527:6: ( (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' ) )
                    // InternalAssembler.g:2528:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    {
                    // InternalAssembler.g:2528:7: (lv_register_6_1= 'S' | lv_register_6_2= 'U' | lv_register_6_3= 'X' | lv_register_6_4= 'Y' )
                    int alt40=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt40=1;
                        }
                        break;
                    case 37:
                        {
                        alt40=2;
                        }
                        break;
                    case 38:
                        {
                        alt40=3;
                        }
                        break;
                    case 39:
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
                            // InternalAssembler.g:2529:8: lv_register_6_1= 'S'
                            {
                            lv_register_6_1=(Token)match(input,36,FOLLOW_18); if (state.failed) return current;
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
                            // InternalAssembler.g:2540:8: lv_register_6_2= 'U'
                            {
                            lv_register_6_2=(Token)match(input,37,FOLLOW_18); if (state.failed) return current;
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
                            // InternalAssembler.g:2551:8: lv_register_6_3= 'X'
                            {
                            lv_register_6_3=(Token)match(input,38,FOLLOW_18); if (state.failed) return current;
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
                            // InternalAssembler.g:2562:8: lv_register_6_4= 'Y'
                            {
                            lv_register_6_4=(Token)match(input,39,FOLLOW_18); if (state.failed) return current;
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

                    // InternalAssembler.g:2575:5: ( ( (lv_increment_7_0= '+' ) ) | ( (lv_increment_8_0= '++' ) ) )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==45) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==46) ) {
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
                            // InternalAssembler.g:2576:6: ( (lv_increment_7_0= '+' ) )
                            {
                            // InternalAssembler.g:2576:6: ( (lv_increment_7_0= '+' ) )
                            // InternalAssembler.g:2577:7: (lv_increment_7_0= '+' )
                            {
                            // InternalAssembler.g:2577:7: (lv_increment_7_0= '+' )
                            // InternalAssembler.g:2578:8: lv_increment_7_0= '+'
                            {
                            lv_increment_7_0=(Token)match(input,45,FOLLOW_12); if (state.failed) return current;
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
                            // InternalAssembler.g:2591:6: ( (lv_increment_8_0= '++' ) )
                            {
                            // InternalAssembler.g:2591:6: ( (lv_increment_8_0= '++' ) )
                            // InternalAssembler.g:2592:7: (lv_increment_8_0= '++' )
                            {
                            // InternalAssembler.g:2592:7: (lv_increment_8_0= '++' )
                            // InternalAssembler.g:2593:8: lv_increment_8_0= '++'
                            {
                            lv_increment_8_0=(Token)match(input,46,FOLLOW_12); if (state.failed) return current;
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
    // InternalAssembler.g:2616:1: entryRuleRelatifToPCMode returns [EObject current=null] : iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF ;
    public final EObject entryRuleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCMode = null;


        try {
            // InternalAssembler.g:2616:56: (iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF )
            // InternalAssembler.g:2617:2: iv_ruleRelatifToPCMode= ruleRelatifToPCMode EOF
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
    // InternalAssembler.g:2623:1: ruleRelatifToPCMode returns [EObject current=null] : ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) ;
    public final EObject ruleRelatifToPCMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_register_2_0=null;
        EObject lv_deplacement_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2629:2: ( ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) ) )
            // InternalAssembler.g:2630:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            {
            // InternalAssembler.g:2630:2: ( ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) ) )
            // InternalAssembler.g:2631:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )? otherlv_1= ',' ( (lv_register_2_0= 'PCR' ) )
            {
            // InternalAssembler.g:2631:3: ( (lv_deplacement_0_0= ruleNumericalValue ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_CHARACTER)||LA43_0==43||LA43_0==45) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAssembler.g:2632:4: (lv_deplacement_0_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2632:4: (lv_deplacement_0_0= ruleNumericalValue )
                    // InternalAssembler.g:2633:5: lv_deplacement_0_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCModeAccess().getDeplacementNumericalValueParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_13);
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

            otherlv_1=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelatifToPCModeAccess().getCommaKeyword_1());
              		
            }
            // InternalAssembler.g:2654:3: ( (lv_register_2_0= 'PCR' ) )
            // InternalAssembler.g:2655:4: (lv_register_2_0= 'PCR' )
            {
            // InternalAssembler.g:2655:4: (lv_register_2_0= 'PCR' )
            // InternalAssembler.g:2656:5: lv_register_2_0= 'PCR'
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
    // InternalAssembler.g:2672:1: entryRuleRelatifToPCIndirectMode returns [EObject current=null] : iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF ;
    public final EObject entryRuleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelatifToPCIndirectMode = null;


        try {
            // InternalAssembler.g:2672:64: (iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF )
            // InternalAssembler.g:2673:2: iv_ruleRelatifToPCIndirectMode= ruleRelatifToPCIndirectMode EOF
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
    // InternalAssembler.g:2679:1: ruleRelatifToPCIndirectMode returns [EObject current=null] : (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) ;
    public final EObject ruleRelatifToPCIndirectMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_register_3_0=null;
        Token otherlv_4=null;
        EObject lv_deplacement_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2685:2: ( (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' ) )
            // InternalAssembler.g:2686:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            {
            // InternalAssembler.g:2686:2: (otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']' )
            // InternalAssembler.g:2687:3: otherlv_0= '[' ( (lv_deplacement_1_0= ruleNumericalValue ) )? otherlv_2= ',' ( (lv_register_3_0= 'PCR' ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRelatifToPCIndirectModeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalAssembler.g:2691:3: ( (lv_deplacement_1_0= ruleNumericalValue ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_CHARACTER)||LA44_0==43||LA44_0==45) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAssembler.g:2692:4: (lv_deplacement_1_0= ruleNumericalValue )
                    {
                    // InternalAssembler.g:2692:4: (lv_deplacement_1_0= ruleNumericalValue )
                    // InternalAssembler.g:2693:5: lv_deplacement_1_0= ruleNumericalValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRelatifToPCIndirectModeAccess().getDeplacementNumericalValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_13);
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

            otherlv_2=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRelatifToPCIndirectModeAccess().getCommaKeyword_2());
              		
            }
            // InternalAssembler.g:2714:3: ( (lv_register_3_0= 'PCR' ) )
            // InternalAssembler.g:2715:4: (lv_register_3_0= 'PCR' )
            {
            // InternalAssembler.g:2715:4: (lv_register_3_0= 'PCR' )
            // InternalAssembler.g:2716:5: lv_register_3_0= 'PCR'
            {
            lv_register_3_0=(Token)match(input,47,FOLLOW_12); if (state.failed) return current;
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
    // InternalAssembler.g:2736:1: entryRuleDirectiveLine returns [EObject current=null] : iv_ruleDirectiveLine= ruleDirectiveLine EOF ;
    public final EObject entryRuleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectiveLine = null;


        try {
            // InternalAssembler.g:2736:54: (iv_ruleDirectiveLine= ruleDirectiveLine EOF )
            // InternalAssembler.g:2737:2: iv_ruleDirectiveLine= ruleDirectiveLine EOF
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
    // InternalAssembler.g:2743:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:2749:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:2750:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:2750:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:2751:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) ) (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_20= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:2751:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAssembler.g:2752:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2752:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:2753:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2774:3: ( ( (lv_directive_2_0= ruleEquDirective ) ) | ( (lv_directive_3_0= ruleOrgDirective ) ) | ( (lv_directive_4_0= ruleBszDirective ) ) | ( (lv_directive_5_0= ruleEndDirective ) ) | ( (lv_directive_6_0= ruleFailDirective ) ) | ( (lv_directive_7_0= ruleFillDirective ) ) | ( (lv_directive_8_0= ruleOptDirective ) ) | ( (lv_directive_9_0= rulePagDirective ) ) | ( (lv_directive_10_0= ruleNamDirective ) ) | ( (lv_directive_11_0= ruleSetDirective ) ) | ( (lv_directive_12_0= ruleSpcDirective ) ) | ( (lv_directive_13_0= ruleRegDirective ) ) | ( (lv_directive_14_0= ruleFcbDirective ) ) | ( (lv_directive_15_0= ruleFdbDirective ) ) | ( (lv_directive_16_0= ruleFccDirective ) ) | ( (lv_directive_17_0= ruleRmbDirective ) ) )
            int alt46=16;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt46=1;
                }
                break;
            case 65:
                {
                alt46=2;
                }
                break;
            case 59:
            case 60:
                {
                alt46=3;
                }
                break;
            case 64:
                {
                alt46=4;
                }
                break;
            case 55:
                {
                alt46=5;
                }
                break;
            case 58:
                {
                alt46=6;
                }
                break;
            case 54:
                {
                alt46=7;
                }
                break;
            case 53:
                {
                alt46=8;
                }
                break;
            case 51:
            case 52:
                {
                alt46=9;
                }
                break;
            case 56:
                {
                alt46=10;
                }
                break;
            case 50:
                {
                alt46=11;
                }
                break;
            case 49:
                {
                alt46=12;
                }
                break;
            case 62:
                {
                alt46=13;
                }
                break;
            case 61:
                {
                alt46=14;
                }
                break;
            case 48:
                {
                alt46=15;
                }
                break;
            case 63:
                {
                alt46=16;
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
                    // InternalAssembler.g:2775:4: ( (lv_directive_2_0= ruleEquDirective ) )
                    {
                    // InternalAssembler.g:2775:4: ( (lv_directive_2_0= ruleEquDirective ) )
                    // InternalAssembler.g:2776:5: (lv_directive_2_0= ruleEquDirective )
                    {
                    // InternalAssembler.g:2776:5: (lv_directive_2_0= ruleEquDirective )
                    // InternalAssembler.g:2777:6: lv_directive_2_0= ruleEquDirective
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
                    // InternalAssembler.g:2795:4: ( (lv_directive_3_0= ruleOrgDirective ) )
                    {
                    // InternalAssembler.g:2795:4: ( (lv_directive_3_0= ruleOrgDirective ) )
                    // InternalAssembler.g:2796:5: (lv_directive_3_0= ruleOrgDirective )
                    {
                    // InternalAssembler.g:2796:5: (lv_directive_3_0= ruleOrgDirective )
                    // InternalAssembler.g:2797:6: lv_directive_3_0= ruleOrgDirective
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
                    // InternalAssembler.g:2815:4: ( (lv_directive_4_0= ruleBszDirective ) )
                    {
                    // InternalAssembler.g:2815:4: ( (lv_directive_4_0= ruleBszDirective ) )
                    // InternalAssembler.g:2816:5: (lv_directive_4_0= ruleBszDirective )
                    {
                    // InternalAssembler.g:2816:5: (lv_directive_4_0= ruleBszDirective )
                    // InternalAssembler.g:2817:6: lv_directive_4_0= ruleBszDirective
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
                    // InternalAssembler.g:2835:4: ( (lv_directive_5_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:2835:4: ( (lv_directive_5_0= ruleEndDirective ) )
                    // InternalAssembler.g:2836:5: (lv_directive_5_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:2836:5: (lv_directive_5_0= ruleEndDirective )
                    // InternalAssembler.g:2837:6: lv_directive_5_0= ruleEndDirective
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
                    // InternalAssembler.g:2855:4: ( (lv_directive_6_0= ruleFailDirective ) )
                    {
                    // InternalAssembler.g:2855:4: ( (lv_directive_6_0= ruleFailDirective ) )
                    // InternalAssembler.g:2856:5: (lv_directive_6_0= ruleFailDirective )
                    {
                    // InternalAssembler.g:2856:5: (lv_directive_6_0= ruleFailDirective )
                    // InternalAssembler.g:2857:6: lv_directive_6_0= ruleFailDirective
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
                    // InternalAssembler.g:2875:4: ( (lv_directive_7_0= ruleFillDirective ) )
                    {
                    // InternalAssembler.g:2875:4: ( (lv_directive_7_0= ruleFillDirective ) )
                    // InternalAssembler.g:2876:5: (lv_directive_7_0= ruleFillDirective )
                    {
                    // InternalAssembler.g:2876:5: (lv_directive_7_0= ruleFillDirective )
                    // InternalAssembler.g:2877:6: lv_directive_7_0= ruleFillDirective
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
                    // InternalAssembler.g:2895:4: ( (lv_directive_8_0= ruleOptDirective ) )
                    {
                    // InternalAssembler.g:2895:4: ( (lv_directive_8_0= ruleOptDirective ) )
                    // InternalAssembler.g:2896:5: (lv_directive_8_0= ruleOptDirective )
                    {
                    // InternalAssembler.g:2896:5: (lv_directive_8_0= ruleOptDirective )
                    // InternalAssembler.g:2897:6: lv_directive_8_0= ruleOptDirective
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
                    // InternalAssembler.g:2915:4: ( (lv_directive_9_0= rulePagDirective ) )
                    {
                    // InternalAssembler.g:2915:4: ( (lv_directive_9_0= rulePagDirective ) )
                    // InternalAssembler.g:2916:5: (lv_directive_9_0= rulePagDirective )
                    {
                    // InternalAssembler.g:2916:5: (lv_directive_9_0= rulePagDirective )
                    // InternalAssembler.g:2917:6: lv_directive_9_0= rulePagDirective
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
                    // InternalAssembler.g:2935:4: ( (lv_directive_10_0= ruleNamDirective ) )
                    {
                    // InternalAssembler.g:2935:4: ( (lv_directive_10_0= ruleNamDirective ) )
                    // InternalAssembler.g:2936:5: (lv_directive_10_0= ruleNamDirective )
                    {
                    // InternalAssembler.g:2936:5: (lv_directive_10_0= ruleNamDirective )
                    // InternalAssembler.g:2937:6: lv_directive_10_0= ruleNamDirective
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
                    // InternalAssembler.g:2955:4: ( (lv_directive_11_0= ruleSetDirective ) )
                    {
                    // InternalAssembler.g:2955:4: ( (lv_directive_11_0= ruleSetDirective ) )
                    // InternalAssembler.g:2956:5: (lv_directive_11_0= ruleSetDirective )
                    {
                    // InternalAssembler.g:2956:5: (lv_directive_11_0= ruleSetDirective )
                    // InternalAssembler.g:2957:6: lv_directive_11_0= ruleSetDirective
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
                    // InternalAssembler.g:2975:4: ( (lv_directive_12_0= ruleSpcDirective ) )
                    {
                    // InternalAssembler.g:2975:4: ( (lv_directive_12_0= ruleSpcDirective ) )
                    // InternalAssembler.g:2976:5: (lv_directive_12_0= ruleSpcDirective )
                    {
                    // InternalAssembler.g:2976:5: (lv_directive_12_0= ruleSpcDirective )
                    // InternalAssembler.g:2977:6: lv_directive_12_0= ruleSpcDirective
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
                    // InternalAssembler.g:2995:4: ( (lv_directive_13_0= ruleRegDirective ) )
                    {
                    // InternalAssembler.g:2995:4: ( (lv_directive_13_0= ruleRegDirective ) )
                    // InternalAssembler.g:2996:5: (lv_directive_13_0= ruleRegDirective )
                    {
                    // InternalAssembler.g:2996:5: (lv_directive_13_0= ruleRegDirective )
                    // InternalAssembler.g:2997:6: lv_directive_13_0= ruleRegDirective
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
                    // InternalAssembler.g:3015:4: ( (lv_directive_14_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:3015:4: ( (lv_directive_14_0= ruleFcbDirective ) )
                    // InternalAssembler.g:3016:5: (lv_directive_14_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:3016:5: (lv_directive_14_0= ruleFcbDirective )
                    // InternalAssembler.g:3017:6: lv_directive_14_0= ruleFcbDirective
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
                    // InternalAssembler.g:3035:4: ( (lv_directive_15_0= ruleFdbDirective ) )
                    {
                    // InternalAssembler.g:3035:4: ( (lv_directive_15_0= ruleFdbDirective ) )
                    // InternalAssembler.g:3036:5: (lv_directive_15_0= ruleFdbDirective )
                    {
                    // InternalAssembler.g:3036:5: (lv_directive_15_0= ruleFdbDirective )
                    // InternalAssembler.g:3037:6: lv_directive_15_0= ruleFdbDirective
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
                    // InternalAssembler.g:3055:4: ( (lv_directive_16_0= ruleFccDirective ) )
                    {
                    // InternalAssembler.g:3055:4: ( (lv_directive_16_0= ruleFccDirective ) )
                    // InternalAssembler.g:3056:5: (lv_directive_16_0= ruleFccDirective )
                    {
                    // InternalAssembler.g:3056:5: (lv_directive_16_0= ruleFccDirective )
                    // InternalAssembler.g:3057:6: lv_directive_16_0= ruleFccDirective
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
                    // InternalAssembler.g:3075:4: ( (lv_directive_17_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:3075:4: ( (lv_directive_17_0= ruleRmbDirective ) )
                    // InternalAssembler.g:3076:5: (lv_directive_17_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:3076:5: (lv_directive_17_0= ruleRmbDirective )
                    // InternalAssembler.g:3077:6: lv_directive_17_0= ruleRmbDirective
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

            // InternalAssembler.g:3095:3: (this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_WS) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // InternalAssembler.g:3096:4: this_WS_18= RULE_WS ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_18, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:3100:4: ( (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:3101:5: (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:3101:5: (lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:3102:6: lv_comment_19_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:3119:3: (this_WS_20= RULE_WS )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_WS) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalAssembler.g:3120:4: this_WS_20= RULE_WS
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
    // InternalAssembler.g:3136:1: entryRuleFccDirective returns [EObject current=null] : iv_ruleFccDirective= ruleFccDirective EOF ;
    public final EObject entryRuleFccDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFccDirective = null;


        try {
            // InternalAssembler.g:3136:53: (iv_ruleFccDirective= ruleFccDirective EOF )
            // InternalAssembler.g:3137:2: iv_ruleFccDirective= ruleFccDirective EOF
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
    // InternalAssembler.g:3143:1: ruleFccDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleFccDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_string_2_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3149:2: ( ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) ) )
            // InternalAssembler.g:3150:2: ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) )
            {
            // InternalAssembler.g:3150:2: ( ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) ) )
            // InternalAssembler.g:3151:3: ( (lv_directive_0_0= 'FCC' ) ) (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) )
            {
            // InternalAssembler.g:3151:3: ( (lv_directive_0_0= 'FCC' ) )
            // InternalAssembler.g:3152:4: (lv_directive_0_0= 'FCC' )
            {
            // InternalAssembler.g:3152:4: (lv_directive_0_0= 'FCC' )
            // InternalAssembler.g:3153:5: lv_directive_0_0= 'FCC'
            {
            lv_directive_0_0=(Token)match(input,48,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:3165:3: (this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) ) )
            // InternalAssembler.g:3166:4: this_WS_1= RULE_WS ( (lv_string_2_0= RULE_STRING ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFccDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:3170:4: ( (lv_string_2_0= RULE_STRING ) )
            // InternalAssembler.g:3171:5: (lv_string_2_0= RULE_STRING )
            {
            // InternalAssembler.g:3171:5: (lv_string_2_0= RULE_STRING )
            // InternalAssembler.g:3172:6: lv_string_2_0= RULE_STRING
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
    // InternalAssembler.g:3193:1: entryRuleRegDirective returns [EObject current=null] : iv_ruleRegDirective= ruleRegDirective EOF ;
    public final EObject entryRuleRegDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegDirective = null;


        try {
            // InternalAssembler.g:3193:53: (iv_ruleRegDirective= ruleRegDirective EOF )
            // InternalAssembler.g:3194:2: iv_ruleRegDirective= ruleRegDirective EOF
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
    // InternalAssembler.g:3200:1: ruleRegDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? ) ;
    public final EObject ruleRegDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_options_2_0 = null;

        Enumerator lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3206:2: ( ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? ) )
            // InternalAssembler.g:3207:2: ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? )
            {
            // InternalAssembler.g:3207:2: ( ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )? )
            // InternalAssembler.g:3208:3: ( (lv_directive_0_0= 'REG' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )?
            {
            // InternalAssembler.g:3208:3: ( (lv_directive_0_0= 'REG' ) )
            // InternalAssembler.g:3209:4: (lv_directive_0_0= 'REG' )
            {
            // InternalAssembler.g:3209:4: (lv_directive_0_0= 'REG' )
            // InternalAssembler.g:3210:5: lv_directive_0_0= 'REG'
            {
            lv_directive_0_0=(Token)match(input,49,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:3222:3: (this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_WS) ) {
                int LA50_1 = input.LA(2);

                if ( ((LA50_1>=36 && LA50_1<=42)||(LA50_1>=84 && LA50_1<=86)) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // InternalAssembler.g:3223:4: this_WS_1= RULE_WS ( (lv_options_2_0= ruleRegister ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )*
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getRegDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3227:4: ( (lv_options_2_0= ruleRegister ) )
                    // InternalAssembler.g:3228:5: (lv_options_2_0= ruleRegister )
                    {
                    // InternalAssembler.g:3228:5: (lv_options_2_0= ruleRegister )
                    // InternalAssembler.g:3229:6: lv_options_2_0= ruleRegister
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRegDirectiveAccess().getOptionsRegisterEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
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

                    // InternalAssembler.g:3246:4: (otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==35) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalAssembler.g:3247:5: otherlv_3= ',' ( (lv_options_4_0= ruleRegister ) )
                    	    {
                    	    otherlv_3=(Token)match(input,35,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getRegDirectiveAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:3251:5: ( (lv_options_4_0= ruleRegister ) )
                    	    // InternalAssembler.g:3252:6: (lv_options_4_0= ruleRegister )
                    	    {
                    	    // InternalAssembler.g:3252:6: (lv_options_4_0= ruleRegister )
                    	    // InternalAssembler.g:3253:7: lv_options_4_0= ruleRegister
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRegDirectiveAccess().getOptionsRegisterEnumRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_24);
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
                    	    break loop49;
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
    // InternalAssembler.g:3276:1: entryRuleSpcDirective returns [EObject current=null] : iv_ruleSpcDirective= ruleSpcDirective EOF ;
    public final EObject entryRuleSpcDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpcDirective = null;


        try {
            // InternalAssembler.g:3276:53: (iv_ruleSpcDirective= ruleSpcDirective EOF )
            // InternalAssembler.g:3277:2: iv_ruleSpcDirective= ruleSpcDirective EOF
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
    // InternalAssembler.g:3283:1: ruleSpcDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? ) ;
    public final EObject ruleSpcDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        EObject lv_spaceCount_2_0 = null;

        EObject lv_keepCount_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3289:2: ( ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? ) )
            // InternalAssembler.g:3290:2: ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? )
            {
            // InternalAssembler.g:3290:2: ( ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )? )
            // InternalAssembler.g:3291:3: ( (lv_directive_0_0= 'SPC' ) ) (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )?
            {
            // InternalAssembler.g:3291:3: ( (lv_directive_0_0= 'SPC' ) )
            // InternalAssembler.g:3292:4: (lv_directive_0_0= 'SPC' )
            {
            // InternalAssembler.g:3292:4: (lv_directive_0_0= 'SPC' )
            // InternalAssembler.g:3293:5: lv_directive_0_0= 'SPC'
            {
            lv_directive_0_0=(Token)match(input,50,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:3305:3: (this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )? )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_WS) ) {
                int LA52_1 = input.LA(2);

                if ( ((LA52_1>=RULE_ID && LA52_1<=RULE_CHARACTER)||LA52_1==43||LA52_1==45||(LA52_1>=74 && LA52_1<=75)) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalAssembler.g:3306:4: this_WS_1= RULE_WS ( (lv_spaceCount_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )?
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getSpcDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3310:4: ( (lv_spaceCount_2_0= ruleExpression ) )
                    // InternalAssembler.g:3311:5: (lv_spaceCount_2_0= ruleExpression )
                    {
                    // InternalAssembler.g:3311:5: (lv_spaceCount_2_0= ruleExpression )
                    // InternalAssembler.g:3312:6: lv_spaceCount_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSpcDirectiveAccess().getSpaceCountExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
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

                    // InternalAssembler.g:3329:4: (otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==35) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalAssembler.g:3330:5: otherlv_3= ',' ( (lv_keepCount_4_0= ruleExpression ) )
                            {
                            otherlv_3=(Token)match(input,35,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getSpcDirectiveAccess().getCommaKeyword_1_2_0());
                              				
                            }
                            // InternalAssembler.g:3334:5: ( (lv_keepCount_4_0= ruleExpression ) )
                            // InternalAssembler.g:3335:6: (lv_keepCount_4_0= ruleExpression )
                            {
                            // InternalAssembler.g:3335:6: (lv_keepCount_4_0= ruleExpression )
                            // InternalAssembler.g:3336:7: lv_keepCount_4_0= ruleExpression
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
    // InternalAssembler.g:3359:1: entryRuleNamDirective returns [EObject current=null] : iv_ruleNamDirective= ruleNamDirective EOF ;
    public final EObject entryRuleNamDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamDirective = null;


        try {
            // InternalAssembler.g:3359:53: (iv_ruleNamDirective= ruleNamDirective EOF )
            // InternalAssembler.g:3360:2: iv_ruleNamDirective= ruleNamDirective EOF
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
    // InternalAssembler.g:3366:1: ruleNamDirective returns [EObject current=null] : ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) ) ;
    public final EObject ruleNamDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token lv_directive_1_0=null;
        Token this_WS_2=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3372:2: ( ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:3373:2: ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:3373:2: ( ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) ) )
            // InternalAssembler.g:3374:3: ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) ) this_WS_2= RULE_WS ( (lv_operand_3_0= ruleIdentifierValue ) )
            {
            // InternalAssembler.g:3374:3: ( ( (lv_directive_0_0= 'NAM' ) ) | ( (lv_directive_1_0= 'TTL' ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==51) ) {
                alt53=1;
            }
            else if ( (LA53_0==52) ) {
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
                    // InternalAssembler.g:3375:4: ( (lv_directive_0_0= 'NAM' ) )
                    {
                    // InternalAssembler.g:3375:4: ( (lv_directive_0_0= 'NAM' ) )
                    // InternalAssembler.g:3376:5: (lv_directive_0_0= 'NAM' )
                    {
                    // InternalAssembler.g:3376:5: (lv_directive_0_0= 'NAM' )
                    // InternalAssembler.g:3377:6: lv_directive_0_0= 'NAM'
                    {
                    lv_directive_0_0=(Token)match(input,51,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:3390:4: ( (lv_directive_1_0= 'TTL' ) )
                    {
                    // InternalAssembler.g:3390:4: ( (lv_directive_1_0= 'TTL' ) )
                    // InternalAssembler.g:3391:5: (lv_directive_1_0= 'TTL' )
                    {
                    // InternalAssembler.g:3391:5: (lv_directive_1_0= 'TTL' )
                    // InternalAssembler.g:3392:6: lv_directive_1_0= 'TTL'
                    {
                    lv_directive_1_0=(Token)match(input,52,FOLLOW_5); if (state.failed) return current;
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

            this_WS_2=(Token)match(input,RULE_WS,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_2, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:3409:3: ( (lv_operand_3_0= ruleIdentifierValue ) )
            // InternalAssembler.g:3410:4: (lv_operand_3_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:3410:4: (lv_operand_3_0= ruleIdentifierValue )
            // InternalAssembler.g:3411:5: lv_operand_3_0= ruleIdentifierValue
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
    // InternalAssembler.g:3432:1: entryRulePagDirective returns [EObject current=null] : iv_rulePagDirective= rulePagDirective EOF ;
    public final EObject entryRulePagDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePagDirective = null;


        try {
            // InternalAssembler.g:3432:53: (iv_rulePagDirective= rulePagDirective EOF )
            // InternalAssembler.g:3433:2: iv_rulePagDirective= rulePagDirective EOF
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
    // InternalAssembler.g:3439:1: rulePagDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? ) ;
    public final EObject rulePagDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3445:2: ( ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? ) )
            // InternalAssembler.g:3446:2: ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? )
            {
            // InternalAssembler.g:3446:2: ( ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )? )
            // InternalAssembler.g:3447:3: ( (lv_directive_0_0= 'PAG' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )?
            {
            // InternalAssembler.g:3447:3: ( (lv_directive_0_0= 'PAG' ) )
            // InternalAssembler.g:3448:4: (lv_directive_0_0= 'PAG' )
            {
            // InternalAssembler.g:3448:4: (lv_directive_0_0= 'PAG' )
            // InternalAssembler.g:3449:5: lv_directive_0_0= 'PAG'
            {
            lv_directive_0_0=(Token)match(input,53,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:3461:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_WS) ) {
                int LA54_1 = input.LA(2);

                if ( ((LA54_1>=RULE_ID && LA54_1<=RULE_CHARACTER)||LA54_1==43||LA54_1==45||(LA54_1>=74 && LA54_1<=75)) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalAssembler.g:3462:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3466:4: ( (lv_operand_2_0= ruleExpression ) )
                    // InternalAssembler.g:3467:5: (lv_operand_2_0= ruleExpression )
                    {
                    // InternalAssembler.g:3467:5: (lv_operand_2_0= ruleExpression )
                    // InternalAssembler.g:3468:6: lv_operand_2_0= ruleExpression
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
    // InternalAssembler.g:3490:1: entryRuleOptDirective returns [EObject current=null] : iv_ruleOptDirective= ruleOptDirective EOF ;
    public final EObject entryRuleOptDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptDirective = null;


        try {
            // InternalAssembler.g:3490:53: (iv_ruleOptDirective= ruleOptDirective EOF )
            // InternalAssembler.g:3491:2: iv_ruleOptDirective= ruleOptDirective EOF
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
    // InternalAssembler.g:3497:1: ruleOptDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? ) ;
    public final EObject ruleOptDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        Enumerator lv_options_2_0 = null;

        Enumerator lv_options_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3503:2: ( ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? ) )
            // InternalAssembler.g:3504:2: ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? )
            {
            // InternalAssembler.g:3504:2: ( ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )? )
            // InternalAssembler.g:3505:3: ( (lv_directive_0_0= 'OPT' ) ) (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )?
            {
            // InternalAssembler.g:3505:3: ( (lv_directive_0_0= 'OPT' ) )
            // InternalAssembler.g:3506:4: (lv_directive_0_0= 'OPT' )
            {
            // InternalAssembler.g:3506:4: (lv_directive_0_0= 'OPT' )
            // InternalAssembler.g:3507:5: lv_directive_0_0= 'OPT'
            {
            lv_directive_0_0=(Token)match(input,54,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:3519:3: (this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_WS) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==53||(LA56_1>=77 && LA56_1<=83)) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // InternalAssembler.g:3520:4: this_WS_1= RULE_WS ( (lv_options_2_0= ruleAssemblyOption ) ) (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )*
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3524:4: ( (lv_options_2_0= ruleAssemblyOption ) )
                    // InternalAssembler.g:3525:5: (lv_options_2_0= ruleAssemblyOption )
                    {
                    // InternalAssembler.g:3525:5: (lv_options_2_0= ruleAssemblyOption )
                    // InternalAssembler.g:3526:6: lv_options_2_0= ruleAssemblyOption
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
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

                    // InternalAssembler.g:3543:4: (otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==35) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalAssembler.g:3544:5: otherlv_3= ',' ( (lv_options_4_0= ruleAssemblyOption ) )
                    	    {
                    	    otherlv_3=(Token)match(input,35,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getOptDirectiveAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:3548:5: ( (lv_options_4_0= ruleAssemblyOption ) )
                    	    // InternalAssembler.g:3549:6: (lv_options_4_0= ruleAssemblyOption )
                    	    {
                    	    // InternalAssembler.g:3549:6: (lv_options_4_0= ruleAssemblyOption )
                    	    // InternalAssembler.g:3550:7: lv_options_4_0= ruleAssemblyOption
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_24);
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
                    	    break loop55;
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
    // InternalAssembler.g:3573:1: entryRuleFailDirective returns [EObject current=null] : iv_ruleFailDirective= ruleFailDirective EOF ;
    public final EObject entryRuleFailDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailDirective = null;


        try {
            // InternalAssembler.g:3573:54: (iv_ruleFailDirective= ruleFailDirective EOF )
            // InternalAssembler.g:3574:2: iv_ruleFailDirective= ruleFailDirective EOF
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
    // InternalAssembler.g:3580:1: ruleFailDirective returns [EObject current=null] : ( (lv_directive_0_0= 'FAIL' ) ) ;
    public final EObject ruleFailDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3586:2: ( ( (lv_directive_0_0= 'FAIL' ) ) )
            // InternalAssembler.g:3587:2: ( (lv_directive_0_0= 'FAIL' ) )
            {
            // InternalAssembler.g:3587:2: ( (lv_directive_0_0= 'FAIL' ) )
            // InternalAssembler.g:3588:3: (lv_directive_0_0= 'FAIL' )
            {
            // InternalAssembler.g:3588:3: (lv_directive_0_0= 'FAIL' )
            // InternalAssembler.g:3589:4: lv_directive_0_0= 'FAIL'
            {
            lv_directive_0_0=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3604:1: entryRuleSetDirective returns [EObject current=null] : iv_ruleSetDirective= ruleSetDirective EOF ;
    public final EObject entryRuleSetDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDirective = null;


        try {
            // InternalAssembler.g:3604:53: (iv_ruleSetDirective= ruleSetDirective EOF )
            // InternalAssembler.g:3605:2: iv_ruleSetDirective= ruleSetDirective EOF
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
    // InternalAssembler.g:3611:1: ruleSetDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) ;
    public final EObject ruleSetDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3617:2: ( ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) )
            // InternalAssembler.g:3618:2: ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            {
            // InternalAssembler.g:3618:2: ( ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            // InternalAssembler.g:3619:3: ( (lv_directive_0_0= 'SET' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            {
            // InternalAssembler.g:3619:3: ( (lv_directive_0_0= 'SET' ) )
            // InternalAssembler.g:3620:4: (lv_directive_0_0= 'SET' )
            {
            // InternalAssembler.g:3620:4: (lv_directive_0_0= 'SET' )
            // InternalAssembler.g:3621:5: lv_directive_0_0= 'SET'
            {
            lv_directive_0_0=(Token)match(input,56,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:3637:3: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==57) ) {
                int LA58_1 = input.LA(2);

                if ( ((LA58_1>=RULE_ID && LA58_1<=RULE_CHARACTER)||LA58_1==43||LA58_1==45||(LA58_1>=74 && LA58_1<=75)) ) {
                    alt58=1;
                }
                else if ( (LA58_1==EOF||LA58_1==RULE_WS||(LA58_1>=RULE_CR && LA58_1<=RULE_END_OF_FILE)) ) {
                    alt58=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA58_0>=RULE_ID && LA58_0<=RULE_CHARACTER)||LA58_0==43||LA58_0==45||(LA58_0>=74 && LA58_0<=75)) ) {
                alt58=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalAssembler.g:3638:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:3638:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:3639:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:3639:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==57) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // InternalAssembler.g:3640:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:3640:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:3641:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,57,FOLLOW_11); if (state.failed) return current;
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

                    // InternalAssembler.g:3653:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:3654:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:3654:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:3655:7: lv_operand_3_0= ruleExpression
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
                    // InternalAssembler.g:3674:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    {
                    // InternalAssembler.g:3674:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    // InternalAssembler.g:3675:5: (lv_isRelativeToPC_4_0= '*' )
                    {
                    // InternalAssembler.g:3675:5: (lv_isRelativeToPC_4_0= '*' )
                    // InternalAssembler.g:3676:6: lv_isRelativeToPC_4_0= '*'
                    {
                    lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:3693:1: entryRuleFillDirective returns [EObject current=null] : iv_ruleFillDirective= ruleFillDirective EOF ;
    public final EObject entryRuleFillDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFillDirective = null;


        try {
            // InternalAssembler.g:3693:54: (iv_ruleFillDirective= ruleFillDirective EOF )
            // InternalAssembler.g:3694:2: iv_ruleFillDirective= ruleFillDirective EOF
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
    // InternalAssembler.g:3700:1: ruleFillDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) ) ;
    public final EObject ruleFillDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;

        EObject lv_number_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3706:2: ( ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) ) )
            // InternalAssembler.g:3707:2: ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) )
            {
            // InternalAssembler.g:3707:2: ( ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) ) )
            // InternalAssembler.g:3708:3: ( (lv_directive_0_0= 'FILL' ) ) (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:3708:3: ( (lv_directive_0_0= 'FILL' ) )
            // InternalAssembler.g:3709:4: (lv_directive_0_0= 'FILL' )
            {
            // InternalAssembler.g:3709:4: (lv_directive_0_0= 'FILL' )
            // InternalAssembler.g:3710:5: lv_directive_0_0= 'FILL'
            {
            lv_directive_0_0=(Token)match(input,58,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:3722:3: (this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) ) )
            // InternalAssembler.g:3723:4: this_WS_1= RULE_WS ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_number_4_0= ruleExpression ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:3727:4: ( (lv_value_2_0= ruleExpression ) )
            // InternalAssembler.g:3728:5: (lv_value_2_0= ruleExpression )
            {
            // InternalAssembler.g:3728:5: (lv_value_2_0= ruleExpression )
            // InternalAssembler.g:3729:6: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getFillDirectiveAccess().getValueExpressionParserRuleCall_1_1_0());
              					
            }
            pushFollow(FOLLOW_13);
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

            otherlv_3=(Token)match(input,35,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_3, grammarAccess.getFillDirectiveAccess().getCommaKeyword_1_2());
              			
            }
            // InternalAssembler.g:3750:4: ( (lv_number_4_0= ruleExpression ) )
            // InternalAssembler.g:3751:5: (lv_number_4_0= ruleExpression )
            {
            // InternalAssembler.g:3751:5: (lv_number_4_0= ruleExpression )
            // InternalAssembler.g:3752:6: lv_number_4_0= ruleExpression
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
    // InternalAssembler.g:3774:1: entryRuleBszDirective returns [EObject current=null] : iv_ruleBszDirective= ruleBszDirective EOF ;
    public final EObject entryRuleBszDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBszDirective = null;


        try {
            // InternalAssembler.g:3774:53: (iv_ruleBszDirective= ruleBszDirective EOF )
            // InternalAssembler.g:3775:2: iv_ruleBszDirective= ruleBszDirective EOF
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
    // InternalAssembler.g:3781:1: ruleBszDirective returns [EObject current=null] : ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) ) ;
    public final EObject ruleBszDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_1=null;
        Token lv_directive_0_2=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3787:2: ( ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) ) )
            // InternalAssembler.g:3788:2: ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) )
            {
            // InternalAssembler.g:3788:2: ( ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) ) )
            // InternalAssembler.g:3789:3: ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )
            {
            // InternalAssembler.g:3789:3: ( ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) ) )
            // InternalAssembler.g:3790:4: ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) )
            {
            // InternalAssembler.g:3790:4: ( (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' ) )
            // InternalAssembler.g:3791:5: (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' )
            {
            // InternalAssembler.g:3791:5: (lv_directive_0_1= 'BSZ' | lv_directive_0_2= 'ZMB' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==59) ) {
                alt59=1;
            }
            else if ( (LA59_0==60) ) {
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
                    // InternalAssembler.g:3792:6: lv_directive_0_1= 'BSZ'
                    {
                    lv_directive_0_1=(Token)match(input,59,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:3803:6: lv_directive_0_2= 'ZMB'
                    {
                    lv_directive_0_2=(Token)match(input,60,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:3816:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) ) )
            // InternalAssembler.g:3817:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleExpression ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:3821:4: ( (lv_operand_2_0= ruleExpression ) )
            // InternalAssembler.g:3822:5: (lv_operand_2_0= ruleExpression )
            {
            // InternalAssembler.g:3822:5: (lv_operand_2_0= ruleExpression )
            // InternalAssembler.g:3823:6: lv_operand_2_0= ruleExpression
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
    // InternalAssembler.g:3845:1: entryRuleFdbDirective returns [EObject current=null] : iv_ruleFdbDirective= ruleFdbDirective EOF ;
    public final EObject entryRuleFdbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFdbDirective = null;


        try {
            // InternalAssembler.g:3845:53: (iv_ruleFdbDirective= ruleFdbDirective EOF )
            // InternalAssembler.g:3846:2: iv_ruleFdbDirective= ruleFdbDirective EOF
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
    // InternalAssembler.g:3852:1: ruleFdbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) ;
    public final EObject ruleFdbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3858:2: ( ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) )
            // InternalAssembler.g:3859:2: ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            {
            // InternalAssembler.g:3859:2: ( ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            // InternalAssembler.g:3860:3: ( (lv_directive_0_0= 'FDB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            {
            // InternalAssembler.g:3860:3: ( (lv_directive_0_0= 'FDB' ) )
            // InternalAssembler.g:3861:4: (lv_directive_0_0= 'FDB' )
            {
            // InternalAssembler.g:3861:4: (lv_directive_0_0= 'FDB' )
            // InternalAssembler.g:3862:5: lv_directive_0_0= 'FDB'
            {
            lv_directive_0_0=(Token)match(input,61,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:3874:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_WS) ) {
                int LA60_1 = input.LA(2);

                if ( ((LA60_1>=RULE_ID && LA60_1<=RULE_CHARACTER)||LA60_1==43||LA60_1==45||(LA60_1>=74 && LA60_1<=75)) ) {
                    alt60=1;
                }
            }
            switch (alt60) {
                case 1 :
                    // InternalAssembler.g:3875:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3879:4: ( (lv_operand_2_0= ruleListOfExpression ) )
                    // InternalAssembler.g:3880:5: (lv_operand_2_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:3880:5: (lv_operand_2_0= ruleListOfExpression )
                    // InternalAssembler.g:3881:6: lv_operand_2_0= ruleListOfExpression
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
    // InternalAssembler.g:3903:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:3903:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:3904:2: iv_ruleFcbDirective= ruleFcbDirective EOF
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
    // InternalAssembler.g:3910:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) ;
    public final EObject ruleFcbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3916:2: ( ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? ) )
            // InternalAssembler.g:3917:2: ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            {
            // InternalAssembler.g:3917:2: ( ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )? )
            // InternalAssembler.g:3918:3: ( (lv_directive_0_0= 'FCB' ) ) (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            {
            // InternalAssembler.g:3918:3: ( (lv_directive_0_0= 'FCB' ) )
            // InternalAssembler.g:3919:4: (lv_directive_0_0= 'FCB' )
            {
            // InternalAssembler.g:3919:4: (lv_directive_0_0= 'FCB' )
            // InternalAssembler.g:3920:5: lv_directive_0_0= 'FCB'
            {
            lv_directive_0_0=(Token)match(input,62,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:3932:3: (this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_WS) ) {
                int LA61_1 = input.LA(2);

                if ( ((LA61_1>=RULE_ID && LA61_1<=RULE_CHARACTER)||LA61_1==43||LA61_1==45||(LA61_1>=74 && LA61_1<=75)) ) {
                    alt61=1;
                }
            }
            switch (alt61) {
                case 1 :
                    // InternalAssembler.g:3933:4: this_WS_1= RULE_WS ( (lv_operand_2_0= ruleListOfExpression ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3937:4: ( (lv_operand_2_0= ruleListOfExpression ) )
                    // InternalAssembler.g:3938:5: (lv_operand_2_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:3938:5: (lv_operand_2_0= ruleListOfExpression )
                    // InternalAssembler.g:3939:6: lv_operand_2_0= ruleListOfExpression
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
    // InternalAssembler.g:3961:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:3961:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:3962:2: iv_ruleRmbDirective= ruleRmbDirective EOF
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
    // InternalAssembler.g:3968:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? ) ;
    public final EObject ruleRmbDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:3974:2: ( ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? ) )
            // InternalAssembler.g:3975:2: ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? )
            {
            // InternalAssembler.g:3975:2: ( ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )? )
            // InternalAssembler.g:3976:3: ( (lv_directive_0_0= 'RMB' ) ) (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )?
            {
            // InternalAssembler.g:3976:3: ( (lv_directive_0_0= 'RMB' ) )
            // InternalAssembler.g:3977:4: (lv_directive_0_0= 'RMB' )
            {
            // InternalAssembler.g:3977:4: (lv_directive_0_0= 'RMB' )
            // InternalAssembler.g:3978:5: lv_directive_0_0= 'RMB'
            {
            lv_directive_0_0=(Token)match(input,63,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:3990:3: (this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_WS) ) {
                int LA63_1 = input.LA(2);

                if ( ((LA63_1>=RULE_ID && LA63_1<=RULE_CHARACTER)||LA63_1==43||LA63_1==45||LA63_1==57||(LA63_1>=74 && LA63_1<=75)) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // InternalAssembler.g:3991:4: this_WS_1= RULE_WS ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:3995:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:3996:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:3996:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==57) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalAssembler.g:3997:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:3997:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:3998:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,57,FOLLOW_11); if (state.failed) return current;
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

                    // InternalAssembler.g:4010:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:4011:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:4011:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:4012:7: lv_operand_3_0= ruleExpression
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
    // InternalAssembler.g:4035:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:4035:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:4036:2: iv_ruleEndDirective= ruleEndDirective EOF
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
    // InternalAssembler.g:4042:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) ;
    public final EObject ruleEndDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4048:2: ( ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) )
            // InternalAssembler.g:4049:2: ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            {
            // InternalAssembler.g:4049:2: ( ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            // InternalAssembler.g:4050:3: ( (lv_directive_0_0= 'END' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            {
            // InternalAssembler.g:4050:3: ( (lv_directive_0_0= 'END' ) )
            // InternalAssembler.g:4051:4: (lv_directive_0_0= 'END' )
            {
            // InternalAssembler.g:4051:4: (lv_directive_0_0= 'END' )
            // InternalAssembler.g:4052:5: lv_directive_0_0= 'END'
            {
            lv_directive_0_0=(Token)match(input,64,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:4064:3: (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_WS) ) {
                int LA66_1 = input.LA(2);

                if ( ((LA66_1>=RULE_ID && LA66_1<=RULE_CHARACTER)||LA66_1==43||LA66_1==45||LA66_1==57||(LA66_1>=74 && LA66_1<=75)) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // InternalAssembler.g:4065:4: this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4069:4: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==57) ) {
                        int LA65_1 = input.LA(2);

                        if ( (LA65_1==EOF||LA65_1==RULE_WS||(LA65_1>=RULE_CR && LA65_1<=RULE_END_OF_FILE)) ) {
                            alt65=2;
                        }
                        else if ( ((LA65_1>=RULE_ID && LA65_1<=RULE_CHARACTER)||LA65_1==43||LA65_1==45||(LA65_1>=74 && LA65_1<=75)) ) {
                            alt65=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 65, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA65_0>=RULE_ID && LA65_0<=RULE_CHARACTER)||LA65_0==43||LA65_0==45||(LA65_0>=74 && LA65_0<=75)) ) {
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
                            // InternalAssembler.g:4070:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:4070:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            // InternalAssembler.g:4071:6: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:4071:6: ( (lv_isRelativeToPC_2_0= '*' ) )?
                            int alt64=2;
                            int LA64_0 = input.LA(1);

                            if ( (LA64_0==57) ) {
                                alt64=1;
                            }
                            switch (alt64) {
                                case 1 :
                                    // InternalAssembler.g:4072:7: (lv_isRelativeToPC_2_0= '*' )
                                    {
                                    // InternalAssembler.g:4072:7: (lv_isRelativeToPC_2_0= '*' )
                                    // InternalAssembler.g:4073:8: lv_isRelativeToPC_2_0= '*'
                                    {
                                    lv_isRelativeToPC_2_0=(Token)match(input,57,FOLLOW_11); if (state.failed) return current;
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

                            // InternalAssembler.g:4085:6: ( (lv_operand_3_0= ruleExpression ) )
                            // InternalAssembler.g:4086:7: (lv_operand_3_0= ruleExpression )
                            {
                            // InternalAssembler.g:4086:7: (lv_operand_3_0= ruleExpression )
                            // InternalAssembler.g:4087:8: lv_operand_3_0= ruleExpression
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
                            // InternalAssembler.g:4106:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            {
                            // InternalAssembler.g:4106:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            // InternalAssembler.g:4107:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:4107:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:4108:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4126:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:4126:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:4127:2: iv_ruleOrgDirective= ruleOrgDirective EOF
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
    // InternalAssembler.g:4133:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) ;
    public final EObject ruleOrgDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4139:2: ( ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? ) )
            // InternalAssembler.g:4140:2: ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            {
            // InternalAssembler.g:4140:2: ( ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )? )
            // InternalAssembler.g:4141:3: ( (lv_directive_0_0= 'ORG' ) ) (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            {
            // InternalAssembler.g:4141:3: ( (lv_directive_0_0= 'ORG' ) )
            // InternalAssembler.g:4142:4: (lv_directive_0_0= 'ORG' )
            {
            // InternalAssembler.g:4142:4: (lv_directive_0_0= 'ORG' )
            // InternalAssembler.g:4143:5: lv_directive_0_0= 'ORG'
            {
            lv_directive_0_0=(Token)match(input,65,FOLLOW_22); if (state.failed) return current;
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

            // InternalAssembler.g:4155:3: (this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_WS) ) {
                int LA69_1 = input.LA(2);

                if ( ((LA69_1>=RULE_ID && LA69_1<=RULE_CHARACTER)||LA69_1==43||LA69_1==45||LA69_1==57||(LA69_1>=74 && LA69_1<=75)) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // InternalAssembler.g:4156:4: this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1_0());
                      			
                    }
                    // InternalAssembler.g:4160:4: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==57) ) {
                        int LA68_1 = input.LA(2);

                        if ( ((LA68_1>=RULE_ID && LA68_1<=RULE_CHARACTER)||LA68_1==43||LA68_1==45||(LA68_1>=74 && LA68_1<=75)) ) {
                            alt68=1;
                        }
                        else if ( (LA68_1==EOF||LA68_1==RULE_WS||(LA68_1>=RULE_CR && LA68_1<=RULE_END_OF_FILE)) ) {
                            alt68=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 68, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA68_0>=RULE_ID && LA68_0<=RULE_CHARACTER)||LA68_0==43||LA68_0==45||(LA68_0>=74 && LA68_0<=75)) ) {
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
                            // InternalAssembler.g:4161:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:4161:5: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                            // InternalAssembler.g:4162:6: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:4162:6: ( (lv_isRelativeToPC_2_0= '*' ) )?
                            int alt67=2;
                            int LA67_0 = input.LA(1);

                            if ( (LA67_0==57) ) {
                                alt67=1;
                            }
                            switch (alt67) {
                                case 1 :
                                    // InternalAssembler.g:4163:7: (lv_isRelativeToPC_2_0= '*' )
                                    {
                                    // InternalAssembler.g:4163:7: (lv_isRelativeToPC_2_0= '*' )
                                    // InternalAssembler.g:4164:8: lv_isRelativeToPC_2_0= '*'
                                    {
                                    lv_isRelativeToPC_2_0=(Token)match(input,57,FOLLOW_11); if (state.failed) return current;
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

                            // InternalAssembler.g:4176:6: ( (lv_operand_3_0= ruleExpression ) )
                            // InternalAssembler.g:4177:7: (lv_operand_3_0= ruleExpression )
                            {
                            // InternalAssembler.g:4177:7: (lv_operand_3_0= ruleExpression )
                            // InternalAssembler.g:4178:8: lv_operand_3_0= ruleExpression
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
                            // InternalAssembler.g:4197:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            {
                            // InternalAssembler.g:4197:5: ( (lv_isRelativeToPC_4_0= '*' ) )
                            // InternalAssembler.g:4198:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:4198:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:4199:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4217:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:4217:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:4218:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:4224:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) ;
    public final EObject ruleEquDirective() throws RecognitionException {
        EObject current = null;

        Token lv_directive_0_0=null;
        Token this_WS_1=null;
        Token lv_isRelativeToPC_2_0=null;
        Token lv_isRelativeToPC_4_0=null;
        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4230:2: ( ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) ) )
            // InternalAssembler.g:4231:2: ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            {
            // InternalAssembler.g:4231:2: ( ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) ) )
            // InternalAssembler.g:4232:3: ( (lv_directive_0_0= 'EQU' ) ) this_WS_1= RULE_WS ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            {
            // InternalAssembler.g:4232:3: ( (lv_directive_0_0= 'EQU' ) )
            // InternalAssembler.g:4233:4: (lv_directive_0_0= 'EQU' )
            {
            // InternalAssembler.g:4233:4: (lv_directive_0_0= 'EQU' )
            // InternalAssembler.g:4234:5: lv_directive_0_0= 'EQU'
            {
            lv_directive_0_0=(Token)match(input,66,FOLLOW_5); if (state.failed) return current;
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
            // InternalAssembler.g:4250:3: ( ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_4_0= '*' ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==57) ) {
                int LA71_1 = input.LA(2);

                if ( ((LA71_1>=RULE_ID && LA71_1<=RULE_CHARACTER)||LA71_1==43||LA71_1==45||(LA71_1>=74 && LA71_1<=75)) ) {
                    alt71=1;
                }
                else if ( (LA71_1==EOF||LA71_1==RULE_WS||(LA71_1>=RULE_CR && LA71_1<=RULE_END_OF_FILE)) ) {
                    alt71=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA71_0>=RULE_ID && LA71_0<=RULE_CHARACTER)||LA71_0==43||LA71_0==45||(LA71_0>=74 && LA71_0<=75)) ) {
                alt71=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalAssembler.g:4251:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:4251:4: ( ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) ) )
                    // InternalAssembler.g:4252:5: ( (lv_isRelativeToPC_2_0= '*' ) )? ( (lv_operand_3_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:4252:5: ( (lv_isRelativeToPC_2_0= '*' ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==57) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // InternalAssembler.g:4253:6: (lv_isRelativeToPC_2_0= '*' )
                            {
                            // InternalAssembler.g:4253:6: (lv_isRelativeToPC_2_0= '*' )
                            // InternalAssembler.g:4254:7: lv_isRelativeToPC_2_0= '*'
                            {
                            lv_isRelativeToPC_2_0=(Token)match(input,57,FOLLOW_11); if (state.failed) return current;
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

                    // InternalAssembler.g:4266:5: ( (lv_operand_3_0= ruleExpression ) )
                    // InternalAssembler.g:4267:6: (lv_operand_3_0= ruleExpression )
                    {
                    // InternalAssembler.g:4267:6: (lv_operand_3_0= ruleExpression )
                    // InternalAssembler.g:4268:7: lv_operand_3_0= ruleExpression
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
                    // InternalAssembler.g:4287:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    {
                    // InternalAssembler.g:4287:4: ( (lv_isRelativeToPC_4_0= '*' ) )
                    // InternalAssembler.g:4288:5: (lv_isRelativeToPC_4_0= '*' )
                    {
                    // InternalAssembler.g:4288:5: (lv_isRelativeToPC_4_0= '*' )
                    // InternalAssembler.g:4289:6: lv_isRelativeToPC_4_0= '*'
                    {
                    lv_isRelativeToPC_4_0=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:4306:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:4306:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:4307:2: iv_ruleListOfExpression= ruleListOfExpression EOF
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
    // InternalAssembler.g:4313:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4319:2: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalAssembler.g:4320:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalAssembler.g:4320:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalAssembler.g:4321:3: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalAssembler.g:4321:3: ( (lv_expressions_0_0= ruleExpression ) )
            // InternalAssembler.g:4322:4: (lv_expressions_0_0= ruleExpression )
            {
            // InternalAssembler.g:4322:4: (lv_expressions_0_0= ruleExpression )
            // InternalAssembler.g:4323:5: lv_expressions_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_24);
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

            // InternalAssembler.g:4340:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==35) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalAssembler.g:4341:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:4345:4: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalAssembler.g:4346:5: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalAssembler.g:4346:5: (lv_expressions_2_0= ruleExpression )
            	    // InternalAssembler.g:4347:6: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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
            	    break loop72;
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
    // InternalAssembler.g:4369:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:4369:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:4370:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalAssembler.g:4376:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4382:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:4383:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:4383:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:4384:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:4384:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:4385:4: lv_operand_0_0= ruleMultiplication
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
    // InternalAssembler.g:4405:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:4405:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:4406:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:4412:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4418:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:4419:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:4419:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:4420:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
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
            // InternalAssembler.g:4428:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==57) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalAssembler.g:4429:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:4429:4: ()
            	    // InternalAssembler.g:4430:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4436:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:4437:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:4437:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:4438:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,57,FOLLOW_11); if (state.failed) return current;
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

            	    // InternalAssembler.g:4450:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:4451:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:4451:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:4452:6: lv_right_3_0= ruleDivision
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
            	    break loop73;
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
    // InternalAssembler.g:4474:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:4474:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:4475:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:4481:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4487:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:4488:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:4488:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:4489:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
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
            // InternalAssembler.g:4497:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==67) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalAssembler.g:4498:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:4498:4: ()
            	    // InternalAssembler.g:4499:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4505:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:4506:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:4506:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:4507:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,67,FOLLOW_11); if (state.failed) return current;
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

            	    // InternalAssembler.g:4519:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:4520:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:4520:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:4521:6: lv_right_3_0= ruleModulo
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
            	    break loop74;
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
    // InternalAssembler.g:4543:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:4543:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:4544:2: iv_ruleModulo= ruleModulo EOF
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
    // InternalAssembler.g:4550:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4556:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:4557:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:4557:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:4558:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
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
            // InternalAssembler.g:4566:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==68) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalAssembler.g:4567:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:4567:4: ()
            	    // InternalAssembler.g:4568:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4574:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:4575:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:4575:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:4576:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,68,FOLLOW_11); if (state.failed) return current;
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

            	    // InternalAssembler.g:4588:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:4589:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:4589:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:4590:6: lv_right_3_0= ruleAddition
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
            	    break loop75;
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
    // InternalAssembler.g:4612:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:4612:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:4613:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:4619:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4625:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:4626:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:4626:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:4627:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
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
            // InternalAssembler.g:4635:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==45) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalAssembler.g:4636:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:4636:4: ()
            	    // InternalAssembler.g:4637:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,45,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4647:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:4648:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:4648:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:4649:6: lv_right_3_0= ruleSubstraction
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
            	    break loop76;
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
    // InternalAssembler.g:4671:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:4671:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:4672:2: iv_ruleSubstraction= ruleSubstraction EOF
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
    // InternalAssembler.g:4678:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4684:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:4685:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:4685:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:4686:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
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
            // InternalAssembler.g:4694:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==43) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalAssembler.g:4695:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:4695:4: ()
            	    // InternalAssembler.g:4696:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4702:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:4703:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:4709:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:4710:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:4710:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:4711:6: lv_right_3_0= ruleLeftShift
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
            	    break loop77;
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
    // InternalAssembler.g:4733:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:4733:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:4734:2: iv_ruleLeftShift= ruleLeftShift EOF
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
    // InternalAssembler.g:4740:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4746:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:4747:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:4747:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:4748:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
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
            // InternalAssembler.g:4756:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==69) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalAssembler.g:4757:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:4757:4: ()
            	    // InternalAssembler.g:4758:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,69,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4768:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:4769:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:4769:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:4770:6: lv_right_3_0= ruleRightShift
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
            	    break loop78;
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
    // InternalAssembler.g:4792:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:4792:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:4793:2: iv_ruleRightShift= ruleRightShift EOF
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
    // InternalAssembler.g:4799:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4805:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:4806:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:4806:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:4807:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
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
            // InternalAssembler.g:4815:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==70) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalAssembler.g:4816:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:4816:4: ()
            	    // InternalAssembler.g:4817:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,70,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4827:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:4828:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:4828:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:4829:6: lv_right_3_0= ruleAnd
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
    // $ANTLR end "ruleRightShift"


    // $ANTLR start "entryRuleAnd"
    // InternalAssembler.g:4851:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:4851:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:4852:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalAssembler.g:4858:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4864:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:4865:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:4865:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:4866:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
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
            // InternalAssembler.g:4874:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==71) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalAssembler.g:4875:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:4875:4: ()
            	    // InternalAssembler.g:4876:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,71,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4886:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:4887:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:4887:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:4888:6: lv_right_3_0= ruleOr
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
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleOr"
    // InternalAssembler.g:4910:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:4910:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:4911:2: iv_ruleOr= ruleOr EOF
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
    // InternalAssembler.g:4917:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4923:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:4924:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:4924:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:4925:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
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
            // InternalAssembler.g:4933:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==72) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalAssembler.g:4934:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:4934:4: ()
            	    // InternalAssembler.g:4935:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,72,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:4945:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:4946:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:4946:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:4947:6: lv_right_3_0= ruleXor
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
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleXor"
    // InternalAssembler.g:4969:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:4969:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:4970:2: iv_ruleXor= ruleXor EOF
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
    // InternalAssembler.g:4976:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:4982:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:4983:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:4983:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:4984:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
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
            // InternalAssembler.g:4992:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==73) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalAssembler.g:4993:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:4993:4: ()
            	    // InternalAssembler.g:4994:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,73,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:5004:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:5005:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:5005:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:5006:6: lv_right_3_0= rulePrimary
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
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRulePrimary"
    // InternalAssembler.g:5028:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:5028:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:5029:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:5035:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
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
            // InternalAssembler.g:5041:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:5042:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:5042:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt83=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 43:
            case 45:
                {
                alt83=1;
                }
                break;
            case RULE_HEXA:
                {
                alt83=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt83=3;
                }
                break;
            case RULE_BINARY:
                {
                alt83=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt83=5;
                }
                break;
            case RULE_ID:
                {
                alt83=6;
                }
                break;
            case 74:
                {
                alt83=7;
                }
                break;
            case 75:
                {
                alt83=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalAssembler.g:5043:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:5043:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:5044:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:5044:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:5045:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:5063:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:5063:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:5064:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:5064:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:5065:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:5083:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:5083:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:5084:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:5084:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:5085:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:5103:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:5103:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:5104:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:5104:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:5105:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:5123:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:5123:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:5124:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:5124:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:5125:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:5143:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:5143:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:5144:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5144:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:5145:5: lv_value_5_0= ruleIdentifierValue
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
                    // InternalAssembler.g:5163:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:5163:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:5164:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:5164:4: ()
                    // InternalAssembler.g:5165:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,74,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:5175:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:5176:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:5176:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:5177:6: lv_value_8_0= rulePrimary
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
                    // InternalAssembler.g:5196:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:5196:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:5197:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,75,FOLLOW_11); if (state.failed) return current;
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
    // InternalAssembler.g:5218:1: entryRuleNumericalValue returns [EObject current=null] : iv_ruleNumericalValue= ruleNumericalValue EOF ;
    public final EObject entryRuleNumericalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalValue = null;


        try {
            // InternalAssembler.g:5218:55: (iv_ruleNumericalValue= ruleNumericalValue EOF )
            // InternalAssembler.g:5219:2: iv_ruleNumericalValue= ruleNumericalValue EOF
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
    // InternalAssembler.g:5225:1: ruleNumericalValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) ;
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
            // InternalAssembler.g:5231:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) ) )
            // InternalAssembler.g:5232:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            {
            // InternalAssembler.g:5232:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) )
            int alt84=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 43:
            case 45:
                {
                alt84=1;
                }
                break;
            case RULE_HEXA:
                {
                alt84=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt84=3;
                }
                break;
            case RULE_BINARY:
                {
                alt84=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt84=5;
                }
                break;
            case RULE_ID:
                {
                alt84=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalAssembler.g:5233:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:5233:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:5234:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:5234:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:5235:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:5253:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:5253:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:5254:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:5254:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:5255:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:5273:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:5273:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:5274:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:5274:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:5275:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:5293:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:5293:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:5294:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:5294:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:5295:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:5313:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:5313:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:5314:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:5314:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:5315:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:5333:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:5333:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:5334:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:5334:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:5335:5: lv_value_5_0= ruleIdentifierValue
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
    // InternalAssembler.g:5356:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:5356:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:5357:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
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
    // InternalAssembler.g:5363:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5369:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:5370:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:5370:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:5371:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:5371:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:5372:4: lv_value_0_0= RULE_ID
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
    // InternalAssembler.g:5391:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:5391:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:5392:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalAssembler.g:5398:1: ruleDecimalValue returns [EObject current=null] : ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_sign_0_1=null;
        Token lv_sign_0_2=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5404:2: ( ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:5405:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:5405:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:5406:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:5406:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==43||LA86_0==45) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalAssembler.g:5407:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    {
                    // InternalAssembler.g:5407:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    // InternalAssembler.g:5408:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    {
                    // InternalAssembler.g:5408:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==43) ) {
                        alt85=1;
                    }
                    else if ( (LA85_0==45) ) {
                        alt85=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;
                    }
                    switch (alt85) {
                        case 1 :
                            // InternalAssembler.g:5409:6: lv_sign_0_1= '-'
                            {
                            lv_sign_0_1=(Token)match(input,43,FOLLOW_39); if (state.failed) return current;
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
                            // InternalAssembler.g:5420:6: lv_sign_0_2= '+'
                            {
                            lv_sign_0_2=(Token)match(input,45,FOLLOW_39); if (state.failed) return current;
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

            // InternalAssembler.g:5433:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:5434:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:5434:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:5435:5: lv_value_1_0= RULE_INT
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
    // InternalAssembler.g:5455:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:5455:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:5456:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
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
    // InternalAssembler.g:5462:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5468:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:5469:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:5469:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:5470:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:5470:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:5471:4: lv_value_0_0= RULE_HEXA
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
    // InternalAssembler.g:5490:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:5490:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:5491:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:5497:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5503:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:5504:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:5504:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:5505:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:5505:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:5506:4: lv_value_0_0= RULE_OCTAL
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
    // InternalAssembler.g:5525:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:5525:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:5526:2: iv_ruleBinaryValue= ruleBinaryValue EOF
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
    // InternalAssembler.g:5532:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5538:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:5539:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:5539:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:5540:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:5540:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:5541:4: lv_value_0_0= RULE_BINARY
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
    // InternalAssembler.g:5560:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:5560:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:5561:2: iv_ruleCharacterValue= ruleCharacterValue EOF
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
    // InternalAssembler.g:5567:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:5573:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:5574:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:5574:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:5575:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:5575:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:5576:4: lv_value_0_0= RULE_CHARACTER
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
    // InternalAssembler.g:5595:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:5595:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:5596:2: iv_ruleEndOfLine= ruleEndOfLine EOF
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
    // InternalAssembler.g:5602:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:5608:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:5609:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:5609:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_CR) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_END_OF_FILE) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalAssembler.g:5610:3: this_CR_0= RULE_CR
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
                    // InternalAssembler.g:5618:3: this_END_OF_FILE_1= RULE_END_OF_FILE
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
    // InternalAssembler.g:5629:1: ruleAssemblyOption returns [Enumerator current=null] : ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) ;
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
            // InternalAssembler.g:5635:2: ( ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) )
            // InternalAssembler.g:5636:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            {
            // InternalAssembler.g:5636:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            int alt88=8;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt88=1;
                }
                break;
            case 77:
                {
                alt88=2;
                }
                break;
            case 78:
                {
                alt88=3;
                }
                break;
            case 79:
                {
                alt88=4;
                }
                break;
            case 80:
                {
                alt88=5;
                }
                break;
            case 81:
                {
                alt88=6;
                }
                break;
            case 82:
                {
                alt88=7;
                }
                break;
            case 83:
                {
                alt88=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalAssembler.g:5637:3: (enumLiteral_0= 'PAG' )
                    {
                    // InternalAssembler.g:5637:3: (enumLiteral_0= 'PAG' )
                    // InternalAssembler.g:5638:4: enumLiteral_0= 'PAG'
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
                    // InternalAssembler.g:5645:3: (enumLiteral_1= 'NOP' )
                    {
                    // InternalAssembler.g:5645:3: (enumLiteral_1= 'NOP' )
                    // InternalAssembler.g:5646:4: enumLiteral_1= 'NOP'
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
                    // InternalAssembler.g:5653:3: (enumLiteral_2= 'CON' )
                    {
                    // InternalAssembler.g:5653:3: (enumLiteral_2= 'CON' )
                    // InternalAssembler.g:5654:4: enumLiteral_2= 'CON'
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
                    // InternalAssembler.g:5661:3: (enumLiteral_3= 'NOC' )
                    {
                    // InternalAssembler.g:5661:3: (enumLiteral_3= 'NOC' )
                    // InternalAssembler.g:5662:4: enumLiteral_3= 'NOC'
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
                    // InternalAssembler.g:5669:3: (enumLiteral_4= 'MAC' )
                    {
                    // InternalAssembler.g:5669:3: (enumLiteral_4= 'MAC' )
                    // InternalAssembler.g:5670:4: enumLiteral_4= 'MAC'
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
                    // InternalAssembler.g:5677:3: (enumLiteral_5= 'NOM' )
                    {
                    // InternalAssembler.g:5677:3: (enumLiteral_5= 'NOM' )
                    // InternalAssembler.g:5678:4: enumLiteral_5= 'NOM'
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
                    // InternalAssembler.g:5685:3: (enumLiteral_6= 'EXP' )
                    {
                    // InternalAssembler.g:5685:3: (enumLiteral_6= 'EXP' )
                    // InternalAssembler.g:5686:4: enumLiteral_6= 'EXP'
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
                    // InternalAssembler.g:5693:3: (enumLiteral_7= 'NOE' )
                    {
                    // InternalAssembler.g:5693:3: (enumLiteral_7= 'NOE' )
                    // InternalAssembler.g:5694:4: enumLiteral_7= 'NOE'
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
    // InternalAssembler.g:5704:1: ruleRegister returns [Enumerator current=null] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) ;
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
            // InternalAssembler.g:5710:2: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) ) )
            // InternalAssembler.g:5711:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            {
            // InternalAssembler.g:5711:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'D' ) | (enumLiteral_3= 'X' ) | (enumLiteral_4= 'Y' ) | (enumLiteral_5= 'U' ) | (enumLiteral_6= 'S' ) | (enumLiteral_7= 'DP' ) | (enumLiteral_8= 'CC' ) | (enumLiteral_9= 'PC' ) )
            int alt89=10;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt89=1;
                }
                break;
            case 41:
                {
                alt89=2;
                }
                break;
            case 42:
                {
                alt89=3;
                }
                break;
            case 38:
                {
                alt89=4;
                }
                break;
            case 39:
                {
                alt89=5;
                }
                break;
            case 37:
                {
                alt89=6;
                }
                break;
            case 36:
                {
                alt89=7;
                }
                break;
            case 84:
                {
                alt89=8;
                }
                break;
            case 85:
                {
                alt89=9;
                }
                break;
            case 86:
                {
                alt89=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalAssembler.g:5712:3: (enumLiteral_0= 'A' )
                    {
                    // InternalAssembler.g:5712:3: (enumLiteral_0= 'A' )
                    // InternalAssembler.g:5713:4: enumLiteral_0= 'A'
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
                    // InternalAssembler.g:5720:3: (enumLiteral_1= 'B' )
                    {
                    // InternalAssembler.g:5720:3: (enumLiteral_1= 'B' )
                    // InternalAssembler.g:5721:4: enumLiteral_1= 'B'
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
                    // InternalAssembler.g:5728:3: (enumLiteral_2= 'D' )
                    {
                    // InternalAssembler.g:5728:3: (enumLiteral_2= 'D' )
                    // InternalAssembler.g:5729:4: enumLiteral_2= 'D'
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
                    // InternalAssembler.g:5736:3: (enumLiteral_3= 'X' )
                    {
                    // InternalAssembler.g:5736:3: (enumLiteral_3= 'X' )
                    // InternalAssembler.g:5737:4: enumLiteral_3= 'X'
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
                    // InternalAssembler.g:5744:3: (enumLiteral_4= 'Y' )
                    {
                    // InternalAssembler.g:5744:3: (enumLiteral_4= 'Y' )
                    // InternalAssembler.g:5745:4: enumLiteral_4= 'Y'
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
                    // InternalAssembler.g:5752:3: (enumLiteral_5= 'U' )
                    {
                    // InternalAssembler.g:5752:3: (enumLiteral_5= 'U' )
                    // InternalAssembler.g:5753:4: enumLiteral_5= 'U'
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
                    // InternalAssembler.g:5760:3: (enumLiteral_6= 'S' )
                    {
                    // InternalAssembler.g:5760:3: (enumLiteral_6= 'S' )
                    // InternalAssembler.g:5761:4: enumLiteral_6= 'S'
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
                    // InternalAssembler.g:5768:3: (enumLiteral_7= 'DP' )
                    {
                    // InternalAssembler.g:5768:3: (enumLiteral_7= 'DP' )
                    // InternalAssembler.g:5769:4: enumLiteral_7= 'DP'
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
                    // InternalAssembler.g:5776:3: (enumLiteral_8= 'CC' )
                    {
                    // InternalAssembler.g:5776:3: (enumLiteral_8= 'CC' )
                    // InternalAssembler.g:5777:4: enumLiteral_8= 'CC'
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
                    // InternalAssembler.g:5784:3: (enumLiteral_9= 'PC' )
                    {
                    // InternalAssembler.g:5784:3: (enumLiteral_9= 'PC' )
                    // InternalAssembler.g:5785:4: enumLiteral_9= 'PC'
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


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\4\uffff\6\14\14\uffff";
    static final String dfa_3s = "\1\7\1\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\37\1\uffff";
    static final String dfa_4s = "\1\113\1\uffff\2\10\6\111\1\uffff\1\113\1\uffff\2\10\6\111\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\10\uffff\1\2\1\uffff\1\3\10\uffff\1\4";
    static final String dfa_6s = "\26\uffff}>";
    static final String[] dfa_7s = {
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
            return "598:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "734:6: (lv_operand_3_1= ruleDirectOperand | lv_operand_3_2= ruleIndexedOperand | lv_operand_3_3= ruleExtendedOperand | lv_operand_3_4= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_8s = "\27\uffff";
    static final String dfa_9s = "\5\uffff\6\15\14\uffff";
    static final String dfa_10s = "\1\7\2\uffff\2\10\6\4\1\uffff\1\7\1\uffff\2\10\6\37\1\uffff";
    static final String dfa_11s = "\1\113\2\uffff\2\10\6\111\1\uffff\1\113\1\uffff\2\10\6\111\1\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\10\uffff\1\3\1\uffff\1\4\10\uffff\1\5";
    static final String dfa_13s = "\27\uffff}>";
    static final String[] dfa_14s = {
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

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "910:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1032:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1167:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
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
            return "1302:5: (lv_operand_2_1= ruleImmediatOperand | lv_operand_2_2= ruleDirectOperand | lv_operand_2_3= ruleIndexedOperand | lv_operand_2_4= ruleExtendedOperand | lv_operand_2_5= ruleExtendedIndirectOperand )";
        }
    }
    static final String dfa_15s = "\44\uffff";
    static final String dfa_16s = "\14\uffff\4\34\24\uffff";
    static final String dfa_17s = "\1\7\2\10\6\43\1\44\1\uffff\1\7\4\4\2\uffff\2\10\6\43\1\44\3\uffff\4\37\2\uffff";
    static final String dfa_18s = "\1\55\2\10\6\43\1\57\1\uffff\1\55\4\56\2\uffff\2\10\6\43\1\57\3\uffff\4\56\2\uffff";
    static final String dfa_19s = "\12\uffff\1\3\5\uffff\1\4\1\1\11\uffff\1\7\1\2\1\6\4\uffff\1\10\1\5";
    static final String dfa_20s = "\44\uffff}>";
    static final String[] dfa_21s = {
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

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "1608:2: ( ( (lv_mode_0_0= ruleAutoIncDecMode ) ) | ( (lv_mode_1_0= ruleConstantIndexedMode ) ) | ( (lv_mode_2_0= ruleAccumulatorMovingMode ) ) | ( (lv_mode_3_0= ruleRelatifToPCMode ) ) | ( (lv_mode_4_0= ruleConstantIndexedMovingIndirectMode ) ) | ( (lv_mode_5_0= ruleAutoIncDecIndirectMode ) ) | ( (lv_mode_6_0= ruleAccumulatorMovingIndirectMode ) ) | ( (lv_mode_7_0= ruleRelatifToPCIndirectMode ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000060B2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000003FFF8000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00002F0B40001F80L,0x0000000000000C00L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00002F0F40001F80L,0x0000000000000C00L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000280100001F80L,0x0000000000000C00L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000F000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000280800001F80L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000070000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000018F000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFDFF000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000007F000000000L,0x0000000000700000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0020000000000000L,0x00000000000FE000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0200280100001F80L,0x0000000000000C00L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000100L});

}
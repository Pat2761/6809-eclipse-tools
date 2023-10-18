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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_ID", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "RULE_STRING", "'NAM'", "'TTL'", "'PAG'", "'OPT'", "','", "'FAIL'", "'SET'", "'*'", "'FILL'", "'BSZ'", "'FDB'", "'FCB'", "'RMB'", "'END'", "'ORG'", "'EQU'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'&&'", "'||'", "'^'", "'!'", "'('", "')'", "'NOP'", "'CON'", "'NOC'", "'MAC'", "'NOM'", "'EXP'", "'NOE'"
    };
    public static final int RULE_ANY_EXCEPT_COMMENT_END_OF_LINE=5;
    public static final int RULE_CHARACTER=11;
    public static final int RULE_CR=12;
    public static final int T__19=19;
    public static final int RULE_OCTAL=9;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_ID=6;
    public static final int RULE_HEXA=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=14;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int RULE_END_OF_FILE=13;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=4;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int RULE_BINARY=10;
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

                if ( ((LA1_0>=RULE_WS && LA1_0<=RULE_ID)||(LA1_0>=RULE_CR && LA1_0<=RULE_END_OF_FILE)) ) {
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
    // InternalAssembler.g:108:1: ruleSourceLine returns [EObject current=null] : ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) ) ;
    public final EObject ruleSourceLine() throws RecognitionException {
        EObject current = null;

        EObject lv_lineContent_0_0 = null;

        EObject lv_lineContent_1_0 = null;

        EObject lv_lineContent_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:114:2: ( ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) ) )
            // InternalAssembler.g:115:2: ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) )
            {
            // InternalAssembler.g:115:2: ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_WS:
                {
                int LA2_1 = input.LA(2);

                if ( ((LA2_1>=RULE_CR && LA2_1<=RULE_END_OF_FILE)) ) {
                    alt2=1;
                }
                else if ( ((LA2_1>=15 && LA2_1<=18)||(LA2_1>=20 && LA2_1<=21)||(LA2_1>=23 && LA2_1<=30)) ) {
                    alt2=3;
                }
                else {
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
                alt2=3;
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

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
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
    // InternalAssembler.g:179:1: entryRuleBlankLine returns [EObject current=null] : iv_ruleBlankLine= ruleBlankLine EOF ;
    public final EObject entryRuleBlankLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlankLine = null;


        try {
            // InternalAssembler.g:179:50: (iv_ruleBlankLine= ruleBlankLine EOF )
            // InternalAssembler.g:180:2: iv_ruleBlankLine= ruleBlankLine EOF
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
    // InternalAssembler.g:186:1: ruleBlankLine returns [EObject current=null] : ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine ) ;
    public final EObject ruleBlankLine() throws RecognitionException {
        EObject current = null;

        Token lv_blankLine_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:192:2: ( ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine ) )
            // InternalAssembler.g:193:2: ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:193:2: ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine )
            // InternalAssembler.g:194:3: () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine
            {
            // InternalAssembler.g:194:3: ()
            // InternalAssembler.g:195:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlankLineAccess().getBlankLineAction_0(),
              					current);
              			
            }

            }

            // InternalAssembler.g:201:3: ( (lv_blankLine_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssembler.g:202:4: (lv_blankLine_1_0= RULE_WS )
                    {
                    // InternalAssembler.g:202:4: (lv_blankLine_1_0= RULE_WS )
                    // InternalAssembler.g:203:5: lv_blankLine_1_0= RULE_WS
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
    // InternalAssembler.g:230:1: entryRuleCommentLine returns [EObject current=null] : iv_ruleCommentLine= ruleCommentLine EOF ;
    public final EObject entryRuleCommentLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentLine = null;


        try {
            // InternalAssembler.g:230:52: (iv_ruleCommentLine= ruleCommentLine EOF )
            // InternalAssembler.g:231:2: iv_ruleCommentLine= ruleCommentLine EOF
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
    // InternalAssembler.g:237:1: ruleCommentLine returns [EObject current=null] : ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine ) ;
    public final EObject ruleCommentLine() throws RecognitionException {
        EObject current = null;

        Token lv_comment_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:243:2: ( ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine ) )
            // InternalAssembler.g:244:2: ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine )
            {
            // InternalAssembler.g:244:2: ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine )
            // InternalAssembler.g:245:3: ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine
            {
            // InternalAssembler.g:245:3: ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
            // InternalAssembler.g:246:4: (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            {
            // InternalAssembler.g:246:4: (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            // InternalAssembler.g:247:5: lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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


    // $ANTLR start "entryRuleDirectiveLine"
    // InternalAssembler.g:274:1: entryRuleDirectiveLine returns [EObject current=null] : iv_ruleDirectiveLine= ruleDirectiveLine EOF ;
    public final EObject entryRuleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectiveLine = null;


        try {
            // InternalAssembler.g:274:54: (iv_ruleDirectiveLine= ruleDirectiveLine EOF )
            // InternalAssembler.g:275:2: iv_ruleDirectiveLine= ruleDirectiveLine EOF
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
    // InternalAssembler.g:281:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleRmbDirective ) ) | ( (lv_directive_11_0= ruleFcbDirective ) ) | ( (lv_directive_12_0= ruleFdbDirective ) ) ) ;
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



        	enterRule();

        try {
            // InternalAssembler.g:287:2: ( ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleRmbDirective ) ) | ( (lv_directive_11_0= ruleFcbDirective ) ) | ( (lv_directive_12_0= ruleFdbDirective ) ) ) )
            // InternalAssembler.g:288:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleRmbDirective ) ) | ( (lv_directive_11_0= ruleFcbDirective ) ) | ( (lv_directive_12_0= ruleFdbDirective ) ) )
            {
            // InternalAssembler.g:288:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleRmbDirective ) ) | ( (lv_directive_11_0= ruleFcbDirective ) ) | ( (lv_directive_12_0= ruleFdbDirective ) ) )
            int alt4=13;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:289:3: ( (lv_directive_0_0= ruleEquDirective ) )
                    {
                    // InternalAssembler.g:289:3: ( (lv_directive_0_0= ruleEquDirective ) )
                    // InternalAssembler.g:290:4: (lv_directive_0_0= ruleEquDirective )
                    {
                    // InternalAssembler.g:290:4: (lv_directive_0_0= ruleEquDirective )
                    // InternalAssembler.g:291:5: lv_directive_0_0= ruleEquDirective
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
                    // InternalAssembler.g:309:3: ( (lv_directive_1_0= ruleOrgDirective ) )
                    {
                    // InternalAssembler.g:309:3: ( (lv_directive_1_0= ruleOrgDirective ) )
                    // InternalAssembler.g:310:4: (lv_directive_1_0= ruleOrgDirective )
                    {
                    // InternalAssembler.g:310:4: (lv_directive_1_0= ruleOrgDirective )
                    // InternalAssembler.g:311:5: lv_directive_1_0= ruleOrgDirective
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
                    // InternalAssembler.g:329:3: ( (lv_directive_2_0= ruleBszDirective ) )
                    {
                    // InternalAssembler.g:329:3: ( (lv_directive_2_0= ruleBszDirective ) )
                    // InternalAssembler.g:330:4: (lv_directive_2_0= ruleBszDirective )
                    {
                    // InternalAssembler.g:330:4: (lv_directive_2_0= ruleBszDirective )
                    // InternalAssembler.g:331:5: lv_directive_2_0= ruleBszDirective
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
                    // InternalAssembler.g:349:3: ( (lv_directive_3_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:349:3: ( (lv_directive_3_0= ruleEndDirective ) )
                    // InternalAssembler.g:350:4: (lv_directive_3_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:350:4: (lv_directive_3_0= ruleEndDirective )
                    // InternalAssembler.g:351:5: lv_directive_3_0= ruleEndDirective
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
                    // InternalAssembler.g:369:3: ( (lv_directive_4_0= ruleFailDirective ) )
                    {
                    // InternalAssembler.g:369:3: ( (lv_directive_4_0= ruleFailDirective ) )
                    // InternalAssembler.g:370:4: (lv_directive_4_0= ruleFailDirective )
                    {
                    // InternalAssembler.g:370:4: (lv_directive_4_0= ruleFailDirective )
                    // InternalAssembler.g:371:5: lv_directive_4_0= ruleFailDirective
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
                    // InternalAssembler.g:389:3: ( (lv_directive_5_0= ruleFillDirective ) )
                    {
                    // InternalAssembler.g:389:3: ( (lv_directive_5_0= ruleFillDirective ) )
                    // InternalAssembler.g:390:4: (lv_directive_5_0= ruleFillDirective )
                    {
                    // InternalAssembler.g:390:4: (lv_directive_5_0= ruleFillDirective )
                    // InternalAssembler.g:391:5: lv_directive_5_0= ruleFillDirective
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
                    // InternalAssembler.g:409:3: ( (lv_directive_6_0= ruleOptDirective ) )
                    {
                    // InternalAssembler.g:409:3: ( (lv_directive_6_0= ruleOptDirective ) )
                    // InternalAssembler.g:410:4: (lv_directive_6_0= ruleOptDirective )
                    {
                    // InternalAssembler.g:410:4: (lv_directive_6_0= ruleOptDirective )
                    // InternalAssembler.g:411:5: lv_directive_6_0= ruleOptDirective
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
                    // InternalAssembler.g:429:3: ( (lv_directive_7_0= rulePagDirective ) )
                    {
                    // InternalAssembler.g:429:3: ( (lv_directive_7_0= rulePagDirective ) )
                    // InternalAssembler.g:430:4: (lv_directive_7_0= rulePagDirective )
                    {
                    // InternalAssembler.g:430:4: (lv_directive_7_0= rulePagDirective )
                    // InternalAssembler.g:431:5: lv_directive_7_0= rulePagDirective
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
                    // InternalAssembler.g:449:3: ( (lv_directive_8_0= ruleNamDirective ) )
                    {
                    // InternalAssembler.g:449:3: ( (lv_directive_8_0= ruleNamDirective ) )
                    // InternalAssembler.g:450:4: (lv_directive_8_0= ruleNamDirective )
                    {
                    // InternalAssembler.g:450:4: (lv_directive_8_0= ruleNamDirective )
                    // InternalAssembler.g:451:5: lv_directive_8_0= ruleNamDirective
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
                    // InternalAssembler.g:469:3: ( (lv_directive_9_0= ruleSetDirective ) )
                    {
                    // InternalAssembler.g:469:3: ( (lv_directive_9_0= ruleSetDirective ) )
                    // InternalAssembler.g:470:4: (lv_directive_9_0= ruleSetDirective )
                    {
                    // InternalAssembler.g:470:4: (lv_directive_9_0= ruleSetDirective )
                    // InternalAssembler.g:471:5: lv_directive_9_0= ruleSetDirective
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
                    // InternalAssembler.g:489:3: ( (lv_directive_10_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:489:3: ( (lv_directive_10_0= ruleRmbDirective ) )
                    // InternalAssembler.g:490:4: (lv_directive_10_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:490:4: (lv_directive_10_0= ruleRmbDirective )
                    // InternalAssembler.g:491:5: lv_directive_10_0= ruleRmbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveRmbDirectiveParserRuleCall_10_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_10_0=ruleRmbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.RmbDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalAssembler.g:509:3: ( (lv_directive_11_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:509:3: ( (lv_directive_11_0= ruleFcbDirective ) )
                    // InternalAssembler.g:510:4: (lv_directive_11_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:510:4: (lv_directive_11_0= ruleFcbDirective )
                    // InternalAssembler.g:511:5: lv_directive_11_0= ruleFcbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFcbDirectiveParserRuleCall_11_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_11_0=ruleFcbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FcbDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalAssembler.g:529:3: ( (lv_directive_12_0= ruleFdbDirective ) )
                    {
                    // InternalAssembler.g:529:3: ( (lv_directive_12_0= ruleFdbDirective ) )
                    // InternalAssembler.g:530:4: (lv_directive_12_0= ruleFdbDirective )
                    {
                    // InternalAssembler.g:530:4: (lv_directive_12_0= ruleFdbDirective )
                    // InternalAssembler.g:531:5: lv_directive_12_0= ruleFdbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFdbDirectiveParserRuleCall_12_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_12_0=ruleFdbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FdbDirective");
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


    // $ANTLR start "entryRuleNamDirective"
    // InternalAssembler.g:552:1: entryRuleNamDirective returns [EObject current=null] : iv_ruleNamDirective= ruleNamDirective EOF ;
    public final EObject entryRuleNamDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamDirective = null;


        try {
            // InternalAssembler.g:552:53: (iv_ruleNamDirective= ruleNamDirective EOF )
            // InternalAssembler.g:553:2: iv_ruleNamDirective= ruleNamDirective EOF
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
    // InternalAssembler.g:559:1: ruleNamDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:565:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) )
            // InternalAssembler.g:566:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:566:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            // InternalAssembler.g:567:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) ) this_WS_4= RULE_WS ( (lv_operand_5_0= ruleIdentifierValue ) ) (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine
            {
            // InternalAssembler.g:567:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:568:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:568:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:569:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:590:3: ( ( (lv_directive_2_0= 'NAM' ) ) | ( (lv_directive_3_0= 'TTL' ) ) )
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
                    // InternalAssembler.g:591:4: ( (lv_directive_2_0= 'NAM' ) )
                    {
                    // InternalAssembler.g:591:4: ( (lv_directive_2_0= 'NAM' ) )
                    // InternalAssembler.g:592:5: (lv_directive_2_0= 'NAM' )
                    {
                    // InternalAssembler.g:592:5: (lv_directive_2_0= 'NAM' )
                    // InternalAssembler.g:593:6: lv_directive_2_0= 'NAM'
                    {
                    lv_directive_2_0=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
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
                    // InternalAssembler.g:606:4: ( (lv_directive_3_0= 'TTL' ) )
                    {
                    // InternalAssembler.g:606:4: ( (lv_directive_3_0= 'TTL' ) )
                    // InternalAssembler.g:607:5: (lv_directive_3_0= 'TTL' )
                    {
                    // InternalAssembler.g:607:5: (lv_directive_3_0= 'TTL' )
                    // InternalAssembler.g:608:6: lv_directive_3_0= 'TTL'
                    {
                    lv_directive_3_0=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
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

            this_WS_4=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_4, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:625:3: ( (lv_operand_5_0= ruleIdentifierValue ) )
            // InternalAssembler.g:626:4: (lv_operand_5_0= ruleIdentifierValue )
            {
            // InternalAssembler.g:626:4: (lv_operand_5_0= ruleIdentifierValue )
            // InternalAssembler.g:627:5: lv_operand_5_0= ruleIdentifierValue
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

            // InternalAssembler.g:644:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:645:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getNamDirectiveAccess().getWSTerminalRuleCall_5_0());
                      			
                    }
                    // InternalAssembler.g:649:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:650:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:650:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:651:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:679:1: entryRulePagDirective returns [EObject current=null] : iv_rulePagDirective= rulePagDirective EOF ;
    public final EObject entryRulePagDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePagDirective = null;


        try {
            // InternalAssembler.g:679:53: (iv_rulePagDirective= rulePagDirective EOF )
            // InternalAssembler.g:680:2: iv_rulePagDirective= rulePagDirective EOF
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
    // InternalAssembler.g:686:1: rulePagDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:692:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine ) )
            // InternalAssembler.g:693:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:693:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine )
            // InternalAssembler.g:694:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'PAG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? ruleEndOfLine
            {
            // InternalAssembler.g:694:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:695:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:695:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:696:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:717:3: ( (lv_directive_2_0= 'PAG' ) )
            // InternalAssembler.g:718:4: (lv_directive_2_0= 'PAG' )
            {
            // InternalAssembler.g:718:4: (lv_directive_2_0= 'PAG' )
            // InternalAssembler.g:719:5: lv_directive_2_0= 'PAG'
            {
            lv_directive_2_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:731:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_WS) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==RULE_WS||(LA10_1>=RULE_ID && LA10_1<=RULE_END_OF_FILE)||(LA10_1>=33 && LA10_1<=34)||(LA10_1>=40 && LA10_1<=41)) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:732:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )?
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:736:4: ( (lv_operand_4_0= ruleExpression ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_CHARACTER)||(LA9_0>=33 && LA9_0<=34)||(LA9_0>=40 && LA9_0<=41)) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalAssembler.g:737:5: (lv_operand_4_0= ruleExpression )
                            {
                            // InternalAssembler.g:737:5: (lv_operand_4_0= ruleExpression )
                            // InternalAssembler.g:738:6: lv_operand_4_0= ruleExpression
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

            // InternalAssembler.g:756:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_WS) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAssembler.g:757:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getPagDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:761:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:762:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:762:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:763:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:791:1: entryRuleOptDirective returns [EObject current=null] : iv_ruleOptDirective= ruleOptDirective EOF ;
    public final EObject entryRuleOptDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptDirective = null;


        try {
            // InternalAssembler.g:791:53: (iv_ruleOptDirective= ruleOptDirective EOF )
            // InternalAssembler.g:792:2: iv_ruleOptDirective= ruleOptDirective EOF
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
    // InternalAssembler.g:798:1: ruleOptDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:804:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) )
            // InternalAssembler.g:805:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            {
            // InternalAssembler.g:805:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            // InternalAssembler.g:806:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'OPT' ) ) (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine
            {
            // InternalAssembler.g:806:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAssembler.g:807:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:807:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:808:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:829:3: ( (lv_directive_2_0= 'OPT' ) )
            // InternalAssembler.g:830:4: (lv_directive_2_0= 'OPT' )
            {
            // InternalAssembler.g:830:4: (lv_directive_2_0= 'OPT' )
            // InternalAssembler.g:831:5: lv_directive_2_0= 'OPT'
            {
            lv_directive_2_0=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:843:3: (this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_WS) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==17||(LA14_1>=43 && LA14_1<=49)) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalAssembler.g:844:4: this_WS_3= RULE_WS ( (lv_options_4_0= ruleAssemblyOption ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )*
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:848:4: ( (lv_options_4_0= ruleAssemblyOption ) )
                    // InternalAssembler.g:849:5: (lv_options_4_0= ruleAssemblyOption )
                    {
                    // InternalAssembler.g:849:5: (lv_options_4_0= ruleAssemblyOption )
                    // InternalAssembler.g:850:6: lv_options_4_0= ruleAssemblyOption
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
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

                    // InternalAssembler.g:867:4: (otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==19) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalAssembler.g:868:5: otherlv_5= ',' ( (lv_options_6_0= ruleAssemblyOption ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getOptDirectiveAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalAssembler.g:872:5: ( (lv_options_6_0= ruleAssemblyOption ) )
                    	    // InternalAssembler.g:873:6: (lv_options_6_0= ruleAssemblyOption )
                    	    {
                    	    // InternalAssembler.g:873:6: (lv_options_6_0= ruleAssemblyOption )
                    	    // InternalAssembler.g:874:7: lv_options_6_0= ruleAssemblyOption
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOptDirectiveAccess().getOptionsAssemblyOptionEnumRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
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
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAssembler.g:893:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_WS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAssembler.g:894:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getOptDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:898:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalAssembler.g:899:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            {
                            // InternalAssembler.g:899:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            // InternalAssembler.g:900:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:928:1: entryRuleFailDirective returns [EObject current=null] : iv_ruleFailDirective= ruleFailDirective EOF ;
    public final EObject entryRuleFailDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailDirective = null;


        try {
            // InternalAssembler.g:928:54: (iv_ruleFailDirective= ruleFailDirective EOF )
            // InternalAssembler.g:929:2: iv_ruleFailDirective= ruleFailDirective EOF
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
    // InternalAssembler.g:935:1: ruleFailDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) ;
    public final EObject ruleFailDirective() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_directive_2_0=null;
        Token this_WS_3=null;
        Token lv_comment_4_0=null;
        EObject lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:941:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine ) )
            // InternalAssembler.g:942:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            {
            // InternalAssembler.g:942:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine )
            // InternalAssembler.g:943:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FAIL' ) ) (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )? ruleEndOfLine
            {
            // InternalAssembler.g:943:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAssembler.g:944:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:944:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:945:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFailDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:966:3: ( (lv_directive_2_0= 'FAIL' ) )
            // InternalAssembler.g:967:4: (lv_directive_2_0= 'FAIL' )
            {
            // InternalAssembler.g:967:4: (lv_directive_2_0= 'FAIL' )
            // InternalAssembler.g:968:5: lv_directive_2_0= 'FAIL'
            {
            lv_directive_2_0=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:980:3: (this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_WS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAssembler.g:981:4: this_WS_3= RULE_WS ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFailDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:985:4: ( (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalAssembler.g:986:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            {
                            // InternalAssembler.g:986:5: (lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                            // InternalAssembler.g:987:6: lv_comment_4_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:1015:1: entryRuleSetDirective returns [EObject current=null] : iv_ruleSetDirective= ruleSetDirective EOF ;
    public final EObject entryRuleSetDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDirective = null;


        try {
            // InternalAssembler.g:1015:53: (iv_ruleSetDirective= ruleSetDirective EOF )
            // InternalAssembler.g:1016:2: iv_ruleSetDirective= ruleSetDirective EOF
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
    // InternalAssembler.g:1022:1: ruleSetDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1028:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:1029:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:1029:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:1030:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:1030:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1031:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1031:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1032:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1053:3: ( (lv_directive_2_0= 'SET' ) )
            // InternalAssembler.g:1054:4: (lv_directive_2_0= 'SET' )
            {
            // InternalAssembler.g:1054:4: (lv_directive_2_0= 'SET' )
            // InternalAssembler.g:1055:5: lv_directive_2_0= 'SET'
            {
            lv_directive_2_0=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
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

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:1071:3: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==22) ) {
                int LA22_1 = input.LA(2);

                if ( ((LA22_1>=RULE_ID && LA22_1<=RULE_CHARACTER)||(LA22_1>=33 && LA22_1<=34)||(LA22_1>=40 && LA22_1<=41)) ) {
                    alt22=1;
                }
                else if ( ((LA22_1>=RULE_WS && LA22_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA22_1>=RULE_CR && LA22_1<=RULE_END_OF_FILE)) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_CHARACTER)||(LA22_0>=33 && LA22_0<=34)||(LA22_0>=40 && LA22_0<=41)) ) {
                alt22=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:1072:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:1072:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:1073:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:1073:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==22) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalAssembler.g:1074:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:1074:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:1075:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
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

                    // InternalAssembler.g:1087:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:1088:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:1088:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:1089:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetDirectiveAccess().getOperandExpressionParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_14);
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
                    // InternalAssembler.g:1108:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    {
                    // InternalAssembler.g:1108:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    // InternalAssembler.g:1109:5: (lv_isRelativeToPC_6_0= '*' )
                    {
                    // InternalAssembler.g:1109:5: (lv_isRelativeToPC_6_0= '*' )
                    // InternalAssembler.g:1110:6: lv_isRelativeToPC_6_0= '*'
                    {
                    lv_isRelativeToPC_6_0=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
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

            // InternalAssembler.g:1123:3: (this_WS_7= RULE_WS )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_WS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAssembler.g:1124:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:1129:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAssembler.g:1130:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1130:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1131:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:1158:1: entryRuleFillDirective returns [EObject current=null] : iv_ruleFillDirective= ruleFillDirective EOF ;
    public final EObject entryRuleFillDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFillDirective = null;


        try {
            // InternalAssembler.g:1158:54: (iv_ruleFillDirective= ruleFillDirective EOF )
            // InternalAssembler.g:1159:2: iv_ruleFillDirective= ruleFillDirective EOF
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
    // InternalAssembler.g:1165:1: ruleFillDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1171:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1172:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1172:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1173:3: ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1173:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAssembler.g:1174:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1174:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1175:5: lv_name_0_0= ruleIdentifierValue
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

            // InternalAssembler.g:1192:3: (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) )
            // InternalAssembler.g:1193:4: this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:1197:4: ( (lv_directive_2_0= 'FILL' ) )
            // InternalAssembler.g:1198:5: (lv_directive_2_0= 'FILL' )
            {
            // InternalAssembler.g:1198:5: (lv_directive_2_0= 'FILL' )
            // InternalAssembler.g:1199:6: lv_directive_2_0= 'FILL'
            {
            lv_directive_2_0=(Token)match(input,23,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:1212:3: (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) )
            // InternalAssembler.g:1213:4: this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_2_0());
              			
            }
            // InternalAssembler.g:1217:4: ( (lv_value_4_0= ruleExpression ) )
            // InternalAssembler.g:1218:5: (lv_value_4_0= ruleExpression )
            {
            // InternalAssembler.g:1218:5: (lv_value_4_0= ruleExpression )
            // InternalAssembler.g:1219:6: lv_value_4_0= ruleExpression
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

            otherlv_5=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getFillDirectiveAccess().getCommaKeyword_2_2());
              			
            }
            // InternalAssembler.g:1240:4: ( (lv_number_6_0= ruleExpression ) )
            // InternalAssembler.g:1241:5: (lv_number_6_0= ruleExpression )
            {
            // InternalAssembler.g:1241:5: (lv_number_6_0= ruleExpression )
            // InternalAssembler.g:1242:6: lv_number_6_0= ruleExpression
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

            // InternalAssembler.g:1260:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_WS) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // InternalAssembler.g:1261:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1265:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1266:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1266:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1267:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1284:3: (this_WS_9= RULE_WS )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_WS) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalAssembler.g:1285:4: this_WS_9= RULE_WS
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
    // InternalAssembler.g:1301:1: entryRuleBszDirective returns [EObject current=null] : iv_ruleBszDirective= ruleBszDirective EOF ;
    public final EObject entryRuleBszDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBszDirective = null;


        try {
            // InternalAssembler.g:1301:53: (iv_ruleBszDirective= ruleBszDirective EOF )
            // InternalAssembler.g:1302:2: iv_ruleBszDirective= ruleBszDirective EOF
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
    // InternalAssembler.g:1308:1: ruleBszDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleBszDirective() throws RecognitionException {
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
            // InternalAssembler.g:1314:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1315:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1315:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1316:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1316:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAssembler.g:1317:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1317:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1318:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1339:3: ( (lv_directive_2_0= 'BSZ' ) )
            // InternalAssembler.g:1340:4: (lv_directive_2_0= 'BSZ' )
            {
            // InternalAssembler.g:1340:4: (lv_directive_2_0= 'BSZ' )
            // InternalAssembler.g:1341:5: lv_directive_2_0= 'BSZ'
            {
            lv_directive_2_0=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_directive_2_0, grammarAccess.getBszDirectiveAccess().getDirectiveBSZKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBszDirectiveRule());
              					}
              					setWithLastConsumed(current, "directive", lv_directive_2_0, "BSZ");
              				
            }

            }


            }

            // InternalAssembler.g:1353:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )
            // InternalAssembler.g:1354:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_3_0());
              			
            }
            // InternalAssembler.g:1358:4: ( (lv_operand_4_0= ruleExpression ) )
            // InternalAssembler.g:1359:5: (lv_operand_4_0= ruleExpression )
            {
            // InternalAssembler.g:1359:5: (lv_operand_4_0= ruleExpression )
            // InternalAssembler.g:1360:6: lv_operand_4_0= ruleExpression
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

            // InternalAssembler.g:1378:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_WS) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // InternalAssembler.g:1379:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:1383:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1384:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1384:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1385:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1402:3: (this_WS_7= RULE_WS )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_WS) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAssembler.g:1403:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:1419:1: entryRuleFdbDirective returns [EObject current=null] : iv_ruleFdbDirective= ruleFdbDirective EOF ;
    public final EObject entryRuleFdbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFdbDirective = null;


        try {
            // InternalAssembler.g:1419:53: (iv_ruleFdbDirective= ruleFdbDirective EOF )
            // InternalAssembler.g:1420:2: iv_ruleFdbDirective= ruleFdbDirective EOF
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
    // InternalAssembler.g:1426:1: ruleFdbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1432:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1433:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1433:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1434:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1434:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAssembler.g:1435:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1435:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1436:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1457:3: ( (lv_directive_2_0= 'FDB' ) )
            // InternalAssembler.g:1458:4: (lv_directive_2_0= 'FDB' )
            {
            // InternalAssembler.g:1458:4: (lv_directive_2_0= 'FDB' )
            // InternalAssembler.g:1459:5: lv_directive_2_0= 'FDB'
            {
            lv_directive_2_0=(Token)match(input,25,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1471:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_WS) ) {
                int LA32_1 = input.LA(2);

                if ( ((LA32_1>=RULE_ID && LA32_1<=RULE_CHARACTER)||(LA32_1>=33 && LA32_1<=34)||(LA32_1>=40 && LA32_1<=41)) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalAssembler.g:1472:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1476:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:1477:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:1477:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:1478:6: lv_operand_4_0= ruleListOfExpression
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

            // InternalAssembler.g:1496:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_WS) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // InternalAssembler.g:1497:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:1501:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1502:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1502:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1503:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1520:3: (this_WS_7= RULE_WS )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_WS) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAssembler.g:1521:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:1537:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:1537:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:1538:2: iv_ruleFcbDirective= ruleFcbDirective EOF
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
    // InternalAssembler.g:1544:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1550:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1551:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1551:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1552:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1552:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAssembler.g:1553:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1553:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1554:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1575:3: ( (lv_directive_2_0= 'FCB' ) )
            // InternalAssembler.g:1576:4: (lv_directive_2_0= 'FCB' )
            {
            // InternalAssembler.g:1576:4: (lv_directive_2_0= 'FCB' )
            // InternalAssembler.g:1577:5: lv_directive_2_0= 'FCB'
            {
            lv_directive_2_0=(Token)match(input,26,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1589:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_WS) ) {
                int LA36_1 = input.LA(2);

                if ( ((LA36_1>=RULE_ID && LA36_1<=RULE_CHARACTER)||(LA36_1>=33 && LA36_1<=34)||(LA36_1>=40 && LA36_1<=41)) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // InternalAssembler.g:1590:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1594:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:1595:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:1595:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:1596:6: lv_operand_4_0= ruleListOfExpression
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

            // InternalAssembler.g:1614:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:1615:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:1619:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1620:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1620:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1621:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1638:3: (this_WS_7= RULE_WS )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_WS) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAssembler.g:1639:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:1655:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:1655:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:1656:2: iv_ruleRmbDirective= ruleRmbDirective EOF
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
    // InternalAssembler.g:1662:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1668:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1669:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1669:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1670:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1670:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAssembler.g:1671:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1671:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1672:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1693:3: ( (lv_directive_2_0= 'RMB' ) )
            // InternalAssembler.g:1694:4: (lv_directive_2_0= 'RMB' )
            {
            // InternalAssembler.g:1694:4: (lv_directive_2_0= 'RMB' )
            // InternalAssembler.g:1695:5: lv_directive_2_0= 'RMB'
            {
            lv_directive_2_0=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1707:3: (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_WS) ) {
                int LA41_1 = input.LA(2);

                if ( ((LA41_1>=RULE_ID && LA41_1<=RULE_CHARACTER)||LA41_1==22||(LA41_1>=33 && LA41_1<=34)||(LA41_1>=40 && LA41_1<=41)) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // InternalAssembler.g:1708:4: this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1712:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:1713:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:1713:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==22) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalAssembler.g:1714:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:1714:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:1715:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
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

                    // InternalAssembler.g:1727:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:1728:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:1728:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:1729:7: lv_operand_5_0= ruleExpression
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

            // InternalAssembler.g:1748:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_WS) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalAssembler.g:1749:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:1753:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1754:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1754:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1755:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1772:3: (this_WS_8= RULE_WS )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_WS) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAssembler.g:1773:4: this_WS_8= RULE_WS
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
    // InternalAssembler.g:1789:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:1789:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:1790:2: iv_ruleEndDirective= ruleEndDirective EOF
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
    // InternalAssembler.g:1796:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1802:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1803:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1803:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1804:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1804:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAssembler.g:1805:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1805:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1806:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1827:3: ( (lv_directive_2_0= 'END' ) )
            // InternalAssembler.g:1828:4: (lv_directive_2_0= 'END' )
            {
            // InternalAssembler.g:1828:4: (lv_directive_2_0= 'END' )
            // InternalAssembler.g:1829:5: lv_directive_2_0= 'END'
            {
            lv_directive_2_0=(Token)match(input,28,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1841:3: (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_WS) ) {
                int LA47_1 = input.LA(2);

                if ( ((LA47_1>=RULE_ID && LA47_1<=RULE_CHARACTER)||LA47_1==22||(LA47_1>=33 && LA47_1<=34)||(LA47_1>=40 && LA47_1<=41)) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // InternalAssembler.g:1842:4: this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1846:4: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==22) ) {
                        int LA46_1 = input.LA(2);

                        if ( (LA46_1==RULE_WS||(LA46_1>=RULE_CR && LA46_1<=RULE_END_OF_FILE)) ) {
                            alt46=2;
                        }
                        else if ( ((LA46_1>=RULE_ID && LA46_1<=RULE_CHARACTER)||(LA46_1>=33 && LA46_1<=34)||(LA46_1>=40 && LA46_1<=41)) ) {
                            alt46=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 46, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_CHARACTER)||(LA46_0>=33 && LA46_0<=34)||(LA46_0>=40 && LA46_0<=41)) ) {
                        alt46=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalAssembler.g:1847:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:1847:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            // InternalAssembler.g:1848:6: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:1848:6: ( (lv_isRelativeToPC_4_0= '*' ) )?
                            int alt45=2;
                            int LA45_0 = input.LA(1);

                            if ( (LA45_0==22) ) {
                                alt45=1;
                            }
                            switch (alt45) {
                                case 1 :
                                    // InternalAssembler.g:1849:7: (lv_isRelativeToPC_4_0= '*' )
                                    {
                                    // InternalAssembler.g:1849:7: (lv_isRelativeToPC_4_0= '*' )
                                    // InternalAssembler.g:1850:8: lv_isRelativeToPC_4_0= '*'
                                    {
                                    lv_isRelativeToPC_4_0=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
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

                            // InternalAssembler.g:1862:6: ( (lv_operand_5_0= ruleExpression ) )
                            // InternalAssembler.g:1863:7: (lv_operand_5_0= ruleExpression )
                            {
                            // InternalAssembler.g:1863:7: (lv_operand_5_0= ruleExpression )
                            // InternalAssembler.g:1864:8: lv_operand_5_0= ruleExpression
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
                            // InternalAssembler.g:1883:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            {
                            // InternalAssembler.g:1883:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            // InternalAssembler.g:1884:6: (lv_isRelativeToPC_6_0= '*' )
                            {
                            // InternalAssembler.g:1884:6: (lv_isRelativeToPC_6_0= '*' )
                            // InternalAssembler.g:1885:7: lv_isRelativeToPC_6_0= '*'
                            {
                            lv_isRelativeToPC_6_0=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1899:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_WS) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // InternalAssembler.g:1900:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:1904:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1905:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1905:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1906:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1923:3: (this_WS_9= RULE_WS )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_WS) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalAssembler.g:1924:4: this_WS_9= RULE_WS
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
    // InternalAssembler.g:1940:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:1940:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:1941:2: iv_ruleOrgDirective= ruleOrgDirective EOF
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
    // InternalAssembler.g:1947:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1953:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:1954:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:1954:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:1955:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:1955:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalAssembler.g:1956:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1956:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1957:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1978:3: ( (lv_directive_2_0= 'ORG' ) )
            // InternalAssembler.g:1979:4: (lv_directive_2_0= 'ORG' )
            {
            // InternalAssembler.g:1979:4: (lv_directive_2_0= 'ORG' )
            // InternalAssembler.g:1980:5: lv_directive_2_0= 'ORG'
            {
            lv_directive_2_0=(Token)match(input,29,FOLLOW_14); if (state.failed) return current;
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

            // InternalAssembler.g:1992:3: (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_WS) ) {
                int LA53_1 = input.LA(2);

                if ( ((LA53_1>=RULE_ID && LA53_1<=RULE_CHARACTER)||LA53_1==22||(LA53_1>=33 && LA53_1<=34)||(LA53_1>=40 && LA53_1<=41)) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalAssembler.g:1993:4: this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1997:4: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==22) ) {
                        int LA52_1 = input.LA(2);

                        if ( ((LA52_1>=RULE_ID && LA52_1<=RULE_CHARACTER)||(LA52_1>=33 && LA52_1<=34)||(LA52_1>=40 && LA52_1<=41)) ) {
                            alt52=1;
                        }
                        else if ( ((LA52_1>=RULE_WS && LA52_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA52_1>=RULE_CR && LA52_1<=RULE_END_OF_FILE)) ) {
                            alt52=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 52, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA52_0>=RULE_ID && LA52_0<=RULE_CHARACTER)||(LA52_0>=33 && LA52_0<=34)||(LA52_0>=40 && LA52_0<=41)) ) {
                        alt52=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }
                    switch (alt52) {
                        case 1 :
                            // InternalAssembler.g:1998:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:1998:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            // InternalAssembler.g:1999:6: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:1999:6: ( (lv_isRelativeToPC_4_0= '*' ) )?
                            int alt51=2;
                            int LA51_0 = input.LA(1);

                            if ( (LA51_0==22) ) {
                                alt51=1;
                            }
                            switch (alt51) {
                                case 1 :
                                    // InternalAssembler.g:2000:7: (lv_isRelativeToPC_4_0= '*' )
                                    {
                                    // InternalAssembler.g:2000:7: (lv_isRelativeToPC_4_0= '*' )
                                    // InternalAssembler.g:2001:8: lv_isRelativeToPC_4_0= '*'
                                    {
                                    lv_isRelativeToPC_4_0=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
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

                            // InternalAssembler.g:2013:6: ( (lv_operand_5_0= ruleExpression ) )
                            // InternalAssembler.g:2014:7: (lv_operand_5_0= ruleExpression )
                            {
                            // InternalAssembler.g:2014:7: (lv_operand_5_0= ruleExpression )
                            // InternalAssembler.g:2015:8: lv_operand_5_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getOrgDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_14);
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
                            // InternalAssembler.g:2034:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            {
                            // InternalAssembler.g:2034:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            // InternalAssembler.g:2035:6: (lv_isRelativeToPC_6_0= '*' )
                            {
                            // InternalAssembler.g:2035:6: (lv_isRelativeToPC_6_0= '*' )
                            // InternalAssembler.g:2036:7: lv_isRelativeToPC_6_0= '*'
                            {
                            lv_isRelativeToPC_6_0=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
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

            // InternalAssembler.g:2050:3: (this_WS_7= RULE_WS )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_WS) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAssembler.g:2051:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:2056:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalAssembler.g:2057:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:2057:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:2058:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:2085:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:2085:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:2086:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:2092:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:2098:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:2099:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:2099:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:2100:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:2100:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAssembler.g:2101:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2101:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:2102:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:2123:3: ( (lv_directive_2_0= 'EQU' ) )
            // InternalAssembler.g:2124:4: (lv_directive_2_0= 'EQU' )
            {
            // InternalAssembler.g:2124:4: (lv_directive_2_0= 'EQU' )
            // InternalAssembler.g:2125:5: lv_directive_2_0= 'EQU'
            {
            lv_directive_2_0=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
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

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:2141:3: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==22) ) {
                int LA58_1 = input.LA(2);

                if ( ((LA58_1>=RULE_ID && LA58_1<=RULE_CHARACTER)||(LA58_1>=33 && LA58_1<=34)||(LA58_1>=40 && LA58_1<=41)) ) {
                    alt58=1;
                }
                else if ( ((LA58_1>=RULE_WS && LA58_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA58_1>=RULE_CR && LA58_1<=RULE_END_OF_FILE)) ) {
                    alt58=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA58_0>=RULE_ID && LA58_0<=RULE_CHARACTER)||(LA58_0>=33 && LA58_0<=34)||(LA58_0>=40 && LA58_0<=41)) ) {
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
                    // InternalAssembler.g:2142:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:2142:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:2143:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:2143:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==22) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // InternalAssembler.g:2144:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:2144:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:2145:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
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

                    // InternalAssembler.g:2157:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:2158:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:2158:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:2159:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getEquDirectiveAccess().getOperandExpressionParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_14);
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
                    // InternalAssembler.g:2178:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    {
                    // InternalAssembler.g:2178:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    // InternalAssembler.g:2179:5: (lv_isRelativeToPC_6_0= '*' )
                    {
                    // InternalAssembler.g:2179:5: (lv_isRelativeToPC_6_0= '*' )
                    // InternalAssembler.g:2180:6: lv_isRelativeToPC_6_0= '*'
                    {
                    lv_isRelativeToPC_6_0=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
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

            // InternalAssembler.g:2193:3: (this_WS_7= RULE_WS )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_WS) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAssembler.g:2194:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:2199:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalAssembler.g:2200:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:2200:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:2201:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:2228:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:2228:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:2229:2: iv_ruleListOfExpression= ruleListOfExpression EOF
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
    // InternalAssembler.g:2235:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2241:2: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalAssembler.g:2242:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalAssembler.g:2242:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalAssembler.g:2243:3: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalAssembler.g:2243:3: ( (lv_expressions_0_0= ruleExpression ) )
            // InternalAssembler.g:2244:4: (lv_expressions_0_0= ruleExpression )
            {
            // InternalAssembler.g:2244:4: (lv_expressions_0_0= ruleExpression )
            // InternalAssembler.g:2245:5: lv_expressions_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalAssembler.g:2262:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==19) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalAssembler.g:2263:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:2267:4: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalAssembler.g:2268:5: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalAssembler.g:2268:5: (lv_expressions_2_0= ruleExpression )
            	    // InternalAssembler.g:2269:6: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
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
            	    break loop61;
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
    // InternalAssembler.g:2291:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:2291:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:2292:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalAssembler.g:2298:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2304:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:2305:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:2305:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:2306:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:2306:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:2307:4: lv_operand_0_0= ruleMultiplication
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
    // InternalAssembler.g:2327:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:2327:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:2328:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:2334:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2340:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:2341:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:2341:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:2342:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_Division_0=ruleDivision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Division_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2350:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==22) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalAssembler.g:2351:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:2351:4: ()
            	    // InternalAssembler.g:2352:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:2358:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:2359:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:2359:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:2360:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
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

            	    // InternalAssembler.g:2372:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:2373:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:2373:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:2374:6: lv_right_3_0= ruleDivision
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop62;
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
    // InternalAssembler.g:2396:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:2396:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:2397:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:2403:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2409:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:2410:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:2410:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:2411:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_30);
            this_Modulo_0=ruleModulo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Modulo_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2419:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==31) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalAssembler.g:2420:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:2420:4: ()
            	    // InternalAssembler.g:2421:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:2427:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:2428:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:2428:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:2429:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,31,FOLLOW_18); if (state.failed) return current;
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

            	    // InternalAssembler.g:2441:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:2442:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:2442:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:2443:6: lv_right_3_0= ruleModulo
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    break loop63;
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
    // InternalAssembler.g:2465:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:2465:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:2466:2: iv_ruleModulo= ruleModulo EOF
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
    // InternalAssembler.g:2472:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2478:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:2479:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:2479:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:2480:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2488:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==32) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalAssembler.g:2489:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:2489:4: ()
            	    // InternalAssembler.g:2490:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:2496:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:2497:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:2497:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:2498:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,32,FOLLOW_18); if (state.failed) return current;
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

            	    // InternalAssembler.g:2510:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:2511:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:2511:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:2512:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
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
            	    break loop64;
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
    // InternalAssembler.g:2534:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:2534:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:2535:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:2541:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2547:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:2548:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:2548:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:2549:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_32);
            this_Substraction_0=ruleSubstraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Substraction_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2557:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==33) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalAssembler.g:2558:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:2558:4: ()
            	    // InternalAssembler.g:2559:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,33,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2569:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:2570:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:2570:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:2571:6: lv_right_3_0= ruleSubstraction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
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
            	    break loop65;
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
    // InternalAssembler.g:2593:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:2593:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:2594:2: iv_ruleSubstraction= ruleSubstraction EOF
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
    // InternalAssembler.g:2600:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2606:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:2607:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:2607:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:2608:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_33);
            this_LeftShift_0=ruleLeftShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LeftShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2616:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==34) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalAssembler.g:2617:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:2617:4: ()
            	    // InternalAssembler.g:2618:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:2624:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:2625:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,34,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:2631:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:2632:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:2632:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:2633:6: lv_right_3_0= ruleLeftShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop66;
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
    // InternalAssembler.g:2655:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:2655:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:2656:2: iv_ruleLeftShift= ruleLeftShift EOF
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
    // InternalAssembler.g:2662:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2668:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:2669:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:2669:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:2670:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLeftShiftAccess().getRightShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_34);
            this_RightShift_0=ruleRightShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RightShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2678:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==35) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalAssembler.g:2679:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:2679:4: ()
            	    // InternalAssembler.g:2680:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2690:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:2691:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:2691:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:2692:6: lv_right_3_0= ruleRightShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLeftShiftAccess().getRightRightShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
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
            	    break loop67;
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
    // InternalAssembler.g:2714:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:2714:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:2715:2: iv_ruleRightShift= ruleRightShift EOF
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
    // InternalAssembler.g:2721:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2727:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:2728:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:2728:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:2729:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRightShiftAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2737:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==36) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalAssembler.g:2738:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:2738:4: ()
            	    // InternalAssembler.g:2739:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,36,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2749:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:2750:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:2750:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:2751:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRightShiftAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
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
            	    break loop68;
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
    // InternalAssembler.g:2773:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:2773:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:2774:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalAssembler.g:2780:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2786:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:2787:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:2787:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:2788:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getOrParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_36);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Or_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2796:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==37) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalAssembler.g:2797:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:2797:4: ()
            	    // InternalAssembler.g:2798:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,37,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2808:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:2809:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:2809:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:2810:6: lv_right_3_0= ruleOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
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
            	    break loop69;
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
    // InternalAssembler.g:2832:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:2832:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:2833:2: iv_ruleOr= ruleOr EOF
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
    // InternalAssembler.g:2839:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2845:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:2846:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:2846:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:2847:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getXorParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_37);
            this_Xor_0=ruleXor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Xor_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2855:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==38) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalAssembler.g:2856:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:2856:4: ()
            	    // InternalAssembler.g:2857:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,38,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2867:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:2868:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:2868:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:2869:6: lv_right_3_0= ruleXor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
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
            	    break loop70;
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
    // InternalAssembler.g:2891:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:2891:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:2892:2: iv_ruleXor= ruleXor EOF
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
    // InternalAssembler.g:2898:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2904:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:2905:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:2905:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:2906:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2914:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==39) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalAssembler.g:2915:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:2915:4: ()
            	    // InternalAssembler.g:2916:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,39,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2926:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:2927:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:2927:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:2928:6: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
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
            	    break loop71;
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
    // InternalAssembler.g:2950:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:2950:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:2951:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:2957:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
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
            // InternalAssembler.g:2963:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:2964:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:2964:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt72=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 33:
            case 34:
                {
                alt72=1;
                }
                break;
            case RULE_HEXA:
                {
                alt72=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt72=3;
                }
                break;
            case RULE_BINARY:
                {
                alt72=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt72=5;
                }
                break;
            case RULE_ID:
                {
                alt72=6;
                }
                break;
            case 40:
                {
                alt72=7;
                }
                break;
            case 41:
                {
                alt72=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalAssembler.g:2965:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:2965:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:2966:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:2966:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:2967:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:2985:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:2985:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:2986:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:2986:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:2987:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:3005:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:3005:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:3006:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:3006:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:3007:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:3025:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:3025:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:3026:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:3026:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:3027:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:3045:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:3045:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:3046:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:3046:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:3047:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:3065:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:3065:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:3066:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:3066:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:3067:5: lv_value_5_0= ruleIdentifierValue
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
                    // InternalAssembler.g:3085:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:3085:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:3086:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:3086:4: ()
                    // InternalAssembler.g:3087:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,40,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:3097:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:3098:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:3098:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:3099:6: lv_value_8_0= rulePrimary
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
                    // InternalAssembler.g:3118:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:3118:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:3119:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,41,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_39);
                    this_Multiplication_10=ruleMultiplication();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Multiplication_10;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_11=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleIdentifierValue"
    // InternalAssembler.g:3140:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:3140:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:3141:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
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
    // InternalAssembler.g:3147:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3153:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:3154:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:3154:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:3155:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:3155:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:3156:4: lv_value_0_0= RULE_ID
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
    // InternalAssembler.g:3175:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:3175:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:3176:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalAssembler.g:3182:1: ruleDecimalValue returns [EObject current=null] : ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_sign_0_1=null;
        Token lv_sign_0_2=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3188:2: ( ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:3189:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:3189:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:3190:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:3190:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=33 && LA74_0<=34)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalAssembler.g:3191:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    {
                    // InternalAssembler.g:3191:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    // InternalAssembler.g:3192:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    {
                    // InternalAssembler.g:3192:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==34) ) {
                        alt73=1;
                    }
                    else if ( (LA73_0==33) ) {
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
                            // InternalAssembler.g:3193:6: lv_sign_0_1= '-'
                            {
                            lv_sign_0_1=(Token)match(input,34,FOLLOW_40); if (state.failed) return current;
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
                            // InternalAssembler.g:3204:6: lv_sign_0_2= '+'
                            {
                            lv_sign_0_2=(Token)match(input,33,FOLLOW_40); if (state.failed) return current;
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

            // InternalAssembler.g:3217:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:3218:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:3218:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:3219:5: lv_value_1_0= RULE_INT
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
    // InternalAssembler.g:3239:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:3239:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:3240:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
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
    // InternalAssembler.g:3246:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3252:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:3253:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:3253:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:3254:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:3254:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:3255:4: lv_value_0_0= RULE_HEXA
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
    // InternalAssembler.g:3274:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:3274:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:3275:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:3281:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3287:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:3288:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:3288:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:3289:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:3289:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:3290:4: lv_value_0_0= RULE_OCTAL
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
    // InternalAssembler.g:3309:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:3309:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:3310:2: iv_ruleBinaryValue= ruleBinaryValue EOF
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
    // InternalAssembler.g:3316:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3322:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:3323:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:3323:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:3324:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:3324:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:3325:4: lv_value_0_0= RULE_BINARY
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
    // InternalAssembler.g:3344:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:3344:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:3345:2: iv_ruleCharacterValue= ruleCharacterValue EOF
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
    // InternalAssembler.g:3351:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:3357:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:3358:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:3358:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:3359:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:3359:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:3360:4: lv_value_0_0= RULE_CHARACTER
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
    // InternalAssembler.g:3379:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:3379:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:3380:2: iv_ruleEndOfLine= ruleEndOfLine EOF
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
    // InternalAssembler.g:3386:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:3392:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:3393:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:3393:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_CR) ) {
                alt75=1;
            }
            else if ( (LA75_0==RULE_END_OF_FILE) ) {
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
                    // InternalAssembler.g:3394:3: this_CR_0= RULE_CR
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
                    // InternalAssembler.g:3402:3: this_END_OF_FILE_1= RULE_END_OF_FILE
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
    // InternalAssembler.g:3413:1: ruleAssemblyOption returns [Enumerator current=null] : ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) ;
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
            // InternalAssembler.g:3419:2: ( ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) ) )
            // InternalAssembler.g:3420:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            {
            // InternalAssembler.g:3420:2: ( (enumLiteral_0= 'PAG' ) | (enumLiteral_1= 'NOP' ) | (enumLiteral_2= 'CON' ) | (enumLiteral_3= 'NOC' ) | (enumLiteral_4= 'MAC' ) | (enumLiteral_5= 'NOM' ) | (enumLiteral_6= 'EXP' ) | (enumLiteral_7= 'NOE' ) )
            int alt76=8;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt76=1;
                }
                break;
            case 43:
                {
                alt76=2;
                }
                break;
            case 44:
                {
                alt76=3;
                }
                break;
            case 45:
                {
                alt76=4;
                }
                break;
            case 46:
                {
                alt76=5;
                }
                break;
            case 47:
                {
                alt76=6;
                }
                break;
            case 48:
                {
                alt76=7;
                }
                break;
            case 49:
                {
                alt76=8;
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
                    // InternalAssembler.g:3421:3: (enumLiteral_0= 'PAG' )
                    {
                    // InternalAssembler.g:3421:3: (enumLiteral_0= 'PAG' )
                    // InternalAssembler.g:3422:4: enumLiteral_0= 'PAG'
                    {
                    enumLiteral_0=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssemblyOptionAccess().getPAGEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:3429:3: (enumLiteral_1= 'NOP' )
                    {
                    // InternalAssembler.g:3429:3: (enumLiteral_1= 'NOP' )
                    // InternalAssembler.g:3430:4: enumLiteral_1= 'NOP'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssemblyOptionAccess().getNOPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:3437:3: (enumLiteral_2= 'CON' )
                    {
                    // InternalAssembler.g:3437:3: (enumLiteral_2= 'CON' )
                    // InternalAssembler.g:3438:4: enumLiteral_2= 'CON'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssemblyOptionAccess().getCONEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:3445:3: (enumLiteral_3= 'NOC' )
                    {
                    // InternalAssembler.g:3445:3: (enumLiteral_3= 'NOC' )
                    // InternalAssembler.g:3446:4: enumLiteral_3= 'NOC'
                    {
                    enumLiteral_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssemblyOptionAccess().getNOCEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:3453:3: (enumLiteral_4= 'MAC' )
                    {
                    // InternalAssembler.g:3453:3: (enumLiteral_4= 'MAC' )
                    // InternalAssembler.g:3454:4: enumLiteral_4= 'MAC'
                    {
                    enumLiteral_4=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssemblyOptionAccess().getMACEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:3461:3: (enumLiteral_5= 'NOM' )
                    {
                    // InternalAssembler.g:3461:3: (enumLiteral_5= 'NOM' )
                    // InternalAssembler.g:3462:4: enumLiteral_5= 'NOM'
                    {
                    enumLiteral_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssemblyOptionAccess().getNOMEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:3469:3: (enumLiteral_6= 'EXP' )
                    {
                    // InternalAssembler.g:3469:3: (enumLiteral_6= 'EXP' )
                    // InternalAssembler.g:3470:4: enumLiteral_6= 'EXP'
                    {
                    enumLiteral_6=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssemblyOptionAccess().getEXPEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:3477:3: (enumLiteral_7= 'NOE' )
                    {
                    // InternalAssembler.g:3477:3: (enumLiteral_7= 'NOE' )
                    // InternalAssembler.g:3478:4: enumLiteral_7= 'NOE'
                    {
                    enumLiteral_7=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\2\4\1\17\15\uffff";
    static final String dfa_3s = "\1\6\1\4\1\36\15\uffff";
    static final String dfa_4s = "\3\uffff\1\1\1\5\1\6\1\3\1\2\1\12\1\15\1\11\1\14\1\4\1\10\1\7\1\13";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\1\uffff\1\1",
            "\1\2",
            "\2\12\1\15\1\16\1\uffff\1\4\1\10\1\uffff\1\5\1\6\1\11\1\13\1\17\1\14\1\7\1\3",
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
            return "288:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFailDirective ) ) | ( (lv_directive_5_0= ruleFillDirective ) ) | ( (lv_directive_6_0= ruleOptDirective ) ) | ( (lv_directive_7_0= rulePagDirective ) ) | ( (lv_directive_8_0= ruleNamDirective ) ) | ( (lv_directive_9_0= ruleSetDirective ) ) | ( (lv_directive_10_0= ruleRmbDirective ) ) | ( (lv_directive_11_0= ruleFcbDirective ) ) | ( (lv_directive_12_0= ruleFdbDirective ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000030600003FD0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0003F80000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000083010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000003030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000030600400FC0L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000030600000FC0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000080L});

}
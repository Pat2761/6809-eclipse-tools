package org.bpy.electronics.mc6809.assembler.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_ID", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "RULE_STRING", "'FCB'", "'RMB'", "'END'", "'ORG'", "'EQU'", "','", "'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'&&'", "'||'", "'^'", "'!'", "'('", "')'"
    };
    public static final int RULE_ANY_EXCEPT_COMMENT_END_OF_LINE=5;
    public static final int RULE_CHARACTER=11;
    public static final int RULE_CR=12;
    public static final int RULE_STRING=14;
    public static final int T__19=19;
    public static final int RULE_OCTAL=9;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int RULE_END_OF_FILE=13;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=6;
    public static final int RULE_WS=4;
    public static final int RULE_HEXA=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int RULE_BINARY=10;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // InternalAssembler.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAssembler.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalAssembler.g:65:2: iv_ruleModel= ruleModel EOF
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
    // InternalAssembler.g:71:1: ruleModel returns [EObject current=null] : ( (lv_sourceLines_0_0= ruleSourceLine ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_sourceLines_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:77:2: ( ( (lv_sourceLines_0_0= ruleSourceLine ) )* )
            // InternalAssembler.g:78:2: ( (lv_sourceLines_0_0= ruleSourceLine ) )*
            {
            // InternalAssembler.g:78:2: ( (lv_sourceLines_0_0= ruleSourceLine ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_WS && LA1_0<=RULE_ID)||(LA1_0>=RULE_CR && LA1_0<=RULE_END_OF_FILE)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAssembler.g:79:3: (lv_sourceLines_0_0= ruleSourceLine )
            	    {
            	    // InternalAssembler.g:79:3: (lv_sourceLines_0_0= ruleSourceLine )
            	    // InternalAssembler.g:80:4: lv_sourceLines_0_0= ruleSourceLine
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
    // InternalAssembler.g:100:1: entryRuleSourceLine returns [EObject current=null] : iv_ruleSourceLine= ruleSourceLine EOF ;
    public final EObject entryRuleSourceLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceLine = null;


        try {
            // InternalAssembler.g:100:51: (iv_ruleSourceLine= ruleSourceLine EOF )
            // InternalAssembler.g:101:2: iv_ruleSourceLine= ruleSourceLine EOF
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
    // InternalAssembler.g:107:1: ruleSourceLine returns [EObject current=null] : ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) ) ;
    public final EObject ruleSourceLine() throws RecognitionException {
        EObject current = null;

        EObject lv_lineContent_0_0 = null;

        EObject lv_lineContent_1_0 = null;

        EObject lv_lineContent_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:113:2: ( ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) ) )
            // InternalAssembler.g:114:2: ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) )
            {
            // InternalAssembler.g:114:2: ( ( (lv_lineContent_0_0= ruleBlankLine ) ) | ( (lv_lineContent_1_0= ruleCommentLine ) ) | ( (lv_lineContent_2_0= ruleDirectiveLine ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_WS:
                {
                int LA2_1 = input.LA(2);

                if ( ((LA2_1>=15 && LA2_1<=19)) ) {
                    alt2=3;
                }
                else if ( ((LA2_1>=RULE_CR && LA2_1<=RULE_END_OF_FILE)) ) {
                    alt2=1;
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
                    // InternalAssembler.g:115:3: ( (lv_lineContent_0_0= ruleBlankLine ) )
                    {
                    // InternalAssembler.g:115:3: ( (lv_lineContent_0_0= ruleBlankLine ) )
                    // InternalAssembler.g:116:4: (lv_lineContent_0_0= ruleBlankLine )
                    {
                    // InternalAssembler.g:116:4: (lv_lineContent_0_0= ruleBlankLine )
                    // InternalAssembler.g:117:5: lv_lineContent_0_0= ruleBlankLine
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
                    // InternalAssembler.g:135:3: ( (lv_lineContent_1_0= ruleCommentLine ) )
                    {
                    // InternalAssembler.g:135:3: ( (lv_lineContent_1_0= ruleCommentLine ) )
                    // InternalAssembler.g:136:4: (lv_lineContent_1_0= ruleCommentLine )
                    {
                    // InternalAssembler.g:136:4: (lv_lineContent_1_0= ruleCommentLine )
                    // InternalAssembler.g:137:5: lv_lineContent_1_0= ruleCommentLine
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
                    // InternalAssembler.g:155:3: ( (lv_lineContent_2_0= ruleDirectiveLine ) )
                    {
                    // InternalAssembler.g:155:3: ( (lv_lineContent_2_0= ruleDirectiveLine ) )
                    // InternalAssembler.g:156:4: (lv_lineContent_2_0= ruleDirectiveLine )
                    {
                    // InternalAssembler.g:156:4: (lv_lineContent_2_0= ruleDirectiveLine )
                    // InternalAssembler.g:157:5: lv_lineContent_2_0= ruleDirectiveLine
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
    // InternalAssembler.g:178:1: entryRuleBlankLine returns [EObject current=null] : iv_ruleBlankLine= ruleBlankLine EOF ;
    public final EObject entryRuleBlankLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlankLine = null;


        try {
            // InternalAssembler.g:178:50: (iv_ruleBlankLine= ruleBlankLine EOF )
            // InternalAssembler.g:179:2: iv_ruleBlankLine= ruleBlankLine EOF
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
    // InternalAssembler.g:185:1: ruleBlankLine returns [EObject current=null] : ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine ) ;
    public final EObject ruleBlankLine() throws RecognitionException {
        EObject current = null;

        Token lv_blankLine_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:191:2: ( ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine ) )
            // InternalAssembler.g:192:2: ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:192:2: ( () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine )
            // InternalAssembler.g:193:3: () ( (lv_blankLine_1_0= RULE_WS ) )? ruleEndOfLine
            {
            // InternalAssembler.g:193:3: ()
            // InternalAssembler.g:194:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlankLineAccess().getBlankLineAction_0(),
              					current);
              			
            }

            }

            // InternalAssembler.g:200:3: ( (lv_blankLine_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssembler.g:201:4: (lv_blankLine_1_0= RULE_WS )
                    {
                    // InternalAssembler.g:201:4: (lv_blankLine_1_0= RULE_WS )
                    // InternalAssembler.g:202:5: lv_blankLine_1_0= RULE_WS
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
    // InternalAssembler.g:229:1: entryRuleCommentLine returns [EObject current=null] : iv_ruleCommentLine= ruleCommentLine EOF ;
    public final EObject entryRuleCommentLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentLine = null;


        try {
            // InternalAssembler.g:229:52: (iv_ruleCommentLine= ruleCommentLine EOF )
            // InternalAssembler.g:230:2: iv_ruleCommentLine= ruleCommentLine EOF
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
    // InternalAssembler.g:236:1: ruleCommentLine returns [EObject current=null] : ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine ) ;
    public final EObject ruleCommentLine() throws RecognitionException {
        EObject current = null;

        Token lv_comment_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:242:2: ( ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine ) )
            // InternalAssembler.g:243:2: ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine )
            {
            // InternalAssembler.g:243:2: ( ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine )
            // InternalAssembler.g:244:3: ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) ruleEndOfLine
            {
            // InternalAssembler.g:244:3: ( (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
            // InternalAssembler.g:245:4: (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            {
            // InternalAssembler.g:245:4: (lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            // InternalAssembler.g:246:5: lv_comment_0_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:273:1: entryRuleDirectiveLine returns [EObject current=null] : iv_ruleDirectiveLine= ruleDirectiveLine EOF ;
    public final EObject entryRuleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectiveLine = null;


        try {
            // InternalAssembler.g:273:54: (iv_ruleDirectiveLine= ruleDirectiveLine EOF )
            // InternalAssembler.g:274:2: iv_ruleDirectiveLine= ruleDirectiveLine EOF
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
    // InternalAssembler.g:280:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleEndDirective ) ) | ( (lv_directive_3_0= ruleRmbDirective ) ) | ( (lv_directive_4_0= ruleFcbDirective ) ) ) ;
    public final EObject ruleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject lv_directive_0_0 = null;

        EObject lv_directive_1_0 = null;

        EObject lv_directive_2_0 = null;

        EObject lv_directive_3_0 = null;

        EObject lv_directive_4_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:286:2: ( ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleEndDirective ) ) | ( (lv_directive_3_0= ruleRmbDirective ) ) | ( (lv_directive_4_0= ruleFcbDirective ) ) ) )
            // InternalAssembler.g:287:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleEndDirective ) ) | ( (lv_directive_3_0= ruleRmbDirective ) ) | ( (lv_directive_4_0= ruleFcbDirective ) ) )
            {
            // InternalAssembler.g:287:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleEndDirective ) ) | ( (lv_directive_3_0= ruleRmbDirective ) ) | ( (lv_directive_4_0= ruleFcbDirective ) ) )
            int alt4=5;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==RULE_WS) ) {
                    switch ( input.LA(3) ) {
                    case 19:
                        {
                        alt4=1;
                        }
                        break;
                    case 17:
                        {
                        alt4=3;
                        }
                        break;
                    case 15:
                        {
                        alt4=5;
                        }
                        break;
                    case 18:
                        {
                        alt4=2;
                        }
                        break;
                    case 16:
                        {
                        alt4=4;
                        }
                        break;
                    default:
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
                switch ( input.LA(2) ) {
                case 19:
                    {
                    alt4=1;
                    }
                    break;
                case 17:
                    {
                    alt4=3;
                    }
                    break;
                case 15:
                    {
                    alt4=5;
                    }
                    break;
                case 18:
                    {
                    alt4=2;
                    }
                    break;
                case 16:
                    {
                    alt4=4;
                    }
                    break;
                default:
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
                    // InternalAssembler.g:288:3: ( (lv_directive_0_0= ruleEquDirective ) )
                    {
                    // InternalAssembler.g:288:3: ( (lv_directive_0_0= ruleEquDirective ) )
                    // InternalAssembler.g:289:4: (lv_directive_0_0= ruleEquDirective )
                    {
                    // InternalAssembler.g:289:4: (lv_directive_0_0= ruleEquDirective )
                    // InternalAssembler.g:290:5: lv_directive_0_0= ruleEquDirective
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
                    // InternalAssembler.g:308:3: ( (lv_directive_1_0= ruleOrgDirective ) )
                    {
                    // InternalAssembler.g:308:3: ( (lv_directive_1_0= ruleOrgDirective ) )
                    // InternalAssembler.g:309:4: (lv_directive_1_0= ruleOrgDirective )
                    {
                    // InternalAssembler.g:309:4: (lv_directive_1_0= ruleOrgDirective )
                    // InternalAssembler.g:310:5: lv_directive_1_0= ruleOrgDirective
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
                    // InternalAssembler.g:328:3: ( (lv_directive_2_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:328:3: ( (lv_directive_2_0= ruleEndDirective ) )
                    // InternalAssembler.g:329:4: (lv_directive_2_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:329:4: (lv_directive_2_0= ruleEndDirective )
                    // InternalAssembler.g:330:5: lv_directive_2_0= ruleEndDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveEndDirectiveParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_2_0=ruleEndDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.EndDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:348:3: ( (lv_directive_3_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:348:3: ( (lv_directive_3_0= ruleRmbDirective ) )
                    // InternalAssembler.g:349:4: (lv_directive_3_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:349:4: (lv_directive_3_0= ruleRmbDirective )
                    // InternalAssembler.g:350:5: lv_directive_3_0= ruleRmbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveRmbDirectiveParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_3_0=ruleRmbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.RmbDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:368:3: ( (lv_directive_4_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:368:3: ( (lv_directive_4_0= ruleFcbDirective ) )
                    // InternalAssembler.g:369:4: (lv_directive_4_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:369:4: (lv_directive_4_0= ruleFcbDirective )
                    // InternalAssembler.g:370:5: lv_directive_4_0= ruleFcbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFcbDirectiveParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_4_0=ruleFcbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FcbDirective");
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


    // $ANTLR start "entryRuleFcbDirective"
    // InternalAssembler.g:391:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:391:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:392:2: iv_ruleFcbDirective= ruleFcbDirective EOF
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
    // InternalAssembler.g:398:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:404:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:405:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:405:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:406:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:406:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:407:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:407:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:408:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:429:3: ( (lv_directive_2_0= 'FCB' ) )
            // InternalAssembler.g:430:4: (lv_directive_2_0= 'FCB' )
            {
            // InternalAssembler.g:430:4: (lv_directive_2_0= 'FCB' )
            // InternalAssembler.g:431:5: lv_directive_2_0= 'FCB'
            {
            lv_directive_2_0=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:443:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_WS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:444:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:448:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:449:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:449:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:450:6: lv_operand_4_0= ruleListOfExpression
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

            // InternalAssembler.g:468:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WS) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:469:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:473:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:474:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:474:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:475:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:492:3: (this_WS_7= RULE_WS )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_WS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:493:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:509:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:509:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:510:2: iv_ruleRmbDirective= ruleRmbDirective EOF
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
    // InternalAssembler.g:516:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleRmbDirective() throws RecognitionException {
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
            // InternalAssembler.g:522:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:523:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:523:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:524:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:524:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:525:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:525:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:526:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:547:3: ( (lv_directive_2_0= 'RMB' ) )
            // InternalAssembler.g:548:4: (lv_directive_2_0= 'RMB' )
            {
            // InternalAssembler.g:548:4: (lv_directive_2_0= 'RMB' )
            // InternalAssembler.g:549:5: lv_directive_2_0= 'RMB'
            {
            lv_directive_2_0=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:561:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_WS) ) {
                int LA10_1 = input.LA(2);

                if ( ((LA10_1>=RULE_ID && LA10_1<=RULE_CHARACTER)||LA10_1==25||(LA10_1>=31 && LA10_1<=32)) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:562:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:566:4: ( (lv_operand_4_0= ruleExpression ) )
                    // InternalAssembler.g:567:5: (lv_operand_4_0= ruleExpression )
                    {
                    // InternalAssembler.g:567:5: (lv_operand_4_0= ruleExpression )
                    // InternalAssembler.g:568:6: lv_operand_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRmbDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRmbDirectiveRule());
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
                    break;

            }

            // InternalAssembler.g:586:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:587:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:591:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:592:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:592:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:593:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getRmbDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRmbDirectiveRule());
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

            // InternalAssembler.g:610:3: (this_WS_7= RULE_WS )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_WS) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAssembler.g:611:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_5());
                      			
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
    // InternalAssembler.g:627:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:627:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:628:2: iv_ruleEndDirective= ruleEndDirective EOF
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
    // InternalAssembler.g:634:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleEndDirective() throws RecognitionException {
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
            // InternalAssembler.g:640:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:641:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:641:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:642:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:642:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAssembler.g:643:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:643:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:644:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:665:3: ( (lv_directive_2_0= 'END' ) )
            // InternalAssembler.g:666:4: (lv_directive_2_0= 'END' )
            {
            // InternalAssembler.g:666:4: (lv_directive_2_0= 'END' )
            // InternalAssembler.g:667:5: lv_directive_2_0= 'END'
            {
            lv_directive_2_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:679:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_WS) ) {
                int LA14_1 = input.LA(2);

                if ( ((LA14_1>=RULE_ID && LA14_1<=RULE_CHARACTER)||LA14_1==25||(LA14_1>=31 && LA14_1<=32)) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalAssembler.g:680:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:684:4: ( (lv_operand_4_0= ruleExpression ) )
                    // InternalAssembler.g:685:5: (lv_operand_4_0= ruleExpression )
                    {
                    // InternalAssembler.g:685:5: (lv_operand_4_0= ruleExpression )
                    // InternalAssembler.g:686:6: lv_operand_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEndDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEndDirectiveRule());
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
                    break;

            }

            // InternalAssembler.g:704:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:705:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:709:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:710:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:710:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:711:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getEndDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEndDirectiveRule());
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

            // InternalAssembler.g:728:3: (this_WS_7= RULE_WS )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_WS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAssembler.g:729:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_5());
                      			
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
    // InternalAssembler.g:745:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:745:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:746:2: iv_ruleOrgDirective= ruleOrgDirective EOF
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
    // InternalAssembler.g:752:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
    public final EObject ruleOrgDirective() throws RecognitionException {
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
            // InternalAssembler.g:758:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:759:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:759:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:760:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:760:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAssembler.g:761:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:761:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:762:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:783:3: ( (lv_directive_2_0= 'ORG' ) )
            // InternalAssembler.g:784:4: (lv_directive_2_0= 'ORG' )
            {
            // InternalAssembler.g:784:4: (lv_directive_2_0= 'ORG' )
            // InternalAssembler.g:785:5: lv_directive_2_0= 'ORG'
            {
            lv_directive_2_0=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:797:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_WS) ) {
                int LA18_1 = input.LA(2);

                if ( ((LA18_1>=RULE_ID && LA18_1<=RULE_CHARACTER)||LA18_1==25||(LA18_1>=31 && LA18_1<=32)) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // InternalAssembler.g:798:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:802:4: ( (lv_operand_4_0= ruleExpression ) )
                    // InternalAssembler.g:803:5: (lv_operand_4_0= ruleExpression )
                    {
                    // InternalAssembler.g:803:5: (lv_operand_4_0= ruleExpression )
                    // InternalAssembler.g:804:6: lv_operand_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOrgDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_operand_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOrgDirectiveRule());
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
                    break;

            }

            // InternalAssembler.g:822:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_WS) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // InternalAssembler.g:823:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:827:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:828:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:828:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:829:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_comment_6_0, grammarAccess.getOrgDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getOrgDirectiveRule());
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

            // InternalAssembler.g:846:3: (this_WS_7= RULE_WS )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_WS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:847:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_5());
                      			
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
    // InternalAssembler.g:863:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:863:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:864:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:870:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
    public final EObject ruleEquDirective() throws RecognitionException {
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
            // InternalAssembler.g:876:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:877:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:877:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:878:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:878:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalAssembler.g:879:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:879:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:880:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:901:3: ( (lv_directive_2_0= 'EQU' ) )
            // InternalAssembler.g:902:4: (lv_directive_2_0= 'EQU' )
            {
            // InternalAssembler.g:902:4: (lv_directive_2_0= 'EQU' )
            // InternalAssembler.g:903:5: lv_directive_2_0= 'EQU'
            {
            lv_directive_2_0=(Token)match(input,19,FOLLOW_5); if (state.failed) return current;
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

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:919:3: ( (lv_operand_4_0= ruleExpression ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_CHARACTER)||LA22_0==25||(LA22_0>=31 && LA22_0<=32)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:920:4: (lv_operand_4_0= ruleExpression )
                    {
                    // InternalAssembler.g:920:4: (lv_operand_4_0= ruleExpression )
                    // InternalAssembler.g:921:5: lv_operand_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getEquDirectiveAccess().getOperandExpressionParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_15);
                    lv_operand_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getEquDirectiveRule());
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

            // InternalAssembler.g:938:3: (this_WS_5= RULE_WS )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_WS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAssembler.g:939:4: this_WS_5= RULE_WS
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:944:3: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAssembler.g:945:4: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:945:4: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:946:5: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_comment_6_0, grammarAccess.getEquDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_6_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEquDirectiveRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"comment",
                      						lv_comment_6_0,
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
    // InternalAssembler.g:973:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:973:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:974:2: iv_ruleListOfExpression= ruleListOfExpression EOF
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
    // InternalAssembler.g:980:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpressionValue ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpressionValue ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:986:2: ( ( ( (lv_expressions_0_0= ruleExpressionValue ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpressionValue ) ) )* ) )
            // InternalAssembler.g:987:2: ( ( (lv_expressions_0_0= ruleExpressionValue ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpressionValue ) ) )* )
            {
            // InternalAssembler.g:987:2: ( ( (lv_expressions_0_0= ruleExpressionValue ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpressionValue ) ) )* )
            // InternalAssembler.g:988:3: ( (lv_expressions_0_0= ruleExpressionValue ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpressionValue ) ) )*
            {
            // InternalAssembler.g:988:3: ( (lv_expressions_0_0= ruleExpressionValue ) )
            // InternalAssembler.g:989:4: (lv_expressions_0_0= ruleExpressionValue )
            {
            // InternalAssembler.g:989:4: (lv_expressions_0_0= ruleExpressionValue )
            // InternalAssembler.g:990:5: lv_expressions_0_0= ruleExpressionValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionValueParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_expressions_0_0=ruleExpressionValue();

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
              						"org.bpy.electronics.mc6809.assembler.Assembler.ExpressionValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAssembler.g:1007:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpressionValue ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==20) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalAssembler.g:1008:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpressionValue ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:1012:4: ( (lv_expressions_2_0= ruleExpressionValue ) )
            	    // InternalAssembler.g:1013:5: (lv_expressions_2_0= ruleExpressionValue )
            	    {
            	    // InternalAssembler.g:1013:5: (lv_expressions_2_0= ruleExpressionValue )
            	    // InternalAssembler.g:1014:6: lv_expressions_2_0= ruleExpressionValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionValueParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_expressions_2_0=ruleExpressionValue();

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
            	      							"org.bpy.electronics.mc6809.assembler.Assembler.ExpressionValue");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
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


    // $ANTLR start "entryRuleExpressionValue"
    // InternalAssembler.g:1036:1: entryRuleExpressionValue returns [EObject current=null] : iv_ruleExpressionValue= ruleExpressionValue EOF ;
    public final EObject entryRuleExpressionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionValue = null;


        try {
            // InternalAssembler.g:1036:56: (iv_ruleExpressionValue= ruleExpressionValue EOF )
            // InternalAssembler.g:1037:2: iv_ruleExpressionValue= ruleExpressionValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionValue=ruleExpressionValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionValue"


    // $ANTLR start "ruleExpressionValue"
    // InternalAssembler.g:1043:1: ruleExpressionValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExpression ) )? ) ;
    public final EObject ruleExpressionValue() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1049:2: ( ( () ( (lv_value_1_0= ruleExpression ) )? ) )
            // InternalAssembler.g:1050:2: ( () ( (lv_value_1_0= ruleExpression ) )? )
            {
            // InternalAssembler.g:1050:2: ( () ( (lv_value_1_0= ruleExpression ) )? )
            // InternalAssembler.g:1051:3: () ( (lv_value_1_0= ruleExpression ) )?
            {
            // InternalAssembler.g:1051:3: ()
            // InternalAssembler.g:1052:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExpressionValueAccess().getExpressionValueAction_0(),
              					current);
              			
            }

            }

            // InternalAssembler.g:1058:3: ( (lv_value_1_0= ruleExpression ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_CHARACTER)||LA26_0==25||(LA26_0>=31 && LA26_0<=32)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAssembler.g:1059:4: (lv_value_1_0= ruleExpression )
                    {
                    // InternalAssembler.g:1059:4: (lv_value_1_0= ruleExpression )
                    // InternalAssembler.g:1060:5: lv_value_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getExpressionValueAccess().getValueExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getExpressionValueRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_1_0,
                      						"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                      					afterParserOrEnumRuleCall();
                      				
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
    // $ANTLR end "ruleExpressionValue"


    // $ANTLR start "entryRuleExpression"
    // InternalAssembler.g:1081:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:1081:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:1082:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalAssembler.g:1088:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1094:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:1095:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:1095:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:1096:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:1096:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:1097:4: lv_operand_0_0= ruleMultiplication
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
    // InternalAssembler.g:1117:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:1117:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:1118:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:1124:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1130:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:1131:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:1131:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:1132:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_17);
            this_Division_0=ruleDivision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Division_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1140:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==21) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalAssembler.g:1141:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:1141:4: ()
            	    // InternalAssembler.g:1142:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:1148:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:1149:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:1149:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:1150:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
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

            	    // InternalAssembler.g:1162:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:1163:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:1163:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:1164:6: lv_right_3_0= ruleDivision
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
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
            	    break loop27;
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
    // InternalAssembler.g:1186:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:1186:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:1187:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:1193:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1199:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:1200:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:1200:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:1201:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_18);
            this_Modulo_0=ruleModulo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Modulo_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1209:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==22) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalAssembler.g:1210:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:1210:4: ()
            	    // InternalAssembler.g:1211:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:1217:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:1218:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:1218:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:1219:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,22,FOLLOW_10); if (state.failed) return current;
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

            	    // InternalAssembler.g:1231:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:1232:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:1232:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:1233:6: lv_right_3_0= ruleModulo
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
            	    break loop28;
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
    // InternalAssembler.g:1255:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:1255:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:1256:2: iv_ruleModulo= ruleModulo EOF
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
    // InternalAssembler.g:1262:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1268:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:1269:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:1269:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:1270:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_19);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1278:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==23) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalAssembler.g:1279:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:1279:4: ()
            	    // InternalAssembler.g:1280:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:1286:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:1287:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:1287:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:1288:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
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

            	    // InternalAssembler.g:1300:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:1301:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:1301:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:1302:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
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
            	    break loop29;
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
    // InternalAssembler.g:1324:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:1324:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:1325:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:1331:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1337:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:1338:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:1338:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:1339:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_20);
            this_Substraction_0=ruleSubstraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Substraction_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1347:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==24) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalAssembler.g:1348:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:1348:4: ()
            	    // InternalAssembler.g:1349:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,24,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:1359:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:1360:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:1360:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:1361:6: lv_right_3_0= ruleSubstraction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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
            	    break loop30;
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
    // InternalAssembler.g:1383:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:1383:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:1384:2: iv_ruleSubstraction= ruleSubstraction EOF
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
    // InternalAssembler.g:1390:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1396:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:1397:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:1397:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:1398:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_21);
            this_LeftShift_0=ruleLeftShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LeftShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1406:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==25) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalAssembler.g:1407:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:1407:4: ()
            	    // InternalAssembler.g:1408:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:1414:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:1415:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:1421:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:1422:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:1422:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:1423:6: lv_right_3_0= ruleLeftShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
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
            	    break loop31;
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
    // InternalAssembler.g:1445:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:1445:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:1446:2: iv_ruleLeftShift= ruleLeftShift EOF
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
    // InternalAssembler.g:1452:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1458:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:1459:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:1459:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:1460:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLeftShiftAccess().getRightShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_22);
            this_RightShift_0=ruleRightShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RightShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1468:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==26) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalAssembler.g:1469:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:1469:4: ()
            	    // InternalAssembler.g:1470:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,26,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:1480:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:1481:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:1481:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:1482:6: lv_right_3_0= ruleRightShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLeftShiftAccess().getRightRightShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
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
            	    break loop32;
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
    // InternalAssembler.g:1504:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:1504:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:1505:2: iv_ruleRightShift= ruleRightShift EOF
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
    // InternalAssembler.g:1511:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1517:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:1518:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:1518:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:1519:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRightShiftAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_23);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1527:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==27) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalAssembler.g:1528:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:1528:4: ()
            	    // InternalAssembler.g:1529:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:1539:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:1540:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:1540:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:1541:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRightShiftAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
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
            	    break loop33;
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
    // InternalAssembler.g:1563:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:1563:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:1564:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalAssembler.g:1570:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1576:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:1577:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:1577:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:1578:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getOrParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_24);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Or_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1586:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==28) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalAssembler.g:1587:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:1587:4: ()
            	    // InternalAssembler.g:1588:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:1598:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:1599:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:1599:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:1600:6: lv_right_3_0= ruleOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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
            	    break loop34;
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
    // InternalAssembler.g:1622:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:1622:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:1623:2: iv_ruleOr= ruleOr EOF
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
    // InternalAssembler.g:1629:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1635:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:1636:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:1636:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:1637:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getXorParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_25);
            this_Xor_0=ruleXor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Xor_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1645:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==29) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalAssembler.g:1646:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:1646:4: ()
            	    // InternalAssembler.g:1647:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,29,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:1657:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:1658:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:1658:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:1659:6: lv_right_3_0= ruleXor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
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
            	    break loop35;
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
    // InternalAssembler.g:1681:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:1681:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:1682:2: iv_ruleXor= ruleXor EOF
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
    // InternalAssembler.g:1688:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1694:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:1695:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:1695:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:1696:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_26);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1704:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==30) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalAssembler.g:1705:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:1705:4: ()
            	    // InternalAssembler.g:1706:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,30,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:1716:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:1717:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:1717:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:1718:6: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
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
            	    break loop36;
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
    // InternalAssembler.g:1740:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:1740:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:1741:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:1747:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
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
            // InternalAssembler.g:1753:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:1754:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:1754:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt37=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 25:
                {
                alt37=1;
                }
                break;
            case RULE_HEXA:
                {
                alt37=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt37=3;
                }
                break;
            case RULE_BINARY:
                {
                alt37=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt37=5;
                }
                break;
            case RULE_ID:
                {
                alt37=6;
                }
                break;
            case 31:
                {
                alt37=7;
                }
                break;
            case 32:
                {
                alt37=8;
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
                    // InternalAssembler.g:1755:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:1755:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:1756:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:1756:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:1757:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:1775:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:1775:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:1776:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:1776:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:1777:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:1795:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:1795:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:1796:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:1796:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:1797:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:1815:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:1815:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:1816:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:1816:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:1817:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:1835:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:1835:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:1836:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:1836:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:1837:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:1855:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:1855:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:1856:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1856:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:1857:5: lv_value_5_0= ruleIdentifierValue
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
                    // InternalAssembler.g:1875:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:1875:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:1876:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:1876:4: ()
                    // InternalAssembler.g:1877:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:1887:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:1888:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:1888:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:1889:6: lv_value_8_0= rulePrimary
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
                    // InternalAssembler.g:1908:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:1908:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:1909:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,32,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_27);
                    this_Multiplication_10=ruleMultiplication();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Multiplication_10;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_11=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:1930:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:1930:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:1931:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
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
    // InternalAssembler.g:1937:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1943:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:1944:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:1944:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:1945:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:1945:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:1946:4: lv_value_0_0= RULE_ID
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
    // InternalAssembler.g:1965:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:1965:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:1966:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalAssembler.g:1972:1: ruleDecimalValue returns [EObject current=null] : ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_isNegative_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1978:2: ( ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:1979:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:1979:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:1980:3: ( (lv_isNegative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:1980:3: ( (lv_isNegative_0_0= '-' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==25) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAssembler.g:1981:4: (lv_isNegative_0_0= '-' )
                    {
                    // InternalAssembler.g:1981:4: (lv_isNegative_0_0= '-' )
                    // InternalAssembler.g:1982:5: lv_isNegative_0_0= '-'
                    {
                    lv_isNegative_0_0=(Token)match(input,25,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_isNegative_0_0, grammarAccess.getDecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDecimalValueRule());
                      					}
                      					setWithLastConsumed(current, "isNegative", lv_isNegative_0_0 != null, "-");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalAssembler.g:1994:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:1995:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:1995:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:1996:5: lv_value_1_0= RULE_INT
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
    // InternalAssembler.g:2016:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:2016:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:2017:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
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
    // InternalAssembler.g:2023:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2029:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:2030:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:2030:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:2031:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:2031:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:2032:4: lv_value_0_0= RULE_HEXA
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
    // InternalAssembler.g:2051:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:2051:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:2052:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:2058:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2064:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:2065:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:2065:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:2066:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:2066:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:2067:4: lv_value_0_0= RULE_OCTAL
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
    // InternalAssembler.g:2086:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:2086:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:2087:2: iv_ruleBinaryValue= ruleBinaryValue EOF
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
    // InternalAssembler.g:2093:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2099:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:2100:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:2100:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:2101:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:2101:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:2102:4: lv_value_0_0= RULE_BINARY
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
    // InternalAssembler.g:2121:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:2121:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:2122:2: iv_ruleCharacterValue= ruleCharacterValue EOF
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
    // InternalAssembler.g:2128:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2134:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:2135:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:2135:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:2136:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:2136:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:2137:4: lv_value_0_0= RULE_CHARACTER
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
    // InternalAssembler.g:2156:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:2156:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:2157:2: iv_ruleEndOfLine= ruleEndOfLine EOF
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
    // InternalAssembler.g:2163:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:2169:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:2170:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:2170:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_CR) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_END_OF_FILE) ) {
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
                    // InternalAssembler.g:2171:3: this_CR_0= RULE_CR
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
                    // InternalAssembler.g:2179:3: this_END_OF_FILE_1= RULE_END_OF_FILE
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000182100FC0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000182000FC0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000182003FF0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000003030L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000080L});

}
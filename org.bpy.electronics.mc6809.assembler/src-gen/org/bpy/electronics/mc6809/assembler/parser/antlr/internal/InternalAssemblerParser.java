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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_ID", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "RULE_STRING", "'SET'", "'*'", "'FILL'", "','", "'BSZ'", "'FDB'", "'FCB'", "'RMB'", "'END'", "'ORG'", "'EQU'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'&&'", "'||'", "'^'", "'!'", "'('", "')'"
    };
    public static final int RULE_ANY_EXCEPT_COMMENT_END_OF_LINE=5;
    public static final int RULE_CHARACTER=11;
    public static final int RULE_CR=12;
    public static final int RULE_STRING=14;
    public static final int T__19=19;
    public static final int RULE_OCTAL=9;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int RULE_END_OF_FILE=13;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
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

                if ( (LA2_1==15||LA2_1==17||(LA2_1>=19 && LA2_1<=25)) ) {
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
    // InternalAssembler.g:280:1: ruleDirectiveLine returns [EObject current=null] : ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFillDirective ) ) | ( (lv_directive_5_0= ruleSetDirective ) ) | ( (lv_directive_6_0= ruleRmbDirective ) ) | ( (lv_directive_7_0= ruleFcbDirective ) ) | ( (lv_directive_8_0= ruleFdbDirective ) ) ) ;
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



        	enterRule();

        try {
            // InternalAssembler.g:286:2: ( ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFillDirective ) ) | ( (lv_directive_5_0= ruleSetDirective ) ) | ( (lv_directive_6_0= ruleRmbDirective ) ) | ( (lv_directive_7_0= ruleFcbDirective ) ) | ( (lv_directive_8_0= ruleFdbDirective ) ) ) )
            // InternalAssembler.g:287:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFillDirective ) ) | ( (lv_directive_5_0= ruleSetDirective ) ) | ( (lv_directive_6_0= ruleRmbDirective ) ) | ( (lv_directive_7_0= ruleFcbDirective ) ) | ( (lv_directive_8_0= ruleFdbDirective ) ) )
            {
            // InternalAssembler.g:287:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFillDirective ) ) | ( (lv_directive_5_0= ruleSetDirective ) ) | ( (lv_directive_6_0= ruleRmbDirective ) ) | ( (lv_directive_7_0= ruleFcbDirective ) ) | ( (lv_directive_8_0= ruleFdbDirective ) ) )
            int alt4=9;
            alt4 = dfa4.predict(input);
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
                    // InternalAssembler.g:328:3: ( (lv_directive_2_0= ruleBszDirective ) )
                    {
                    // InternalAssembler.g:328:3: ( (lv_directive_2_0= ruleBszDirective ) )
                    // InternalAssembler.g:329:4: (lv_directive_2_0= ruleBszDirective )
                    {
                    // InternalAssembler.g:329:4: (lv_directive_2_0= ruleBszDirective )
                    // InternalAssembler.g:330:5: lv_directive_2_0= ruleBszDirective
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
                    // InternalAssembler.g:348:3: ( (lv_directive_3_0= ruleEndDirective ) )
                    {
                    // InternalAssembler.g:348:3: ( (lv_directive_3_0= ruleEndDirective ) )
                    // InternalAssembler.g:349:4: (lv_directive_3_0= ruleEndDirective )
                    {
                    // InternalAssembler.g:349:4: (lv_directive_3_0= ruleEndDirective )
                    // InternalAssembler.g:350:5: lv_directive_3_0= ruleEndDirective
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
                    // InternalAssembler.g:368:3: ( (lv_directive_4_0= ruleFillDirective ) )
                    {
                    // InternalAssembler.g:368:3: ( (lv_directive_4_0= ruleFillDirective ) )
                    // InternalAssembler.g:369:4: (lv_directive_4_0= ruleFillDirective )
                    {
                    // InternalAssembler.g:369:4: (lv_directive_4_0= ruleFillDirective )
                    // InternalAssembler.g:370:5: lv_directive_4_0= ruleFillDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFillDirectiveParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_4_0=ruleFillDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FillDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:388:3: ( (lv_directive_5_0= ruleSetDirective ) )
                    {
                    // InternalAssembler.g:388:3: ( (lv_directive_5_0= ruleSetDirective ) )
                    // InternalAssembler.g:389:4: (lv_directive_5_0= ruleSetDirective )
                    {
                    // InternalAssembler.g:389:4: (lv_directive_5_0= ruleSetDirective )
                    // InternalAssembler.g:390:5: lv_directive_5_0= ruleSetDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveSetDirectiveParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_5_0=ruleSetDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.SetDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:408:3: ( (lv_directive_6_0= ruleRmbDirective ) )
                    {
                    // InternalAssembler.g:408:3: ( (lv_directive_6_0= ruleRmbDirective ) )
                    // InternalAssembler.g:409:4: (lv_directive_6_0= ruleRmbDirective )
                    {
                    // InternalAssembler.g:409:4: (lv_directive_6_0= ruleRmbDirective )
                    // InternalAssembler.g:410:5: lv_directive_6_0= ruleRmbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveRmbDirectiveParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_6_0=ruleRmbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.RmbDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalAssembler.g:428:3: ( (lv_directive_7_0= ruleFcbDirective ) )
                    {
                    // InternalAssembler.g:428:3: ( (lv_directive_7_0= ruleFcbDirective ) )
                    // InternalAssembler.g:429:4: (lv_directive_7_0= ruleFcbDirective )
                    {
                    // InternalAssembler.g:429:4: (lv_directive_7_0= ruleFcbDirective )
                    // InternalAssembler.g:430:5: lv_directive_7_0= ruleFcbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFcbDirectiveParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_7_0=ruleFcbDirective();

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
                      						"org.bpy.electronics.mc6809.assembler.Assembler.FcbDirective");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalAssembler.g:448:3: ( (lv_directive_8_0= ruleFdbDirective ) )
                    {
                    // InternalAssembler.g:448:3: ( (lv_directive_8_0= ruleFdbDirective ) )
                    // InternalAssembler.g:449:4: (lv_directive_8_0= ruleFdbDirective )
                    {
                    // InternalAssembler.g:449:4: (lv_directive_8_0= ruleFdbDirective )
                    // InternalAssembler.g:450:5: lv_directive_8_0= ruleFdbDirective
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveFdbDirectiveParserRuleCall_8_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_directive_8_0=ruleFdbDirective();

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


    // $ANTLR start "entryRuleSetDirective"
    // InternalAssembler.g:471:1: entryRuleSetDirective returns [EObject current=null] : iv_ruleSetDirective= ruleSetDirective EOF ;
    public final EObject entryRuleSetDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDirective = null;


        try {
            // InternalAssembler.g:471:53: (iv_ruleSetDirective= ruleSetDirective EOF )
            // InternalAssembler.g:472:2: iv_ruleSetDirective= ruleSetDirective EOF
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
    // InternalAssembler.g:478:1: ruleSetDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:484:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:485:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:485:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:486:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'SET' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:486:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:487:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:487:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:488:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:509:3: ( (lv_directive_2_0= 'SET' ) )
            // InternalAssembler.g:510:4: (lv_directive_2_0= 'SET' )
            {
            // InternalAssembler.g:510:4: (lv_directive_2_0= 'SET' )
            // InternalAssembler.g:511:5: lv_directive_2_0= 'SET'
            {
            lv_directive_2_0=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
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

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:527:3: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                int LA7_1 = input.LA(2);

                if ( ((LA7_1>=RULE_ID && LA7_1<=RULE_CHARACTER)||(LA7_1>=28 && LA7_1<=29)||(LA7_1>=35 && LA7_1<=36)) ) {
                    alt7=1;
                }
                else if ( ((LA7_1>=RULE_WS && LA7_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA7_1>=RULE_CR && LA7_1<=RULE_END_OF_FILE)) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_CHARACTER)||(LA7_0>=28 && LA7_0<=29)||(LA7_0>=35 && LA7_0<=36)) ) {
                alt7=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:528:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:528:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:529:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:529:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==16) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalAssembler.g:530:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:530:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:531:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
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

                    // InternalAssembler.g:543:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:544:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:544:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:545:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetDirectiveAccess().getOperandExpressionParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_8);
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
                    // InternalAssembler.g:564:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    {
                    // InternalAssembler.g:564:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    // InternalAssembler.g:565:5: (lv_isRelativeToPC_6_0= '*' )
                    {
                    // InternalAssembler.g:565:5: (lv_isRelativeToPC_6_0= '*' )
                    // InternalAssembler.g:566:6: lv_isRelativeToPC_6_0= '*'
                    {
                    lv_isRelativeToPC_6_0=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
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

            // InternalAssembler.g:579:3: (this_WS_7= RULE_WS )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_WS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:580:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getSetDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:585:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:586:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:586:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:587:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:614:1: entryRuleFillDirective returns [EObject current=null] : iv_ruleFillDirective= ruleFillDirective EOF ;
    public final EObject entryRuleFillDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFillDirective = null;


        try {
            // InternalAssembler.g:614:54: (iv_ruleFillDirective= ruleFillDirective EOF )
            // InternalAssembler.g:615:2: iv_ruleFillDirective= ruleFillDirective EOF
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
    // InternalAssembler.g:621:1: ruleFillDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:627:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:628:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:628:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:629:3: ( (lv_name_0_0= ruleIdentifierValue ) )? (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) ) (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) ) (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:629:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:630:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:630:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:631:5: lv_name_0_0= ruleIdentifierValue
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

            // InternalAssembler.g:648:3: (this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) ) )
            // InternalAssembler.g:649:4: this_WS_1= RULE_WS ( (lv_directive_2_0= 'FILL' ) )
            {
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_1, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_1_0());
              			
            }
            // InternalAssembler.g:653:4: ( (lv_directive_2_0= 'FILL' ) )
            // InternalAssembler.g:654:5: (lv_directive_2_0= 'FILL' )
            {
            // InternalAssembler.g:654:5: (lv_directive_2_0= 'FILL' )
            // InternalAssembler.g:655:6: lv_directive_2_0= 'FILL'
            {
            lv_directive_2_0=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:668:3: (this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) ) )
            // InternalAssembler.g:669:4: this_WS_3= RULE_WS ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_number_6_0= ruleExpression ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_2_0());
              			
            }
            // InternalAssembler.g:673:4: ( (lv_value_4_0= ruleExpression ) )
            // InternalAssembler.g:674:5: (lv_value_4_0= ruleExpression )
            {
            // InternalAssembler.g:674:5: (lv_value_4_0= ruleExpression )
            // InternalAssembler.g:675:6: lv_value_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getFillDirectiveAccess().getValueExpressionParserRuleCall_2_1_0());
              					
            }
            pushFollow(FOLLOW_10);
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

            otherlv_5=(Token)match(input,18,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getFillDirectiveAccess().getCommaKeyword_2_2());
              			
            }
            // InternalAssembler.g:696:4: ( (lv_number_6_0= ruleExpression ) )
            // InternalAssembler.g:697:5: (lv_number_6_0= ruleExpression )
            {
            // InternalAssembler.g:697:5: (lv_number_6_0= ruleExpression )
            // InternalAssembler.g:698:6: lv_number_6_0= ruleExpression
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

            // InternalAssembler.g:716:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:717:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getFillDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:721:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:722:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:722:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:723:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:740:3: (this_WS_9= RULE_WS )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_WS) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAssembler.g:741:4: this_WS_9= RULE_WS
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
    // InternalAssembler.g:757:1: entryRuleBszDirective returns [EObject current=null] : iv_ruleBszDirective= ruleBszDirective EOF ;
    public final EObject entryRuleBszDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBszDirective = null;


        try {
            // InternalAssembler.g:757:53: (iv_ruleBszDirective= ruleBszDirective EOF )
            // InternalAssembler.g:758:2: iv_ruleBszDirective= ruleBszDirective EOF
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
    // InternalAssembler.g:764:1: ruleBszDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:770:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:771:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:771:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:772:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'BSZ' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) ) (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:772:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAssembler.g:773:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:773:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:774:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:795:3: ( (lv_directive_2_0= 'BSZ' ) )
            // InternalAssembler.g:796:4: (lv_directive_2_0= 'BSZ' )
            {
            // InternalAssembler.g:796:4: (lv_directive_2_0= 'BSZ' )
            // InternalAssembler.g:797:5: lv_directive_2_0= 'BSZ'
            {
            lv_directive_2_0=(Token)match(input,19,FOLLOW_5); if (state.failed) return current;
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

            // InternalAssembler.g:809:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) ) )
            // InternalAssembler.g:810:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleExpression ) )
            {
            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_WS_3, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_3_0());
              			
            }
            // InternalAssembler.g:814:4: ( (lv_operand_4_0= ruleExpression ) )
            // InternalAssembler.g:815:5: (lv_operand_4_0= ruleExpression )
            {
            // InternalAssembler.g:815:5: (lv_operand_4_0= ruleExpression )
            // InternalAssembler.g:816:6: lv_operand_4_0= ruleExpression
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

            // InternalAssembler.g:834:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_WS) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalAssembler.g:835:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getBszDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:839:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:840:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:840:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:841:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:858:3: (this_WS_7= RULE_WS )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_WS) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAssembler.g:859:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:875:1: entryRuleFdbDirective returns [EObject current=null] : iv_ruleFdbDirective= ruleFdbDirective EOF ;
    public final EObject entryRuleFdbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFdbDirective = null;


        try {
            // InternalAssembler.g:875:53: (iv_ruleFdbDirective= ruleFdbDirective EOF )
            // InternalAssembler.g:876:2: iv_ruleFdbDirective= ruleFdbDirective EOF
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
    // InternalAssembler.g:882:1: ruleFdbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:888:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:889:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:889:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:890:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FDB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:890:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAssembler.g:891:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:891:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:892:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:913:3: ( (lv_directive_2_0= 'FDB' ) )
            // InternalAssembler.g:914:4: (lv_directive_2_0= 'FDB' )
            {
            // InternalAssembler.g:914:4: (lv_directive_2_0= 'FDB' )
            // InternalAssembler.g:915:5: lv_directive_2_0= 'FDB'
            {
            lv_directive_2_0=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:927:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_WS) ) {
                int LA17_1 = input.LA(2);

                if ( ((LA17_1>=RULE_ID && LA17_1<=RULE_CHARACTER)||(LA17_1>=28 && LA17_1<=29)||(LA17_1>=35 && LA17_1<=36)) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // InternalAssembler.g:928:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:932:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:933:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:933:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:934:6: lv_operand_4_0= ruleListOfExpression
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

            // InternalAssembler.g:952:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:953:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFdbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:957:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:958:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:958:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:959:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:976:3: (this_WS_7= RULE_WS )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_WS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAssembler.g:977:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:993:1: entryRuleFcbDirective returns [EObject current=null] : iv_ruleFcbDirective= ruleFcbDirective EOF ;
    public final EObject entryRuleFcbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFcbDirective = null;


        try {
            // InternalAssembler.g:993:53: (iv_ruleFcbDirective= ruleFcbDirective EOF )
            // InternalAssembler.g:994:2: iv_ruleFcbDirective= ruleFcbDirective EOF
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
    // InternalAssembler.g:1000:1: ruleFcbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1006:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1007:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1007:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1008:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'FCB' ) ) (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )? (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_7= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1008:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1009:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1009:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1010:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1031:3: ( (lv_directive_2_0= 'FCB' ) )
            // InternalAssembler.g:1032:4: (lv_directive_2_0= 'FCB' )
            {
            // InternalAssembler.g:1032:4: (lv_directive_2_0= 'FCB' )
            // InternalAssembler.g:1033:5: lv_directive_2_0= 'FCB'
            {
            lv_directive_2_0=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1045:3: (this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_WS) ) {
                int LA21_1 = input.LA(2);

                if ( ((LA21_1>=RULE_ID && LA21_1<=RULE_CHARACTER)||(LA21_1>=28 && LA21_1<=29)||(LA21_1>=35 && LA21_1<=36)) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalAssembler.g:1046:4: this_WS_3= RULE_WS ( (lv_operand_4_0= ruleListOfExpression ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1050:4: ( (lv_operand_4_0= ruleListOfExpression ) )
                    // InternalAssembler.g:1051:5: (lv_operand_4_0= ruleListOfExpression )
                    {
                    // InternalAssembler.g:1051:5: (lv_operand_4_0= ruleListOfExpression )
                    // InternalAssembler.g:1052:6: lv_operand_4_0= ruleListOfExpression
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

            // InternalAssembler.g:1070:3: (this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_WS) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:1071:4: this_WS_5= RULE_WS ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_5, grammarAccess.getFcbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:1075:4: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1076:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1076:5: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1077:6: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1094:3: (this_WS_7= RULE_WS )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_WS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAssembler.g:1095:4: this_WS_7= RULE_WS
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
    // InternalAssembler.g:1111:1: entryRuleRmbDirective returns [EObject current=null] : iv_ruleRmbDirective= ruleRmbDirective EOF ;
    public final EObject entryRuleRmbDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRmbDirective = null;


        try {
            // InternalAssembler.g:1111:53: (iv_ruleRmbDirective= ruleRmbDirective EOF )
            // InternalAssembler.g:1112:2: iv_ruleRmbDirective= ruleRmbDirective EOF
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
    // InternalAssembler.g:1118:1: ruleRmbDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1124:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1125:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1125:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1126:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'RMB' ) ) (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )? (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_8= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1126:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAssembler.g:1127:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1127:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1128:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1149:3: ( (lv_directive_2_0= 'RMB' ) )
            // InternalAssembler.g:1150:4: (lv_directive_2_0= 'RMB' )
            {
            // InternalAssembler.g:1150:4: (lv_directive_2_0= 'RMB' )
            // InternalAssembler.g:1151:5: lv_directive_2_0= 'RMB'
            {
            lv_directive_2_0=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1163:3: (this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_WS) ) {
                int LA26_1 = input.LA(2);

                if ( ((LA26_1>=RULE_ID && LA26_1<=RULE_CHARACTER)||LA26_1==16||(LA26_1>=28 && LA26_1<=29)||(LA26_1>=35 && LA26_1<=36)) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // InternalAssembler.g:1164:4: this_WS_3= RULE_WS ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1168:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:1169:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:1169:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==16) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalAssembler.g:1170:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:1170:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:1171:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
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

                    // InternalAssembler.g:1183:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:1184:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:1184:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:1185:7: lv_operand_5_0= ruleExpression
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

            // InternalAssembler.g:1204:3: (this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:1205:4: this_WS_6= RULE_WS ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_6, grammarAccess.getRmbDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:1209:4: ( (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1210:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1210:5: (lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1211:6: lv_comment_7_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1228:3: (this_WS_8= RULE_WS )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_WS) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAssembler.g:1229:4: this_WS_8= RULE_WS
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
    // InternalAssembler.g:1245:1: entryRuleEndDirective returns [EObject current=null] : iv_ruleEndDirective= ruleEndDirective EOF ;
    public final EObject entryRuleEndDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndDirective = null;


        try {
            // InternalAssembler.g:1245:53: (iv_ruleEndDirective= ruleEndDirective EOF )
            // InternalAssembler.g:1246:2: iv_ruleEndDirective= ruleEndDirective EOF
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
    // InternalAssembler.g:1252:1: ruleEndDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1258:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine ) )
            // InternalAssembler.g:1259:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            {
            // InternalAssembler.g:1259:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine )
            // InternalAssembler.g:1260:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'END' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )? (this_WS_9= RULE_WS )? ruleEndOfLine
            {
            // InternalAssembler.g:1260:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAssembler.g:1261:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1261:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1262:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1283:3: ( (lv_directive_2_0= 'END' ) )
            // InternalAssembler.g:1284:4: (lv_directive_2_0= 'END' )
            {
            // InternalAssembler.g:1284:4: (lv_directive_2_0= 'END' )
            // InternalAssembler.g:1285:5: lv_directive_2_0= 'END'
            {
            lv_directive_2_0=(Token)match(input,23,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1297:3: (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_WS) ) {
                int LA32_1 = input.LA(2);

                if ( ((LA32_1>=RULE_ID && LA32_1<=RULE_CHARACTER)||LA32_1==16||(LA32_1>=28 && LA32_1<=29)||(LA32_1>=35 && LA32_1<=36)) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalAssembler.g:1298:4: this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1302:4: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==16) ) {
                        int LA31_1 = input.LA(2);

                        if ( ((LA31_1>=RULE_ID && LA31_1<=RULE_CHARACTER)||(LA31_1>=28 && LA31_1<=29)||(LA31_1>=35 && LA31_1<=36)) ) {
                            alt31=1;
                        }
                        else if ( (LA31_1==RULE_WS||(LA31_1>=RULE_CR && LA31_1<=RULE_END_OF_FILE)) ) {
                            alt31=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 31, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_CHARACTER)||(LA31_0>=28 && LA31_0<=29)||(LA31_0>=35 && LA31_0<=36)) ) {
                        alt31=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalAssembler.g:1303:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:1303:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            // InternalAssembler.g:1304:6: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:1304:6: ( (lv_isRelativeToPC_4_0= '*' ) )?
                            int alt30=2;
                            int LA30_0 = input.LA(1);

                            if ( (LA30_0==16) ) {
                                alt30=1;
                            }
                            switch (alt30) {
                                case 1 :
                                    // InternalAssembler.g:1305:7: (lv_isRelativeToPC_4_0= '*' )
                                    {
                                    // InternalAssembler.g:1305:7: (lv_isRelativeToPC_4_0= '*' )
                                    // InternalAssembler.g:1306:8: lv_isRelativeToPC_4_0= '*'
                                    {
                                    lv_isRelativeToPC_4_0=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
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

                            // InternalAssembler.g:1318:6: ( (lv_operand_5_0= ruleExpression ) )
                            // InternalAssembler.g:1319:7: (lv_operand_5_0= ruleExpression )
                            {
                            // InternalAssembler.g:1319:7: (lv_operand_5_0= ruleExpression )
                            // InternalAssembler.g:1320:8: lv_operand_5_0= ruleExpression
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
                            // InternalAssembler.g:1339:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            {
                            // InternalAssembler.g:1339:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            // InternalAssembler.g:1340:6: (lv_isRelativeToPC_6_0= '*' )
                            {
                            // InternalAssembler.g:1340:6: (lv_isRelativeToPC_6_0= '*' )
                            // InternalAssembler.g:1341:7: lv_isRelativeToPC_6_0= '*'
                            {
                            lv_isRelativeToPC_6_0=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
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

            // InternalAssembler.g:1355:3: (this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ) )?
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
                    // InternalAssembler.g:1356:4: this_WS_7= RULE_WS ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEndDirectiveAccess().getWSTerminalRuleCall_4_0());
                      			
                    }
                    // InternalAssembler.g:1360:4: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
                    // InternalAssembler.g:1361:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1361:5: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1362:6: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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

            // InternalAssembler.g:1379:3: (this_WS_9= RULE_WS )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_WS) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAssembler.g:1380:4: this_WS_9= RULE_WS
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
    // InternalAssembler.g:1396:1: entryRuleOrgDirective returns [EObject current=null] : iv_ruleOrgDirective= ruleOrgDirective EOF ;
    public final EObject entryRuleOrgDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrgDirective = null;


        try {
            // InternalAssembler.g:1396:53: (iv_ruleOrgDirective= ruleOrgDirective EOF )
            // InternalAssembler.g:1397:2: iv_ruleOrgDirective= ruleOrgDirective EOF
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
    // InternalAssembler.g:1403:1: ruleOrgDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1409:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:1410:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:1410:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:1411:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'ORG' ) ) (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )? (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:1411:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAssembler.g:1412:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1412:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1413:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1434:3: ( (lv_directive_2_0= 'ORG' ) )
            // InternalAssembler.g:1435:4: (lv_directive_2_0= 'ORG' )
            {
            // InternalAssembler.g:1435:4: (lv_directive_2_0= 'ORG' )
            // InternalAssembler.g:1436:5: lv_directive_2_0= 'ORG'
            {
            lv_directive_2_0=(Token)match(input,24,FOLLOW_8); if (state.failed) return current;
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

            // InternalAssembler.g:1448:3: (this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_WS) ) {
                int LA38_1 = input.LA(2);

                if ( ((LA38_1>=RULE_ID && LA38_1<=RULE_CHARACTER)||LA38_1==16||(LA38_1>=28 && LA38_1<=29)||(LA38_1>=35 && LA38_1<=36)) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalAssembler.g:1449:4: this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_3, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_3_0());
                      			
                    }
                    // InternalAssembler.g:1453:4: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==16) ) {
                        int LA37_1 = input.LA(2);

                        if ( ((LA37_1>=RULE_ID && LA37_1<=RULE_CHARACTER)||(LA37_1>=28 && LA37_1<=29)||(LA37_1>=35 && LA37_1<=36)) ) {
                            alt37=1;
                        }
                        else if ( ((LA37_1>=RULE_WS && LA37_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA37_1>=RULE_CR && LA37_1<=RULE_END_OF_FILE)) ) {
                            alt37=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 37, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA37_0>=RULE_ID && LA37_0<=RULE_CHARACTER)||(LA37_0>=28 && LA37_0<=29)||(LA37_0>=35 && LA37_0<=36)) ) {
                        alt37=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalAssembler.g:1454:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            {
                            // InternalAssembler.g:1454:5: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                            // InternalAssembler.g:1455:6: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                            {
                            // InternalAssembler.g:1455:6: ( (lv_isRelativeToPC_4_0= '*' ) )?
                            int alt36=2;
                            int LA36_0 = input.LA(1);

                            if ( (LA36_0==16) ) {
                                alt36=1;
                            }
                            switch (alt36) {
                                case 1 :
                                    // InternalAssembler.g:1456:7: (lv_isRelativeToPC_4_0= '*' )
                                    {
                                    // InternalAssembler.g:1456:7: (lv_isRelativeToPC_4_0= '*' )
                                    // InternalAssembler.g:1457:8: lv_isRelativeToPC_4_0= '*'
                                    {
                                    lv_isRelativeToPC_4_0=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
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

                            // InternalAssembler.g:1469:6: ( (lv_operand_5_0= ruleExpression ) )
                            // InternalAssembler.g:1470:7: (lv_operand_5_0= ruleExpression )
                            {
                            // InternalAssembler.g:1470:7: (lv_operand_5_0= ruleExpression )
                            // InternalAssembler.g:1471:8: lv_operand_5_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getOrgDirectiveAccess().getOperandExpressionParserRuleCall_3_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_8);
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
                            // InternalAssembler.g:1490:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            {
                            // InternalAssembler.g:1490:5: ( (lv_isRelativeToPC_6_0= '*' ) )
                            // InternalAssembler.g:1491:6: (lv_isRelativeToPC_6_0= '*' )
                            {
                            // InternalAssembler.g:1491:6: (lv_isRelativeToPC_6_0= '*' )
                            // InternalAssembler.g:1492:7: lv_isRelativeToPC_6_0= '*'
                            {
                            lv_isRelativeToPC_6_0=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
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

            // InternalAssembler.g:1506:3: (this_WS_7= RULE_WS )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_WS) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAssembler.g:1507:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getOrgDirectiveAccess().getWSTerminalRuleCall_4());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:1512:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalAssembler.g:1513:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1513:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1514:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:1541:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:1541:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:1542:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:1548:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:1554:2: ( ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:1555:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:1555:2: ( ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:1556:3: ( (lv_name_0_0= ruleIdentifierValue ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) ) (this_WS_7= RULE_WS )? ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:1556:3: ( (lv_name_0_0= ruleIdentifierValue ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAssembler.g:1557:4: (lv_name_0_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:1557:4: (lv_name_0_0= ruleIdentifierValue )
                    // InternalAssembler.g:1558:5: lv_name_0_0= ruleIdentifierValue
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

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_1, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1());
              		
            }
            // InternalAssembler.g:1579:3: ( (lv_directive_2_0= 'EQU' ) )
            // InternalAssembler.g:1580:4: (lv_directive_2_0= 'EQU' )
            {
            // InternalAssembler.g:1580:4: (lv_directive_2_0= 'EQU' )
            // InternalAssembler.g:1581:5: lv_directive_2_0= 'EQU'
            {
            lv_directive_2_0=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
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

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_WS_3, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3());
              		
            }
            // InternalAssembler.g:1597:3: ( ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) ) | ( (lv_isRelativeToPC_6_0= '*' ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==16) ) {
                int LA43_1 = input.LA(2);

                if ( ((LA43_1>=RULE_WS && LA43_1<=RULE_ANY_EXCEPT_COMMENT_END_OF_LINE)||(LA43_1>=RULE_CR && LA43_1<=RULE_END_OF_FILE)) ) {
                    alt43=2;
                }
                else if ( ((LA43_1>=RULE_ID && LA43_1<=RULE_CHARACTER)||(LA43_1>=28 && LA43_1<=29)||(LA43_1>=35 && LA43_1<=36)) ) {
                    alt43=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_CHARACTER)||(LA43_0>=28 && LA43_0<=29)||(LA43_0>=35 && LA43_0<=36)) ) {
                alt43=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalAssembler.g:1598:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    {
                    // InternalAssembler.g:1598:4: ( ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) ) )
                    // InternalAssembler.g:1599:5: ( (lv_isRelativeToPC_4_0= '*' ) )? ( (lv_operand_5_0= ruleExpression ) )
                    {
                    // InternalAssembler.g:1599:5: ( (lv_isRelativeToPC_4_0= '*' ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==16) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalAssembler.g:1600:6: (lv_isRelativeToPC_4_0= '*' )
                            {
                            // InternalAssembler.g:1600:6: (lv_isRelativeToPC_4_0= '*' )
                            // InternalAssembler.g:1601:7: lv_isRelativeToPC_4_0= '*'
                            {
                            lv_isRelativeToPC_4_0=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
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

                    // InternalAssembler.g:1613:5: ( (lv_operand_5_0= ruleExpression ) )
                    // InternalAssembler.g:1614:6: (lv_operand_5_0= ruleExpression )
                    {
                    // InternalAssembler.g:1614:6: (lv_operand_5_0= ruleExpression )
                    // InternalAssembler.g:1615:7: lv_operand_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getEquDirectiveAccess().getOperandExpressionParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_8);
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
                    // InternalAssembler.g:1634:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    {
                    // InternalAssembler.g:1634:4: ( (lv_isRelativeToPC_6_0= '*' ) )
                    // InternalAssembler.g:1635:5: (lv_isRelativeToPC_6_0= '*' )
                    {
                    // InternalAssembler.g:1635:5: (lv_isRelativeToPC_6_0= '*' )
                    // InternalAssembler.g:1636:6: lv_isRelativeToPC_6_0= '*'
                    {
                    lv_isRelativeToPC_6_0=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
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

            // InternalAssembler.g:1649:3: (this_WS_7= RULE_WS )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_WS) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAssembler.g:1650:4: this_WS_7= RULE_WS
                    {
                    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_WS_7, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5());
                      			
                    }

                    }
                    break;

            }

            // InternalAssembler.g:1655:3: ( (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAssembler.g:1656:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:1656:4: (lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:1657:5: lv_comment_8_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
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
    // InternalAssembler.g:1684:1: entryRuleListOfExpression returns [EObject current=null] : iv_ruleListOfExpression= ruleListOfExpression EOF ;
    public final EObject entryRuleListOfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfExpression = null;


        try {
            // InternalAssembler.g:1684:57: (iv_ruleListOfExpression= ruleListOfExpression EOF )
            // InternalAssembler.g:1685:2: iv_ruleListOfExpression= ruleListOfExpression EOF
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
    // InternalAssembler.g:1691:1: ruleListOfExpression returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1697:2: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalAssembler.g:1698:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalAssembler.g:1698:2: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalAssembler.g:1699:3: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalAssembler.g:1699:3: ( (lv_expressions_0_0= ruleExpression ) )
            // InternalAssembler.g:1700:4: (lv_expressions_0_0= ruleExpression )
            {
            // InternalAssembler.g:1700:4: (lv_expressions_0_0= ruleExpression )
            // InternalAssembler.g:1701:5: lv_expressions_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_19);
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

            // InternalAssembler.g:1718:3: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==18) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalAssembler.g:1719:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListOfExpressionAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAssembler.g:1723:4: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalAssembler.g:1724:5: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalAssembler.g:1724:5: (lv_expressions_2_0= ruleExpression )
            	    // InternalAssembler.g:1725:6: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getListOfExpressionAccess().getExpressionsExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
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
            	    break loop46;
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
    // InternalAssembler.g:1747:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:1747:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:1748:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalAssembler.g:1754:1: ruleExpression returns [EObject current=null] : ( (lv_operand_0_0= ruleMultiplication ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1760:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) )
            // InternalAssembler.g:1761:2: ( (lv_operand_0_0= ruleMultiplication ) )
            {
            // InternalAssembler.g:1761:2: ( (lv_operand_0_0= ruleMultiplication ) )
            // InternalAssembler.g:1762:3: (lv_operand_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:1762:3: (lv_operand_0_0= ruleMultiplication )
            // InternalAssembler.g:1763:4: lv_operand_0_0= ruleMultiplication
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
    // InternalAssembler.g:1783:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:1783:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:1784:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:1790:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1796:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:1797:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:1797:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:1798:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_20);
            this_Division_0=ruleDivision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Division_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1806:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==16) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalAssembler.g:1807:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:1807:4: ()
            	    // InternalAssembler.g:1808:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:1814:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:1815:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:1815:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:1816:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalAssembler.g:1828:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:1829:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:1829:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:1830:6: lv_right_3_0= ruleDivision
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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
            	    break loop47;
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
    // InternalAssembler.g:1852:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:1852:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:1853:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:1859:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1865:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:1866:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:1866:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:1867:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_21);
            this_Modulo_0=ruleModulo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Modulo_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1875:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==26) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalAssembler.g:1876:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:1876:4: ()
            	    // InternalAssembler.g:1877:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:1883:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:1884:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:1884:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:1885:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,26,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalAssembler.g:1897:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:1898:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:1898:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:1899:6: lv_right_3_0= ruleModulo
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
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
            	    break loop48;
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
    // InternalAssembler.g:1921:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:1921:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:1922:2: iv_ruleModulo= ruleModulo EOF
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
    // InternalAssembler.g:1928:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1934:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:1935:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:1935:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:1936:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_22);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:1944:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==27) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalAssembler.g:1945:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:1945:4: ()
            	    // InternalAssembler.g:1946:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:1952:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:1953:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:1953:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:1954:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,27,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalAssembler.g:1966:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:1967:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:1967:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:1968:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
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
            	    break loop49;
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
    // InternalAssembler.g:1990:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:1990:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:1991:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:1997:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2003:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:2004:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:2004:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:2005:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_23);
            this_Substraction_0=ruleSubstraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Substraction_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2013:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==28) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalAssembler.g:2014:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:2014:4: ()
            	    // InternalAssembler.g:2015:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,28,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2025:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:2026:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:2026:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:2027:6: lv_right_3_0= ruleSubstraction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
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
            	    break loop50;
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
    // InternalAssembler.g:2049:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:2049:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:2050:2: iv_ruleSubstraction= ruleSubstraction EOF
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
    // InternalAssembler.g:2056:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2062:2: ( (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:2063:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:2063:2: (this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:2064:3: this_LeftShift_0= ruleLeftShift ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_24);
            this_LeftShift_0=ruleLeftShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LeftShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2072:3: ( () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==29) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalAssembler.g:2073:4: () ( ( '-' )=>otherlv_2= '-' ) ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:2073:4: ()
            	    // InternalAssembler.g:2074:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:2080:4: ( ( '-' )=>otherlv_2= '-' )
            	    // InternalAssembler.g:2081:5: ( '-' )=>otherlv_2= '-'
            	    {
            	    otherlv_2=(Token)match(input,29,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	      				
            	    }

            	    }

            	    // InternalAssembler.g:2087:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:2088:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:2088:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:2089:6: lv_right_3_0= ruleLeftShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
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
            	    break loop51;
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
    // InternalAssembler.g:2111:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:2111:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:2112:2: iv_ruleLeftShift= ruleLeftShift EOF
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
    // InternalAssembler.g:2118:1: ruleLeftShift returns [EObject current=null] : (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RightShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2124:2: ( (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* ) )
            // InternalAssembler.g:2125:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            {
            // InternalAssembler.g:2125:2: (this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )* )
            // InternalAssembler.g:2126:3: this_RightShift_0= ruleRightShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLeftShiftAccess().getRightShiftParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_25);
            this_RightShift_0=ruleRightShift();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RightShift_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2134:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==30) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalAssembler.g:2135:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRightShift ) )
            	    {
            	    // InternalAssembler.g:2135:4: ()
            	    // InternalAssembler.g:2136:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,30,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2146:4: ( (lv_right_3_0= ruleRightShift ) )
            	    // InternalAssembler.g:2147:5: (lv_right_3_0= ruleRightShift )
            	    {
            	    // InternalAssembler.g:2147:5: (lv_right_3_0= ruleRightShift )
            	    // InternalAssembler.g:2148:6: lv_right_3_0= ruleRightShift
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLeftShiftAccess().getRightRightShiftParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
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
            	    break loop52;
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
    // InternalAssembler.g:2170:1: entryRuleRightShift returns [EObject current=null] : iv_ruleRightShift= ruleRightShift EOF ;
    public final EObject entryRuleRightShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightShift = null;


        try {
            // InternalAssembler.g:2170:51: (iv_ruleRightShift= ruleRightShift EOF )
            // InternalAssembler.g:2171:2: iv_ruleRightShift= ruleRightShift EOF
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
    // InternalAssembler.g:2177:1: ruleRightShift returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleRightShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2183:2: ( (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:2184:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:2184:2: (this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:2185:3: this_And_0= ruleAnd ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRightShiftAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_26);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2193:3: ( () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==31) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalAssembler.g:2194:4: () otherlv_2= '>>' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:2194:4: ()
            	    // InternalAssembler.g:2195:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,31,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRightShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2205:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:2206:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:2206:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:2207:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRightShiftAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
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
            	    break loop53;
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
    // InternalAssembler.g:2229:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:2229:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:2230:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalAssembler.g:2236:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2242:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:2243:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:2243:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:2244:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getOrParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_27);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Or_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2252:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==32) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalAssembler.g:2253:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:2253:4: ()
            	    // InternalAssembler.g:2254:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,32,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2264:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:2265:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:2265:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:2266:6: lv_right_3_0= ruleOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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
            	    break loop54;
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
    // InternalAssembler.g:2288:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:2288:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:2289:2: iv_ruleOr= ruleOr EOF
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
    // InternalAssembler.g:2295:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2301:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:2302:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:2302:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:2303:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getXorParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_Xor_0=ruleXor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Xor_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2311:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==33) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalAssembler.g:2312:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:2312:4: ()
            	    // InternalAssembler.g:2313:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,33,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2323:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:2324:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:2324:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:2325:6: lv_right_3_0= ruleXor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
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
            	    break loop55;
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
    // InternalAssembler.g:2347:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:2347:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:2348:2: iv_ruleXor= ruleXor EOF
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
    // InternalAssembler.g:2354:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:2360:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:2361:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:2361:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:2362:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAssembler.g:2370:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==34) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalAssembler.g:2371:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:2371:4: ()
            	    // InternalAssembler.g:2372:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,34,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	      			
            	    }
            	    // InternalAssembler.g:2382:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:2383:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:2383:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:2384:6: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
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
            	    break loop56;
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
    // InternalAssembler.g:2406:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:2406:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:2407:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:2413:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) ;
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
            // InternalAssembler.g:2419:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) ) )
            // InternalAssembler.g:2420:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            {
            // InternalAssembler.g:2420:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifierValue ) ) | ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) ) | (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' ) )
            int alt57=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 28:
            case 29:
                {
                alt57=1;
                }
                break;
            case RULE_HEXA:
                {
                alt57=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt57=3;
                }
                break;
            case RULE_BINARY:
                {
                alt57=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt57=5;
                }
                break;
            case RULE_ID:
                {
                alt57=6;
                }
                break;
            case 35:
                {
                alt57=7;
                }
                break;
            case 36:
                {
                alt57=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalAssembler.g:2421:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:2421:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:2422:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:2422:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:2423:5: lv_value_0_0= ruleDecimalValue
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
                    // InternalAssembler.g:2441:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:2441:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:2442:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:2442:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:2443:5: lv_value_1_0= ruleHexaDecimalValue
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
                    // InternalAssembler.g:2461:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:2461:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:2462:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:2462:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:2463:5: lv_value_2_0= ruleOctalValue
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
                    // InternalAssembler.g:2481:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:2481:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:2482:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:2482:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:2483:5: lv_value_3_0= ruleBinaryValue
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
                    // InternalAssembler.g:2501:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:2501:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:2502:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:2502:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:2503:5: lv_value_4_0= ruleCharacterValue
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
                    // InternalAssembler.g:2521:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    {
                    // InternalAssembler.g:2521:3: ( (lv_value_5_0= ruleIdentifierValue ) )
                    // InternalAssembler.g:2522:4: (lv_value_5_0= ruleIdentifierValue )
                    {
                    // InternalAssembler.g:2522:4: (lv_value_5_0= ruleIdentifierValue )
                    // InternalAssembler.g:2523:5: lv_value_5_0= ruleIdentifierValue
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
                    // InternalAssembler.g:2541:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    {
                    // InternalAssembler.g:2541:3: ( () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) ) )
                    // InternalAssembler.g:2542:4: () otherlv_7= '!' ( (lv_value_8_0= rulePrimary ) )
                    {
                    // InternalAssembler.g:2542:4: ()
                    // InternalAssembler.g:2543:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,35,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_6_1());
                      			
                    }
                    // InternalAssembler.g:2553:4: ( (lv_value_8_0= rulePrimary ) )
                    // InternalAssembler.g:2554:5: (lv_value_8_0= rulePrimary )
                    {
                    // InternalAssembler.g:2554:5: (lv_value_8_0= rulePrimary )
                    // InternalAssembler.g:2555:6: lv_value_8_0= rulePrimary
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
                    // InternalAssembler.g:2574:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    {
                    // InternalAssembler.g:2574:3: (otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')' )
                    // InternalAssembler.g:2575:4: otherlv_9= '(' this_Multiplication_10= ruleMultiplication otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_30);
                    this_Multiplication_10=ruleMultiplication();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Multiplication_10;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_11=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalAssembler.g:2596:1: entryRuleIdentifierValue returns [EObject current=null] : iv_ruleIdentifierValue= ruleIdentifierValue EOF ;
    public final EObject entryRuleIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierValue = null;


        try {
            // InternalAssembler.g:2596:56: (iv_ruleIdentifierValue= ruleIdentifierValue EOF )
            // InternalAssembler.g:2597:2: iv_ruleIdentifierValue= ruleIdentifierValue EOF
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
    // InternalAssembler.g:2603:1: ruleIdentifierValue returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2609:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:2610:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:2610:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:2611:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:2611:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:2612:4: lv_value_0_0= RULE_ID
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
    // InternalAssembler.g:2631:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:2631:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:2632:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalAssembler.g:2638:1: ruleDecimalValue returns [EObject current=null] : ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_sign_0_1=null;
        Token lv_sign_0_2=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2644:2: ( ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalAssembler.g:2645:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalAssembler.g:2645:2: ( ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // InternalAssembler.g:2646:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalAssembler.g:2646:3: ( ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=28 && LA59_0<=29)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAssembler.g:2647:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    {
                    // InternalAssembler.g:2647:4: ( (lv_sign_0_1= '-' | lv_sign_0_2= '+' ) )
                    // InternalAssembler.g:2648:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    {
                    // InternalAssembler.g:2648:5: (lv_sign_0_1= '-' | lv_sign_0_2= '+' )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==29) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==28) ) {
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
                            // InternalAssembler.g:2649:6: lv_sign_0_1= '-'
                            {
                            lv_sign_0_1=(Token)match(input,29,FOLLOW_31); if (state.failed) return current;
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
                            // InternalAssembler.g:2660:6: lv_sign_0_2= '+'
                            {
                            lv_sign_0_2=(Token)match(input,28,FOLLOW_31); if (state.failed) return current;
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

            // InternalAssembler.g:2673:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalAssembler.g:2674:4: (lv_value_1_0= RULE_INT )
            {
            // InternalAssembler.g:2674:4: (lv_value_1_0= RULE_INT )
            // InternalAssembler.g:2675:5: lv_value_1_0= RULE_INT
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
    // InternalAssembler.g:2695:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:2695:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:2696:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
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
    // InternalAssembler.g:2702:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2708:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:2709:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:2709:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:2710:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:2710:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:2711:4: lv_value_0_0= RULE_HEXA
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
    // InternalAssembler.g:2730:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:2730:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:2731:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:2737:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2743:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:2744:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:2744:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:2745:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:2745:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:2746:4: lv_value_0_0= RULE_OCTAL
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
    // InternalAssembler.g:2765:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:2765:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:2766:2: iv_ruleBinaryValue= ruleBinaryValue EOF
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
    // InternalAssembler.g:2772:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2778:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:2779:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:2779:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:2780:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:2780:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:2781:4: lv_value_0_0= RULE_BINARY
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
    // InternalAssembler.g:2800:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:2800:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:2801:2: iv_ruleCharacterValue= ruleCharacterValue EOF
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
    // InternalAssembler.g:2807:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:2813:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:2814:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:2814:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:2815:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:2815:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:2816:4: lv_value_0_0= RULE_CHARACTER
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
    // InternalAssembler.g:2835:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:2835:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:2836:2: iv_ruleEndOfLine= ruleEndOfLine EOF
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
    // InternalAssembler.g:2842:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:2848:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:2849:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:2849:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_CR) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_END_OF_FILE) ) {
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
                    // InternalAssembler.g:2850:3: this_CR_0= RULE_CR
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
                    // InternalAssembler.g:2858:3: this_END_OF_FILE_1= RULE_END_OF_FILE
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


    protected DFA4 dfa4 = new DFA4(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\2\4\1\17\11\uffff";
    static final String dfa_3s = "\1\6\1\4\1\31\11\uffff";
    static final String dfa_4s = "\3\uffff\1\10\1\1\1\3\1\4\1\7\1\6\1\11\1\2\1\5";
    static final String dfa_5s = "\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\1\uffff\1\1",
            "\1\2",
            "\1\10\1\uffff\1\13\1\uffff\1\5\1\11\1\3\1\7\1\6\1\12\1\4",
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
            return "287:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) | ( (lv_directive_1_0= ruleOrgDirective ) ) | ( (lv_directive_2_0= ruleBszDirective ) ) | ( (lv_directive_3_0= ruleEndDirective ) ) | ( (lv_directive_4_0= ruleFillDirective ) ) | ( (lv_directive_5_0= ruleSetDirective ) ) | ( (lv_directive_6_0= ruleRmbDirective ) ) | ( (lv_directive_7_0= ruleFcbDirective ) ) | ( (lv_directive_8_0= ruleFdbDirective ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000001830010FC0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000003030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000080L});

}
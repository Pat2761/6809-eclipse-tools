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

@SuppressWarnings("all")
public class InternalAssemblerParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "RULE_CR", "RULE_END_OF_FILE", "'EQU'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'~'", "'&&'", "'||'", "'^'", "'('", "')'"
    };
    public static final int RULE_ANY_EXCEPT_COMMENT_END_OF_LINE=5;
    public static final int RULE_CHARACTER=12;
    public static final int RULE_CR=13;
    public static final int RULE_STRING=7;
    public static final int T__19=19;
    public static final int RULE_OCTAL=10;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_END_OF_FILE=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_WS=4;
    public static final int RULE_HEXA=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int RULE_BINARY=11;
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
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

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

            	    				newCompositeNode(grammarAccess.getModelAccess().getSourceLinesSourceLineParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_sourceLines_0_0=ruleSourceLine();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

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
             newCompositeNode(grammarAccess.getSourceLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSourceLine=ruleSourceLine();

            state._fsp--;

             current =iv_ruleSourceLine; 
            match(input,EOF,FOLLOW_2); 

            }

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

                if ( ((LA2_1>=RULE_CR && LA2_1<=RULE_END_OF_FILE)) ) {
                    alt2=1;
                }
                else if ( (LA2_1==15) ) {
                    alt2=3;
                }
                else {
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

                    					newCompositeNode(grammarAccess.getSourceLineAccess().getLineContentBlankLineParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_lineContent_0_0=ruleBlankLine();

                    state._fsp--;


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

                    					newCompositeNode(grammarAccess.getSourceLineAccess().getLineContentCommentLineParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_lineContent_1_0=ruleCommentLine();

                    state._fsp--;


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

                    					newCompositeNode(grammarAccess.getSourceLineAccess().getLineContentDirectiveLineParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_lineContent_2_0=ruleDirectiveLine();

                    state._fsp--;


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
                    break;

            }


            }


            	leaveRule();

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
             newCompositeNode(grammarAccess.getBlankLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlankLine=ruleBlankLine();

            state._fsp--;

             current =iv_ruleBlankLine; 
            match(input,EOF,FOLLOW_2); 

            }

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

            				current = forceCreateModelElement(
            					grammarAccess.getBlankLineAccess().getBlankLineAction_0(),
            					current);
            			

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
                    lv_blankLine_1_0=(Token)match(input,RULE_WS,FOLLOW_4); 

                    					newLeafNode(lv_blankLine_1_0, grammarAccess.getBlankLineAccess().getBlankLineWSTerminalRuleCall_1_0());
                    				

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
                    break;

            }


            			newCompositeNode(grammarAccess.getBlankLineAccess().getEndOfLineParserRuleCall_2());
            		
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

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
             newCompositeNode(grammarAccess.getCommentLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCommentLine=ruleCommentLine();

            state._fsp--;

             current =iv_ruleCommentLine; 
            match(input,EOF,FOLLOW_2); 

            }

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
            lv_comment_0_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); 

            					newLeafNode(lv_comment_0_0, grammarAccess.getCommentLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_0_0());
            				

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


            			newCompositeNode(grammarAccess.getCommentLineAccess().getEndOfLineParserRuleCall_1());
            		
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

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
             newCompositeNode(grammarAccess.getDirectiveLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDirectiveLine=ruleDirectiveLine();

            state._fsp--;

             current =iv_ruleDirectiveLine; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:280:1: ruleDirectiveLine returns [EObject current=null] : ( (lv_directive_0_0= ruleEquDirective ) ) ;
    public final EObject ruleDirectiveLine() throws RecognitionException {
        EObject current = null;

        EObject lv_directive_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:286:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) )
            // InternalAssembler.g:287:2: ( (lv_directive_0_0= ruleEquDirective ) )
            {
            // InternalAssembler.g:287:2: ( (lv_directive_0_0= ruleEquDirective ) )
            // InternalAssembler.g:288:3: (lv_directive_0_0= ruleEquDirective )
            {
            // InternalAssembler.g:288:3: (lv_directive_0_0= ruleEquDirective )
            // InternalAssembler.g:289:4: lv_directive_0_0= ruleEquDirective
            {

            				newCompositeNode(grammarAccess.getDirectiveLineAccess().getDirectiveEquDirectiveParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_directive_0_0=ruleEquDirective();

            state._fsp--;


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


            	leaveRule();

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


    // $ANTLR start "entryRuleEquDirective"
    // InternalAssembler.g:309:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:309:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:310:2: iv_ruleEquDirective= ruleEquDirective EOF
            {
             newCompositeNode(grammarAccess.getEquDirectiveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEquDirective=ruleEquDirective();

            state._fsp--;

             current =iv_ruleEquDirective; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:316:1: ruleEquDirective returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleOperand ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) ;
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
            // InternalAssembler.g:322:2: ( ( ( (lv_name_0_0= ruleIdentifier ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleOperand ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine ) )
            // InternalAssembler.g:323:2: ( ( (lv_name_0_0= ruleIdentifier ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleOperand ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            {
            // InternalAssembler.g:323:2: ( ( (lv_name_0_0= ruleIdentifier ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleOperand ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine )
            // InternalAssembler.g:324:3: ( (lv_name_0_0= ruleIdentifier ) )? this_WS_1= RULE_WS ( (lv_directive_2_0= 'EQU' ) ) this_WS_3= RULE_WS ( (lv_operand_4_0= ruleOperand ) )? (this_WS_5= RULE_WS )? ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )? ruleEndOfLine
            {
            // InternalAssembler.g:324:3: ( (lv_name_0_0= ruleIdentifier ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:325:4: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalAssembler.g:325:4: (lv_name_0_0= ruleIdentifier )
                    // InternalAssembler.g:326:5: lv_name_0_0= ruleIdentifier
                    {

                    					newCompositeNode(grammarAccess.getEquDirectiveAccess().getNameIdentifierParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEquDirectiveRule());
                    					}
                    					set(
                    						current,
                    						"name",
                    						lv_name_0_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.Identifier");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_6); 

            			newLeafNode(this_WS_1, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1());
            		
            // InternalAssembler.g:347:3: ( (lv_directive_2_0= 'EQU' ) )
            // InternalAssembler.g:348:4: (lv_directive_2_0= 'EQU' )
            {
            // InternalAssembler.g:348:4: (lv_directive_2_0= 'EQU' )
            // InternalAssembler.g:349:5: lv_directive_2_0= 'EQU'
            {
            lv_directive_2_0=(Token)match(input,15,FOLLOW_5); 

            					newLeafNode(lv_directive_2_0, grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEquDirectiveRule());
            					}
            					setWithLastConsumed(current, "directive", lv_directive_2_0, "EQU");
            				

            }


            }

            this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); 

            			newLeafNode(this_WS_3, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3());
            		
            // InternalAssembler.g:365:3: ( (lv_operand_4_0= ruleOperand ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_CHARACTER)||LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:366:4: (lv_operand_4_0= ruleOperand )
                    {
                    // InternalAssembler.g:366:4: (lv_operand_4_0= ruleOperand )
                    // InternalAssembler.g:367:5: lv_operand_4_0= ruleOperand
                    {

                    					newCompositeNode(grammarAccess.getEquDirectiveAccess().getOperandOperandParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_8);
                    lv_operand_4_0=ruleOperand();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEquDirectiveRule());
                    					}
                    					set(
                    						current,
                    						"operand",
                    						lv_operand_4_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.Operand");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAssembler.g:384:3: (this_WS_5= RULE_WS )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_WS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:385:4: this_WS_5= RULE_WS
                    {
                    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_8); 

                    				newLeafNode(this_WS_5, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5());
                    			

                    }
                    break;

            }

            // InternalAssembler.g:390:3: ( (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:391:4: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    {
                    // InternalAssembler.g:391:4: (lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
                    // InternalAssembler.g:392:5: lv_comment_6_0= RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                    {
                    lv_comment_6_0=(Token)match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_4); 

                    					newLeafNode(lv_comment_6_0, grammarAccess.getEquDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_6_0());
                    				

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
                    break;

            }


            			newCompositeNode(grammarAccess.getEquDirectiveAccess().getEndOfLineParserRuleCall_7());
            		
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleOperand"
    // InternalAssembler.g:419:1: entryRuleOperand returns [EObject current=null] : iv_ruleOperand= ruleOperand EOF ;
    public final EObject entryRuleOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperand = null;


        try {
            // InternalAssembler.g:419:48: (iv_ruleOperand= ruleOperand EOF )
            // InternalAssembler.g:420:2: iv_ruleOperand= ruleOperand EOF
            {
             newCompositeNode(grammarAccess.getOperandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperand=ruleOperand();

            state._fsp--;

             current =iv_ruleOperand; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperand"


    // $ANTLR start "ruleOperand"
    // InternalAssembler.g:426:1: ruleOperand returns [EObject current=null] : ( ( (lv_operand_0_0= ruleMultiplication ) ) | ( (lv_operand_1_0= ruleStringValue ) ) ) ;
    public final EObject ruleOperand() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_0_0 = null;

        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:432:2: ( ( ( (lv_operand_0_0= ruleMultiplication ) ) | ( (lv_operand_1_0= ruleStringValue ) ) ) )
            // InternalAssembler.g:433:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) | ( (lv_operand_1_0= ruleStringValue ) ) )
            {
            // InternalAssembler.g:433:2: ( ( (lv_operand_0_0= ruleMultiplication ) ) | ( (lv_operand_1_0= ruleStringValue ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||(LA8_0>=RULE_INT && LA8_0<=RULE_CHARACTER)||LA8_0==27) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_STRING) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:434:3: ( (lv_operand_0_0= ruleMultiplication ) )
                    {
                    // InternalAssembler.g:434:3: ( (lv_operand_0_0= ruleMultiplication ) )
                    // InternalAssembler.g:435:4: (lv_operand_0_0= ruleMultiplication )
                    {
                    // InternalAssembler.g:435:4: (lv_operand_0_0= ruleMultiplication )
                    // InternalAssembler.g:436:5: lv_operand_0_0= ruleMultiplication
                    {

                    					newCompositeNode(grammarAccess.getOperandAccess().getOperandMultiplicationParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_operand_0_0=ruleMultiplication();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperandRule());
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
                    break;
                case 2 :
                    // InternalAssembler.g:454:3: ( (lv_operand_1_0= ruleStringValue ) )
                    {
                    // InternalAssembler.g:454:3: ( (lv_operand_1_0= ruleStringValue ) )
                    // InternalAssembler.g:455:4: (lv_operand_1_0= ruleStringValue )
                    {
                    // InternalAssembler.g:455:4: (lv_operand_1_0= ruleStringValue )
                    // InternalAssembler.g:456:5: lv_operand_1_0= ruleStringValue
                    {

                    					newCompositeNode(grammarAccess.getOperandAccess().getOperandStringValueParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_operand_1_0=ruleStringValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperandRule());
                    					}
                    					set(
                    						current,
                    						"operand",
                    						lv_operand_1_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.StringValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperand"


    // $ANTLR start "entryRuleMultiplication"
    // InternalAssembler.g:477:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:477:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:478:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:484:1: ruleMultiplication returns [EObject current=null] : (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_operation_2_0=null;
        EObject this_Division_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:490:2: ( (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:491:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:491:2: (this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )* )
            // InternalAssembler.g:492:3: this_Division_0= ruleDivision ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0());
            		
            pushFollow(FOLLOW_9);
            this_Division_0=ruleDivision();

            state._fsp--;


            			current = this_Division_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:500:3: ( () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAssembler.g:501:4: () ( (lv_operation_2_0= '*' ) ) ( (lv_right_3_0= ruleDivision ) )
            	    {
            	    // InternalAssembler.g:501:4: ()
            	    // InternalAssembler.g:502:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalAssembler.g:508:4: ( (lv_operation_2_0= '*' ) )
            	    // InternalAssembler.g:509:5: (lv_operation_2_0= '*' )
            	    {
            	    // InternalAssembler.g:509:5: (lv_operation_2_0= '*' )
            	    // InternalAssembler.g:510:6: lv_operation_2_0= '*'
            	    {
            	    lv_operation_2_0=(Token)match(input,16,FOLLOW_10); 

            	    						newLeafNode(lv_operation_2_0, grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMultiplicationRule());
            	    						}
            	    						setWithLastConsumed(current, "operation", lv_operation_2_0, "*");
            	    					

            	    }


            	    }

            	    // InternalAssembler.g:522:4: ( (lv_right_3_0= ruleDivision ) )
            	    // InternalAssembler.g:523:5: (lv_right_3_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:523:5: (lv_right_3_0= ruleDivision )
            	    // InternalAssembler.g:524:6: lv_right_3_0= ruleDivision
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_right_3_0=ruleDivision();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:546:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:546:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:547:2: iv_ruleDivision= ruleDivision EOF
            {
             newCompositeNode(grammarAccess.getDivisionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDivision=ruleDivision();

            state._fsp--;

             current =iv_ruleDivision; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:553:1: ruleDivision returns [EObject current=null] : (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Modulo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:559:2: ( (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* ) )
            // InternalAssembler.g:560:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            {
            // InternalAssembler.g:560:2: (this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )* )
            // InternalAssembler.g:561:3: this_Modulo_0= ruleModulo ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            {

            			newCompositeNode(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0());
            		
            pushFollow(FOLLOW_11);
            this_Modulo_0=ruleModulo();

            state._fsp--;


            			current = this_Modulo_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:569:3: ( () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalAssembler.g:570:4: () ( (lv_opretation_2_0= '/' ) ) ( (lv_right_3_0= ruleModulo ) )
            	    {
            	    // InternalAssembler.g:570:4: ()
            	    // InternalAssembler.g:571:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalAssembler.g:577:4: ( (lv_opretation_2_0= '/' ) )
            	    // InternalAssembler.g:578:5: (lv_opretation_2_0= '/' )
            	    {
            	    // InternalAssembler.g:578:5: (lv_opretation_2_0= '/' )
            	    // InternalAssembler.g:579:6: lv_opretation_2_0= '/'
            	    {
            	    lv_opretation_2_0=(Token)match(input,17,FOLLOW_10); 

            	    						newLeafNode(lv_opretation_2_0, grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDivisionRule());
            	    						}
            	    						setWithLastConsumed(current, "opretation", lv_opretation_2_0, "/");
            	    					

            	    }


            	    }

            	    // InternalAssembler.g:591:4: ( (lv_right_3_0= ruleModulo ) )
            	    // InternalAssembler.g:592:5: (lv_right_3_0= ruleModulo )
            	    {
            	    // InternalAssembler.g:592:5: (lv_right_3_0= ruleModulo )
            	    // InternalAssembler.g:593:6: lv_right_3_0= ruleModulo
            	    {

            	    						newCompositeNode(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_right_3_0=ruleModulo();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:615:1: entryRuleModulo returns [EObject current=null] : iv_ruleModulo= ruleModulo EOF ;
    public final EObject entryRuleModulo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModulo = null;


        try {
            // InternalAssembler.g:615:47: (iv_ruleModulo= ruleModulo EOF )
            // InternalAssembler.g:616:2: iv_ruleModulo= ruleModulo EOF
            {
             newCompositeNode(grammarAccess.getModuloRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModulo=ruleModulo();

            state._fsp--;

             current =iv_ruleModulo; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:622:1: ruleModulo returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleModulo() throws RecognitionException {
        EObject current = null;

        Token lv_opretation_2_0=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:628:2: ( (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalAssembler.g:629:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalAssembler.g:629:2: (this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalAssembler.g:630:3: this_Addition_0= ruleAddition ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {

            			newCompositeNode(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0());
            		
            pushFollow(FOLLOW_12);
            this_Addition_0=ruleAddition();

            state._fsp--;


            			current = this_Addition_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:638:3: ( () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAssembler.g:639:4: () ( (lv_opretation_2_0= '%' ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalAssembler.g:639:4: ()
            	    // InternalAssembler.g:640:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getModuloAccess().getModuloLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalAssembler.g:646:4: ( (lv_opretation_2_0= '%' ) )
            	    // InternalAssembler.g:647:5: (lv_opretation_2_0= '%' )
            	    {
            	    // InternalAssembler.g:647:5: (lv_opretation_2_0= '%' )
            	    // InternalAssembler.g:648:6: lv_opretation_2_0= '%'
            	    {
            	    lv_opretation_2_0=(Token)match(input,18,FOLLOW_10); 

            	    						newLeafNode(lv_opretation_2_0, grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getModuloRule());
            	    						}
            	    						setWithLastConsumed(current, "opretation", lv_opretation_2_0, "%");
            	    					

            	    }


            	    }

            	    // InternalAssembler.g:660:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalAssembler.g:661:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalAssembler.g:661:5: (lv_right_3_0= ruleAddition )
            	    // InternalAssembler.g:662:6: lv_right_3_0= ruleAddition
            	    {

            	    						newCompositeNode(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_right_3_0=ruleAddition();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:684:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:684:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:685:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:691:1: ruleAddition returns [EObject current=null] : (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Substraction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:697:2: ( (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* ) )
            // InternalAssembler.g:698:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            {
            // InternalAssembler.g:698:2: (this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )* )
            // InternalAssembler.g:699:3: this_Substraction_0= ruleSubstraction ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_Substraction_0=ruleSubstraction();

            state._fsp--;


            			current = this_Substraction_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:707:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==19) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAssembler.g:708:4: () otherlv_2= '+' ( (lv_right_3_0= ruleSubstraction ) )
            	    {
            	    // InternalAssembler.g:708:4: ()
            	    // InternalAssembler.g:709:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	    			
            	    // InternalAssembler.g:719:4: ( (lv_right_3_0= ruleSubstraction ) )
            	    // InternalAssembler.g:720:5: (lv_right_3_0= ruleSubstraction )
            	    {
            	    // InternalAssembler.g:720:5: (lv_right_3_0= ruleSubstraction )
            	    // InternalAssembler.g:721:6: lv_right_3_0= ruleSubstraction
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=ruleSubstraction();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:743:1: entryRuleSubstraction returns [EObject current=null] : iv_ruleSubstraction= ruleSubstraction EOF ;
    public final EObject entryRuleSubstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstraction = null;


        try {
            // InternalAssembler.g:743:53: (iv_ruleSubstraction= ruleSubstraction EOF )
            // InternalAssembler.g:744:2: iv_ruleSubstraction= ruleSubstraction EOF
            {
             newCompositeNode(grammarAccess.getSubstractionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubstraction=ruleSubstraction();

            state._fsp--;

             current =iv_ruleSubstraction; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:750:1: ruleSubstraction returns [EObject current=null] : (this_LeftShift_0= ruleLeftShift ( () otherlv_2= '-' ( (lv_right_3_0= ruleLeftShift ) ) )* ) ;
    public final EObject ruleSubstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LeftShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:756:2: ( (this_LeftShift_0= ruleLeftShift ( () otherlv_2= '-' ( (lv_right_3_0= ruleLeftShift ) ) )* ) )
            // InternalAssembler.g:757:2: (this_LeftShift_0= ruleLeftShift ( () otherlv_2= '-' ( (lv_right_3_0= ruleLeftShift ) ) )* )
            {
            // InternalAssembler.g:757:2: (this_LeftShift_0= ruleLeftShift ( () otherlv_2= '-' ( (lv_right_3_0= ruleLeftShift ) ) )* )
            // InternalAssembler.g:758:3: this_LeftShift_0= ruleLeftShift ( () otherlv_2= '-' ( (lv_right_3_0= ruleLeftShift ) ) )*
            {

            			newCompositeNode(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0());
            		
            pushFollow(FOLLOW_14);
            this_LeftShift_0=ruleLeftShift();

            state._fsp--;


            			current = this_LeftShift_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:766:3: ( () otherlv_2= '-' ( (lv_right_3_0= ruleLeftShift ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAssembler.g:767:4: () otherlv_2= '-' ( (lv_right_3_0= ruleLeftShift ) )
            	    {
            	    // InternalAssembler.g:767:4: ()
            	    // InternalAssembler.g:768:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,20,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1());
            	    			
            	    // InternalAssembler.g:778:4: ( (lv_right_3_0= ruleLeftShift ) )
            	    // InternalAssembler.g:779:5: (lv_right_3_0= ruleLeftShift )
            	    {
            	    // InternalAssembler.g:779:5: (lv_right_3_0= ruleLeftShift )
            	    // InternalAssembler.g:780:6: lv_right_3_0= ruleLeftShift
            	    {

            	    						newCompositeNode(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    lv_right_3_0=ruleLeftShift();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:802:1: entryRuleLeftShift returns [EObject current=null] : iv_ruleLeftShift= ruleLeftShift EOF ;
    public final EObject entryRuleLeftShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftShift = null;


        try {
            // InternalAssembler.g:802:50: (iv_ruleLeftShift= ruleLeftShift EOF )
            // InternalAssembler.g:803:2: iv_ruleLeftShift= ruleLeftShift EOF
            {
             newCompositeNode(grammarAccess.getLeftShiftRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLeftShift=ruleLeftShift();

            state._fsp--;

             current =iv_ruleLeftShift; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:809:1: ruleLeftShift returns [EObject current=null] : (this_RigthShift_0= ruleRigthShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRigthShift ) ) )* ) ;
    public final EObject ruleLeftShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RigthShift_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:815:2: ( (this_RigthShift_0= ruleRigthShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRigthShift ) ) )* ) )
            // InternalAssembler.g:816:2: (this_RigthShift_0= ruleRigthShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRigthShift ) ) )* )
            {
            // InternalAssembler.g:816:2: (this_RigthShift_0= ruleRigthShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRigthShift ) ) )* )
            // InternalAssembler.g:817:3: this_RigthShift_0= ruleRigthShift ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRigthShift ) ) )*
            {

            			newCompositeNode(grammarAccess.getLeftShiftAccess().getRigthShiftParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_RigthShift_0=ruleRigthShift();

            state._fsp--;


            			current = this_RigthShift_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:825:3: ( () otherlv_2= '<<' ( (lv_right_3_0= ruleRigthShift ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==21) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalAssembler.g:826:4: () otherlv_2= '<<' ( (lv_right_3_0= ruleRigthShift ) )
            	    {
            	    // InternalAssembler.g:826:4: ()
            	    // InternalAssembler.g:827:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,21,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1());
            	    			
            	    // InternalAssembler.g:837:4: ( (lv_right_3_0= ruleRigthShift ) )
            	    // InternalAssembler.g:838:5: (lv_right_3_0= ruleRigthShift )
            	    {
            	    // InternalAssembler.g:838:5: (lv_right_3_0= ruleRigthShift )
            	    // InternalAssembler.g:839:6: lv_right_3_0= ruleRigthShift
            	    {

            	    						newCompositeNode(grammarAccess.getLeftShiftAccess().getRightRigthShiftParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_right_3_0=ruleRigthShift();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLeftShiftRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.bpy.electronics.mc6809.assembler.Assembler.RigthShift");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleRigthShift"
    // InternalAssembler.g:861:1: entryRuleRigthShift returns [EObject current=null] : iv_ruleRigthShift= ruleRigthShift EOF ;
    public final EObject entryRuleRigthShift() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRigthShift = null;


        try {
            // InternalAssembler.g:861:51: (iv_ruleRigthShift= ruleRigthShift EOF )
            // InternalAssembler.g:862:2: iv_ruleRigthShift= ruleRigthShift EOF
            {
             newCompositeNode(grammarAccess.getRigthShiftRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRigthShift=ruleRigthShift();

            state._fsp--;

             current =iv_ruleRigthShift; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRigthShift"


    // $ANTLR start "ruleRigthShift"
    // InternalAssembler.g:868:1: ruleRigthShift returns [EObject current=null] : (this_Negate_0= ruleNegate ( () otherlv_2= '>>' ( (lv_Negate_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleRigthShift() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Negate_0 = null;

        EObject lv_Negate_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:874:2: ( (this_Negate_0= ruleNegate ( () otherlv_2= '>>' ( (lv_Negate_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:875:2: (this_Negate_0= ruleNegate ( () otherlv_2= '>>' ( (lv_Negate_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:875:2: (this_Negate_0= ruleNegate ( () otherlv_2= '>>' ( (lv_Negate_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:876:3: this_Negate_0= ruleNegate ( () otherlv_2= '>>' ( (lv_Negate_3_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getRigthShiftAccess().getNegateParserRuleCall_0());
            		
            pushFollow(FOLLOW_16);
            this_Negate_0=ruleNegate();

            state._fsp--;


            			current = this_Negate_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:884:3: ( () otherlv_2= '>>' ( (lv_Negate_3_0= rulePrimary ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==22) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalAssembler.g:885:4: () otherlv_2= '>>' ( (lv_Negate_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:885:4: ()
            	    // InternalAssembler.g:886:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getRigthShiftAccess().getRigthShiftLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,22,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getRigthShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1());
            	    			
            	    // InternalAssembler.g:896:4: ( (lv_Negate_3_0= rulePrimary ) )
            	    // InternalAssembler.g:897:5: (lv_Negate_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:897:5: (lv_Negate_3_0= rulePrimary )
            	    // InternalAssembler.g:898:6: lv_Negate_3_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getRigthShiftAccess().getNegatePrimaryParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_Negate_3_0=rulePrimary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRigthShiftRule());
            	    						}
            	    						set(
            	    							current,
            	    							"Negate",
            	    							lv_Negate_3_0,
            	    							"org.bpy.electronics.mc6809.assembler.Assembler.Primary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRigthShift"


    // $ANTLR start "entryRuleNegate"
    // InternalAssembler.g:920:1: entryRuleNegate returns [EObject current=null] : iv_ruleNegate= ruleNegate EOF ;
    public final EObject entryRuleNegate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegate = null;


        try {
            // InternalAssembler.g:920:47: (iv_ruleNegate= ruleNegate EOF )
            // InternalAssembler.g:921:2: iv_ruleNegate= ruleNegate EOF
            {
             newCompositeNode(grammarAccess.getNegateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNegate=ruleNegate();

            state._fsp--;

             current =iv_ruleNegate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegate"


    // $ANTLR start "ruleNegate"
    // InternalAssembler.g:927:1: ruleNegate returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '~' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleNegate() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:933:2: ( (this_And_0= ruleAnd ( () otherlv_2= '~' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalAssembler.g:934:2: (this_And_0= ruleAnd ( () otherlv_2= '~' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalAssembler.g:934:2: (this_And_0= ruleAnd ( () otherlv_2= '~' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalAssembler.g:935:3: this_And_0= ruleAnd ( () otherlv_2= '~' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getNegateAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_17);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:943:3: ( () otherlv_2= '~' ( (lv_right_3_0= ruleAnd ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalAssembler.g:944:4: () otherlv_2= '~' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalAssembler.g:944:4: ()
            	    // InternalAssembler.g:945:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getNegateAccess().getNegateLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,23,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getNegateAccess().getTildeKeyword_1_1());
            	    			
            	    // InternalAssembler.g:955:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalAssembler.g:956:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalAssembler.g:956:5: (lv_right_3_0= ruleAnd )
            	    // InternalAssembler.g:957:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getNegateAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_17);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNegateRule());
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
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegate"


    // $ANTLR start "entryRuleAnd"
    // InternalAssembler.g:979:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalAssembler.g:979:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalAssembler.g:980:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:986:1: ruleAnd returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:992:2: ( (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalAssembler.g:993:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalAssembler.g:993:2: (this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalAssembler.g:994:3: this_Or_0= ruleOr ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getOrParserRuleCall_0());
            		
            pushFollow(FOLLOW_18);
            this_Or_0=ruleOr();

            state._fsp--;


            			current = this_Or_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:1002:3: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==24) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAssembler.g:1003:4: () otherlv_2= '&&' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalAssembler.g:1003:4: ()
            	    // InternalAssembler.g:1004:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,24,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1());
            	    			
            	    // InternalAssembler.g:1014:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalAssembler.g:1015:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalAssembler.g:1015:5: (lv_right_3_0= ruleOr )
            	    // InternalAssembler.g:1016:6: lv_right_3_0= ruleOr
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_18);
            	    lv_right_3_0=ruleOr();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:1038:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalAssembler.g:1038:43: (iv_ruleOr= ruleOr EOF )
            // InternalAssembler.g:1039:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1045:1: ruleOr returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1051:2: ( (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalAssembler.g:1052:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalAssembler.g:1052:2: (this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalAssembler.g:1053:3: this_Xor_0= ruleXor ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getXorParserRuleCall_0());
            		
            pushFollow(FOLLOW_19);
            this_Xor_0=ruleXor();

            state._fsp--;


            			current = this_Xor_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:1061:3: ( () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==25) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAssembler.g:1062:4: () otherlv_2= '||' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalAssembler.g:1062:4: ()
            	    // InternalAssembler.g:1063:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,25,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1());
            	    			
            	    // InternalAssembler.g:1073:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalAssembler.g:1074:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalAssembler.g:1074:5: (lv_right_3_0= ruleXor )
            	    // InternalAssembler.g:1075:6: lv_right_3_0= ruleXor
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_right_3_0=ruleXor();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:1097:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalAssembler.g:1097:44: (iv_ruleXor= ruleXor EOF )
            // InternalAssembler.g:1098:2: iv_ruleXor= ruleXor EOF
            {
             newCompositeNode(grammarAccess.getXorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXor=ruleXor();

            state._fsp--;

             current =iv_ruleXor; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1104:1: ruleXor returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1110:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:1111:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:1111:2: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalAssembler.g:1112:3: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_20);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalAssembler.g:1120:3: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==26) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalAssembler.g:1121:4: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalAssembler.g:1121:4: ()
            	    // InternalAssembler.g:1122:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,26,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1());
            	    			
            	    // InternalAssembler.g:1132:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalAssembler.g:1133:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:1133:5: (lv_right_3_0= rulePrimary )
            	    // InternalAssembler.g:1134:6: lv_right_3_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:1156:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:1156:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:1157:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1163:1: rulePrimary returns [EObject current=null] : ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifier ) ) | (otherlv_6= '(' this_Multiplication_7= ruleMultiplication otherlv_8= ')' ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_value_0_0 = null;

        EObject lv_value_1_0 = null;

        EObject lv_value_2_0 = null;

        EObject lv_value_3_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_value_5_0 = null;

        EObject this_Multiplication_7 = null;



        	enterRule();

        try {
            // InternalAssembler.g:1169:2: ( ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifier ) ) | (otherlv_6= '(' this_Multiplication_7= ruleMultiplication otherlv_8= ')' ) ) )
            // InternalAssembler.g:1170:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifier ) ) | (otherlv_6= '(' this_Multiplication_7= ruleMultiplication otherlv_8= ')' ) )
            {
            // InternalAssembler.g:1170:2: ( ( (lv_value_0_0= ruleDecimalValue ) ) | ( (lv_value_1_0= ruleHexaDecimalValue ) ) | ( (lv_value_2_0= ruleOctalValue ) ) | ( (lv_value_3_0= ruleBinaryValue ) ) | ( (lv_value_4_0= ruleCharacterValue ) ) | ( (lv_value_5_0= ruleIdentifier ) ) | (otherlv_6= '(' this_Multiplication_7= ruleMultiplication otherlv_8= ')' ) )
            int alt20=7;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt20=1;
                }
                break;
            case RULE_HEXA:
                {
                alt20=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt20=3;
                }
                break;
            case RULE_BINARY:
                {
                alt20=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt20=5;
                }
                break;
            case RULE_ID:
                {
                alt20=6;
                }
                break;
            case 27:
                {
                alt20=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalAssembler.g:1171:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    {
                    // InternalAssembler.g:1171:3: ( (lv_value_0_0= ruleDecimalValue ) )
                    // InternalAssembler.g:1172:4: (lv_value_0_0= ruleDecimalValue )
                    {
                    // InternalAssembler.g:1172:4: (lv_value_0_0= ruleDecimalValue )
                    // InternalAssembler.g:1173:5: lv_value_0_0= ruleDecimalValue
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getValueDecimalValueParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=ruleDecimalValue();

                    state._fsp--;


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
                    break;
                case 2 :
                    // InternalAssembler.g:1191:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    {
                    // InternalAssembler.g:1191:3: ( (lv_value_1_0= ruleHexaDecimalValue ) )
                    // InternalAssembler.g:1192:4: (lv_value_1_0= ruleHexaDecimalValue )
                    {
                    // InternalAssembler.g:1192:4: (lv_value_1_0= ruleHexaDecimalValue )
                    // InternalAssembler.g:1193:5: lv_value_1_0= ruleHexaDecimalValue
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getValueHexaDecimalValueParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleHexaDecimalValue();

                    state._fsp--;


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
                    break;
                case 3 :
                    // InternalAssembler.g:1211:3: ( (lv_value_2_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:1211:3: ( (lv_value_2_0= ruleOctalValue ) )
                    // InternalAssembler.g:1212:4: (lv_value_2_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:1212:4: (lv_value_2_0= ruleOctalValue )
                    // InternalAssembler.g:1213:5: lv_value_2_0= ruleOctalValue
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getValueOctalValueParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleOctalValue();

                    state._fsp--;


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
                    break;
                case 4 :
                    // InternalAssembler.g:1231:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    {
                    // InternalAssembler.g:1231:3: ( (lv_value_3_0= ruleBinaryValue ) )
                    // InternalAssembler.g:1232:4: (lv_value_3_0= ruleBinaryValue )
                    {
                    // InternalAssembler.g:1232:4: (lv_value_3_0= ruleBinaryValue )
                    // InternalAssembler.g:1233:5: lv_value_3_0= ruleBinaryValue
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getValueBinaryValueParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleBinaryValue();

                    state._fsp--;


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
                    break;
                case 5 :
                    // InternalAssembler.g:1251:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    {
                    // InternalAssembler.g:1251:3: ( (lv_value_4_0= ruleCharacterValue ) )
                    // InternalAssembler.g:1252:4: (lv_value_4_0= ruleCharacterValue )
                    {
                    // InternalAssembler.g:1252:4: (lv_value_4_0= ruleCharacterValue )
                    // InternalAssembler.g:1253:5: lv_value_4_0= ruleCharacterValue
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getValueCharacterValueParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleCharacterValue();

                    state._fsp--;


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
                    break;
                case 6 :
                    // InternalAssembler.g:1271:3: ( (lv_value_5_0= ruleIdentifier ) )
                    {
                    // InternalAssembler.g:1271:3: ( (lv_value_5_0= ruleIdentifier ) )
                    // InternalAssembler.g:1272:4: (lv_value_5_0= ruleIdentifier )
                    {
                    // InternalAssembler.g:1272:4: (lv_value_5_0= ruleIdentifier )
                    // InternalAssembler.g:1273:5: lv_value_5_0= ruleIdentifier
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getValueIdentifierParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleIdentifier();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_5_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.Identifier");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:1291:3: (otherlv_6= '(' this_Multiplication_7= ruleMultiplication otherlv_8= ')' )
                    {
                    // InternalAssembler.g:1291:3: (otherlv_6= '(' this_Multiplication_7= ruleMultiplication otherlv_8= ')' )
                    // InternalAssembler.g:1292:4: otherlv_6= '(' this_Multiplication_7= ruleMultiplication otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_10); 

                    				newLeafNode(otherlv_6, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_6_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_6_1());
                    			
                    pushFollow(FOLLOW_21);
                    this_Multiplication_7=ruleMultiplication();

                    state._fsp--;


                    				current = this_Multiplication_7;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_8=(Token)match(input,28,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_6_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleIdentifier"
    // InternalAssembler.g:1313:1: entryRuleIdentifier returns [EObject current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final EObject entryRuleIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifier = null;


        try {
            // InternalAssembler.g:1313:51: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalAssembler.g:1314:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
             newCompositeNode(grammarAccess.getIdentifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;

             current =iv_ruleIdentifier; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalAssembler.g:1320:1: ruleIdentifier returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1326:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalAssembler.g:1327:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalAssembler.g:1327:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalAssembler.g:1328:3: (lv_value_0_0= RULE_ID )
            {
            // InternalAssembler.g:1328:3: (lv_value_0_0= RULE_ID )
            // InternalAssembler.g:1329:4: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIdentifierAccess().getValueIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIdentifierRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.bpy.electronics.mc6809.assembler.Assembler.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleStringValue"
    // InternalAssembler.g:1348:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // InternalAssembler.g:1348:52: (iv_ruleStringValue= ruleStringValue EOF )
            // InternalAssembler.g:1349:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringValue"


    // $ANTLR start "ruleStringValue"
    // InternalAssembler.g:1355:1: ruleStringValue returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1361:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalAssembler.g:1362:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalAssembler.g:1362:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalAssembler.g:1363:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalAssembler.g:1363:3: (lv_value_0_0= RULE_STRING )
            // InternalAssembler.g:1364:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.bpy.electronics.mc6809.assembler.Assembler.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringValue"


    // $ANTLR start "entryRuleDecimalValue"
    // InternalAssembler.g:1383:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalAssembler.g:1383:53: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalAssembler.g:1384:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1390:1: ruleDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1396:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalAssembler.g:1397:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalAssembler.g:1397:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalAssembler.g:1398:3: (lv_value_0_0= RULE_INT )
            {
            // InternalAssembler.g:1398:3: (lv_value_0_0= RULE_INT )
            // InternalAssembler.g:1399:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getDecimalValueAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getDecimalValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.bpy.electronics.mc6809.assembler.Assembler.INT");
            			

            }


            }


            }


            	leaveRule();

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
    // InternalAssembler.g:1418:1: entryRuleHexaDecimalValue returns [EObject current=null] : iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF ;
    public final EObject entryRuleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexaDecimalValue = null;


        try {
            // InternalAssembler.g:1418:57: (iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF )
            // InternalAssembler.g:1419:2: iv_ruleHexaDecimalValue= ruleHexaDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getHexaDecimalValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHexaDecimalValue=ruleHexaDecimalValue();

            state._fsp--;

             current =iv_ruleHexaDecimalValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1425:1: ruleHexaDecimalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_HEXA ) ) ;
    public final EObject ruleHexaDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1431:2: ( ( (lv_value_0_0= RULE_HEXA ) ) )
            // InternalAssembler.g:1432:2: ( (lv_value_0_0= RULE_HEXA ) )
            {
            // InternalAssembler.g:1432:2: ( (lv_value_0_0= RULE_HEXA ) )
            // InternalAssembler.g:1433:3: (lv_value_0_0= RULE_HEXA )
            {
            // InternalAssembler.g:1433:3: (lv_value_0_0= RULE_HEXA )
            // InternalAssembler.g:1434:4: lv_value_0_0= RULE_HEXA
            {
            lv_value_0_0=(Token)match(input,RULE_HEXA,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getHexaDecimalValueAccess().getValueHEXATerminalRuleCall_0());
            			

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


            	leaveRule();

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
    // InternalAssembler.g:1453:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:1453:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:1454:2: iv_ruleOctalValue= ruleOctalValue EOF
            {
             newCompositeNode(grammarAccess.getOctalValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOctalValue=ruleOctalValue();

            state._fsp--;

             current =iv_ruleOctalValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1460:1: ruleOctalValue returns [EObject current=null] : ( (lv_value_0_0= RULE_OCTAL ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1466:2: ( ( (lv_value_0_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:1467:2: ( (lv_value_0_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:1467:2: ( (lv_value_0_0= RULE_OCTAL ) )
            // InternalAssembler.g:1468:3: (lv_value_0_0= RULE_OCTAL )
            {
            // InternalAssembler.g:1468:3: (lv_value_0_0= RULE_OCTAL )
            // InternalAssembler.g:1469:4: lv_value_0_0= RULE_OCTAL
            {
            lv_value_0_0=(Token)match(input,RULE_OCTAL,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getOctalValueAccess().getValueOCTALTerminalRuleCall_0());
            			

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


            	leaveRule();

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
    // InternalAssembler.g:1488:1: entryRuleBinaryValue returns [EObject current=null] : iv_ruleBinaryValue= ruleBinaryValue EOF ;
    public final EObject entryRuleBinaryValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryValue = null;


        try {
            // InternalAssembler.g:1488:52: (iv_ruleBinaryValue= ruleBinaryValue EOF )
            // InternalAssembler.g:1489:2: iv_ruleBinaryValue= ruleBinaryValue EOF
            {
             newCompositeNode(grammarAccess.getBinaryValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryValue=ruleBinaryValue();

            state._fsp--;

             current =iv_ruleBinaryValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1495:1: ruleBinaryValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BINARY ) ) ;
    public final EObject ruleBinaryValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1501:2: ( ( (lv_value_0_0= RULE_BINARY ) ) )
            // InternalAssembler.g:1502:2: ( (lv_value_0_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:1502:2: ( (lv_value_0_0= RULE_BINARY ) )
            // InternalAssembler.g:1503:3: (lv_value_0_0= RULE_BINARY )
            {
            // InternalAssembler.g:1503:3: (lv_value_0_0= RULE_BINARY )
            // InternalAssembler.g:1504:4: lv_value_0_0= RULE_BINARY
            {
            lv_value_0_0=(Token)match(input,RULE_BINARY,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getBinaryValueAccess().getValueBINARYTerminalRuleCall_0());
            			

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


            	leaveRule();

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
    // InternalAssembler.g:1523:1: entryRuleCharacterValue returns [EObject current=null] : iv_ruleCharacterValue= ruleCharacterValue EOF ;
    public final EObject entryRuleCharacterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterValue = null;


        try {
            // InternalAssembler.g:1523:55: (iv_ruleCharacterValue= ruleCharacterValue EOF )
            // InternalAssembler.g:1524:2: iv_ruleCharacterValue= ruleCharacterValue EOF
            {
             newCompositeNode(grammarAccess.getCharacterValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCharacterValue=ruleCharacterValue();

            state._fsp--;

             current =iv_ruleCharacterValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1530:1: ruleCharacterValue returns [EObject current=null] : ( (lv_value_0_0= RULE_CHARACTER ) ) ;
    public final EObject ruleCharacterValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1536:2: ( ( (lv_value_0_0= RULE_CHARACTER ) ) )
            // InternalAssembler.g:1537:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            {
            // InternalAssembler.g:1537:2: ( (lv_value_0_0= RULE_CHARACTER ) )
            // InternalAssembler.g:1538:3: (lv_value_0_0= RULE_CHARACTER )
            {
            // InternalAssembler.g:1538:3: (lv_value_0_0= RULE_CHARACTER )
            // InternalAssembler.g:1539:4: lv_value_0_0= RULE_CHARACTER
            {
            lv_value_0_0=(Token)match(input,RULE_CHARACTER,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getCharacterValueAccess().getValueCHARACTERTerminalRuleCall_0());
            			

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


            	leaveRule();

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
    // InternalAssembler.g:1558:1: entryRuleEndOfLine returns [String current=null] : iv_ruleEndOfLine= ruleEndOfLine EOF ;
    public final String entryRuleEndOfLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndOfLine = null;


        try {
            // InternalAssembler.g:1558:49: (iv_ruleEndOfLine= ruleEndOfLine EOF )
            // InternalAssembler.g:1559:2: iv_ruleEndOfLine= ruleEndOfLine EOF
            {
             newCompositeNode(grammarAccess.getEndOfLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndOfLine=ruleEndOfLine();

            state._fsp--;

             current =iv_ruleEndOfLine.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalAssembler.g:1565:1: ruleEndOfLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) ;
    public final AntlrDatatypeRuleToken ruleEndOfLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CR_0=null;
        Token this_END_OF_FILE_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:1571:2: ( (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE ) )
            // InternalAssembler.g:1572:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            {
            // InternalAssembler.g:1572:2: (this_CR_0= RULE_CR | this_END_OF_FILE_1= RULE_END_OF_FILE )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_CR) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_END_OF_FILE) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalAssembler.g:1573:3: this_CR_0= RULE_CR
                    {
                    this_CR_0=(Token)match(input,RULE_CR,FOLLOW_2); 

                    			current.merge(this_CR_0);
                    		

                    			newLeafNode(this_CR_0, grammarAccess.getEndOfLineAccess().getCRTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:1581:3: this_END_OF_FILE_1= RULE_END_OF_FILE
                    {
                    this_END_OF_FILE_1=(Token)match(input,RULE_END_OF_FILE,FOLLOW_2); 

                    			current.merge(this_END_OF_FILE_1);
                    		

                    			newLeafNode(this_END_OF_FILE_1, grammarAccess.getEndOfLineAccess().getEND_OF_FILETerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000006072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000008007FF0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000006030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008001F40L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});

}
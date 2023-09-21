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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_SL_COMMENT", "RULE_CR"
    };
    public static final int RULE_WS=4;
    public static final int RULE_CR=6;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=5;

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

                if ( ((LA1_0>=RULE_WS && LA1_0<=RULE_CR)) ) {
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
    // InternalAssembler.g:107:1: ruleSourceLine returns [EObject current=null] : ( ( (lv_emptyLine_0_0= ruleEmptyLine ) ) | ( (lv_commentLine_1_0= ruleCommentLine ) ) ) ;
    public final EObject ruleSourceLine() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_emptyLine_0_0 = null;

        EObject lv_commentLine_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:113:2: ( ( ( (lv_emptyLine_0_0= ruleEmptyLine ) ) | ( (lv_commentLine_1_0= ruleCommentLine ) ) ) )
            // InternalAssembler.g:114:2: ( ( (lv_emptyLine_0_0= ruleEmptyLine ) ) | ( (lv_commentLine_1_0= ruleCommentLine ) ) )
            {
            // InternalAssembler.g:114:2: ( ( (lv_emptyLine_0_0= ruleEmptyLine ) ) | ( (lv_commentLine_1_0= ruleCommentLine ) ) )
            int alt2=2;
            switch ( input.LA(1) ) {
            case RULE_WS:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_SL_COMMENT) ) {
                    alt2=2;
                }
                else if ( (LA2_1==RULE_CR) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_CR:
                {
                alt2=1;
                }
                break;
            case RULE_SL_COMMENT:
                {
                alt2=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalAssembler.g:115:3: ( (lv_emptyLine_0_0= ruleEmptyLine ) )
                    {
                    // InternalAssembler.g:115:3: ( (lv_emptyLine_0_0= ruleEmptyLine ) )
                    // InternalAssembler.g:116:4: (lv_emptyLine_0_0= ruleEmptyLine )
                    {
                    // InternalAssembler.g:116:4: (lv_emptyLine_0_0= ruleEmptyLine )
                    // InternalAssembler.g:117:5: lv_emptyLine_0_0= ruleEmptyLine
                    {

                    					newCompositeNode(grammarAccess.getSourceLineAccess().getEmptyLineEmptyLineParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_emptyLine_0_0=ruleEmptyLine();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                    					}
                    					set(
                    						current,
                    						"emptyLine",
                    						lv_emptyLine_0_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.EmptyLine");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:135:3: ( (lv_commentLine_1_0= ruleCommentLine ) )
                    {
                    // InternalAssembler.g:135:3: ( (lv_commentLine_1_0= ruleCommentLine ) )
                    // InternalAssembler.g:136:4: (lv_commentLine_1_0= ruleCommentLine )
                    {
                    // InternalAssembler.g:136:4: (lv_commentLine_1_0= ruleCommentLine )
                    // InternalAssembler.g:137:5: lv_commentLine_1_0= ruleCommentLine
                    {

                    					newCompositeNode(grammarAccess.getSourceLineAccess().getCommentLineCommentLineParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_commentLine_1_0=ruleCommentLine();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                    					}
                    					set(
                    						current,
                    						"commentLine",
                    						lv_commentLine_1_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.CommentLine");
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


    // $ANTLR start "entryRuleCommentLine"
    // InternalAssembler.g:158:1: entryRuleCommentLine returns [EObject current=null] : iv_ruleCommentLine= ruleCommentLine EOF ;
    public final EObject entryRuleCommentLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentLine = null;


        try {
            // InternalAssembler.g:158:52: (iv_ruleCommentLine= ruleCommentLine EOF )
            // InternalAssembler.g:159:2: iv_ruleCommentLine= ruleCommentLine EOF
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
    // InternalAssembler.g:165:1: ruleCommentLine returns [EObject current=null] : ( (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) ) ) ;
    public final EObject ruleCommentLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_0=null;
        Token lv_comment_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:171:2: ( ( (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) ) ) )
            // InternalAssembler.g:172:2: ( (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) ) )
            {
            // InternalAssembler.g:172:2: ( (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) ) )
            // InternalAssembler.g:173:3: (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) )
            {
            // InternalAssembler.g:173:3: (this_WS_0= RULE_WS )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssembler.g:174:4: this_WS_0= RULE_WS
                    {
                    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_4); 

                    				newLeafNode(this_WS_0, grammarAccess.getCommentLineAccess().getWSTerminalRuleCall_0());
                    			

                    }
                    break;

            }

            // InternalAssembler.g:179:3: ( (lv_comment_1_0= RULE_SL_COMMENT ) )
            // InternalAssembler.g:180:4: (lv_comment_1_0= RULE_SL_COMMENT )
            {
            // InternalAssembler.g:180:4: (lv_comment_1_0= RULE_SL_COMMENT )
            // InternalAssembler.g:181:5: lv_comment_1_0= RULE_SL_COMMENT
            {
            lv_comment_1_0=(Token)match(input,RULE_SL_COMMENT,FOLLOW_2); 

            					newLeafNode(lv_comment_1_0, grammarAccess.getCommentLineAccess().getCommentSL_COMMENTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCommentLineRule());
            					}
            					setWithLastConsumed(
            						current,
            						"comment",
            						lv_comment_1_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.SL_COMMENT");
            				

            }


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
    // $ANTLR end "ruleCommentLine"


    // $ANTLR start "entryRuleEmptyLine"
    // InternalAssembler.g:201:1: entryRuleEmptyLine returns [String current=null] : iv_ruleEmptyLine= ruleEmptyLine EOF ;
    public final String entryRuleEmptyLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEmptyLine = null;


        try {
            // InternalAssembler.g:201:49: (iv_ruleEmptyLine= ruleEmptyLine EOF )
            // InternalAssembler.g:202:2: iv_ruleEmptyLine= ruleEmptyLine EOF
            {
             newCompositeNode(grammarAccess.getEmptyLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEmptyLine=ruleEmptyLine();

            state._fsp--;

             current =iv_ruleEmptyLine.getText(); 
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
    // $ANTLR end "entryRuleEmptyLine"


    // $ANTLR start "ruleEmptyLine"
    // InternalAssembler.g:208:1: ruleEmptyLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )? this_CR_1= RULE_CR ) ;
    public final AntlrDatatypeRuleToken ruleEmptyLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_CR_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:214:2: ( ( (this_WS_0= RULE_WS )? this_CR_1= RULE_CR ) )
            // InternalAssembler.g:215:2: ( (this_WS_0= RULE_WS )? this_CR_1= RULE_CR )
            {
            // InternalAssembler.g:215:2: ( (this_WS_0= RULE_WS )? this_CR_1= RULE_CR )
            // InternalAssembler.g:216:3: (this_WS_0= RULE_WS )? this_CR_1= RULE_CR
            {
            // InternalAssembler.g:216:3: (this_WS_0= RULE_WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_WS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:217:4: this_WS_0= RULE_WS
                    {
                    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_5); 

                    				current.merge(this_WS_0);
                    			

                    				newLeafNode(this_WS_0, grammarAccess.getEmptyLineAccess().getWSTerminalRuleCall_0());
                    			

                    }
                    break;

            }

            this_CR_1=(Token)match(input,RULE_CR,FOLLOW_2); 

            			current.merge(this_CR_1);
            		

            			newLeafNode(this_CR_1, grammarAccess.getEmptyLineAccess().getCRTerminalRuleCall_1());
            		

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
    // $ANTLR end "ruleEmptyLine"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000040L});

}
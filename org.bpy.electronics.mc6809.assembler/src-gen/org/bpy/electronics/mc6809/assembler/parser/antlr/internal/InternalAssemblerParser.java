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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_SL_COMMENT", "RULE_CR", "RULE_LABEL", "RULE_BINARY", "RULE_OCTAL", "RULE_DECIMAL", "RULE_HEXADECIMAL", "RULE_ASCII", "'EQU'", "'+'", "'*'", "'/'", "'-'", "'('", "')'"
    };
    public static final int RULE_LABEL=7;
    public static final int RULE_CR=6;
    public static final int RULE_SL_COMMENT=5;
    public static final int T__19=19;
    public static final int RULE_OCTAL=9;
    public static final int RULE_ASCII=12;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_WS=4;
    public static final int RULE_DECIMAL=10;
    public static final int RULE_HEXADECIMAL=11;
    public static final int RULE_BINARY=8;

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

                if ( ((LA1_0>=RULE_WS && LA1_0<=RULE_LABEL)) ) {
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
    // InternalAssembler.g:107:1: ruleSourceLine returns [EObject current=null] : ( ( (lv_assemblyLine_0_0= ruleAssemblyLine ) ) | ( (lv_emptyLine_1_0= ruleEmptyLine ) ) | ( (lv_commentLine_2_0= ruleCommentLine ) ) ) ;
    public final EObject ruleSourceLine() throws RecognitionException {
        EObject current = null;

        EObject lv_assemblyLine_0_0 = null;

        AntlrDatatypeRuleToken lv_emptyLine_1_0 = null;

        EObject lv_commentLine_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:113:2: ( ( ( (lv_assemblyLine_0_0= ruleAssemblyLine ) ) | ( (lv_emptyLine_1_0= ruleEmptyLine ) ) | ( (lv_commentLine_2_0= ruleCommentLine ) ) ) )
            // InternalAssembler.g:114:2: ( ( (lv_assemblyLine_0_0= ruleAssemblyLine ) ) | ( (lv_emptyLine_1_0= ruleEmptyLine ) ) | ( (lv_commentLine_2_0= ruleCommentLine ) ) )
            {
            // InternalAssembler.g:114:2: ( ( (lv_assemblyLine_0_0= ruleAssemblyLine ) ) | ( (lv_emptyLine_1_0= ruleEmptyLine ) ) | ( (lv_commentLine_2_0= ruleCommentLine ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_LABEL:
                {
                alt2=1;
                }
                break;
            case RULE_WS:
                {
                switch ( input.LA(2) ) {
                case RULE_SL_COMMENT:
                    {
                    alt2=3;
                    }
                    break;
                case 13:
                    {
                    alt2=1;
                    }
                    break;
                case RULE_CR:
                    {
                    alt2=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_CR:
                {
                alt2=2;
                }
                break;
            case RULE_SL_COMMENT:
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
                    // InternalAssembler.g:115:3: ( (lv_assemblyLine_0_0= ruleAssemblyLine ) )
                    {
                    // InternalAssembler.g:115:3: ( (lv_assemblyLine_0_0= ruleAssemblyLine ) )
                    // InternalAssembler.g:116:4: (lv_assemblyLine_0_0= ruleAssemblyLine )
                    {
                    // InternalAssembler.g:116:4: (lv_assemblyLine_0_0= ruleAssemblyLine )
                    // InternalAssembler.g:117:5: lv_assemblyLine_0_0= ruleAssemblyLine
                    {

                    					newCompositeNode(grammarAccess.getSourceLineAccess().getAssemblyLineAssemblyLineParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_assemblyLine_0_0=ruleAssemblyLine();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                    					}
                    					set(
                    						current,
                    						"assemblyLine",
                    						lv_assemblyLine_0_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.AssemblyLine");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:135:3: ( (lv_emptyLine_1_0= ruleEmptyLine ) )
                    {
                    // InternalAssembler.g:135:3: ( (lv_emptyLine_1_0= ruleEmptyLine ) )
                    // InternalAssembler.g:136:4: (lv_emptyLine_1_0= ruleEmptyLine )
                    {
                    // InternalAssembler.g:136:4: (lv_emptyLine_1_0= ruleEmptyLine )
                    // InternalAssembler.g:137:5: lv_emptyLine_1_0= ruleEmptyLine
                    {

                    					newCompositeNode(grammarAccess.getSourceLineAccess().getEmptyLineEmptyLineParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_emptyLine_1_0=ruleEmptyLine();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                    					}
                    					set(
                    						current,
                    						"emptyLine",
                    						lv_emptyLine_1_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.EmptyLine");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:155:3: ( (lv_commentLine_2_0= ruleCommentLine ) )
                    {
                    // InternalAssembler.g:155:3: ( (lv_commentLine_2_0= ruleCommentLine ) )
                    // InternalAssembler.g:156:4: (lv_commentLine_2_0= ruleCommentLine )
                    {
                    // InternalAssembler.g:156:4: (lv_commentLine_2_0= ruleCommentLine )
                    // InternalAssembler.g:157:5: lv_commentLine_2_0= ruleCommentLine
                    {

                    					newCompositeNode(grammarAccess.getSourceLineAccess().getCommentLineCommentLineParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_commentLine_2_0=ruleCommentLine();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSourceLineRule());
                    					}
                    					set(
                    						current,
                    						"commentLine",
                    						lv_commentLine_2_0,
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


    // $ANTLR start "entryRuleAssemblyLine"
    // InternalAssembler.g:178:1: entryRuleAssemblyLine returns [EObject current=null] : iv_ruleAssemblyLine= ruleAssemblyLine EOF ;
    public final EObject entryRuleAssemblyLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssemblyLine = null;


        try {
            // InternalAssembler.g:178:53: (iv_ruleAssemblyLine= ruleAssemblyLine EOF )
            // InternalAssembler.g:179:2: iv_ruleAssemblyLine= ruleAssemblyLine EOF
            {
             newCompositeNode(grammarAccess.getAssemblyLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssemblyLine=ruleAssemblyLine();

            state._fsp--;

             current =iv_ruleAssemblyLine; 
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
    // $ANTLR end "entryRuleAssemblyLine"


    // $ANTLR start "ruleAssemblyLine"
    // InternalAssembler.g:185:1: ruleAssemblyLine returns [EObject current=null] : ( ( (lv_labelField_0_0= ruleLabelField ) )? this_WS_1= RULE_WS ( (lv_command_2_0= ruleDirective ) ) (this_WS_3= RULE_WS )? (this_SL_COMMENT_4= RULE_SL_COMMENT | this_CR_5= RULE_CR ) ) ;
    public final EObject ruleAssemblyLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_WS_3=null;
        Token this_SL_COMMENT_4=null;
        Token this_CR_5=null;
        EObject lv_labelField_0_0 = null;

        EObject lv_command_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:191:2: ( ( ( (lv_labelField_0_0= ruleLabelField ) )? this_WS_1= RULE_WS ( (lv_command_2_0= ruleDirective ) ) (this_WS_3= RULE_WS )? (this_SL_COMMENT_4= RULE_SL_COMMENT | this_CR_5= RULE_CR ) ) )
            // InternalAssembler.g:192:2: ( ( (lv_labelField_0_0= ruleLabelField ) )? this_WS_1= RULE_WS ( (lv_command_2_0= ruleDirective ) ) (this_WS_3= RULE_WS )? (this_SL_COMMENT_4= RULE_SL_COMMENT | this_CR_5= RULE_CR ) )
            {
            // InternalAssembler.g:192:2: ( ( (lv_labelField_0_0= ruleLabelField ) )? this_WS_1= RULE_WS ( (lv_command_2_0= ruleDirective ) ) (this_WS_3= RULE_WS )? (this_SL_COMMENT_4= RULE_SL_COMMENT | this_CR_5= RULE_CR ) )
            // InternalAssembler.g:193:3: ( (lv_labelField_0_0= ruleLabelField ) )? this_WS_1= RULE_WS ( (lv_command_2_0= ruleDirective ) ) (this_WS_3= RULE_WS )? (this_SL_COMMENT_4= RULE_SL_COMMENT | this_CR_5= RULE_CR )
            {
            // InternalAssembler.g:193:3: ( (lv_labelField_0_0= ruleLabelField ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_LABEL) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssembler.g:194:4: (lv_labelField_0_0= ruleLabelField )
                    {
                    // InternalAssembler.g:194:4: (lv_labelField_0_0= ruleLabelField )
                    // InternalAssembler.g:195:5: lv_labelField_0_0= ruleLabelField
                    {

                    					newCompositeNode(grammarAccess.getAssemblyLineAccess().getLabelFieldLabelFieldParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_labelField_0_0=ruleLabelField();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getAssemblyLineRule());
                    					}
                    					set(
                    						current,
                    						"labelField",
                    						lv_labelField_0_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.LabelField");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_5); 

            			newLeafNode(this_WS_1, grammarAccess.getAssemblyLineAccess().getWSTerminalRuleCall_1());
            		
            // InternalAssembler.g:216:3: ( (lv_command_2_0= ruleDirective ) )
            // InternalAssembler.g:217:4: (lv_command_2_0= ruleDirective )
            {
            // InternalAssembler.g:217:4: (lv_command_2_0= ruleDirective )
            // InternalAssembler.g:218:5: lv_command_2_0= ruleDirective
            {

            					newCompositeNode(grammarAccess.getAssemblyLineAccess().getCommandDirectiveParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_command_2_0=ruleDirective();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssemblyLineRule());
            					}
            					set(
            						current,
            						"command",
            						lv_command_2_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.Directive");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAssembler.g:235:3: (this_WS_3= RULE_WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_WS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:236:4: this_WS_3= RULE_WS
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_7); 

                    				newLeafNode(this_WS_3, grammarAccess.getAssemblyLineAccess().getWSTerminalRuleCall_3());
                    			

                    }
                    break;

            }

            // InternalAssembler.g:241:3: (this_SL_COMMENT_4= RULE_SL_COMMENT | this_CR_5= RULE_CR )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_SL_COMMENT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_CR) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:242:4: this_SL_COMMENT_4= RULE_SL_COMMENT
                    {
                    this_SL_COMMENT_4=(Token)match(input,RULE_SL_COMMENT,FOLLOW_2); 

                    				newLeafNode(this_SL_COMMENT_4, grammarAccess.getAssemblyLineAccess().getSL_COMMENTTerminalRuleCall_4_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:247:4: this_CR_5= RULE_CR
                    {
                    this_CR_5=(Token)match(input,RULE_CR,FOLLOW_2); 

                    				newLeafNode(this_CR_5, grammarAccess.getAssemblyLineAccess().getCRTerminalRuleCall_4_1());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleAssemblyLine"


    // $ANTLR start "entryRuleDirective"
    // InternalAssembler.g:256:1: entryRuleDirective returns [EObject current=null] : iv_ruleDirective= ruleDirective EOF ;
    public final EObject entryRuleDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirective = null;


        try {
            // InternalAssembler.g:256:50: (iv_ruleDirective= ruleDirective EOF )
            // InternalAssembler.g:257:2: iv_ruleDirective= ruleDirective EOF
            {
             newCompositeNode(grammarAccess.getDirectiveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDirective=ruleDirective();

            state._fsp--;

             current =iv_ruleDirective; 
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
    // $ANTLR end "entryRuleDirective"


    // $ANTLR start "ruleDirective"
    // InternalAssembler.g:263:1: ruleDirective returns [EObject current=null] : ( (lv_directive_0_0= ruleEquDirective ) ) ;
    public final EObject ruleDirective() throws RecognitionException {
        EObject current = null;

        EObject lv_directive_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:269:2: ( ( (lv_directive_0_0= ruleEquDirective ) ) )
            // InternalAssembler.g:270:2: ( (lv_directive_0_0= ruleEquDirective ) )
            {
            // InternalAssembler.g:270:2: ( (lv_directive_0_0= ruleEquDirective ) )
            // InternalAssembler.g:271:3: (lv_directive_0_0= ruleEquDirective )
            {
            // InternalAssembler.g:271:3: (lv_directive_0_0= ruleEquDirective )
            // InternalAssembler.g:272:4: lv_directive_0_0= ruleEquDirective
            {

            				newCompositeNode(grammarAccess.getDirectiveAccess().getDirectiveEquDirectiveParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_directive_0_0=ruleEquDirective();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getDirectiveRule());
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
    // $ANTLR end "ruleDirective"


    // $ANTLR start "entryRuleEquDirective"
    // InternalAssembler.g:292:1: entryRuleEquDirective returns [EObject current=null] : iv_ruleEquDirective= ruleEquDirective EOF ;
    public final EObject entryRuleEquDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquDirective = null;


        try {
            // InternalAssembler.g:292:53: (iv_ruleEquDirective= ruleEquDirective EOF )
            // InternalAssembler.g:293:2: iv_ruleEquDirective= ruleEquDirective EOF
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
    // InternalAssembler.g:299:1: ruleEquDirective returns [EObject current=null] : (otherlv_0= 'EQU' this_WS_1= RULE_WS ( (lv_constant_2_0= ruleSpecifiedValue ) ) ) ;
    public final EObject ruleEquDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_WS_1=null;
        EObject lv_constant_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:305:2: ( (otherlv_0= 'EQU' this_WS_1= RULE_WS ( (lv_constant_2_0= ruleSpecifiedValue ) ) ) )
            // InternalAssembler.g:306:2: (otherlv_0= 'EQU' this_WS_1= RULE_WS ( (lv_constant_2_0= ruleSpecifiedValue ) ) )
            {
            // InternalAssembler.g:306:2: (otherlv_0= 'EQU' this_WS_1= RULE_WS ( (lv_constant_2_0= ruleSpecifiedValue ) ) )
            // InternalAssembler.g:307:3: otherlv_0= 'EQU' this_WS_1= RULE_WS ( (lv_constant_2_0= ruleSpecifiedValue ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEquDirectiveAccess().getEQUKeyword_0());
            		
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_8); 

            			newLeafNode(this_WS_1, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1());
            		
            // InternalAssembler.g:315:3: ( (lv_constant_2_0= ruleSpecifiedValue ) )
            // InternalAssembler.g:316:4: (lv_constant_2_0= ruleSpecifiedValue )
            {
            // InternalAssembler.g:316:4: (lv_constant_2_0= ruleSpecifiedValue )
            // InternalAssembler.g:317:5: lv_constant_2_0= ruleSpecifiedValue
            {

            					newCompositeNode(grammarAccess.getEquDirectiveAccess().getConstantSpecifiedValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_constant_2_0=ruleSpecifiedValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEquDirectiveRule());
            					}
            					set(
            						current,
            						"constant",
            						lv_constant_2_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.SpecifiedValue");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleEquDirective"


    // $ANTLR start "entryRuleLabelField"
    // InternalAssembler.g:338:1: entryRuleLabelField returns [EObject current=null] : iv_ruleLabelField= ruleLabelField EOF ;
    public final EObject entryRuleLabelField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabelField = null;


        try {
            // InternalAssembler.g:338:51: (iv_ruleLabelField= ruleLabelField EOF )
            // InternalAssembler.g:339:2: iv_ruleLabelField= ruleLabelField EOF
            {
             newCompositeNode(grammarAccess.getLabelFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLabelField=ruleLabelField();

            state._fsp--;

             current =iv_ruleLabelField; 
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
    // $ANTLR end "entryRuleLabelField"


    // $ANTLR start "ruleLabelField"
    // InternalAssembler.g:345:1: ruleLabelField returns [EObject current=null] : ( (lv_label_0_0= RULE_LABEL ) ) ;
    public final EObject ruleLabelField() throws RecognitionException {
        EObject current = null;

        Token lv_label_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:351:2: ( ( (lv_label_0_0= RULE_LABEL ) ) )
            // InternalAssembler.g:352:2: ( (lv_label_0_0= RULE_LABEL ) )
            {
            // InternalAssembler.g:352:2: ( (lv_label_0_0= RULE_LABEL ) )
            // InternalAssembler.g:353:3: (lv_label_0_0= RULE_LABEL )
            {
            // InternalAssembler.g:353:3: (lv_label_0_0= RULE_LABEL )
            // InternalAssembler.g:354:4: lv_label_0_0= RULE_LABEL
            {
            lv_label_0_0=(Token)match(input,RULE_LABEL,FOLLOW_2); 

            				newLeafNode(lv_label_0_0, grammarAccess.getLabelFieldAccess().getLabelLABELTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getLabelFieldRule());
            				}
            				setWithLastConsumed(
            					current,
            					"label",
            					lv_label_0_0,
            					"org.bpy.electronics.mc6809.assembler.Assembler.LABEL");
            			

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
    // $ANTLR end "ruleLabelField"


    // $ANTLR start "entryRuleCommentLine"
    // InternalAssembler.g:373:1: entryRuleCommentLine returns [EObject current=null] : iv_ruleCommentLine= ruleCommentLine EOF ;
    public final EObject entryRuleCommentLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentLine = null;


        try {
            // InternalAssembler.g:373:52: (iv_ruleCommentLine= ruleCommentLine EOF )
            // InternalAssembler.g:374:2: iv_ruleCommentLine= ruleCommentLine EOF
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
    // InternalAssembler.g:380:1: ruleCommentLine returns [EObject current=null] : ( (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) ) ) ;
    public final EObject ruleCommentLine() throws RecognitionException {
        EObject current = null;

        Token this_WS_0=null;
        Token lv_comment_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:386:2: ( ( (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) ) ) )
            // InternalAssembler.g:387:2: ( (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) ) )
            {
            // InternalAssembler.g:387:2: ( (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) ) )
            // InternalAssembler.g:388:3: (this_WS_0= RULE_WS )? ( (lv_comment_1_0= RULE_SL_COMMENT ) )
            {
            // InternalAssembler.g:388:3: (this_WS_0= RULE_WS )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_WS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:389:4: this_WS_0= RULE_WS
                    {
                    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_9); 

                    				newLeafNode(this_WS_0, grammarAccess.getCommentLineAccess().getWSTerminalRuleCall_0());
                    			

                    }
                    break;

            }

            // InternalAssembler.g:394:3: ( (lv_comment_1_0= RULE_SL_COMMENT ) )
            // InternalAssembler.g:395:4: (lv_comment_1_0= RULE_SL_COMMENT )
            {
            // InternalAssembler.g:395:4: (lv_comment_1_0= RULE_SL_COMMENT )
            // InternalAssembler.g:396:5: lv_comment_1_0= RULE_SL_COMMENT
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
    // InternalAssembler.g:416:1: entryRuleEmptyLine returns [String current=null] : iv_ruleEmptyLine= ruleEmptyLine EOF ;
    public final String entryRuleEmptyLine() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEmptyLine = null;


        try {
            // InternalAssembler.g:416:49: (iv_ruleEmptyLine= ruleEmptyLine EOF )
            // InternalAssembler.g:417:2: iv_ruleEmptyLine= ruleEmptyLine EOF
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
    // InternalAssembler.g:423:1: ruleEmptyLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )? this_CR_1= RULE_CR ) ;
    public final AntlrDatatypeRuleToken ruleEmptyLine() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_CR_1=null;


        	enterRule();

        try {
            // InternalAssembler.g:429:2: ( ( (this_WS_0= RULE_WS )? this_CR_1= RULE_CR ) )
            // InternalAssembler.g:430:2: ( (this_WS_0= RULE_WS )? this_CR_1= RULE_CR )
            {
            // InternalAssembler.g:430:2: ( (this_WS_0= RULE_WS )? this_CR_1= RULE_CR )
            // InternalAssembler.g:431:3: (this_WS_0= RULE_WS )? this_CR_1= RULE_CR
            {
            // InternalAssembler.g:431:3: (this_WS_0= RULE_WS )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:432:4: this_WS_0= RULE_WS
                    {
                    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_10); 

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


    // $ANTLR start "entryRuleSpecifiedValue"
    // InternalAssembler.g:451:1: entryRuleSpecifiedValue returns [EObject current=null] : iv_ruleSpecifiedValue= ruleSpecifiedValue EOF ;
    public final EObject entryRuleSpecifiedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecifiedValue = null;


        try {
            // InternalAssembler.g:451:55: (iv_ruleSpecifiedValue= ruleSpecifiedValue EOF )
            // InternalAssembler.g:452:2: iv_ruleSpecifiedValue= ruleSpecifiedValue EOF
            {
             newCompositeNode(grammarAccess.getSpecifiedValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecifiedValue=ruleSpecifiedValue();

            state._fsp--;

             current =iv_ruleSpecifiedValue; 
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
    // $ANTLR end "entryRuleSpecifiedValue"


    // $ANTLR start "ruleSpecifiedValue"
    // InternalAssembler.g:458:1: ruleSpecifiedValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExpression ) )? ) ;
    public final EObject ruleSpecifiedValue() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:464:2: ( ( () ( (lv_value_1_0= ruleExpression ) )? ) )
            // InternalAssembler.g:465:2: ( () ( (lv_value_1_0= ruleExpression ) )? )
            {
            // InternalAssembler.g:465:2: ( () ( (lv_value_1_0= ruleExpression ) )? )
            // InternalAssembler.g:466:3: () ( (lv_value_1_0= ruleExpression ) )?
            {
            // InternalAssembler.g:466:3: ()
            // InternalAssembler.g:467:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpecifiedValueAccess().getSpecifiedValueAction_0(),
            					current);
            			

            }

            // InternalAssembler.g:473:3: ( (lv_value_1_0= ruleExpression ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_LABEL && LA8_0<=RULE_ASCII)||LA8_0==15||(LA8_0>=17 && LA8_0<=18)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:474:4: (lv_value_1_0= ruleExpression )
                    {
                    // InternalAssembler.g:474:4: (lv_value_1_0= ruleExpression )
                    // InternalAssembler.g:475:5: lv_value_1_0= ruleExpression
                    {

                    					newCompositeNode(grammarAccess.getSpecifiedValueAccess().getValueExpressionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSpecifiedValueRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_1_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.Expression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleSpecifiedValue"


    // $ANTLR start "entryRuleExpression"
    // InternalAssembler.g:496:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalAssembler.g:496:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalAssembler.g:497:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalAssembler.g:503:1: ruleExpression returns [EObject current=null] : ( (lv_addition_0_0= ruleAddition ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_addition_0_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:509:2: ( ( (lv_addition_0_0= ruleAddition ) ) )
            // InternalAssembler.g:510:2: ( (lv_addition_0_0= ruleAddition ) )
            {
            // InternalAssembler.g:510:2: ( (lv_addition_0_0= ruleAddition ) )
            // InternalAssembler.g:511:3: (lv_addition_0_0= ruleAddition )
            {
            // InternalAssembler.g:511:3: (lv_addition_0_0= ruleAddition )
            // InternalAssembler.g:512:4: lv_addition_0_0= ruleAddition
            {

            				newCompositeNode(grammarAccess.getExpressionAccess().getAdditionAdditionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_addition_0_0=ruleAddition();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getExpressionRule());
            				}
            				set(
            					current,
            					"addition",
            					lv_addition_0_0,
            					"org.bpy.electronics.mc6809.assembler.Assembler.Addition");
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAddition"
    // InternalAssembler.g:532:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalAssembler.g:532:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalAssembler.g:533:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalAssembler.g:539:1: ruleAddition returns [EObject current=null] : ( ( (lv_values_0_0= ruleMultiplication ) ) (otherlv_1= '+' ( (lv_values_2_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:545:2: ( ( ( (lv_values_0_0= ruleMultiplication ) ) (otherlv_1= '+' ( (lv_values_2_0= ruleMultiplication ) ) )* ) )
            // InternalAssembler.g:546:2: ( ( (lv_values_0_0= ruleMultiplication ) ) (otherlv_1= '+' ( (lv_values_2_0= ruleMultiplication ) ) )* )
            {
            // InternalAssembler.g:546:2: ( ( (lv_values_0_0= ruleMultiplication ) ) (otherlv_1= '+' ( (lv_values_2_0= ruleMultiplication ) ) )* )
            // InternalAssembler.g:547:3: ( (lv_values_0_0= ruleMultiplication ) ) (otherlv_1= '+' ( (lv_values_2_0= ruleMultiplication ) ) )*
            {
            // InternalAssembler.g:547:3: ( (lv_values_0_0= ruleMultiplication ) )
            // InternalAssembler.g:548:4: (lv_values_0_0= ruleMultiplication )
            {
            // InternalAssembler.g:548:4: (lv_values_0_0= ruleMultiplication )
            // InternalAssembler.g:549:5: lv_values_0_0= ruleMultiplication
            {

            					newCompositeNode(grammarAccess.getAdditionAccess().getValuesMultiplicationParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_values_0_0=ruleMultiplication();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdditionRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_0_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.Multiplication");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAssembler.g:566:3: (otherlv_1= '+' ( (lv_values_2_0= ruleMultiplication ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==14) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAssembler.g:567:4: otherlv_1= '+' ( (lv_values_2_0= ruleMultiplication ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0());
            	    			
            	    // InternalAssembler.g:571:4: ( (lv_values_2_0= ruleMultiplication ) )
            	    // InternalAssembler.g:572:5: (lv_values_2_0= ruleMultiplication )
            	    {
            	    // InternalAssembler.g:572:5: (lv_values_2_0= ruleMultiplication )
            	    // InternalAssembler.g:573:6: lv_values_2_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getValuesMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_values_2_0=ruleMultiplication();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_2_0,
            	    							"org.bpy.electronics.mc6809.assembler.Assembler.Multiplication");
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalAssembler.g:595:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalAssembler.g:595:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalAssembler.g:596:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalAssembler.g:602:1: ruleMultiplication returns [EObject current=null] : ( ( (lv_values_0_0= ruleDivision ) ) (otherlv_1= '*' ( (lv_values_2_0= ruleDivision ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:608:2: ( ( ( (lv_values_0_0= ruleDivision ) ) (otherlv_1= '*' ( (lv_values_2_0= ruleDivision ) ) )* ) )
            // InternalAssembler.g:609:2: ( ( (lv_values_0_0= ruleDivision ) ) (otherlv_1= '*' ( (lv_values_2_0= ruleDivision ) ) )* )
            {
            // InternalAssembler.g:609:2: ( ( (lv_values_0_0= ruleDivision ) ) (otherlv_1= '*' ( (lv_values_2_0= ruleDivision ) ) )* )
            // InternalAssembler.g:610:3: ( (lv_values_0_0= ruleDivision ) ) (otherlv_1= '*' ( (lv_values_2_0= ruleDivision ) ) )*
            {
            // InternalAssembler.g:610:3: ( (lv_values_0_0= ruleDivision ) )
            // InternalAssembler.g:611:4: (lv_values_0_0= ruleDivision )
            {
            // InternalAssembler.g:611:4: (lv_values_0_0= ruleDivision )
            // InternalAssembler.g:612:5: lv_values_0_0= ruleDivision
            {

            					newCompositeNode(grammarAccess.getMultiplicationAccess().getValuesDivisionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_values_0_0=ruleDivision();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_0_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.Division");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAssembler.g:629:3: (otherlv_1= '*' ( (lv_values_2_0= ruleDivision ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalAssembler.g:630:4: otherlv_1= '*' ( (lv_values_2_0= ruleDivision ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0());
            	    			
            	    // InternalAssembler.g:634:4: ( (lv_values_2_0= ruleDivision ) )
            	    // InternalAssembler.g:635:5: (lv_values_2_0= ruleDivision )
            	    {
            	    // InternalAssembler.g:635:5: (lv_values_2_0= ruleDivision )
            	    // InternalAssembler.g:636:6: lv_values_2_0= ruleDivision
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getValuesDivisionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_values_2_0=ruleDivision();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_2_0,
            	    							"org.bpy.electronics.mc6809.assembler.Assembler.Division");
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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleDivision"
    // InternalAssembler.g:658:1: entryRuleDivision returns [EObject current=null] : iv_ruleDivision= ruleDivision EOF ;
    public final EObject entryRuleDivision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivision = null;


        try {
            // InternalAssembler.g:658:49: (iv_ruleDivision= ruleDivision EOF )
            // InternalAssembler.g:659:2: iv_ruleDivision= ruleDivision EOF
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
    // InternalAssembler.g:665:1: ruleDivision returns [EObject current=null] : ( ( (lv_values_0_0= ruleSoustraction ) ) (otherlv_1= '/' ( (lv_values_2_0= ruleSoustraction ) ) )* ) ;
    public final EObject ruleDivision() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:671:2: ( ( ( (lv_values_0_0= ruleSoustraction ) ) (otherlv_1= '/' ( (lv_values_2_0= ruleSoustraction ) ) )* ) )
            // InternalAssembler.g:672:2: ( ( (lv_values_0_0= ruleSoustraction ) ) (otherlv_1= '/' ( (lv_values_2_0= ruleSoustraction ) ) )* )
            {
            // InternalAssembler.g:672:2: ( ( (lv_values_0_0= ruleSoustraction ) ) (otherlv_1= '/' ( (lv_values_2_0= ruleSoustraction ) ) )* )
            // InternalAssembler.g:673:3: ( (lv_values_0_0= ruleSoustraction ) ) (otherlv_1= '/' ( (lv_values_2_0= ruleSoustraction ) ) )*
            {
            // InternalAssembler.g:673:3: ( (lv_values_0_0= ruleSoustraction ) )
            // InternalAssembler.g:674:4: (lv_values_0_0= ruleSoustraction )
            {
            // InternalAssembler.g:674:4: (lv_values_0_0= ruleSoustraction )
            // InternalAssembler.g:675:5: lv_values_0_0= ruleSoustraction
            {

            					newCompositeNode(grammarAccess.getDivisionAccess().getValuesSoustractionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_13);
            lv_values_0_0=ruleSoustraction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDivisionRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_0_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.Soustraction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAssembler.g:692:3: (otherlv_1= '/' ( (lv_values_2_0= ruleSoustraction ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==16) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAssembler.g:693:4: otherlv_1= '/' ( (lv_values_2_0= ruleSoustraction ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getDivisionAccess().getSolidusKeyword_1_0());
            	    			
            	    // InternalAssembler.g:697:4: ( (lv_values_2_0= ruleSoustraction ) )
            	    // InternalAssembler.g:698:5: (lv_values_2_0= ruleSoustraction )
            	    {
            	    // InternalAssembler.g:698:5: (lv_values_2_0= ruleSoustraction )
            	    // InternalAssembler.g:699:6: lv_values_2_0= ruleSoustraction
            	    {

            	    						newCompositeNode(grammarAccess.getDivisionAccess().getValuesSoustractionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_values_2_0=ruleSoustraction();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDivisionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_2_0,
            	    							"org.bpy.electronics.mc6809.assembler.Assembler.Soustraction");
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
    // $ANTLR end "ruleDivision"


    // $ANTLR start "entryRuleSoustraction"
    // InternalAssembler.g:721:1: entryRuleSoustraction returns [EObject current=null] : iv_ruleSoustraction= ruleSoustraction EOF ;
    public final EObject entryRuleSoustraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoustraction = null;


        try {
            // InternalAssembler.g:721:53: (iv_ruleSoustraction= ruleSoustraction EOF )
            // InternalAssembler.g:722:2: iv_ruleSoustraction= ruleSoustraction EOF
            {
             newCompositeNode(grammarAccess.getSoustractionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSoustraction=ruleSoustraction();

            state._fsp--;

             current =iv_ruleSoustraction; 
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
    // $ANTLR end "entryRuleSoustraction"


    // $ANTLR start "ruleSoustraction"
    // InternalAssembler.g:728:1: ruleSoustraction returns [EObject current=null] : ( ( (lv_values_0_0= rulePrimary ) ) (otherlv_1= '-' ( (lv_values_2_0= rulePrimary ) ) )* ) ;
    public final EObject ruleSoustraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:734:2: ( ( ( (lv_values_0_0= rulePrimary ) ) (otherlv_1= '-' ( (lv_values_2_0= rulePrimary ) ) )* ) )
            // InternalAssembler.g:735:2: ( ( (lv_values_0_0= rulePrimary ) ) (otherlv_1= '-' ( (lv_values_2_0= rulePrimary ) ) )* )
            {
            // InternalAssembler.g:735:2: ( ( (lv_values_0_0= rulePrimary ) ) (otherlv_1= '-' ( (lv_values_2_0= rulePrimary ) ) )* )
            // InternalAssembler.g:736:3: ( (lv_values_0_0= rulePrimary ) ) (otherlv_1= '-' ( (lv_values_2_0= rulePrimary ) ) )*
            {
            // InternalAssembler.g:736:3: ( (lv_values_0_0= rulePrimary ) )
            // InternalAssembler.g:737:4: (lv_values_0_0= rulePrimary )
            {
            // InternalAssembler.g:737:4: (lv_values_0_0= rulePrimary )
            // InternalAssembler.g:738:5: lv_values_0_0= rulePrimary
            {

            					newCompositeNode(grammarAccess.getSoustractionAccess().getValuesPrimaryParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_14);
            lv_values_0_0=rulePrimary();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSoustractionRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_0_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.Primary");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAssembler.g:755:3: (otherlv_1= '-' ( (lv_values_2_0= rulePrimary ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==17) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAssembler.g:756:4: otherlv_1= '-' ( (lv_values_2_0= rulePrimary ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getSoustractionAccess().getHyphenMinusKeyword_1_0());
            	    			
            	    // InternalAssembler.g:760:4: ( (lv_values_2_0= rulePrimary ) )
            	    // InternalAssembler.g:761:5: (lv_values_2_0= rulePrimary )
            	    {
            	    // InternalAssembler.g:761:5: (lv_values_2_0= rulePrimary )
            	    // InternalAssembler.g:762:6: lv_values_2_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getSoustractionAccess().getValuesPrimaryParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    lv_values_2_0=rulePrimary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSoustractionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_2_0,
            	    							"org.bpy.electronics.mc6809.assembler.Assembler.Primary");
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
    // $ANTLR end "ruleSoustraction"


    // $ANTLR start "entryRulePrimary"
    // InternalAssembler.g:784:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalAssembler.g:784:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalAssembler.g:785:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalAssembler.g:791:1: rulePrimary returns [EObject current=null] : ( ( (lv_expressionValue_0_0= ruleExpressionValue ) ) | (otherlv_1= '(' ( (lv_expressionValue_2_0= ruleAddition ) ) otherlv_3= ')' ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressionValue_0_0 = null;

        EObject lv_expressionValue_2_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:797:2: ( ( ( (lv_expressionValue_0_0= ruleExpressionValue ) ) | (otherlv_1= '(' ( (lv_expressionValue_2_0= ruleAddition ) ) otherlv_3= ')' ) ) )
            // InternalAssembler.g:798:2: ( ( (lv_expressionValue_0_0= ruleExpressionValue ) ) | (otherlv_1= '(' ( (lv_expressionValue_2_0= ruleAddition ) ) otherlv_3= ')' ) )
            {
            // InternalAssembler.g:798:2: ( ( (lv_expressionValue_0_0= ruleExpressionValue ) ) | (otherlv_1= '(' ( (lv_expressionValue_2_0= ruleAddition ) ) otherlv_3= ')' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_LABEL && LA13_0<=RULE_ASCII)||LA13_0==15||LA13_0==17) ) {
                alt13=1;
            }
            else if ( (LA13_0==18) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalAssembler.g:799:3: ( (lv_expressionValue_0_0= ruleExpressionValue ) )
                    {
                    // InternalAssembler.g:799:3: ( (lv_expressionValue_0_0= ruleExpressionValue ) )
                    // InternalAssembler.g:800:4: (lv_expressionValue_0_0= ruleExpressionValue )
                    {
                    // InternalAssembler.g:800:4: (lv_expressionValue_0_0= ruleExpressionValue )
                    // InternalAssembler.g:801:5: lv_expressionValue_0_0= ruleExpressionValue
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionValueExpressionValueParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_expressionValue_0_0=ruleExpressionValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                    					}
                    					set(
                    						current,
                    						"expressionValue",
                    						lv_expressionValue_0_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.ExpressionValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:819:3: (otherlv_1= '(' ( (lv_expressionValue_2_0= ruleAddition ) ) otherlv_3= ')' )
                    {
                    // InternalAssembler.g:819:3: (otherlv_1= '(' ( (lv_expressionValue_2_0= ruleAddition ) ) otherlv_3= ')' )
                    // InternalAssembler.g:820:4: otherlv_1= '(' ( (lv_expressionValue_2_0= ruleAddition ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalAssembler.g:824:4: ( (lv_expressionValue_2_0= ruleAddition ) )
                    // InternalAssembler.g:825:5: (lv_expressionValue_2_0= ruleAddition )
                    {
                    // InternalAssembler.g:825:5: (lv_expressionValue_2_0= ruleAddition )
                    // InternalAssembler.g:826:6: lv_expressionValue_2_0= ruleAddition
                    {

                    						newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionValueAdditionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_expressionValue_2_0=ruleAddition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                    						}
                    						set(
                    							current,
                    							"expressionValue",
                    							lv_expressionValue_2_0,
                    							"org.bpy.electronics.mc6809.assembler.Assembler.Addition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_1_2());
                    			

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


    // $ANTLR start "entryRuleExpressionValue"
    // InternalAssembler.g:852:1: entryRuleExpressionValue returns [EObject current=null] : iv_ruleExpressionValue= ruleExpressionValue EOF ;
    public final EObject entryRuleExpressionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionValue = null;


        try {
            // InternalAssembler.g:852:56: (iv_ruleExpressionValue= ruleExpressionValue EOF )
            // InternalAssembler.g:853:2: iv_ruleExpressionValue= ruleExpressionValue EOF
            {
             newCompositeNode(grammarAccess.getExpressionValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionValue=ruleExpressionValue();

            state._fsp--;

             current =iv_ruleExpressionValue; 
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
    // $ANTLR end "entryRuleExpressionValue"


    // $ANTLR start "ruleExpressionValue"
    // InternalAssembler.g:859:1: ruleExpressionValue returns [EObject current=null] : ( ( (lv_expressionValue_0_0= ruleBinaryeValue ) ) | ( (lv_expressionValue_1_0= ruleOctalValue ) ) | ( (lv_expressionValue_2_0= ruleDecimelValue ) ) | ( (lv_expressionValue_3_0= ruleHexadecimalValue ) ) | ( (lv_expressionValue_4_0= ruleLabelValue ) ) | ( (lv_expressionValue_5_0= ruleAsciiValue ) ) | ( (lv_expressionValue_6_0= ruleActualPosition ) ) ) ;
    public final EObject ruleExpressionValue() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionValue_0_0 = null;

        EObject lv_expressionValue_1_0 = null;

        EObject lv_expressionValue_2_0 = null;

        EObject lv_expressionValue_3_0 = null;

        EObject lv_expressionValue_4_0 = null;

        EObject lv_expressionValue_5_0 = null;

        EObject lv_expressionValue_6_0 = null;



        	enterRule();

        try {
            // InternalAssembler.g:865:2: ( ( ( (lv_expressionValue_0_0= ruleBinaryeValue ) ) | ( (lv_expressionValue_1_0= ruleOctalValue ) ) | ( (lv_expressionValue_2_0= ruleDecimelValue ) ) | ( (lv_expressionValue_3_0= ruleHexadecimalValue ) ) | ( (lv_expressionValue_4_0= ruleLabelValue ) ) | ( (lv_expressionValue_5_0= ruleAsciiValue ) ) | ( (lv_expressionValue_6_0= ruleActualPosition ) ) ) )
            // InternalAssembler.g:866:2: ( ( (lv_expressionValue_0_0= ruleBinaryeValue ) ) | ( (lv_expressionValue_1_0= ruleOctalValue ) ) | ( (lv_expressionValue_2_0= ruleDecimelValue ) ) | ( (lv_expressionValue_3_0= ruleHexadecimalValue ) ) | ( (lv_expressionValue_4_0= ruleLabelValue ) ) | ( (lv_expressionValue_5_0= ruleAsciiValue ) ) | ( (lv_expressionValue_6_0= ruleActualPosition ) ) )
            {
            // InternalAssembler.g:866:2: ( ( (lv_expressionValue_0_0= ruleBinaryeValue ) ) | ( (lv_expressionValue_1_0= ruleOctalValue ) ) | ( (lv_expressionValue_2_0= ruleDecimelValue ) ) | ( (lv_expressionValue_3_0= ruleHexadecimalValue ) ) | ( (lv_expressionValue_4_0= ruleLabelValue ) ) | ( (lv_expressionValue_5_0= ruleAsciiValue ) ) | ( (lv_expressionValue_6_0= ruleActualPosition ) ) )
            int alt14=7;
            switch ( input.LA(1) ) {
            case 17:
                {
                switch ( input.LA(2) ) {
                case RULE_HEXADECIMAL:
                    {
                    alt14=4;
                    }
                    break;
                case RULE_OCTAL:
                    {
                    alt14=2;
                    }
                    break;
                case RULE_DECIMAL:
                    {
                    alt14=3;
                    }
                    break;
                case RULE_BINARY:
                    {
                    alt14=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_BINARY:
                {
                alt14=1;
                }
                break;
            case RULE_OCTAL:
                {
                alt14=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt14=3;
                }
                break;
            case RULE_HEXADECIMAL:
                {
                alt14=4;
                }
                break;
            case RULE_LABEL:
                {
                alt14=5;
                }
                break;
            case RULE_ASCII:
                {
                alt14=6;
                }
                break;
            case 15:
                {
                alt14=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalAssembler.g:867:3: ( (lv_expressionValue_0_0= ruleBinaryeValue ) )
                    {
                    // InternalAssembler.g:867:3: ( (lv_expressionValue_0_0= ruleBinaryeValue ) )
                    // InternalAssembler.g:868:4: (lv_expressionValue_0_0= ruleBinaryeValue )
                    {
                    // InternalAssembler.g:868:4: (lv_expressionValue_0_0= ruleBinaryeValue )
                    // InternalAssembler.g:869:5: lv_expressionValue_0_0= ruleBinaryeValue
                    {

                    					newCompositeNode(grammarAccess.getExpressionValueAccess().getExpressionValueBinaryeValueParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_expressionValue_0_0=ruleBinaryeValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionValueRule());
                    					}
                    					set(
                    						current,
                    						"expressionValue",
                    						lv_expressionValue_0_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.BinaryeValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:887:3: ( (lv_expressionValue_1_0= ruleOctalValue ) )
                    {
                    // InternalAssembler.g:887:3: ( (lv_expressionValue_1_0= ruleOctalValue ) )
                    // InternalAssembler.g:888:4: (lv_expressionValue_1_0= ruleOctalValue )
                    {
                    // InternalAssembler.g:888:4: (lv_expressionValue_1_0= ruleOctalValue )
                    // InternalAssembler.g:889:5: lv_expressionValue_1_0= ruleOctalValue
                    {

                    					newCompositeNode(grammarAccess.getExpressionValueAccess().getExpressionValueOctalValueParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_expressionValue_1_0=ruleOctalValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionValueRule());
                    					}
                    					set(
                    						current,
                    						"expressionValue",
                    						lv_expressionValue_1_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.OctalValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:907:3: ( (lv_expressionValue_2_0= ruleDecimelValue ) )
                    {
                    // InternalAssembler.g:907:3: ( (lv_expressionValue_2_0= ruleDecimelValue ) )
                    // InternalAssembler.g:908:4: (lv_expressionValue_2_0= ruleDecimelValue )
                    {
                    // InternalAssembler.g:908:4: (lv_expressionValue_2_0= ruleDecimelValue )
                    // InternalAssembler.g:909:5: lv_expressionValue_2_0= ruleDecimelValue
                    {

                    					newCompositeNode(grammarAccess.getExpressionValueAccess().getExpressionValueDecimelValueParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_expressionValue_2_0=ruleDecimelValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionValueRule());
                    					}
                    					set(
                    						current,
                    						"expressionValue",
                    						lv_expressionValue_2_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.DecimelValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:927:3: ( (lv_expressionValue_3_0= ruleHexadecimalValue ) )
                    {
                    // InternalAssembler.g:927:3: ( (lv_expressionValue_3_0= ruleHexadecimalValue ) )
                    // InternalAssembler.g:928:4: (lv_expressionValue_3_0= ruleHexadecimalValue )
                    {
                    // InternalAssembler.g:928:4: (lv_expressionValue_3_0= ruleHexadecimalValue )
                    // InternalAssembler.g:929:5: lv_expressionValue_3_0= ruleHexadecimalValue
                    {

                    					newCompositeNode(grammarAccess.getExpressionValueAccess().getExpressionValueHexadecimalValueParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_expressionValue_3_0=ruleHexadecimalValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionValueRule());
                    					}
                    					set(
                    						current,
                    						"expressionValue",
                    						lv_expressionValue_3_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.HexadecimalValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:947:3: ( (lv_expressionValue_4_0= ruleLabelValue ) )
                    {
                    // InternalAssembler.g:947:3: ( (lv_expressionValue_4_0= ruleLabelValue ) )
                    // InternalAssembler.g:948:4: (lv_expressionValue_4_0= ruleLabelValue )
                    {
                    // InternalAssembler.g:948:4: (lv_expressionValue_4_0= ruleLabelValue )
                    // InternalAssembler.g:949:5: lv_expressionValue_4_0= ruleLabelValue
                    {

                    					newCompositeNode(grammarAccess.getExpressionValueAccess().getExpressionValueLabelValueParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_expressionValue_4_0=ruleLabelValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionValueRule());
                    					}
                    					set(
                    						current,
                    						"expressionValue",
                    						lv_expressionValue_4_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.LabelValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:967:3: ( (lv_expressionValue_5_0= ruleAsciiValue ) )
                    {
                    // InternalAssembler.g:967:3: ( (lv_expressionValue_5_0= ruleAsciiValue ) )
                    // InternalAssembler.g:968:4: (lv_expressionValue_5_0= ruleAsciiValue )
                    {
                    // InternalAssembler.g:968:4: (lv_expressionValue_5_0= ruleAsciiValue )
                    // InternalAssembler.g:969:5: lv_expressionValue_5_0= ruleAsciiValue
                    {

                    					newCompositeNode(grammarAccess.getExpressionValueAccess().getExpressionValueAsciiValueParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_expressionValue_5_0=ruleAsciiValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionValueRule());
                    					}
                    					set(
                    						current,
                    						"expressionValue",
                    						lv_expressionValue_5_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.AsciiValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:987:3: ( (lv_expressionValue_6_0= ruleActualPosition ) )
                    {
                    // InternalAssembler.g:987:3: ( (lv_expressionValue_6_0= ruleActualPosition ) )
                    // InternalAssembler.g:988:4: (lv_expressionValue_6_0= ruleActualPosition )
                    {
                    // InternalAssembler.g:988:4: (lv_expressionValue_6_0= ruleActualPosition )
                    // InternalAssembler.g:989:5: lv_expressionValue_6_0= ruleActualPosition
                    {

                    					newCompositeNode(grammarAccess.getExpressionValueAccess().getExpressionValueActualPositionParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_expressionValue_6_0=ruleActualPosition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpressionValueRule());
                    					}
                    					set(
                    						current,
                    						"expressionValue",
                    						lv_expressionValue_6_0,
                    						"org.bpy.electronics.mc6809.assembler.Assembler.ActualPosition");
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
    // $ANTLR end "ruleExpressionValue"


    // $ANTLR start "entryRuleActualPosition"
    // InternalAssembler.g:1010:1: entryRuleActualPosition returns [EObject current=null] : iv_ruleActualPosition= ruleActualPosition EOF ;
    public final EObject entryRuleActualPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualPosition = null;


        try {
            // InternalAssembler.g:1010:55: (iv_ruleActualPosition= ruleActualPosition EOF )
            // InternalAssembler.g:1011:2: iv_ruleActualPosition= ruleActualPosition EOF
            {
             newCompositeNode(grammarAccess.getActualPositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActualPosition=ruleActualPosition();

            state._fsp--;

             current =iv_ruleActualPosition; 
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
    // $ANTLR end "entryRuleActualPosition"


    // $ANTLR start "ruleActualPosition"
    // InternalAssembler.g:1017:1: ruleActualPosition returns [EObject current=null] : ( (lv_actualPosition_0_0= '*' ) ) ;
    public final EObject ruleActualPosition() throws RecognitionException {
        EObject current = null;

        Token lv_actualPosition_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1023:2: ( ( (lv_actualPosition_0_0= '*' ) ) )
            // InternalAssembler.g:1024:2: ( (lv_actualPosition_0_0= '*' ) )
            {
            // InternalAssembler.g:1024:2: ( (lv_actualPosition_0_0= '*' ) )
            // InternalAssembler.g:1025:3: (lv_actualPosition_0_0= '*' )
            {
            // InternalAssembler.g:1025:3: (lv_actualPosition_0_0= '*' )
            // InternalAssembler.g:1026:4: lv_actualPosition_0_0= '*'
            {
            lv_actualPosition_0_0=(Token)match(input,15,FOLLOW_2); 

            				newLeafNode(lv_actualPosition_0_0, grammarAccess.getActualPositionAccess().getActualPositionAsteriskKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getActualPositionRule());
            				}
            				setWithLastConsumed(current, "actualPosition", lv_actualPosition_0_0, "*");
            			

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
    // $ANTLR end "ruleActualPosition"


    // $ANTLR start "entryRuleBinaryeValue"
    // InternalAssembler.g:1041:1: entryRuleBinaryeValue returns [EObject current=null] : iv_ruleBinaryeValue= ruleBinaryeValue EOF ;
    public final EObject entryRuleBinaryeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryeValue = null;


        try {
            // InternalAssembler.g:1041:53: (iv_ruleBinaryeValue= ruleBinaryeValue EOF )
            // InternalAssembler.g:1042:2: iv_ruleBinaryeValue= ruleBinaryeValue EOF
            {
             newCompositeNode(grammarAccess.getBinaryeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryeValue=ruleBinaryeValue();

            state._fsp--;

             current =iv_ruleBinaryeValue; 
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
    // $ANTLR end "entryRuleBinaryeValue"


    // $ANTLR start "ruleBinaryeValue"
    // InternalAssembler.g:1048:1: ruleBinaryeValue returns [EObject current=null] : ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_binaryValue_1_0= RULE_BINARY ) ) ) ;
    public final EObject ruleBinaryeValue() throws RecognitionException {
        EObject current = null;

        Token lv_isNegative_0_0=null;
        Token lv_binaryValue_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1054:2: ( ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_binaryValue_1_0= RULE_BINARY ) ) ) )
            // InternalAssembler.g:1055:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_binaryValue_1_0= RULE_BINARY ) ) )
            {
            // InternalAssembler.g:1055:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_binaryValue_1_0= RULE_BINARY ) ) )
            // InternalAssembler.g:1056:3: ( (lv_isNegative_0_0= '-' ) )? ( (lv_binaryValue_1_0= RULE_BINARY ) )
            {
            // InternalAssembler.g:1056:3: ( (lv_isNegative_0_0= '-' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAssembler.g:1057:4: (lv_isNegative_0_0= '-' )
                    {
                    // InternalAssembler.g:1057:4: (lv_isNegative_0_0= '-' )
                    // InternalAssembler.g:1058:5: lv_isNegative_0_0= '-'
                    {
                    lv_isNegative_0_0=(Token)match(input,17,FOLLOW_16); 

                    					newLeafNode(lv_isNegative_0_0, grammarAccess.getBinaryeValueAccess().getIsNegativeHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBinaryeValueRule());
                    					}
                    					setWithLastConsumed(current, "isNegative", lv_isNegative_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalAssembler.g:1070:3: ( (lv_binaryValue_1_0= RULE_BINARY ) )
            // InternalAssembler.g:1071:4: (lv_binaryValue_1_0= RULE_BINARY )
            {
            // InternalAssembler.g:1071:4: (lv_binaryValue_1_0= RULE_BINARY )
            // InternalAssembler.g:1072:5: lv_binaryValue_1_0= RULE_BINARY
            {
            lv_binaryValue_1_0=(Token)match(input,RULE_BINARY,FOLLOW_2); 

            					newLeafNode(lv_binaryValue_1_0, grammarAccess.getBinaryeValueAccess().getBinaryValueBINARYTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinaryeValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"binaryValue",
            						lv_binaryValue_1_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.BINARY");
            				

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
    // $ANTLR end "ruleBinaryeValue"


    // $ANTLR start "entryRuleOctalValue"
    // InternalAssembler.g:1092:1: entryRuleOctalValue returns [EObject current=null] : iv_ruleOctalValue= ruleOctalValue EOF ;
    public final EObject entryRuleOctalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOctalValue = null;


        try {
            // InternalAssembler.g:1092:51: (iv_ruleOctalValue= ruleOctalValue EOF )
            // InternalAssembler.g:1093:2: iv_ruleOctalValue= ruleOctalValue EOF
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
    // InternalAssembler.g:1099:1: ruleOctalValue returns [EObject current=null] : ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_octalValue_1_0= RULE_OCTAL ) ) ) ;
    public final EObject ruleOctalValue() throws RecognitionException {
        EObject current = null;

        Token lv_isNegative_0_0=null;
        Token lv_octalValue_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1105:2: ( ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_octalValue_1_0= RULE_OCTAL ) ) ) )
            // InternalAssembler.g:1106:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_octalValue_1_0= RULE_OCTAL ) ) )
            {
            // InternalAssembler.g:1106:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_octalValue_1_0= RULE_OCTAL ) ) )
            // InternalAssembler.g:1107:3: ( (lv_isNegative_0_0= '-' ) )? ( (lv_octalValue_1_0= RULE_OCTAL ) )
            {
            // InternalAssembler.g:1107:3: ( (lv_isNegative_0_0= '-' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAssembler.g:1108:4: (lv_isNegative_0_0= '-' )
                    {
                    // InternalAssembler.g:1108:4: (lv_isNegative_0_0= '-' )
                    // InternalAssembler.g:1109:5: lv_isNegative_0_0= '-'
                    {
                    lv_isNegative_0_0=(Token)match(input,17,FOLLOW_17); 

                    					newLeafNode(lv_isNegative_0_0, grammarAccess.getOctalValueAccess().getIsNegativeHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOctalValueRule());
                    					}
                    					setWithLastConsumed(current, "isNegative", lv_isNegative_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalAssembler.g:1121:3: ( (lv_octalValue_1_0= RULE_OCTAL ) )
            // InternalAssembler.g:1122:4: (lv_octalValue_1_0= RULE_OCTAL )
            {
            // InternalAssembler.g:1122:4: (lv_octalValue_1_0= RULE_OCTAL )
            // InternalAssembler.g:1123:5: lv_octalValue_1_0= RULE_OCTAL
            {
            lv_octalValue_1_0=(Token)match(input,RULE_OCTAL,FOLLOW_2); 

            					newLeafNode(lv_octalValue_1_0, grammarAccess.getOctalValueAccess().getOctalValueOCTALTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOctalValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"octalValue",
            						lv_octalValue_1_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.OCTAL");
            				

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
    // $ANTLR end "ruleOctalValue"


    // $ANTLR start "entryRuleDecimelValue"
    // InternalAssembler.g:1143:1: entryRuleDecimelValue returns [EObject current=null] : iv_ruleDecimelValue= ruleDecimelValue EOF ;
    public final EObject entryRuleDecimelValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimelValue = null;


        try {
            // InternalAssembler.g:1143:53: (iv_ruleDecimelValue= ruleDecimelValue EOF )
            // InternalAssembler.g:1144:2: iv_ruleDecimelValue= ruleDecimelValue EOF
            {
             newCompositeNode(grammarAccess.getDecimelValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimelValue=ruleDecimelValue();

            state._fsp--;

             current =iv_ruleDecimelValue; 
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
    // $ANTLR end "entryRuleDecimelValue"


    // $ANTLR start "ruleDecimelValue"
    // InternalAssembler.g:1150:1: ruleDecimelValue returns [EObject current=null] : ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_decimalValue_1_0= RULE_DECIMAL ) ) ) ;
    public final EObject ruleDecimelValue() throws RecognitionException {
        EObject current = null;

        Token lv_isNegative_0_0=null;
        Token lv_decimalValue_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1156:2: ( ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_decimalValue_1_0= RULE_DECIMAL ) ) ) )
            // InternalAssembler.g:1157:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_decimalValue_1_0= RULE_DECIMAL ) ) )
            {
            // InternalAssembler.g:1157:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_decimalValue_1_0= RULE_DECIMAL ) ) )
            // InternalAssembler.g:1158:3: ( (lv_isNegative_0_0= '-' ) )? ( (lv_decimalValue_1_0= RULE_DECIMAL ) )
            {
            // InternalAssembler.g:1158:3: ( (lv_isNegative_0_0= '-' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==17) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAssembler.g:1159:4: (lv_isNegative_0_0= '-' )
                    {
                    // InternalAssembler.g:1159:4: (lv_isNegative_0_0= '-' )
                    // InternalAssembler.g:1160:5: lv_isNegative_0_0= '-'
                    {
                    lv_isNegative_0_0=(Token)match(input,17,FOLLOW_18); 

                    					newLeafNode(lv_isNegative_0_0, grammarAccess.getDecimelValueAccess().getIsNegativeHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDecimelValueRule());
                    					}
                    					setWithLastConsumed(current, "isNegative", lv_isNegative_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalAssembler.g:1172:3: ( (lv_decimalValue_1_0= RULE_DECIMAL ) )
            // InternalAssembler.g:1173:4: (lv_decimalValue_1_0= RULE_DECIMAL )
            {
            // InternalAssembler.g:1173:4: (lv_decimalValue_1_0= RULE_DECIMAL )
            // InternalAssembler.g:1174:5: lv_decimalValue_1_0= RULE_DECIMAL
            {
            lv_decimalValue_1_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

            					newLeafNode(lv_decimalValue_1_0, grammarAccess.getDecimelValueAccess().getDecimalValueDECIMALTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDecimelValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"decimalValue",
            						lv_decimalValue_1_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.DECIMAL");
            				

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
    // $ANTLR end "ruleDecimelValue"


    // $ANTLR start "entryRuleHexadecimalValue"
    // InternalAssembler.g:1194:1: entryRuleHexadecimalValue returns [EObject current=null] : iv_ruleHexadecimalValue= ruleHexadecimalValue EOF ;
    public final EObject entryRuleHexadecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexadecimalValue = null;


        try {
            // InternalAssembler.g:1194:57: (iv_ruleHexadecimalValue= ruleHexadecimalValue EOF )
            // InternalAssembler.g:1195:2: iv_ruleHexadecimalValue= ruleHexadecimalValue EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHexadecimalValue=ruleHexadecimalValue();

            state._fsp--;

             current =iv_ruleHexadecimalValue; 
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
    // $ANTLR end "entryRuleHexadecimalValue"


    // $ANTLR start "ruleHexadecimalValue"
    // InternalAssembler.g:1201:1: ruleHexadecimalValue returns [EObject current=null] : ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL ) ) ) ;
    public final EObject ruleHexadecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_isNegative_0_0=null;
        Token lv_hexadeciamlValue_1_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1207:2: ( ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL ) ) ) )
            // InternalAssembler.g:1208:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL ) ) )
            {
            // InternalAssembler.g:1208:2: ( ( (lv_isNegative_0_0= '-' ) )? ( (lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL ) ) )
            // InternalAssembler.g:1209:3: ( (lv_isNegative_0_0= '-' ) )? ( (lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL ) )
            {
            // InternalAssembler.g:1209:3: ( (lv_isNegative_0_0= '-' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAssembler.g:1210:4: (lv_isNegative_0_0= '-' )
                    {
                    // InternalAssembler.g:1210:4: (lv_isNegative_0_0= '-' )
                    // InternalAssembler.g:1211:5: lv_isNegative_0_0= '-'
                    {
                    lv_isNegative_0_0=(Token)match(input,17,FOLLOW_19); 

                    					newLeafNode(lv_isNegative_0_0, grammarAccess.getHexadecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHexadecimalValueRule());
                    					}
                    					setWithLastConsumed(current, "isNegative", lv_isNegative_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalAssembler.g:1223:3: ( (lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL ) )
            // InternalAssembler.g:1224:4: (lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL )
            {
            // InternalAssembler.g:1224:4: (lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL )
            // InternalAssembler.g:1225:5: lv_hexadeciamlValue_1_0= RULE_HEXADECIMAL
            {
            lv_hexadeciamlValue_1_0=(Token)match(input,RULE_HEXADECIMAL,FOLLOW_2); 

            					newLeafNode(lv_hexadeciamlValue_1_0, grammarAccess.getHexadecimalValueAccess().getHexadeciamlValueHEXADECIMALTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHexadecimalValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"hexadeciamlValue",
            						lv_hexadeciamlValue_1_0,
            						"org.bpy.electronics.mc6809.assembler.Assembler.HEXADECIMAL");
            				

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
    // $ANTLR end "ruleHexadecimalValue"


    // $ANTLR start "entryRuleAsciiValue"
    // InternalAssembler.g:1245:1: entryRuleAsciiValue returns [EObject current=null] : iv_ruleAsciiValue= ruleAsciiValue EOF ;
    public final EObject entryRuleAsciiValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsciiValue = null;


        try {
            // InternalAssembler.g:1245:51: (iv_ruleAsciiValue= ruleAsciiValue EOF )
            // InternalAssembler.g:1246:2: iv_ruleAsciiValue= ruleAsciiValue EOF
            {
             newCompositeNode(grammarAccess.getAsciiValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAsciiValue=ruleAsciiValue();

            state._fsp--;

             current =iv_ruleAsciiValue; 
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
    // $ANTLR end "entryRuleAsciiValue"


    // $ANTLR start "ruleAsciiValue"
    // InternalAssembler.g:1252:1: ruleAsciiValue returns [EObject current=null] : ( (lv_asciiValue_0_0= RULE_ASCII ) ) ;
    public final EObject ruleAsciiValue() throws RecognitionException {
        EObject current = null;

        Token lv_asciiValue_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1258:2: ( ( (lv_asciiValue_0_0= RULE_ASCII ) ) )
            // InternalAssembler.g:1259:2: ( (lv_asciiValue_0_0= RULE_ASCII ) )
            {
            // InternalAssembler.g:1259:2: ( (lv_asciiValue_0_0= RULE_ASCII ) )
            // InternalAssembler.g:1260:3: (lv_asciiValue_0_0= RULE_ASCII )
            {
            // InternalAssembler.g:1260:3: (lv_asciiValue_0_0= RULE_ASCII )
            // InternalAssembler.g:1261:4: lv_asciiValue_0_0= RULE_ASCII
            {
            lv_asciiValue_0_0=(Token)match(input,RULE_ASCII,FOLLOW_2); 

            				newLeafNode(lv_asciiValue_0_0, grammarAccess.getAsciiValueAccess().getAsciiValueASCIITerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getAsciiValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"asciiValue",
            					lv_asciiValue_0_0,
            					"org.bpy.electronics.mc6809.assembler.Assembler.ASCII");
            			

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
    // $ANTLR end "ruleAsciiValue"


    // $ANTLR start "entryRuleLabelValue"
    // InternalAssembler.g:1280:1: entryRuleLabelValue returns [EObject current=null] : iv_ruleLabelValue= ruleLabelValue EOF ;
    public final EObject entryRuleLabelValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabelValue = null;


        try {
            // InternalAssembler.g:1280:51: (iv_ruleLabelValue= ruleLabelValue EOF )
            // InternalAssembler.g:1281:2: iv_ruleLabelValue= ruleLabelValue EOF
            {
             newCompositeNode(grammarAccess.getLabelValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLabelValue=ruleLabelValue();

            state._fsp--;

             current =iv_ruleLabelValue; 
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
    // $ANTLR end "entryRuleLabelValue"


    // $ANTLR start "ruleLabelValue"
    // InternalAssembler.g:1287:1: ruleLabelValue returns [EObject current=null] : ( (lv_label_0_0= RULE_LABEL ) ) ;
    public final EObject ruleLabelValue() throws RecognitionException {
        EObject current = null;

        Token lv_label_0_0=null;


        	enterRule();

        try {
            // InternalAssembler.g:1293:2: ( ( (lv_label_0_0= RULE_LABEL ) ) )
            // InternalAssembler.g:1294:2: ( (lv_label_0_0= RULE_LABEL ) )
            {
            // InternalAssembler.g:1294:2: ( (lv_label_0_0= RULE_LABEL ) )
            // InternalAssembler.g:1295:3: (lv_label_0_0= RULE_LABEL )
            {
            // InternalAssembler.g:1295:3: (lv_label_0_0= RULE_LABEL )
            // InternalAssembler.g:1296:4: lv_label_0_0= RULE_LABEL
            {
            lv_label_0_0=(Token)match(input,RULE_LABEL,FOLLOW_2); 

            				newLeafNode(lv_label_0_0, grammarAccess.getLabelValueAccess().getLabelLABELTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getLabelValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"label",
            					lv_label_0_0,
            					"org.bpy.electronics.mc6809.assembler.Assembler.LABEL");
            			

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
    // $ANTLR end "ruleLabelValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000000F2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000069F80L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000800L});

}
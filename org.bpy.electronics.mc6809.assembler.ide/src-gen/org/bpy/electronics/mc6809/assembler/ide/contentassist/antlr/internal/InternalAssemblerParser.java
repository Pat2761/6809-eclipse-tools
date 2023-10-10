package org.bpy.electronics.mc6809.assembler.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.bpy.electronics.mc6809.assembler.services.AssemblerGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalAssemblerParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CR", "RULE_END_OF_FILE", "RULE_WS", "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEXA", "RULE_OCTAL", "RULE_BINARY", "RULE_CHARACTER", "'+'", "'-'", "'<<'", "'>>'", "'~'", "'&&'", "'||'", "'^'", "'('", "')'", "'EQU'", "'*'", "'/'", "'%'"
    };
    public static final int RULE_ANY_EXCEPT_COMMENT_END_OF_LINE=7;
    public static final int RULE_CHARACTER=14;
    public static final int RULE_CR=4;
    public static final int RULE_STRING=9;
    public static final int T__19=19;
    public static final int RULE_OCTAL=12;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_END_OF_FILE=5;
    public static final int EOF=-1;
    public static final int RULE_ID=8;
    public static final int RULE_WS=6;
    public static final int RULE_HEXA=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=10;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int RULE_BINARY=13;
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

    	public void setGrammarAccess(AssemblerGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalAssembler.g:54:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalAssembler.g:55:1: ( ruleModel EOF )
            // InternalAssembler.g:56:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalAssembler.g:63:1: ruleModel : ( ( rule__Model__SourceLinesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:67:2: ( ( ( rule__Model__SourceLinesAssignment )* ) )
            // InternalAssembler.g:68:2: ( ( rule__Model__SourceLinesAssignment )* )
            {
            // InternalAssembler.g:68:2: ( ( rule__Model__SourceLinesAssignment )* )
            // InternalAssembler.g:69:3: ( rule__Model__SourceLinesAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSourceLinesAssignment()); 
            }
            // InternalAssembler.g:70:3: ( rule__Model__SourceLinesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_CR && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAssembler.g:70:4: rule__Model__SourceLinesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__SourceLinesAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSourceLinesAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSourceLine"
    // InternalAssembler.g:79:1: entryRuleSourceLine : ruleSourceLine EOF ;
    public final void entryRuleSourceLine() throws RecognitionException {
        try {
            // InternalAssembler.g:80:1: ( ruleSourceLine EOF )
            // InternalAssembler.g:81:1: ruleSourceLine EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSourceLineRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSourceLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSourceLineRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSourceLine"


    // $ANTLR start "ruleSourceLine"
    // InternalAssembler.g:88:1: ruleSourceLine : ( ( rule__SourceLine__Alternatives ) ) ;
    public final void ruleSourceLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:92:2: ( ( ( rule__SourceLine__Alternatives ) ) )
            // InternalAssembler.g:93:2: ( ( rule__SourceLine__Alternatives ) )
            {
            // InternalAssembler.g:93:2: ( ( rule__SourceLine__Alternatives ) )
            // InternalAssembler.g:94:3: ( rule__SourceLine__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSourceLineAccess().getAlternatives()); 
            }
            // InternalAssembler.g:95:3: ( rule__SourceLine__Alternatives )
            // InternalAssembler.g:95:4: rule__SourceLine__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SourceLine__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSourceLineAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSourceLine"


    // $ANTLR start "entryRuleBlankLine"
    // InternalAssembler.g:104:1: entryRuleBlankLine : ruleBlankLine EOF ;
    public final void entryRuleBlankLine() throws RecognitionException {
        try {
            // InternalAssembler.g:105:1: ( ruleBlankLine EOF )
            // InternalAssembler.g:106:1: ruleBlankLine EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankLineRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBlankLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankLineRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBlankLine"


    // $ANTLR start "ruleBlankLine"
    // InternalAssembler.g:113:1: ruleBlankLine : ( ( rule__BlankLine__Group__0 ) ) ;
    public final void ruleBlankLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:117:2: ( ( ( rule__BlankLine__Group__0 ) ) )
            // InternalAssembler.g:118:2: ( ( rule__BlankLine__Group__0 ) )
            {
            // InternalAssembler.g:118:2: ( ( rule__BlankLine__Group__0 ) )
            // InternalAssembler.g:119:3: ( rule__BlankLine__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankLineAccess().getGroup()); 
            }
            // InternalAssembler.g:120:3: ( rule__BlankLine__Group__0 )
            // InternalAssembler.g:120:4: rule__BlankLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BlankLine__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankLineAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlankLine"


    // $ANTLR start "entryRuleCommentLine"
    // InternalAssembler.g:129:1: entryRuleCommentLine : ruleCommentLine EOF ;
    public final void entryRuleCommentLine() throws RecognitionException {
        try {
            // InternalAssembler.g:130:1: ( ruleCommentLine EOF )
            // InternalAssembler.g:131:1: ruleCommentLine EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommentLineRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCommentLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommentLineRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCommentLine"


    // $ANTLR start "ruleCommentLine"
    // InternalAssembler.g:138:1: ruleCommentLine : ( ( rule__CommentLine__Group__0 ) ) ;
    public final void ruleCommentLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:142:2: ( ( ( rule__CommentLine__Group__0 ) ) )
            // InternalAssembler.g:143:2: ( ( rule__CommentLine__Group__0 ) )
            {
            // InternalAssembler.g:143:2: ( ( rule__CommentLine__Group__0 ) )
            // InternalAssembler.g:144:3: ( rule__CommentLine__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommentLineAccess().getGroup()); 
            }
            // InternalAssembler.g:145:3: ( rule__CommentLine__Group__0 )
            // InternalAssembler.g:145:4: rule__CommentLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CommentLine__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommentLineAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCommentLine"


    // $ANTLR start "entryRuleDirectiveLine"
    // InternalAssembler.g:154:1: entryRuleDirectiveLine : ruleDirectiveLine EOF ;
    public final void entryRuleDirectiveLine() throws RecognitionException {
        try {
            // InternalAssembler.g:155:1: ( ruleDirectiveLine EOF )
            // InternalAssembler.g:156:1: ruleDirectiveLine EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDirectiveLineRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDirectiveLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDirectiveLineRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDirectiveLine"


    // $ANTLR start "ruleDirectiveLine"
    // InternalAssembler.g:163:1: ruleDirectiveLine : ( ( rule__DirectiveLine__DirectiveAssignment ) ) ;
    public final void ruleDirectiveLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:167:2: ( ( ( rule__DirectiveLine__DirectiveAssignment ) ) )
            // InternalAssembler.g:168:2: ( ( rule__DirectiveLine__DirectiveAssignment ) )
            {
            // InternalAssembler.g:168:2: ( ( rule__DirectiveLine__DirectiveAssignment ) )
            // InternalAssembler.g:169:3: ( rule__DirectiveLine__DirectiveAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDirectiveLineAccess().getDirectiveAssignment()); 
            }
            // InternalAssembler.g:170:3: ( rule__DirectiveLine__DirectiveAssignment )
            // InternalAssembler.g:170:4: rule__DirectiveLine__DirectiveAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DirectiveLine__DirectiveAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDirectiveLineAccess().getDirectiveAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDirectiveLine"


    // $ANTLR start "entryRuleEquDirective"
    // InternalAssembler.g:179:1: entryRuleEquDirective : ruleEquDirective EOF ;
    public final void entryRuleEquDirective() throws RecognitionException {
        try {
            // InternalAssembler.g:180:1: ( ruleEquDirective EOF )
            // InternalAssembler.g:181:1: ruleEquDirective EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEquDirective();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEquDirective"


    // $ANTLR start "ruleEquDirective"
    // InternalAssembler.g:188:1: ruleEquDirective : ( ( rule__EquDirective__Group__0 ) ) ;
    public final void ruleEquDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:192:2: ( ( ( rule__EquDirective__Group__0 ) ) )
            // InternalAssembler.g:193:2: ( ( rule__EquDirective__Group__0 ) )
            {
            // InternalAssembler.g:193:2: ( ( rule__EquDirective__Group__0 ) )
            // InternalAssembler.g:194:3: ( rule__EquDirective__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getGroup()); 
            }
            // InternalAssembler.g:195:3: ( rule__EquDirective__Group__0 )
            // InternalAssembler.g:195:4: rule__EquDirective__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquDirective"


    // $ANTLR start "entryRuleOperand"
    // InternalAssembler.g:204:1: entryRuleOperand : ruleOperand EOF ;
    public final void entryRuleOperand() throws RecognitionException {
        try {
            // InternalAssembler.g:205:1: ( ruleOperand EOF )
            // InternalAssembler.g:206:1: ruleOperand EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperandRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOperand();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperandRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperand"


    // $ANTLR start "ruleOperand"
    // InternalAssembler.g:213:1: ruleOperand : ( ( rule__Operand__Alternatives ) ) ;
    public final void ruleOperand() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:217:2: ( ( ( rule__Operand__Alternatives ) ) )
            // InternalAssembler.g:218:2: ( ( rule__Operand__Alternatives ) )
            {
            // InternalAssembler.g:218:2: ( ( rule__Operand__Alternatives ) )
            // InternalAssembler.g:219:3: ( rule__Operand__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperandAccess().getAlternatives()); 
            }
            // InternalAssembler.g:220:3: ( rule__Operand__Alternatives )
            // InternalAssembler.g:220:4: rule__Operand__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Operand__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperandAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperand"


    // $ANTLR start "entryRuleMultiplication"
    // InternalAssembler.g:229:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // InternalAssembler.g:230:1: ( ruleMultiplication EOF )
            // InternalAssembler.g:231:1: ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMultiplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalAssembler.g:238:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:242:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // InternalAssembler.g:243:2: ( ( rule__Multiplication__Group__0 ) )
            {
            // InternalAssembler.g:243:2: ( ( rule__Multiplication__Group__0 ) )
            // InternalAssembler.g:244:3: ( rule__Multiplication__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup()); 
            }
            // InternalAssembler.g:245:3: ( rule__Multiplication__Group__0 )
            // InternalAssembler.g:245:4: rule__Multiplication__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleDivision"
    // InternalAssembler.g:254:1: entryRuleDivision : ruleDivision EOF ;
    public final void entryRuleDivision() throws RecognitionException {
        try {
            // InternalAssembler.g:255:1: ( ruleDivision EOF )
            // InternalAssembler.g:256:1: ruleDivision EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDivision();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDivision"


    // $ANTLR start "ruleDivision"
    // InternalAssembler.g:263:1: ruleDivision : ( ( rule__Division__Group__0 ) ) ;
    public final void ruleDivision() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:267:2: ( ( ( rule__Division__Group__0 ) ) )
            // InternalAssembler.g:268:2: ( ( rule__Division__Group__0 ) )
            {
            // InternalAssembler.g:268:2: ( ( rule__Division__Group__0 ) )
            // InternalAssembler.g:269:3: ( rule__Division__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getGroup()); 
            }
            // InternalAssembler.g:270:3: ( rule__Division__Group__0 )
            // InternalAssembler.g:270:4: rule__Division__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Division__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDivision"


    // $ANTLR start "entryRuleModulo"
    // InternalAssembler.g:279:1: entryRuleModulo : ruleModulo EOF ;
    public final void entryRuleModulo() throws RecognitionException {
        try {
            // InternalAssembler.g:280:1: ( ruleModulo EOF )
            // InternalAssembler.g:281:1: ruleModulo EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleModulo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModulo"


    // $ANTLR start "ruleModulo"
    // InternalAssembler.g:288:1: ruleModulo : ( ( rule__Modulo__Group__0 ) ) ;
    public final void ruleModulo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:292:2: ( ( ( rule__Modulo__Group__0 ) ) )
            // InternalAssembler.g:293:2: ( ( rule__Modulo__Group__0 ) )
            {
            // InternalAssembler.g:293:2: ( ( rule__Modulo__Group__0 ) )
            // InternalAssembler.g:294:3: ( rule__Modulo__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getGroup()); 
            }
            // InternalAssembler.g:295:3: ( rule__Modulo__Group__0 )
            // InternalAssembler.g:295:4: rule__Modulo__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModulo"


    // $ANTLR start "entryRuleAddition"
    // InternalAssembler.g:304:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // InternalAssembler.g:305:1: ( ruleAddition EOF )
            // InternalAssembler.g:306:1: ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalAssembler.g:313:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:317:2: ( ( ( rule__Addition__Group__0 ) ) )
            // InternalAssembler.g:318:2: ( ( rule__Addition__Group__0 ) )
            {
            // InternalAssembler.g:318:2: ( ( rule__Addition__Group__0 ) )
            // InternalAssembler.g:319:3: ( rule__Addition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getGroup()); 
            }
            // InternalAssembler.g:320:3: ( rule__Addition__Group__0 )
            // InternalAssembler.g:320:4: rule__Addition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleSubstraction"
    // InternalAssembler.g:329:1: entryRuleSubstraction : ruleSubstraction EOF ;
    public final void entryRuleSubstraction() throws RecognitionException {
        try {
            // InternalAssembler.g:330:1: ( ruleSubstraction EOF )
            // InternalAssembler.g:331:1: ruleSubstraction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubstractionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSubstraction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubstractionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubstraction"


    // $ANTLR start "ruleSubstraction"
    // InternalAssembler.g:338:1: ruleSubstraction : ( ( rule__Substraction__Group__0 ) ) ;
    public final void ruleSubstraction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:342:2: ( ( ( rule__Substraction__Group__0 ) ) )
            // InternalAssembler.g:343:2: ( ( rule__Substraction__Group__0 ) )
            {
            // InternalAssembler.g:343:2: ( ( rule__Substraction__Group__0 ) )
            // InternalAssembler.g:344:3: ( rule__Substraction__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubstractionAccess().getGroup()); 
            }
            // InternalAssembler.g:345:3: ( rule__Substraction__Group__0 )
            // InternalAssembler.g:345:4: rule__Substraction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Substraction__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubstractionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubstraction"


    // $ANTLR start "entryRuleLeftShift"
    // InternalAssembler.g:354:1: entryRuleLeftShift : ruleLeftShift EOF ;
    public final void entryRuleLeftShift() throws RecognitionException {
        try {
            // InternalAssembler.g:355:1: ( ruleLeftShift EOF )
            // InternalAssembler.g:356:1: ruleLeftShift EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLeftShiftRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLeftShift();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLeftShiftRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLeftShift"


    // $ANTLR start "ruleLeftShift"
    // InternalAssembler.g:363:1: ruleLeftShift : ( ( rule__LeftShift__Group__0 ) ) ;
    public final void ruleLeftShift() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:367:2: ( ( ( rule__LeftShift__Group__0 ) ) )
            // InternalAssembler.g:368:2: ( ( rule__LeftShift__Group__0 ) )
            {
            // InternalAssembler.g:368:2: ( ( rule__LeftShift__Group__0 ) )
            // InternalAssembler.g:369:3: ( rule__LeftShift__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLeftShiftAccess().getGroup()); 
            }
            // InternalAssembler.g:370:3: ( rule__LeftShift__Group__0 )
            // InternalAssembler.g:370:4: rule__LeftShift__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLeftShiftAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLeftShift"


    // $ANTLR start "entryRuleRigthShift"
    // InternalAssembler.g:379:1: entryRuleRigthShift : ruleRigthShift EOF ;
    public final void entryRuleRigthShift() throws RecognitionException {
        try {
            // InternalAssembler.g:380:1: ( ruleRigthShift EOF )
            // InternalAssembler.g:381:1: ruleRigthShift EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRigthShiftRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRigthShift();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRigthShiftRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRigthShift"


    // $ANTLR start "ruleRigthShift"
    // InternalAssembler.g:388:1: ruleRigthShift : ( ( rule__RigthShift__Group__0 ) ) ;
    public final void ruleRigthShift() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:392:2: ( ( ( rule__RigthShift__Group__0 ) ) )
            // InternalAssembler.g:393:2: ( ( rule__RigthShift__Group__0 ) )
            {
            // InternalAssembler.g:393:2: ( ( rule__RigthShift__Group__0 ) )
            // InternalAssembler.g:394:3: ( rule__RigthShift__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRigthShiftAccess().getGroup()); 
            }
            // InternalAssembler.g:395:3: ( rule__RigthShift__Group__0 )
            // InternalAssembler.g:395:4: rule__RigthShift__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRigthShiftAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRigthShift"


    // $ANTLR start "entryRuleNegate"
    // InternalAssembler.g:404:1: entryRuleNegate : ruleNegate EOF ;
    public final void entryRuleNegate() throws RecognitionException {
        try {
            // InternalAssembler.g:405:1: ( ruleNegate EOF )
            // InternalAssembler.g:406:1: ruleNegate EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNegateRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNegate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNegateRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegate"


    // $ANTLR start "ruleNegate"
    // InternalAssembler.g:413:1: ruleNegate : ( ( rule__Negate__Group__0 ) ) ;
    public final void ruleNegate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:417:2: ( ( ( rule__Negate__Group__0 ) ) )
            // InternalAssembler.g:418:2: ( ( rule__Negate__Group__0 ) )
            {
            // InternalAssembler.g:418:2: ( ( rule__Negate__Group__0 ) )
            // InternalAssembler.g:419:3: ( rule__Negate__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNegateAccess().getGroup()); 
            }
            // InternalAssembler.g:420:3: ( rule__Negate__Group__0 )
            // InternalAssembler.g:420:4: rule__Negate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Negate__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNegateAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegate"


    // $ANTLR start "entryRuleAnd"
    // InternalAssembler.g:429:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalAssembler.g:430:1: ( ruleAnd EOF )
            // InternalAssembler.g:431:1: ruleAnd EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalAssembler.g:438:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:442:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalAssembler.g:443:2: ( ( rule__And__Group__0 ) )
            {
            // InternalAssembler.g:443:2: ( ( rule__And__Group__0 ) )
            // InternalAssembler.g:444:3: ( rule__And__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getGroup()); 
            }
            // InternalAssembler.g:445:3: ( rule__And__Group__0 )
            // InternalAssembler.g:445:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleOr"
    // InternalAssembler.g:454:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalAssembler.g:455:1: ( ruleOr EOF )
            // InternalAssembler.g:456:1: ruleOr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalAssembler.g:463:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:467:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalAssembler.g:468:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalAssembler.g:468:2: ( ( rule__Or__Group__0 ) )
            // InternalAssembler.g:469:3: ( rule__Or__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getGroup()); 
            }
            // InternalAssembler.g:470:3: ( rule__Or__Group__0 )
            // InternalAssembler.g:470:4: rule__Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleXor"
    // InternalAssembler.g:479:1: entryRuleXor : ruleXor EOF ;
    public final void entryRuleXor() throws RecognitionException {
        try {
            // InternalAssembler.g:480:1: ( ruleXor EOF )
            // InternalAssembler.g:481:1: ruleXor EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXor();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXor"


    // $ANTLR start "ruleXor"
    // InternalAssembler.g:488:1: ruleXor : ( ( rule__Xor__Group__0 ) ) ;
    public final void ruleXor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:492:2: ( ( ( rule__Xor__Group__0 ) ) )
            // InternalAssembler.g:493:2: ( ( rule__Xor__Group__0 ) )
            {
            // InternalAssembler.g:493:2: ( ( rule__Xor__Group__0 ) )
            // InternalAssembler.g:494:3: ( rule__Xor__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorAccess().getGroup()); 
            }
            // InternalAssembler.g:495:3: ( rule__Xor__Group__0 )
            // InternalAssembler.g:495:4: rule__Xor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRulePrimary"
    // InternalAssembler.g:504:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalAssembler.g:505:1: ( rulePrimary EOF )
            // InternalAssembler.g:506:1: rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrimary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalAssembler.g:513:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:517:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalAssembler.g:518:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalAssembler.g:518:2: ( ( rule__Primary__Alternatives ) )
            // InternalAssembler.g:519:3: ( rule__Primary__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            }
            // InternalAssembler.g:520:3: ( rule__Primary__Alternatives )
            // InternalAssembler.g:520:4: rule__Primary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleIdentifierValue"
    // InternalAssembler.g:529:1: entryRuleIdentifierValue : ruleIdentifierValue EOF ;
    public final void entryRuleIdentifierValue() throws RecognitionException {
        try {
            // InternalAssembler.g:530:1: ( ruleIdentifierValue EOF )
            // InternalAssembler.g:531:1: ruleIdentifierValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIdentifierValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdentifierValue"


    // $ANTLR start "ruleIdentifierValue"
    // InternalAssembler.g:538:1: ruleIdentifierValue : ( ( rule__IdentifierValue__ValueAssignment ) ) ;
    public final void ruleIdentifierValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:542:2: ( ( ( rule__IdentifierValue__ValueAssignment ) ) )
            // InternalAssembler.g:543:2: ( ( rule__IdentifierValue__ValueAssignment ) )
            {
            // InternalAssembler.g:543:2: ( ( rule__IdentifierValue__ValueAssignment ) )
            // InternalAssembler.g:544:3: ( rule__IdentifierValue__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierValueAccess().getValueAssignment()); 
            }
            // InternalAssembler.g:545:3: ( rule__IdentifierValue__ValueAssignment )
            // InternalAssembler.g:545:4: rule__IdentifierValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IdentifierValue__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierValueAccess().getValueAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentifierValue"


    // $ANTLR start "entryRuleStringValue"
    // InternalAssembler.g:554:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // InternalAssembler.g:555:1: ( ruleStringValue EOF )
            // InternalAssembler.g:556:1: ruleStringValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStringValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringValue"


    // $ANTLR start "ruleStringValue"
    // InternalAssembler.g:563:1: ruleStringValue : ( ( rule__StringValue__ValueAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:567:2: ( ( ( rule__StringValue__ValueAssignment ) ) )
            // InternalAssembler.g:568:2: ( ( rule__StringValue__ValueAssignment ) )
            {
            // InternalAssembler.g:568:2: ( ( rule__StringValue__ValueAssignment ) )
            // InternalAssembler.g:569:3: ( rule__StringValue__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringValueAccess().getValueAssignment()); 
            }
            // InternalAssembler.g:570:3: ( rule__StringValue__ValueAssignment )
            // InternalAssembler.g:570:4: rule__StringValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringValue__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringValueAccess().getValueAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringValue"


    // $ANTLR start "entryRuleDecimalValue"
    // InternalAssembler.g:579:1: entryRuleDecimalValue : ruleDecimalValue EOF ;
    public final void entryRuleDecimalValue() throws RecognitionException {
        try {
            // InternalAssembler.g:580:1: ( ruleDecimalValue EOF )
            // InternalAssembler.g:581:1: ruleDecimalValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDecimalValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDecimalValue"


    // $ANTLR start "ruleDecimalValue"
    // InternalAssembler.g:588:1: ruleDecimalValue : ( ( rule__DecimalValue__Group__0 ) ) ;
    public final void ruleDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:592:2: ( ( ( rule__DecimalValue__Group__0 ) ) )
            // InternalAssembler.g:593:2: ( ( rule__DecimalValue__Group__0 ) )
            {
            // InternalAssembler.g:593:2: ( ( rule__DecimalValue__Group__0 ) )
            // InternalAssembler.g:594:3: ( rule__DecimalValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalValueAccess().getGroup()); 
            }
            // InternalAssembler.g:595:3: ( rule__DecimalValue__Group__0 )
            // InternalAssembler.g:595:4: rule__DecimalValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DecimalValue__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalValueAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDecimalValue"


    // $ANTLR start "entryRuleHexaDecimalValue"
    // InternalAssembler.g:604:1: entryRuleHexaDecimalValue : ruleHexaDecimalValue EOF ;
    public final void entryRuleHexaDecimalValue() throws RecognitionException {
        try {
            // InternalAssembler.g:605:1: ( ruleHexaDecimalValue EOF )
            // InternalAssembler.g:606:1: ruleHexaDecimalValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexaDecimalValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleHexaDecimalValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexaDecimalValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHexaDecimalValue"


    // $ANTLR start "ruleHexaDecimalValue"
    // InternalAssembler.g:613:1: ruleHexaDecimalValue : ( ( rule__HexaDecimalValue__ValueAssignment ) ) ;
    public final void ruleHexaDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:617:2: ( ( ( rule__HexaDecimalValue__ValueAssignment ) ) )
            // InternalAssembler.g:618:2: ( ( rule__HexaDecimalValue__ValueAssignment ) )
            {
            // InternalAssembler.g:618:2: ( ( rule__HexaDecimalValue__ValueAssignment ) )
            // InternalAssembler.g:619:3: ( rule__HexaDecimalValue__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexaDecimalValueAccess().getValueAssignment()); 
            }
            // InternalAssembler.g:620:3: ( rule__HexaDecimalValue__ValueAssignment )
            // InternalAssembler.g:620:4: rule__HexaDecimalValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__HexaDecimalValue__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexaDecimalValueAccess().getValueAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHexaDecimalValue"


    // $ANTLR start "entryRuleOctalValue"
    // InternalAssembler.g:629:1: entryRuleOctalValue : ruleOctalValue EOF ;
    public final void entryRuleOctalValue() throws RecognitionException {
        try {
            // InternalAssembler.g:630:1: ( ruleOctalValue EOF )
            // InternalAssembler.g:631:1: ruleOctalValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOctalValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOctalValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOctalValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOctalValue"


    // $ANTLR start "ruleOctalValue"
    // InternalAssembler.g:638:1: ruleOctalValue : ( ( rule__OctalValue__ValueAssignment ) ) ;
    public final void ruleOctalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:642:2: ( ( ( rule__OctalValue__ValueAssignment ) ) )
            // InternalAssembler.g:643:2: ( ( rule__OctalValue__ValueAssignment ) )
            {
            // InternalAssembler.g:643:2: ( ( rule__OctalValue__ValueAssignment ) )
            // InternalAssembler.g:644:3: ( rule__OctalValue__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOctalValueAccess().getValueAssignment()); 
            }
            // InternalAssembler.g:645:3: ( rule__OctalValue__ValueAssignment )
            // InternalAssembler.g:645:4: rule__OctalValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__OctalValue__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOctalValueAccess().getValueAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOctalValue"


    // $ANTLR start "entryRuleBinaryValue"
    // InternalAssembler.g:654:1: entryRuleBinaryValue : ruleBinaryValue EOF ;
    public final void entryRuleBinaryValue() throws RecognitionException {
        try {
            // InternalAssembler.g:655:1: ( ruleBinaryValue EOF )
            // InternalAssembler.g:656:1: ruleBinaryValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBinaryValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBinaryValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBinaryValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinaryValue"


    // $ANTLR start "ruleBinaryValue"
    // InternalAssembler.g:663:1: ruleBinaryValue : ( ( rule__BinaryValue__ValueAssignment ) ) ;
    public final void ruleBinaryValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:667:2: ( ( ( rule__BinaryValue__ValueAssignment ) ) )
            // InternalAssembler.g:668:2: ( ( rule__BinaryValue__ValueAssignment ) )
            {
            // InternalAssembler.g:668:2: ( ( rule__BinaryValue__ValueAssignment ) )
            // InternalAssembler.g:669:3: ( rule__BinaryValue__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBinaryValueAccess().getValueAssignment()); 
            }
            // InternalAssembler.g:670:3: ( rule__BinaryValue__ValueAssignment )
            // InternalAssembler.g:670:4: rule__BinaryValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BinaryValue__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBinaryValueAccess().getValueAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinaryValue"


    // $ANTLR start "entryRuleCharacterValue"
    // InternalAssembler.g:679:1: entryRuleCharacterValue : ruleCharacterValue EOF ;
    public final void entryRuleCharacterValue() throws RecognitionException {
        try {
            // InternalAssembler.g:680:1: ( ruleCharacterValue EOF )
            // InternalAssembler.g:681:1: ruleCharacterValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCharacterValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCharacterValue"


    // $ANTLR start "ruleCharacterValue"
    // InternalAssembler.g:688:1: ruleCharacterValue : ( ( rule__CharacterValue__ValueAssignment ) ) ;
    public final void ruleCharacterValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:692:2: ( ( ( rule__CharacterValue__ValueAssignment ) ) )
            // InternalAssembler.g:693:2: ( ( rule__CharacterValue__ValueAssignment ) )
            {
            // InternalAssembler.g:693:2: ( ( rule__CharacterValue__ValueAssignment ) )
            // InternalAssembler.g:694:3: ( rule__CharacterValue__ValueAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterValueAccess().getValueAssignment()); 
            }
            // InternalAssembler.g:695:3: ( rule__CharacterValue__ValueAssignment )
            // InternalAssembler.g:695:4: rule__CharacterValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__CharacterValue__ValueAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterValueAccess().getValueAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCharacterValue"


    // $ANTLR start "entryRuleEndOfLine"
    // InternalAssembler.g:704:1: entryRuleEndOfLine : ruleEndOfLine EOF ;
    public final void entryRuleEndOfLine() throws RecognitionException {
        try {
            // InternalAssembler.g:705:1: ( ruleEndOfLine EOF )
            // InternalAssembler.g:706:1: ruleEndOfLine EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEndOfLineRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEndOfLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEndOfLineRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEndOfLine"


    // $ANTLR start "ruleEndOfLine"
    // InternalAssembler.g:713:1: ruleEndOfLine : ( ( rule__EndOfLine__Alternatives ) ) ;
    public final void ruleEndOfLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:717:2: ( ( ( rule__EndOfLine__Alternatives ) ) )
            // InternalAssembler.g:718:2: ( ( rule__EndOfLine__Alternatives ) )
            {
            // InternalAssembler.g:718:2: ( ( rule__EndOfLine__Alternatives ) )
            // InternalAssembler.g:719:3: ( rule__EndOfLine__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEndOfLineAccess().getAlternatives()); 
            }
            // InternalAssembler.g:720:3: ( rule__EndOfLine__Alternatives )
            // InternalAssembler.g:720:4: rule__EndOfLine__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EndOfLine__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEndOfLineAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEndOfLine"


    // $ANTLR start "rule__SourceLine__Alternatives"
    // InternalAssembler.g:728:1: rule__SourceLine__Alternatives : ( ( ( rule__SourceLine__LineContentAssignment_0 ) ) | ( ( rule__SourceLine__LineContentAssignment_1 ) ) | ( ( rule__SourceLine__LineContentAssignment_2 ) ) );
    public final void rule__SourceLine__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:732:1: ( ( ( rule__SourceLine__LineContentAssignment_0 ) ) | ( ( rule__SourceLine__LineContentAssignment_1 ) ) | ( ( rule__SourceLine__LineContentAssignment_2 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_WS:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==25) ) {
                    alt2=3;
                }
                else if ( ((LA2_1>=RULE_CR && LA2_1<=RULE_END_OF_FILE)) ) {
                    alt2=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalAssembler.g:733:2: ( ( rule__SourceLine__LineContentAssignment_0 ) )
                    {
                    // InternalAssembler.g:733:2: ( ( rule__SourceLine__LineContentAssignment_0 ) )
                    // InternalAssembler.g:734:3: ( rule__SourceLine__LineContentAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSourceLineAccess().getLineContentAssignment_0()); 
                    }
                    // InternalAssembler.g:735:3: ( rule__SourceLine__LineContentAssignment_0 )
                    // InternalAssembler.g:735:4: rule__SourceLine__LineContentAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__LineContentAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSourceLineAccess().getLineContentAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:739:2: ( ( rule__SourceLine__LineContentAssignment_1 ) )
                    {
                    // InternalAssembler.g:739:2: ( ( rule__SourceLine__LineContentAssignment_1 ) )
                    // InternalAssembler.g:740:3: ( rule__SourceLine__LineContentAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSourceLineAccess().getLineContentAssignment_1()); 
                    }
                    // InternalAssembler.g:741:3: ( rule__SourceLine__LineContentAssignment_1 )
                    // InternalAssembler.g:741:4: rule__SourceLine__LineContentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__LineContentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSourceLineAccess().getLineContentAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:745:2: ( ( rule__SourceLine__LineContentAssignment_2 ) )
                    {
                    // InternalAssembler.g:745:2: ( ( rule__SourceLine__LineContentAssignment_2 ) )
                    // InternalAssembler.g:746:3: ( rule__SourceLine__LineContentAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSourceLineAccess().getLineContentAssignment_2()); 
                    }
                    // InternalAssembler.g:747:3: ( rule__SourceLine__LineContentAssignment_2 )
                    // InternalAssembler.g:747:4: rule__SourceLine__LineContentAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__LineContentAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSourceLineAccess().getLineContentAssignment_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceLine__Alternatives"


    // $ANTLR start "rule__Operand__Alternatives"
    // InternalAssembler.g:755:1: rule__Operand__Alternatives : ( ( ( rule__Operand__OperandAssignment_0 ) ) | ( ( rule__Operand__OperandAssignment_1 ) ) );
    public final void rule__Operand__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:759:1: ( ( ( rule__Operand__OperandAssignment_0 ) ) | ( ( rule__Operand__OperandAssignment_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID||(LA3_0>=RULE_INT && LA3_0<=RULE_CHARACTER)||LA3_0==16||LA3_0==23) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_STRING) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssembler.g:760:2: ( ( rule__Operand__OperandAssignment_0 ) )
                    {
                    // InternalAssembler.g:760:2: ( ( rule__Operand__OperandAssignment_0 ) )
                    // InternalAssembler.g:761:3: ( rule__Operand__OperandAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperandAccess().getOperandAssignment_0()); 
                    }
                    // InternalAssembler.g:762:3: ( rule__Operand__OperandAssignment_0 )
                    // InternalAssembler.g:762:4: rule__Operand__OperandAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operand__OperandAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperandAccess().getOperandAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:766:2: ( ( rule__Operand__OperandAssignment_1 ) )
                    {
                    // InternalAssembler.g:766:2: ( ( rule__Operand__OperandAssignment_1 ) )
                    // InternalAssembler.g:767:3: ( rule__Operand__OperandAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperandAccess().getOperandAssignment_1()); 
                    }
                    // InternalAssembler.g:768:3: ( rule__Operand__OperandAssignment_1 )
                    // InternalAssembler.g:768:4: rule__Operand__OperandAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operand__OperandAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperandAccess().getOperandAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__Alternatives"


    // $ANTLR start "rule__Primary__Alternatives"
    // InternalAssembler.g:776:1: rule__Primary__Alternatives : ( ( ( rule__Primary__ValueAssignment_0 ) ) | ( ( rule__Primary__ValueAssignment_1 ) ) | ( ( rule__Primary__ValueAssignment_2 ) ) | ( ( rule__Primary__ValueAssignment_3 ) ) | ( ( rule__Primary__ValueAssignment_4 ) ) | ( ( rule__Primary__ValueAssignment_5 ) ) | ( ( rule__Primary__Group_6__0 ) ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:780:1: ( ( ( rule__Primary__ValueAssignment_0 ) ) | ( ( rule__Primary__ValueAssignment_1 ) ) | ( ( rule__Primary__ValueAssignment_2 ) ) | ( ( rule__Primary__ValueAssignment_3 ) ) | ( ( rule__Primary__ValueAssignment_4 ) ) | ( ( rule__Primary__ValueAssignment_5 ) ) | ( ( rule__Primary__Group_6__0 ) ) )
            int alt4=7;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 16:
                {
                alt4=1;
                }
                break;
            case RULE_HEXA:
                {
                alt4=2;
                }
                break;
            case RULE_OCTAL:
                {
                alt4=3;
                }
                break;
            case RULE_BINARY:
                {
                alt4=4;
                }
                break;
            case RULE_CHARACTER:
                {
                alt4=5;
                }
                break;
            case RULE_ID:
                {
                alt4=6;
                }
                break;
            case 23:
                {
                alt4=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:781:2: ( ( rule__Primary__ValueAssignment_0 ) )
                    {
                    // InternalAssembler.g:781:2: ( ( rule__Primary__ValueAssignment_0 ) )
                    // InternalAssembler.g:782:3: ( rule__Primary__ValueAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getValueAssignment_0()); 
                    }
                    // InternalAssembler.g:783:3: ( rule__Primary__ValueAssignment_0 )
                    // InternalAssembler.g:783:4: rule__Primary__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getValueAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:787:2: ( ( rule__Primary__ValueAssignment_1 ) )
                    {
                    // InternalAssembler.g:787:2: ( ( rule__Primary__ValueAssignment_1 ) )
                    // InternalAssembler.g:788:3: ( rule__Primary__ValueAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getValueAssignment_1()); 
                    }
                    // InternalAssembler.g:789:3: ( rule__Primary__ValueAssignment_1 )
                    // InternalAssembler.g:789:4: rule__Primary__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getValueAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:793:2: ( ( rule__Primary__ValueAssignment_2 ) )
                    {
                    // InternalAssembler.g:793:2: ( ( rule__Primary__ValueAssignment_2 ) )
                    // InternalAssembler.g:794:3: ( rule__Primary__ValueAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getValueAssignment_2()); 
                    }
                    // InternalAssembler.g:795:3: ( rule__Primary__ValueAssignment_2 )
                    // InternalAssembler.g:795:4: rule__Primary__ValueAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getValueAssignment_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:799:2: ( ( rule__Primary__ValueAssignment_3 ) )
                    {
                    // InternalAssembler.g:799:2: ( ( rule__Primary__ValueAssignment_3 ) )
                    // InternalAssembler.g:800:3: ( rule__Primary__ValueAssignment_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getValueAssignment_3()); 
                    }
                    // InternalAssembler.g:801:3: ( rule__Primary__ValueAssignment_3 )
                    // InternalAssembler.g:801:4: rule__Primary__ValueAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getValueAssignment_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:805:2: ( ( rule__Primary__ValueAssignment_4 ) )
                    {
                    // InternalAssembler.g:805:2: ( ( rule__Primary__ValueAssignment_4 ) )
                    // InternalAssembler.g:806:3: ( rule__Primary__ValueAssignment_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getValueAssignment_4()); 
                    }
                    // InternalAssembler.g:807:3: ( rule__Primary__ValueAssignment_4 )
                    // InternalAssembler.g:807:4: rule__Primary__ValueAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getValueAssignment_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:811:2: ( ( rule__Primary__ValueAssignment_5 ) )
                    {
                    // InternalAssembler.g:811:2: ( ( rule__Primary__ValueAssignment_5 ) )
                    // InternalAssembler.g:812:3: ( rule__Primary__ValueAssignment_5 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getValueAssignment_5()); 
                    }
                    // InternalAssembler.g:813:3: ( rule__Primary__ValueAssignment_5 )
                    // InternalAssembler.g:813:4: rule__Primary__ValueAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getValueAssignment_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:817:2: ( ( rule__Primary__Group_6__0 ) )
                    {
                    // InternalAssembler.g:817:2: ( ( rule__Primary__Group_6__0 ) )
                    // InternalAssembler.g:818:3: ( rule__Primary__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryAccess().getGroup_6()); 
                    }
                    // InternalAssembler.g:819:3: ( rule__Primary__Group_6__0 )
                    // InternalAssembler.g:819:4: rule__Primary__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Alternatives"


    // $ANTLR start "rule__EndOfLine__Alternatives"
    // InternalAssembler.g:827:1: rule__EndOfLine__Alternatives : ( ( RULE_CR ) | ( RULE_END_OF_FILE ) );
    public final void rule__EndOfLine__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:831:1: ( ( RULE_CR ) | ( RULE_END_OF_FILE ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_CR) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_END_OF_FILE) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:832:2: ( RULE_CR )
                    {
                    // InternalAssembler.g:832:2: ( RULE_CR )
                    // InternalAssembler.g:833:3: RULE_CR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEndOfLineAccess().getCRTerminalRuleCall_0()); 
                    }
                    match(input,RULE_CR,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEndOfLineAccess().getCRTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:838:2: ( RULE_END_OF_FILE )
                    {
                    // InternalAssembler.g:838:2: ( RULE_END_OF_FILE )
                    // InternalAssembler.g:839:3: RULE_END_OF_FILE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEndOfLineAccess().getEND_OF_FILETerminalRuleCall_1()); 
                    }
                    match(input,RULE_END_OF_FILE,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEndOfLineAccess().getEND_OF_FILETerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndOfLine__Alternatives"


    // $ANTLR start "rule__BlankLine__Group__0"
    // InternalAssembler.g:848:1: rule__BlankLine__Group__0 : rule__BlankLine__Group__0__Impl rule__BlankLine__Group__1 ;
    public final void rule__BlankLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:852:1: ( rule__BlankLine__Group__0__Impl rule__BlankLine__Group__1 )
            // InternalAssembler.g:853:2: rule__BlankLine__Group__0__Impl rule__BlankLine__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__BlankLine__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BlankLine__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlankLine__Group__0"


    // $ANTLR start "rule__BlankLine__Group__0__Impl"
    // InternalAssembler.g:860:1: rule__BlankLine__Group__0__Impl : ( () ) ;
    public final void rule__BlankLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:864:1: ( ( () ) )
            // InternalAssembler.g:865:1: ( () )
            {
            // InternalAssembler.g:865:1: ( () )
            // InternalAssembler.g:866:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankLineAccess().getBlankLineAction_0()); 
            }
            // InternalAssembler.g:867:2: ()
            // InternalAssembler.g:867:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankLineAccess().getBlankLineAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlankLine__Group__0__Impl"


    // $ANTLR start "rule__BlankLine__Group__1"
    // InternalAssembler.g:875:1: rule__BlankLine__Group__1 : rule__BlankLine__Group__1__Impl rule__BlankLine__Group__2 ;
    public final void rule__BlankLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:879:1: ( rule__BlankLine__Group__1__Impl rule__BlankLine__Group__2 )
            // InternalAssembler.g:880:2: rule__BlankLine__Group__1__Impl rule__BlankLine__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__BlankLine__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BlankLine__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlankLine__Group__1"


    // $ANTLR start "rule__BlankLine__Group__1__Impl"
    // InternalAssembler.g:887:1: rule__BlankLine__Group__1__Impl : ( ( rule__BlankLine__BlankLineAssignment_1 )? ) ;
    public final void rule__BlankLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:891:1: ( ( ( rule__BlankLine__BlankLineAssignment_1 )? ) )
            // InternalAssembler.g:892:1: ( ( rule__BlankLine__BlankLineAssignment_1 )? )
            {
            // InternalAssembler.g:892:1: ( ( rule__BlankLine__BlankLineAssignment_1 )? )
            // InternalAssembler.g:893:2: ( rule__BlankLine__BlankLineAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankLineAccess().getBlankLineAssignment_1()); 
            }
            // InternalAssembler.g:894:2: ( rule__BlankLine__BlankLineAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_WS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:894:3: rule__BlankLine__BlankLineAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BlankLine__BlankLineAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankLineAccess().getBlankLineAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlankLine__Group__1__Impl"


    // $ANTLR start "rule__BlankLine__Group__2"
    // InternalAssembler.g:902:1: rule__BlankLine__Group__2 : rule__BlankLine__Group__2__Impl ;
    public final void rule__BlankLine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:906:1: ( rule__BlankLine__Group__2__Impl )
            // InternalAssembler.g:907:2: rule__BlankLine__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BlankLine__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlankLine__Group__2"


    // $ANTLR start "rule__BlankLine__Group__2__Impl"
    // InternalAssembler.g:913:1: rule__BlankLine__Group__2__Impl : ( ruleEndOfLine ) ;
    public final void rule__BlankLine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:917:1: ( ( ruleEndOfLine ) )
            // InternalAssembler.g:918:1: ( ruleEndOfLine )
            {
            // InternalAssembler.g:918:1: ( ruleEndOfLine )
            // InternalAssembler.g:919:2: ruleEndOfLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankLineAccess().getEndOfLineParserRuleCall_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankLineAccess().getEndOfLineParserRuleCall_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlankLine__Group__2__Impl"


    // $ANTLR start "rule__CommentLine__Group__0"
    // InternalAssembler.g:929:1: rule__CommentLine__Group__0 : rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1 ;
    public final void rule__CommentLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:933:1: ( rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1 )
            // InternalAssembler.g:934:2: rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__CommentLine__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CommentLine__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommentLine__Group__0"


    // $ANTLR start "rule__CommentLine__Group__0__Impl"
    // InternalAssembler.g:941:1: rule__CommentLine__Group__0__Impl : ( ( rule__CommentLine__CommentAssignment_0 ) ) ;
    public final void rule__CommentLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:945:1: ( ( ( rule__CommentLine__CommentAssignment_0 ) ) )
            // InternalAssembler.g:946:1: ( ( rule__CommentLine__CommentAssignment_0 ) )
            {
            // InternalAssembler.g:946:1: ( ( rule__CommentLine__CommentAssignment_0 ) )
            // InternalAssembler.g:947:2: ( rule__CommentLine__CommentAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommentLineAccess().getCommentAssignment_0()); 
            }
            // InternalAssembler.g:948:2: ( rule__CommentLine__CommentAssignment_0 )
            // InternalAssembler.g:948:3: rule__CommentLine__CommentAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CommentLine__CommentAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommentLineAccess().getCommentAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommentLine__Group__0__Impl"


    // $ANTLR start "rule__CommentLine__Group__1"
    // InternalAssembler.g:956:1: rule__CommentLine__Group__1 : rule__CommentLine__Group__1__Impl ;
    public final void rule__CommentLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:960:1: ( rule__CommentLine__Group__1__Impl )
            // InternalAssembler.g:961:2: rule__CommentLine__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CommentLine__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommentLine__Group__1"


    // $ANTLR start "rule__CommentLine__Group__1__Impl"
    // InternalAssembler.g:967:1: rule__CommentLine__Group__1__Impl : ( ruleEndOfLine ) ;
    public final void rule__CommentLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:971:1: ( ( ruleEndOfLine ) )
            // InternalAssembler.g:972:1: ( ruleEndOfLine )
            {
            // InternalAssembler.g:972:1: ( ruleEndOfLine )
            // InternalAssembler.g:973:2: ruleEndOfLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommentLineAccess().getEndOfLineParserRuleCall_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommentLineAccess().getEndOfLineParserRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommentLine__Group__1__Impl"


    // $ANTLR start "rule__EquDirective__Group__0"
    // InternalAssembler.g:983:1: rule__EquDirective__Group__0 : rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1 ;
    public final void rule__EquDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:987:1: ( rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1 )
            // InternalAssembler.g:988:2: rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__EquDirective__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__0"


    // $ANTLR start "rule__EquDirective__Group__0__Impl"
    // InternalAssembler.g:995:1: rule__EquDirective__Group__0__Impl : ( ( rule__EquDirective__NameAssignment_0 )? ) ;
    public final void rule__EquDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:999:1: ( ( ( rule__EquDirective__NameAssignment_0 )? ) )
            // InternalAssembler.g:1000:1: ( ( rule__EquDirective__NameAssignment_0 )? )
            {
            // InternalAssembler.g:1000:1: ( ( rule__EquDirective__NameAssignment_0 )? )
            // InternalAssembler.g:1001:2: ( rule__EquDirective__NameAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getNameAssignment_0()); 
            }
            // InternalAssembler.g:1002:2: ( rule__EquDirective__NameAssignment_0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:1002:3: rule__EquDirective__NameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EquDirective__NameAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__0__Impl"


    // $ANTLR start "rule__EquDirective__Group__1"
    // InternalAssembler.g:1010:1: rule__EquDirective__Group__1 : rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2 ;
    public final void rule__EquDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1014:1: ( rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2 )
            // InternalAssembler.g:1015:2: rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__EquDirective__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__1"


    // $ANTLR start "rule__EquDirective__Group__1__Impl"
    // InternalAssembler.g:1022:1: rule__EquDirective__Group__1__Impl : ( RULE_WS ) ;
    public final void rule__EquDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1026:1: ( ( RULE_WS ) )
            // InternalAssembler.g:1027:1: ( RULE_WS )
            {
            // InternalAssembler.g:1027:1: ( RULE_WS )
            // InternalAssembler.g:1028:2: RULE_WS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1()); 
            }
            match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__1__Impl"


    // $ANTLR start "rule__EquDirective__Group__2"
    // InternalAssembler.g:1037:1: rule__EquDirective__Group__2 : rule__EquDirective__Group__2__Impl rule__EquDirective__Group__3 ;
    public final void rule__EquDirective__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1041:1: ( rule__EquDirective__Group__2__Impl rule__EquDirective__Group__3 )
            // InternalAssembler.g:1042:2: rule__EquDirective__Group__2__Impl rule__EquDirective__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__EquDirective__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__2"


    // $ANTLR start "rule__EquDirective__Group__2__Impl"
    // InternalAssembler.g:1049:1: rule__EquDirective__Group__2__Impl : ( ( rule__EquDirective__DirectiveAssignment_2 ) ) ;
    public final void rule__EquDirective__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1053:1: ( ( ( rule__EquDirective__DirectiveAssignment_2 ) ) )
            // InternalAssembler.g:1054:1: ( ( rule__EquDirective__DirectiveAssignment_2 ) )
            {
            // InternalAssembler.g:1054:1: ( ( rule__EquDirective__DirectiveAssignment_2 ) )
            // InternalAssembler.g:1055:2: ( rule__EquDirective__DirectiveAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getDirectiveAssignment_2()); 
            }
            // InternalAssembler.g:1056:2: ( rule__EquDirective__DirectiveAssignment_2 )
            // InternalAssembler.g:1056:3: rule__EquDirective__DirectiveAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EquDirective__DirectiveAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getDirectiveAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__2__Impl"


    // $ANTLR start "rule__EquDirective__Group__3"
    // InternalAssembler.g:1064:1: rule__EquDirective__Group__3 : rule__EquDirective__Group__3__Impl rule__EquDirective__Group__4 ;
    public final void rule__EquDirective__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1068:1: ( rule__EquDirective__Group__3__Impl rule__EquDirective__Group__4 )
            // InternalAssembler.g:1069:2: rule__EquDirective__Group__3__Impl rule__EquDirective__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__EquDirective__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__3"


    // $ANTLR start "rule__EquDirective__Group__3__Impl"
    // InternalAssembler.g:1076:1: rule__EquDirective__Group__3__Impl : ( RULE_WS ) ;
    public final void rule__EquDirective__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1080:1: ( ( RULE_WS ) )
            // InternalAssembler.g:1081:1: ( RULE_WS )
            {
            // InternalAssembler.g:1081:1: ( RULE_WS )
            // InternalAssembler.g:1082:2: RULE_WS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3()); 
            }
            match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__3__Impl"


    // $ANTLR start "rule__EquDirective__Group__4"
    // InternalAssembler.g:1091:1: rule__EquDirective__Group__4 : rule__EquDirective__Group__4__Impl rule__EquDirective__Group__5 ;
    public final void rule__EquDirective__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1095:1: ( rule__EquDirective__Group__4__Impl rule__EquDirective__Group__5 )
            // InternalAssembler.g:1096:2: rule__EquDirective__Group__4__Impl rule__EquDirective__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__EquDirective__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__4"


    // $ANTLR start "rule__EquDirective__Group__4__Impl"
    // InternalAssembler.g:1103:1: rule__EquDirective__Group__4__Impl : ( ( rule__EquDirective__OperandAssignment_4 )? ) ;
    public final void rule__EquDirective__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1107:1: ( ( ( rule__EquDirective__OperandAssignment_4 )? ) )
            // InternalAssembler.g:1108:1: ( ( rule__EquDirective__OperandAssignment_4 )? )
            {
            // InternalAssembler.g:1108:1: ( ( rule__EquDirective__OperandAssignment_4 )? )
            // InternalAssembler.g:1109:2: ( rule__EquDirective__OperandAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getOperandAssignment_4()); 
            }
            // InternalAssembler.g:1110:2: ( rule__EquDirective__OperandAssignment_4 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_CHARACTER)||LA8_0==16||LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:1110:3: rule__EquDirective__OperandAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__EquDirective__OperandAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getOperandAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__4__Impl"


    // $ANTLR start "rule__EquDirective__Group__5"
    // InternalAssembler.g:1118:1: rule__EquDirective__Group__5 : rule__EquDirective__Group__5__Impl rule__EquDirective__Group__6 ;
    public final void rule__EquDirective__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1122:1: ( rule__EquDirective__Group__5__Impl rule__EquDirective__Group__6 )
            // InternalAssembler.g:1123:2: rule__EquDirective__Group__5__Impl rule__EquDirective__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__EquDirective__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__5"


    // $ANTLR start "rule__EquDirective__Group__5__Impl"
    // InternalAssembler.g:1130:1: rule__EquDirective__Group__5__Impl : ( ( RULE_WS )? ) ;
    public final void rule__EquDirective__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1134:1: ( ( ( RULE_WS )? ) )
            // InternalAssembler.g:1135:1: ( ( RULE_WS )? )
            {
            // InternalAssembler.g:1135:1: ( ( RULE_WS )? )
            // InternalAssembler.g:1136:2: ( RULE_WS )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5()); 
            }
            // InternalAssembler.g:1137:2: ( RULE_WS )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_WS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:1137:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__5__Impl"


    // $ANTLR start "rule__EquDirective__Group__6"
    // InternalAssembler.g:1145:1: rule__EquDirective__Group__6 : rule__EquDirective__Group__6__Impl rule__EquDirective__Group__7 ;
    public final void rule__EquDirective__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1149:1: ( rule__EquDirective__Group__6__Impl rule__EquDirective__Group__7 )
            // InternalAssembler.g:1150:2: rule__EquDirective__Group__6__Impl rule__EquDirective__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__EquDirective__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__6"


    // $ANTLR start "rule__EquDirective__Group__6__Impl"
    // InternalAssembler.g:1157:1: rule__EquDirective__Group__6__Impl : ( ( rule__EquDirective__CommentAssignment_6 )? ) ;
    public final void rule__EquDirective__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1161:1: ( ( ( rule__EquDirective__CommentAssignment_6 )? ) )
            // InternalAssembler.g:1162:1: ( ( rule__EquDirective__CommentAssignment_6 )? )
            {
            // InternalAssembler.g:1162:1: ( ( rule__EquDirective__CommentAssignment_6 )? )
            // InternalAssembler.g:1163:2: ( rule__EquDirective__CommentAssignment_6 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getCommentAssignment_6()); 
            }
            // InternalAssembler.g:1164:2: ( rule__EquDirective__CommentAssignment_6 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:1164:3: rule__EquDirective__CommentAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__EquDirective__CommentAssignment_6();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getCommentAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__6__Impl"


    // $ANTLR start "rule__EquDirective__Group__7"
    // InternalAssembler.g:1172:1: rule__EquDirective__Group__7 : rule__EquDirective__Group__7__Impl ;
    public final void rule__EquDirective__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1176:1: ( rule__EquDirective__Group__7__Impl )
            // InternalAssembler.g:1177:2: rule__EquDirective__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__7"


    // $ANTLR start "rule__EquDirective__Group__7__Impl"
    // InternalAssembler.g:1183:1: rule__EquDirective__Group__7__Impl : ( ruleEndOfLine ) ;
    public final void rule__EquDirective__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1187:1: ( ( ruleEndOfLine ) )
            // InternalAssembler.g:1188:1: ( ruleEndOfLine )
            {
            // InternalAssembler.g:1188:1: ( ruleEndOfLine )
            // InternalAssembler.g:1189:2: ruleEndOfLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getEndOfLineParserRuleCall_7()); 
            }
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getEndOfLineParserRuleCall_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__Group__7__Impl"


    // $ANTLR start "rule__Multiplication__Group__0"
    // InternalAssembler.g:1199:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1203:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // InternalAssembler.g:1204:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__0"


    // $ANTLR start "rule__Multiplication__Group__0__Impl"
    // InternalAssembler.g:1211:1: rule__Multiplication__Group__0__Impl : ( ruleDivision ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1215:1: ( ( ruleDivision ) )
            // InternalAssembler.g:1216:1: ( ruleDivision )
            {
            // InternalAssembler.g:1216:1: ( ruleDivision )
            // InternalAssembler.g:1217:2: ruleDivision
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDivision();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__0__Impl"


    // $ANTLR start "rule__Multiplication__Group__1"
    // InternalAssembler.g:1226:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1230:1: ( rule__Multiplication__Group__1__Impl )
            // InternalAssembler.g:1231:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__1"


    // $ANTLR start "rule__Multiplication__Group__1__Impl"
    // InternalAssembler.g:1237:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1241:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // InternalAssembler.g:1242:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // InternalAssembler.g:1242:1: ( ( rule__Multiplication__Group_1__0 )* )
            // InternalAssembler.g:1243:2: ( rule__Multiplication__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            }
            // InternalAssembler.g:1244:2: ( rule__Multiplication__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAssembler.g:1244:3: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__0"
    // InternalAssembler.g:1253:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1257:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // InternalAssembler.g:1258:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__0"


    // $ANTLR start "rule__Multiplication__Group_1__0__Impl"
    // InternalAssembler.g:1265:1: rule__Multiplication__Group_1__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1269:1: ( ( () ) )
            // InternalAssembler.g:1270:1: ( () )
            {
            // InternalAssembler.g:1270:1: ( () )
            // InternalAssembler.g:1271:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0()); 
            }
            // InternalAssembler.g:1272:2: ()
            // InternalAssembler.g:1272:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__1"
    // InternalAssembler.g:1280:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl rule__Multiplication__Group_1__2 ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1284:1: ( rule__Multiplication__Group_1__1__Impl rule__Multiplication__Group_1__2 )
            // InternalAssembler.g:1285:2: rule__Multiplication__Group_1__1__Impl rule__Multiplication__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Multiplication__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__1"


    // $ANTLR start "rule__Multiplication__Group_1__1__Impl"
    // InternalAssembler.g:1292:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__OperationAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1296:1: ( ( ( rule__Multiplication__OperationAssignment_1_1 ) ) )
            // InternalAssembler.g:1297:1: ( ( rule__Multiplication__OperationAssignment_1_1 ) )
            {
            // InternalAssembler.g:1297:1: ( ( rule__Multiplication__OperationAssignment_1_1 ) )
            // InternalAssembler.g:1298:2: ( rule__Multiplication__OperationAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOperationAssignment_1_1()); 
            }
            // InternalAssembler.g:1299:2: ( rule__Multiplication__OperationAssignment_1_1 )
            // InternalAssembler.g:1299:3: rule__Multiplication__OperationAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__OperationAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getOperationAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__2"
    // InternalAssembler.g:1307:1: rule__Multiplication__Group_1__2 : rule__Multiplication__Group_1__2__Impl ;
    public final void rule__Multiplication__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1311:1: ( rule__Multiplication__Group_1__2__Impl )
            // InternalAssembler.g:1312:2: rule__Multiplication__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__2"


    // $ANTLR start "rule__Multiplication__Group_1__2__Impl"
    // InternalAssembler.g:1318:1: rule__Multiplication__Group_1__2__Impl : ( ( rule__Multiplication__RightAssignment_1_2 ) ) ;
    public final void rule__Multiplication__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1322:1: ( ( ( rule__Multiplication__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1323:1: ( ( rule__Multiplication__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1323:1: ( ( rule__Multiplication__RightAssignment_1_2 ) )
            // InternalAssembler.g:1324:2: ( rule__Multiplication__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:1325:2: ( rule__Multiplication__RightAssignment_1_2 )
            // InternalAssembler.g:1325:3: rule__Multiplication__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__2__Impl"


    // $ANTLR start "rule__Division__Group__0"
    // InternalAssembler.g:1334:1: rule__Division__Group__0 : rule__Division__Group__0__Impl rule__Division__Group__1 ;
    public final void rule__Division__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1338:1: ( rule__Division__Group__0__Impl rule__Division__Group__1 )
            // InternalAssembler.g:1339:2: rule__Division__Group__0__Impl rule__Division__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Division__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Division__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group__0"


    // $ANTLR start "rule__Division__Group__0__Impl"
    // InternalAssembler.g:1346:1: rule__Division__Group__0__Impl : ( ruleModulo ) ;
    public final void rule__Division__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1350:1: ( ( ruleModulo ) )
            // InternalAssembler.g:1351:1: ( ruleModulo )
            {
            // InternalAssembler.g:1351:1: ( ruleModulo )
            // InternalAssembler.g:1352:2: ruleModulo
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleModulo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group__0__Impl"


    // $ANTLR start "rule__Division__Group__1"
    // InternalAssembler.g:1361:1: rule__Division__Group__1 : rule__Division__Group__1__Impl ;
    public final void rule__Division__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1365:1: ( rule__Division__Group__1__Impl )
            // InternalAssembler.g:1366:2: rule__Division__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Division__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group__1"


    // $ANTLR start "rule__Division__Group__1__Impl"
    // InternalAssembler.g:1372:1: rule__Division__Group__1__Impl : ( ( rule__Division__Group_1__0 )* ) ;
    public final void rule__Division__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1376:1: ( ( ( rule__Division__Group_1__0 )* ) )
            // InternalAssembler.g:1377:1: ( ( rule__Division__Group_1__0 )* )
            {
            // InternalAssembler.g:1377:1: ( ( rule__Division__Group_1__0 )* )
            // InternalAssembler.g:1378:2: ( rule__Division__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getGroup_1()); 
            }
            // InternalAssembler.g:1379:2: ( rule__Division__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAssembler.g:1379:3: rule__Division__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Division__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group__1__Impl"


    // $ANTLR start "rule__Division__Group_1__0"
    // InternalAssembler.g:1388:1: rule__Division__Group_1__0 : rule__Division__Group_1__0__Impl rule__Division__Group_1__1 ;
    public final void rule__Division__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1392:1: ( rule__Division__Group_1__0__Impl rule__Division__Group_1__1 )
            // InternalAssembler.g:1393:2: rule__Division__Group_1__0__Impl rule__Division__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Division__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Division__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group_1__0"


    // $ANTLR start "rule__Division__Group_1__0__Impl"
    // InternalAssembler.g:1400:1: rule__Division__Group_1__0__Impl : ( () ) ;
    public final void rule__Division__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1404:1: ( ( () ) )
            // InternalAssembler.g:1405:1: ( () )
            {
            // InternalAssembler.g:1405:1: ( () )
            // InternalAssembler.g:1406:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0()); 
            }
            // InternalAssembler.g:1407:2: ()
            // InternalAssembler.g:1407:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group_1__0__Impl"


    // $ANTLR start "rule__Division__Group_1__1"
    // InternalAssembler.g:1415:1: rule__Division__Group_1__1 : rule__Division__Group_1__1__Impl rule__Division__Group_1__2 ;
    public final void rule__Division__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1419:1: ( rule__Division__Group_1__1__Impl rule__Division__Group_1__2 )
            // InternalAssembler.g:1420:2: rule__Division__Group_1__1__Impl rule__Division__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Division__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Division__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group_1__1"


    // $ANTLR start "rule__Division__Group_1__1__Impl"
    // InternalAssembler.g:1427:1: rule__Division__Group_1__1__Impl : ( ( rule__Division__OpretationAssignment_1_1 ) ) ;
    public final void rule__Division__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1431:1: ( ( ( rule__Division__OpretationAssignment_1_1 ) ) )
            // InternalAssembler.g:1432:1: ( ( rule__Division__OpretationAssignment_1_1 ) )
            {
            // InternalAssembler.g:1432:1: ( ( rule__Division__OpretationAssignment_1_1 ) )
            // InternalAssembler.g:1433:2: ( rule__Division__OpretationAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getOpretationAssignment_1_1()); 
            }
            // InternalAssembler.g:1434:2: ( rule__Division__OpretationAssignment_1_1 )
            // InternalAssembler.g:1434:3: rule__Division__OpretationAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Division__OpretationAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getOpretationAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group_1__1__Impl"


    // $ANTLR start "rule__Division__Group_1__2"
    // InternalAssembler.g:1442:1: rule__Division__Group_1__2 : rule__Division__Group_1__2__Impl ;
    public final void rule__Division__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1446:1: ( rule__Division__Group_1__2__Impl )
            // InternalAssembler.g:1447:2: rule__Division__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Division__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group_1__2"


    // $ANTLR start "rule__Division__Group_1__2__Impl"
    // InternalAssembler.g:1453:1: rule__Division__Group_1__2__Impl : ( ( rule__Division__RightAssignment_1_2 ) ) ;
    public final void rule__Division__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1457:1: ( ( ( rule__Division__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1458:1: ( ( rule__Division__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1458:1: ( ( rule__Division__RightAssignment_1_2 ) )
            // InternalAssembler.g:1459:2: ( rule__Division__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:1460:2: ( rule__Division__RightAssignment_1_2 )
            // InternalAssembler.g:1460:3: rule__Division__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Division__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__Group_1__2__Impl"


    // $ANTLR start "rule__Modulo__Group__0"
    // InternalAssembler.g:1469:1: rule__Modulo__Group__0 : rule__Modulo__Group__0__Impl rule__Modulo__Group__1 ;
    public final void rule__Modulo__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1473:1: ( rule__Modulo__Group__0__Impl rule__Modulo__Group__1 )
            // InternalAssembler.g:1474:2: rule__Modulo__Group__0__Impl rule__Modulo__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Modulo__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Modulo__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group__0"


    // $ANTLR start "rule__Modulo__Group__0__Impl"
    // InternalAssembler.g:1481:1: rule__Modulo__Group__0__Impl : ( ruleAddition ) ;
    public final void rule__Modulo__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1485:1: ( ( ruleAddition ) )
            // InternalAssembler.g:1486:1: ( ruleAddition )
            {
            // InternalAssembler.g:1486:1: ( ruleAddition )
            // InternalAssembler.g:1487:2: ruleAddition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group__0__Impl"


    // $ANTLR start "rule__Modulo__Group__1"
    // InternalAssembler.g:1496:1: rule__Modulo__Group__1 : rule__Modulo__Group__1__Impl ;
    public final void rule__Modulo__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1500:1: ( rule__Modulo__Group__1__Impl )
            // InternalAssembler.g:1501:2: rule__Modulo__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group__1"


    // $ANTLR start "rule__Modulo__Group__1__Impl"
    // InternalAssembler.g:1507:1: rule__Modulo__Group__1__Impl : ( ( rule__Modulo__Group_1__0 )* ) ;
    public final void rule__Modulo__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1511:1: ( ( ( rule__Modulo__Group_1__0 )* ) )
            // InternalAssembler.g:1512:1: ( ( rule__Modulo__Group_1__0 )* )
            {
            // InternalAssembler.g:1512:1: ( ( rule__Modulo__Group_1__0 )* )
            // InternalAssembler.g:1513:2: ( rule__Modulo__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getGroup_1()); 
            }
            // InternalAssembler.g:1514:2: ( rule__Modulo__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAssembler.g:1514:3: rule__Modulo__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Modulo__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group__1__Impl"


    // $ANTLR start "rule__Modulo__Group_1__0"
    // InternalAssembler.g:1523:1: rule__Modulo__Group_1__0 : rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1 ;
    public final void rule__Modulo__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1527:1: ( rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1 )
            // InternalAssembler.g:1528:2: rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__Modulo__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__0"


    // $ANTLR start "rule__Modulo__Group_1__0__Impl"
    // InternalAssembler.g:1535:1: rule__Modulo__Group_1__0__Impl : ( () ) ;
    public final void rule__Modulo__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1539:1: ( ( () ) )
            // InternalAssembler.g:1540:1: ( () )
            {
            // InternalAssembler.g:1540:1: ( () )
            // InternalAssembler.g:1541:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getModuloLeftAction_1_0()); 
            }
            // InternalAssembler.g:1542:2: ()
            // InternalAssembler.g:1542:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getModuloLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__0__Impl"


    // $ANTLR start "rule__Modulo__Group_1__1"
    // InternalAssembler.g:1550:1: rule__Modulo__Group_1__1 : rule__Modulo__Group_1__1__Impl rule__Modulo__Group_1__2 ;
    public final void rule__Modulo__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1554:1: ( rule__Modulo__Group_1__1__Impl rule__Modulo__Group_1__2 )
            // InternalAssembler.g:1555:2: rule__Modulo__Group_1__1__Impl rule__Modulo__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Modulo__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__1"


    // $ANTLR start "rule__Modulo__Group_1__1__Impl"
    // InternalAssembler.g:1562:1: rule__Modulo__Group_1__1__Impl : ( ( rule__Modulo__OpretationAssignment_1_1 ) ) ;
    public final void rule__Modulo__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1566:1: ( ( ( rule__Modulo__OpretationAssignment_1_1 ) ) )
            // InternalAssembler.g:1567:1: ( ( rule__Modulo__OpretationAssignment_1_1 ) )
            {
            // InternalAssembler.g:1567:1: ( ( rule__Modulo__OpretationAssignment_1_1 ) )
            // InternalAssembler.g:1568:2: ( rule__Modulo__OpretationAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getOpretationAssignment_1_1()); 
            }
            // InternalAssembler.g:1569:2: ( rule__Modulo__OpretationAssignment_1_1 )
            // InternalAssembler.g:1569:3: rule__Modulo__OpretationAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__OpretationAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getOpretationAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__1__Impl"


    // $ANTLR start "rule__Modulo__Group_1__2"
    // InternalAssembler.g:1577:1: rule__Modulo__Group_1__2 : rule__Modulo__Group_1__2__Impl ;
    public final void rule__Modulo__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1581:1: ( rule__Modulo__Group_1__2__Impl )
            // InternalAssembler.g:1582:2: rule__Modulo__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__2"


    // $ANTLR start "rule__Modulo__Group_1__2__Impl"
    // InternalAssembler.g:1588:1: rule__Modulo__Group_1__2__Impl : ( ( rule__Modulo__RightAssignment_1_2 ) ) ;
    public final void rule__Modulo__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1592:1: ( ( ( rule__Modulo__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1593:1: ( ( rule__Modulo__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1593:1: ( ( rule__Modulo__RightAssignment_1_2 ) )
            // InternalAssembler.g:1594:2: ( rule__Modulo__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:1595:2: ( rule__Modulo__RightAssignment_1_2 )
            // InternalAssembler.g:1595:3: rule__Modulo__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__Group_1__2__Impl"


    // $ANTLR start "rule__Addition__Group__0"
    // InternalAssembler.g:1604:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1608:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // InternalAssembler.g:1609:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Addition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Addition__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__0"


    // $ANTLR start "rule__Addition__Group__0__Impl"
    // InternalAssembler.g:1616:1: rule__Addition__Group__0__Impl : ( ruleSubstraction ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1620:1: ( ( ruleSubstraction ) )
            // InternalAssembler.g:1621:1: ( ruleSubstraction )
            {
            // InternalAssembler.g:1621:1: ( ruleSubstraction )
            // InternalAssembler.g:1622:2: ruleSubstraction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSubstraction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__0__Impl"


    // $ANTLR start "rule__Addition__Group__1"
    // InternalAssembler.g:1631:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1635:1: ( rule__Addition__Group__1__Impl )
            // InternalAssembler.g:1636:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__1"


    // $ANTLR start "rule__Addition__Group__1__Impl"
    // InternalAssembler.g:1642:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1646:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // InternalAssembler.g:1647:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // InternalAssembler.g:1647:1: ( ( rule__Addition__Group_1__0 )* )
            // InternalAssembler.g:1648:2: ( rule__Addition__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getGroup_1()); 
            }
            // InternalAssembler.g:1649:2: ( rule__Addition__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==15) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalAssembler.g:1649:3: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__1__Impl"


    // $ANTLR start "rule__Addition__Group_1__0"
    // InternalAssembler.g:1658:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1662:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // InternalAssembler.g:1663:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__0"


    // $ANTLR start "rule__Addition__Group_1__0__Impl"
    // InternalAssembler.g:1670:1: rule__Addition__Group_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1674:1: ( ( () ) )
            // InternalAssembler.g:1675:1: ( () )
            {
            // InternalAssembler.g:1675:1: ( () )
            // InternalAssembler.g:1676:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0()); 
            }
            // InternalAssembler.g:1677:2: ()
            // InternalAssembler.g:1677:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__0__Impl"


    // $ANTLR start "rule__Addition__Group_1__1"
    // InternalAssembler.g:1685:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl rule__Addition__Group_1__2 ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1689:1: ( rule__Addition__Group_1__1__Impl rule__Addition__Group_1__2 )
            // InternalAssembler.g:1690:2: rule__Addition__Group_1__1__Impl rule__Addition__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Addition__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__1"


    // $ANTLR start "rule__Addition__Group_1__1__Impl"
    // InternalAssembler.g:1697:1: rule__Addition__Group_1__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1701:1: ( ( '+' ) )
            // InternalAssembler.g:1702:1: ( '+' )
            {
            // InternalAssembler.g:1702:1: ( '+' )
            // InternalAssembler.g:1703:2: '+'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__1__Impl"


    // $ANTLR start "rule__Addition__Group_1__2"
    // InternalAssembler.g:1712:1: rule__Addition__Group_1__2 : rule__Addition__Group_1__2__Impl ;
    public final void rule__Addition__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1716:1: ( rule__Addition__Group_1__2__Impl )
            // InternalAssembler.g:1717:2: rule__Addition__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__2"


    // $ANTLR start "rule__Addition__Group_1__2__Impl"
    // InternalAssembler.g:1723:1: rule__Addition__Group_1__2__Impl : ( ( rule__Addition__RightAssignment_1_2 ) ) ;
    public final void rule__Addition__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1727:1: ( ( ( rule__Addition__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1728:1: ( ( rule__Addition__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1728:1: ( ( rule__Addition__RightAssignment_1_2 ) )
            // InternalAssembler.g:1729:2: ( rule__Addition__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:1730:2: ( rule__Addition__RightAssignment_1_2 )
            // InternalAssembler.g:1730:3: rule__Addition__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Addition__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__2__Impl"


    // $ANTLR start "rule__Substraction__Group__0"
    // InternalAssembler.g:1739:1: rule__Substraction__Group__0 : rule__Substraction__Group__0__Impl rule__Substraction__Group__1 ;
    public final void rule__Substraction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1743:1: ( rule__Substraction__Group__0__Impl rule__Substraction__Group__1 )
            // InternalAssembler.g:1744:2: rule__Substraction__Group__0__Impl rule__Substraction__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Substraction__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Substraction__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group__0"


    // $ANTLR start "rule__Substraction__Group__0__Impl"
    // InternalAssembler.g:1751:1: rule__Substraction__Group__0__Impl : ( ruleLeftShift ) ;
    public final void rule__Substraction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1755:1: ( ( ruleLeftShift ) )
            // InternalAssembler.g:1756:1: ( ruleLeftShift )
            {
            // InternalAssembler.g:1756:1: ( ruleLeftShift )
            // InternalAssembler.g:1757:2: ruleLeftShift
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLeftShift();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group__0__Impl"


    // $ANTLR start "rule__Substraction__Group__1"
    // InternalAssembler.g:1766:1: rule__Substraction__Group__1 : rule__Substraction__Group__1__Impl ;
    public final void rule__Substraction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1770:1: ( rule__Substraction__Group__1__Impl )
            // InternalAssembler.g:1771:2: rule__Substraction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Substraction__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group__1"


    // $ANTLR start "rule__Substraction__Group__1__Impl"
    // InternalAssembler.g:1777:1: rule__Substraction__Group__1__Impl : ( ( rule__Substraction__Group_1__0 )* ) ;
    public final void rule__Substraction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1781:1: ( ( ( rule__Substraction__Group_1__0 )* ) )
            // InternalAssembler.g:1782:1: ( ( rule__Substraction__Group_1__0 )* )
            {
            // InternalAssembler.g:1782:1: ( ( rule__Substraction__Group_1__0 )* )
            // InternalAssembler.g:1783:2: ( rule__Substraction__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubstractionAccess().getGroup_1()); 
            }
            // InternalAssembler.g:1784:2: ( rule__Substraction__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==16) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalAssembler.g:1784:3: rule__Substraction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__Substraction__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubstractionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group__1__Impl"


    // $ANTLR start "rule__Substraction__Group_1__0"
    // InternalAssembler.g:1793:1: rule__Substraction__Group_1__0 : rule__Substraction__Group_1__0__Impl rule__Substraction__Group_1__1 ;
    public final void rule__Substraction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1797:1: ( rule__Substraction__Group_1__0__Impl rule__Substraction__Group_1__1 )
            // InternalAssembler.g:1798:2: rule__Substraction__Group_1__0__Impl rule__Substraction__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__Substraction__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Substraction__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group_1__0"


    // $ANTLR start "rule__Substraction__Group_1__0__Impl"
    // InternalAssembler.g:1805:1: rule__Substraction__Group_1__0__Impl : ( () ) ;
    public final void rule__Substraction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1809:1: ( ( () ) )
            // InternalAssembler.g:1810:1: ( () )
            {
            // InternalAssembler.g:1810:1: ( () )
            // InternalAssembler.g:1811:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0()); 
            }
            // InternalAssembler.g:1812:2: ()
            // InternalAssembler.g:1812:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group_1__0__Impl"


    // $ANTLR start "rule__Substraction__Group_1__1"
    // InternalAssembler.g:1820:1: rule__Substraction__Group_1__1 : rule__Substraction__Group_1__1__Impl rule__Substraction__Group_1__2 ;
    public final void rule__Substraction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1824:1: ( rule__Substraction__Group_1__1__Impl rule__Substraction__Group_1__2 )
            // InternalAssembler.g:1825:2: rule__Substraction__Group_1__1__Impl rule__Substraction__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Substraction__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Substraction__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group_1__1"


    // $ANTLR start "rule__Substraction__Group_1__1__Impl"
    // InternalAssembler.g:1832:1: rule__Substraction__Group_1__1__Impl : ( ( '-' ) ) ;
    public final void rule__Substraction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1836:1: ( ( ( '-' ) ) )
            // InternalAssembler.g:1837:1: ( ( '-' ) )
            {
            // InternalAssembler.g:1837:1: ( ( '-' ) )
            // InternalAssembler.g:1838:2: ( '-' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1()); 
            }
            // InternalAssembler.g:1839:2: ( '-' )
            // InternalAssembler.g:1839:3: '-'
            {
            match(input,16,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group_1__1__Impl"


    // $ANTLR start "rule__Substraction__Group_1__2"
    // InternalAssembler.g:1847:1: rule__Substraction__Group_1__2 : rule__Substraction__Group_1__2__Impl ;
    public final void rule__Substraction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1851:1: ( rule__Substraction__Group_1__2__Impl )
            // InternalAssembler.g:1852:2: rule__Substraction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Substraction__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group_1__2"


    // $ANTLR start "rule__Substraction__Group_1__2__Impl"
    // InternalAssembler.g:1858:1: rule__Substraction__Group_1__2__Impl : ( ( rule__Substraction__RightAssignment_1_2 ) ) ;
    public final void rule__Substraction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1862:1: ( ( ( rule__Substraction__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1863:1: ( ( rule__Substraction__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1863:1: ( ( rule__Substraction__RightAssignment_1_2 ) )
            // InternalAssembler.g:1864:2: ( rule__Substraction__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubstractionAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:1865:2: ( rule__Substraction__RightAssignment_1_2 )
            // InternalAssembler.g:1865:3: rule__Substraction__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Substraction__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubstractionAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__Group_1__2__Impl"


    // $ANTLR start "rule__LeftShift__Group__0"
    // InternalAssembler.g:1874:1: rule__LeftShift__Group__0 : rule__LeftShift__Group__0__Impl rule__LeftShift__Group__1 ;
    public final void rule__LeftShift__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1878:1: ( rule__LeftShift__Group__0__Impl rule__LeftShift__Group__1 )
            // InternalAssembler.g:1879:2: rule__LeftShift__Group__0__Impl rule__LeftShift__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__LeftShift__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group__0"


    // $ANTLR start "rule__LeftShift__Group__0__Impl"
    // InternalAssembler.g:1886:1: rule__LeftShift__Group__0__Impl : ( ruleRigthShift ) ;
    public final void rule__LeftShift__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1890:1: ( ( ruleRigthShift ) )
            // InternalAssembler.g:1891:1: ( ruleRigthShift )
            {
            // InternalAssembler.g:1891:1: ( ruleRigthShift )
            // InternalAssembler.g:1892:2: ruleRigthShift
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLeftShiftAccess().getRigthShiftParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRigthShift();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLeftShiftAccess().getRigthShiftParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group__0__Impl"


    // $ANTLR start "rule__LeftShift__Group__1"
    // InternalAssembler.g:1901:1: rule__LeftShift__Group__1 : rule__LeftShift__Group__1__Impl ;
    public final void rule__LeftShift__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1905:1: ( rule__LeftShift__Group__1__Impl )
            // InternalAssembler.g:1906:2: rule__LeftShift__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group__1"


    // $ANTLR start "rule__LeftShift__Group__1__Impl"
    // InternalAssembler.g:1912:1: rule__LeftShift__Group__1__Impl : ( ( rule__LeftShift__Group_1__0 )* ) ;
    public final void rule__LeftShift__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1916:1: ( ( ( rule__LeftShift__Group_1__0 )* ) )
            // InternalAssembler.g:1917:1: ( ( rule__LeftShift__Group_1__0 )* )
            {
            // InternalAssembler.g:1917:1: ( ( rule__LeftShift__Group_1__0 )* )
            // InternalAssembler.g:1918:2: ( rule__LeftShift__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLeftShiftAccess().getGroup_1()); 
            }
            // InternalAssembler.g:1919:2: ( rule__LeftShift__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==17) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalAssembler.g:1919:3: rule__LeftShift__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__LeftShift__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLeftShiftAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group__1__Impl"


    // $ANTLR start "rule__LeftShift__Group_1__0"
    // InternalAssembler.g:1928:1: rule__LeftShift__Group_1__0 : rule__LeftShift__Group_1__0__Impl rule__LeftShift__Group_1__1 ;
    public final void rule__LeftShift__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1932:1: ( rule__LeftShift__Group_1__0__Impl rule__LeftShift__Group_1__1 )
            // InternalAssembler.g:1933:2: rule__LeftShift__Group_1__0__Impl rule__LeftShift__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__LeftShift__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group_1__0"


    // $ANTLR start "rule__LeftShift__Group_1__0__Impl"
    // InternalAssembler.g:1940:1: rule__LeftShift__Group_1__0__Impl : ( () ) ;
    public final void rule__LeftShift__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1944:1: ( ( () ) )
            // InternalAssembler.g:1945:1: ( () )
            {
            // InternalAssembler.g:1945:1: ( () )
            // InternalAssembler.g:1946:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0()); 
            }
            // InternalAssembler.g:1947:2: ()
            // InternalAssembler.g:1947:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group_1__0__Impl"


    // $ANTLR start "rule__LeftShift__Group_1__1"
    // InternalAssembler.g:1955:1: rule__LeftShift__Group_1__1 : rule__LeftShift__Group_1__1__Impl rule__LeftShift__Group_1__2 ;
    public final void rule__LeftShift__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1959:1: ( rule__LeftShift__Group_1__1__Impl rule__LeftShift__Group_1__2 )
            // InternalAssembler.g:1960:2: rule__LeftShift__Group_1__1__Impl rule__LeftShift__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__LeftShift__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group_1__1"


    // $ANTLR start "rule__LeftShift__Group_1__1__Impl"
    // InternalAssembler.g:1967:1: rule__LeftShift__Group_1__1__Impl : ( '<<' ) ;
    public final void rule__LeftShift__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1971:1: ( ( '<<' ) )
            // InternalAssembler.g:1972:1: ( '<<' )
            {
            // InternalAssembler.g:1972:1: ( '<<' )
            // InternalAssembler.g:1973:2: '<<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group_1__1__Impl"


    // $ANTLR start "rule__LeftShift__Group_1__2"
    // InternalAssembler.g:1982:1: rule__LeftShift__Group_1__2 : rule__LeftShift__Group_1__2__Impl ;
    public final void rule__LeftShift__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1986:1: ( rule__LeftShift__Group_1__2__Impl )
            // InternalAssembler.g:1987:2: rule__LeftShift__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group_1__2"


    // $ANTLR start "rule__LeftShift__Group_1__2__Impl"
    // InternalAssembler.g:1993:1: rule__LeftShift__Group_1__2__Impl : ( ( rule__LeftShift__RightAssignment_1_2 ) ) ;
    public final void rule__LeftShift__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1997:1: ( ( ( rule__LeftShift__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1998:1: ( ( rule__LeftShift__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1998:1: ( ( rule__LeftShift__RightAssignment_1_2 ) )
            // InternalAssembler.g:1999:2: ( rule__LeftShift__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLeftShiftAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:2000:2: ( rule__LeftShift__RightAssignment_1_2 )
            // InternalAssembler.g:2000:3: rule__LeftShift__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__LeftShift__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLeftShiftAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__Group_1__2__Impl"


    // $ANTLR start "rule__RigthShift__Group__0"
    // InternalAssembler.g:2009:1: rule__RigthShift__Group__0 : rule__RigthShift__Group__0__Impl rule__RigthShift__Group__1 ;
    public final void rule__RigthShift__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2013:1: ( rule__RigthShift__Group__0__Impl rule__RigthShift__Group__1 )
            // InternalAssembler.g:2014:2: rule__RigthShift__Group__0__Impl rule__RigthShift__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__RigthShift__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group__0"


    // $ANTLR start "rule__RigthShift__Group__0__Impl"
    // InternalAssembler.g:2021:1: rule__RigthShift__Group__0__Impl : ( ruleNegate ) ;
    public final void rule__RigthShift__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2025:1: ( ( ruleNegate ) )
            // InternalAssembler.g:2026:1: ( ruleNegate )
            {
            // InternalAssembler.g:2026:1: ( ruleNegate )
            // InternalAssembler.g:2027:2: ruleNegate
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRigthShiftAccess().getNegateParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNegate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRigthShiftAccess().getNegateParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group__0__Impl"


    // $ANTLR start "rule__RigthShift__Group__1"
    // InternalAssembler.g:2036:1: rule__RigthShift__Group__1 : rule__RigthShift__Group__1__Impl ;
    public final void rule__RigthShift__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2040:1: ( rule__RigthShift__Group__1__Impl )
            // InternalAssembler.g:2041:2: rule__RigthShift__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group__1"


    // $ANTLR start "rule__RigthShift__Group__1__Impl"
    // InternalAssembler.g:2047:1: rule__RigthShift__Group__1__Impl : ( ( rule__RigthShift__Group_1__0 )* ) ;
    public final void rule__RigthShift__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2051:1: ( ( ( rule__RigthShift__Group_1__0 )* ) )
            // InternalAssembler.g:2052:1: ( ( rule__RigthShift__Group_1__0 )* )
            {
            // InternalAssembler.g:2052:1: ( ( rule__RigthShift__Group_1__0 )* )
            // InternalAssembler.g:2053:2: ( rule__RigthShift__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRigthShiftAccess().getGroup_1()); 
            }
            // InternalAssembler.g:2054:2: ( rule__RigthShift__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==18) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAssembler.g:2054:3: rule__RigthShift__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__RigthShift__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRigthShiftAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group__1__Impl"


    // $ANTLR start "rule__RigthShift__Group_1__0"
    // InternalAssembler.g:2063:1: rule__RigthShift__Group_1__0 : rule__RigthShift__Group_1__0__Impl rule__RigthShift__Group_1__1 ;
    public final void rule__RigthShift__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2067:1: ( rule__RigthShift__Group_1__0__Impl rule__RigthShift__Group_1__1 )
            // InternalAssembler.g:2068:2: rule__RigthShift__Group_1__0__Impl rule__RigthShift__Group_1__1
            {
            pushFollow(FOLLOW_22);
            rule__RigthShift__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group_1__0"


    // $ANTLR start "rule__RigthShift__Group_1__0__Impl"
    // InternalAssembler.g:2075:1: rule__RigthShift__Group_1__0__Impl : ( () ) ;
    public final void rule__RigthShift__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2079:1: ( ( () ) )
            // InternalAssembler.g:2080:1: ( () )
            {
            // InternalAssembler.g:2080:1: ( () )
            // InternalAssembler.g:2081:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRigthShiftAccess().getRigthShiftLeftAction_1_0()); 
            }
            // InternalAssembler.g:2082:2: ()
            // InternalAssembler.g:2082:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRigthShiftAccess().getRigthShiftLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group_1__0__Impl"


    // $ANTLR start "rule__RigthShift__Group_1__1"
    // InternalAssembler.g:2090:1: rule__RigthShift__Group_1__1 : rule__RigthShift__Group_1__1__Impl rule__RigthShift__Group_1__2 ;
    public final void rule__RigthShift__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2094:1: ( rule__RigthShift__Group_1__1__Impl rule__RigthShift__Group_1__2 )
            // InternalAssembler.g:2095:2: rule__RigthShift__Group_1__1__Impl rule__RigthShift__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__RigthShift__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group_1__1"


    // $ANTLR start "rule__RigthShift__Group_1__1__Impl"
    // InternalAssembler.g:2102:1: rule__RigthShift__Group_1__1__Impl : ( '>>' ) ;
    public final void rule__RigthShift__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2106:1: ( ( '>>' ) )
            // InternalAssembler.g:2107:1: ( '>>' )
            {
            // InternalAssembler.g:2107:1: ( '>>' )
            // InternalAssembler.g:2108:2: '>>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRigthShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRigthShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group_1__1__Impl"


    // $ANTLR start "rule__RigthShift__Group_1__2"
    // InternalAssembler.g:2117:1: rule__RigthShift__Group_1__2 : rule__RigthShift__Group_1__2__Impl ;
    public final void rule__RigthShift__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2121:1: ( rule__RigthShift__Group_1__2__Impl )
            // InternalAssembler.g:2122:2: rule__RigthShift__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group_1__2"


    // $ANTLR start "rule__RigthShift__Group_1__2__Impl"
    // InternalAssembler.g:2128:1: rule__RigthShift__Group_1__2__Impl : ( ( rule__RigthShift__NegateAssignment_1_2 ) ) ;
    public final void rule__RigthShift__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2132:1: ( ( ( rule__RigthShift__NegateAssignment_1_2 ) ) )
            // InternalAssembler.g:2133:1: ( ( rule__RigthShift__NegateAssignment_1_2 ) )
            {
            // InternalAssembler.g:2133:1: ( ( rule__RigthShift__NegateAssignment_1_2 ) )
            // InternalAssembler.g:2134:2: ( rule__RigthShift__NegateAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRigthShiftAccess().getNegateAssignment_1_2()); 
            }
            // InternalAssembler.g:2135:2: ( rule__RigthShift__NegateAssignment_1_2 )
            // InternalAssembler.g:2135:3: rule__RigthShift__NegateAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__RigthShift__NegateAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRigthShiftAccess().getNegateAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__Group_1__2__Impl"


    // $ANTLR start "rule__Negate__Group__0"
    // InternalAssembler.g:2144:1: rule__Negate__Group__0 : rule__Negate__Group__0__Impl rule__Negate__Group__1 ;
    public final void rule__Negate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2148:1: ( rule__Negate__Group__0__Impl rule__Negate__Group__1 )
            // InternalAssembler.g:2149:2: rule__Negate__Group__0__Impl rule__Negate__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Negate__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Negate__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group__0"


    // $ANTLR start "rule__Negate__Group__0__Impl"
    // InternalAssembler.g:2156:1: rule__Negate__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Negate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2160:1: ( ( ruleAnd ) )
            // InternalAssembler.g:2161:1: ( ruleAnd )
            {
            // InternalAssembler.g:2161:1: ( ruleAnd )
            // InternalAssembler.g:2162:2: ruleAnd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNegateAccess().getAndParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNegateAccess().getAndParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group__0__Impl"


    // $ANTLR start "rule__Negate__Group__1"
    // InternalAssembler.g:2171:1: rule__Negate__Group__1 : rule__Negate__Group__1__Impl ;
    public final void rule__Negate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2175:1: ( rule__Negate__Group__1__Impl )
            // InternalAssembler.g:2176:2: rule__Negate__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Negate__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group__1"


    // $ANTLR start "rule__Negate__Group__1__Impl"
    // InternalAssembler.g:2182:1: rule__Negate__Group__1__Impl : ( ( rule__Negate__Group_1__0 )* ) ;
    public final void rule__Negate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2186:1: ( ( ( rule__Negate__Group_1__0 )* ) )
            // InternalAssembler.g:2187:1: ( ( rule__Negate__Group_1__0 )* )
            {
            // InternalAssembler.g:2187:1: ( ( rule__Negate__Group_1__0 )* )
            // InternalAssembler.g:2188:2: ( rule__Negate__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNegateAccess().getGroup_1()); 
            }
            // InternalAssembler.g:2189:2: ( rule__Negate__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAssembler.g:2189:3: rule__Negate__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__Negate__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNegateAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group__1__Impl"


    // $ANTLR start "rule__Negate__Group_1__0"
    // InternalAssembler.g:2198:1: rule__Negate__Group_1__0 : rule__Negate__Group_1__0__Impl rule__Negate__Group_1__1 ;
    public final void rule__Negate__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2202:1: ( rule__Negate__Group_1__0__Impl rule__Negate__Group_1__1 )
            // InternalAssembler.g:2203:2: rule__Negate__Group_1__0__Impl rule__Negate__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__Negate__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Negate__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group_1__0"


    // $ANTLR start "rule__Negate__Group_1__0__Impl"
    // InternalAssembler.g:2210:1: rule__Negate__Group_1__0__Impl : ( () ) ;
    public final void rule__Negate__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2214:1: ( ( () ) )
            // InternalAssembler.g:2215:1: ( () )
            {
            // InternalAssembler.g:2215:1: ( () )
            // InternalAssembler.g:2216:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNegateAccess().getNegateLeftAction_1_0()); 
            }
            // InternalAssembler.g:2217:2: ()
            // InternalAssembler.g:2217:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNegateAccess().getNegateLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group_1__0__Impl"


    // $ANTLR start "rule__Negate__Group_1__1"
    // InternalAssembler.g:2225:1: rule__Negate__Group_1__1 : rule__Negate__Group_1__1__Impl rule__Negate__Group_1__2 ;
    public final void rule__Negate__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2229:1: ( rule__Negate__Group_1__1__Impl rule__Negate__Group_1__2 )
            // InternalAssembler.g:2230:2: rule__Negate__Group_1__1__Impl rule__Negate__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Negate__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Negate__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group_1__1"


    // $ANTLR start "rule__Negate__Group_1__1__Impl"
    // InternalAssembler.g:2237:1: rule__Negate__Group_1__1__Impl : ( '~' ) ;
    public final void rule__Negate__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2241:1: ( ( '~' ) )
            // InternalAssembler.g:2242:1: ( '~' )
            {
            // InternalAssembler.g:2242:1: ( '~' )
            // InternalAssembler.g:2243:2: '~'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNegateAccess().getTildeKeyword_1_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNegateAccess().getTildeKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group_1__1__Impl"


    // $ANTLR start "rule__Negate__Group_1__2"
    // InternalAssembler.g:2252:1: rule__Negate__Group_1__2 : rule__Negate__Group_1__2__Impl ;
    public final void rule__Negate__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2256:1: ( rule__Negate__Group_1__2__Impl )
            // InternalAssembler.g:2257:2: rule__Negate__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Negate__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group_1__2"


    // $ANTLR start "rule__Negate__Group_1__2__Impl"
    // InternalAssembler.g:2263:1: rule__Negate__Group_1__2__Impl : ( ( rule__Negate__RightAssignment_1_2 ) ) ;
    public final void rule__Negate__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2267:1: ( ( ( rule__Negate__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:2268:1: ( ( rule__Negate__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:2268:1: ( ( rule__Negate__RightAssignment_1_2 ) )
            // InternalAssembler.g:2269:2: ( rule__Negate__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNegateAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:2270:2: ( rule__Negate__RightAssignment_1_2 )
            // InternalAssembler.g:2270:3: rule__Negate__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Negate__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNegateAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__Group_1__2__Impl"


    // $ANTLR start "rule__And__Group__0"
    // InternalAssembler.g:2279:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2283:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalAssembler.g:2284:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__And__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0"


    // $ANTLR start "rule__And__Group__0__Impl"
    // InternalAssembler.g:2291:1: rule__And__Group__0__Impl : ( ruleOr ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2295:1: ( ( ruleOr ) )
            // InternalAssembler.g:2296:1: ( ruleOr )
            {
            // InternalAssembler.g:2296:1: ( ruleOr )
            // InternalAssembler.g:2297:2: ruleOr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getOrParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getOrParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0__Impl"


    // $ANTLR start "rule__And__Group__1"
    // InternalAssembler.g:2306:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2310:1: ( rule__And__Group__1__Impl )
            // InternalAssembler.g:2311:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1"


    // $ANTLR start "rule__And__Group__1__Impl"
    // InternalAssembler.g:2317:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2321:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalAssembler.g:2322:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalAssembler.g:2322:1: ( ( rule__And__Group_1__0 )* )
            // InternalAssembler.g:2323:2: ( rule__And__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getGroup_1()); 
            }
            // InternalAssembler.g:2324:2: ( rule__And__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==20) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalAssembler.g:2324:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__And__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1__Impl"


    // $ANTLR start "rule__And__Group_1__0"
    // InternalAssembler.g:2333:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2337:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalAssembler.g:2338:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_26);
            rule__And__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0"


    // $ANTLR start "rule__And__Group_1__0__Impl"
    // InternalAssembler.g:2345:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2349:1: ( ( () ) )
            // InternalAssembler.g:2350:1: ( () )
            {
            // InternalAssembler.g:2350:1: ( () )
            // InternalAssembler.g:2351:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            }
            // InternalAssembler.g:2352:2: ()
            // InternalAssembler.g:2352:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0__Impl"


    // $ANTLR start "rule__And__Group_1__1"
    // InternalAssembler.g:2360:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2364:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalAssembler.g:2365:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__And__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1"


    // $ANTLR start "rule__And__Group_1__1__Impl"
    // InternalAssembler.g:2372:1: rule__And__Group_1__1__Impl : ( '&&' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2376:1: ( ( '&&' ) )
            // InternalAssembler.g:2377:1: ( '&&' )
            {
            // InternalAssembler.g:2377:1: ( '&&' )
            // InternalAssembler.g:2378:2: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1__Impl"


    // $ANTLR start "rule__And__Group_1__2"
    // InternalAssembler.g:2387:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2391:1: ( rule__And__Group_1__2__Impl )
            // InternalAssembler.g:2392:2: rule__And__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2"


    // $ANTLR start "rule__And__Group_1__2__Impl"
    // InternalAssembler.g:2398:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2402:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:2403:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:2403:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalAssembler.g:2404:2: ( rule__And__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:2405:2: ( rule__And__RightAssignment_1_2 )
            // InternalAssembler.g:2405:3: rule__And__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__And__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2__Impl"


    // $ANTLR start "rule__Or__Group__0"
    // InternalAssembler.g:2414:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2418:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalAssembler.g:2419:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__Or__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0"


    // $ANTLR start "rule__Or__Group__0__Impl"
    // InternalAssembler.g:2426:1: rule__Or__Group__0__Impl : ( ruleXor ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2430:1: ( ( ruleXor ) )
            // InternalAssembler.g:2431:1: ( ruleXor )
            {
            // InternalAssembler.g:2431:1: ( ruleXor )
            // InternalAssembler.g:2432:2: ruleXor
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getXorParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXor();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getXorParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0__Impl"


    // $ANTLR start "rule__Or__Group__1"
    // InternalAssembler.g:2441:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2445:1: ( rule__Or__Group__1__Impl )
            // InternalAssembler.g:2446:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1"


    // $ANTLR start "rule__Or__Group__1__Impl"
    // InternalAssembler.g:2452:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2456:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalAssembler.g:2457:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalAssembler.g:2457:1: ( ( rule__Or__Group_1__0 )* )
            // InternalAssembler.g:2458:2: ( rule__Or__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getGroup_1()); 
            }
            // InternalAssembler.g:2459:2: ( rule__Or__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==21) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAssembler.g:2459:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__Or__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1__Impl"


    // $ANTLR start "rule__Or__Group_1__0"
    // InternalAssembler.g:2468:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2472:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalAssembler.g:2473:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__Or__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0"


    // $ANTLR start "rule__Or__Group_1__0__Impl"
    // InternalAssembler.g:2480:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2484:1: ( ( () ) )
            // InternalAssembler.g:2485:1: ( () )
            {
            // InternalAssembler.g:2485:1: ( () )
            // InternalAssembler.g:2486:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            }
            // InternalAssembler.g:2487:2: ()
            // InternalAssembler.g:2487:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0__Impl"


    // $ANTLR start "rule__Or__Group_1__1"
    // InternalAssembler.g:2495:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2499:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalAssembler.g:2500:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Or__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1"


    // $ANTLR start "rule__Or__Group_1__1__Impl"
    // InternalAssembler.g:2507:1: rule__Or__Group_1__1__Impl : ( '||' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2511:1: ( ( '||' ) )
            // InternalAssembler.g:2512:1: ( '||' )
            {
            // InternalAssembler.g:2512:1: ( '||' )
            // InternalAssembler.g:2513:2: '||'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1__Impl"


    // $ANTLR start "rule__Or__Group_1__2"
    // InternalAssembler.g:2522:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2526:1: ( rule__Or__Group_1__2__Impl )
            // InternalAssembler.g:2527:2: rule__Or__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2"


    // $ANTLR start "rule__Or__Group_1__2__Impl"
    // InternalAssembler.g:2533:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2537:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:2538:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:2538:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalAssembler.g:2539:2: ( rule__Or__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:2540:2: ( rule__Or__RightAssignment_1_2 )
            // InternalAssembler.g:2540:3: rule__Or__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Or__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2__Impl"


    // $ANTLR start "rule__Xor__Group__0"
    // InternalAssembler.g:2549:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2553:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalAssembler.g:2554:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__Xor__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Xor__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__0"


    // $ANTLR start "rule__Xor__Group__0__Impl"
    // InternalAssembler.g:2561:1: rule__Xor__Group__0__Impl : ( rulePrimary ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2565:1: ( ( rulePrimary ) )
            // InternalAssembler.g:2566:1: ( rulePrimary )
            {
            // InternalAssembler.g:2566:1: ( rulePrimary )
            // InternalAssembler.g:2567:2: rulePrimary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__0__Impl"


    // $ANTLR start "rule__Xor__Group__1"
    // InternalAssembler.g:2576:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2580:1: ( rule__Xor__Group__1__Impl )
            // InternalAssembler.g:2581:2: rule__Xor__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__1"


    // $ANTLR start "rule__Xor__Group__1__Impl"
    // InternalAssembler.g:2587:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2591:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalAssembler.g:2592:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalAssembler.g:2592:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalAssembler.g:2593:2: ( rule__Xor__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorAccess().getGroup_1()); 
            }
            // InternalAssembler.g:2594:2: ( rule__Xor__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAssembler.g:2594:3: rule__Xor__Group_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__Xor__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__1__Impl"


    // $ANTLR start "rule__Xor__Group_1__0"
    // InternalAssembler.g:2603:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2607:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalAssembler.g:2608:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Xor__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__0"


    // $ANTLR start "rule__Xor__Group_1__0__Impl"
    // InternalAssembler.g:2615:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2619:1: ( ( () ) )
            // InternalAssembler.g:2620:1: ( () )
            {
            // InternalAssembler.g:2620:1: ( () )
            // InternalAssembler.g:2621:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorAccess().getOrLeftAction_1_0()); 
            }
            // InternalAssembler.g:2622:2: ()
            // InternalAssembler.g:2622:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorAccess().getOrLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__0__Impl"


    // $ANTLR start "rule__Xor__Group_1__1"
    // InternalAssembler.g:2630:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2634:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalAssembler.g:2635:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Xor__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__1"


    // $ANTLR start "rule__Xor__Group_1__1__Impl"
    // InternalAssembler.g:2642:1: rule__Xor__Group_1__1__Impl : ( '^' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2646:1: ( ( '^' ) )
            // InternalAssembler.g:2647:1: ( '^' )
            {
            // InternalAssembler.g:2647:1: ( '^' )
            // InternalAssembler.g:2648:2: '^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__1__Impl"


    // $ANTLR start "rule__Xor__Group_1__2"
    // InternalAssembler.g:2657:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2661:1: ( rule__Xor__Group_1__2__Impl )
            // InternalAssembler.g:2662:2: rule__Xor__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__2"


    // $ANTLR start "rule__Xor__Group_1__2__Impl"
    // InternalAssembler.g:2668:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2672:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:2673:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:2673:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalAssembler.g:2674:2: ( rule__Xor__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            }
            // InternalAssembler.g:2675:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalAssembler.g:2675:3: rule__Xor__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Xor__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__2__Impl"


    // $ANTLR start "rule__Primary__Group_6__0"
    // InternalAssembler.g:2684:1: rule__Primary__Group_6__0 : rule__Primary__Group_6__0__Impl rule__Primary__Group_6__1 ;
    public final void rule__Primary__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2688:1: ( rule__Primary__Group_6__0__Impl rule__Primary__Group_6__1 )
            // InternalAssembler.g:2689:2: rule__Primary__Group_6__0__Impl rule__Primary__Group_6__1
            {
            pushFollow(FOLLOW_11);
            rule__Primary__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Primary__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_6__0"


    // $ANTLR start "rule__Primary__Group_6__0__Impl"
    // InternalAssembler.g:2696:1: rule__Primary__Group_6__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2700:1: ( ( '(' ) )
            // InternalAssembler.g:2701:1: ( '(' )
            {
            // InternalAssembler.g:2701:1: ( '(' )
            // InternalAssembler.g:2702:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_6_0()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_6__0__Impl"


    // $ANTLR start "rule__Primary__Group_6__1"
    // InternalAssembler.g:2711:1: rule__Primary__Group_6__1 : rule__Primary__Group_6__1__Impl rule__Primary__Group_6__2 ;
    public final void rule__Primary__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2715:1: ( rule__Primary__Group_6__1__Impl rule__Primary__Group_6__2 )
            // InternalAssembler.g:2716:2: rule__Primary__Group_6__1__Impl rule__Primary__Group_6__2
            {
            pushFollow(FOLLOW_32);
            rule__Primary__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Primary__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_6__1"


    // $ANTLR start "rule__Primary__Group_6__1__Impl"
    // InternalAssembler.g:2723:1: rule__Primary__Group_6__1__Impl : ( ruleMultiplication ) ;
    public final void rule__Primary__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2727:1: ( ( ruleMultiplication ) )
            // InternalAssembler.g:2728:1: ( ruleMultiplication )
            {
            // InternalAssembler.g:2728:1: ( ruleMultiplication )
            // InternalAssembler.g:2729:2: ruleMultiplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_6_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_6__1__Impl"


    // $ANTLR start "rule__Primary__Group_6__2"
    // InternalAssembler.g:2738:1: rule__Primary__Group_6__2 : rule__Primary__Group_6__2__Impl ;
    public final void rule__Primary__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2742:1: ( rule__Primary__Group_6__2__Impl )
            // InternalAssembler.g:2743:2: rule__Primary__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_6__2"


    // $ANTLR start "rule__Primary__Group_6__2__Impl"
    // InternalAssembler.g:2749:1: rule__Primary__Group_6__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2753:1: ( ( ')' ) )
            // InternalAssembler.g:2754:1: ( ')' )
            {
            // InternalAssembler.g:2754:1: ( ')' )
            // InternalAssembler.g:2755:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_6_2()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_6__2__Impl"


    // $ANTLR start "rule__DecimalValue__Group__0"
    // InternalAssembler.g:2765:1: rule__DecimalValue__Group__0 : rule__DecimalValue__Group__0__Impl rule__DecimalValue__Group__1 ;
    public final void rule__DecimalValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2769:1: ( rule__DecimalValue__Group__0__Impl rule__DecimalValue__Group__1 )
            // InternalAssembler.g:2770:2: rule__DecimalValue__Group__0__Impl rule__DecimalValue__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__DecimalValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DecimalValue__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalValue__Group__0"


    // $ANTLR start "rule__DecimalValue__Group__0__Impl"
    // InternalAssembler.g:2777:1: rule__DecimalValue__Group__0__Impl : ( ( rule__DecimalValue__IsNegativeAssignment_0 )? ) ;
    public final void rule__DecimalValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2781:1: ( ( ( rule__DecimalValue__IsNegativeAssignment_0 )? ) )
            // InternalAssembler.g:2782:1: ( ( rule__DecimalValue__IsNegativeAssignment_0 )? )
            {
            // InternalAssembler.g:2782:1: ( ( rule__DecimalValue__IsNegativeAssignment_0 )? )
            // InternalAssembler.g:2783:2: ( rule__DecimalValue__IsNegativeAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalValueAccess().getIsNegativeAssignment_0()); 
            }
            // InternalAssembler.g:2784:2: ( rule__DecimalValue__IsNegativeAssignment_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==16) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAssembler.g:2784:3: rule__DecimalValue__IsNegativeAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DecimalValue__IsNegativeAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalValueAccess().getIsNegativeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalValue__Group__0__Impl"


    // $ANTLR start "rule__DecimalValue__Group__1"
    // InternalAssembler.g:2792:1: rule__DecimalValue__Group__1 : rule__DecimalValue__Group__1__Impl ;
    public final void rule__DecimalValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2796:1: ( rule__DecimalValue__Group__1__Impl )
            // InternalAssembler.g:2797:2: rule__DecimalValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DecimalValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalValue__Group__1"


    // $ANTLR start "rule__DecimalValue__Group__1__Impl"
    // InternalAssembler.g:2803:1: rule__DecimalValue__Group__1__Impl : ( ( rule__DecimalValue__ValueAssignment_1 ) ) ;
    public final void rule__DecimalValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2807:1: ( ( ( rule__DecimalValue__ValueAssignment_1 ) ) )
            // InternalAssembler.g:2808:1: ( ( rule__DecimalValue__ValueAssignment_1 ) )
            {
            // InternalAssembler.g:2808:1: ( ( rule__DecimalValue__ValueAssignment_1 ) )
            // InternalAssembler.g:2809:2: ( rule__DecimalValue__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalValueAccess().getValueAssignment_1()); 
            }
            // InternalAssembler.g:2810:2: ( rule__DecimalValue__ValueAssignment_1 )
            // InternalAssembler.g:2810:3: rule__DecimalValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DecimalValue__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalValueAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalValue__Group__1__Impl"


    // $ANTLR start "rule__Model__SourceLinesAssignment"
    // InternalAssembler.g:2819:1: rule__Model__SourceLinesAssignment : ( ruleSourceLine ) ;
    public final void rule__Model__SourceLinesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2823:1: ( ( ruleSourceLine ) )
            // InternalAssembler.g:2824:2: ( ruleSourceLine )
            {
            // InternalAssembler.g:2824:2: ( ruleSourceLine )
            // InternalAssembler.g:2825:3: ruleSourceLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSourceLinesSourceLineParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSourceLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSourceLinesSourceLineParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__SourceLinesAssignment"


    // $ANTLR start "rule__SourceLine__LineContentAssignment_0"
    // InternalAssembler.g:2834:1: rule__SourceLine__LineContentAssignment_0 : ( ruleBlankLine ) ;
    public final void rule__SourceLine__LineContentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2838:1: ( ( ruleBlankLine ) )
            // InternalAssembler.g:2839:2: ( ruleBlankLine )
            {
            // InternalAssembler.g:2839:2: ( ruleBlankLine )
            // InternalAssembler.g:2840:3: ruleBlankLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSourceLineAccess().getLineContentBlankLineParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBlankLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSourceLineAccess().getLineContentBlankLineParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceLine__LineContentAssignment_0"


    // $ANTLR start "rule__SourceLine__LineContentAssignment_1"
    // InternalAssembler.g:2849:1: rule__SourceLine__LineContentAssignment_1 : ( ruleCommentLine ) ;
    public final void rule__SourceLine__LineContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2853:1: ( ( ruleCommentLine ) )
            // InternalAssembler.g:2854:2: ( ruleCommentLine )
            {
            // InternalAssembler.g:2854:2: ( ruleCommentLine )
            // InternalAssembler.g:2855:3: ruleCommentLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSourceLineAccess().getLineContentCommentLineParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCommentLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSourceLineAccess().getLineContentCommentLineParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceLine__LineContentAssignment_1"


    // $ANTLR start "rule__SourceLine__LineContentAssignment_2"
    // InternalAssembler.g:2864:1: rule__SourceLine__LineContentAssignment_2 : ( ruleDirectiveLine ) ;
    public final void rule__SourceLine__LineContentAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2868:1: ( ( ruleDirectiveLine ) )
            // InternalAssembler.g:2869:2: ( ruleDirectiveLine )
            {
            // InternalAssembler.g:2869:2: ( ruleDirectiveLine )
            // InternalAssembler.g:2870:3: ruleDirectiveLine
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSourceLineAccess().getLineContentDirectiveLineParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDirectiveLine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSourceLineAccess().getLineContentDirectiveLineParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SourceLine__LineContentAssignment_2"


    // $ANTLR start "rule__BlankLine__BlankLineAssignment_1"
    // InternalAssembler.g:2879:1: rule__BlankLine__BlankLineAssignment_1 : ( RULE_WS ) ;
    public final void rule__BlankLine__BlankLineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2883:1: ( ( RULE_WS ) )
            // InternalAssembler.g:2884:2: ( RULE_WS )
            {
            // InternalAssembler.g:2884:2: ( RULE_WS )
            // InternalAssembler.g:2885:3: RULE_WS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankLineAccess().getBlankLineWSTerminalRuleCall_1_0()); 
            }
            match(input,RULE_WS,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankLineAccess().getBlankLineWSTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlankLine__BlankLineAssignment_1"


    // $ANTLR start "rule__CommentLine__CommentAssignment_0"
    // InternalAssembler.g:2894:1: rule__CommentLine__CommentAssignment_0 : ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ;
    public final void rule__CommentLine__CommentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2898:1: ( ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
            // InternalAssembler.g:2899:2: ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            {
            // InternalAssembler.g:2899:2: ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            // InternalAssembler.g:2900:3: RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCommentLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_0_0()); 
            }
            match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCommentLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CommentLine__CommentAssignment_0"


    // $ANTLR start "rule__DirectiveLine__DirectiveAssignment"
    // InternalAssembler.g:2909:1: rule__DirectiveLine__DirectiveAssignment : ( ruleEquDirective ) ;
    public final void rule__DirectiveLine__DirectiveAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2913:1: ( ( ruleEquDirective ) )
            // InternalAssembler.g:2914:2: ( ruleEquDirective )
            {
            // InternalAssembler.g:2914:2: ( ruleEquDirective )
            // InternalAssembler.g:2915:3: ruleEquDirective
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDirectiveLineAccess().getDirectiveEquDirectiveParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEquDirective();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDirectiveLineAccess().getDirectiveEquDirectiveParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DirectiveLine__DirectiveAssignment"


    // $ANTLR start "rule__EquDirective__NameAssignment_0"
    // InternalAssembler.g:2924:1: rule__EquDirective__NameAssignment_0 : ( ruleIdentifierValue ) ;
    public final void rule__EquDirective__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2928:1: ( ( ruleIdentifierValue ) )
            // InternalAssembler.g:2929:2: ( ruleIdentifierValue )
            {
            // InternalAssembler.g:2929:2: ( ruleIdentifierValue )
            // InternalAssembler.g:2930:3: ruleIdentifierValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleIdentifierValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getNameIdentifierValueParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__NameAssignment_0"


    // $ANTLR start "rule__EquDirective__DirectiveAssignment_2"
    // InternalAssembler.g:2939:1: rule__EquDirective__DirectiveAssignment_2 : ( ( 'EQU' ) ) ;
    public final void rule__EquDirective__DirectiveAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2943:1: ( ( ( 'EQU' ) ) )
            // InternalAssembler.g:2944:2: ( ( 'EQU' ) )
            {
            // InternalAssembler.g:2944:2: ( ( 'EQU' ) )
            // InternalAssembler.g:2945:3: ( 'EQU' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0()); 
            }
            // InternalAssembler.g:2946:3: ( 'EQU' )
            // InternalAssembler.g:2947:4: 'EQU'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__DirectiveAssignment_2"


    // $ANTLR start "rule__EquDirective__OperandAssignment_4"
    // InternalAssembler.g:2958:1: rule__EquDirective__OperandAssignment_4 : ( ruleOperand ) ;
    public final void rule__EquDirective__OperandAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2962:1: ( ( ruleOperand ) )
            // InternalAssembler.g:2963:2: ( ruleOperand )
            {
            // InternalAssembler.g:2963:2: ( ruleOperand )
            // InternalAssembler.g:2964:3: ruleOperand
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getOperandOperandParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOperand();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getOperandOperandParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__OperandAssignment_4"


    // $ANTLR start "rule__EquDirective__CommentAssignment_6"
    // InternalAssembler.g:2973:1: rule__EquDirective__CommentAssignment_6 : ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ;
    public final void rule__EquDirective__CommentAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2977:1: ( ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
            // InternalAssembler.g:2978:2: ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            {
            // InternalAssembler.g:2978:2: ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            // InternalAssembler.g:2979:3: RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEquDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_6_0()); 
            }
            match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEquDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EquDirective__CommentAssignment_6"


    // $ANTLR start "rule__Operand__OperandAssignment_0"
    // InternalAssembler.g:2988:1: rule__Operand__OperandAssignment_0 : ( ruleMultiplication ) ;
    public final void rule__Operand__OperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2992:1: ( ( ruleMultiplication ) )
            // InternalAssembler.g:2993:2: ( ruleMultiplication )
            {
            // InternalAssembler.g:2993:2: ( ruleMultiplication )
            // InternalAssembler.g:2994:3: ruleMultiplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperandAccess().getOperandMultiplicationParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperandAccess().getOperandMultiplicationParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__OperandAssignment_0"


    // $ANTLR start "rule__Operand__OperandAssignment_1"
    // InternalAssembler.g:3003:1: rule__Operand__OperandAssignment_1 : ( ruleStringValue ) ;
    public final void rule__Operand__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3007:1: ( ( ruleStringValue ) )
            // InternalAssembler.g:3008:2: ( ruleStringValue )
            {
            // InternalAssembler.g:3008:2: ( ruleStringValue )
            // InternalAssembler.g:3009:3: ruleStringValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperandAccess().getOperandStringValueParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStringValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperandAccess().getOperandStringValueParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__OperandAssignment_1"


    // $ANTLR start "rule__Multiplication__OperationAssignment_1_1"
    // InternalAssembler.g:3018:1: rule__Multiplication__OperationAssignment_1_1 : ( ( '*' ) ) ;
    public final void rule__Multiplication__OperationAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3022:1: ( ( ( '*' ) ) )
            // InternalAssembler.g:3023:2: ( ( '*' ) )
            {
            // InternalAssembler.g:3023:2: ( ( '*' ) )
            // InternalAssembler.g:3024:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0()); 
            }
            // InternalAssembler.g:3025:3: ( '*' )
            // InternalAssembler.g:3026:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__OperationAssignment_1_1"


    // $ANTLR start "rule__Multiplication__RightAssignment_1_2"
    // InternalAssembler.g:3037:1: rule__Multiplication__RightAssignment_1_2 : ( ruleDivision ) ;
    public final void rule__Multiplication__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3041:1: ( ( ruleDivision ) )
            // InternalAssembler.g:3042:2: ( ruleDivision )
            {
            // InternalAssembler.g:3042:2: ( ruleDivision )
            // InternalAssembler.g:3043:3: ruleDivision
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDivision();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__RightAssignment_1_2"


    // $ANTLR start "rule__Division__OpretationAssignment_1_1"
    // InternalAssembler.g:3052:1: rule__Division__OpretationAssignment_1_1 : ( ( '/' ) ) ;
    public final void rule__Division__OpretationAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3056:1: ( ( ( '/' ) ) )
            // InternalAssembler.g:3057:2: ( ( '/' ) )
            {
            // InternalAssembler.g:3057:2: ( ( '/' ) )
            // InternalAssembler.g:3058:3: ( '/' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0()); 
            }
            // InternalAssembler.g:3059:3: ( '/' )
            // InternalAssembler.g:3060:4: '/'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__OpretationAssignment_1_1"


    // $ANTLR start "rule__Division__RightAssignment_1_2"
    // InternalAssembler.g:3071:1: rule__Division__RightAssignment_1_2 : ( ruleModulo ) ;
    public final void rule__Division__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3075:1: ( ( ruleModulo ) )
            // InternalAssembler.g:3076:2: ( ruleModulo )
            {
            // InternalAssembler.g:3076:2: ( ruleModulo )
            // InternalAssembler.g:3077:3: ruleModulo
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleModulo();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Division__RightAssignment_1_2"


    // $ANTLR start "rule__Modulo__OpretationAssignment_1_1"
    // InternalAssembler.g:3086:1: rule__Modulo__OpretationAssignment_1_1 : ( ( '%' ) ) ;
    public final void rule__Modulo__OpretationAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3090:1: ( ( ( '%' ) ) )
            // InternalAssembler.g:3091:2: ( ( '%' ) )
            {
            // InternalAssembler.g:3091:2: ( ( '%' ) )
            // InternalAssembler.g:3092:3: ( '%' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0()); 
            }
            // InternalAssembler.g:3093:3: ( '%' )
            // InternalAssembler.g:3094:4: '%'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__OpretationAssignment_1_1"


    // $ANTLR start "rule__Modulo__RightAssignment_1_2"
    // InternalAssembler.g:3105:1: rule__Modulo__RightAssignment_1_2 : ( ruleAddition ) ;
    public final void rule__Modulo__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3109:1: ( ( ruleAddition ) )
            // InternalAssembler.g:3110:2: ( ruleAddition )
            {
            // InternalAssembler.g:3110:2: ( ruleAddition )
            // InternalAssembler.g:3111:3: ruleAddition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modulo__RightAssignment_1_2"


    // $ANTLR start "rule__Addition__RightAssignment_1_2"
    // InternalAssembler.g:3120:1: rule__Addition__RightAssignment_1_2 : ( ruleSubstraction ) ;
    public final void rule__Addition__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3124:1: ( ( ruleSubstraction ) )
            // InternalAssembler.g:3125:2: ( ruleSubstraction )
            {
            // InternalAssembler.g:3125:2: ( ruleSubstraction )
            // InternalAssembler.g:3126:3: ruleSubstraction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSubstraction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__RightAssignment_1_2"


    // $ANTLR start "rule__Substraction__RightAssignment_1_2"
    // InternalAssembler.g:3135:1: rule__Substraction__RightAssignment_1_2 : ( ruleLeftShift ) ;
    public final void rule__Substraction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3139:1: ( ( ruleLeftShift ) )
            // InternalAssembler.g:3140:2: ( ruleLeftShift )
            {
            // InternalAssembler.g:3140:2: ( ruleLeftShift )
            // InternalAssembler.g:3141:3: ruleLeftShift
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLeftShift();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Substraction__RightAssignment_1_2"


    // $ANTLR start "rule__LeftShift__RightAssignment_1_2"
    // InternalAssembler.g:3150:1: rule__LeftShift__RightAssignment_1_2 : ( ruleRigthShift ) ;
    public final void rule__LeftShift__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3154:1: ( ( ruleRigthShift ) )
            // InternalAssembler.g:3155:2: ( ruleRigthShift )
            {
            // InternalAssembler.g:3155:2: ( ruleRigthShift )
            // InternalAssembler.g:3156:3: ruleRigthShift
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLeftShiftAccess().getRightRigthShiftParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRigthShift();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLeftShiftAccess().getRightRigthShiftParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LeftShift__RightAssignment_1_2"


    // $ANTLR start "rule__RigthShift__NegateAssignment_1_2"
    // InternalAssembler.g:3165:1: rule__RigthShift__NegateAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__RigthShift__NegateAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3169:1: ( ( rulePrimary ) )
            // InternalAssembler.g:3170:2: ( rulePrimary )
            {
            // InternalAssembler.g:3170:2: ( rulePrimary )
            // InternalAssembler.g:3171:3: rulePrimary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRigthShiftAccess().getNegatePrimaryParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRigthShiftAccess().getNegatePrimaryParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RigthShift__NegateAssignment_1_2"


    // $ANTLR start "rule__Negate__RightAssignment_1_2"
    // InternalAssembler.g:3180:1: rule__Negate__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Negate__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3184:1: ( ( ruleAnd ) )
            // InternalAssembler.g:3185:2: ( ruleAnd )
            {
            // InternalAssembler.g:3185:2: ( ruleAnd )
            // InternalAssembler.g:3186:3: ruleAnd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNegateAccess().getRightAndParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNegateAccess().getRightAndParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negate__RightAssignment_1_2"


    // $ANTLR start "rule__And__RightAssignment_1_2"
    // InternalAssembler.g:3195:1: rule__And__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3199:1: ( ( ruleOr ) )
            // InternalAssembler.g:3200:2: ( ruleOr )
            {
            // InternalAssembler.g:3200:2: ( ruleOr )
            // InternalAssembler.g:3201:3: ruleOr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__RightAssignment_1_2"


    // $ANTLR start "rule__Or__RightAssignment_1_2"
    // InternalAssembler.g:3210:1: rule__Or__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3214:1: ( ( ruleXor ) )
            // InternalAssembler.g:3215:2: ( ruleXor )
            {
            // InternalAssembler.g:3215:2: ( ruleXor )
            // InternalAssembler.g:3216:3: ruleXor
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXor();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__RightAssignment_1_2"


    // $ANTLR start "rule__Xor__RightAssignment_1_2"
    // InternalAssembler.g:3225:1: rule__Xor__RightAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3229:1: ( ( rulePrimary ) )
            // InternalAssembler.g:3230:2: ( rulePrimary )
            {
            // InternalAssembler.g:3230:2: ( rulePrimary )
            // InternalAssembler.g:3231:3: rulePrimary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__RightAssignment_1_2"


    // $ANTLR start "rule__Primary__ValueAssignment_0"
    // InternalAssembler.g:3240:1: rule__Primary__ValueAssignment_0 : ( ruleDecimalValue ) ;
    public final void rule__Primary__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3244:1: ( ( ruleDecimalValue ) )
            // InternalAssembler.g:3245:2: ( ruleDecimalValue )
            {
            // InternalAssembler.g:3245:2: ( ruleDecimalValue )
            // InternalAssembler.g:3246:3: ruleDecimalValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getValueDecimalValueParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDecimalValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getValueDecimalValueParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ValueAssignment_0"


    // $ANTLR start "rule__Primary__ValueAssignment_1"
    // InternalAssembler.g:3255:1: rule__Primary__ValueAssignment_1 : ( ruleHexaDecimalValue ) ;
    public final void rule__Primary__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3259:1: ( ( ruleHexaDecimalValue ) )
            // InternalAssembler.g:3260:2: ( ruleHexaDecimalValue )
            {
            // InternalAssembler.g:3260:2: ( ruleHexaDecimalValue )
            // InternalAssembler.g:3261:3: ruleHexaDecimalValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getValueHexaDecimalValueParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleHexaDecimalValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getValueHexaDecimalValueParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ValueAssignment_1"


    // $ANTLR start "rule__Primary__ValueAssignment_2"
    // InternalAssembler.g:3270:1: rule__Primary__ValueAssignment_2 : ( ruleOctalValue ) ;
    public final void rule__Primary__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3274:1: ( ( ruleOctalValue ) )
            // InternalAssembler.g:3275:2: ( ruleOctalValue )
            {
            // InternalAssembler.g:3275:2: ( ruleOctalValue )
            // InternalAssembler.g:3276:3: ruleOctalValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getValueOctalValueParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOctalValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getValueOctalValueParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ValueAssignment_2"


    // $ANTLR start "rule__Primary__ValueAssignment_3"
    // InternalAssembler.g:3285:1: rule__Primary__ValueAssignment_3 : ( ruleBinaryValue ) ;
    public final void rule__Primary__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3289:1: ( ( ruleBinaryValue ) )
            // InternalAssembler.g:3290:2: ( ruleBinaryValue )
            {
            // InternalAssembler.g:3290:2: ( ruleBinaryValue )
            // InternalAssembler.g:3291:3: ruleBinaryValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getValueBinaryValueParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBinaryValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getValueBinaryValueParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ValueAssignment_3"


    // $ANTLR start "rule__Primary__ValueAssignment_4"
    // InternalAssembler.g:3300:1: rule__Primary__ValueAssignment_4 : ( ruleCharacterValue ) ;
    public final void rule__Primary__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3304:1: ( ( ruleCharacterValue ) )
            // InternalAssembler.g:3305:2: ( ruleCharacterValue )
            {
            // InternalAssembler.g:3305:2: ( ruleCharacterValue )
            // InternalAssembler.g:3306:3: ruleCharacterValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getValueCharacterValueParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCharacterValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getValueCharacterValueParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ValueAssignment_4"


    // $ANTLR start "rule__Primary__ValueAssignment_5"
    // InternalAssembler.g:3315:1: rule__Primary__ValueAssignment_5 : ( ruleIdentifierValue ) ;
    public final void rule__Primary__ValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3319:1: ( ( ruleIdentifierValue ) )
            // InternalAssembler.g:3320:2: ( ruleIdentifierValue )
            {
            // InternalAssembler.g:3320:2: ( ruleIdentifierValue )
            // InternalAssembler.g:3321:3: ruleIdentifierValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryAccess().getValueIdentifierValueParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleIdentifierValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryAccess().getValueIdentifierValueParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ValueAssignment_5"


    // $ANTLR start "rule__IdentifierValue__ValueAssignment"
    // InternalAssembler.g:3330:1: rule__IdentifierValue__ValueAssignment : ( RULE_ID ) ;
    public final void rule__IdentifierValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3334:1: ( ( RULE_ID ) )
            // InternalAssembler.g:3335:2: ( RULE_ID )
            {
            // InternalAssembler.g:3335:2: ( RULE_ID )
            // InternalAssembler.g:3336:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierValueAccess().getValueIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierValueAccess().getValueIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifierValue__ValueAssignment"


    // $ANTLR start "rule__StringValue__ValueAssignment"
    // InternalAssembler.g:3345:1: rule__StringValue__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3349:1: ( ( RULE_STRING ) )
            // InternalAssembler.g:3350:2: ( RULE_STRING )
            {
            // InternalAssembler.g:3350:2: ( RULE_STRING )
            // InternalAssembler.g:3351:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringValue__ValueAssignment"


    // $ANTLR start "rule__DecimalValue__IsNegativeAssignment_0"
    // InternalAssembler.g:3360:1: rule__DecimalValue__IsNegativeAssignment_0 : ( ( '-' ) ) ;
    public final void rule__DecimalValue__IsNegativeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3364:1: ( ( ( '-' ) ) )
            // InternalAssembler.g:3365:2: ( ( '-' ) )
            {
            // InternalAssembler.g:3365:2: ( ( '-' ) )
            // InternalAssembler.g:3366:3: ( '-' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            }
            // InternalAssembler.g:3367:3: ( '-' )
            // InternalAssembler.g:3368:4: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalValue__IsNegativeAssignment_0"


    // $ANTLR start "rule__DecimalValue__ValueAssignment_1"
    // InternalAssembler.g:3379:1: rule__DecimalValue__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__DecimalValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3383:1: ( ( RULE_INT ) )
            // InternalAssembler.g:3384:2: ( RULE_INT )
            {
            // InternalAssembler.g:3384:2: ( RULE_INT )
            // InternalAssembler.g:3385:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecimalValueAccess().getValueINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecimalValueAccess().getValueINTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalValue__ValueAssignment_1"


    // $ANTLR start "rule__HexaDecimalValue__ValueAssignment"
    // InternalAssembler.g:3394:1: rule__HexaDecimalValue__ValueAssignment : ( RULE_HEXA ) ;
    public final void rule__HexaDecimalValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3398:1: ( ( RULE_HEXA ) )
            // InternalAssembler.g:3399:2: ( RULE_HEXA )
            {
            // InternalAssembler.g:3399:2: ( RULE_HEXA )
            // InternalAssembler.g:3400:3: RULE_HEXA
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHexaDecimalValueAccess().getValueHEXATerminalRuleCall_0()); 
            }
            match(input,RULE_HEXA,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHexaDecimalValueAccess().getValueHEXATerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HexaDecimalValue__ValueAssignment"


    // $ANTLR start "rule__OctalValue__ValueAssignment"
    // InternalAssembler.g:3409:1: rule__OctalValue__ValueAssignment : ( RULE_OCTAL ) ;
    public final void rule__OctalValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3413:1: ( ( RULE_OCTAL ) )
            // InternalAssembler.g:3414:2: ( RULE_OCTAL )
            {
            // InternalAssembler.g:3414:2: ( RULE_OCTAL )
            // InternalAssembler.g:3415:3: RULE_OCTAL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOctalValueAccess().getValueOCTALTerminalRuleCall_0()); 
            }
            match(input,RULE_OCTAL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOctalValueAccess().getValueOCTALTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OctalValue__ValueAssignment"


    // $ANTLR start "rule__BinaryValue__ValueAssignment"
    // InternalAssembler.g:3424:1: rule__BinaryValue__ValueAssignment : ( RULE_BINARY ) ;
    public final void rule__BinaryValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3428:1: ( ( RULE_BINARY ) )
            // InternalAssembler.g:3429:2: ( RULE_BINARY )
            {
            // InternalAssembler.g:3429:2: ( RULE_BINARY )
            // InternalAssembler.g:3430:3: RULE_BINARY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBinaryValueAccess().getValueBINARYTerminalRuleCall_0()); 
            }
            match(input,RULE_BINARY,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBinaryValueAccess().getValueBINARYTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryValue__ValueAssignment"


    // $ANTLR start "rule__CharacterValue__ValueAssignment"
    // InternalAssembler.g:3439:1: rule__CharacterValue__ValueAssignment : ( RULE_CHARACTER ) ;
    public final void rule__CharacterValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3443:1: ( ( RULE_CHARACTER ) )
            // InternalAssembler.g:3444:2: ( RULE_CHARACTER )
            {
            // InternalAssembler.g:3444:2: ( RULE_CHARACTER )
            // InternalAssembler.g:3445:3: RULE_CHARACTER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCharacterValueAccess().getValueCHARACTERTerminalRuleCall_0()); 
            }
            match(input,RULE_CHARACTER,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCharacterValueAccess().getValueCHARACTERTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterValue__ValueAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000001F2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000817FF0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000817D00L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000010400L});

}
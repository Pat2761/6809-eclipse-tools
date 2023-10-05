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
    // InternalAssembler.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalAssembler.g:54:1: ( ruleModel EOF )
            // InternalAssembler.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:62:1: ruleModel : ( ( rule__Model__SourceLinesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:66:2: ( ( ( rule__Model__SourceLinesAssignment )* ) )
            // InternalAssembler.g:67:2: ( ( rule__Model__SourceLinesAssignment )* )
            {
            // InternalAssembler.g:67:2: ( ( rule__Model__SourceLinesAssignment )* )
            // InternalAssembler.g:68:3: ( rule__Model__SourceLinesAssignment )*
            {
             before(grammarAccess.getModelAccess().getSourceLinesAssignment()); 
            // InternalAssembler.g:69:3: ( rule__Model__SourceLinesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_CR && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAssembler.g:69:4: rule__Model__SourceLinesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__SourceLinesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getSourceLinesAssignment()); 

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
    // InternalAssembler.g:78:1: entryRuleSourceLine : ruleSourceLine EOF ;
    public final void entryRuleSourceLine() throws RecognitionException {
        try {
            // InternalAssembler.g:79:1: ( ruleSourceLine EOF )
            // InternalAssembler.g:80:1: ruleSourceLine EOF
            {
             before(grammarAccess.getSourceLineRule()); 
            pushFollow(FOLLOW_1);
            ruleSourceLine();

            state._fsp--;

             after(grammarAccess.getSourceLineRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:87:1: ruleSourceLine : ( ( rule__SourceLine__Alternatives ) ) ;
    public final void ruleSourceLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:91:2: ( ( ( rule__SourceLine__Alternatives ) ) )
            // InternalAssembler.g:92:2: ( ( rule__SourceLine__Alternatives ) )
            {
            // InternalAssembler.g:92:2: ( ( rule__SourceLine__Alternatives ) )
            // InternalAssembler.g:93:3: ( rule__SourceLine__Alternatives )
            {
             before(grammarAccess.getSourceLineAccess().getAlternatives()); 
            // InternalAssembler.g:94:3: ( rule__SourceLine__Alternatives )
            // InternalAssembler.g:94:4: rule__SourceLine__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SourceLine__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSourceLineAccess().getAlternatives()); 

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
    // InternalAssembler.g:103:1: entryRuleBlankLine : ruleBlankLine EOF ;
    public final void entryRuleBlankLine() throws RecognitionException {
        try {
            // InternalAssembler.g:104:1: ( ruleBlankLine EOF )
            // InternalAssembler.g:105:1: ruleBlankLine EOF
            {
             before(grammarAccess.getBlankLineRule()); 
            pushFollow(FOLLOW_1);
            ruleBlankLine();

            state._fsp--;

             after(grammarAccess.getBlankLineRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:112:1: ruleBlankLine : ( ( rule__BlankLine__Group__0 ) ) ;
    public final void ruleBlankLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:116:2: ( ( ( rule__BlankLine__Group__0 ) ) )
            // InternalAssembler.g:117:2: ( ( rule__BlankLine__Group__0 ) )
            {
            // InternalAssembler.g:117:2: ( ( rule__BlankLine__Group__0 ) )
            // InternalAssembler.g:118:3: ( rule__BlankLine__Group__0 )
            {
             before(grammarAccess.getBlankLineAccess().getGroup()); 
            // InternalAssembler.g:119:3: ( rule__BlankLine__Group__0 )
            // InternalAssembler.g:119:4: rule__BlankLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BlankLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBlankLineAccess().getGroup()); 

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
    // InternalAssembler.g:128:1: entryRuleCommentLine : ruleCommentLine EOF ;
    public final void entryRuleCommentLine() throws RecognitionException {
        try {
            // InternalAssembler.g:129:1: ( ruleCommentLine EOF )
            // InternalAssembler.g:130:1: ruleCommentLine EOF
            {
             before(grammarAccess.getCommentLineRule()); 
            pushFollow(FOLLOW_1);
            ruleCommentLine();

            state._fsp--;

             after(grammarAccess.getCommentLineRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:137:1: ruleCommentLine : ( ( rule__CommentLine__Group__0 ) ) ;
    public final void ruleCommentLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:141:2: ( ( ( rule__CommentLine__Group__0 ) ) )
            // InternalAssembler.g:142:2: ( ( rule__CommentLine__Group__0 ) )
            {
            // InternalAssembler.g:142:2: ( ( rule__CommentLine__Group__0 ) )
            // InternalAssembler.g:143:3: ( rule__CommentLine__Group__0 )
            {
             before(grammarAccess.getCommentLineAccess().getGroup()); 
            // InternalAssembler.g:144:3: ( rule__CommentLine__Group__0 )
            // InternalAssembler.g:144:4: rule__CommentLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CommentLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCommentLineAccess().getGroup()); 

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
    // InternalAssembler.g:153:1: entryRuleDirectiveLine : ruleDirectiveLine EOF ;
    public final void entryRuleDirectiveLine() throws RecognitionException {
        try {
            // InternalAssembler.g:154:1: ( ruleDirectiveLine EOF )
            // InternalAssembler.g:155:1: ruleDirectiveLine EOF
            {
             before(grammarAccess.getDirectiveLineRule()); 
            pushFollow(FOLLOW_1);
            ruleDirectiveLine();

            state._fsp--;

             after(grammarAccess.getDirectiveLineRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:162:1: ruleDirectiveLine : ( ( rule__DirectiveLine__DirectiveAssignment ) ) ;
    public final void ruleDirectiveLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:166:2: ( ( ( rule__DirectiveLine__DirectiveAssignment ) ) )
            // InternalAssembler.g:167:2: ( ( rule__DirectiveLine__DirectiveAssignment ) )
            {
            // InternalAssembler.g:167:2: ( ( rule__DirectiveLine__DirectiveAssignment ) )
            // InternalAssembler.g:168:3: ( rule__DirectiveLine__DirectiveAssignment )
            {
             before(grammarAccess.getDirectiveLineAccess().getDirectiveAssignment()); 
            // InternalAssembler.g:169:3: ( rule__DirectiveLine__DirectiveAssignment )
            // InternalAssembler.g:169:4: rule__DirectiveLine__DirectiveAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DirectiveLine__DirectiveAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDirectiveLineAccess().getDirectiveAssignment()); 

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
    // InternalAssembler.g:178:1: entryRuleEquDirective : ruleEquDirective EOF ;
    public final void entryRuleEquDirective() throws RecognitionException {
        try {
            // InternalAssembler.g:179:1: ( ruleEquDirective EOF )
            // InternalAssembler.g:180:1: ruleEquDirective EOF
            {
             before(grammarAccess.getEquDirectiveRule()); 
            pushFollow(FOLLOW_1);
            ruleEquDirective();

            state._fsp--;

             after(grammarAccess.getEquDirectiveRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:187:1: ruleEquDirective : ( ( rule__EquDirective__Group__0 ) ) ;
    public final void ruleEquDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:191:2: ( ( ( rule__EquDirective__Group__0 ) ) )
            // InternalAssembler.g:192:2: ( ( rule__EquDirective__Group__0 ) )
            {
            // InternalAssembler.g:192:2: ( ( rule__EquDirective__Group__0 ) )
            // InternalAssembler.g:193:3: ( rule__EquDirective__Group__0 )
            {
             before(grammarAccess.getEquDirectiveAccess().getGroup()); 
            // InternalAssembler.g:194:3: ( rule__EquDirective__Group__0 )
            // InternalAssembler.g:194:4: rule__EquDirective__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEquDirectiveAccess().getGroup()); 

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
    // InternalAssembler.g:203:1: entryRuleOperand : ruleOperand EOF ;
    public final void entryRuleOperand() throws RecognitionException {
        try {
            // InternalAssembler.g:204:1: ( ruleOperand EOF )
            // InternalAssembler.g:205:1: ruleOperand EOF
            {
             before(grammarAccess.getOperandRule()); 
            pushFollow(FOLLOW_1);
            ruleOperand();

            state._fsp--;

             after(grammarAccess.getOperandRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:212:1: ruleOperand : ( ( rule__Operand__Alternatives ) ) ;
    public final void ruleOperand() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:216:2: ( ( ( rule__Operand__Alternatives ) ) )
            // InternalAssembler.g:217:2: ( ( rule__Operand__Alternatives ) )
            {
            // InternalAssembler.g:217:2: ( ( rule__Operand__Alternatives ) )
            // InternalAssembler.g:218:3: ( rule__Operand__Alternatives )
            {
             before(grammarAccess.getOperandAccess().getAlternatives()); 
            // InternalAssembler.g:219:3: ( rule__Operand__Alternatives )
            // InternalAssembler.g:219:4: rule__Operand__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Operand__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOperandAccess().getAlternatives()); 

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
    // InternalAssembler.g:228:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // InternalAssembler.g:229:1: ( ruleMultiplication EOF )
            // InternalAssembler.g:230:1: ruleMultiplication EOF
            {
             before(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getMultiplicationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:237:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:241:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // InternalAssembler.g:242:2: ( ( rule__Multiplication__Group__0 ) )
            {
            // InternalAssembler.g:242:2: ( ( rule__Multiplication__Group__0 ) )
            // InternalAssembler.g:243:3: ( rule__Multiplication__Group__0 )
            {
             before(grammarAccess.getMultiplicationAccess().getGroup()); 
            // InternalAssembler.g:244:3: ( rule__Multiplication__Group__0 )
            // InternalAssembler.g:244:4: rule__Multiplication__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getGroup()); 

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
    // InternalAssembler.g:253:1: entryRuleDivision : ruleDivision EOF ;
    public final void entryRuleDivision() throws RecognitionException {
        try {
            // InternalAssembler.g:254:1: ( ruleDivision EOF )
            // InternalAssembler.g:255:1: ruleDivision EOF
            {
             before(grammarAccess.getDivisionRule()); 
            pushFollow(FOLLOW_1);
            ruleDivision();

            state._fsp--;

             after(grammarAccess.getDivisionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:262:1: ruleDivision : ( ( rule__Division__Group__0 ) ) ;
    public final void ruleDivision() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:266:2: ( ( ( rule__Division__Group__0 ) ) )
            // InternalAssembler.g:267:2: ( ( rule__Division__Group__0 ) )
            {
            // InternalAssembler.g:267:2: ( ( rule__Division__Group__0 ) )
            // InternalAssembler.g:268:3: ( rule__Division__Group__0 )
            {
             before(grammarAccess.getDivisionAccess().getGroup()); 
            // InternalAssembler.g:269:3: ( rule__Division__Group__0 )
            // InternalAssembler.g:269:4: rule__Division__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Division__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDivisionAccess().getGroup()); 

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
    // InternalAssembler.g:278:1: entryRuleModulo : ruleModulo EOF ;
    public final void entryRuleModulo() throws RecognitionException {
        try {
            // InternalAssembler.g:279:1: ( ruleModulo EOF )
            // InternalAssembler.g:280:1: ruleModulo EOF
            {
             before(grammarAccess.getModuloRule()); 
            pushFollow(FOLLOW_1);
            ruleModulo();

            state._fsp--;

             after(grammarAccess.getModuloRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:287:1: ruleModulo : ( ( rule__Modulo__Group__0 ) ) ;
    public final void ruleModulo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:291:2: ( ( ( rule__Modulo__Group__0 ) ) )
            // InternalAssembler.g:292:2: ( ( rule__Modulo__Group__0 ) )
            {
            // InternalAssembler.g:292:2: ( ( rule__Modulo__Group__0 ) )
            // InternalAssembler.g:293:3: ( rule__Modulo__Group__0 )
            {
             before(grammarAccess.getModuloAccess().getGroup()); 
            // InternalAssembler.g:294:3: ( rule__Modulo__Group__0 )
            // InternalAssembler.g:294:4: rule__Modulo__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModuloAccess().getGroup()); 

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
    // InternalAssembler.g:303:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // InternalAssembler.g:304:1: ( ruleAddition EOF )
            // InternalAssembler.g:305:1: ruleAddition EOF
            {
             before(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_1);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getAdditionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:312:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:316:2: ( ( ( rule__Addition__Group__0 ) ) )
            // InternalAssembler.g:317:2: ( ( rule__Addition__Group__0 ) )
            {
            // InternalAssembler.g:317:2: ( ( rule__Addition__Group__0 ) )
            // InternalAssembler.g:318:3: ( rule__Addition__Group__0 )
            {
             before(grammarAccess.getAdditionAccess().getGroup()); 
            // InternalAssembler.g:319:3: ( rule__Addition__Group__0 )
            // InternalAssembler.g:319:4: rule__Addition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdditionAccess().getGroup()); 

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
    // InternalAssembler.g:328:1: entryRuleSubstraction : ruleSubstraction EOF ;
    public final void entryRuleSubstraction() throws RecognitionException {
        try {
            // InternalAssembler.g:329:1: ( ruleSubstraction EOF )
            // InternalAssembler.g:330:1: ruleSubstraction EOF
            {
             before(grammarAccess.getSubstractionRule()); 
            pushFollow(FOLLOW_1);
            ruleSubstraction();

            state._fsp--;

             after(grammarAccess.getSubstractionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:337:1: ruleSubstraction : ( ( rule__Substraction__Group__0 ) ) ;
    public final void ruleSubstraction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:341:2: ( ( ( rule__Substraction__Group__0 ) ) )
            // InternalAssembler.g:342:2: ( ( rule__Substraction__Group__0 ) )
            {
            // InternalAssembler.g:342:2: ( ( rule__Substraction__Group__0 ) )
            // InternalAssembler.g:343:3: ( rule__Substraction__Group__0 )
            {
             before(grammarAccess.getSubstractionAccess().getGroup()); 
            // InternalAssembler.g:344:3: ( rule__Substraction__Group__0 )
            // InternalAssembler.g:344:4: rule__Substraction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Substraction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubstractionAccess().getGroup()); 

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
    // InternalAssembler.g:353:1: entryRuleLeftShift : ruleLeftShift EOF ;
    public final void entryRuleLeftShift() throws RecognitionException {
        try {
            // InternalAssembler.g:354:1: ( ruleLeftShift EOF )
            // InternalAssembler.g:355:1: ruleLeftShift EOF
            {
             before(grammarAccess.getLeftShiftRule()); 
            pushFollow(FOLLOW_1);
            ruleLeftShift();

            state._fsp--;

             after(grammarAccess.getLeftShiftRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:362:1: ruleLeftShift : ( ( rule__LeftShift__Group__0 ) ) ;
    public final void ruleLeftShift() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:366:2: ( ( ( rule__LeftShift__Group__0 ) ) )
            // InternalAssembler.g:367:2: ( ( rule__LeftShift__Group__0 ) )
            {
            // InternalAssembler.g:367:2: ( ( rule__LeftShift__Group__0 ) )
            // InternalAssembler.g:368:3: ( rule__LeftShift__Group__0 )
            {
             before(grammarAccess.getLeftShiftAccess().getGroup()); 
            // InternalAssembler.g:369:3: ( rule__LeftShift__Group__0 )
            // InternalAssembler.g:369:4: rule__LeftShift__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLeftShiftAccess().getGroup()); 

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
    // InternalAssembler.g:378:1: entryRuleRigthShift : ruleRigthShift EOF ;
    public final void entryRuleRigthShift() throws RecognitionException {
        try {
            // InternalAssembler.g:379:1: ( ruleRigthShift EOF )
            // InternalAssembler.g:380:1: ruleRigthShift EOF
            {
             before(grammarAccess.getRigthShiftRule()); 
            pushFollow(FOLLOW_1);
            ruleRigthShift();

            state._fsp--;

             after(grammarAccess.getRigthShiftRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:387:1: ruleRigthShift : ( ( rule__RigthShift__Group__0 ) ) ;
    public final void ruleRigthShift() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:391:2: ( ( ( rule__RigthShift__Group__0 ) ) )
            // InternalAssembler.g:392:2: ( ( rule__RigthShift__Group__0 ) )
            {
            // InternalAssembler.g:392:2: ( ( rule__RigthShift__Group__0 ) )
            // InternalAssembler.g:393:3: ( rule__RigthShift__Group__0 )
            {
             before(grammarAccess.getRigthShiftAccess().getGroup()); 
            // InternalAssembler.g:394:3: ( rule__RigthShift__Group__0 )
            // InternalAssembler.g:394:4: rule__RigthShift__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRigthShiftAccess().getGroup()); 

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
    // InternalAssembler.g:403:1: entryRuleNegate : ruleNegate EOF ;
    public final void entryRuleNegate() throws RecognitionException {
        try {
            // InternalAssembler.g:404:1: ( ruleNegate EOF )
            // InternalAssembler.g:405:1: ruleNegate EOF
            {
             before(grammarAccess.getNegateRule()); 
            pushFollow(FOLLOW_1);
            ruleNegate();

            state._fsp--;

             after(grammarAccess.getNegateRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:412:1: ruleNegate : ( ( rule__Negate__Group__0 ) ) ;
    public final void ruleNegate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:416:2: ( ( ( rule__Negate__Group__0 ) ) )
            // InternalAssembler.g:417:2: ( ( rule__Negate__Group__0 ) )
            {
            // InternalAssembler.g:417:2: ( ( rule__Negate__Group__0 ) )
            // InternalAssembler.g:418:3: ( rule__Negate__Group__0 )
            {
             before(grammarAccess.getNegateAccess().getGroup()); 
            // InternalAssembler.g:419:3: ( rule__Negate__Group__0 )
            // InternalAssembler.g:419:4: rule__Negate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Negate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNegateAccess().getGroup()); 

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
    // InternalAssembler.g:428:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalAssembler.g:429:1: ( ruleAnd EOF )
            // InternalAssembler.g:430:1: ruleAnd EOF
            {
             before(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getAndRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:437:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:441:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalAssembler.g:442:2: ( ( rule__And__Group__0 ) )
            {
            // InternalAssembler.g:442:2: ( ( rule__And__Group__0 ) )
            // InternalAssembler.g:443:3: ( rule__And__Group__0 )
            {
             before(grammarAccess.getAndAccess().getGroup()); 
            // InternalAssembler.g:444:3: ( rule__And__Group__0 )
            // InternalAssembler.g:444:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getGroup()); 

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
    // InternalAssembler.g:453:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalAssembler.g:454:1: ( ruleOr EOF )
            // InternalAssembler.g:455:1: ruleOr EOF
            {
             before(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getOrRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:462:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:466:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalAssembler.g:467:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalAssembler.g:467:2: ( ( rule__Or__Group__0 ) )
            // InternalAssembler.g:468:3: ( rule__Or__Group__0 )
            {
             before(grammarAccess.getOrAccess().getGroup()); 
            // InternalAssembler.g:469:3: ( rule__Or__Group__0 )
            // InternalAssembler.g:469:4: rule__Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getGroup()); 

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
    // InternalAssembler.g:478:1: entryRuleXor : ruleXor EOF ;
    public final void entryRuleXor() throws RecognitionException {
        try {
            // InternalAssembler.g:479:1: ( ruleXor EOF )
            // InternalAssembler.g:480:1: ruleXor EOF
            {
             before(grammarAccess.getXorRule()); 
            pushFollow(FOLLOW_1);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getXorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:487:1: ruleXor : ( ( rule__Xor__Group__0 ) ) ;
    public final void ruleXor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:491:2: ( ( ( rule__Xor__Group__0 ) ) )
            // InternalAssembler.g:492:2: ( ( rule__Xor__Group__0 ) )
            {
            // InternalAssembler.g:492:2: ( ( rule__Xor__Group__0 ) )
            // InternalAssembler.g:493:3: ( rule__Xor__Group__0 )
            {
             before(grammarAccess.getXorAccess().getGroup()); 
            // InternalAssembler.g:494:3: ( rule__Xor__Group__0 )
            // InternalAssembler.g:494:4: rule__Xor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXorAccess().getGroup()); 

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
    // InternalAssembler.g:503:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalAssembler.g:504:1: ( rulePrimary EOF )
            // InternalAssembler.g:505:1: rulePrimary EOF
            {
             before(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getPrimaryRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:512:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:516:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalAssembler.g:517:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalAssembler.g:517:2: ( ( rule__Primary__Alternatives ) )
            // InternalAssembler.g:518:3: ( rule__Primary__Alternatives )
            {
             before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            // InternalAssembler.g:519:3: ( rule__Primary__Alternatives )
            // InternalAssembler.g:519:4: rule__Primary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getAlternatives()); 

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


    // $ANTLR start "entryRuleIdentifier"
    // InternalAssembler.g:528:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // InternalAssembler.g:529:1: ( ruleIdentifier EOF )
            // InternalAssembler.g:530:1: ruleIdentifier EOF
            {
             before(grammarAccess.getIdentifierRule()); 
            pushFollow(FOLLOW_1);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getIdentifierRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalAssembler.g:537:1: ruleIdentifier : ( ( rule__Identifier__ValueAssignment ) ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:541:2: ( ( ( rule__Identifier__ValueAssignment ) ) )
            // InternalAssembler.g:542:2: ( ( rule__Identifier__ValueAssignment ) )
            {
            // InternalAssembler.g:542:2: ( ( rule__Identifier__ValueAssignment ) )
            // InternalAssembler.g:543:3: ( rule__Identifier__ValueAssignment )
            {
             before(grammarAccess.getIdentifierAccess().getValueAssignment()); 
            // InternalAssembler.g:544:3: ( rule__Identifier__ValueAssignment )
            // InternalAssembler.g:544:4: rule__Identifier__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Identifier__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIdentifierAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleStringValue"
    // InternalAssembler.g:553:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // InternalAssembler.g:554:1: ( ruleStringValue EOF )
            // InternalAssembler.g:555:1: ruleStringValue EOF
            {
             before(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_1);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getStringValueRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:562:1: ruleStringValue : ( ( rule__StringValue__ValueAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:566:2: ( ( ( rule__StringValue__ValueAssignment ) ) )
            // InternalAssembler.g:567:2: ( ( rule__StringValue__ValueAssignment ) )
            {
            // InternalAssembler.g:567:2: ( ( rule__StringValue__ValueAssignment ) )
            // InternalAssembler.g:568:3: ( rule__StringValue__ValueAssignment )
            {
             before(grammarAccess.getStringValueAccess().getValueAssignment()); 
            // InternalAssembler.g:569:3: ( rule__StringValue__ValueAssignment )
            // InternalAssembler.g:569:4: rule__StringValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringValueAccess().getValueAssignment()); 

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
    // InternalAssembler.g:578:1: entryRuleDecimalValue : ruleDecimalValue EOF ;
    public final void entryRuleDecimalValue() throws RecognitionException {
        try {
            // InternalAssembler.g:579:1: ( ruleDecimalValue EOF )
            // InternalAssembler.g:580:1: ruleDecimalValue EOF
            {
             before(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_1);
            ruleDecimalValue();

            state._fsp--;

             after(grammarAccess.getDecimalValueRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:587:1: ruleDecimalValue : ( ( rule__DecimalValue__ValueAssignment ) ) ;
    public final void ruleDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:591:2: ( ( ( rule__DecimalValue__ValueAssignment ) ) )
            // InternalAssembler.g:592:2: ( ( rule__DecimalValue__ValueAssignment ) )
            {
            // InternalAssembler.g:592:2: ( ( rule__DecimalValue__ValueAssignment ) )
            // InternalAssembler.g:593:3: ( rule__DecimalValue__ValueAssignment )
            {
             before(grammarAccess.getDecimalValueAccess().getValueAssignment()); 
            // InternalAssembler.g:594:3: ( rule__DecimalValue__ValueAssignment )
            // InternalAssembler.g:594:4: rule__DecimalValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DecimalValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDecimalValueAccess().getValueAssignment()); 

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
    // InternalAssembler.g:603:1: entryRuleHexaDecimalValue : ruleHexaDecimalValue EOF ;
    public final void entryRuleHexaDecimalValue() throws RecognitionException {
        try {
            // InternalAssembler.g:604:1: ( ruleHexaDecimalValue EOF )
            // InternalAssembler.g:605:1: ruleHexaDecimalValue EOF
            {
             before(grammarAccess.getHexaDecimalValueRule()); 
            pushFollow(FOLLOW_1);
            ruleHexaDecimalValue();

            state._fsp--;

             after(grammarAccess.getHexaDecimalValueRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:612:1: ruleHexaDecimalValue : ( ( rule__HexaDecimalValue__ValueAssignment ) ) ;
    public final void ruleHexaDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:616:2: ( ( ( rule__HexaDecimalValue__ValueAssignment ) ) )
            // InternalAssembler.g:617:2: ( ( rule__HexaDecimalValue__ValueAssignment ) )
            {
            // InternalAssembler.g:617:2: ( ( rule__HexaDecimalValue__ValueAssignment ) )
            // InternalAssembler.g:618:3: ( rule__HexaDecimalValue__ValueAssignment )
            {
             before(grammarAccess.getHexaDecimalValueAccess().getValueAssignment()); 
            // InternalAssembler.g:619:3: ( rule__HexaDecimalValue__ValueAssignment )
            // InternalAssembler.g:619:4: rule__HexaDecimalValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__HexaDecimalValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getHexaDecimalValueAccess().getValueAssignment()); 

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
    // InternalAssembler.g:628:1: entryRuleOctalValue : ruleOctalValue EOF ;
    public final void entryRuleOctalValue() throws RecognitionException {
        try {
            // InternalAssembler.g:629:1: ( ruleOctalValue EOF )
            // InternalAssembler.g:630:1: ruleOctalValue EOF
            {
             before(grammarAccess.getOctalValueRule()); 
            pushFollow(FOLLOW_1);
            ruleOctalValue();

            state._fsp--;

             after(grammarAccess.getOctalValueRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:637:1: ruleOctalValue : ( ( rule__OctalValue__ValueAssignment ) ) ;
    public final void ruleOctalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:641:2: ( ( ( rule__OctalValue__ValueAssignment ) ) )
            // InternalAssembler.g:642:2: ( ( rule__OctalValue__ValueAssignment ) )
            {
            // InternalAssembler.g:642:2: ( ( rule__OctalValue__ValueAssignment ) )
            // InternalAssembler.g:643:3: ( rule__OctalValue__ValueAssignment )
            {
             before(grammarAccess.getOctalValueAccess().getValueAssignment()); 
            // InternalAssembler.g:644:3: ( rule__OctalValue__ValueAssignment )
            // InternalAssembler.g:644:4: rule__OctalValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__OctalValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getOctalValueAccess().getValueAssignment()); 

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
    // InternalAssembler.g:653:1: entryRuleBinaryValue : ruleBinaryValue EOF ;
    public final void entryRuleBinaryValue() throws RecognitionException {
        try {
            // InternalAssembler.g:654:1: ( ruleBinaryValue EOF )
            // InternalAssembler.g:655:1: ruleBinaryValue EOF
            {
             before(grammarAccess.getBinaryValueRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryValue();

            state._fsp--;

             after(grammarAccess.getBinaryValueRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:662:1: ruleBinaryValue : ( ( rule__BinaryValue__ValueAssignment ) ) ;
    public final void ruleBinaryValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:666:2: ( ( ( rule__BinaryValue__ValueAssignment ) ) )
            // InternalAssembler.g:667:2: ( ( rule__BinaryValue__ValueAssignment ) )
            {
            // InternalAssembler.g:667:2: ( ( rule__BinaryValue__ValueAssignment ) )
            // InternalAssembler.g:668:3: ( rule__BinaryValue__ValueAssignment )
            {
             before(grammarAccess.getBinaryValueAccess().getValueAssignment()); 
            // InternalAssembler.g:669:3: ( rule__BinaryValue__ValueAssignment )
            // InternalAssembler.g:669:4: rule__BinaryValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BinaryValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBinaryValueAccess().getValueAssignment()); 

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
    // InternalAssembler.g:678:1: entryRuleCharacterValue : ruleCharacterValue EOF ;
    public final void entryRuleCharacterValue() throws RecognitionException {
        try {
            // InternalAssembler.g:679:1: ( ruleCharacterValue EOF )
            // InternalAssembler.g:680:1: ruleCharacterValue EOF
            {
             before(grammarAccess.getCharacterValueRule()); 
            pushFollow(FOLLOW_1);
            ruleCharacterValue();

            state._fsp--;

             after(grammarAccess.getCharacterValueRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:687:1: ruleCharacterValue : ( ( rule__CharacterValue__ValueAssignment ) ) ;
    public final void ruleCharacterValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:691:2: ( ( ( rule__CharacterValue__ValueAssignment ) ) )
            // InternalAssembler.g:692:2: ( ( rule__CharacterValue__ValueAssignment ) )
            {
            // InternalAssembler.g:692:2: ( ( rule__CharacterValue__ValueAssignment ) )
            // InternalAssembler.g:693:3: ( rule__CharacterValue__ValueAssignment )
            {
             before(grammarAccess.getCharacterValueAccess().getValueAssignment()); 
            // InternalAssembler.g:694:3: ( rule__CharacterValue__ValueAssignment )
            // InternalAssembler.g:694:4: rule__CharacterValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__CharacterValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCharacterValueAccess().getValueAssignment()); 

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
    // InternalAssembler.g:703:1: entryRuleEndOfLine : ruleEndOfLine EOF ;
    public final void entryRuleEndOfLine() throws RecognitionException {
        try {
            // InternalAssembler.g:704:1: ( ruleEndOfLine EOF )
            // InternalAssembler.g:705:1: ruleEndOfLine EOF
            {
             before(grammarAccess.getEndOfLineRule()); 
            pushFollow(FOLLOW_1);
            ruleEndOfLine();

            state._fsp--;

             after(grammarAccess.getEndOfLineRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalAssembler.g:712:1: ruleEndOfLine : ( ( rule__EndOfLine__Alternatives ) ) ;
    public final void ruleEndOfLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:716:2: ( ( ( rule__EndOfLine__Alternatives ) ) )
            // InternalAssembler.g:717:2: ( ( rule__EndOfLine__Alternatives ) )
            {
            // InternalAssembler.g:717:2: ( ( rule__EndOfLine__Alternatives ) )
            // InternalAssembler.g:718:3: ( rule__EndOfLine__Alternatives )
            {
             before(grammarAccess.getEndOfLineAccess().getAlternatives()); 
            // InternalAssembler.g:719:3: ( rule__EndOfLine__Alternatives )
            // InternalAssembler.g:719:4: rule__EndOfLine__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EndOfLine__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEndOfLineAccess().getAlternatives()); 

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
    // InternalAssembler.g:727:1: rule__SourceLine__Alternatives : ( ( ( rule__SourceLine__LineContentAssignment_0 ) ) | ( ( rule__SourceLine__LineContentAssignment_1 ) ) | ( ( rule__SourceLine__LineContentAssignment_2 ) ) );
    public final void rule__SourceLine__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:731:1: ( ( ( rule__SourceLine__LineContentAssignment_0 ) ) | ( ( rule__SourceLine__LineContentAssignment_1 ) ) | ( ( rule__SourceLine__LineContentAssignment_2 ) ) )
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
                    // InternalAssembler.g:732:2: ( ( rule__SourceLine__LineContentAssignment_0 ) )
                    {
                    // InternalAssembler.g:732:2: ( ( rule__SourceLine__LineContentAssignment_0 ) )
                    // InternalAssembler.g:733:3: ( rule__SourceLine__LineContentAssignment_0 )
                    {
                     before(grammarAccess.getSourceLineAccess().getLineContentAssignment_0()); 
                    // InternalAssembler.g:734:3: ( rule__SourceLine__LineContentAssignment_0 )
                    // InternalAssembler.g:734:4: rule__SourceLine__LineContentAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__LineContentAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSourceLineAccess().getLineContentAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:738:2: ( ( rule__SourceLine__LineContentAssignment_1 ) )
                    {
                    // InternalAssembler.g:738:2: ( ( rule__SourceLine__LineContentAssignment_1 ) )
                    // InternalAssembler.g:739:3: ( rule__SourceLine__LineContentAssignment_1 )
                    {
                     before(grammarAccess.getSourceLineAccess().getLineContentAssignment_1()); 
                    // InternalAssembler.g:740:3: ( rule__SourceLine__LineContentAssignment_1 )
                    // InternalAssembler.g:740:4: rule__SourceLine__LineContentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__LineContentAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSourceLineAccess().getLineContentAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:744:2: ( ( rule__SourceLine__LineContentAssignment_2 ) )
                    {
                    // InternalAssembler.g:744:2: ( ( rule__SourceLine__LineContentAssignment_2 ) )
                    // InternalAssembler.g:745:3: ( rule__SourceLine__LineContentAssignment_2 )
                    {
                     before(grammarAccess.getSourceLineAccess().getLineContentAssignment_2()); 
                    // InternalAssembler.g:746:3: ( rule__SourceLine__LineContentAssignment_2 )
                    // InternalAssembler.g:746:4: rule__SourceLine__LineContentAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__LineContentAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getSourceLineAccess().getLineContentAssignment_2()); 

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
    // InternalAssembler.g:754:1: rule__Operand__Alternatives : ( ( ( rule__Operand__OperandAssignment_0 ) ) | ( ( rule__Operand__OperandAssignment_1 ) ) );
    public final void rule__Operand__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:758:1: ( ( ( rule__Operand__OperandAssignment_0 ) ) | ( ( rule__Operand__OperandAssignment_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID||(LA3_0>=RULE_INT && LA3_0<=RULE_CHARACTER)||LA3_0==23) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_STRING) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssembler.g:759:2: ( ( rule__Operand__OperandAssignment_0 ) )
                    {
                    // InternalAssembler.g:759:2: ( ( rule__Operand__OperandAssignment_0 ) )
                    // InternalAssembler.g:760:3: ( rule__Operand__OperandAssignment_0 )
                    {
                     before(grammarAccess.getOperandAccess().getOperandAssignment_0()); 
                    // InternalAssembler.g:761:3: ( rule__Operand__OperandAssignment_0 )
                    // InternalAssembler.g:761:4: rule__Operand__OperandAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operand__OperandAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOperandAccess().getOperandAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:765:2: ( ( rule__Operand__OperandAssignment_1 ) )
                    {
                    // InternalAssembler.g:765:2: ( ( rule__Operand__OperandAssignment_1 ) )
                    // InternalAssembler.g:766:3: ( rule__Operand__OperandAssignment_1 )
                    {
                     before(grammarAccess.getOperandAccess().getOperandAssignment_1()); 
                    // InternalAssembler.g:767:3: ( rule__Operand__OperandAssignment_1 )
                    // InternalAssembler.g:767:4: rule__Operand__OperandAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operand__OperandAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getOperandAccess().getOperandAssignment_1()); 

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
    // InternalAssembler.g:775:1: rule__Primary__Alternatives : ( ( ( rule__Primary__ValueAssignment_0 ) ) | ( ( rule__Primary__ValueAssignment_1 ) ) | ( ( rule__Primary__ValueAssignment_2 ) ) | ( ( rule__Primary__ValueAssignment_3 ) ) | ( ( rule__Primary__ValueAssignment_4 ) ) | ( ( rule__Primary__ValueAssignment_5 ) ) | ( ( rule__Primary__Group_6__0 ) ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:779:1: ( ( ( rule__Primary__ValueAssignment_0 ) ) | ( ( rule__Primary__ValueAssignment_1 ) ) | ( ( rule__Primary__ValueAssignment_2 ) ) | ( ( rule__Primary__ValueAssignment_3 ) ) | ( ( rule__Primary__ValueAssignment_4 ) ) | ( ( rule__Primary__ValueAssignment_5 ) ) | ( ( rule__Primary__Group_6__0 ) ) )
            int alt4=7;
            switch ( input.LA(1) ) {
            case RULE_INT:
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
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:780:2: ( ( rule__Primary__ValueAssignment_0 ) )
                    {
                    // InternalAssembler.g:780:2: ( ( rule__Primary__ValueAssignment_0 ) )
                    // InternalAssembler.g:781:3: ( rule__Primary__ValueAssignment_0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getValueAssignment_0()); 
                    // InternalAssembler.g:782:3: ( rule__Primary__ValueAssignment_0 )
                    // InternalAssembler.g:782:4: rule__Primary__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:786:2: ( ( rule__Primary__ValueAssignment_1 ) )
                    {
                    // InternalAssembler.g:786:2: ( ( rule__Primary__ValueAssignment_1 ) )
                    // InternalAssembler.g:787:3: ( rule__Primary__ValueAssignment_1 )
                    {
                     before(grammarAccess.getPrimaryAccess().getValueAssignment_1()); 
                    // InternalAssembler.g:788:3: ( rule__Primary__ValueAssignment_1 )
                    // InternalAssembler.g:788:4: rule__Primary__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getValueAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:792:2: ( ( rule__Primary__ValueAssignment_2 ) )
                    {
                    // InternalAssembler.g:792:2: ( ( rule__Primary__ValueAssignment_2 ) )
                    // InternalAssembler.g:793:3: ( rule__Primary__ValueAssignment_2 )
                    {
                     before(grammarAccess.getPrimaryAccess().getValueAssignment_2()); 
                    // InternalAssembler.g:794:3: ( rule__Primary__ValueAssignment_2 )
                    // InternalAssembler.g:794:4: rule__Primary__ValueAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getValueAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:798:2: ( ( rule__Primary__ValueAssignment_3 ) )
                    {
                    // InternalAssembler.g:798:2: ( ( rule__Primary__ValueAssignment_3 ) )
                    // InternalAssembler.g:799:3: ( rule__Primary__ValueAssignment_3 )
                    {
                     before(grammarAccess.getPrimaryAccess().getValueAssignment_3()); 
                    // InternalAssembler.g:800:3: ( rule__Primary__ValueAssignment_3 )
                    // InternalAssembler.g:800:4: rule__Primary__ValueAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getValueAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:804:2: ( ( rule__Primary__ValueAssignment_4 ) )
                    {
                    // InternalAssembler.g:804:2: ( ( rule__Primary__ValueAssignment_4 ) )
                    // InternalAssembler.g:805:3: ( rule__Primary__ValueAssignment_4 )
                    {
                     before(grammarAccess.getPrimaryAccess().getValueAssignment_4()); 
                    // InternalAssembler.g:806:3: ( rule__Primary__ValueAssignment_4 )
                    // InternalAssembler.g:806:4: rule__Primary__ValueAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getValueAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:810:2: ( ( rule__Primary__ValueAssignment_5 ) )
                    {
                    // InternalAssembler.g:810:2: ( ( rule__Primary__ValueAssignment_5 ) )
                    // InternalAssembler.g:811:3: ( rule__Primary__ValueAssignment_5 )
                    {
                     before(grammarAccess.getPrimaryAccess().getValueAssignment_5()); 
                    // InternalAssembler.g:812:3: ( rule__Primary__ValueAssignment_5 )
                    // InternalAssembler.g:812:4: rule__Primary__ValueAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ValueAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getValueAssignment_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:816:2: ( ( rule__Primary__Group_6__0 ) )
                    {
                    // InternalAssembler.g:816:2: ( ( rule__Primary__Group_6__0 ) )
                    // InternalAssembler.g:817:3: ( rule__Primary__Group_6__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_6()); 
                    // InternalAssembler.g:818:3: ( rule__Primary__Group_6__0 )
                    // InternalAssembler.g:818:4: rule__Primary__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getGroup_6()); 

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
    // InternalAssembler.g:826:1: rule__EndOfLine__Alternatives : ( ( RULE_CR ) | ( RULE_END_OF_FILE ) );
    public final void rule__EndOfLine__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:830:1: ( ( RULE_CR ) | ( RULE_END_OF_FILE ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_CR) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_END_OF_FILE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:831:2: ( RULE_CR )
                    {
                    // InternalAssembler.g:831:2: ( RULE_CR )
                    // InternalAssembler.g:832:3: RULE_CR
                    {
                     before(grammarAccess.getEndOfLineAccess().getCRTerminalRuleCall_0()); 
                    match(input,RULE_CR,FOLLOW_2); 
                     after(grammarAccess.getEndOfLineAccess().getCRTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:837:2: ( RULE_END_OF_FILE )
                    {
                    // InternalAssembler.g:837:2: ( RULE_END_OF_FILE )
                    // InternalAssembler.g:838:3: RULE_END_OF_FILE
                    {
                     before(grammarAccess.getEndOfLineAccess().getEND_OF_FILETerminalRuleCall_1()); 
                    match(input,RULE_END_OF_FILE,FOLLOW_2); 
                     after(grammarAccess.getEndOfLineAccess().getEND_OF_FILETerminalRuleCall_1()); 

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
    // InternalAssembler.g:847:1: rule__BlankLine__Group__0 : rule__BlankLine__Group__0__Impl rule__BlankLine__Group__1 ;
    public final void rule__BlankLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:851:1: ( rule__BlankLine__Group__0__Impl rule__BlankLine__Group__1 )
            // InternalAssembler.g:852:2: rule__BlankLine__Group__0__Impl rule__BlankLine__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__BlankLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BlankLine__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:859:1: rule__BlankLine__Group__0__Impl : ( () ) ;
    public final void rule__BlankLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:863:1: ( ( () ) )
            // InternalAssembler.g:864:1: ( () )
            {
            // InternalAssembler.g:864:1: ( () )
            // InternalAssembler.g:865:2: ()
            {
             before(grammarAccess.getBlankLineAccess().getBlankLineAction_0()); 
            // InternalAssembler.g:866:2: ()
            // InternalAssembler.g:866:3: 
            {
            }

             after(grammarAccess.getBlankLineAccess().getBlankLineAction_0()); 

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
    // InternalAssembler.g:874:1: rule__BlankLine__Group__1 : rule__BlankLine__Group__1__Impl rule__BlankLine__Group__2 ;
    public final void rule__BlankLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:878:1: ( rule__BlankLine__Group__1__Impl rule__BlankLine__Group__2 )
            // InternalAssembler.g:879:2: rule__BlankLine__Group__1__Impl rule__BlankLine__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__BlankLine__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BlankLine__Group__2();

            state._fsp--;


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
    // InternalAssembler.g:886:1: rule__BlankLine__Group__1__Impl : ( ( rule__BlankLine__BlankLineAssignment_1 )? ) ;
    public final void rule__BlankLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:890:1: ( ( ( rule__BlankLine__BlankLineAssignment_1 )? ) )
            // InternalAssembler.g:891:1: ( ( rule__BlankLine__BlankLineAssignment_1 )? )
            {
            // InternalAssembler.g:891:1: ( ( rule__BlankLine__BlankLineAssignment_1 )? )
            // InternalAssembler.g:892:2: ( rule__BlankLine__BlankLineAssignment_1 )?
            {
             before(grammarAccess.getBlankLineAccess().getBlankLineAssignment_1()); 
            // InternalAssembler.g:893:2: ( rule__BlankLine__BlankLineAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_WS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:893:3: rule__BlankLine__BlankLineAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BlankLine__BlankLineAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBlankLineAccess().getBlankLineAssignment_1()); 

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
    // InternalAssembler.g:901:1: rule__BlankLine__Group__2 : rule__BlankLine__Group__2__Impl ;
    public final void rule__BlankLine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:905:1: ( rule__BlankLine__Group__2__Impl )
            // InternalAssembler.g:906:2: rule__BlankLine__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BlankLine__Group__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:912:1: rule__BlankLine__Group__2__Impl : ( ruleEndOfLine ) ;
    public final void rule__BlankLine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:916:1: ( ( ruleEndOfLine ) )
            // InternalAssembler.g:917:1: ( ruleEndOfLine )
            {
            // InternalAssembler.g:917:1: ( ruleEndOfLine )
            // InternalAssembler.g:918:2: ruleEndOfLine
            {
             before(grammarAccess.getBlankLineAccess().getEndOfLineParserRuleCall_2()); 
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;

             after(grammarAccess.getBlankLineAccess().getEndOfLineParserRuleCall_2()); 

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
    // InternalAssembler.g:928:1: rule__CommentLine__Group__0 : rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1 ;
    public final void rule__CommentLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:932:1: ( rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1 )
            // InternalAssembler.g:933:2: rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__CommentLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CommentLine__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:940:1: rule__CommentLine__Group__0__Impl : ( ( rule__CommentLine__CommentAssignment_0 ) ) ;
    public final void rule__CommentLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:944:1: ( ( ( rule__CommentLine__CommentAssignment_0 ) ) )
            // InternalAssembler.g:945:1: ( ( rule__CommentLine__CommentAssignment_0 ) )
            {
            // InternalAssembler.g:945:1: ( ( rule__CommentLine__CommentAssignment_0 ) )
            // InternalAssembler.g:946:2: ( rule__CommentLine__CommentAssignment_0 )
            {
             before(grammarAccess.getCommentLineAccess().getCommentAssignment_0()); 
            // InternalAssembler.g:947:2: ( rule__CommentLine__CommentAssignment_0 )
            // InternalAssembler.g:947:3: rule__CommentLine__CommentAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CommentLine__CommentAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCommentLineAccess().getCommentAssignment_0()); 

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
    // InternalAssembler.g:955:1: rule__CommentLine__Group__1 : rule__CommentLine__Group__1__Impl ;
    public final void rule__CommentLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:959:1: ( rule__CommentLine__Group__1__Impl )
            // InternalAssembler.g:960:2: rule__CommentLine__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CommentLine__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:966:1: rule__CommentLine__Group__1__Impl : ( ruleEndOfLine ) ;
    public final void rule__CommentLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:970:1: ( ( ruleEndOfLine ) )
            // InternalAssembler.g:971:1: ( ruleEndOfLine )
            {
            // InternalAssembler.g:971:1: ( ruleEndOfLine )
            // InternalAssembler.g:972:2: ruleEndOfLine
            {
             before(grammarAccess.getCommentLineAccess().getEndOfLineParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;

             after(grammarAccess.getCommentLineAccess().getEndOfLineParserRuleCall_1()); 

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
    // InternalAssembler.g:982:1: rule__EquDirective__Group__0 : rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1 ;
    public final void rule__EquDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:986:1: ( rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1 )
            // InternalAssembler.g:987:2: rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__EquDirective__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:994:1: rule__EquDirective__Group__0__Impl : ( ( rule__EquDirective__NameAssignment_0 )? ) ;
    public final void rule__EquDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:998:1: ( ( ( rule__EquDirective__NameAssignment_0 )? ) )
            // InternalAssembler.g:999:1: ( ( rule__EquDirective__NameAssignment_0 )? )
            {
            // InternalAssembler.g:999:1: ( ( rule__EquDirective__NameAssignment_0 )? )
            // InternalAssembler.g:1000:2: ( rule__EquDirective__NameAssignment_0 )?
            {
             before(grammarAccess.getEquDirectiveAccess().getNameAssignment_0()); 
            // InternalAssembler.g:1001:2: ( rule__EquDirective__NameAssignment_0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:1001:3: rule__EquDirective__NameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EquDirective__NameAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEquDirectiveAccess().getNameAssignment_0()); 

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
    // InternalAssembler.g:1009:1: rule__EquDirective__Group__1 : rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2 ;
    public final void rule__EquDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1013:1: ( rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2 )
            // InternalAssembler.g:1014:2: rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__EquDirective__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__2();

            state._fsp--;


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
    // InternalAssembler.g:1021:1: rule__EquDirective__Group__1__Impl : ( RULE_WS ) ;
    public final void rule__EquDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1025:1: ( ( RULE_WS ) )
            // InternalAssembler.g:1026:1: ( RULE_WS )
            {
            // InternalAssembler.g:1026:1: ( RULE_WS )
            // InternalAssembler.g:1027:2: RULE_WS
            {
             before(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1()); 
            match(input,RULE_WS,FOLLOW_2); 
             after(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_1()); 

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
    // InternalAssembler.g:1036:1: rule__EquDirective__Group__2 : rule__EquDirective__Group__2__Impl rule__EquDirective__Group__3 ;
    public final void rule__EquDirective__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1040:1: ( rule__EquDirective__Group__2__Impl rule__EquDirective__Group__3 )
            // InternalAssembler.g:1041:2: rule__EquDirective__Group__2__Impl rule__EquDirective__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__EquDirective__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__3();

            state._fsp--;


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
    // InternalAssembler.g:1048:1: rule__EquDirective__Group__2__Impl : ( ( rule__EquDirective__DirectiveAssignment_2 ) ) ;
    public final void rule__EquDirective__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1052:1: ( ( ( rule__EquDirective__DirectiveAssignment_2 ) ) )
            // InternalAssembler.g:1053:1: ( ( rule__EquDirective__DirectiveAssignment_2 ) )
            {
            // InternalAssembler.g:1053:1: ( ( rule__EquDirective__DirectiveAssignment_2 ) )
            // InternalAssembler.g:1054:2: ( rule__EquDirective__DirectiveAssignment_2 )
            {
             before(grammarAccess.getEquDirectiveAccess().getDirectiveAssignment_2()); 
            // InternalAssembler.g:1055:2: ( rule__EquDirective__DirectiveAssignment_2 )
            // InternalAssembler.g:1055:3: rule__EquDirective__DirectiveAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EquDirective__DirectiveAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEquDirectiveAccess().getDirectiveAssignment_2()); 

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
    // InternalAssembler.g:1063:1: rule__EquDirective__Group__3 : rule__EquDirective__Group__3__Impl rule__EquDirective__Group__4 ;
    public final void rule__EquDirective__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1067:1: ( rule__EquDirective__Group__3__Impl rule__EquDirective__Group__4 )
            // InternalAssembler.g:1068:2: rule__EquDirective__Group__3__Impl rule__EquDirective__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__EquDirective__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__4();

            state._fsp--;


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
    // InternalAssembler.g:1075:1: rule__EquDirective__Group__3__Impl : ( RULE_WS ) ;
    public final void rule__EquDirective__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1079:1: ( ( RULE_WS ) )
            // InternalAssembler.g:1080:1: ( RULE_WS )
            {
            // InternalAssembler.g:1080:1: ( RULE_WS )
            // InternalAssembler.g:1081:2: RULE_WS
            {
             before(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3()); 
            match(input,RULE_WS,FOLLOW_2); 
             after(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_3()); 

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
    // InternalAssembler.g:1090:1: rule__EquDirective__Group__4 : rule__EquDirective__Group__4__Impl rule__EquDirective__Group__5 ;
    public final void rule__EquDirective__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1094:1: ( rule__EquDirective__Group__4__Impl rule__EquDirective__Group__5 )
            // InternalAssembler.g:1095:2: rule__EquDirective__Group__4__Impl rule__EquDirective__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__EquDirective__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__5();

            state._fsp--;


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
    // InternalAssembler.g:1102:1: rule__EquDirective__Group__4__Impl : ( ( rule__EquDirective__OperandAssignment_4 )? ) ;
    public final void rule__EquDirective__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1106:1: ( ( ( rule__EquDirective__OperandAssignment_4 )? ) )
            // InternalAssembler.g:1107:1: ( ( rule__EquDirective__OperandAssignment_4 )? )
            {
            // InternalAssembler.g:1107:1: ( ( rule__EquDirective__OperandAssignment_4 )? )
            // InternalAssembler.g:1108:2: ( rule__EquDirective__OperandAssignment_4 )?
            {
             before(grammarAccess.getEquDirectiveAccess().getOperandAssignment_4()); 
            // InternalAssembler.g:1109:2: ( rule__EquDirective__OperandAssignment_4 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_CHARACTER)||LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:1109:3: rule__EquDirective__OperandAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__EquDirective__OperandAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEquDirectiveAccess().getOperandAssignment_4()); 

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
    // InternalAssembler.g:1117:1: rule__EquDirective__Group__5 : rule__EquDirective__Group__5__Impl rule__EquDirective__Group__6 ;
    public final void rule__EquDirective__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1121:1: ( rule__EquDirective__Group__5__Impl rule__EquDirective__Group__6 )
            // InternalAssembler.g:1122:2: rule__EquDirective__Group__5__Impl rule__EquDirective__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__EquDirective__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__6();

            state._fsp--;


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
    // InternalAssembler.g:1129:1: rule__EquDirective__Group__5__Impl : ( ( RULE_WS )? ) ;
    public final void rule__EquDirective__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1133:1: ( ( ( RULE_WS )? ) )
            // InternalAssembler.g:1134:1: ( ( RULE_WS )? )
            {
            // InternalAssembler.g:1134:1: ( ( RULE_WS )? )
            // InternalAssembler.g:1135:2: ( RULE_WS )?
            {
             before(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5()); 
            // InternalAssembler.g:1136:2: ( RULE_WS )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_WS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:1136:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5()); 

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
    // InternalAssembler.g:1144:1: rule__EquDirective__Group__6 : rule__EquDirective__Group__6__Impl rule__EquDirective__Group__7 ;
    public final void rule__EquDirective__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1148:1: ( rule__EquDirective__Group__6__Impl rule__EquDirective__Group__7 )
            // InternalAssembler.g:1149:2: rule__EquDirective__Group__6__Impl rule__EquDirective__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__EquDirective__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__7();

            state._fsp--;


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
    // InternalAssembler.g:1156:1: rule__EquDirective__Group__6__Impl : ( ( rule__EquDirective__CommentAssignment_6 )? ) ;
    public final void rule__EquDirective__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1160:1: ( ( ( rule__EquDirective__CommentAssignment_6 )? ) )
            // InternalAssembler.g:1161:1: ( ( rule__EquDirective__CommentAssignment_6 )? )
            {
            // InternalAssembler.g:1161:1: ( ( rule__EquDirective__CommentAssignment_6 )? )
            // InternalAssembler.g:1162:2: ( rule__EquDirective__CommentAssignment_6 )?
            {
             before(grammarAccess.getEquDirectiveAccess().getCommentAssignment_6()); 
            // InternalAssembler.g:1163:2: ( rule__EquDirective__CommentAssignment_6 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ANY_EXCEPT_COMMENT_END_OF_LINE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:1163:3: rule__EquDirective__CommentAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__EquDirective__CommentAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEquDirectiveAccess().getCommentAssignment_6()); 

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
    // InternalAssembler.g:1171:1: rule__EquDirective__Group__7 : rule__EquDirective__Group__7__Impl ;
    public final void rule__EquDirective__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1175:1: ( rule__EquDirective__Group__7__Impl )
            // InternalAssembler.g:1176:2: rule__EquDirective__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__7__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1182:1: rule__EquDirective__Group__7__Impl : ( ruleEndOfLine ) ;
    public final void rule__EquDirective__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1186:1: ( ( ruleEndOfLine ) )
            // InternalAssembler.g:1187:1: ( ruleEndOfLine )
            {
            // InternalAssembler.g:1187:1: ( ruleEndOfLine )
            // InternalAssembler.g:1188:2: ruleEndOfLine
            {
             before(grammarAccess.getEquDirectiveAccess().getEndOfLineParserRuleCall_7()); 
            pushFollow(FOLLOW_2);
            ruleEndOfLine();

            state._fsp--;

             after(grammarAccess.getEquDirectiveAccess().getEndOfLineParserRuleCall_7()); 

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
    // InternalAssembler.g:1198:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1202:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // InternalAssembler.g:1203:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:1210:1: rule__Multiplication__Group__0__Impl : ( ruleDivision ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1214:1: ( ( ruleDivision ) )
            // InternalAssembler.g:1215:1: ( ruleDivision )
            {
            // InternalAssembler.g:1215:1: ( ruleDivision )
            // InternalAssembler.g:1216:2: ruleDivision
            {
             before(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDivision();

            state._fsp--;

             after(grammarAccess.getMultiplicationAccess().getDivisionParserRuleCall_0()); 

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
    // InternalAssembler.g:1225:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1229:1: ( rule__Multiplication__Group__1__Impl )
            // InternalAssembler.g:1230:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1236:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1240:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // InternalAssembler.g:1241:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // InternalAssembler.g:1241:1: ( ( rule__Multiplication__Group_1__0 )* )
            // InternalAssembler.g:1242:2: ( rule__Multiplication__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            // InternalAssembler.g:1243:2: ( rule__Multiplication__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAssembler.g:1243:3: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getMultiplicationAccess().getGroup_1()); 

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
    // InternalAssembler.g:1252:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1256:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // InternalAssembler.g:1257:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:1264:1: rule__Multiplication__Group_1__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1268:1: ( ( () ) )
            // InternalAssembler.g:1269:1: ( () )
            {
            // InternalAssembler.g:1269:1: ( () )
            // InternalAssembler.g:1270:2: ()
            {
             before(grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0()); 
            // InternalAssembler.g:1271:2: ()
            // InternalAssembler.g:1271:3: 
            {
            }

             after(grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0()); 

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
    // InternalAssembler.g:1279:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl rule__Multiplication__Group_1__2 ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1283:1: ( rule__Multiplication__Group_1__1__Impl rule__Multiplication__Group_1__2 )
            // InternalAssembler.g:1284:2: rule__Multiplication__Group_1__1__Impl rule__Multiplication__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Multiplication__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:1291:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__OperationAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1295:1: ( ( ( rule__Multiplication__OperationAssignment_1_1 ) ) )
            // InternalAssembler.g:1296:1: ( ( rule__Multiplication__OperationAssignment_1_1 ) )
            {
            // InternalAssembler.g:1296:1: ( ( rule__Multiplication__OperationAssignment_1_1 ) )
            // InternalAssembler.g:1297:2: ( rule__Multiplication__OperationAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicationAccess().getOperationAssignment_1_1()); 
            // InternalAssembler.g:1298:2: ( rule__Multiplication__OperationAssignment_1_1 )
            // InternalAssembler.g:1298:3: rule__Multiplication__OperationAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__OperationAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getOperationAssignment_1_1()); 

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
    // InternalAssembler.g:1306:1: rule__Multiplication__Group_1__2 : rule__Multiplication__Group_1__2__Impl ;
    public final void rule__Multiplication__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1310:1: ( rule__Multiplication__Group_1__2__Impl )
            // InternalAssembler.g:1311:2: rule__Multiplication__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1317:1: rule__Multiplication__Group_1__2__Impl : ( ( rule__Multiplication__RightAssignment_1_2 ) ) ;
    public final void rule__Multiplication__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1321:1: ( ( ( rule__Multiplication__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1322:1: ( ( rule__Multiplication__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1322:1: ( ( rule__Multiplication__RightAssignment_1_2 ) )
            // InternalAssembler.g:1323:2: ( rule__Multiplication__RightAssignment_1_2 )
            {
             before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:1324:2: ( rule__Multiplication__RightAssignment_1_2 )
            // InternalAssembler.g:1324:3: rule__Multiplication__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:1333:1: rule__Division__Group__0 : rule__Division__Group__0__Impl rule__Division__Group__1 ;
    public final void rule__Division__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1337:1: ( rule__Division__Group__0__Impl rule__Division__Group__1 )
            // InternalAssembler.g:1338:2: rule__Division__Group__0__Impl rule__Division__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Division__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Division__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:1345:1: rule__Division__Group__0__Impl : ( ruleModulo ) ;
    public final void rule__Division__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1349:1: ( ( ruleModulo ) )
            // InternalAssembler.g:1350:1: ( ruleModulo )
            {
            // InternalAssembler.g:1350:1: ( ruleModulo )
            // InternalAssembler.g:1351:2: ruleModulo
            {
             before(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleModulo();

            state._fsp--;

             after(grammarAccess.getDivisionAccess().getModuloParserRuleCall_0()); 

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
    // InternalAssembler.g:1360:1: rule__Division__Group__1 : rule__Division__Group__1__Impl ;
    public final void rule__Division__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1364:1: ( rule__Division__Group__1__Impl )
            // InternalAssembler.g:1365:2: rule__Division__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Division__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1371:1: rule__Division__Group__1__Impl : ( ( rule__Division__Group_1__0 )* ) ;
    public final void rule__Division__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1375:1: ( ( ( rule__Division__Group_1__0 )* ) )
            // InternalAssembler.g:1376:1: ( ( rule__Division__Group_1__0 )* )
            {
            // InternalAssembler.g:1376:1: ( ( rule__Division__Group_1__0 )* )
            // InternalAssembler.g:1377:2: ( rule__Division__Group_1__0 )*
            {
             before(grammarAccess.getDivisionAccess().getGroup_1()); 
            // InternalAssembler.g:1378:2: ( rule__Division__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAssembler.g:1378:3: rule__Division__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Division__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getDivisionAccess().getGroup_1()); 

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
    // InternalAssembler.g:1387:1: rule__Division__Group_1__0 : rule__Division__Group_1__0__Impl rule__Division__Group_1__1 ;
    public final void rule__Division__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1391:1: ( rule__Division__Group_1__0__Impl rule__Division__Group_1__1 )
            // InternalAssembler.g:1392:2: rule__Division__Group_1__0__Impl rule__Division__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Division__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Division__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:1399:1: rule__Division__Group_1__0__Impl : ( () ) ;
    public final void rule__Division__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1403:1: ( ( () ) )
            // InternalAssembler.g:1404:1: ( () )
            {
            // InternalAssembler.g:1404:1: ( () )
            // InternalAssembler.g:1405:2: ()
            {
             before(grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0()); 
            // InternalAssembler.g:1406:2: ()
            // InternalAssembler.g:1406:3: 
            {
            }

             after(grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0()); 

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
    // InternalAssembler.g:1414:1: rule__Division__Group_1__1 : rule__Division__Group_1__1__Impl rule__Division__Group_1__2 ;
    public final void rule__Division__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1418:1: ( rule__Division__Group_1__1__Impl rule__Division__Group_1__2 )
            // InternalAssembler.g:1419:2: rule__Division__Group_1__1__Impl rule__Division__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Division__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Division__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:1426:1: rule__Division__Group_1__1__Impl : ( ( rule__Division__OpretationAssignment_1_1 ) ) ;
    public final void rule__Division__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1430:1: ( ( ( rule__Division__OpretationAssignment_1_1 ) ) )
            // InternalAssembler.g:1431:1: ( ( rule__Division__OpretationAssignment_1_1 ) )
            {
            // InternalAssembler.g:1431:1: ( ( rule__Division__OpretationAssignment_1_1 ) )
            // InternalAssembler.g:1432:2: ( rule__Division__OpretationAssignment_1_1 )
            {
             before(grammarAccess.getDivisionAccess().getOpretationAssignment_1_1()); 
            // InternalAssembler.g:1433:2: ( rule__Division__OpretationAssignment_1_1 )
            // InternalAssembler.g:1433:3: rule__Division__OpretationAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Division__OpretationAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDivisionAccess().getOpretationAssignment_1_1()); 

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
    // InternalAssembler.g:1441:1: rule__Division__Group_1__2 : rule__Division__Group_1__2__Impl ;
    public final void rule__Division__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1445:1: ( rule__Division__Group_1__2__Impl )
            // InternalAssembler.g:1446:2: rule__Division__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Division__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1452:1: rule__Division__Group_1__2__Impl : ( ( rule__Division__RightAssignment_1_2 ) ) ;
    public final void rule__Division__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1456:1: ( ( ( rule__Division__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1457:1: ( ( rule__Division__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1457:1: ( ( rule__Division__RightAssignment_1_2 ) )
            // InternalAssembler.g:1458:2: ( rule__Division__RightAssignment_1_2 )
            {
             before(grammarAccess.getDivisionAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:1459:2: ( rule__Division__RightAssignment_1_2 )
            // InternalAssembler.g:1459:3: rule__Division__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Division__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDivisionAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:1468:1: rule__Modulo__Group__0 : rule__Modulo__Group__0__Impl rule__Modulo__Group__1 ;
    public final void rule__Modulo__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1472:1: ( rule__Modulo__Group__0__Impl rule__Modulo__Group__1 )
            // InternalAssembler.g:1473:2: rule__Modulo__Group__0__Impl rule__Modulo__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Modulo__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Modulo__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:1480:1: rule__Modulo__Group__0__Impl : ( ruleAddition ) ;
    public final void rule__Modulo__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1484:1: ( ( ruleAddition ) )
            // InternalAssembler.g:1485:1: ( ruleAddition )
            {
            // InternalAssembler.g:1485:1: ( ruleAddition )
            // InternalAssembler.g:1486:2: ruleAddition
            {
             before(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getModuloAccess().getAdditionParserRuleCall_0()); 

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
    // InternalAssembler.g:1495:1: rule__Modulo__Group__1 : rule__Modulo__Group__1__Impl ;
    public final void rule__Modulo__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1499:1: ( rule__Modulo__Group__1__Impl )
            // InternalAssembler.g:1500:2: rule__Modulo__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1506:1: rule__Modulo__Group__1__Impl : ( ( rule__Modulo__Group_1__0 )* ) ;
    public final void rule__Modulo__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1510:1: ( ( ( rule__Modulo__Group_1__0 )* ) )
            // InternalAssembler.g:1511:1: ( ( rule__Modulo__Group_1__0 )* )
            {
            // InternalAssembler.g:1511:1: ( ( rule__Modulo__Group_1__0 )* )
            // InternalAssembler.g:1512:2: ( rule__Modulo__Group_1__0 )*
            {
             before(grammarAccess.getModuloAccess().getGroup_1()); 
            // InternalAssembler.g:1513:2: ( rule__Modulo__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAssembler.g:1513:3: rule__Modulo__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Modulo__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getModuloAccess().getGroup_1()); 

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
    // InternalAssembler.g:1522:1: rule__Modulo__Group_1__0 : rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1 ;
    public final void rule__Modulo__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1526:1: ( rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1 )
            // InternalAssembler.g:1527:2: rule__Modulo__Group_1__0__Impl rule__Modulo__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__Modulo__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:1534:1: rule__Modulo__Group_1__0__Impl : ( () ) ;
    public final void rule__Modulo__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1538:1: ( ( () ) )
            // InternalAssembler.g:1539:1: ( () )
            {
            // InternalAssembler.g:1539:1: ( () )
            // InternalAssembler.g:1540:2: ()
            {
             before(grammarAccess.getModuloAccess().getModuloLeftAction_1_0()); 
            // InternalAssembler.g:1541:2: ()
            // InternalAssembler.g:1541:3: 
            {
            }

             after(grammarAccess.getModuloAccess().getModuloLeftAction_1_0()); 

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
    // InternalAssembler.g:1549:1: rule__Modulo__Group_1__1 : rule__Modulo__Group_1__1__Impl rule__Modulo__Group_1__2 ;
    public final void rule__Modulo__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1553:1: ( rule__Modulo__Group_1__1__Impl rule__Modulo__Group_1__2 )
            // InternalAssembler.g:1554:2: rule__Modulo__Group_1__1__Impl rule__Modulo__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Modulo__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:1561:1: rule__Modulo__Group_1__1__Impl : ( ( rule__Modulo__OpretationAssignment_1_1 ) ) ;
    public final void rule__Modulo__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1565:1: ( ( ( rule__Modulo__OpretationAssignment_1_1 ) ) )
            // InternalAssembler.g:1566:1: ( ( rule__Modulo__OpretationAssignment_1_1 ) )
            {
            // InternalAssembler.g:1566:1: ( ( rule__Modulo__OpretationAssignment_1_1 ) )
            // InternalAssembler.g:1567:2: ( rule__Modulo__OpretationAssignment_1_1 )
            {
             before(grammarAccess.getModuloAccess().getOpretationAssignment_1_1()); 
            // InternalAssembler.g:1568:2: ( rule__Modulo__OpretationAssignment_1_1 )
            // InternalAssembler.g:1568:3: rule__Modulo__OpretationAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__OpretationAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModuloAccess().getOpretationAssignment_1_1()); 

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
    // InternalAssembler.g:1576:1: rule__Modulo__Group_1__2 : rule__Modulo__Group_1__2__Impl ;
    public final void rule__Modulo__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1580:1: ( rule__Modulo__Group_1__2__Impl )
            // InternalAssembler.g:1581:2: rule__Modulo__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1587:1: rule__Modulo__Group_1__2__Impl : ( ( rule__Modulo__RightAssignment_1_2 ) ) ;
    public final void rule__Modulo__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1591:1: ( ( ( rule__Modulo__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1592:1: ( ( rule__Modulo__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1592:1: ( ( rule__Modulo__RightAssignment_1_2 ) )
            // InternalAssembler.g:1593:2: ( rule__Modulo__RightAssignment_1_2 )
            {
             before(grammarAccess.getModuloAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:1594:2: ( rule__Modulo__RightAssignment_1_2 )
            // InternalAssembler.g:1594:3: rule__Modulo__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Modulo__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getModuloAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:1603:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1607:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // InternalAssembler.g:1608:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Addition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Addition__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:1615:1: rule__Addition__Group__0__Impl : ( ruleSubstraction ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1619:1: ( ( ruleSubstraction ) )
            // InternalAssembler.g:1620:1: ( ruleSubstraction )
            {
            // InternalAssembler.g:1620:1: ( ruleSubstraction )
            // InternalAssembler.g:1621:2: ruleSubstraction
            {
             before(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSubstraction();

            state._fsp--;

             after(grammarAccess.getAdditionAccess().getSubstractionParserRuleCall_0()); 

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
    // InternalAssembler.g:1630:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1634:1: ( rule__Addition__Group__1__Impl )
            // InternalAssembler.g:1635:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1641:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1645:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // InternalAssembler.g:1646:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // InternalAssembler.g:1646:1: ( ( rule__Addition__Group_1__0 )* )
            // InternalAssembler.g:1647:2: ( rule__Addition__Group_1__0 )*
            {
             before(grammarAccess.getAdditionAccess().getGroup_1()); 
            // InternalAssembler.g:1648:2: ( rule__Addition__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==15) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalAssembler.g:1648:3: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getAdditionAccess().getGroup_1()); 

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
    // InternalAssembler.g:1657:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1661:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // InternalAssembler.g:1662:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:1669:1: rule__Addition__Group_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1673:1: ( ( () ) )
            // InternalAssembler.g:1674:1: ( () )
            {
            // InternalAssembler.g:1674:1: ( () )
            // InternalAssembler.g:1675:2: ()
            {
             before(grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0()); 
            // InternalAssembler.g:1676:2: ()
            // InternalAssembler.g:1676:3: 
            {
            }

             after(grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0()); 

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
    // InternalAssembler.g:1684:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl rule__Addition__Group_1__2 ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1688:1: ( rule__Addition__Group_1__1__Impl rule__Addition__Group_1__2 )
            // InternalAssembler.g:1689:2: rule__Addition__Group_1__1__Impl rule__Addition__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Addition__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:1696:1: rule__Addition__Group_1__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1700:1: ( ( '+' ) )
            // InternalAssembler.g:1701:1: ( '+' )
            {
            // InternalAssembler.g:1701:1: ( '+' )
            // InternalAssembler.g:1702:2: '+'
            {
             before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1()); 

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
    // InternalAssembler.g:1711:1: rule__Addition__Group_1__2 : rule__Addition__Group_1__2__Impl ;
    public final void rule__Addition__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1715:1: ( rule__Addition__Group_1__2__Impl )
            // InternalAssembler.g:1716:2: rule__Addition__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1722:1: rule__Addition__Group_1__2__Impl : ( ( rule__Addition__RightAssignment_1_2 ) ) ;
    public final void rule__Addition__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1726:1: ( ( ( rule__Addition__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1727:1: ( ( rule__Addition__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1727:1: ( ( rule__Addition__RightAssignment_1_2 ) )
            // InternalAssembler.g:1728:2: ( rule__Addition__RightAssignment_1_2 )
            {
             before(grammarAccess.getAdditionAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:1729:2: ( rule__Addition__RightAssignment_1_2 )
            // InternalAssembler.g:1729:3: rule__Addition__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Addition__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAdditionAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:1738:1: rule__Substraction__Group__0 : rule__Substraction__Group__0__Impl rule__Substraction__Group__1 ;
    public final void rule__Substraction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1742:1: ( rule__Substraction__Group__0__Impl rule__Substraction__Group__1 )
            // InternalAssembler.g:1743:2: rule__Substraction__Group__0__Impl rule__Substraction__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Substraction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Substraction__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:1750:1: rule__Substraction__Group__0__Impl : ( ruleLeftShift ) ;
    public final void rule__Substraction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1754:1: ( ( ruleLeftShift ) )
            // InternalAssembler.g:1755:1: ( ruleLeftShift )
            {
            // InternalAssembler.g:1755:1: ( ruleLeftShift )
            // InternalAssembler.g:1756:2: ruleLeftShift
            {
             before(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleLeftShift();

            state._fsp--;

             after(grammarAccess.getSubstractionAccess().getLeftShiftParserRuleCall_0()); 

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
    // InternalAssembler.g:1765:1: rule__Substraction__Group__1 : rule__Substraction__Group__1__Impl ;
    public final void rule__Substraction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1769:1: ( rule__Substraction__Group__1__Impl )
            // InternalAssembler.g:1770:2: rule__Substraction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Substraction__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1776:1: rule__Substraction__Group__1__Impl : ( ( rule__Substraction__Group_1__0 )* ) ;
    public final void rule__Substraction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1780:1: ( ( ( rule__Substraction__Group_1__0 )* ) )
            // InternalAssembler.g:1781:1: ( ( rule__Substraction__Group_1__0 )* )
            {
            // InternalAssembler.g:1781:1: ( ( rule__Substraction__Group_1__0 )* )
            // InternalAssembler.g:1782:2: ( rule__Substraction__Group_1__0 )*
            {
             before(grammarAccess.getSubstractionAccess().getGroup_1()); 
            // InternalAssembler.g:1783:2: ( rule__Substraction__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==16) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalAssembler.g:1783:3: rule__Substraction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__Substraction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getSubstractionAccess().getGroup_1()); 

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
    // InternalAssembler.g:1792:1: rule__Substraction__Group_1__0 : rule__Substraction__Group_1__0__Impl rule__Substraction__Group_1__1 ;
    public final void rule__Substraction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1796:1: ( rule__Substraction__Group_1__0__Impl rule__Substraction__Group_1__1 )
            // InternalAssembler.g:1797:2: rule__Substraction__Group_1__0__Impl rule__Substraction__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__Substraction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Substraction__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:1804:1: rule__Substraction__Group_1__0__Impl : ( () ) ;
    public final void rule__Substraction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1808:1: ( ( () ) )
            // InternalAssembler.g:1809:1: ( () )
            {
            // InternalAssembler.g:1809:1: ( () )
            // InternalAssembler.g:1810:2: ()
            {
             before(grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0()); 
            // InternalAssembler.g:1811:2: ()
            // InternalAssembler.g:1811:3: 
            {
            }

             after(grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0()); 

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
    // InternalAssembler.g:1819:1: rule__Substraction__Group_1__1 : rule__Substraction__Group_1__1__Impl rule__Substraction__Group_1__2 ;
    public final void rule__Substraction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1823:1: ( rule__Substraction__Group_1__1__Impl rule__Substraction__Group_1__2 )
            // InternalAssembler.g:1824:2: rule__Substraction__Group_1__1__Impl rule__Substraction__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Substraction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Substraction__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:1831:1: rule__Substraction__Group_1__1__Impl : ( '-' ) ;
    public final void rule__Substraction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1835:1: ( ( '-' ) )
            // InternalAssembler.g:1836:1: ( '-' )
            {
            // InternalAssembler.g:1836:1: ( '-' )
            // InternalAssembler.g:1837:2: '-'
            {
             before(grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getSubstractionAccess().getHyphenMinusKeyword_1_1()); 

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
    // InternalAssembler.g:1846:1: rule__Substraction__Group_1__2 : rule__Substraction__Group_1__2__Impl ;
    public final void rule__Substraction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1850:1: ( rule__Substraction__Group_1__2__Impl )
            // InternalAssembler.g:1851:2: rule__Substraction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Substraction__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1857:1: rule__Substraction__Group_1__2__Impl : ( ( rule__Substraction__RightAssignment_1_2 ) ) ;
    public final void rule__Substraction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1861:1: ( ( ( rule__Substraction__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1862:1: ( ( rule__Substraction__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1862:1: ( ( rule__Substraction__RightAssignment_1_2 ) )
            // InternalAssembler.g:1863:2: ( rule__Substraction__RightAssignment_1_2 )
            {
             before(grammarAccess.getSubstractionAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:1864:2: ( rule__Substraction__RightAssignment_1_2 )
            // InternalAssembler.g:1864:3: rule__Substraction__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Substraction__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getSubstractionAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:1873:1: rule__LeftShift__Group__0 : rule__LeftShift__Group__0__Impl rule__LeftShift__Group__1 ;
    public final void rule__LeftShift__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1877:1: ( rule__LeftShift__Group__0__Impl rule__LeftShift__Group__1 )
            // InternalAssembler.g:1878:2: rule__LeftShift__Group__0__Impl rule__LeftShift__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__LeftShift__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LeftShift__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:1885:1: rule__LeftShift__Group__0__Impl : ( ruleRigthShift ) ;
    public final void rule__LeftShift__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1889:1: ( ( ruleRigthShift ) )
            // InternalAssembler.g:1890:1: ( ruleRigthShift )
            {
            // InternalAssembler.g:1890:1: ( ruleRigthShift )
            // InternalAssembler.g:1891:2: ruleRigthShift
            {
             before(grammarAccess.getLeftShiftAccess().getRigthShiftParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleRigthShift();

            state._fsp--;

             after(grammarAccess.getLeftShiftAccess().getRigthShiftParserRuleCall_0()); 

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
    // InternalAssembler.g:1900:1: rule__LeftShift__Group__1 : rule__LeftShift__Group__1__Impl ;
    public final void rule__LeftShift__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1904:1: ( rule__LeftShift__Group__1__Impl )
            // InternalAssembler.g:1905:2: rule__LeftShift__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1911:1: rule__LeftShift__Group__1__Impl : ( ( rule__LeftShift__Group_1__0 )* ) ;
    public final void rule__LeftShift__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1915:1: ( ( ( rule__LeftShift__Group_1__0 )* ) )
            // InternalAssembler.g:1916:1: ( ( rule__LeftShift__Group_1__0 )* )
            {
            // InternalAssembler.g:1916:1: ( ( rule__LeftShift__Group_1__0 )* )
            // InternalAssembler.g:1917:2: ( rule__LeftShift__Group_1__0 )*
            {
             before(grammarAccess.getLeftShiftAccess().getGroup_1()); 
            // InternalAssembler.g:1918:2: ( rule__LeftShift__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==17) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalAssembler.g:1918:3: rule__LeftShift__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__LeftShift__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getLeftShiftAccess().getGroup_1()); 

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
    // InternalAssembler.g:1927:1: rule__LeftShift__Group_1__0 : rule__LeftShift__Group_1__0__Impl rule__LeftShift__Group_1__1 ;
    public final void rule__LeftShift__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1931:1: ( rule__LeftShift__Group_1__0__Impl rule__LeftShift__Group_1__1 )
            // InternalAssembler.g:1932:2: rule__LeftShift__Group_1__0__Impl rule__LeftShift__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__LeftShift__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LeftShift__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:1939:1: rule__LeftShift__Group_1__0__Impl : ( () ) ;
    public final void rule__LeftShift__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1943:1: ( ( () ) )
            // InternalAssembler.g:1944:1: ( () )
            {
            // InternalAssembler.g:1944:1: ( () )
            // InternalAssembler.g:1945:2: ()
            {
             before(grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0()); 
            // InternalAssembler.g:1946:2: ()
            // InternalAssembler.g:1946:3: 
            {
            }

             after(grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0()); 

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
    // InternalAssembler.g:1954:1: rule__LeftShift__Group_1__1 : rule__LeftShift__Group_1__1__Impl rule__LeftShift__Group_1__2 ;
    public final void rule__LeftShift__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1958:1: ( rule__LeftShift__Group_1__1__Impl rule__LeftShift__Group_1__2 )
            // InternalAssembler.g:1959:2: rule__LeftShift__Group_1__1__Impl rule__LeftShift__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__LeftShift__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LeftShift__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:1966:1: rule__LeftShift__Group_1__1__Impl : ( '<<' ) ;
    public final void rule__LeftShift__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1970:1: ( ( '<<' ) )
            // InternalAssembler.g:1971:1: ( '<<' )
            {
            // InternalAssembler.g:1971:1: ( '<<' )
            // InternalAssembler.g:1972:2: '<<'
            {
             before(grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getLeftShiftAccess().getLessThanSignLessThanSignKeyword_1_1()); 

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
    // InternalAssembler.g:1981:1: rule__LeftShift__Group_1__2 : rule__LeftShift__Group_1__2__Impl ;
    public final void rule__LeftShift__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1985:1: ( rule__LeftShift__Group_1__2__Impl )
            // InternalAssembler.g:1986:2: rule__LeftShift__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LeftShift__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:1992:1: rule__LeftShift__Group_1__2__Impl : ( ( rule__LeftShift__RightAssignment_1_2 ) ) ;
    public final void rule__LeftShift__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1996:1: ( ( ( rule__LeftShift__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:1997:1: ( ( rule__LeftShift__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:1997:1: ( ( rule__LeftShift__RightAssignment_1_2 ) )
            // InternalAssembler.g:1998:2: ( rule__LeftShift__RightAssignment_1_2 )
            {
             before(grammarAccess.getLeftShiftAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:1999:2: ( rule__LeftShift__RightAssignment_1_2 )
            // InternalAssembler.g:1999:3: rule__LeftShift__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__LeftShift__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getLeftShiftAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:2008:1: rule__RigthShift__Group__0 : rule__RigthShift__Group__0__Impl rule__RigthShift__Group__1 ;
    public final void rule__RigthShift__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2012:1: ( rule__RigthShift__Group__0__Impl rule__RigthShift__Group__1 )
            // InternalAssembler.g:2013:2: rule__RigthShift__Group__0__Impl rule__RigthShift__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__RigthShift__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RigthShift__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:2020:1: rule__RigthShift__Group__0__Impl : ( ruleNegate ) ;
    public final void rule__RigthShift__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2024:1: ( ( ruleNegate ) )
            // InternalAssembler.g:2025:1: ( ruleNegate )
            {
            // InternalAssembler.g:2025:1: ( ruleNegate )
            // InternalAssembler.g:2026:2: ruleNegate
            {
             before(grammarAccess.getRigthShiftAccess().getNegateParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleNegate();

            state._fsp--;

             after(grammarAccess.getRigthShiftAccess().getNegateParserRuleCall_0()); 

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
    // InternalAssembler.g:2035:1: rule__RigthShift__Group__1 : rule__RigthShift__Group__1__Impl ;
    public final void rule__RigthShift__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2039:1: ( rule__RigthShift__Group__1__Impl )
            // InternalAssembler.g:2040:2: rule__RigthShift__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2046:1: rule__RigthShift__Group__1__Impl : ( ( rule__RigthShift__Group_1__0 )* ) ;
    public final void rule__RigthShift__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2050:1: ( ( ( rule__RigthShift__Group_1__0 )* ) )
            // InternalAssembler.g:2051:1: ( ( rule__RigthShift__Group_1__0 )* )
            {
            // InternalAssembler.g:2051:1: ( ( rule__RigthShift__Group_1__0 )* )
            // InternalAssembler.g:2052:2: ( rule__RigthShift__Group_1__0 )*
            {
             before(grammarAccess.getRigthShiftAccess().getGroup_1()); 
            // InternalAssembler.g:2053:2: ( rule__RigthShift__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==18) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAssembler.g:2053:3: rule__RigthShift__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__RigthShift__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getRigthShiftAccess().getGroup_1()); 

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
    // InternalAssembler.g:2062:1: rule__RigthShift__Group_1__0 : rule__RigthShift__Group_1__0__Impl rule__RigthShift__Group_1__1 ;
    public final void rule__RigthShift__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2066:1: ( rule__RigthShift__Group_1__0__Impl rule__RigthShift__Group_1__1 )
            // InternalAssembler.g:2067:2: rule__RigthShift__Group_1__0__Impl rule__RigthShift__Group_1__1
            {
            pushFollow(FOLLOW_22);
            rule__RigthShift__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RigthShift__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:2074:1: rule__RigthShift__Group_1__0__Impl : ( () ) ;
    public final void rule__RigthShift__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2078:1: ( ( () ) )
            // InternalAssembler.g:2079:1: ( () )
            {
            // InternalAssembler.g:2079:1: ( () )
            // InternalAssembler.g:2080:2: ()
            {
             before(grammarAccess.getRigthShiftAccess().getRigthShiftLeftAction_1_0()); 
            // InternalAssembler.g:2081:2: ()
            // InternalAssembler.g:2081:3: 
            {
            }

             after(grammarAccess.getRigthShiftAccess().getRigthShiftLeftAction_1_0()); 

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
    // InternalAssembler.g:2089:1: rule__RigthShift__Group_1__1 : rule__RigthShift__Group_1__1__Impl rule__RigthShift__Group_1__2 ;
    public final void rule__RigthShift__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2093:1: ( rule__RigthShift__Group_1__1__Impl rule__RigthShift__Group_1__2 )
            // InternalAssembler.g:2094:2: rule__RigthShift__Group_1__1__Impl rule__RigthShift__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__RigthShift__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RigthShift__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:2101:1: rule__RigthShift__Group_1__1__Impl : ( '>>' ) ;
    public final void rule__RigthShift__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2105:1: ( ( '>>' ) )
            // InternalAssembler.g:2106:1: ( '>>' )
            {
            // InternalAssembler.g:2106:1: ( '>>' )
            // InternalAssembler.g:2107:2: '>>'
            {
             before(grammarAccess.getRigthShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getRigthShiftAccess().getGreaterThanSignGreaterThanSignKeyword_1_1()); 

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
    // InternalAssembler.g:2116:1: rule__RigthShift__Group_1__2 : rule__RigthShift__Group_1__2__Impl ;
    public final void rule__RigthShift__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2120:1: ( rule__RigthShift__Group_1__2__Impl )
            // InternalAssembler.g:2121:2: rule__RigthShift__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RigthShift__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2127:1: rule__RigthShift__Group_1__2__Impl : ( ( rule__RigthShift__NegateAssignment_1_2 ) ) ;
    public final void rule__RigthShift__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2131:1: ( ( ( rule__RigthShift__NegateAssignment_1_2 ) ) )
            // InternalAssembler.g:2132:1: ( ( rule__RigthShift__NegateAssignment_1_2 ) )
            {
            // InternalAssembler.g:2132:1: ( ( rule__RigthShift__NegateAssignment_1_2 ) )
            // InternalAssembler.g:2133:2: ( rule__RigthShift__NegateAssignment_1_2 )
            {
             before(grammarAccess.getRigthShiftAccess().getNegateAssignment_1_2()); 
            // InternalAssembler.g:2134:2: ( rule__RigthShift__NegateAssignment_1_2 )
            // InternalAssembler.g:2134:3: rule__RigthShift__NegateAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__RigthShift__NegateAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getRigthShiftAccess().getNegateAssignment_1_2()); 

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
    // InternalAssembler.g:2143:1: rule__Negate__Group__0 : rule__Negate__Group__0__Impl rule__Negate__Group__1 ;
    public final void rule__Negate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2147:1: ( rule__Negate__Group__0__Impl rule__Negate__Group__1 )
            // InternalAssembler.g:2148:2: rule__Negate__Group__0__Impl rule__Negate__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Negate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Negate__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:2155:1: rule__Negate__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Negate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2159:1: ( ( ruleAnd ) )
            // InternalAssembler.g:2160:1: ( ruleAnd )
            {
            // InternalAssembler.g:2160:1: ( ruleAnd )
            // InternalAssembler.g:2161:2: ruleAnd
            {
             before(grammarAccess.getNegateAccess().getAndParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getNegateAccess().getAndParserRuleCall_0()); 

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
    // InternalAssembler.g:2170:1: rule__Negate__Group__1 : rule__Negate__Group__1__Impl ;
    public final void rule__Negate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2174:1: ( rule__Negate__Group__1__Impl )
            // InternalAssembler.g:2175:2: rule__Negate__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Negate__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2181:1: rule__Negate__Group__1__Impl : ( ( rule__Negate__Group_1__0 )* ) ;
    public final void rule__Negate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2185:1: ( ( ( rule__Negate__Group_1__0 )* ) )
            // InternalAssembler.g:2186:1: ( ( rule__Negate__Group_1__0 )* )
            {
            // InternalAssembler.g:2186:1: ( ( rule__Negate__Group_1__0 )* )
            // InternalAssembler.g:2187:2: ( rule__Negate__Group_1__0 )*
            {
             before(grammarAccess.getNegateAccess().getGroup_1()); 
            // InternalAssembler.g:2188:2: ( rule__Negate__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAssembler.g:2188:3: rule__Negate__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__Negate__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getNegateAccess().getGroup_1()); 

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
    // InternalAssembler.g:2197:1: rule__Negate__Group_1__0 : rule__Negate__Group_1__0__Impl rule__Negate__Group_1__1 ;
    public final void rule__Negate__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2201:1: ( rule__Negate__Group_1__0__Impl rule__Negate__Group_1__1 )
            // InternalAssembler.g:2202:2: rule__Negate__Group_1__0__Impl rule__Negate__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__Negate__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Negate__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:2209:1: rule__Negate__Group_1__0__Impl : ( () ) ;
    public final void rule__Negate__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2213:1: ( ( () ) )
            // InternalAssembler.g:2214:1: ( () )
            {
            // InternalAssembler.g:2214:1: ( () )
            // InternalAssembler.g:2215:2: ()
            {
             before(grammarAccess.getNegateAccess().getNegateLeftAction_1_0()); 
            // InternalAssembler.g:2216:2: ()
            // InternalAssembler.g:2216:3: 
            {
            }

             after(grammarAccess.getNegateAccess().getNegateLeftAction_1_0()); 

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
    // InternalAssembler.g:2224:1: rule__Negate__Group_1__1 : rule__Negate__Group_1__1__Impl rule__Negate__Group_1__2 ;
    public final void rule__Negate__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2228:1: ( rule__Negate__Group_1__1__Impl rule__Negate__Group_1__2 )
            // InternalAssembler.g:2229:2: rule__Negate__Group_1__1__Impl rule__Negate__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Negate__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Negate__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:2236:1: rule__Negate__Group_1__1__Impl : ( '~' ) ;
    public final void rule__Negate__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2240:1: ( ( '~' ) )
            // InternalAssembler.g:2241:1: ( '~' )
            {
            // InternalAssembler.g:2241:1: ( '~' )
            // InternalAssembler.g:2242:2: '~'
            {
             before(grammarAccess.getNegateAccess().getTildeKeyword_1_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getNegateAccess().getTildeKeyword_1_1()); 

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
    // InternalAssembler.g:2251:1: rule__Negate__Group_1__2 : rule__Negate__Group_1__2__Impl ;
    public final void rule__Negate__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2255:1: ( rule__Negate__Group_1__2__Impl )
            // InternalAssembler.g:2256:2: rule__Negate__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Negate__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2262:1: rule__Negate__Group_1__2__Impl : ( ( rule__Negate__RightAssignment_1_2 ) ) ;
    public final void rule__Negate__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2266:1: ( ( ( rule__Negate__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:2267:1: ( ( rule__Negate__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:2267:1: ( ( rule__Negate__RightAssignment_1_2 ) )
            // InternalAssembler.g:2268:2: ( rule__Negate__RightAssignment_1_2 )
            {
             before(grammarAccess.getNegateAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:2269:2: ( rule__Negate__RightAssignment_1_2 )
            // InternalAssembler.g:2269:3: rule__Negate__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Negate__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNegateAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:2278:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2282:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalAssembler.g:2283:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__And__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:2290:1: rule__And__Group__0__Impl : ( ruleOr ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2294:1: ( ( ruleOr ) )
            // InternalAssembler.g:2295:1: ( ruleOr )
            {
            // InternalAssembler.g:2295:1: ( ruleOr )
            // InternalAssembler.g:2296:2: ruleOr
            {
             before(grammarAccess.getAndAccess().getOrParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getAndAccess().getOrParserRuleCall_0()); 

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
    // InternalAssembler.g:2305:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2309:1: ( rule__And__Group__1__Impl )
            // InternalAssembler.g:2310:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2316:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2320:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalAssembler.g:2321:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalAssembler.g:2321:1: ( ( rule__And__Group_1__0 )* )
            // InternalAssembler.g:2322:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalAssembler.g:2323:2: ( rule__And__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==20) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalAssembler.g:2323:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__And__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getAndAccess().getGroup_1()); 

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
    // InternalAssembler.g:2332:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2336:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalAssembler.g:2337:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_26);
            rule__And__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:2344:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2348:1: ( ( () ) )
            // InternalAssembler.g:2349:1: ( () )
            {
            // InternalAssembler.g:2349:1: ( () )
            // InternalAssembler.g:2350:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalAssembler.g:2351:2: ()
            // InternalAssembler.g:2351:3: 
            {
            }

             after(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 

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
    // InternalAssembler.g:2359:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2363:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalAssembler.g:2364:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__And__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:2371:1: rule__And__Group_1__1__Impl : ( '&&' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2375:1: ( ( '&&' ) )
            // InternalAssembler.g:2376:1: ( '&&' )
            {
            // InternalAssembler.g:2376:1: ( '&&' )
            // InternalAssembler.g:2377:2: '&&'
            {
             before(grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getAndAccess().getAmpersandAmpersandKeyword_1_1()); 

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
    // InternalAssembler.g:2386:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2390:1: ( rule__And__Group_1__2__Impl )
            // InternalAssembler.g:2391:2: rule__And__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2397:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2401:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:2402:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:2402:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalAssembler.g:2403:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:2404:2: ( rule__And__RightAssignment_1_2 )
            // InternalAssembler.g:2404:3: rule__And__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__And__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:2413:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2417:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalAssembler.g:2418:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__Or__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:2425:1: rule__Or__Group__0__Impl : ( ruleXor ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2429:1: ( ( ruleXor ) )
            // InternalAssembler.g:2430:1: ( ruleXor )
            {
            // InternalAssembler.g:2430:1: ( ruleXor )
            // InternalAssembler.g:2431:2: ruleXor
            {
             before(grammarAccess.getOrAccess().getXorParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getOrAccess().getXorParserRuleCall_0()); 

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
    // InternalAssembler.g:2440:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2444:1: ( rule__Or__Group__1__Impl )
            // InternalAssembler.g:2445:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2451:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2455:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalAssembler.g:2456:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalAssembler.g:2456:1: ( ( rule__Or__Group_1__0 )* )
            // InternalAssembler.g:2457:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalAssembler.g:2458:2: ( rule__Or__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==21) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAssembler.g:2458:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__Or__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getOrAccess().getGroup_1()); 

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
    // InternalAssembler.g:2467:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2471:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalAssembler.g:2472:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__Or__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:2479:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2483:1: ( ( () ) )
            // InternalAssembler.g:2484:1: ( () )
            {
            // InternalAssembler.g:2484:1: ( () )
            // InternalAssembler.g:2485:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalAssembler.g:2486:2: ()
            // InternalAssembler.g:2486:3: 
            {
            }

             after(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 

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
    // InternalAssembler.g:2494:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2498:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalAssembler.g:2499:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Or__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:2506:1: rule__Or__Group_1__1__Impl : ( '||' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2510:1: ( ( '||' ) )
            // InternalAssembler.g:2511:1: ( '||' )
            {
            // InternalAssembler.g:2511:1: ( '||' )
            // InternalAssembler.g:2512:2: '||'
            {
             before(grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getOrAccess().getVerticalLineVerticalLineKeyword_1_1()); 

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
    // InternalAssembler.g:2521:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2525:1: ( rule__Or__Group_1__2__Impl )
            // InternalAssembler.g:2526:2: rule__Or__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2532:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2536:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:2537:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:2537:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalAssembler.g:2538:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:2539:2: ( rule__Or__RightAssignment_1_2 )
            // InternalAssembler.g:2539:3: rule__Or__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Or__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:2548:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2552:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalAssembler.g:2553:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__Xor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group__1();

            state._fsp--;


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
    // InternalAssembler.g:2560:1: rule__Xor__Group__0__Impl : ( rulePrimary ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2564:1: ( ( rulePrimary ) )
            // InternalAssembler.g:2565:1: ( rulePrimary )
            {
            // InternalAssembler.g:2565:1: ( rulePrimary )
            // InternalAssembler.g:2566:2: rulePrimary
            {
             before(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getXorAccess().getPrimaryParserRuleCall_0()); 

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
    // InternalAssembler.g:2575:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2579:1: ( rule__Xor__Group__1__Impl )
            // InternalAssembler.g:2580:2: rule__Xor__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group__1__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2586:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2590:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalAssembler.g:2591:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalAssembler.g:2591:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalAssembler.g:2592:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalAssembler.g:2593:2: ( rule__Xor__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAssembler.g:2593:3: rule__Xor__Group_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__Xor__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getXorAccess().getGroup_1()); 

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
    // InternalAssembler.g:2602:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2606:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalAssembler.g:2607:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Xor__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__1();

            state._fsp--;


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
    // InternalAssembler.g:2614:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2618:1: ( ( () ) )
            // InternalAssembler.g:2619:1: ( () )
            {
            // InternalAssembler.g:2619:1: ( () )
            // InternalAssembler.g:2620:2: ()
            {
             before(grammarAccess.getXorAccess().getOrLeftAction_1_0()); 
            // InternalAssembler.g:2621:2: ()
            // InternalAssembler.g:2621:3: 
            {
            }

             after(grammarAccess.getXorAccess().getOrLeftAction_1_0()); 

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
    // InternalAssembler.g:2629:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2633:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalAssembler.g:2634:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Xor__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__2();

            state._fsp--;


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
    // InternalAssembler.g:2641:1: rule__Xor__Group_1__1__Impl : ( '^' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2645:1: ( ( '^' ) )
            // InternalAssembler.g:2646:1: ( '^' )
            {
            // InternalAssembler.g:2646:1: ( '^' )
            // InternalAssembler.g:2647:2: '^'
            {
             before(grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getXorAccess().getCircumflexAccentKeyword_1_1()); 

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
    // InternalAssembler.g:2656:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2660:1: ( rule__Xor__Group_1__2__Impl )
            // InternalAssembler.g:2661:2: rule__Xor__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2667:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2671:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalAssembler.g:2672:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalAssembler.g:2672:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalAssembler.g:2673:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalAssembler.g:2674:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalAssembler.g:2674:3: rule__Xor__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Xor__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getXorAccess().getRightAssignment_1_2()); 

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
    // InternalAssembler.g:2683:1: rule__Primary__Group_6__0 : rule__Primary__Group_6__0__Impl rule__Primary__Group_6__1 ;
    public final void rule__Primary__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2687:1: ( rule__Primary__Group_6__0__Impl rule__Primary__Group_6__1 )
            // InternalAssembler.g:2688:2: rule__Primary__Group_6__0__Impl rule__Primary__Group_6__1
            {
            pushFollow(FOLLOW_11);
            rule__Primary__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_6__1();

            state._fsp--;


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
    // InternalAssembler.g:2695:1: rule__Primary__Group_6__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2699:1: ( ( '(' ) )
            // InternalAssembler.g:2700:1: ( '(' )
            {
            // InternalAssembler.g:2700:1: ( '(' )
            // InternalAssembler.g:2701:2: '('
            {
             before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_6_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_6_0()); 

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
    // InternalAssembler.g:2710:1: rule__Primary__Group_6__1 : rule__Primary__Group_6__1__Impl rule__Primary__Group_6__2 ;
    public final void rule__Primary__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2714:1: ( rule__Primary__Group_6__1__Impl rule__Primary__Group_6__2 )
            // InternalAssembler.g:2715:2: rule__Primary__Group_6__1__Impl rule__Primary__Group_6__2
            {
            pushFollow(FOLLOW_32);
            rule__Primary__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_6__2();

            state._fsp--;


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
    // InternalAssembler.g:2722:1: rule__Primary__Group_6__1__Impl : ( ruleMultiplication ) ;
    public final void rule__Primary__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2726:1: ( ( ruleMultiplication ) )
            // InternalAssembler.g:2727:1: ( ruleMultiplication )
            {
            // InternalAssembler.g:2727:1: ( ruleMultiplication )
            // InternalAssembler.g:2728:2: ruleMultiplication
            {
             before(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_6_1()); 
            pushFollow(FOLLOW_2);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getMultiplicationParserRuleCall_6_1()); 

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
    // InternalAssembler.g:2737:1: rule__Primary__Group_6__2 : rule__Primary__Group_6__2__Impl ;
    public final void rule__Primary__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2741:1: ( rule__Primary__Group_6__2__Impl )
            // InternalAssembler.g:2742:2: rule__Primary__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_6__2__Impl();

            state._fsp--;


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
    // InternalAssembler.g:2748:1: rule__Primary__Group_6__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2752:1: ( ( ')' ) )
            // InternalAssembler.g:2753:1: ( ')' )
            {
            // InternalAssembler.g:2753:1: ( ')' )
            // InternalAssembler.g:2754:2: ')'
            {
             before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_6_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_6_2()); 

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


    // $ANTLR start "rule__Model__SourceLinesAssignment"
    // InternalAssembler.g:2764:1: rule__Model__SourceLinesAssignment : ( ruleSourceLine ) ;
    public final void rule__Model__SourceLinesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2768:1: ( ( ruleSourceLine ) )
            // InternalAssembler.g:2769:2: ( ruleSourceLine )
            {
            // InternalAssembler.g:2769:2: ( ruleSourceLine )
            // InternalAssembler.g:2770:3: ruleSourceLine
            {
             before(grammarAccess.getModelAccess().getSourceLinesSourceLineParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSourceLine();

            state._fsp--;

             after(grammarAccess.getModelAccess().getSourceLinesSourceLineParserRuleCall_0()); 

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
    // InternalAssembler.g:2779:1: rule__SourceLine__LineContentAssignment_0 : ( ruleBlankLine ) ;
    public final void rule__SourceLine__LineContentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2783:1: ( ( ruleBlankLine ) )
            // InternalAssembler.g:2784:2: ( ruleBlankLine )
            {
            // InternalAssembler.g:2784:2: ( ruleBlankLine )
            // InternalAssembler.g:2785:3: ruleBlankLine
            {
             before(grammarAccess.getSourceLineAccess().getLineContentBlankLineParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleBlankLine();

            state._fsp--;

             after(grammarAccess.getSourceLineAccess().getLineContentBlankLineParserRuleCall_0_0()); 

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
    // InternalAssembler.g:2794:1: rule__SourceLine__LineContentAssignment_1 : ( ruleCommentLine ) ;
    public final void rule__SourceLine__LineContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2798:1: ( ( ruleCommentLine ) )
            // InternalAssembler.g:2799:2: ( ruleCommentLine )
            {
            // InternalAssembler.g:2799:2: ( ruleCommentLine )
            // InternalAssembler.g:2800:3: ruleCommentLine
            {
             before(grammarAccess.getSourceLineAccess().getLineContentCommentLineParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCommentLine();

            state._fsp--;

             after(grammarAccess.getSourceLineAccess().getLineContentCommentLineParserRuleCall_1_0()); 

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
    // InternalAssembler.g:2809:1: rule__SourceLine__LineContentAssignment_2 : ( ruleDirectiveLine ) ;
    public final void rule__SourceLine__LineContentAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2813:1: ( ( ruleDirectiveLine ) )
            // InternalAssembler.g:2814:2: ( ruleDirectiveLine )
            {
            // InternalAssembler.g:2814:2: ( ruleDirectiveLine )
            // InternalAssembler.g:2815:3: ruleDirectiveLine
            {
             before(grammarAccess.getSourceLineAccess().getLineContentDirectiveLineParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDirectiveLine();

            state._fsp--;

             after(grammarAccess.getSourceLineAccess().getLineContentDirectiveLineParserRuleCall_2_0()); 

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
    // InternalAssembler.g:2824:1: rule__BlankLine__BlankLineAssignment_1 : ( RULE_WS ) ;
    public final void rule__BlankLine__BlankLineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2828:1: ( ( RULE_WS ) )
            // InternalAssembler.g:2829:2: ( RULE_WS )
            {
            // InternalAssembler.g:2829:2: ( RULE_WS )
            // InternalAssembler.g:2830:3: RULE_WS
            {
             before(grammarAccess.getBlankLineAccess().getBlankLineWSTerminalRuleCall_1_0()); 
            match(input,RULE_WS,FOLLOW_2); 
             after(grammarAccess.getBlankLineAccess().getBlankLineWSTerminalRuleCall_1_0()); 

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
    // InternalAssembler.g:2839:1: rule__CommentLine__CommentAssignment_0 : ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ;
    public final void rule__CommentLine__CommentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2843:1: ( ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
            // InternalAssembler.g:2844:2: ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            {
            // InternalAssembler.g:2844:2: ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            // InternalAssembler.g:2845:3: RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
            {
             before(grammarAccess.getCommentLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_0_0()); 
            match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_2); 
             after(grammarAccess.getCommentLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_0_0()); 

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
    // InternalAssembler.g:2854:1: rule__DirectiveLine__DirectiveAssignment : ( ruleEquDirective ) ;
    public final void rule__DirectiveLine__DirectiveAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2858:1: ( ( ruleEquDirective ) )
            // InternalAssembler.g:2859:2: ( ruleEquDirective )
            {
            // InternalAssembler.g:2859:2: ( ruleEquDirective )
            // InternalAssembler.g:2860:3: ruleEquDirective
            {
             before(grammarAccess.getDirectiveLineAccess().getDirectiveEquDirectiveParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleEquDirective();

            state._fsp--;

             after(grammarAccess.getDirectiveLineAccess().getDirectiveEquDirectiveParserRuleCall_0()); 

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
    // InternalAssembler.g:2869:1: rule__EquDirective__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__EquDirective__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2873:1: ( ( ruleIdentifier ) )
            // InternalAssembler.g:2874:2: ( ruleIdentifier )
            {
            // InternalAssembler.g:2874:2: ( ruleIdentifier )
            // InternalAssembler.g:2875:3: ruleIdentifier
            {
             before(grammarAccess.getEquDirectiveAccess().getNameIdentifierParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getEquDirectiveAccess().getNameIdentifierParserRuleCall_0_0()); 

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
    // InternalAssembler.g:2884:1: rule__EquDirective__DirectiveAssignment_2 : ( ( 'EQU' ) ) ;
    public final void rule__EquDirective__DirectiveAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2888:1: ( ( ( 'EQU' ) ) )
            // InternalAssembler.g:2889:2: ( ( 'EQU' ) )
            {
            // InternalAssembler.g:2889:2: ( ( 'EQU' ) )
            // InternalAssembler.g:2890:3: ( 'EQU' )
            {
             before(grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0()); 
            // InternalAssembler.g:2891:3: ( 'EQU' )
            // InternalAssembler.g:2892:4: 'EQU'
            {
             before(grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0()); 

            }

             after(grammarAccess.getEquDirectiveAccess().getDirectiveEQUKeyword_2_0()); 

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
    // InternalAssembler.g:2903:1: rule__EquDirective__OperandAssignment_4 : ( ruleOperand ) ;
    public final void rule__EquDirective__OperandAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2907:1: ( ( ruleOperand ) )
            // InternalAssembler.g:2908:2: ( ruleOperand )
            {
            // InternalAssembler.g:2908:2: ( ruleOperand )
            // InternalAssembler.g:2909:3: ruleOperand
            {
             before(grammarAccess.getEquDirectiveAccess().getOperandOperandParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleOperand();

            state._fsp--;

             after(grammarAccess.getEquDirectiveAccess().getOperandOperandParserRuleCall_4_0()); 

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
    // InternalAssembler.g:2918:1: rule__EquDirective__CommentAssignment_6 : ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) ;
    public final void rule__EquDirective__CommentAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2922:1: ( ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE ) )
            // InternalAssembler.g:2923:2: ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            {
            // InternalAssembler.g:2923:2: ( RULE_ANY_EXCEPT_COMMENT_END_OF_LINE )
            // InternalAssembler.g:2924:3: RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
            {
             before(grammarAccess.getEquDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_6_0()); 
            match(input,RULE_ANY_EXCEPT_COMMENT_END_OF_LINE,FOLLOW_2); 
             after(grammarAccess.getEquDirectiveAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_6_0()); 

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
    // InternalAssembler.g:2933:1: rule__Operand__OperandAssignment_0 : ( ruleMultiplication ) ;
    public final void rule__Operand__OperandAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2937:1: ( ( ruleMultiplication ) )
            // InternalAssembler.g:2938:2: ( ruleMultiplication )
            {
            // InternalAssembler.g:2938:2: ( ruleMultiplication )
            // InternalAssembler.g:2939:3: ruleMultiplication
            {
             before(grammarAccess.getOperandAccess().getOperandMultiplicationParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getOperandAccess().getOperandMultiplicationParserRuleCall_0_0()); 

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
    // InternalAssembler.g:2948:1: rule__Operand__OperandAssignment_1 : ( ruleStringValue ) ;
    public final void rule__Operand__OperandAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2952:1: ( ( ruleStringValue ) )
            // InternalAssembler.g:2953:2: ( ruleStringValue )
            {
            // InternalAssembler.g:2953:2: ( ruleStringValue )
            // InternalAssembler.g:2954:3: ruleStringValue
            {
             before(grammarAccess.getOperandAccess().getOperandStringValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getOperandAccess().getOperandStringValueParserRuleCall_1_0()); 

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
    // InternalAssembler.g:2963:1: rule__Multiplication__OperationAssignment_1_1 : ( ( '*' ) ) ;
    public final void rule__Multiplication__OperationAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2967:1: ( ( ( '*' ) ) )
            // InternalAssembler.g:2968:2: ( ( '*' ) )
            {
            // InternalAssembler.g:2968:2: ( ( '*' ) )
            // InternalAssembler.g:2969:3: ( '*' )
            {
             before(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0()); 
            // InternalAssembler.g:2970:3: ( '*' )
            // InternalAssembler.g:2971:4: '*'
            {
             before(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0()); 

            }

             after(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0()); 

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
    // InternalAssembler.g:2982:1: rule__Multiplication__RightAssignment_1_2 : ( ruleDivision ) ;
    public final void rule__Multiplication__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2986:1: ( ( ruleDivision ) )
            // InternalAssembler.g:2987:2: ( ruleDivision )
            {
            // InternalAssembler.g:2987:2: ( ruleDivision )
            // InternalAssembler.g:2988:3: ruleDivision
            {
             before(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDivision();

            state._fsp--;

             after(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:2997:1: rule__Division__OpretationAssignment_1_1 : ( ( '/' ) ) ;
    public final void rule__Division__OpretationAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3001:1: ( ( ( '/' ) ) )
            // InternalAssembler.g:3002:2: ( ( '/' ) )
            {
            // InternalAssembler.g:3002:2: ( ( '/' ) )
            // InternalAssembler.g:3003:3: ( '/' )
            {
             before(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0()); 
            // InternalAssembler.g:3004:3: ( '/' )
            // InternalAssembler.g:3005:4: '/'
            {
             before(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0()); 

            }

             after(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0()); 

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
    // InternalAssembler.g:3016:1: rule__Division__RightAssignment_1_2 : ( ruleModulo ) ;
    public final void rule__Division__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3020:1: ( ( ruleModulo ) )
            // InternalAssembler.g:3021:2: ( ruleModulo )
            {
            // InternalAssembler.g:3021:2: ( ruleModulo )
            // InternalAssembler.g:3022:3: ruleModulo
            {
             before(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleModulo();

            state._fsp--;

             after(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3031:1: rule__Modulo__OpretationAssignment_1_1 : ( ( '%' ) ) ;
    public final void rule__Modulo__OpretationAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3035:1: ( ( ( '%' ) ) )
            // InternalAssembler.g:3036:2: ( ( '%' ) )
            {
            // InternalAssembler.g:3036:2: ( ( '%' ) )
            // InternalAssembler.g:3037:3: ( '%' )
            {
             before(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0()); 
            // InternalAssembler.g:3038:3: ( '%' )
            // InternalAssembler.g:3039:4: '%'
            {
             before(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0()); 

            }

             after(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0()); 

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
    // InternalAssembler.g:3050:1: rule__Modulo__RightAssignment_1_2 : ( ruleAddition ) ;
    public final void rule__Modulo__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3054:1: ( ( ruleAddition ) )
            // InternalAssembler.g:3055:2: ( ruleAddition )
            {
            // InternalAssembler.g:3055:2: ( ruleAddition )
            // InternalAssembler.g:3056:3: ruleAddition
            {
             before(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3065:1: rule__Addition__RightAssignment_1_2 : ( ruleSubstraction ) ;
    public final void rule__Addition__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3069:1: ( ( ruleSubstraction ) )
            // InternalAssembler.g:3070:2: ( ruleSubstraction )
            {
            // InternalAssembler.g:3070:2: ( ruleSubstraction )
            // InternalAssembler.g:3071:3: ruleSubstraction
            {
             before(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSubstraction();

            state._fsp--;

             after(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3080:1: rule__Substraction__RightAssignment_1_2 : ( ruleLeftShift ) ;
    public final void rule__Substraction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3084:1: ( ( ruleLeftShift ) )
            // InternalAssembler.g:3085:2: ( ruleLeftShift )
            {
            // InternalAssembler.g:3085:2: ( ruleLeftShift )
            // InternalAssembler.g:3086:3: ruleLeftShift
            {
             before(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLeftShift();

            state._fsp--;

             after(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3095:1: rule__LeftShift__RightAssignment_1_2 : ( ruleRigthShift ) ;
    public final void rule__LeftShift__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3099:1: ( ( ruleRigthShift ) )
            // InternalAssembler.g:3100:2: ( ruleRigthShift )
            {
            // InternalAssembler.g:3100:2: ( ruleRigthShift )
            // InternalAssembler.g:3101:3: ruleRigthShift
            {
             before(grammarAccess.getLeftShiftAccess().getRightRigthShiftParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleRigthShift();

            state._fsp--;

             after(grammarAccess.getLeftShiftAccess().getRightRigthShiftParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3110:1: rule__RigthShift__NegateAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__RigthShift__NegateAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3114:1: ( ( rulePrimary ) )
            // InternalAssembler.g:3115:2: ( rulePrimary )
            {
            // InternalAssembler.g:3115:2: ( rulePrimary )
            // InternalAssembler.g:3116:3: rulePrimary
            {
             before(grammarAccess.getRigthShiftAccess().getNegatePrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getRigthShiftAccess().getNegatePrimaryParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3125:1: rule__Negate__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Negate__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3129:1: ( ( ruleAnd ) )
            // InternalAssembler.g:3130:2: ( ruleAnd )
            {
            // InternalAssembler.g:3130:2: ( ruleAnd )
            // InternalAssembler.g:3131:3: ruleAnd
            {
             before(grammarAccess.getNegateAccess().getRightAndParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getNegateAccess().getRightAndParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3140:1: rule__And__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3144:1: ( ( ruleOr ) )
            // InternalAssembler.g:3145:2: ( ruleOr )
            {
            // InternalAssembler.g:3145:2: ( ruleOr )
            // InternalAssembler.g:3146:3: ruleOr
            {
             before(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3155:1: rule__Or__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3159:1: ( ( ruleXor ) )
            // InternalAssembler.g:3160:2: ( ruleXor )
            {
            // InternalAssembler.g:3160:2: ( ruleXor )
            // InternalAssembler.g:3161:3: ruleXor
            {
             before(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3170:1: rule__Xor__RightAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3174:1: ( ( rulePrimary ) )
            // InternalAssembler.g:3175:2: ( rulePrimary )
            {
            // InternalAssembler.g:3175:2: ( rulePrimary )
            // InternalAssembler.g:3176:3: rulePrimary
            {
             before(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0()); 

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
    // InternalAssembler.g:3185:1: rule__Primary__ValueAssignment_0 : ( ruleDecimalValue ) ;
    public final void rule__Primary__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3189:1: ( ( ruleDecimalValue ) )
            // InternalAssembler.g:3190:2: ( ruleDecimalValue )
            {
            // InternalAssembler.g:3190:2: ( ruleDecimalValue )
            // InternalAssembler.g:3191:3: ruleDecimalValue
            {
             before(grammarAccess.getPrimaryAccess().getValueDecimalValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDecimalValue();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getValueDecimalValueParserRuleCall_0_0()); 

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
    // InternalAssembler.g:3200:1: rule__Primary__ValueAssignment_1 : ( ruleHexaDecimalValue ) ;
    public final void rule__Primary__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3204:1: ( ( ruleHexaDecimalValue ) )
            // InternalAssembler.g:3205:2: ( ruleHexaDecimalValue )
            {
            // InternalAssembler.g:3205:2: ( ruleHexaDecimalValue )
            // InternalAssembler.g:3206:3: ruleHexaDecimalValue
            {
             before(grammarAccess.getPrimaryAccess().getValueHexaDecimalValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHexaDecimalValue();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getValueHexaDecimalValueParserRuleCall_1_0()); 

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
    // InternalAssembler.g:3215:1: rule__Primary__ValueAssignment_2 : ( ruleOctalValue ) ;
    public final void rule__Primary__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3219:1: ( ( ruleOctalValue ) )
            // InternalAssembler.g:3220:2: ( ruleOctalValue )
            {
            // InternalAssembler.g:3220:2: ( ruleOctalValue )
            // InternalAssembler.g:3221:3: ruleOctalValue
            {
             before(grammarAccess.getPrimaryAccess().getValueOctalValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOctalValue();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getValueOctalValueParserRuleCall_2_0()); 

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
    // InternalAssembler.g:3230:1: rule__Primary__ValueAssignment_3 : ( ruleBinaryValue ) ;
    public final void rule__Primary__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3234:1: ( ( ruleBinaryValue ) )
            // InternalAssembler.g:3235:2: ( ruleBinaryValue )
            {
            // InternalAssembler.g:3235:2: ( ruleBinaryValue )
            // InternalAssembler.g:3236:3: ruleBinaryValue
            {
             before(grammarAccess.getPrimaryAccess().getValueBinaryValueParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryValue();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getValueBinaryValueParserRuleCall_3_0()); 

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
    // InternalAssembler.g:3245:1: rule__Primary__ValueAssignment_4 : ( ruleCharacterValue ) ;
    public final void rule__Primary__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3249:1: ( ( ruleCharacterValue ) )
            // InternalAssembler.g:3250:2: ( ruleCharacterValue )
            {
            // InternalAssembler.g:3250:2: ( ruleCharacterValue )
            // InternalAssembler.g:3251:3: ruleCharacterValue
            {
             before(grammarAccess.getPrimaryAccess().getValueCharacterValueParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleCharacterValue();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getValueCharacterValueParserRuleCall_4_0()); 

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
    // InternalAssembler.g:3260:1: rule__Primary__ValueAssignment_5 : ( ruleIdentifier ) ;
    public final void rule__Primary__ValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3264:1: ( ( ruleIdentifier ) )
            // InternalAssembler.g:3265:2: ( ruleIdentifier )
            {
            // InternalAssembler.g:3265:2: ( ruleIdentifier )
            // InternalAssembler.g:3266:3: ruleIdentifier
            {
             before(grammarAccess.getPrimaryAccess().getValueIdentifierParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getValueIdentifierParserRuleCall_5_0()); 

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


    // $ANTLR start "rule__Identifier__ValueAssignment"
    // InternalAssembler.g:3275:1: rule__Identifier__ValueAssignment : ( RULE_ID ) ;
    public final void rule__Identifier__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3279:1: ( ( RULE_ID ) )
            // InternalAssembler.g:3280:2: ( RULE_ID )
            {
            // InternalAssembler.g:3280:2: ( RULE_ID )
            // InternalAssembler.g:3281:3: RULE_ID
            {
             before(grammarAccess.getIdentifierAccess().getValueIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getIdentifierAccess().getValueIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__Identifier__ValueAssignment"


    // $ANTLR start "rule__StringValue__ValueAssignment"
    // InternalAssembler.g:3290:1: rule__StringValue__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3294:1: ( ( RULE_STRING ) )
            // InternalAssembler.g:3295:2: ( RULE_STRING )
            {
            // InternalAssembler.g:3295:2: ( RULE_STRING )
            // InternalAssembler.g:3296:3: RULE_STRING
            {
             before(grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0()); 

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


    // $ANTLR start "rule__DecimalValue__ValueAssignment"
    // InternalAssembler.g:3305:1: rule__DecimalValue__ValueAssignment : ( RULE_INT ) ;
    public final void rule__DecimalValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3309:1: ( ( RULE_INT ) )
            // InternalAssembler.g:3310:2: ( RULE_INT )
            {
            // InternalAssembler.g:3310:2: ( RULE_INT )
            // InternalAssembler.g:3311:3: RULE_INT
            {
             before(grammarAccess.getDecimalValueAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDecimalValueAccess().getValueINTTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__DecimalValue__ValueAssignment"


    // $ANTLR start "rule__HexaDecimalValue__ValueAssignment"
    // InternalAssembler.g:3320:1: rule__HexaDecimalValue__ValueAssignment : ( RULE_HEXA ) ;
    public final void rule__HexaDecimalValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3324:1: ( ( RULE_HEXA ) )
            // InternalAssembler.g:3325:2: ( RULE_HEXA )
            {
            // InternalAssembler.g:3325:2: ( RULE_HEXA )
            // InternalAssembler.g:3326:3: RULE_HEXA
            {
             before(grammarAccess.getHexaDecimalValueAccess().getValueHEXATerminalRuleCall_0()); 
            match(input,RULE_HEXA,FOLLOW_2); 
             after(grammarAccess.getHexaDecimalValueAccess().getValueHEXATerminalRuleCall_0()); 

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
    // InternalAssembler.g:3335:1: rule__OctalValue__ValueAssignment : ( RULE_OCTAL ) ;
    public final void rule__OctalValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3339:1: ( ( RULE_OCTAL ) )
            // InternalAssembler.g:3340:2: ( RULE_OCTAL )
            {
            // InternalAssembler.g:3340:2: ( RULE_OCTAL )
            // InternalAssembler.g:3341:3: RULE_OCTAL
            {
             before(grammarAccess.getOctalValueAccess().getValueOCTALTerminalRuleCall_0()); 
            match(input,RULE_OCTAL,FOLLOW_2); 
             after(grammarAccess.getOctalValueAccess().getValueOCTALTerminalRuleCall_0()); 

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
    // InternalAssembler.g:3350:1: rule__BinaryValue__ValueAssignment : ( RULE_BINARY ) ;
    public final void rule__BinaryValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3354:1: ( ( RULE_BINARY ) )
            // InternalAssembler.g:3355:2: ( RULE_BINARY )
            {
            // InternalAssembler.g:3355:2: ( RULE_BINARY )
            // InternalAssembler.g:3356:3: RULE_BINARY
            {
             before(grammarAccess.getBinaryValueAccess().getValueBINARYTerminalRuleCall_0()); 
            match(input,RULE_BINARY,FOLLOW_2); 
             after(grammarAccess.getBinaryValueAccess().getValueBINARYTerminalRuleCall_0()); 

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
    // InternalAssembler.g:3365:1: rule__CharacterValue__ValueAssignment : ( RULE_CHARACTER ) ;
    public final void rule__CharacterValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:3369:1: ( ( RULE_CHARACTER ) )
            // InternalAssembler.g:3370:2: ( RULE_CHARACTER )
            {
            // InternalAssembler.g:3370:2: ( RULE_CHARACTER )
            // InternalAssembler.g:3371:3: RULE_CHARACTER
            {
             before(grammarAccess.getCharacterValueAccess().getValueCHARACTERTerminalRuleCall_0()); 
            match(input,RULE_CHARACTER,FOLLOW_2); 
             after(grammarAccess.getCharacterValueAccess().getValueCHARACTERTerminalRuleCall_0()); 

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
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000807FF0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000807D00L});
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

}
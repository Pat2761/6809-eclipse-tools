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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_COMMENT", "RULE_CR", "RULE_WS", "RULE_LABEL", "RULE_BINARY", "RULE_OCTAL", "RULE_DECIMAL", "RULE_HEXADECIMAL", "RULE_ASCII", "'EQU'", "'+'", "'*'", "'/'", "'-'", "'('", "')'"
    };
    public static final int RULE_LABEL=7;
    public static final int RULE_CR=5;
    public static final int RULE_SL_COMMENT=4;
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
    public static final int RULE_WS=6;
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

                if ( ((LA1_0>=RULE_SL_COMMENT && LA1_0<=RULE_LABEL)) ) {
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


    // $ANTLR start "entryRuleAssemblyLine"
    // InternalAssembler.g:103:1: entryRuleAssemblyLine : ruleAssemblyLine EOF ;
    public final void entryRuleAssemblyLine() throws RecognitionException {
        try {
            // InternalAssembler.g:104:1: ( ruleAssemblyLine EOF )
            // InternalAssembler.g:105:1: ruleAssemblyLine EOF
            {
             before(grammarAccess.getAssemblyLineRule()); 
            pushFollow(FOLLOW_1);
            ruleAssemblyLine();

            state._fsp--;

             after(grammarAccess.getAssemblyLineRule()); 
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
    // $ANTLR end "entryRuleAssemblyLine"


    // $ANTLR start "ruleAssemblyLine"
    // InternalAssembler.g:112:1: ruleAssemblyLine : ( ( rule__AssemblyLine__Group__0 ) ) ;
    public final void ruleAssemblyLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:116:2: ( ( ( rule__AssemblyLine__Group__0 ) ) )
            // InternalAssembler.g:117:2: ( ( rule__AssemblyLine__Group__0 ) )
            {
            // InternalAssembler.g:117:2: ( ( rule__AssemblyLine__Group__0 ) )
            // InternalAssembler.g:118:3: ( rule__AssemblyLine__Group__0 )
            {
             before(grammarAccess.getAssemblyLineAccess().getGroup()); 
            // InternalAssembler.g:119:3: ( rule__AssemblyLine__Group__0 )
            // InternalAssembler.g:119:4: rule__AssemblyLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AssemblyLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssemblyLineAccess().getGroup()); 

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
    // $ANTLR end "ruleAssemblyLine"


    // $ANTLR start "entryRuleDirective"
    // InternalAssembler.g:128:1: entryRuleDirective : ruleDirective EOF ;
    public final void entryRuleDirective() throws RecognitionException {
        try {
            // InternalAssembler.g:129:1: ( ruleDirective EOF )
            // InternalAssembler.g:130:1: ruleDirective EOF
            {
             before(grammarAccess.getDirectiveRule()); 
            pushFollow(FOLLOW_1);
            ruleDirective();

            state._fsp--;

             after(grammarAccess.getDirectiveRule()); 
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
    // $ANTLR end "entryRuleDirective"


    // $ANTLR start "ruleDirective"
    // InternalAssembler.g:137:1: ruleDirective : ( ( rule__Directive__DirectiveAssignment ) ) ;
    public final void ruleDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:141:2: ( ( ( rule__Directive__DirectiveAssignment ) ) )
            // InternalAssembler.g:142:2: ( ( rule__Directive__DirectiveAssignment ) )
            {
            // InternalAssembler.g:142:2: ( ( rule__Directive__DirectiveAssignment ) )
            // InternalAssembler.g:143:3: ( rule__Directive__DirectiveAssignment )
            {
             before(grammarAccess.getDirectiveAccess().getDirectiveAssignment()); 
            // InternalAssembler.g:144:3: ( rule__Directive__DirectiveAssignment )
            // InternalAssembler.g:144:4: rule__Directive__DirectiveAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Directive__DirectiveAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDirectiveAccess().getDirectiveAssignment()); 

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
    // $ANTLR end "ruleDirective"


    // $ANTLR start "entryRuleEquDirective"
    // InternalAssembler.g:153:1: entryRuleEquDirective : ruleEquDirective EOF ;
    public final void entryRuleEquDirective() throws RecognitionException {
        try {
            // InternalAssembler.g:154:1: ( ruleEquDirective EOF )
            // InternalAssembler.g:155:1: ruleEquDirective EOF
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
    // InternalAssembler.g:162:1: ruleEquDirective : ( ( rule__EquDirective__Group__0 ) ) ;
    public final void ruleEquDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:166:2: ( ( ( rule__EquDirective__Group__0 ) ) )
            // InternalAssembler.g:167:2: ( ( rule__EquDirective__Group__0 ) )
            {
            // InternalAssembler.g:167:2: ( ( rule__EquDirective__Group__0 ) )
            // InternalAssembler.g:168:3: ( rule__EquDirective__Group__0 )
            {
             before(grammarAccess.getEquDirectiveAccess().getGroup()); 
            // InternalAssembler.g:169:3: ( rule__EquDirective__Group__0 )
            // InternalAssembler.g:169:4: rule__EquDirective__Group__0
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


    // $ANTLR start "entryRuleLabelField"
    // InternalAssembler.g:178:1: entryRuleLabelField : ruleLabelField EOF ;
    public final void entryRuleLabelField() throws RecognitionException {
        try {
            // InternalAssembler.g:179:1: ( ruleLabelField EOF )
            // InternalAssembler.g:180:1: ruleLabelField EOF
            {
             before(grammarAccess.getLabelFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleLabelField();

            state._fsp--;

             after(grammarAccess.getLabelFieldRule()); 
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
    // $ANTLR end "entryRuleLabelField"


    // $ANTLR start "ruleLabelField"
    // InternalAssembler.g:187:1: ruleLabelField : ( ( rule__LabelField__LabelAssignment ) ) ;
    public final void ruleLabelField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:191:2: ( ( ( rule__LabelField__LabelAssignment ) ) )
            // InternalAssembler.g:192:2: ( ( rule__LabelField__LabelAssignment ) )
            {
            // InternalAssembler.g:192:2: ( ( rule__LabelField__LabelAssignment ) )
            // InternalAssembler.g:193:3: ( rule__LabelField__LabelAssignment )
            {
             before(grammarAccess.getLabelFieldAccess().getLabelAssignment()); 
            // InternalAssembler.g:194:3: ( rule__LabelField__LabelAssignment )
            // InternalAssembler.g:194:4: rule__LabelField__LabelAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LabelField__LabelAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLabelFieldAccess().getLabelAssignment()); 

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
    // $ANTLR end "ruleLabelField"


    // $ANTLR start "entryRuleCommentLine"
    // InternalAssembler.g:203:1: entryRuleCommentLine : ruleCommentLine EOF ;
    public final void entryRuleCommentLine() throws RecognitionException {
        try {
            // InternalAssembler.g:204:1: ( ruleCommentLine EOF )
            // InternalAssembler.g:205:1: ruleCommentLine EOF
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
    // InternalAssembler.g:212:1: ruleCommentLine : ( ( rule__CommentLine__Group__0 ) ) ;
    public final void ruleCommentLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:216:2: ( ( ( rule__CommentLine__Group__0 ) ) )
            // InternalAssembler.g:217:2: ( ( rule__CommentLine__Group__0 ) )
            {
            // InternalAssembler.g:217:2: ( ( rule__CommentLine__Group__0 ) )
            // InternalAssembler.g:218:3: ( rule__CommentLine__Group__0 )
            {
             before(grammarAccess.getCommentLineAccess().getGroup()); 
            // InternalAssembler.g:219:3: ( rule__CommentLine__Group__0 )
            // InternalAssembler.g:219:4: rule__CommentLine__Group__0
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


    // $ANTLR start "entryRuleEmptyLine"
    // InternalAssembler.g:228:1: entryRuleEmptyLine : ruleEmptyLine EOF ;
    public final void entryRuleEmptyLine() throws RecognitionException {
        try {
            // InternalAssembler.g:229:1: ( ruleEmptyLine EOF )
            // InternalAssembler.g:230:1: ruleEmptyLine EOF
            {
             before(grammarAccess.getEmptyLineRule()); 
            pushFollow(FOLLOW_1);
            ruleEmptyLine();

            state._fsp--;

             after(grammarAccess.getEmptyLineRule()); 
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
    // $ANTLR end "entryRuleEmptyLine"


    // $ANTLR start "ruleEmptyLine"
    // InternalAssembler.g:237:1: ruleEmptyLine : ( ( rule__EmptyLine__Group__0 ) ) ;
    public final void ruleEmptyLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:241:2: ( ( ( rule__EmptyLine__Group__0 ) ) )
            // InternalAssembler.g:242:2: ( ( rule__EmptyLine__Group__0 ) )
            {
            // InternalAssembler.g:242:2: ( ( rule__EmptyLine__Group__0 ) )
            // InternalAssembler.g:243:3: ( rule__EmptyLine__Group__0 )
            {
             before(grammarAccess.getEmptyLineAccess().getGroup()); 
            // InternalAssembler.g:244:3: ( rule__EmptyLine__Group__0 )
            // InternalAssembler.g:244:4: rule__EmptyLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EmptyLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEmptyLineAccess().getGroup()); 

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
    // $ANTLR end "ruleEmptyLine"


    // $ANTLR start "entryRuleSpecifiedValue"
    // InternalAssembler.g:253:1: entryRuleSpecifiedValue : ruleSpecifiedValue EOF ;
    public final void entryRuleSpecifiedValue() throws RecognitionException {
        try {
            // InternalAssembler.g:254:1: ( ruleSpecifiedValue EOF )
            // InternalAssembler.g:255:1: ruleSpecifiedValue EOF
            {
             before(grammarAccess.getSpecifiedValueRule()); 
            pushFollow(FOLLOW_1);
            ruleSpecifiedValue();

            state._fsp--;

             after(grammarAccess.getSpecifiedValueRule()); 
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
    // $ANTLR end "entryRuleSpecifiedValue"


    // $ANTLR start "ruleSpecifiedValue"
    // InternalAssembler.g:262:1: ruleSpecifiedValue : ( ( rule__SpecifiedValue__Group__0 ) ) ;
    public final void ruleSpecifiedValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:266:2: ( ( ( rule__SpecifiedValue__Group__0 ) ) )
            // InternalAssembler.g:267:2: ( ( rule__SpecifiedValue__Group__0 ) )
            {
            // InternalAssembler.g:267:2: ( ( rule__SpecifiedValue__Group__0 ) )
            // InternalAssembler.g:268:3: ( rule__SpecifiedValue__Group__0 )
            {
             before(grammarAccess.getSpecifiedValueAccess().getGroup()); 
            // InternalAssembler.g:269:3: ( rule__SpecifiedValue__Group__0 )
            // InternalAssembler.g:269:4: rule__SpecifiedValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SpecifiedValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSpecifiedValueAccess().getGroup()); 

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
    // $ANTLR end "ruleSpecifiedValue"


    // $ANTLR start "entryRuleExpression"
    // InternalAssembler.g:278:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalAssembler.g:279:1: ( ruleExpression EOF )
            // InternalAssembler.g:280:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalAssembler.g:287:1: ruleExpression : ( ( rule__Expression__AdditionAssignment ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:291:2: ( ( ( rule__Expression__AdditionAssignment ) ) )
            // InternalAssembler.g:292:2: ( ( rule__Expression__AdditionAssignment ) )
            {
            // InternalAssembler.g:292:2: ( ( rule__Expression__AdditionAssignment ) )
            // InternalAssembler.g:293:3: ( rule__Expression__AdditionAssignment )
            {
             before(grammarAccess.getExpressionAccess().getAdditionAssignment()); 
            // InternalAssembler.g:294:3: ( rule__Expression__AdditionAssignment )
            // InternalAssembler.g:294:4: rule__Expression__AdditionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Expression__AdditionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAdditionAssignment()); 

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
    // $ANTLR end "ruleExpression"


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


    // $ANTLR start "entryRuleMultiplication"
    // InternalAssembler.g:328:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // InternalAssembler.g:329:1: ( ruleMultiplication EOF )
            // InternalAssembler.g:330:1: ruleMultiplication EOF
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
    // InternalAssembler.g:337:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:341:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // InternalAssembler.g:342:2: ( ( rule__Multiplication__Group__0 ) )
            {
            // InternalAssembler.g:342:2: ( ( rule__Multiplication__Group__0 ) )
            // InternalAssembler.g:343:3: ( rule__Multiplication__Group__0 )
            {
             before(grammarAccess.getMultiplicationAccess().getGroup()); 
            // InternalAssembler.g:344:3: ( rule__Multiplication__Group__0 )
            // InternalAssembler.g:344:4: rule__Multiplication__Group__0
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
    // InternalAssembler.g:353:1: entryRuleDivision : ruleDivision EOF ;
    public final void entryRuleDivision() throws RecognitionException {
        try {
            // InternalAssembler.g:354:1: ( ruleDivision EOF )
            // InternalAssembler.g:355:1: ruleDivision EOF
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
    // InternalAssembler.g:362:1: ruleDivision : ( ( rule__Division__Group__0 ) ) ;
    public final void ruleDivision() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:366:2: ( ( ( rule__Division__Group__0 ) ) )
            // InternalAssembler.g:367:2: ( ( rule__Division__Group__0 ) )
            {
            // InternalAssembler.g:367:2: ( ( rule__Division__Group__0 ) )
            // InternalAssembler.g:368:3: ( rule__Division__Group__0 )
            {
             before(grammarAccess.getDivisionAccess().getGroup()); 
            // InternalAssembler.g:369:3: ( rule__Division__Group__0 )
            // InternalAssembler.g:369:4: rule__Division__Group__0
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


    // $ANTLR start "entryRuleSoustraction"
    // InternalAssembler.g:378:1: entryRuleSoustraction : ruleSoustraction EOF ;
    public final void entryRuleSoustraction() throws RecognitionException {
        try {
            // InternalAssembler.g:379:1: ( ruleSoustraction EOF )
            // InternalAssembler.g:380:1: ruleSoustraction EOF
            {
             before(grammarAccess.getSoustractionRule()); 
            pushFollow(FOLLOW_1);
            ruleSoustraction();

            state._fsp--;

             after(grammarAccess.getSoustractionRule()); 
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
    // $ANTLR end "entryRuleSoustraction"


    // $ANTLR start "ruleSoustraction"
    // InternalAssembler.g:387:1: ruleSoustraction : ( ( rule__Soustraction__Group__0 ) ) ;
    public final void ruleSoustraction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:391:2: ( ( ( rule__Soustraction__Group__0 ) ) )
            // InternalAssembler.g:392:2: ( ( rule__Soustraction__Group__0 ) )
            {
            // InternalAssembler.g:392:2: ( ( rule__Soustraction__Group__0 ) )
            // InternalAssembler.g:393:3: ( rule__Soustraction__Group__0 )
            {
             before(grammarAccess.getSoustractionAccess().getGroup()); 
            // InternalAssembler.g:394:3: ( rule__Soustraction__Group__0 )
            // InternalAssembler.g:394:4: rule__Soustraction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Soustraction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSoustractionAccess().getGroup()); 

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
    // $ANTLR end "ruleSoustraction"


    // $ANTLR start "entryRulePrimary"
    // InternalAssembler.g:403:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalAssembler.g:404:1: ( rulePrimary EOF )
            // InternalAssembler.g:405:1: rulePrimary EOF
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
    // InternalAssembler.g:412:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:416:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalAssembler.g:417:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalAssembler.g:417:2: ( ( rule__Primary__Alternatives ) )
            // InternalAssembler.g:418:3: ( rule__Primary__Alternatives )
            {
             before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            // InternalAssembler.g:419:3: ( rule__Primary__Alternatives )
            // InternalAssembler.g:419:4: rule__Primary__Alternatives
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


    // $ANTLR start "entryRuleExpressionValue"
    // InternalAssembler.g:428:1: entryRuleExpressionValue : ruleExpressionValue EOF ;
    public final void entryRuleExpressionValue() throws RecognitionException {
        try {
            // InternalAssembler.g:429:1: ( ruleExpressionValue EOF )
            // InternalAssembler.g:430:1: ruleExpressionValue EOF
            {
             before(grammarAccess.getExpressionValueRule()); 
            pushFollow(FOLLOW_1);
            ruleExpressionValue();

            state._fsp--;

             after(grammarAccess.getExpressionValueRule()); 
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
    // $ANTLR end "entryRuleExpressionValue"


    // $ANTLR start "ruleExpressionValue"
    // InternalAssembler.g:437:1: ruleExpressionValue : ( ( rule__ExpressionValue__Alternatives ) ) ;
    public final void ruleExpressionValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:441:2: ( ( ( rule__ExpressionValue__Alternatives ) ) )
            // InternalAssembler.g:442:2: ( ( rule__ExpressionValue__Alternatives ) )
            {
            // InternalAssembler.g:442:2: ( ( rule__ExpressionValue__Alternatives ) )
            // InternalAssembler.g:443:3: ( rule__ExpressionValue__Alternatives )
            {
             before(grammarAccess.getExpressionValueAccess().getAlternatives()); 
            // InternalAssembler.g:444:3: ( rule__ExpressionValue__Alternatives )
            // InternalAssembler.g:444:4: rule__ExpressionValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionValueAccess().getAlternatives()); 

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
    // $ANTLR end "ruleExpressionValue"


    // $ANTLR start "entryRuleActualPosition"
    // InternalAssembler.g:453:1: entryRuleActualPosition : ruleActualPosition EOF ;
    public final void entryRuleActualPosition() throws RecognitionException {
        try {
            // InternalAssembler.g:454:1: ( ruleActualPosition EOF )
            // InternalAssembler.g:455:1: ruleActualPosition EOF
            {
             before(grammarAccess.getActualPositionRule()); 
            pushFollow(FOLLOW_1);
            ruleActualPosition();

            state._fsp--;

             after(grammarAccess.getActualPositionRule()); 
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
    // $ANTLR end "entryRuleActualPosition"


    // $ANTLR start "ruleActualPosition"
    // InternalAssembler.g:462:1: ruleActualPosition : ( ( rule__ActualPosition__ActualPositionAssignment ) ) ;
    public final void ruleActualPosition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:466:2: ( ( ( rule__ActualPosition__ActualPositionAssignment ) ) )
            // InternalAssembler.g:467:2: ( ( rule__ActualPosition__ActualPositionAssignment ) )
            {
            // InternalAssembler.g:467:2: ( ( rule__ActualPosition__ActualPositionAssignment ) )
            // InternalAssembler.g:468:3: ( rule__ActualPosition__ActualPositionAssignment )
            {
             before(grammarAccess.getActualPositionAccess().getActualPositionAssignment()); 
            // InternalAssembler.g:469:3: ( rule__ActualPosition__ActualPositionAssignment )
            // InternalAssembler.g:469:4: rule__ActualPosition__ActualPositionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ActualPosition__ActualPositionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getActualPositionAccess().getActualPositionAssignment()); 

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
    // $ANTLR end "ruleActualPosition"


    // $ANTLR start "entryRuleBinaryeValue"
    // InternalAssembler.g:478:1: entryRuleBinaryeValue : ruleBinaryeValue EOF ;
    public final void entryRuleBinaryeValue() throws RecognitionException {
        try {
            // InternalAssembler.g:479:1: ( ruleBinaryeValue EOF )
            // InternalAssembler.g:480:1: ruleBinaryeValue EOF
            {
             before(grammarAccess.getBinaryeValueRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryeValue();

            state._fsp--;

             after(grammarAccess.getBinaryeValueRule()); 
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
    // $ANTLR end "entryRuleBinaryeValue"


    // $ANTLR start "ruleBinaryeValue"
    // InternalAssembler.g:487:1: ruleBinaryeValue : ( ( rule__BinaryeValue__Group__0 ) ) ;
    public final void ruleBinaryeValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:491:2: ( ( ( rule__BinaryeValue__Group__0 ) ) )
            // InternalAssembler.g:492:2: ( ( rule__BinaryeValue__Group__0 ) )
            {
            // InternalAssembler.g:492:2: ( ( rule__BinaryeValue__Group__0 ) )
            // InternalAssembler.g:493:3: ( rule__BinaryeValue__Group__0 )
            {
             before(grammarAccess.getBinaryeValueAccess().getGroup()); 
            // InternalAssembler.g:494:3: ( rule__BinaryeValue__Group__0 )
            // InternalAssembler.g:494:4: rule__BinaryeValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BinaryeValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryeValueAccess().getGroup()); 

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
    // $ANTLR end "ruleBinaryeValue"


    // $ANTLR start "entryRuleOctalValue"
    // InternalAssembler.g:503:1: entryRuleOctalValue : ruleOctalValue EOF ;
    public final void entryRuleOctalValue() throws RecognitionException {
        try {
            // InternalAssembler.g:504:1: ( ruleOctalValue EOF )
            // InternalAssembler.g:505:1: ruleOctalValue EOF
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
    // InternalAssembler.g:512:1: ruleOctalValue : ( ( rule__OctalValue__Group__0 ) ) ;
    public final void ruleOctalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:516:2: ( ( ( rule__OctalValue__Group__0 ) ) )
            // InternalAssembler.g:517:2: ( ( rule__OctalValue__Group__0 ) )
            {
            // InternalAssembler.g:517:2: ( ( rule__OctalValue__Group__0 ) )
            // InternalAssembler.g:518:3: ( rule__OctalValue__Group__0 )
            {
             before(grammarAccess.getOctalValueAccess().getGroup()); 
            // InternalAssembler.g:519:3: ( rule__OctalValue__Group__0 )
            // InternalAssembler.g:519:4: rule__OctalValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OctalValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOctalValueAccess().getGroup()); 

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


    // $ANTLR start "entryRuleDecimelValue"
    // InternalAssembler.g:528:1: entryRuleDecimelValue : ruleDecimelValue EOF ;
    public final void entryRuleDecimelValue() throws RecognitionException {
        try {
            // InternalAssembler.g:529:1: ( ruleDecimelValue EOF )
            // InternalAssembler.g:530:1: ruleDecimelValue EOF
            {
             before(grammarAccess.getDecimelValueRule()); 
            pushFollow(FOLLOW_1);
            ruleDecimelValue();

            state._fsp--;

             after(grammarAccess.getDecimelValueRule()); 
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
    // $ANTLR end "entryRuleDecimelValue"


    // $ANTLR start "ruleDecimelValue"
    // InternalAssembler.g:537:1: ruleDecimelValue : ( ( rule__DecimelValue__Group__0 ) ) ;
    public final void ruleDecimelValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:541:2: ( ( ( rule__DecimelValue__Group__0 ) ) )
            // InternalAssembler.g:542:2: ( ( rule__DecimelValue__Group__0 ) )
            {
            // InternalAssembler.g:542:2: ( ( rule__DecimelValue__Group__0 ) )
            // InternalAssembler.g:543:3: ( rule__DecimelValue__Group__0 )
            {
             before(grammarAccess.getDecimelValueAccess().getGroup()); 
            // InternalAssembler.g:544:3: ( rule__DecimelValue__Group__0 )
            // InternalAssembler.g:544:4: rule__DecimelValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DecimelValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecimelValueAccess().getGroup()); 

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
    // $ANTLR end "ruleDecimelValue"


    // $ANTLR start "entryRuleHexadecimalValue"
    // InternalAssembler.g:553:1: entryRuleHexadecimalValue : ruleHexadecimalValue EOF ;
    public final void entryRuleHexadecimalValue() throws RecognitionException {
        try {
            // InternalAssembler.g:554:1: ( ruleHexadecimalValue EOF )
            // InternalAssembler.g:555:1: ruleHexadecimalValue EOF
            {
             before(grammarAccess.getHexadecimalValueRule()); 
            pushFollow(FOLLOW_1);
            ruleHexadecimalValue();

            state._fsp--;

             after(grammarAccess.getHexadecimalValueRule()); 
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
    // $ANTLR end "entryRuleHexadecimalValue"


    // $ANTLR start "ruleHexadecimalValue"
    // InternalAssembler.g:562:1: ruleHexadecimalValue : ( ( rule__HexadecimalValue__Group__0 ) ) ;
    public final void ruleHexadecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:566:2: ( ( ( rule__HexadecimalValue__Group__0 ) ) )
            // InternalAssembler.g:567:2: ( ( rule__HexadecimalValue__Group__0 ) )
            {
            // InternalAssembler.g:567:2: ( ( rule__HexadecimalValue__Group__0 ) )
            // InternalAssembler.g:568:3: ( rule__HexadecimalValue__Group__0 )
            {
             before(grammarAccess.getHexadecimalValueAccess().getGroup()); 
            // InternalAssembler.g:569:3: ( rule__HexadecimalValue__Group__0 )
            // InternalAssembler.g:569:4: rule__HexadecimalValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HexadecimalValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHexadecimalValueAccess().getGroup()); 

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
    // $ANTLR end "ruleHexadecimalValue"


    // $ANTLR start "entryRuleAsciiValue"
    // InternalAssembler.g:578:1: entryRuleAsciiValue : ruleAsciiValue EOF ;
    public final void entryRuleAsciiValue() throws RecognitionException {
        try {
            // InternalAssembler.g:579:1: ( ruleAsciiValue EOF )
            // InternalAssembler.g:580:1: ruleAsciiValue EOF
            {
             before(grammarAccess.getAsciiValueRule()); 
            pushFollow(FOLLOW_1);
            ruleAsciiValue();

            state._fsp--;

             after(grammarAccess.getAsciiValueRule()); 
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
    // $ANTLR end "entryRuleAsciiValue"


    // $ANTLR start "ruleAsciiValue"
    // InternalAssembler.g:587:1: ruleAsciiValue : ( ( rule__AsciiValue__AsciiValueAssignment ) ) ;
    public final void ruleAsciiValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:591:2: ( ( ( rule__AsciiValue__AsciiValueAssignment ) ) )
            // InternalAssembler.g:592:2: ( ( rule__AsciiValue__AsciiValueAssignment ) )
            {
            // InternalAssembler.g:592:2: ( ( rule__AsciiValue__AsciiValueAssignment ) )
            // InternalAssembler.g:593:3: ( rule__AsciiValue__AsciiValueAssignment )
            {
             before(grammarAccess.getAsciiValueAccess().getAsciiValueAssignment()); 
            // InternalAssembler.g:594:3: ( rule__AsciiValue__AsciiValueAssignment )
            // InternalAssembler.g:594:4: rule__AsciiValue__AsciiValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__AsciiValue__AsciiValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getAsciiValueAccess().getAsciiValueAssignment()); 

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
    // $ANTLR end "ruleAsciiValue"


    // $ANTLR start "entryRuleLabelValue"
    // InternalAssembler.g:603:1: entryRuleLabelValue : ruleLabelValue EOF ;
    public final void entryRuleLabelValue() throws RecognitionException {
        try {
            // InternalAssembler.g:604:1: ( ruleLabelValue EOF )
            // InternalAssembler.g:605:1: ruleLabelValue EOF
            {
             before(grammarAccess.getLabelValueRule()); 
            pushFollow(FOLLOW_1);
            ruleLabelValue();

            state._fsp--;

             after(grammarAccess.getLabelValueRule()); 
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
    // $ANTLR end "entryRuleLabelValue"


    // $ANTLR start "ruleLabelValue"
    // InternalAssembler.g:612:1: ruleLabelValue : ( ( rule__LabelValue__LabelAssignment ) ) ;
    public final void ruleLabelValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:616:2: ( ( ( rule__LabelValue__LabelAssignment ) ) )
            // InternalAssembler.g:617:2: ( ( rule__LabelValue__LabelAssignment ) )
            {
            // InternalAssembler.g:617:2: ( ( rule__LabelValue__LabelAssignment ) )
            // InternalAssembler.g:618:3: ( rule__LabelValue__LabelAssignment )
            {
             before(grammarAccess.getLabelValueAccess().getLabelAssignment()); 
            // InternalAssembler.g:619:3: ( rule__LabelValue__LabelAssignment )
            // InternalAssembler.g:619:4: rule__LabelValue__LabelAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LabelValue__LabelAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLabelValueAccess().getLabelAssignment()); 

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
    // $ANTLR end "ruleLabelValue"


    // $ANTLR start "rule__SourceLine__Alternatives"
    // InternalAssembler.g:627:1: rule__SourceLine__Alternatives : ( ( ( rule__SourceLine__AssemblyLineAssignment_0 ) ) | ( ( rule__SourceLine__EmptyLineAssignment_1 ) ) | ( ( rule__SourceLine__CommentLineAssignment_2 ) ) );
    public final void rule__SourceLine__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:631:1: ( ( ( rule__SourceLine__AssemblyLineAssignment_0 ) ) | ( ( rule__SourceLine__EmptyLineAssignment_1 ) ) | ( ( rule__SourceLine__CommentLineAssignment_2 ) ) )
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
                    // InternalAssembler.g:632:2: ( ( rule__SourceLine__AssemblyLineAssignment_0 ) )
                    {
                    // InternalAssembler.g:632:2: ( ( rule__SourceLine__AssemblyLineAssignment_0 ) )
                    // InternalAssembler.g:633:3: ( rule__SourceLine__AssemblyLineAssignment_0 )
                    {
                     before(grammarAccess.getSourceLineAccess().getAssemblyLineAssignment_0()); 
                    // InternalAssembler.g:634:3: ( rule__SourceLine__AssemblyLineAssignment_0 )
                    // InternalAssembler.g:634:4: rule__SourceLine__AssemblyLineAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__AssemblyLineAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSourceLineAccess().getAssemblyLineAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:638:2: ( ( rule__SourceLine__EmptyLineAssignment_1 ) )
                    {
                    // InternalAssembler.g:638:2: ( ( rule__SourceLine__EmptyLineAssignment_1 ) )
                    // InternalAssembler.g:639:3: ( rule__SourceLine__EmptyLineAssignment_1 )
                    {
                     before(grammarAccess.getSourceLineAccess().getEmptyLineAssignment_1()); 
                    // InternalAssembler.g:640:3: ( rule__SourceLine__EmptyLineAssignment_1 )
                    // InternalAssembler.g:640:4: rule__SourceLine__EmptyLineAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__EmptyLineAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSourceLineAccess().getEmptyLineAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:644:2: ( ( rule__SourceLine__CommentLineAssignment_2 ) )
                    {
                    // InternalAssembler.g:644:2: ( ( rule__SourceLine__CommentLineAssignment_2 ) )
                    // InternalAssembler.g:645:3: ( rule__SourceLine__CommentLineAssignment_2 )
                    {
                     before(grammarAccess.getSourceLineAccess().getCommentLineAssignment_2()); 
                    // InternalAssembler.g:646:3: ( rule__SourceLine__CommentLineAssignment_2 )
                    // InternalAssembler.g:646:4: rule__SourceLine__CommentLineAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__SourceLine__CommentLineAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getSourceLineAccess().getCommentLineAssignment_2()); 

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


    // $ANTLR start "rule__AssemblyLine__Alternatives_4"
    // InternalAssembler.g:654:1: rule__AssemblyLine__Alternatives_4 : ( ( RULE_SL_COMMENT ) | ( RULE_CR ) );
    public final void rule__AssemblyLine__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:658:1: ( ( RULE_SL_COMMENT ) | ( RULE_CR ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_SL_COMMENT) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_CR) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalAssembler.g:659:2: ( RULE_SL_COMMENT )
                    {
                    // InternalAssembler.g:659:2: ( RULE_SL_COMMENT )
                    // InternalAssembler.g:660:3: RULE_SL_COMMENT
                    {
                     before(grammarAccess.getAssemblyLineAccess().getSL_COMMENTTerminalRuleCall_4_0()); 
                    match(input,RULE_SL_COMMENT,FOLLOW_2); 
                     after(grammarAccess.getAssemblyLineAccess().getSL_COMMENTTerminalRuleCall_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:665:2: ( RULE_CR )
                    {
                    // InternalAssembler.g:665:2: ( RULE_CR )
                    // InternalAssembler.g:666:3: RULE_CR
                    {
                     before(grammarAccess.getAssemblyLineAccess().getCRTerminalRuleCall_4_1()); 
                    match(input,RULE_CR,FOLLOW_2); 
                     after(grammarAccess.getAssemblyLineAccess().getCRTerminalRuleCall_4_1()); 

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
    // $ANTLR end "rule__AssemblyLine__Alternatives_4"


    // $ANTLR start "rule__Primary__Alternatives"
    // InternalAssembler.g:675:1: rule__Primary__Alternatives : ( ( ( rule__Primary__ExpressionValueAssignment_0 ) ) | ( ( rule__Primary__Group_1__0 ) ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:679:1: ( ( ( rule__Primary__ExpressionValueAssignment_0 ) ) | ( ( rule__Primary__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_LABEL && LA4_0<=RULE_ASCII)||LA4_0==15||LA4_0==17) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalAssembler.g:680:2: ( ( rule__Primary__ExpressionValueAssignment_0 ) )
                    {
                    // InternalAssembler.g:680:2: ( ( rule__Primary__ExpressionValueAssignment_0 ) )
                    // InternalAssembler.g:681:3: ( rule__Primary__ExpressionValueAssignment_0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getExpressionValueAssignment_0()); 
                    // InternalAssembler.g:682:3: ( rule__Primary__ExpressionValueAssignment_0 )
                    // InternalAssembler.g:682:4: rule__Primary__ExpressionValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__ExpressionValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getExpressionValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:686:2: ( ( rule__Primary__Group_1__0 ) )
                    {
                    // InternalAssembler.g:686:2: ( ( rule__Primary__Group_1__0 ) )
                    // InternalAssembler.g:687:3: ( rule__Primary__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_1()); 
                    // InternalAssembler.g:688:3: ( rule__Primary__Group_1__0 )
                    // InternalAssembler.g:688:4: rule__Primary__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getGroup_1()); 

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


    // $ANTLR start "rule__ExpressionValue__Alternatives"
    // InternalAssembler.g:696:1: rule__ExpressionValue__Alternatives : ( ( ( rule__ExpressionValue__ExpressionValueAssignment_0 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_1 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_2 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_3 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_4 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_5 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_6 ) ) );
    public final void rule__ExpressionValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:700:1: ( ( ( rule__ExpressionValue__ExpressionValueAssignment_0 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_1 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_2 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_3 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_4 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_5 ) ) | ( ( rule__ExpressionValue__ExpressionValueAssignment_6 ) ) )
            int alt5=7;
            switch ( input.LA(1) ) {
            case 17:
                {
                switch ( input.LA(2) ) {
                case RULE_OCTAL:
                    {
                    alt5=2;
                    }
                    break;
                case RULE_DECIMAL:
                    {
                    alt5=3;
                    }
                    break;
                case RULE_HEXADECIMAL:
                    {
                    alt5=4;
                    }
                    break;
                case RULE_BINARY:
                    {
                    alt5=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_BINARY:
                {
                alt5=1;
                }
                break;
            case RULE_OCTAL:
                {
                alt5=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt5=3;
                }
                break;
            case RULE_HEXADECIMAL:
                {
                alt5=4;
                }
                break;
            case RULE_LABEL:
                {
                alt5=5;
                }
                break;
            case RULE_ASCII:
                {
                alt5=6;
                }
                break;
            case 15:
                {
                alt5=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:701:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_0 ) )
                    {
                    // InternalAssembler.g:701:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_0 ) )
                    // InternalAssembler.g:702:3: ( rule__ExpressionValue__ExpressionValueAssignment_0 )
                    {
                     before(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_0()); 
                    // InternalAssembler.g:703:3: ( rule__ExpressionValue__ExpressionValueAssignment_0 )
                    // InternalAssembler.g:703:4: rule__ExpressionValue__ExpressionValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionValue__ExpressionValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAssembler.g:707:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_1 ) )
                    {
                    // InternalAssembler.g:707:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_1 ) )
                    // InternalAssembler.g:708:3: ( rule__ExpressionValue__ExpressionValueAssignment_1 )
                    {
                     before(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_1()); 
                    // InternalAssembler.g:709:3: ( rule__ExpressionValue__ExpressionValueAssignment_1 )
                    // InternalAssembler.g:709:4: rule__ExpressionValue__ExpressionValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionValue__ExpressionValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAssembler.g:713:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_2 ) )
                    {
                    // InternalAssembler.g:713:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_2 ) )
                    // InternalAssembler.g:714:3: ( rule__ExpressionValue__ExpressionValueAssignment_2 )
                    {
                     before(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_2()); 
                    // InternalAssembler.g:715:3: ( rule__ExpressionValue__ExpressionValueAssignment_2 )
                    // InternalAssembler.g:715:4: rule__ExpressionValue__ExpressionValueAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionValue__ExpressionValueAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAssembler.g:719:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_3 ) )
                    {
                    // InternalAssembler.g:719:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_3 ) )
                    // InternalAssembler.g:720:3: ( rule__ExpressionValue__ExpressionValueAssignment_3 )
                    {
                     before(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_3()); 
                    // InternalAssembler.g:721:3: ( rule__ExpressionValue__ExpressionValueAssignment_3 )
                    // InternalAssembler.g:721:4: rule__ExpressionValue__ExpressionValueAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionValue__ExpressionValueAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAssembler.g:725:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_4 ) )
                    {
                    // InternalAssembler.g:725:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_4 ) )
                    // InternalAssembler.g:726:3: ( rule__ExpressionValue__ExpressionValueAssignment_4 )
                    {
                     before(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_4()); 
                    // InternalAssembler.g:727:3: ( rule__ExpressionValue__ExpressionValueAssignment_4 )
                    // InternalAssembler.g:727:4: rule__ExpressionValue__ExpressionValueAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionValue__ExpressionValueAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAssembler.g:731:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_5 ) )
                    {
                    // InternalAssembler.g:731:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_5 ) )
                    // InternalAssembler.g:732:3: ( rule__ExpressionValue__ExpressionValueAssignment_5 )
                    {
                     before(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_5()); 
                    // InternalAssembler.g:733:3: ( rule__ExpressionValue__ExpressionValueAssignment_5 )
                    // InternalAssembler.g:733:4: rule__ExpressionValue__ExpressionValueAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionValue__ExpressionValueAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalAssembler.g:737:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_6 ) )
                    {
                    // InternalAssembler.g:737:2: ( ( rule__ExpressionValue__ExpressionValueAssignment_6 ) )
                    // InternalAssembler.g:738:3: ( rule__ExpressionValue__ExpressionValueAssignment_6 )
                    {
                     before(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_6()); 
                    // InternalAssembler.g:739:3: ( rule__ExpressionValue__ExpressionValueAssignment_6 )
                    // InternalAssembler.g:739:4: rule__ExpressionValue__ExpressionValueAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionValue__ExpressionValueAssignment_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionValueAccess().getExpressionValueAssignment_6()); 

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
    // $ANTLR end "rule__ExpressionValue__Alternatives"


    // $ANTLR start "rule__AssemblyLine__Group__0"
    // InternalAssembler.g:747:1: rule__AssemblyLine__Group__0 : rule__AssemblyLine__Group__0__Impl rule__AssemblyLine__Group__1 ;
    public final void rule__AssemblyLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:751:1: ( rule__AssemblyLine__Group__0__Impl rule__AssemblyLine__Group__1 )
            // InternalAssembler.g:752:2: rule__AssemblyLine__Group__0__Impl rule__AssemblyLine__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__AssemblyLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AssemblyLine__Group__1();

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
    // $ANTLR end "rule__AssemblyLine__Group__0"


    // $ANTLR start "rule__AssemblyLine__Group__0__Impl"
    // InternalAssembler.g:759:1: rule__AssemblyLine__Group__0__Impl : ( ( rule__AssemblyLine__LabelFieldAssignment_0 )? ) ;
    public final void rule__AssemblyLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:763:1: ( ( ( rule__AssemblyLine__LabelFieldAssignment_0 )? ) )
            // InternalAssembler.g:764:1: ( ( rule__AssemblyLine__LabelFieldAssignment_0 )? )
            {
            // InternalAssembler.g:764:1: ( ( rule__AssemblyLine__LabelFieldAssignment_0 )? )
            // InternalAssembler.g:765:2: ( rule__AssemblyLine__LabelFieldAssignment_0 )?
            {
             before(grammarAccess.getAssemblyLineAccess().getLabelFieldAssignment_0()); 
            // InternalAssembler.g:766:2: ( rule__AssemblyLine__LabelFieldAssignment_0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_LABEL) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:766:3: rule__AssemblyLine__LabelFieldAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AssemblyLine__LabelFieldAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssemblyLineAccess().getLabelFieldAssignment_0()); 

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
    // $ANTLR end "rule__AssemblyLine__Group__0__Impl"


    // $ANTLR start "rule__AssemblyLine__Group__1"
    // InternalAssembler.g:774:1: rule__AssemblyLine__Group__1 : rule__AssemblyLine__Group__1__Impl rule__AssemblyLine__Group__2 ;
    public final void rule__AssemblyLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:778:1: ( rule__AssemblyLine__Group__1__Impl rule__AssemblyLine__Group__2 )
            // InternalAssembler.g:779:2: rule__AssemblyLine__Group__1__Impl rule__AssemblyLine__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__AssemblyLine__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AssemblyLine__Group__2();

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
    // $ANTLR end "rule__AssemblyLine__Group__1"


    // $ANTLR start "rule__AssemblyLine__Group__1__Impl"
    // InternalAssembler.g:786:1: rule__AssemblyLine__Group__1__Impl : ( RULE_WS ) ;
    public final void rule__AssemblyLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:790:1: ( ( RULE_WS ) )
            // InternalAssembler.g:791:1: ( RULE_WS )
            {
            // InternalAssembler.g:791:1: ( RULE_WS )
            // InternalAssembler.g:792:2: RULE_WS
            {
             before(grammarAccess.getAssemblyLineAccess().getWSTerminalRuleCall_1()); 
            match(input,RULE_WS,FOLLOW_2); 
             after(grammarAccess.getAssemblyLineAccess().getWSTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__AssemblyLine__Group__1__Impl"


    // $ANTLR start "rule__AssemblyLine__Group__2"
    // InternalAssembler.g:801:1: rule__AssemblyLine__Group__2 : rule__AssemblyLine__Group__2__Impl rule__AssemblyLine__Group__3 ;
    public final void rule__AssemblyLine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:805:1: ( rule__AssemblyLine__Group__2__Impl rule__AssemblyLine__Group__3 )
            // InternalAssembler.g:806:2: rule__AssemblyLine__Group__2__Impl rule__AssemblyLine__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__AssemblyLine__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AssemblyLine__Group__3();

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
    // $ANTLR end "rule__AssemblyLine__Group__2"


    // $ANTLR start "rule__AssemblyLine__Group__2__Impl"
    // InternalAssembler.g:813:1: rule__AssemblyLine__Group__2__Impl : ( ( rule__AssemblyLine__CommandAssignment_2 ) ) ;
    public final void rule__AssemblyLine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:817:1: ( ( ( rule__AssemblyLine__CommandAssignment_2 ) ) )
            // InternalAssembler.g:818:1: ( ( rule__AssemblyLine__CommandAssignment_2 ) )
            {
            // InternalAssembler.g:818:1: ( ( rule__AssemblyLine__CommandAssignment_2 ) )
            // InternalAssembler.g:819:2: ( rule__AssemblyLine__CommandAssignment_2 )
            {
             before(grammarAccess.getAssemblyLineAccess().getCommandAssignment_2()); 
            // InternalAssembler.g:820:2: ( rule__AssemblyLine__CommandAssignment_2 )
            // InternalAssembler.g:820:3: rule__AssemblyLine__CommandAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AssemblyLine__CommandAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssemblyLineAccess().getCommandAssignment_2()); 

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
    // $ANTLR end "rule__AssemblyLine__Group__2__Impl"


    // $ANTLR start "rule__AssemblyLine__Group__3"
    // InternalAssembler.g:828:1: rule__AssemblyLine__Group__3 : rule__AssemblyLine__Group__3__Impl rule__AssemblyLine__Group__4 ;
    public final void rule__AssemblyLine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:832:1: ( rule__AssemblyLine__Group__3__Impl rule__AssemblyLine__Group__4 )
            // InternalAssembler.g:833:2: rule__AssemblyLine__Group__3__Impl rule__AssemblyLine__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__AssemblyLine__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AssemblyLine__Group__4();

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
    // $ANTLR end "rule__AssemblyLine__Group__3"


    // $ANTLR start "rule__AssemblyLine__Group__3__Impl"
    // InternalAssembler.g:840:1: rule__AssemblyLine__Group__3__Impl : ( ( RULE_WS )? ) ;
    public final void rule__AssemblyLine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:844:1: ( ( ( RULE_WS )? ) )
            // InternalAssembler.g:845:1: ( ( RULE_WS )? )
            {
            // InternalAssembler.g:845:1: ( ( RULE_WS )? )
            // InternalAssembler.g:846:2: ( RULE_WS )?
            {
             before(grammarAccess.getAssemblyLineAccess().getWSTerminalRuleCall_3()); 
            // InternalAssembler.g:847:2: ( RULE_WS )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssembler.g:847:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getAssemblyLineAccess().getWSTerminalRuleCall_3()); 

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
    // $ANTLR end "rule__AssemblyLine__Group__3__Impl"


    // $ANTLR start "rule__AssemblyLine__Group__4"
    // InternalAssembler.g:855:1: rule__AssemblyLine__Group__4 : rule__AssemblyLine__Group__4__Impl ;
    public final void rule__AssemblyLine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:859:1: ( rule__AssemblyLine__Group__4__Impl )
            // InternalAssembler.g:860:2: rule__AssemblyLine__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AssemblyLine__Group__4__Impl();

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
    // $ANTLR end "rule__AssemblyLine__Group__4"


    // $ANTLR start "rule__AssemblyLine__Group__4__Impl"
    // InternalAssembler.g:866:1: rule__AssemblyLine__Group__4__Impl : ( ( rule__AssemblyLine__Alternatives_4 ) ) ;
    public final void rule__AssemblyLine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:870:1: ( ( ( rule__AssemblyLine__Alternatives_4 ) ) )
            // InternalAssembler.g:871:1: ( ( rule__AssemblyLine__Alternatives_4 ) )
            {
            // InternalAssembler.g:871:1: ( ( rule__AssemblyLine__Alternatives_4 ) )
            // InternalAssembler.g:872:2: ( rule__AssemblyLine__Alternatives_4 )
            {
             before(grammarAccess.getAssemblyLineAccess().getAlternatives_4()); 
            // InternalAssembler.g:873:2: ( rule__AssemblyLine__Alternatives_4 )
            // InternalAssembler.g:873:3: rule__AssemblyLine__Alternatives_4
            {
            pushFollow(FOLLOW_2);
            rule__AssemblyLine__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getAssemblyLineAccess().getAlternatives_4()); 

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
    // $ANTLR end "rule__AssemblyLine__Group__4__Impl"


    // $ANTLR start "rule__EquDirective__Group__0"
    // InternalAssembler.g:882:1: rule__EquDirective__Group__0 : rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1 ;
    public final void rule__EquDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:886:1: ( rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1 )
            // InternalAssembler.g:887:2: rule__EquDirective__Group__0__Impl rule__EquDirective__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalAssembler.g:894:1: rule__EquDirective__Group__0__Impl : ( 'EQU' ) ;
    public final void rule__EquDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:898:1: ( ( 'EQU' ) )
            // InternalAssembler.g:899:1: ( 'EQU' )
            {
            // InternalAssembler.g:899:1: ( 'EQU' )
            // InternalAssembler.g:900:2: 'EQU'
            {
             before(grammarAccess.getEquDirectiveAccess().getEQUKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getEquDirectiveAccess().getEQUKeyword_0()); 

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
    // InternalAssembler.g:909:1: rule__EquDirective__Group__1 : rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2 ;
    public final void rule__EquDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:913:1: ( rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2 )
            // InternalAssembler.g:914:2: rule__EquDirective__Group__1__Impl rule__EquDirective__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalAssembler.g:921:1: rule__EquDirective__Group__1__Impl : ( RULE_WS ) ;
    public final void rule__EquDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:925:1: ( ( RULE_WS ) )
            // InternalAssembler.g:926:1: ( RULE_WS )
            {
            // InternalAssembler.g:926:1: ( RULE_WS )
            // InternalAssembler.g:927:2: RULE_WS
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
    // InternalAssembler.g:936:1: rule__EquDirective__Group__2 : rule__EquDirective__Group__2__Impl ;
    public final void rule__EquDirective__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:940:1: ( rule__EquDirective__Group__2__Impl )
            // InternalAssembler.g:941:2: rule__EquDirective__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EquDirective__Group__2__Impl();

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
    // InternalAssembler.g:947:1: rule__EquDirective__Group__2__Impl : ( ( rule__EquDirective__ConstantAssignment_2 ) ) ;
    public final void rule__EquDirective__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:951:1: ( ( ( rule__EquDirective__ConstantAssignment_2 ) ) )
            // InternalAssembler.g:952:1: ( ( rule__EquDirective__ConstantAssignment_2 ) )
            {
            // InternalAssembler.g:952:1: ( ( rule__EquDirective__ConstantAssignment_2 ) )
            // InternalAssembler.g:953:2: ( rule__EquDirective__ConstantAssignment_2 )
            {
             before(grammarAccess.getEquDirectiveAccess().getConstantAssignment_2()); 
            // InternalAssembler.g:954:2: ( rule__EquDirective__ConstantAssignment_2 )
            // InternalAssembler.g:954:3: rule__EquDirective__ConstantAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EquDirective__ConstantAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEquDirectiveAccess().getConstantAssignment_2()); 

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


    // $ANTLR start "rule__CommentLine__Group__0"
    // InternalAssembler.g:963:1: rule__CommentLine__Group__0 : rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1 ;
    public final void rule__CommentLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:967:1: ( rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1 )
            // InternalAssembler.g:968:2: rule__CommentLine__Group__0__Impl rule__CommentLine__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalAssembler.g:975:1: rule__CommentLine__Group__0__Impl : ( ( RULE_WS )? ) ;
    public final void rule__CommentLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:979:1: ( ( ( RULE_WS )? ) )
            // InternalAssembler.g:980:1: ( ( RULE_WS )? )
            {
            // InternalAssembler.g:980:1: ( ( RULE_WS )? )
            // InternalAssembler.g:981:2: ( RULE_WS )?
            {
             before(grammarAccess.getCommentLineAccess().getWSTerminalRuleCall_0()); 
            // InternalAssembler.g:982:2: ( RULE_WS )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_WS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssembler.g:982:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getCommentLineAccess().getWSTerminalRuleCall_0()); 

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
    // InternalAssembler.g:990:1: rule__CommentLine__Group__1 : rule__CommentLine__Group__1__Impl ;
    public final void rule__CommentLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:994:1: ( rule__CommentLine__Group__1__Impl )
            // InternalAssembler.g:995:2: rule__CommentLine__Group__1__Impl
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
    // InternalAssembler.g:1001:1: rule__CommentLine__Group__1__Impl : ( ( rule__CommentLine__CommentAssignment_1 ) ) ;
    public final void rule__CommentLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1005:1: ( ( ( rule__CommentLine__CommentAssignment_1 ) ) )
            // InternalAssembler.g:1006:1: ( ( rule__CommentLine__CommentAssignment_1 ) )
            {
            // InternalAssembler.g:1006:1: ( ( rule__CommentLine__CommentAssignment_1 ) )
            // InternalAssembler.g:1007:2: ( rule__CommentLine__CommentAssignment_1 )
            {
             before(grammarAccess.getCommentLineAccess().getCommentAssignment_1()); 
            // InternalAssembler.g:1008:2: ( rule__CommentLine__CommentAssignment_1 )
            // InternalAssembler.g:1008:3: rule__CommentLine__CommentAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__CommentLine__CommentAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCommentLineAccess().getCommentAssignment_1()); 

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


    // $ANTLR start "rule__EmptyLine__Group__0"
    // InternalAssembler.g:1017:1: rule__EmptyLine__Group__0 : rule__EmptyLine__Group__0__Impl rule__EmptyLine__Group__1 ;
    public final void rule__EmptyLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1021:1: ( rule__EmptyLine__Group__0__Impl rule__EmptyLine__Group__1 )
            // InternalAssembler.g:1022:2: rule__EmptyLine__Group__0__Impl rule__EmptyLine__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__EmptyLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EmptyLine__Group__1();

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
    // $ANTLR end "rule__EmptyLine__Group__0"


    // $ANTLR start "rule__EmptyLine__Group__0__Impl"
    // InternalAssembler.g:1029:1: rule__EmptyLine__Group__0__Impl : ( ( RULE_WS )? ) ;
    public final void rule__EmptyLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1033:1: ( ( ( RULE_WS )? ) )
            // InternalAssembler.g:1034:1: ( ( RULE_WS )? )
            {
            // InternalAssembler.g:1034:1: ( ( RULE_WS )? )
            // InternalAssembler.g:1035:2: ( RULE_WS )?
            {
             before(grammarAccess.getEmptyLineAccess().getWSTerminalRuleCall_0()); 
            // InternalAssembler.g:1036:2: ( RULE_WS )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_WS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:1036:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEmptyLineAccess().getWSTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__EmptyLine__Group__0__Impl"


    // $ANTLR start "rule__EmptyLine__Group__1"
    // InternalAssembler.g:1044:1: rule__EmptyLine__Group__1 : rule__EmptyLine__Group__1__Impl ;
    public final void rule__EmptyLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1048:1: ( rule__EmptyLine__Group__1__Impl )
            // InternalAssembler.g:1049:2: rule__EmptyLine__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EmptyLine__Group__1__Impl();

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
    // $ANTLR end "rule__EmptyLine__Group__1"


    // $ANTLR start "rule__EmptyLine__Group__1__Impl"
    // InternalAssembler.g:1055:1: rule__EmptyLine__Group__1__Impl : ( RULE_CR ) ;
    public final void rule__EmptyLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1059:1: ( ( RULE_CR ) )
            // InternalAssembler.g:1060:1: ( RULE_CR )
            {
            // InternalAssembler.g:1060:1: ( RULE_CR )
            // InternalAssembler.g:1061:2: RULE_CR
            {
             before(grammarAccess.getEmptyLineAccess().getCRTerminalRuleCall_1()); 
            match(input,RULE_CR,FOLLOW_2); 
             after(grammarAccess.getEmptyLineAccess().getCRTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__EmptyLine__Group__1__Impl"


    // $ANTLR start "rule__SpecifiedValue__Group__0"
    // InternalAssembler.g:1071:1: rule__SpecifiedValue__Group__0 : rule__SpecifiedValue__Group__0__Impl rule__SpecifiedValue__Group__1 ;
    public final void rule__SpecifiedValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1075:1: ( rule__SpecifiedValue__Group__0__Impl rule__SpecifiedValue__Group__1 )
            // InternalAssembler.g:1076:2: rule__SpecifiedValue__Group__0__Impl rule__SpecifiedValue__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__SpecifiedValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpecifiedValue__Group__1();

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
    // $ANTLR end "rule__SpecifiedValue__Group__0"


    // $ANTLR start "rule__SpecifiedValue__Group__0__Impl"
    // InternalAssembler.g:1083:1: rule__SpecifiedValue__Group__0__Impl : ( () ) ;
    public final void rule__SpecifiedValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1087:1: ( ( () ) )
            // InternalAssembler.g:1088:1: ( () )
            {
            // InternalAssembler.g:1088:1: ( () )
            // InternalAssembler.g:1089:2: ()
            {
             before(grammarAccess.getSpecifiedValueAccess().getSpecifiedValueAction_0()); 
            // InternalAssembler.g:1090:2: ()
            // InternalAssembler.g:1090:3: 
            {
            }

             after(grammarAccess.getSpecifiedValueAccess().getSpecifiedValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecifiedValue__Group__0__Impl"


    // $ANTLR start "rule__SpecifiedValue__Group__1"
    // InternalAssembler.g:1098:1: rule__SpecifiedValue__Group__1 : rule__SpecifiedValue__Group__1__Impl ;
    public final void rule__SpecifiedValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1102:1: ( rule__SpecifiedValue__Group__1__Impl )
            // InternalAssembler.g:1103:2: rule__SpecifiedValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SpecifiedValue__Group__1__Impl();

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
    // $ANTLR end "rule__SpecifiedValue__Group__1"


    // $ANTLR start "rule__SpecifiedValue__Group__1__Impl"
    // InternalAssembler.g:1109:1: rule__SpecifiedValue__Group__1__Impl : ( ( rule__SpecifiedValue__ValueAssignment_1 )? ) ;
    public final void rule__SpecifiedValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1113:1: ( ( ( rule__SpecifiedValue__ValueAssignment_1 )? ) )
            // InternalAssembler.g:1114:1: ( ( rule__SpecifiedValue__ValueAssignment_1 )? )
            {
            // InternalAssembler.g:1114:1: ( ( rule__SpecifiedValue__ValueAssignment_1 )? )
            // InternalAssembler.g:1115:2: ( rule__SpecifiedValue__ValueAssignment_1 )?
            {
             before(grammarAccess.getSpecifiedValueAccess().getValueAssignment_1()); 
            // InternalAssembler.g:1116:2: ( rule__SpecifiedValue__ValueAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=RULE_LABEL && LA10_0<=RULE_ASCII)||LA10_0==15||(LA10_0>=17 && LA10_0<=18)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:1116:3: rule__SpecifiedValue__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SpecifiedValue__ValueAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSpecifiedValueAccess().getValueAssignment_1()); 

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
    // $ANTLR end "rule__SpecifiedValue__Group__1__Impl"


    // $ANTLR start "rule__Addition__Group__0"
    // InternalAssembler.g:1125:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1129:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // InternalAssembler.g:1130:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalAssembler.g:1137:1: rule__Addition__Group__0__Impl : ( ( rule__Addition__ValuesAssignment_0 ) ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1141:1: ( ( ( rule__Addition__ValuesAssignment_0 ) ) )
            // InternalAssembler.g:1142:1: ( ( rule__Addition__ValuesAssignment_0 ) )
            {
            // InternalAssembler.g:1142:1: ( ( rule__Addition__ValuesAssignment_0 ) )
            // InternalAssembler.g:1143:2: ( rule__Addition__ValuesAssignment_0 )
            {
             before(grammarAccess.getAdditionAccess().getValuesAssignment_0()); 
            // InternalAssembler.g:1144:2: ( rule__Addition__ValuesAssignment_0 )
            // InternalAssembler.g:1144:3: rule__Addition__ValuesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Addition__ValuesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAdditionAccess().getValuesAssignment_0()); 

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
    // InternalAssembler.g:1152:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1156:1: ( rule__Addition__Group__1__Impl )
            // InternalAssembler.g:1157:2: rule__Addition__Group__1__Impl
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
    // InternalAssembler.g:1163:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1167:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // InternalAssembler.g:1168:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // InternalAssembler.g:1168:1: ( ( rule__Addition__Group_1__0 )* )
            // InternalAssembler.g:1169:2: ( rule__Addition__Group_1__0 )*
            {
             before(grammarAccess.getAdditionAccess().getGroup_1()); 
            // InternalAssembler.g:1170:2: ( rule__Addition__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==14) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAssembler.g:1170:3: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalAssembler.g:1179:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1183:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // InternalAssembler.g:1184:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalAssembler.g:1191:1: rule__Addition__Group_1__0__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1195:1: ( ( '+' ) )
            // InternalAssembler.g:1196:1: ( '+' )
            {
            // InternalAssembler.g:1196:1: ( '+' )
            // InternalAssembler.g:1197:2: '+'
            {
             before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0()); 

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
    // $ANTLR end "rule__Addition__Group_1__0__Impl"


    // $ANTLR start "rule__Addition__Group_1__1"
    // InternalAssembler.g:1206:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1210:1: ( rule__Addition__Group_1__1__Impl )
            // InternalAssembler.g:1211:2: rule__Addition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__1__Impl();

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
    // InternalAssembler.g:1217:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__ValuesAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1221:1: ( ( ( rule__Addition__ValuesAssignment_1_1 ) ) )
            // InternalAssembler.g:1222:1: ( ( rule__Addition__ValuesAssignment_1_1 ) )
            {
            // InternalAssembler.g:1222:1: ( ( rule__Addition__ValuesAssignment_1_1 ) )
            // InternalAssembler.g:1223:2: ( rule__Addition__ValuesAssignment_1_1 )
            {
             before(grammarAccess.getAdditionAccess().getValuesAssignment_1_1()); 
            // InternalAssembler.g:1224:2: ( rule__Addition__ValuesAssignment_1_1 )
            // InternalAssembler.g:1224:3: rule__Addition__ValuesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Addition__ValuesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAdditionAccess().getValuesAssignment_1_1()); 

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


    // $ANTLR start "rule__Multiplication__Group__0"
    // InternalAssembler.g:1233:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1237:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // InternalAssembler.g:1238:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalAssembler.g:1245:1: rule__Multiplication__Group__0__Impl : ( ( rule__Multiplication__ValuesAssignment_0 ) ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1249:1: ( ( ( rule__Multiplication__ValuesAssignment_0 ) ) )
            // InternalAssembler.g:1250:1: ( ( rule__Multiplication__ValuesAssignment_0 ) )
            {
            // InternalAssembler.g:1250:1: ( ( rule__Multiplication__ValuesAssignment_0 ) )
            // InternalAssembler.g:1251:2: ( rule__Multiplication__ValuesAssignment_0 )
            {
             before(grammarAccess.getMultiplicationAccess().getValuesAssignment_0()); 
            // InternalAssembler.g:1252:2: ( rule__Multiplication__ValuesAssignment_0 )
            // InternalAssembler.g:1252:3: rule__Multiplication__ValuesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__ValuesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getValuesAssignment_0()); 

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
    // InternalAssembler.g:1260:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1264:1: ( rule__Multiplication__Group__1__Impl )
            // InternalAssembler.g:1265:2: rule__Multiplication__Group__1__Impl
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
    // InternalAssembler.g:1271:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1275:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // InternalAssembler.g:1276:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // InternalAssembler.g:1276:1: ( ( rule__Multiplication__Group_1__0 )* )
            // InternalAssembler.g:1277:2: ( rule__Multiplication__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            // InternalAssembler.g:1278:2: ( rule__Multiplication__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAssembler.g:1278:3: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // InternalAssembler.g:1287:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1291:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // InternalAssembler.g:1292:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalAssembler.g:1299:1: rule__Multiplication__Group_1__0__Impl : ( '*' ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1303:1: ( ( '*' ) )
            // InternalAssembler.g:1304:1: ( '*' )
            {
            // InternalAssembler.g:1304:1: ( '*' )
            // InternalAssembler.g:1305:2: '*'
            {
             before(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0()); 

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
    // $ANTLR end "rule__Multiplication__Group_1__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__1"
    // InternalAssembler.g:1314:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1318:1: ( rule__Multiplication__Group_1__1__Impl )
            // InternalAssembler.g:1319:2: rule__Multiplication__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__1__Impl();

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
    // InternalAssembler.g:1325:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__ValuesAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1329:1: ( ( ( rule__Multiplication__ValuesAssignment_1_1 ) ) )
            // InternalAssembler.g:1330:1: ( ( rule__Multiplication__ValuesAssignment_1_1 ) )
            {
            // InternalAssembler.g:1330:1: ( ( rule__Multiplication__ValuesAssignment_1_1 ) )
            // InternalAssembler.g:1331:2: ( rule__Multiplication__ValuesAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicationAccess().getValuesAssignment_1_1()); 
            // InternalAssembler.g:1332:2: ( rule__Multiplication__ValuesAssignment_1_1 )
            // InternalAssembler.g:1332:3: rule__Multiplication__ValuesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__ValuesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getValuesAssignment_1_1()); 

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


    // $ANTLR start "rule__Division__Group__0"
    // InternalAssembler.g:1341:1: rule__Division__Group__0 : rule__Division__Group__0__Impl rule__Division__Group__1 ;
    public final void rule__Division__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1345:1: ( rule__Division__Group__0__Impl rule__Division__Group__1 )
            // InternalAssembler.g:1346:2: rule__Division__Group__0__Impl rule__Division__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalAssembler.g:1353:1: rule__Division__Group__0__Impl : ( ( rule__Division__ValuesAssignment_0 ) ) ;
    public final void rule__Division__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1357:1: ( ( ( rule__Division__ValuesAssignment_0 ) ) )
            // InternalAssembler.g:1358:1: ( ( rule__Division__ValuesAssignment_0 ) )
            {
            // InternalAssembler.g:1358:1: ( ( rule__Division__ValuesAssignment_0 ) )
            // InternalAssembler.g:1359:2: ( rule__Division__ValuesAssignment_0 )
            {
             before(grammarAccess.getDivisionAccess().getValuesAssignment_0()); 
            // InternalAssembler.g:1360:2: ( rule__Division__ValuesAssignment_0 )
            // InternalAssembler.g:1360:3: rule__Division__ValuesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Division__ValuesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDivisionAccess().getValuesAssignment_0()); 

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
    // InternalAssembler.g:1368:1: rule__Division__Group__1 : rule__Division__Group__1__Impl ;
    public final void rule__Division__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1372:1: ( rule__Division__Group__1__Impl )
            // InternalAssembler.g:1373:2: rule__Division__Group__1__Impl
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
    // InternalAssembler.g:1379:1: rule__Division__Group__1__Impl : ( ( rule__Division__Group_1__0 )* ) ;
    public final void rule__Division__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1383:1: ( ( ( rule__Division__Group_1__0 )* ) )
            // InternalAssembler.g:1384:1: ( ( rule__Division__Group_1__0 )* )
            {
            // InternalAssembler.g:1384:1: ( ( rule__Division__Group_1__0 )* )
            // InternalAssembler.g:1385:2: ( rule__Division__Group_1__0 )*
            {
             before(grammarAccess.getDivisionAccess().getGroup_1()); 
            // InternalAssembler.g:1386:2: ( rule__Division__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==16) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAssembler.g:1386:3: rule__Division__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Division__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalAssembler.g:1395:1: rule__Division__Group_1__0 : rule__Division__Group_1__0__Impl rule__Division__Group_1__1 ;
    public final void rule__Division__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1399:1: ( rule__Division__Group_1__0__Impl rule__Division__Group_1__1 )
            // InternalAssembler.g:1400:2: rule__Division__Group_1__0__Impl rule__Division__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalAssembler.g:1407:1: rule__Division__Group_1__0__Impl : ( '/' ) ;
    public final void rule__Division__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1411:1: ( ( '/' ) )
            // InternalAssembler.g:1412:1: ( '/' )
            {
            // InternalAssembler.g:1412:1: ( '/' )
            // InternalAssembler.g:1413:2: '/'
            {
             before(grammarAccess.getDivisionAccess().getSolidusKeyword_1_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getDivisionAccess().getSolidusKeyword_1_0()); 

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
    // $ANTLR end "rule__Division__Group_1__0__Impl"


    // $ANTLR start "rule__Division__Group_1__1"
    // InternalAssembler.g:1422:1: rule__Division__Group_1__1 : rule__Division__Group_1__1__Impl ;
    public final void rule__Division__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1426:1: ( rule__Division__Group_1__1__Impl )
            // InternalAssembler.g:1427:2: rule__Division__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Division__Group_1__1__Impl();

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
    // InternalAssembler.g:1433:1: rule__Division__Group_1__1__Impl : ( ( rule__Division__ValuesAssignment_1_1 ) ) ;
    public final void rule__Division__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1437:1: ( ( ( rule__Division__ValuesAssignment_1_1 ) ) )
            // InternalAssembler.g:1438:1: ( ( rule__Division__ValuesAssignment_1_1 ) )
            {
            // InternalAssembler.g:1438:1: ( ( rule__Division__ValuesAssignment_1_1 ) )
            // InternalAssembler.g:1439:2: ( rule__Division__ValuesAssignment_1_1 )
            {
             before(grammarAccess.getDivisionAccess().getValuesAssignment_1_1()); 
            // InternalAssembler.g:1440:2: ( rule__Division__ValuesAssignment_1_1 )
            // InternalAssembler.g:1440:3: rule__Division__ValuesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Division__ValuesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDivisionAccess().getValuesAssignment_1_1()); 

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


    // $ANTLR start "rule__Soustraction__Group__0"
    // InternalAssembler.g:1449:1: rule__Soustraction__Group__0 : rule__Soustraction__Group__0__Impl rule__Soustraction__Group__1 ;
    public final void rule__Soustraction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1453:1: ( rule__Soustraction__Group__0__Impl rule__Soustraction__Group__1 )
            // InternalAssembler.g:1454:2: rule__Soustraction__Group__0__Impl rule__Soustraction__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Soustraction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Soustraction__Group__1();

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
    // $ANTLR end "rule__Soustraction__Group__0"


    // $ANTLR start "rule__Soustraction__Group__0__Impl"
    // InternalAssembler.g:1461:1: rule__Soustraction__Group__0__Impl : ( ( rule__Soustraction__ValuesAssignment_0 ) ) ;
    public final void rule__Soustraction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1465:1: ( ( ( rule__Soustraction__ValuesAssignment_0 ) ) )
            // InternalAssembler.g:1466:1: ( ( rule__Soustraction__ValuesAssignment_0 ) )
            {
            // InternalAssembler.g:1466:1: ( ( rule__Soustraction__ValuesAssignment_0 ) )
            // InternalAssembler.g:1467:2: ( rule__Soustraction__ValuesAssignment_0 )
            {
             before(grammarAccess.getSoustractionAccess().getValuesAssignment_0()); 
            // InternalAssembler.g:1468:2: ( rule__Soustraction__ValuesAssignment_0 )
            // InternalAssembler.g:1468:3: rule__Soustraction__ValuesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Soustraction__ValuesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSoustractionAccess().getValuesAssignment_0()); 

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
    // $ANTLR end "rule__Soustraction__Group__0__Impl"


    // $ANTLR start "rule__Soustraction__Group__1"
    // InternalAssembler.g:1476:1: rule__Soustraction__Group__1 : rule__Soustraction__Group__1__Impl ;
    public final void rule__Soustraction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1480:1: ( rule__Soustraction__Group__1__Impl )
            // InternalAssembler.g:1481:2: rule__Soustraction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Soustraction__Group__1__Impl();

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
    // $ANTLR end "rule__Soustraction__Group__1"


    // $ANTLR start "rule__Soustraction__Group__1__Impl"
    // InternalAssembler.g:1487:1: rule__Soustraction__Group__1__Impl : ( ( rule__Soustraction__Group_1__0 )* ) ;
    public final void rule__Soustraction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1491:1: ( ( ( rule__Soustraction__Group_1__0 )* ) )
            // InternalAssembler.g:1492:1: ( ( rule__Soustraction__Group_1__0 )* )
            {
            // InternalAssembler.g:1492:1: ( ( rule__Soustraction__Group_1__0 )* )
            // InternalAssembler.g:1493:2: ( rule__Soustraction__Group_1__0 )*
            {
             before(grammarAccess.getSoustractionAccess().getGroup_1()); 
            // InternalAssembler.g:1494:2: ( rule__Soustraction__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==17) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalAssembler.g:1494:3: rule__Soustraction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Soustraction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getSoustractionAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Soustraction__Group__1__Impl"


    // $ANTLR start "rule__Soustraction__Group_1__0"
    // InternalAssembler.g:1503:1: rule__Soustraction__Group_1__0 : rule__Soustraction__Group_1__0__Impl rule__Soustraction__Group_1__1 ;
    public final void rule__Soustraction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1507:1: ( rule__Soustraction__Group_1__0__Impl rule__Soustraction__Group_1__1 )
            // InternalAssembler.g:1508:2: rule__Soustraction__Group_1__0__Impl rule__Soustraction__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Soustraction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Soustraction__Group_1__1();

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
    // $ANTLR end "rule__Soustraction__Group_1__0"


    // $ANTLR start "rule__Soustraction__Group_1__0__Impl"
    // InternalAssembler.g:1515:1: rule__Soustraction__Group_1__0__Impl : ( '-' ) ;
    public final void rule__Soustraction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1519:1: ( ( '-' ) )
            // InternalAssembler.g:1520:1: ( '-' )
            {
            // InternalAssembler.g:1520:1: ( '-' )
            // InternalAssembler.g:1521:2: '-'
            {
             before(grammarAccess.getSoustractionAccess().getHyphenMinusKeyword_1_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getSoustractionAccess().getHyphenMinusKeyword_1_0()); 

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
    // $ANTLR end "rule__Soustraction__Group_1__0__Impl"


    // $ANTLR start "rule__Soustraction__Group_1__1"
    // InternalAssembler.g:1530:1: rule__Soustraction__Group_1__1 : rule__Soustraction__Group_1__1__Impl ;
    public final void rule__Soustraction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1534:1: ( rule__Soustraction__Group_1__1__Impl )
            // InternalAssembler.g:1535:2: rule__Soustraction__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Soustraction__Group_1__1__Impl();

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
    // $ANTLR end "rule__Soustraction__Group_1__1"


    // $ANTLR start "rule__Soustraction__Group_1__1__Impl"
    // InternalAssembler.g:1541:1: rule__Soustraction__Group_1__1__Impl : ( ( rule__Soustraction__ValuesAssignment_1_1 ) ) ;
    public final void rule__Soustraction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1545:1: ( ( ( rule__Soustraction__ValuesAssignment_1_1 ) ) )
            // InternalAssembler.g:1546:1: ( ( rule__Soustraction__ValuesAssignment_1_1 ) )
            {
            // InternalAssembler.g:1546:1: ( ( rule__Soustraction__ValuesAssignment_1_1 ) )
            // InternalAssembler.g:1547:2: ( rule__Soustraction__ValuesAssignment_1_1 )
            {
             before(grammarAccess.getSoustractionAccess().getValuesAssignment_1_1()); 
            // InternalAssembler.g:1548:2: ( rule__Soustraction__ValuesAssignment_1_1 )
            // InternalAssembler.g:1548:3: rule__Soustraction__ValuesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Soustraction__ValuesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSoustractionAccess().getValuesAssignment_1_1()); 

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
    // $ANTLR end "rule__Soustraction__Group_1__1__Impl"


    // $ANTLR start "rule__Primary__Group_1__0"
    // InternalAssembler.g:1557:1: rule__Primary__Group_1__0 : rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1 ;
    public final void rule__Primary__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1561:1: ( rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1 )
            // InternalAssembler.g:1562:2: rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Primary__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__1();

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
    // $ANTLR end "rule__Primary__Group_1__0"


    // $ANTLR start "rule__Primary__Group_1__0__Impl"
    // InternalAssembler.g:1569:1: rule__Primary__Group_1__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1573:1: ( ( '(' ) )
            // InternalAssembler.g:1574:1: ( '(' )
            {
            // InternalAssembler.g:1574:1: ( '(' )
            // InternalAssembler.g:1575:2: '('
            {
             before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_1_0()); 

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
    // $ANTLR end "rule__Primary__Group_1__0__Impl"


    // $ANTLR start "rule__Primary__Group_1__1"
    // InternalAssembler.g:1584:1: rule__Primary__Group_1__1 : rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2 ;
    public final void rule__Primary__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1588:1: ( rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2 )
            // InternalAssembler.g:1589:2: rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2
            {
            pushFollow(FOLLOW_19);
            rule__Primary__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__2();

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
    // $ANTLR end "rule__Primary__Group_1__1"


    // $ANTLR start "rule__Primary__Group_1__1__Impl"
    // InternalAssembler.g:1596:1: rule__Primary__Group_1__1__Impl : ( ( rule__Primary__ExpressionValueAssignment_1_1 ) ) ;
    public final void rule__Primary__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1600:1: ( ( ( rule__Primary__ExpressionValueAssignment_1_1 ) ) )
            // InternalAssembler.g:1601:1: ( ( rule__Primary__ExpressionValueAssignment_1_1 ) )
            {
            // InternalAssembler.g:1601:1: ( ( rule__Primary__ExpressionValueAssignment_1_1 ) )
            // InternalAssembler.g:1602:2: ( rule__Primary__ExpressionValueAssignment_1_1 )
            {
             before(grammarAccess.getPrimaryAccess().getExpressionValueAssignment_1_1()); 
            // InternalAssembler.g:1603:2: ( rule__Primary__ExpressionValueAssignment_1_1 )
            // InternalAssembler.g:1603:3: rule__Primary__ExpressionValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Primary__ExpressionValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getExpressionValueAssignment_1_1()); 

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
    // $ANTLR end "rule__Primary__Group_1__1__Impl"


    // $ANTLR start "rule__Primary__Group_1__2"
    // InternalAssembler.g:1611:1: rule__Primary__Group_1__2 : rule__Primary__Group_1__2__Impl ;
    public final void rule__Primary__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1615:1: ( rule__Primary__Group_1__2__Impl )
            // InternalAssembler.g:1616:2: rule__Primary__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__2__Impl();

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
    // $ANTLR end "rule__Primary__Group_1__2"


    // $ANTLR start "rule__Primary__Group_1__2__Impl"
    // InternalAssembler.g:1622:1: rule__Primary__Group_1__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1626:1: ( ( ')' ) )
            // InternalAssembler.g:1627:1: ( ')' )
            {
            // InternalAssembler.g:1627:1: ( ')' )
            // InternalAssembler.g:1628:2: ')'
            {
             before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_1_2()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_1_2()); 

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
    // $ANTLR end "rule__Primary__Group_1__2__Impl"


    // $ANTLR start "rule__BinaryeValue__Group__0"
    // InternalAssembler.g:1638:1: rule__BinaryeValue__Group__0 : rule__BinaryeValue__Group__0__Impl rule__BinaryeValue__Group__1 ;
    public final void rule__BinaryeValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1642:1: ( rule__BinaryeValue__Group__0__Impl rule__BinaryeValue__Group__1 )
            // InternalAssembler.g:1643:2: rule__BinaryeValue__Group__0__Impl rule__BinaryeValue__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__BinaryeValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryeValue__Group__1();

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
    // $ANTLR end "rule__BinaryeValue__Group__0"


    // $ANTLR start "rule__BinaryeValue__Group__0__Impl"
    // InternalAssembler.g:1650:1: rule__BinaryeValue__Group__0__Impl : ( ( rule__BinaryeValue__IsNegativeAssignment_0 )? ) ;
    public final void rule__BinaryeValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1654:1: ( ( ( rule__BinaryeValue__IsNegativeAssignment_0 )? ) )
            // InternalAssembler.g:1655:1: ( ( rule__BinaryeValue__IsNegativeAssignment_0 )? )
            {
            // InternalAssembler.g:1655:1: ( ( rule__BinaryeValue__IsNegativeAssignment_0 )? )
            // InternalAssembler.g:1656:2: ( rule__BinaryeValue__IsNegativeAssignment_0 )?
            {
             before(grammarAccess.getBinaryeValueAccess().getIsNegativeAssignment_0()); 
            // InternalAssembler.g:1657:2: ( rule__BinaryeValue__IsNegativeAssignment_0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAssembler.g:1657:3: rule__BinaryeValue__IsNegativeAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BinaryeValue__IsNegativeAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBinaryeValueAccess().getIsNegativeAssignment_0()); 

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
    // $ANTLR end "rule__BinaryeValue__Group__0__Impl"


    // $ANTLR start "rule__BinaryeValue__Group__1"
    // InternalAssembler.g:1665:1: rule__BinaryeValue__Group__1 : rule__BinaryeValue__Group__1__Impl ;
    public final void rule__BinaryeValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1669:1: ( rule__BinaryeValue__Group__1__Impl )
            // InternalAssembler.g:1670:2: rule__BinaryeValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryeValue__Group__1__Impl();

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
    // $ANTLR end "rule__BinaryeValue__Group__1"


    // $ANTLR start "rule__BinaryeValue__Group__1__Impl"
    // InternalAssembler.g:1676:1: rule__BinaryeValue__Group__1__Impl : ( ( rule__BinaryeValue__BinaryValueAssignment_1 ) ) ;
    public final void rule__BinaryeValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1680:1: ( ( ( rule__BinaryeValue__BinaryValueAssignment_1 ) ) )
            // InternalAssembler.g:1681:1: ( ( rule__BinaryeValue__BinaryValueAssignment_1 ) )
            {
            // InternalAssembler.g:1681:1: ( ( rule__BinaryeValue__BinaryValueAssignment_1 ) )
            // InternalAssembler.g:1682:2: ( rule__BinaryeValue__BinaryValueAssignment_1 )
            {
             before(grammarAccess.getBinaryeValueAccess().getBinaryValueAssignment_1()); 
            // InternalAssembler.g:1683:2: ( rule__BinaryeValue__BinaryValueAssignment_1 )
            // InternalAssembler.g:1683:3: rule__BinaryeValue__BinaryValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BinaryeValue__BinaryValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBinaryeValueAccess().getBinaryValueAssignment_1()); 

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
    // $ANTLR end "rule__BinaryeValue__Group__1__Impl"


    // $ANTLR start "rule__OctalValue__Group__0"
    // InternalAssembler.g:1692:1: rule__OctalValue__Group__0 : rule__OctalValue__Group__0__Impl rule__OctalValue__Group__1 ;
    public final void rule__OctalValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1696:1: ( rule__OctalValue__Group__0__Impl rule__OctalValue__Group__1 )
            // InternalAssembler.g:1697:2: rule__OctalValue__Group__0__Impl rule__OctalValue__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__OctalValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OctalValue__Group__1();

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
    // $ANTLR end "rule__OctalValue__Group__0"


    // $ANTLR start "rule__OctalValue__Group__0__Impl"
    // InternalAssembler.g:1704:1: rule__OctalValue__Group__0__Impl : ( ( rule__OctalValue__IsNegativeAssignment_0 )? ) ;
    public final void rule__OctalValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1708:1: ( ( ( rule__OctalValue__IsNegativeAssignment_0 )? ) )
            // InternalAssembler.g:1709:1: ( ( rule__OctalValue__IsNegativeAssignment_0 )? )
            {
            // InternalAssembler.g:1709:1: ( ( rule__OctalValue__IsNegativeAssignment_0 )? )
            // InternalAssembler.g:1710:2: ( rule__OctalValue__IsNegativeAssignment_0 )?
            {
             before(grammarAccess.getOctalValueAccess().getIsNegativeAssignment_0()); 
            // InternalAssembler.g:1711:2: ( rule__OctalValue__IsNegativeAssignment_0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAssembler.g:1711:3: rule__OctalValue__IsNegativeAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OctalValue__IsNegativeAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOctalValueAccess().getIsNegativeAssignment_0()); 

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
    // $ANTLR end "rule__OctalValue__Group__0__Impl"


    // $ANTLR start "rule__OctalValue__Group__1"
    // InternalAssembler.g:1719:1: rule__OctalValue__Group__1 : rule__OctalValue__Group__1__Impl ;
    public final void rule__OctalValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1723:1: ( rule__OctalValue__Group__1__Impl )
            // InternalAssembler.g:1724:2: rule__OctalValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OctalValue__Group__1__Impl();

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
    // $ANTLR end "rule__OctalValue__Group__1"


    // $ANTLR start "rule__OctalValue__Group__1__Impl"
    // InternalAssembler.g:1730:1: rule__OctalValue__Group__1__Impl : ( ( rule__OctalValue__OctalValueAssignment_1 ) ) ;
    public final void rule__OctalValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1734:1: ( ( ( rule__OctalValue__OctalValueAssignment_1 ) ) )
            // InternalAssembler.g:1735:1: ( ( rule__OctalValue__OctalValueAssignment_1 ) )
            {
            // InternalAssembler.g:1735:1: ( ( rule__OctalValue__OctalValueAssignment_1 ) )
            // InternalAssembler.g:1736:2: ( rule__OctalValue__OctalValueAssignment_1 )
            {
             before(grammarAccess.getOctalValueAccess().getOctalValueAssignment_1()); 
            // InternalAssembler.g:1737:2: ( rule__OctalValue__OctalValueAssignment_1 )
            // InternalAssembler.g:1737:3: rule__OctalValue__OctalValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__OctalValue__OctalValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOctalValueAccess().getOctalValueAssignment_1()); 

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
    // $ANTLR end "rule__OctalValue__Group__1__Impl"


    // $ANTLR start "rule__DecimelValue__Group__0"
    // InternalAssembler.g:1746:1: rule__DecimelValue__Group__0 : rule__DecimelValue__Group__0__Impl rule__DecimelValue__Group__1 ;
    public final void rule__DecimelValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1750:1: ( rule__DecimelValue__Group__0__Impl rule__DecimelValue__Group__1 )
            // InternalAssembler.g:1751:2: rule__DecimelValue__Group__0__Impl rule__DecimelValue__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__DecimelValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DecimelValue__Group__1();

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
    // $ANTLR end "rule__DecimelValue__Group__0"


    // $ANTLR start "rule__DecimelValue__Group__0__Impl"
    // InternalAssembler.g:1758:1: rule__DecimelValue__Group__0__Impl : ( ( rule__DecimelValue__IsNegativeAssignment_0 )? ) ;
    public final void rule__DecimelValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1762:1: ( ( ( rule__DecimelValue__IsNegativeAssignment_0 )? ) )
            // InternalAssembler.g:1763:1: ( ( rule__DecimelValue__IsNegativeAssignment_0 )? )
            {
            // InternalAssembler.g:1763:1: ( ( rule__DecimelValue__IsNegativeAssignment_0 )? )
            // InternalAssembler.g:1764:2: ( rule__DecimelValue__IsNegativeAssignment_0 )?
            {
             before(grammarAccess.getDecimelValueAccess().getIsNegativeAssignment_0()); 
            // InternalAssembler.g:1765:2: ( rule__DecimelValue__IsNegativeAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==17) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAssembler.g:1765:3: rule__DecimelValue__IsNegativeAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DecimelValue__IsNegativeAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDecimelValueAccess().getIsNegativeAssignment_0()); 

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
    // $ANTLR end "rule__DecimelValue__Group__0__Impl"


    // $ANTLR start "rule__DecimelValue__Group__1"
    // InternalAssembler.g:1773:1: rule__DecimelValue__Group__1 : rule__DecimelValue__Group__1__Impl ;
    public final void rule__DecimelValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1777:1: ( rule__DecimelValue__Group__1__Impl )
            // InternalAssembler.g:1778:2: rule__DecimelValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DecimelValue__Group__1__Impl();

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
    // $ANTLR end "rule__DecimelValue__Group__1"


    // $ANTLR start "rule__DecimelValue__Group__1__Impl"
    // InternalAssembler.g:1784:1: rule__DecimelValue__Group__1__Impl : ( ( rule__DecimelValue__DecimalValueAssignment_1 ) ) ;
    public final void rule__DecimelValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1788:1: ( ( ( rule__DecimelValue__DecimalValueAssignment_1 ) ) )
            // InternalAssembler.g:1789:1: ( ( rule__DecimelValue__DecimalValueAssignment_1 ) )
            {
            // InternalAssembler.g:1789:1: ( ( rule__DecimelValue__DecimalValueAssignment_1 ) )
            // InternalAssembler.g:1790:2: ( rule__DecimelValue__DecimalValueAssignment_1 )
            {
             before(grammarAccess.getDecimelValueAccess().getDecimalValueAssignment_1()); 
            // InternalAssembler.g:1791:2: ( rule__DecimelValue__DecimalValueAssignment_1 )
            // InternalAssembler.g:1791:3: rule__DecimelValue__DecimalValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DecimelValue__DecimalValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDecimelValueAccess().getDecimalValueAssignment_1()); 

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
    // $ANTLR end "rule__DecimelValue__Group__1__Impl"


    // $ANTLR start "rule__HexadecimalValue__Group__0"
    // InternalAssembler.g:1800:1: rule__HexadecimalValue__Group__0 : rule__HexadecimalValue__Group__0__Impl rule__HexadecimalValue__Group__1 ;
    public final void rule__HexadecimalValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1804:1: ( rule__HexadecimalValue__Group__0__Impl rule__HexadecimalValue__Group__1 )
            // InternalAssembler.g:1805:2: rule__HexadecimalValue__Group__0__Impl rule__HexadecimalValue__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__HexadecimalValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HexadecimalValue__Group__1();

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
    // $ANTLR end "rule__HexadecimalValue__Group__0"


    // $ANTLR start "rule__HexadecimalValue__Group__0__Impl"
    // InternalAssembler.g:1812:1: rule__HexadecimalValue__Group__0__Impl : ( ( rule__HexadecimalValue__IsNegativeAssignment_0 )? ) ;
    public final void rule__HexadecimalValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1816:1: ( ( ( rule__HexadecimalValue__IsNegativeAssignment_0 )? ) )
            // InternalAssembler.g:1817:1: ( ( rule__HexadecimalValue__IsNegativeAssignment_0 )? )
            {
            // InternalAssembler.g:1817:1: ( ( rule__HexadecimalValue__IsNegativeAssignment_0 )? )
            // InternalAssembler.g:1818:2: ( rule__HexadecimalValue__IsNegativeAssignment_0 )?
            {
             before(grammarAccess.getHexadecimalValueAccess().getIsNegativeAssignment_0()); 
            // InternalAssembler.g:1819:2: ( rule__HexadecimalValue__IsNegativeAssignment_0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAssembler.g:1819:3: rule__HexadecimalValue__IsNegativeAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HexadecimalValue__IsNegativeAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHexadecimalValueAccess().getIsNegativeAssignment_0()); 

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
    // $ANTLR end "rule__HexadecimalValue__Group__0__Impl"


    // $ANTLR start "rule__HexadecimalValue__Group__1"
    // InternalAssembler.g:1827:1: rule__HexadecimalValue__Group__1 : rule__HexadecimalValue__Group__1__Impl ;
    public final void rule__HexadecimalValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1831:1: ( rule__HexadecimalValue__Group__1__Impl )
            // InternalAssembler.g:1832:2: rule__HexadecimalValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HexadecimalValue__Group__1__Impl();

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
    // $ANTLR end "rule__HexadecimalValue__Group__1"


    // $ANTLR start "rule__HexadecimalValue__Group__1__Impl"
    // InternalAssembler.g:1838:1: rule__HexadecimalValue__Group__1__Impl : ( ( rule__HexadecimalValue__HexadeciamlValueAssignment_1 ) ) ;
    public final void rule__HexadecimalValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1842:1: ( ( ( rule__HexadecimalValue__HexadeciamlValueAssignment_1 ) ) )
            // InternalAssembler.g:1843:1: ( ( rule__HexadecimalValue__HexadeciamlValueAssignment_1 ) )
            {
            // InternalAssembler.g:1843:1: ( ( rule__HexadecimalValue__HexadeciamlValueAssignment_1 ) )
            // InternalAssembler.g:1844:2: ( rule__HexadecimalValue__HexadeciamlValueAssignment_1 )
            {
             before(grammarAccess.getHexadecimalValueAccess().getHexadeciamlValueAssignment_1()); 
            // InternalAssembler.g:1845:2: ( rule__HexadecimalValue__HexadeciamlValueAssignment_1 )
            // InternalAssembler.g:1845:3: rule__HexadecimalValue__HexadeciamlValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HexadecimalValue__HexadeciamlValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHexadecimalValueAccess().getHexadeciamlValueAssignment_1()); 

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
    // $ANTLR end "rule__HexadecimalValue__Group__1__Impl"


    // $ANTLR start "rule__Model__SourceLinesAssignment"
    // InternalAssembler.g:1854:1: rule__Model__SourceLinesAssignment : ( ruleSourceLine ) ;
    public final void rule__Model__SourceLinesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1858:1: ( ( ruleSourceLine ) )
            // InternalAssembler.g:1859:2: ( ruleSourceLine )
            {
            // InternalAssembler.g:1859:2: ( ruleSourceLine )
            // InternalAssembler.g:1860:3: ruleSourceLine
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


    // $ANTLR start "rule__SourceLine__AssemblyLineAssignment_0"
    // InternalAssembler.g:1869:1: rule__SourceLine__AssemblyLineAssignment_0 : ( ruleAssemblyLine ) ;
    public final void rule__SourceLine__AssemblyLineAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1873:1: ( ( ruleAssemblyLine ) )
            // InternalAssembler.g:1874:2: ( ruleAssemblyLine )
            {
            // InternalAssembler.g:1874:2: ( ruleAssemblyLine )
            // InternalAssembler.g:1875:3: ruleAssemblyLine
            {
             before(grammarAccess.getSourceLineAccess().getAssemblyLineAssemblyLineParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAssemblyLine();

            state._fsp--;

             after(grammarAccess.getSourceLineAccess().getAssemblyLineAssemblyLineParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__SourceLine__AssemblyLineAssignment_0"


    // $ANTLR start "rule__SourceLine__EmptyLineAssignment_1"
    // InternalAssembler.g:1884:1: rule__SourceLine__EmptyLineAssignment_1 : ( ruleEmptyLine ) ;
    public final void rule__SourceLine__EmptyLineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1888:1: ( ( ruleEmptyLine ) )
            // InternalAssembler.g:1889:2: ( ruleEmptyLine )
            {
            // InternalAssembler.g:1889:2: ( ruleEmptyLine )
            // InternalAssembler.g:1890:3: ruleEmptyLine
            {
             before(grammarAccess.getSourceLineAccess().getEmptyLineEmptyLineParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEmptyLine();

            state._fsp--;

             after(grammarAccess.getSourceLineAccess().getEmptyLineEmptyLineParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__SourceLine__EmptyLineAssignment_1"


    // $ANTLR start "rule__SourceLine__CommentLineAssignment_2"
    // InternalAssembler.g:1899:1: rule__SourceLine__CommentLineAssignment_2 : ( ruleCommentLine ) ;
    public final void rule__SourceLine__CommentLineAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1903:1: ( ( ruleCommentLine ) )
            // InternalAssembler.g:1904:2: ( ruleCommentLine )
            {
            // InternalAssembler.g:1904:2: ( ruleCommentLine )
            // InternalAssembler.g:1905:3: ruleCommentLine
            {
             before(grammarAccess.getSourceLineAccess().getCommentLineCommentLineParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCommentLine();

            state._fsp--;

             after(grammarAccess.getSourceLineAccess().getCommentLineCommentLineParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__SourceLine__CommentLineAssignment_2"


    // $ANTLR start "rule__AssemblyLine__LabelFieldAssignment_0"
    // InternalAssembler.g:1914:1: rule__AssemblyLine__LabelFieldAssignment_0 : ( ruleLabelField ) ;
    public final void rule__AssemblyLine__LabelFieldAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1918:1: ( ( ruleLabelField ) )
            // InternalAssembler.g:1919:2: ( ruleLabelField )
            {
            // InternalAssembler.g:1919:2: ( ruleLabelField )
            // InternalAssembler.g:1920:3: ruleLabelField
            {
             before(grammarAccess.getAssemblyLineAccess().getLabelFieldLabelFieldParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleLabelField();

            state._fsp--;

             after(grammarAccess.getAssemblyLineAccess().getLabelFieldLabelFieldParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__AssemblyLine__LabelFieldAssignment_0"


    // $ANTLR start "rule__AssemblyLine__CommandAssignment_2"
    // InternalAssembler.g:1929:1: rule__AssemblyLine__CommandAssignment_2 : ( ruleDirective ) ;
    public final void rule__AssemblyLine__CommandAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1933:1: ( ( ruleDirective ) )
            // InternalAssembler.g:1934:2: ( ruleDirective )
            {
            // InternalAssembler.g:1934:2: ( ruleDirective )
            // InternalAssembler.g:1935:3: ruleDirective
            {
             before(grammarAccess.getAssemblyLineAccess().getCommandDirectiveParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDirective();

            state._fsp--;

             after(grammarAccess.getAssemblyLineAccess().getCommandDirectiveParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__AssemblyLine__CommandAssignment_2"


    // $ANTLR start "rule__Directive__DirectiveAssignment"
    // InternalAssembler.g:1944:1: rule__Directive__DirectiveAssignment : ( ruleEquDirective ) ;
    public final void rule__Directive__DirectiveAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1948:1: ( ( ruleEquDirective ) )
            // InternalAssembler.g:1949:2: ( ruleEquDirective )
            {
            // InternalAssembler.g:1949:2: ( ruleEquDirective )
            // InternalAssembler.g:1950:3: ruleEquDirective
            {
             before(grammarAccess.getDirectiveAccess().getDirectiveEquDirectiveParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleEquDirective();

            state._fsp--;

             after(grammarAccess.getDirectiveAccess().getDirectiveEquDirectiveParserRuleCall_0()); 

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
    // $ANTLR end "rule__Directive__DirectiveAssignment"


    // $ANTLR start "rule__EquDirective__ConstantAssignment_2"
    // InternalAssembler.g:1959:1: rule__EquDirective__ConstantAssignment_2 : ( ruleSpecifiedValue ) ;
    public final void rule__EquDirective__ConstantAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1963:1: ( ( ruleSpecifiedValue ) )
            // InternalAssembler.g:1964:2: ( ruleSpecifiedValue )
            {
            // InternalAssembler.g:1964:2: ( ruleSpecifiedValue )
            // InternalAssembler.g:1965:3: ruleSpecifiedValue
            {
             before(grammarAccess.getEquDirectiveAccess().getConstantSpecifiedValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSpecifiedValue();

            state._fsp--;

             after(grammarAccess.getEquDirectiveAccess().getConstantSpecifiedValueParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__EquDirective__ConstantAssignment_2"


    // $ANTLR start "rule__LabelField__LabelAssignment"
    // InternalAssembler.g:1974:1: rule__LabelField__LabelAssignment : ( RULE_LABEL ) ;
    public final void rule__LabelField__LabelAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1978:1: ( ( RULE_LABEL ) )
            // InternalAssembler.g:1979:2: ( RULE_LABEL )
            {
            // InternalAssembler.g:1979:2: ( RULE_LABEL )
            // InternalAssembler.g:1980:3: RULE_LABEL
            {
             before(grammarAccess.getLabelFieldAccess().getLabelLABELTerminalRuleCall_0()); 
            match(input,RULE_LABEL,FOLLOW_2); 
             after(grammarAccess.getLabelFieldAccess().getLabelLABELTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__LabelField__LabelAssignment"


    // $ANTLR start "rule__CommentLine__CommentAssignment_1"
    // InternalAssembler.g:1989:1: rule__CommentLine__CommentAssignment_1 : ( RULE_SL_COMMENT ) ;
    public final void rule__CommentLine__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:1993:1: ( ( RULE_SL_COMMENT ) )
            // InternalAssembler.g:1994:2: ( RULE_SL_COMMENT )
            {
            // InternalAssembler.g:1994:2: ( RULE_SL_COMMENT )
            // InternalAssembler.g:1995:3: RULE_SL_COMMENT
            {
             before(grammarAccess.getCommentLineAccess().getCommentSL_COMMENTTerminalRuleCall_1_0()); 
            match(input,RULE_SL_COMMENT,FOLLOW_2); 
             after(grammarAccess.getCommentLineAccess().getCommentSL_COMMENTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__CommentLine__CommentAssignment_1"


    // $ANTLR start "rule__SpecifiedValue__ValueAssignment_1"
    // InternalAssembler.g:2004:1: rule__SpecifiedValue__ValueAssignment_1 : ( ruleExpression ) ;
    public final void rule__SpecifiedValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2008:1: ( ( ruleExpression ) )
            // InternalAssembler.g:2009:2: ( ruleExpression )
            {
            // InternalAssembler.g:2009:2: ( ruleExpression )
            // InternalAssembler.g:2010:3: ruleExpression
            {
             before(grammarAccess.getSpecifiedValueAccess().getValueExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getSpecifiedValueAccess().getValueExpressionParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__SpecifiedValue__ValueAssignment_1"


    // $ANTLR start "rule__Expression__AdditionAssignment"
    // InternalAssembler.g:2019:1: rule__Expression__AdditionAssignment : ( ruleAddition ) ;
    public final void rule__Expression__AdditionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2023:1: ( ( ruleAddition ) )
            // InternalAssembler.g:2024:2: ( ruleAddition )
            {
            // InternalAssembler.g:2024:2: ( ruleAddition )
            // InternalAssembler.g:2025:3: ruleAddition
            {
             before(grammarAccess.getExpressionAccess().getAdditionAdditionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getAdditionAdditionParserRuleCall_0()); 

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
    // $ANTLR end "rule__Expression__AdditionAssignment"


    // $ANTLR start "rule__Addition__ValuesAssignment_0"
    // InternalAssembler.g:2034:1: rule__Addition__ValuesAssignment_0 : ( ruleMultiplication ) ;
    public final void rule__Addition__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2038:1: ( ( ruleMultiplication ) )
            // InternalAssembler.g:2039:2: ( ruleMultiplication )
            {
            // InternalAssembler.g:2039:2: ( ruleMultiplication )
            // InternalAssembler.g:2040:3: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getValuesMultiplicationParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getAdditionAccess().getValuesMultiplicationParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Addition__ValuesAssignment_0"


    // $ANTLR start "rule__Addition__ValuesAssignment_1_1"
    // InternalAssembler.g:2049:1: rule__Addition__ValuesAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2053:1: ( ( ruleMultiplication ) )
            // InternalAssembler.g:2054:2: ( ruleMultiplication )
            {
            // InternalAssembler.g:2054:2: ( ruleMultiplication )
            // InternalAssembler.g:2055:3: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getValuesMultiplicationParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getAdditionAccess().getValuesMultiplicationParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Addition__ValuesAssignment_1_1"


    // $ANTLR start "rule__Multiplication__ValuesAssignment_0"
    // InternalAssembler.g:2064:1: rule__Multiplication__ValuesAssignment_0 : ( ruleDivision ) ;
    public final void rule__Multiplication__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2068:1: ( ( ruleDivision ) )
            // InternalAssembler.g:2069:2: ( ruleDivision )
            {
            // InternalAssembler.g:2069:2: ( ruleDivision )
            // InternalAssembler.g:2070:3: ruleDivision
            {
             before(grammarAccess.getMultiplicationAccess().getValuesDivisionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDivision();

            state._fsp--;

             after(grammarAccess.getMultiplicationAccess().getValuesDivisionParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Multiplication__ValuesAssignment_0"


    // $ANTLR start "rule__Multiplication__ValuesAssignment_1_1"
    // InternalAssembler.g:2079:1: rule__Multiplication__ValuesAssignment_1_1 : ( ruleDivision ) ;
    public final void rule__Multiplication__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2083:1: ( ( ruleDivision ) )
            // InternalAssembler.g:2084:2: ( ruleDivision )
            {
            // InternalAssembler.g:2084:2: ( ruleDivision )
            // InternalAssembler.g:2085:3: ruleDivision
            {
             before(grammarAccess.getMultiplicationAccess().getValuesDivisionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDivision();

            state._fsp--;

             after(grammarAccess.getMultiplicationAccess().getValuesDivisionParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Multiplication__ValuesAssignment_1_1"


    // $ANTLR start "rule__Division__ValuesAssignment_0"
    // InternalAssembler.g:2094:1: rule__Division__ValuesAssignment_0 : ( ruleSoustraction ) ;
    public final void rule__Division__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2098:1: ( ( ruleSoustraction ) )
            // InternalAssembler.g:2099:2: ( ruleSoustraction )
            {
            // InternalAssembler.g:2099:2: ( ruleSoustraction )
            // InternalAssembler.g:2100:3: ruleSoustraction
            {
             before(grammarAccess.getDivisionAccess().getValuesSoustractionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSoustraction();

            state._fsp--;

             after(grammarAccess.getDivisionAccess().getValuesSoustractionParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Division__ValuesAssignment_0"


    // $ANTLR start "rule__Division__ValuesAssignment_1_1"
    // InternalAssembler.g:2109:1: rule__Division__ValuesAssignment_1_1 : ( ruleSoustraction ) ;
    public final void rule__Division__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2113:1: ( ( ruleSoustraction ) )
            // InternalAssembler.g:2114:2: ( ruleSoustraction )
            {
            // InternalAssembler.g:2114:2: ( ruleSoustraction )
            // InternalAssembler.g:2115:3: ruleSoustraction
            {
             before(grammarAccess.getDivisionAccess().getValuesSoustractionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSoustraction();

            state._fsp--;

             after(grammarAccess.getDivisionAccess().getValuesSoustractionParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Division__ValuesAssignment_1_1"


    // $ANTLR start "rule__Soustraction__ValuesAssignment_0"
    // InternalAssembler.g:2124:1: rule__Soustraction__ValuesAssignment_0 : ( rulePrimary ) ;
    public final void rule__Soustraction__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2128:1: ( ( rulePrimary ) )
            // InternalAssembler.g:2129:2: ( rulePrimary )
            {
            // InternalAssembler.g:2129:2: ( rulePrimary )
            // InternalAssembler.g:2130:3: rulePrimary
            {
             before(grammarAccess.getSoustractionAccess().getValuesPrimaryParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getSoustractionAccess().getValuesPrimaryParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Soustraction__ValuesAssignment_0"


    // $ANTLR start "rule__Soustraction__ValuesAssignment_1_1"
    // InternalAssembler.g:2139:1: rule__Soustraction__ValuesAssignment_1_1 : ( rulePrimary ) ;
    public final void rule__Soustraction__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2143:1: ( ( rulePrimary ) )
            // InternalAssembler.g:2144:2: ( rulePrimary )
            {
            // InternalAssembler.g:2144:2: ( rulePrimary )
            // InternalAssembler.g:2145:3: rulePrimary
            {
             before(grammarAccess.getSoustractionAccess().getValuesPrimaryParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getSoustractionAccess().getValuesPrimaryParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Soustraction__ValuesAssignment_1_1"


    // $ANTLR start "rule__Primary__ExpressionValueAssignment_0"
    // InternalAssembler.g:2154:1: rule__Primary__ExpressionValueAssignment_0 : ( ruleExpressionValue ) ;
    public final void rule__Primary__ExpressionValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2158:1: ( ( ruleExpressionValue ) )
            // InternalAssembler.g:2159:2: ( ruleExpressionValue )
            {
            // InternalAssembler.g:2159:2: ( ruleExpressionValue )
            // InternalAssembler.g:2160:3: ruleExpressionValue
            {
             before(grammarAccess.getPrimaryAccess().getExpressionValueExpressionValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExpressionValue();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getExpressionValueExpressionValueParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Primary__ExpressionValueAssignment_0"


    // $ANTLR start "rule__Primary__ExpressionValueAssignment_1_1"
    // InternalAssembler.g:2169:1: rule__Primary__ExpressionValueAssignment_1_1 : ( ruleAddition ) ;
    public final void rule__Primary__ExpressionValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2173:1: ( ( ruleAddition ) )
            // InternalAssembler.g:2174:2: ( ruleAddition )
            {
            // InternalAssembler.g:2174:2: ( ruleAddition )
            // InternalAssembler.g:2175:3: ruleAddition
            {
             before(grammarAccess.getPrimaryAccess().getExpressionValueAdditionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getExpressionValueAdditionParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Primary__ExpressionValueAssignment_1_1"


    // $ANTLR start "rule__ExpressionValue__ExpressionValueAssignment_0"
    // InternalAssembler.g:2184:1: rule__ExpressionValue__ExpressionValueAssignment_0 : ( ruleBinaryeValue ) ;
    public final void rule__ExpressionValue__ExpressionValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2188:1: ( ( ruleBinaryeValue ) )
            // InternalAssembler.g:2189:2: ( ruleBinaryeValue )
            {
            // InternalAssembler.g:2189:2: ( ruleBinaryeValue )
            // InternalAssembler.g:2190:3: ruleBinaryeValue
            {
             before(grammarAccess.getExpressionValueAccess().getExpressionValueBinaryeValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryeValue();

            state._fsp--;

             after(grammarAccess.getExpressionValueAccess().getExpressionValueBinaryeValueParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__ExpressionValue__ExpressionValueAssignment_0"


    // $ANTLR start "rule__ExpressionValue__ExpressionValueAssignment_1"
    // InternalAssembler.g:2199:1: rule__ExpressionValue__ExpressionValueAssignment_1 : ( ruleOctalValue ) ;
    public final void rule__ExpressionValue__ExpressionValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2203:1: ( ( ruleOctalValue ) )
            // InternalAssembler.g:2204:2: ( ruleOctalValue )
            {
            // InternalAssembler.g:2204:2: ( ruleOctalValue )
            // InternalAssembler.g:2205:3: ruleOctalValue
            {
             before(grammarAccess.getExpressionValueAccess().getExpressionValueOctalValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOctalValue();

            state._fsp--;

             after(grammarAccess.getExpressionValueAccess().getExpressionValueOctalValueParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__ExpressionValue__ExpressionValueAssignment_1"


    // $ANTLR start "rule__ExpressionValue__ExpressionValueAssignment_2"
    // InternalAssembler.g:2214:1: rule__ExpressionValue__ExpressionValueAssignment_2 : ( ruleDecimelValue ) ;
    public final void rule__ExpressionValue__ExpressionValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2218:1: ( ( ruleDecimelValue ) )
            // InternalAssembler.g:2219:2: ( ruleDecimelValue )
            {
            // InternalAssembler.g:2219:2: ( ruleDecimelValue )
            // InternalAssembler.g:2220:3: ruleDecimelValue
            {
             before(grammarAccess.getExpressionValueAccess().getExpressionValueDecimelValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDecimelValue();

            state._fsp--;

             after(grammarAccess.getExpressionValueAccess().getExpressionValueDecimelValueParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__ExpressionValue__ExpressionValueAssignment_2"


    // $ANTLR start "rule__ExpressionValue__ExpressionValueAssignment_3"
    // InternalAssembler.g:2229:1: rule__ExpressionValue__ExpressionValueAssignment_3 : ( ruleHexadecimalValue ) ;
    public final void rule__ExpressionValue__ExpressionValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2233:1: ( ( ruleHexadecimalValue ) )
            // InternalAssembler.g:2234:2: ( ruleHexadecimalValue )
            {
            // InternalAssembler.g:2234:2: ( ruleHexadecimalValue )
            // InternalAssembler.g:2235:3: ruleHexadecimalValue
            {
             before(grammarAccess.getExpressionValueAccess().getExpressionValueHexadecimalValueParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleHexadecimalValue();

            state._fsp--;

             after(grammarAccess.getExpressionValueAccess().getExpressionValueHexadecimalValueParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__ExpressionValue__ExpressionValueAssignment_3"


    // $ANTLR start "rule__ExpressionValue__ExpressionValueAssignment_4"
    // InternalAssembler.g:2244:1: rule__ExpressionValue__ExpressionValueAssignment_4 : ( ruleLabelValue ) ;
    public final void rule__ExpressionValue__ExpressionValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2248:1: ( ( ruleLabelValue ) )
            // InternalAssembler.g:2249:2: ( ruleLabelValue )
            {
            // InternalAssembler.g:2249:2: ( ruleLabelValue )
            // InternalAssembler.g:2250:3: ruleLabelValue
            {
             before(grammarAccess.getExpressionValueAccess().getExpressionValueLabelValueParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleLabelValue();

            state._fsp--;

             after(grammarAccess.getExpressionValueAccess().getExpressionValueLabelValueParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__ExpressionValue__ExpressionValueAssignment_4"


    // $ANTLR start "rule__ExpressionValue__ExpressionValueAssignment_5"
    // InternalAssembler.g:2259:1: rule__ExpressionValue__ExpressionValueAssignment_5 : ( ruleAsciiValue ) ;
    public final void rule__ExpressionValue__ExpressionValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2263:1: ( ( ruleAsciiValue ) )
            // InternalAssembler.g:2264:2: ( ruleAsciiValue )
            {
            // InternalAssembler.g:2264:2: ( ruleAsciiValue )
            // InternalAssembler.g:2265:3: ruleAsciiValue
            {
             before(grammarAccess.getExpressionValueAccess().getExpressionValueAsciiValueParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleAsciiValue();

            state._fsp--;

             after(grammarAccess.getExpressionValueAccess().getExpressionValueAsciiValueParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__ExpressionValue__ExpressionValueAssignment_5"


    // $ANTLR start "rule__ExpressionValue__ExpressionValueAssignment_6"
    // InternalAssembler.g:2274:1: rule__ExpressionValue__ExpressionValueAssignment_6 : ( ruleActualPosition ) ;
    public final void rule__ExpressionValue__ExpressionValueAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2278:1: ( ( ruleActualPosition ) )
            // InternalAssembler.g:2279:2: ( ruleActualPosition )
            {
            // InternalAssembler.g:2279:2: ( ruleActualPosition )
            // InternalAssembler.g:2280:3: ruleActualPosition
            {
             before(grammarAccess.getExpressionValueAccess().getExpressionValueActualPositionParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleActualPosition();

            state._fsp--;

             after(grammarAccess.getExpressionValueAccess().getExpressionValueActualPositionParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__ExpressionValue__ExpressionValueAssignment_6"


    // $ANTLR start "rule__ActualPosition__ActualPositionAssignment"
    // InternalAssembler.g:2289:1: rule__ActualPosition__ActualPositionAssignment : ( ( '*' ) ) ;
    public final void rule__ActualPosition__ActualPositionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2293:1: ( ( ( '*' ) ) )
            // InternalAssembler.g:2294:2: ( ( '*' ) )
            {
            // InternalAssembler.g:2294:2: ( ( '*' ) )
            // InternalAssembler.g:2295:3: ( '*' )
            {
             before(grammarAccess.getActualPositionAccess().getActualPositionAsteriskKeyword_0()); 
            // InternalAssembler.g:2296:3: ( '*' )
            // InternalAssembler.g:2297:4: '*'
            {
             before(grammarAccess.getActualPositionAccess().getActualPositionAsteriskKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getActualPositionAccess().getActualPositionAsteriskKeyword_0()); 

            }

             after(grammarAccess.getActualPositionAccess().getActualPositionAsteriskKeyword_0()); 

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
    // $ANTLR end "rule__ActualPosition__ActualPositionAssignment"


    // $ANTLR start "rule__BinaryeValue__IsNegativeAssignment_0"
    // InternalAssembler.g:2308:1: rule__BinaryeValue__IsNegativeAssignment_0 : ( ( '-' ) ) ;
    public final void rule__BinaryeValue__IsNegativeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2312:1: ( ( ( '-' ) ) )
            // InternalAssembler.g:2313:2: ( ( '-' ) )
            {
            // InternalAssembler.g:2313:2: ( ( '-' ) )
            // InternalAssembler.g:2314:3: ( '-' )
            {
             before(grammarAccess.getBinaryeValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            // InternalAssembler.g:2315:3: ( '-' )
            // InternalAssembler.g:2316:4: '-'
            {
             before(grammarAccess.getBinaryeValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getBinaryeValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 

            }

             after(grammarAccess.getBinaryeValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 

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
    // $ANTLR end "rule__BinaryeValue__IsNegativeAssignment_0"


    // $ANTLR start "rule__BinaryeValue__BinaryValueAssignment_1"
    // InternalAssembler.g:2327:1: rule__BinaryeValue__BinaryValueAssignment_1 : ( RULE_BINARY ) ;
    public final void rule__BinaryeValue__BinaryValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2331:1: ( ( RULE_BINARY ) )
            // InternalAssembler.g:2332:2: ( RULE_BINARY )
            {
            // InternalAssembler.g:2332:2: ( RULE_BINARY )
            // InternalAssembler.g:2333:3: RULE_BINARY
            {
             before(grammarAccess.getBinaryeValueAccess().getBinaryValueBINARYTerminalRuleCall_1_0()); 
            match(input,RULE_BINARY,FOLLOW_2); 
             after(grammarAccess.getBinaryeValueAccess().getBinaryValueBINARYTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__BinaryeValue__BinaryValueAssignment_1"


    // $ANTLR start "rule__OctalValue__IsNegativeAssignment_0"
    // InternalAssembler.g:2342:1: rule__OctalValue__IsNegativeAssignment_0 : ( ( '-' ) ) ;
    public final void rule__OctalValue__IsNegativeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2346:1: ( ( ( '-' ) ) )
            // InternalAssembler.g:2347:2: ( ( '-' ) )
            {
            // InternalAssembler.g:2347:2: ( ( '-' ) )
            // InternalAssembler.g:2348:3: ( '-' )
            {
             before(grammarAccess.getOctalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            // InternalAssembler.g:2349:3: ( '-' )
            // InternalAssembler.g:2350:4: '-'
            {
             before(grammarAccess.getOctalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getOctalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 

            }

             after(grammarAccess.getOctalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 

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
    // $ANTLR end "rule__OctalValue__IsNegativeAssignment_0"


    // $ANTLR start "rule__OctalValue__OctalValueAssignment_1"
    // InternalAssembler.g:2361:1: rule__OctalValue__OctalValueAssignment_1 : ( RULE_OCTAL ) ;
    public final void rule__OctalValue__OctalValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2365:1: ( ( RULE_OCTAL ) )
            // InternalAssembler.g:2366:2: ( RULE_OCTAL )
            {
            // InternalAssembler.g:2366:2: ( RULE_OCTAL )
            // InternalAssembler.g:2367:3: RULE_OCTAL
            {
             before(grammarAccess.getOctalValueAccess().getOctalValueOCTALTerminalRuleCall_1_0()); 
            match(input,RULE_OCTAL,FOLLOW_2); 
             after(grammarAccess.getOctalValueAccess().getOctalValueOCTALTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__OctalValue__OctalValueAssignment_1"


    // $ANTLR start "rule__DecimelValue__IsNegativeAssignment_0"
    // InternalAssembler.g:2376:1: rule__DecimelValue__IsNegativeAssignment_0 : ( ( '-' ) ) ;
    public final void rule__DecimelValue__IsNegativeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2380:1: ( ( ( '-' ) ) )
            // InternalAssembler.g:2381:2: ( ( '-' ) )
            {
            // InternalAssembler.g:2381:2: ( ( '-' ) )
            // InternalAssembler.g:2382:3: ( '-' )
            {
             before(grammarAccess.getDecimelValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            // InternalAssembler.g:2383:3: ( '-' )
            // InternalAssembler.g:2384:4: '-'
            {
             before(grammarAccess.getDecimelValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getDecimelValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 

            }

             after(grammarAccess.getDecimelValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 

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
    // $ANTLR end "rule__DecimelValue__IsNegativeAssignment_0"


    // $ANTLR start "rule__DecimelValue__DecimalValueAssignment_1"
    // InternalAssembler.g:2395:1: rule__DecimelValue__DecimalValueAssignment_1 : ( RULE_DECIMAL ) ;
    public final void rule__DecimelValue__DecimalValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2399:1: ( ( RULE_DECIMAL ) )
            // InternalAssembler.g:2400:2: ( RULE_DECIMAL )
            {
            // InternalAssembler.g:2400:2: ( RULE_DECIMAL )
            // InternalAssembler.g:2401:3: RULE_DECIMAL
            {
             before(grammarAccess.getDecimelValueAccess().getDecimalValueDECIMALTerminalRuleCall_1_0()); 
            match(input,RULE_DECIMAL,FOLLOW_2); 
             after(grammarAccess.getDecimelValueAccess().getDecimalValueDECIMALTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__DecimelValue__DecimalValueAssignment_1"


    // $ANTLR start "rule__HexadecimalValue__IsNegativeAssignment_0"
    // InternalAssembler.g:2410:1: rule__HexadecimalValue__IsNegativeAssignment_0 : ( ( '-' ) ) ;
    public final void rule__HexadecimalValue__IsNegativeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2414:1: ( ( ( '-' ) ) )
            // InternalAssembler.g:2415:2: ( ( '-' ) )
            {
            // InternalAssembler.g:2415:2: ( ( '-' ) )
            // InternalAssembler.g:2416:3: ( '-' )
            {
             before(grammarAccess.getHexadecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            // InternalAssembler.g:2417:3: ( '-' )
            // InternalAssembler.g:2418:4: '-'
            {
             before(grammarAccess.getHexadecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getHexadecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 

            }

             after(grammarAccess.getHexadecimalValueAccess().getIsNegativeHyphenMinusKeyword_0_0()); 

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
    // $ANTLR end "rule__HexadecimalValue__IsNegativeAssignment_0"


    // $ANTLR start "rule__HexadecimalValue__HexadeciamlValueAssignment_1"
    // InternalAssembler.g:2429:1: rule__HexadecimalValue__HexadeciamlValueAssignment_1 : ( RULE_HEXADECIMAL ) ;
    public final void rule__HexadecimalValue__HexadeciamlValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2433:1: ( ( RULE_HEXADECIMAL ) )
            // InternalAssembler.g:2434:2: ( RULE_HEXADECIMAL )
            {
            // InternalAssembler.g:2434:2: ( RULE_HEXADECIMAL )
            // InternalAssembler.g:2435:3: RULE_HEXADECIMAL
            {
             before(grammarAccess.getHexadecimalValueAccess().getHexadeciamlValueHEXADECIMALTerminalRuleCall_1_0()); 
            match(input,RULE_HEXADECIMAL,FOLLOW_2); 
             after(grammarAccess.getHexadecimalValueAccess().getHexadeciamlValueHEXADECIMALTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__HexadecimalValue__HexadeciamlValueAssignment_1"


    // $ANTLR start "rule__AsciiValue__AsciiValueAssignment"
    // InternalAssembler.g:2444:1: rule__AsciiValue__AsciiValueAssignment : ( RULE_ASCII ) ;
    public final void rule__AsciiValue__AsciiValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2448:1: ( ( RULE_ASCII ) )
            // InternalAssembler.g:2449:2: ( RULE_ASCII )
            {
            // InternalAssembler.g:2449:2: ( RULE_ASCII )
            // InternalAssembler.g:2450:3: RULE_ASCII
            {
             before(grammarAccess.getAsciiValueAccess().getAsciiValueASCIITerminalRuleCall_0()); 
            match(input,RULE_ASCII,FOLLOW_2); 
             after(grammarAccess.getAsciiValueAccess().getAsciiValueASCIITerminalRuleCall_0()); 

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
    // $ANTLR end "rule__AsciiValue__AsciiValueAssignment"


    // $ANTLR start "rule__LabelValue__LabelAssignment"
    // InternalAssembler.g:2459:1: rule__LabelValue__LabelAssignment : ( RULE_LABEL ) ;
    public final void rule__LabelValue__LabelAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAssembler.g:2463:1: ( ( RULE_LABEL ) )
            // InternalAssembler.g:2464:2: ( RULE_LABEL )
            {
            // InternalAssembler.g:2464:2: ( RULE_LABEL )
            // InternalAssembler.g:2465:3: RULE_LABEL
            {
             before(grammarAccess.getLabelValueAccess().getLabelLABELTerminalRuleCall_0()); 
            match(input,RULE_LABEL,FOLLOW_2); 
             after(grammarAccess.getLabelValueAccess().getLabelLABELTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__LabelValue__LabelAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000000F2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000069F80L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020100L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000020800L});

}
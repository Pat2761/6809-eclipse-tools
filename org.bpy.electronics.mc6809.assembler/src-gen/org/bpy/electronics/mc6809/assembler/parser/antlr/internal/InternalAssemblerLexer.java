package org.bpy.electronics.mc6809.assembler.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAssemblerLexer extends Lexer {
    public static final int RULE_WS=4;
    public static final int RULE_CR=6;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=5;

    // delegates
    // delegators

    public InternalAssemblerLexer() {;} 
    public InternalAssemblerLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalAssemblerLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalAssembler.g"; }

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:235:17: ( ';' ( . )* RULE_CR )
            // InternalAssembler.g:235:19: ';' ( . )* RULE_CR
            {
            match(';'); 
            // InternalAssembler.g:235:23: ( . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\r') ) {
                    alt1=2;
                }
                else if ( (LA1_0=='\n') ) {
                    alt1=2;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAssembler.g:235:23: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            mRULE_CR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_CR"
    public final void mRULE_CR() throws RecognitionException {
        try {
            int _type = RULE_CR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:237:9: ( ( '\\r' )? '\\n' )
            // InternalAssembler.g:237:11: ( '\\r' )? '\\n'
            {
            // InternalAssembler.g:237:11: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalAssembler.g:237:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CR"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:239:9: ( ( ' ' | '\\t' )+ )
            // InternalAssembler.g:239:11: ( ' ' | '\\t' )+
            {
            // InternalAssembler.g:239:11: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAssembler.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // InternalAssembler.g:1:8: ( RULE_SL_COMMENT | RULE_CR | RULE_WS )
        int alt4=3;
        switch ( input.LA(1) ) {
        case ';':
            {
            alt4=1;
            }
            break;
        case '\n':
        case '\r':
            {
            alt4=2;
            }
            break;
        case '\t':
        case ' ':
            {
            alt4=3;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;
        }

        switch (alt4) {
            case 1 :
                // InternalAssembler.g:1:10: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 2 :
                // InternalAssembler.g:1:26: RULE_CR
                {
                mRULE_CR(); 

                }
                break;
            case 3 :
                // InternalAssembler.g:1:34: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


 

}
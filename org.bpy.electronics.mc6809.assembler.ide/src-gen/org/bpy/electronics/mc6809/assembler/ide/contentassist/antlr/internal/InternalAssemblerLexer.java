package org.bpy.electronics.mc6809.assembler.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAssemblerLexer extends Lexer {
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

    public InternalAssemblerLexer() {;} 
    public InternalAssemblerLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalAssemblerLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalAssembler.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:11:7: ( '+' )
            // InternalAssembler.g:11:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:12:7: ( '-' )
            // InternalAssembler.g:12:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:13:7: ( '<<' )
            // InternalAssembler.g:13:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:14:7: ( '>>' )
            // InternalAssembler.g:14:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:15:7: ( '~' )
            // InternalAssembler.g:15:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:16:7: ( '&&' )
            // InternalAssembler.g:16:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:17:7: ( '||' )
            // InternalAssembler.g:17:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:18:7: ( '^' )
            // InternalAssembler.g:18:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:19:7: ( '(' )
            // InternalAssembler.g:19:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:20:7: ( ')' )
            // InternalAssembler.g:20:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:21:7: ( 'EQU' )
            // InternalAssembler.g:21:9: 'EQU'
            {
            match("EQU"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:22:7: ( '*' )
            // InternalAssembler.g:22:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:23:7: ( '/' )
            // InternalAssembler.g:23:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:24:7: ( '%' )
            // InternalAssembler.g:24:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3380:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalAssembler.g:3380:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalAssembler.g:3380:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalAssembler.g:3380:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalAssembler.g:3380:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAssembler.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_HEXA"
    public final void mRULE_HEXA() throws RecognitionException {
        try {
            int _type = RULE_HEXA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3382:11: ( '$' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalAssembler.g:3382:13: '$' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('$'); 
            // InternalAssembler.g:3382:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='F')||(LA3_0>='a' && LA3_0<='f')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAssembler.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end "RULE_HEXA"

    // $ANTLR start "RULE_BINARY"
    public final void mRULE_BINARY() throws RecognitionException {
        try {
            int _type = RULE_BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3384:13: ( '%' ( '0' .. '1' )+ )
            // InternalAssembler.g:3384:15: '%' ( '0' .. '1' )+
            {
            match('%'); 
            // InternalAssembler.g:3384:19: ( '0' .. '1' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='1')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAssembler.g:3384:20: '0' .. '1'
            	    {
            	    matchRange('0','1'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINARY"

    // $ANTLR start "RULE_OCTAL"
    public final void mRULE_OCTAL() throws RecognitionException {
        try {
            int _type = RULE_OCTAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3386:12: ( '@' ( '0' .. '7' )+ )
            // InternalAssembler.g:3386:14: '@' ( '0' .. '7' )+
            {
            match('@'); 
            // InternalAssembler.g:3386:18: ( '0' .. '7' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='7')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalAssembler.g:3386:19: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTAL"

    // $ANTLR start "RULE_CHARACTER"
    public final void mRULE_CHARACTER() throws RecognitionException {
        try {
            int _type = RULE_CHARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3388:16: ( '\\'' ' ' .. '\\u007F' )
            // InternalAssembler.g:3388:18: '\\'' ' ' .. '\\u007F'
            {
            match('\''); 
            matchRange(' ','\u007F'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARACTER"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3390:10: ( ( '-' )? ( '0' .. '9' )+ )
            // InternalAssembler.g:3390:12: ( '-' )? ( '0' .. '9' )+
            {
            // InternalAssembler.g:3390:12: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAssembler.g:3390:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalAssembler.g:3390:17: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAssembler.g:3390:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3392:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* )
            // InternalAssembler.g:3392:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            {
            match('\"'); 
            // InternalAssembler.g:3392:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    alt8=1;
                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalAssembler.g:3392:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalAssembler.g:3392:27: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE"
    public final void mRULE_ANY_EXCEPT_COMMENT_END_OF_LINE() throws RecognitionException {
        try {
            int _type = RULE_ANY_EXCEPT_COMMENT_END_OF_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3394:37: ( ';' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalAssembler.g:3394:39: ';' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match(';'); 
            // InternalAssembler.g:3394:43: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAssembler.g:3394:43: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3396:9: ( ( ' ' | '\\t' )+ )
            // InternalAssembler.g:3396:11: ( ' ' | '\\t' )+
            {
            // InternalAssembler.g:3396:11: ( ' ' | '\\t' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_CR"
    public final void mRULE_CR() throws RecognitionException {
        try {
            int _type = RULE_CR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3398:9: ( ( '\\r' )? '\\n' )
            // InternalAssembler.g:3398:11: ( '\\r' )? '\\n'
            {
            // InternalAssembler.g:3398:11: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAssembler.g:3398:11: '\\r'
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

    // $ANTLR start "RULE_END_OF_FILE"
    public final void mRULE_END_OF_FILE() throws RecognitionException {
        try {
            int _type = RULE_END_OF_FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:3400:18: ( EOF )
            // InternalAssembler.g:3400:20: EOF
            {
            match(EOF); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_END_OF_FILE"

    public void mTokens() throws RecognitionException {
        // InternalAssembler.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | RULE_ID | RULE_HEXA | RULE_BINARY | RULE_OCTAL | RULE_CHARACTER | RULE_INT | RULE_STRING | RULE_ANY_EXCEPT_COMMENT_END_OF_LINE | RULE_WS | RULE_CR | RULE_END_OF_FILE )
        int alt12=25;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalAssembler.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // InternalAssembler.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // InternalAssembler.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // InternalAssembler.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // InternalAssembler.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // InternalAssembler.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // InternalAssembler.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // InternalAssembler.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // InternalAssembler.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // InternalAssembler.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // InternalAssembler.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // InternalAssembler.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // InternalAssembler.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // InternalAssembler.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // InternalAssembler.g:1:94: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 16 :
                // InternalAssembler.g:1:102: RULE_HEXA
                {
                mRULE_HEXA(); 

                }
                break;
            case 17 :
                // InternalAssembler.g:1:112: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 18 :
                // InternalAssembler.g:1:124: RULE_OCTAL
                {
                mRULE_OCTAL(); 

                }
                break;
            case 19 :
                // InternalAssembler.g:1:135: RULE_CHARACTER
                {
                mRULE_CHARACTER(); 

                }
                break;
            case 20 :
                // InternalAssembler.g:1:150: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 21 :
                // InternalAssembler.g:1:159: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 22 :
                // InternalAssembler.g:1:171: RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                {
                mRULE_ANY_EXCEPT_COMMENT_END_OF_LINE(); 

                }
                break;
            case 23 :
                // InternalAssembler.g:1:207: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 24 :
                // InternalAssembler.g:1:215: RULE_CR
                {
                mRULE_CR(); 

                }
                break;
            case 25 :
                // InternalAssembler.g:1:223: RULE_END_OF_FILE
                {
                mRULE_END_OF_FILE(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\30\1\uffff\1\31\5\uffff\1\32\2\uffff\1\17\2\uffff\1\34\14\uffff\1\17\2\uffff\1\37\1\uffff";
    static final String DFA12_eofS =
        "\40\uffff";
    static final String DFA12_minS =
        "\1\11\1\uffff\1\60\5\uffff\1\101\2\uffff\1\121\2\uffff\1\60\14\uffff\1\125\2\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\176\1\uffff\1\71\5\uffff\1\172\2\uffff\1\121\2\uffff\1\61\14\uffff\1\125\2\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\7\1\uffff\1\11\1\12\1\uffff\1\14\1\15\1\uffff\1\17\1\20\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\2\1\10\1\uffff\1\16\1\21\1\uffff\1\13";
    static final String DFA12_specialS =
        "\40\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\26\1\27\2\uffff\1\27\22\uffff\1\26\1\uffff\1\24\1\uffff\1\20\1\16\1\6\1\22\1\11\1\12\1\14\1\1\1\uffff\1\2\1\uffff\1\15\12\23\1\uffff\1\25\1\3\1\uffff\1\4\1\uffff\1\21\4\17\1\13\25\17\3\uffff\1\10\1\17\1\uffff\32\17\1\uffff\1\7\1\uffff\1\5",
            "",
            "\12\23",
            "",
            "",
            "",
            "",
            "",
            "\32\17\4\uffff\1\17\1\uffff\32\17",
            "",
            "",
            "\1\33",
            "",
            "",
            "\2\35",
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
            "\1\36",
            "",
            "",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | RULE_ID | RULE_HEXA | RULE_BINARY | RULE_OCTAL | RULE_CHARACTER | RULE_INT | RULE_STRING | RULE_ANY_EXCEPT_COMMENT_END_OF_LINE | RULE_WS | RULE_CR | RULE_END_OF_FILE );";
        }
    }
 

}
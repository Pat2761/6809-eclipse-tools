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
    public static final int RULE_CHARACTER=13;
    public static final int RULE_CR=4;
    public static final int RULE_STRING=14;
    public static final int T__19=19;
    public static final int RULE_OCTAL=11;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int RULE_END_OF_FILE=5;
    public static final int T__34=34;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=8;
    public static final int RULE_WS=6;
    public static final int RULE_HEXA=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=9;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int RULE_BINARY=12;
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
            // InternalAssembler.g:11:7: ( ',' )
            // InternalAssembler.g:11:9: ','
            {
            match(','); 

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
            // InternalAssembler.g:12:7: ( '+' )
            // InternalAssembler.g:12:9: '+'
            {
            match('+'); 

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
            // InternalAssembler.g:13:7: ( '-' )
            // InternalAssembler.g:13:9: '-'
            {
            match('-'); 

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
            // InternalAssembler.g:14:7: ( '<<' )
            // InternalAssembler.g:14:9: '<<'
            {
            match("<<"); 


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
            // InternalAssembler.g:15:7: ( '>>' )
            // InternalAssembler.g:15:9: '>>'
            {
            match(">>"); 


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
            // InternalAssembler.g:19:7: ( '!' )
            // InternalAssembler.g:19:9: '!'
            {
            match('!'); 

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
            // InternalAssembler.g:20:7: ( '(' )
            // InternalAssembler.g:20:9: '('
            {
            match('('); 

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
            // InternalAssembler.g:21:7: ( ')' )
            // InternalAssembler.g:21:9: ')'
            {
            match(')'); 

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
            // InternalAssembler.g:22:7: ( 'FDB' )
            // InternalAssembler.g:22:9: 'FDB'
            {
            match("FDB"); 


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
            // InternalAssembler.g:23:7: ( 'FCB' )
            // InternalAssembler.g:23:9: 'FCB'
            {
            match("FCB"); 


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
            // InternalAssembler.g:24:7: ( 'RMB' )
            // InternalAssembler.g:24:9: 'RMB'
            {
            match("RMB"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:25:7: ( 'END' )
            // InternalAssembler.g:25:9: 'END'
            {
            match("END"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:26:7: ( 'ORG' )
            // InternalAssembler.g:26:9: 'ORG'
            {
            match("ORG"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:27:7: ( 'EQU' )
            // InternalAssembler.g:27:9: 'EQU'
            {
            match("EQU"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:28:7: ( '*' )
            // InternalAssembler.g:28:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:29:7: ( '/' )
            // InternalAssembler.g:29:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:30:7: ( '%' )
            // InternalAssembler.g:30:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:5518:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalAssembler.g:5518:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalAssembler.g:5518:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalAssembler.g:5518:11: '^'
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

            // InternalAssembler.g:5518:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // InternalAssembler.g:5520:11: ( '$' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalAssembler.g:5520:13: '$' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('$'); 
            // InternalAssembler.g:5520:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:5522:10: ( ( '0' .. '9' )+ )
            // InternalAssembler.g:5522:12: ( '0' .. '9' )+
            {
            // InternalAssembler.g:5522:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAssembler.g:5522:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_OCTAL"
    public final void mRULE_OCTAL() throws RecognitionException {
        try {
            int _type = RULE_OCTAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:5524:12: ( '@' ( '0' .. '7' )+ )
            // InternalAssembler.g:5524:14: '@' ( '0' .. '7' )+
            {
            match('@'); 
            // InternalAssembler.g:5524:18: ( '0' .. '7' )+
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
            	    // InternalAssembler.g:5524:19: '0' .. '7'
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

    // $ANTLR start "RULE_BINARY"
    public final void mRULE_BINARY() throws RecognitionException {
        try {
            int _type = RULE_BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:5526:13: ( '0' 'b' ( '0' .. '1' )+ )
            // InternalAssembler.g:5526:15: '0' 'b' ( '0' .. '1' )+
            {
            match('0'); 
            match('b'); 
            // InternalAssembler.g:5526:23: ( '0' .. '1' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='1')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalAssembler.g:5526:24: '0' .. '1'
            	    {
            	    matchRange('0','1'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINARY"

    // $ANTLR start "RULE_CHARACTER"
    public final void mRULE_CHARACTER() throws RecognitionException {
        try {
            int _type = RULE_CHARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:5528:16: ( '\\'' ' ' .. '\\u007F' )
            // InternalAssembler.g:5528:18: '\\'' ' ' .. '\\u007F'
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:5530:13: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* )
            // InternalAssembler.g:5530:15: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            {
            match('\"'); 
            // InternalAssembler.g:5530:19: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    alt7=1;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAssembler.g:5530:20: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalAssembler.g:5530:27: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop7;
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
            // InternalAssembler.g:5532:37: ( ';' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalAssembler.g:5532:39: ';' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match(';'); 
            // InternalAssembler.g:5532:43: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalAssembler.g:5532:43: ~ ( ( '\\n' | '\\r' ) )
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
    // $ANTLR end "RULE_ANY_EXCEPT_COMMENT_END_OF_LINE"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:5534:9: ( ( ' ' | '\\t' )+ )
            // InternalAssembler.g:5534:11: ( ' ' | '\\t' )+
            {
            // InternalAssembler.g:5534:11: ( ' ' | '\\t' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // InternalAssembler.g:5536:9: ( ( '\\r' )? '\\n' )
            // InternalAssembler.g:5536:11: ( '\\r' )? '\\n'
            {
            // InternalAssembler.g:5536:11: ( '\\r' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssembler.g:5536:11: '\\r'
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
            // InternalAssembler.g:5538:18: ( EOF )
            // InternalAssembler.g:5538:20: EOF
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
        // InternalAssembler.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | RULE_ID | RULE_HEXA | RULE_INT | RULE_OCTAL | RULE_BINARY | RULE_CHARACTER | RULE_STRING | RULE_ANY_EXCEPT_COMMENT_END_OF_LINE | RULE_WS | RULE_CR | RULE_END_OF_FILE )
        int alt11=31;
        alt11 = dfa11.predict(input);
        switch (alt11) {
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
                // InternalAssembler.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // InternalAssembler.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // InternalAssembler.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // InternalAssembler.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // InternalAssembler.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // InternalAssembler.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // InternalAssembler.g:1:130: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 22 :
                // InternalAssembler.g:1:138: RULE_HEXA
                {
                mRULE_HEXA(); 

                }
                break;
            case 23 :
                // InternalAssembler.g:1:148: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 24 :
                // InternalAssembler.g:1:157: RULE_OCTAL
                {
                mRULE_OCTAL(); 

                }
                break;
            case 25 :
                // InternalAssembler.g:1:168: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 26 :
                // InternalAssembler.g:1:180: RULE_CHARACTER
                {
                mRULE_CHARACTER(); 

                }
                break;
            case 27 :
                // InternalAssembler.g:1:195: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 28 :
                // InternalAssembler.g:1:207: RULE_ANY_EXCEPT_COMMENT_END_OF_LINE
                {
                mRULE_ANY_EXCEPT_COMMENT_END_OF_LINE(); 

                }
                break;
            case 29 :
                // InternalAssembler.g:1:243: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 30 :
                // InternalAssembler.g:1:251: RULE_CR
                {
                mRULE_CR(); 

                }
                break;
            case 31 :
                // InternalAssembler.g:1:259: RULE_END_OF_FILE
                {
                mRULE_END_OF_FILE(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\35\7\uffff\1\36\3\uffff\4\23\5\uffff\1\27\11\uffff\6\23\1\uffff\1\54\1\55\1\56\1\57\1\60\1\61\6\uffff";
    static final String DFA11_eofS =
        "\62\uffff";
    static final String DFA11_minS =
        "\1\11\7\uffff\1\101\3\uffff\1\103\1\115\1\116\1\122\5\uffff\1\142\11\uffff\3\102\1\104\1\125\1\107\1\uffff\6\60\6\uffff";
    static final String DFA11_maxS =
        "\1\174\7\uffff\1\172\3\uffff\1\104\1\115\1\121\1\122\5\uffff\1\142\11\uffff\3\102\1\104\1\125\1\107\1\uffff\6\172\6\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\11\1\12\1\13\4\uffff\1\22\1\23\1\24\1\25\1\26\1\uffff\1\30\1\27\1\32\1\33\1\34\1\35\1\36\1\37\1\10\6\uffff\1\31\6\uffff\1\14\1\15\1\16\1\17\1\21\1\20";
    static final String DFA11_specialS =
        "\62\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\33\1\34\2\uffff\1\34\22\uffff\1\33\1\11\1\31\1\uffff\1\24\1\22\1\6\1\30\1\12\1\13\1\20\1\2\1\1\1\3\1\uffff\1\21\1\25\11\27\1\uffff\1\32\1\4\1\uffff\1\5\1\uffff\1\26\4\23\1\16\1\14\10\23\1\17\2\23\1\15\10\23\3\uffff\1\10\1\23\1\uffff\32\23\1\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "",
            "",
            "\1\40\1\37",
            "\1\41",
            "\1\42\2\uffff\1\43",
            "\1\44",
            "",
            "",
            "",
            "",
            "",
            "\1\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | RULE_ID | RULE_HEXA | RULE_INT | RULE_OCTAL | RULE_BINARY | RULE_CHARACTER | RULE_STRING | RULE_ANY_EXCEPT_COMMENT_END_OF_LINE | RULE_WS | RULE_CR | RULE_END_OF_FILE );";
        }
    }
 

}
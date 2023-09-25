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

    public InternalAssemblerLexer() {;} 
    public InternalAssemblerLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalAssemblerLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalAssembler.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:11:7: ( 'EQU' )
            // InternalAssembler.g:11:9: 'EQU'
            {
            match("EQU"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:13:7: ( '*' )
            // InternalAssembler.g:13:9: '*'
            {
            match('*'); 

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
            // InternalAssembler.g:14:7: ( '/' )
            // InternalAssembler.g:14:9: '/'
            {
            match('/'); 

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
            // InternalAssembler.g:15:7: ( '-' )
            // InternalAssembler.g:15:9: '-'
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
            // InternalAssembler.g:16:7: ( '(' )
            // InternalAssembler.g:16:9: '('
            {
            match('('); 

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
            // InternalAssembler.g:17:7: ( ')' )
            // InternalAssembler.g:17:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "RULE_HEXADECIMAL"
    public final void mRULE_HEXADECIMAL() throws RecognitionException {
        try {
            int _type = RULE_HEXADECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:2474:18: ( '$' ( 'A' .. 'F' | '0' .. '9' )+ )
            // InternalAssembler.g:2474:20: '$' ( 'A' .. 'F' | '0' .. '9' )+
            {
            match('$'); 
            // InternalAssembler.g:2474:24: ( 'A' .. 'F' | '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAssembler.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEXADECIMAL"

    // $ANTLR start "RULE_BINARY"
    public final void mRULE_BINARY() throws RecognitionException {
        try {
            int _type = RULE_BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:2476:13: ( '%' ( '0' .. '1' )+ )
            // InternalAssembler.g:2476:15: '%' ( '0' .. '1' )+
            {
            match('%'); 
            // InternalAssembler.g:2476:19: ( '0' .. '1' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='1')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAssembler.g:2476:20: '0' .. '1'
            	    {
            	    matchRange('0','1'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINARY"

    // $ANTLR start "RULE_DECIMAL"
    public final void mRULE_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:2478:14: ( ( '0' .. '9' )+ )
            // InternalAssembler.g:2478:16: ( '0' .. '9' )+
            {
            // InternalAssembler.g:2478:16: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAssembler.g:2478:17: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_DECIMAL"

    // $ANTLR start "RULE_ASCII"
    public final void mRULE_ASCII() throws RecognitionException {
        try {
            int _type = RULE_ASCII;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:2480:12: ( '\\'' ( . )+ ( RULE_WS | RULE_CR | '\\'' ) )
            // InternalAssembler.g:2480:14: '\\'' ( . )+ ( RULE_WS | RULE_CR | '\\'' )
            {
            match('\''); 
            // InternalAssembler.g:2480:19: ( . )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=2;
                }
                else if ( (LA4_0=='\r') ) {
                    alt4=2;
                }
                else if ( (LA4_0=='\n') ) {
                    alt4=2;
                }
                else if ( (LA4_0=='\'') ) {
                    alt4=2;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='\b')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\u001F')||(LA4_0>='!' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAssembler.g:2480:19: .
            	    {
            	    matchAny(); 

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

            // InternalAssembler.g:2480:22: ( RULE_WS | RULE_CR | '\\'' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case '\t':
            case ' ':
                {
                alt5=1;
                }
                break;
            case '\n':
            case '\r':
                {
                alt5=2;
                }
                break;
            case '\'':
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalAssembler.g:2480:23: RULE_WS
                    {
                    mRULE_WS(); 

                    }
                    break;
                case 2 :
                    // InternalAssembler.g:2480:31: RULE_CR
                    {
                    mRULE_CR(); 

                    }
                    break;
                case 3 :
                    // InternalAssembler.g:2480:39: '\\''
                    {
                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASCII"

    // $ANTLR start "RULE_OCTAL"
    public final void mRULE_OCTAL() throws RecognitionException {
        try {
            int _type = RULE_OCTAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:2482:12: ( '@' ( '0' .. '7' )+ )
            // InternalAssembler.g:2482:14: '@' ( '0' .. '7' )+
            {
            match('@'); 
            // InternalAssembler.g:2482:18: ( '0' .. '7' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='7')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalAssembler.g:2482:19: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

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
    // $ANTLR end "RULE_OCTAL"

    // $ANTLR start "RULE_LABEL"
    public final void mRULE_LABEL() throws RecognitionException {
        try {
            int _type = RULE_LABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:2484:12: ( 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' | '@' )+ )
            // InternalAssembler.g:2484:14: 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' | '@' )+
            {
            matchRange('A','Z'); 
            // InternalAssembler.g:2484:23: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' | '@' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='.'||(LA7_0>='0' && LA7_0<='9')||(LA7_0>='@' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAssembler.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
    // $ANTLR end "RULE_LABEL"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAssembler.g:2486:17: ( ';' ( . )* RULE_CR )
            // InternalAssembler.g:2486:19: ';' ( . )* RULE_CR
            {
            match(';'); 
            // InternalAssembler.g:2486:23: ( . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\r') ) {
                    alt8=2;
                }
                else if ( (LA8_0=='\n') ) {
                    alt8=2;
                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalAssembler.g:2486:23: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
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
            // InternalAssembler.g:2488:9: ( ( '\\r' )? '\\n' )
            // InternalAssembler.g:2488:11: ( '\\r' )? '\\n'
            {
            // InternalAssembler.g:2488:11: ( '\\r' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssembler.g:2488:11: '\\r'
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
            // InternalAssembler.g:2490:9: ( ( ' ' | '\\t' )+ )
            // InternalAssembler.g:2490:11: ( ' ' | '\\t' )+
            {
            // InternalAssembler.g:2490:11: ( ' ' | '\\t' )+
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

    public void mTokens() throws RecognitionException {
        // InternalAssembler.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | RULE_HEXADECIMAL | RULE_BINARY | RULE_DECIMAL | RULE_ASCII | RULE_OCTAL | RULE_LABEL | RULE_SL_COMMENT | RULE_CR | RULE_WS )
        int alt11=16;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // InternalAssembler.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalAssembler.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalAssembler.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalAssembler.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalAssembler.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalAssembler.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalAssembler.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalAssembler.g:1:52: RULE_HEXADECIMAL
                {
                mRULE_HEXADECIMAL(); 

                }
                break;
            case 9 :
                // InternalAssembler.g:1:69: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 10 :
                // InternalAssembler.g:1:81: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 11 :
                // InternalAssembler.g:1:94: RULE_ASCII
                {
                mRULE_ASCII(); 

                }
                break;
            case 12 :
                // InternalAssembler.g:1:105: RULE_OCTAL
                {
                mRULE_OCTAL(); 

                }
                break;
            case 13 :
                // InternalAssembler.g:1:116: RULE_LABEL
                {
                mRULE_LABEL(); 

                }
                break;
            case 14 :
                // InternalAssembler.g:1:127: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 15 :
                // InternalAssembler.g:1:143: RULE_CR
                {
                mRULE_CR(); 

                }
                break;
            case 16 :
                // InternalAssembler.g:1:151: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\21\uffff\1\15\1\23\1\uffff";
    static final String DFA11_eofS =
        "\24\uffff";
    static final String DFA11_minS =
        "\1\11\1\56\17\uffff\1\125\1\56\1\uffff";
    static final String DFA11_maxS =
        "\1\132\1\172\17\uffff\1\125\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\2\uffff\1\1";
    static final String DFA11_specialS =
        "\24\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\20\1\17\2\uffff\1\17\22\uffff\1\20\3\uffff\1\10\1\11\1\uffff\1\13\1\6\1\7\1\3\1\2\1\uffff\1\5\1\uffff\1\4\12\12\1\uffff\1\16\4\uffff\1\14\4\15\1\1\25\15",
            "\1\15\1\uffff\12\15\6\uffff\21\15\1\21\11\15\4\uffff\1\15\1\uffff\32\15",
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
            "",
            "",
            "",
            "\1\22",
            "\1\15\1\uffff\12\15\6\uffff\33\15\4\uffff\1\15\1\uffff\32\15",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | RULE_HEXADECIMAL | RULE_BINARY | RULE_DECIMAL | RULE_ASCII | RULE_OCTAL | RULE_LABEL | RULE_SL_COMMENT | RULE_CR | RULE_WS );";
        }
    }
 

}
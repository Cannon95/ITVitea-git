import tokens.PrimitiveToken;
import tokens.Token;

import java.util.ArrayList;
import java.util.List;

public class TokenList {

    //primitives
    List<Token> Tokens = new ArrayList<>();
    Tokens.ad


    public void tokenCollector(){
        Tokens.add(new PrimitiveToken("Value","val"));
        Tokens.add(new PrimitiveToken("Measured Value","mea"));
        Tokens.add(new PrimitiveToken("Variable","var"));
        Tokens.add(new PrimitiveToken("String","string"));
        Tokens.add(new Token("Space"," "));
        Tokens.add(new Token("Print Start","["));
        Tokens.add(new Token("Print End","]"));
        Tokens.add(new Token("Var Start",">"));
        Tokens.add(new Token("Var End","<"));
        Tokens.add(new Token("Comma",","));
        Tokens.add(new Token("function1", "("));
        Tokens.add(new Token("function2", ")"));
    }







}

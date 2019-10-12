package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {

    private List<STATEMENT> statements;

    @Override
    public void parse() {
        while (!tokenizer.checkToken("NO_MORE_TOKENS")) {
            STATEMENT s = null;
            if (tokenizer.checkToken("expression")) {
                s = new EXPRESSION();
            } else if (tokenizer.checkToken("test strings with")) {
                s = new TEST();
            } else if (tokenizer.checkToken("{")) {
                // s = new TEST();
            } else if (tokenizer.checkToken("}")) {
                // s = new TEST();
            } else if (tokenizer.checkToken("starts with")) {
                // s = new TEST();
            } else if (tokenizer.checkToken("ends with")) {
                // s = new TEST();
            } else if (tokenizer.checkToken("or more of")) {
                // s = new TEST();
            } else if (tokenizer.checkToken("character")) {
                // s = new TEST();
            } else if (tokenizer.checkToken("digit")) {
                // s = new TEST();
            } else if (tokenizer.checkToken("from")) {
                // s = new TEST();
            } else if (tokenizer.checkToken("to")) {
                // s = new TEST();
            }

            s.parse();
            statements.add(s);
        }
    }

    public void nameCheck(){
        for (STATEMENT s : statements){
            s.nameCheck();
        }
    }

    @Override
    public void typeCheck() {
        for (STATEMENT s : statements){
            s.typeCheck();
        }
    }

    @Override
    public String evaluate() {
        for (STATEMENT s : statements){
            s.evaluate();
        }
        return "";
    }
}

package ast;

public class CHARDEF extends KEYWORD {

    @Override
    public void parse(){
        tokenizer.getAndCheckNext("character");
    }

    @Override
    public void nameCheck() {

    }

    @Override
    public void typeCheck() {

    }

    @Override
    public String evaluate() {
        return null;
    }
}
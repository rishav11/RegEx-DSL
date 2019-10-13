package ast;

public class DIGITDEF extends KEYWORD {

    @Override
    public void parse(){
        tokenizer.getAndCheckNext("digit");
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
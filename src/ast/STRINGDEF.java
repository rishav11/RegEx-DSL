package ast;

public class STRINGDEF extends KEYWORD {
    private String str;
    @Override
    public void parse(){
        str = tokenizer.getNext();
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

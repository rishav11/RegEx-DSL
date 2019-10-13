package ast;

public class CHARDEF extends KEYWORD {
    private CHARCONSTRAINT c;
    @Override
    public void parse(){
        tokenizer.getAndCheckNext("character");
        if (tokenizer.checkToken("from")) {
            c = new CHARCONSTRAINT();
            c.parse();
        }
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
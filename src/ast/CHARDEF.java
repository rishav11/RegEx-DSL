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
        if (c == null) {
//            writer.print("a-zA-Z");
            return "a-zA-Z";
        } else {
            return c.evaluate();
        }

//        return null;
    }
}
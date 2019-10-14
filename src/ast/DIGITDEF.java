package ast;

public class DIGITDEF extends KEYWORD {
    private DIGITCONSTRAINT d;
    @Override
    public void parse(){
        tokenizer.getAndCheckNext("digit");
        if (tokenizer.checkToken("from")) {
            d = new DIGITCONSTRAINT();
            d.parse();
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
        if (d == null) {
//            writer.print("0-9");
            return "0-9";
        } else {
            return d.evaluate();
        }

//        return null;
    }
}
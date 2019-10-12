package ast;

/**
 * Created by Rishav on 2019-10-11.
 */
public class RULE extends STATEMENT {

    private ANCHOR anchor;
    private QUANTIFIER quantifier;
    private KEYWORD keyword;

    @Override
    public void parse(){
        // NO anchor
        if (!tokenizer.checkToken("[0-9]+")) {
            anchor = new ANCHOR();
            anchor.parse();
        }
        quantifier = new QUANTIFIER();
        quantifier.parse();
        tokenizer.getAndCheckNext(":");
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

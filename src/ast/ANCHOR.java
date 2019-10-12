package ast;

/**
 * Created by Rishav on 2019-10-11.
 */
public class ANCHOR extends STATEMENT {

    private String anchor;

    @Override
    public void parse(){
        anchor = tokenizer.getNext();
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

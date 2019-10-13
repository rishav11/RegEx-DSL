package ast;

import java.util.ArrayList;

/**
 * Created by Rishav on 2019-10-11.
 */
public class RULE extends STATEMENT {

    private ANCHOR anchor;
    private QUANTIFIER quantifier;
    private ArrayList<KEYWORD> keywords = new ArrayList<>();

    @Override
    public void parse(){
        // check if it has anchor, if yes
        if (!tokenizer.checkToken("[0-9]+")) {
            anchor = new ANCHOR();
            anchor.parse();
        }
        quantifier = new QUANTIFIER();
        quantifier.parse();
        tokenizer.getAndCheckNext(":");
        while (!tokenizer.checkToken(",")) {
            if (tokenizer.checkToken("\\}")) break;
            if (!tokenizer.checkToken("or")) {
                KEYWORD keyword = new KEYWORD();
                keyword.parse();
                keywords.add(keyword);
            }
            if (tokenizer.checkToken("or")) {
                tokenizer.getNext();
            }
        }
        if (!tokenizer.checkToken("\\}")) {
            tokenizer.getNext();
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
//        String anchorRegEx = anchor.evaluate();
//        if (anchorRegEx.equals("^")) writer.print("^");
        writer.print("[");
        for (KEYWORD k : keywords) {
            k.evaluate();
        }
        writer.print("]");
        quantifier.evaluate();
//        if (anchorRegEx.equals("$")) writer.print("$");
        return "";
    }

}

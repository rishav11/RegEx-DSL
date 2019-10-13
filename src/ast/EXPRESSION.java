package ast;

import java.util.ArrayList;

/**
 * Created by Rishav on 2019-10-11.
 */
public class EXPRESSION extends STATEMENT {

    private String name;
    private ArrayList<RULE> rules = new ArrayList<>();

    @Override
    public void parse(){
        tokenizer.getAndCheckNext("expression");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("\\{");
        while (!tokenizer.checkToken("\\}")) {
            RULE rule = new RULE();
            rule.parse();
            rules.add(rule);
        }
        tokenizer.getAndCheckNext("\\}");
    }

    @Override
    public void nameCheck() {

    }

    @Override
    public void typeCheck() {

    }

    @Override
    public String evaluate() {
        writer.print(name + ": ");
        for (RULE s : rules){
            s.evaluate();
        }
        writer.print("\n");
        return "";
    }
}

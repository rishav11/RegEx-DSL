package ast;

import java.util.ArrayList;
import java.util.List;

public class CHARCONSTRAINT extends CHARDEF {
    private List<String> chars = new ArrayList<>();

    @Override
    public void parse(){
        tokenizer.getAndCheckNext("from");
        chars.add(tokenizer.getNext());
        tokenizer.getAndCheckNext("to");
        chars.add(tokenizer.getNext());
        while (tokenizer.checkToken("and")) {
            tokenizer.getAndCheckNext("and");
            chars.add(tokenizer.getNext());
            tokenizer.getAndCheckNext("to");
            chars.add(tokenizer.getNext());
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
        for (int i=0; i<chars.size(); i++) {
            writer.print(chars.get(i));
            if (i%2 == 0) {
                writer.print("-");
            }
        }
        return null;
    }
}

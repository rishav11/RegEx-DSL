package ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rishav on 2019-10-11.
 */
public class KEYWORD extends STATEMENT {
    private KEYWORD k;

    @Override
    public void parse(){
        if (tokenizer.checkToken("character")) {
            k = new CHARDEF();
        } else if (tokenizer.checkToken("digit")) {
            k = new DIGITDEF();
        } else {
            k = new STRINGDEF();
        }
        k.parse();
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

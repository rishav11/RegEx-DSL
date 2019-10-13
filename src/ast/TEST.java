package ast;

import libs.NameCheckException;
import libs.Node;

import java.util.ArrayList;

/**
 * Created by Rishav on 2019-10-11.
 */
public class TEST extends STATEMENT {

    private String name ;
    private ArrayList<String> tests =  new ArrayList<>();

    @Override
    public void parse(){
        tokenizer.getAndCheckNext("test") ;
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("with");
        tokenizer.getAndCheckNext("\\{");
        while(!tokenizer.checkToken("\\}")){
            String test = tokenizer.getNext();
            if (tokenizer.checkToken(",")) {
                tokenizer.getAndCheckNext(",");
            }
        }
        tokenizer.getAndCheckNext("\\}");
    }

    @Override
    public void nameCheck() {
        if(!Node.names.contains(name)){
            throw new NameCheckException(name) ;
        }
    }

    @Override
    public void typeCheck() {

    }

    @Override
    public String evaluate() {
        return null;
    }
}

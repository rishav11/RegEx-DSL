package ast;

import libs.NameCheckException;
import libs.Node;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
            tests.add(test) ;
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
        writer.println("Tests for " + name);
        for(String test : tests) {
            Boolean isMatch = Pattern.matches(Node.outputs.get(name), test.replaceAll("\"", ""));
            writer.print(test + ": ") ;
            if (isMatch) {
                writer.println("MATCHED");
            } else {
                writer.println("DID NOT MATCH");
            }
        }
        return "" ;
    }
}

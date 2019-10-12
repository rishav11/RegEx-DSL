package ast;

/**
 * Created by Rishav on 2019-10-11.
 */
public class EXPRESSION extends STATEMENT {

    private String name;
    private RULE codeblock ;

    @Override
    public void parse(){
        tokenizer.getAndCheckNext("newexpressioncalled");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("{");
        codeblock = new RULE();
        codeblock.parse();
        tokenizer.getAndCheckNext("}");
    }

    @Override
    public String evaluate() {
        return super.evaluate();
    }
}

package ast;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.ArrayList;

/**
 * Created by Rishav on 2019-10-11.
 */
public class QUANTIFIER extends STATEMENT {

    private int digit;
    private boolean isExactly;
    private ArrayList<Integer> ordigits;

    @Override
    public void parse() {
        String d = tokenizer.getNext();
        digit = Integer.parseInt(d);
        String exact = tokenizer.getNext();
        if (exact == "of") {
            isExactly = true;
        } else if (exact == "ormoreof") {
            isExactly = false;
        } else if (exact == "or") {
            while (!tokenizer.checkToken("of")) {
                tokenizer.getNext();
                ordigits.add(Integer.parseInt(tokenizer.getNext()));

            }

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
        return null;
    }
}

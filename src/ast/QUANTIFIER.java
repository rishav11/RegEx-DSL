package ast;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.ArrayList;

/**
 * Created by Rishav on 2019-10-11.
 */

public class QUANTIFIER extends STATEMENT {

    private int digit;
    private int isExactly;
    private ArrayList<Integer> ordigits;

    @Override
    public void parse() {
        String d = tokenizer.getNext();
        digit = Integer.parseInt(d);
        String exact = tokenizer.getNext();
        if (exact == "of") {
            isExactly = 0;
        } else if (exact == "ormoreof") {
            isExactly = 1;
        } else if (exact == "to") {
            isExactly = 2 ;
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

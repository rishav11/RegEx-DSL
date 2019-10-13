package ast;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.ArrayList;

/**
 * Created by Rishav on 2019-10-11.
 */

public class QUANTIFIER extends STATEMENT {

    private int digit;
    private int toDigit;
    private int isExactly;

    @Override
    public void parse() {
        String d = tokenizer.getNext();
        digit = Integer.parseInt(d);
        String exact = tokenizer.getNext();
        if (exact.equals("of")) {
            isExactly = 0;
        } else if (exact.equals("ormoreof")) {
            isExactly = 1;
        } else if (exact.equals("to")) {
            isExactly = 2 ;
            toDigit = Integer.parseInt(tokenizer.getNext());
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
        if (isExactly == 0) {
            if (digit != 1) {
                writer.print("{" + digit + "}");
            }
        } else if (isExactly == 1) {
            if (digit == 0) {
                writer.print("*");
            } else if (digit == 1) {
                writer.print("+");
            } else {
                writer.print("{" + digit + ",}");
            }
        } else if (isExactly == 2) {
            if (digit == 0 && toDigit == 1) {
                writer.print("?");
            } else {
                writer.print("{" + digit + "," + toDigit + "}");
            }
        }

        return null;
    }
}

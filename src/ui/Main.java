package ui;

import ast.PROGRAM;
import libs.Node;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> literals = Arrays.asList("new expression called", "test strings with", "{", "}", "starts with", "ends with", "or more of", "character", "digit", "from", "and", "to");
        Tokenizer.makeTokenizer("input.super",literals);
        Node.setWriter("output.txt");
        Node program = new PROGRAM();
        program.parse();
        // program.nameCheck();
        // program.typeCheck();
        // program.evaluate();
        Node.closeWriter();
    }

}

package ast;

public class STRINGDEF extends KEYWORD {
    private String str;
    @Override
    public void parse(){
        str = tokenizer.getNext();
    }

    @Override
    public void nameCheck() {

    }

    @Override
    public void typeCheck() {

    }

    @Override
    public String evaluate() {
        String sanitizedString = str.replaceAll("\"", "");
        if (sanitizedString.length() == 1) {
//            writer.print(sanitizedString);
            return sanitizedString;
        } else {
//            writer.print(sanitizedString);
            return sanitizedString;
        }

//        return null;
    }
}

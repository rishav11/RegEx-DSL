# SuperRex DSL
### A small language that helps you write regular expressions

## Grammar
```
PROGRAM ::= STATEMENT+
STATEMENT ::= EXPRESSION (EXPRESSION | TEST)*

TEST ::= 'test' STRING 'with' '{' STRING ( ',' STRING )* '}'

EXPRESSION ::= 'expression' STRING '{' RULE ( ',' RULE )* '}'
RULE ::= ANCHOR? QUANTIFIER ':' KEYWORD ( 'or' KEYWORD )*
ANCHOR ::= 'starts with' | 'ends with'
QUANTIFIER ::= DIGIT ( 'or more' | 'to' DIGIT )? 'of'
KEYWORD ::= CHARDEF | DIGITDEF | STRING | 'any' | 'non-digit' | 'whitespace' | 'non-whitespace' | 'newline' | 'tab'
CHARDEF ::= 'character' CHARCONSTRAINT?
CHARCONSTRAINT ::= 'from' CHAR 'to' CHAR ( 'and' CHAR 'to' CHAR )*
CHAR ::= [a-zA-Z]
DIGITDEF ::= 'digit' DIGITCONSTRAINT?
DIGITCONSTRAINT ::= 'from' DIGIT 'to' DIGIT ( 'and' DIGIT 'to' DIGIT )*
DIGIT ::= [0-9]
```

## Code Snippets
```
expression emailRegEx {
    starts with 1 or more of: character or digit or "_" or "." or "-",
    1 of: "@",
    1 or more of: character or digit or "." or "-",
    1 of: ".",
    ends with 2 or more of: character
}

expression phoneNumberRegEx {
    starts with 3 of: digit,
    1 of: "-",
    3 of: digit,
    1 of: "-",
    ends with 4 of: digit
}

test emailRegEx with {
    "vinielk@icloud.com",
    "notvalidemail@.com"
}

test phoneNumberRegEx with {
    "     778-994-1393",
    "7789941393",
    "(778) 994-1393",
    "778-994-1393       ",
    "778-994-1393"
}
```
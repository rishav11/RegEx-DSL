# SuperRex DSL
### A small language that helps you write regular expressions

## Grammar
```bst
PROGRAM ::= STATEMENT+
STATEMENT ::= EXPRESSION (EXPRESSION | TEST)*
EXPRESSION ::= "new expression called" STRING "{" RULE* "}"
TEST ::= "test strings with" STRING "{" STRING (STRING",")* "}" 
RULE ::= ANCHOR? QUANTIFIER ":" KEYWORD
ANCHOR ::= "starts with" | "ends with"
QUANTIFIER ::= DIGIT "of" | DIGIT "or more of" | DIGIT ORDIGIT* "of"
KEYWORD ::= CHARACTER-DEF | DIGIT-DEF | NON-DIGIT | NON-WHITESPACE | NEWLINE | RETURN | TAB

CHARACTER-DEF ::= "character" CHARACTER-CONSTRAINT?
CHARACTER-CONSTRAINT ::= FROM-CHAR | FROM-CHAR AND-CHAR*
FROM-CHAR ::= "from" CHAR "to" CHAR
AND-CHAR ::= "and" CHAR "to" CHAR

DIGIT-DEF ::= "digit" DIGIT-CONSTRAINT?
DIGIT-CONSTRAINT ::= FROM-DIGIT | FROM-DIGIT AND-DIGIT*
FROM-DIGIT ::= "from" DIGIT "to" DIGIT
AND-DIGIT ::= "and" DIGIT "to" DIGIT

CHAR ::= [a-Z]
DIGIT ::= [0-9]
ORDIGIT ::= "or" DIGIT
NON-DIGIT ::= [^0-9]
NON-WHITESPACE ::= "\s"
NEWLINE ::= "\n"
RETURN ::= "\r"
TAB ::= "\t"

```
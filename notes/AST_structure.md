# AST Structure

## Node types

| Node class              | Superclass          | Relevant grammar rule | Children
|-------------------------|---------------------|-----------------------|:---------------------------------------------:
| `AstNode` (A)           |                     |                       | —
| `Statement` (A)         | `AstNode`           | `statement`           | —
| `Expression` (A)        | `AstNode`           | `expression`          | —
| `Program`               | `AstNode`           | `program`             | `statements: List<Statement>` (Ariana)
| `Assignment`            | `AstNode`           |                       | `value: Expression` (Stephanie)
| `FunctionDefinition`    | `Statement`         | `functionDefinition`  | `body: Expression`
| `PrintStatement`        | `Statement`         | `print`               | `items: List<Item>` (Rachel)
| `InputStatement`        | `Statement`         | `input`               | `items: List<Item>` (Braxden)
| `IfStatement`           | `Statement`         | `ifStatement`         | `cond: BooleanExpression; trueStatement: Statement; falseStatement Statement;`
| `WhileLoop`             | `Statement`         | `whileLoop`           | `cond: BooleanExpression` (Ava)
| `NumberExpression`      | `Expression`        | `#numberExpr`         | —
| `VariableExpression`    | `Expression`        | `#variableExpr`       | —
| `BinaryOpExpression`    | `Expression`        | `#binaryOpExpr`       | `left: Expression; right: Expression` (Sanskriti)
| `NegateExpression`      | `Expression`        | `#negateExpr`         | `args: List<Expression>` (Jake)
| `FunctionCallExpression`| `Expression`        | `#funcCallExpr`       | ―
| `BooleanExpression` (A) | `Expression`        | `booleanExpression`   | —
| `Item`                  | `AstNode`           | `item`                | `expr: Expression` (or a `String`) (John)
| `NotBoolExpression`     | `BooleanExpression` | `#notBool`            | `expr: BooleanExpression`
| `BinaryBoolOpExpression`| `BooleanExpression` | `#binaryBoolOp`       | `left: BooleanExpression; right: BooleanExpression` (Juliano)
| `BinaryBoolExpression`  | `BooleanExpression` | `binaryBoolExpr`      | `left: BooleanExpression; right: BooleanExpression` 
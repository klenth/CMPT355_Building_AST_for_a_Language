# AST Structure

## Node types

| Node class              | Superclass          | Relevant grammar rule | Children
|-------------------------|---------------------|-----------------------|:---------------------------------------------:
| `AstNode` (A)           |                     |                       | —
| `Statement` (A)         | `AstNode`           | `statement`           | —
| `Expression` (A)        | `AstNode`           | `expression`          | —
| `Program`               | `AstNode`           | `program`             | `statements: List<Statement>` (Ariana)
| `Assignment`            | `Statement`         | `assignment`          | `value: Expression` (Stephanie)
| `FunctionDefinition`    | `Statement`         | `functionDefinition`  | `body: Expression` (Kathy)
| `PrintStatement`        | `Statement`         | `print`               | `items: List<Item>`  (Rachel)
| `InputStatement`        | `Statement`         | `input`               | `items: List<Item>` (Braxden)
| `IfStatement`           | `Statement`         | `ifStatement`         | `cond: BooleanExpression; trueStmt: Statement; falseStmt: Statement (optional)` (Kathy)
| `WhileLoop`             | `Statement`         | `whileLoop`           | `cond: BooleanExpression: body: Statement` (Ava)
| `NumberExpression`      | `Expression`        | `#numberExpr`         | — (Kathy)
| `VariableExpression`    | `Expression`        | `#variableExpr`       | — (Ava)
| `BinaryOpExpression`    | `Expression`        | `#binaryOpExpr`       | `left: Expression; right: Expression` (Sanskriti)
| `NegateExpression`      | `Expression`        | `#negateExpr`         | `expr: Expression` (Ariana)
| `FunctionCallExpression`| `Expression`        | `#funcCallExpr`       | `args: List<Expression>` (Jake)
| `BooleanExpression` (A) |                     | `booleanExpression`   | — (Kathy)
| `Item`                  | `AstNode`           | `item`                | `expr: Expression` (or a `String`) (John)
| `NotBoolExpression`     | `BooleanExpression` | `#notBool`            | `expr: BooleanExpression` (Kathy)
| `BinaryBoolOpExpression`| `BooleanExpression` | `#binaryBoolOp`       | `left: BooleanExpression; right: BooleanExpression` (Juliano)
| `BinaryBoolExpression`  | `BooleanExpression` | `#binaryBoolExpr`     | `left: Expression; right: Expression` (Kathy)

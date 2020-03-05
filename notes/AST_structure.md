# AST Structure

## Node types

| Node class              | Superclass          | Relevant grammar rule | Children
|-------------------------|---------------------|-----------------------|:---------------------------------------------:
| `AstNode` (A)           |                     |                       | —
| `Statement` (A)         | `AstNode`           | `statement`           | —
| `Expression` (A)        | `AstNode`           | `expression`          | —
| `Program`               | `AstNode`           | `program`             | `statements: List<Statement>`
| `Assignment`            | `Statement`         | `assignment`          | `id: String; value: Expression`
| `FunctionDefinition`    | `Statement`         | `functionDefinition`  | `body: Expression`
| `PrintStatement`        | `Statement`         | `print`               | `items: List<Item>`
| `InputStatement`        | `Statement`         | `input`               | `items: List<Item>`
| `IfStatement`           | `Statement`         | `ifStatement`         | `cond: BooleanExpression; trueStmt: Statement; falseStmt: Statement (optional)`
| `WhileLoop`             | `Statement`         | `whileLoop`           | `cond: BooleanExpression; body: Statement`
| `NumberExpression`      | `Expression`        | `#numberExpr`         | —
| `VariableExpression`    | `Expression`        | `#variableExpr`       | —
| `BinaryOpExpression`    | `Expression`        | `#binaryOpExpr`       | `left: Expression; right: Expression`
| `NegateExpression`      | `Expression`        | `#negateExpr`         | `expr: Expression`
| `FunctionCallExpression`| `Expression`        | `#funcCallExpr`       | `args: List<Expression>`
| `BooleanExpression` (A) | `AstNode`           | `booleanExpression`   | —
| `Item`                  | `AstNode`           | `item`                | `expr: Expression` (or a `String`)
| `NotBoolExpression`     | `BooleanExpression` | `#notBool`            | `expr: BooleanExpression`
| `BinaryBoolOpExpression`| `BooleanExpression` | `#binaryBoolOp`       | `left: BooleanExpression; right: BooleanExpression`
| `BinaryBoolExpression`  | `BooleanExpression` | `#binaryBoolExpr`     | `left: Expression; right: Expression`
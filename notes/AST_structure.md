# AST Structure

## Node types

### General nodes
| Node class         | Superclass          | Relevant grammar rule |
|--------------------|---------------------|-----------------------|
| `AstNode`          |                     |                       |
| `Statement`        | `AstNode`           | `statement`           |
| `Expression`       | `AstNode`           | `expression`          |
| `Program`          |                     | `program`             |
| `Assignment`       |                     |                       |
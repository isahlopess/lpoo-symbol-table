# Symbol Table Engine (Java OOP)

An object-oriented **Symbol Table** implementation for a simplified Java compiler, built to model lexical scoping, symbol hierarchies, and upward scope resolution.

---

## 🧱 Architecture & Packages

1. **`simbolos` (Symbols):**
   - Defines the base `Symbol` abstraction with identifiers and access modifiers.
   - Derived classes: `VariableSymbol`, `ClassSymbol`, `MethodSymbol`, and `ConstructorSymbol`.
   - Classes and methods act as both symbols and scopes by implementing the internal scope contract.

2. **`escopos` (Scopes):**
   - Defines the `Scope` interface (symbol definition and resolution contract) along with `GlobalScope` and `BlockScope` implementations.
   - Uses `TreeMap` (implementing Java's `Map` interface) for internal symbol storage across scopes.

3. **Core Engine (`SymbolTable.java`):**
   - Manages entering (`pushScope`) and exiting (`popScope`) blocks while tracking `currentScope`.
   - Implements recursive upward resolution in `resolve`: searches the current scope first and delegates to the enclosing parent scope up to the global scope, with support for qualified lookups.

4. **Test Driver (`Main.java`):**
   - Simulates compiler/parser calls by registering classes, methods, and variables, validating symbol resolution across nested hierarchical scopes via console output.

---

## 🛠️ Tech Stack

- **Language:** Java (Object-Oriented Programming)
- **Concepts:** Symbol Tables, Lexical Scoping, Interfaces, Inheritance, `TreeMap`

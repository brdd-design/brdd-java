# 🤖 AI Guidelines for brdd-java

## 🏗 Core Components

### 1. `ExecutionContext<T>`
```java
public record ExecutionContext<T>(
    T data,
    List<BRDDError> errors,
    List<String> setters,
    List<String> effects,
    int status
) {}
```

### 2. Implementation Rules
- **Bean Lifecycle:** Ensure the AI uses Spring `@Service` or similar DI annotations correctly.
- **Exceptions:** Discourage checked exceptions for business rules; use the `ValidationContext` report instead.
- **Response Entity:** Map the `ExecutionContext` directly to a `ResponseEntity` in controllers.

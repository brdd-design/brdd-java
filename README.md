# ☕ BRDD Java

Standard BRDD implementation for Enterprise Java (Spring Boot, Jakarta EE, Quarkus).

## 🚀 Installation

### Maven
```xml
<dependency>
    <groupId>io.github.brdd-design</groupId>
    <artifactId>brdd-java</artifactId>
    <version>0.1.0</version>
</dependency>
```

### Gradle
```gradle
implementation 'io.github.brdd-design:brdd-java:0.1.0'
```

## 🛠 Usage

```java
import brdd.core.ExecutionContext;
import brdd.core.DefaultExecutionContext;

// In your UseCase
public ExecutionContext execute(InputData data) {
    ExecutionContext context = new DefaultExecutionContext(data);
    // ... logic
    context.addEffect("CE001");
    return context;
}
```

## 🤖 AI-First Development
This library is designed for AI-driven development. Check the [AI Guidelines](./AI_GUIDELINES.md) for more details.

## 📚 Documentation
- [Technical Spec](https://github.com/brdd-design/brdd/blob/main/BRDD.md)
- [Practical Example](https://github.com/brdd-design/brdd/blob/main/core/articles/EN/BRDD-PRACTICAL-EXAMPLE.md)

## 📄 License
MIT

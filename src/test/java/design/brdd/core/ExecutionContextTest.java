package design.brdd.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExecutionContextTest {

    @Test
    void testExecutionContextFlow() {
        ValidationContext vCtx = ValidationContext.build();
        ExecutionContext<String> ctx = ExecutionContext.build("US001", vCtx);

        assertFalse(ctx.hasErrors());
        assertEquals("US001", ctx.getUseCaseCode());

        // Test Setters
        ctx.addSetter("SET_USER_ID", 123L);
        assertEquals(123L, ctx.getSetters().get("SET_USER_ID"));

        // Test Effects
        ctx.addEffect(ExecutionContext.POST_EFFECT, "EFF_SEND_MAIL", () -> System.out.println("Email sent"));
        assertEquals(1, ctx.getEffects().size());
        assertEquals("EFF_SEND_MAIL", ctx.getEffects().get(0).code());

        // Test Data
        ctx.setData("Success Result");
        assertEquals("Success Result", ctx.getData());
    }

    @Test
    void testValidationContextErrors() {
        ValidationContext vCtx = ValidationContext.build();
        vCtx.addError("ERR01", "Validation failed");

        assertTrue(vCtx.hasErrors());
        assertEquals(1, vCtx.getErrors().size());
        assertEquals("ERR01", vCtx.getErrors().get(0).code());
    }
}

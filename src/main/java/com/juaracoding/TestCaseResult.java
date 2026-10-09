package com.juaracoding;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestCaseResult {
    // 1. Instance Fields
    private String testId;
    private String scenarioName;
    private String module;
    private String status; // PASS, FAIL, SKIP
    private long executionDurationMs;
    private String errorMessage;
    private LocalDateTime executedAt;

    // 2. Parameterized Constructor
    public TestCaseResult(String testId, String scenarioName, String module) {
        this.testId = testId;
        this.scenarioName = scenarioName;
        this.module = module;
        this.status = "SKIP";
        this.executionDurationMs = 0;
        this.errorMessage = "-";
        this.executedAt = LocalDateTime.now();
    }

    // 3. Behavior Methods
    public void markPassed(long durationMs) {
        this.status = "PASS";
        this.executionDurationMs = durationMs;
        this.errorMessage = "-";
    }

    public void markFailed(long durationMs, String error) {
        this.status = "FAIL";
        this.executionDurationMs = durationMs;
        this.errorMessage = error;
    }

    public boolean isPassed() {
        return "PASS".equals(this.status);
    }

    public String getTestId() { return testId; }
    public String getScenarioName() { return scenarioName; }
    public String getModule() { return module; }
    public String getStatus() { return status; }
    public long getExecutionDurationMs() { return executionDurationMs; }
    public String getErrorMessage() { return errorMessage; }

    public void printSummaryRow() {
        System.out.printf("%-10s | %-12s | %-28s | %-6s | %5d ms | %s\n",
                testId, module, scenarioName, status, executionDurationMs, errorMessage);
    }
}

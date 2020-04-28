package ar.edu.um.jobs.model;

public enum Seniority {
    JUNIOR("Junior", 2),
    SEMI_SENIOR("Semi-Senior", 4),
    SENIOR("Senior", 7);

    private Integer priority;
    private String seniority;

    Seniority(String seniority, Integer priority) {
        this.seniority = seniority;
        this.priority = priority;
    }

    public Integer getPriority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return this.seniority;
    }
}

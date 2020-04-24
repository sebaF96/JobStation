package ar.edu.um.jobs.model;

public enum Seniority {
    JUNIOR("Junior"),
    SEMI_SENIOR("Semi-Senior"),
    SENIOR("Senior");

    private String seniority;

    Seniority(String seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return this.seniority;
    }
}

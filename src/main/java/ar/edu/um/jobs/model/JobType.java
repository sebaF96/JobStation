package ar.edu.um.jobs.model;

public enum JobType {
    FULL_TIME("Full-Time"),
    PART_TIME("Part-Time"),
    VOLUNTEER("Volunteer"),
    CONTRACT("Contract"),
    TEMPORARY("Temporary");

    private String type;

    JobType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}

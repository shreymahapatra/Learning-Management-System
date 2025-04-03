package com.lms.lmssystem.dto;

public class StudentProgressReport {
    private Long studentId;
    private String studentName;
    private long courseCount;
    private double averageGrade;
    private double maxGrade;
    private double minGrade;

    public StudentProgressReport(Long studentId, String studentName, long courseCount,
                                 double averageGrade, double maxGrade, double minGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseCount = courseCount;
        this.averageGrade = averageGrade;
        this.maxGrade = maxGrade;
        this.minGrade = minGrade;
    }

    // Getters and Setters

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(long courseCount) {
        this.courseCount = courseCount;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public double getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(double maxGrade) {
        this.maxGrade = maxGrade;
    }

    public double getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(double minGrade) {
        this.minGrade = minGrade;
    }
}

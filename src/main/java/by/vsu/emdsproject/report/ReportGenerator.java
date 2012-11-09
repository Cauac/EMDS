package by.vsu.emdsproject.report;

public interface ReportGenerator {

    static class ReportName {

        public static final String PERSON_CARD_REPORT = "personCardRepost";
    }

    public void createReport(IReport report);
}

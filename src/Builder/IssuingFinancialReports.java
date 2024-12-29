package Builder;

public class IssuingFinancialReports {

    // product
    public static class Report
    {
        enum enReportFileType {PDF, POWERPOINT, WORD, EXCEL}
        enum enMonthPeriod {DAY, WEEK, MONTH, YEAR}
        enum enRequiredSections {SUMMARY, DETAILS, GRAPHS}

        enReportFileType fileType;
        enMonthPeriod period;
        enRequiredSections requiredSections;

        public void setFileType(enReportFileType fileType){
            this.fileType = fileType;
        }
        public void setPeriod(enMonthPeriod period){
            this.period = period;
        }
        public void setRequiredSections(enRequiredSections requiredSections){
            this.requiredSections = requiredSections;
        }
        @Override
        public String toString() {
            return "[" + fileType + ", " + requiredSections + ", " + period+ "]";
        }
    }

    // product builder
    public static interface ReportBuild
    {
        Report buildReport();
        void buildReportFileType();
        void buildMonthPeriod();
        void buildRequiredSections();
    }

    // product director
    public static class ReportDirector
    {
        ReportBuild buildReport;
        public ReportDirector(ReportBuild buildReport){
            this.buildReport = buildReport;
        }

        public Report constructReport(){
            buildReport.buildReportFileType();
            buildReport.buildMonthPeriod();
            buildReport.buildRequiredSections();
            return buildReport.buildReport();
        }
    }

    // concrete product
    public static class RevenueReport implements ReportBuild
    {
        private Report report;

        public RevenueReport() {
            this.report = new Report();
        }

        @Override
        public void buildReportFileType() {
            report.setFileType(Report.enReportFileType.EXCEL);
        }

        @Override
        public Report buildReport() {
            return report;
        }

        @Override
        public void buildRequiredSections() {
            report.setRequiredSections(Report.enRequiredSections.DETAILS);
        }

        @Override
        public void buildMonthPeriod() {
            report.setPeriod(Report.enMonthPeriod.MONTH);
        }
    }

    // concrete product
    public static class ProfitLossReport implements ReportBuild
    {
        private Report report;

        public ProfitLossReport() {
            this.report = new Report();
        }

        @Override
        public void buildReportFileType() {
            report.setFileType(Report.enReportFileType.WORD);
        }

        @Override
        public Report buildReport() {
            return report;
        }

        @Override
        public void buildRequiredSections() {
            report.setRequiredSections(Report.enRequiredSections.SUMMARY);
        }

        @Override
        public void buildMonthPeriod() {
            report.setPeriod(Report.enMonthPeriod.YEAR);
        }
    }

    public static void main(String[] args) {
        ReportBuild reportBuild = new RevenueReport();
        ReportDirector reportDirector = new ReportDirector(reportBuild);
        Report report = reportDirector.constructReport();
        System.out.println(report);
    }
}

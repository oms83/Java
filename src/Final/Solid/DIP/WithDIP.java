package Final.Solid.DIP;

public class WithDIP {
    public static class GenerateReport {
        IReportGeneratorService generatorService;
        public GenerateReport(IReportGeneratorService generatorService) {
            this.generatorService = generatorService;
        }

        public void Generate()
        {
            generatorService.Generate();
        }
    }
    public static interface IReportGeneratorService {
        public void Generate();
    }
    public static class PDFService implements IReportGeneratorService {
        public void Generate() {
            System.out.println("Generating PDF ...");
        }
    }

    public static class WordService implements IReportGeneratorService {
        public void Generate() {
            System.out.println("Generating Word ...");
        }
    }

    public static class ExcelService implements IReportGeneratorService {
        public void Generate() {
            System.out.println("Generating Excel ...");
        }
    }

    public static void main(String[] args) {
        GenerateReport report = new GenerateReport(new PDFService());
        report.Generate();

        report = new GenerateReport(new ExcelService());
        report.Generate();

        report = new GenerateReport(new WordService());
        report.Generate();
    }
}

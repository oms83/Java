package Final.Solid.DIP;

public class WithoutDIP {

    public static class GenerateReport {
        PDFService pdfService = null;
        WordService wordService = null;
        ExcelService excelService = null;

        public GenerateReport(PDFService pdfService) {
            this.pdfService = pdfService;
        }

        public GenerateReport(WordService wordService) {
            this.wordService = wordService;
        }

        public GenerateReport(ExcelService excelService) {
            this.excelService = excelService;
        }

        public void Generate()
        {
            if (pdfService != null) pdfService.Generate();
            if (wordService != null) wordService.Generate();
            if (excelService != null) excelService.Generate();
        }
    }

    public static class PDFService {
        public void Generate() {
            System.out.println("Generating PDF ...");
        }
    }

    public static class WordService {
        public void Generate() {
            System.out.println("Generating Word ...");
        }
    }

    public static class ExcelService {
        public void Generate() {
            System.out.println("Generating Excel ...");
        }
    }

    public static void main(String[] args) {
        GenerateReport report = new GenerateReport(new PDFService());
        report.Generate();
    }
}

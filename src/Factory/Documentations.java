package Factory;

public class Documentations {

    public static class DocumentationFactory {

        public enum enDocumentation {word, powerpoint, excel}

        public static IDocumentation getDocumentation(enDocumentation en, String title, String content, String author) {
            switch (en) {
                case word:
                    return new WrodDOC(title, content, author);
                case powerpoint:
                    return new PowerpointDOC(title, content, author);
                case excel:
                    return new ExcelDOC(title, content, author);
                default:
                    return null;
            }
        }
    }

    public static interface IDocumentation {
        public void WriteDocumentation(String content);
        public String ReadDocumentation();
    }

    public static abstract class AbstractDocumentation implements IDocumentation {
        protected String content;
        protected String title;
        protected String author;

        public AbstractDocumentation(String content, String title, String author) {
            this.content = content;
            this.title = title;
            this.author = author;
        }
    }

    public static class WrodDOC extends AbstractDocumentation {
        public WrodDOC(String content, String title, String author) {
            super(content, title, author);
        }

        @Override
        public void WriteDocumentation(String content) {
            this.content = content;
        }

        @Override
        public String ReadDocumentation() {
            return this.content;
        }
    }

    public static class PowerpointDOC extends AbstractDocumentation {
        public PowerpointDOC(String content, String title, String author) {
            super(content, title, author);
        }

        @Override
        public String ReadDocumentation() {
            return this.content;
        }

        @Override
        public void WriteDocumentation(String content) {
            this.content = content;
        }
    }

    public static class ExcelDOC extends AbstractDocumentation {
        public ExcelDOC(String content, String title, String author) {
            super(content, title, author);
        }

        @Override
        public String ReadDocumentation() {
            return this.content;
        }

        @Override
        public void WriteDocumentation(String content) {
            this.content = content;
        }

    }

    public static void main(String[] args) {
        IDocumentation documentation = DocumentationFactory.getDocumentation(DocumentationFactory.enDocumentation.excel,
                "C++ fundamentals", "no content", "Omer MEMES");

        if (documentation != null) {
            System.out.println(documentation.ReadDocumentation());
            documentation.WriteDocumentation("C++ is very strong programming language");
            System.out.println(documentation.ReadDocumentation());
        }

        documentation = DocumentationFactory.getDocumentation(DocumentationFactory.enDocumentation.word,
                "C# fundamentals", "no content", "Ali MEMES");

        if (documentation != null) {
            System.out.println(documentation.ReadDocumentation());
        }
    }
}


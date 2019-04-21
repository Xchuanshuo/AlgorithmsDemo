package lintcode;

/**
 * @author Legend
 * @data by on 19-4-21.
 * @description kindle-oo-design
 */
public class Test748 {

    class Kindle {

        private EBookReaderFactory factory;
        public Kindle() {
            //write your code here
            if (factory == null) {
                this.factory = new EBookReaderFactory();
            }
        }

        public String readBook(Book book) throws Exception {
            EBookReader reader = factory.createReader(book);
            return reader.readBook();
        }

        public void downloadBook(Book b) {
            //write your code here
        }

        public void uploadBook(Book b) {
            //write your code here
        }

        public void deleteBook(Book b) {
            //write your code here
        }
    }

    enum Format {
        EPUB("epub"), PDF("pdf"), MOBI("mobi");

        private String content;

        Format(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    class Book {
        private Format format;

        public Book(Format format) {
            this.format = format;
        }

        public Format getFormat() {
            return format;
        }
    }

    abstract class EBookReader {

        protected Book book;

        public EBookReader(Book b){
            this.book = b;
        }

        public abstract String readBook();
        public abstract String displayReaderType();
    }

    class EBookReaderFactory {

        public EBookReader createReader(Book b) {
            //write your code here
            switch (b.getFormat()) {
                case PDF: return new PdfReader(b);
                case EPUB: return new EpubReader(b);
                case MOBI: return new MobiReader(b);
                default: return null;
            }
        }
    }

    class EpubReader extends EBookReader{

        public EpubReader(Book b) {
            super(b);
        }

        @Override
        public String readBook() {
            return displayReaderType() + ", book content is: " + Format.EPUB.getContent();
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using EPUB reader";
        }
    }

    class MobiReader extends EBookReader {

        public MobiReader(Book b) {
            super(b);
        }

        @Override
        public String readBook() {
            return displayReaderType() + ", book content is: " + Format.MOBI.getContent();
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using MOBI reader";
        }

    }
    class PdfReader extends EBookReader{

        public PdfReader(Book b) {
            super(b);
        }

        @Override
        public String readBook() {
            return displayReaderType() + ", book content is: " + Format.PDF.getContent();
        }

        @Override
        public String displayReaderType() {
            // TODO Auto-generated method stub
            return "Using PDF reader";
        }
    }
}

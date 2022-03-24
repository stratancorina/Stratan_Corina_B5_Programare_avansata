import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, CatalogUtil.InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("MyRefs");
        var book = new Item("knuth67", "The Art of Computer Programming","d:/books/programming/tacp.ps" );
        var article = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "d:/research/catalog.json");
    }

    private void testLoadView() throws CatalogUtil.InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("d:/research/catalog.json");
        CatalogUtil.view(catalog.findById("article1"));
    }


}
import commands.*;
import exceptions.InvalidItemId;
import models.Book;
import models.Catalog;
import models.Item;
import java.io.IOException;


public class Main {
     public static void main(String args[]) {
          Main app = new Main();
          app.testCreateSave();
          app.testLoadToStringList();
          app.testView();
     }

     private void testCreateSave() {
          Catalog catalog = new Catalog("MyRefs");
          Item book = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps" );
          Item article = new Book("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
          book.addTag("year", "1967");
          book.addTag("author", "Donald E. Knuth");
          book.addTag("type", "book");
          article.addTag("year", "2021");
          article.addTag("author", "James Gosling & others");

          AddCommand.addItem(catalog, book);
          AddCommand.addItem(catalog, article);

          try {
               SaveCommand.saveCatalog(catalog, "C:/JsonFiles/catalog.json");
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     private void testLoadToStringList() {
          try {
               Catalog catalog = LoadCommand.loadCatalog("C:/JsonFiles/catalog.json");
               System.out.println(ToStringCommand.toString(catalog));
               ListCommand.listItems(catalog);
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     private void testView() {
          Catalog catalog = new Catalog("MyRefs");
          Item book = new Book("knuth67", "The Art of Computer Programming", "C:/JsonFiles/catalog.json" );
          AddCommand.addItem(catalog, book);
          try {
               ViewCommand.viewItem(catalog.getItemById("knuth67"));
          } catch (NullPointerException error) {
               System.out.println("File is null");
          } catch (IllegalArgumentException error) {
               System.out.println("The specified file doesn't exist");
          }  catch (UnsupportedOperationException error) {
               System.out.println("The current platform does not support the Desktop.Action.OPEN action");
          } catch (IOException error) {
               error.printStackTrace();
          } catch (InvalidItemId error) {
               System.out.println("Cannot find the id in the items list.");
          }
     }



}

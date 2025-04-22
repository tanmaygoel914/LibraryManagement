import controller.LibraryController;
import repository.BookRepository;
import repository.UserRepository;
import service.LibraryService;
import service.UserService;
import ui.MainUI;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepo = new BookRepository();
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);
        LibraryService libraryService = new LibraryService(bookRepo, userService);
        LibraryController controller = new LibraryController(libraryService, userService);
        MainUI ui = new MainUI(controller);
        ui.start();
    }
}

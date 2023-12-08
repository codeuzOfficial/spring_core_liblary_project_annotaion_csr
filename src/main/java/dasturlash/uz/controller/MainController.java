package dasturlash.uz.controller;

import dasturlash.uz.container.ComponentContainer;
import dasturlash.uz.dto.Profile;
import dasturlash.uz.service.AuthService;
import dasturlash.uz.service.BookService;
import dasturlash.uz.service.CategoryService;
import dasturlash.uz.service.InitService;
import dasturlash.uz.util.ScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {
    @Autowired
    private InitService initService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthService authService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ComponentContainer componentContainer;
    @Autowired
    private ScannerService scannerService;

    // lesson finished
    public void start() {
        initService.initCreateFile();
        initService.initAdmin();
        initService.initTestStudent();

        boolean loop = true;
        while (loop) {
            showMenu();
            int action = scannerService.getAction();
            switch (action) {
                case 1:
                    bookService.all();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    byCategory();
                    break;
                case 4:
                    login();
                    break;
                case 5:
                    registration();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Mazgi bu hatoku.");
            }

        }

    }

    public void showMenu() {
        System.out.println("*** Main Menu ***");
        System.out.println("1. BookList");
        System.out.println("2. Search");
        System.out.println("3. By category");
        System.out.println("4. Login");
        System.out.println("5. Registration");
        System.out.println("0. Exit");
    }

    public void login() {
        System.out.print("Enter login: ");
        String login = componentContainer.getScannerText().next();

        System.out.print("scannerText password: ");
        String password = componentContainer.getScannerText().next();
        //
        authService.login(login, password);
    }

    public void registration() {
        System.out.print("Enter name: ");
        String name = componentContainer.getScannerText().next();

        System.out.print("Enter surname: ");
        String surname = componentContainer.getScannerText().next();

        System.out.print("Enter phone: ");
        String phone = componentContainer.getScannerText().next();

        System.out.print("Enter login: ");
        String login = componentContainer.getScannerText().next();

        System.out.print("Enter password: ");
        String password = componentContainer.getScannerText().next();

        Profile profile = new Profile();
        profile.setName(name.trim());
        profile.setSurname(surname.trim());
        profile.setPhone(phone.trim());

        profile.setLogin(login.trim()); // valish
        profile.setPassword(password.trim()); // 222

        authService.registration(profile);
    }

    public void search() {
        System.out.print("Enter query:");
        String query = componentContainer.getScannerText().next();
        bookService.search(query);
    }

    public void byCategory() {
        categoryService.list();
        System.out.print("Enter category id:");
        Integer categoryId = componentContainer.getScannerText().nextInt();
        bookService.byCategoryId(categoryId);
    }

}

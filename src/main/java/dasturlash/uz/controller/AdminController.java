package dasturlash.uz.controller;


import dasturlash.uz.util.ScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private BookController bookController;
    @Autowired
    private CategoryController categoryController;

    @Autowired
    private StudentProfileController studentProfileController;
    @Autowired
    private ProfileController profileController;
    @Autowired
    private ScannerService scannerService;

    public void start() {
        boolean loop = true;
        while (loop) {
            showMenu();
            int action = scannerService.getAction();
            switch (action) {
                case 1:
                    bookController.start();
                    break;
                case 2:
                    categoryController.start();
                    break;
                case 3:
                    studentProfileController.start();
                    break;
                case 4:
                    profileController.start();
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
        System.out.println("*** Menu ***");
        System.out.println("1. Book");
        System.out.println("2. Category");
        System.out.println("3. Student");
        System.out.println("4. Profile");
        System.out.println("0. Exit");
    }
}

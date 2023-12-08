package dasturlash.uz.util;

import dasturlash.uz.container.ComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ScannerService {
    @Autowired
    private ComponentContainer componentContainer;

    public int getAction() {
        System.out.print("Enter action: ");
        try {
            return componentContainer.getScannerNumber().nextInt();
        } catch (InputMismatchException e) {
            componentContainer.setScannerNumber(new Scanner(System.in));
            System.out.println("\nPlease enter number.\n");
            return -1;
        }
    }

}

package dasturlash.uz.container;

import dasturlash.uz.dto.Profile;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ComponentContainer {
    private Scanner scannerText;
    private Scanner scannerNumber;

    private Profile currentProfile;

    public ComponentContainer() {
        scannerText = new Scanner(System.in);
        scannerNumber = new Scanner(System.in);
    }


    public Scanner getScannerText() {
        return scannerText;
    }

    public Scanner getScannerNumber() {
        return scannerNumber;
    }

    public void setScannerNumber(Scanner scannerNumber) {
        this.scannerNumber = scannerNumber;
    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
    }
}

package com.denizguzel.Interface;

import com.denizguzel.FileOperations.PatientFile;
import com.denizguzel.Models.Patient;

import java.util.Scanner;

public class PatientMenu implements Menu {
    PatientFile fileObject = new PatientFile();
    Patient user = new Patient();
    Patient user2 = new Patient();

    public PatientMenu() {
        System.out.println("1-Hasta ekleme\n" + "2-Hasta güncelleme\n" + "3-Hasta silme\n" + "4-Hasta listeleme\n");
        Scanner menuChoice = new Scanner(System.in);
        byte menuNumber = menuChoice.nextByte();

        switch (menuNumber) {
            case 1:
                addPatient();
                break;
            case 2:
                updatePatient();
                break;
            case 3:
                deletePatient();
                break;
            case 4:
                fileObject.List();
                break;
            default:
                break;
        }
    }

    private void addPatient() {
        System.out.println("İsim giriniz");
        Scanner name = new Scanner(System.in);
        user.setName(name.nextLine());

        System.out.println("Soyisim giriniz");
        Scanner surname = new Scanner(System.in);
        user.setSurname(surname.nextLine());

        fileObject.Add(user);
    }

    private void updatePatient() {
        fileObject.List();
        System.out.println("Güncellemek istediğiniz ismi ve soyismi giriniz\n");

        System.out.println("İsim giriniz");
        Scanner curremtName = new Scanner(System.in);
        user.setName(curremtName.nextLine());

        System.out.println("Soyisim giriniz");
        Scanner currentSurname = new Scanner(System.in);
        user.setSurname(currentSurname.nextLine());

        System.out.println("Yeni isim giriniz");
        Scanner newName = new Scanner(System.in);
        user2.setName(newName.nextLine());

        System.out.println("Yeni soyisim giriniz");
        Scanner newSurname = new Scanner(System.in);
        user2.setSurname(newSurname.nextLine());

        fileObject.Update(user, user2);
    }

    private void deletePatient() {
        fileObject.List();
        System.out.println("Silmek istediğiniz ismi ve soyismi giriniz\n");

        System.out.println("İsim giriniz");
        Scanner curremtName = new Scanner(System.in);
        user.setName(curremtName.nextLine());

        System.out.println("Soyisim giriniz");
        Scanner currentSurname = new Scanner(System.in);
        user.setSurname(currentSurname.nextLine());

        fileObject.Delete(user);
    }

    @Override
    public void baseMenu() {

    }
}

package com.denizguzel.Interface;

import com.denizguzel.FileOperations.DoctorFile;
import com.denizguzel.Models.Doctor;

import java.util.Scanner;

public class DoctorMenu implements Menu {

  DoctorFile fileObject = new DoctorFile();
  Doctor user = new Doctor();
  Doctor user2 = new Doctor();

    public DoctorMenu() {
        System.out.println("1-Doktor ekleme\n" + "2-Doktor güncelleme\n" + "3-Doktor silme\n" + "4-Doktor listeleme\n");
        Scanner menuChoice = new Scanner(System.in);
        byte menuNumber = menuChoice.nextByte();

        switch (menuNumber) {
            case 1:
                addUser();
                break;
            case 2:
                updateUser();
                break;
            case 3:
                deleteUser();
                break;
            case 4:
                fileObject.List();
                break;
            default:
                break;
        }
    }

    private void addUser() {
    System.out.println("İsim giriniz");
    Scanner name = new Scanner(System.in);
    user.setName(name.nextLine());

    System.out.println("Soyisim giriniz");
    Scanner surname = new Scanner(System.in);
    user.setSurname(surname.nextLine());

    fileObject.Add(user);
  }

  private void updateUser () {
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

  private void deleteUser () {
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
  public void baseMenu () {

  }
}

package com.denizguzel.Interface;

import com.denizguzel.FileOperations.MedicineFile;
import com.denizguzel.Models.Medicine;

import java.util.Scanner;

public class MedicineMenu implements Menu {
  MedicineFile fileObject = new MedicineFile();
  Medicine medicine1 = new Medicine();
  Medicine medicine2 = new Medicine();

    public MedicineMenu() {
        System.out.println("1-İlaç ekleme\n" + "2-İlaç güncelleme\n" + "3-İlaç silme\n" + "4-İlaç listeleme\n");
        Scanner menuChoice = new Scanner(System.in);
        byte menuNumber = menuChoice.nextByte();

        switch (menuNumber) {
            case 1:
                addMedicine();
                break;
            case 2:
                updateMedicine();
                break;
            case 3:
                deleteMedicine();
                break;
            case 4:
                fileObject.List();
                break;
            default:
                break;
        }
    }

    private void addMedicine() {
    System.out.println("İlaç ismi giriniz");
    Scanner name = new Scanner(System.in);
    medicine1.setMedicineName(name.nextLine());

    System.out.println("Kaç adet?");
    Scanner count = new Scanner(System.in);
    medicine1.setMedicineCount(count.nextInt());

    fileObject.Add(medicine1);
  }

  private void updateMedicine () {
    fileObject.List();
    System.out.println("Güncellemek istediğiniz ilacın ismini ve adetini giriniz\n");

    System.out.println("İlaç ismi giriniz");
    Scanner currentName = new Scanner(System.in);
    medicine1.setMedicineName(currentName.nextLine());

    System.out.println("İlacın yeni ismini giriniz");
    Scanner newName = new Scanner(System.in);
    medicine2.setMedicineName(newName.nextLine());

    System.out.println("Eski adet sayısı?");
    Scanner currentCount = new Scanner(System.in);
    medicine1.setMedicineCount(currentCount.nextInt());

    System.out.println("Yeni adet sayısı?");
    Scanner newCount = new Scanner(System.in);
    medicine2.setMedicineCount(newCount.nextInt());


    fileObject.Update(medicine1, medicine2);
  }

  private void deleteMedicine () {
    fileObject.List();
    System.out.println("Silmek istediğiniz ilacın ismini ve adetini giriniz\n");

    System.out.println("İsim giriniz");
    Scanner currentName = new Scanner(System.in);
    medicine1.setMedicineName(currentName.nextLine());

    System.out.println("Kaç adet?");
    Scanner count = new Scanner(System.in);
    medicine1.setMedicineCount(count.nextInt());

    fileObject.Delete(medicine1);
  }

  @Override
  public void baseMenu () {

  }
}

package com.denizguzel.Interface;

import com.denizguzel.FileOperations.DateFile;
import com.denizguzel.Models.Date;

import java.util.Scanner;

public class DateMenu implements Menu {
  DateFile fileObject = new DateFile();
  Date appointment1 = new Date();
  Date appointment2 = new Date();

  private void addAppointment () {
    System.out.println("Randevu tarihi giriniz (Örn. 30 Aralık 2016)");
    Scanner name = new Scanner(System.in);
    appointment1.setAppointmentDate(name.nextLine());

    fileObject.Add(appointment1);
  }

  private void updateAppointment () {
    fileObject.List();
    System.out.println("Güncellemek istediğiniz tarihi giriniz\n");

    System.out.println("Tarihi giriniz");
    Scanner currentDate = new Scanner(System.in);
    appointment1.setAppointmentDate(currentDate.nextLine());

    System.out.println("Yeni tarihi giriniz");
    Scanner newDate = new Scanner(System.in);
    appointment2.setAppointmentDate(newDate.nextLine());

    fileObject.Update(appointment1, appointment2);
  }

  private void deleteAppointment () {
    fileObject.List();
    System.out.println("Silmek istediğiniz tarihi giriniz\n");

    System.out.println("Tarihi giriniz");
    Scanner curremtName = new Scanner(System.in);
    appointment1.setAppointmentDate(curremtName.nextLine());

    fileObject.Delete(appointment1);
  }

  @Override
  public void baseMenu () {
    System.out.println("1-Randevu ekleme\n" + "2-Randevu güncelleme\n" + "3-Randevu silme\n" + "4-Randevu listeleme\n");
    Scanner menuChoice = new Scanner(System.in);
    byte    menuNumber = menuChoice.nextByte();

    switch ( menuNumber ) {
      case 1:
        addAppointment();
        break;
      case 2:
        updateAppointment();
        break;
      case 3:
        deleteAppointment();
        break;
      case 4:
        fileObject.List();
        break;
      default:
        break;
    }
  }
}

package com.denizguzel;

import com.denizguzel.Interface.*;

import java.util.Scanner;

public class Main {

  public static void main (String[] args) {
    Menu welcomeMenu = new Menu() {

      private byte menuChoice;

      byte getMenuChoice () {
        return menuChoice;
      }

      void setMenuChoice (byte menuChoice) {
        this.menuChoice = menuChoice;
      }

      @Override
      public void baseMenu () {
        System.out.println("1-Hasta Kaydı ve Güncelleme\n" + "2-Doktor Kaydı ve Güncelleme\n" + "3-Randevu Alma\n" + "4-İlaç Sorgulama");
        Scanner menuNumber = new Scanner(System.in);
        setMenuChoice(menuNumber.nextByte());

        switch ( getMenuChoice() ) {
          case 1:
            new PatientMenu();
            break;
          case 2:
              new DoctorMenu();
            break;
          case 3:
              new DateMenu();
            break;
          case 4:
              new MedicineMenu();
            break;
          default:
            break;
        }
          baseMenu();
      }
    };
    welcomeMenu.baseMenu();
  }
}

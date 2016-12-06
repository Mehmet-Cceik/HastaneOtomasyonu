package com.denizguzel.Models;

public class Medicine extends Base {
  private String medicineName;
  private int medicineCount;

  public int getMedicineCount () {
    return medicineCount;
  }

  public void setMedicineCount (int medicineCount) {
    this.medicineCount = medicineCount;
  }

  public String getMedicineName () {
    return medicineName;
  }

  public void setMedicineName (String medicineName) {
    this.medicineName = medicineName;
  }
}

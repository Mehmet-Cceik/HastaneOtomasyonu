package com.denizguzel.FileOperations;

import java.io.*;

import com.denizguzel.Models.Patient;

public class PatientFile implements BaseFile<Patient> {

  private String getFileName () {
    return "hastalar.txt";
  }

  @Override
  public void Add (Patient patient) {
    try {
      File file = new File(getFileName());

      FileWriter     fw = new FileWriter(file, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter    pw = new PrintWriter(bw);

      pw.println(patient.getName() + "," + patient.getSurname());
      pw.close();

    } catch ( IOException ioe ) {
      System.out.println("Dosyaya yazmada sorun oluştu.");
      ioe.printStackTrace();
    }
  }

  @Override
  public void Update (Patient currentName, Patient newName) {
    String search      = currentName.getName() + "," + currentName.getSurname();
    String replacement = newName.getName() + "," + newName.getSurname();

    try {
      File   file    = new File(getFileName());
      String line;
      String oldText = "";

      BufferedReader br = new BufferedReader(new FileReader(file));
      while ( (line = br.readLine()) != null )
        oldText += line + "\n";

      br.close();
      String newText = oldText.replaceAll(search, replacement);

      FileWriter fw = new FileWriter(file);
      fw.write(newText);
      fw.close();

    } catch ( IOException ioe ) {
      System.out.println("Güncelleme sırasında sorun oluştu.");
      ioe.printStackTrace();
    }
  }

  @Override
  public void List () {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(getFileName()));
      String textLine = br.readLine();
      while ( textLine != null ) {
        System.out.println(textLine);
        textLine = br.readLine();
      }
    } catch ( IOException ioe ) {
      ioe.printStackTrace();
    } finally {
      try {
        if ( br != null )
          br.close();
      } catch ( IOException ioe ) {
        System.out.println("Listelemede sorun oluştu.");
        ioe.printStackTrace();
      }
    }
  }

  @Override
  public void Delete (Patient patient) {
    String search = patient.getName() + "," + patient.getSurname();

    try {
      File   file    = new File(getFileName());
      String line;
      String oldText = "";

      BufferedReader br = new BufferedReader(new FileReader(file));
      while ( (line = br.readLine()) != null )
        oldText += line + "\n";

      br.close();
      String newText = oldText.replaceAll(search, "");

      FileWriter fw = new FileWriter(file);
      fw.write(newText);
      fw.close();

    } catch ( IOException ioe ) {
      System.out.println("Sorun Oluştu:");
      ioe.printStackTrace();
    }
  }
}

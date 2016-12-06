package com.denizguzel.FileOperations;

import com.denizguzel.Models.Date;

import java.io.*;

public class DateFile implements BaseFile<Date> {
  private String getFileName () {
    return "randevular.txt";
  }


  @Override
  public void Add (Date appointment) {
    try {
      File file = new File(getFileName());

      FileWriter     fw = new FileWriter(file, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter    pw = new PrintWriter(bw);

      pw.println(appointment.getAppointmentDate());
      pw.close();

    } catch ( IOException ioe ) {
      System.out.println("Dosyaya yazmada sorun oluştu.");
      ioe.printStackTrace();
    }
  }

  @Override
  public void Update (Date currentOne, Date newOne) {
    String search      = currentOne.getAppointmentDate();
    String replacement = newOne.getAppointmentDate();

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
  public void Delete (Date appointment) {
    String search = appointment.getAppointmentDate();

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

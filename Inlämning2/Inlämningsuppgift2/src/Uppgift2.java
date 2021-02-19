/**
 * Programmet räknar ut hur mycket energi ett antal solceller producerar,
 * baserat på solens uppgång och nedgång samt solinstrålning och solcellspanelerna yta.
 * Användaren matar in tiderna för soluppgång,solnedgång samt datum.
 * Programmet kalkylerar sedan antalet soltimmar, antalet kWh och värdet på energin i pengar.
 * 
 * @author moring-0
 *
 */
//Importerar metoder
import java.util.Scanner;
import java.text.DecimalFormat;
public class Uppgift2
{
   public static void main(String[] args)
   {
      //Deklarerar variabler
      int month, day;
      double dayLight, h1, h2, m1, m2, minutes,sunpanelSize, production, value;
      String date;
      
      //anger en variabel f, som styr antal decimaler
      DecimalFormat f = new DecimalFormat("##.00");
      
      //Deklarerar input variabler
      Scanner dateInput = new Scanner(System.in);
      Scanner sunrise = new Scanner(System.in);
      Scanner sunset = new Scanner(System.in);
      
      //Anger separator i inmatningarna
      dateInput.useDelimiter("[-/\\s]+");
      sunrise.useDelimiter("[:\\s]+");
      sunset.useDelimiter("[:\\s]+");
      
      //Uppmanar användaren att mata in datum samt sparar värdena i variabler.
      System.out.print("Ange dagens datum på formen [mm-dd]>");
      month = dateInput.nextInt();
      day = dateInput.nextInt();
      
      //Uppmanar användaren att mata in tid för soluppgång samt sparar värdena i variabler.
      System.out.print("Ange tiden för solens uppgång på formen [hh:mm]>");
      h1 = sunrise.nextDouble();
      m1 = sunrise.nextDouble();
      
      //Uppmanar användaren att mata in tid för solnedgång samt sparar värdena i variabler.
      System.out.print("Ange tiden för solens nedgång på formen [hh:mm]>");
      h2 = sunset.nextDouble();
      m2 = sunset.nextDouble();
      System.out.println("======================================================");
      
      //Genomför beräkningar och sparar dem i variabler.
      sunpanelSize = 26 * 1.7;
      date = day + "/" + month;
      minutes = (h2-h1)*60 + (m2-m1);
      dayLight = minutes / 60;
      production = (166 * dayLight * sunpanelSize * 0.2) / 1000;
      value = production * 0.9;
      
      //Anger villkoret för Juni och Juli månad samt att solnedgången är senare än soluppgången, och presenterar resultatet eller ett felmeddelande
      if(h2 > h1 && month == 6 || month == 7)
      {
         System.out.printf("%1s  %1s %1s%n", "Soltimmar:", f.format(dayLight), "timmar");
         System.out.printf("%1s  %1s  %1s  %1s %1s %1s %1s%n", "Produktionen den", date, "är:", f.format(production), "kWh till ett värde av:", f.format(value), "kr");
      }
      else
      {
         System.out.print("Error, solnedgången måste vara senare än soluppgången och bara juni och juli är giltiga månader");
      }
      //Stänger scanner input och avslutar programmet.
      dateInput.close();
      sunrise.close();
      sunset.close();
      System.exit(0);
   }
}

import java.awt.Desktop;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import static java.awt.Desktop.getDesktop;
import static java.util.Arrays.asList;

public class VideoGameRoulette
{
	public static void main(String[] args) throws Exception
	{
		final String gameFolder = "Enter the path to your game installation folder here";
		Random random = new Random();

		File folder = new File(gameFolder);
		File[] listOfFiles = folder.listFiles();

    	int randGame = random.nextInt(listOfFiles.length);

    	File result = listOfFiles[randGame];

    	System.out.println(" ");
    	System.out.println("-----------------------------------------------------------------");
        System.out.println("          You should play " + result.getName() + "!             ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("The program will now open a website that will allow you to find the game id to your steam game");
        System.out.println(" ");
        System.out.println("To find the game id please enter the game name that was chosen and change the app type to Game ");
        System.out.println(" ");
        System.out.println("Once you have found the game ID, the program will ask you to write the ID");
        System.out.println(" ");
        System.out.println("After finding the game ID, go back to the terminal" + "\n" + "and simply Copy & Paste the id to the terminal and the game will run");
        System.out.println(" ");
        System.out.println("Press 'v' to view the website to find the game ID or any button to end the program");
        System.out.println(" ");

        Scanner scan = new Scanner(System.in);
        String viewSite = scan.nextLine();


        if(viewSite.equals("v")) 
        {
        	try 
        	{
  				Desktop desktop = java.awt.Desktop.getDesktop();
  				URI oURL = new URI("https://steamdb.info/search/");
  				desktop.browse(oURL);
			} 
			catch (Exception e) 
			{
  				e.printStackTrace();
			}

			Scanner insertGameID = new Scanner(System.in);

			System.out.println(" ");
			System.out.println("Please Enter the Game ID to run the game");

			String id = insertGameID.nextLine();

        	try
			{
				URI steamProtocol = new URI("steam://run/" + id);
        		Desktop.getDesktop().browse(steamProtocol);
			}
			catch (Exception e)
			{
    			System.out.println(e.getMessage());
			}

		}
		else
		{
			System.out.println("You have ended the program. Have a nice day.");
		}
		
	}
}
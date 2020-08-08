import java.awt.Desktop;
import java.util.*;
import java.io.*;
import java.net.URI;
import static java.awt.Desktop.getDesktop;
import static java.util.Arrays.asList;

public class VideoGameRoullete{
	public static void main(String[] args) throws Exception{
		
		FilesIntoArray roullette = new FilesIntoArray();
		Scanner scanPath = new Scanner(System.in);

		System.out.println("Please copy and paste your steam game directory");
		String path = scanPath.nextLine();

		//puts files from path into array called gameList
		File[] gameList = roullette.filesIntoArray(path);

		//chooses a file at random from the array
		String game = roullette.chooseGame(gameList);

		//prints the prompt with the chosen game
		roullette.printPrompt(gameList);

//bug: wrong id is chosen OFTEN the readline may be being overwritten idk 
//------------------------------------------------------------------------------------------------------------------------------
		// System.out.println("To run the chosen game, press 'r' or any button to end the program.");

		// Scanner scanRunGame = new Scanner(System.in);
  //       String runGame = scanRunGame.nextLine();

  //       boolean runOK = false;

  //       if(runGame.equals("r")){
  //           try{

  //               BufferedReader br = new BufferedReader(new FileReader(path + game + "/steam_appid.txt"));                
  //               String gameID = br.readLine();
  //               System.out.println(gameID);
                
  //               URI steamProtocol = new URI("steam://run/" + gameID); 
  //               Desktop.getDesktop().browse(steamProtocol);

  //               runOK = true;
  //               }
                
            
  //           catch (Exception e){
  //               System.out.println("Could not find game id in folder or is either not istalled. Press 'v' to find it manually or any button to end the program");
  //               System.out.println(" ");
  //               System.out.println("The program will now open a website that will allow you to find the game id to your steam game");
  //               System.out.println(" ");
  //               System.out.println("To find the game id please enter the game name that was chosen and change the app type to Game ");
  //               System.out.println(" ");
  //               System.out.println("Once you have found the game ID, the program will ask you to write the ID");
  //               System.out.println(" ");
  //               System.out.println("After finding the game ID, go back to the terminal" + "\n" + "and simply Copy & Paste the id to the terminal and the game will run");
  //               System.out.println(" ");

  //           }

	 //        if(!runOK){
		// 	Scanner scan = new Scanner(System.in);
	 //        String viewSite = scan.nextLine();

	 //        //allows the user to view the site to input game id and run it
	 //        //or allows them to exit the program
	 //        roullette.findManual(viewSite);
	 //    	}
	 //    	else{
	 //    		System.out.println("The program has ended. Have a nice day.");
	 //    	}
		// }
		// else{
		// 	System.out.println("You have ended the program. Have a nice day.");
		// }
//-----------------------------------------------------------------------------------------------------------------------------------
		Scanner scan = new Scanner(System.in);
        String viewSite = scan.nextLine();

        //allows the user to view the site to input game id and run it
        //or allows them to exit the program
        roullette.scannerLogic(viewSite);
	}
}

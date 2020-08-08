//Rafael Sudiyanto 
//Created 6/3/2019
//Last updated 8/8/2020

import java.awt.Desktop;
import java.util.*;
import java.io.*;
import java.net.URI;
import static java.awt.Desktop.getDesktop;
import static java.util.Arrays.asList;

public class VideoGameRoulette
{
	public static void main(String[] args) throws Exception
	{
		Scanner scanPath = new Scanner(System.in);

        System.out.println("Please copy and paste your steam game directory");
        String path = scanPath.nextLine();

		Random random = new Random();

		File folder = new File(path);

        //lists all files found from the path and stores them into an array
		File[] listOfFiles = folder.listFiles();

        //generates a random number based on the amount of files in path
    	int randGame = random.nextInt(listOfFiles.length);

        //chooses a game from the array
    	File result = listOfFiles[randGame];

        String game = result.getName();

    	System.out.println(" ");
    	System.out.println("-----------------------------------------------------------------");
        System.out.println("          You should play " + game + "!             ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("press r");

        Scanner scanRunGame = new Scanner(System.in);
        String runGame = scanRunGame.nextLine();

        boolean runOK = false;

        if(runGame.equals("r")){
            try{

                //reads the steam game ID textfile that is typically present in the game's folder 
                BufferedReader br = new BufferedReader(new FileReader(path + game + "/steam_appid.txt"));                
                String gameID = br.readLine();
                
                URI steamProtocol = new URI("steam://run/" + gameID); 
                Desktop.getDesktop().browse(steamProtocol);

                runOK = true;
                }
                
            //catches if no id was found
            catch (Exception e){
                System.out.println(" ");
                System.out.println("Could not find game id in folder or is either not istalled.");
                System.out.println(" ");
                System.out.println("Press 'v' to find it manually or any button to end the program");
                System.out.println(" ");
                System.out.println("The program will now open a website that will allow you to find the game id to your steam game");
                System.out.println(" ");
                System.out.println("To find the game id please enter the game name that was chosen and change the app type to Game ");
                System.out.println(" ");
                System.out.println("Once you have found the game ID, the program will ask you to write the ID");
                System.out.println(" ");
                System.out.println("After finding the game ID, go back to the terminal" + "\n" + "and simply Copy & Paste the id to the terminal and the game will run");
                System.out.println(" ");

            }

            //runs if game was not able to be run automatically
            if(!runOK){    
                Scanner scan = new Scanner(System.in);
                String viewSite = scan.nextLine();


                if(viewSite.equals("v")){ 
                
                	try{ 
                	
          				Desktop desktop = java.awt.Desktop.getDesktop();
          				URI oURL = new URI("https://steamdb.info/search/");
          				desktop.browse(oURL);
        			} 
        			catch (Exception e){ 
        			
          				e.printStackTrace();
        			}

        			Scanner insertGameID = new Scanner(System.in);

        			System.out.println(" ");
        			System.out.println("Please Enter the Game ID to run the game");

        			String id = insertGameID.nextLine();

                	try{
        			
        				URI steamProtocol = new URI("steam://run/" + id);
                		Desktop.getDesktop().browse(steamProtocol);
        			}
        			catch (Exception e){
        			
            			System.out.println(e.getMessage());
        			}

        		}
                //else for if(viewSite.equals("v"))
            	else{
            	   System.out.println("You have ended the program. Have a nice day.");
            	}
            }
            //else for if(!runOK)
            else{ 
                System.out.println("The program has ended");
            }
        }
        //else for if(runGame.equals("r"))
        else
        {
            System.out.println("You have ended the program. Have a nice day.");
        }
		
	}
}

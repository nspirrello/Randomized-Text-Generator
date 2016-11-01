package songRandom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * @author Nicholas Pirrello
 * This class is the GUI and data gathering portion of the program. Contained in it is a menu, FileChooser, Labels, TextAreas, TextFields and Buttons
 */
public class App extends Application{
	SuperLink temp;
	Scanner reader = null;
	String[] song = null;
	File songText;
	SuperLinkList sl = new SuperLinkList();
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
//		SuperLink current = sl.first;
//		while(current != null){
//			System.out.print(current.key + " ");
//			System.out.print(current.bList.n);
//			current.bList.displayList();
//			
//			current = current.next;
//			System.out.println();
//		}
		
	}
	/**
	 * Using the FileChooser, the user imports a text file with song lyrics. Then the lyrics are loaded into the program and split into LinkedList containing each unique word 
	 * found and then each word that follow it.
	 * Each SuperLinkedList should be a unique word, each node should contain a reference to that word as well as a BabyList to hold the following words.
	 * When that word is encountered again, only the following word is added to the appropriate BabyList.
	 * 
	 * The user can input the starting word and the amount of words they want to have shown. Then the program will follow through the LinkedList and 
	 * generate random words from the previously generated word's BabyList until the limit (user inputed) is reached as well as combined into a single String. 
	 * Finally, the string is printed into a formatted Text area for the user to read.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("File");
		MenuItem importF = new MenuItem("Choose File");
		
		importF.setOnAction(event -> {
			FileChooser fileC = new FileChooser();
			FileChooser.ExtensionFilter extenFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
			fileC.getExtensionFilters().add(extenFilter);
			fileC.setTitle("Load data");
			songText = fileC.showOpenDialog(new Stage());
			
			try {
				reader = new Scanner(songText);
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}
			String wholeText = "";
			while(reader.hasNextLine()){
				wholeText =  wholeText + "" + reader.nextLine();
			}
			song = wholeText.split("\t");
			//finds if the word is already contained in a linkedList
			for(int i = 0;i < song.length-1;i++){
				if(sl.isEmpty()){
					sl.insertLast(song[i]);
					temp = sl.getLink(song[i]);
					temp.bList.insertLast(song[i+1]);
				} else if (sl.findLink(song[i]) == false) {
					sl.insertLast(song[i]);
					temp = sl.getLink(song[i]);
					temp.bList.insertLast(song[i+1]);
				
				} else {
					temp = sl.getLink(song[i]);
					temp.bList.insertLast(song[i+1]);
				} 
			}
		});
//		songText = fileC.showSaveDialog(new Stage());
		menuBar.getMenus().add(file);
		file.getItems().add(importF);
		
		BorderPane bp = new BorderPane();
		
		
		
		Label word = new Label("Enter word [in song]:");
		TextField wordF = new TextField();
		Label num = new Label("Number of words:");
		TextField numF = new TextField();
		
		TextArea result = new TextArea();
		result.setWrapText(true);
		
		Button gen = new Button("Generate");
		
		gen.setOnAction(event -> {
			String wordGiven = wordF.getText();
			String finalWords = wordGiven + " ";
			int count = Integer.parseInt(numF.getText());
			SuperLink s;
			String temp;
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Invalid input!");
			alert.setContentText("The word entered is not in the song chosen");
			for(int i = 0;i < count-1;i++){
				s = sl.getLink(wordGiven);
				try{
					temp = s.bList.getNextWord();
					finalWords = finalWords + " " + temp + " ";
					wordGiven = temp;
				} catch (NullPointerException e){
					finalWords = "";
					alert.showAndWait();
				}
			}
			result.setText(finalWords);
			result.setEditable(false);
			
			FileWriter fw = null;
			PrintWriter pw = null;
			File parentDir = new File("output");
			parentDir.mkdir();
			File location = new File(parentDir,"output.txt");

			try {
				location.createNewFile();
				fw = new FileWriter(location);
				pw = new PrintWriter(fw);
				pw.print(finalWords);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			pw.close();
			
			
			
			
			
			
		});
		
		
		
		
		
		HBox hbox1 = new HBox(30);
		hbox1.getChildren().addAll(word,wordF,num,numF);
		
		VBox v1 = new VBox(20);
		v1.getChildren().addAll(hbox1,result,gen);
		
		bp.setTop(menuBar);
		bp.setCenter(v1);
		
		Scene scene = new Scene(bp,600,300);
		stage.setScene(scene);
		stage.show();
		
		
	}

}

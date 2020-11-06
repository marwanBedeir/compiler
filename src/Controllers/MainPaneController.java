

package Controllers;

import Models.Context;
import Models.FileTabPane;
import backend.ErrorMessages;
import backend.FileManager;
import backend.Parse;
import backend.Parser;
import backend.Scanner;
import backend.Token;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

/**
 * FXML Controller of MainPane.fxml.
 * This is the controller for the view MainPane.fxml. This is a VBox with
 * a MenuBar, and AnchorPane and an HBox.
 * The Anchor Pane includes FileTabPane.fxml. See FileTabPane.
 * The HBox holds a few labels.
 * This class implements the methods for the MenuBar, while the FileTabController
 * implements the application logic.
 */
public class MainPaneController implements Initializable {
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    /*
    * @return the FileTabPaneController which controls the file tabs.
    */
    public FileTabPaneController getFileTabPaneController() {
        return fileTabPaneController;
    }
    
    /**
     * Removes the find dialog or replace dialog prompt, which ever is open.
     */
    public void removeFindOrReplaceDialog() {
        Node replaceDialog = vBox.lookup("#replaceDialogHBox");
        Node findDialog = vBox.lookup("#findDialogHBox");
        if (replaceDialog != null) {
            vBox.getChildren().remove(replaceDialog);
        }
        else if (findDialog != null) {
            vBox.getChildren().remove(findDialog);
        }
    }

    // FXML ACTIONS
    
    /**
     * Adds a new empty file tab.
     * @throws java.io.IOException
     */
    @FXML public void newFile() throws IOException  {
        fileTabPaneController.newFile();
    }
      
    /**
     * Opens a prompt to select and open a file tab.
     * @throws IOException 
     */
    @FXML public void openFile() throws IOException  {
        fileTabPaneController.openFile();
    }
    
    /**
     * Saves the contents of the text area to the file.
     * @throws IOException 
     */
    @FXML public void saveFile() throws IOException {
        fileTabPaneController.saveSelectedFile();
    }
    
    /**
     * Save the contents of the text area to a file chosen in a prompt.
     * @throws IOException 
     */
    @FXML public void saveAsFile() throws IOException {
        fileTabPaneController.saveAsSelectedFile();
    }
        
    /**
     * Prints the file with the default printer.
     */
    @FXML public void printFile()  {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            fileTabController.print();
        }
    }
          
    /**
     * Overrides the normal program quit to prompt for file saving.
     * @throws IOException 
     */
    @FXML public void quitApp() throws IOException {
        fileTabPaneController.closeTabsAndExit();
    }
    
    /**
     * Undo the most recent text change in the text area.
     */
    @FXML public void undo() {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            fileTabController.undo();
        }
    }
        
    /**
     * Redo the most recent text change in the text area.
     */
    @FXML public void redo() {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            fileTabController.redo();
        }
    }
     
    /**
     * Cuts the chosen text within the text area.
     */
    @FXML public void cut() {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            fileTabController.cut();
        }
    }
    
    /**
     * Copies the chosen text within the text area.
     */
    @FXML public void copy() {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            fileTabController.copy();
        }
    }
    
    /**
     * Pastes the curretly copied/cut text to the text area.
     */
    @FXML public void paste() {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            fileTabController.paste();
        }
    }

    /**
     * Selects all the text in the text area.
     */
    @FXML public void selectAll() {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            fileTabController.selectAll();
        }
    }
    
    /**
     * Opens a prompt in which a user can input text to find in the text area.
     * Will exclusively open this or a replace dialog.
     * @throws java.io.IOException
     */
    @FXML public void find() throws IOException {
        Node replaceDialog = vBox.lookup("#replaceDialogHBox");
        Node findDialog = vBox.lookup("#findDialogHBox");
        if (replaceDialog != null) {
            removeFindOrReplaceDialog();
            addFindDialog();
        }
        else if (findDialog == null) {
            addFindDialog();
        }
    }
    
    /**
     * Opens a prompt to find text in the text area and then replace it.
     * @throws java.io.IOException
     */
    @FXML public void replace() throws IOException {
        Node replaceDialog = vBox.lookup("#replaceDialogHBox");
        Node findDialog = vBox.lookup("#findDialogHBox");
        if (findDialog != null) {
            removeFindOrReplaceDialog();
            addReplaceDialog();
        }
        else if (replaceDialog == null) {
            addReplaceDialog();
        }
    }
    
    /**
     * 
     * @throws java.io.IOException
     */
    
 
    // PRIVATE METHODS
    
    /**
     * Opens a prompt in which a user can input text to find in the text area.
     * @throws IOException 
     */
    private void addFindDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/FindDialog.fxml"));
        Parent node = loader.load();
        FindDialogController controller = loader.getController();
        controller.setContext(new Context(fileTabPaneController, this));
        int index = 2;
        vBox.getChildren().add(index, node);
    }
 
    /**
     * Opens a prompt in which a user can input text to find in the text area and
     * replace it.
     * @throws IOException 
     */
    private void addReplaceDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/ReplaceDialog.fxml"));
        Parent node = loader.load();
        ReplaceDialogController controller = loader.getController();
        Context context = new Context(fileTabPaneController, this);
        controller.getFindDialogController().setContext(context);
        controller.setContext(context);
        int index = 2;
        vBox.getChildren().add(index, node);
    }
     
    @FXML public void comment()  {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            String selectedText = fileTabController.getTextArea().getSelectedText();
            if(!selectedText.equals("")){
                String orignalText = fileTabController.getTextArea().getText();
                String commentedText = "/- " + selectedText + " -/";
                String newText = orignalText.replace(selectedText, commentedText);
                fileTabController.getTextArea().setText(newText);
            }
        }
    }
    
    @FXML public void uncomment()  {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            String selectedText = fileTabController.getTextArea().getSelectedText();
            String orignalText = fileTabController.getTextArea().getText();
            String uncommentedText = "";
            char[] array = selectedText.toCharArray();
            int i = 0;
            for(char ch : array){
                if(i < selectedText.length()-1){
                    if(!((ch == '/' && array[i+1] == '-') || (ch == '-' && array[i+1] == '/'))){
                        if(i > 0){
                            if(!((ch == '/' && array[i-1] == '-') || (ch == '-' && array[i-1] == '/'))){
                            uncommentedText += ch;
                        }
                        }else{
                            uncommentedText += ch;
                        }
                    }
                }else{
                    if(!((ch == '/' && array[i-1] == '-') || (ch == '-' && array[i-1] == '/'))){
                        uncommentedText += ch;
                    }
                }
                i++;
            }
            String newText = orignalText.replace(selectedText, uncommentedText);
            fileTabController.getTextArea().setText(newText);
        }
    }
    
  
    @FXML public void scanfile()  { 
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            String input = fileTabController.getTextArea().getText();
            
            FileManager fileManager = new FileManager();
            String fileName = "temp.txt";
            if(fileManager.creatFile(input, fileName)){
                
                Scanner scanner = new Scanner();
                ArrayList<Token> tokens = scanner.scan(fileName);
                fileManager.deleteFile(fileName); 
                
                ErrorMessages scanErrorMessage = new ErrorMessages();   
                String ErrorMessage = scanErrorMessage.ScanMessage(tokens);
                ErrorArea.setText(ErrorMessage);
                
                System.out.println(ErrorMessage);
            }else{
                System.out.println("Error in scanning");
            }
                 
        }
    }
    @FXML public void parsefile()  {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            String input = fileTabController.getTextArea().getText();
            
            FileManager fileManager = new FileManager();
            String fileName = "temp.txt";
            if(fileManager.creatFile(input, fileName)){
                
                Scanner scanner = new Scanner();
                ArrayList<Token> tokens = scanner.scan(fileName);
                fileManager.deleteFile(fileName); 
                Parser parser = new Parser();
                tokens.add(new Token("$",0,"Accepted"));
                ArrayList<Parse> parses = parser.parse(tokens);
                ErrorMessages parseErrorMessage = new ErrorMessages();   
                String ErrorMessage = parseErrorMessage.parseMessage(parses);
                ErrorArea.setText(ErrorMessage);
                
                System.out.println(ErrorMessage);
            }else{
                System.out.println("Error in Parsing");
            }
                 
        }

    }
    @FXML public void compilefile()  {
        FileTabController fileTabController = fileTabPaneController.getCurrentFileTabController();
        if (fileTabController != null) {
            String input = fileTabController.getTextArea().getText();
            
            FileManager fileManager = new FileManager();
            String fileName = "temp.txt";
            if(fileManager.creatFile(input, fileName)){
                
                Scanner scanner = new Scanner();
                ArrayList<Token> tokens = scanner.scan(fileName);
                fileManager.deleteFile(fileName); 
                Parser parser = new Parser();
                tokens.add(new Token("$",0,"Accepted"));
                ArrayList<Parse> parses = parser.parse(tokens);
                ErrorMessages compileErrorMessage = new ErrorMessages();   
                String ErrorMessage = compileErrorMessage.compileMessage(parses, tokens);
                ErrorArea.setText(ErrorMessage);
                
                System.out.println(ErrorMessage);
            }else{
                System.out.println("Error in Compiling");
            }
                 
        }
    }
    
    @FXML public void browsefile()  {
        try {
            File file = fileTabPaneController.chooseFile();
            if (file != null) {
                String message = "Chosse scan or parse";
                int choice = confirmBox.display("Choose", message,"Scan","Parse","Compile");
                Scanner scanner = new Scanner();
                ArrayList<Token> tokens = scanner.scan(file);
                Parser parser = new Parser();
                tokens.add(new Token("$",0,"Accepted"));
                ArrayList<Parse> parses = parser.parse(tokens);
                if(choice == 1){
                    // scan
                    ErrorMessages scanErrorMessage = new ErrorMessages();   
                    String ErrorMessage = scanErrorMessage.ScanMessage(tokens);
                    ErrorArea.setText(ErrorMessage);
                }else if(choice == 2){
                    //parse
                    ErrorMessages parseErrorMessage = new ErrorMessages();   
                    String ErrorMessage = parseErrorMessage.parseMessage(parses);
                    ErrorArea.setText(ErrorMessage);
                }else{
                    //compile
                    ErrorMessages compileErrorMessage = new ErrorMessages();   
                    String ErrorMessage = compileErrorMessage.compileMessage(parses, tokens);
                    ErrorArea.setText(ErrorMessage);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public Window getWindow() {
        return tabPane.getScene().getWindow();
    }
        @FXML private TabPane tabPane;
        
    
    
    // FXML VARIABLES: DO NOT CHANGE:
    
    @FXML private VBox vBox;
    @FXML private FileTabPaneController fileTabPaneController;
    @FXML private TextArea ErrorArea;
    // END OF FXML VARIABLES
}
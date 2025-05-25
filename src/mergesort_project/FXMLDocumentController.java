package mergesort_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import static mergesort_project.MergeSort.ArrayLength;
import static mergesort_project.MergeSort.array;

/**
 *
 * @author DELL
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label err1;
    @FXML
    private TextField length_array;
    public boolean Enter_Size_First = false;
    @FXML
    private Button MergeSort;
    @FXML
    private TextArea output;
    @FXML
    private Button again;

    public void Enter_size(ActionEvent event) throws IOException {
        try {
            ArrayLength = Integer.parseInt(length_array.getText());
            array = new int[ArrayLength];
            Enter_Size_First = true;
            System.out.println(Enter_Size_First);
            addControls(ArrayLength);

        } catch (NumberFormatException ex) {
            err1.setText(" * Please, Enter only numbers");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // Enter values of Array
    @FXML
    public VBox container1; 

    public void addControls(int arrayLength) {
        TextField field[] = new TextField[ArrayLength];
        for (int i = 0; i < arrayLength; i++) {
            Label label = new Label("Enter Value " + (i + 1) + " :");
            label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 22));
            label.setTextFill(Paint.valueOf("Yellow"));
            VBox.setMargin(label, new Insets(15, 15, 25, 15));
            field[i] = new TextField();
            VBox.setMargin(field[i], new Insets(0, 15, 25, 15));
         
         
            container1.getChildren().addAll(label, field[i]);
            
        }
           Button button = new Button("Enter values");
            button.setBackground(Background.fill(Paint.valueOf("Lime")));
            button.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            button.setTextFill(Paint.valueOf("Black"));
            button.setCursor(Cursor.HAND);
            VBox.setMargin(button, new Insets(15, 15, 25, 15));
               button.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                       MergeSort.setVisible(true);
                        AddValues_of_Array(field);
                }
            
            });
        container1.getChildren().add(button);
    }
    public void AddValues_of_Array(TextField f []){
        try{
              for(int j = 0 ; j < ArrayLength; j++){
              array[j] = Integer.parseInt(f[j].getText());
              }
        }
        catch (NumberFormatException ex) {
            err1.setText(" * Please, Enter only numbers");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void MergeSort(ActionEvent event) throws IOException {
         if (output != null) {
        for (int a = 0; a < ArrayLength; a++) {
            System.out.print(array[a] + "  ,  ");
        }
        output.setVisible(true);
        output.appendText("Given Array : \n");
        printArray(array, 0, ArrayLength);
        mergeSort(array, 0, ArrayLength - 1);
        output.appendText("\nSorted Array : \n");
        printArray(array, 0, ArrayLength);
        again.setVisible(true);
    } else {
        System.out.println("Output TextArea is null");
    }
    }
    
   

    // Merge Sort
  public  void mergeSort(int[] array, int start, int end) {
        if (end - start < 1) {
            return ;
        }
        int mid = (start + end) / 2 + 1;
        output.appendText("Dividing array from index " + start + " to " + (mid - 1) + "\n");

    mergeSort(array, start, mid - 1);

    output.appendText("Dividing array from index " + mid + " to " + end + "\n");
    mergeSort(array, mid, end);

    output.appendText("Merging arrays from index " + start + " to " + end + "\n");
    merge(array, start, mid, end);
     
    }
    
    // Merge Step
      public  void merge(int[] array, int start, int mid, int end) {
        int[] left = new int[mid - start];
        int[] right = new int[end - mid + 1];

        System.arraycopy(array, start, left, 0, mid - start);
        System.arraycopy(array, mid, right, 0, end - mid + 1);

        int i = 0, j = 0, k = start;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }

        printArray(array, start, end + 1);
    }
    
    // Print Array
    
        public  void printArray(int[] array, int start, int end) {
            output.appendText("[ ");
        for (int i = start; i < end; i++) {
            output.appendText(array[i] + "");
             if (i < end - 1) {
                output.appendText(" , ");
            }
        }
        output.appendText(" ]");
        output.appendText("\n");
    }

     // Start Again 
       public void StartAgain(ActionEvent event) throws IOException {
           ArrayLength = 0; 
           length_array.setText("");
            container1.getChildren().clear();
           Enter_Size_First = false;
           MergeSort.setVisible(false);
             output.setVisible(false);
              again.setVisible(false);
            }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

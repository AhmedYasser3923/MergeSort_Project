package mergesort_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MergeSort_Project extends Application  {
    
    @Override
    public void start(Stage stage) throws Exception {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load(); 
        Scene scene = new Scene(root, 1000, 777);
        FXMLDocumentController controller = loader.getController();
        System.out.println(controller.Enter_Size_First);
        if(!controller.Enter_Size_First){
             controller.container1.getChildren().clear();
        }
        else{
            System.out.println(controller.Enter_Size_First);
        controller.addControls(MergeSort.ArrayLength); 
            
        }
        stage.setScene(scene);
        stage.show();
    }

  
    public static void main(String[] args) {
        launch(args);
    }
    
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class MainChangeDifference {
	public static void main(String[] args) {
        // Use Java Collections to create the List
        List<String> list = new ArrayList<String>();
        list.add("d");list.add("b");list.add("a");list.add("c");
        
        // Now add observability by wrapping it with ObservableList
       ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });
        
        // Sort using FXCollections
        FXCollections.sort(observableList);
	}
}

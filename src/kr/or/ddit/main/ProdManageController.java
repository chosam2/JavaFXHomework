package kr.or.ddit.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ComboBox;

public class ProdManageController implements Initializable {

	@FXML
	TableColumn col_id;
	@FXML
	TableColumn col_name;
	@FXML
	TableColumn col_lgu;
	@FXML
	TableColumn col_buyer;
	@FXML
	TableColumn col_cost;
	@FXML
	TableColumn col_sale;
	@FXML
	TableColumn col_outline;
	@FXML
	TableColumn col_detail;
	@FXML
	ComboBox<String> cmb_left;
	@FXML
	ComboBox<String> cmb_right;

	ObservableList<String> list;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = FXCollections.observableArrayList();
		
		cmb_left.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
			}
		});
	}

}

package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class Z04_MemberMVCController implements Initializable {

	@FXML
	TextField input_id;
	@FXML
	TextField input_name;
	@FXML
	TextField input_tel;
	@FXML
	Button btn_add;
	@FXML
	Button btn_edit;
	@FXML
	Button btn_delete;
	@FXML
	Button btn_ok;
	@FXML
	Button btn_cancel;
	@FXML
	TableView<Member> tableView;
	@FXML
	TableColumn<Member, String> col_id;
	@FXML
	TableColumn<Member, String> col_name;
	@FXML
	TableColumn<Member, String> col_tel;
	@FXML
	TableColumn<Member, String> col_addr;
	@FXML
	TextField input_addr;

	ObservableList<Member> data;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		data = FXCollections.observableArrayList();

		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_id.setStyle("-fx-alignment: CENTER;");
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_name.setStyle("-fx-alignment: CENTER;");
		col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
		col_tel.setStyle("-fx-alignment: CENTER;");
		col_addr.setCellValueFactory(new PropertyValueFactory<>("addr"));
		col_addr.setStyle("-fx-alignment: CENTER;");

		tableView.setItems(data);

		btn_add.setOnAction(e -> {
			addBtnStart(e);

		});
	}

	private void addBtnStart(ActionEvent e) {
		if (input_id.getText().isEmpty() || input_name.getText().isEmpty() || input_tel.getText().isEmpty() || input_addr.getText().isEmpty()) {

			errMsg("작업 오류", "빈 항목이 있습니다");
			return;
		}

		data.add(new Member(input_id.getText(), input_name.getText(), input_tel.getText(), input_addr.getText()));

	}

	private void errMsg(String headerText, String msg) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류");
		errAlert.setHeaderText(headerText);
		errAlert.setContentText(msg);
		errAlert.showAndWait();
	}

	/**
	 * 정보메시지 출력
	 * @param headerText
	 * @param msg
	 */
	public void infoMsg(String headerText, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("정보 확인");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}

	public class Member {
		
		Member(String id, String name, String tel, String addr) {
			super();
			this.id = id;
			this.name = name;
			this.tel = tel;
			this.addr = addr;
		}

		private String id; // 아이디
		private String name; // 이름
		private String tel; // 전화번호
		private String addr; // 주소

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}
	}
}



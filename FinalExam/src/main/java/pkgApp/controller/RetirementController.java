package pkgApp.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {


    private RetirementApp mainApp = null;

    @FXML
    private TextField txtYearsToWork;
    @FXML
    private TextField txtAnnualReturn;
    @FXML
    private TextField txtYearsRetired;
    @FXML
    private TextField txtRetiredReturn;
    @FXML
    private TextField txtRequiredIncome;
    @FXML
    private TextField txtMonthlySSI;
    @FXML
    private Label MonthlyAmountSaved;
    @FXML
    private Label TotalAmountSaved;

    @FXML
    public RetirementApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(RetirementApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void btnClear(ActionEvent event) {
        System.out.println("Clear pressed");
        txtYearsToWork.clear();
        txtAnnualReturn.clear();
        txtYearsRetired.clear();
        txtRetiredReturn.clear();
        txtRequiredIncome.clear();
        txtMonthlySSI.clear();
        MonthlyAmountSaved.setText("");
        TotalAmountSaved.setText("");
    }

    @FXML
    public void btnCalculate(ActionEvent event) {
		if (InputValid()) {
			Retirement Ret = new Retirement(0, 0, 0, 0, 0, 0);

			Ret.setiYearsToWork(Integer.parseInt(txtYearsToWork.getText()));
			Ret.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturn.getText()));
			Ret.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
			Ret.setdAnnualReturnRetired(Double.parseDouble(txtRetiredReturn.getText()));
			Ret.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
			Ret.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));
            double MonthlyAmountSaved = Ret.AmountToSave();
            double TotalAmountSaved = Ret.TotalAmountSaved();

            DecimalFormat df = new DecimalFormat("#,###.00");

            String StrMonthlyAmountSaved = df.format(MonthlyAmountSaved);
            String StrTotalAmountSaved= df.format(TotalAmountSaved);

		}

    }

    private boolean InputValid() {

    	if (txtYearsToWork.getText().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("It can not be empty");
    		alert.show();
    		return false;
					}
    	try {
    		Integer.parseInt(txtYearsToWork.getText());
    		} catch (NumberFormatException e) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("You must input a valid integer");
    			alert.show();
    			return false;
    			}

    	if (txtAnnualReturn.getText().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("It can not be empty");
    		alert.show();
    		return false;
    		}
    	try {
    		double workReturn = Double.parseDouble(txtAnnualReturn.getText());
    		if (workReturn < 0 || workReturn > 0.2) {
    			Alert alert= new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("You must input a valid number b/w 0 and 0.2");
    			alert.show();
    			return false;
    			}
    		} catch (NumberFormatException e) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("You must input a valid number");
    			alert.show();
    			return false;
    			}

    	if (txtYearsRetired.getText().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("It can not be empty");
    		alert.show();
    		return false;
    		}
    	try {
    		Integer.parseInt(txtYearsRetired.getText());
    		} catch (NumberFormatException e) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("You must input a valid integer");
    			alert.show();
    			return false;
    			}

    	if (txtRetiredReturn.getText().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("It can not be empty");
    		alert.show();
    		return false;
    		}
    	try {
    		double RReturn = Double.parseDouble(txtRetiredReturn.getText());
    		if (RReturn < 0 || RReturn > 0.03) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("you must input a valid number b/w 0 and 0.03");
    			alert.show();
    			return false;
    			}
    		} catch (NumberFormatException e) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("You must input a number");
    			alert.show();
    			return false;
    			}

    	if (txtRequiredIncome.getText().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("It can not be empty");
    		alert.show();
    		return false;
    		}
    	try {
    		Double.parseDouble(txtRequiredIncome.getText());
    		} catch (NumberFormatException e) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("You must input a valid number");
    			alert.show();
    			return false;
    			}

    	if (txtMonthlySSI.getText().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("It can not be empty");
    		alert.show();
    		return false;
    		}
    	try {
    		Double.parseDouble(txtMonthlySSI.getText());
    		} catch (NumberFormatException e) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("Y");
    			alert.show();
    			return false;
    			}
    	return true;
    	}
}

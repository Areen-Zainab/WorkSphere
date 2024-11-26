package com.example.projecthr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;

public class ClientController {
    User currentUser;

    @FXML
    private Label namelabel, totalProj, ongoingProj;

    @FXML
    private PieChart projectPieChart;

    @FXML
    public void initialize() {
        if(projectPieChart != null) {
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Completed Projects", 60), // 60% completed
                    new PieChart.Data("Ongoing Projects", 40),   // 40% ongoing
                    new PieChart.Data("Pending Proposals", 2) // pending project proposals
            );

            // Set data to the pie chart
            projectPieChart.setData(pieChartData);
        }
        setCurrentUser();
        namelabel.setText(currentUser.getFirstName() + "'s Dashboard");
    }

    @FXML
    protected void onLogoutButtonClick() {
        ProjectApplication.switchScene("LoginForm.fxml");
    }

    @FXML
    protected void onProfileButtonClick() {
        ProjectApplication.switchScene("ClientProfile.fxml", 1000, 600);
    }

    @FXML
    protected void onProjectButtonClick() {
        if(!currentUser.setUpComplete()){
            showAlert(Alert.AlertType.ERROR, "Error", "Please, finish setting up your profile first!");
        }
        else{
            ProjectApplication.switchScene("ClientProject.fxml", 1000, 600);
        }
    }

    @FXML
    protected void onProposalButtonClick() {
        if(!currentUser.setUpComplete()){
            showAlert(Alert.AlertType.ERROR, "Error", "Please, finish setting up your profile first!");
        }
        else {
            ProjectApplication.switchScene("ClientProposals.fxml", 1000, 600);
        }
    }

    @FXML
    protected void onMeetingButtonClick() {
        if(!currentUser.setUpComplete()){
            showAlert(Alert.AlertType.ERROR, "Error", "Please, finish setting up your profile first!");
        }
        else{
            ProjectApplication.switchScene("ClientMeetings.fxml", 1000, 600);
        }
    }

    @FXML
    protected void onUpdateButtonClick() {
        System.out.println("Update Button clicked");
    }

    @FXML
    protected void onDashboardButtonClick() {
        ProjectApplication.switchScene("ClientDashboard.fxml", 1000, 600);
    }

    @FXML
    public void onMouseEntered(MouseEvent event) {
        if (event.getSource() instanceof Button button) {
            button.setStyle("-fx-background-color: rgba(120, 80, 50, 0.5); -fx-text-fill: white;  -fx-background-radius: 20;");
        }
    }

    @FXML
    public void onMouseExited(MouseEvent event) {
        if (event.getSource() instanceof Button button) {
            button.setStyle("-fx-background-color: transparent; -fx-text-fill: white;  -fx-background-radius: 20;");
        }
    }

    @FXML
    public void onOtherMouseExit(MouseEvent event) {
        if (event.getSource() instanceof Button button) {
            button.setStyle("-fx-background-color:  rgba(80, 45, 20, 0.6); -fx-text-fill: white;  -fx-background-radius: 20;");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        ProjectApplication.showAlert(alertType, title, message);
    }

    private void setCurrentUser(){
        currentUser = Factory.getFactory().getMainApp().getUser();
    }
}

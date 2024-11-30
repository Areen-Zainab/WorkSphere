package controller.hr;

import com.example.projecthr.ProjectApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class HRDashboardController {

    @FXML
    protected void onManageEmployeesClick() throws IOException {
        ProjectApplication.switchScene("adminManageEmployees.fxml");
    }

    @FXML
    protected void onProfileClick() throws IOException {
        ProjectApplication.switchScene("adminProfile.fxml");
    }

}
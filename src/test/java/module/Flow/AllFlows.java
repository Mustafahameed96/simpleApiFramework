package module.Flow;

import core.dbConnect.DbConnect;
import core.general.BaseTest;
import core.general.ReusableMethods;
import module.Validations.*;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class AllFlows extends BaseTest{
    public AllFlows(){}

    @Test
    public void createNewEmployee(){
        System.out.println("TEST CREATE !!!");

        CreateEmployees.sanityFlowCreateEmployees("Maaz", "10", "");
    }

    @Test
    public void updateEmployeeDetails(){
        System.out.println("TEST UPDATE!!!");
        FetchEmployees.sanityFlowFetchEmployees();

        List<String> id = response.jsonPath().getJsonObject("id");
        int random = ReusableMethods.generateRandomIntIntRange(0, 10);

        FetchRespectiveEmployees.sanityFlowFetchRespectiveEmployees(id.get(0));

        String name = response.path("employee_name").toString();
        String salary = response.path("employee_salary").toString();
        String age = response.path("employee_age").toString();

        UpdateEmployeeDetails.sanityFlowUpdateEmployeeDetails(id.get(0), name, salary, age);
    }

    @Test
    public void deleteEmployeeDetails(){
        System.out.println("TEST DELETE !!!");

        FetchEmployees.sanityFlowFetchEmployees();

        List<String> id = response.jsonPath().getJsonObject("id");
        DeleteEmployees.sanityFlowDeleteEmployees(id.get(5));
    }


    @Test
    public void testDB() throws SQLException {

        System.out.println(DbConnect.getOrderIDsList());
    }

}

package com.maslanka.out_of_office_solution_backend.Repositories;

import com.maslanka.out_of_office_solution_backend.Models.Employee;
import com.maslanka.out_of_office_solution_backend.Models.Project;
import com.maslanka.out_of_office_solution_backend.SelectionLists.EmployeeStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Get - filter
    public List<Employee> getEmployees(){
        StringBuilder query = new StringBuilder("SELECT * FROM employee WHERE 1=1");
        return jdbcTemplate.query(query.toString(), new EmployeeRepository.EmployeeRowMapper());
    }
    //Search by name

    //Add
    public int addEmployee(Employee employee){
        String sql = "INSERT INTO employee(fullname, subdivision, position, employeestatus, peoplepartner, outofofficebalance, photo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                employee.getFullName(),
                employee.getSubdivision().ordinal(),
                employee.getPosition().ordinal(),
                employee.getEmployeeStatus().ordinal(),
                employee.getPeoplePartner(),
                employee.getOutOfOfficeBalance(),
                employee.getPhoto());
    }
    //Update

    //Deactivate
    public void deactivateEmployee(int id){
        jdbcTemplate.update("UPDATE employee SET employeestatus = ? WHERE id = ?", EmployeeStatusEnum.INACTIVE, id);
    }
    //Assign to project

    private static final class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFullName(resultSet.getString("fullname"));
            employee.setSubdivision(resultSet.getInt("subdivision"));
            employee.setPosition(resultSet.getInt("position"));
            employee.setEmployeeStatus(resultSet.getInt("employeestatus"));
            employee.setPeoplePartner(resultSet.getObject("peoplepartner")!=null?resultSet.getInt("peoplepartner"): -1);
            employee.setOutOfOfficeBalance(resultSet.getInt("outofofficebalance"));
            employee.setPhoto(resultSet.getObject("photo")!=null?resultSet.getInt("photo"):-1);

            return employee;
        }
    }
}

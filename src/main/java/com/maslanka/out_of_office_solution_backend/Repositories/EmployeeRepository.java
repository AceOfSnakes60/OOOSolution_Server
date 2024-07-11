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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Get - filter
    public List<Employee> getEmployees(Map<String, String> params){

        String name = params.get("fullName");
        String sortBy = params.getOrDefault("sortBy", "id");
        String sortOrder = params.getOrDefault("sortOrder", "asc");
        //int page = params.containsKey("page") ? Integer.valueOf(params.get("page")) : 0;
        //int size = params.containsKey("size") ? Integer.valueOf(params.get("size")) : 10;

        StringBuilder query = new StringBuilder("SELECT * FROM employee WHERE 1=1");
        List<Object> queryParams = new ArrayList<>();

        if(name != null){
            query.append(" AND name = ?");
            queryParams.add(name);
        }

        query.append(" ORDER BY ").append(sortBy).append(" ").append(sortOrder);
        //query.append(" LIMIT ").append(size).append(" OFFSET ").append(page * size);

        return jdbcTemplate.query(query.toString(), queryParams.toArray(), new EmployeeRepository.EmployeeRowMapper());
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

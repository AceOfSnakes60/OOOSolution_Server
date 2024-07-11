package com.maslanka.out_of_office_solution_backend.Repositories;


import com.maslanka.out_of_office_solution_backend.Models.Project;
import com.maslanka.out_of_office_solution_backend.SelectionLists.ProjectStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Sort/filter/search
    public List<Project> getProjects(){
        StringBuilder query = new StringBuilder("SELECT * FROM project WHERE 1=1");

        return jdbcTemplate.query(query.toString(), new ProjectRowMapper());
    }

    //get details

    public List<Project> findById(int id){
        return jdbcTemplate.query("SELECT * from projects WHERE id = " + id, new ProjectRowMapper());
    }


    //Add/update/deactivate

    public int addProject(Project project){
        String sql = "INSERT INTO project(projecttype, startdate, enddate, manager, comment, projectstatus) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                project.getProjectType().ordinal(),
                project.getStartDate(),
                project.getEndDate(),
                project.getManager(),
                project.getComment(),
                project.getProjectStatus().ordinal());
    }

    public void deactivateProject(int id){
        jdbcTemplate.update("UPDATE project SET projectstatus = ? WHERE id = ?", ProjectStatusEnum.INACTIVE, id);
    }

    private final class ProjectRowMapper implements RowMapper<Project> {
        @Override
        public Project mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Project project = new Project();
            project.setId(resultSet.getInt("id"));
            project.setProjectType(resultSet.getInt("projecttype"));
            project.setStartDate(resultSet.getDate("startdate"));
            project.setEndDate(resultSet.getDate("endDate"));
            project.setManager(resultSet.getInt("manager"));
            project.setComment(resultSet.getString("comment"));
            project.setProjectStatus(resultSet.getInt("projectstatus"));

            return project;
        }
    }
}

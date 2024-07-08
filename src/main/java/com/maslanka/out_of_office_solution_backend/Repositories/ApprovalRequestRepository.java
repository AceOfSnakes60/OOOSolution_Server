package com.maslanka.out_of_office_solution_backend.Repositories;

import com.maslanka.out_of_office_solution_backend.Models.ApprovalRequest;
import com.maslanka.out_of_office_solution_backend.SelectionLists.ApprovalStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ApprovalRequestRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ApprovalRequest> getAllARequests() {
        String sql = "SELECT * FROM approvalrequest";
        return jdbcTemplate.query(sql, new approvalRequestRowMapper());
    }

    //Sort/filter/search
    //open with details


    //Approve or reject Request
    public void changeApprovalRequestStatus(ApprovalStatusEnum newStatus, int id){
        jdbcTemplate.update("UPDATE approvalrequest SET approvalstatus = ? WHERE id = ?", newStatus, id);
    }

    //Create approval
    public int addApprovalRequest(ApprovalRequest approvalRequest){
        String sql = "INSERT INTO approvalrequest(approver, leaverequest, approvalstatus, comment) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                approvalRequest.getApprover(),
                approvalRequest.getLeaveRequest(),
                approvalRequest.getApprovalStatus(),
                approvalRequest.getComment(),
                approvalRequest.getApprovalStatus());
    }

    private final class approvalRequestRowMapper implements RowMapper<ApprovalRequest> {
        @Override
        public ApprovalRequest mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            ApprovalRequest approvalRequest = new ApprovalRequest();
            approvalRequest.setID(resultSet.getInt("id"));
            approvalRequest.setApprover(resultSet.getInt("approver"));
            approvalRequest.setLeaveRequest(resultSet.getInt("leaverequest"));
            approvalRequest.setApprovalStatus(resultSet.getInt("approvalstatus"));
            approvalRequest.setComment(resultSet.getString("comment"));
            return approvalRequest;
        }
    }
}
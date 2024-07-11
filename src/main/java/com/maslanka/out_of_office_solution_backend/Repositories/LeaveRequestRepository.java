package com.maslanka.out_of_office_solution_backend.Repositories;


import com.maslanka.out_of_office_solution_backend.Models.LeaveRequest;
import com.maslanka.out_of_office_solution_backend.SelectionLists.ApprovalStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LeaveRequestRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Get: Sort-Filter
    public List<LeaveRequest> getLeaveRequests(){
        StringBuilder query = new StringBuilder("SELECT * FROM leaverequest WHERE 1=1");
        return jdbcTemplate.query(query.toString(), new LeaveRequestRepository.LeaveRequestRowMapper());
    }

    // Search by name
    public List<LeaveRequest> findById(int id){
        return jdbcTemplate.query("SELECT * from leaverequest WHERE id = " + id, new LeaveRequestRepository.LeaveRequestRowMapper());
    }

    // Approve/Reject
    public void changeLeaveRequestStatus(int id, ApprovalStatusEnum newStatus){
        jdbcTemplate.update("UPDATE leaverequest SET approvalstatus = ? WHERE id = ?", newStatus, id);
    }

    // Create Request
    public int addLeaveRequest(LeaveRequest leaveRequest){
        String sql = "INSERT INTO leaverequest(employee, absencereason, startdate, enddate, comment, approvalstatus) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                leaveRequest.getEmployee(),
                leaveRequest.getAbsenceReason().ordinal(),
                leaveRequest.getStartDate(),
                leaveRequest.getEndDate(),
                leaveRequest.getComment(),
                leaveRequest.getApprovalStatus().ordinal());
    }

    // Update Request
    //

    private static final class LeaveRequestRowMapper implements RowMapper<LeaveRequest> {
        @Override
        public LeaveRequest mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            LeaveRequest leaveRequest = new LeaveRequest();
            leaveRequest.setId(resultSet.getInt("id"));
            leaveRequest.setEmployee(resultSet.getInt("employee"));
            leaveRequest.setAbsenceReason(resultSet.getInt("absencereason"));
            leaveRequest.setStartDate(resultSet.getDate("startdate"));
            leaveRequest.setEndDate(resultSet.getDate("enddate"));
            leaveRequest.setComment(resultSet.getString("comment"));
            leaveRequest.setApprovalStatus(resultSet.getInt("approvalStatus"));

            return leaveRequest;
        }
    }
}

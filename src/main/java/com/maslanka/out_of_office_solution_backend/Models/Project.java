package com.maslanka.out_of_office_solution_backend.Models;

import com.maslanka.out_of_office_solution_backend.SelectionLists.ProjectStatusEnum;
import com.maslanka.out_of_office_solution_backend.SelectionLists.ProjectTypeEnum;

import java.util.Date;

public class Project {
    private int id;
    private ProjectTypeEnum projectType;
    private Date startDate;
    private Date endDate;
    private int manager;
    private String comment;
    private ProjectStatusEnum projectStatus;

    public void setId(int id) {
        this.id = id;
    }

    public ProjectTypeEnum getProjectType() {
        return projectType;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ProjectStatusEnum getProjectStatus() {
        return projectStatus;
    }

    public void setProjectType(int projecttype) {
        this.projectType = ProjectTypeEnum.values()[projecttype];
    }

    public void setProjectStatus(int projectstatus) {
        this.projectStatus = ProjectStatusEnum.values()[projectstatus];
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getManager() {
        return manager;
    }

    public String getComment() {
        return comment;
    }

    public int getId() {
        return id;
    }
}

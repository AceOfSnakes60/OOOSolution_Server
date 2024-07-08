package com.maslanka.out_of_office_solution_backend.Models;

import com.maslanka.out_of_office_solution_backend.SelectionLists.EmployeeStatusEnum;
import com.maslanka.out_of_office_solution_backend.SelectionLists.PositionEnum;
import com.maslanka.out_of_office_solution_backend.SelectionLists.SubdivisionEnum;

import java.sql.Date;

public class Employee {
    private int id;
    private String fullName;
    private SubdivisionEnum subdivision;
    private PositionEnum position;
    private EmployeeStatusEnum employeeStatus;
    private int peoplePartner; // FK Single choice from the “Employee” table with “HR Manager” position
    private int outOfOfficeBalance; //Number of available day-offs
    private int photo;

    public void setId(int id){ this.id = id; }
    public void setFullName(String fullName){ this.fullName = fullName; }
    public void setSubdivision(int subdivision){ this.subdivision = SubdivisionEnum.values()[subdivision]; }
    public void setPosition(int position){ this.position = PositionEnum.values()[position];}
    public void setEmployeeStatus(int employeeStatus){ this.employeeStatus = EmployeeStatusEnum.values()[employeeStatus];}
    public void setPeoplePartner(int peoplePartner){ this.peoplePartner = peoplePartner; }
    public void setOutOfOfficeBalance(int outOfOfficeBalance){ this.outOfOfficeBalance = outOfOfficeBalance;}
    public void setPhoto(int photo){this.photo = photo;}

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public SubdivisionEnum getSubdivision() {
        return subdivision;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public EmployeeStatusEnum getEmployeeStatus() {
        return employeeStatus;
    }

    public int getPeoplePartner() {
        return peoplePartner;
    }

    public int getOutOfOfficeBalance() {
        return outOfOfficeBalance;
    }

    public int getPhoto() {
        return photo;
    }
}


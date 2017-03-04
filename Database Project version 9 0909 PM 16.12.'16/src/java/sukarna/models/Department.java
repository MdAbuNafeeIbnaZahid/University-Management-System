/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukarna.models;

/**
 *
 * @author nafeedgbhs
 */
public class Department {
    int departmentID;
    String departmentName;
    int departmentHeadID;
    String departmentHeadUsername;

    public Department() {
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentHeadID() {
        return departmentHeadID;
    }

    public void setDepartmentHeadID(int departmentHeadID) {
        this.departmentHeadID = departmentHeadID;
    }

    public String getDepartmentHeadUsername() {
        return departmentHeadUsername;
    }

    public void setDepartmentHeadUsername(String departmentHeadUsername) {
        this.departmentHeadUsername = departmentHeadUsername;
    }

    
    
}

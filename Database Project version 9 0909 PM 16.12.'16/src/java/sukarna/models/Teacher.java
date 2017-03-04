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
public class Teacher {
    int teacherID;
    String username;
    String firstName;
    String lastName;
    String address;
    String phoneNumber;
    String emailAddress;
    double salary;
    String joinDate;
    String departmentName;
    String teacherRank;

    public Teacher() {
    }

    
    
    public Teacher(int teacherID, String username, String firstName, String lastName, String address, 
            String phoneNumber, String emailAddress, double salary, String joinDate, 
            String departmentName, String teacherRank) 
    {
        this.teacherID = teacherID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.salary = salary;
        this.joinDate = joinDate;
        this.departmentName = departmentName;
        this.teacherRank = teacherRank;
    }

    public String getTeacherRank() {
        return teacherRank;
    }

    public void setTeacherRank(String teacherRank) {
        this.teacherRank = teacherRank;
    }

    
    
    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherID=" + teacherID + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", salary=" + salary + ", joinDate=" + joinDate + ", departmentName=" + departmentName + ", teacherRank=" + teacherRank + '}';
    }

    
    
    
}

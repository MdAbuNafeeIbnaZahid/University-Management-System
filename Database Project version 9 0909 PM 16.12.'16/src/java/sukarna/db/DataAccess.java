/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukarna.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sukarna.models.BankTransaction;
import sukarna.models.Course;
import sukarna.models.Department;
import sukarna.models.Teacher;


/**
 *
 * @author samsung
 */
public class DataAccess 
{
    String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "COURSE_MANAGEMENT";
    String password = "1234";

    Connection conn = null;
    public DataAccess()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            System.out.println( "Failed to create DataAccess" );
        }
    }
    
    //By Nafee
    public int addNewClass(String monthOfClass, int yearOfClass, String departmentName, int courseNumber)
    {
        int ret = 0;
        String call;
        call = "{ call ADD_NEW_CLASS( ?, ?, ?, ?, ? ) }";
        
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            
            cstmt.setString("MONTH_OF_CLASS", monthOfClass);
            cstmt.setInt("YEAR_OF_CLASS", yearOfClass);
            cstmt.setString("DEPARTMENT_NAME", departmentName);
            cstmt.setInt("COURSE_NUMBER", courseNumber);
            
            cstmt.registerOutParameter("IF_SUCCESS", oracle.jdbc.OracleTypes.NUMBER);
            
            cstmt.executeUpdate();
            
            System.out.println( "cstmt executed" );
            
            ret = cstmt.getInt("IF_SUCCESS");
            
            System.out.println( "ret = cstmt.getInt(1); executed" );
        }
        catch(Exception e)
        {
            System.out.println("Caught exception in addNewCourse() in DataAccess");
        }
        return ret;
    }
    
    
    //By Nafee
    public ArrayList<Course> getCoursesByDepartmentName(String departmentName)
    {
        ArrayList<Course> ret = new ArrayList<Course>();
        
        
        
        String selectStatement = "SELECT COURSE_ID, COURSE_NUMBER, COURSE_NAME, CREDIT_HOURS, " 
                + " DEPARTMENT_ID, Get_Dept_Name_From_Dept_ID(DEPARTMENT_ID ) DEPT_NAME " 
                + "FROM COURSE "
                + " WHERE Get_Dept_Name_From_Dept_ID(DEPARTMENT_ID ) = ? " ;
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, departmentName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Course course = new Course();
                
                int courseID = rs.getInt("COURSE_ID");
                int courseNumber = rs.getInt("COURSE_NUMBER");
                String  courseName = rs.getString("COURSE_NAME");
                double creditHours = rs.getDouble("CREDIT_HOURS");
                int departmentID = rs.getInt("DEPARTMENT_ID");
                //String departmentName = rs.getString("DEPT_NAME");
                
                //course.setCourseID(courseID);
                course.setCourseNumber(courseNumber);
                course.setCourseName(courseName);
                course.setCreditHours(creditHours);
                course.setDepartmentName(departmentName);
                
                ret.add( course );
            }
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            System.out.println("Caught exception inside getCoursesByDepartmentName() inside DataAccess");
            System.out.println( e );
        }
        
        return ret;

    }
    
    //By Nafee
    public int addNewCourse(int courseNumber, String courseName, double creditHours, String departmentName)
    {
        int ret = 0;
        String call;
        call = "{ call ADD_NEW_COURSE( ?, ?, ?, ?, ? ) }";
        
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            
            cstmt.setInt("COURSE_NUMBER", courseNumber);
            cstmt.setString("COURSE_NAME", courseName);
            cstmt.setDouble("CREDIT_HOURS", creditHours);
            cstmt.setString("DEPARTMENT_NAME", departmentName);
            
            cstmt.registerOutParameter("IF_SUCCESS", oracle.jdbc.OracleTypes.NUMBER);
            
            cstmt.executeUpdate();
            
            System.out.println( "cstmt executed" );
            
            ret = cstmt.getInt("IF_SUCCESS");
            
            System.out.println( "ret = cstmt.getInt(1); executed" );
        }
        catch(Exception e)
        {
            System.out.println("Caught exception in addNewCourse() in DataAccess");
        }
        return ret;
    }
    
    
    //By Nafee
    public ArrayList<Department> getAllDepartments()
    {
        ArrayList<Department> ret = new ArrayList<Department>();
        
        String selectStatement = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, HEAD_ID, " + 
                " Get_USERNAME_From_TEACHER_ID(HEAD_ID) DEPARTMENT_HEAD_USERNAME FROM DEPT " ;
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                
                Department department = new Department();
                
                int departmentID = rs.getInt("DEPARTMENT_ID");
                String departmentName = rs.getString("DEPARTMENT_NAME");
                int departmentHeadID = rs.getInt("HEAD_ID");
                String departmentHeadUsername = rs.getString("DEPARTMENT_HEAD_USERNAME");
                
                department.setDepartmentID(departmentID);
                department.setDepartmentName(departmentName);
                department.setDepartmentHeadID(departmentHeadID);
                department.setDepartmentHeadUsername( departmentHeadUsername );
                
                
                ret.add( department );
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in getAllDepartments() ");
        }
        
        return ret;
    }
    
    //By Nafee
    public int setDepartmentHead(String departmentName, String teacherUsername)
    {
        int ret = 0;
        String call;
        call = "{  call SET_DEPARTMENT_HEAD( ?, ?, ? ) }";
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            cstmt.registerOutParameter("IF_SUCCESS", oracle.jdbc.OracleTypes.NUMBER);
            
            cstmt.setString("D_NAME", departmentName);
            cstmt.setString("T_UN", teacherUsername);
            
            cstmt.executeUpdate();
            
            ret = cstmt.getInt("IF_SUCCESS");
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in setDepartmentHead in DataAceess");
        }
        return ret;
    }
    
    
    //By Nafee
    public int updateTeacherInfoUsernameGiven(String username, String firstName, String lastName,  String address, String phoneNumber,
            String emailAddress)
    {
        
        int ret = 0;
        String call;
        call = "{  call EDIT_TEACHER_INFO_UN_GIVEN( ?, ?, ?, ?, ?, ?, ? ) }";
        
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            cstmt.registerOutParameter("IF_SUCCESS", oracle.jdbc.OracleTypes.NUMBER);
            
            cstmt.setString("T_USERNAME", username);
            cstmt.setString("T_FIRST_NAME", firstName);
            cstmt.setString("T_LAST_NAME", lastName);
            cstmt.setString("T_ADDRESS", address);
            cstmt.setString("T_PHONE_NUMBER", phoneNumber);
            cstmt.setString("T_EMAIL_ADDRESS", emailAddress);
            
            cstmt.executeUpdate();
            
            ret = cstmt.getInt("IF_SUCCESS");
        }
        catch(Exception e)
        {
            System.out.println("Exception in updateTeacherInfoUsernameGiven in DataAceess");
        }
        return ret;
    }
    
    //By Nafee
    public Teacher getTeacherByUsername(String username)
    {
        Teacher ret = new Teacher();
        
        String procedureStatement = " { call GET_TEACHER_INFO_FROM_USERNAME(?, ?, ?, ?, ?, ?, ?, ?) } " ;
        
        try
        {    
            CallableStatement cStmt = conn.prepareCall( procedureStatement );
            
            cStmt.registerOutParameter("T_FIRST_NAME", oracle.jdbc.OracleTypes.VARCHAR);
            cStmt.registerOutParameter("T_LAST_NAME", oracle.jdbc.OracleTypes.VARCHAR);
            cStmt.registerOutParameter("T_ADDRESS", oracle.jdbc.OracleTypes.VARCHAR);
            cStmt.registerOutParameter("T_PHONE_NUMBER", oracle.jdbc.OracleTypes.VARCHAR);
            cStmt.registerOutParameter("T_EMAIL_ADDRESS", oracle.jdbc.OracleTypes.VARCHAR);
            cStmt.registerOutParameter("T_DEPARTMENT_NAME", oracle.jdbc.OracleTypes.VARCHAR);
            cStmt.registerOutParameter("T_TEACHER_RANK", oracle.jdbc.OracleTypes.VARCHAR);
            
            
            cStmt.setString("T_USERNAME", username);
            
            cStmt.execute();
            
            
            String firstName = cStmt.getString("T_first_name");
            String lastName = cStmt.getString("T_last_name");
            String address = cStmt.getString("T_address");
            String phoneNumber = cStmt.getString("T_phone_number");
            String emailAddress = cStmt.getString("T_email_address");
            String departmentName = cStmt.getString("T_DEPARTMENT_NAME");
            String teacherRank = cStmt.getString("T_TEACHER_RANK");

            ret.setUsername(username);
            ret.setFirstName(firstName);
            ret.setLastName(lastName);
            ret.setAddress(address);
            ret.setPhoneNumber(phoneNumber);
            ret.setEmailAddress(emailAddress);
            ret.setDepartmentName(departmentName);
            ret.setTeacherRank(teacherRank);


        }
        catch(Exception e)
        {
            System.out.println("caught exception inside getTeacherByUsername ");
        }
        return ret;
    }
    

    
    //By Nafee
    public ArrayList<Teacher> getTeachersByRank(String teacherRank)
    {
        ArrayList<Teacher> ret = new ArrayList<Teacher>();
        
        String selectStatement = "SELECT TEACHER_ID, username, first_name, last_name, address, phone_number, "
                + " email_address, salary, TO_CHAR(join_date) dt, DEPARTMENT_ID, " 
                + " Get_Dept_Name_From_Dept_ID(DEPARTMENT_ID ) DEPT_NAME, TEACHER_RANK FROM TEACHER " 
                + " WHERE LOWER(TEACHER_RANK) = ? " ;
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, teacherRank);
            
            System.out.println(" Inside dataaccess inside getTeachersByRank teacherRank = " + teacherRank);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                
                Teacher teacher = new Teacher();
                
                int teacherID = rs.getInt("TEACHER_ID");
                String username = rs.getString("username");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");
                String emailAddress = rs.getString("email_address");
                double salary = rs.getDouble("salary");
                String date = rs.getString("dt");
                String departmentName = rs.getString("DEPT_NAME");
                //String teacherRank = rs.getString("TEACHER_RANK");
                
                teacher.setTeacherID(teacherID);
                teacher.setUsername(username);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setAddress(address);
                teacher.setPhoneNumber(phoneNumber);
                teacher.setEmailAddress(emailAddress);
                teacher.setDepartmentName(departmentName);
                teacher.setTeacherRank(teacherRank);
                
                
                ret.add( teacher );
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in getTeachersByRank");
        }
        
        return ret;

    }
    
    
    
    //By Nafee
    public Teacher getHeadTeacherByDepartmentName(String departmentName)
    {
        Teacher ret = new Teacher();
        
        String selectStatement = "SELECT TEACHER_ID, username, first_name, last_name, address, phone_number, "
                + " email_address, salary, TO_CHAR(join_date) dt, DEPARTMENT_ID, " 
                + " TEACHER_RANK FROM TEACHER " 
                + " WHERE TEACHER_ID = Get_Head_ID_From_Dept_Name(?) " ;
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, departmentName);
            ResultSet rs = stmt.executeQuery();
            if( rs.next() )
            {
                int teacherID = rs.getInt("TEACHER_ID");
                String username = rs.getString("username");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");
                String emailAddress = rs.getString("email_address");
                double salary = rs.getDouble("salary");
                String date = rs.getString("dt");
//                String departmentName = rs.getString("DEPT_NAME");
                String teacherRank = rs.getString("TEACHER_RANK");
                
                
                ret.setTeacherID(teacherID);
                ret.setUsername(username);
                ret.setFirstName(firstName);
                ret.setLastName(lastName);
                ret.setAddress(address);
                ret.setPhoneNumber(phoneNumber);
                ret.setEmailAddress(emailAddress);
                ret.setDepartmentName(departmentName);
                ret.setTeacherRank(teacherRank);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return ret;

    }
    
    
    
    //By Nafee
    public int getDeptIDFromDeptName(String departmentName)
    {
        int ret = 0;
        String call;
        call = "{ ? = call Get_Dept_ID_From_Dept_Name(? ) }";
        
        //call = "{ ? = call Get_Dept_ID_From_Dept_Name(  ? ) }";
        
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            
            cstmt.setString(2, departmentName);
            
            
            cstmt.executeUpdate();
            
            //System.out.println( "cstmt executed" );
            
            ret = cstmt.getInt(1);
            
            //System.out.println( "ret = cstmt.getInt(1); executed" );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return ret;
    }
    
    
    
    //By Nafee
    public ArrayList<Teacher> getTeachersByLastName(String teacherLastName)
    {
        ArrayList<Teacher> ret = new ArrayList<Teacher>();
                
        String selectStatement = "SELECT TEACHER_ID, username, first_name, last_name, address, phone_number, "
                + " email_address, salary, TO_CHAR(join_date) dt, DEPARTMENT_ID, " 
                + " Get_Dept_Name_From_Dept_ID(DEPARTMENT_ID ) DEPT_NAME, TEACHER_RANK FROM TEACHER " 
                + " WHERE LAST_NAME = ? " ;
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, teacherLastName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Teacher teacher = new Teacher();
                
                int teacherID = rs.getInt("TEACHER_ID");
                String username = rs.getString("username");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");
                String emailAddress = rs.getString("email_address");
                double salary = rs.getDouble("salary");
                String date = rs.getString("dt");
                String departmentName = rs.getString("DEPT_NAME");
                String teacherRank = rs.getString("TEACHER_RANK");
                
                teacher.setTeacherID(teacherID);
                teacher.setUsername(username);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setAddress(address);
                teacher.setPhoneNumber(phoneNumber);
                teacher.setEmailAddress(emailAddress);
                teacher.setDepartmentName(departmentName);
                teacher.setTeacherRank(teacherRank);
                
                
                ret.add( teacher );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return ret;

    }
    
    //By Nafee
    public ArrayList<Teacher> getTeachersByDepartmentName(String departmentName)
    {
        ArrayList<Teacher> ret = new ArrayList<Teacher>();
        
        /*
        String selectStatement = "select accountno, amount,"
                + "to_char(datetime,'DD/MM/YY hh:mi') dt from banktransaction"
                + " where accountno = ? order by datetime asc";
        
        */
        
        
        String selectStatement = "SELECT TEACHER_ID, username, first_name, last_name, address, phone_number, "
                + " email_address, salary, TO_CHAR(join_date) dt, DEPARTMENT_ID, " 
                + " Get_Dept_Name_From_Dept_ID(DEPARTMENT_ID ) DEPT_NAME, TEACHER_RANK FROM TEACHER " 
                + " WHERE Get_Dept_Name_From_Dept_ID(DEPARTMENT_ID ) = ? " ;
        
        
        /*
        String selectStatement = "SELECT *,  TO_CHAR(join_date) dt, " 
                + " Get_Dept_Name_From_Dept_ID(DEPARTMENT_ID ) DEPT_NAME " 
                + " FROM TEACHER " 
                + " WHERE LAST_NAME = ? " ;
        */
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, departmentName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                /*
                String accountno = rs.getString("accountno");
                double amount = rs.getDouble("amount");
                Saftring datetime = rs.getString("dt");
                BankTransaction trans = new BankTransaction(accountno, amount, datetime);
                transactions.add(trans);
                */
                
                Teacher teacher = new Teacher();
                
                int teacherID = rs.getInt("TEACHER_ID");
                String username = rs.getString("username");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");
                String emailAddress = rs.getString("email_address");
                double salary = rs.getDouble("salary");
                String date = rs.getString("dt");
//                String departmentName = rs.getString("DEPT_NAME");
                String teacherRank = rs.getString("TEACHER_RANK");
                
                teacher.setTeacherID(teacherID);
                teacher.setUsername(username);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setAddress(address);
                teacher.setPhoneNumber(phoneNumber);
                teacher.setEmailAddress(emailAddress);
                teacher.setDepartmentName(departmentName);
                teacher.setTeacherRank(teacherRank);
                
                
                ret.add( teacher );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return ret;

    }
    
    
    //By Nafee
    public int addNewStudent(String username, String pass, String firstName, String lastName, String address,
            String phoneNumber, String emailAddress, String lev, String term, String departmentName)
    {
        int ret = 0;
        String call;
        call = "{ ? = call ADD_NEW_Student( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }";
        
        //call = "{ ? = call Get_Dept_ID_From_Dept_Name(  ? ) }";
        
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            
            //cstmt.setString(2, departmentName);
            
            
            cstmt.setString(2, username);
            cstmt.setString(3, pass);
            cstmt.setString(4, firstName);
            cstmt.setString(5, lastName);
            cstmt.setString(6, address);
            cstmt.setString(7, phoneNumber);
            cstmt.setString(8, emailAddress);
            cstmt.setString(9, lev );
            cstmt.setString(10, term );
            cstmt.setString(11, departmentName);
            
            cstmt.executeUpdate();
            
            System.out.println( "cstmt executed" );
            
            ret = cstmt.getInt(1);
            
            System.out.println( "ret = cstmt.getInt(1); executed" );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return ret;
    }
    
    
    //By Nafee
    public int doUsernamePasswordExist(String username, String pass, String userType)
    {
        int ret = 0;
        String call;
        call = "{ ? = call Do_Username_Password_Exist( ?, ?, ? ) }";
        
        //call = "{ ? = call Get_Dept_ID_From_Dept_Name(  ? ) }";
        
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            
            cstmt.setString(2, username);
            cstmt.setString(3, pass);
            cstmt.setString(4, userType);
                 
            cstmt.executeUpdate();
            
            System.out.println( "cstmt executed" );
            
            ret = cstmt.getInt(1);
            
            System.out.println( "ret = cstmt.getInt(1); executed" );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return ret;
    }
    
    //By Nafee
    public int addNewTeacher(String username, String pass, String firstName, String lastName, String address,
            String phoneNumber, String emailAddress, String joinDate, String departmentName, String teacherRank)
    {
        System.out.println("teacherRank = " + teacherRank);
        
        int ret = 0;
        String call;
        call = "{ ? = call ADD_NEW_Teacher( ?, ?, ?, ?, ?, ?, ?,  TO_DATE( ?, 'DD/MM/YYYY'), ?, ? ) }";
        
        //call = "{ ? = call Get_Dept_ID_From_Dept_Name(  ? ) }";
        
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            
            //cstmt.setString(2, departmentName);
            
            
            cstmt.setString(2, username);
            cstmt.setString(3, pass);
            cstmt.setString(4, firstName);
            cstmt.setString(5, lastName);
            cstmt.setString(6, address);
            cstmt.setString(7, phoneNumber);
            cstmt.setString(8, emailAddress);
            cstmt.setString(9, joinDate );
            cstmt.setString(10, departmentName);
            cstmt.setString(11, teacherRank);
            
            //System.out.println( "departmentName = " + departmentName );
            
            cstmt.executeUpdate();
            
            //System.out.println( "cstmt executed" );
            
            ret = cstmt.getInt(1);
            
            //System.out.println( "ret = cstmt.getInt(1); executed" );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return ret;
    }
    
    //By Nafee
    public int addNewDepartment(String departmentName)
    {
        int ret = 0;
        String call;
        call = "{ ? = call ADD_NEW_Department( ?) }";
        
        try
        {
            CallableStatement cstmt = conn.prepareCall( call );
            cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            cstmt.setString(2, departmentName);
            cstmt.executeUpdate();
            ret = cstmt.getInt(1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return ret;
    }
    
    public List<String> getEmployeeNames()
    {
        List<String> employeeNames = new ArrayList<String>();
        String selectStatement = "select first_name, last_name from employees";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String name = first + " " + last;
                employeeNames.add(name);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return employeeNames;
    }
    public int createAccount(String firstName, String lastName, String username, 
            String password)
    {
        try
        {
            String insertCommand = "insert into account values(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, username);
            stmt.setString(4, password);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }       
    }
    
    public int addNewTeacher(String teacherID, String firstName, String lastName, String address, 
            String phoneNo, String emailAddress, String departmentID)
    {
        try
        {
            String insertCommand = "insert into Teacher values(?,?,?,?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, teacherID);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, address);
            stmt.setString(5, phoneNo);
            stmt.setString(6, emailAddress);
            stmt.setString(7, "100");
            stmt.setString(8, "09/10/2016");
            stmt.setString(9, departmentID);
            
            
            int count = stmt.executeUpdate();
            
            System.out.println("Nafee debug In data access. stmt.execeuteUpdate run, count = " +  count);
            
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }       
    }
    
   
    public boolean existUser(String username,String password)
    {
        try
        {
            String query = "select * from account where username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean ifTeacherExist(String teacherID)
    {
        try
        {
            String query = "select * from TEACHER where TEACHER_ID = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, teacherID);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<BankTransaction> getTransactions(String bankAccountNo)
    {
        ArrayList<BankTransaction> transactions = new ArrayList<BankTransaction>();
        
        String selectStatement = "select accountno, amount,"
                + "to_char(datetime,'DD/MM/YY hh:mi') dt from banktransaction"
                + " where accountno = ? order by datetime asc";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, bankAccountNo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String accountno = rs.getString("accountno");
                double amount = rs.getDouble("amount");
                String datetime = rs.getString("dt");
                BankTransaction trans = new BankTransaction(accountno, amount, datetime);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return transactions;

    }
    
    public boolean processTransaction(String bankAccountNo, double amount)
    {
        String sql = "{ call processTransaction(?,?) }";
        try
        {
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,bankAccountNo);
            statement.setDouble(2,amount);
            statement.execute();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }     
    }
/*
//Call function sample:
    
    String sql = "{ ? = call FUNCT_PERSON(?,?) }";
    CallableStatement statement = connection.prepareCall(sql);
    statement.setString(2,username);
    statement.setString(3,password);
    statement.registerOutParameter(1, java.sql.Types.INTEGER);  

    statement.execute();   
    //this is the main line
    long id = statement.getLong(1);
    if (id > 0) {
        //proceed to another page
    } else {
        //Go back to the login page
    }*/
    
 /*
    String sql = "{ call PROC_PERSON(?,?,?) }";
    CallableStatement statement = connection.prepareCall(sql);
    statement.setString(2,username);
    statement.setString(3,password);
    statement.registerOutParameter(1, java.sql.Types.INTEGER);  

    statement.execute();   
    //this is the main line
    long id = statement.getLong(1);
    if (id > 0) {
        //proceed to another page
    } else {
        //Go back to the login page
    }*/ 
}

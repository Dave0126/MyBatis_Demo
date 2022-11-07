package fr.gdai.mybatis.pojo;

public class Emp {
    private Integer empId;
    private String empName;
    private Integer empAge;
    private String empGender;
    private String empEmail;
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer empId, String empName, Integer empAge, String empGender, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empGender = empGender;
        this.empEmail = empEmail;
    }

    public Emp(Integer empId, String empName, Integer empAge, String empGender, String empEmail, Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empGender = empGender;
        this.empEmail = empEmail;
        this.dept = dept;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public void setDept(Dept dept) { this.dept = dept; }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public String getEmpGender() {
        return empGender;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public Dept getDept() { return dept; }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empGender='" + empGender + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", dept=" + dept +
                '}';
    }
}

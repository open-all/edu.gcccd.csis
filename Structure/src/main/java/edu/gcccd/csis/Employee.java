package edu.gcccd.csis;

public class Employee {

    private String name;
    private String jobTitle;
    private Company organization;
    private String birthday;

    public Employee(String name, String jobTitle, Company organization, String birthday){
        this.name = name;
        this.jobTitle = jobTitle;
        this.organization = organization;
        organization.addEmployee();
        this.birthday = birthday;
    }

    public void setCompany(Company organization) {
        this.organization = organization;
        organization.addEmployee();
    }

    public String getName(){
        return this.name;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public String getBirthday() {
        return this.birthday;
    }


    public Company getOrganization() {
        return this.organization;
    }

    @Override
    public boolean equals(Object object) {
        //if we are comparing the object to itself return true
        if (object == this){
            return true;
        }
        //If object is not an employee it cannot be equal
        if(!(object instanceof Employee)) {
            return false;
        }

        //cast object into employee into compare member variables
        Employee c = (Employee) object;
        return (this.name == c.getName() && this.birthday == c.getBirthday() && this.organization == c.getOrganization());
    }

    public boolean isComplete() {
        return (this.name != null && this.jobTitle != null && this.organization != null && this.birthday != null);

    }

}

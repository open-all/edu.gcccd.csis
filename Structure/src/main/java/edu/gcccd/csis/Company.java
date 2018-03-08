package edu.gcccd.csis;

public class Company {
    private String companyName;
    private int numberOfEmployees;

    public Company() {
        this.companyName = null;
        numberOfEmployees = 0;
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void addEmployee() {
        numberOfEmployees++;
    }

    public boolean isComplete(){
        return (this.companyName != null && this.numberOfEmployees > 0);
    }
    @Override
    public boolean equals(Object object) {
        //if we are comparing the object to itself return true
        if (object == this){
            return true;
        }
        //If object is not an employee it cannot be equal
        if(!(object instanceof Company)) {
            return false;
        }

        //cast object into employee into compare member variables
        Company c = (Company) object;
        return this.getCompanyName() == c.getCompanyName();
    }

    @Override
    public String toString() {
        return  this.companyName;
    }
}



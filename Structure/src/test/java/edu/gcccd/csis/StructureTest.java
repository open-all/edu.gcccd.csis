package edu.gcccd.csis;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Tests for a system that can track employee information for two organizations.
 * The Employee information you must (at least) track, is as follows:
 * Name, Job Title, Organization they work for, Birthday
 *
 * As for the Organization that the Employee works for, you must also (at the very least) track this information:
 * Organization Name, Number of Employees
 *
 * The system must be able to properly compare any two employees against each other to determine,
 * if they are the same Person. This means that if you compared two People,
 * with the same Name, Birthday, and Organization, the system should think that they are equal to one another.
 * If any of these properties are different, then the two People are not the same Person.
 * The same rules apply to comparing Organizations to one another.
 * Organizations with the same Organization name are to be thought of as equal,
 * different names means different organizations.
 */
public class StructureTest {



    @Test
    public void employeeComplete() {
        //
        Company c1 = new Company("Google");
        Employee e1 = new Employee("John Doe", "Software Engineer", c1, "2000/03/06");
        // check that an employee's attribute are complete and make sense.
        assertTrue(e1.isComplete());
        // assertTrue( employee is alive and company complies with child labor laws ...;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        //Time variable to hold the current date in format yyyyMMdd
        Long time = Long.valueOf(now.format(format));
        //make sure the employee is at least 18 years old
        long bday = Long.parseLong(e1.getBirthday().replaceAll("[\\D]", ""));
        assertTrue(time - bday >= 180000);
        //...

    }
    /**
     * Check Employee Equality
     */
    @Test
    public void employeeEq() {
        Company c1 = new Company("Microsoft");
        Company c2 = new Company("Google");

        Employee e1 = new Employee("John Doe", "Software Engineer", c1, "1995-01-01");
        Employee e2 = new Employee("John Doe", "Software Engineer", c1, "1995-01-01");

        // Create employee e1,
        // Create another employee e2 that matches the specific criteria for equality
        assertTrue(e1.equals(e2));

        // modify employee e2 (eg. by making her/him join the other company
        e2.setCompany(c2);
        assertNotEquals(e1, e2);

    }

    /**
     * Check Company Equality
     */
    @Test
    public void companyEq() {
        // Create company c1,
        Company c1 = new Company("Microsoft");
        // Create company employee c2 that matches the specific criteria for equality
        Company c2 = new Company("Microsoft");
        assertTrue(c1.equals(c2));

        // modify company c2, i.e. change its name or create another company with a different name ..
        c2.setCompanyName("Google");
        assertNotEquals(c1, c2);

    }

    @Test
    public void companyComplete() {
        // check that a companies' attribute are complete and make sense.
        Company c1 = new Company("Google");
        Employee e1 = new Employee("John Doe", "Software Engineer", c1, "1995-01-01");

        assertTrue(c1.isComplete());

    }
}
package Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employeee extends Person {
    private BigDecimal salary;
    private String function;

    public Employeee(String name, LocalDate dateOfBirth, BigDecimal salary, String function) {
        super(name, dateOfBirth);
        this.salary = salary;
        this.function = function;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getFunction() {
        return function;
    }
}

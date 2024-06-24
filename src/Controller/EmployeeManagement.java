package Controller;

import Helper.ParameterFormatter;
import Models.Employeee;
import Models.tableHeader;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class EmployeeManagement {

    ArrayList<Employeee> listOfEmployees = new ArrayList<>();
    tableHeader cabecalho = new tableHeader();

    //Map usado para agrupar os funcionarios por função
    Map<String,List<Employeee>> groupedEmployees = new HashMap<String,List<Employeee>>();

    public ArrayList<Employeee> getlistOfEmployees() {
        return listOfEmployees;
    }

    public void listGenerator() {

        //Cria os obejtos funcionarios seguindo os padrões impostos pela classe Employee e pela classe Models.Person
        Employeee employeee01 = new Employeee("Maria", LocalDate.of(2000, Month.OCTOBER, 18), new BigDecimal("2009.44"), "Operador");
        Employeee employeee02 = new Employeee("João", LocalDate.of(1990, Month.MAY, 12), new BigDecimal("2284.38"), "Operador");
        Employeee employeee03 = new Employeee("Caio", LocalDate.of(1961, Month.MAY, 2), new BigDecimal("9836.14"), "Cordenador");
        Employeee employeee04 = new Employeee("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), new BigDecimal("19119.88"), "Diretor");
        Employeee employeee05 = new Employeee("Alice", LocalDate.of(1995, Month.JANUARY, 05), new BigDecimal("2234.68"), "Reccepcionista");
        Employeee employeee06 = new Employeee("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), new BigDecimal("1582.72"), "Operador");
        Employeee employeee07 = new Employeee("Arthur", LocalDate.of(1993, Month.MARCH, 31), new BigDecimal("4071.84"), "Contador");
        Employeee employeee08 = new Employeee("Laura", LocalDate.of(1994, Month.JULY, 8), new BigDecimal("3017.45"), "Gerente");
        Employeee employeee09 = new Employeee("Heloísa", LocalDate.of(2003, Month.MAY, 24), new BigDecimal("1606.85"), "Eletricista");
        Employeee employeee10 = new Employeee("Helena", LocalDate.of(1996, Month.SEPTEMBER, 02), new BigDecimal("2799.93"), "Gerente");

        //Adiciona os objetos gerados a listOfEmployees
        listOfEmployees.add(employeee01);
        listOfEmployees.add(employeee02);
        listOfEmployees.add(employeee03);
        listOfEmployees.add(employeee04);
        listOfEmployees.add(employeee05);
        listOfEmployees.add(employeee06);
        listOfEmployees.add(employeee07);
        listOfEmployees.add(employeee08);
        listOfEmployees.add(employeee09);
        listOfEmployees.add(employeee10);
    }

    //Método para imprimir a lista
    public void printList(List<Employeee> employeees){

        System.out.println(cabecalho.getDefaultHeader());
        for (Employeee employeee : employeees) {
            //Converte a data para o formato dd/mm/aaaa e o salario para R$ 9.999,99
            String formattedDate = ParameterFormatter.formatOfDate(employeee.getDateOfBirth());
            String salaryFormatted = ParameterFormatter.formatOfSalary(employeee.getSalary());
            System.out.printf("|  %-7s|  %20s|  %-11s|  %-10s|\n", employeee.getName(), formattedDate, salaryFormatted, employeee.getFunction());
        }

    }


    //Metodo para remover funcionario da tabela
    public void removeEmployee(String removedName){
        listOfEmployees.removeIf(listOfEmployees -> listOfEmployees.getName().equals(removedName));
    }


    //Atualiza o salário dos funcionarios
    public void updateSalaries(BigDecimal rate){
        for(Employeee employeee : listOfEmployees){
            BigDecimal newSalary = employeee.getSalary().multiply(rate);
            employeee.setSalary(newSalary);
        }
    }

    //Agrupar os funcionarios pela função
    public void groupEmployeesFromList(){

        for(Employeee employeee : listOfEmployees){

            List<Employeee> employeees = new ArrayList<>();
            String function = employeee.getFunction();

            if(groupedEmployees.containsKey(function)){
                employeees = groupedEmployees.get(function);
            }
            employeees.add(employeee);
            groupedEmployees.put(function, employeees);
        }
    }

    //Imprime os funcionarios por função
    public void printEmployeesByFunction(){
        for (String function : groupedEmployees.keySet() ){
            System.out.printf("""
            ___________________________________________________________
            |   Cargo: %-15s                                 |\n""", function);
            printList(groupedEmployees.get(function));
            System.out.println("");
        }
    }

    //Imprime os funcionarios que fazem aniversario em outubro e dezembro
    public void printEmployeesByBirthMonth(){
        List<Employeee> selectedEmployees = new ArrayList<>();
        for(Employeee employeee : listOfEmployees){
            var selectedMonths = employeee.getDateOfBirth().getMonthValue();
            if(selectedMonths == 10 || selectedMonths == 12 ){
                selectedEmployees.add(employeee);
            }
        }
        printList(selectedEmployees);
    }


    //Imprime o funcionario mais velho
    public void printsOlderEmployee(){
        LocalDate selectCurrentDay = LocalDate.now();
        Employeee senior = null;

        for(Employeee employeee : listOfEmployees){
            if(senior == null || senior.getDateOfBirth().compareTo(employeee.getDateOfBirth()) > 0 ){
                senior = employeee;
            }
        }
        System.out.println("Nome: " + senior.getName()+"\n" +
                "Idade: " + senior.getDateOfBirth().until(LocalDate.now(), ChronoUnit.YEARS ));
    }

    //Organiza a lista por ordem alfabetica
    public void organizesListOfEmployees(){
        Collections.sort(listOfEmployees);
        printList(listOfEmployees);
    }

    //Soma o salario dos funcionarios
    public void sumOfAllSalaries(){
        BigDecimal totalOfSalaries = new BigDecimal("0");
        for(Employeee employeee : listOfEmployees){
            totalOfSalaries = totalOfSalaries.add(employeee.getSalary());
        }
        System.out.println("Total dos salários: " + ParameterFormatter.formatOfSalary(totalOfSalaries));
    }

    //Verifica quantos salários cada funcionario recebe
    public void calculateMinimumSalary(){
        BigDecimal minimumWage = new BigDecimal("1212.00");

        System.out.println("-------------------------------------------");
        System.out.printf("| %-18s | %-18s |\n","Nome","Salarios Minimos");
        System.out.println("-------------------------------------------");

        for(Employeee employeee : listOfEmployees){
            BigDecimal calculationOfSalaries = employeee.getSalary().divide(minimumWage, 2, RoundingMode.HALF_UP);
            System.out.printf("| %-18s | %-18s |\n", employeee.getName(),calculationOfSalaries );
        }
    }
}

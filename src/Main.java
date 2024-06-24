import Controller.EmployeeManagement;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement newListOfEmployees = new EmployeeManagement();
        System.out.println("1) Insere todos os funcionarios conforme a lista:");
        newListOfEmployees.listGenerator();

        System.out.println("\n ----------------------------- \n");

        System.out.println("2) Remover funcionário 'João' da lista:");
        newListOfEmployees.removeEmployee("João");

        System.out.println("\n ----------------------------- \n");

        System.out.println("3) Imprimir todos os funcionarios com todas as suas funções, sendo que:");
        System.out.println("- Informação de data deve ser exibido no formato dd/mm/aaaa");
        System.out.println("- Informação de valor numérico deve ser recebida no formato com separador" +
                            " de milhar como ponto e decimal como virgula\n");
        newListOfEmployees.printList(newListOfEmployees.getlistOfEmployees());

        System.out.println("\n ----------------------------- \n");

        System.out.println("4) Atualizar a lista com o novo valor de salário:");
        newListOfEmployees.updateSalaries(new BigDecimal("1.10"));
        newListOfEmployees.printList(newListOfEmployees.getlistOfEmployees());

        System.out.println("\n ----------------------------- \n");

        System.out.println("5) Agrupar funcionarios por função em um MAP, sendo a chave a 'função' e o valor a ´lista de" +
                                " funcionarios': ");
        newListOfEmployees.groupEmployeesFromList();

        System.out.println("\n ----------------------------- \n");

        System.out.println("6) Imprimir funcionários agrupados por funções: ");
        newListOfEmployees.printEmployeesByFunction();

        System.out.println("\n ----------------------------- \n");

        System.out.println("8) Imprimir funcionarios que fazem aniversário no mês 10 e 12:");
        newListOfEmployees.printEmployeesByBirthMonth();

        System.out.println("\n ----------------------------- \n");

        System.out.println("9) Imprimir o funcionario com a maior idade, exibindo nome e idade:");
        newListOfEmployees.printsOlderEmployee();

        System.out.println("\n ----------------------------- \n");

        System.out.println("10) Imprime a lista de funcionarios por ordem alfabetica:");
        newListOfEmployees.organizesListOfEmployees();

        System.out.println("\n ----------------------------- \n");

        System.out.println("11) Imprima o total dos salários dos funcionários:");
        newListOfEmployees.sumOfAllSalaries();

        System.out.println("\n ----------------------------- \n");

        System.out.println("12) Imprima quantos salarios minimos ganha cada funcionario, considerando que um salario " +
                                " minimo é iagual a R$1212.00:");
        newListOfEmployees.calculateMinimumSalary();



    }
}
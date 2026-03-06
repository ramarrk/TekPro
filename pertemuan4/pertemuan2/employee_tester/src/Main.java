import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- MEMULAI PENGUJIAN LIBRARY JAR ---");

        // 1. Panggil class dari JAR
        Department d = new Department("Teknik Komputer");
        EmploymentType t = new EmploymentType("Full-Time");
        Employee e = new Employee(1, "Si Tester", d, t, 10000000);

        // 2. Pakai service dari JAR
        EmployeeService s = new EmployeeService();
        s.addEmployee(e);

        // 3. Print hasil
        System.out.println("Karyawan Terdaftar: " + s.getEmployee(1).getName());
        System.out.println("Gaji: " + s.getEmployee(1).getSalary());
        System.out.println("\nSTATUS: JAR BERHASIL DI-LOAD!");
    }
}
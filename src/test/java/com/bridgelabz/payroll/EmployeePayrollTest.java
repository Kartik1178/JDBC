@Test
public void testDateRangeQuery() {

    EmployeePayrollService service = new EmployeePayrollService();

    Date start = Date.valueOf("2018-01-01");
    Date end = Date.valueOf("2020-01-01");

    List<EmployeePayrollData> employees =
            service.getEmployeesByDateRange(start, end);

    System.out.println(employees.size());
}
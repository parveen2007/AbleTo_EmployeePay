$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/Emp_NoDeduction.feature");
formatter.feature({
  "name": "Employees biweekly salary preview",
  "description": "  As an admin user I want to input my employee data so that I can get preview of their pay",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@BiweeklySalary"
    }
  ]
});
formatter.scenario({
  "name": "Add Employee no Deduction",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@BiweeklySalary"
    },
    {
      "name": "@NoDeduction"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am an Admin",
  "keyword": "Given "
});
formatter.match({
  "location": "Emp_NoDeduction.i_am_an_Admin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Admin Dashboard page",
  "keyword": "And "
});
formatter.match({
  "location": "Emp_NoDeduction.i_am_on_the_Admin_Dashboard_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select Add New Employee",
  "keyword": "When "
});
formatter.match({
  "location": "Emp_NoDeduction.i_select_Add_New_Employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to enter employee details",
  "keyword": "Then "
});
formatter.match({
  "location": "Emp_NoDeduction.i_should_be_able_to_enter_employee_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "First Name does not begin with “A” or “a”",
  "keyword": "And "
});
formatter.match({
  "location": "Emp_NoDeduction.first_Name_does_not_begin_with_A_or_a()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee should save",
  "keyword": "And "
});
formatter.match({
  "location": "Emp_NoDeduction.the_employee_should_save()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the employee in the table",
  "keyword": "And "
});
formatter.match({
  "location": "Emp_NoDeduction.i_should_see_the_employee_in_the_table()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Program Bonus amount is correct",
  "keyword": "And "
});
formatter.match({
  "location": "Emp_NoDeduction.the_Program_Bonus_amount_is_correct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Total Biweekly Pay calculation is correct",
  "keyword": "And "
});
formatter.match({
  "location": "Emp_NoDeduction.the_Total_Biweekly_Pay_calculation_is_correct()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
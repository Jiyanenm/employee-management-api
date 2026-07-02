package com.nkosinathi.employeemanagement.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.nkosinathi.employeemanagement.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private static final String COLLECTION_NAME = "employees";

    private final Firestore firestore;

    public EmployeeRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    /**
     * Save Employee
     */
    public String save(Employee employee) throws Exception {

        DocumentReference documentReference =
                firestore.collection(COLLECTION_NAME).document();

        employee.setId(documentReference.getId());

        ApiFuture<WriteResult> future =
                documentReference.set(employee);

        future.get();

        return employee.getId();
    }
    public Employee findById(String id) throws Exception {

        DocumentSnapshot document = firestore
                .collection(COLLECTION_NAME)
                .document(id)
                .get()
                .get();

        if (!document.exists()) {
            return null;
        }

        Employee employee = document.toObject(Employee.class);
        employee.setId(document.getId());

        return employee;
    }
    public void update(String id, Employee employee) throws Exception {

        employee.setId(id);

        firestore.collection(COLLECTION_NAME)
                .document(id)
                .set(employee)
                .get();
    }
    public void delete(String id) throws Exception {

        firestore.collection(COLLECTION_NAME)
                .document(id)
                .delete()
                .get();
    }
    /**
     * Get All Employees
     */
    public List<Employee> findAll() throws Exception {

        ApiFuture<QuerySnapshot> future =
                firestore.collection(COLLECTION_NAME).get();

        List<QueryDocumentSnapshot> documents =
                future.get().getDocuments();

        List<Employee> employees = new ArrayList<>();

        for (DocumentSnapshot document : documents) {

            Employee employee =
                    document.toObject(Employee.class);

            // Set the Firestore document ID
            employee.setId(document.getId());

            employees.add(employee);

        }

        return employees;
    }
    public List<Employee> searchByName(String name) throws Exception {

        ApiFuture<QuerySnapshot> future = firestore.collection(COLLECTION_NAME)
                .whereEqualTo("name", name)
                .get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Employee> employees = new ArrayList<>();

        for (QueryDocumentSnapshot document : documents) {

            Employee employee = document.toObject(Employee.class);
            employee.setId(document.getId());

            employees.add(employee);
        }

        return employees;
    }
    public List<Employee> searchByDepartment(String department) throws Exception {

        ApiFuture<QuerySnapshot> future = firestore.collection(COLLECTION_NAME)
                .whereEqualTo("department", department)
                .get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Employee> employees = new ArrayList<>();

        for (QueryDocumentSnapshot document : documents) {

            Employee employee = document.toObject(Employee.class);
            employee.setId(document.getId());

            employees.add(employee);
        }

        return employees;
    }
    public List<Employee> searchByStatus(String status) throws Exception {

        ApiFuture<QuerySnapshot> future = firestore.collection(COLLECTION_NAME)
                .whereEqualTo("status", status)
                .get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Employee> employees = new ArrayList<>();

        for (QueryDocumentSnapshot document : documents) {

            Employee employee = document.toObject(Employee.class);
            employee.setId(document.getId());

            employees.add(employee);
        }

        return employees;
    }

}
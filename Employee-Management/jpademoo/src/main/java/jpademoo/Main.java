package jpademoo;

import jakarta.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
        // Obtain the EntityManager instance from the JPAUtil class
        EntityManager em = JPAUtil.getEntityManager();

        // Insert operation - Create and persist a new Employee object
        em.getTransaction().begin();  // Begin transaction
        Employee emp1 = new Employee("Sneha_Reddy", "Training", 500);
        em.persist(emp1);  // Persist employee (INSERT operation)
        em.getTransaction().commit();  // Commit transaction

        // Retrieve and update the same employee by its auto-generated ID
        em.getTransaction().begin();
        Employee emp2 = em.find(Employee.class, emp1.getId());  // Retrieve employee by its ID

      
            System.out.println(emp2.getName());  // Print the retrieved employee's name
            System.out.println(emp2.getId());    // Print the employee ID

            emp2.setSalary(5000);  // Update salary
            em.merge(emp2);        // Merge the updated entity into the current persistence context
            
            em.remove(emp2);



        em.getTransaction().commit();  // Commit the updated transaction

        // Close EntityManager and free resources
        em.close();
        JPAUtil.close();
    }
}

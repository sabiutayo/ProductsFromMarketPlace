package sample.Utils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sample.entity.User;

import java.util.List;

public class UserDao {
    private Session session = HibernateUtil.getSession();

    public List<User> getAllUsers() {
        return session.createQuery("from User").list();
    }

    public User getUserById(int userId) {
        return session.get(User.class, userId);
    }

    public User getUserByUsername(String username) {
        Query<User> query = session.createQuery(
                "select u from User u where username = :username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    public void removeUser(User userToRemove) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(userToRemove);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        session.close();
    }

    public void addUser(User userToAdd) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(userToAdd);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        session.close();
    }
/*
    public double buyProduct(User user, Product selectedProduct, int quantity) {
        double discount = 1d;
        double price = selectedProduct.getPrice() * quantity;
        if (UserType.EMPLOYEE.equals(user.getUserType())) {
            discount = 0.5d;
        }
        price *= discount;
        return price;
    }
*/

}

package dawuHomework.emp.dao;

import static dawuHomework.util.Constants.PAGE_MAX_RESULT;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import dawuHomework.emp.entity.Emp;
import dawuHomework.util.HibernateUtil;

public class EmpDAOImpl implements EmpDAO {
	private SessionFactory factory = HibernateUtil.getSessionFactory();

	@Override
	public void insert(Emp entity) {
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		boolean isNewTransaction = !tx.isActive();
		try {
			if (isNewTransaction)
				tx.begin();
			session.persist(entity);
			if (isNewTransaction)
				tx.commit();
		} catch (Exception e) {
			if (isNewTransaction && tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public List<Emp> getAll() {
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		boolean isNewTransaction = !tx.isActive();
		try {
			if (isNewTransaction)
				tx.begin();
			List<Emp> list = session.createQuery("from Emp", Emp.class).getResultList();
			if (isNewTransaction)
				tx.commit();
			return list;
		} catch (Exception e) {
			if (isNewTransaction && tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public void update(Emp entity) {
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		boolean isNewTransaction = !tx.isActive();
		try {
			if (isNewTransaction)
				tx.begin();
			session.merge(entity);
			if (isNewTransaction)
				tx.commit();
		} catch (Exception e) {
			if (isNewTransaction && tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public void delete(Integer id) {
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		boolean isNewTransaction = !tx.isActive();
		try {
			if (isNewTransaction)
				tx.begin();
			Emp emp = session.get(Emp.class, id);
			if (emp != null)
				session.remove(emp);
			if (isNewTransaction)
				tx.commit();
		} catch (Exception e) {
			if (isNewTransaction && tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public Emp getById(Integer id) {
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		boolean isNewTransaction = !tx.isActive();
		try {
			if (isNewTransaction)
				tx.begin();
			Emp emp = session.find(Emp.class, id);
			if (isNewTransaction)
				tx.commit();
			return emp;
		} catch (Exception e) {
			if (isNewTransaction && tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public List<Emp> getAll(int currentPage) {
		return getAll();
	}

	@Override
	public long getTotal() {
		Session session = factory.getCurrentSession();
		Transaction tx = session.getTransaction();
		boolean isNewTransaction = !tx.isActive();
		try {
			if (isNewTransaction)
				tx.begin();
			long count = session.createQuery("select count(*) from Emp", Long.class).getSingleResult();
			if (isNewTransaction)
				tx.commit();
			return count;
		} catch (Exception e) {
			if (isNewTransaction && tx != null)
				tx.rollback();
			throw e;
		}
	}
}
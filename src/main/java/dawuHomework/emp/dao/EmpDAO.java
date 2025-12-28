package dawuHomework.emp.dao;

import java.util.List;
import dawuHomework.emp.entity.Emp;

public interface EmpDAO {
	void insert(Emp entity);

	void update(Emp entity);

	void delete(Integer id);

	Emp getById(Integer id);

	List<Emp> getAll();

	List<Emp> getAll(int currentPage);

	long getTotal();
}
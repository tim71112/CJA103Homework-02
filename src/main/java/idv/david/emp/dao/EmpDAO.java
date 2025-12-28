package idv.david.emp.dao;

import java.util.List;
import java.util.Map;

import idv.david.emp.entity.Emp;

public interface EmpDAO {
	
	void insert(Emp entity);

	void update(Emp entity);
	
	void delete(Integer id);
	 
	Emp getById(Integer id);
	
	List<Emp> getAll();
	
	List<Emp> getByCompositeQuery(Map<String, String> map);
	
	List<Emp> getAll(int currentPage);
	
	long getTotal();
}

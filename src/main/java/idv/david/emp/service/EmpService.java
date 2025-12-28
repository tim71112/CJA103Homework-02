package idv.david.emp.service;

import java.util.List;
import java.util.Map;

import idv.david.emp.entity.Emp;

public interface EmpService {
	
	List<Emp> getAllEmps(int currentPage);
	
	int getPageTotal();
	
	List<Emp> getEmpsByCompositeQuery(Map<String, String[]> map);
}

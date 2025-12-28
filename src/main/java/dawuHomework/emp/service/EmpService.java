package dawuHomework.emp.service;

import java.util.List;
import dawuHomework.emp.entity.Emp;

public interface EmpService {
	List<Emp> getAllEmps(int currentPage);

	int getPageTotal();
}
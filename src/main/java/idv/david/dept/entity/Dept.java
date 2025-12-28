package idv.david.dept.entity;

import java.util.Set;

import idv.david.emp.entity.Emp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;


@Entity
@Table(name = "department")
public class Dept {
	@Id
	@Column(name = "deptno", updatable = false)
	private Integer deptno;

	@Column(name = "dname")
	private String dname;

	@Column(name = "loc")
	private String loc;

	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	@OrderBy("empno asc")
	private Set<Emp> emps;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

}

package dawuHomework.emp.entity;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "install_appeals")
public class Emp implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appeals_no")
	private Integer empno;

	@Column(name = "member_no")
	private Integer comm;

	@Column(name = "install_order_no")
	private Integer sal;

	@Column(name = "status")
	private String job;

	@Column(name = "description")
	private String ename;

	@Column(name = "apply_date", insertable = false, updatable = false)
	private Timestamp hiredate;

	@Column(name = "target_member_no")
	private Integer targetMemberNo;

	@Column(name = "response")
	private String response;

	@Column(name = "adm_no")
	private Integer admNo;

	@Column(name = "priority")
	private String priority;

	// 關鍵修正：加入 @Lob 與對應 MEDIUMBLOB 的設定
	@Lob
	@Column(name = "attachment", columnDefinition = "MEDIUMBLOB")
	private byte[] attachment;

	public Emp() {
	}

	// Getter & Setter
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Timestamp getHiredate() {
		return hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getTargetMemberNo() {
		return targetMemberNo;
	}

	public void setTargetMemberNo(Integer targetMemberNo) {
		this.targetMemberNo = targetMemberNo;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Integer getAdmNo() {
		return admNo;
	}

	public void setAdmNo(Integer admNo) {
		this.admNo = admNo;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
}
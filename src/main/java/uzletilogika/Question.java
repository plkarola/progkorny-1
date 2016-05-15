package uzletilogika;

import java.util.List;

public class Question {

	private int id;
	private List<String> questinoline;
	private String status;
	public Question(int id, List<String> questinoline, String status) {
		super();
		this.id = id;
		this.questinoline = questinoline;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getQuestinoline() {
		return questinoline;
	}
	public void setQuestinoline(List<String> questinoline) {
		this.questinoline = questinoline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ",\n questinoline=" + questinoline + ", \nstatus=" + status + "]";
	}
	
	
	
	
}

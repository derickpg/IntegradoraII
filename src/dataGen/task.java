package dataGen;

public class task {

	String subTask, task, taskType, role;
        //Contribuição Derick sobre Prioridades
        int prioridade;
	
	public task(String subTask, String task, String taskType, String role, int prioridade) {
        //public task(String subTask, String task, String taskType, String role) {
		super();
		this.subTask = subTask;
		this.task = task;
		this.taskType = taskType;
		this.role = role;
                this.prioridade = prioridade;
	}

	public String getSubTask() {
		return subTask;
	}

	public String getTask() {
		return task;
	}

	public String getTaskType() {
		return taskType;
	}

	public String getRole() {
		return role;
	}
	
        public int getPrioridade(){
                return prioridade;
        }
        
}
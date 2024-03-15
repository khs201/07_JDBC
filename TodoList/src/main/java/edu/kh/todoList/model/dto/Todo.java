package edu.kh.todoList.model.dto;

public class Todo {

	private int todoNo; // 할 일 번호
	private String todoTitle; // 할 일 제목
	private String todoContent; // 할 일 내용
	private String complete; // 할 일 완료 여부 ("Y", "N")
	
	public Todo(int todoNo, String todoTitle, String todoContent) {
		super();
		this.todoNo = todoNo;
		this.todoTitle = todoTitle;
		this.todoContent = todoContent;
	}

	private String regDate; // 할 일 등록일(String으로 변환해서 저장)
	
	// 매개변수 생성자(할 일 목록 조회)
	public Todo(int todoNo, String todoTitle, String complete, String regDate) {
		super();
		this.todoNo = todoNo;
		this.todoTitle = todoTitle;
		this.complete = complete;
		this.regDate = regDate;
	}

	// 기본 생성자
	public Todo() {
	}

	public int getTodoNo() {
		return todoNo;
	}

	@Override
	public String toString() {
		return "Todo [todoNo=" + todoNo + ", todoTitle=" + todoTitle + ", todoContent=" + todoContent + ", complete="
				+ complete + ", regDate=" + regDate + "]";
	}

	public void setTodoNo(int todoNo) {
		this.todoNo = todoNo;
	}

	public String getTodoTitle() {
		return todoTitle;
	}

	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}

	public String getTodoContent() {
		return todoContent;
	}

	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}

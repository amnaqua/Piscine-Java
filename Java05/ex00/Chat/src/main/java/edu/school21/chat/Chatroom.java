package edu.school21.chat;

import java.util.List;

public class Chatroom {
	private int id;
	private String name;
	private User owner;
	List<Message> messageList;

	public Chatroom(int id, String name, User owner, List<Message> messageList) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.messageList = messageList;
	}

	@Override
	public String toString() {
		return ("ROOM: " + "\n" +
				"id: " + id + "\n" +
				"name: " + name + "\n" +
				"owner: " + owner + "\n" +
				"messageList" + messageList);
	}

	@Override
	public boolean equals(Object user) {
		return (super.equals(user));
	}

	@Override
	public int hashCode() {
		return (super.hashCode());
	}
}

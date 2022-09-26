package edu.school21.chat;

import java.util.List;

public class User {
	private int id;
	private String login;
	private String password;
	private List<Chatroom> createdRoom;
	private List<Chatroom> joinedRoom;

	public User(int id, String login, String password, List<Chatroom> createdRoom, List<Chatroom> joinedRoom) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.createdRoom = createdRoom;
		this.joinedRoom = joinedRoom;
	}

	@Override
	public String toString() {
		return ("USER: " + "\n" +
				"id: " + id + "\n" +
				"login: " + login + "\n" +
				"password: " + password + "\n" +
				"createdRooms: " + createdRoom + "\n" +
				"joinedRooms: " + joinedRoom
				);
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

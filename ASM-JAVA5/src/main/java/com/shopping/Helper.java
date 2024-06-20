package com.shopping;

import jakarta.servlet.http.HttpSession;

public class Helper {

	public static final String CURRENT_USER = "currentUser";

	public static void setCurrentUser(HttpSession session, Object user) {
		session.setAttribute(CURRENT_USER, user);
	}

	public static Object getCurrentUser(HttpSession session) {
		return session.getAttribute(CURRENT_USER);
	}

	public static void removeCurrentUser(HttpSession session) {
		session.removeAttribute(CURRENT_USER);
	}

}

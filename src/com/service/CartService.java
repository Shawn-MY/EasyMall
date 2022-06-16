package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CartService {
	public void getPro(HttpServletRequest req, HttpServletResponse res);
	public void update(HttpServletRequest req, HttpServletResponse res);
}

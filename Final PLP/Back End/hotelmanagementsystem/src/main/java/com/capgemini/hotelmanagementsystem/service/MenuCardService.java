package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;

public interface MenuCardService {
	// To get Menu Cart
	public List<MenuCardBean> menuCard();

	// To Add New Menu
	public boolean addMenu(MenuCardBean menuCardBean);

	// To Delete Menu
	public boolean deleteMenu(int foodId);

	// To Update Menu
	public boolean updateMenu(MenuCardBean menuCardBean);
}

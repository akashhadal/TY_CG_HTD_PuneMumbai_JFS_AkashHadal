package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;
import com.capgemini.hotelmanagementsystem.dao.MenuCardDAO;

@Service
public class MenuCardServiceImplementation implements MenuCardService {
	@Autowired
	private MenuCardDAO menuCardDAO;

	@Override
	public List<MenuCardBean> menuCard() {
		return menuCardDAO.menuCard();
	}

	@Override
	public boolean addMenu(MenuCardBean menuCardBean) {
		return menuCardDAO.addMenu(menuCardBean);
	}

	@Override
	public boolean deleteMenu(int foodId) {
		return menuCardDAO.deleteMenu(foodId);
	}

	@Override
	public boolean updateMenu(MenuCardBean menuCardBean) {
		return menuCardDAO.updateMenu(menuCardBean);
	}

}

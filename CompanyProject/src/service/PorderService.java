package service;

import java.util.List;

import model.Porder;

public interface PorderService {
	//create
	void addPorder(Porder porder);
	//read
	String allPorder();
	List<Porder> findAllPorder();
	Porder findById(int id);
	//update
	void updatePorder(String name, int id);
	void updatePorder(int lcd, int ram, int mouse, int id);
	void updatePorder(Porder porder);
	//delete
	void deletePorder(int id);
}

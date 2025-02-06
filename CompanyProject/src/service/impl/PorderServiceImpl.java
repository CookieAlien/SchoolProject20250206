package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService{

	public static void main(String[] args) {
		System.out.println(new PorderServiceImpl().findById(2));

	}
	private static PorderDaoImpl porderDaoImpl = new PorderDaoImpl();
	@Override
	public void addPorder(Porder porder) {
		if (porder.getLcd()>=0 && porder.getRam()>=0 && porder.getMouse() >=0) {
			porderDaoImpl.add(porder);
		}
		
		
	}

	@Override
	public String allPorder() {
		List<Porder> porders = findAllPorder();
		String output ="";
		for (Porder porder : porders) {
			int sum = porder.getId() * 1280 + porder.getRam() * 4900 + porder.getMouse() * 2450;
			output+="id:"+porder.getId()+"\t"+
					"name:"+porder.getName()+"\t"+
					"lcd:"+porder.getLcd()+"\t"+
					"ram:"+porder.getRam()+"\t"+
					"mouse:"+porder.getMouse()+"\t"+
					"sum:"+sum+"\n";
					
		}
		return output;
	}

	@Override
	public List<Porder> findAllPorder() {
		
		return porderDaoImpl.selectAll();
	}

	@Override
	public Porder findById(int id) {
		Porder porder = null;
		if(id>0) {
			List<Porder> list = porderDaoImpl.selectById(id);
			if (list.size()>0) {
				porder = list.get(0);
			}
		}
		return porder;
	}

	@Override
	public void updatePorder(String name, int id) {
		Porder porder = findById(id);
		porder.setName(name);
		
		porderDaoImpl.update(porder);
		
		
	}

	@Override
	public void updatePorder(int lcd, int ram, int mouse, int id) {
		Porder porder = findById(id);
		porder.setLcd(lcd);
		porder.setRam(ram);
		porder.setMouse(mouse);
		
		porderDaoImpl.update(porder);
		
	}

	@Override
	public void updatePorder(Porder porder) {
		
		
	}

	@Override
	public void deletePorder(int id) {
		// TODO Auto-generated method stub
		porderDaoImpl.delete(id);
	}

}

package test;

import java.util.ArrayList;

import database.DAOsanpham;
import model.san_pham;

public class test {

	public static void main(String[] args) {
		ArrayList<san_pham> list = DAOsanpham.getInstance().selectAll();
		for (san_pham san_pham : list) {
			System.out.println(san_pham.toString());
		}
	}
}

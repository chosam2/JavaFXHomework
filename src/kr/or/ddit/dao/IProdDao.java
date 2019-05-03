package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.LprodVO;
import kr.or.ddit.vo.ProdVO;

public interface IProdDao {

	public List<LprodVO> getLprodList();

	public List<ProdVO> getProdList(String lprod_nm);

	public List<ProdVO> getSelectProdList(String selectProd);
	
}

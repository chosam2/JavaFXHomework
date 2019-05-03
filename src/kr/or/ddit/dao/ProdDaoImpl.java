package kr.or.ddit.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.vo.LprodVO;
import kr.or.ddit.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	
	private static IProdDao dao;
	
	private SqlMapClient smc;
	
	private ProdDaoImpl() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
		} catch (Exception e) {
			System.out.println("xml파일 읽기 오류");
		}
	}
	
	public static IProdDao getInstance() {
		if(dao == null) {
			dao = new ProdDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<LprodVO> getLprodList() {
		List<LprodVO> lprodList = new ArrayList<>();
		
		try {
			lprodList = smc.queryForList("lprod");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lprodList;
	}

	@Override
	public List<ProdVO> getProdList(String lprod_nm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdVO> getSelectProdList(String selectProd) {
		// TODO Auto-generated method stub
		return null;
	}

}

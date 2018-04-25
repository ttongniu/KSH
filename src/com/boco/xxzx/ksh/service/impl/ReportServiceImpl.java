package com.boco.xxzx.ksh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.xxzx.ksh.bean.BusinessInfo;
import com.boco.xxzx.ksh.bean.BusinessPersonAssets;
import com.boco.xxzx.ksh.bean.BusinessPersonLiZhi;
import com.boco.xxzx.ksh.bean.BusinessPersonRuZhi;
import com.boco.xxzx.ksh.bean.BusinessPersonTotal;
import com.boco.xxzx.ksh.bean.BusinessPersonYSSJ;
import com.boco.xxzx.ksh.bean.DepartmentPersonAssets;
import com.boco.xxzx.ksh.bean.DepartmentPersonYSSJ;
import com.boco.xxzx.ksh.bean.IndustryProject;
import com.boco.xxzx.ksh.bean.PersonNianLing;
import com.boco.xxzx.ksh.bean.PersonScore;
import com.boco.xxzx.ksh.bean.PersonSiLing;
import com.boco.xxzx.ksh.bean.PersonXueLi;
import com.boco.xxzx.ksh.bean.ProvinceProject;
import com.boco.xxzx.ksh.dao.ReportDao;
import com.boco.xxzx.ksh.service.ReportService;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao reportDao;

	@Override
	public List<ProvinceProject> findProvinceProject() {
		return reportDao.findProvinceProject();
	}

	@Override
	public List<IndustryProject> findIndustryProject() {
		return reportDao.findIndustryProject();
	}

	
	@Override
	public List<BusinessPersonYSSJ> findBusinessPersonYSSJForYear(String year) {
		return reportDao.findBusinessPersonYSSJForYear(year);
	}

	@Override
	public List<DepartmentPersonYSSJ> findDepartmentPersonYSSJForYear(String year) {
		return  reportDao.findDepartmentPersonYSSJForYear(year);
	}

	@Override
	public List<BusinessInfo> findBusinessList() {
		return reportDao.findBusinessList();
	}

	@Override
	public List<BusinessPersonTotal> findbusinessPersonTotal() {
		return reportDao.findbusinessPersonTotal();
	}

	@Override
	public List<BusinessPersonTotal> findbusinessPersonTotalByCode(String code) {
		return reportDao.findbusinessPersonTotalByCode(code);
	}

	@Override
	public List<BusinessPersonRuZhi> findBusinessPersonRuZhi() {
		return reportDao.findBusinessPersonRuZhi();
	}

	@Override
	public List<BusinessPersonRuZhi> findBusinessPersonRuZhiByCode(String code) {
		return reportDao.findBusinessPersonRuZhiByCode(code);
	}

	@Override
	public List<BusinessPersonLiZhi> findBusinessPersonLiZhi() {
		return reportDao.findBusinessPersonLiZhi();
	}

	@Override
	public List<BusinessPersonLiZhi> findBusinessPersonLiZhiByCode(String code) {
		return reportDao.findBusinessPersonLiZhiByCode(code);
	}

	@Override
	public List<PersonSiLing> findPersonSiLingByYear(String year) {
		return reportDao.findPersonSiLingByYear(year);
	}

	@Override
	public List<PersonSiLing> findPersonSiLing() {
		return reportDao.findPersonSiLing();
	}

	@Override
	public List<PersonNianLing> findPersonNianLing() {
		return reportDao.findPersonNianLing();
	}

	@Override
	public List<PersonNianLing> findPersonNianLingByYear(String year) {
		return reportDao.findPersonNianLingByYear(year);
	}

	@Override
	public List<PersonXueLi> findPersonXueLiByYear(String year) {
		return reportDao.findPersonXueLiByYear(year);
	}

	@Override
	public List<PersonScore> findPersonScoreByYear(String year) {
		return reportDao.findPersonScoreByYear(year);
	}

	@Override
	public List<BusinessPersonAssets> findBusinessPersonAssets(String year) {
		return reportDao.findBusinessPersonAssets(year);
	}

	@Override
	public List<DepartmentPersonAssets> findDepartmentPersonAssets(String year) {
		return reportDao.findDepartmentPersonAssets(year);
	}	

}

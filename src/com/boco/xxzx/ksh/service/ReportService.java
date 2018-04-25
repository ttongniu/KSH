package com.boco.xxzx.ksh.service;

import java.util.List;

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


public interface ReportService {

	List<ProvinceProject> findProvinceProject();

	List<IndustryProject> findIndustryProject();

	List<BusinessPersonYSSJ> findBusinessPersonYSSJForYear(String year);

	List<DepartmentPersonYSSJ> findDepartmentPersonYSSJForYear(String year);

	List<BusinessInfo> findBusinessList();

	List<BusinessPersonTotal> findbusinessPersonTotal();

	List<BusinessPersonTotal> findbusinessPersonTotalByCode(String code);

	List<BusinessPersonRuZhi> findBusinessPersonRuZhi();

	List<BusinessPersonRuZhi> findBusinessPersonRuZhiByCode(String code);

	List<BusinessPersonLiZhi> findBusinessPersonLiZhi();

	List<BusinessPersonLiZhi> findBusinessPersonLiZhiByCode(String code);

	List<PersonSiLing> findPersonSiLingByYear(String year);

	List<PersonSiLing> findPersonSiLing();

	List<PersonNianLing> findPersonNianLing();

	List<PersonNianLing> findPersonNianLingByYear(String year);

	List<PersonXueLi> findPersonXueLiByYear(String year);

	List<PersonScore> findPersonScoreByYear(String year);

	List<BusinessPersonAssets> findBusinessPersonAssets(String year);

	List<DepartmentPersonAssets> findDepartmentPersonAssets(String year);

	
}

package com.boco.xxzx.ksh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
import com.boco.xxzx.ksh.service.ReportService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	/**
	 * 项目：立项个数
	 */
	@RequestMapping("province")
	public ModelAndView provinceNum(){
		ModelAndView view=new ModelAndView("json");
		List<ProvinceProject> projectList=reportService.findProvinceProject();
		String nameArray[]=new String[projectList.size()];
		Integer numArray[]=new Integer[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			ProvinceProject project=projectList.get(i);
			nameArray[i]=project.getName();
			numArray[i]=project.getNum();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("nameJSON", nameArray);
		map.put("numJSON", numArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	/**
	 * 行业：立项个数
	 */
	@RequestMapping("industry")
	public ModelAndView industryNum(){
		ModelAndView view=new ModelAndView("json");
		List<IndustryProject> projectList=reportService.findIndustryProject();
		String nameArray[]=new String[projectList.size()];
		Integer numArray[]=new Integer[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			IndustryProject project=projectList.get(i);
			nameArray[i]=project.getName();
			numArray[i]=project.getNum();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("nameJSON", nameArray);
		map.put("numJSON", numArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}

	/**
	 * 各事业部人员预算与实际人数对比
	 * @return
	 */
	@RequestMapping("businessYSSJ")
	public ModelAndView businessYSSJ(String year){
		ModelAndView view=new ModelAndView("json");
		List<BusinessPersonYSSJ> projectList=reportService.findBusinessPersonYSSJForYear(year);
		String nameArray[]=new String[projectList.size()];
		Integer ysNumArray[]=new Integer[projectList.size()];
		Integer sjNumArray[]=new Integer[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			BusinessPersonYSSJ project=projectList.get(i);
			nameArray[i]=project.getName();
			ysNumArray[i]=project.getYs_Person();
			sjNumArray[i]=project.getSj_Person();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("nameJSON", nameArray);
		map.put("ysNumJSON", ysNumArray);
		map.put("sjNumJSON", sjNumArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	
	/**
	 * 各部门人员预算与实际人数对比
	 * @return
	 */
	@RequestMapping("departmentYSSJ")
	public ModelAndView departmentYSSJ(String year){
		ModelAndView view=new ModelAndView("json");
		List<DepartmentPersonYSSJ> projectList=reportService.findDepartmentPersonYSSJForYear(year);
		String nameArray[]=new String[projectList.size()];
		Integer ysNumArray[]=new Integer[projectList.size()];
		Integer sjNumArray[]=new Integer[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			DepartmentPersonYSSJ project=projectList.get(i);
			nameArray[i]=project.getName();
			ysNumArray[i]=project.getYs_person();
			sjNumArray[i]=project.getSj_person();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("nameJSON", nameArray);
		map.put("ysNumJSON", ysNumArray);
		map.put("sjNumJSON", sjNumArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	
	/**
	 * 加载所有的事业部
	 * @return
	 */
	@RequestMapping("businessList")
	public ModelAndView businessList(){
		ModelAndView view=new ModelAndView("json");
		List<BusinessInfo> businessInfoList=reportService.findBusinessList();
		JSONArray object=JSONArray.fromObject(businessInfoList);
		view.addObject("json", object);
		return view;
	}
	
	/**
	 * 加载某个事业部的总人数
	 * @return
	 */
	@RequestMapping("businessPersonTotal")
	public ModelAndView businessPersonTotal(String code){
		ModelAndView view=new ModelAndView("json");
		List<BusinessPersonTotal> businessPersonTotalList=null;
		if ("".equals(code)||code==null||"all".equals(code)) {
			businessPersonTotalList=reportService.findbusinessPersonTotal();
		}else{
			businessPersonTotalList=reportService.findbusinessPersonTotalByCode(code);
		}
		Integer totalArray[]=new Integer[businessPersonTotalList.size()];
		Integer monthArray[]=new Integer[businessPersonTotalList.size()];
		String businessCode="";
		String businessName="";
		for (int i = 0; i < businessPersonTotalList.size(); i++) {
			BusinessPersonTotal businessPersonTotal=businessPersonTotalList.get(i);
			businessCode=businessPersonTotal.getCode();
			businessName=businessPersonTotal.getName();
			totalArray[i]=businessPersonTotal.getTotal_person();
			monthArray[i]=businessPersonTotal.getMonth();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("code", businessCode);
		map.put("name", businessName);
		map.put("total", totalArray);
		map.put("month", monthArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	/**
	 * 加载某个事业部入职人员数量
	 * @param code
	 * @return
	 */
	@RequestMapping("businessPersonRuZhi")
	public ModelAndView businessPersonRuZhi(String code){
		ModelAndView view=new ModelAndView("json");
		List<BusinessPersonRuZhi> businessPersonRuZhiList=null;
		if ("".equals(code)||code==null||"all".equals(code)) {
			businessPersonRuZhiList=reportService.findBusinessPersonRuZhi();
		}else{
			businessPersonRuZhiList=reportService.findBusinessPersonRuZhiByCode(code);
		}
		Integer ruzhiArray[]=new Integer[businessPersonRuZhiList.size()];
		Integer monthArray[]=new Integer[businessPersonRuZhiList.size()];
		String businessCode="";
		String businessName="";
		for (int i = 0; i < businessPersonRuZhiList.size(); i++) {
			BusinessPersonRuZhi businessPersonRuZhi=businessPersonRuZhiList.get(i);
			businessCode=businessPersonRuZhi.getCode();
			businessName=businessPersonRuZhi.getName();
			ruzhiArray[i]=businessPersonRuZhi.getRz_person();
			monthArray[i]=businessPersonRuZhi.getMonth();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("code", businessCode);
		map.put("name", businessName);
		map.put("ruzhi", ruzhiArray);
		map.put("month", monthArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	/**
	 * 加载某个事业部离职人员数量
	 * @param code
	 * @return
	 */
	@RequestMapping("businessPersonLiZhi")
	public ModelAndView businessPersonLiZhi(String code){
		ModelAndView view=new ModelAndView("json");
		List<BusinessPersonLiZhi> businessPersonLiZhiList=null;
		if ("".equals(code)||code==null||"all".equals(code)) {
			businessPersonLiZhiList=reportService.findBusinessPersonLiZhi();
		}else{
			businessPersonLiZhiList=reportService.findBusinessPersonLiZhiByCode(code);
		}
		Integer lizhiArray[]=new Integer[businessPersonLiZhiList.size()];
		Integer monthArray[]=new Integer[businessPersonLiZhiList.size()];
		String businessCode="";
		String businessName="";
		for (int i = 0; i < businessPersonLiZhiList.size(); i++) {
			BusinessPersonLiZhi businessPersonLiZhi=businessPersonLiZhiList.get(i);
			businessCode=businessPersonLiZhi.getCode();
			businessName=businessPersonLiZhi.getName();
			lizhiArray[i]=businessPersonLiZhi.getLz_person();
			monthArray[i]=businessPersonLiZhi.getMonth();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("code", businessCode);
		map.put("name", businessName);
		map.put("lizhi", lizhiArray);
		map.put("month", monthArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	/**
	 * 司龄
	 * @return
	 */
	@RequestMapping("personSiLing")
	public ModelAndView personSiLing(String year){
		ModelAndView view=new ModelAndView("json");
		List<PersonSiLing> projectList=reportService.findPersonSiLingByYear(year);
		String nameArray[]=new String[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			PersonSiLing project=projectList.get(i);
			nameArray[i]=project.getName();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("name", nameArray);
		map.put("data", projectList);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	
	/**
	 * 年龄
	 * @return
	 */
	@RequestMapping("personNianLing")
	public ModelAndView personNianLing(String year){
		ModelAndView view=new ModelAndView("json");
		List<PersonNianLing> projectList=reportService.findPersonNianLingByYear(year);
		String nameArray[]=new String[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			PersonNianLing project=projectList.get(i);
			nameArray[i]=project.getName();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("name", nameArray);
		map.put("data", projectList);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	/**
	 * 学历
	 * @param year
	 * @return
	 */
	@RequestMapping("personXueLi")
	public ModelAndView personXueLi(String year){
		ModelAndView view=new ModelAndView("json");
		List<PersonXueLi> projectList=reportService.findPersonXueLiByYear(year);
		String nameArray[]=new String[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			PersonXueLi project=projectList.get(i);
			nameArray[i]=project.getName();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("name", nameArray);
		map.put("data", projectList);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}

	/**
	 * 绩效考核
	 * @param year
	 * @return
	 */
	@RequestMapping("personScore")
	public ModelAndView personScore(String year){
		ModelAndView view=new ModelAndView("json");
		List<PersonScore> projectList=reportService.findPersonScoreByYear(year);
		String nameArray[]=new String[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			PersonScore project=projectList.get(i);
			nameArray[i]=project.getName();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("name", nameArray);
		map.put("data", projectList);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	/**
	 * 事业部：人员数量和固定资产数量
	 * @return
	 */
	@RequestMapping("businessPersonAssets")
	public ModelAndView businessPersonAssets(String year){
		ModelAndView view=new ModelAndView("json");
		List<BusinessPersonAssets> projectList=reportService.findBusinessPersonAssets(year);
		String nameArray[]=new String[projectList.size()];
		Integer numArray[]=new Integer[projectList.size()];
		Integer assetArray[]=new Integer[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			BusinessPersonAssets project=projectList.get(i);
			nameArray[i]=project.getName();
			numArray[i]=project.getNum();
			assetArray[i]=project.getAsset();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("name", nameArray);
		map.put("num", numArray);
		map.put("asset", assetArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
	
	/**
	 * 部门：人员数量和固定资产数量
	 * @return
	 */
	@RequestMapping("departmentPersonAssets")
	public ModelAndView departmentPersonAssets(String year){
		ModelAndView view=new ModelAndView("json");
		List<DepartmentPersonAssets> projectList=reportService.findDepartmentPersonAssets(year);
		String nameArray[]=new String[projectList.size()];
		Integer numArray[]=new Integer[projectList.size()];
		Integer assetArray[]=new Integer[projectList.size()];
		for (int i = 0; i < projectList.size(); i++) {
			DepartmentPersonAssets project=projectList.get(i);
			nameArray[i]=project.getName();
			numArray[i]=project.getNum();
			assetArray[i]=project.getAsset();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("name", nameArray);
		map.put("num", numArray);
		map.put("asset", assetArray);
		JSONObject object=JSONObject.fromObject(map);
		view.addObject("json", object);
		return view;
	}
	
}

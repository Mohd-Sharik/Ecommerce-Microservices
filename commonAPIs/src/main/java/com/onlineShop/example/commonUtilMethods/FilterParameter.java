package com.onlineShop.example.commonUtilMethods;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

public class FilterParameter {
	
	
	
	// most common
		private @QueryParam("pageIndex") Integer pageIndex = 0;
		private @QueryParam("pageName") String pageName = "";
		private @QueryParam("recordToShowOnOnePage") Integer recordToShowOnOnePage = CommonConstant.REC_PER_PG;
		private @QueryParam("recordTotal") Long recordTotal;
		private @QueryParam("arcFlag") String arcFlag = "";
		private @QueryParam("flag") String flag = "";
		private @QueryParam("id") String id = "";
		private @QueryParam("aplId") String aplId = "";
		private @QueryParam("cd") String cd = "";
		private @QueryParam("email") String email = "";
		private @QueryParam("type") String type = "";
		private @QueryParam("refId") String refId = "";
		private @QueryParam("dsplNm") String dsplNm = "";
		private @QueryParam("ldapAuth") String ldapAuth = "";
		private @QueryParam("contactNumber") String contactNumber ="";
		private @QueryParam("price") String price = "";
		private @QueryParam("orderId") String orderId = "";
		private @QueryParam("paymentMode") String paymentMode = "";
		private @QueryParam("referenceNumber") String referenceNumber ="";
		private @QueryParam("paymentStatus") String paymentStatus = "";

		private @QueryParam("dsplTyp") String dsplTyp;
		private @QueryParam("usrState") String usrState = "";
		private @QueryParam("fullNm") String fullNm = "";
		private @QueryParam("isMakerCheker") String isMakerCheker = "";
		private @QueryParam("name") String name = "";
		private @QueryParam("ip") String ip = "";
		private @QueryParam("port") String port = "";
		private @QueryParam("txnId") String txnId = "";
		private @QueryParam("deptId") String deptId = "";
		private @QueryParam("rolNm") String rolNm = "";
		private @QueryParam("rolId") String rolId = "";
		private @QueryParam("usrId") String usrId = "";
		private @QueryParam("action") String action = "";
		private @QueryParam("desc") String desc = "";
		private @QueryParam("refCd") String refCd = "";
		private @QueryParam("key") String key = "";
		private @QueryParam("srcSysId") String srcSysId = "";
		private @QueryParam("tgtSysId") String tgtSysId = "";
		private @QueryParam("tblRefId") String tblRefId = "";
		private @QueryParam("code") String code = "";
		private @QueryParam("activity") String activity = "";
		private @QueryParam("status") String status = "";
		private @QueryParam("trckngKey") String trckngKey = "";
		private @QueryParam("amt") String amt = "";
		private @QueryParam("dtOfOps") String dtOfOps = "";
		private @QueryParam("isActive") String isActive = "";
		private @QueryParam("crtBy") String crtBy = "";
		private @QueryParam("updBy") String updBy = "";
		private @QueryParam("fromDate") String fromDate = "";
		private @QueryParam("toDate") String toDate = "";
		private @QueryParam("crtTs") String crtTs = "";
		private @QueryParam("tableName") String tableName = "";
		private @QueryParam("clubbed") String clubbed = "";
		private @QueryParam("host") String host = "";
		private @QueryParam("sprCapLn") String sprCapLn = "";
		private @QueryParam("sysNm") String sysNm = "";
		private @QueryParam("brandName") String brandName = "";

		// not a query parameter but general use
		private List<String> list = new ArrayList<>();
		private List<String> cmpnyCds = new ArrayList<>();
		private List<Long> ids = new ArrayList<>();
		public Integer getPageIndex() {
			return pageIndex;
		}
		public void setPageIndex(Integer pageIndex) {
			this.pageIndex = pageIndex;
		}
		public String getPageName() {
			return pageName;
		}
		public void setPageName(String pageName) {
			this.pageName = pageName;
		}
		public Integer getRecordToShowOnOnePage() {
			return recordToShowOnOnePage;
		}
		public void setRecordToShowOnOnePage(Integer recordToShowOnOnePage) {
			this.recordToShowOnOnePage = recordToShowOnOnePage;
		}
		public Long getRecordTotal() {
			return recordTotal;
		}
		public void setRecordTotal(Long recordTotal) {
			this.recordTotal = recordTotal;
		}
		public String getArcFlag() {
			return arcFlag;
		}
		public void setArcFlag(String arcFlag) {
			this.arcFlag = arcFlag;
		}
		public String getFlag() {
			return flag;
		}
		public void setFlag(String flag) {
			this.flag = flag;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getAplId() {
			return aplId;
		}
		public void setAplId(String aplId) {
			this.aplId = aplId;
		}
		public String getCd() {
			return cd;
		}
		public void setCd(String cd) {
			this.cd = cd;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getRefId() {
			return refId;
		}
		public void setRefId(String refId) {
			this.refId = refId;
		}
		public String getDsplNm() {
			return dsplNm;
		}
		public void setDsplNm(String dsplNm) {
			this.dsplNm = dsplNm;
		}
		public String getLdapAuth() {
			return ldapAuth;
		}
		public void setLdapAuth(String ldapAuth) {
			this.ldapAuth = ldapAuth;
		}
		public String getDsplTyp() {
			return dsplTyp;
		}
		public void setDsplTyp(String dsplTyp) {
			this.dsplTyp = dsplTyp;
		}
		public String getUsrState() {
			return usrState;
		}
		public void setUsrState(String usrState) {
			this.usrState = usrState;
		}
		public String getFullNm() {
			return fullNm;
		}
		public void setFullNm(String fullNm) {
			this.fullNm = fullNm;
		}
		public String getIsMakerCheker() {
			return isMakerCheker;
		}
		public void setIsMakerCheker(String isMakerCheker) {
			this.isMakerCheker = isMakerCheker;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getPort() {
			return port;
		}
		public void setPort(String port) {
			this.port = port;
		}
		public String getTxnId() {
			return txnId;
		}
		public void setTxnId(String txnId) {
			this.txnId = txnId;
		}
		public String getDeptId() {
			return deptId;
		}
		public void setDeptId(String deptId) {
			this.deptId = deptId;
		}
		public String getRolNm() {
			return rolNm;
		}
		public void setRolNm(String rolNm) {
			this.rolNm = rolNm;
		}
		public String getRolId() {
			return rolId;
		}
		public void setRolId(String rolId) {
			this.rolId = rolId;
		}
		public String getUsrId() {
			return usrId;
		}
		public void setUsrId(String usrId) {
			this.usrId = usrId;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getRefCd() {
			return refCd;
		}
		public void setRefCd(String refCd) {
			this.refCd = refCd;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getSrcSysId() {
			return srcSysId;
		}
		public void setSrcSysId(String srcSysId) {
			this.srcSysId = srcSysId;
		}
		public String getTgtSysId() {
			return tgtSysId;
		}
		public void setTgtSysId(String tgtSysId) {
			this.tgtSysId = tgtSysId;
		}
		public String getTblRefId() {
			return tblRefId;
		}
		public void setTblRefId(String tblRefId) {
			this.tblRefId = tblRefId;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getActivity() {
			return activity;
		}
		public void setActivity(String activity) {
			this.activity = activity;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getTrckngKey() {
			return trckngKey;
		}
		public void setTrckngKey(String trckngKey) {
			this.trckngKey = trckngKey;
		}
		public String getAmt() {
			return amt;
		}
		public void setAmt(String amt) {
			this.amt = amt;
		}
		public String getDtOfOps() {
			return dtOfOps;
		}
		public void setDtOfOps(String dtOfOps) {
			this.dtOfOps = dtOfOps;
		}
		public String getIsActive() {
			return isActive;
		}
		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}
		public String getCrtBy() {
			return crtBy;
		}
		public void setCrtBy(String crtBy) {
			this.crtBy = crtBy;
		}
		public String getUpdBy() {
			return updBy;
		}
		public void setUpdBy(String updBy) {
			this.updBy = updBy;
		}
		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}
		public String getToDate() {
			return toDate;
		}
		public void setToDate(String toDate) {
			this.toDate = toDate;
		}
		public String getCrtTs() {
			return crtTs;
		}
		public void setCrtTs(String crtTs) {
			this.crtTs = crtTs;
		}
		public String getTableName() {
			return tableName;
		}
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		public String getClubbed() {
			return clubbed;
		}
		public void setClubbed(String clubbed) {
			this.clubbed = clubbed;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getSprCapLn() {
			return sprCapLn;
		}
		public void setSprCapLn(String sprCapLn) {
			this.sprCapLn = sprCapLn;
		}
		public String getSysNm() {
			return sysNm;
		}
		public void setSysNm(String sysNm) {
			this.sysNm = sysNm;
		}
		public List<String> getList() {
			return list;
		}
		public void setList(List<String> list) {
			this.list = list;
		}
		public List<String> getCmpnyCds() {
			return cmpnyCds;
		}
		public void setCmpnyCds(List<String> cmpnyCds) {
			this.cmpnyCds = cmpnyCds;
		}
		public List<Long> getIds() {
			return ids;
		}
		public void setIds(List<Long> ids) {
			this.ids = ids;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getBrandName() {
			return brandName;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		public String getReferenceNumber() {
			return referenceNumber;
		}
		public void setReferenceNumber(String referenceNumber) {
			this.referenceNumber = referenceNumber;
		}
		public String getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}


		
		
		
		
		
		
		
		
		

}

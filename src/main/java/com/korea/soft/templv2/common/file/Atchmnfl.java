package com.korea.soft.templv2.common.file;

public class Atchmnfl {

	
	/** 회원사아이디 **/
	private int atchmnflId;
	/** 첨부파일_순번 */
	private int atchmnflSn;
	/** 원본_파일명 */
	private String orginlFilenm;
	/** 저장_파일경로 */
	private String streFlpth;
	/** 저장_파일명 */
	private String streFilenm;
	/** 파일_확장자 */
	private String fileExtsn;
	/** 파일_사이즈 */
	private Long fileSize;
	/** 삭제할 첨부파일 일련번호 */
	private int[] atchSnArrToDelete;
	
	private String tableNm;
	
	
	public int getAtchmnflSn() {
		return atchmnflSn;
	}
	public void setAtchmnflSn(int atchmnflSn) {
		this.atchmnflSn = atchmnflSn;
	}
	public String getOrginlFilenm() {
		return orginlFilenm;
	}
	public void setOrginlFilenm(String orginlFilenm) {
		this.orginlFilenm = orginlFilenm;
	}
	public String getStreFlpth() {
		return streFlpth;
	}
	public void setStreFlpth(String streFlpth) {
		this.streFlpth = streFlpth;
	}
	public String getStreFilenm() {
		return streFilenm;
	}
	public void setStreFilenm(String streFilenm) {
		this.streFilenm = streFilenm;
	}
	public String getFileExtsn() {
		return fileExtsn;
	}
	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public int[] getAtchSnArrToDelete() {
		return atchSnArrToDelete;
	}
	public void setAtchSnArrToDelete(int[] atchSnArrToDelete) {
		this.atchSnArrToDelete = atchSnArrToDelete;
	}
	public String getTableNm() {
		return tableNm;
	}
	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
	}
	public int getAtchmnflId() {
		return atchmnflId;
	}
	public void setAtchmnflId(int atchmnflId) {
		this.atchmnflId = atchmnflId;
	}
}

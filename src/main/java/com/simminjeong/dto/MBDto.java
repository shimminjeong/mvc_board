package com.simminjeong.dto;

import java.sql.Timestamp;

public class MBDto {

	private int id;
	private String name;
	private String title;
	private String content;
	private Timestamp writedate;
	private int hit;
	private int groups;
	private int step;
	private int indent;

	public MBDto() {

	}

	public MBDto(String name, String title, String content) {
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public MBDto(int id, String name, String title, String content) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public MBDto(String name, String title, String content, int groups, int step, int indent) {
		this.name = name;
		this.title = title;
		this.content = content;
		this.groups = groups;
		this.step = step;
		this.indent = indent;
	}

	public MBDto(int id, String name, String title, String content, Timestamp writedate, int hit, int groups, int step,
			int indent) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
		this.hit = hit;
		this.groups = groups;
		this.step = step;
		this.indent = indent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getWrite_date() {
		return writedate;
	}

	public void setWrite_date(Timestamp write_date) {
		this.writedate = write_date;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getGroups() {
		return groups;
	}

	public void setGroups(int groups) {
		this.groups = groups;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

}
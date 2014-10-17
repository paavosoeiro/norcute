package br.com.tinysoft.social.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class User implements Serializable {

	@Id
	private String uid;

	private String nome;
	private String login;
	private List<UserInfo> loginInfo;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<UserInfo> getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(List<UserInfo> loginInfo) {
		this.loginInfo = loginInfo;
	}

}

package com.devscoop.resttest.client.models;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class Account {
	@JsonProperty("account_id")
	private BigDecimal accountId;
	
	@JsonProperty("authorizing_balance_reference")
	private String authorizingBalanceReference;
	
	@JsonProperty("nickname")
	private String nickname;
	
	@JsonProperty("balances")
	private ArrayList<Balance> balances;

	public BigDecimal getAccountId() {
		return accountId;
	}

	public void setAccountId(BigDecimal accountId) {
		this.accountId = accountId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public BigDecimal getAuthorizingBalance() {
		for (Balance b : balances) {
			if (b.getReference().equals(authorizingBalanceReference))
				return b.getAmount();
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Account: [accountId=" + accountId + ", nickname=" + nickname
				+ ", authorizingBalance=" + getAuthorizingBalance() + "]";
	}

	public static class Balance {
		@JsonProperty("reference")
		private String reference;

		@JsonProperty("display_name")
		private String displayName;
		
		@JsonProperty("amount")
		private BigDecimal amount;

		public String getReference() {
			return reference;
		}

		public void setReference(String reference) {
			this.reference = reference;
		}

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
	}
}

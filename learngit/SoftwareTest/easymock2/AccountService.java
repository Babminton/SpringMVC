package lab07;
public class AccountService {
	private AccountManager accountManager;

	public void setAccountManager(AccountManager manager) {
		this.accountManager = manager;
	}

	public void transfer(String senderId, String beneficiaryId, long amount) {
		Account sender = this.accountManager.findAccountForUser(senderId);
		Account beneficiary = this.accountManager
				.findAccountForUser(beneficiaryId);
		sender.debit(amount); //取款
		beneficiary.credit(amount); //存款
		this.accountManager.updateAccount(sender);
		this.accountManager.updateAccount(beneficiary);
	}
}

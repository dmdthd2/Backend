package bgp500;

public class LoginDAO {

	private final String userUD_DUMMY = "kdhong";
	private final String userPW_DUMMY = "1234";
	
	public LoginDTO loginAuth(LoginDTO loginDTO) {
		if (userUD_DUMMY.equals(loginDTO.getUserID())) {
			if (userPW_DUMMY.equals(loginDTO.getUserPW())) {
				loginDTO.setLoginState("login");
			}else {
				loginDTO.setLoginState("errorPW");
			}
		}else {
			loginDTO.setLoginState("errorID");
		}
		return loginDTO;
	}
}

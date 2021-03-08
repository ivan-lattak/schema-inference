class AuthenticationParam {
	authDatabase:String;
	userName:String;
	password:String;
	authMechanism:String;
	
	isValid = (): boolean => {
		if(this.authDatabase && this.userName && this.password && this.authMechanism)
			return true;
		return false;
	}
}
export default AuthenticationParam;

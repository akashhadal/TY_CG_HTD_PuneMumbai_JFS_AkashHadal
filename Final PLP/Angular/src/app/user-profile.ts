export class UserProfile {
    constructor(
        public userId: number,
        public userName: string,
        public emailId: string,
        public userType: string,
        public password: string,
        public address: string,
        public nationality: string,
        public phoneNumber: number
    ) { }
}

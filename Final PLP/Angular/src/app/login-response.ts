export class LoginResponse {
    constructor(
        public statusCode: number,
        public message: string,
        public description: string,
        public userDetails: any,
        public role: string
    ) { }
}

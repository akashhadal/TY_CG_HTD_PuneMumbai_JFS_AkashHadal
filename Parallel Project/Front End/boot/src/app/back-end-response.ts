export class BackEndResponse {
    constructor(
        public statusCode: number,
        public message: string,
        public description: string
    ){}
}

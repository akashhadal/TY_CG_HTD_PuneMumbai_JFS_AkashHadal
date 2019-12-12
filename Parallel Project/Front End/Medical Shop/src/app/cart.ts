export class Cart {
    constructor(
        public userId: number,
        public userName: string,
        public productId: number,
        public productName: string,
        public price: number
    ) { }
}

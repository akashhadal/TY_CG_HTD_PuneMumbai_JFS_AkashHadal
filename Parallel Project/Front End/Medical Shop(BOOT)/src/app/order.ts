export class Order {
    constructor(
        public orderId: number,
        public userId: number,
        public userName: string,
        public productId: number,
        public productName: string,
        public price: number,
        public address: string
    ) { }
}

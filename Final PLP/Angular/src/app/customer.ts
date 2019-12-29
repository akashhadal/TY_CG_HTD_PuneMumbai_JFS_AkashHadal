export class Customer {
    constructor(
        public bookingId: number,
        public hotelId: number,
        public roomId: number,
        public userId: number,
        public amount: number,
        public paymentStatus: string,
        public modeOfPayment: string,
        public checkinDate: number,
        public checkoutDate: number,
    ) { }
}

export class Hotel {
    constructor(
        public hotelId: number,
        public hotelName: string,
        public location: string,
        public availableAcRoom: number,
        public availableNonAcRoom: number
    ) { }
}

export class Room {
    constructor(
        public roomId: number,
        public roomRent: number,
        public roomType: number,
        public roomCapacity: number,
        public roomStatus: string,
        public hotelId: number,
        public roomFacility: string
    ) { }
}

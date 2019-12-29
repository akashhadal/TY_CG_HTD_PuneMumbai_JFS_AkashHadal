import { Pipe, PipeTransform } from '@angular/core';
import { Hotel } from './hotel';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(hotels: Hotel[], search: string): Hotel[] {
    if (search === undefined) {
      return hotels;
    } else {
     return hotels.filter((value, index, array) => {
       return value.location.toLowerCase().includes(search.toLowerCase());
       });
    }
   }

}

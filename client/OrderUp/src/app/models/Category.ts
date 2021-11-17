import { Product } from "./Product";

export class Category {
    constructor(
        public _id: string,
        public name: string,
        public products: Product[] 
    ){}
}
import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Global } from "./global";

@Injectable()
export class ProductService {
    public url:string;

    constructor(
        public _http: HttpClient
    ){
        this.url = Global.url;
    }

    getProducts():Observable<any> {
        return this._http.get(this.url+"/products");
    }
    getProduct(id:any):Observable<any> {
        return this._http.get(this.url+"/products/"+id)
    }
    getCategorys():Observable<any> {
        return this._http.get(this.url+"/categories");
    }
    getOrders():Observable<any> {
        return this._http.get(this.url+"/orders");
    }
    getOrder(id:any):Observable<any> {
        return this._http.get(this.url+"/orders/"+id);
    }
    PutOrder(product:any,id:any):Observable<any> {
        var params = JSON.stringify(product);
        return this._http.put(this.url+"/orders/"+id,params);
    }
}

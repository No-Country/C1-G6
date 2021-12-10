import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Global } from "./global";

@Injectable()
export class UserService {
    public url:string;

    constructor(
        public _http: HttpClient
    ){
        this.url = Global.url;
    }

    authorization(user:any):Observable<any> {
        let headers = new HttpHeaders().set('Content-Type','application/json');
        return this._http.post(this.url+"/authenticate",user, {headers:headers})
    }
   
}

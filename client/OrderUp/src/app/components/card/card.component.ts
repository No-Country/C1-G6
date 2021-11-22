import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/Category';
import { Router,ActivatedRoute,Params } from '@angular/router';
import * as $ from 'jquery';

@Component({
  selector: 'card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  public C1: Category = {
    _id: "",
    name: "Milanesas",
    products: [
      {_id:"",name:"Comida 1",price:200,stock:true},
      {_id:"",name:"Comida 1",price:2200,stock:true},
      {_id:"",name:"Comida 1",price:2,stock:true},
      {_id:"",name:"Comida 1",price:20220,stock:true}
    ]
  }
  public C2: Category = {
    _id: "",
    name: "Pastas",
    products: [
      {_id:"",name:"Comida 2",price:200,stock:true},
      {_id:"",name:"Comida 2",price:2200,stock:true},
      {_id:"",name:"Comida 2",price:2,stock:true},
      {_id:"",name:"Comida 2",price:20220,stock:true}
    ]
  }
  public C3: Category = {
    _id: "",
    name: "Bebidas",
    products: [
      {_id:"",name:"Comida 3",price:200,stock:true},
      {_id:"",name:"Comida 3",price:2200,stock:true},
      {_id:"",name:"Comida 3",price:2,stock:true},
      {_id:"",name:"Comida 3",price:20220,stock:true}
    ]
  }
  public C4: Category = {
    _id: "",
    name: "Postres",
    products: [
      {_id:"",name:"Comida 4",price:200,stock:true},
      {_id:"",name:"Comida 4",price:2200,stock:true},
      {_id:"",name:"Comida 4",price:2,stock:true},
      {_id:"",name:"Comida 4",price:20220,stock:true}
    ]
  }

  public Categorys: Category[] = [this.C1,this.C2,this.C3,this.C4]
  constructor(
    private _router: Router
  ) { }

  ngOnInit(): void {
  }

  reviewOrder(){
    this._router.navigate(['Order']);
  }
  blur(index:number){
    var clas = '.category'+index;
    var aux = $(clas);
    var class_list = aux.attr('class');

    if(class_list){
      if(class_list.split(' ').includes('blur')){
        aux.removeClass('blur');
      }else {
        aux.addClass('blur');
      }
    }
  }
}

import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute,Params } from '@angular/router';
import { ProductService } from 'src/app/services/produtc.service';
import * as $ from 'jquery';
import { Product } from 'src/app/models/Product';
import { Category } from 'src/app/models/Category';
import { Order } from 'src/app/models/Order';

@Component({
  selector: 'card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
  providers: [ProductService]
})
export class CardComponent implements OnInit {
  public order: Order = {comments:"",id:0,table:{id:0,tableNumber:-1},productlist:"",user:{id:0,name:"",surname:"",password:"",email:"",phone:0,role_id:{id:0,name:""}}}
  public Categorys: Category[] = []
  public Products: Product[] = []
  public ProductsOrder: Product[] = []
  constructor(
    private _router: Router,
    private _ProductService: ProductService,
    private _route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getProducts();
    this.getCategorys();
    this.addProdouct(2);
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

  getProducts() {
    this._ProductService.getProducts().subscribe(
      response => {
        this.Products = response;
        console.log(this.Products)
      },
      err => {
        console.log("-----------------------")
        console.log(err);
        console.log("-----------------------")
      }
    )
  }

  getCategorys() {
    this._ProductService.getCategorys().subscribe(
      response => {
        this.Categorys = response;
      },
      err => {
        console.log("-----------------------")
        console.log(err);
        console.log("-----------------------")
      }
    )
  }

  getOrder() {
    this._ProductService.getOrder(2).subscribe(
      response => {
        this.order = response;
      },
      err => {
        console.log(err);
      }
    )
  }

  addProdouct(id:any){
    this._ProductService.getOrder(2).subscribe(
      response => {
        this.order = response;
        this.order.productlist += "/"+id;
        this.updateProduct(this.order);
      },
      err => {
        console.log(err);
      }
    )
  }

  updateProduct(order: Order){
    this._ProductService.PutOrder(order,2).subscribe(
      response => {
        console.log("hola")
      },
      err => {
        console.log(err);
      }
    )
  }

  
}
